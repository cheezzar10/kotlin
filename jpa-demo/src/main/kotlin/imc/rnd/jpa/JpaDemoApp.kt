package imc.rnd.jpa

import imc.rnd.jpa.model.DelayedJob
import imc.rnd.jpa.sys.Jpa
import org.hibernate.jpa.QueryHints

fun main() {
  Jpa("jdbc:postgresql://localhost:5432/jpademo").use { jpa ->
    jpa.withJpa { em ->
      // filling delayed jobs queue
      val newDelayedJob = DelayedJob(1)
      em.persist(newDelayedJob)

      for (taskId in 2..10) {
        em.persist(DelayedJob(taskId))

        if (taskId % 100 == 0) {
          println("persisting batch")
          em.flush()
          em.clear()
        }
      }

      // reading delayed job with 1 second timeout
      val delayedJob = em.find(DelayedJob::class.java, 1, mapOf(QueryHints.SPEC_HINT_TIMEOUT to 1000))
      println(delayedJob)

      // slow query emulation, pg_sleep is called for every row
      val query = em.createQuery(
        "select dj from DelayedJob dj where function('pg_sleep', 1) is not null",
        DelayedJob::class.java)

      val delayedJobs = query
        .setHint(QueryHints.SPEC_HINT_TIMEOUT, 1000)
        .resultList

      println(delayedJobs)
    }
  }
}

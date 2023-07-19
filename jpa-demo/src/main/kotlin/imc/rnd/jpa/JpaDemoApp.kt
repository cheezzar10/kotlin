package imc.rnd.jpa

import imc.rnd.jpa.model.DelayedJob
import imc.rnd.jpa.sys.Jpa

fun main() {
  Jpa("jdbc:postgresql://localhost:5432/jpademo").use { jpa ->
    jpa.withJpa { em ->
      // filling delayed jobs queue
      val newDelayedJob = DelayedJob(1)
      em.persist(newDelayedJob)

      for (taskId in 2..10_000) {
        em.persist(DelayedJob(taskId))

        if (taskId % 100 == 0) {
          println("persisting batch")
          em.flush()
          em.clear()
        }
      }

      // reading delayed job
      val delayedJob = em.find(DelayedJob::class.java, 1)
      println(delayedJob)
    }
  }
}

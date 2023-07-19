package imc.rnd.jpa.sys

import java.io.Closeable
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

class Jpa(private val jdbcUrl: String) : Closeable {
    private val emf: EntityManagerFactory by lazy(this::createEntityManagerFactory)

    private fun createEntityManagerFactory(): EntityManagerFactory {
        println("EMF init started")

        val emf = Persistence.createEntityManagerFactory("jpademo", mapOf("javax.persistence.jdbc.url" to jdbcUrl))
        println("EMF init completed")

        return emf
    }

    fun <T> withJpa(action: (EntityManager) -> T): T {
        val em = emf.createEntityManager()
        println("entity manager reference obtained")

        val tx = em.transaction
        tx.begin()

        println("transaction started: $tx")

        try {
            val result = action(em)

            tx.commit()
            println("transaction committed")

            return result
        } catch (ex: Exception) {
            tx.rollback()
            println("transaction rolled back")

            throw ex
        } finally {
            em.close()
        }
    }

    override fun close() {
        // TODO here we need to check that emf was initialized actually
        emf.close()
        println("EMF closed")
    }
}
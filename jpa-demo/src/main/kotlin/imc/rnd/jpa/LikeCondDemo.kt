package imc.rnd.jpa

import imc.rnd.jpa.model.Resource
import imc.rnd.jpa.sys.Jpa

fun main() {
    Jpa("jdbc:postgresql://localhost:5432/jpademo").use { jpa ->
        jpa.withJpa { em ->
            for (resourcePath in listOf("x1", "x1x5", "x2", "x2x3")) {
                em.persist(Resource(resourcePath))
            }

            // create empty Any? array using arrayOf
            val emptyArray: Array<Any?> = arrayOfNulls(0)
            val query = em.createQuery(
                "select cr.id, cr.path from Resource vr, Resource cr where vr.id = 1 and cr.path like concat(vr.path, '%')",
                emptyArray.javaClass)

            for (r in query.resultList) {
                println("row: { customer resource id: ${r[0]}, customer resource path: ${r[1]} }")
            }
        }
    }
}
package imc.rnd.jpa.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "resource")
class Resource() {
    @Id
    @GeneratedValue
    @Column(name = "id")
    var id: Int? = null

    @Column(name = "path", nullable = false)
    var path: String = ""

    constructor(path: String) : this() {
        this.path = path
    }

    override fun toString(): String = "Resource: { id: $id, path: $path }"
}
package imc.rnd.jpa.model

import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class DelayedJob() {
    @Id
    @Column(name = "task_id")
    var taskId: Int? = null

    @Column(name = "start_on", nullable = false)
    var startOn: Timestamp = Timestamp(System.currentTimeMillis())

    @Column(name = "node_name", nullable = false)
    var nodeName: String = ""

    constructor(taskId: Int) : this() {
        this.taskId = taskId
    }
}
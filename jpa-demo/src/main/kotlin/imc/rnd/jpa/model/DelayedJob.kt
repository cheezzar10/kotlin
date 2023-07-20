package imc.rnd.jpa.model

import org.hibernate.annotations.Loader
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "delayed_job")
@NamedNativeQuery(
    name = "DelayedJob.byTaskId",
    query = "select task_id, start_on, node_name, pg_sleep(3) from delayed_job where task_id = ?",
    resultSetMapping = "DelayedJob.allColumns")
@SqlResultSetMapping(
    name = "DelayedJob.allColumns",
    entities = [
        EntityResult(
            entityClass = DelayedJob::class,
            fields = arrayOf(
                FieldResult(name = "taskId", column = "task_id"),
                FieldResult(name = "startOn", column = "start_on"),
                FieldResult(name = "nodeName", column = "node_name")))])
@Loader(namedQuery = "DelayedJob.byTaskId")
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
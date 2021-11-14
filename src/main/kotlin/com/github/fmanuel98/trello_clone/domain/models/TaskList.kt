package com.github.fmanuel98.trello_clone.domain.models

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import java.time.OffsetDateTime
import javax.enterprise.context.ApplicationScoped
import javax.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp

@Entity
class TaskList(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
        @Column(nullable = false) var name: String = "",
        @ManyToOne(optional = false) val project: Project? = null,
        @ManyToOne(optional = false) val user: User? = null,
        @OneToMany(mappedBy = "taskList") val cards: List<Card>? = null,
        @CreationTimestamp
        @Column(nullable = false, updatable = false)
        val createdAt: OffsetDateTime? = null,
        @Column(nullable = false) @UpdateTimestamp val updatedAt: OffsetDateTime? = null
)

@ApplicationScoped class TaskListRepository : PanacheRepository<TaskList> {}

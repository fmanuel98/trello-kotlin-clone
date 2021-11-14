package com.github.fmanuel98.trello_clone.domain.models

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import java.time.OffsetDateTime
import javax.enterprise.context.ApplicationScoped
import javax.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp

@Entity
@Table(name = "tb_user")
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    @Column(nullable = false) var name: String = "",
    @Column(nullable = false) var email: String = "",
    @Column(nullable = false) var passWord: String = "",
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    val createdAt: OffsetDateTime? = null,
    @Column(nullable = false) @UpdateTimestamp val updatedAt: OffsetDateTime? = null
)

@ApplicationScoped class UserRepository : PanacheRepository<User> {}

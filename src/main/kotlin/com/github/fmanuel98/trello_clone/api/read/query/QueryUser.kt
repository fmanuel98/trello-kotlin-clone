package com.github.fmanuel98.trello_clone.api.read.query

import com.github.fmanuel98.trello_clone.domain.models.User
import java.time.OffsetDateTime

class QueryUser(
    val id: Long?,
    val name: String?,
    val email: String?,
    val createdAt: OffsetDateTime?,
    val updatedAt: OffsetDateTime?
) {
  constructor(
      model: User?
  ) : this(model?.id, model?.name, model?.email, model?.createdAt, model?.updatedAt)
}

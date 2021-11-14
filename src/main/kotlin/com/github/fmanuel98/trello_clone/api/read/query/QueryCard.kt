package com.github.fmanuel98.trello_clone.api.read.query

import com.github.fmanuel98.trello_clone.domain.models.Card
import java.time.OffsetDateTime

class QueryCard(
    val id: Long?,
    val name: String?,
    val user: QueryUser?,
    val tasks: List<QueryTask>?,
    val createdAt: OffsetDateTime?,
    val updatedAt: OffsetDateTime?
) {
  constructor(
      model: Card?
  ) : this(
      model?.id,
      model?.name,
      QueryUser(model?.user),
      model?.tasks?.map { QueryTask(it) },
      model?.createdAt,
      model?.updatedAt
  )
}

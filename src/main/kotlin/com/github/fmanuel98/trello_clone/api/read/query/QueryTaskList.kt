package com.github.fmanuel98.trello_clone.api.read.query

import com.github.fmanuel98.trello_clone.domain.models.TaskList
import java.time.OffsetDateTime

class QueryTaskList(
          val id: Long?,
          val name: String?,
          val user: QueryUser?,
          var cards: List<QueryCard>?,
          val createdAt: OffsetDateTime?,
          val updatedAt: OffsetDateTime?
) {
     constructor(
               model: TaskList?
     ) : this(
               model?.id,
               model?.name,
               QueryUser(model?.user),
               model?.cards?.map { QueryCard(it) },
               model?.createdAt,
               model?.updatedAt
     )
}

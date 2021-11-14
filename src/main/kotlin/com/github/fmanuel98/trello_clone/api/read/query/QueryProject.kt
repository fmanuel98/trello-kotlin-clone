package com.github.fmanuel98.trello_clone.api.read.query

import com.github.fmanuel98.trello_clone.domain.models.Project
import java.time.OffsetDateTime

class QueryProject(
    val id: Long?,
    val name: String?,
    val user: QueryUser?,
    val taskList: List<QueryTaskList>?,
    val createdAt: OffsetDateTime?,
    val updatedAt: OffsetDateTime?
) {
  constructor(
      model: Project?
  ) : this(
      model?.id,
      model?.name,
      QueryUser(model?.user),
      model?.taskList?.map { QueryTaskList(it) },
      model?.createdAt,
      model?.updatedAt
  )
}

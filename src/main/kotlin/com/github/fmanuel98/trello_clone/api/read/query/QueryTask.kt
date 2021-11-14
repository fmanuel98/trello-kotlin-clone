package com.github.fmanuel98.trello_clone.api.read.query

import com.github.fmanuel98.trello_clone.domain.models.Task
import java.time.OffsetDateTime

class QueryTask(
        val id: Long?,
        val name: String?,
        val user: QueryUser?,
        val createdAt: OffsetDateTime?,
        val updatedAt: OffsetDateTime?
) {
    constructor(
            model: Task?
    ) : this(model?.id, model?.name, QueryUser(model?.user), model?.createdAt, model?.updatedAt)
}

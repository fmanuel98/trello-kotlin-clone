package com.github.fmanuel98.trello_clone.api.write.command

import com.github.fmanuel98.trello_clone.domain.models.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class CommandCreatTaskList {
  @field:NotBlank lateinit var name: String
  @field:NotNull var userId: Long = 0
  @field:NotNull var projectId: Long = 0

  fun toDomain() =
      TaskList(name = name, user = User(id = userId), project = Project(id = projectId))
}

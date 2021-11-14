package com.github.fmanuel98.trello_clone.api.write.command

import com.github.fmanuel98.trello_clone.domain.models.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class CommandCreatCard {
  @field:NotBlank lateinit var name: String
  @field:NotNull var userId: Long = 0
  @field:NotNull var taskListId: Long = 0

  fun toDomain() = Card(name = name, user = User(id = userId), taskList = TaskList(id = taskListId))
}

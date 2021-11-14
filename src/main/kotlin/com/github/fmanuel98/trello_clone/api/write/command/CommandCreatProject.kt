package com.github.fmanuel98.trello_clone.api.write.command

import com.github.fmanuel98.trello_clone.domain.models.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class CommandCreatProject {
  @field:NotBlank lateinit var name: String
  @field:NotNull var userId: Long = 0

  fun toDomain() = Project(name = name, user = User(id = userId))
}

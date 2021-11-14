package com.github.fmanuel98.trello_clone.api.write.command

import com.github.fmanuel98.trello_clone.domain.models.User
import javax.validation.constraints.Email
import javax.validation.constraints.Size

class CommandCreatUser {
  @field:Size(max = 50) lateinit var name: String
  @field:Size(max = 50) lateinit var passWord: String
  @field:Email lateinit var email: String

  fun toDomain() = User(name = name, passWord = passWord, email = email)
}

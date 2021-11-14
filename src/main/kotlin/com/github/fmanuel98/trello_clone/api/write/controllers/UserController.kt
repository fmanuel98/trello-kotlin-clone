package com.github.fmanuel98.trello_clone.api.write.command

import com.github.fmanuel98.trello_clone.domain.models.UserRepository
import javax.transaction.Transactional
import javax.validation.Valid
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Mutation

@GraphQLApi
class UserController(val repository: UserRepository) {

  @Mutation
  @Transactional
  fun saveUser(@Valid command: CommandCreatUser) =
      repository
          .run {
            this.persist(command.toDomain())
            command
          }
          .let { it }
}

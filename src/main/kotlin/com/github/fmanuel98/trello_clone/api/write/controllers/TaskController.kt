package com.github.fmanuel98.trello_clone.api.write.controllers

import com.github.fmanuel98.trello_clone.api.write.command.CommandCreatTask
import com.github.fmanuel98.trello_clone.domain.models.*
import javax.transaction.Transactional
import javax.validation.Valid
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Mutation

@GraphQLApi
class TaskController(val repository: TaskRepository) {
  @Mutation
  @Transactional
  fun saveTask(@Valid command: CommandCreatTask) =
      repository
          .run {
            this.persist(command.toDomain())
            command
          }
          .let { it }
}

package com.github.fmanuel98.trello_clone.api.write.controllers

import com.github.fmanuel98.trello_clone.api.write.command.CommandCreatTaskList
import com.github.fmanuel98.trello_clone.domain.models.TaskListRepository
import javax.transaction.Transactional
import javax.validation.Valid
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Mutation

@GraphQLApi
class TaskListController(val repository: TaskListRepository) {
  @Mutation
  @Transactional
  fun saveTaskList(@Valid command: CommandCreatTaskList) =
      repository
          .run {
            this.persist(command.toDomain())
            command
          }
          .let { it }
}

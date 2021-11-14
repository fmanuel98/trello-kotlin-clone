package com.github.fmanuel98.trello_clone.api.read.controllers

import com.github.fmanuel98.trello_clone.api.read.query.QueryTask
import com.github.fmanuel98.trello_clone.domain.models.TaskRepository
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query

@GraphQLApi
class TaskLController(val repository: TaskRepository) {
  @Query fun listTasks() = repository.listAll().map { QueryTask(it) }
}

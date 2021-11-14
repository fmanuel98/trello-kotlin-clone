package com.github.fmanuel98.trello_clone.api.read.controllers

import com.github.fmanuel98.trello_clone.api.read.query.QueryTaskList
import com.github.fmanuel98.trello_clone.domain.models.TaskListRepository
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query

@GraphQLApi
class TaskListController(val repository: TaskListRepository) {
  @Query fun listTaskList() = repository.listAll().map { QueryTaskList(it) }
}

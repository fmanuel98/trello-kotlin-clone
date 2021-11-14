package com.github.fmanuel98.trello_clone.api.read.controllers

import com.github.fmanuel98.trello_clone.api.read.query.QueryProject
import com.github.fmanuel98.trello_clone.domain.models.ProjectRepository
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query

@GraphQLApi
class ProjectController(val repository: ProjectRepository) {
  @Query fun listProjects() = repository.listAll().map { QueryProject(it) }
}

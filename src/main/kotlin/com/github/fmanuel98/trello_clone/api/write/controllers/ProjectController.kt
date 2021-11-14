package com.github.fmanuel98.trello_clone.api.write.controllers

import com.github.fmanuel98.trello_clone.api.write.command.CommandCreatProject
import com.github.fmanuel98.trello_clone.domain.models.ProjectRepository
import javax.transaction.Transactional
import javax.validation.Valid
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Mutation

@GraphQLApi
class ProjectController(val repository: ProjectRepository) {
  @Mutation
  @Transactional
  fun saveProject(@Valid command: CommandCreatProject) =
      repository
          .run {
            this.persist(command.toDomain())
            command
          }
          .let { it }
}

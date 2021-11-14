package com.github.fmanuel98.trello_clone.api.read.controllers

import com.github.fmanuel98.trello_clone.api.read.query.QueryUser
import com.github.fmanuel98.trello_clone.domain.models.UserRepository
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query

@GraphQLApi
class UserController(val repository: UserRepository) {
  @Query fun listUsers() = repository.listAll().map { QueryUser(it) }
}

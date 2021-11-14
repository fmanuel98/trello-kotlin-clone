package com.github.fmanuel98.trello_clone.api.write.controllers

import com.github.fmanuel98.trello_clone.api.read.query.QueryCard
import com.github.fmanuel98.trello_clone.domain.models.CardRepository
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Query

@GraphQLApi
class CardController(val repository: CardRepository) {
  @Query fun listCards() = repository.listAll().map { QueryCard(it) }
}

package com.github.fmanuel98.trello_clone.api.read.controllers

import com.github.fmanuel98.trello_clone.api.read.query.QueryCard
import com.github.fmanuel98.trello_clone.api.write.command.CommandCreatCard
import com.github.fmanuel98.trello_clone.domain.models.CardRepository
import com.github.fmanuel98.trello_clone.domain.models.TaskList
import javax.transaction.Transactional
import javax.validation.Valid
import org.eclipse.microprofile.graphql.GraphQLApi
import org.eclipse.microprofile.graphql.Mutation

@GraphQLApi
class CardController(val repository: CardRepository) {
  @Mutation
  @Transactional
  fun saveCard(@Valid command: CommandCreatCard) =
      repository
          .run {
            this.persist(command.toDomain())
            command
          }
          .let { it }
  @Mutation
  @Transactional
  fun moveCard(cardId: Long, taskListId: Long) =
      repository
          .run {
            val card = this.findById(cardId)
            card?.taskList = TaskList(id = taskListId)
            card
          }
          .let { QueryCard(it) }
}

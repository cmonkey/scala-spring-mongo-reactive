package org.github.cmonkey.reactive.repository

import org.github.cmonkey.reactive.entity.Tweet
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

trait TweetRepository extends ReactiveMongoRepository[Tweet, String]

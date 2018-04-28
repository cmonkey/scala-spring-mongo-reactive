package org.github.cmonkey.reactive.service

import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Sink, Source}
import org.github.cmonkey.reactive.entity.{HashTag, Tweet}
import org.github.cmonkey.reactive.repository.TweetRepository
import org.reactivestreams.Publisher
import org.springframework.stereotype.Service

import scala.collection.JavaConverters

@Service
class TweetService(tr: TweetRepository, am:ActorMaterializer) {
  def hashtags(): Publisher[HashTag] = {
    Source.fromPublisher(tweets())
      .map(t => JavaConverters.asScalaSet(t.hashTags).toSet)
      .reduce((x, y) => x ++ y)
      .mapConcat(identity)
      .runWith(Sink.asPublisher(true)){
        am
      }
  }

  def tweets(): Publisher[Tweet] = tr.findAll()
}

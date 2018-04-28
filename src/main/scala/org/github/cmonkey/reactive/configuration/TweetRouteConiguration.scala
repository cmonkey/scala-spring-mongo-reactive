package org.github.cmonkey.reactive.configuration

import org.github.cmonkey.reactive.entity.{HashTag, Tweet}
import org.github.cmonkey.reactive.service.TweetService
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.web.reactive.function.server.RequestPredicates._
import org.springframework.web.reactive.function.server.RouterFunctions.{route, _}
import org.springframework.web.reactive.function.server.ServerResponse._

@Configuration
class TweetRouteConiguration(ts: TweetService) {

  @Bean
  def routes() = {
    route(GET("/tweets"), _ => ok().body(ts.tweets(), classOf[Tweet]))
       .andRoute(GET("/hashtags/unique"), _ => ok().body(ts.hashtags(), classOf[HashTag]))
  }
}

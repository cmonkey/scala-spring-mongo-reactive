package org.github.cmonkey.reactive.configuration

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class AkkaConfiguration {

  @Bean
  def actorSystem() = ActorSystem.create("reactive")

  @Bean
  def actorMaterializer() = ActorMaterializer.create(actorSystem())

}

package org.github.cmonkey.reactive.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import scala.beans.BeanProperty

@Document
case class HashTag (@BeanProperty @Id tag: String)

package org.github.cmonkey.reactive.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

import scala.beans.BeanProperty
import scala.collection.JavaConverters

@Document
case class Tweet(@BeanProperty @Id content: String, @BeanProperty author : Author) {

  @BeanProperty
  val hashTags: java.util.Set[HashTag] =
    JavaConverters.setAsJavaSet(
      content.split(" ")
      .collect{
        case t if t.startsWith("#") => HashTag(t.replaceAll("[^#\\w]", "").toLowerCase())
      }
      .toSet
    )
}

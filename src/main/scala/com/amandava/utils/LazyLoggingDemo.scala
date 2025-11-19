package com.amandava.utils

import com.typesafe.scalalogging.LazyLogging


object LazyLoggingDemo extends App with LazyLogging {
  logger.info("Lazy log")
}

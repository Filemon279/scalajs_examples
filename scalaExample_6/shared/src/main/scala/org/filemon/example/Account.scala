package org.filemon.example

import io.circe.generic.JsonCodec

@JsonCodec case class Account(owner: String, ammount: BigDecimal)




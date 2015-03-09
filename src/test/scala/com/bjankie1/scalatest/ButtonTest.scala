package com.bjankie1.scalatest

import org.scalacheck.Gen
import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}


class ButtonTest extends FlatSpec with Matchers with PropertyChecks {

  val smallInteger = Gen.choose(0,100)

  "The button" should "be ON after pressing it" in {
    val button = new Button
    button.press()
    button.isOn shouldBe true
  }


  "The audit log" should "contain set of states" in {
    val button = new Button
    button.press()
    button.getAudit should contain only (true)
  }


  "The audit log" should "record all changes" in {
    forAll(smallInteger) { times =>
      val button = new Button
      for(_ <- 1 to times) button.press()
      button.getAudit should have size times
    }
  }

}

package com.bjankie1.scalatest

import org.scalatest.{Matchers, FlatSpec}


class ButtonTest extends FlatSpec with Matchers {


  "The button" should "be ON after pressing it" in {
    val button = new Button
    button.press()
    button.isOn shouldBe true
  }


  "The audit log" should "contain set of states" in {
    val button = new Button
    button.press()
    button.getAudit should contain only(true)
  }


}

/*
 * Copyright 2001-2013 Artima, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.scalatest

import scala.collection.mutable.WrappedArray
import org.scalactic.PrettyMethods
import org.scalactic.Prettifier
import org.scalactic.Pretty

class AssertionsWithPrettyMethodsOverriddenSpec extends FunSpec with Matchers with PrettyMethods {

  override def prettifier =
    Prettifier {
      case s: String => "!!! " + s + " !!!"
      case other => super.prettifier(other)
    }

  describe("Trait Assertions when PrettyMethods is mixed in") {
    it("should allow .pretty output to be customized by overriding prettifier") {
      'c'.pretty shouldBe "'c'"
      "hello".pretty shouldBe "!!! hello !!!"
    }
  }
}


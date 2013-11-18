package views.html.helper

/**
 * Contains template helpers, for example for generating HTML forms.
 */
package object bootstrap {

  implicit val bootstrapField = new FieldConstructor {
    def apply(elts: FieldElements) = bootstrapFieldConstructor(elts)
  }

}
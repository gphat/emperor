package emp

import java.text.NumberFormat

/**
 * Utilities for formatting currency.
 */
object CurrencyFormatter {

  def formatCurrency(amount: Int, currency: String): String = {
    val fmt = NumberFormat.getCurrencyInstance()
    fmt.format(amount / 100)
  }
}
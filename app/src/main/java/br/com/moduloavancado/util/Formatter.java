package br.com.moduloavancado.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Locale;

import static br.com.moduloavancado.util.DefaultConstants.CURRENCY_CUSTOM_TAG;
import static br.com.moduloavancado.util.DefaultConstants.CURRENCY_DEFAULT_TAG;

public class Formatter {

    public static final String DAY = " dia";
    public static final String DAYS = " dias";

    public static String formatValue(BigDecimal value) {
        return DecimalFormat.getCurrencyInstance(
                new Locale("pt", "br")).format(
                        value.setScale(2, BigDecimal.ROUND_HALF_UP)).replace(
                CURRENCY_DEFAULT_TAG, CURRENCY_CUSTOM_TAG);
    }

    public static String formatDay(BigInteger days) {
        if (days == null) {
            return "";
        }
        if (days.compareTo(BigInteger.ONE) == 0) {
            return days.toString() + DAY;
        }
        return days.toString() + DAYS;
    }
}

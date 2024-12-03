package org.apache.commons.validator.routines;

import java.text.DecimalFormat;
import java.text.Format;
import net.bytebuddy.jar.asm.Opcodes;

public class CurrencyValidator extends BigDecimalValidator {
    private static final char CURRENCY_SYMBOL = '¤';
    private static final CurrencyValidator VALIDATOR = new CurrencyValidator();
    private static final long serialVersionUID = -4201640771171486514L;

    public CurrencyValidator() {
        this(true, true);
    }

    public static BigDecimalValidator getInstance() {
        return VALIDATOR;
    }

    /* access modifiers changed from: protected */
    public Object parse(String str, Format format2) {
        Object parse = super.parse(str, format2);
        if (parse != null || !(format2 instanceof DecimalFormat)) {
            return parse;
        }
        DecimalFormat decimalFormat = (DecimalFormat) format2;
        String pattern = decimalFormat.toPattern();
        if (pattern.indexOf(Opcodes.IF_ICMPLE) < 0) {
            return parse;
        }
        StringBuilder sb2 = new StringBuilder(pattern.length());
        for (int i10 = 0; i10 < pattern.length(); i10++) {
            if (pattern.charAt(i10) != 164) {
                sb2.append(pattern.charAt(i10));
            }
        }
        decimalFormat.applyPattern(sb2.toString());
        return super.parse(str, decimalFormat);
    }

    public CurrencyValidator(boolean z10, boolean z11) {
        super(z10, 1, z11);
    }
}

package org.apache.commons.validator;

import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.validator.util.Flags;

public class CreditCardValidator {
    public static final int AMEX = 1;
    public static final int DISCOVER = 8;
    public static final int MASTERCARD = 4;
    public static final int NONE = 0;
    public static final int VISA = 2;
    private final Collection<CreditCardType> cardTypes;

    private static class Amex implements CreditCardType {
        private static final String PREFIX = "34,37,";

        private Amex() {
        }

        public boolean matches(String str) {
            if (!PREFIX.contains(str.substring(0, 2) + AppsFlyerKit.COMMA) || str.length() != 15) {
                return false;
            }
            return true;
        }
    }

    public interface CreditCardType {
        boolean matches(String str);
    }

    private static class Discover implements CreditCardType {
        private static final String PREFIX = "6011";

        private Discover() {
        }

        public boolean matches(String str) {
            return str.substring(0, 4).equals(PREFIX) && str.length() == 16;
        }
    }

    private static class Mastercard implements CreditCardType {
        private static final String PREFIX = "51,52,53,54,55,";

        private Mastercard() {
        }

        public boolean matches(String str) {
            if (!PREFIX.contains(str.substring(0, 2) + AppsFlyerKit.COMMA) || str.length() != 16) {
                return false;
            }
            return true;
        }
    }

    private static class Visa implements CreditCardType {
        private static final String PREFIX = "4";

        private Visa() {
        }

        public boolean matches(String str) {
            if (str.substring(0, 1).equals("4")) {
                return str.length() == 13 || str.length() == 16;
            }
            return false;
        }
    }

    public CreditCardValidator() {
        this(15);
    }

    public void addAllowedCardType(CreditCardType creditCardType) {
        this.cardTypes.add(creditCardType);
    }

    public boolean isValid(String str) {
        if (str == null || str.length() < 13 || str.length() > 19 || !luhnCheck(str)) {
            return false;
        }
        for (CreditCardType matches : this.cardTypes) {
            if (matches.matches(str)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean luhnCheck(String str) {
        int length = str.length();
        int i10 = length & 1;
        long j10 = 0;
        int i11 = 0;
        while (i11 < length) {
            try {
                int parseInt = Integer.parseInt(str.charAt(i11) + "");
                if (((i11 & 1) ^ i10) == 0 && (parseInt = parseInt * 2) > 9) {
                    parseInt -= 9;
                }
                j10 += (long) parseInt;
                i11++;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        if (j10 != 0 && j10 % 10 == 0) {
            return true;
        }
        return false;
    }

    public CreditCardValidator(int i10) {
        ArrayList arrayList = new ArrayList();
        this.cardTypes = arrayList;
        Flags flags = new Flags((long) i10);
        if (flags.isOn(2)) {
            arrayList.add(new Visa());
        }
        if (flags.isOn(1)) {
            arrayList.add(new Amex());
        }
        if (flags.isOn(4)) {
            arrayList.add(new Mastercard());
        }
        if (flags.isOn(8)) {
            arrayList.add(new Discover());
        }
    }
}

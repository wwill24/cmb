package kotlin.text;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.j;

class t extends s {
    public static boolean a1(CharSequence charSequence) {
        j.g(charSequence, "<this>");
        return !(charSequence.length() == 0);
    }

    public static String b1(String str, int i10) {
        boolean z10;
        j.g(str, "<this>");
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            String substring = str.substring(j.g(i10, str.length()));
            j.f(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static String c1(String str, int i10) {
        boolean z10;
        j.g(str, "<this>");
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return h1(str, j.c(str.length() - i10, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static char d1(CharSequence charSequence) {
        boolean z10;
        j.g(charSequence, "<this>");
        if (charSequence.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char e1(CharSequence charSequence) {
        boolean z10;
        j.g(charSequence, "<this>");
        if (charSequence.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return charSequence.charAt(StringsKt__StringsKt.V(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static CharSequence f1(CharSequence charSequence) {
        j.g(charSequence, "<this>");
        StringBuilder reverse = new StringBuilder(charSequence).reverse();
        j.f(reverse, "StringBuilder(this).reverse()");
        return reverse;
    }

    public static char g1(CharSequence charSequence) {
        j.g(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        } else if (length == 1) {
            return charSequence.charAt(0);
        } else {
            throw new IllegalArgumentException("Char sequence has more than one element.");
        }
    }

    public static String h1(String str, int i10) {
        boolean z10;
        j.g(str, "<this>");
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            String substring = str.substring(0, j.g(i10, str.length()));
            j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }
}

package kotlin.text;

import kotlin.jvm.internal.j;

class p extends o {
    public static Double i(String str) {
        j.g(str, "<this>");
        try {
            if (i.f32235b.e(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}

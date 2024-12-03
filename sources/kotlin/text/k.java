package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.j;

class k {
    public static <T> void a(Appendable appendable, T t10, Function1<? super T, ? extends CharSequence> function1) {
        boolean z10;
        j.g(appendable, "<this>");
        if (function1 != null) {
            appendable.append((CharSequence) function1.invoke(t10));
            return;
        }
        if (t10 == null) {
            z10 = true;
        } else {
            z10 = t10 instanceof CharSequence;
        }
        if (z10) {
            appendable.append((CharSequence) t10);
        } else if (t10 instanceof Character) {
            appendable.append(((Character) t10).charValue());
        } else {
            appendable.append(String.valueOf(t10));
        }
    }
}

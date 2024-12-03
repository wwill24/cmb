package kotlin.text;

import gk.h;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class StringsKt__StringsKt$rangesDelimitedBy$1 extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ char[] $delimiters;
    final /* synthetic */ boolean $ignoreCase;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$rangesDelimitedBy$1(char[] cArr, boolean z10) {
        super(2);
        this.$delimiters = cArr;
        this.$ignoreCase = z10;
    }

    public final Pair<Integer, Integer> a(CharSequence charSequence, int i10) {
        j.g(charSequence, "$this$$receiver");
        int c02 = StringsKt__StringsKt.c0(charSequence, this.$delimiters, i10, this.$ignoreCase);
        if (c02 < 0) {
            return null;
        }
        return h.a(Integer.valueOf(c02), 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a((CharSequence) obj, ((Number) obj2).intValue());
    }
}

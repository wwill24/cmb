package kotlin.text;

import gk.h;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class StringsKt__StringsKt$rangesDelimitedBy$2 extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ List<String> $delimitersList;
    final /* synthetic */ boolean $ignoreCase;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$rangesDelimitedBy$2(List<String> list, boolean z10) {
        super(2);
        this.$delimitersList = list;
        this.$ignoreCase = z10;
    }

    public final Pair<Integer, Integer> a(CharSequence charSequence, int i10) {
        j.g(charSequence, "$this$$receiver");
        Pair K = StringsKt__StringsKt.T(charSequence, this.$delimitersList, i10, this.$ignoreCase, false);
        if (K != null) {
            return h.a(K.c(), Integer.valueOf(((String) K.d()).length()));
        }
        return null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a((CharSequence) obj, ((Number) obj2).intValue());
    }
}

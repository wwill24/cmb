package kotlin.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class StringsKt__IndentKt$getIndentFunction$1 extends Lambda implements Function1<String, String> {

    /* renamed from: a  reason: collision with root package name */
    public static final StringsKt__IndentKt$getIndentFunction$1 f32214a = new StringsKt__IndentKt$getIndentFunction$1();

    StringsKt__IndentKt$getIndentFunction$1() {
        super(1);
    }

    /* renamed from: a */
    public final String invoke(String str) {
        j.g(str, "line");
        return str;
    }
}

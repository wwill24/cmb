package kotlin.io;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class TextStreamsKt$readLines$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ ArrayList<String> $result;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextStreamsKt$readLines$1(ArrayList<String> arrayList) {
        super(1);
        this.$result = arrayList;
    }

    public final void a(String str) {
        j.g(str, "it");
        this.$result.add(str);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}

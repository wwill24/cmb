package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "result", "Lkotlin/coroutines/CoroutineContext$Element;", "it", "a", "(ZLkotlin/coroutines/CoroutineContext$Element;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0})
final class CoroutineContextKt$hasCopyableElements$1 extends Lambda implements Function2<Boolean, CoroutineContext.Element, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final CoroutineContextKt$hasCopyableElements$1 f32245a = new CoroutineContextKt$hasCopyableElements$1();

    CoroutineContextKt$hasCopyableElements$1() {
        super(2);
    }

    public final Boolean a(boolean z10, CoroutineContext.Element element) {
        return Boolean.valueOf(z10 || (element instanceof f0));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a(((Boolean) obj).booleanValue(), (CoroutineContext.Element) obj2);
    }
}

package kotlin.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class CombinedContext$toString$1 extends Lambda implements Function2<String, CoroutineContext.Element, String> {

    /* renamed from: a  reason: collision with root package name */
    public static final CombinedContext$toString$1 f32068a = new CombinedContext$toString$1();

    CombinedContext$toString$1() {
        super(2);
    }

    /* renamed from: a */
    public final String invoke(String str, CoroutineContext.Element element) {
        j.g(str, "acc");
        j.g(element, "element");
        if (str.length() == 0) {
            return element.toString();
        }
        return str + ", " + element;
    }
}

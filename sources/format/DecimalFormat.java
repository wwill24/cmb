package format;

import format.a;
import kotlin.jvm.functions.Function2;
import ml.b;

public final class DecimalFormat implements b, a {

    /* renamed from: a  reason: collision with root package name */
    public static final DecimalFormat f29681a = new DecimalFormat();

    private DecimalFormat() {
    }

    public String a(Object obj, Object obj2, Function2<? super String, ? super Double, String> function2) {
        return a.C0342a.b(this, obj, obj2, function2);
    }

    public Object f(Object obj, Object obj2) {
        return a(obj, obj2, DecimalFormat$evaluateLogic$1.f29682a);
    }
}

package format;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class DecimalFormat$evaluateLogic$1 extends Lambda implements Function2<String, Double, String> {

    /* renamed from: a  reason: collision with root package name */
    public static final DecimalFormat$evaluateLogic$1 f29682a = new DecimalFormat$evaluateLogic$1();

    DecimalFormat$evaluateLogic$1() {
        super(2);
    }

    public final String a(String str, double d10) {
        j.g(str, "formatSequence");
        String format2 = String.format(str, new Object[]{Double.valueOf(d10)});
        j.f(format2, "format(formatSequence, arg)");
        return format2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return a((String) obj, ((Number) obj2).doubleValue());
    }
}

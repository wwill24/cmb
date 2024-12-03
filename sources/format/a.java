package format;

import gk.g;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlin.text.Regex;
import p004do.c;

public interface a {

    /* renamed from: format.a$a  reason: collision with other inner class name */
    public static final class C0342a {
        private static String a(a aVar, String str, String str2, Function2<? super String, ? super Double, String> function2) {
            Double i10;
            if (!new Regex("%[\\d|.]*[f]").e(str) || (i10 = p.i(str2)) == null) {
                return null;
            }
            return function2.invoke(str, Double.valueOf(i10.doubleValue()));
        }

        public static String b(a aVar, Object obj, Object obj2, Function2<? super String, ? super Double, String> function2) {
            Object obj3;
            j.g(function2, "formatFloatingPoint");
            List<Object> c10 = p004do.a.c(obj);
            String valueOf = String.valueOf(CollectionsKt___CollectionsKt.P(c10));
            String valueOf2 = String.valueOf(c.b(c10));
            try {
                Result.a aVar2 = Result.f32010a;
                obj3 = Result.b(a(aVar, valueOf, valueOf2, function2));
            } catch (Throwable th2) {
                Result.a aVar3 = Result.f32010a;
                obj3 = Result.b(g.a(th2));
            }
            if (Result.e(obj3) == null) {
                return (String) obj3;
            }
            return null;
        }
    }
}

package kotlinx.coroutines;

import gk.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlinx.coroutines.internal.i;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u0010\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0018\u0010\b\u001a\u00020\u0001*\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\t"}, d2 = {"Lkotlin/coroutines/c;", "", "c", "", "b", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "a", "classSimpleName", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class m0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(c<?> cVar) {
        Object obj;
        if (cVar instanceof i) {
            return cVar.toString();
        }
        try {
            Result.a aVar = Result.f32010a;
            obj = Result.b(cVar + '@' + b(cVar));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f32010a;
            obj = Result.b(g.a(th2));
        }
        Throwable e10 = Result.e(obj);
        String str = obj;
        if (e10 != null) {
            str = cVar.getClass().getName() + '@' + b(cVar);
        }
        return (String) str;
    }
}

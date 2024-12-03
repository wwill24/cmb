package kotlinx.coroutines.internal;

import gk.g;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u001c\u0010\b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007\"\u001c\u0010\n\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0007*\f\b\u0000\u0010\f\"\u00020\u000b2\u00020\u000b*\f\b\u0000\u0010\u000e\"\u00020\r2\u00020\r¨\u0006\u000f"}, d2 = {"", "E", "exception", "a", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "baseContinuationImplClassName", "b", "stackTraceRecoveryClassName", "Lkotlin/coroutines/jvm/internal/c;", "CoroutineStackFrame", "Ljava/lang/StackTraceElement;", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f32526a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f32527b;

    static {
        Object obj;
        Object obj2;
        try {
            Result.a aVar = Result.f32010a;
            obj = Result.b(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f32010a;
            obj = Result.b(g.a(th2));
        }
        if (Result.e(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f32526a = (String) obj;
        try {
            obj2 = Result.b(e0.class.getCanonicalName());
        } catch (Throwable th3) {
            Result.a aVar3 = Result.f32010a;
            obj2 = Result.b(g.a(th3));
        }
        if (Result.e(obj2) != null) {
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f32527b = (String) obj2;
    }

    public static final <E extends Throwable> E a(E e10) {
        return e10;
    }
}

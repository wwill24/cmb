package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.scheduling.a;
import kotlinx.coroutines.scheduling.b;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\bR \u0010\t\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R \u0010\r\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u0012\u0004\b\f\u0010\b\u001a\u0004\b\u000b\u0010\u0006R \u0010\u0010\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u0003\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00118FX\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\n\u0010\u0012¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/x0;", "", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault$annotations", "()V", "Default", "c", "getUnconfined", "getUnconfined$annotations", "Unconfined", "d", "getIO$annotations", "IO", "Lkotlinx/coroutines/c2;", "()Lkotlinx/coroutines/c2;", "getMain$annotations", "Main", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class x0 {

    /* renamed from: a  reason: collision with root package name */
    public static final x0 f32733a = new x0();

    /* renamed from: b  reason: collision with root package name */
    private static final CoroutineDispatcher f32734b = b.f32649j;

    /* renamed from: c  reason: collision with root package name */
    private static final CoroutineDispatcher f32735c = w2.f32732c;

    /* renamed from: d  reason: collision with root package name */
    private static final CoroutineDispatcher f32736d = a.f32647d;

    private x0() {
    }

    public static final CoroutineDispatcher a() {
        return f32734b;
    }

    public static final CoroutineDispatcher b() {
        return f32736d;
    }

    public static final c2 c() {
        return v.f32568c;
    }
}

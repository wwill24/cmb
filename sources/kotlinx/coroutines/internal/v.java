package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlinx.coroutines.c2;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/internal/v;", "", "Lkotlinx/coroutines/c2;", "a", "", "b", "Z", "FAST_SERVICE_LOADER_ENABLED", "c", "Lkotlinx/coroutines/c2;", "dispatcher", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static final v f32566a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f32567b = g0.e("kotlinx.coroutines.fast.service.loader", true);

    /* renamed from: c  reason: collision with root package name */
    public static final c2 f32568c;

    static {
        v vVar = new v();
        f32566a = vVar;
        f32568c = vVar.a();
    }

    private v() {
    }

    private final c2 a() {
        List<u> list;
        T t10;
        c2 e10;
        Class<u> cls = u.class;
        try {
            if (f32567b) {
                list = k.f32542a.c();
            } else {
                list = SequencesKt___SequencesKt.t(SequencesKt__SequencesKt.c(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
            }
            Iterator<T> it = list.iterator();
            if (!it.hasNext()) {
                t10 = null;
            } else {
                t10 = it.next();
                if (it.hasNext()) {
                    int c10 = ((u) t10).c();
                    do {
                        T next = it.next();
                        int c11 = ((u) next).c();
                        if (c10 < c11) {
                            t10 = next;
                            c10 = c11;
                        }
                    } while (it.hasNext());
                }
            }
            u uVar = (u) t10;
            if (uVar == null || (e10 = w.e(uVar, list)) == null) {
                return w.b((Throwable) null, (String) null, 3, (Object) null);
            }
            return e10;
        } catch (Throwable th2) {
            return w.b(th2, (String) null, 2, (Object) null);
        }
    }
}

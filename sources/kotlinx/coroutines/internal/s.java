package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/internal/s;", "", "E", "", "b", "()V", "element", "", "a", "(Ljava/lang/Object;)Z", "d", "()Ljava/lang/Object;", "", "c", "()I", "size", "singleConsumer", "<init>", "(Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class s<E> {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f32556a = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public s(boolean z10) {
        this._cur = new t(8, z10);
    }

    public final boolean a(E e10) {
        while (true) {
            t tVar = (t) this._cur;
            int a10 = tVar.a(e10);
            if (a10 == 0) {
                return true;
            }
            if (a10 == 1) {
                a.a(f32556a, this, tVar, tVar.i());
            } else if (a10 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            t tVar = (t) this._cur;
            if (!tVar.d()) {
                a.a(f32556a, this, tVar, tVar.i());
            } else {
                return;
            }
        }
    }

    public final int c() {
        return ((t) this._cur).f();
    }

    public final E d() {
        while (true) {
            t tVar = (t) this._cur;
            E j10 = tVar.j();
            if (j10 != t.f32560h) {
                return j10;
            }
            a.a(f32556a, this, tVar, tVar.i());
        }
    }
}

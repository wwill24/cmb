package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class a<T> implements Iterator<T>, qk.a {

    /* renamed from: a  reason: collision with root package name */
    private State f32026a = State.NotReady;

    /* renamed from: b  reason: collision with root package name */
    private T f32027b;

    /* renamed from: kotlin.collections.a$a  reason: collision with other inner class name */
    public /* synthetic */ class C0367a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32028a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                kotlin.collections.State[] r0 = kotlin.collections.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.collections.State r1 = kotlin.collections.State.Done     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.collections.State r1 = kotlin.collections.State.Ready     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f32028a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.a.C0367a.<clinit>():void");
        }
    }

    private final boolean e() {
        this.f32026a = State.Failed;
        a();
        if (this.f32026a == State.Ready) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: protected */
    public final void c() {
        this.f32026a = State.Done;
    }

    /* access modifiers changed from: protected */
    public final void d(T t10) {
        this.f32027b = t10;
        this.f32026a = State.Ready;
    }

    public boolean hasNext() {
        boolean z10;
        State state = this.f32026a;
        if (state != State.Failed) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int i10 = C0367a.f32028a[state.ordinal()];
            if (i10 == 1) {
                return false;
            }
            if (i10 != 2) {
                return e();
            }
            return true;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public T next() {
        if (hasNext()) {
            this.f32026a = State.NotReady;
            return this.f32027b;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

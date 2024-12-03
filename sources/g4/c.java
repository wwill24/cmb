package g4;

import androidx.annotation.NonNull;

public abstract class c {

    private static class b extends c {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f15188a;

        b() {
            super();
        }

        public void b(boolean z10) {
            this.f15188a = z10;
        }

        public void c() {
            if (this.f15188a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    private c() {
    }

    @NonNull
    public static c a() {
        return new b();
    }

    /* access modifiers changed from: package-private */
    public abstract void b(boolean z10);

    public abstract void c();
}

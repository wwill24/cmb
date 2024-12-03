package b0;

import android.location.Location;
import androidx.annotation.NonNull;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private final b f7683a;

    static abstract class a<T extends e, B> {

        /* renamed from: a  reason: collision with root package name */
        final b.a<?> f7684a;

        a(@NonNull b.a<?> aVar) {
            this.f7684a = aVar;
            aVar.a(0);
        }
    }

    static abstract class b {

        static abstract class a<B> {
            a() {
            }

            /* access modifiers changed from: package-private */
            @NonNull
            public abstract B a(long j10);
        }

        b() {
        }

        /* access modifiers changed from: package-private */
        public abstract long a();

        /* access modifiers changed from: package-private */
        public abstract Location b();
    }

    e(@NonNull b bVar) {
        this.f7683a = bVar;
    }

    public long a() {
        return this.f7683a.a();
    }

    public Location b() {
        return this.f7683a.b();
    }
}

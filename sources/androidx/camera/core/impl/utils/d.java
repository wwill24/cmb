package androidx.camera.core.impl.utils;

import android.os.Build;
import android.util.CloseGuard;
import androidx.annotation.NonNull;
import androidx.core.util.h;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final b f2619a;

    static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private final CloseGuard f2620a = new CloseGuard();

        a() {
        }

        public void a(@NonNull String str) {
            this.f2620a.open(str);
        }

        public void b() {
            this.f2620a.warnIfOpen();
        }

        public void close() {
            this.f2620a.close();
        }
    }

    private interface b {
        void a(@NonNull String str);

        void b();

        void close();
    }

    static final class c implements b {
        c() {
        }

        public void a(@NonNull String str) {
            h.h(str, "CloseMethodName must not be null.");
        }

        public void b() {
        }

        public void close() {
        }
    }

    private d(b bVar) {
        this.f2619a = bVar;
    }

    @NonNull
    public static d b() {
        if (Build.VERSION.SDK_INT >= 30) {
            return new d(new a());
        }
        return new d(new c());
    }

    public void a() {
        this.f2619a.close();
    }

    public void c(@NonNull String str) {
        this.f2619a.a(str);
    }

    public void d() {
        this.f2619a.b();
    }
}

package p;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.NonNull;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f16882a;

    interface a {
        void a(long j10);

        void b(@NonNull Surface surface);

        void c(String str);

        String d();

        void e();

        Object f();

        Surface getSurface();
    }

    public b(int i10, @NonNull Surface surface) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 33) {
            this.f16882a = new i(i10, surface);
        } else if (i11 >= 28) {
            this.f16882a = new h(i10, surface);
        } else if (i11 >= 26) {
            this.f16882a = new f(i10, surface);
        } else {
            this.f16882a = new c(i10, surface);
        }
    }

    public static b h(Object obj) {
        a aVar;
        if (obj == null) {
            return null;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            aVar = i.k((OutputConfiguration) obj);
        } else if (i10 >= 28) {
            aVar = h.j((OutputConfiguration) obj);
        } else if (i10 >= 26) {
            aVar = f.i((OutputConfiguration) obj);
        } else {
            aVar = c.h((OutputConfiguration) obj);
        }
        if (aVar == null) {
            return null;
        }
        return new b(aVar);
    }

    public void a(@NonNull Surface surface) {
        this.f16882a.b(surface);
    }

    public void b() {
        this.f16882a.e();
    }

    public String c() {
        return this.f16882a.d();
    }

    public Surface d() {
        return this.f16882a.getSurface();
    }

    public void e(String str) {
        this.f16882a.c(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f16882a.equals(((b) obj).f16882a);
    }

    public void f(long j10) {
        this.f16882a.a(j10);
    }

    public Object g() {
        return this.f16882a.f();
    }

    public int hashCode() {
        return this.f16882a.hashCode();
    }

    private b(@NonNull a aVar) {
        this.f16882a = aVar;
    }
}

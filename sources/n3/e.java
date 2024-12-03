package n3;

import android.util.Log;
import f3.b;
import java.io.File;
import java.io.IOException;
import n3.a;

public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private final j f16395a;

    /* renamed from: b  reason: collision with root package name */
    private final File f16396b;

    /* renamed from: c  reason: collision with root package name */
    private final long f16397c;

    /* renamed from: d  reason: collision with root package name */
    private final c f16398d = new c();

    /* renamed from: e  reason: collision with root package name */
    private b f16399e;

    @Deprecated
    protected e(File file, long j10) {
        this.f16396b = file;
        this.f16397c = j10;
        this.f16395a = new j();
    }

    public static a c(File file, long j10) {
        return new e(file, j10);
    }

    private synchronized b d() throws IOException {
        if (this.f16399e == null) {
            this.f16399e = b.G(this.f16396b, 1, 1, this.f16397c);
        }
        return this.f16399e;
    }

    public File a(i3.b bVar) {
        String b10 = this.f16395a.b(bVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Get: Obtained: ");
            sb2.append(b10);
            sb2.append(" for for Key: ");
            sb2.append(bVar);
        }
        try {
            b.e E = d().E(b10);
            if (E != null) {
                return E.a(0);
            }
            return null;
        } catch (IOException unused) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
            return null;
        }
    }

    public void b(i3.b bVar, a.b bVar2) {
        b.c x10;
        String b10 = this.f16395a.b(bVar);
        this.f16398d.a(b10);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Put: Obtained: ");
                sb2.append(b10);
                sb2.append(" for for Key: ");
                sb2.append(bVar);
            }
            try {
                b d10 = d();
                if (d10.E(b10) == null) {
                    x10 = d10.x(b10);
                    if (x10 != null) {
                        if (bVar2.a(x10.f(0))) {
                            x10.e();
                        }
                        x10.b();
                        this.f16398d.b(b10);
                        return;
                    }
                    throw new IllegalStateException("Had two simultaneous puts for: " + b10);
                }
            } catch (IOException unused) {
                boolean isLoggable = Log.isLoggable("DiskLruCacheWrapper", 5);
            } catch (Throwable th2) {
                x10.b();
                throw th2;
            }
        } finally {
            this.f16398d.b(b10);
        }
    }
}

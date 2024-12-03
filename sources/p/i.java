package p;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.annotation.NonNull;

public class i extends h {
    i(int i10, @NonNull Surface surface) {
        this(new OutputConfiguration(i10, surface));
    }

    static i k(@NonNull OutputConfiguration outputConfiguration) {
        return new i(outputConfiguration);
    }

    public void a(long j10) {
        if (j10 != -1) {
            ((OutputConfiguration) f()).setStreamUseCase(j10);
        }
    }

    public /* bridge */ /* synthetic */ void b(@NonNull Surface surface) {
        super.b(surface);
    }

    public /* bridge */ /* synthetic */ void c(String str) {
        super.c(str);
    }

    public /* bridge */ /* synthetic */ String d() {
        return super.d();
    }

    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @NonNull
    public /* bridge */ /* synthetic */ Object f() {
        return super.f();
    }

    public /* bridge */ /* synthetic */ Surface getSurface() {
        return super.getSurface();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    i(@NonNull Object obj) {
        super(obj);
    }
}

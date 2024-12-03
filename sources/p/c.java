package p;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.core.util.h;
import java.util.Objects;

class c extends j {

    private static final class a {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final OutputConfiguration f16883a;

        /* renamed from: b  reason: collision with root package name */
        String f16884b;

        /* renamed from: c  reason: collision with root package name */
        boolean f16885c;

        a(@NonNull OutputConfiguration outputConfiguration) {
            this.f16883a = outputConfiguration;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!Objects.equals(this.f16883a, aVar.f16883a) || this.f16885c != aVar.f16885c || !Objects.equals(this.f16884b, aVar.f16884b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i10;
            int hashCode = this.f16883a.hashCode() ^ 31;
            boolean z10 = this.f16885c ^ ((hashCode << 5) - hashCode);
            int i11 = ((z10 ? 1 : 0) << true) - z10;
            String str = this.f16884b;
            if (str == null) {
                i10 = 0;
            } else {
                i10 = str.hashCode();
            }
            return i10 ^ i11;
        }
    }

    c(int i10, @NonNull Surface surface) {
        this(new a(new OutputConfiguration(i10, surface)));
    }

    static c h(@NonNull OutputConfiguration outputConfiguration) {
        return new c(new a(outputConfiguration));
    }

    public void c(String str) {
        ((a) this.f16888a).f16884b = str;
    }

    public String d() {
        return ((a) this.f16888a).f16884b;
    }

    public void e() {
        ((a) this.f16888a).f16885c = true;
    }

    @NonNull
    public Object f() {
        h.a(this.f16888a instanceof a);
        return ((a) this.f16888a).f16883a;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return ((a) this.f16888a).f16885c;
    }

    public Surface getSurface() {
        return ((OutputConfiguration) f()).getSurface();
    }

    c(@NonNull Object obj) {
        super(obj);
    }
}

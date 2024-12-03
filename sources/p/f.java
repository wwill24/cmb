package p;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.core.util.h;
import java.util.Objects;

class f extends c {

    private static final class a {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final OutputConfiguration f16886a;

        /* renamed from: b  reason: collision with root package name */
        String f16887b;

        a(@NonNull OutputConfiguration outputConfiguration) {
            this.f16886a = outputConfiguration;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!Objects.equals(this.f16886a, aVar.f16886a) || !Objects.equals(this.f16887b, aVar.f16887b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i10;
            int hashCode = this.f16886a.hashCode() ^ 31;
            int i11 = (hashCode << 5) - hashCode;
            String str = this.f16887b;
            if (str == null) {
                i10 = 0;
            } else {
                i10 = str.hashCode();
            }
            return i10 ^ i11;
        }
    }

    f(int i10, @NonNull Surface surface) {
        this(new a(new OutputConfiguration(i10, surface)));
    }

    static f i(@NonNull OutputConfiguration outputConfiguration) {
        return new f(new a(outputConfiguration));
    }

    public void b(@NonNull Surface surface) {
        ((OutputConfiguration) f()).addSurface(surface);
    }

    public void c(String str) {
        ((a) this.f16888a).f16887b = str;
    }

    public String d() {
        return ((a) this.f16888a).f16887b;
    }

    public void e() {
        ((OutputConfiguration) f()).enableSurfaceSharing();
    }

    @NonNull
    public Object f() {
        h.a(this.f16888a instanceof a);
        return ((a) this.f16888a).f16886a;
    }

    /* access modifiers changed from: package-private */
    public final boolean g() {
        throw new AssertionError("isSurfaceSharingEnabled() should not be called on API >= 26");
    }

    f(@NonNull Object obj) {
        super(obj);
    }
}

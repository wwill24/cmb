package p;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.core.util.h;
import java.util.List;
import java.util.Objects;
import p.b;

class j implements b.a {

    /* renamed from: a  reason: collision with root package name */
    final Object f16888a;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<Surface> f16889a;

        /* renamed from: b  reason: collision with root package name */
        final Size f16890b;

        /* renamed from: c  reason: collision with root package name */
        final int f16891c;

        /* renamed from: d  reason: collision with root package name */
        final int f16892d;

        /* renamed from: e  reason: collision with root package name */
        String f16893e;

        /* renamed from: f  reason: collision with root package name */
        boolean f16894f;

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.f16890b.equals(aVar.f16890b) || this.f16891c != aVar.f16891c || this.f16892d != aVar.f16892d || this.f16894f != aVar.f16894f || !Objects.equals(this.f16893e, aVar.f16893e)) {
                return false;
            }
            int min = Math.min(this.f16889a.size(), aVar.f16889a.size());
            for (int i10 = 0; i10 < min; i10++) {
                if (this.f16889a.get(i10) != aVar.f16889a.get(i10)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i10;
            int hashCode = this.f16889a.hashCode() ^ 31;
            int i11 = this.f16892d ^ ((hashCode << 5) - hashCode);
            int hashCode2 = this.f16890b.hashCode() ^ ((i11 << 5) - i11);
            int i12 = this.f16891c ^ ((hashCode2 << 5) - hashCode2);
            boolean z10 = this.f16894f ^ ((i12 << 5) - i12);
            int i13 = ((z10 ? 1 : 0) << true) - z10;
            String str = this.f16893e;
            if (str == null) {
                i10 = 0;
            } else {
                i10 = str.hashCode();
            }
            return i10 ^ i13;
        }
    }

    j(@NonNull Object obj) {
        this.f16888a = obj;
    }

    public void a(long j10) {
    }

    public void b(@NonNull Surface surface) {
        h.h(surface, "Surface must not be null");
        if (getSurface() == surface) {
            throw new IllegalStateException("Surface is already added!");
        } else if (!g()) {
            throw new IllegalStateException("Cannot have 2 surfaces for a non-sharing configuration");
        } else {
            throw new IllegalArgumentException("Exceeds maximum number of surfaces");
        }
    }

    public void c(String str) {
        ((a) this.f16888a).f16893e = str;
    }

    public String d() {
        return ((a) this.f16888a).f16893e;
    }

    public void e() {
        ((a) this.f16888a).f16894f = true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        return Objects.equals(this.f16888a, ((j) obj).f16888a);
    }

    public Object f() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return ((a) this.f16888a).f16894f;
    }

    public Surface getSurface() {
        List<Surface> list = ((a) this.f16888a).f16889a;
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public int hashCode() {
        return this.f16888a.hashCode();
    }
}

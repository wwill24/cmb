package g0;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.m;
import g0.h;

final class g extends h {

    /* renamed from: a  reason: collision with root package name */
    private final String f14980a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14981b;

    /* renamed from: c  reason: collision with root package name */
    private final m f14982c;

    static final class b extends h.a {

        /* renamed from: a  reason: collision with root package name */
        private String f14983a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f14984b;

        /* renamed from: c  reason: collision with root package name */
        private m f14985c;

        b() {
        }

        public h a() {
            String str = "";
            if (this.f14983a == null) {
                str = str + " mimeType";
            }
            if (this.f14984b == null) {
                str = str + " profile";
            }
            if (str.isEmpty()) {
                return new g(this.f14983a, this.f14984b.intValue(), this.f14985c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public h.a b(m mVar) {
            this.f14985c = mVar;
            return this;
        }

        public h.a c(int i10) {
            this.f14984b = Integer.valueOf(i10);
            return this;
        }

        /* access modifiers changed from: package-private */
        public h.a d(String str) {
            if (str != null) {
                this.f14983a = str;
                return this;
            }
            throw new NullPointerException("Null mimeType");
        }
    }

    public m b() {
        return this.f14982c;
    }

    @NonNull
    public String c() {
        return this.f14980a;
    }

    public int d() {
        return this.f14981b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f14980a.equals(hVar.c()) && this.f14981b == hVar.d()) {
            m mVar = this.f14982c;
            if (mVar == null) {
                if (hVar.b() == null) {
                    return true;
                }
            } else if (mVar.equals(hVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = (((this.f14980a.hashCode() ^ 1000003) * 1000003) ^ this.f14981b) * 1000003;
        m mVar = this.f14982c;
        if (mVar == null) {
            i10 = 0;
        } else {
            i10 = mVar.hashCode();
        }
        return hashCode ^ i10;
    }

    public String toString() {
        return "MimeInfo{mimeType=" + this.f14980a + ", profile=" + this.f14981b + ", compatibleCamcorderProfile=" + this.f14982c + "}";
    }

    private g(String str, int i10, m mVar) {
        this.f14980a = str;
        this.f14981b = i10;
        this.f14982c = mVar;
    }
}

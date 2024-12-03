package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.SessionConfig;
import java.util.List;

final class h extends SessionConfig.e {

    /* renamed from: a  reason: collision with root package name */
    private final DeferrableSurface f2538a;

    /* renamed from: b  reason: collision with root package name */
    private final List<DeferrableSurface> f2539b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2540c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2541d;

    static final class b extends SessionConfig.e.a {

        /* renamed from: a  reason: collision with root package name */
        private DeferrableSurface f2542a;

        /* renamed from: b  reason: collision with root package name */
        private List<DeferrableSurface> f2543b;

        /* renamed from: c  reason: collision with root package name */
        private String f2544c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f2545d;

        b() {
        }

        public SessionConfig.e a() {
            String str = "";
            if (this.f2542a == null) {
                str = str + " surface";
            }
            if (this.f2543b == null) {
                str = str + " sharedSurfaces";
            }
            if (this.f2545d == null) {
                str = str + " surfaceGroupId";
            }
            if (str.isEmpty()) {
                return new h(this.f2542a, this.f2543b, this.f2544c, this.f2545d.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public SessionConfig.e.a b(String str) {
            this.f2544c = str;
            return this;
        }

        public SessionConfig.e.a c(List<DeferrableSurface> list) {
            if (list != null) {
                this.f2543b = list;
                return this;
            }
            throw new NullPointerException("Null sharedSurfaces");
        }

        public SessionConfig.e.a d(int i10) {
            this.f2545d = Integer.valueOf(i10);
            return this;
        }

        public SessionConfig.e.a e(DeferrableSurface deferrableSurface) {
            if (deferrableSurface != null) {
                this.f2542a = deferrableSurface;
                return this;
            }
            throw new NullPointerException("Null surface");
        }
    }

    public String b() {
        return this.f2540c;
    }

    @NonNull
    public List<DeferrableSurface> c() {
        return this.f2539b;
    }

    @NonNull
    public DeferrableSurface d() {
        return this.f2538a;
    }

    public int e() {
        return this.f2541d;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SessionConfig.e)) {
            return false;
        }
        SessionConfig.e eVar = (SessionConfig.e) obj;
        if (!this.f2538a.equals(eVar.d()) || !this.f2539b.equals(eVar.c()) || ((str = this.f2540c) != null ? !str.equals(eVar.b()) : eVar.b() != null) || this.f2541d != eVar.e()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        int hashCode = (((this.f2538a.hashCode() ^ 1000003) * 1000003) ^ this.f2539b.hashCode()) * 1000003;
        String str = this.f2540c;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        return ((hashCode ^ i10) * 1000003) ^ this.f2541d;
    }

    public String toString() {
        return "OutputConfig{surface=" + this.f2538a + ", sharedSurfaces=" + this.f2539b + ", physicalCameraId=" + this.f2540c + ", surfaceGroupId=" + this.f2541d + "}";
    }

    private h(DeferrableSurface deferrableSurface, List<DeferrableSurface> list, String str, int i10) {
        this.f2538a = deferrableSurface;
        this.f2539b = list;
        this.f2540c = str;
        this.f2541d = i10;
    }
}

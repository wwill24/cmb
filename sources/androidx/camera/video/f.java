package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.camera.video.n;

final class f extends n {

    /* renamed from: a  reason: collision with root package name */
    private final j0 f3100a;

    /* renamed from: b  reason: collision with root package name */
    private final a f3101b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3102c;

    static final class b extends n.a {

        /* renamed from: a  reason: collision with root package name */
        private j0 f3103a;

        /* renamed from: b  reason: collision with root package name */
        private a f3104b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f3105c;

        public n a() {
            String str = "";
            if (this.f3103a == null) {
                str = str + " videoSpec";
            }
            if (this.f3104b == null) {
                str = str + " audioSpec";
            }
            if (this.f3105c == null) {
                str = str + " outputFormat";
            }
            if (str.isEmpty()) {
                return new f(this.f3103a, this.f3104b, this.f3105c.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        public j0 c() {
            j0 j0Var = this.f3103a;
            if (j0Var != null) {
                return j0Var;
            }
            throw new IllegalStateException("Property \"videoSpec\" has not been set");
        }

        public n.a d(a aVar) {
            if (aVar != null) {
                this.f3104b = aVar;
                return this;
            }
            throw new NullPointerException("Null audioSpec");
        }

        public n.a e(int i10) {
            this.f3105c = Integer.valueOf(i10);
            return this;
        }

        public n.a f(j0 j0Var) {
            if (j0Var != null) {
                this.f3103a = j0Var;
                return this;
            }
            throw new NullPointerException("Null videoSpec");
        }

        b() {
        }

        private b(n nVar) {
            this.f3103a = nVar.d();
            this.f3104b = nVar.b();
            this.f3105c = Integer.valueOf(nVar.c());
        }
    }

    @NonNull
    public a b() {
        return this.f3101b;
    }

    public int c() {
        return this.f3102c;
    }

    @NonNull
    public j0 d() {
        return this.f3100a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (!this.f3100a.equals(nVar.d()) || !this.f3101b.equals(nVar.b()) || this.f3102c != nVar.c()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.f3100a.hashCode() ^ 1000003) * 1000003) ^ this.f3101b.hashCode()) * 1000003) ^ this.f3102c;
    }

    public n.a i() {
        return new b(this);
    }

    public String toString() {
        return "MediaSpec{videoSpec=" + this.f3100a + ", audioSpec=" + this.f3101b + ", outputFormat=" + this.f3102c + "}";
    }

    private f(j0 j0Var, a aVar, int i10) {
        this.f3100a = j0Var;
        this.f3101b = aVar;
        this.f3102c = i10;
    }
}

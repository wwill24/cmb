package androidx.camera.video;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.video.j0;

final class l extends j0 {

    /* renamed from: d  reason: collision with root package name */
    private final r f3388d;

    /* renamed from: e  reason: collision with root package name */
    private final Range<Integer> f3389e;

    /* renamed from: f  reason: collision with root package name */
    private final Range<Integer> f3390f;

    /* renamed from: g  reason: collision with root package name */
    private final int f3391g;

    static final class b extends j0.a {

        /* renamed from: a  reason: collision with root package name */
        private r f3392a;

        /* renamed from: b  reason: collision with root package name */
        private Range<Integer> f3393b;

        /* renamed from: c  reason: collision with root package name */
        private Range<Integer> f3394c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f3395d;

        public j0 a() {
            String str = "";
            if (this.f3392a == null) {
                str = str + " qualitySelector";
            }
            if (this.f3393b == null) {
                str = str + " frameRate";
            }
            if (this.f3394c == null) {
                str = str + " bitrate";
            }
            if (this.f3395d == null) {
                str = str + " aspectRatio";
            }
            if (str.isEmpty()) {
                return new l(this.f3392a, this.f3393b, this.f3394c, this.f3395d.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        public j0.a b(int i10) {
            this.f3395d = Integer.valueOf(i10);
            return this;
        }

        public j0.a c(Range<Integer> range) {
            if (range != null) {
                this.f3394c = range;
                return this;
            }
            throw new NullPointerException("Null bitrate");
        }

        public j0.a d(Range<Integer> range) {
            if (range != null) {
                this.f3393b = range;
                return this;
            }
            throw new NullPointerException("Null frameRate");
        }

        public j0.a e(r rVar) {
            if (rVar != null) {
                this.f3392a = rVar;
                return this;
            }
            throw new NullPointerException("Null qualitySelector");
        }

        b() {
        }

        private b(j0 j0Var) {
            this.f3392a = j0Var.e();
            this.f3393b = j0Var.d();
            this.f3394c = j0Var.c();
            this.f3395d = Integer.valueOf(j0Var.b());
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f3391g;
    }

    @NonNull
    public Range<Integer> c() {
        return this.f3390f;
    }

    @NonNull
    public Range<Integer> d() {
        return this.f3389e;
    }

    @NonNull
    public r e() {
        return this.f3388d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        if (!this.f3388d.equals(j0Var.e()) || !this.f3389e.equals(j0Var.d()) || !this.f3390f.equals(j0Var.c()) || this.f3391g != j0Var.b()) {
            return false;
        }
        return true;
    }

    public j0.a f() {
        return new b(this);
    }

    public int hashCode() {
        return ((((((this.f3388d.hashCode() ^ 1000003) * 1000003) ^ this.f3389e.hashCode()) * 1000003) ^ this.f3390f.hashCode()) * 1000003) ^ this.f3391g;
    }

    public String toString() {
        return "VideoSpec{qualitySelector=" + this.f3388d + ", frameRate=" + this.f3389e + ", bitrate=" + this.f3390f + ", aspectRatio=" + this.f3391g + "}";
    }

    private l(r rVar, Range<Integer> range, Range<Integer> range2, int i10) {
        this.f3388d = rVar;
        this.f3389e = range;
        this.f3390f = range2;
        this.f3391g = i10;
    }
}

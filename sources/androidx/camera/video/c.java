package androidx.camera.video;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.video.a;

final class c extends a {

    /* renamed from: d  reason: collision with root package name */
    private final Range<Integer> f3081d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3082e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3083f;

    /* renamed from: g  reason: collision with root package name */
    private final Range<Integer> f3084g;

    /* renamed from: h  reason: collision with root package name */
    private final int f3085h;

    static final class b extends a.C0021a {

        /* renamed from: a  reason: collision with root package name */
        private Range<Integer> f3086a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f3087b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f3088c;

        /* renamed from: d  reason: collision with root package name */
        private Range<Integer> f3089d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f3090e;

        b() {
        }

        public a a() {
            String str = "";
            if (this.f3086a == null) {
                str = str + " bitrate";
            }
            if (this.f3087b == null) {
                str = str + " sourceFormat";
            }
            if (this.f3088c == null) {
                str = str + " source";
            }
            if (this.f3089d == null) {
                str = str + " sampleRate";
            }
            if (this.f3090e == null) {
                str = str + " channelCount";
            }
            if (str.isEmpty()) {
                return new c(this.f3086a, this.f3087b.intValue(), this.f3088c.intValue(), this.f3089d, this.f3090e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public a.C0021a b(Range<Integer> range) {
            if (range != null) {
                this.f3086a = range;
                return this;
            }
            throw new NullPointerException("Null bitrate");
        }

        public a.C0021a c(int i10) {
            this.f3090e = Integer.valueOf(i10);
            return this;
        }

        public a.C0021a d(Range<Integer> range) {
            if (range != null) {
                this.f3089d = range;
                return this;
            }
            throw new NullPointerException("Null sampleRate");
        }

        public a.C0021a e(int i10) {
            this.f3088c = Integer.valueOf(i10);
            return this;
        }

        public a.C0021a f(int i10) {
            this.f3087b = Integer.valueOf(i10);
            return this;
        }
    }

    @NonNull
    public Range<Integer> b() {
        return this.f3081d;
    }

    public int c() {
        return this.f3085h;
    }

    @NonNull
    public Range<Integer> d() {
        return this.f3084g;
    }

    public int e() {
        return this.f3083f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f3081d.equals(aVar.b()) && this.f3082e == aVar.f() && this.f3083f == aVar.e() && this.f3084g.equals(aVar.d()) && this.f3085h == aVar.c()) {
            return true;
        }
        return false;
    }

    public int f() {
        return this.f3082e;
    }

    public int hashCode() {
        return ((((((((this.f3081d.hashCode() ^ 1000003) * 1000003) ^ this.f3082e) * 1000003) ^ this.f3083f) * 1000003) ^ this.f3084g.hashCode()) * 1000003) ^ this.f3085h;
    }

    public String toString() {
        return "AudioSpec{bitrate=" + this.f3081d + ", sourceFormat=" + this.f3082e + ", source=" + this.f3083f + ", sampleRate=" + this.f3084g + ", channelCount=" + this.f3085h + "}";
    }

    private c(Range<Integer> range, int i10, int i11, Range<Integer> range2, int i12) {
        this.f3081d = range;
        this.f3082e = i10;
        this.f3083f = i11;
        this.f3084g = range2;
        this.f3085h = i12;
    }
}

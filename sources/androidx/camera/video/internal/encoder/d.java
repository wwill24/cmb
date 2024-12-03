package androidx.camera.video.internal.encoder;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.h1;

final class d extends h1 {

    /* renamed from: b  reason: collision with root package name */
    private final String f3274b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3275c;

    /* renamed from: d  reason: collision with root package name */
    private final Timebase f3276d;

    /* renamed from: e  reason: collision with root package name */
    private final Size f3277e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3278f;

    /* renamed from: g  reason: collision with root package name */
    private final int f3279g;

    /* renamed from: h  reason: collision with root package name */
    private final int f3280h;

    /* renamed from: i  reason: collision with root package name */
    private final int f3281i;

    static final class b extends h1.a {

        /* renamed from: a  reason: collision with root package name */
        private String f3282a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f3283b;

        /* renamed from: c  reason: collision with root package name */
        private Timebase f3284c;

        /* renamed from: d  reason: collision with root package name */
        private Size f3285d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f3286e;

        /* renamed from: f  reason: collision with root package name */
        private Integer f3287f;

        /* renamed from: g  reason: collision with root package name */
        private Integer f3288g;

        /* renamed from: h  reason: collision with root package name */
        private Integer f3289h;

        b() {
        }

        public h1 a() {
            String str = "";
            if (this.f3282a == null) {
                str = str + " mimeType";
            }
            if (this.f3283b == null) {
                str = str + " profile";
            }
            if (this.f3284c == null) {
                str = str + " inputTimebase";
            }
            if (this.f3285d == null) {
                str = str + " resolution";
            }
            if (this.f3286e == null) {
                str = str + " colorFormat";
            }
            if (this.f3287f == null) {
                str = str + " frameRate";
            }
            if (this.f3288g == null) {
                str = str + " IFrameInterval";
            }
            if (this.f3289h == null) {
                str = str + " bitrate";
            }
            if (str.isEmpty()) {
                return new d(this.f3282a, this.f3283b.intValue(), this.f3284c, this.f3285d, this.f3286e.intValue(), this.f3287f.intValue(), this.f3288g.intValue(), this.f3289h.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public h1.a b(int i10) {
            this.f3289h = Integer.valueOf(i10);
            return this;
        }

        public h1.a c(int i10) {
            this.f3286e = Integer.valueOf(i10);
            return this;
        }

        public h1.a d(int i10) {
            this.f3287f = Integer.valueOf(i10);
            return this;
        }

        public h1.a e(int i10) {
            this.f3288g = Integer.valueOf(i10);
            return this;
        }

        public h1.a f(Timebase timebase) {
            if (timebase != null) {
                this.f3284c = timebase;
                return this;
            }
            throw new NullPointerException("Null inputTimebase");
        }

        public h1.a g(String str) {
            if (str != null) {
                this.f3282a = str;
                return this;
            }
            throw new NullPointerException("Null mimeType");
        }

        public h1.a h(Size size) {
            if (size != null) {
                this.f3285d = size;
                return this;
            }
            throw new NullPointerException("Null resolution");
        }

        public h1.a i(int i10) {
            this.f3283b = Integer.valueOf(i10);
            return this;
        }
    }

    @NonNull
    public String b() {
        return this.f3274b;
    }

    @NonNull
    public Timebase c() {
        return this.f3276d;
    }

    public int e() {
        return this.f3281i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h1)) {
            return false;
        }
        h1 h1Var = (h1) obj;
        if (this.f3274b.equals(h1Var.b()) && this.f3275c == h1Var.i() && this.f3276d.equals(h1Var.c()) && this.f3277e.equals(h1Var.j()) && this.f3278f == h1Var.f() && this.f3279g == h1Var.g() && this.f3280h == h1Var.h() && this.f3281i == h1Var.e()) {
            return true;
        }
        return false;
    }

    public int f() {
        return this.f3278f;
    }

    public int g() {
        return this.f3279g;
    }

    public int h() {
        return this.f3280h;
    }

    public int hashCode() {
        return ((((((((((((((this.f3274b.hashCode() ^ 1000003) * 1000003) ^ this.f3275c) * 1000003) ^ this.f3276d.hashCode()) * 1000003) ^ this.f3277e.hashCode()) * 1000003) ^ this.f3278f) * 1000003) ^ this.f3279g) * 1000003) ^ this.f3280h) * 1000003) ^ this.f3281i;
    }

    public int i() {
        return this.f3275c;
    }

    @NonNull
    public Size j() {
        return this.f3277e;
    }

    public String toString() {
        return "VideoEncoderConfig{mimeType=" + this.f3274b + ", profile=" + this.f3275c + ", inputTimebase=" + this.f3276d + ", resolution=" + this.f3277e + ", colorFormat=" + this.f3278f + ", frameRate=" + this.f3279g + ", IFrameInterval=" + this.f3280h + ", bitrate=" + this.f3281i + "}";
    }

    private d(String str, int i10, Timebase timebase, Size size, int i11, int i12, int i13, int i14) {
        this.f3274b = str;
        this.f3275c = i10;
        this.f3276d = timebase;
        this.f3277e = size;
        this.f3278f = i11;
        this.f3279g = i12;
        this.f3280h = i13;
        this.f3281i = i14;
    }
}

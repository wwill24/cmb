package androidx.camera.video.internal.encoder;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.a;

final class c extends a {

    /* renamed from: b  reason: collision with root package name */
    private final String f3260b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3261c;

    /* renamed from: d  reason: collision with root package name */
    private final Timebase f3262d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3263e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3264f;

    /* renamed from: g  reason: collision with root package name */
    private final int f3265g;

    static final class b extends a.C0024a {

        /* renamed from: a  reason: collision with root package name */
        private String f3266a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f3267b;

        /* renamed from: c  reason: collision with root package name */
        private Timebase f3268c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f3269d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f3270e;

        /* renamed from: f  reason: collision with root package name */
        private Integer f3271f;

        b() {
        }

        /* access modifiers changed from: package-private */
        public a a() {
            String str = "";
            if (this.f3266a == null) {
                str = str + " mimeType";
            }
            if (this.f3267b == null) {
                str = str + " profile";
            }
            if (this.f3268c == null) {
                str = str + " inputTimebase";
            }
            if (this.f3269d == null) {
                str = str + " bitrate";
            }
            if (this.f3270e == null) {
                str = str + " sampleRate";
            }
            if (this.f3271f == null) {
                str = str + " channelCount";
            }
            if (str.isEmpty()) {
                return new c(this.f3266a, this.f3267b.intValue(), this.f3268c, this.f3269d.intValue(), this.f3270e.intValue(), this.f3271f.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public a.C0024a c(int i10) {
            this.f3269d = Integer.valueOf(i10);
            return this;
        }

        public a.C0024a d(int i10) {
            this.f3271f = Integer.valueOf(i10);
            return this;
        }

        public a.C0024a e(Timebase timebase) {
            if (timebase != null) {
                this.f3268c = timebase;
                return this;
            }
            throw new NullPointerException("Null inputTimebase");
        }

        public a.C0024a f(String str) {
            if (str != null) {
                this.f3266a = str;
                return this;
            }
            throw new NullPointerException("Null mimeType");
        }

        public a.C0024a g(int i10) {
            this.f3267b = Integer.valueOf(i10);
            return this;
        }

        public a.C0024a h(int i10) {
            this.f3270e = Integer.valueOf(i10);
            return this;
        }
    }

    @NonNull
    public String b() {
        return this.f3260b;
    }

    @NonNull
    public Timebase c() {
        return this.f3262d;
    }

    public int e() {
        return this.f3263e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f3260b.equals(aVar.b()) && this.f3261c == aVar.g() && this.f3262d.equals(aVar.c()) && this.f3263e == aVar.e() && this.f3264f == aVar.h() && this.f3265g == aVar.f()) {
            return true;
        }
        return false;
    }

    public int f() {
        return this.f3265g;
    }

    public int g() {
        return this.f3261c;
    }

    public int h() {
        return this.f3264f;
    }

    public int hashCode() {
        return ((((((((((this.f3260b.hashCode() ^ 1000003) * 1000003) ^ this.f3261c) * 1000003) ^ this.f3262d.hashCode()) * 1000003) ^ this.f3263e) * 1000003) ^ this.f3264f) * 1000003) ^ this.f3265g;
    }

    public String toString() {
        return "AudioEncoderConfig{mimeType=" + this.f3260b + ", profile=" + this.f3261c + ", inputTimebase=" + this.f3262d + ", bitrate=" + this.f3263e + ", sampleRate=" + this.f3264f + ", channelCount=" + this.f3265g + "}";
    }

    private c(String str, int i10, Timebase timebase, int i11, int i12, int i13) {
        this.f3260b = str;
        this.f3261c = i10;
        this.f3262d = timebase;
        this.f3263e = i11;
        this.f3264f = i12;
        this.f3265g = i13;
    }
}

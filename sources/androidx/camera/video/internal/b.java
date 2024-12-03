package androidx.camera.video.internal;

import androidx.camera.video.internal.AudioSource;

final class b extends AudioSource.f {

    /* renamed from: a  reason: collision with root package name */
    private final int f3184a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3185b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3186c;

    /* renamed from: d  reason: collision with root package name */
    private final int f3187d;

    /* renamed from: androidx.camera.video.internal.b$b  reason: collision with other inner class name */
    static final class C0022b extends AudioSource.f.a {

        /* renamed from: a  reason: collision with root package name */
        private Integer f3188a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f3189b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f3190c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f3191d;

        C0022b() {
        }

        /* access modifiers changed from: package-private */
        public AudioSource.f a() {
            String str = "";
            if (this.f3188a == null) {
                str = str + " audioSource";
            }
            if (this.f3189b == null) {
                str = str + " sampleRate";
            }
            if (this.f3190c == null) {
                str = str + " channelCount";
            }
            if (this.f3191d == null) {
                str = str + " audioFormat";
            }
            if (str.isEmpty()) {
                return new b(this.f3188a.intValue(), this.f3189b.intValue(), this.f3190c.intValue(), this.f3191d.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public AudioSource.f.a c(int i10) {
            this.f3191d = Integer.valueOf(i10);
            return this;
        }

        public AudioSource.f.a d(int i10) {
            this.f3188a = Integer.valueOf(i10);
            return this;
        }

        public AudioSource.f.a e(int i10) {
            this.f3190c = Integer.valueOf(i10);
            return this;
        }

        public AudioSource.f.a f(int i10) {
            this.f3189b = Integer.valueOf(i10);
            return this;
        }
    }

    public int b() {
        return this.f3187d;
    }

    public int c() {
        return this.f3184a;
    }

    public int d() {
        return this.f3186c;
    }

    public int e() {
        return this.f3185b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AudioSource.f)) {
            return false;
        }
        AudioSource.f fVar = (AudioSource.f) obj;
        if (this.f3184a == fVar.c() && this.f3185b == fVar.e() && this.f3186c == fVar.d() && this.f3187d == fVar.b()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f3184a ^ 1000003) * 1000003) ^ this.f3185b) * 1000003) ^ this.f3186c) * 1000003) ^ this.f3187d;
    }

    public String toString() {
        return "Settings{audioSource=" + this.f3184a + ", sampleRate=" + this.f3185b + ", channelCount=" + this.f3186c + ", audioFormat=" + this.f3187d + "}";
    }

    private b(int i10, int i11, int i12, int i13) {
        this.f3184a = i10;
        this.f3185b = i11;
        this.f3186c = i12;
        this.f3187d = i13;
    }
}

package androidx.media;

import java.util.Arrays;

class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    int f6131a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f6132b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f6133c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f6134d = -1;

    AudioAttributesImplBase() {
    }

    public int a() {
        return this.f6132b;
    }

    public int b() {
        int i10 = this.f6133c;
        int c10 = c();
        if (c10 == 6) {
            i10 |= 4;
        } else if (c10 == 7) {
            i10 |= 1;
        }
        return i10 & 273;
    }

    public int c() {
        int i10 = this.f6134d;
        if (i10 != -1) {
            return i10;
        }
        return AudioAttributesCompat.a(false, this.f6133c, this.f6131a);
    }

    public int d() {
        return this.f6131a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f6132b == audioAttributesImplBase.a() && this.f6133c == audioAttributesImplBase.b() && this.f6131a == audioAttributesImplBase.d() && this.f6134d == audioAttributesImplBase.f6134d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f6132b), Integer.valueOf(this.f6133c), Integer.valueOf(this.f6131a), Integer.valueOf(this.f6134d)});
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("AudioAttributesCompat:");
        if (this.f6134d != -1) {
            sb2.append(" stream=");
            sb2.append(this.f6134d);
            sb2.append(" derived");
        }
        sb2.append(" usage=");
        sb2.append(AudioAttributesCompat.b(this.f6131a));
        sb2.append(" content=");
        sb2.append(this.f6132b);
        sb2.append(" flags=0x");
        sb2.append(Integer.toHexString(this.f6133c).toUpperCase());
        return sb2.toString();
    }
}

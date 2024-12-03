package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    AudioAttributes f6129a;

    /* renamed from: b  reason: collision with root package name */
    int f6130b = -1;

    AudioAttributesImplApi21() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.f6129a.equals(((AudioAttributesImplApi21) obj).f6129a);
    }

    public int hashCode() {
        return this.f6129a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f6129a;
    }
}

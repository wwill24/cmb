package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.a;

public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(a aVar) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f6129a = (AudioAttributes) aVar.r(audioAttributesImplApi21.f6129a, 1);
        audioAttributesImplApi21.f6130b = aVar.p(audioAttributesImplApi21.f6130b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, a aVar) {
        aVar.x(false, false);
        aVar.H(audioAttributesImplApi21.f6129a, 1);
        aVar.F(audioAttributesImplApi21.f6130b, 2);
    }
}

package androidx.media;

import androidx.versionedparcelable.a;

public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(a aVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f6131a = aVar.p(audioAttributesImplBase.f6131a, 1);
        audioAttributesImplBase.f6132b = aVar.p(audioAttributesImplBase.f6132b, 2);
        audioAttributesImplBase.f6133c = aVar.p(audioAttributesImplBase.f6133c, 3);
        audioAttributesImplBase.f6134d = aVar.p(audioAttributesImplBase.f6134d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, a aVar) {
        aVar.x(false, false);
        aVar.F(audioAttributesImplBase.f6131a, 1);
        aVar.F(audioAttributesImplBase.f6132b, 2);
        aVar.F(audioAttributesImplBase.f6133c, 3);
        aVar.F(audioAttributesImplBase.f6134d, 4);
    }
}

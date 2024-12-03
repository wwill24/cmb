package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import androidx.annotation.NonNull;
import i0.b;
import java.util.Objects;

public abstract class a1 implements z0 {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodecInfo f3253a;

    /* renamed from: b  reason: collision with root package name */
    protected final MediaCodecInfo.CodecCapabilities f3254b;

    a1(@NonNull MediaCodecInfo mediaCodecInfo, @NonNull String str) throws InvalidConfigException {
        this.f3253a = mediaCodecInfo;
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
            Objects.requireNonNull(capabilitiesForType);
            MediaCodecInfo.CodecCapabilities codecCapabilities = capabilitiesForType;
            this.f3254b = capabilitiesForType;
        } catch (RuntimeException e10) {
            throw new InvalidConfigException("Unable to get CodecCapabilities for mime: " + str, e10);
        }
    }

    @NonNull
    static MediaCodecInfo g(@NonNull l lVar) throws InvalidConfigException {
        MediaCodec a10 = new b().a(lVar.a());
        MediaCodecInfo codecInfo = a10.getCodecInfo();
        a10.release();
        return codecInfo;
    }
}

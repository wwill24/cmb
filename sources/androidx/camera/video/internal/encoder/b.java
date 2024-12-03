package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import androidx.annotation.NonNull;
import java.util.Objects;

public class b extends a1 {

    /* renamed from: c  reason: collision with root package name */
    private final MediaCodecInfo.AudioCapabilities f3255c;

    b(@NonNull MediaCodecInfo mediaCodecInfo, @NonNull String str) throws InvalidConfigException {
        super(mediaCodecInfo, str);
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.f3254b.getAudioCapabilities();
        Objects.requireNonNull(audioCapabilities);
        MediaCodecInfo.AudioCapabilities audioCapabilities2 = audioCapabilities;
        this.f3255c = audioCapabilities;
    }
}

package e0;

import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.annotation.NonNull;

public final class e {
    @NonNull
    public static Range<Integer> a(@NonNull MediaCodecInfo.EncoderCapabilities encoderCapabilities) {
        return encoderCapabilities.getQualityRange();
    }
}

package e0;

import android.content.Context;
import android.media.AudioRecord;
import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.annotation.NonNull;

public final class m {
    @NonNull
    public static Range<Integer>[] a(@NonNull MediaCodecInfo.AudioCapabilities audioCapabilities) {
        return audioCapabilities.getInputChannelCountRanges();
    }

    public static int b(@NonNull MediaCodecInfo.AudioCapabilities audioCapabilities) {
        return audioCapabilities.getMinInputChannelCount();
    }

    public static void c(@NonNull AudioRecord.Builder builder, @NonNull Context context) {
        AudioRecord.Builder unused = builder.setContext(context);
    }
}

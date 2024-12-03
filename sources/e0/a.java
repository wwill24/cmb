package e0;

import android.media.AudioFormat;
import android.media.AudioRecord;
import androidx.annotation.NonNull;

public final class a {
    @NonNull
    public static AudioRecord a(@NonNull AudioRecord.Builder builder) {
        return builder.build();
    }

    @NonNull
    public static AudioRecord.Builder b() {
        return new AudioRecord.Builder();
    }

    public static void c(@NonNull AudioRecord.Builder builder, @NonNull AudioFormat audioFormat) {
        builder.setAudioFormat(audioFormat);
    }

    public static void d(@NonNull AudioRecord.Builder builder, int i10) {
        builder.setAudioSource(i10);
    }

    public static void e(@NonNull AudioRecord.Builder builder, int i10) {
        builder.setBufferSizeInBytes(i10);
    }
}

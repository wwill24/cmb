package e0;

import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;
import androidx.annotation.NonNull;

public final class b {
    public static int a(@NonNull AudioRecordingConfiguration audioRecordingConfiguration) {
        return audioRecordingConfiguration.getClientAudioSessionId();
    }

    public static int b(@NonNull AudioRecord audioRecord, @NonNull AudioTimestamp audioTimestamp, int i10) {
        return audioRecord.getTimestamp(audioTimestamp, i10);
    }
}

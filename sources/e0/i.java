package e0;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

public final class i {
    public static boolean a(@NonNull AudioRecordingConfiguration audioRecordingConfiguration) {
        return audioRecordingConfiguration.isClientSilenced();
    }

    public static void b(@NonNull AudioRecord audioRecord, @NonNull Executor executor, @NonNull AudioManager.AudioRecordingCallback audioRecordingCallback) {
        audioRecord.registerAudioRecordingCallback(executor, audioRecordingCallback);
    }

    public static void c(@NonNull AudioRecord audioRecord, @NonNull AudioManager.AudioRecordingCallback audioRecordingCallback) {
        audioRecord.unregisterAudioRecordingCallback(audioRecordingCallback);
    }
}

package e0;

import android.media.MediaMuxer;
import androidx.annotation.NonNull;
import java.io.FileDescriptor;
import java.io.IOException;

public final class c {
    @NonNull
    public static MediaMuxer a(@NonNull FileDescriptor fileDescriptor, int i10) throws IOException {
        return new MediaMuxer(fileDescriptor, i10);
    }
}

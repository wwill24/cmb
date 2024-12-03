package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

public interface g extends AutoCloseable {
    @NonNull
    MediaCodec.BufferInfo W();

    void close();

    boolean d0();

    @NonNull
    ByteBuffer q();

    long size();

    long z0();
}

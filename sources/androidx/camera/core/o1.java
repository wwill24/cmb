package androidx.camera.core;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.media.Image;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

public interface o1 extends AutoCloseable {

    public interface a {
        @NonNull
        ByteBuffer d();

        int e();

        int f();
    }

    @SuppressLint({"ArrayReturn"})
    @NonNull
    a[] M0();

    @NonNull
    Rect X0();

    void close();

    int getFormat();

    int getHeight();

    int getWidth();

    void p0(Rect rect);

    Image t();

    @NonNull
    l1 z1();
}

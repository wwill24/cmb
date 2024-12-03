package p3;

import android.util.Log;
import androidx.annotation.NonNull;
import i3.a;
import i3.e;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class c implements a<ByteBuffer> {
    /* renamed from: c */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull e eVar) {
        try {
            f4.a.e(byteBuffer, file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("ByteBufferEncoder", 3);
            return false;
        }
    }
}

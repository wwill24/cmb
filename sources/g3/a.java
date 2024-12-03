package g3;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

public interface a {

    /* renamed from: g3.a$a  reason: collision with other inner class name */
    public interface C0161a {
        @NonNull
        byte[] a(int i10);

        @NonNull
        Bitmap b(int i10, int i11, @NonNull Bitmap.Config config);

        @NonNull
        int[] c(int i10);

        void d(@NonNull Bitmap bitmap);

        void e(@NonNull byte[] bArr);

        void f(@NonNull int[] iArr);
    }

    Bitmap a();

    void b();

    int c();

    void clear();

    void d(@NonNull Bitmap.Config config);

    int e();

    void f();

    int g();

    @NonNull
    ByteBuffer getData();

    int h();
}

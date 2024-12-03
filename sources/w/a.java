package w;

import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.NonNull;

public final class a {
    public static void a(@NonNull ImageWriter imageWriter) {
        b.a(imageWriter);
    }

    @NonNull
    public static Image b(@NonNull ImageWriter imageWriter) {
        return b.b(imageWriter);
    }

    @NonNull
    public static ImageWriter c(@NonNull Surface surface, int i10) {
        return b.c(surface, i10);
    }

    @NonNull
    public static ImageWriter d(@NonNull Surface surface, int i10, int i11) {
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 29) {
            return e.a(surface, i10, i11);
        }
        if (i12 >= 26) {
            return c.a(surface, i10, i11);
        }
        throw new RuntimeException("Unable to call newInstance(Surface, int, int) on API " + i12 + ". Version 26 or higher required.");
    }

    public static void e(@NonNull ImageWriter imageWriter, @NonNull Image image) {
        b.d(imageWriter, image);
    }
}

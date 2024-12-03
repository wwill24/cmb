package w;

import android.media.Image;
import android.media.ImageWriter;
import android.view.Surface;
import androidx.annotation.NonNull;

final class b {
    static void a(ImageWriter imageWriter) {
        imageWriter.close();
    }

    @NonNull
    static Image b(@NonNull ImageWriter imageWriter) {
        return imageWriter.dequeueInputImage();
    }

    @NonNull
    static ImageWriter c(@NonNull Surface surface, int i10) {
        return ImageWriter.newInstance(surface, i10);
    }

    static void d(@NonNull ImageWriter imageWriter, @NonNull Image image) {
        imageWriter.queueInputImage(image);
    }
}

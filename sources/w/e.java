package w;

import android.media.ImageWriter;
import android.view.Surface;
import androidx.annotation.NonNull;

final class e {
    @NonNull
    static ImageWriter a(@NonNull Surface surface, int i10, int i11) {
        return ImageWriter.newInstance(surface, i10, i11);
    }
}

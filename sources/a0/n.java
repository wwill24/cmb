package a0;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;

public interface n<I, O> {
    @NonNull
    O apply(@NonNull I i10) throws ImageCaptureException;
}

package s3;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.a;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import m3.b;

public final class n implements ImageHeaderParser {
    public int a(@NonNull InputStream inputStream, @NonNull b bVar) throws IOException {
        int i10 = new a(inputStream).i("Orientation", 1);
        if (i10 == 0) {
            return -1;
        }
        return i10;
    }

    @NonNull
    public ImageHeaderParser.ImageType b(@NonNull ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @NonNull
    public ImageHeaderParser.ImageType c(@NonNull InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}

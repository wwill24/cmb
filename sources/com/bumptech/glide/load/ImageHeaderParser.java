package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import m3.b;

public interface ImageHeaderParser {

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        
        private final boolean hasAlpha;

        private ImageType(boolean z10) {
            this.hasAlpha = z10;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    int a(@NonNull InputStream inputStream, @NonNull b bVar) throws IOException;

    @NonNull
    ImageType b(@NonNull ByteBuffer byteBuffer) throws IOException;

    @NonNull
    ImageType c(@NonNull InputStream inputStream) throws IOException;
}

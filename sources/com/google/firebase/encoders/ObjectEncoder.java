package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import java.io.IOException;

public interface ObjectEncoder<T> extends Encoder<T, ObjectEncoderContext> {
    /* synthetic */ void encode(@NonNull Object obj, @NonNull Object obj2) throws IOException;
}

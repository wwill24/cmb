package androidx.camera.core.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.r;
import java.util.Set;

public interface w {

    public interface a {
        @NonNull
        w a(@NonNull Context context, @NonNull b0 b0Var, r rVar) throws InitializationException;
    }

    @NonNull
    CameraInternal a(@NonNull String str) throws CameraUnavailableException;

    @NonNull
    Set<String> b();

    Object c();
}

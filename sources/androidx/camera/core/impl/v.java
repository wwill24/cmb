package androidx.camera.core.impl;

import android.content.Context;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.InitializationException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface v {

    public interface a {
        @NonNull
        v a(@NonNull Context context, Object obj, @NonNull Set<String> set) throws InitializationException;
    }

    SurfaceConfig a(@NonNull String str, int i10, @NonNull Size size);

    @NonNull
    Map<f2<?>, Size> b(@NonNull String str, @NonNull List<a> list, @NonNull List<f2<?>> list2);
}

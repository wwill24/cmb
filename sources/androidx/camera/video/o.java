package androidx.camera.video;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.util.h;

public abstract class o {
    @NonNull
    static o b(@NonNull Uri uri) {
        h.h(uri, "OutputUri cannot be null.");
        return new g(uri);
    }

    @NonNull
    public abstract Uri a();
}

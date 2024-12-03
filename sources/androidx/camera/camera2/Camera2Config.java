package androidx.camera.camera2;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.b1;
import androidx.camera.camera2.internal.e1;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.v;
import java.util.Set;
import m.a;
import m.b;
import m.c;

public final class Camera2Config {

    public static final class DefaultProvider implements v.b {
        @NonNull
        public v getCameraXConfig() {
            return Camera2Config.c();
        }
    }

    @NonNull
    public static v c() {
        a aVar = new a();
        b bVar = new b();
        return new v.a().c(aVar).d(bVar).g(new c()).a();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ androidx.camera.core.impl.v d(Context context, Object obj, Set set) throws InitializationException {
        try {
            return new b1(context, obj, set);
        } catch (CameraUnavailableException e10) {
            throw new InitializationException(e10);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ UseCaseConfigFactory e(Context context) throws InitializationException {
        return new e1(context);
    }
}

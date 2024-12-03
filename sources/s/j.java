package s;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.camera.core.e0;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.h1;
import androidx.camera.core.impl.i1;
import androidx.camera.core.impl.n1;
import androidx.camera.core.impl.s1;

public class j implements s1 {
    private final Config A;

    public static final class a implements e0<j> {

        /* renamed from: a  reason: collision with root package name */
        private final i1 f17438a = i1.O();

        @NonNull
        public static a e(@NonNull Config config) {
            a aVar = new a();
            config.c("camera2.captureRequest.option.", new i(aVar, config));
            return aVar;
        }

        @NonNull
        public h1 a() {
            return this.f17438a;
        }

        @NonNull
        public j d() {
            return new j(n1.M(this.f17438a));
        }

        @NonNull
        public <ValueT> a g(@NonNull CaptureRequest.Key<ValueT> key, @NonNull ValueT valuet) {
            this.f17438a.p(n.a.K(key), valuet);
            return this;
        }
    }

    public j(@NonNull Config config) {
        this.A = config;
    }

    @NonNull
    public Config getConfig() {
        return this.A;
    }
}

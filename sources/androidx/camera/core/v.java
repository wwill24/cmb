package androidx.camera.core;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.h1;
import androidx.camera.core.impl.i1;
import androidx.camera.core.impl.n1;
import androidx.camera.core.impl.v;
import androidx.camera.core.impl.w;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.apache.commons.cli.HelpFormatter;
import v.h;

public final class v implements h<CameraX> {
    static final Config.a<w.a> B = Config.a.a("camerax.core.appConfig.cameraFactoryProvider", w.a.class);
    static final Config.a<v.a> C = Config.a.a("camerax.core.appConfig.deviceSurfaceManagerProvider", v.a.class);
    static final Config.a<UseCaseConfigFactory.b> D = Config.a.a("camerax.core.appConfig.useCaseConfigFactoryProvider", UseCaseConfigFactory.b.class);
    static final Config.a<Executor> E = Config.a.a("camerax.core.appConfig.cameraExecutor", Executor.class);
    static final Config.a<Handler> F = Config.a.a("camerax.core.appConfig.schedulerHandler", Handler.class);
    static final Config.a<Integer> G = Config.a.a("camerax.core.appConfig.minimumLoggingLevel", Integer.TYPE);
    static final Config.a<r> H = Config.a.a("camerax.core.appConfig.availableCamerasLimiter", r.class);
    private final n1 A;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final i1 f2924a;

        public a() {
            this(i1.O());
        }

        @NonNull
        private h1 b() {
            return this.f2924a;
        }

        @NonNull
        public v a() {
            return new v(n1.M(this.f2924a));
        }

        @NonNull
        public a c(@NonNull w.a aVar) {
            b().p(v.B, aVar);
            return this;
        }

        @NonNull
        public a d(@NonNull v.a aVar) {
            b().p(v.C, aVar);
            return this;
        }

        @NonNull
        public a e(@NonNull Class<CameraX> cls) {
            b().p(h.f18039x, cls);
            if (b().g(h.f18038w, null) == null) {
                f(cls.getCanonicalName() + HelpFormatter.DEFAULT_OPT_PREFIX + UUID.randomUUID());
            }
            return this;
        }

        @NonNull
        public a f(@NonNull String str) {
            b().p(h.f18038w, str);
            return this;
        }

        @NonNull
        public a g(@NonNull UseCaseConfigFactory.b bVar) {
            b().p(v.D, bVar);
            return this;
        }

        private a(i1 i1Var) {
            Class<CameraX> cls = CameraX.class;
            this.f2924a = i1Var;
            Class cls2 = (Class) i1Var.g(h.f18039x, null);
            if (cls2 == null || cls2.equals(cls)) {
                e(cls);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls2);
        }
    }

    public interface b {
        @NonNull
        v getCameraXConfig();
    }

    v(n1 n1Var) {
        this.A = n1Var;
    }

    public r K(r rVar) {
        return (r) this.A.g(H, rVar);
    }

    public Executor L(Executor executor) {
        return (Executor) this.A.g(E, executor);
    }

    public w.a M(w.a aVar) {
        return (w.a) this.A.g(B, aVar);
    }

    public v.a N(v.a aVar) {
        return (v.a) this.A.g(C, aVar);
    }

    public Handler O(Handler handler) {
        return (Handler) this.A.g(F, handler);
    }

    public UseCaseConfigFactory.b P(UseCaseConfigFactory.b bVar) {
        return (UseCaseConfigFactory.b) this.A.g(D, bVar);
    }

    @NonNull
    public Config getConfig() {
        return this.A;
    }
}

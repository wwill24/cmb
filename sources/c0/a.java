package c0;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.f2;
import androidx.camera.core.impl.n1;
import androidx.camera.core.impl.v0;
import androidx.camera.video.VideoOutput;
import androidx.camera.video.g0;
import androidx.camera.video.internal.encoder.h1;
import androidx.camera.video.internal.encoder.i1;
import java.util.Objects;
import v.i;

public final class a<T extends VideoOutput> implements f2<g0<T>>, v0, i {
    public static final Config.a<VideoOutput> B = Config.a.a("camerax.video.VideoCapture.videoOutput", VideoOutput.class);
    public static final Config.a<k.a<h1, i1>> C = Config.a.a("camerax.video.VideoCapture.videoEncoderInfoFinder", k.a.class);
    private final n1 A;

    public a(@NonNull n1 n1Var) {
        this.A = n1Var;
    }

    @NonNull
    public k.a<h1, i1> K() {
        k.a<h1, i1> aVar = (k.a) a(C);
        Objects.requireNonNull(aVar);
        return aVar;
    }

    @NonNull
    public T L() {
        return (VideoOutput) a(B);
    }

    @NonNull
    public Config getConfig() {
        return this.A;
    }

    public int l() {
        return 34;
    }
}

package v;

import androidx.camera.core.UseCase;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.s1;

public interface j extends s1 {

    /* renamed from: z  reason: collision with root package name */
    public static final Config.a<UseCase.b> f18041z = Config.a.a("camerax.core.useCaseEventCallback", UseCase.b.class);

    UseCase.b H(UseCase.b bVar) {
        return (UseCase.b) g(f18041z, bVar);
    }
}

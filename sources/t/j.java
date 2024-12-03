package t;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.utils.p;
import java.util.List;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final List<d0> f17582a;

    /* renamed from: b  reason: collision with root package name */
    private final h0 f17583b;

    public j(@NonNull List<d0> list, @NonNull h0 h0Var) {
        this.f17582a = list;
        this.f17583b = h0Var;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<d0> a() {
        return this.f17582a;
    }

    /* access modifiers changed from: package-private */
    public void b(@NonNull ImageCaptureException imageCaptureException) {
        p.a();
        this.f17583b.d(imageCaptureException);
    }
}

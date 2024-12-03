package y;

import android.media.MediaCodec;
import androidx.annotation.NonNull;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.f2;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import java.util.Collections;
import java.util.List;
import x.a;
import x.f;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f18581a;

    public c() {
        boolean z10;
        if (a.a(f.class) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f18581a = z10;
    }

    private int b(@NonNull DeferrableSurface deferrableSurface) {
        if (deferrableSurface.e() == MediaCodec.class || deferrableSurface.e() == VideoCapture.class) {
            return 2;
        }
        if (deferrableSurface.e() == f2.class) {
            return 0;
        }
        return 1;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ int c(SessionConfig.e eVar, SessionConfig.e eVar2) {
        return b(eVar.d()) - b(eVar2.d());
    }

    public void d(@NonNull List<SessionConfig.e> list) {
        if (this.f18581a) {
            Collections.sort(list, new b(this));
        }
    }
}

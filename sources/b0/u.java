package b0;

import android.util.Size;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.video.g0;
import c0.a;

public final /* synthetic */ class u implements SessionConfig.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g0 f7712a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f7713b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f7714c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Size f7715d;

    public /* synthetic */ u(g0 g0Var, String str, a aVar, Size size) {
        this.f7712a = g0Var;
        this.f7713b = str;
        this.f7714c = aVar;
        this.f7715d = size;
    }

    public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f7712a.q0(this.f7713b, this.f7714c, this.f7715d, sessionConfig, sessionError);
    }
}

package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.r0;

public final /* synthetic */ class j0 implements SessionConfig.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l0 f2742a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2743b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ r0 f2744c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Size f2745d;

    public /* synthetic */ j0(l0 l0Var, String str, r0 r0Var, Size size) {
        this.f2742a = l0Var;
        this.f2743b = str;
        this.f2744c = r0Var;
        this.f2745d = size;
    }

    public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f2742a.X(this.f2743b, this.f2744c, this.f2745d, sessionConfig, sessionError);
    }
}

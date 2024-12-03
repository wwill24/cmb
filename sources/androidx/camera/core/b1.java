package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.s0;

public final /* synthetic */ class b1 implements SessionConfig.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h1 f2180a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2181b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ s0 f2182c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Size f2183d;

    public /* synthetic */ b1(h1 h1Var, String str, s0 s0Var, Size size) {
        this.f2180a = h1Var;
        this.f2181b = str;
        this.f2182c = s0Var;
        this.f2183d = size;
    }

    public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f2180a.s0(this.f2181b, this.f2182c, this.f2183d, sessionConfig, sessionError);
    }
}

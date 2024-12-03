package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.p1;

public final /* synthetic */ class e2 implements SessionConfig.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f2 f2223a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f2224b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ p1 f2225c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Size f2226d;

    public /* synthetic */ e2(f2 f2Var, String str, p1 p1Var, Size size) {
        this.f2223a = f2Var;
        this.f2224b = str;
        this.f2225c = p1Var;
        this.f2226d = size;
    }

    public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f2223a.S(this.f2224b, this.f2225c, this.f2226d, sessionConfig, sessionError);
    }
}

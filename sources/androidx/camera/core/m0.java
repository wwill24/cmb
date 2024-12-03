package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.l0;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

public final /* synthetic */ class m0 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o0 f2808a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f2809b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ o1 f2810c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Matrix f2811d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ o1 f2812e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Rect f2813f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ l0.a f2814g;

    public /* synthetic */ m0(o0 o0Var, Executor executor, o1 o1Var, Matrix matrix, o1 o1Var2, Rect rect, l0.a aVar) {
        this.f2808a = o0Var;
        this.f2809b = executor;
        this.f2810c = o1Var;
        this.f2811d = matrix;
        this.f2812e = o1Var2;
        this.f2813f = rect;
        this.f2814g = aVar;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f2808a.n(this.f2809b, this.f2810c, this.f2811d, this.f2812e, this.f2813f, this.f2814g, aVar);
    }
}

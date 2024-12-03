package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.l0;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class n0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o0 f2818a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o1 f2819b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Matrix f2820c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ o1 f2821d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Rect f2822e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ l0.a f2823f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f2824g;

    public /* synthetic */ n0(o0 o0Var, o1 o1Var, Matrix matrix, o1 o1Var2, Rect rect, l0.a aVar, CallbackToFutureAdapter.a aVar2) {
        this.f2818a = o0Var;
        this.f2819b = o1Var;
        this.f2820c = matrix;
        this.f2821d = o1Var2;
        this.f2822e = rect;
        this.f2823f = aVar;
        this.f2824g = aVar2;
    }

    public final void run() {
        this.f2818a.m(this.f2819b, this.f2820c, this.f2821d, this.f2822e, this.f2823f, this.f2824g);
    }
}

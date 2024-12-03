package com.withpersona.sdk2.camera;

import android.view.View;
import com.withpersona.sdk2.camera.n;
import gk.g;
import java.io.File;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.a;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.r;
import kotlinx.coroutines.flow.s;

public final class t implements g {

    /* renamed from: a  reason: collision with root package name */
    private final View f14376a;

    public t(View view) {
        j.g(view, "previewView");
        this.f14376a = view;
    }

    public void a(boolean z10) {
    }

    public Object b(c<? super Boolean> cVar) {
        return a.a(false);
    }

    public r<n> c() {
        return s.a(n.c.f14369a);
    }

    public View d() {
        return this.f14376a;
    }

    public void e() {
    }

    public void f(boolean z10) {
    }

    public Object g(c<? super Result<? extends File>> cVar) {
        Result.a aVar = Result.f32010a;
        return Result.b(g.a(new NoSuitableCameraError()));
    }

    public Object h(c<? super Result<? extends File>> cVar) {
        Result.a aVar = Result.f32010a;
        return Result.b(g.a(new NoSuitableCameraError()));
    }

    public void prepare() {
    }
}

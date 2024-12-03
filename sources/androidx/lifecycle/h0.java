package androidx.lifecycle;

import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import gk.f;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import m1.a;
import wk.c;

public final class h0<VM extends f0> implements f<VM> {

    /* renamed from: a  reason: collision with root package name */
    private final c<VM> f6028a;

    /* renamed from: b  reason: collision with root package name */
    private final Function0<k0> f6029b;

    /* renamed from: c  reason: collision with root package name */
    private final Function0<i0.b> f6030c;

    /* renamed from: d  reason: collision with root package name */
    private final Function0<a> f6031d;

    /* renamed from: e  reason: collision with root package name */
    private VM f6032e;

    public h0(c<VM> cVar, Function0<? extends k0> function0, Function0<? extends i0.b> function02, Function0<? extends a> function03) {
        j.g(cVar, "viewModelClass");
        j.g(function0, "storeProducer");
        j.g(function02, "factoryProducer");
        j.g(function03, "extrasProducer");
        this.f6028a = cVar;
        this.f6029b = function0;
        this.f6030c = function02;
        this.f6031d = function03;
    }

    /* renamed from: a */
    public VM getValue() {
        VM vm2 = this.f6032e;
        if (vm2 != null) {
            return vm2;
        }
        VM a10 = new i0(this.f6029b.invoke(), this.f6030c.invoke(), this.f6031d.invoke()).a(ok.a.a(this.f6028a));
        this.f6032e = a10;
        return a10;
    }

    public boolean isInitialized() {
        return this.f6032e != null;
    }
}

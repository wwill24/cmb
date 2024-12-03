package v7;

import com.coffeemeetsbagel.models.interfaces.GiveTakeBase;
import v7.d;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u f18085a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d.c f18086b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ GiveTakeBase f18087c;

    public /* synthetic */ m(u uVar, d.c cVar, GiveTakeBase giveTakeBase) {
        this.f18085a = uVar;
        this.f18086b = cVar;
        this.f18087c = giveTakeBase;
    }

    public final void run() {
        this.f18085a.m0(this.f18086b, this.f18087c);
    }
}

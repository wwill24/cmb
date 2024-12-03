package androidx.camera.view;

import androidx.camera.core.q;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;

public final /* synthetic */ class d implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f3464a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q f3465b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f3466c;

    public /* synthetic */ d(e eVar, q qVar, List list) {
        this.f3464a = eVar;
        this.f3465b = qVar;
        this.f3466c = list;
    }

    public final Object a(CallbackToFutureAdapter.a aVar) {
        return this.f3464a.i(this.f3465b, this.f3466c, aVar);
    }
}

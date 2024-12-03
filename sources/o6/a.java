package o6;

import com.coffeemeetsbagel.discover_feed.ActionListenerEvent;
import com.coffeemeetsbagel.models.NetworkProfile;
import r6.d;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f16826a;

    /* renamed from: b  reason: collision with root package name */
    private NetworkProfile f16827b;

    /* renamed from: c  reason: collision with root package name */
    private d f16828c;

    /* renamed from: d  reason: collision with root package name */
    private final ActionListenerEvent f16829d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16830e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f16831f;

    public a(ActionListenerEvent actionListenerEvent, int i10, boolean z10, Integer num) {
        this.f16829d = actionListenerEvent;
        this.f16826a = i10;
        this.f16830e = z10;
        this.f16831f = num;
    }

    public ActionListenerEvent a() {
        return this.f16829d;
    }

    public Integer b() {
        return this.f16831f;
    }

    public int c() {
        return this.f16826a;
    }

    public NetworkProfile d() {
        return this.f16827b;
    }

    public boolean e() {
        return this.f16830e;
    }

    public void f(d dVar) {
        this.f16828c = dVar;
    }

    public void g(NetworkProfile networkProfile) {
        this.f16827b = networkProfile;
    }
}

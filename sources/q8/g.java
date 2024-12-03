package q8;

import com.coffeemeetsbagel.models.NetworkProfile;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f17200a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NetworkProfile f17201b;

    public /* synthetic */ g(l lVar, NetworkProfile networkProfile) {
        this.f17200a = lVar;
        this.f17201b = networkProfile;
    }

    public final void run() {
        this.f17200a.v(this.f17201b);
    }
}

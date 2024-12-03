package k7;

import com.coffeemeetsbagel.models.Bagel;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f15908a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f15909b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bagel f15910c;

    public /* synthetic */ l(s sVar, boolean z10, Bagel bagel) {
        this.f15908a = sVar;
        this.f15909b = z10;
        this.f15910c = bagel;
    }

    public final void run() {
        this.f15908a.N(this.f15909b, this.f15910c);
    }
}

package k7;

import com.coffeemeetsbagel.models.Bagel;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f15895a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f15896b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bagel f15897c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f15898d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Long f15899e;

    public /* synthetic */ h(s sVar, String str, Bagel bagel, a aVar, Long l10) {
        this.f15895a = sVar;
        this.f15896b = str;
        this.f15897c = bagel;
        this.f15898d = aVar;
        this.f15899e = l10;
    }

    public final void run() {
        this.f15895a.L(this.f15896b, this.f15897c, this.f15898d, this.f15899e);
    }
}

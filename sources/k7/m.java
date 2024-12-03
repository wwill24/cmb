package k7;

import com.coffeemeetsbagel.models.Bagel;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f15911a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bagel f15912b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CharSequence f15913c;

    public /* synthetic */ m(s sVar, Bagel bagel, CharSequence charSequence) {
        this.f15911a = sVar;
        this.f15912b = bagel;
        this.f15913c = charSequence;
    }

    public final void run() {
        this.f15911a.K(this.f15912b, this.f15913c);
    }
}

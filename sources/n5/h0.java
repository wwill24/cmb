package n5;

import android.view.View;
import com.coffeemeetsbagel.models.Price;

public final /* synthetic */ class h0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h1 f16481a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Price f16482b;

    public /* synthetic */ h0(h1 h1Var, Price price) {
        this.f16481a = h1Var;
        this.f16482b = price;
    }

    public final void onClick(View view) {
        this.f16481a.U2(this.f16482b, view);
    }
}

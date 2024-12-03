package fc;

import android.view.View;
import com.coffeemeetsbagel.today_view.card.no_bagel.NoBagelClickOption;
import com.coffeemeetsbagel.today_view.card.no_bagel.NoBagelComponentView;

public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NoBagelComponentView f40793a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NoBagelClickOption f40794b;

    public /* synthetic */ l(NoBagelComponentView noBagelComponentView, NoBagelClickOption noBagelClickOption) {
        this.f40793a = noBagelComponentView;
        this.f40794b = noBagelClickOption;
    }

    public final void onClick(View view) {
        NoBagelComponentView.D(this.f40793a, this.f40794b, view);
    }
}

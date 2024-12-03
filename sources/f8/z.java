package f8;

import android.view.View;
import com.coffeemeetsbagel.models.enums.Ethnicity;

public final /* synthetic */ class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b0 f14958a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ethnicity f14959b;

    public /* synthetic */ z(b0 b0Var, Ethnicity ethnicity) {
        this.f14958a = b0Var;
        this.f14959b = ethnicity;
    }

    public final void onClick(View view) {
        this.f14958a.Z0(this.f14959b, view);
    }
}

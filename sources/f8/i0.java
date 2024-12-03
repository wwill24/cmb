package f8;

import android.view.View;
import com.coffeemeetsbagel.models.enums.Religion;

public final /* synthetic */ class i0 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k0 f14902a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Religion f14903b;

    public /* synthetic */ i0(k0 k0Var, Religion religion) {
        this.f14902a = k0Var;
        this.f14903b = religion;
    }

    public final void onClick(View view) {
        this.f14902a.Z0(this.f14903b, view);
    }
}

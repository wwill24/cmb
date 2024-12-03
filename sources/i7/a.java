package i7;

import android.view.View;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.feature.bagelprofile.ProfileIdView;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileIdView f15510a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CmbTextView f15511b;

    public /* synthetic */ a(ProfileIdView profileIdView, CmbTextView cmbTextView) {
        this.f15510a = profileIdView;
        this.f15511b = cmbTextView;
    }

    public final void onClick(View view) {
        this.f15510a.c(this.f15511b, view);
    }
}

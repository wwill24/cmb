package q5;

import android.widget.CompoundButton;
import com.coffeemeetsbagel.cmb_views.CmbRadioGroup;

public final /* synthetic */ class d implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CmbRadioGroup f17168a;

    public /* synthetic */ d(CmbRadioGroup cmbRadioGroup) {
        this.f17168a = cmbRadioGroup;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        CmbRadioGroup.e(this.f17168a, compoundButton, z10);
    }
}

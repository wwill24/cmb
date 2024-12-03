package ef;

import android.widget.CompoundButton;
import com.google.android.material.chip.Chip;

public final /* synthetic */ class a implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Chip f23372a;

    public /* synthetic */ a(Chip chip) {
        this.f23372a = chip;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        this.f23372a.t(compoundButton, z10);
    }
}

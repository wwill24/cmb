package k6;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.coffeemeetsbagel.cmb_views.CmbTextView;

public abstract class q extends ViewDataBinding {
    @NonNull
    public final CmbTextView D;
    @NonNull
    public final CmbTextView E;
    protected String F;

    protected q(Object obj, View view, int i10, CmbTextView cmbTextView, CmbTextView cmbTextView2) {
        super(obj, view, i10);
        this.D = cmbTextView;
        this.E = cmbTextView2;
    }

    public abstract void G(String str);
}

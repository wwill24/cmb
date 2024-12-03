package k6;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.cmb_views.CmbTextView;

public abstract class o extends ViewDataBinding {
    @NonNull
    public final CmbTextView D;
    @NonNull
    public final CmbEditText E;
    protected String F;

    protected o(Object obj, View view, int i10, CmbTextView cmbTextView, CmbEditText cmbEditText) {
        super(obj, view, i10);
        this.D = cmbTextView;
        this.E = cmbEditText;
    }

    public abstract void G(String str);
}

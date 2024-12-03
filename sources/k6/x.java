package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z1.a;
import z1.b;

public final class x implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f15855a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbTextView f15856b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbTextView f15857c;

    private x(@NonNull LinearLayout linearLayout, @NonNull CmbTextView cmbTextView, @NonNull CmbTextView cmbTextView2) {
        this.f15855a = linearLayout;
        this.f15856b = cmbTextView;
        this.f15857c = cmbTextView2;
    }

    @NonNull
    public static x a(@NonNull View view) {
        int i10 = R.id.label;
        CmbTextView cmbTextView = (CmbTextView) b.a(view, R.id.label);
        if (cmbTextView != null) {
            i10 = R.id.value;
            CmbTextView cmbTextView2 = (CmbTextView) b.a(view, R.id.value);
            if (cmbTextView2 != null) {
                return new x((LinearLayout) view, cmbTextView, cmbTextView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static x c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.list_item_label_value_read_only, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f15855a;
    }
}

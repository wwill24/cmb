package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z1.a;
import z1.b;

public final class e0 implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f15733a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final View f15734b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f15735c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f15736d;

    private e0(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull ImageView imageView, @NonNull CmbTextView cmbTextView) {
        this.f15733a = constraintLayout;
        this.f15734b = view;
        this.f15735c = imageView;
        this.f15736d = cmbTextView;
    }

    @NonNull
    public static e0 a(@NonNull View view) {
        int i10 = R.id.item_separator;
        View a10 = b.a(view, R.id.item_separator);
        if (a10 != null) {
            i10 = R.id.reason_check;
            ImageView imageView = (ImageView) b.a(view, R.id.reason_check);
            if (imageView != null) {
                i10 = R.id.reason_text;
                CmbTextView cmbTextView = (CmbTextView) b.a(view, R.id.reason_text);
                if (cmbTextView != null) {
                    return new e0((ConstraintLayout) view, a10, imageView, cmbTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static e0 c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reason_view_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f15733a;
    }
}

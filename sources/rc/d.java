package rc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffemeetsbagel.hide_report.y;
import com.coffemeetsbagel.hide_report.z;
import z1.a;
import z1.b;

public final class d implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f41833a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final RadioButton f41834b;

    private d(@NonNull ConstraintLayout constraintLayout, @NonNull RadioButton radioButton) {
        this.f41833a = constraintLayout;
        this.f41834b = radioButton;
    }

    @NonNull
    public static d a(@NonNull View view) {
        int i10 = y.reason_list_item;
        RadioButton radioButton = (RadioButton) b.a(view, i10);
        if (radioButton != null) {
            return new d((ConstraintLayout) view, radioButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static d c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(z.reason_list_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f41833a;
    }
}

package aj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.withpersona.sdk2.inquiry.steps.ui.g;
import com.withpersona.sdk2.inquiry.steps.ui.h;
import z1.a;
import z1.b;

public final class m implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f24871a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final MaterialCheckBox f24872b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f24873c;

    private m(@NonNull ConstraintLayout constraintLayout, @NonNull MaterialCheckBox materialCheckBox, @NonNull TextView textView) {
        this.f24871a = constraintLayout;
        this.f24872b = materialCheckBox;
        this.f24873c = textView;
    }

    @NonNull
    public static m a(@NonNull View view) {
        int i10 = g.checkbox;
        MaterialCheckBox materialCheckBox = (MaterialCheckBox) b.a(view, i10);
        if (materialCheckBox != null) {
            i10 = g.textview_input_select_list_item_label;
            TextView textView = (TextView) b.a(view, i10);
            if (textView != null) {
                return new m((ConstraintLayout) view, materialCheckBox, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static m c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(h.pi2_ui_list_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f24871a;
    }
}

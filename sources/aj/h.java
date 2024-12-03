package aj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.checkbox.MaterialCheckBox;
import z1.a;

public final class h implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCheckBox f24859a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final MaterialCheckBox f24860b;

    private h(@NonNull MaterialCheckBox materialCheckBox, @NonNull MaterialCheckBox materialCheckBox2) {
        this.f24859a = materialCheckBox;
        this.f24860b = materialCheckBox2;
    }

    @NonNull
    public static h a(@NonNull View view) {
        if (view != null) {
            MaterialCheckBox materialCheckBox = (MaterialCheckBox) view;
            return new h(materialCheckBox, materialCheckBox);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static h c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static h d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(com.withpersona.sdk2.inquiry.steps.ui.h.pi2_ui_input_checkbox, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public MaterialCheckBox getRoot() {
        return this.f24859a;
    }
}

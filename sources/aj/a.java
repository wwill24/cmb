package aj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.withpersona.sdk2.inquiry.steps.ui.h;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialRadioButton f24829a;

    private a(@NonNull MaterialRadioButton materialRadioButton) {
        this.f24829a = materialRadioButton;
    }

    @NonNull
    public static a a(@NonNull View view) {
        if (view != null) {
            return new a((MaterialRadioButton) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static a d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(h.pi2_radio_button, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public MaterialRadioButton getRoot() {
        return this.f24829a;
    }
}

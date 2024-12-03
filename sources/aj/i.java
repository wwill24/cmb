package aj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.h;
import z1.a;

public final class i implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TextInputLayout f24861a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextInputLayout f24862b;

    private i(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        this.f24861a = textInputLayout;
        this.f24862b = textInputLayout2;
    }

    @NonNull
    public static i a(@NonNull View view) {
        if (view != null) {
            TextInputLayout textInputLayout = (TextInputLayout) view;
            return new i(textInputLayout, textInputLayout);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static i c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static i d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(h.pi2_ui_input_number, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public TextInputLayout getRoot() {
        return this.f24861a;
    }
}

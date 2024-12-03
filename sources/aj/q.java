package aj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.h;
import z1.a;

public final class q implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TextInputLayout f24880a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextInputLayout f24881b;

    private q(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        this.f24880a = textInputLayout;
        this.f24881b = textInputLayout2;
    }

    @NonNull
    public static q a(@NonNull View view) {
        if (view != null) {
            TextInputLayout textInputLayout = (TextInputLayout) view;
            return new q(textInputLayout, textInputLayout);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static q c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static q d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(h.pi2_ui_secure_text, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public TextInputLayout getRoot() {
        return this.f24880a;
    }
}

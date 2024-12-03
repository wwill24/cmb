package aj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.g;
import com.withpersona.sdk2.inquiry.steps.ui.h;
import z1.a;
import z1.b;

public final class n implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TextInputLayout f24874a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextInputLayout f24875b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final AutoCompleteTextView f24876c;

    private n(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull AutoCompleteTextView autoCompleteTextView) {
        this.f24874a = textInputLayout;
        this.f24875b = textInputLayout2;
        this.f24876c = autoCompleteTextView;
    }

    @NonNull
    public static n a(@NonNull View view) {
        TextInputLayout textInputLayout = (TextInputLayout) view;
        int i10 = g.textview_input_select;
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) b.a(view, i10);
        if (autoCompleteTextView != null) {
            return new n(textInputLayout, textInputLayout, autoCompleteTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static n c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static n d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(h.pi2_ui_list_select, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public TextInputLayout getRoot() {
        return this.f24874a;
    }
}

package aj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.g;
import com.withpersona.sdk2.inquiry.steps.ui.h;
import z1.a;
import z1.b;

public final class c implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f24835a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextInputLayout f24836b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextInputLayout f24837c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f24838d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f24839e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextInputLayout f24840f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextInputLayout f24841g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextInputLayout f24842h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final CircularProgressIndicator f24843j;

    private c(@NonNull ConstraintLayout constraintLayout, @NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout3, @NonNull TextInputLayout textInputLayout4, @NonNull TextInputLayout textInputLayout5, @NonNull CircularProgressIndicator circularProgressIndicator) {
        this.f24835a = constraintLayout;
        this.f24836b = textInputLayout;
        this.f24837c = textInputLayout2;
        this.f24838d = constraintLayout2;
        this.f24839e = textView;
        this.f24840f = textInputLayout3;
        this.f24841g = textInputLayout4;
        this.f24842h = textInputLayout5;
        this.f24843j = circularProgressIndicator;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i10 = g.address_city;
        TextInputLayout textInputLayout = (TextInputLayout) b.a(view, i10);
        if (textInputLayout != null) {
            i10 = g.address_field;
            TextInputLayout textInputLayout2 = (TextInputLayout) b.a(view, i10);
            if (textInputLayout2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i10 = g.address_label;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null) {
                    i10 = g.address_postal_code;
                    TextInputLayout textInputLayout3 = (TextInputLayout) b.a(view, i10);
                    if (textInputLayout3 != null) {
                        i10 = g.address_subdivision;
                        TextInputLayout textInputLayout4 = (TextInputLayout) b.a(view, i10);
                        if (textInputLayout4 != null) {
                            i10 = g.address_suite;
                            TextInputLayout textInputLayout5 = (TextInputLayout) b.a(view, i10);
                            if (textInputLayout5 != null) {
                                i10 = g.progress_indicator;
                                CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) b.a(view, i10);
                                if (circularProgressIndicator != null) {
                                    return new c(constraintLayout, textInputLayout, textInputLayout2, constraintLayout, textView, textInputLayout3, textInputLayout4, textInputLayout5, circularProgressIndicator);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static c c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static c d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(h.pi2_ui_address_field, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f24835a;
    }
}

package aj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.g;
import com.withpersona.sdk2.inquiry.steps.ui.h;
import z1.a;

public final class b implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f24830a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextInputLayout f24831b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextInputLayout f24832c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextInputLayout f24833d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextInputLayout f24834e;

    private b(@NonNull ConstraintLayout constraintLayout, @NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull TextInputLayout textInputLayout3, @NonNull TextInputLayout textInputLayout4) {
        this.f24830a = constraintLayout;
        this.f24831b = textInputLayout;
        this.f24832c = textInputLayout2;
        this.f24833d = textInputLayout3;
        this.f24834e = textInputLayout4;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i10 = g.first;
        TextInputLayout textInputLayout = (TextInputLayout) z1.b.a(view, i10);
        if (textInputLayout != null) {
            i10 = g.fourth;
            TextInputLayout textInputLayout2 = (TextInputLayout) z1.b.a(view, i10);
            if (textInputLayout2 != null) {
                i10 = g.second;
                TextInputLayout textInputLayout3 = (TextInputLayout) z1.b.a(view, i10);
                if (textInputLayout3 != null) {
                    i10 = g.third;
                    TextInputLayout textInputLayout4 = (TextInputLayout) z1.b.a(view, i10);
                    if (textInputLayout4 != null) {
                        return new b((ConstraintLayout) view, textInputLayout, textInputLayout2, textInputLayout3, textInputLayout4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static b c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static b d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(h.pi2_ui_2fa_auth, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f24830a;
    }
}

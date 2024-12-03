package aj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.withpersona.sdk2.inquiry.steps.ui.g;
import com.withpersona.sdk2.inquiry.steps.ui.h;
import z1.a;
import z1.b;

public final class e implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f24847a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextView f24848b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextInputLayout f24849c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f24850d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextInputLayout f24851e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextInputLayout f24852f;

    private e(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView2, @NonNull TextInputLayout textInputLayout2, @NonNull TextInputLayout textInputLayout3) {
        this.f24847a = constraintLayout;
        this.f24848b = textView;
        this.f24849c = textInputLayout;
        this.f24850d = textView2;
        this.f24851e = textInputLayout2;
        this.f24852f = textInputLayout3;
    }

    @NonNull
    public static e a(@NonNull View view) {
        int i10 = g.date_label;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = g.day;
            TextInputLayout textInputLayout = (TextInputLayout) b.a(view, i10);
            if (textInputLayout != null) {
                i10 = g.error_label;
                TextView textView2 = (TextView) b.a(view, i10);
                if (textView2 != null) {
                    i10 = g.month;
                    TextInputLayout textInputLayout2 = (TextInputLayout) b.a(view, i10);
                    if (textInputLayout2 != null) {
                        i10 = g.year;
                        TextInputLayout textInputLayout3 = (TextInputLayout) b.a(view, i10);
                        if (textInputLayout3 != null) {
                            return new e((ConstraintLayout) view, textView, textInputLayout, textView2, textInputLayout2, textInputLayout3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static e c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static e d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(h.pi2_ui_date_field, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f24847a;
    }
}

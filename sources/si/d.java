package si;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.withpersona.sdk2.inquiry.selfie.i;
import com.withpersona.sdk2.inquiry.selfie.j;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import z1.a;
import z1.b;

public final class d implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f33836a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ThemeableLottieAnimationView f33837b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f33838c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f33839d;

    private d(@NonNull ConstraintLayout constraintLayout, @NonNull ThemeableLottieAnimationView themeableLottieAnimationView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f33836a = constraintLayout;
        this.f33837b = themeableLottieAnimationView;
        this.f33838c = textView;
        this.f33839d = textView2;
    }

    @NonNull
    public static d a(@NonNull View view) {
        int i10 = i.pending_animation;
        ThemeableLottieAnimationView themeableLottieAnimationView = (ThemeableLottieAnimationView) b.a(view, i10);
        if (themeableLottieAnimationView != null) {
            i10 = i.textview_selfie_submitting_body;
            TextView textView = (TextView) b.a(view, i10);
            if (textView != null) {
                i10 = i.textview_selfie_submitting_title;
                TextView textView2 = (TextView) b.a(view, i10);
                if (textView2 != null) {
                    return new d((ConstraintLayout) view, themeableLottieAnimationView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static d c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(j.pi2_selfie_submitting_screen, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f33836a;
    }
}

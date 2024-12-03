package ki;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.withpersona.sdk2.inquiry.governmentid.l0;
import com.withpersona.sdk2.inquiry.governmentid.m0;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import z1.a;
import z1.b;

public final class g implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f31997a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ThemeableLottieAnimationView f31998b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f31999c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f32000d;

    private g(@NonNull ConstraintLayout constraintLayout, @NonNull ThemeableLottieAnimationView themeableLottieAnimationView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f31997a = constraintLayout;
        this.f31998b = themeableLottieAnimationView;
        this.f31999c = textView;
        this.f32000d = textView2;
    }

    @NonNull
    public static g a(@NonNull View view) {
        int i10 = l0.animationview_governmentid_pending;
        ThemeableLottieAnimationView themeableLottieAnimationView = (ThemeableLottieAnimationView) b.a(view, i10);
        if (themeableLottieAnimationView != null) {
            i10 = l0.textview_governmentid_pending_body;
            TextView textView = (TextView) b.a(view, i10);
            if (textView != null) {
                i10 = l0.textview_governmentid_pending_title;
                TextView textView2 = (TextView) b.a(view, i10);
                if (textView2 != null) {
                    return new g((ConstraintLayout) view, themeableLottieAnimationView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static g c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(m0.pi2_governmentid_submitting_screen, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f31997a;
    }
}

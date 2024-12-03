package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.new_user_experience.numberPickers.OnboardingPicker;
import z1.a;
import z1.b;

public final class j implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f15767a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final SwitchCompat f15768b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbTextView f15769c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final OnboardingPicker f15770d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f15771e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f15772f;

    private j(@NonNull ConstraintLayout constraintLayout, @NonNull SwitchCompat switchCompat, @NonNull CmbTextView cmbTextView, @NonNull OnboardingPicker onboardingPicker, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f15767a = constraintLayout;
        this.f15768b = switchCompat;
        this.f15769c = cmbTextView;
        this.f15770d = onboardingPicker;
        this.f15771e = textView;
        this.f15772f = textView2;
    }

    @NonNull
    public static j a(@NonNull View view) {
        int i10 = R.id.is_dealbreaker;
        SwitchCompat switchCompat = (SwitchCompat) b.a(view, R.id.is_dealbreaker);
        if (switchCompat != null) {
            i10 = R.id.message;
            CmbTextView cmbTextView = (CmbTextView) b.a(view, R.id.message);
            if (cmbTextView != null) {
                i10 = R.id.numberPicker;
                OnboardingPicker onboardingPicker = (OnboardingPicker) b.a(view, R.id.numberPicker);
                if (onboardingPicker != null) {
                    i10 = R.id.switch_label;
                    TextView textView = (TextView) b.a(view, R.id.switch_label);
                    if (textView != null) {
                        i10 = R.id.switch_title;
                        TextView textView2 = (TextView) b.a(view, R.id.switch_title);
                        if (textView2 != null) {
                            return new j((ConstraintLayout) view, switchCompat, cmbTextView, onboardingPicker, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static j c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.distance_match_preference, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f15767a;
    }
}

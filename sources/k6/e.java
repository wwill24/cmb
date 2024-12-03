package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.new_user_experience.numberPickers.OnboardingPicker;
import z1.a;
import z1.b;

public final class e implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f15724a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final OnboardingPicker f15725b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final OnboardingPicker f15726c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final Guideline f15727d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final SwitchCompat f15728e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CmbTextView f15729f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f15730g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f15731h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f15732j;

    private e(@NonNull ConstraintLayout constraintLayout, @NonNull OnboardingPicker onboardingPicker, @NonNull OnboardingPicker onboardingPicker2, @NonNull Guideline guideline, @NonNull SwitchCompat switchCompat, @NonNull CmbTextView cmbTextView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f15724a = constraintLayout;
        this.f15725b = onboardingPicker;
        this.f15726c = onboardingPicker2;
        this.f15727d = guideline;
        this.f15728e = switchCompat;
        this.f15729f = cmbTextView;
        this.f15730g = textView;
        this.f15731h = textView2;
        this.f15732j = textView3;
    }

    @NonNull
    public static e a(@NonNull View view) {
        int i10 = R.id.age_high;
        OnboardingPicker onboardingPicker = (OnboardingPicker) b.a(view, R.id.age_high);
        if (onboardingPicker != null) {
            i10 = R.id.age_low;
            OnboardingPicker onboardingPicker2 = (OnboardingPicker) b.a(view, R.id.age_low);
            if (onboardingPicker2 != null) {
                i10 = R.id.guideline;
                Guideline guideline = (Guideline) b.a(view, R.id.guideline);
                if (guideline != null) {
                    i10 = R.id.is_dealbreaker;
                    SwitchCompat switchCompat = (SwitchCompat) b.a(view, R.id.is_dealbreaker);
                    if (switchCompat != null) {
                        i10 = R.id.message;
                        CmbTextView cmbTextView = (CmbTextView) b.a(view, R.id.message);
                        if (cmbTextView != null) {
                            i10 = R.id.switch_label;
                            TextView textView = (TextView) b.a(view, R.id.switch_label);
                            if (textView != null) {
                                i10 = R.id.switch_title;
                                TextView textView2 = (TextView) b.a(view, R.id.switch_title);
                                if (textView2 != null) {
                                    i10 = R.id.to;
                                    TextView textView3 = (TextView) b.a(view, R.id.to);
                                    if (textView3 != null) {
                                        return new e((ConstraintLayout) view, onboardingPicker, onboardingPicker2, guideline, switchCompat, cmbTextView, textView, textView2, textView3);
                                    }
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
    public static e c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.age_match_preference, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f15724a;
    }
}

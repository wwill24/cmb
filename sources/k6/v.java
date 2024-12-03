package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import com.appyvet.rangebar.RangeBar;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z1.a;
import z1.b;

public final class v implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f15822a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbTextView f15823b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbTextView f15824c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f15825d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f15826e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ViewStub f15827f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final CmbTextView f15828g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final CmbTextView f15829h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final CmbTextView f15830j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final CmbTextView f15831k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final CmbTextView f15832l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final RangeBar f15833m;
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    public final RangeBar f15834n;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    public final RangeBar f15835p;
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    public final ScrollView f15836q;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    public final CmbTextView f15837t;
    @NonNull

    /* renamed from: w  reason: collision with root package name */
    public final CmbTextView f15838w;
    @NonNull

    /* renamed from: x  reason: collision with root package name */
    public final CmbTextView f15839x;

    private v(@NonNull ScrollView scrollView, @NonNull CmbTextView cmbTextView, @NonNull CmbTextView cmbTextView2, @NonNull CmbTextView cmbTextView3, @NonNull LinearLayout linearLayout, @NonNull ViewStub viewStub, @NonNull CmbTextView cmbTextView4, @NonNull CmbTextView cmbTextView5, @NonNull CmbTextView cmbTextView6, @NonNull CmbTextView cmbTextView7, @NonNull CmbTextView cmbTextView8, @NonNull RangeBar rangeBar, @NonNull RangeBar rangeBar2, @NonNull RangeBar rangeBar3, @NonNull ScrollView scrollView2, @NonNull CmbTextView cmbTextView9, @NonNull CmbTextView cmbTextView10, @NonNull CmbTextView cmbTextView11) {
        this.f15822a = scrollView;
        this.f15823b = cmbTextView;
        this.f15824c = cmbTextView2;
        this.f15825d = cmbTextView3;
        this.f15826e = linearLayout;
        this.f15827f = viewStub;
        this.f15828g = cmbTextView4;
        this.f15829h = cmbTextView5;
        this.f15830j = cmbTextView6;
        this.f15831k = cmbTextView7;
        this.f15832l = cmbTextView8;
        this.f15833m = rangeBar;
        this.f15834n = rangeBar2;
        this.f15835p = rangeBar3;
        this.f15836q = scrollView2;
        this.f15837t = cmbTextView9;
        this.f15838w = cmbTextView10;
        this.f15839x = cmbTextView11;
    }

    @NonNull
    public static v a(@NonNull View view) {
        View view2 = view;
        int i10 = R.id.customTextView_my_profile_preference_agerange_value;
        CmbTextView cmbTextView = (CmbTextView) b.a(view2, R.id.customTextView_my_profile_preference_agerange_value);
        if (cmbTextView != null) {
            i10 = R.id.customTextView_my_profile_preference_matchradius_value;
            CmbTextView cmbTextView2 = (CmbTextView) b.a(view2, R.id.customTextView_my_profile_preference_matchradius_value);
            if (cmbTextView2 != null) {
                i10 = R.id.fragment_my_profile_prefs_disclaimer_textview;
                CmbTextView cmbTextView3 = (CmbTextView) b.a(view2, R.id.fragment_my_profile_prefs_disclaimer_textview);
                if (cmbTextView3 != null) {
                    i10 = R.id.linearLayout_my_profile_preference_container;
                    LinearLayout linearLayout = (LinearLayout) b.a(view2, R.id.linearLayout_my_profile_preference_container);
                    if (linearLayout != null) {
                        i10 = R.id.match_prefs_container;
                        ViewStub viewStub = (ViewStub) b.a(view2, R.id.match_prefs_container);
                        if (viewStub != null) {
                            i10 = R.id.my_profile_preference_both;
                            CmbTextView cmbTextView4 = (CmbTextView) b.a(view2, R.id.my_profile_preference_both);
                            if (cmbTextView4 != null) {
                                i10 = R.id.my_profile_preference_men;
                                CmbTextView cmbTextView5 = (CmbTextView) b.a(view2, R.id.my_profile_preference_men);
                                if (cmbTextView5 != null) {
                                    i10 = R.id.my_profile_preference_women;
                                    CmbTextView cmbTextView6 = (CmbTextView) b.a(view2, R.id.my_profile_preference_women);
                                    if (cmbTextView6 != null) {
                                        i10 = R.id.onboarding_prompt;
                                        CmbTextView cmbTextView7 = (CmbTextView) b.a(view2, R.id.onboarding_prompt);
                                        if (cmbTextView7 != null) {
                                            i10 = R.id.onboarding_title;
                                            CmbTextView cmbTextView8 = (CmbTextView) b.a(view2, R.id.onboarding_title);
                                            if (cmbTextView8 != null) {
                                                i10 = R.id.rangebar_age;
                                                RangeBar rangeBar = (RangeBar) b.a(view2, R.id.rangebar_age);
                                                if (rangeBar != null) {
                                                    i10 = R.id.rangebar_distance;
                                                    RangeBar rangeBar2 = (RangeBar) b.a(view2, R.id.rangebar_distance);
                                                    if (rangeBar2 != null) {
                                                        i10 = R.id.rangebar_height;
                                                        RangeBar rangeBar3 = (RangeBar) b.a(view2, R.id.rangebar_height);
                                                        if (rangeBar3 != null) {
                                                            ScrollView scrollView = (ScrollView) view2;
                                                            i10 = R.id.textView_ethnicity;
                                                            CmbTextView cmbTextView9 = (CmbTextView) b.a(view2, R.id.textView_ethnicity);
                                                            if (cmbTextView9 != null) {
                                                                i10 = R.id.textView_height_value;
                                                                CmbTextView cmbTextView10 = (CmbTextView) b.a(view2, R.id.textView_height_value);
                                                                if (cmbTextView10 != null) {
                                                                    i10 = R.id.textView_religion;
                                                                    CmbTextView cmbTextView11 = (CmbTextView) b.a(view2, R.id.textView_religion);
                                                                    if (cmbTextView11 != null) {
                                                                        return new v(scrollView, cmbTextView, cmbTextView2, cmbTextView3, linearLayout, viewStub, cmbTextView4, cmbTextView5, cmbTextView6, cmbTextView7, cmbTextView8, rangeBar, rangeBar2, rangeBar3, scrollView, cmbTextView9, cmbTextView10, cmbTextView11);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
    public static v c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_my_profile_preference_dls, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ScrollView getRoot() {
        return this.f15822a;
    }
}

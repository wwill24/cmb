package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.new_user_experience.numberPickers.FeetHeightPicker;
import com.coffeemeetsbagel.new_user_experience.numberPickers.InchesHeightPicker;
import z1.a;
import z1.b;

public final class y implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f15858a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f15859b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final SwitchCompat f15860c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f15861d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final FeetHeightPicker f15862e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final FeetHeightPicker f15863f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final InchesHeightPicker f15864g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final InchesHeightPicker f15865h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f15866j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f15867k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f15868l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final LinearLayout f15869m;
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    public final CmbTextView f15870n;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    public final CmbTextView f15871p;
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    public final CmbTextView f15872q;

    private y(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull SwitchCompat switchCompat, @NonNull CmbTextView cmbTextView, @NonNull FeetHeightPicker feetHeightPicker, @NonNull FeetHeightPicker feetHeightPicker2, @NonNull InchesHeightPicker inchesHeightPicker, @NonNull InchesHeightPicker inchesHeightPicker2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout2, @NonNull CmbTextView cmbTextView2, @NonNull CmbTextView cmbTextView3, @NonNull CmbTextView cmbTextView4) {
        this.f15858a = constraintLayout;
        this.f15859b = linearLayout;
        this.f15860c = switchCompat;
        this.f15861d = cmbTextView;
        this.f15862e = feetHeightPicker;
        this.f15863f = feetHeightPicker2;
        this.f15864g = inchesHeightPicker;
        this.f15865h = inchesHeightPicker2;
        this.f15866j = textView;
        this.f15867k = textView2;
        this.f15868l = textView3;
        this.f15869m = linearLayout2;
        this.f15870n = cmbTextView2;
        this.f15871p = cmbTextView3;
        this.f15872q = cmbTextView4;
    }

    @NonNull
    public static y a(@NonNull View view) {
        View view2 = view;
        int i10 = R.id.contents;
        LinearLayout linearLayout = (LinearLayout) b.a(view2, R.id.contents);
        if (linearLayout != null) {
            i10 = R.id.is_dealbreaker;
            SwitchCompat switchCompat = (SwitchCompat) b.a(view2, R.id.is_dealbreaker);
            if (switchCompat != null) {
                i10 = R.id.message;
                CmbTextView cmbTextView = (CmbTextView) b.a(view2, R.id.message);
                if (cmbTextView != null) {
                    i10 = R.id.picker_feet_from;
                    FeetHeightPicker feetHeightPicker = (FeetHeightPicker) b.a(view2, R.id.picker_feet_from);
                    if (feetHeightPicker != null) {
                        i10 = R.id.picker_feet_to;
                        FeetHeightPicker feetHeightPicker2 = (FeetHeightPicker) b.a(view2, R.id.picker_feet_to);
                        if (feetHeightPicker2 != null) {
                            i10 = R.id.picker_inches_from;
                            InchesHeightPicker inchesHeightPicker = (InchesHeightPicker) b.a(view2, R.id.picker_inches_from);
                            if (inchesHeightPicker != null) {
                                i10 = R.id.picker_inches_to;
                                InchesHeightPicker inchesHeightPicker2 = (InchesHeightPicker) b.a(view2, R.id.picker_inches_to);
                                if (inchesHeightPicker2 != null) {
                                    i10 = R.id.switch_label;
                                    TextView textView = (TextView) b.a(view2, R.id.switch_label);
                                    if (textView != null) {
                                        i10 = R.id.switch_title;
                                        TextView textView2 = (TextView) b.a(view2, R.id.switch_title);
                                        if (textView2 != null) {
                                            i10 = R.id.to;
                                            TextView textView3 = (TextView) b.a(view2, R.id.to);
                                            if (textView3 != null) {
                                                i10 = R.id.upsell_card;
                                                LinearLayout linearLayout2 = (LinearLayout) b.a(view2, R.id.upsell_card);
                                                if (linearLayout2 != null) {
                                                    i10 = R.id.upsell_cta;
                                                    CmbTextView cmbTextView2 = (CmbTextView) b.a(view2, R.id.upsell_cta);
                                                    if (cmbTextView2 != null) {
                                                        i10 = R.id.upsell_header;
                                                        CmbTextView cmbTextView3 = (CmbTextView) b.a(view2, R.id.upsell_header);
                                                        if (cmbTextView3 != null) {
                                                            i10 = R.id.upsell_text;
                                                            CmbTextView cmbTextView4 = (CmbTextView) b.a(view2, R.id.upsell_text);
                                                            if (cmbTextView4 != null) {
                                                                return new y((ConstraintLayout) view2, linearLayout, switchCompat, cmbTextView, feetHeightPicker, feetHeightPicker2, inchesHeightPicker, inchesHeightPicker2, textView, textView2, textView3, linearLayout2, cmbTextView2, cmbTextView3, cmbTextView4);
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
    public static y c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.match_preferences_height_imperial, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f15858a;
    }
}

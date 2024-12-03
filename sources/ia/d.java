package ia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.coffeemeetsbagel.cmb_views.CmbRadioGroup;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.match_prefs.g;
import com.coffeemeetsbagel.match_prefs.h;
import z1.a;
import z1.b;

public final class d implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f40938a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbTextView f40939b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final SwitchCompat f40940c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f40941d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f40942e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CmbTextView f40943f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f40944g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final CmbTextView f40945h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final CmbTextView f40946j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final CmbTextView f40947k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final CmbRadioGroup f40948l;

    private d(@NonNull ConstraintLayout constraintLayout, @NonNull CmbTextView cmbTextView, @NonNull SwitchCompat switchCompat, @NonNull TextView textView, @NonNull TextView textView2, @NonNull CmbTextView cmbTextView2, @NonNull LinearLayout linearLayout, @NonNull CmbTextView cmbTextView3, @NonNull CmbTextView cmbTextView4, @NonNull CmbTextView cmbTextView5, @NonNull CmbRadioGroup cmbRadioGroup) {
        this.f40938a = constraintLayout;
        this.f40939b = cmbTextView;
        this.f40940c = switchCompat;
        this.f40941d = textView;
        this.f40942e = textView2;
        this.f40943f = cmbTextView2;
        this.f40944g = linearLayout;
        this.f40945h = cmbTextView3;
        this.f40946j = cmbTextView4;
        this.f40947k = cmbTextView5;
        this.f40948l = cmbRadioGroup;
    }

    @NonNull
    public static d a(@NonNull View view) {
        int i10 = g.instruction;
        CmbTextView cmbTextView = (CmbTextView) b.a(view, i10);
        if (cmbTextView != null) {
            i10 = g.is_dealbreaker;
            SwitchCompat switchCompat = (SwitchCompat) b.a(view, i10);
            if (switchCompat != null) {
                i10 = g.switch_label;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null) {
                    i10 = g.switch_title;
                    TextView textView2 = (TextView) b.a(view, i10);
                    if (textView2 != null) {
                        i10 = g.title;
                        CmbTextView cmbTextView2 = (CmbTextView) b.a(view, i10);
                        if (cmbTextView2 != null) {
                            i10 = g.upsell_card;
                            LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
                            if (linearLayout != null) {
                                i10 = g.upsell_cta;
                                CmbTextView cmbTextView3 = (CmbTextView) b.a(view, i10);
                                if (cmbTextView3 != null) {
                                    i10 = g.upsell_header;
                                    CmbTextView cmbTextView4 = (CmbTextView) b.a(view, i10);
                                    if (cmbTextView4 != null) {
                                        i10 = g.upsell_text;
                                        CmbTextView cmbTextView5 = (CmbTextView) b.a(view, i10);
                                        if (cmbTextView5 != null) {
                                            i10 = g.vertical_list_content_container;
                                            CmbRadioGroup cmbRadioGroup = (CmbRadioGroup) b.a(view, i10);
                                            if (cmbRadioGroup != null) {
                                                return new d((ConstraintLayout) view, cmbTextView, switchCompat, textView, textView2, cmbTextView2, linearLayout, cmbTextView3, cmbTextView4, cmbTextView5, cmbRadioGroup);
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
    public static d c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(h.match_pref_premium_multiple_choice, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f40938a;
    }
}

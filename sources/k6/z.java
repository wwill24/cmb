package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.new_user_experience.numberPickers.CentimeterHeightPicker;
import z1.a;
import z1.b;

public final class z implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f15873a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f15874b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Guideline f15875c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final SwitchCompat f15876d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbTextView f15877e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CentimeterHeightPicker f15878f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final CentimeterHeightPicker f15879g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f15880h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f15881j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f15882k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final LinearLayout f15883l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final CmbTextView f15884m;
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    public final CmbTextView f15885n;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    public final CmbTextView f15886p;

    private z(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull Guideline guideline, @NonNull SwitchCompat switchCompat, @NonNull CmbTextView cmbTextView, @NonNull CentimeterHeightPicker centimeterHeightPicker, @NonNull CentimeterHeightPicker centimeterHeightPicker2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout2, @NonNull CmbTextView cmbTextView2, @NonNull CmbTextView cmbTextView3, @NonNull CmbTextView cmbTextView4) {
        this.f15873a = constraintLayout;
        this.f15874b = linearLayout;
        this.f15875c = guideline;
        this.f15876d = switchCompat;
        this.f15877e = cmbTextView;
        this.f15878f = centimeterHeightPicker;
        this.f15879g = centimeterHeightPicker2;
        this.f15880h = textView;
        this.f15881j = textView2;
        this.f15882k = textView3;
        this.f15883l = linearLayout2;
        this.f15884m = cmbTextView2;
        this.f15885n = cmbTextView3;
        this.f15886p = cmbTextView4;
    }

    @NonNull
    public static z a(@NonNull View view) {
        View view2 = view;
        int i10 = R.id.contents;
        LinearLayout linearLayout = (LinearLayout) b.a(view2, R.id.contents);
        if (linearLayout != null) {
            i10 = R.id.guideline;
            Guideline guideline = (Guideline) b.a(view2, R.id.guideline);
            if (guideline != null) {
                i10 = R.id.is_dealbreaker;
                SwitchCompat switchCompat = (SwitchCompat) b.a(view2, R.id.is_dealbreaker);
                if (switchCompat != null) {
                    i10 = R.id.message;
                    CmbTextView cmbTextView = (CmbTextView) b.a(view2, R.id.message);
                    if (cmbTextView != null) {
                        i10 = R.id.picker_from;
                        CentimeterHeightPicker centimeterHeightPicker = (CentimeterHeightPicker) b.a(view2, R.id.picker_from);
                        if (centimeterHeightPicker != null) {
                            i10 = R.id.picker_to;
                            CentimeterHeightPicker centimeterHeightPicker2 = (CentimeterHeightPicker) b.a(view2, R.id.picker_to);
                            if (centimeterHeightPicker2 != null) {
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
                                                            return new z((ConstraintLayout) view2, linearLayout, guideline, switchCompat, cmbTextView, centimeterHeightPicker, centimeterHeightPicker2, textView, textView2, textView3, linearLayout2, cmbTextView2, cmbTextView3, cmbTextView4);
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
    public static z c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.match_preferences_height_metric, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f15873a;
    }
}

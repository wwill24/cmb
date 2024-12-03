package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z1.a;
import z1.b;

public final class w implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f15840a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbTextView f15841b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f15842c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f15843d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f15844e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f15845f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f15846g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f15847h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final CmbTextView f15848j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final Space f15849k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final Space f15850l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final CmbTextView f15851m;
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    public final CmbTextView f15852n;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    public final Guideline f15853p;
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    public final Guideline f15854q;

    private w(@NonNull CardView cardView, @NonNull CmbTextView cmbTextView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull LinearLayout linearLayout2, @NonNull CmbTextView cmbTextView2, @NonNull Space space, @NonNull Space space2, @NonNull CmbTextView cmbTextView3, @NonNull CmbTextView cmbTextView4, @NonNull Guideline guideline, @NonNull Guideline guideline2) {
        this.f15840a = cardView;
        this.f15841b = cmbTextView;
        this.f15842c = linearLayout;
        this.f15843d = imageView;
        this.f15844e = imageView2;
        this.f15845f = imageView3;
        this.f15846g = imageView4;
        this.f15847h = linearLayout2;
        this.f15848j = cmbTextView2;
        this.f15849k = space;
        this.f15850l = space2;
        this.f15851m = cmbTextView3;
        this.f15852n = cmbTextView4;
        this.f15853p = guideline;
        this.f15854q = guideline2;
    }

    @NonNull
    public static w a(@NonNull View view) {
        View view2 = view;
        int i10 = R.id.confirm_button;
        CmbTextView cmbTextView = (CmbTextView) b.a(view2, R.id.confirm_button);
        if (cmbTextView != null) {
            i10 = R.id.dialog_limelight_view;
            LinearLayout linearLayout = (LinearLayout) b.a(view2, R.id.dialog_limelight_view);
            if (linearLayout != null) {
                i10 = R.id.image;
                ImageView imageView = (ImageView) b.a(view2, R.id.image);
                if (imageView != null) {
                    i10 = R.id.image_view_1;
                    ImageView imageView2 = (ImageView) b.a(view2, R.id.image_view_1);
                    if (imageView2 != null) {
                        i10 = R.id.image_view_2;
                        ImageView imageView3 = (ImageView) b.a(view2, R.id.image_view_2);
                        if (imageView3 != null) {
                            i10 = R.id.image_view_3;
                            ImageView imageView4 = (ImageView) b.a(view2, R.id.image_view_3);
                            if (imageView4 != null) {
                                i10 = R.id.image_view_container;
                                LinearLayout linearLayout2 = (LinearLayout) b.a(view2, R.id.image_view_container);
                                if (linearLayout2 != null) {
                                    i10 = R.id.not_now;
                                    CmbTextView cmbTextView2 = (CmbTextView) b.a(view2, R.id.not_now);
                                    if (cmbTextView2 != null) {
                                        i10 = R.id.spacer;
                                        Space space = (Space) b.a(view2, R.id.spacer);
                                        if (space != null) {
                                            i10 = R.id.spacer_2;
                                            Space space2 = (Space) b.a(view2, R.id.spacer_2);
                                            if (space2 != null) {
                                                i10 = R.id.textview_description;
                                                CmbTextView cmbTextView3 = (CmbTextView) b.a(view2, R.id.textview_description);
                                                if (cmbTextView3 != null) {
                                                    i10 = R.id.textview_title;
                                                    CmbTextView cmbTextView4 = (CmbTextView) b.a(view2, R.id.textview_title);
                                                    if (cmbTextView4 != null) {
                                                        i10 = R.id.vertical_divider;
                                                        Guideline guideline = (Guideline) b.a(view2, R.id.vertical_divider);
                                                        if (guideline != null) {
                                                            i10 = R.id.vertical_divider_2;
                                                            Guideline guideline2 = (Guideline) b.a(view2, R.id.vertical_divider_2);
                                                            if (guideline2 != null) {
                                                                return new w((CardView) view2, cmbTextView, linearLayout, imageView, imageView2, imageView3, imageView4, linearLayout2, cmbTextView2, space, space2, cmbTextView3, cmbTextView4, guideline, guideline2);
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
    public static w c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static w d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.limelight_dialog, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public CardView getRoot() {
        return this.f15840a;
    }
}

package k6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z1.a;
import z1.b;

public final class c0 implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f15710a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final CmbImageView f15711b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f15712c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbButton f15713d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CmbTextView f15714e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CmbImageView f15715f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final CmbTextView f15716g;

    private c0(@NonNull LinearLayout linearLayout, @NonNull CmbImageView cmbImageView, @NonNull LinearLayout linearLayout2, @NonNull CmbButton cmbButton, @NonNull CmbTextView cmbTextView, @NonNull CmbImageView cmbImageView2, @NonNull CmbTextView cmbTextView2) {
        this.f15710a = linearLayout;
        this.f15711b = cmbImageView;
        this.f15712c = linearLayout2;
        this.f15713d = cmbButton;
        this.f15714e = cmbTextView;
        this.f15715f = cmbImageView2;
        this.f15716g = cmbTextView2;
    }

    @NonNull
    public static c0 a(@NonNull View view) {
        int i10 = R.id.chat_purchase_attribution_icon;
        CmbImageView cmbImageView = (CmbImageView) b.a(view, R.id.chat_purchase_attribution_icon);
        if (cmbImageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i10 = R.id.header_cta;
            CmbButton cmbButton = (CmbButton) b.a(view, R.id.header_cta);
            if (cmbButton != null) {
                i10 = R.id.header_text;
                CmbTextView cmbTextView = (CmbTextView) b.a(view, R.id.header_text);
                if (cmbTextView != null) {
                    i10 = R.id.imageView_avatar_chat;
                    CmbImageView cmbImageView2 = (CmbImageView) b.a(view, R.id.imageView_avatar_chat);
                    if (cmbImageView2 != null) {
                        i10 = R.id.textView_over;
                        CmbTextView cmbTextView2 = (CmbTextView) b.a(view, R.id.textView_over);
                        if (cmbTextView2 != null) {
                            return new c0(linearLayout, cmbImageView, linearLayout, cmbButton, cmbTextView, cmbImageView2, cmbTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static c0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static c0 d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.partial_header_messages_dls, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f15710a;
    }
}

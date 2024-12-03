package da;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import com.coffeemeetsbagel.cmb_views.CmbImageView;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.likes_you.s0;
import z1.a;

public final class d implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f40570a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f40571b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f40572c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f40573d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final View f40574e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f40575f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final View f40576g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final CmbImageView f40577h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final CmbTextView f40578j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final CmbTextView f40579k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final CmbTextView f40580l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final TextView f40581m;

    private d(@NonNull CardView cardView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull View view, @NonNull View view2, @NonNull View view3, @NonNull CmbImageView cmbImageView, @NonNull CmbTextView cmbTextView, @NonNull CmbTextView cmbTextView2, @NonNull CmbTextView cmbTextView3, @NonNull TextView textView2) {
        this.f40570a = cardView;
        this.f40571b = linearLayout;
        this.f40572c = imageView;
        this.f40573d = textView;
        this.f40574e = view;
        this.f40575f = view2;
        this.f40576g = view3;
        this.f40577h = cmbImageView;
        this.f40578j = cmbTextView;
        this.f40579k = cmbTextView2;
        this.f40580l = cmbTextView3;
        this.f40581m = textView2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        r0 = com.coffeemeetsbagel.likes_you.r0.fake_meta_item3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.coffeemeetsbagel.likes_you.r0.fake_meta_item1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        r0 = com.coffeemeetsbagel.likes_you.r0.fake_meta_item2;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static da.d a(@androidx.annotation.NonNull android.view.View r15) {
        /*
            int r0 = com.coffeemeetsbagel.likes_you.r0.bottom_photo_banner_container
            android.view.View r1 = z1.b.a(r15, r0)
            r4 = r1
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x007a
            int r0 = com.coffeemeetsbagel.likes_you.r0.bottom_photo_banner_icon
            android.view.View r1 = z1.b.a(r15, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x007a
            int r0 = com.coffeemeetsbagel.likes_you.r0.bottom_photo_banner_text
            android.view.View r1 = z1.b.a(r15, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x007a
            int r0 = com.coffeemeetsbagel.likes_you.r0.fake_meta_item1
            android.view.View r7 = z1.b.a(r15, r0)
            if (r7 == 0) goto L_0x007a
            int r0 = com.coffeemeetsbagel.likes_you.r0.fake_meta_item2
            android.view.View r8 = z1.b.a(r15, r0)
            if (r8 == 0) goto L_0x007a
            int r0 = com.coffeemeetsbagel.likes_you.r0.fake_meta_item3
            android.view.View r9 = z1.b.a(r15, r0)
            if (r9 == 0) goto L_0x007a
            int r0 = com.coffeemeetsbagel.likes_you.r0.image_view
            android.view.View r1 = z1.b.a(r15, r0)
            r10 = r1
            com.coffeemeetsbagel.cmb_views.CmbImageView r10 = (com.coffeemeetsbagel.cmb_views.CmbImageView) r10
            if (r10 == 0) goto L_0x007a
            int r0 = com.coffeemeetsbagel.likes_you.r0.meta_item_1
            android.view.View r1 = z1.b.a(r15, r0)
            r11 = r1
            com.coffeemeetsbagel.cmb_views.CmbTextView r11 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r11
            if (r11 == 0) goto L_0x007a
            int r0 = com.coffeemeetsbagel.likes_you.r0.meta_item_2
            android.view.View r1 = z1.b.a(r15, r0)
            r12 = r1
            com.coffeemeetsbagel.cmb_views.CmbTextView r12 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r12
            if (r12 == 0) goto L_0x007a
            int r0 = com.coffeemeetsbagel.likes_you.r0.meta_item_3
            android.view.View r1 = z1.b.a(r15, r0)
            r13 = r1
            com.coffeemeetsbagel.cmb_views.CmbTextView r13 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r13
            if (r13 == 0) goto L_0x007a
            int r0 = com.coffeemeetsbagel.likes_you.r0.text_view_your_type
            android.view.View r1 = z1.b.a(r15, r0)
            r14 = r1
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x007a
            da.d r0 = new da.d
            r3 = r15
            androidx.cardview.widget.CardView r3 = (androidx.cardview.widget.CardView) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r0
        L_0x007a:
            android.content.res.Resources r15 = r15.getResources()
            java.lang.String r15 = r15.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r15 = r1.concat(r15)
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: da.d.a(android.view.View):da.d");
    }

    @NonNull
    public static d c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(s0.limelight_grid_item_v2, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public CardView getRoot() {
        return this.f40570a;
    }
}

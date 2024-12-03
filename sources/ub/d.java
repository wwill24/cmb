package ub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.cmb_views.CmbButton;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.store.o0;
import z1.a;

public final class d implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f41967a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f41968b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CmbButton f41969c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CmbTextView f41970d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f41971e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ConstraintLayout f41972f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f41973g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final NestedScrollView f41974h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final CmbTextView f41975j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final c f41976k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final FrameLayout f41977l;

    private d(@NonNull ConstraintLayout constraintLayout, @NonNull RecyclerView recyclerView, @NonNull CmbButton cmbButton, @NonNull CmbTextView cmbTextView, @NonNull LinearLayout linearLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView, @NonNull NestedScrollView nestedScrollView, @NonNull CmbTextView cmbTextView2, @NonNull c cVar, @NonNull FrameLayout frameLayout) {
        this.f41967a = constraintLayout;
        this.f41968b = recyclerView;
        this.f41969c = cmbButton;
        this.f41970d = cmbTextView;
        this.f41971e = linearLayout;
        this.f41972f = constraintLayout2;
        this.f41973g = imageView;
        this.f41974h = nestedScrollView;
        this.f41975j = cmbTextView2;
        this.f41976k = cVar;
        this.f41977l = frameLayout;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        r0 = com.coffeemeetsbagel.store.n0.top_benefit;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ub.d a(@androidx.annotation.NonNull android.view.View r14) {
        /*
            int r0 = com.coffeemeetsbagel.store.n0.benefit_list
            android.view.View r1 = z1.b.a(r14, r0)
            r4 = r1
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            if (r4 == 0) goto L_0x0079
            int r0 = com.coffeemeetsbagel.store.n0.cta_primary
            android.view.View r1 = z1.b.a(r14, r0)
            r5 = r1
            com.coffeemeetsbagel.cmb_views.CmbButton r5 = (com.coffeemeetsbagel.cmb_views.CmbButton) r5
            if (r5 == 0) goto L_0x0079
            int r0 = com.coffeemeetsbagel.store.n0.first_line
            android.view.View r1 = z1.b.a(r14, r0)
            r6 = r1
            com.coffeemeetsbagel.cmb_views.CmbTextView r6 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r6
            if (r6 == 0) goto L_0x0079
            int r0 = com.coffeemeetsbagel.store.n0.footer_container
            android.view.View r1 = z1.b.a(r14, r0)
            r7 = r1
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x0079
            int r0 = com.coffeemeetsbagel.store.n0.header
            android.view.View r1 = z1.b.a(r14, r0)
            r8 = r1
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x0079
            int r0 = com.coffeemeetsbagel.store.n0.illustration
            android.view.View r1 = z1.b.a(r14, r0)
            r9 = r1
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0079
            int r0 = com.coffeemeetsbagel.store.n0.list_container
            android.view.View r1 = z1.b.a(r14, r0)
            r10 = r1
            androidx.core.widget.NestedScrollView r10 = (androidx.core.widget.NestedScrollView) r10
            if (r10 == 0) goto L_0x0079
            int r0 = com.coffeemeetsbagel.store.n0.title
            android.view.View r1 = z1.b.a(r14, r0)
            r11 = r1
            com.coffeemeetsbagel.cmb_views.CmbTextView r11 = (com.coffeemeetsbagel.cmb_views.CmbTextView) r11
            if (r11 == 0) goto L_0x0079
            int r0 = com.coffeemeetsbagel.store.n0.top_benefit
            android.view.View r1 = z1.b.a(r14, r0)
            if (r1 == 0) goto L_0x0079
            ub.c r12 = ub.c.a(r1)
            int r0 = com.coffeemeetsbagel.store.n0.top_benefit_container
            android.view.View r1 = z1.b.a(r14, r0)
            r13 = r1
            android.widget.FrameLayout r13 = (android.widget.FrameLayout) r13
            if (r13 == 0) goto L_0x0079
            ub.d r0 = new ub.d
            r3 = r14
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r0
        L_0x0079:
            android.content.res.Resources r14 = r14.getResources()
            java.lang.String r14 = r14.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r14 = r1.concat(r14)
            r0.<init>(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ub.d.a(android.view.View):ub.d");
    }

    @NonNull
    public static d c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(o0.subscription_benefits, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f41967a;
    }
}

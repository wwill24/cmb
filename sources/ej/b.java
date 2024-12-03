package ej;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar;
import com.withpersona.sdk2.inquiry.steps.ui.view.ShadowedNestedScrollView;
import com.withpersona.sdk2.inquiry.ui.i;
import z1.a;

public final class b implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f29589a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final ConstraintLayout f29590b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f29591c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f29592d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CoordinatorLayout f29593e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f29594f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final NestedScrollView f29595g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final Pi2NavigationBar f29596h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final ShadowedNestedScrollView f29597j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final ConstraintLayout f29598k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final FrameLayout f29599l;

    private b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull View view, @NonNull NestedScrollView nestedScrollView, @NonNull Pi2NavigationBar pi2NavigationBar, @NonNull ShadowedNestedScrollView shadowedNestedScrollView, @NonNull ConstraintLayout constraintLayout2, @NonNull FrameLayout frameLayout2) {
        this.f29589a = coordinatorLayout;
        this.f29590b = constraintLayout;
        this.f29591c = frameLayout;
        this.f29592d = linearLayout;
        this.f29593e = coordinatorLayout2;
        this.f29594f = view;
        this.f29595g = nestedScrollView;
        this.f29596h = pi2NavigationBar;
        this.f29597j = shadowedNestedScrollView;
        this.f29598k = constraintLayout2;
        this.f29599l = frameLayout2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.withpersona.sdk2.inquiry.ui.h.footer_sheet_grabber;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ej.b a(@androidx.annotation.NonNull android.view.View r14) {
        /*
            int r0 = com.withpersona.sdk2.inquiry.ui.h.container
            android.view.View r1 = z1.b.a(r14, r0)
            r4 = r1
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            if (r4 == 0) goto L_0x0075
            int r0 = com.withpersona.sdk2.inquiry.ui.h.footer_container
            android.view.View r1 = z1.b.a(r14, r0)
            r5 = r1
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            if (r5 == 0) goto L_0x0075
            int r0 = com.withpersona.sdk2.inquiry.ui.h.footer_sheet
            android.view.View r1 = z1.b.a(r14, r0)
            r6 = r1
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x0075
            int r0 = com.withpersona.sdk2.inquiry.ui.h.footer_sheet_coordinator_layout
            android.view.View r1 = z1.b.a(r14, r0)
            r7 = r1
            androidx.coordinatorlayout.widget.CoordinatorLayout r7 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r7
            if (r7 == 0) goto L_0x0075
            int r0 = com.withpersona.sdk2.inquiry.ui.h.footer_sheet_grabber
            android.view.View r8 = z1.b.a(r14, r0)
            if (r8 == 0) goto L_0x0075
            int r0 = com.withpersona.sdk2.inquiry.ui.h.footer_sheet_scroll_view
            android.view.View r1 = z1.b.a(r14, r0)
            r9 = r1
            androidx.core.widget.NestedScrollView r9 = (androidx.core.widget.NestedScrollView) r9
            if (r9 == 0) goto L_0x0075
            int r0 = com.withpersona.sdk2.inquiry.ui.h.navigation_bar
            android.view.View r1 = z1.b.a(r14, r0)
            r10 = r1
            com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar r10 = (com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar) r10
            if (r10 == 0) goto L_0x0075
            int r0 = com.withpersona.sdk2.inquiry.ui.h.nestedScroll
            android.view.View r1 = z1.b.a(r14, r0)
            r11 = r1
            com.withpersona.sdk2.inquiry.steps.ui.view.ShadowedNestedScrollView r11 = (com.withpersona.sdk2.inquiry.steps.ui.view.ShadowedNestedScrollView) r11
            if (r11 == 0) goto L_0x0075
            int r0 = com.withpersona.sdk2.inquiry.ui.h.root_layout
            android.view.View r1 = z1.b.a(r14, r0)
            r12 = r1
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            if (r12 == 0) goto L_0x0075
            int r0 = com.withpersona.sdk2.inquiry.ui.h.ui_step_container
            android.view.View r1 = z1.b.a(r14, r0)
            r13 = r1
            android.widget.FrameLayout r13 = (android.widget.FrameLayout) r13
            if (r13 == 0) goto L_0x0075
            ej.b r0 = new ej.b
            r3 = r14
            androidx.coordinatorlayout.widget.CoordinatorLayout r3 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r0
        L_0x0075:
            android.content.res.Resources r14 = r14.getResources()
            java.lang.String r14 = r14.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r14 = r1.concat(r14)
            r0.<init>(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ej.b.a(android.view.View):ej.b");
    }

    @NonNull
    public static b c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static b d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.pi2_inquiry_ui, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public CoordinatorLayout getRoot() {
        return this.f29589a;
    }
}

package ki;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.button.MaterialButton;
import com.withpersona.sdk2.inquiry.governmentid.m0;
import com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import z1.a;

public final class c implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f31950a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final TextView f31951b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final MaterialButton f31952c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ThemeableLottieAnimationView f31953d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ThemeableLottieAnimationView f31954e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f31955f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final CardView f31956g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final Pi2NavigationBar f31957h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f31958j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final Button f31959k;

    private c(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull ThemeableLottieAnimationView themeableLottieAnimationView, @NonNull ThemeableLottieAnimationView themeableLottieAnimationView2, @NonNull View view, @NonNull CardView cardView, @NonNull Pi2NavigationBar pi2NavigationBar, @NonNull TextView textView2, @NonNull Button button) {
        this.f31950a = coordinatorLayout;
        this.f31951b = textView;
        this.f31952c = materialButton;
        this.f31953d = themeableLottieAnimationView;
        this.f31954e = themeableLottieAnimationView2;
        this.f31955f = view;
        this.f31956g = cardView;
        this.f31957h = pi2NavigationBar;
        this.f31958j = textView2;
        this.f31959k = button;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.withpersona.sdk2.inquiry.governmentid.l0.id_image_container;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ki.c a(@androidx.annotation.NonNull android.view.View r13) {
        /*
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.body
            android.view.View r1 = z1.b.a(r13, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.camera_button
            android.view.View r1 = z1.b.a(r13, r0)
            r5 = r1
            com.google.android.material.button.MaterialButton r5 = (com.google.android.material.button.MaterialButton) r5
            if (r5 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.id_back
            android.view.View r1 = z1.b.a(r13, r0)
            r6 = r1
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r6 = (com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView) r6
            if (r6 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.id_front
            android.view.View r1 = z1.b.a(r13, r0)
            r7 = r1
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r7 = (com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView) r7
            if (r7 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.id_image_container
            android.view.View r8 = z1.b.a(r13, r0)
            if (r8 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.image_view_container
            android.view.View r1 = z1.b.a(r13, r0)
            r9 = r1
            androidx.cardview.widget.CardView r9 = (androidx.cardview.widget.CardView) r9
            if (r9 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.navigation_bar
            android.view.View r1 = z1.b.a(r13, r0)
            r10 = r1
            com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar r10 = (com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar) r10
            if (r10 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.title
            android.view.View r1 = z1.b.a(r13, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.upload_button
            android.view.View r1 = z1.b.a(r13, r0)
            r12 = r1
            android.widget.Button r12 = (android.widget.Button) r12
            if (r12 == 0) goto L_0x006a
            ki.c r0 = new ki.c
            r3 = r13
            androidx.coordinatorlayout.widget.CoordinatorLayout r3 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x006a:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ki.c.a(android.view.View):ki.c");
    }

    @NonNull
    public static c c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(m0.pi2_governmentid_choose_capture_method, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public CoordinatorLayout getRoot() {
        return this.f31950a;
    }
}

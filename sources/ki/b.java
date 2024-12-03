package ki;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.withpersona.sdk2.inquiry.governmentid.m0;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;
import z1.a;

public final class b implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f31941a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f31942b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f31943c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f31944d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ThemeableLottieAnimationView f31945e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f31946f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final View f31947g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f31948h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f31949j;

    private b(@NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull ConstraintLayout constraintLayout, @NonNull ThemeableLottieAnimationView themeableLottieAnimationView, @NonNull TextView textView, @NonNull View view, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f31941a = frameLayout;
        this.f31942b = linearLayout;
        this.f31943c = button;
        this.f31944d = constraintLayout;
        this.f31945e = themeableLottieAnimationView;
        this.f31946f = textView;
        this.f31947g = view;
        this.f31948h = textView2;
        this.f31949j = textView3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r0 = com.withpersona.sdk2.inquiry.governmentid.l0.shadow;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ki.b a(@androidx.annotation.NonNull android.view.View r12) {
        /*
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.bottom_sheet
            android.view.View r1 = z1.b.a(r12, r0)
            r4 = r1
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x005f
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.button
            android.view.View r1 = z1.b.a(r12, r0)
            r5 = r1
            android.widget.Button r5 = (android.widget.Button) r5
            if (r5 == 0) goto L_0x005f
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.content_container
            android.view.View r1 = z1.b.a(r12, r0)
            r6 = r1
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x005f
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.illustration
            android.view.View r1 = z1.b.a(r12, r0)
            r7 = r1
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r7 = (com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView) r7
            if (r7 == 0) goto L_0x005f
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.prompt
            android.view.View r1 = z1.b.a(r12, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x005f
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.shadow
            android.view.View r9 = z1.b.a(r12, r0)
            if (r9 == 0) goto L_0x005f
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.tips
            android.view.View r1 = z1.b.a(r12, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x005f
            int r0 = com.withpersona.sdk2.inquiry.governmentid.l0.title
            android.view.View r1 = z1.b.a(r12, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x005f
            ki.b r0 = new ki.b
            r3 = r12
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x005f:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ki.b.a(android.view.View):ki.b");
    }

    @NonNull
    public static b c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(m0.pi2_governmentid_capture_tips, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f31941a;
    }
}

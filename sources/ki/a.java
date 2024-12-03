package ki;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.airbnb.lottie.LottieAnimationView;
import com.withpersona.sdk2.camera.camera2.Camera2PreviewView;
import com.withpersona.sdk2.inquiry.governmentid.m0;
import com.withpersona.sdk2.inquiry.governmentid.view.ScanningView;
import com.withpersona.sdk2.inquiry.governmentid.view.SpotlightView;
import com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar;
import com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView;

public final class a implements z1.a {
    @NonNull
    public final ProgressBar B;
    @NonNull
    public final LottieAnimationView C;
    @NonNull
    public final ScanningView D;
    @NonNull
    public final View E;
    @NonNull
    public final View F;
    @NonNull
    public final SpotlightView G;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f31921a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Button f31922b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Camera2PreviewView f31923c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f31924d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f31925e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f31926f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f31927g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f31928h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final ToggleButton f31929j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f31930k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final Pi2NavigationBar f31931l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final View f31932m;
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    public final ImageView f31933n;
    @NonNull

    /* renamed from: p  reason: collision with root package name */
    public final ConstraintLayout f31934p;
    @NonNull

    /* renamed from: q  reason: collision with root package name */
    public final ThemeableLottieAnimationView f31935q;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    public final TextView f31936t;
    @NonNull

    /* renamed from: w  reason: collision with root package name */
    public final FrameLayout f31937w;
    @NonNull

    /* renamed from: x  reason: collision with root package name */
    public final View f31938x;
    @NonNull

    /* renamed from: y  reason: collision with root package name */
    public final PreviewView f31939y;
    @NonNull

    /* renamed from: z  reason: collision with root package name */
    public final Guideline f31940z;

    private a(@NonNull ConstraintLayout constraintLayout, @NonNull Button button, @NonNull Camera2PreviewView camera2PreviewView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull ToggleButton toggleButton, @NonNull TextView textView3, @NonNull Pi2NavigationBar pi2NavigationBar, @NonNull View view, @NonNull ImageView imageView2, @NonNull ConstraintLayout constraintLayout3, @NonNull ThemeableLottieAnimationView themeableLottieAnimationView, @NonNull TextView textView4, @NonNull FrameLayout frameLayout, @NonNull View view2, @NonNull PreviewView previewView, @NonNull Guideline guideline, @NonNull ProgressBar progressBar, @NonNull LottieAnimationView lottieAnimationView, @NonNull ScanningView scanningView, @NonNull View view3, @NonNull View view4, @NonNull SpotlightView spotlightView) {
        this.f31921a = constraintLayout;
        this.f31922b = button;
        this.f31923c = camera2PreviewView;
        this.f31924d = constraintLayout2;
        this.f31925e = textView;
        this.f31926f = textView2;
        this.f31927g = imageView;
        this.f31928h = linearLayout;
        this.f31929j = toggleButton;
        this.f31930k = textView3;
        this.f31931l = pi2NavigationBar;
        this.f31932m = view;
        this.f31933n = imageView2;
        this.f31934p = constraintLayout3;
        this.f31935q = themeableLottieAnimationView;
        this.f31936t = textView4;
        this.f31937w = frameLayout;
        this.f31938x = view2;
        this.f31939y = previewView;
        this.f31940z = guideline;
        this.B = progressBar;
        this.C = lottieAnimationView;
        this.D = scanningView;
        this.E = view3;
        this.F = view4;
        this.G = spotlightView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
        r1 = com.withpersona.sdk2.inquiry.governmentid.l0.overlay;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ac, code lost:
        r1 = com.withpersona.sdk2.inquiry.governmentid.l0.preview_dim;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        r1 = com.withpersona.sdk2.inquiry.governmentid.l0.shutter_bottom;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f8, code lost:
        r1 = com.withpersona.sdk2.inquiry.governmentid.l0.shutter_top;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ki.a a(@androidx.annotation.NonNull android.view.View r30) {
        /*
            r0 = r30
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.button
            android.view.View r2 = z1.b.a(r0, r1)
            r5 = r2
            android.widget.Button r5 = (android.widget.Button) r5
            if (r5 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.camera2_preview
            android.view.View r2 = z1.b.a(r0, r1)
            r6 = r2
            com.withpersona.sdk2.camera.camera2.Camera2PreviewView r6 = (com.withpersona.sdk2.camera.camera2.Camera2PreviewView) r6
            if (r6 == 0) goto L_0x0114
            r7 = r0
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.capture_tips
            android.view.View r2 = z1.b.a(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.disclaimer
            android.view.View r2 = z1.b.a(r0, r1)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.disclaimer_icon
            android.view.View r2 = z1.b.a(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.disclaimer_layout
            android.view.View r2 = z1.b.a(r0, r1)
            r11 = r2
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.flashlight_toggle
            android.view.View r2 = z1.b.a(r0, r1)
            r12 = r2
            android.widget.ToggleButton r12 = (android.widget.ToggleButton) r12
            if (r12 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.hint
            android.view.View r2 = z1.b.a(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.navigation_bar
            android.view.View r2 = z1.b.a(r0, r1)
            r14 = r2
            com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar r14 = (com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar) r14
            if (r14 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.overlay
            android.view.View r15 = z1.b.a(r0, r1)
            if (r15 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.overlay_guide
            android.view.View r2 = z1.b.a(r0, r1)
            r16 = r2
            android.widget.ImageView r16 = (android.widget.ImageView) r16
            if (r16 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.overlay_hint
            android.view.View r2 = z1.b.a(r0, r1)
            r17 = r2
            androidx.constraintlayout.widget.ConstraintLayout r17 = (androidx.constraintlayout.widget.ConstraintLayout) r17
            if (r17 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.overlay_icon
            android.view.View r2 = z1.b.a(r0, r1)
            r18 = r2
            com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView r18 = (com.withpersona.sdk2.inquiry.shared.ui.ThemeableLottieAnimationView) r18
            if (r18 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.overlay_text
            android.view.View r2 = z1.b.a(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.preview_container
            android.view.View r2 = z1.b.a(r0, r1)
            r20 = r2
            android.widget.FrameLayout r20 = (android.widget.FrameLayout) r20
            if (r20 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.preview_dim
            android.view.View r21 = z1.b.a(r0, r1)
            if (r21 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.preview_view
            android.view.View r2 = z1.b.a(r0, r1)
            r22 = r2
            androidx.camera.view.PreviewView r22 = (androidx.camera.view.PreviewView) r22
            if (r22 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.preview_view_center_guideline
            android.view.View r2 = z1.b.a(r0, r1)
            r23 = r2
            androidx.constraintlayout.widget.Guideline r23 = (androidx.constraintlayout.widget.Guideline) r23
            if (r23 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.progress_bar
            android.view.View r2 = z1.b.a(r0, r1)
            r24 = r2
            android.widget.ProgressBar r24 = (android.widget.ProgressBar) r24
            if (r24 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.scanning_animation
            android.view.View r2 = z1.b.a(r0, r1)
            r25 = r2
            com.airbnb.lottie.LottieAnimationView r25 = (com.airbnb.lottie.LottieAnimationView) r25
            if (r25 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.scanning_view
            android.view.View r2 = z1.b.a(r0, r1)
            r26 = r2
            com.withpersona.sdk2.inquiry.governmentid.view.ScanningView r26 = (com.withpersona.sdk2.inquiry.governmentid.view.ScanningView) r26
            if (r26 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.shutter_bottom
            android.view.View r27 = z1.b.a(r0, r1)
            if (r27 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.shutter_top
            android.view.View r28 = z1.b.a(r0, r1)
            if (r28 == 0) goto L_0x0114
            int r1 = com.withpersona.sdk2.inquiry.governmentid.l0.spotlight_view
            android.view.View r2 = z1.b.a(r0, r1)
            r29 = r2
            com.withpersona.sdk2.inquiry.governmentid.view.SpotlightView r29 = (com.withpersona.sdk2.inquiry.governmentid.view.SpotlightView) r29
            if (r29 == 0) goto L_0x0114
            ki.a r0 = new ki.a
            r3 = r0
            r4 = r7
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return r0
        L_0x0114:
            android.content.res.Resources r0 = r30.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ki.a.a(android.view.View):ki.a");
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static a d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(m0.pi2_governmentid_camera, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f31921a;
    }
}

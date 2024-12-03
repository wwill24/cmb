package si;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.withpersona.sdk2.camera.camera2.Camera2PreviewView;
import com.withpersona.sdk2.inquiry.selfie.j;
import com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView;
import com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar;

public final class a implements z1.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f33807a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Button f33808b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Camera2PreviewView f33809c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f33810d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f33811e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Pi2NavigationBar f33812f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final FrameLayout f33813g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final PreviewView f33814h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final SelfieOverlayView f33815j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final View f33816k;

    private a(@NonNull ConstraintLayout constraintLayout, @NonNull Button button, @NonNull Camera2PreviewView camera2PreviewView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull Pi2NavigationBar pi2NavigationBar, @NonNull FrameLayout frameLayout, @NonNull PreviewView previewView, @NonNull SelfieOverlayView selfieOverlayView, @NonNull View view) {
        this.f33807a = constraintLayout;
        this.f33808b = button;
        this.f33809c = camera2PreviewView;
        this.f33810d = textView;
        this.f33811e = textView2;
        this.f33812f = pi2NavigationBar;
        this.f33813g = frameLayout;
        this.f33814h = previewView;
        this.f33815j = selfieOverlayView;
        this.f33816k = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        r0 = com.withpersona.sdk2.inquiry.selfie.i.view_selfie_previewmask;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static si.a a(@androidx.annotation.NonNull android.view.View r13) {
        /*
            int r0 = com.withpersona.sdk2.inquiry.selfie.i.button
            android.view.View r1 = z1.b.a(r13, r0)
            r4 = r1
            android.widget.Button r4 = (android.widget.Button) r4
            if (r4 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.selfie.i.camera2_preview
            android.view.View r1 = z1.b.a(r13, r0)
            r5 = r1
            com.withpersona.sdk2.camera.camera2.Camera2PreviewView r5 = (com.withpersona.sdk2.camera.camera2.Camera2PreviewView) r5
            if (r5 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.selfie.i.countdown
            android.view.View r1 = z1.b.a(r13, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.selfie.i.hint_message
            android.view.View r1 = z1.b.a(r13, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.selfie.i.navigation_bar
            android.view.View r1 = z1.b.a(r13, r0)
            r8 = r1
            com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar r8 = (com.withpersona.sdk2.inquiry.shared.ui.Pi2NavigationBar) r8
            if (r8 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.selfie.i.preview_container
            android.view.View r1 = z1.b.a(r13, r0)
            r9 = r1
            android.widget.FrameLayout r9 = (android.widget.FrameLayout) r9
            if (r9 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.selfie.i.previewview_selfie_camera
            android.view.View r1 = z1.b.a(r13, r0)
            r10 = r1
            androidx.camera.view.PreviewView r10 = (androidx.camera.view.PreviewView) r10
            if (r10 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.selfie.i.selfie_window
            android.view.View r1 = z1.b.a(r13, r0)
            r11 = r1
            com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView r11 = (com.withpersona.sdk2.inquiry.selfie.view.SelfieOverlayView) r11
            if (r11 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.selfie.i.view_selfie_previewmask
            android.view.View r12 = z1.b.a(r13, r0)
            if (r12 == 0) goto L_0x006a
            si.a r0 = new si.a
            r3 = r13
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: si.a.a(android.view.View):si.a");
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static a d(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(j.pi2_selfie_camera, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public ConstraintLayout getRoot() {
        return this.f33807a;
    }
}

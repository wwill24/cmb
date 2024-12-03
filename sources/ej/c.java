package ej;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.withpersona.sdk2.inquiry.steps.ui.view.SignatureView;
import com.withpersona.sdk2.inquiry.ui.i;
import z1.a;

public final class c implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f29600a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final Button f29601b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f29602c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final Flow f29603d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final Button f29604e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f29605f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final SignatureView f29606g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f29607h;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f29608j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final ConstraintLayout f29609k;

    private c(@NonNull FrameLayout frameLayout, @NonNull Button button, @NonNull ImageView imageView, @NonNull Flow flow, @NonNull Button button2, @NonNull View view, @NonNull SignatureView signatureView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ConstraintLayout constraintLayout) {
        this.f29600a = frameLayout;
        this.f29601b = button;
        this.f29602c = imageView;
        this.f29603d = flow;
        this.f29604e = button2;
        this.f29605f = view;
        this.f29606g = signatureView;
        this.f29607h = textView;
        this.f29608j = textView2;
        this.f29609k = constraintLayout;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.withpersona.sdk2.inquiry.ui.h.shadow;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ej.c a(@androidx.annotation.NonNull android.view.View r13) {
        /*
            int r0 = com.withpersona.sdk2.inquiry.ui.h.clear_button
            android.view.View r1 = z1.b.a(r13, r0)
            r4 = r1
            android.widget.Button r4 = (android.widget.Button) r4
            if (r4 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.ui.h.close_signature_sheet_button
            android.view.View r1 = z1.b.a(r13, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.ui.h.flow_layout
            android.view.View r1 = z1.b.a(r13, r0)
            r6 = r1
            androidx.constraintlayout.helper.widget.Flow r6 = (androidx.constraintlayout.helper.widget.Flow) r6
            if (r6 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.ui.h.save_button
            android.view.View r1 = z1.b.a(r13, r0)
            r7 = r1
            android.widget.Button r7 = (android.widget.Button) r7
            if (r7 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.ui.h.shadow
            android.view.View r8 = z1.b.a(r13, r0)
            if (r8 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.ui.h.signature_canvas
            android.view.View r1 = z1.b.a(r13, r0)
            r9 = r1
            com.withpersona.sdk2.inquiry.steps.ui.view.SignatureView r9 = (com.withpersona.sdk2.inquiry.steps.ui.view.SignatureView) r9
            if (r9 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.ui.h.signature_description
            android.view.View r1 = z1.b.a(r13, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.ui.h.signature_label
            android.view.View r1 = z1.b.a(r13, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x006a
            int r0 = com.withpersona.sdk2.inquiry.ui.h.signature_sheet
            android.view.View r1 = z1.b.a(r13, r0)
            r12 = r1
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            if (r12 == 0) goto L_0x006a
            ej.c r0 = new ej.c
            r3 = r13
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: ej.c.a(android.view.View):ej.c");
    }

    @NonNull
    public static c c(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.pi2_signature_bottom_sheet, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f29600a;
    }
}

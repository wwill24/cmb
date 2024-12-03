package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import bf.b;
import bf.f;
import of.a;

public class SnackbarContentLayout extends LinearLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    private TextView f20132a;

    /* renamed from: b  reason: collision with root package name */
    private Button f20133b;

    /* renamed from: c  reason: collision with root package name */
    private final TimeInterpolator f20134c;

    /* renamed from: d  reason: collision with root package name */
    private int f20135d;

    public SnackbarContentLayout(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20134c = a.g(context, b.motionEasingEmphasizedInterpolator, cf.a.f18978b);
    }

    private static void d(@NonNull View view, int i10, int i11) {
        if (n0.Y(view)) {
            n0.I0(view, n0.G(view), i10, n0.F(view), i11);
        } else {
            view.setPadding(view.getPaddingLeft(), i10, view.getPaddingRight(), i11);
        }
    }

    private boolean e(int i10, int i11, int i12) {
        boolean z10;
        if (i10 != getOrientation()) {
            setOrientation(i10);
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f20132a.getPaddingTop() == i11 && this.f20132a.getPaddingBottom() == i12) {
            return z10;
        }
        d(this.f20132a, i11, i12);
        return true;
    }

    public void a(int i10, int i11) {
        this.f20132a.setAlpha(0.0f);
        long j10 = (long) i11;
        long j11 = (long) i10;
        this.f20132a.animate().alpha(1.0f).setDuration(j10).setInterpolator(this.f20134c).setStartDelay(j11).start();
        if (this.f20133b.getVisibility() == 0) {
            this.f20133b.setAlpha(0.0f);
            this.f20133b.animate().alpha(1.0f).setDuration(j10).setInterpolator(this.f20134c).setStartDelay(j11).start();
        }
    }

    public void b(int i10, int i11) {
        this.f20132a.setAlpha(1.0f);
        long j10 = (long) i11;
        long j11 = (long) i10;
        this.f20132a.animate().alpha(0.0f).setDuration(j10).setInterpolator(this.f20134c).setStartDelay(j11).start();
        if (this.f20133b.getVisibility() == 0) {
            this.f20133b.setAlpha(1.0f);
            this.f20133b.animate().alpha(0.0f).setDuration(j10).setInterpolator(this.f20134c).setStartDelay(j11).start();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(float f10) {
        if (f10 != 1.0f) {
            this.f20133b.setTextColor(hf.a.i(hf.a.d(this, b.colorSurface), this.f20133b.getCurrentTextColor(), f10));
        }
    }

    public Button getActionView() {
        return this.f20133b;
    }

    public TextView getMessageView() {
        return this.f20132a;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f20132a = (TextView) findViewById(f.snackbar_text);
        this.f20133b = (Button) findViewById(f.snackbar_action);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        if (e(1, r0, r0 - r2) != false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (e(0, r0, r0) != false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.getOrientation()
            r1 = 1
            if (r0 != r1) goto L_0x000b
            return
        L_0x000b:
            android.content.res.Resources r0 = r7.getResources()
            int r2 = bf.d.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r2)
            android.content.res.Resources r2 = r7.getResources()
            int r3 = bf.d.design_snackbar_padding_vertical
            int r2 = r2.getDimensionPixelSize(r3)
            android.widget.TextView r3 = r7.f20132a
            android.text.Layout r3 = r3.getLayout()
            r4 = 0
            if (r3 == 0) goto L_0x0030
            int r3 = r3.getLineCount()
            if (r3 <= r1) goto L_0x0030
            r3 = r1
            goto L_0x0031
        L_0x0030:
            r3 = r4
        L_0x0031:
            if (r3 == 0) goto L_0x004a
            int r5 = r7.f20135d
            if (r5 <= 0) goto L_0x004a
            android.widget.Button r5 = r7.f20133b
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f20135d
            if (r5 <= r6) goto L_0x004a
            int r2 = r0 - r2
            boolean r0 = r7.e(r1, r0, r2)
            if (r0 == 0) goto L_0x0055
            goto L_0x0056
        L_0x004a:
            if (r3 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r0 = r2
        L_0x004e:
            boolean r0 = r7.e(r4, r0, r0)
            if (r0 == 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r1 = r4
        L_0x0056:
            if (r1 == 0) goto L_0x005b
            super.onMeasure(r8, r9)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int i10) {
        this.f20135d = i10;
    }
}

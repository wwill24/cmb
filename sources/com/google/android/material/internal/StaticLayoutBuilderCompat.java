package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;

final class StaticLayoutBuilderCompat {

    /* renamed from: o  reason: collision with root package name */
    static final int f19792o = 1;

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f19793a;

    /* renamed from: b  reason: collision with root package name */
    private final TextPaint f19794b;

    /* renamed from: c  reason: collision with root package name */
    private final int f19795c;

    /* renamed from: d  reason: collision with root package name */
    private int f19796d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f19797e;

    /* renamed from: f  reason: collision with root package name */
    private Layout.Alignment f19798f;

    /* renamed from: g  reason: collision with root package name */
    private int f19799g;

    /* renamed from: h  reason: collision with root package name */
    private float f19800h;

    /* renamed from: i  reason: collision with root package name */
    private float f19801i;

    /* renamed from: j  reason: collision with root package name */
    private int f19802j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f19803k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f19804l;

    /* renamed from: m  reason: collision with root package name */
    private TextUtils.TruncateAt f19805m;

    /* renamed from: n  reason: collision with root package name */
    private m f19806n;

    static class StaticLayoutBuilderCompatException extends Exception {
    }

    private StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i10) {
        this.f19793a = charSequence;
        this.f19794b = textPaint;
        this.f19795c = i10;
        this.f19797e = charSequence.length();
        this.f19798f = Layout.Alignment.ALIGN_NORMAL;
        this.f19799g = a.e.API_PRIORITY_OTHER;
        this.f19800h = 0.0f;
        this.f19801i = 1.0f;
        this.f19802j = f19792o;
        this.f19803k = true;
        this.f19805m = null;
    }

    @NonNull
    public static StaticLayoutBuilderCompat b(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, int i10) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i10);
    }

    public StaticLayout a() throws StaticLayoutBuilderCompatException {
        TextDirectionHeuristic textDirectionHeuristic;
        if (this.f19793a == null) {
            this.f19793a = "";
        }
        int max = Math.max(0, this.f19795c);
        CharSequence charSequence = this.f19793a;
        if (this.f19799g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f19794b, (float) max, this.f19805m);
        }
        int min = Math.min(charSequence.length(), this.f19797e);
        this.f19797e = min;
        if (this.f19804l && this.f19799g == 1) {
            this.f19798f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.f19796d, min, this.f19794b, max);
        obtain.setAlignment(this.f19798f);
        obtain.setIncludePad(this.f19803k);
        if (this.f19804l) {
            textDirectionHeuristic = TextDirectionHeuristics.RTL;
        } else {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        }
        obtain.setTextDirection(textDirectionHeuristic);
        TextUtils.TruncateAt truncateAt = this.f19805m;
        if (truncateAt != null) {
            obtain.setEllipsize(truncateAt);
        }
        obtain.setMaxLines(this.f19799g);
        float f10 = this.f19800h;
        if (!(f10 == 0.0f && this.f19801i == 1.0f)) {
            obtain.setLineSpacing(f10, this.f19801i);
        }
        if (this.f19799g > 1) {
            obtain.setHyphenationFrequency(this.f19802j);
        }
        m mVar = this.f19806n;
        if (mVar != null) {
            mVar.a(obtain);
        }
        return obtain.build();
    }

    @NonNull
    public StaticLayoutBuilderCompat c(@NonNull Layout.Alignment alignment) {
        this.f19798f = alignment;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat d(TextUtils.TruncateAt truncateAt) {
        this.f19805m = truncateAt;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat e(int i10) {
        this.f19802j = i10;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat f(boolean z10) {
        this.f19803k = z10;
        return this;
    }

    public StaticLayoutBuilderCompat g(boolean z10) {
        this.f19804l = z10;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat h(float f10, float f11) {
        this.f19800h = f10;
        this.f19801i = f11;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat i(int i10) {
        this.f19799g = i10;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat j(m mVar) {
        this.f19806n = mVar;
        return this;
    }
}

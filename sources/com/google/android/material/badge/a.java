package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import bf.b;
import bf.d;
import bf.f;
import bf.j;
import bf.k;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.n;
import com.google.android.material.internal.p;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import tf.g;

public class a extends Drawable implements n.b {

    /* renamed from: p  reason: collision with root package name */
    private static final int f19149p = k.Widget_MaterialComponents_Badge;

    /* renamed from: q  reason: collision with root package name */
    private static final int f19150q = b.badgeStyle;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f19151a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final g f19152b = new g();
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final n f19153c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Rect f19154d = new Rect();
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final BadgeState f19155e;

    /* renamed from: f  reason: collision with root package name */
    private float f19156f;

    /* renamed from: g  reason: collision with root package name */
    private float f19157g;

    /* renamed from: h  reason: collision with root package name */
    private int f19158h;

    /* renamed from: j  reason: collision with root package name */
    private float f19159j;

    /* renamed from: k  reason: collision with root package name */
    private float f19160k;

    /* renamed from: l  reason: collision with root package name */
    private float f19161l;

    /* renamed from: m  reason: collision with root package name */
    private WeakReference<View> f19162m;

    /* renamed from: n  reason: collision with root package name */
    private WeakReference<FrameLayout> f19163n;

    /* renamed from: com.google.android.material.badge.a$a  reason: collision with other inner class name */
    class C0231a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f19164a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FrameLayout f19165b;

        C0231a(View view, FrameLayout frameLayout) {
            this.f19164a = view;
            this.f19165b = frameLayout;
        }

        public void run() {
            a.this.y(this.f19164a, this.f19165b);
        }
    }

    private a(@NonNull Context context, int i10, int i11, int i12, BadgeState.State state) {
        this.f19151a = new WeakReference<>(context);
        p.c(context);
        n nVar = new n(this);
        this.f19153c = nVar;
        nVar.e().setTextAlign(Paint.Align.CENTER);
        v(k.TextAppearance_MaterialComponents_Badge);
        this.f19155e = new BadgeState(context, i10, i11, i12, state);
        t();
    }

    private void A() {
        this.f19158h = ((int) Math.pow(10.0d, ((double) h()) - 1.0d)) - 1;
    }

    private void b(@NonNull Context context, @NonNull Rect rect, @NonNull View view) {
        int i10;
        float f10;
        float f11;
        float f12;
        int k10 = k();
        int f13 = this.f19155e.f();
        if (f13 == 8388691 || f13 == 8388693) {
            this.f19157g = (float) (rect.bottom - k10);
        } else {
            this.f19157g = (float) (rect.top + k10);
        }
        if (i() <= 9) {
            if (!l()) {
                f12 = this.f19155e.f19128c;
            } else {
                f12 = this.f19155e.f19129d;
            }
            this.f19159j = f12;
            this.f19161l = f12;
            this.f19160k = f12;
        } else {
            float f14 = this.f19155e.f19129d;
            this.f19159j = f14;
            this.f19161l = f14;
            this.f19160k = (this.f19153c.f(e()) / 2.0f) + this.f19155e.f19130e;
        }
        Resources resources = context.getResources();
        if (l()) {
            i10 = d.mtrl_badge_text_horizontal_edge_offset;
        } else {
            i10 = d.mtrl_badge_horizontal_edge_offset;
        }
        int dimensionPixelSize = resources.getDimensionPixelSize(i10);
        int j10 = j();
        int f15 = this.f19155e.f();
        if (f15 == 8388659 || f15 == 8388691) {
            if (n0.B(view) == 0) {
                f10 = (((float) rect.left) - this.f19160k) + ((float) dimensionPixelSize) + ((float) j10);
            } else {
                f10 = ((((float) rect.right) + this.f19160k) - ((float) dimensionPixelSize)) - ((float) j10);
            }
            this.f19156f = f10;
            return;
        }
        if (n0.B(view) == 0) {
            f11 = ((((float) rect.right) + this.f19160k) - ((float) dimensionPixelSize)) - ((float) j10);
        } else {
            f11 = (((float) rect.left) - this.f19160k) + ((float) dimensionPixelSize) + ((float) j10);
        }
        this.f19156f = f11;
    }

    @NonNull
    public static a c(@NonNull Context context) {
        return new a(context, 0, f19150q, f19149p, (BadgeState.State) null);
    }

    private void d(Canvas canvas) {
        Rect rect = new Rect();
        String e10 = e();
        this.f19153c.e().getTextBounds(e10, 0, e10.length(), rect);
        canvas.drawText(e10, this.f19156f, this.f19157g + ((float) (rect.height() / 2)), this.f19153c.e());
    }

    @NonNull
    private String e() {
        if (i() <= this.f19158h) {
            return NumberFormat.getInstance(this.f19155e.o()).format((long) i());
        }
        Context context = this.f19151a.get();
        if (context == null) {
            return "";
        }
        return String.format(this.f19155e.o(), context.getString(j.mtrl_exceed_max_badge_number_suffix), new Object[]{Integer.valueOf(this.f19158h), "+"});
    }

    private int j() {
        int i10;
        if (l()) {
            i10 = this.f19155e.k();
        } else {
            i10 = this.f19155e.l();
        }
        return i10 + this.f19155e.b();
    }

    private int k() {
        int i10;
        if (l()) {
            i10 = this.f19155e.p();
        } else {
            i10 = this.f19155e.q();
        }
        return i10 + this.f19155e.c();
    }

    private void m() {
        this.f19153c.e().setAlpha(getAlpha());
        invalidateSelf();
    }

    private void n() {
        ColorStateList valueOf = ColorStateList.valueOf(this.f19155e.e());
        if (this.f19152b.x() != valueOf) {
            this.f19152b.b0(valueOf);
            invalidateSelf();
        }
    }

    private void o() {
        FrameLayout frameLayout;
        WeakReference<View> weakReference = this.f19162m;
        if (weakReference != null && weakReference.get() != null) {
            View view = this.f19162m.get();
            WeakReference<FrameLayout> weakReference2 = this.f19163n;
            if (weakReference2 != null) {
                frameLayout = weakReference2.get();
            } else {
                frameLayout = null;
            }
            y(view, frameLayout);
        }
    }

    private void p() {
        this.f19153c.e().setColor(this.f19155e.g());
        invalidateSelf();
    }

    private void q() {
        A();
        this.f19153c.i(true);
        z();
        invalidateSelf();
    }

    private void r() {
        this.f19153c.i(true);
        z();
        invalidateSelf();
    }

    private void s() {
        boolean s10 = this.f19155e.s();
        setVisible(s10, false);
        if (b.f19167a && g() != null && !s10) {
            ((ViewGroup) g().getParent()).invalidate();
        }
    }

    private void t() {
        q();
        r();
        m();
        n();
        p();
        o();
        z();
        s();
    }

    private void u(qf.d dVar) {
        Context context;
        if (this.f19153c.d() != dVar && (context = this.f19151a.get()) != null) {
            this.f19153c.h(dVar, context);
            z();
        }
    }

    private void v(int i10) {
        Context context = this.f19151a.get();
        if (context != null) {
            u(new qf.d(context, i10));
        }
    }

    private void w(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != f.mtrl_anchor_parent) {
            WeakReference<FrameLayout> weakReference = this.f19163n;
            if (weakReference == null || weakReference.get() != viewGroup) {
                x(view);
                FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(f.mtrl_anchor_parent);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(indexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, indexOfChild);
                this.f19163n = new WeakReference<>(frameLayout);
                frameLayout.post(new C0231a(view, frameLayout));
            }
        }
    }

    private static void x(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void z() {
        View view;
        Context context = this.f19151a.get();
        WeakReference<View> weakReference = this.f19162m;
        ViewGroup viewGroup = null;
        if (weakReference != null) {
            view = weakReference.get();
        } else {
            view = null;
        }
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.f19154d);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.f19163n;
            if (weakReference2 != null) {
                viewGroup = weakReference2.get();
            }
            if (viewGroup != null || b.f19167a) {
                if (viewGroup == null) {
                    viewGroup = (ViewGroup) view.getParent();
                }
                viewGroup.offsetDescendantRectToMyCoords(view, rect2);
            }
            b(context, rect2, view);
            b.d(this.f19154d, this.f19156f, this.f19157g, this.f19160k, this.f19161l);
            this.f19152b.Y(this.f19159j);
            if (!rect.equals(this.f19154d)) {
                this.f19152b.setBounds(this.f19154d);
            }
        }
    }

    public void a() {
        invalidateSelf();
    }

    public void draw(@NonNull Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.f19152b.draw(canvas);
            if (l()) {
                d(canvas);
            }
        }
    }

    public CharSequence f() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!l()) {
            return this.f19155e.i();
        }
        if (this.f19155e.j() == 0 || (context = this.f19151a.get()) == null) {
            return null;
        }
        if (i() <= this.f19158h) {
            return context.getResources().getQuantityString(this.f19155e.j(), i(), new Object[]{Integer.valueOf(i())});
        }
        return context.getString(this.f19155e.h(), new Object[]{Integer.valueOf(this.f19158h)});
    }

    public FrameLayout g() {
        WeakReference<FrameLayout> weakReference = this.f19163n;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getAlpha() {
        return this.f19155e.d();
    }

    public int getIntrinsicHeight() {
        return this.f19154d.height();
    }

    public int getIntrinsicWidth() {
        return this.f19154d.width();
    }

    public int getOpacity() {
        return -3;
    }

    public int h() {
        return this.f19155e.m();
    }

    public int i() {
        if (l()) {
            return this.f19155e.n();
        }
        return 0;
    }

    public boolean isStateful() {
        return false;
    }

    public boolean l() {
        return this.f19155e.r();
    }

    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void setAlpha(int i10) {
        this.f19155e.u(i10);
        m();
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void y(@NonNull View view, FrameLayout frameLayout) {
        this.f19162m = new WeakReference<>(view);
        boolean z10 = b.f19167a;
        if (!z10 || frameLayout != null) {
            this.f19163n = new WeakReference<>(frameLayout);
        } else {
            w(view);
        }
        if (!z10) {
            x(view);
        }
        z();
        invalidateSelf();
    }
}

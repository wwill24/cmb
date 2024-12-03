package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.e2;
import androidx.core.view.f2;
import androidx.core.view.n0;
import d.j;

abstract class a extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    protected final C0014a f1186a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f1187b;

    /* renamed from: c  reason: collision with root package name */
    protected ActionMenuView f1188c;

    /* renamed from: d  reason: collision with root package name */
    protected ActionMenuPresenter f1189d;

    /* renamed from: e  reason: collision with root package name */
    protected int f1190e;

    /* renamed from: f  reason: collision with root package name */
    protected e2 f1191f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1192g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1193h;

    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    protected class C0014a implements f2 {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1194a = false;

        /* renamed from: b  reason: collision with root package name */
        int f1195b;

        protected C0014a() {
        }

        public void a(View view) {
            this.f1194a = true;
        }

        public void b(View view) {
            if (!this.f1194a) {
                a aVar = a.this;
                aVar.f1191f = null;
                a.super.setVisibility(this.f1195b);
            }
        }

        public void c(View view) {
            a.super.setVisibility(0);
            this.f1194a = false;
        }

        public C0014a d(e2 e2Var, int i10) {
            a.this.f1191f = e2Var;
            this.f1195b = i10;
            return this;
        }
    }

    a(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected static int d(int i10, int i11, boolean z10) {
        return z10 ? i10 - i11 : i10 + i11;
    }

    /* access modifiers changed from: protected */
    public int c(View view, int i10, int i11, int i12) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), i11);
        return Math.max(0, (i10 - view.getMeasuredWidth()) - i12);
    }

    /* access modifiers changed from: protected */
    public int e(View view, int i10, int i11, int i12, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = i11 + ((i12 - measuredHeight) / 2);
        if (z10) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        if (z10) {
            return -measuredWidth;
        }
        return measuredWidth;
    }

    public e2 f(int i10, long j10) {
        e2 e2Var = this.f1191f;
        if (e2Var != null) {
            e2Var.c();
        }
        if (i10 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            e2 b10 = n0.e(this).b(1.0f);
            b10.f(j10);
            b10.h(this.f1186a.d(b10, i10));
            return b10;
        }
        e2 b11 = n0.e(this).b(0.0f);
        b11.f(j10);
        b11.h(this.f1186a.d(b11, i10));
        return b11;
    }

    public int getAnimatedVisibility() {
        if (this.f1191f != null) {
            return this.f1186a.f1195b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.f1190e;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, j.ActionBar, d.a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f1189d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.F(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1193h = false;
        }
        if (!this.f1193h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f1193h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1193h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1192g = false;
        }
        if (!this.f1192g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f1192g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1192g = false;
        }
        return true;
    }

    public void setContentHeight(int i10) {
        this.f1190e = i10;
        requestLayout();
    }

    public void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            e2 e2Var = this.f1191f;
            if (e2Var != null) {
                e2Var.c();
            }
            super.setVisibility(i10);
        }
    }

    a(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1186a = new C0014a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(d.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1187b = context;
        } else {
            this.f1187b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }
}

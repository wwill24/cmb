package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.n1;
import androidx.appcompat.widget.o0;
import d.j;

public class ActionMenuItemView extends d0 implements n.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: h  reason: collision with root package name */
    i f713h;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f714j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f715k;

    /* renamed from: l  reason: collision with root package name */
    g.b f716l;

    /* renamed from: m  reason: collision with root package name */
    private o0 f717m;

    /* renamed from: n  reason: collision with root package name */
    b f718n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f719p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f720q;

    /* renamed from: t  reason: collision with root package name */
    private int f721t;

    /* renamed from: w  reason: collision with root package name */
    private int f722w;

    /* renamed from: x  reason: collision with root package name */
    private int f723x;

    private class a extends o0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        public p b() {
            b bVar = ActionMenuItemView.this.f718n;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public boolean c() {
            p b10;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            g.b bVar = actionMenuItemView.f716l;
            if (bVar == null || !bVar.b(actionMenuItemView.f713h) || (b10 = b()) == null || !b10.b()) {
                return false;
            }
            return true;
        }
    }

    public static abstract class b {
        public abstract p a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean s() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        int i11 = configuration.screenHeightDp;
        if (i10 >= 480 || ((i10 >= 640 && i11 >= 480) || configuration.orientation == 2)) {
            return true;
        }
        return false;
    }

    private void t() {
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f714j);
        if (this.f715k != null && (!this.f713h.B() || (!this.f719p && !this.f720q))) {
            z10 = false;
        }
        boolean z12 = z11 & z10;
        CharSequence charSequence3 = null;
        if (z12) {
            charSequence = this.f714j;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        CharSequence contentDescription = this.f713h.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (z12) {
                charSequence2 = null;
            } else {
                charSequence2 = this.f713h.getTitle();
            }
            setContentDescription(charSequence2);
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f713h.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z12) {
                charSequence3 = this.f713h.getTitle();
            }
            n1.a(this, charSequence3);
            return;
        }
        n1.a(this, tooltipText);
    }

    public boolean a() {
        return r();
    }

    public boolean b() {
        return r() && this.f713h.getIcon() == null;
    }

    public void c(i iVar, int i10) {
        int i11;
        this.f713h = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.i(this));
        setId(iVar.getItemId());
        if (iVar.isVisible()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        setVisibility(i11);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.f717m == null) {
            this.f717m = new a();
        }
    }

    public boolean d() {
        return true;
    }

    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    public i getItemData() {
        return this.f713h;
    }

    public void onClick(View view) {
        g.b bVar = this.f716l;
        if (bVar != null) {
            bVar.b(this.f713h);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f719p = s();
        t();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        boolean r10 = r();
        if (r10 && (i13 = this.f722w) >= 0) {
            super.setPadding(i13, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int measuredWidth = getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            i12 = Math.min(size, this.f721t);
        } else {
            i12 = this.f721t;
        }
        if (mode != 1073741824 && this.f721t > 0 && measuredWidth < i12) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
        }
        if (!r10 && this.f715k != null) {
            super.setPadding((getMeasuredWidth() - this.f715k.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        o0 o0Var;
        if (!this.f713h.hasSubMenu() || (o0Var = this.f717m) == null || !o0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean r() {
        return !TextUtils.isEmpty(getText());
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }

    public void setExpandedFormat(boolean z10) {
        if (this.f720q != z10) {
            this.f720q = z10;
            i iVar = this.f713h;
            if (iVar != null) {
                iVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f715k = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i10 = this.f723x;
            if (intrinsicWidth > i10) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i10) / ((float) intrinsicWidth)));
                intrinsicWidth = i10;
            }
            if (intrinsicHeight > i10) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i10) / ((float) intrinsicHeight)));
            } else {
                i10 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i10);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        t();
    }

    public void setItemInvoker(g.b bVar) {
        this.f716l = bVar;
    }

    public void setPadding(int i10, int i11, int i12, int i13) {
        this.f722w = i10;
        super.setPadding(i10, i11, i12, i13);
    }

    public void setPopupCallback(b bVar) {
        this.f718n = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f714j = charSequence;
        t();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Resources resources = context.getResources();
        this.f719p = s();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionMenuItemView, i10, 0);
        this.f721t = obtainStyledAttributes.getDimensionPixelSize(j.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f723x = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f722w = -1;
        setSaveEnabled(false);
    }
}

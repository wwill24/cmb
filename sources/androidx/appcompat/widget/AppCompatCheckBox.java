package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.core.widget.v;
import d.a;

public class AppCompatCheckBox extends CheckBox implements v {

    /* renamed from: a  reason: collision with root package name */
    private final g f1012a;

    /* renamed from: b  reason: collision with root package name */
    private final d f1013b;

    /* renamed from: c  reason: collision with root package name */
    private final x f1014c;

    /* renamed from: d  reason: collision with root package name */
    private k f1015d;

    public AppCompatCheckBox(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.checkboxStyle);
    }

    @NonNull
    private k getEmojiTextViewHelper() {
        if (this.f1015d == null) {
            this.f1015d = new k(this);
        }
        return this.f1015d;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1013b;
        if (dVar != null) {
            dVar.b();
        }
        x xVar = this.f1014c;
        if (xVar != null) {
            xVar.b();
        }
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        g gVar = this.f1012a;
        if (gVar != null) {
            return gVar.b(compoundPaddingLeft);
        }
        return compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1013b;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1013b;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        g gVar = this.f1012a;
        if (gVar != null) {
            return gVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        g gVar = this.f1012a;
        if (gVar != null) {
            return gVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1014c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1014c.k();
    }

    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1013b;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f1013b;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        g gVar = this.f1012a;
        if (gVar != null) {
            gVar.f();
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        x xVar = this.f1014c;
        if (xVar != null) {
            xVar.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        x xVar = this.f1014c;
        if (xVar != null) {
            xVar.p();
        }
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
    }

    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1013b;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1013b;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        g gVar = this.f1012a;
        if (gVar != null) {
            gVar.g(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        g gVar = this.f1012a;
        if (gVar != null) {
            gVar.h(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1014c.w(colorStateList);
        this.f1014c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1014c.x(mode);
        this.f1014c.b();
    }

    public AppCompatCheckBox(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(e1.b(context), attributeSet, i10);
        c1.a(this, getContext());
        g gVar = new g(this);
        this.f1012a = gVar;
        gVar.e(attributeSet, i10);
        d dVar = new d(this);
        this.f1013b = dVar;
        dVar.e(attributeSet, i10);
        x xVar = new x(this);
        this.f1014c = xVar;
        xVar.m(attributeSet, i10);
        getEmojiTextViewHelper().c(attributeSet, i10);
    }

    public void setButtonDrawable(int i10) {
        setButtonDrawable(e.a.b(getContext(), i10));
    }
}

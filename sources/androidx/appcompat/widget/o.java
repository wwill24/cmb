package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.annotation.NonNull;
import d.a;

public class o extends MultiAutoCompleteTextView {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f1368d = {16843126};

    /* renamed from: a  reason: collision with root package name */
    private final d f1369a;

    /* renamed from: b  reason: collision with root package name */
    private final x f1370b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final j f1371c;

    public o(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.autoCompleteTextViewStyle);
    }

    /* access modifiers changed from: package-private */
    public void a(j jVar) {
        KeyListener keyListener = getKeyListener();
        if (jVar.b(keyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener a10 = jVar.a(keyListener);
            if (a10 != keyListener) {
                super.setKeyListener(a10);
                super.setRawInputType(inputType);
                super.setFocusable(isFocusable);
                super.setClickable(isClickable);
                super.setLongClickable(isLongClickable);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1369a;
        if (dVar != null) {
            dVar.b();
        }
        x xVar = this.f1370b;
        if (xVar != null) {
            xVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1369a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1369a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1370b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1370b.k();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f1371c.d(l.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1369a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f1369a;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        x xVar = this.f1370b;
        if (xVar != null) {
            xVar.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        x xVar = this.f1370b;
        if (xVar != null) {
            xVar.p();
        }
    }

    public void setDropDownBackgroundResource(int i10) {
        setDropDownBackgroundDrawable(e.a.b(getContext(), i10));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        this.f1371c.e(z10);
    }

    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f1371c.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1369a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1369a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1370b.w(colorStateList);
        this.f1370b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1370b.x(mode);
        this.f1370b.b();
    }

    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        x xVar = this.f1370b;
        if (xVar != null) {
            xVar.q(context, i10);
        }
    }

    public o(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(e1.b(context), attributeSet, i10);
        c1.a(this, getContext());
        h1 v10 = h1.v(getContext(), attributeSet, f1368d, i10, 0);
        if (v10.s(0)) {
            setDropDownBackgroundDrawable(v10.g(0));
        }
        v10.w();
        d dVar = new d(this);
        this.f1369a = dVar;
        dVar.e(attributeSet, i10);
        x xVar = new x(this);
        this.f1370b = xVar;
        xVar.m(attributeSet, i10);
        xVar.b();
        j jVar = new j(this);
        this.f1371c = jVar;
        jVar.c(attributeSet, i10);
        a(jVar);
    }
}

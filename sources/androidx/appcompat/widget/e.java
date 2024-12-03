package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.core.widget.l;
import d.a;

public class e extends CheckedTextView {

    /* renamed from: a  reason: collision with root package name */
    private final f f1241a;

    /* renamed from: b  reason: collision with root package name */
    private final d f1242b;

    /* renamed from: c  reason: collision with root package name */
    private final x f1243c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private k f1244d;

    public e(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.checkedTextViewStyle);
    }

    @NonNull
    private k getEmojiTextViewHelper() {
        if (this.f1244d == null) {
            this.f1244d = new k(this);
        }
        return this.f1244d;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        x xVar = this.f1243c;
        if (xVar != null) {
            xVar.b();
        }
        d dVar = this.f1242b;
        if (dVar != null) {
            dVar.b();
        }
        f fVar = this.f1241a;
        if (fVar != null) {
            fVar.a();
        }
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return l.u(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1242b;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1242b;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        f fVar = this.f1241a;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        f fVar = this.f1241a;
        if (fVar != null) {
            return fVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1243c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1243c.k();
    }

    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1242b;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f1242b;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        f fVar = this.f1241a;
        if (fVar != null) {
            fVar.e();
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        x xVar = this.f1243c;
        if (xVar != null) {
            xVar.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        x xVar = this.f1243c;
        if (xVar != null) {
            xVar.p();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(l.v(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1242b;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1242b;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        f fVar = this.f1241a;
        if (fVar != null) {
            fVar.f(colorStateList);
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        f fVar = this.f1241a;
        if (fVar != null) {
            fVar.g(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1243c.w(colorStateList);
        this.f1243c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1243c.x(mode);
        this.f1243c.b();
    }

    public void setTextAppearance(@NonNull Context context, int i10) {
        super.setTextAppearance(context, i10);
        x xVar = this.f1243c;
        if (xVar != null) {
            xVar.q(context, i10);
        }
    }

    public e(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(e1.b(context), attributeSet, i10);
        c1.a(this, getContext());
        x xVar = new x(this);
        this.f1243c = xVar;
        xVar.m(attributeSet, i10);
        xVar.b();
        d dVar = new d(this);
        this.f1242b = dVar;
        dVar.e(attributeSet, i10);
        f fVar = new f(this);
        this.f1241a = fVar;
        fVar.d(attributeSet, i10);
        getEmojiTextViewHelper().c(attributeSet, i10);
    }

    public void setCheckMarkDrawable(int i10) {
        setCheckMarkDrawable(e.a.b(getContext(), i10));
    }
}

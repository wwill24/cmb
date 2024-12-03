package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.core.view.c;
import androidx.core.view.j0;
import androidx.core.view.n0;
import androidx.core.widget.l;
import androidx.core.widget.u;
import w0.b;
import w0.d;

public class i extends EditText implements j0 {

    /* renamed from: a  reason: collision with root package name */
    private final d f1295a;

    /* renamed from: b  reason: collision with root package name */
    private final x f1296b;

    /* renamed from: c  reason: collision with root package name */
    private final w f1297c;

    /* renamed from: d  reason: collision with root package name */
    private final u f1298d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final j f1299e;

    /* renamed from: f  reason: collision with root package name */
    private a f1300f;

    class a {
        a() {
        }

        public TextClassifier a() {
            return i.super.getTextClassifier();
        }

        public void b(TextClassifier textClassifier) {
            i.super.setTextClassifier(textClassifier);
        }
    }

    public i(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.editTextStyle);
    }

    @NonNull
    private a getSuperCaller() {
        if (this.f1300f == null) {
            this.f1300f = new a();
        }
        return this.f1300f;
    }

    public c a(@NonNull c cVar) {
        return this.f1298d.a(this, cVar);
    }

    /* access modifiers changed from: package-private */
    public void d(j jVar) {
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
        d dVar = this.f1295a;
        if (dVar != null) {
            dVar.b();
        }
        x xVar = this.f1296b;
        if (xVar != null) {
            xVar.b();
        }
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return l.u(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1295a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1295a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1296b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1296b.k();
    }

    @NonNull
    public TextClassifier getTextClassifier() {
        w wVar;
        if (Build.VERSION.SDK_INT >= 28 || (wVar = this.f1297c) == null) {
            return getSuperCaller().a();
        }
        return wVar.a();
    }

    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        String[] E;
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1296b.r(this, onCreateInputConnection, editorInfo);
        InputConnection a10 = l.a(onCreateInputConnection, editorInfo, this);
        if (!(a10 == null || Build.VERSION.SDK_INT > 30 || (E = n0.E(this)) == null)) {
            b.c(editorInfo, E);
            a10 = d.c(this, a10, editorInfo);
        }
        return this.f1299e.d(a10, editorInfo);
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        if (t.a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    public boolean onTextContextMenuItem(int i10) {
        if (t.b(this, i10)) {
            return true;
        }
        return super.onTextContextMenuItem(i10);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1295a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f1295a;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        x xVar = this.f1296b;
        if (xVar != null) {
            xVar.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        x xVar = this.f1296b;
        if (xVar != null) {
            xVar.p();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(l.v(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        this.f1299e.e(z10);
    }

    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f1299e.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1295a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1295a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1296b.w(colorStateList);
        this.f1296b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1296b.x(mode);
        this.f1296b.b();
    }

    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        x xVar = this.f1296b;
        if (xVar != null) {
            xVar.q(context, i10);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        w wVar;
        if (Build.VERSION.SDK_INT >= 28 || (wVar = this.f1297c) == null) {
            getSuperCaller().b(textClassifier);
        } else {
            wVar.b(textClassifier);
        }
    }

    public i(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(e1.b(context), attributeSet, i10);
        c1.a(this, getContext());
        d dVar = new d(this);
        this.f1295a = dVar;
        dVar.e(attributeSet, i10);
        x xVar = new x(this);
        this.f1296b = xVar;
        xVar.m(attributeSet, i10);
        xVar.b();
        this.f1297c = new w(this);
        this.f1298d = new u();
        j jVar = new j(this);
        this.f1299e = jVar;
        jVar.c(attributeSet, i10);
        d(jVar);
    }

    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }
}

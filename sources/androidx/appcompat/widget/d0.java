package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.graphics.e;
import androidx.core.text.d;
import androidx.core.widget.l;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class d0 extends TextView implements androidx.core.widget.b {

    /* renamed from: a  reason: collision with root package name */
    private final d f1232a;

    /* renamed from: b  reason: collision with root package name */
    private final x f1233b;

    /* renamed from: c  reason: collision with root package name */
    private final w f1234c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private k f1235d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1236e;

    /* renamed from: f  reason: collision with root package name */
    private a f1237f;

    /* renamed from: g  reason: collision with root package name */
    private Future<d> f1238g;

    private interface a {
        void a(int[] iArr, int i10);

        void b(int i10);

        int[] c();

        TextClassifier d();

        int e();

        void f(TextClassifier textClassifier);

        void g(int i10);

        int getAutoSizeMinTextSize();

        int getAutoSizeStepGranularity();

        int getAutoSizeTextType();

        void h(int i10);

        void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13);
    }

    class b implements a {
        b() {
        }

        public void a(int[] iArr, int i10) {
            d0.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
        }

        public void b(int i10) {
        }

        public int[] c() {
            return d0.super.getAutoSizeTextAvailableSizes();
        }

        public TextClassifier d() {
            return d0.super.getTextClassifier();
        }

        public int e() {
            return d0.super.getAutoSizeMaxTextSize();
        }

        public void f(TextClassifier textClassifier) {
            d0.super.setTextClassifier(textClassifier);
        }

        public void g(int i10) {
        }

        public int getAutoSizeMinTextSize() {
            return d0.super.getAutoSizeMinTextSize();
        }

        public int getAutoSizeStepGranularity() {
            return d0.super.getAutoSizeStepGranularity();
        }

        public int getAutoSizeTextType() {
            return d0.super.getAutoSizeTextType();
        }

        public void h(int i10) {
            d0.super.setAutoSizeTextTypeWithDefaults(i10);
        }

        public void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) {
            d0.super.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
        }
    }

    class c extends b {
        c() {
            super();
        }

        public void b(int i10) {
            d0.super.setLastBaselineToBottomHeight(i10);
        }

        public void g(int i10) {
            d0.super.setFirstBaselineToTopHeight(i10);
        }
    }

    public d0(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @NonNull
    private k getEmojiTextViewHelper() {
        if (this.f1235d == null) {
            this.f1235d = new k(this);
        }
        return this.f1235d;
    }

    private void q() {
        Future<d> future = this.f1238g;
        if (future != null) {
            try {
                this.f1238g = null;
                l.r(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1232a;
        if (dVar != null) {
            dVar.b();
        }
        x xVar = this.f1233b;
        if (xVar != null) {
            xVar.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (t1.f1448b) {
            return getSuperCaller().e();
        }
        x xVar = this.f1233b;
        if (xVar != null) {
            return xVar.e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (t1.f1448b) {
            return getSuperCaller().getAutoSizeMinTextSize();
        }
        x xVar = this.f1233b;
        if (xVar != null) {
            return xVar.f();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (t1.f1448b) {
            return getSuperCaller().getAutoSizeStepGranularity();
        }
        x xVar = this.f1233b;
        if (xVar != null) {
            return xVar.g();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (t1.f1448b) {
            return getSuperCaller().c();
        }
        x xVar = this.f1233b;
        if (xVar != null) {
            return xVar.h();
        }
        return new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (!t1.f1448b) {
            x xVar = this.f1233b;
            if (xVar != null) {
                return xVar.i();
            }
            return 0;
        } else if (getSuperCaller().getAutoSizeTextType() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return l.u(super.getCustomSelectionActionModeCallback());
    }

    public int getFirstBaselineToTopHeight() {
        return l.e(this);
    }

    public int getLastBaselineToBottomHeight() {
        return l.f(this);
    }

    /* access modifiers changed from: package-private */
    public a getSuperCaller() {
        if (this.f1237f == null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 28) {
                this.f1237f = new c();
            } else if (i10 >= 26) {
                this.f1237f = new b();
            }
        }
        return this.f1237f;
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1232a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1232a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1233b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1233b.k();
    }

    public CharSequence getText() {
        q();
        return super.getText();
    }

    @NonNull
    public TextClassifier getTextClassifier() {
        w wVar;
        if (Build.VERSION.SDK_INT >= 28 || (wVar = this.f1234c) == null) {
            return getSuperCaller().d();
        }
        return wVar.a();
    }

    @NonNull
    public d.a getTextMetricsParamsCompat() {
        return l.j(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f1233b.r(this, onCreateInputConnection, editorInfo);
        return l.a(onCreateInputConnection, editorInfo, this);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        x xVar = this.f1233b;
        if (xVar != null) {
            xVar.o(z10, i10, i11, i12, i13);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        q();
        super.onMeasure(i10, i11);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        boolean z10;
        super.onTextChanged(charSequence, i10, i11, i12);
        x xVar = this.f1233b;
        if (xVar == null || t1.f1448b || !xVar.l()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            this.f1233b.c();
        }
    }

    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        if (t1.f1448b) {
            getSuperCaller().setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
            return;
        }
        x xVar = this.f1233b;
        if (xVar != null) {
            xVar.t(i10, i11, i12, i13);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i10) throws IllegalArgumentException {
        if (t1.f1448b) {
            getSuperCaller().a(iArr, i10);
            return;
        }
        x xVar = this.f1233b;
        if (xVar != null) {
            xVar.u(iArr, i10);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i10) {
        if (t1.f1448b) {
            getSuperCaller().h(i10);
            return;
        }
        x xVar = this.f1233b;
        if (xVar != null) {
            xVar.v(i10);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1232a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f1232a;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        x xVar = this.f1233b;
        if (xVar != null) {
            xVar.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        x xVar = this.f1233b;
        if (xVar != null) {
            xVar.p();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        x xVar = this.f1233b;
        if (xVar != null) {
            xVar.p();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        x xVar = this.f1233b;
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

    public void setFilters(@NonNull InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setFirstBaselineToTopHeight(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().g(i10);
        } else {
            l.o(this, i10);
        }
    }

    public void setLastBaselineToBottomHeight(int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().b(i10);
        } else {
            l.p(this, i10);
        }
    }

    public void setLineHeight(int i10) {
        l.q(this, i10);
    }

    public void setPrecomputedText(@NonNull d dVar) {
        l.r(this, dVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1232a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1232a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1233b.w(colorStateList);
        this.f1233b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1233b.x(mode);
        this.f1233b.b();
    }

    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        x xVar = this.f1233b;
        if (xVar != null) {
            xVar.q(context, i10);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        w wVar;
        if (Build.VERSION.SDK_INT >= 28 || (wVar = this.f1234c) == null) {
            getSuperCaller().f(textClassifier);
        } else {
            wVar.b(textClassifier);
        }
    }

    public void setTextFuture(Future<d> future) {
        this.f1238g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(@NonNull d.a aVar) {
        l.t(this, aVar);
    }

    public void setTextSize(int i10, float f10) {
        if (t1.f1448b) {
            super.setTextSize(i10, f10);
            return;
        }
        x xVar = this.f1233b;
        if (xVar != null) {
            xVar.A(i10, f10);
        }
    }

    public void setTypeface(Typeface typeface, int i10) {
        if (!this.f1236e) {
            Typeface typeface2 = null;
            if (typeface != null && i10 > 0) {
                typeface2 = e.a(getContext(), typeface, i10);
            }
            this.f1236e = true;
            if (typeface2 != null) {
                typeface = typeface2;
            }
            try {
                super.setTypeface(typeface, i10);
            } finally {
                this.f1236e = false;
            }
        }
    }

    public d0(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public d0(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(e1.b(context), attributeSet, i10);
        this.f1236e = false;
        this.f1237f = null;
        c1.a(this, getContext());
        d dVar = new d(this);
        this.f1232a = dVar;
        dVar.e(attributeSet, i10);
        x xVar = new x(this);
        this.f1233b = xVar;
        xVar.m(attributeSet, i10);
        xVar.b();
        this.f1234c = new w(this);
        getEmojiTextViewHelper().c(attributeSet, i10);
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b10 = i10 != 0 ? e.a.b(context, i10) : null;
        Drawable b11 = i11 != 0 ? e.a.b(context, i11) : null;
        Drawable b12 = i12 != 0 ? e.a.b(context, i12) : null;
        if (i13 != 0) {
            drawable = e.a.b(context, i13);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(b10, b11, b12, drawable);
        x xVar = this.f1233b;
        if (xVar != null) {
            xVar.p();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b10 = i10 != 0 ? e.a.b(context, i10) : null;
        Drawable b11 = i11 != 0 ? e.a.b(context, i11) : null;
        Drawable b12 = i12 != 0 ? e.a.b(context, i12) : null;
        if (i13 != 0) {
            drawable = e.a.b(context, i13);
        }
        setCompoundDrawablesWithIntrinsicBounds(b10, b11, b12, drawable);
        x xVar = this.f1233b;
        if (xVar != null) {
            xVar.p();
        }
    }
}

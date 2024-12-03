package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.core.widget.b;
import androidx.core.widget.l;
import d.a;

public class AppCompatButton extends Button implements b {

    /* renamed from: a  reason: collision with root package name */
    private final d f1009a;

    /* renamed from: b  reason: collision with root package name */
    private final x f1010b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private k f1011c;

    public AppCompatButton(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.buttonStyle);
    }

    @NonNull
    private k getEmojiTextViewHelper() {
        if (this.f1011c == null) {
            this.f1011c = new k(this);
        }
        return this.f1011c;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1009a;
        if (dVar != null) {
            dVar.b();
        }
        x xVar = this.f1010b;
        if (xVar != null) {
            xVar.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (t1.f1448b) {
            return super.getAutoSizeMaxTextSize();
        }
        x xVar = this.f1010b;
        if (xVar != null) {
            return xVar.e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (t1.f1448b) {
            return super.getAutoSizeMinTextSize();
        }
        x xVar = this.f1010b;
        if (xVar != null) {
            return xVar.f();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (t1.f1448b) {
            return super.getAutoSizeStepGranularity();
        }
        x xVar = this.f1010b;
        if (xVar != null) {
            return xVar.g();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (t1.f1448b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        x xVar = this.f1010b;
        if (xVar != null) {
            return xVar.h();
        }
        return new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (!t1.f1448b) {
            x xVar = this.f1010b;
            if (xVar != null) {
                return xVar.i();
            }
            return 0;
        } else if (super.getAutoSizeTextType() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return l.u(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1009a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1009a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1010b.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1010b.k();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        x xVar = this.f1010b;
        if (xVar != null) {
            xVar.o(z10, i10, i11, i12, i13);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        boolean z10;
        super.onTextChanged(charSequence, i10, i11, i12);
        x xVar = this.f1010b;
        if (xVar == null || t1.f1448b || !xVar.l()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            this.f1010b.c();
        }
    }

    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        if (t1.f1448b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
            return;
        }
        x xVar = this.f1010b;
        if (xVar != null) {
            xVar.t(i10, i11, i12, i13);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(@NonNull int[] iArr, int i10) throws IllegalArgumentException {
        if (t1.f1448b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
            return;
        }
        x xVar = this.f1010b;
        if (xVar != null) {
            xVar.u(iArr, i10);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i10) {
        if (t1.f1448b) {
            super.setAutoSizeTextTypeWithDefaults(i10);
            return;
        }
        x xVar = this.f1010b;
        if (xVar != null) {
            xVar.v(i10);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1009a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f1009a;
        if (dVar != null) {
            dVar.g(i10);
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

    public void setSupportAllCaps(boolean z10) {
        x xVar = this.f1010b;
        if (xVar != null) {
            xVar.s(z10);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1009a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1009a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1010b.w(colorStateList);
        this.f1010b.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1010b.x(mode);
        this.f1010b.b();
    }

    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        x xVar = this.f1010b;
        if (xVar != null) {
            xVar.q(context, i10);
        }
    }

    public void setTextSize(int i10, float f10) {
        if (t1.f1448b) {
            super.setTextSize(i10, f10);
            return;
        }
        x xVar = this.f1010b;
        if (xVar != null) {
            xVar.A(i10, f10);
        }
    }

    public AppCompatButton(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(e1.b(context), attributeSet, i10);
        c1.a(this, getContext());
        d dVar = new d(this);
        this.f1009a = dVar;
        dVar.e(attributeSet, i10);
        x xVar = new x(this);
        this.f1010b = xVar;
        xVar.m(attributeSet, i10);
        xVar.b();
        getEmojiTextViewHelper().c(attributeSet, i10);
    }
}

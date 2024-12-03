package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.i;
import bf.b;
import bf.k;
import bf.l;
import com.google.android.material.internal.j;
import com.google.android.material.internal.p;
import wf.a;

public class TextInputEditText extends i {

    /* renamed from: g  reason: collision with root package name */
    private final Rect f20226g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f20227h;

    public TextInputEditText(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.editTextStyle);
    }

    private boolean e(TextInputLayout textInputLayout) {
        return textInputLayout != null && this.f20227h;
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public void getFocusedRect(Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (e(textInputLayout) && rect != null) {
            textInputLayout.getFocusedRect(this.f20226g);
            rect.bottom = this.f20226g.bottom;
        }
    }

    public boolean getGlobalVisibleRect(Rect rect, Point point) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (e(textInputLayout)) {
            return textInputLayout.getGlobalVisibleRect(rect, point);
        }
        return super.getGlobalVisibleRect(rect, point);
    }

    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout == null || !textInputLayout.P()) {
            return super.getHint();
        }
        return textInputLayout.getHint();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.P() && super.getHint() == null && j.c()) {
            setHint("");
        }
    }

    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return onCreateInputConnection;
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        getTextInputLayout();
    }

    public boolean requestRectangleOnScreen(Rect rect) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!e(textInputLayout) || rect == null) {
            return super.requestRectangleOnScreen(rect);
        }
        this.f20226g.set(rect.left, rect.top, rect.right, rect.bottom + (textInputLayout.getHeight() - getHeight()));
        return super.requestRectangleOnScreen(this.f20226g);
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z10) {
        this.f20227h = z10;
    }

    public TextInputEditText(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(a.c(context, attributeSet, i10, 0), attributeSet, i10);
        this.f20226g = new Rect();
        TypedArray i11 = p.i(context, attributeSet, l.TextInputEditText, i10, k.Widget_Design_TextInputEditText, new int[0]);
        setTextInputLayoutFocusedRectEnabled(i11.getBoolean(l.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
        i11.recycle();
    }
}

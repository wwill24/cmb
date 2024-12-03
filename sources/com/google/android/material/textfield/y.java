package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import bf.e;
import bf.j;

class y extends t {

    /* renamed from: e  reason: collision with root package name */
    private int f20384e = e.design_password_eye;

    /* renamed from: f  reason: collision with root package name */
    private EditText f20385f;

    /* renamed from: g  reason: collision with root package name */
    private final View.OnClickListener f20386g = new x(this);

    y(@NonNull s sVar, int i10) {
        super(sVar);
        if (i10 != 0) {
            this.f20384e = i10;
        }
    }

    private boolean w() {
        EditText editText = this.f20385f;
        if (editText == null || !(editText.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            return false;
        }
        return true;
    }

    private static boolean x(EditText editText) {
        if (editText == null || (editText.getInputType() != 16 && editText.getInputType() != 128 && editText.getInputType() != 144 && editText.getInputType() != 224)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        EditText editText = this.f20385f;
        if (editText != null) {
            int selectionEnd = editText.getSelectionEnd();
            if (w()) {
                this.f20385f.setTransformationMethod((TransformationMethod) null);
            } else {
                this.f20385f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                this.f20385f.setSelection(selectionEnd);
            }
            r();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(CharSequence charSequence, int i10, int i11, int i12) {
        r();
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return j.password_toggle_content_description;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f20384e;
    }

    /* access modifiers changed from: package-private */
    public View.OnClickListener f() {
        return this.f20386g;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return !w();
    }

    /* access modifiers changed from: package-private */
    public void n(EditText editText) {
        this.f20385f = editText;
        r();
    }

    /* access modifiers changed from: package-private */
    public void s() {
        if (x(this.f20385f)) {
            this.f20385f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /* access modifiers changed from: package-private */
    public void u() {
        EditText editText = this.f20385f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}

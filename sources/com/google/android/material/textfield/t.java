package com.google.android.material.textfield;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.c;
import androidx.core.view.accessibility.k;
import com.google.android.material.internal.CheckableImageButton;

abstract class t {

    /* renamed from: a  reason: collision with root package name */
    final TextInputLayout f20347a;

    /* renamed from: b  reason: collision with root package name */
    final s f20348b;

    /* renamed from: c  reason: collision with root package name */
    final Context f20349c;

    /* renamed from: d  reason: collision with root package name */
    final CheckableImageButton f20350d;

    t(@NonNull s sVar) {
        this.f20347a = sVar.f20320a;
        this.f20348b = sVar;
        this.f20349c = sVar.getContext();
        this.f20350d = sVar.r();
    }

    /* access modifiers changed from: package-private */
    public void a(Editable editable) {
    }

    /* access modifiers changed from: package-private */
    public void b(CharSequence charSequence, int i10, int i11, int i12) {
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener e() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public View.OnClickListener f() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public View.OnFocusChangeListener g() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public c.b h() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean i(int i10) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void n(EditText editText) {
    }

    /* access modifiers changed from: package-private */
    public void o(View view, @NonNull k kVar) {
    }

    /* access modifiers changed from: package-private */
    public void p(View view, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: package-private */
    public void q(boolean z10) {
    }

    /* access modifiers changed from: package-private */
    public final void r() {
        this.f20348b.K(false);
    }

    /* access modifiers changed from: package-private */
    public void s() {
    }

    /* access modifiers changed from: package-private */
    public boolean t() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void u() {
    }
}

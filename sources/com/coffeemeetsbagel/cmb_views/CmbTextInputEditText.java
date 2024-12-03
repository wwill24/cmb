package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.jvm.internal.j;
import qj.q;

public final class CmbTextInputEditText extends TextInputEditText {
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final io.reactivex.subjects.a<Editable> f11491j;

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CmbTextInputEditText f11492a;

        a(CmbTextInputEditText cmbTextInputEditText) {
            this.f11492a = cmbTextInputEditText;
        }

        public void afterTextChanged(Editable editable) {
            if (editable != null) {
                this.f11492a.f11491j.d(editable);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CmbTextInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.editTextStyle);
        j.g(context, "ctx");
    }

    public final q<Editable> g() {
        q<Editable> C0 = this.f11491j.P().d0(1).C0();
        j.f(C0, "textChangedRelay.hide().replay(1).refCount()");
        return C0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CmbTextInputEditText(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        j.g(context, "ctx");
        io.reactivex.subjects.a<Editable> C0 = io.reactivex.subjects.a.C0();
        j.f(C0, "create<Editable>()");
        this.f11491j = C0;
        addTextChangedListener(new a(this));
    }
}

package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.appcompat.widget.i;
import io.reactivex.subjects.PublishSubject;
import q5.b;
import q5.c;
import q5.f;
import q5.p;

public class CmbEditText extends i {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final PublishSubject<Editable> f11476g;

    /* renamed from: h  reason: collision with root package name */
    private final PublishSubject<t5.a> f11477h;

    class a implements TextWatcher {
        a() {
        }

        public void afterTextChanged(Editable editable) {
            CmbEditText.this.f11476g.d(editable);
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public CmbEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.editTextStyle);
        j(context, attributeSet);
        setLayerType(1, (Paint) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean h(TextView textView, int i10, KeyEvent keyEvent) {
        this.f11477h.d(new t5.a(textView, i10, keyEvent));
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i() {
        ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 1);
    }

    private void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.CmbEditText);
        k(context, obtainStyledAttributes.getString(p.CmbEditText_customFont));
        obtainStyledAttributes.recycle();
    }

    public boolean k(Context context, String str) {
        Typeface c10 = f.c(context, str);
        if (c10 == null) {
            return false;
        }
        setTypeface(c10);
        return true;
    }

    public void l() {
        requestFocus();
        post(new c(this));
    }

    public CmbEditText(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11476g = PublishSubject.C0();
        this.f11477h = PublishSubject.C0();
        j(context, attributeSet);
        setLayerType(1, (Paint) null);
        addTextChangedListener(new a());
        setOnEditorActionListener(new b(this));
    }
}

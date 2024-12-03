package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.n0;
import bf.f;
import bf.h;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.o;
import com.google.android.material.internal.r;
import com.google.android.material.textfield.TextInputLayout;

class ChipTextInputComboView extends FrameLayout implements Checkable {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Chip f20397a;

    /* renamed from: b  reason: collision with root package name */
    private final TextInputLayout f20398b;

    /* renamed from: c  reason: collision with root package name */
    private final EditText f20399c;

    /* renamed from: d  reason: collision with root package name */
    private TextWatcher f20400d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f20401e;

    private class b extends o {
        private b() {
        }

        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f20397a.setText(ChipTextInputComboView.this.c("00"));
                return;
            }
            String a10 = ChipTextInputComboView.this.c(editable);
            Chip b10 = ChipTextInputComboView.this.f20397a;
            if (TextUtils.isEmpty(a10)) {
                a10 = ChipTextInputComboView.this.c("00");
            }
            b10.setText(a10);
        }
    }

    public ChipTextInputComboView(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public String c(CharSequence charSequence) {
        return TimeModel.a(getResources(), charSequence);
    }

    private void d() {
        this.f20399c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
    }

    public boolean isChecked() {
        return this.f20397a.isChecked();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d();
    }

    public void setChecked(boolean z10) {
        int i10;
        this.f20397a.setChecked(z10);
        EditText editText = this.f20399c;
        int i11 = 0;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 4;
        }
        editText.setVisibility(i10);
        Chip chip = this.f20397a;
        if (z10) {
            i11 = 8;
        }
        chip.setVisibility(i11);
        if (isChecked()) {
            r.n(this.f20399c);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f20397a.setOnClickListener(onClickListener);
    }

    public void setTag(int i10, Object obj) {
        this.f20397a.setTag(i10, obj);
    }

    public void toggle() {
        this.f20397a.toggle();
    }

    public ChipTextInputComboView(@NonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(h.material_time_chip, this, false);
        this.f20397a = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(h.material_time_input, this, false);
        this.f20398b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f20399c = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.f20400d = bVar;
        editText.addTextChangedListener(bVar);
        d();
        addView(chip);
        addView(textInputLayout);
        this.f20401e = (TextView) findViewById(f.material_label);
        editText.setId(n0.k());
        n0.F0(this.f20401e, editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}

package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.appcompat.app.k;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.c;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.r;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import vf.a;

public class MaterialComponentsViewInflater extends k {
    /* access modifiers changed from: protected */
    @NonNull
    public c c(@NonNull Context context, AttributeSet attributeSet) {
        return new MaterialAutoCompleteTextView(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatButton d(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public AppCompatCheckBox e(Context context, AttributeSet attributeSet) {
        return new MaterialCheckBox(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public r k(Context context, AttributeSet attributeSet) {
        return new MaterialRadioButton(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public d0 o(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }
}

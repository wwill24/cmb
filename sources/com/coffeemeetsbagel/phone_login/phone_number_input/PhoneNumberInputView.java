package com.coffeemeetsbagel.phone_login.phone_number_input;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.util.d;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.country.CmbCountry;
import com.coffeemeetsbagel.onboarding.OnboardingBaseLayout;
import lc.c;
import lc.u;

public class PhoneNumberInputView extends OnboardingBaseLayout {

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f35720c;

    /* renamed from: d  reason: collision with root package name */
    private CmbEditText f35721d;

    /* renamed from: e  reason: collision with root package name */
    private CmbTextView f35722e;

    /* renamed from: f  reason: collision with root package name */
    private CmbTextView f35723f;

    /* renamed from: g  reason: collision with root package name */
    private CmbTextView f35724g;

    /* renamed from: h  reason: collision with root package name */
    private CmbTextView f35725h;

    /* renamed from: j  reason: collision with root package name */
    private CmbTextView f35726j;

    class a implements TextWatcher {
        a() {
        }

        public void afterTextChanged(Editable editable) {
            PhoneNumberInputView.this.d(editable.length() >= 1, true);
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            PhoneNumberInputView.this.i();
        }
    }

    public PhoneNumberInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean j(TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 != 6 || TextUtils.isEmpty(this.f35721d.getText().toString()) || !this.f35725h.isEnabled()) {
            return false;
        }
        this.f35725h.performClick();
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k() {
        if (this.f35721d.getText() != null) {
            CmbEditText cmbEditText = this.f35721d;
            cmbEditText.setSelection(cmbEditText.getText().length());
        }
    }

    public void d(boolean z10, boolean z11) {
        Resources resources;
        int i10;
        super.d(z10, z11);
        this.f35725h.setClickable(z10);
        this.f35725h.setEnabled(z10);
        CmbTextView cmbTextView = this.f35725h;
        if (z10) {
            resources = getResources();
            i10 = R.color.white;
        } else {
            resources = getResources();
            i10 = R.color.gray;
        }
        cmbTextView.setTextColor(resources.getColor(i10));
    }

    public CmbTextView getContactSupport() {
        return this.f35726j;
    }

    public CmbEditText getPhoneEditText() {
        return this.f35721d;
    }

    public d<String, String> getPhoneNumberInput() {
        return new d<>(new u().a(this.f35723f.getText().toString(), this.f35721d.getText().toString()), this.f35721d.getText().toString());
    }

    public CmbTextView getStartedButton() {
        return this.f35725h;
    }

    public void i() {
        this.f35724g.setText("");
        f(this.f35721d, false);
        f(this.f35720c, false);
        this.f35724g.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f35720c = (LinearLayout) findViewById(R.id.phone_number_input_country_picker);
        this.f35721d = (CmbEditText) findViewById(R.id.phone_number_input_edittext);
        this.f35722e = (CmbTextView) findViewById(R.id.phone_number_input_flag_icon);
        this.f35723f = (CmbTextView) findViewById(R.id.phone_number_input_country_code);
        this.f35724g = (CmbTextView) findViewById(R.id.phone_number_input_error);
        this.f35725h = (CmbTextView) findViewById(R.id.phone_number_input_get_started);
        this.f35726j = (CmbTextView) findViewById(R.id.phone_number_contact_support);
        d(false, true);
        this.f35721d.requestFocus();
        c.g(getContext(), this.f35721d);
        this.f35721d.setOnEditorActionListener(new k(this));
        this.f35721d.addTextChangedListener(new a());
        this.f35721d.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources().getDrawable(R.drawable.lock), (Drawable) null);
    }

    public void setFlagAndCode(CmbCountry cmbCountry) {
        this.f35722e.setText(cmbCountry.f());
        this.f35723f.setText(cmbCountry.d());
        f(this.f35720c, false);
    }

    public void setPhoneNumberErrorState(int i10) {
        if (i10 > 0) {
            this.f35724g.setText(i10);
        } else {
            this.f35724g.setText("");
        }
        f(this.f35721d, true);
        f(this.f35720c, true);
        this.f35724g.setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    public void setPreviousPhoneNumberInput(String str) {
        this.f35721d.setText(str);
        this.f35721d.post(new j(this));
    }
}

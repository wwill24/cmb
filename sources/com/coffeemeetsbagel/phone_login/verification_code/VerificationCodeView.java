package com.coffeemeetsbagel.phone_login.verification_code;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.onboarding.OnboardingBaseLayout;
import lc.u;

public class VerificationCodeView extends OnboardingBaseLayout {

    /* renamed from: c  reason: collision with root package name */
    private CmbEditText f35755c;

    /* renamed from: d  reason: collision with root package name */
    private CmbEditText f35756d;

    /* renamed from: e  reason: collision with root package name */
    private CmbEditText f35757e;

    /* renamed from: f  reason: collision with root package name */
    private CmbEditText f35758f;

    /* renamed from: g  reason: collision with root package name */
    private CmbEditText f35759g;

    /* renamed from: h  reason: collision with root package name */
    private CmbEditText f35760h;

    /* renamed from: j  reason: collision with root package name */
    private CmbTextView f35761j;

    /* renamed from: k  reason: collision with root package name */
    private CmbTextView f35762k;

    /* renamed from: l  reason: collision with root package name */
    private CmbTextView f35763l;

    /* renamed from: m  reason: collision with root package name */
    private CmbTextView f35764m;

    private class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        private final CmbEditText f35765a;

        /* renamed from: b  reason: collision with root package name */
        private final CmbEditText f35766b;

        /* renamed from: c  reason: collision with root package name */
        private final CmbEditText f35767c;

        private a(CmbEditText cmbEditText, CmbEditText cmbEditText2, CmbEditText cmbEditText3) {
            this.f35765a = cmbEditText;
            this.f35766b = cmbEditText2;
            this.f35767c = cmbEditText3;
        }

        public void afterTextChanged(Editable editable) {
            VerificationCodeView.this.o();
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            VerificationCodeView.this.k();
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (charSequence != null && charSequence.length() == 1) {
                this.f35765a.clearFocus();
                CmbEditText cmbEditText = this.f35766b;
                if (cmbEditText != null) {
                    cmbEditText.requestFocus();
                    this.f35766b.setCursorVisible(true);
                    return;
                }
                this.f35765a.requestFocus();
                this.f35765a.setCursorVisible(true);
            } else if (charSequence != null && charSequence.length() == 0) {
                this.f35765a.clearFocus();
                CmbEditText cmbEditText2 = this.f35767c;
                if (cmbEditText2 != null) {
                    cmbEditText2.requestFocus();
                    this.f35767c.setCursorVisible(true);
                    return;
                }
                this.f35765a.requestFocus();
                this.f35765a.setCursorVisible(true);
            }
        }
    }

    private static class b implements View.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        private final CmbEditText f35769a;

        /* renamed from: b  reason: collision with root package name */
        private final CmbEditText f35770b;

        /* renamed from: c  reason: collision with root package name */
        private final CmbEditText f35771c;

        private b(CmbEditText cmbEditText, CmbEditText cmbEditText2, CmbEditText cmbEditText3) {
            this.f35769a = cmbEditText;
            this.f35770b = cmbEditText2;
            this.f35771c = cmbEditText3;
        }

        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            CmbEditText cmbEditText;
            CmbEditText cmbEditText2;
            if (i10 == 67 && TextUtils.isEmpty(this.f35769a.getText().toString()) && (cmbEditText2 = this.f35771c) != null) {
                cmbEditText2.requestFocus();
                this.f35771c.setCursorVisible(true);
                return false;
            } else if (keyEvent.getAction() != 0 || TextUtils.isEmpty(this.f35769a.getText().toString()) || (cmbEditText = this.f35770b) == null) {
                return false;
            } else {
                cmbEditText.requestFocus();
                this.f35770b.setCursorVisible(true);
                return false;
            }
        }
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean h() {
        if (TextUtils.isEmpty(this.f35755c.getText()) || TextUtils.isEmpty(this.f35756d.getText()) || TextUtils.isEmpty(this.f35757e.getText()) || TextUtils.isEmpty(this.f35758f.getText()) || ((this.f35759g.getVisibility() != 8 && TextUtils.isEmpty(this.f35759g.getText())) || (this.f35760h.getVisibility() != 8 && TextUtils.isEmpty(this.f35760h.getText())))) {
            return false;
        }
        return true;
    }

    private void j() {
        this.f35755c.setFocusableInTouchMode(true);
        this.f35755c.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(2, 0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean n(TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 != 6 || !h()) {
            return false;
        }
        this.f35764m.performClick();
        return true;
    }

    private void setIMEDoneAction(int i10) {
        if (i10 >= 6) {
            this.f35760h.setImeOptions(6);
        } else if (i10 >= 5) {
            this.f35759g.setImeOptions(6);
        } else {
            this.f35758f.setImeOptions(6);
        }
    }

    private void setOnEditorActionListener(CmbEditText cmbEditText) {
        cmbEditText.setOnEditorActionListener(new i(this));
    }

    private void setVerifyGetStartedEnabled(boolean z10) {
        Resources resources;
        int i10;
        this.f35764m.setClickable(z10);
        this.f35764m.setEnabled(z10);
        CmbTextView cmbTextView = this.f35764m;
        if (z10) {
            resources = getResources();
            i10 = R.color.white;
        } else {
            resources = getResources();
            i10 = R.color.gray;
        }
        cmbTextView.setTextColor(resources.getColor(i10));
    }

    public String getCodeInput() {
        return new u().b(this.f35755c.getText().toString(), this.f35756d.getText().toString(), this.f35757e.getText().toString(), this.f35758f.getText().toString(), this.f35759g.getText().toString(), this.f35760h.getText().toString());
    }

    public CmbTextView getResendCodeButton() {
        return this.f35763l;
    }

    public CmbTextView getVerify() {
        return this.f35764m;
    }

    public void i() {
        this.f35755c.getText().clear();
        this.f35756d.getText().clear();
        this.f35757e.getText().clear();
        this.f35758f.getText().clear();
        this.f35759g.getText().clear();
        this.f35760h.getText().clear();
        this.f35755c.requestFocus();
        this.f35755c.setCursorVisible(true);
    }

    public void k() {
        f(this.f35755c, false);
        f(this.f35756d, false);
        f(this.f35757e, false);
        f(this.f35758f, false);
        f(this.f35759g, false);
        f(this.f35760h, false);
        this.f35761j.setText("");
        this.f35761j.setVisibility(4);
    }

    public void l() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public void m() {
        this.f35763l.setVisibility(8);
    }

    public void o() {
        d(h(), true);
        setVerifyGetStartedEnabled(h());
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f35755c = (CmbEditText) findViewById(R.id.verification_code_edittext1);
        this.f35756d = (CmbEditText) findViewById(R.id.verification_code_edittext2);
        this.f35757e = (CmbEditText) findViewById(R.id.verification_code_edittext3);
        this.f35758f = (CmbEditText) findViewById(R.id.verification_code_edittext4);
        this.f35759g = (CmbEditText) findViewById(R.id.verification_code_edittext5);
        this.f35760h = (CmbEditText) findViewById(R.id.verification_code_edittext6);
        this.f35761j = (CmbTextView) findViewById(R.id.verification_code_error);
        this.f35762k = (CmbTextView) findViewById(R.id.verification_code_should_arrive_in);
        this.f35763l = (CmbTextView) findViewById(R.id.verification_code_resend_button);
        this.f35764m = (CmbTextView) findViewById(R.id.verification_code_verify);
        d(false, true);
        j();
    }

    public void p() {
        this.f35763l.setVisibility(0);
    }

    public void q(int i10) {
        if (i10 > 0) {
            this.f35761j.setText(i10);
        } else {
            this.f35761j.setText("");
        }
        f(this.f35755c, true);
        f(this.f35756d, true);
        f(this.f35757e, true);
        f(this.f35758f, true);
        f(this.f35759g, true);
        f(this.f35760h, true);
        this.f35761j.setVisibility(0);
    }

    public void setNumberOfAuthCodeInputs(int i10) {
        CmbEditText cmbEditText;
        int i11;
        CmbEditText cmbEditText2;
        CmbEditText cmbEditText3;
        CmbEditText cmbEditText4;
        CmbEditText cmbEditText5;
        if (i10 >= 6) {
            cmbEditText = this.f35760h;
        } else if (i10 >= 5) {
            cmbEditText = this.f35759g;
        } else {
            cmbEditText = this.f35758f;
        }
        setOnEditorActionListener(cmbEditText);
        CmbEditText cmbEditText6 = this.f35760h;
        int i12 = 0;
        if (i10 >= 6) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        cmbEditText6.setVisibility(i11);
        CmbEditText cmbEditText7 = this.f35759g;
        if (i10 < 5) {
            i12 = 8;
        }
        cmbEditText7.setVisibility(i12);
        setIMEDoneAction(i10);
        CmbEditText cmbEditText8 = this.f35758f;
        if (i10 >= 5) {
            cmbEditText2 = this.f35759g;
        } else {
            cmbEditText2 = null;
        }
        cmbEditText8.addTextChangedListener(new a(cmbEditText8, cmbEditText2, this.f35757e));
        CmbEditText cmbEditText9 = this.f35759g;
        if (i10 >= 6) {
            cmbEditText3 = this.f35760h;
        } else {
            cmbEditText3 = null;
        }
        cmbEditText9.addTextChangedListener(new a(cmbEditText9, cmbEditText3, this.f35758f));
        CmbEditText cmbEditText10 = this.f35760h;
        cmbEditText10.addTextChangedListener(new a(cmbEditText10, (CmbEditText) null, this.f35759g));
        CmbEditText cmbEditText11 = this.f35758f;
        if (i10 >= 5) {
            cmbEditText4 = this.f35759g;
        } else {
            cmbEditText4 = null;
        }
        cmbEditText11.setOnKeyListener(new b(cmbEditText11, cmbEditText4, this.f35757e));
        CmbEditText cmbEditText12 = this.f35759g;
        if (i10 >= 6) {
            cmbEditText5 = this.f35760h;
        } else {
            cmbEditText5 = null;
        }
        cmbEditText12.setOnKeyListener(new b(cmbEditText12, cmbEditText5, this.f35758f));
        CmbEditText cmbEditText13 = this.f35760h;
        cmbEditText13.setOnKeyListener(new b(cmbEditText13, (CmbEditText) null, this.f35759g));
        CmbEditText cmbEditText14 = this.f35755c;
        cmbEditText14.addTextChangedListener(new a(cmbEditText14, this.f35756d, (CmbEditText) null));
        CmbEditText cmbEditText15 = this.f35755c;
        cmbEditText15.setOnKeyListener(new b(cmbEditText15, this.f35756d, (CmbEditText) null));
        CmbEditText cmbEditText16 = this.f35756d;
        cmbEditText16.addTextChangedListener(new a(cmbEditText16, this.f35757e, this.f35755c));
        CmbEditText cmbEditText17 = this.f35756d;
        cmbEditText17.setOnKeyListener(new b(cmbEditText17, this.f35757e, this.f35755c));
        CmbEditText cmbEditText18 = this.f35757e;
        cmbEditText18.addTextChangedListener(new a(cmbEditText18, this.f35758f, this.f35756d));
        CmbEditText cmbEditText19 = this.f35757e;
        cmbEditText19.setOnKeyListener(new b(cmbEditText19, this.f35758f, this.f35756d));
    }

    public void setSmsCode(String str) {
        this.f35755c.setText(String.valueOf(str.charAt(0)));
        this.f35756d.setText(String.valueOf(str.charAt(1)));
        this.f35757e.setText(String.valueOf(str.charAt(2)));
        this.f35758f.setText(String.valueOf(str.charAt(3)));
        if (str.length() >= 5) {
            this.f35759g.setText(String.valueOf(str.charAt(4)));
        }
        if (str.length() == 6) {
            this.f35760h.setText(String.valueOf(str.charAt(5)));
        }
    }

    public void setTimeRemainingText(String str) {
        this.f35762k.setVisibility(0);
        this.f35762k.setText(str);
    }
}

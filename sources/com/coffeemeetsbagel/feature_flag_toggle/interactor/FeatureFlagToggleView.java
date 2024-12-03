package com.coffeemeetsbagel.feature_flag_toggle.interactor;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.coffeemeetsbagel.R;
import com.jakewharton.rxrelay2.b;
import j5.x;
import qj.q;

public class FeatureFlagToggleView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private EditText f13466a;

    /* renamed from: b  reason: collision with root package name */
    private Button f13467b;

    public FeatureFlagToggleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    public void b(TextWatcher textWatcher) {
        this.f13466a.addTextChangedListener(textWatcher);
    }

    /* access modifiers changed from: package-private */
    public q<x> c() {
        b C0 = b.C0();
        this.f13467b.setOnClickListener(new q(C0));
        return C0.P();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f13466a = (EditText) findViewById(R.id.feature_flag_search_field);
        this.f13467b = (Button) findViewById(R.id.feature_flag_clear_search_button);
    }

    /* access modifiers changed from: package-private */
    public void setSearchText(String str) {
        this.f13466a.setText(str);
    }
}

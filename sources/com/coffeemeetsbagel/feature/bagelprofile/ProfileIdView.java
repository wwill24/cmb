package com.coffeemeetsbagel.feature.bagelprofile;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbLinearLayout;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import i7.a;

public class ProfileIdView extends CmbLinearLayout {

    /* renamed from: b  reason: collision with root package name */
    private CmbTextView f12821b;

    /* renamed from: c  reason: collision with root package name */
    private CmbTextView f12822c;

    /* renamed from: d  reason: collision with root package name */
    private CmbTextView f12823d;

    public ProfileIdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(CmbTextView cmbTextView, View view) {
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("Copied Text", cmbTextView.getText()));
        }
    }

    private void setCopyClickListeners(CmbTextView cmbTextView) {
        cmbTextView.setOnClickListener(new a(this, cmbTextView));
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f12821b = (CmbTextView) findViewById(R.id.profile_bagel_id_title);
        this.f12822c = (CmbTextView) findViewById(R.id.profile_bagel_id);
        this.f12823d = (CmbTextView) findViewById(R.id.profile_profile_id);
    }

    public void setBagelId(String str) {
        this.f12822c.setText(str);
        setCopyClickListeners(this.f12822c);
    }

    public void setProfileId(String str) {
        this.f12823d.setText(str);
        setCopyClickListeners(this.f12823d);
    }
}

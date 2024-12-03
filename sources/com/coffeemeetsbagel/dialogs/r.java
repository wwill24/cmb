package com.coffeemeetsbagel.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import z9.e;

public class r extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private e f12149a;

    public r(e eVar, Activity activity) {
        super(activity);
        this.f12149a = eVar;
        setTitle(R.string.upload_now);
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        setContentView(R.layout.dialog_hold_reason_dls);
        ((CmbTextView) findViewById(R.id.textView_done)).setOnClickListener(new q(this, (CmbEditText) findViewById(R.id.editText_reason)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(CmbEditText cmbEditText, View view) {
        if (cmbEditText.getText() != null) {
            this.f12149a.V0(cmbEditText.getText().toString());
        }
        dismiss();
    }
}

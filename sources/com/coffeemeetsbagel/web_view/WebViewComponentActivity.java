package com.coffeemeetsbagel.web_view;

import android.content.Intent;
import android.view.ViewGroup;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.web_view.g;
import j5.t;
import sb.a;

public class WebViewComponentActivity extends t<c, i> {
    private void U0() {
        Intent intent = getIntent();
        if (intent == null) {
            V0();
        } else if (intent.hasExtra("url")) {
            ((c) this.f7848e).D0(intent.getStringExtra("url"));
        }
    }

    private void V0() {
        a.i(getWindow().getDecorView().findViewById(16908290), R.string.generic_error);
    }

    /* access modifiers changed from: protected */
    public String K0() {
        return "";
    }

    /* access modifiers changed from: protected */
    public int Q0() {
        return R.string.empty;
    }

    /* access modifiers changed from: protected */
    /* renamed from: S0 */
    public c G0() {
        return new c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: T0 */
    public i H0(ViewGroup viewGroup) {
        U0();
        return new g((g.a) ((c) this.f7848e).A0()).b(viewGroup);
    }
}

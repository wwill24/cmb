package com.coffeemeetsbagel.limelight.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.mparticle.identity.IdentityHttpResponse;
import gk.f;
import j5.x;
import k6.w;
import kotlin.jvm.internal.j;
import qj.q;

public final class LimelightDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private final f f34361a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LimelightDialog(Context context) {
        super(context);
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f34361a = b.b(new LimelightDialog$binding$2(context));
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            window.setBackgroundDrawableResource(17170445);
        }
        setContentView(a().getRoot());
    }

    public final w a() {
        return (w) this.f34361a.getValue();
    }

    public final q<x> b() {
        q<x> s10 = ((CmbTextView) findViewById(R.id.confirm_button)).s();
        j.f(s10, "findViewById<CmbTextView….confirm_button).clicks()");
        return s10;
    }

    public final q<x> c() {
        q<x> s10 = ((CmbTextView) findViewById(R.id.not_now)).s();
        j.f(s10, "findViewById<CmbTextView>(R.id.not_now).clicks()");
        return s10;
    }
}

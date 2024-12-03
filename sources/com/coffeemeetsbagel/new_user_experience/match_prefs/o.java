package com.coffeemeetsbagel.new_user_experience.match_prefs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class o extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private final a f35452a;

    public interface a {
        void a();

        void b();

        void c();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(a aVar, Context context) {
        super(context, R.style.onboarding_flow_dialog);
        j.g(aVar, "listener");
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f35452a = aVar;
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        setContentView(R.layout.onboarding_component_match_preference_dialog);
        ((TextView) findViewById(R.id.confirm_button)).setOnClickListener(new m(this));
        ((TextView) findViewById(R.id.abort_button)).setOnClickListener(new n(this));
    }

    /* access modifiers changed from: private */
    public static final void c(o oVar, View view) {
        j.g(oVar, "this$0");
        oVar.f35452a.c();
        oVar.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void d(o oVar, View view) {
        j.g(oVar, "this$0");
        oVar.f35452a.b();
        oVar.dismiss();
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.f35452a.a();
    }
}

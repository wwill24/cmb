package com.coffeemeetsbagel.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class k0 extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private final a f12118a;

    /* renamed from: b  reason: collision with root package name */
    private int f12119b = R.string.message;

    public interface a {
        void a();

        void b();

        void onCancel();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k0(a aVar, Context context) {
        super(context, R.style.onboarding_flow_dialog);
        j.g(aVar, "skipListener");
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f12118a = aVar;
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        setContentView(R.layout.skip_dialog);
    }

    /* access modifiers changed from: private */
    public static final void d(k0 k0Var, View view) {
        j.g(k0Var, "this$0");
        k0Var.f12118a.onCancel();
        k0Var.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void e(k0 k0Var, View view) {
        j.g(k0Var, "this$0");
        k0Var.f12118a.a();
        k0Var.dismiss();
    }

    public final void c(int i10) {
        this.f12119b = i10;
    }

    public void onBackPressed() {
        this.f12118a.b();
        super.onBackPressed();
    }

    public void show() {
        TextView textView = (TextView) findViewById(R.id.message);
        textView.setText(textView.getContext().getText(this.f12119b));
        TextView textView2 = (TextView) findViewById(R.id.cancel_button);
        if (textView2 != null) {
            textView2.setOnClickListener(new i0(this));
        }
        TextView textView3 = (TextView) findViewById(R.id.skip_button);
        if (textView3 != null) {
            textView3.setOnClickListener(new j0(this));
        }
        super.show();
    }
}

package com.coffeemeetsbagel.store;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import ub.a;

public final class u extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private final a f36998a;

    /* renamed from: b  reason: collision with root package name */
    private Function0<Unit> f36999b;

    private u(Context context) {
        super(context);
        a c10 = a.c(LayoutInflater.from(context));
        j.f(c10, "inflate(LayoutInflater.from(context))");
        this.f36998a = c10;
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawableResource(17170445);
        }
        setContentView(c10.getRoot());
        c10.f41953b.setScaleX(-1.0f);
        c10.f41953b.setScaleY(-1.0f);
        c10.f41953b.y();
    }

    /* access modifiers changed from: private */
    public static final void d(u uVar, View view) {
        j.g(uVar, "this$0");
        uVar.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void e(u uVar, Function0 function0, View view) {
        j.g(uVar, "this$0");
        uVar.dismiss();
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final void f(u uVar, DialogInterface dialogInterface) {
        j.g(uVar, "this$0");
        Function0<Unit> function0 = uVar.f36999b;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setOnCancelListener(new s(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public u(Context context, String str) {
        this(context);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(str, "firstName");
        a aVar = this.f36998a;
        aVar.f41957f.setText(context.getString(r0.way_to_shine, new Object[]{str}));
        aVar.f41955d.setText(context.getString(r0.congrats_youre_subscriber));
        aVar.f41954c.setText(context.getString(r0.thanks));
        aVar.f41954c.setOnClickListener(new t(this));
        aVar.f41956e.setImageResource(m0.confetti);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public u(Context context, int i10, int i11, int i12, int i13, Function0<Unit> function0) {
        this(context);
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f36999b = function0;
        a aVar = this.f36998a;
        aVar.f41957f.setText(context.getString(i11));
        aVar.f41955d.setText(context.getString(i10));
        aVar.f41954c.setText(context.getString(i12));
        aVar.f41954c.setOnClickListener(new r(this, function0));
        aVar.f41956e.setImageResource(i13);
    }
}

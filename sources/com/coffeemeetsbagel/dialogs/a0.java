package com.coffeemeetsbagel.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.mparticle.identity.IdentityHttpResponse;
import k6.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class a0 extends Dialog {

    /* renamed from: d  reason: collision with root package name */
    public static final b f12077d = new b((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final a f12078a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f12079b;

    /* renamed from: c  reason: collision with root package name */
    private final String f12080c;

    public interface a {
        void a();

        void d();

        void e();
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, String str, String str2, CharSequence charSequence, String str3, boolean z10, a aVar, Function0<Unit> function0) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            j.g(str, "title");
            j.g(str2, "message");
            j.g(charSequence, "primaryButtonText");
            j.g(str3, "secondaryButtonText");
            a aVar2 = aVar;
            j.g(aVar2, "clickListener");
            new a0(context, aVar2, str, str2, charSequence, str3, z10, function0).show();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a0(Context context, a aVar, String str, String str2, CharSequence charSequence, String str3, boolean z10, Function0<Unit> function0) {
        super(context, 16973834);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(aVar, "clickListener");
        j.g(str, "title");
        j.g(str2, "message");
        j.g(charSequence, "primaryButtonText");
        j.g(str3, "secondaryButtonText");
        this.f12078a = aVar;
        this.f12079b = charSequence;
        this.f12080c = str3;
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            window.setBackgroundDrawableResource(R.color.black_transparent_60pc);
        }
        h c10 = h.c(LayoutInflater.from(context));
        j.f(c10, "inflate(LayoutInflater.from(context))");
        setContentView(c10.getRoot());
        if (z10) {
            c10.f15750g.setVisibility(0);
            c10.f15750g.setText(context.getText(R.string.subscribe_for_more));
        } else {
            c10.f15750g.setVisibility(8);
        }
        CmbTextView cmbTextView = c10.f15746c;
        cmbTextView.setText(charSequence);
        cmbTextView.setOnClickListener(new w(this));
        CmbTextView cmbTextView2 = c10.f15747d;
        cmbTextView2.setText(str3);
        cmbTextView2.setOnClickListener(new x(this));
        c10.f15750g.setOnClickListener(new y(this));
        c10.f15749f.setText(str);
        c10.f15748e.setText(str2);
        setOnCancelListener(new z(function0));
    }

    /* access modifiers changed from: private */
    public static final void e(Function0 function0, DialogInterface dialogInterface) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final void f(a0 a0Var, View view) {
        j.g(a0Var, "this$0");
        a0Var.dismiss();
        a0Var.f12078a.e();
    }

    /* access modifiers changed from: private */
    public static final void g(a0 a0Var, View view) {
        j.g(a0Var, "this$0");
        a0Var.dismiss();
        a0Var.f12078a.d();
    }

    /* access modifiers changed from: private */
    public static final void h(a0 a0Var, View view) {
        j.g(a0Var, "this$0");
        a0Var.dismiss();
        a0Var.f12078a.a();
    }
}

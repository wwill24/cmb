package com.coffeemeetsbagel.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.core.content.a;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import q5.i;
import q5.k;
import q5.o;
import s5.b;

public final class DialogFullscreenSingleButton extends Dialog {

    public enum PrimaryCtaStyle {
        NORMAL(k.primary_button_selector),
        DESTRUCTIVE(k.destructive_button_selector);
        
        private final int value;

        private PrimaryCtaStyle(int i10) {
            this.value = i10;
        }

        public final int b() {
            return this.value;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogFullscreenSingleButton(Context context, int i10, String str, String str2, String str3, PrimaryCtaStyle primaryCtaStyle, Function0<Unit> function0) {
        super(context, o.dialog_fullscreen_dls);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(str, "title");
        j.g(str2, "text");
        j.g(str3, "primary");
        j.g(primaryCtaStyle, "style");
        j.g(function0, "primaryClickListener");
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            window.setBackgroundDrawableResource(i.white);
        }
        b c10 = b.c(LayoutInflater.from(context));
        j.f(c10, "inflate(LayoutInflater.from(context))");
        setContentView(c10.getRoot());
        c10.f17483c.setImageDrawable(a.getDrawable(context, i10));
        c10.f17485e.setText(str);
        c10.f17482b.setText(str2);
        c10.f17484d.setText(str3);
        c10.f17484d.setBackground(a.getDrawable(context, primaryCtaStyle.b()));
        c10.f17484d.setOnClickListener(new l(function0));
    }

    /* access modifiers changed from: private */
    public static final void b(Function0 function0, View view) {
        j.g(function0, "$primaryClickListener");
        function0.invoke();
    }
}

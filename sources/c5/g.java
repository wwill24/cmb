package c5;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.mparticle.identity.IdentityHttpResponse;
import d5.a;
import kotlin.jvm.internal.j;

public final class g extends Dialog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Context context) {
        super(context);
        j.g(context, IdentityHttpResponse.CONTEXT);
        if (getWindow() != null) {
            Window window = getWindow();
            j.d(window);
            window.requestFeature(1);
            Window window2 = getWindow();
            j.d(window2);
            window2.setBackgroundDrawableResource(17170445);
        }
        a c10 = a.c(LayoutInflater.from(context));
        j.f(c10, "inflate(inflater)");
        setContentView(c10.getRoot());
        c10.f14446b.setOnClickListener(new f(this));
    }

    /* access modifiers changed from: private */
    public static final void b(g gVar, View view) {
        j.g(gVar, "this$0");
        gVar.dismiss();
    }
}

package com.coffeemeetsbagel.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.mparticle.identity.IdentityHttpResponse;
import gk.f;
import kotlin.jvm.internal.j;

public final class HorizontalPrimarySecondaryDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private final a f12069a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12070b;

    /* renamed from: c  reason: collision with root package name */
    private final String f12071c;

    /* renamed from: d  reason: collision with root package name */
    private final String f12072d;

    /* renamed from: e  reason: collision with root package name */
    private final String f12073e;

    /* renamed from: f  reason: collision with root package name */
    private final f f12074f = b.b(new HorizontalPrimarySecondaryDialog$primaryButton$2(this));

    /* renamed from: g  reason: collision with root package name */
    private final f f12075g = b.b(new HorizontalPrimarySecondaryDialog$secondaryButton$2(this));

    public interface a {
        void a();

        void b();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalPrimarySecondaryDialog(Context context, a aVar, String str, String str2, String str3, String str4) {
        super(context, R.style.horizontal_primary_secondary_dialog);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(aVar, "clickListener");
        j.g(str, "title");
        j.g(str2, "message");
        j.g(str3, "primaryButtonText");
        j.g(str4, "secondaryButtonText");
        this.f12069a = aVar;
        this.f12070b = str;
        this.f12071c = str2;
        this.f12072d = str3;
        this.f12073e = str4;
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        setContentView(R.layout.horizontal_primary_secondary_dialog);
        ((TextView) findViewById(R.id.title)).setText(str);
        ((TextView) findViewById(R.id.message)).setText(str2);
        TextView c10 = c();
        c10.setText(str3);
        c10.setOnClickListener(new c0(this));
        TextView d10 = d();
        d10.setText(str4);
        d10.setOnClickListener(new d0(this));
    }

    private final TextView c() {
        return (TextView) this.f12074f.getValue();
    }

    private final TextView d() {
        return (TextView) this.f12075g.getValue();
    }

    /* access modifiers changed from: private */
    public static final void e(HorizontalPrimarySecondaryDialog horizontalPrimarySecondaryDialog, View view) {
        j.g(horizontalPrimarySecondaryDialog, "this$0");
        horizontalPrimarySecondaryDialog.dismiss();
        horizontalPrimarySecondaryDialog.f12069a.b();
    }

    /* access modifiers changed from: private */
    public static final void f(HorizontalPrimarySecondaryDialog horizontalPrimarySecondaryDialog, View view) {
        j.g(horizontalPrimarySecondaryDialog, "this$0");
        horizontalPrimarySecondaryDialog.dismiss();
        horizontalPrimarySecondaryDialog.f12069a.a();
    }
}

package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.r;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cj.e;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import com.withpersona.sdk2.inquiry.steps.ui.styling.m;
import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.j;
import ti.b;

public final class ESignatureKt {
    /* access modifiers changed from: private */
    public static final void b(r rVar, UiComponent.ESignatureComponentStyle eSignatureComponentStyle) {
        Drawable drawable;
        Drawable mutate;
        TextView textView = rVar.f24883b;
        j.f(textView, "addSignatureLabel");
        m.e(textView, eSignatureComponentStyle.m().U());
        String s10 = eSignatureComponentStyle.s();
        if (s10 != null) {
            rVar.f24886e.setCardBackgroundColor(Color.parseColor(s10));
        }
        String A0 = eSignatureComponentStyle.A0();
        if (!(A0 == null || (drawable = rVar.f24884c.getDrawable()) == null || (mutate = drawable.mutate()) == null)) {
            mutate.setTint(Color.parseColor(A0));
        }
        TextView textView2 = rVar.f24885d;
        j.f(textView2, "errorLabel");
        m.e(textView2, eSignatureComponentStyle.m().w());
        StyleElements.DPSizeSet r10 = eSignatureComponentStyle.r();
        if (r10 != null) {
            ConstraintLayout b10 = rVar.getRoot();
            j.f(b10, "root");
            e.c(b10, r10);
        }
        String d10 = eSignatureComponentStyle.m().d();
        if (d10 != null) {
            rVar.f24886e.setStrokeColor(Color.parseColor(d10));
        }
        Double l10 = eSignatureComponentStyle.m().l();
        if (l10 != null) {
            rVar.f24886e.setStrokeWidth((int) Math.ceil(b.a(l10.doubleValue())));
        }
        Double j10 = eSignatureComponentStyle.m().j();
        if (j10 != null) {
            rVar.f24886e.setRadius((float) b.a(j10.doubleValue()));
        }
    }

    public static final ConstraintLayout c(Context context, UiComponent.ESignature eSignature) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(eSignature, "component");
        r c10 = r.c(LayoutInflater.from(context));
        ImageView imageView = c10.f24887f;
        j.f(imageView, "signaturePreview");
        k.b(imageView, new ESignatureKt$eSignatureView$1$1(eSignature, c10));
        c10.getRoot().setTag(c10);
        ConstraintLayout b10 = c10.getRoot();
        j.f(b10, "inflate(LayoutInflater.f…\n  root.tag = this\n}.root");
        return b10;
    }

    public static final String d(Bitmap bitmap) {
        j.g(bitmap, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 3);
        j.f(encodeToString, "encodedPng");
        return encodeToString;
    }
}

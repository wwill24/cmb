package com.withpersona.sdk2.inquiry.steps.ui.components;

import aj.p;
import aj.s;
import aj.t;
import android.content.Context;
import android.text.Spanned;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.mparticle.identity.IdentityHttpResponse;
import com.withpersona.sdk2.inquiry.shared.ui.k;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import ij.e;
import io.noties.markwon.core.spans.LinkSpan;
import kotlin.jvm.internal.j;

public final class TextsKt {
    public static final TextView a(Context context, UiComponent.Text text) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(text, "component");
        s c10 = s.c(LayoutInflater.from(context));
        UiComponent.Text.Attributes B = text.z();
        if (B != null) {
            TextView textView = c10.f24889b;
            j.f(textView, "textView");
            c(textView, B.e());
            TextView textView2 = c10.f24889b;
            j.f(textView2, "textView");
            k.b(textView2, new TextsKt$personaTextView$1$1$1(text, c10));
        }
        TextView b10 = c10.getRoot();
        j.f(b10, "inflate(LayoutInflater.f…\n      }\n    }\n  }\n}.root");
        return b10;
    }

    public static final TextView b(Context context, UiComponent.PrivacyPolicy privacyPolicy) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(privacyPolicy, "component");
        p c10 = p.c(LayoutInflater.from(context));
        UiComponent.PrivacyPolicy.Attributes B = privacyPolicy.z();
        if (B != null) {
            TextView textView = c10.f24879b;
            j.f(textView, "textView");
            c(textView, B.a());
            TextView textView2 = c10.f24879b;
            j.f(textView2, "textView");
            k.b(textView2, new TextsKt$privacyPolicyView$1$1$1(privacyPolicy, c10));
        }
        TextView b10 = c10.getRoot();
        j.f(b10, "inflate(LayoutInflater.f…\n      }\n    }\n  }\n}.root");
        return b10;
    }

    public static final void c(TextView textView, String str) {
        boolean z10;
        j.g(textView, "<this>");
        j.g(str, "text");
        e b10 = e.b(textView.getContext());
        j.f(b10, "create(this.context)");
        Spanned e10 = b10.e(str);
        j.f(e10, "markwon.toMarkdown(text)");
        b10.d(textView, e10);
        boolean z11 = false;
        Object[] spans = e10.getSpans(0, e10.length(), LinkSpan.class);
        j.f(spans, "getSpans(start, end, T::class.java)");
        if (spans.length == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            Object[] spans2 = e10.getSpans(0, e10.length(), URLSpan.class);
            j.f(spans2, "getSpans(start, end, T::class.java)");
            if (spans2.length == 0) {
                z11 = true;
            }
            if (z11) {
                textView.setMovementMethod((MovementMethod) null);
            }
        }
    }

    public static final TextView d(Context context, UiComponent.Title title) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(title, "component");
        t c10 = t.c(LayoutInflater.from(context));
        UiComponent.Title.Attributes B = title.z();
        if (B != null) {
            TextView textView = c10.f24891b;
            j.f(textView, "textView");
            c(textView, B.e());
            TextView textView2 = c10.f24891b;
            j.f(textView2, "textView");
            k.b(textView2, new TextsKt$titleView$1$1$1(title, c10));
        }
        TextView b10 = c10.getRoot();
        j.f(b10, "inflate(LayoutInflater.f…\n      }\n    }\n  }\n}.root");
        return b10;
    }
}

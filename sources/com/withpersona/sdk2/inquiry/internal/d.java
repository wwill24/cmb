package com.withpersona.sdk2.inquiry.internal;

import android.content.Context;
import coil.ImageLoader;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final InquiryActivity f26328a;

    public d(InquiryActivity inquiryActivity) {
        j.g(inquiryActivity, "inquiryActivity");
        this.f26328a = inquiryActivity;
    }

    public final Context a() {
        Context applicationContext = this.f26328a.getApplicationContext();
        j.f(applicationContext, "inquiryActivity.applicationContext");
        return applicationContext;
    }

    public final ImageLoader b(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        return new ImageLoader.Builder(context).e(true).b();
    }
}

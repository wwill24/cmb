package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import okhttp3.b0;
import qj.a;
import qj.f;
import retrofit2.r;

final class UserRepository$updatePurchasedSkus$1 extends Lambda implements Function1<r<b0>, f> {

    /* renamed from: a  reason: collision with root package name */
    public static final UserRepository$updatePurchasedSkus$1 f12466a = new UserRepository$updatePurchasedSkus$1();

    UserRepository$updatePurchasedSkus$1() {
        super(1);
    }

    /* renamed from: a */
    public final f invoke(r<b0> rVar) {
        j.g(rVar, "response");
        if (rVar.g()) {
            return a.m();
        }
        return a.v(new Throwable("Failed to update profile with purchased subscriptions."));
    }
}

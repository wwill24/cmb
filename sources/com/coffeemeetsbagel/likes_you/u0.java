package com.coffeemeetsbagel.likes_you;

import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import kotlin.jvm.internal.j;
import qj.a;
import x4.r;

public final class u0 {

    /* renamed from: a  reason: collision with root package name */
    private final r f34324a;

    /* renamed from: b  reason: collision with root package name */
    private final LikesYouMatchRepository f34325b;

    public u0(r rVar, LikesYouMatchRepository likesYouMatchRepository) {
        j.g(rVar, "transactionRunner");
        j.g(likesYouMatchRepository, "repository");
        this.f34324a = rVar;
        this.f34325b = likesYouMatchRepository;
    }

    public final a a() {
        return this.f34325b.s(this.f34324a);
    }
}

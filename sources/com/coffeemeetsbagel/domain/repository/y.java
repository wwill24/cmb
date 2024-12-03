package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.likesyou.LikesYouNetworkResponseV5;
import vj.a;
import x4.r;

public final /* synthetic */ class y implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LikesYouNetworkResponseV5 f12601a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LikesYouMatchRepository f12602b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ r f12603c;

    public /* synthetic */ y(LikesYouNetworkResponseV5 likesYouNetworkResponseV5, LikesYouMatchRepository likesYouMatchRepository, r rVar) {
        this.f12601a = likesYouNetworkResponseV5;
        this.f12602b = likesYouMatchRepository;
        this.f12603c = rVar;
    }

    public final void run() {
        LikesYouMatchRepository$fetchCardsGroupsRemote$1.d(this.f12601a, this.f12602b, this.f12603c);
    }
}

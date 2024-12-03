package com.coffeemeetsbagel.feature.chatlist;

import com.coffeemeetsbagel.models.dto.MatchContract;
import fa.a;
import vj.f;

public final /* synthetic */ class v implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MatchContract f12981a;

    public /* synthetic */ v(MatchContract matchContract) {
        this.f12981a = matchContract;
    }

    public final void accept(Object obj) {
        a.g("ChatListFragment", "failed to read bagel from db - " + this.f12981a.getId() + " or get photos from db - " + this.f12981a.getProfileId(), (Throwable) obj);
    }
}

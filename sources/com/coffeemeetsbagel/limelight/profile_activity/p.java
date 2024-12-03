package com.coffeemeetsbagel.limelight.profile_activity;

import b6.u;
import com.coffeemeetsbagel.limelight.profile_activity.LikesYouMatchContainerInteractor;
import com.coffeemeetsbagel.match.MatchIdAttribution;
import java.util.List;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f34458a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f34459b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f34460c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f34461d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MatchIdAttribution f34462e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LikesYouMatchContainerInteractor.b f34463f;

    public /* synthetic */ p(q qVar, u uVar, List list, String str, MatchIdAttribution matchIdAttribution, LikesYouMatchContainerInteractor.b bVar) {
        this.f34458a = qVar;
        this.f34459b = uVar;
        this.f34460c = list;
        this.f34461d = str;
        this.f34462e = matchIdAttribution;
        this.f34463f = bVar;
    }

    public final void run() {
        q.o(this.f34458a, this.f34459b, this.f34460c, this.f34461d, this.f34462e, this.f34463f);
    }
}

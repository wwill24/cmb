package com.coffeemeetsbagel.domain.repository;

import cb.a;
import com.coffeemeetsbagel.likes_you.b;
import com.coffeemeetsbagel.likes_you.f;
import com.coffeemeetsbagel.likes_you.h;
import com.coffeemeetsbagel.likes_you.m;
import com.coffeemeetsbagel.likes_you.s;
import com.coffeemeetsbagel.likesyou.EncountersRequestBody;
import com.coffeemeetsbagel.likesyou.ProfileRequestData;
import com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards;
import com.coffeemeetsbagel.match.b0;
import com.coffeemeetsbagel.match.models.ActionOnBagelNetworkRequest;
import com.coffeemeetsbagel.match.models.Match;
import com.coffeemeetsbagel.match.u;
import com.coffeemeetsbagel.models.entities.LikesYouCardEntity;
import com.coffeemeetsbagel.models.entities.LikesYouGroupEntity;
import com.coffeemeetsbagel.models.entities.LikesYouPaywallCard;
import com.coffeemeetsbagel.models.entities.MatchEntity;
import com.coffeemeetsbagel.models.entities.PhotoEntity;
import com.coffeemeetsbagel.models.entities.ProfileEntity;
import com.coffeemeetsbagel.models.enums.MatchAction;
import com.coffeemeetsbagel.models.enums.MatchType;
import fa.a;
import j$.time.OffsetDateTime;
import j$.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import ma.e;
import qj.w;
import u6.g;
import u6.i;
import u6.k;
import x4.r;

public final class LikesYouMatchRepository {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final g f12391a;

    /* renamed from: b  reason: collision with root package name */
    private final u f12392b;

    /* renamed from: c  reason: collision with root package name */
    private final a f12393c;

    /* renamed from: d  reason: collision with root package name */
    private final k f12394d;

    /* renamed from: e  reason: collision with root package name */
    private final i f12395e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final b0 f12396f;

    /* renamed from: g  reason: collision with root package name */
    private final za.a f12397g;

    /* renamed from: h  reason: collision with root package name */
    private final e f12398h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final b f12399i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final h f12400j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final m f12401k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final f f12402l;

    /* renamed from: m  reason: collision with root package name */
    private final String f12403m = "LikesYouMatchRepository";

    public LikesYouMatchRepository(g gVar, u uVar, a aVar, k kVar, i iVar, b0 b0Var, za.a aVar2, e eVar, b bVar, h hVar, m mVar, f fVar) {
        j.g(gVar, "matchDao");
        j.g(uVar, "matchService");
        j.g(aVar, "schedulerProvider");
        j.g(kVar, "profileDao");
        j.g(iVar, "photoDao");
        j.g(b0Var, "mapper");
        j.g(aVar2, "answerDao");
        j.g(eVar, "v5network");
        j.g(bVar, "cardsDao");
        j.g(hVar, "groupsDao");
        j.g(mVar, "paywallCardDao");
        j.g(fVar, "likesYouDao");
        this.f12391a = gVar;
        this.f12392b = uVar;
        this.f12393c = aVar;
        this.f12394d = kVar;
        this.f12395e = iVar;
        this.f12396f = b0Var;
        this.f12397g = aVar2;
        this.f12398h = eVar;
        this.f12399i = bVar;
        this.f12400j = hVar;
        this.f12401k = mVar;
        this.f12402l = fVar;
    }

    /* access modifiers changed from: private */
    public static final Pair C(Function2 function2, Object obj, Object obj2) {
        j.g(function2, "$tmp0");
        return (Pair) function2.invoke(obj, obj2);
    }

    /* access modifiers changed from: private */
    public static final Optional F(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Optional) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final List H(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    private final w<List<LikesYouCardEntity>> I() {
        w<List<LikesYouCardEntity>> K = this.f12399i.g().K(dk.a.c());
        j.f(K, "cardsDao.getCards().subscribeOn(Schedulers.io())");
        return K;
    }

    /* access modifiers changed from: private */
    public static final List K(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    private final w<List<LikesYouPaywallCard>> L() {
        w<List<LikesYouPaywallCard>> K = this.f12401k.a().K(dk.a.c());
        j.f(K, "paywallCardDao.getPaywal…scribeOn(Schedulers.io())");
        return K;
    }

    /* access modifiers changed from: private */
    public static final Boolean O(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Boolean) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void P(List<MatchEntity> list) {
        List<za.b> list2;
        a.C0491a aVar = fa.a.f40771d;
        aVar.a(this.f12403m, "saveMatchesToDb");
        int f10 = this.f12391a.f(MatchType.LIKES_YOU);
        aVar.a(this.f12403m, "number of matches deleted: " + f10);
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (MatchEntity id2 : list) {
            arrayList.add(id2.getId());
        }
        OffsetDateTime of2 = OffsetDateTime.of(1, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        fa.a.f40771d.a(this.f12403m, "soft-purging");
        g gVar = this.f12391a;
        MatchType matchType = MatchType.LIKES_YOU;
        j.f(of2, "distantPast");
        gVar.a(matchType, of2, arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (MatchEntity profile : list) {
            ProfileEntity profile2 = profile.getProfile();
            if (profile2 != null) {
                arrayList2.add(profile2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            List<PhotoEntity> list3 = null;
            if (!it.hasNext()) {
                break;
            }
            ProfileEntity profile3 = ((MatchEntity) it.next()).getProfile();
            if (profile3 != null) {
                list3 = profile3.getPhotos();
            }
            if (list3 != null) {
                arrayList3.add(list3);
            }
        }
        List u10 = r.u(arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (MatchEntity profile4 : list) {
            ProfileEntity profile5 = profile4.getProfile();
            if (profile5 != null) {
                list2 = profile5.getAnswers();
            } else {
                list2 = null;
            }
            if (list2 != null) {
                arrayList4.add(list2);
            }
        }
        List u11 = r.u(arrayList4);
        this.f12394d.c(arrayList2);
        this.f12391a.i(list);
        this.f12395e.f(u10);
        this.f12397g.a(u11);
    }

    /* access modifiers changed from: private */
    public static final void R(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final qj.f t(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (qj.f) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final List v(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void w(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final rn.a z(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (rn.a) function1.invoke(obj);
    }

    public final qj.h<LikesYouGroupEntity> A(String str) {
        j.g(str, "groupId");
        qj.h<LikesYouGroupEntity> o02 = this.f12400j.g(str).o0(dk.a.c());
        j.f(o02, "groupsDao.getGroupById(g…scribeOn(Schedulers.io())");
        return o02;
    }

    public final qj.h<Pair<Integer, Integer>> B(String str) {
        j.g(str, "groupId");
        qj.h<R> o02 = qj.h.x0(this.f12400j.j(str), this.f12400j.i(str), new o(LikesYouMatchRepository$getGroupCounts$1.f12405a)).o0(dk.a.c());
        j.f(o02, "zip(\n            groupsD…scribeOn(Schedulers.io())");
        return o02;
    }

    public final w<List<String>> D(List<String> list) {
        j.g(list, "groupIds");
        w<List<String>> K = this.f12400j.n(list).K(dk.a.c());
        j.f(K, "groupsDao.getGroupNamesF…scribeOn(Schedulers.io())");
        return K;
    }

    public final qj.h<Optional<LikesYouGroupWithCards>> E(String str) {
        j.g(str, "currentGroup");
        qj.h<R> Y = this.f12402l.d(str).v().o0(dk.a.c()).Y(new p(LikesYouMatchRepository$getGroupWithCards$1.f12406a));
        j.f(Y, "likesYouDao.getGroupWith…          }\n            }");
        return Y;
    }

    public final qj.h<List<String>> G(String str) {
        j.g(str, "profileId");
        qj.h<R> o02 = this.f12399i.f(str).Y(new t(LikesYouMatchRepository$getGroupsFromCardProfileId$1.f12407a)).o0(dk.a.c());
        j.f(o02, "cardsDao.getCardByProfil…scribeOn(Schedulers.io())");
        return o02;
    }

    public final qj.h<List<Match>> J(String str) {
        j.g(str, "matchId");
        qj.h<R> Y = this.f12391a.j(str).v().o0(dk.a.c()).Y(new r(LikesYouMatchRepository$getMatch$1.f12408a));
        j.f(Y, "matchDao.getMatchFromId(…Mapper.dbToDomain(it) } }");
        return Y;
    }

    public final qj.h<List<s>> M() {
        qj.h<List<s>> o02 = this.f12400j.a().o0(dk.a.c());
        j.f(o02, "groupsDao.getTabs().subscribeOn(Schedulers.io())");
        return o02;
    }

    public final w<Boolean> N(String str) {
        j.g(str, "groupId");
        w<R> D = E(str).L().D(new s(LikesYouMatchRepository$hasMoreLikesSingle$1.f12409a));
        j.f(D, "getGroupWithCards(groupI…          }\n            }");
        return D;
    }

    public final qj.a Q(MatchAction matchAction, Match match, String str) {
        j.g(matchAction, "matchAction");
        j.g(match, "match");
        j.g(str, "screenSource");
        qj.a B = this.f12392b.c(match.getId(), new ActionOnBagelNetworkRequest(matchAction.getId(), (String) null, str, 2, (DefaultConstructorMarker) null)).K(dk.a.c()).r(new x(new LikesYouMatchRepository$sendActionForMatch$1(this, match))).B();
        j.f(B, "fun sendActionForMatch(m…   .ignoreElement()\n    }");
        return B;
    }

    public final w<Integer> S(String str, boolean z10) {
        j.g(str, "profileId");
        w<Integer> K = this.f12391a.g(str, z10).K(dk.a.c());
        j.f(K, "matchDao.updateBlocked(p…scribeOn(Schedulers.io())");
        return K;
    }

    public final w<Integer> T(LikesYouGroupEntity likesYouGroupEntity) {
        j.g(likesYouGroupEntity, "group");
        w<Integer> K = this.f12400j.f(likesYouGroupEntity).K(dk.a.c());
        j.f(K, "groupsDao.updateGroup(gr…scribeOn(Schedulers.io())");
        return K;
    }

    public final w<Integer> r(String str) {
        j.g(str, "profileId");
        w<Integer> K = this.f12399i.a(str).K(dk.a.c());
        j.f(K, "cardsDao.deleteCardById(…scribeOn(Schedulers.io())");
        return K;
    }

    public final qj.a s(r rVar) {
        j.g(rVar, "transactionRunner");
        fa.a.f40771d.a(this.f12403m, "fetchFromNetworkAndSaveToDb");
        qj.a w10 = this.f12398h.a().K(this.f12393c.c()).w(new u(new LikesYouMatchRepository$fetchCardsGroupsRemote$1(this, rVar)));
        j.f(w10, "fun fetchCardsGroupsRemo…    }\n            }\n    }");
        return w10;
    }

    public final qj.a u(List<String> list) {
        j.g(list, "profileIds");
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (String profileRequestData : list) {
            arrayList.add(new ProfileRequestData(profileRequestData, (String) null, 2, (DefaultConstructorMarker) null));
        }
        qj.a B = this.f12398h.b(new EncountersRequestBody(arrayList)).K(dk.a.c()).D(new v(new LikesYouMatchRepository$fetchMatchRemote$1(this))).r(new w(new LikesYouMatchRepository$fetchMatchRemote$2(this))).B();
        j.f(B, "fun fetchMatchRemote(pro…   .ignoreElement()\n    }");
        return B;
    }

    public final w<Pair<List<LikesYouCardEntity>, List<LikesYouPaywallCard>>> x() {
        return ck.b.f24947a.a(I(), L());
    }

    public final qj.h<List<LikesYouGroupWithCards>> y() {
        qj.h<R> M = this.f12402l.c().o0(dk.a.c()).M(new q(LikesYouMatchRepository$getAllGroupsWithCards$1.f12404a));
        j.f(M, "likesYouDao.getAllGroups…          }\n            }");
        return M;
    }
}

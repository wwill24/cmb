package com.coffeemeetsbagel.feature.chatlist;

import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import com.coffeemeetsbagel.domain.repository.SubscriptionRepository;
import com.coffeemeetsbagel.experiment.FeatureFlagRepository;
import com.coffeemeetsbagel.likes_you.presentation.MainGroups;
import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.h;
import qj.w;
import u6.e;

public final class GetBagelConnectionUseCase {

    /* renamed from: h  reason: collision with root package name */
    public static final a f12880h = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final m5.a f12881a;

    /* renamed from: b  reason: collision with root package name */
    private final SubscriptionRepository f12882b;

    /* renamed from: c  reason: collision with root package name */
    private final LikesYouMatchRepository f12883c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final e f12884d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ProfileRepositoryV2 f12885e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final FeatureFlagRepository f12886f;

    /* renamed from: g  reason: collision with root package name */
    private final Comparator<ConnectionHolder> f12887g = new b();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements Comparator<ConnectionHolder> {
        b() {
        }

        /* renamed from: a */
        public int compare(ConnectionHolder connectionHolder, ConnectionHolder connectionHolder2) {
            Date date;
            j.g(connectionHolder, "o1");
            j.g(connectionHolder2, "o2");
            ConnectionDetails c10 = connectionHolder.c();
            Date date2 = null;
            if (c10 != null) {
                date = c10.getLastMessageDateDate();
            } else {
                date = null;
            }
            ConnectionDetails c11 = connectionHolder2.c();
            if (c11 != null) {
                date2 = c11.getLastMessageDateDate();
            }
            if (connectionHolder.i() == connectionHolder2.i()) {
                if (date == null || date2 == null) {
                    if (date != null && date2 == null) {
                        return -1;
                    }
                    if (date2 == null || date != null) {
                        return 0;
                    }
                    return 1;
                } else if (date.compareTo(date2) > 0) {
                    return -1;
                } else {
                    if (date.compareTo(date2) < 0) {
                        return 1;
                    }
                    return 0;
                }
            }
            return 0;
        }
    }

    public GetBagelConnectionUseCase(m5.a aVar, SubscriptionRepository subscriptionRepository, LikesYouMatchRepository likesYouMatchRepository, e eVar, ProfileRepositoryV2 profileRepositoryV2, FeatureFlagRepository featureFlagRepository) {
        j.g(aVar, "bagelConnectionRepository");
        j.g(subscriptionRepository, "subscriptionRepository");
        j.g(likesYouMatchRepository, "likesYouMatchRepository");
        j.g(eVar, "connectionDetailsDao");
        j.g(profileRepositoryV2, "profileRepositoryV2");
        j.g(featureFlagRepository, "featureFlagRepository");
        this.f12881a = aVar;
        this.f12882b = subscriptionRepository;
        this.f12883c = likesYouMatchRepository;
        this.f12884d = eVar;
        this.f12885e = profileRepositoryV2;
        this.f12886f = featureFlagRepository;
    }

    private final h<Pair<Integer, String>> i() {
        h<R> Y = this.f12883c.E(MainGroups.ALL.b()).Y(new s0(GetBagelConnectionUseCase$getLikesYouData$1.f12888a));
        j.f(Y, "likesYouMatchRepository.…          }\n            }");
        return Y;
    }

    /* access modifiers changed from: private */
    public static final Pair j(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Pair) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final List l(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 m(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    public final Comparator<ConnectionHolder> h() {
        return this.f12887g;
    }

    public final w<List<ConnectionHolder>> k() {
        w<R> v10 = ck.a.f24943a.b(this.f12882b.T(), i()).L().D(new q0(new GetBagelConnectionUseCase$invoke$1(this))).v(new r0(new GetBagelConnectionUseCase$invoke$2(this)));
        j.f(v10, "operator fun invoke(): S…    }\n            }\n    }");
        return v10;
    }
}

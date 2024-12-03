package com.coffeemeetsbagel.suggested_history;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.ProfileMappersKt;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.profile.l;
import ja.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import v6.c;

final class GetHistoryBagelUseCase$invoke$1 extends Lambda implements Function1<List<? extends Bagel>, b0<? extends List<? extends Bagel>>> {
    final /* synthetic */ GetHistoryBagelUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetHistoryBagelUseCase$invoke$1(GetHistoryBagelUseCase getHistoryBagelUseCase) {
        super(1);
        this.this$0 = getHistoryBagelUseCase;
    }

    /* access modifiers changed from: private */
    public static final List d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* renamed from: c */
    public final b0<? extends List<Bagel>> invoke(final List<? extends Bagel> list) {
        j.g(list, "bagels");
        ProfileRepositoryV2 b10 = this.this$0.f37106b;
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (Bagel profileId : list) {
            arrayList.add(profileId.getProfileId());
        }
        return b10.p(arrayList).D(new h(new Function1<List<? extends Pair<? extends l, ? extends List<? extends Photo>>>, List<? extends Bagel>>() {
            /* renamed from: a */
            public final List<Bagel> invoke(List<? extends Pair<l, ? extends List<Photo>>> list) {
                ArrayList arrayList;
                T t10;
                NetworkProfile networkProfile;
                List<Photo> list2;
                l lVar;
                j.g(list, "profiles");
                List<Bagel> list3 = list;
                j.f(list3, "bagels");
                ArrayList arrayList2 = new ArrayList(r.t(list3, 10));
                for (Bagel bagel : list3) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        arrayList = null;
                        if (!it.hasNext()) {
                            t10 = null;
                            break;
                        }
                        t10 = it.next();
                        if (j.b(bagel.getProfileId(), ((l) ((Pair) t10).c()).j())) {
                            break;
                        }
                    }
                    Pair pair = (Pair) t10;
                    if (pair == null || (lVar = (l) pair.c()) == null) {
                        networkProfile = null;
                    } else {
                        networkProfile = ProfileMappersKt.g(lVar, (b) null);
                    }
                    bagel.setProfile(networkProfile);
                    NetworkProfile profile = bagel.getProfile();
                    if (profile != null) {
                        if (!(pair == null || (list2 = (List) pair.d()) == null)) {
                            arrayList = new ArrayList(r.t(list2, 10));
                            for (Photo e10 : list2) {
                                arrayList.add(c.e(e10));
                            }
                        }
                        profile.setPhotos(arrayList);
                    }
                    arrayList2.add(Unit.f32013a);
                }
                return list;
            }
        }));
    }
}

package com.coffeemeetsbagel.feature.chatlist;

import com.coffeemeetsbagel.feature.chatlist.ConnectionHolder;
import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.dto.MatchContract;
import com.coffeemeetsbagel.photo.Photo;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import com.coffeemeetsbagel.profile.l;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;
import u6.e;

final class GetBagelConnectionUseCase$invoke$2 extends Lambda implements Function1<List<ConnectionHolder>, b0<? extends List<? extends ConnectionHolder>>> {
    final /* synthetic */ GetBagelConnectionUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetBagelConnectionUseCase$invoke$2(GetBagelConnectionUseCase getBagelConnectionUseCase) {
        super(1);
        this.this$0 = getBagelConnectionUseCase;
    }

    /* access modifiers changed from: private */
    public static final b0 d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* renamed from: c */
    public final b0<? extends List<ConnectionHolder>> invoke(final List<ConnectionHolder> list) {
        String str;
        j.g(list, "connectionHolders");
        ArrayList arrayList = new ArrayList();
        for (ConnectionHolder g10 : list) {
            MatchContract g11 = g10.g();
            if (g11 != null) {
                str = g11.getProfileId();
            } else {
                str = null;
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        final List list2 = (List) arrayList.stream().limit(950).collect(Collectors.toList());
        ProfileRepositoryV2 g12 = this.this$0.f12885e;
        j.f(list2, "profileIds");
        w<List<Pair<l, List<Photo>>>> p10 = g12.p(list2);
        final GetBagelConnectionUseCase getBagelConnectionUseCase = this.this$0;
        return p10.v(new t0(new Function1<List<? extends Pair<? extends l, ? extends List<? extends Photo>>>, b0<? extends List<? extends ConnectionHolder>>>() {
            /* access modifiers changed from: private */
            public static final List d(Function1 function1, Object obj) {
                j.g(function1, "$tmp0");
                return (List) function1.invoke(obj);
            }

            /* renamed from: c */
            public final b0<? extends List<ConnectionHolder>> invoke(List<? extends Pair<l, ? extends List<Photo>>> list) {
                j.g(list, "listProfilePhotos");
                final LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(list, 10)), 16));
                for (T next : list) {
                    linkedHashMap.put(((l) ((Pair) next).c()).j(), next);
                }
                e e10 = getBagelConnectionUseCase.f12884d;
                List<String> list2 = list2;
                j.f(list2, "profileIds");
                w<List<ConnectionDetails>> f10 = e10.f(list2);
                final List<ConnectionHolder> list3 = list;
                final GetBagelConnectionUseCase getBagelConnectionUseCase = getBagelConnectionUseCase;
                return f10.D(new u0(new Function1<List<? extends ConnectionDetails>, List<? extends ConnectionHolder>>() {

                    /* renamed from: com.coffeemeetsbagel.feature.chatlist.GetBagelConnectionUseCase$invoke$2$1$1$a */
                    public static final class a<T> implements Comparator {
                        public final int compare(T t10, T t11) {
                            return b.a(((ConnectionHolder) t10).i(), ((ConnectionHolder) t11).i());
                        }
                    }

                    /* renamed from: a */
                    public final List<ConnectionHolder> invoke(List<? extends ConnectionDetails> list) {
                        String str;
                        String str2;
                        List list2;
                        Photo photo;
                        l lVar;
                        j.g(list, "connectionDetails");
                        if (list.size() > 500 || list3.size() > 500) {
                            String str3 = "Too many connections - connection details: " + list.size() + " - active + expired bagels: " + list3.size();
                            fa.a.f40771d.c("GetBagelConnectionUseCase", str3, new IllegalStateException(str3));
                        }
                        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(list, 10)), 16));
                        for (T next : list) {
                            linkedHashMap.put(((ConnectionDetails) next).getProfileId(), next);
                        }
                        List<ConnectionHolder> list3 = list3;
                        j.f(list3, "connectionHolders");
                        Map<String, Pair<l, List<Photo>>> map = linkedHashMap;
                        ArrayList arrayList = new ArrayList(r.t(list3, 10));
                        for (ConnectionHolder connectionHolder : list3) {
                            MatchContract g10 = connectionHolder.g();
                            String str4 = null;
                            if (g10 != null) {
                                str = g10.getProfileId();
                            } else {
                                str = null;
                            }
                            if (str != null) {
                                String profileId = connectionHolder.g().getProfileId();
                                Pair pair = map.get(profileId);
                                if (pair == null || (lVar = (l) pair.c()) == null) {
                                    str2 = null;
                                } else {
                                    str2 = lVar.g();
                                }
                                Pair pair2 = map.get(profileId);
                                if (!(pair2 == null || (list2 = (List) pair2.d()) == null || (photo = (Photo) CollectionsKt___CollectionsKt.P(list2)) == null)) {
                                    str4 = photo.getUrl();
                                }
                                connectionHolder = ConnectionHolder.b(connectionHolder, (MatchContract) null, (ConnectionDetails) linkedHashMap.get(profileId), 0, str2, str4, (Integer) null, (ConnectionHolder.ConnectionHolderType) null, 101, (Object) null);
                            }
                            arrayList.add(connectionHolder);
                        }
                        return CollectionsKt___CollectionsKt.q0(CollectionsKt___CollectionsKt.q0(arrayList, new a()), getBagelConnectionUseCase.h());
                    }
                }));
            }
        }));
    }
}

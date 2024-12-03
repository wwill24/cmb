package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.photo.Photo;
import ja.b;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import rn.a;

final class GetMyOwnProfileLocalUseCase$invoke$1 extends Lambda implements Function1<b, a<? extends Triple<? extends b, ? extends l, ? extends List<? extends Photo>>>> {
    final /* synthetic */ GetMyOwnProfileLocalUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetMyOwnProfileLocalUseCase$invoke$1(GetMyOwnProfileLocalUseCase getMyOwnProfileLocalUseCase) {
        super(1);
        this.this$0 = getMyOwnProfileLocalUseCase;
    }

    /* access modifiers changed from: private */
    public static final Triple d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (Triple) function1.invoke(obj);
    }

    /* renamed from: c */
    public final a<? extends Triple<b, l, List<Photo>>> invoke(final b bVar) {
        j.g(bVar, "user");
        return this.this$0.f36011a.l(bVar.u()).Y(new b(new Function1<Pair<? extends l, ? extends List<? extends Photo>>, Triple<? extends b, ? extends l, ? extends List<? extends Photo>>>() {
            /* renamed from: a */
            public final Triple<b, l, List<Photo>> invoke(Pair<l, ? extends List<Photo>> pair) {
                j.g(pair, "it");
                return new Triple<>(bVar, pair.c(), pair.d());
            }
        }));
    }
}

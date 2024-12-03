package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.profile.ProfileRepositoryV2;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;

final class SuggestedRepository$refill$4 extends Lambda implements Function1<List<? extends Bagel>, b0<? extends List<? extends Bagel>>> {
    final /* synthetic */ SuggestedRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedRepository$refill$4(SuggestedRepository suggestedRepository) {
        super(1);
        this.this$0 = suggestedRepository;
    }

    /* access modifiers changed from: private */
    public static final List d(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* renamed from: c */
    public final b0<? extends List<Bagel>> invoke(final List<? extends Bagel> list) {
        j.g(list, "bagels");
        ProfileRepositoryV2 r10 = this.this$0.f12454d;
        ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (Bagel profile : list) {
            arrayList.add(profile.getProfile());
        }
        return r10.t(arrayList).D(new q2(new Function1<Integer, List<? extends Bagel>>() {
            /* renamed from: a */
            public final List<Bagel> invoke(Integer num) {
                j.g(num, "it");
                return list;
            }
        }));
    }
}

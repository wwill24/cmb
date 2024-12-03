package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.Bagel;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.b0;
import qj.w;

final class SuggestedRepository$refill$3 extends Lambda implements Function1<List<? extends Bagel>, b0<? extends List<? extends Bagel>>> {
    final /* synthetic */ SuggestedRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuggestedRepository$refill$3(SuggestedRepository suggestedRepository) {
        super(1);
        this.this$0 = suggestedRepository;
    }

    /* access modifiers changed from: private */
    public static final b0 f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final b0 h(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (b0) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final List i(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (List) function1.invoke(obj);
    }

    /* renamed from: e */
    public final b0<? extends List<Bagel>> invoke(final List<? extends Bagel> list) {
        j.g(list, "bagels");
        final ArrayList arrayList = new ArrayList(r.t(list, 10));
        for (Bagel profile : list) {
            arrayList.add(profile.getProfile());
        }
        w<Integer> t10 = this.this$0.f12454d.t(arrayList);
        final SuggestedRepository suggestedRepository = this.this$0;
        w<R> v10 = t10.v(new n2(new Function1<Integer, b0<? extends Integer>>() {
            /* renamed from: a */
            public final b0<? extends Integer> invoke(Integer num) {
                j.g(num, "it");
                return suggestedRepository.f12455e.l(arrayList);
            }
        }));
        final SuggestedRepository suggestedRepository2 = this.this$0;
        return v10.v(new o2(new Function1<Integer, b0<? extends List<? extends Long>>>() {
            /* renamed from: a */
            public final b0<? extends List<Long>> invoke(Integer num) {
                j.g(num, "it");
                return suggestedRepository2.f12456f.X(arrayList);
            }
        })).D(new p2(new Function1<List<? extends Long>, List<? extends Bagel>>() {
            /* renamed from: a */
            public final List<Bagel> invoke(List<Long> list) {
                j.g(list, "it");
                return list;
            }
        }));
    }
}

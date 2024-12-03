package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import qj.h;
import rn.a;
import x6.c;
import x6.d;

final class BaseRepository$getRepository$1 extends Lambda implements Function1<DbType, a<? extends d<DbType>>> {
    final /* synthetic */ BaseRepository<DbType, NetworkResponseType> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseRepository$getRepository$1(BaseRepository<DbType, NetworkResponseType> baseRepository) {
        super(1);
        this.this$0 = baseRepository;
    }

    /* access modifiers changed from: private */
    public static final d e(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (d) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final d f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (d) function1.invoke(obj);
    }

    /* renamed from: d */
    public final a<? extends d<DbType>> invoke(DbType dbtype) {
        if (this.this$0.p(dbtype)) {
            h q10 = h.q(h.X(new c()), this.this$0.g().Y(new j(AnonymousClass1.f12389a)).k0(1).h0(new k(AnonymousClass2.f12390a)));
            j.f(q10, "{\n            Flowable.c…            )\n          }");
            return q10;
        }
        h X = h.X(new x6.a(dbtype));
        j.f(X, "{\n            Flowable.j…<DbType>(it))\n          }");
        return X;
    }
}

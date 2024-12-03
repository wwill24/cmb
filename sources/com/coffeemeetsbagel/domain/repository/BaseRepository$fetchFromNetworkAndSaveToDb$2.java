package com.coffeemeetsbagel.domain.repository;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class BaseRepository$fetchFromNetworkAndSaveToDb$2 extends Lambda implements Function1<DbType, Unit> {
    final /* synthetic */ BaseRepository<DbType, NetworkResponseType> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseRepository$fetchFromNetworkAndSaveToDb$2(BaseRepository<DbType, NetworkResponseType> baseRepository) {
        super(1);
        this.this$0 = baseRepository;
    }

    public final void a(DbType dbtype) {
        this.this$0.o(dbtype);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a(obj);
        return Unit.f32013a;
    }
}

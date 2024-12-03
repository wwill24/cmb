package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class BaseRepository$fetchFromNetworkAndSaveToDb$1 extends Lambda implements Function1<NetworkResponseType, DbType> {
    final /* synthetic */ BaseRepository<DbType, NetworkResponseType> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseRepository$fetchFromNetworkAndSaveToDb$1(BaseRepository<DbType, NetworkResponseType> baseRepository) {
        super(1);
        this.this$0 = baseRepository;
    }

    public final DbType invoke(NetworkResponseType networkresponsetype) {
        return this.this$0.n(networkresponsetype);
    }
}

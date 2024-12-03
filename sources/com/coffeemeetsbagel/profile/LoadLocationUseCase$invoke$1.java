package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.utils.model.Optional;
import ja.b;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import rn.a;

final class LoadLocationUseCase$invoke$1 extends Lambda implements Function1<b, a<? extends Optional<Location>>> {
    final /* synthetic */ LoadLocationUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoadLocationUseCase$invoke$1(LoadLocationUseCase loadLocationUseCase) {
        super(1);
        this.this$0 = loadLocationUseCase;
    }

    /* renamed from: a */
    public final a<? extends Optional<Location>> invoke(b bVar) {
        j.g(bVar, "it");
        return this.this$0.d(bVar);
    }
}

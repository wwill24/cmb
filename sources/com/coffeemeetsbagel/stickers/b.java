package com.coffeemeetsbagel.stickers;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class b implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36672a;

    public /* synthetic */ b(Function1 function1) {
        this.f36672a = function1;
    }

    public final Object apply(Object obj) {
        return StickerRepository.g(this.f36672a, obj);
    }
}

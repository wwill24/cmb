package com.coffeemeetsbagel.stickers;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class a implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36671a;

    public /* synthetic */ a(Function1 function1) {
        this.f36671a = function1;
    }

    public final Object apply(Object obj) {
        return StickerRepository.i(this.f36671a, obj);
    }
}

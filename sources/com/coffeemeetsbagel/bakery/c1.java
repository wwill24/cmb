package com.coffeemeetsbagel.bakery;

import com.coffeemeetsbagel.stickers.StickerRepository;
import fj.d;
import fj.g;
import fk.a;
import hb.c;
import u6.n;

public final class c1 implements d<StickerRepository> {

    /* renamed from: a  reason: collision with root package name */
    private final a<com.coffeemeetsbagel.stickers.d> f11073a;

    /* renamed from: b  reason: collision with root package name */
    private final a<n> f11074b;

    /* renamed from: c  reason: collision with root package name */
    private final a<c> f11075c;

    public c1(a<com.coffeemeetsbagel.stickers.d> aVar, a<n> aVar2, a<c> aVar3) {
        this.f11073a = aVar;
        this.f11074b = aVar2;
        this.f11075c = aVar3;
    }

    public static c1 a(a<com.coffeemeetsbagel.stickers.d> aVar, a<n> aVar2, a<c> aVar3) {
        return new c1(aVar, aVar2, aVar3);
    }

    public static StickerRepository c(com.coffeemeetsbagel.stickers.d dVar, n nVar, c cVar) {
        return (StickerRepository) g.e(c.a0(dVar, nVar, cVar));
    }

    /* renamed from: b */
    public StickerRepository get() {
        return c(this.f11073a.get(), this.f11074b.get(), this.f11075c.get());
    }
}

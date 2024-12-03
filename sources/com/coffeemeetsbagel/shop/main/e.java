package com.coffeemeetsbagel.shop.main;

import com.coffeemeetsbagel.shop.main.d;
import fj.d;
import fj.g;

public final class e implements d<MainShopTabs> {

    /* renamed from: a  reason: collision with root package name */
    private final d.b f36445a;

    public e(d.b bVar) {
        this.f36445a = bVar;
    }

    public static e a(d.b bVar) {
        return new e(bVar);
    }

    public static MainShopTabs b(d.b bVar) {
        return (MainShopTabs) g.e(bVar.b());
    }

    /* renamed from: c */
    public MainShopTabs get() {
        return b(this.f36445a);
    }
}

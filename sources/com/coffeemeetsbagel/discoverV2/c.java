package com.coffeemeetsbagel.discoverV2;

import java.util.List;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DiscoverFragment f12287a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f12288b;

    public /* synthetic */ c(DiscoverFragment discoverFragment, List list) {
        this.f12287a = discoverFragment;
        this.f12288b = list;
    }

    public final void run() {
        DiscoverFragment.J1(this.f12287a, this.f12288b);
    }
}

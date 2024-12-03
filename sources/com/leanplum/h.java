package com.leanplum;

import com.leanplum.migration.MigrationManager;
import java.util.Map;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f22199a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ double f22200b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f22201c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Map f22202d;

    public /* synthetic */ h(String str, double d10, String str2, Map map) {
        this.f22199a = str;
        this.f22200b = d10;
        this.f22201c = str2;
        this.f22202d = map;
    }

    public final void run() {
        MigrationManager.getWrapper().trackPurchase(this.f22199a, this.f22200b, this.f22201c, this.f22202d);
    }
}

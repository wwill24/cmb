package com.leanplum;

import com.leanplum.migration.MigrationManager;
import java.util.Map;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f22209a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ double f22210b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f22211c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Map f22212d;

    public /* synthetic */ j(String str, double d10, String str2, Map map) {
        this.f22209a = str;
        this.f22210b = d10;
        this.f22211c = str2;
        this.f22212d = map;
    }

    public final void run() {
        MigrationManager.getWrapper().track(this.f22209a, this.f22210b, this.f22211c, this.f22212d);
    }
}

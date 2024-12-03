package com.leanplum;

import com.leanplum.migration.MigrationManager;
import java.util.Map;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f22189a;

    public /* synthetic */ d(Map map) {
        this.f22189a = map;
    }

    public final void run() {
        MigrationManager.getWrapper().setUserAttributes(this.f22189a);
    }
}

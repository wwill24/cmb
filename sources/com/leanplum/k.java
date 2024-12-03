package com.leanplum;

import com.leanplum.migration.model.MigrationState;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class k implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f22213a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f22214b;

    public /* synthetic */ k(boolean z10, HashMap hashMap) {
        this.f22213a = z10;
        this.f22214b = hashMap;
    }

    public final Object invoke(Object obj) {
        return Leanplum.lambda$startHelper$1(this.f22213a, this.f22214b, (MigrationState) obj);
    }
}

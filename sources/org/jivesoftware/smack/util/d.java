package org.jivesoftware.smack.util;

import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EqualsUtil.Builder f24178a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long[] f24179b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long[] f24180c;

    public /* synthetic */ d(EqualsUtil.Builder builder, long[] jArr, long[] jArr2) {
        this.f24178a = builder;
        this.f24179b = jArr;
        this.f24180c = jArr2;
    }

    public final void run() {
        this.f24178a.lambda$append$6(this.f24179b, this.f24180c);
    }
}

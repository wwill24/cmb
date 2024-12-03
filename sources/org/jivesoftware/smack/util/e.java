package org.jivesoftware.smack.util;

import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EqualsUtil.Builder f24181a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ double[] f24182b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ double[] f24183c;

    public /* synthetic */ e(EqualsUtil.Builder builder, double[] dArr, double[] dArr2) {
        this.f24181a = builder;
        this.f24182b = dArr;
        this.f24183c = dArr2;
    }

    public final void run() {
        this.f24181a.lambda$append$3(this.f24182b, this.f24183c);
    }
}

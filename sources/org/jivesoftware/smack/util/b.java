package org.jivesoftware.smack.util;

import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EqualsUtil.Builder f24172a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int[] f24173b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int[] f24174c;

    public /* synthetic */ b(EqualsUtil.Builder builder, int[] iArr, int[] iArr2) {
        this.f24172a = builder;
        this.f24173b = iArr;
        this.f24174c = iArr2;
    }

    public final void run() {
        this.f24172a.lambda$append$5(this.f24173b, this.f24174c);
    }
}

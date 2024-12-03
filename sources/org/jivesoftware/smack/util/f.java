package org.jivesoftware.smack.util;

import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EqualsUtil.Builder f24184a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ byte[] f24185b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ byte[] f24186c;

    public /* synthetic */ f(EqualsUtil.Builder builder, byte[] bArr, byte[] bArr2) {
        this.f24184a = builder;
        this.f24185b = bArr;
        this.f24186c = bArr2;
    }

    public final void run() {
        this.f24184a.lambda$append$1(this.f24185b, this.f24186c);
    }
}

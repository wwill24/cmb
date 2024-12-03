package org.jivesoftware.smack.util;

import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EqualsUtil.Builder f24187a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ char[] f24188b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ char[] f24189c;

    public /* synthetic */ g(EqualsUtil.Builder builder, char[] cArr, char[] cArr2) {
        this.f24187a = builder;
        this.f24188b = cArr;
        this.f24189c = cArr2;
    }

    public final void run() {
        this.f24187a.lambda$append$2(this.f24188b, this.f24189c);
    }
}

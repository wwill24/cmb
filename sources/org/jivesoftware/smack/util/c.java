package org.jivesoftware.smack.util;

import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EqualsUtil.Builder f24175a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float[] f24176b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float[] f24177c;

    public /* synthetic */ c(EqualsUtil.Builder builder, float[] fArr, float[] fArr2) {
        this.f24175a = builder;
        this.f24176b = fArr;
        this.f24177c = fArr2;
    }

    public final void run() {
        this.f24175a.lambda$append$4(this.f24176b, this.f24177c);
    }
}

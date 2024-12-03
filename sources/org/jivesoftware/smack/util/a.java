package org.jivesoftware.smack.util;

import org.jivesoftware.smack.util.EqualsUtil;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EqualsUtil.Builder f24169a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean[] f24170b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean[] f24171c;

    public /* synthetic */ a(EqualsUtil.Builder builder, boolean[] zArr, boolean[] zArr2) {
        this.f24169a = builder;
        this.f24170b = zArr;
        this.f24171c = zArr2;
    }

    public final void run() {
        this.f24169a.lambda$append$0(this.f24170b, this.f24171c);
    }
}

package org.jivesoftware.smack;

import java.util.concurrent.CountDownLatch;
import org.jivesoftware.smack.util.Consumer;

public final /* synthetic */ class n implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f24129a;

    public /* synthetic */ n(CountDownLatch countDownLatch) {
        this.f24129a = countDownLatch;
    }

    public final void accept(Object obj) {
        this.f24129a.countDown();
    }
}

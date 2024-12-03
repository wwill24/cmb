package org.jivesoftware.smack.util;

import org.jivesoftware.smack.util.HashCode;

public final /* synthetic */ class n implements HashCode.Calculator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Pair f24193a;

    public /* synthetic */ n(Pair pair) {
        this.f24193a = pair;
    }

    public final void calculateHash(HashCode.Builder builder) {
        this.f24193a.lambda$hashCode$0(builder);
    }
}

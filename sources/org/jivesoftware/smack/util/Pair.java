package org.jivesoftware.smack.util;

import org.jivesoftware.smack.util.EqualsUtil;
import org.jivesoftware.smack.util.HashCode;

public final class Pair<F, S> {
    private final F first;
    private final HashCode.Cache hashCodeCache = new HashCode.Cache();
    private final S second;

    private Pair(F f10, S s10) {
        this.first = f10;
        this.second = s10;
    }

    public static <F, S> Pair<F, S> create(F f10, S s10) {
        return new Pair<>(f10, s10);
    }

    public static <F, S> Pair<F, S> createAndInitHashCode(F f10, S s10) {
        Pair<F, S> pair = new Pair<>(f10, s10);
        pair.hashCode();
        return pair;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$equals$1(EqualsUtil.Builder builder, Pair pair) {
        builder.append(this.first, pair.first).append(this.second, pair.second);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$hashCode$0(HashCode.Builder builder) {
        builder.append((Object) this.first).append((Object) this.second);
    }

    public boolean equals(Object obj) {
        return EqualsUtil.equals(this, obj, new m(this));
    }

    public F getFirst() {
        return this.first;
    }

    public S getSecond() {
        return this.second;
    }

    public int hashCode() {
        return this.hashCodeCache.getHashCode(new n(this));
    }
}

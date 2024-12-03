package org.jivesoftware.smack.util;

public interface Function<R, T> {
    static <T> Function<T, T> identity() {
        return new h();
    }

    /* access modifiers changed from: private */
    static /* synthetic */ Object lambda$identity$0(Object obj) {
        return obj;
    }

    R apply(T t10);
}

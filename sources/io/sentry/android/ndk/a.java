package io.sentry.android.ndk;

import io.sentry.SentryOptions;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.q0;
import io.sentry.util.l;

final class a implements q0 {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f31121c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final SentryOptions f31122a;

    /* renamed from: b  reason: collision with root package name */
    private final NativeModuleListLoader f31123b;

    a(SentryAndroidOptions sentryAndroidOptions, NativeModuleListLoader nativeModuleListLoader) {
        this.f31122a = (SentryOptions) l.c(sentryAndroidOptions, "The SentryAndroidOptions is required.");
        this.f31123b = (NativeModuleListLoader) l.c(nativeModuleListLoader, "The NativeModuleListLoader is required.");
    }
}

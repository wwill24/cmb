package io.sentry;

import java.lang.Thread;

interface w4 {

    public static final class a implements w4 {

        /* renamed from: a  reason: collision with root package name */
        private static final a f31786a = new a();

        private a() {
        }

        static w4 c() {
            return f31786a;
        }

        public void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }

        public Thread.UncaughtExceptionHandler b() {
            return Thread.getDefaultUncaughtExceptionHandler();
        }
    }

    void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler);

    Thread.UncaughtExceptionHandler b();
}

package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicReference;

final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    AtomicThrowable() {
    }

    public boolean a(Throwable th2) {
        return ExceptionHelper.a(this, th2);
    }

    public Throwable b() {
        return ExceptionHelper.b(this);
    }
}

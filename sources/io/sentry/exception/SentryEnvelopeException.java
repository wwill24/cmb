package io.sentry.exception;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class SentryEnvelopeException extends Exception {
    private static final long serialVersionUID = -8307801916948173232L;

    public SentryEnvelopeException(String str) {
        super(str);
    }
}

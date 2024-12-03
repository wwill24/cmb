package io.sentry.vendor.gson.stream;

import java.io.IOException;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class MalformedJsonException extends IOException {
    private static final long serialVersionUID = 1;

    public MalformedJsonException(String str) {
        super(str);
    }
}

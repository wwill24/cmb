package io.sentry.protocol;

import java.util.Locale;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public enum TransactionNameSource {
    CUSTOM,
    URL,
    ROUTE,
    VIEW,
    COMPONENT,
    TASK;

    public String apiName() {
        return name().toLowerCase(Locale.ROOT);
    }
}

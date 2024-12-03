package io.sentry;

import java.util.Locale;
import org.jetbrains.annotations.ApiStatus;

public interface MeasurementUnit {

    public enum Duration implements MeasurementUnit {
        NANOSECOND,
        MICROSECOND,
        MILLISECOND,
        SECOND,
        MINUTE,
        HOUR,
        DAY,
        WEEK
    }

    @ApiStatus.Internal
    String apiName() {
        return name().toLowerCase(Locale.ROOT);
    }

    String name();
}

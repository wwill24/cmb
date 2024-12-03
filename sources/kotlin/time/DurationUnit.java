package kotlin.time;

import java.util.concurrent.TimeUnit;

public enum DurationUnit {
    NANOSECONDS(TimeUnit.NANOSECONDS),
    MICROSECONDS(TimeUnit.MICROSECONDS),
    MILLISECONDS(TimeUnit.MILLISECONDS),
    SECONDS(TimeUnit.SECONDS),
    MINUTES(TimeUnit.MINUTES),
    HOURS(TimeUnit.HOURS),
    DAYS(TimeUnit.DAYS);
    
    private final TimeUnit timeUnit;

    private DurationUnit(TimeUnit timeUnit2) {
        this.timeUnit = timeUnit2;
    }

    public final TimeUnit b() {
        return this.timeUnit;
    }
}

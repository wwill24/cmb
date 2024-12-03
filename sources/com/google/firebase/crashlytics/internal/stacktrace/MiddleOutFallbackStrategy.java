package com.google.firebase.crashlytics.internal.stacktrace;

public class MiddleOutFallbackStrategy implements StackTraceTrimmingStrategy {
    private final int maximumStackSize;
    private final MiddleOutStrategy middleOutStrategy;
    private final StackTraceTrimmingStrategy[] trimmingStrategies;

    public MiddleOutFallbackStrategy(int i10, StackTraceTrimmingStrategy... stackTraceTrimmingStrategyArr) {
        this.maximumStackSize = i10;
        this.trimmingStrategies = stackTraceTrimmingStrategyArr;
        this.middleOutStrategy = new MiddleOutStrategy(i10);
    }

    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.maximumStackSize) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (StackTraceTrimmingStrategy stackTraceTrimmingStrategy : this.trimmingStrategies) {
            if (stackTraceElementArr2.length <= this.maximumStackSize) {
                break;
            }
            stackTraceElementArr2 = stackTraceTrimmingStrategy.getTrimmedStackTrace(stackTraceElementArr);
        }
        if (stackTraceElementArr2.length > this.maximumStackSize) {
            return this.middleOutStrategy.getTrimmedStackTrace(stackTraceElementArr2);
        }
        return stackTraceElementArr2;
    }
}

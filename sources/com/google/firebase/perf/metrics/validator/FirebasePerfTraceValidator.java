package com.google.firebase.perf.metrics.validator;

import androidx.annotation.NonNull;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.v1.TraceMetric;
import java.util.Map;

final class FirebasePerfTraceValidator extends PerfMetricValidator {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final TraceMetric traceMetric;

    FirebasePerfTraceValidator(@NonNull TraceMetric traceMetric2) {
        this.traceMetric = traceMetric2;
    }

    private boolean areAllAttributesValid(Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            try {
                PerfMetricValidator.validateAttribute((String) next.getKey(), (String) next.getValue());
            } catch (IllegalArgumentException e10) {
                logger.warn(e10.getLocalizedMessage());
                return false;
            }
        }
        return true;
    }

    private boolean areCountersValid(@NonNull TraceMetric traceMetric2) {
        return areCountersValid(traceMetric2, 0);
    }

    private boolean hasCounters(@NonNull TraceMetric traceMetric2) {
        boolean z10;
        boolean z11;
        if (traceMetric2.getCountersCount() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return true;
        }
        for (TraceMetric countersCount : traceMetric2.getSubtracesList()) {
            if (countersCount.getCountersCount() > 0) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                return true;
            }
        }
        return false;
    }

    private boolean isScreenTrace(@NonNull TraceMetric traceMetric2) {
        return traceMetric2.getName().startsWith(Constants.SCREEN_TRACE_PREFIX);
    }

    private boolean isValidCounterId(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (trim.isEmpty()) {
            logger.warn("counterId is empty");
            return false;
        } else if (trim.length() <= 100) {
            return true;
        } else {
            logger.warn("counterId exceeded max length 100");
            return false;
        }
    }

    private boolean isValidCounterValue(Long l10) {
        return l10 != null;
    }

    private boolean isValidScreenTrace(@NonNull TraceMetric traceMetric2) {
        Long l10 = traceMetric2.getCountersMap().get(Constants.CounterNames.FRAMES_TOTAL.toString());
        if (l10 == null || l10.compareTo(0L) <= 0) {
            return false;
        }
        return true;
    }

    private boolean isValidTrace(TraceMetric traceMetric2, int i10) {
        if (traceMetric2 == null) {
            logger.warn("TraceMetric is null");
            return false;
        } else if (i10 > 1) {
            logger.warn("Exceed MAX_SUBTRACE_DEEP:1");
            return false;
        } else if (!isValidTraceId(traceMetric2.getName())) {
            AndroidLogger androidLogger = logger;
            androidLogger.warn("invalid TraceId:" + traceMetric2.getName());
            return false;
        } else if (!isValidTraceDuration(traceMetric2)) {
            AndroidLogger androidLogger2 = logger;
            androidLogger2.warn("invalid TraceDuration:" + traceMetric2.getDurationUs());
            return false;
        } else if (!traceMetric2.hasClientStartTimeUs()) {
            logger.warn("clientStartTimeUs is null.");
            return false;
        } else if (!isScreenTrace(traceMetric2) || isValidScreenTrace(traceMetric2)) {
            for (TraceMetric isValidTrace : traceMetric2.getSubtracesList()) {
                if (!isValidTrace(isValidTrace, i10 + 1)) {
                    return false;
                }
            }
            if (!areAllAttributesValid(traceMetric2.getCustomAttributesMap())) {
                return false;
            }
            return true;
        } else {
            AndroidLogger androidLogger3 = logger;
            androidLogger3.warn("non-positive totalFrames in screen trace " + traceMetric2.getName());
            return false;
        }
    }

    private boolean isValidTraceDuration(TraceMetric traceMetric2) {
        return traceMetric2 != null && traceMetric2.getDurationUs() > 0;
    }

    private boolean isValidTraceId(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (trim.isEmpty() || trim.length() > 100) {
            return false;
        }
        return true;
    }

    public boolean isValidPerfMetric() {
        if (!isValidTrace(this.traceMetric, 0)) {
            AndroidLogger androidLogger = logger;
            androidLogger.warn("Invalid Trace:" + this.traceMetric.getName());
            return false;
        } else if (!hasCounters(this.traceMetric) || areCountersValid(this.traceMetric)) {
            return true;
        } else {
            AndroidLogger androidLogger2 = logger;
            androidLogger2.warn("Invalid Counters for Trace:" + this.traceMetric.getName());
            return false;
        }
    }

    private boolean areCountersValid(TraceMetric traceMetric2, int i10) {
        if (traceMetric2 == null) {
            return false;
        }
        if (i10 > 1) {
            logger.warn("Exceed MAX_SUBTRACE_DEEP:1");
            return false;
        }
        for (Map.Entry next : traceMetric2.getCountersMap().entrySet()) {
            if (!isValidCounterId((String) next.getKey())) {
                AndroidLogger androidLogger = logger;
                androidLogger.warn("invalid CounterId:" + ((String) next.getKey()));
                return false;
            } else if (!isValidCounterValue((Long) next.getValue())) {
                AndroidLogger androidLogger2 = logger;
                androidLogger2.warn("invalid CounterValue:" + next.getValue());
                return false;
            }
        }
        for (TraceMetric areCountersValid : traceMetric2.getSubtracesList()) {
            if (!areCountersValid(areCountersValid, i10 + 1)) {
                return false;
            }
        }
        return true;
    }
}

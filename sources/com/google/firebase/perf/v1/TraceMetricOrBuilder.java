package com.google.firebase.perf.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.l0;
import com.google.protobuf.m0;
import java.util.List;
import java.util.Map;

public interface TraceMetricOrBuilder extends m0 {
    boolean containsCounters(String str);

    boolean containsCustomAttributes(String str);

    long getClientStartTimeUs();

    @Deprecated
    Map<String, Long> getCounters();

    int getCountersCount();

    Map<String, Long> getCountersMap();

    long getCountersOrDefault(String str, long j10);

    long getCountersOrThrow(String str);

    @Deprecated
    Map<String, String> getCustomAttributes();

    int getCustomAttributesCount();

    Map<String, String> getCustomAttributesMap();

    String getCustomAttributesOrDefault(String str, String str2);

    String getCustomAttributesOrThrow(String str);

    /* synthetic */ l0 getDefaultInstanceForType();

    long getDurationUs();

    boolean getIsAuto();

    String getName();

    ByteString getNameBytes();

    PerfSession getPerfSessions(int i10);

    int getPerfSessionsCount();

    List<PerfSession> getPerfSessionsList();

    TraceMetric getSubtraces(int i10);

    int getSubtracesCount();

    List<TraceMetric> getSubtracesList();

    boolean hasClientStartTimeUs();

    boolean hasDurationUs();

    boolean hasIsAuto();

    boolean hasName();

    /* synthetic */ boolean isInitialized();
}

package com.google.firebase.perf.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.l0;
import com.google.protobuf.m0;
import java.util.List;

public interface PerfSessionOrBuilder extends m0 {
    /* synthetic */ l0 getDefaultInstanceForType();

    String getSessionId();

    ByteString getSessionIdBytes();

    SessionVerbosity getSessionVerbosity(int i10);

    int getSessionVerbosityCount();

    List<SessionVerbosity> getSessionVerbosityList();

    boolean hasSessionId();

    /* synthetic */ boolean isInitialized();
}

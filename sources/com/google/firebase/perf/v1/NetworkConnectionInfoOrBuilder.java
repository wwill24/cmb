package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.NetworkConnectionInfo;
import com.google.protobuf.l0;
import com.google.protobuf.m0;

public interface NetworkConnectionInfoOrBuilder extends m0 {
    /* synthetic */ l0 getDefaultInstanceForType();

    NetworkConnectionInfo.MobileSubtype getMobileSubtype();

    NetworkConnectionInfo.NetworkType getNetworkType();

    boolean hasMobileSubtype();

    boolean hasNetworkType();

    /* synthetic */ boolean isInitialized();
}

package com.google.firebase.perf.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.l0;
import com.google.protobuf.m0;

public interface AndroidApplicationInfoOrBuilder extends m0 {
    /* synthetic */ l0 getDefaultInstanceForType();

    String getPackageName();

    ByteString getPackageNameBytes();

    String getSdkVersion();

    ByteString getSdkVersionBytes();

    String getVersionName();

    ByteString getVersionNameBytes();

    boolean hasPackageName();

    boolean hasSdkVersion();

    boolean hasVersionName();

    /* synthetic */ boolean isInitialized();
}

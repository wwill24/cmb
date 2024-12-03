package com.google.firebase.perf.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.l0;
import com.google.protobuf.m0;
import java.util.Map;

public interface ApplicationInfoOrBuilder extends m0 {
    boolean containsCustomAttributes(String str);

    AndroidApplicationInfo getAndroidAppInfo();

    String getAppInstanceId();

    ByteString getAppInstanceIdBytes();

    ApplicationProcessState getApplicationProcessState();

    @Deprecated
    Map<String, String> getCustomAttributes();

    int getCustomAttributesCount();

    Map<String, String> getCustomAttributesMap();

    String getCustomAttributesOrDefault(String str, String str2);

    String getCustomAttributesOrThrow(String str);

    /* synthetic */ l0 getDefaultInstanceForType();

    String getGoogleAppId();

    ByteString getGoogleAppIdBytes();

    boolean hasAndroidAppInfo();

    boolean hasAppInstanceId();

    boolean hasApplicationProcessState();

    boolean hasGoogleAppId();

    /* synthetic */ boolean isInitialized();
}

package com.google.firebase.heartbeatinfo;

public abstract class SdkHeartBeatResult implements Comparable<SdkHeartBeatResult> {
    public static SdkHeartBeatResult create(String str, long j10) {
        return new AutoValue_SdkHeartBeatResult(str, j10);
    }

    public abstract long getMillis();

    public abstract String getSdkName();

    public int compareTo(SdkHeartBeatResult sdkHeartBeatResult) {
        return getMillis() < sdkHeartBeatResult.getMillis() ? -1 : 1;
    }
}

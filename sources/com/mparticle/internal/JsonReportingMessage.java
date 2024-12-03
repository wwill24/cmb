package com.mparticle.internal;

import org.json.b;

public interface JsonReportingMessage {
    int getModuleId();

    String getSessionId();

    long getTimestamp();

    void setDevMode(boolean z10);

    void setSessionId(String str);

    b toJson();
}

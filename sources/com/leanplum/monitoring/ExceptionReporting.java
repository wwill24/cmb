package com.leanplum.monitoring;

import android.content.Context;

public interface ExceptionReporting {
    void reportException(Throwable th2);

    void setContext(Context context);
}

package com.leanplum.monitoring;

import android.content.Context;
import com.leanplum.internal.Log;

public class ExceptionHandler {
    private static final String LEANPLUM_CRASH_REPORTER_CLASS = "com.leanplum.monitoring.internal.LeanplumExceptionReporter";
    private static final ExceptionHandler instance = new ExceptionHandler();
    public ExceptionReporting exceptionReporter = null;

    private ExceptionHandler() {
    }

    public static ExceptionHandler getInstance() {
        return instance;
    }

    public void reportException(Throwable th2) {
        ExceptionReporting exceptionReporting = this.exceptionReporter;
        if (exceptionReporting != null) {
            try {
                exceptionReporting.reportException(th2);
            } catch (Throwable th3) {
                Log.e("LeanplumExceptionHandler", th3);
            }
        }
    }

    public void setContext(Context context) {
        try {
            Class.forName(LEANPLUM_CRASH_REPORTER_CLASS);
            ExceptionReporting exceptionReporting = this.exceptionReporter;
            if (exceptionReporting != null) {
                try {
                    exceptionReporting.setContext(context);
                } catch (Throwable th2) {
                    Log.e("LeanplumExceptionHandler", th2);
                }
            }
        } catch (ClassNotFoundException unused) {
            Log.i("LeanplumExceptionHandler could not initialize Exception Reporting.This is expected if you have not included the leanplum-monitoring module", new Object[0]);
        } catch (Throwable th3) {
            Log.e("LeanplumExceptionHandler", th3);
        }
    }
}

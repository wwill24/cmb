package com.google.firebase.database.logging;

import com.google.firebase.database.logging.Logger;
import java.util.List;

public class AndroidLogger extends DefaultLogger {
    public AndroidLogger(Logger.Level level, List<String> list) {
        super(level, list);
    }

    /* access modifiers changed from: protected */
    public String buildLogMessage(Logger.Level level, String str, String str2, long j10) {
        return str2;
    }

    /* access modifiers changed from: protected */
    public void debug(String str, String str2) {
    }

    /* access modifiers changed from: protected */
    public void error(String str, String str2) {
    }

    /* access modifiers changed from: protected */
    public void info(String str, String str2) {
    }

    /* access modifiers changed from: protected */
    public void warn(String str, String str2) {
    }
}

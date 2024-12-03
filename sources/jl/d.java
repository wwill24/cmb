package jl;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Ljl/d;", "Ljava/util/logging/Handler;", "Ljava/util/logging/LogRecord;", "record", "", "publish", "flush", "close", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public static final d f31899a = new d();

    private d() {
    }

    public void close() {
    }

    public void flush() {
    }

    public void publish(LogRecord logRecord) {
        j.g(logRecord, "record");
        c cVar = c.f31896a;
        String loggerName = logRecord.getLoggerName();
        j.f(loggerName, "record.loggerName");
        int a10 = e.b(logRecord);
        String message = logRecord.getMessage();
        j.f(message, "record.message");
        cVar.a(loggerName, a10, message, logRecord.getThrown());
    }
}

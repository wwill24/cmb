package jl;

import android.util.Log;
import el.e;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okhttp3.x;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J1\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0007R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0013R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0016¨\u0006\u001a"}, d2 = {"Ljl/c;", "", "", "loggerName", "d", "logger", "tag", "", "c", "", "logLevel", "message", "", "t", "a", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V", "b", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/logging/Logger;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "configuredLoggers", "", "Ljava/util/Map;", "knownLoggers", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f31896a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final CopyOnWriteArraySet<Logger> f31897b = new CopyOnWriteArraySet<>();

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, String> f31898c;

    static {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package packageR = x.class.getPackage();
        if (packageR == null) {
            str = null;
        } else {
            str = packageR.getName();
        }
        if (str != null) {
            linkedHashMap.put(str, "OkHttp");
        }
        String name = x.class.getName();
        j.f(name, "OkHttpClient::class.java.name");
        linkedHashMap.put(name, "okhttp.OkHttpClient");
        String name2 = hl.c.class.getName();
        j.f(name2, "Http2::class.java.name");
        linkedHashMap.put(name2, "okhttp.Http2");
        String name3 = e.class.getName();
        j.f(name3, "TaskRunner::class.java.name");
        linkedHashMap.put(name3, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        f31898c = h0.u(linkedHashMap);
    }

    private c() {
    }

    private final void c(String str, String str2) {
        Level level;
        Logger logger = Logger.getLogger(str);
        if (f31897b.add(logger)) {
            logger.setUseParentHandlers(false);
            if (Log.isLoggable(str2, 3)) {
                level = Level.FINE;
            } else if (Log.isLoggable(str2, 4)) {
                level = Level.INFO;
            } else {
                level = Level.WARNING;
            }
            logger.setLevel(level);
            logger.addHandler(d.f31899a);
        }
    }

    private final String d(String str) {
        String str2 = f31898c.get(str);
        return str2 == null ? t.h1(str, 23) : str2;
    }

    public final void a(String str, int i10, String str2, Throwable th2) {
        int min;
        j.g(str, "loggerName");
        j.g(str2, "message");
        String d10 = d(str);
        if (Log.isLoggable(d10, i10)) {
            if (th2 != null) {
                str2 = str2 + 10 + Log.getStackTraceString(th2);
            }
            int i11 = 0;
            int length = str2.length();
            while (i11 < length) {
                int a02 = StringsKt__StringsKt.a0(str2, 10, i11, false, 4, (Object) null);
                if (a02 == -1) {
                    a02 = length;
                }
                while (true) {
                    min = Math.min(a02, i11 + 4000);
                    String substring = str2.substring(i11, min);
                    j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(i10, d10, substring);
                    if (min >= a02) {
                        break;
                    }
                    i11 = min;
                }
                i11 = min + 1;
            }
        }
    }

    public final void b() {
        for (Map.Entry next : f31898c.entrySet()) {
            c((String) next.getKey(), (String) next.getValue());
        }
    }
}

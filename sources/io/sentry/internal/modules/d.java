package io.sentry.internal.modules;

import io.sentry.SentryLevel;
import io.sentry.h0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public abstract class d implements b {

    /* renamed from: c  reason: collision with root package name */
    private static final Charset f31297c = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    protected final h0 f31298a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f31299b = null;

    public d(h0 h0Var) {
        this.f31298a = h0Var;
    }

    public Map<String, String> a() {
        Map<String, String> map = this.f31299b;
        if (map != null) {
            return map;
        }
        Map<String, String> b10 = b();
        this.f31299b = b10;
        return b10;
    }

    /* access modifiers changed from: protected */
    public abstract Map<String, String> b();

    /* access modifiers changed from: protected */
    public Map<String, String> c(InputStream inputStream) {
        BufferedReader bufferedReader;
        TreeMap treeMap = new TreeMap();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, f31297c));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                int lastIndexOf = readLine.lastIndexOf(58);
                treeMap.put(readLine.substring(0, lastIndexOf), readLine.substring(lastIndexOf + 1));
            }
            this.f31298a.c(SentryLevel.DEBUG, "Extracted %d modules from resources.", Integer.valueOf(treeMap.size()));
            bufferedReader.close();
        } catch (IOException e10) {
            this.f31298a.b(SentryLevel.ERROR, "Error extracting modules.", e10);
        } catch (RuntimeException e11) {
            this.f31298a.a(SentryLevel.ERROR, e11, "%s file is malformed.", "sentry-external-modules.txt");
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        return treeMap;
        throw th;
    }
}

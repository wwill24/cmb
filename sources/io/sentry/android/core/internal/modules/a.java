package io.sentry.android.core.internal.modules;

import android.content.Context;
import io.sentry.SentryLevel;
import io.sentry.h0;
import io.sentry.internal.modules.d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class a extends d {

    /* renamed from: d  reason: collision with root package name */
    private final Context f31019d;

    public a(Context context, h0 h0Var) {
        super(h0Var);
        this.f31019d = context;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> b() {
        TreeMap treeMap = new TreeMap();
        try {
            return c(this.f31019d.getAssets().open("sentry-external-modules.txt"));
        } catch (FileNotFoundException unused) {
            this.f31298a.c(SentryLevel.INFO, "%s file was not found.", "sentry-external-modules.txt");
            return treeMap;
        } catch (IOException e10) {
            this.f31298a.b(SentryLevel.ERROR, "Error extracting modules.", e10);
            return treeMap;
        }
    }
}

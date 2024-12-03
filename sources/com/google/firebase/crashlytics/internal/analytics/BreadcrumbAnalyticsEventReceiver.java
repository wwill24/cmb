package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import org.json.JSONException;
import org.json.b;

public class BreadcrumbAnalyticsEventReceiver implements AnalyticsEventReceiver, BreadcrumbSource {
    private static final String BREADCRUMB_NAME_KEY = "name";
    private static final String BREADCRUMB_PARAMS_KEY = "parameters";
    private static final String BREADCRUMB_PREFIX = "$A$:";
    private BreadcrumbHandler breadcrumbHandler;

    @NonNull
    private static String serializeEvent(@NonNull String str, @NonNull Bundle bundle) throws JSONException {
        b bVar = new b();
        b bVar2 = new b();
        for (String next : bundle.keySet()) {
            bVar2.put(next, bundle.get(next));
        }
        bVar.put("name", (Object) str);
        bVar.put(BREADCRUMB_PARAMS_KEY, (Object) bVar2);
        return bVar.toString();
    }

    public void onEvent(@NonNull String str, @NonNull Bundle bundle) {
        BreadcrumbHandler breadcrumbHandler2 = this.breadcrumbHandler;
        if (breadcrumbHandler2 != null) {
            try {
                breadcrumbHandler2.handleBreadcrumb(BREADCRUMB_PREFIX + serializeEvent(str, bundle));
            } catch (JSONException unused) {
                Logger.getLogger().w("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }

    public void registerBreadcrumbHandler(BreadcrumbHandler breadcrumbHandler2) {
        this.breadcrumbHandler = breadcrumbHandler2;
        Logger.getLogger().d("Registered Firebase Analytics event receiver for breadcrumbs");
    }
}

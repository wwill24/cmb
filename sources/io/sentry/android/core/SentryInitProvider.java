package io.sentry.android.core;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import io.sentry.SentryLevel;
import io.sentry.n2;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class SentryInitProvider extends o0 {
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (!SentryInitProvider.class.getName().equals(providerInfo.authority)) {
            super.attachInfo(context, providerInfo);
            return;
        }
        throw new IllegalStateException("An applicationId is required to fulfill the manifest placeholder.");
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        s sVar = new s();
        Context context = getContext();
        if (context == null) {
            sVar.c(SentryLevel.FATAL, "App. Context from ContentProvider is null", new Object[0]);
            return false;
        } else if (!v0.c(context, sVar)) {
            return true;
        } else {
            d1.d(context, sVar);
            return true;
        }
    }

    public void shutdown() {
        n2.g();
    }
}

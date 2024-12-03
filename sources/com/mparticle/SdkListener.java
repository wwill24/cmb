package com.mparticle;

import androidx.annotation.NonNull;
import com.mparticle.identity.AliasResponse;
import com.mparticle.internal.InternalSession;
import java.util.List;
import org.json.b;

public class SdkListener {
    public static final String ERROR_MESSAGE = "message";

    public enum DatabaseTable {
        ATTRIBUTES,
        BREADCRUMBS,
        MESSAGES,
        REPORTING,
        SESSIONS,
        UPLOADS,
        UNKNOWN
    }

    public enum Endpoint {
        IDENTITY_LOGIN,
        IDENTITY_LOGOUT,
        IDENTITY_IDENTIFY,
        IDENTITY_MODIFY,
        IDENTITY_ALIAS,
        EVENTS,
        CONFIG
    }

    public void onAliasRequestFinished(AliasResponse aliasResponse) {
    }

    public void onApiCalled(@NonNull String str, @NonNull List<Object> list, boolean z10) {
    }

    public void onEntityStored(@NonNull DatabaseTable databaseTable, @NonNull long j10, @NonNull b bVar) {
    }

    public void onKitApiCalled(int i10, @NonNull String str, String str2, String str3, @NonNull List<Object> list, boolean z10) {
    }

    public void onKitConfigReceived(int i10, @NonNull b bVar) {
    }

    public void onKitDetected(int i10) {
    }

    public void onKitExcluded(int i10, @NonNull String str) {
    }

    public void onKitStarted(int i10) {
    }

    public void onNetworkRequestFinished(@NonNull Endpoint endpoint, @NonNull String str, b bVar, int i10) {
    }

    public void onNetworkRequestStarted(@NonNull Endpoint endpoint, @NonNull String str, @NonNull b bVar) {
    }

    public void onSessionUpdated(InternalSession internalSession) {
    }
}

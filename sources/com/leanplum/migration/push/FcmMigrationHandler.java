package com.leanplum.migration.push;

import com.clevertap.android.sdk.pushnotification.fcm.a;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/leanplum/migration/push/FcmMigrationHandler;", "Lcom/clevertap/android/sdk/pushnotification/fcm/a;", "", "forwardingEnabled", "Z", "getForwardingEnabled", "()Z", "setForwardingEnabled", "(Z)V", "<init>", "()V", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class FcmMigrationHandler extends a {
    private boolean forwardingEnabled = true;

    public final boolean getForwardingEnabled() {
        return this.forwardingEnabled;
    }

    public final void setForwardingEnabled(boolean z10) {
        this.forwardingEnabled = z10;
    }
}

package com.leanplum;

import com.leanplum.internal.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/leanplum/LeanplumCloudMessagingProvider;", "provider", "", "updateRegistrationId", "(Lcom/leanplum/LeanplumCloudMessagingProvider;)V", "unregister", "()V", "AndroidSDKFcm_release"}, k = 2, mv = {1, 4, 2})
public final class FirebaseUtilKt {
    public static final void unregister() {
        try {
            Present.INSTANCE.unregister();
        } catch (NoSuchMethodError e10) {
            Log.e("Minimum supported version of Firebase is 20.3.0", (Throwable) e10);
        }
    }

    public static final void updateRegistrationId(LeanplumCloudMessagingProvider leanplumCloudMessagingProvider) {
        j.g(leanplumCloudMessagingProvider, "provider");
        try {
            Present.INSTANCE.updateRegistrationId(leanplumCloudMessagingProvider);
        } catch (NoSuchMethodError e10) {
            Log.e("Minimum supported version of Firebase is 20.3.0", (Throwable) e10);
        }
    }
}

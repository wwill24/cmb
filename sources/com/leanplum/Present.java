package com.leanplum;

import com.google.firebase.messaging.FirebaseMessaging;
import com.leanplum.internal.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/leanplum/Present;", "", "Lcom/leanplum/LeanplumCloudMessagingProvider;", "provider", "", "updateRegistrationId", "(Lcom/leanplum/LeanplumCloudMessagingProvider;)V", "unregister", "()V", "<init>", "AndroidSDKFcm_release"}, k = 1, mv = {1, 4, 2})
final class Present {
    public static final Present INSTANCE = new Present();

    private Present() {
    }

    public final void unregister() {
        try {
            FirebaseMessaging.getInstance().deleteToken();
            Log.i("Application was unregistered from FirebaseMessaging.", new Object[0]);
        } catch (Exception unused) {
            Log.e("Failed to unregister from FirebaseMessaging.", new Object[0]);
        }
    }

    public final void updateRegistrationId(LeanplumCloudMessagingProvider leanplumCloudMessagingProvider) {
        j.g(leanplumCloudMessagingProvider, "provider");
        FirebaseMessaging instance = FirebaseMessaging.getInstance();
        j.f(instance, "FirebaseMessaging.getInstance()");
        instance.getToken().addOnCompleteListener(new Present$updateRegistrationId$1(leanplumCloudMessagingProvider));
    }
}

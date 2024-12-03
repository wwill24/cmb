package com.leanplum;

import android.text.TextUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.leanplum.internal.Log;
import com.leanplum.migration.MigrationManager;
import com.leanplum.migration.push.FcmMigrationHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/google/android/gms/tasks/Task;", "", "kotlin.jvm.PlatformType", "it", "", "onComplete", "(Lcom/google/android/gms/tasks/Task;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
final class Present$updateRegistrationId$1<TResult> implements OnCompleteListener<String> {
    final /* synthetic */ LeanplumCloudMessagingProvider $provider;

    Present$updateRegistrationId$1(LeanplumCloudMessagingProvider leanplumCloudMessagingProvider) {
        this.$provider = leanplumCloudMessagingProvider;
    }

    public final void onComplete(Task<String> task) {
        j.g(task, "it");
        if (task.isSuccessful()) {
            String str = task.getResult().toString();
            if (!TextUtils.isEmpty(str)) {
                this.$provider.setRegistrationId(str);
                FcmMigrationHandler fcmHandler = MigrationManager.getWrapper().getFcmHandler();
                if (fcmHandler != null) {
                    fcmHandler.onNewToken(Leanplum.getContext(), str);
                    return;
                }
                return;
            }
            return;
        }
        Log.e("getToken failed:\n" + Log.getStackTraceString(task.getException()), new Object[0]);
    }
}

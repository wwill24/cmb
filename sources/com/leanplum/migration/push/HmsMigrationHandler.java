package com.leanplum.migration.push;

import android.content.Context;
import android.os.Bundle;
import com.clevertap.android.sdk.pushnotification.PushConstants;
import com.clevertap.android.sdk.pushnotification.h;
import i4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\b¨\u0006\u000b"}, d2 = {"Lcom/leanplum/migration/push/HmsMigrationHandler;", "", "()V", "createNotification", "", "context", "Landroid/content/Context;", "messageData", "", "onNewToken", "token", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class HmsMigrationHandler {
    public final boolean createNotification(Context context, String str) {
        Bundle x10 = x.x(str);
        j.f(x10, "Utils.stringToBundle(messageData)");
        try {
            return h.d().c(context, x10, PushConstants.PushType.HPS.toString());
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public final boolean onNewToken(Context context, String str) {
        try {
            h.d().a(context, str, PushConstants.PushType.HPS.h());
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }
}

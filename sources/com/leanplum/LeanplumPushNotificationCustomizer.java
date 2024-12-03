package com.leanplum;

import android.app.Notification;
import android.os.Bundle;
import androidx.core.app.p;

public interface LeanplumPushNotificationCustomizer {
    void customize(Notification.Builder builder, Bundle bundle, Notification.Style style);

    void customize(p.e eVar, Bundle bundle);
}

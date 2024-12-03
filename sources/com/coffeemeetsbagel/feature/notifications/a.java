package com.coffeemeetsbagel.feature.notifications;

import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.coffeemeetsbagel.profile.GetProfileAvatarUseCase;

public final class a {
    public static void a(NotificationWorkManagerWorker notificationWorkManagerWorker, FirebaseContract.Analytics analytics) {
        notificationWorkManagerWorker.f13115g = analytics;
    }

    public static void b(NotificationWorkManagerWorker notificationWorkManagerWorker, GetProfileAvatarUseCase getProfileAvatarUseCase) {
        notificationWorkManagerWorker.f13117j = getProfileAvatarUseCase;
    }

    public static void c(NotificationWorkManagerWorker notificationWorkManagerWorker, t tVar) {
        notificationWorkManagerWorker.f13116h = tVar;
    }
}

package com.coffeemeetsbagel.feature.profile;

import android.content.Context;
import android.os.Bundle;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.NetworkProfile;
import j5.x;
import jc.b;
import qj.q;
import z9.j;

public interface ProfileContract$Manager {

    public enum NotificationSettingsType {
        DAILY_NOON_ALERT,
        CHAT,
        CUSTOMER_SERVICE,
        VIDEO,
        NEW_LIKES
    }

    public interface a<T> {
        void onError(Throwable th2);

        void onSuccess(T t10);
    }

    void a();

    boolean b();

    void c(NetworkPhoto networkPhoto);

    void clear();

    void d(b<Void> bVar);

    @Deprecated
    void e(Bundle bundle, v8.a aVar);

    void f();

    void g(NotificationSettingsType notificationSettingsType, boolean z10);

    boolean h();

    q<ProfileManager.ProfileStatus> i();

    NetworkProfile j();

    void k(j jVar);

    void l(j jVar);

    q<x> m();

    q<x> n();

    String o(Context context, NetworkProfile networkProfile);

    void p(b<Void> bVar, ModelProfileUpdateDelta modelProfileUpdateDelta, boolean z10);

    boolean q(NetworkProfile networkProfile);

    void start();
}

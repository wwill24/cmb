package com.coffeemeetsbagel.new_user_experience.notification;

import a7.a;
import android.view.ViewGroup;
import b6.s;
import com.coffeemeetsbagel.new_user_experience.notification.NotificationPresenter;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.j;
import na.b;

public final class f extends s<NotificationPresenter, i> implements NotificationPresenter.a {

    /* renamed from: f  reason: collision with root package name */
    public b f35545f;

    /* renamed from: g  reason: collision with root package name */
    public a f35546g;

    public final a H1() {
        a aVar = this.f35546g;
        if (aVar != null) {
            return aVar;
        }
        j.y("analyticsManager");
        return null;
    }

    public final b I1() {
        b bVar = this.f35545f;
        if (bVar != null) {
            return bVar;
        }
        j.y("interactionListener");
        return null;
    }

    public void a() {
        if (androidx.core.content.a.checkSelfPermission(((ViewGroup) ((NotificationPresenter) G1()).g()).getContext(), "android.permission.POST_NOTIFICATIONS") != 0) {
            a H1 = H1();
            String format2 = String.format("Onboarding - %s - Next Button Tapped", Arrays.copyOf(new Object[]{"Push Received"}, 1));
            j.f(format2, "format(this, *args)");
            H1.d(format2);
            ((i) B1()).m();
            return;
        }
        b.f(I1(), (Map) null, 1, (Object) null);
    }
}

package r8;

import android.content.Context;
import android.content.Intent;
import com.coffeemeetsbagel.feature.notifications.NotificationWorkManagerWorker;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.enums.NotificationType;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class f implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotificationWorkManagerWorker f17390a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f17391b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f17392c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ NotificationType f17393d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Bagel f17394e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f17395f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Intent f17396g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Intent f17397h;

    public /* synthetic */ f(NotificationWorkManagerWorker notificationWorkManagerWorker, String str, String str2, NotificationType notificationType, Bagel bagel, Context context, Intent intent, Intent intent2) {
        this.f17390a = notificationWorkManagerWorker;
        this.f17391b = str;
        this.f17392c = str2;
        this.f17393d = notificationType;
        this.f17394e = bagel;
        this.f17395f = context;
        this.f17396g = intent;
        this.f17397h = intent2;
    }

    public final Object invoke() {
        return this.f17390a.I(this.f17391b, this.f17392c, this.f17393d, this.f17394e, this.f17395f, this.f17396g, this.f17397h);
    }
}

package r8;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.coffeemeetsbagel.feature.notifications.NotificationWorkManagerWorker;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.enums.NotificationType;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class g implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotificationWorkManagerWorker f17398a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f17399b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f17400c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ NotificationType f17401d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Bagel f17402e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f17403f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Intent f17404g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Intent f17405h;

    public /* synthetic */ g(NotificationWorkManagerWorker notificationWorkManagerWorker, String str, String str2, NotificationType notificationType, Bagel bagel, Context context, Intent intent, Intent intent2) {
        this.f17398a = notificationWorkManagerWorker;
        this.f17399b = str;
        this.f17400c = str2;
        this.f17401d = notificationType;
        this.f17402e = bagel;
        this.f17403f = context;
        this.f17404g = intent;
        this.f17405h = intent2;
    }

    public final Object invoke(Object obj) {
        return this.f17398a.J(this.f17399b, this.f17400c, this.f17401d, this.f17402e, this.f17403f, this.f17404g, this.f17405h, (Bitmap) obj);
    }
}

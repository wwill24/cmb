package r8;

import com.coffeemeetsbagel.feature.notifications.NotificationWorkManagerWorker;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotificationWorkManagerWorker f17388a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f17389b;

    public /* synthetic */ c(NotificationWorkManagerWorker notificationWorkManagerWorker, String str) {
        this.f17388a = notificationWorkManagerWorker;
        this.f17389b = str;
    }

    public final void run() {
        this.f17388a.M(this.f17389b);
    }
}

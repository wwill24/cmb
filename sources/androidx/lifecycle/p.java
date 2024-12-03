package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.jvm.internal.j;

public class p extends Service implements l {

    /* renamed from: a  reason: collision with root package name */
    private final e0 f6059a = new e0(this);

    public Lifecycle getLifecycle() {
        return this.f6059a.a();
    }

    public IBinder onBind(Intent intent) {
        j.g(intent, SDKConstants.PARAM_INTENT);
        this.f6059a.b();
        return null;
    }

    public void onCreate() {
        this.f6059a.c();
        super.onCreate();
    }

    public void onDestroy() {
        this.f6059a.d();
        super.onDestroy();
    }

    public void onStart(Intent intent, int i10) {
        this.f6059a.e();
        super.onStart(intent, i10);
    }

    public int onStartCommand(Intent intent, int i10, int i11) {
        return super.onStartCommand(intent, i10, i11);
    }
}

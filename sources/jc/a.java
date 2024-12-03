package jc;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.os.ResultReceiver;
import com.coffeemeetsbagel.models.CmbErrorCode;
import com.coffeemeetsbagel.transport.SuccessStatus;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.d;
import com.google.gson.e;
import java.io.Serializable;
import lc.r;
import okhttp3.x;
import org.json.b;

public abstract class a extends IntentService {

    /* renamed from: a  reason: collision with root package name */
    protected PowerManager.WakeLock f41051a;

    /* renamed from: b  reason: collision with root package name */
    protected ResultReceiver f41052b;

    /* renamed from: c  reason: collision with root package name */
    protected d f41053c = new e().c(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).b();

    /* renamed from: d  reason: collision with root package name */
    protected x f41054d = r.d();

    /* renamed from: e  reason: collision with root package name */
    protected b f41055e = new b();

    /* renamed from: f  reason: collision with root package name */
    protected Handler f41056f = new Handler();

    public a() {
        super("AbstractIntentService");
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (this.f41051a == null) {
            this.f41051a = ((PowerManager) getSystemService("power")).newWakeLock(1, "CMB:AbstractIntentService");
        }
        if (!this.f41051a.isHeld()) {
            this.f41051a.acquire();
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        PowerManager.WakeLock wakeLock = this.f41051a;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.f41051a.release();
        }
    }

    /* access modifiers changed from: protected */
    public void c(ResultReceiver resultReceiver, CmbErrorCode cmbErrorCode) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("RESULT_STATUS_ERROR", cmbErrorCode);
        if (resultReceiver != null) {
            resultReceiver.send(1, bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void d(ResultReceiver resultReceiver, SuccessStatus successStatus, Serializable serializable) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("RESULT_STATUS_SUCCESS", successStatus);
        bundle.putSerializable("RESULT_SUCCESS", serializable);
        resultReceiver.send(0, bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        b();
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        a();
        if (intent != null) {
            this.f41052b = (ResultReceiver) intent.getExtras().get("ResultReceiver");
        } else {
            fa.a.i(new IllegalArgumentException("Intent was null AbstractIntentService"));
        }
    }
}

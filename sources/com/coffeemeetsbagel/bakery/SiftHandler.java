package com.coffeemeetsbagel.bakery;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.coffeemeetsbagel.R;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import fa.a;
import kotlin.jvm.internal.j;
import siftscience.android.Sift;

public final class SiftHandler extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final String f11061a = "SiftHandler";

    public enum SiftEvent {
        CREATE,
        RESUME,
        PAUSE,
        DESTROYED
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SiftHandler(Looper looper) {
        super(looper);
        j.g(looper, "backgroundLooper");
    }

    public final void a(SiftEvent siftEvent) {
        j.g(siftEvent, "siftEvent");
        b(siftEvent, (Activity) null);
    }

    public final void b(SiftEvent siftEvent, Activity activity) {
        j.g(siftEvent, "siftEvent");
        if (activity == null) {
            sendEmptyMessage(siftEvent.ordinal());
        } else {
            sendMessage(obtainMessage(siftEvent.ordinal(), activity));
        }
    }

    public void handleMessage(Message message) {
        j.g(message, SDKConstants.PARAM_DEBUG_MESSAGE);
        SiftEvent siftEvent = SiftEvent.values()[message.what];
        a.C0491a aVar = a.f40771d;
        String str = this.f11061a;
        String name = Thread.currentThread().getName();
        aVar.a(str, "handleMessage: " + siftEvent + " thread=" + name);
        if (siftEvent == SiftEvent.CREATE) {
            Bakery w10 = Bakery.w();
            aVar.a(this.f11061a, "\topen()");
            Sift.open(w10.getApplicationContext(), new Sift.Config.Builder().withAccountId(w10.getString(R.string.sift_account_id)).withBeaconKey(w10.getString(R.string.sift_beacon_key)).build());
            aVar.a(this.f11061a, "\tcollect()");
            Sift.collect();
        } else if (siftEvent == SiftEvent.RESUME) {
            String str2 = this.f11061a;
            Object obj = message.obj;
            aVar.a(str2, "\tresume(): " + obj);
            Object obj2 = message.obj;
            j.e(obj2, "null cannot be cast to non-null type android.app.Activity");
            Sift.resume((Activity) obj2);
        } else if (siftEvent == SiftEvent.PAUSE) {
            aVar.a(this.f11061a, "\tpause(): ");
            Sift.pause();
        } else if (siftEvent == SiftEvent.DESTROYED) {
            aVar.a(this.f11061a, "\tclose(): ");
            Sift.close();
        }
    }
}

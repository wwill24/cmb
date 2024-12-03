package gb;

import android.os.Bundle;
import com.coffeemeetsbagel.models.enums.EventType;
import h5.i;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventType f40858a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bundle f40859b;

    public /* synthetic */ f(EventType eventType, Bundle bundle) {
        this.f40858a = eventType;
        this.f40859b = bundle;
    }

    public final void run() {
        i.c(this.f40858a, this.f40859b);
    }
}

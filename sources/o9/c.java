package o9;

import android.os.Handler;
import android.os.Message;

public final /* synthetic */ class c implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f16837a;

    public /* synthetic */ c(f fVar) {
        this.f16837a = fVar;
    }

    public final boolean handleMessage(Message message) {
        return this.f16837a.d(message);
    }
}

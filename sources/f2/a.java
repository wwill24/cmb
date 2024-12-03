package f2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import b2.f;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mparticle.identity.IdentityHttpResponse;
import i2.b;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\n\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lf2/a;", "Lf2/e;", "", "Landroid/content/Intent;", "intent", "m", "", "k", "l", "()Ljava/lang/Boolean;", "initialState", "Landroid/content/IntentFilter;", "j", "()Landroid/content/IntentFilter;", "intentFilter", "Landroid/content/Context;", "context", "Li2/b;", "taskExecutor", "<init>", "(Landroid/content/Context;Li2/b;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class a extends e<Boolean> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, b bVar) {
        super(context, bVar);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(bVar, "taskExecutor");
    }

    private final boolean m(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    public IntentFilter j() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.CHARGING");
        intentFilter.addAction("android.os.action.DISCHARGING");
        return intentFilter;
    }

    public void k(Intent intent) {
        j.g(intent, SDKConstants.PARAM_INTENT);
        String action = intent.getAction();
        if (action != null) {
            f e10 = f.e();
            String a10 = b.f14641a;
            e10.a(a10, "Received " + action);
            switch (action.hashCode()) {
                case -1886648615:
                    if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        g(Boolean.FALSE);
                        return;
                    }
                    return;
                case -54942926:
                    if (action.equals("android.os.action.DISCHARGING")) {
                        g(Boolean.FALSE);
                        return;
                    }
                    return;
                case 948344062:
                    if (action.equals("android.os.action.CHARGING")) {
                        g(Boolean.TRUE);
                        return;
                    }
                    return;
                case 1019184907:
                    if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                        g(Boolean.TRUE);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: l */
    public Boolean e() {
        Intent registerReceiver = d().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return Boolean.valueOf(m(registerReceiver));
        }
        f.e().c(b.f14641a, "getInitialState - null intent received");
        return Boolean.FALSE;
    }
}

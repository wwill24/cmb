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

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lf2/e;", "T", "Lf2/h;", "Landroid/content/Intent;", "intent", "", "k", "h", "i", "Landroid/content/BroadcastReceiver;", "f", "Landroid/content/BroadcastReceiver;", "broadcastReceiver", "Landroid/content/IntentFilter;", "j", "()Landroid/content/IntentFilter;", "intentFilter", "Landroid/content/Context;", "context", "Li2/b;", "taskExecutor", "<init>", "(Landroid/content/Context;Li2/b;)V", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
public abstract class e<T> extends h<T> {

    /* renamed from: f  reason: collision with root package name */
    private final BroadcastReceiver f14643f = new a(this);

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"f2/e$a", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "work-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e<T> f14644a;

        a(e<T> eVar) {
            this.f14644a = eVar;
        }

        public void onReceive(Context context, Intent intent) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            j.g(intent, SDKConstants.PARAM_INTENT);
            this.f14644a.k(intent);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Context context, b bVar) {
        super(context, bVar);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(bVar, "taskExecutor");
    }

    public void h() {
        f e10 = f.e();
        String a10 = f.f14645a;
        e10.a(a10, getClass().getSimpleName() + ": registering receiver");
        d().registerReceiver(this.f14643f, j());
    }

    public void i() {
        f e10 = f.e();
        String a10 = f.f14645a;
        e10.a(a10, getClass().getSimpleName() + ": unregistering receiver");
        d().unregisterReceiver(this.f14643f);
    }

    public abstract IntentFilter j();

    public abstract void k(Intent intent);
}

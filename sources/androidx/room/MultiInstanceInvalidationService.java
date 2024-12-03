package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import androidx.room.j;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u000e8\u0000X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0000X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0007\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001a¨\u0006\u001e"}, d2 = {"Landroidx/room/MultiInstanceInvalidationService;", "Landroid/app/Service;", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "", "a", "I", "c", "()I", "d", "(I)V", "maxClientId", "", "", "b", "Ljava/util/Map;", "()Ljava/util/Map;", "clientNames", "Landroid/os/RemoteCallbackList;", "Landroidx/room/i;", "Landroid/os/RemoteCallbackList;", "()Landroid/os/RemoteCallbackList;", "callbackList", "Landroidx/room/j$a;", "Landroidx/room/j$a;", "binder", "<init>", "()V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class MultiInstanceInvalidationService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private int f6749a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, String> f6750b = new LinkedHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final RemoteCallbackList<i> f6751c = new b(this);

    /* renamed from: d  reason: collision with root package name */
    private final j.a f6752d = new a(this);

    @Metadata(bv = {}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0016J'\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00062\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"androidx/room/MultiInstanceInvalidationService$a", "Landroidx/room/j$a;", "Landroidx/room/i;", "callback", "", "name", "", "Q", "clientId", "", "s0", "", "tables", "D", "(I[Ljava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class a extends j.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MultiInstanceInvalidationService f6753a;

        a(MultiInstanceInvalidationService multiInstanceInvalidationService) {
            this.f6753a = multiInstanceInvalidationService;
        }

        public void D(int i10, String[] strArr) {
            kotlin.jvm.internal.j.g(strArr, "tables");
            RemoteCallbackList<i> a10 = this.f6753a.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.f6753a;
            synchronized (a10) {
                String str = multiInstanceInvalidationService.b().get(Integer.valueOf(i10));
                if (str != null) {
                    int beginBroadcast = multiInstanceInvalidationService.a().beginBroadcast();
                    int i11 = 0;
                    while (i11 < beginBroadcast) {
                        try {
                            Object broadcastCookie = multiInstanceInvalidationService.a().getBroadcastCookie(i11);
                            kotlin.jvm.internal.j.e(broadcastCookie, "null cannot be cast to non-null type kotlin.Int");
                            int intValue = ((Integer) broadcastCookie).intValue();
                            String str2 = multiInstanceInvalidationService.b().get(Integer.valueOf(intValue));
                            if (i10 != intValue && kotlin.jvm.internal.j.b(str, str2)) {
                                try {
                                    multiInstanceInvalidationService.a().getBroadcastItem(i11).l(strArr);
                                } catch (RemoteException unused) {
                                }
                            }
                            i11++;
                        } catch (Throwable th2) {
                            multiInstanceInvalidationService.a().finishBroadcast();
                            throw th2;
                        }
                    }
                    multiInstanceInvalidationService.a().finishBroadcast();
                    Unit unit = Unit.f32013a;
                }
            }
        }

        public int Q(i iVar, String str) {
            kotlin.jvm.internal.j.g(iVar, "callback");
            int i10 = 0;
            if (str == null) {
                return 0;
            }
            RemoteCallbackList<i> a10 = this.f6753a.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.f6753a;
            synchronized (a10) {
                multiInstanceInvalidationService.d(multiInstanceInvalidationService.c() + 1);
                int c10 = multiInstanceInvalidationService.c();
                if (multiInstanceInvalidationService.a().register(iVar, Integer.valueOf(c10))) {
                    multiInstanceInvalidationService.b().put(Integer.valueOf(c10), str);
                    i10 = c10;
                } else {
                    multiInstanceInvalidationService.d(multiInstanceInvalidationService.c() - 1);
                    multiInstanceInvalidationService.c();
                }
            }
            return i10;
        }

        public void s0(i iVar, int i10) {
            kotlin.jvm.internal.j.g(iVar, "callback");
            RemoteCallbackList<i> a10 = this.f6753a.a();
            MultiInstanceInvalidationService multiInstanceInvalidationService = this.f6753a;
            synchronized (a10) {
                multiInstanceInvalidationService.a().unregister(iVar);
                String remove = multiInstanceInvalidationService.b().remove(Integer.valueOf(i10));
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"androidx/room/MultiInstanceInvalidationService$b", "Landroid/os/RemoteCallbackList;", "Landroidx/room/i;", "callback", "", "cookie", "", "a", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class b extends RemoteCallbackList<i> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MultiInstanceInvalidationService f6754a;

        b(MultiInstanceInvalidationService multiInstanceInvalidationService) {
            this.f6754a = multiInstanceInvalidationService;
        }

        /* renamed from: a */
        public void onCallbackDied(i iVar, Object obj) {
            kotlin.jvm.internal.j.g(iVar, "callback");
            kotlin.jvm.internal.j.g(obj, "cookie");
            this.f6754a.b().remove((Integer) obj);
        }
    }

    public final RemoteCallbackList<i> a() {
        return this.f6751c;
    }

    public final Map<Integer, String> b() {
        return this.f6750b;
    }

    public final int c() {
        return this.f6749a;
    }

    public final void d(int i10) {
        this.f6749a = i10;
    }

    public IBinder onBind(Intent intent) {
        kotlin.jvm.internal.j.g(intent, SDKConstants.PARAM_INTENT);
        return this.f6752d;
    }
}

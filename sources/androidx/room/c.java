package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;
import t1.i;
import t1.j;

@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0012B\u001f\u0012\u0006\u0010C\u001a\u00020%\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010F\u001a\u00020(¢\u0006\u0004\bG\u0010HJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J'\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010\"\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\"\u00102\u001a\u00020,8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\n\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00108\u001a\u00020%8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b3\u0010&\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010=\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0014\u00109\u001a\u0004\b3\u0010:\"\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010?R\u0014\u0010A\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0014\u0010B\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001d¨\u0006I"}, d2 = {"Landroidx/room/c;", "", "Lt1/j;", "delegateOpenHelper", "", "k", "V", "Lkotlin/Function1;", "Lt1/i;", "block", "g", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "j", "e", "d", "Ljava/lang/Runnable;", "onAutoClose", "l", "a", "Lt1/j;", "i", "()Lt1/j;", "m", "(Lt1/j;)V", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "handler", "c", "Ljava/lang/Runnable;", "getOnAutoCloseCallback$room_runtime_release", "()Ljava/lang/Runnable;", "setOnAutoCloseCallback$room_runtime_release", "(Ljava/lang/Runnable;)V", "onAutoCloseCallback", "Ljava/lang/Object;", "lock", "", "J", "autoCloseTimeoutInMs", "Ljava/util/concurrent/Executor;", "f", "Ljava/util/concurrent/Executor;", "executor", "", "I", "getRefCount$room_runtime_release", "()I", "setRefCount$room_runtime_release", "(I)V", "refCount", "h", "getLastDecrementRefCountTimeStamp$room_runtime_release", "()J", "setLastDecrementRefCountTimeStamp$room_runtime_release", "(J)V", "lastDecrementRefCountTimeStamp", "Lt1/i;", "()Lt1/i;", "setDelegateDatabase$room_runtime_release", "(Lt1/i;)V", "delegateDatabase", "", "Z", "manuallyClosed", "executeAutoCloser", "autoCloser", "autoCloseTimeoutAmount", "Ljava/util/concurrent/TimeUnit;", "autoCloseTimeUnit", "autoCloseExecutor", "<init>", "(JLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/Executor;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class c {

    /* renamed from: m  reason: collision with root package name */
    public static final a f6810m = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public j f6811a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f6812b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private Runnable f6813c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f6814d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private long f6815e;

    /* renamed from: f  reason: collision with root package name */
    private final Executor f6816f;

    /* renamed from: g  reason: collision with root package name */
    private int f6817g;

    /* renamed from: h  reason: collision with root package name */
    private long f6818h;

    /* renamed from: i  reason: collision with root package name */
    private i f6819i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f6820j;

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f6821k;

    /* renamed from: l  reason: collision with root package name */
    private final Runnable f6822l;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Landroidx/room/c$a;", "", "", "autoCloseBug", "Ljava/lang/String;", "<init>", "()V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(long j10, TimeUnit timeUnit, Executor executor) {
        kotlin.jvm.internal.j.g(timeUnit, "autoCloseTimeUnit");
        kotlin.jvm.internal.j.g(executor, "autoCloseExecutor");
        this.f6815e = timeUnit.toMillis(j10);
        this.f6816f = executor;
        this.f6818h = SystemClock.uptimeMillis();
        this.f6821k = new a(this);
        this.f6822l = new b(this);
    }

    /* access modifiers changed from: private */
    public static final void c(c cVar) {
        Unit unit;
        kotlin.jvm.internal.j.g(cVar, "this$0");
        synchronized (cVar.f6814d) {
            if (SystemClock.uptimeMillis() - cVar.f6818h >= cVar.f6815e) {
                if (cVar.f6817g == 0) {
                    Runnable runnable = cVar.f6813c;
                    if (runnable != null) {
                        runnable.run();
                        unit = Unit.f32013a;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        i iVar = cVar.f6819i;
                        if (iVar != null && iVar.isOpen()) {
                            iVar.close();
                        }
                        cVar.f6819i = null;
                        Unit unit2 = Unit.f32013a;
                        return;
                    }
                    throw new IllegalStateException("onAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568".toString());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void f(c cVar) {
        kotlin.jvm.internal.j.g(cVar, "this$0");
        cVar.f6816f.execute(cVar.f6822l);
    }

    public final void d() throws IOException {
        synchronized (this.f6814d) {
            this.f6820j = true;
            i iVar = this.f6819i;
            if (iVar != null) {
                iVar.close();
            }
            this.f6819i = null;
            Unit unit = Unit.f32013a;
        }
    }

    public final void e() {
        boolean z10;
        synchronized (this.f6814d) {
            int i10 = this.f6817g;
            if (i10 > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                int i11 = i10 - 1;
                this.f6817g = i11;
                if (i11 == 0) {
                    if (this.f6819i != null) {
                        this.f6812b.postDelayed(this.f6821k, this.f6815e);
                    } else {
                        return;
                    }
                }
                Unit unit = Unit.f32013a;
                return;
            }
            throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement".toString());
        }
    }

    public final <V> V g(Function1<? super i, ? extends V> function1) {
        kotlin.jvm.internal.j.g(function1, BlockContactsIQ.ELEMENT);
        try {
            return function1.invoke(j());
        } finally {
            e();
        }
    }

    public final i h() {
        return this.f6819i;
    }

    public final j i() {
        j jVar = this.f6811a;
        if (jVar != null) {
            return jVar;
        }
        kotlin.jvm.internal.j.y("delegateOpenHelper");
        return null;
    }

    public final i j() {
        synchronized (this.f6814d) {
            this.f6812b.removeCallbacks(this.f6821k);
            this.f6817g++;
            if (!this.f6820j) {
                i iVar = this.f6819i;
                if (iVar != null && iVar.isOpen()) {
                    return iVar;
                }
                i n12 = i().n1();
                this.f6819i = n12;
                return n12;
            }
            throw new IllegalStateException("Attempting to open already closed database.".toString());
        }
    }

    public final void k(j jVar) {
        kotlin.jvm.internal.j.g(jVar, "delegateOpenHelper");
        m(jVar);
    }

    public final void l(Runnable runnable) {
        kotlin.jvm.internal.j.g(runnable, "onAutoClose");
        this.f6813c = runnable;
    }

    public final void m(j jVar) {
        kotlin.jvm.internal.j.g(jVar, "<set-?>");
        this.f6811a = jVar;
    }
}

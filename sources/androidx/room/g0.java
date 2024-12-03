package androidx.room;

import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import net.bytebuddy.implementation.MethodDelegation;
import t1.m;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0017\u001a\u00020\u0001\u0012\u0006\u0010\u001a\u001a\u00020\u0011\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b'\u0010(J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\t\u0010\b\u001a\u00020\u0006H\u0001J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0013H\u0016R\u0014\u0010\u0017\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040#8\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Landroidx/room/g0;", "Lt1/m;", "", "bindIndex", "", "value", "", "f", "close", "H", "", "K0", "index", "B1", "f1", "", "K", "", "P0", "", "l1", "a", "Lt1/m;", "delegate", "b", "Ljava/lang/String;", "sqlStatement", "Ljava/util/concurrent/Executor;", "c", "Ljava/util/concurrent/Executor;", "queryCallbackExecutor", "Landroidx/room/RoomDatabase$f;", "d", "Landroidx/room/RoomDatabase$f;", "queryCallback", "", "e", "Ljava/util/List;", "bindArgsCache", "<init>", "(Lt1/m;Ljava/lang/String;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$f;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class g0 implements m {

    /* renamed from: a  reason: collision with root package name */
    private final m f6850a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6851b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f6852c;

    /* renamed from: d  reason: collision with root package name */
    private final RoomDatabase.f f6853d;

    /* renamed from: e  reason: collision with root package name */
    private final List<Object> f6854e = new ArrayList();

    public g0(m mVar, String str, Executor executor, RoomDatabase.f fVar) {
        j.g(mVar, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        j.g(str, "sqlStatement");
        j.g(executor, "queryCallbackExecutor");
        j.g(fVar, "queryCallback");
        this.f6850a = mVar;
        this.f6851b = str;
        this.f6852c = executor;
        this.f6853d = fVar;
    }

    /* access modifiers changed from: private */
    public static final void c(g0 g0Var) {
        j.g(g0Var, "this$0");
        g0Var.f6853d.a(g0Var.f6851b, g0Var.f6854e);
    }

    /* access modifiers changed from: private */
    public static final void e(g0 g0Var) {
        j.g(g0Var, "this$0");
        g0Var.f6853d.a(g0Var.f6851b, g0Var.f6854e);
    }

    private final void f(int i10, Object obj) {
        int i11 = i10 - 1;
        if (i11 >= this.f6854e.size()) {
            int size = (i11 - this.f6854e.size()) + 1;
            for (int i12 = 0; i12 < size; i12++) {
                this.f6854e.add((Object) null);
            }
        }
        this.f6854e.set(i11, obj);
    }

    public void B1(int i10) {
        Object[] array2 = this.f6854e.toArray(new Object[0]);
        j.e(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        f(i10, Arrays.copyOf(array2, array2.length));
        this.f6850a.B1(i10);
    }

    public int H() {
        this.f6852c.execute(new e0(this));
        return this.f6850a.H();
    }

    public void K(int i10, double d10) {
        f(i10, Double.valueOf(d10));
        this.f6850a.K(i10, d10);
    }

    public long K0() {
        this.f6852c.execute(new f0(this));
        return this.f6850a.K0();
    }

    public void P0(int i10, String str) {
        j.g(str, "value");
        f(i10, str);
        this.f6850a.P0(i10, str);
    }

    public void close() {
        this.f6850a.close();
    }

    public void f1(int i10, long j10) {
        f(i10, Long.valueOf(j10));
        this.f6850a.f1(i10, j10);
    }

    public void l1(int i10, byte[] bArr) {
        j.g(bArr, "value");
        f(i10, bArr);
        this.f6850a.l1(i10, bArr);
    }
}

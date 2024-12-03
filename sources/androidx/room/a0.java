package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import net.bytebuddy.implementation.MethodDelegation;
import t1.i;
import t1.l;
import t1.m;

@Metadata(bv = {}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010'\u001a\u00020\u0001\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010/\u001a\u00020,¢\u0006\u0004\b<\u0010=J\t\u0010\u0003\u001a\u00020\u0002H\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u0001JF\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u000f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001cH\u0016J\u001a\u0010 \u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J)\u0010#\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0010\u0010\"\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000e0\rH\u0016¢\u0006\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R(\u00104\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000601\u0018\u0001008VX\u0005¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00105\u001a\u00020\u00048\u0016X\u0005¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00108\u001a\u00020\u00048WX\u0005¢\u0006\u0006\u001a\u0004\b7\u00106R\u0016\u0010;\u001a\u0004\u0018\u00010\u00068\u0016X\u0005¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006>"}, d2 = {"Landroidx/room/a0;", "Lt1/i;", "", "close", "", "E1", "", "table", "", "conflictAlgorithm", "Landroid/content/ContentValues;", "values", "whereClause", "", "", "whereArgs", "k1", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "sql", "Lt1/m;", "T0", "beginTransaction", "b0", "endTransaction", "setTransactionSuccessful", "query", "Landroid/database/Cursor;", "q1", "Lt1/l;", "Z0", "Landroid/os/CancellationSignal;", "cancellationSignal", "t1", "D", "bindArgs", "a0", "(Ljava/lang/String;[Ljava/lang/Object;)V", "a", "Lt1/i;", "delegate", "Ljava/util/concurrent/Executor;", "b", "Ljava/util/concurrent/Executor;", "queryCallbackExecutor", "Landroidx/room/RoomDatabase$f;", "c", "Landroidx/room/RoomDatabase$f;", "queryCallback", "", "Landroid/util/Pair;", "A", "()Ljava/util/List;", "attachedDbs", "isOpen", "()Z", "O1", "isWriteAheadLoggingEnabled", "getPath", "()Ljava/lang/String;", "path", "<init>", "(Lt1/i;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$f;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class a0 implements i {

    /* renamed from: a  reason: collision with root package name */
    private final i f6803a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f6804b;

    /* renamed from: c  reason: collision with root package name */
    private final RoomDatabase.f f6805c;

    public a0(i iVar, Executor executor, RoomDatabase.f fVar) {
        j.g(iVar, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        j.g(executor, "queryCallbackExecutor");
        j.g(fVar, "queryCallback");
        this.f6803a = iVar;
        this.f6804b = executor;
        this.f6805c = fVar;
    }

    /* access modifiers changed from: private */
    public static final void C(a0 a0Var, l lVar, d0 d0Var) {
        j.g(a0Var, "this$0");
        j.g(lVar, "$query");
        j.g(d0Var, "$queryInterceptorProgram");
        a0Var.f6805c.a(lVar.a(), d0Var.a());
    }

    /* access modifiers changed from: private */
    public static final void E(a0 a0Var, l lVar, d0 d0Var) {
        j.g(a0Var, "this$0");
        j.g(lVar, "$query");
        j.g(d0Var, "$queryInterceptorProgram");
        a0Var.f6805c.a(lVar.a(), d0Var.a());
    }

    /* access modifiers changed from: private */
    public static final void F(a0 a0Var) {
        j.g(a0Var, "this$0");
        a0Var.f6805c.a("TRANSACTION SUCCESSFUL", q.j());
    }

    /* access modifiers changed from: private */
    public static final void m(a0 a0Var) {
        j.g(a0Var, "this$0");
        a0Var.f6805c.a("BEGIN EXCLUSIVE TRANSACTION", q.j());
    }

    /* access modifiers changed from: private */
    public static final void n(a0 a0Var) {
        j.g(a0Var, "this$0");
        a0Var.f6805c.a("BEGIN DEFERRED TRANSACTION", q.j());
    }

    /* access modifiers changed from: private */
    public static final void u(a0 a0Var) {
        j.g(a0Var, "this$0");
        a0Var.f6805c.a("END TRANSACTION", q.j());
    }

    /* access modifiers changed from: private */
    public static final void v(a0 a0Var, String str) {
        j.g(a0Var, "this$0");
        j.g(str, "$sql");
        a0Var.f6805c.a(str, q.j());
    }

    /* access modifiers changed from: private */
    public static final void x(a0 a0Var, String str, List list) {
        j.g(a0Var, "this$0");
        j.g(str, "$sql");
        j.g(list, "$inputArguments");
        a0Var.f6805c.a(str, list);
    }

    /* access modifiers changed from: private */
    public static final void y(a0 a0Var, String str) {
        j.g(a0Var, "this$0");
        j.g(str, "$query");
        a0Var.f6805c.a(str, q.j());
    }

    public List<Pair<String, String>> A() {
        return this.f6803a.A();
    }

    public void D(String str) {
        j.g(str, "sql");
        this.f6804b.execute(new z(this, str));
        this.f6803a.D(str);
    }

    public boolean E1() {
        return this.f6803a.E1();
    }

    public boolean O1() {
        return this.f6803a.O1();
    }

    public m T0(String str) {
        j.g(str, "sql");
        return new g0(this.f6803a.T0(str), str, this.f6804b, this.f6805c);
    }

    public Cursor Z0(l lVar) {
        j.g(lVar, "query");
        d0 d0Var = new d0();
        lVar.b(d0Var);
        this.f6804b.execute(new u(this, lVar, d0Var));
        return this.f6803a.Z0(lVar);
    }

    public void a0(String str, Object[] objArr) {
        j.g(str, "sql");
        j.g(objArr, "bindArgs");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(p.e(objArr));
        this.f6804b.execute(new y(this, str, arrayList));
        this.f6803a.a0(str, new List[]{arrayList});
    }

    public void b0() {
        this.f6804b.execute(new r(this));
        this.f6803a.b0();
    }

    public void beginTransaction() {
        this.f6804b.execute(new v(this));
        this.f6803a.beginTransaction();
    }

    public void close() {
        this.f6803a.close();
    }

    public void endTransaction() {
        this.f6804b.execute(new x(this));
        this.f6803a.endTransaction();
    }

    public String getPath() {
        return this.f6803a.getPath();
    }

    public boolean isOpen() {
        return this.f6803a.isOpen();
    }

    public int k1(String str, int i10, ContentValues contentValues, String str2, Object[] objArr) {
        j.g(str, "table");
        j.g(contentValues, "values");
        return this.f6803a.k1(str, i10, contentValues, str2, objArr);
    }

    public Cursor q1(String str) {
        j.g(str, "query");
        this.f6804b.execute(new w(this, str));
        return this.f6803a.q1(str);
    }

    public void setTransactionSuccessful() {
        this.f6804b.execute(new t(this));
        this.f6803a.setTransactionSuccessful();
    }

    public Cursor t1(l lVar, CancellationSignal cancellationSignal) {
        j.g(lVar, "query");
        d0 d0Var = new d0();
        lVar.b(d0Var);
        this.f6804b.execute(new s(this, lVar, d0Var));
        return this.f6803a.Z0(lVar);
    }
}

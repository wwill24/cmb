package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import net.bytebuddy.implementation.MethodDelegation;
import t1.k;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Landroidx/sqlite/db/framework/e;", "Lt1/k;", "", "index", "", "B1", "", "value", "f1", "", "K", "", "P0", "", "l1", "close", "Landroid/database/sqlite/SQLiteProgram;", "a", "Landroid/database/sqlite/SQLiteProgram;", "delegate", "<init>", "(Landroid/database/sqlite/SQLiteProgram;)V", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1})
public class e implements k {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteProgram f7039a;

    public e(SQLiteProgram sQLiteProgram) {
        j.g(sQLiteProgram, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.f7039a = sQLiteProgram;
    }

    public void B1(int i10) {
        this.f7039a.bindNull(i10);
    }

    public void K(int i10, double d10) {
        this.f7039a.bindDouble(i10, d10);
    }

    public void P0(int i10, String str) {
        j.g(str, "value");
        this.f7039a.bindString(i10, str);
    }

    public void close() {
        this.f7039a.close();
    }

    public void f1(int i10, long j10) {
        this.f7039a.bindLong(i10, j10);
    }

    public void l1(int i10, byte[] bArr) {
        j.g(bArr, "value");
        this.f7039a.bindBlob(i10, bArr);
    }
}

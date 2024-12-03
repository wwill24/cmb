package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteStatement;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import net.bytebuddy.implementation.MethodDelegation;
import t1.m;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Landroidx/sqlite/db/framework/f;", "Landroidx/sqlite/db/framework/e;", "Lt1/m;", "", "H", "", "K0", "Landroid/database/sqlite/SQLiteStatement;", "b", "Landroid/database/sqlite/SQLiteStatement;", "delegate", "<init>", "(Landroid/database/sqlite/SQLiteStatement;)V", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1})
public final class f extends e implements m {

    /* renamed from: b  reason: collision with root package name */
    private final SQLiteStatement f7040b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        j.g(sQLiteStatement, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.f7040b = sQLiteStatement;
    }

    public int H() {
        return this.f7040b.executeUpdateDelete();
    }

    public long K0() {
        return this.f7040b.executeInsert();
    }
}

package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import com.mparticle.kits.AppsFlyerKit;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.implementation.MethodDelegation;
import pk.o;
import t1.b;
import t1.i;
import t1.l;
import t1.m;

@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 92\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010*\u001a\u00020%¢\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0010H\u0016J\u001a\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0017JE\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u001d\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J)\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010!\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001c0\u001bH\u0016¢\u0006\u0004\b\"\u0010#J\b\u0010$\u001a\u00020\u0006H\u0016J\u000e\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%R\u0014\u0010*\u001a\u00020%8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u0010/\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u00101\u001a\u00020\u000b8WX\u0004¢\u0006\u0006\u001a\u0004\b0\u0010,R(\u00106\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000203\u0018\u0001028VX\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u0006:"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "Lt1/i;", "", "sql", "Lt1/m;", "T0", "", "beginTransaction", "b0", "endTransaction", "setTransactionSuccessful", "", "E1", "query", "Landroid/database/Cursor;", "q1", "Lt1/l;", "Z0", "Landroid/os/CancellationSignal;", "cancellationSignal", "t1", "table", "", "conflictAlgorithm", "Landroid/content/ContentValues;", "values", "whereClause", "", "", "whereArgs", "k1", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "D", "bindArgs", "a0", "(Ljava/lang/String;[Ljava/lang/Object;)V", "close", "Landroid/database/sqlite/SQLiteDatabase;", "sqLiteDatabase", "c", "a", "Landroid/database/sqlite/SQLiteDatabase;", "delegate", "isOpen", "()Z", "getPath", "()Ljava/lang/String;", "path", "O1", "isWriteAheadLoggingEnabled", "", "Landroid/util/Pair;", "A", "()Ljava/util/List;", "attachedDbs", "<init>", "(Landroid/database/sqlite/SQLiteDatabase;)V", "b", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1})
public final class FrameworkSQLiteDatabase implements i {

    /* renamed from: b  reason: collision with root package name */
    public static final a f7007b = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f7008c = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f7009d = new String[0];

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f7010a;

    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005¨\u0006\t"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase$a;", "", "", "", "CONFLICT_VALUES", "[Ljava/lang/String;", "EMPTY_STRING_ARRAY", "<init>", "()V", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        j.g(sQLiteDatabase, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        this.f7010a = sQLiteDatabase;
    }

    /* access modifiers changed from: private */
    public static final Cursor e(o oVar, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        j.g(oVar, "$tmp0");
        return (Cursor) oVar.g(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* access modifiers changed from: private */
    public static final Cursor f(l lVar, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        j.g(lVar, "$query");
        j.d(sQLiteQuery);
        lVar.b(new e(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    public List<Pair<String, String>> A() {
        return this.f7010a.getAttachedDbs();
    }

    public void D(String str) throws SQLException {
        j.g(str, "sql");
        this.f7010a.execSQL(str);
    }

    public boolean E1() {
        return this.f7010a.inTransaction();
    }

    public boolean O1() {
        return b.b(this.f7010a);
    }

    public m T0(String str) {
        j.g(str, "sql");
        SQLiteStatement compileStatement = this.f7010a.compileStatement(str);
        j.f(compileStatement, "delegate.compileStatement(sql)");
        return new f(compileStatement);
    }

    public Cursor Z0(l lVar) {
        j.g(lVar, "query");
        Cursor rawQueryWithFactory = this.f7010a.rawQueryWithFactory(new b(new FrameworkSQLiteDatabase$query$cursorFactory$1(lVar)), lVar.a(), f7009d, (String) null);
        j.f(rawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return rawQueryWithFactory;
    }

    public void a0(String str, Object[] objArr) throws SQLException {
        j.g(str, "sql");
        j.g(objArr, "bindArgs");
        this.f7010a.execSQL(str, objArr);
    }

    public void b0() {
        this.f7010a.beginTransactionNonExclusive();
    }

    public void beginTransaction() {
        this.f7010a.beginTransaction();
    }

    public final boolean c(SQLiteDatabase sQLiteDatabase) {
        j.g(sQLiteDatabase, "sqLiteDatabase");
        return j.b(this.f7010a, sQLiteDatabase);
    }

    public void close() throws IOException {
        this.f7010a.close();
    }

    public void endTransaction() {
        this.f7010a.endTransaction();
    }

    public String getPath() {
        return this.f7010a.getPath();
    }

    public boolean isOpen() {
        return this.f7010a.isOpen();
    }

    public int k1(String str, int i10, ContentValues contentValues, String str2, Object[] objArr) {
        boolean z10;
        int i11;
        String str3;
        j.g(str, "table");
        j.g(contentValues, "values");
        int i12 = 0;
        if (contentValues.size() != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int size = contentValues.size();
            if (objArr == null) {
                i11 = size;
            } else {
                i11 = objArr.length + size;
            }
            Object[] objArr2 = new Object[i11];
            StringBuilder sb2 = new StringBuilder();
            sb2.append("UPDATE ");
            sb2.append(f7008c[i10]);
            sb2.append(str);
            sb2.append(" SET ");
            for (String next : contentValues.keySet()) {
                if (i12 > 0) {
                    str3 = AppsFlyerKit.COMMA;
                } else {
                    str3 = "";
                }
                sb2.append(str3);
                sb2.append(next);
                objArr2[i12] = contentValues.get(next);
                sb2.append("=?");
                i12++;
            }
            if (objArr != null) {
                for (int i13 = size; i13 < i11; i13++) {
                    objArr2[i13] = objArr[i13 - size];
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sb2.append(" WHERE ");
                sb2.append(str2);
            }
            String sb3 = sb2.toString();
            j.f(sb3, "StringBuilder().apply(builderAction).toString()");
            m T0 = T0(sb3);
            t1.a.f17626c.b(T0, objArr2);
            return T0.H();
        }
        throw new IllegalArgumentException("Empty values".toString());
    }

    public Cursor q1(String str) {
        j.g(str, "query");
        return Z0(new t1.a(str));
    }

    public void setTransactionSuccessful() {
        this.f7010a.setTransactionSuccessful();
    }

    public Cursor t1(l lVar, CancellationSignal cancellationSignal) {
        j.g(lVar, "query");
        SQLiteDatabase sQLiteDatabase = this.f7010a;
        String a10 = lVar.a();
        String[] strArr = f7009d;
        j.d(cancellationSignal);
        return b.c(sQLiteDatabase, a10, strArr, (String) null, cancellationSignal, new a(lVar));
    }
}

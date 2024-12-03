package androidx.room;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import net.bytebuddy.implementation.MethodDelegation;
import t1.c;
import t1.e;
import t1.h;
import t1.i;
import t1.j;
import t1.l;
import t1.m;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u001e\u001f\bB\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0001J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u001a\u0010\u000b\u001a\u00020\u00018\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0000X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188WX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Landroidx/room/AutoClosingRoomOpenHelper;", "Lt1/j;", "Landroidx/room/f;", "", "enabled", "", "setWriteAheadLoggingEnabled", "close", "a", "Lt1/j;", "()Lt1/j;", "delegate", "Landroidx/room/c;", "b", "Landroidx/room/c;", "autoCloser", "Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;", "c", "Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;", "autoClosingDb", "", "getDatabaseName", "()Ljava/lang/String;", "databaseName", "Lt1/i;", "n1", "()Lt1/i;", "writableDatabase", "<init>", "(Lt1/j;Landroidx/room/c;)V", "AutoClosingSupportSQLiteDatabase", "AutoClosingSupportSqliteStatement", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public final class AutoClosingRoomOpenHelper implements j, f {

    /* renamed from: a  reason: collision with root package name */
    private final j f6730a;

    /* renamed from: b  reason: collision with root package name */
    public final c f6731b;

    /* renamed from: c  reason: collision with root package name */
    private final AutoClosingSupportSQLiteDatabase f6732c;

    @Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010(\u001a\u00020&¢\u0006\u0004\b5\u00106J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0011H\u0016J\u001a\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0017JE\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u001e\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J)\u0010#\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\u0010\"\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001d0\u001cH\u0016¢\u0006\u0004\b#\u0010$J\b\u0010%\u001a\u00020\u0002H\u0016R\u0014\u0010(\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010'R\u0014\u0010)\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0016\u0010-\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020\f8WX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*R(\u00104\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000401\u0018\u0001008VX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00067"}, d2 = {"Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;", "Lt1/i;", "", "a", "", "sql", "Lt1/m;", "T0", "beginTransaction", "b0", "endTransaction", "setTransactionSuccessful", "", "E1", "query", "Landroid/database/Cursor;", "q1", "Lt1/l;", "Z0", "Landroid/os/CancellationSignal;", "cancellationSignal", "t1", "table", "", "conflictAlgorithm", "Landroid/content/ContentValues;", "values", "whereClause", "", "", "whereArgs", "k1", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "D", "bindArgs", "a0", "(Ljava/lang/String;[Ljava/lang/Object;)V", "close", "Landroidx/room/c;", "Landroidx/room/c;", "autoCloser", "isOpen", "()Z", "getPath", "()Ljava/lang/String;", "path", "O1", "isWriteAheadLoggingEnabled", "", "Landroid/util/Pair;", "A", "()Ljava/util/List;", "attachedDbs", "<init>", "(Landroidx/room/c;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class AutoClosingSupportSQLiteDatabase implements i {

        /* renamed from: a  reason: collision with root package name */
        private final c f6733a;

        public AutoClosingSupportSQLiteDatabase(c cVar) {
            kotlin.jvm.internal.j.g(cVar, "autoCloser");
            this.f6733a = cVar;
        }

        public List<Pair<String, String>> A() {
            return (List) this.f6733a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1.f6734a);
        }

        public void D(String str) throws SQLException {
            kotlin.jvm.internal.j.g(str, "sql");
            this.f6733a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$1(str));
        }

        public boolean E1() {
            if (this.f6733a.h() == null) {
                return false;
            }
            return ((Boolean) this.f6733a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1.f6735a)).booleanValue();
        }

        public boolean O1() {
            return ((Boolean) this.f6733a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isWriteAheadLoggingEnabled$1.f6736a)).booleanValue();
        }

        public m T0(String str) {
            kotlin.jvm.internal.j.g(str, "sql");
            return new AutoClosingSupportSqliteStatement(str, this.f6733a);
        }

        public Cursor Z0(l lVar) {
            kotlin.jvm.internal.j.g(lVar, "query");
            try {
                return new a(this.f6733a.j().Z0(lVar), this.f6733a);
            } catch (Throwable th2) {
                this.f6733a.e();
                throw th2;
            }
        }

        public final void a() {
            this.f6733a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pokeOpen$1.f6738a);
        }

        public void a0(String str, Object[] objArr) throws SQLException {
            kotlin.jvm.internal.j.g(str, "sql");
            kotlin.jvm.internal.j.g(objArr, "bindArgs");
            this.f6733a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$2(str, objArr));
        }

        public void b0() {
            try {
                this.f6733a.j().b0();
            } catch (Throwable th2) {
                this.f6733a.e();
                throw th2;
            }
        }

        public void beginTransaction() {
            try {
                this.f6733a.j().beginTransaction();
            } catch (Throwable th2) {
                this.f6733a.e();
                throw th2;
            }
        }

        public void close() throws IOException {
            this.f6733a.d();
        }

        public void endTransaction() {
            if (this.f6733a.h() != null) {
                try {
                    i h10 = this.f6733a.h();
                    kotlin.jvm.internal.j.d(h10);
                    h10.endTransaction();
                } finally {
                    this.f6733a.e();
                }
            } else {
                throw new IllegalStateException("End transaction called but delegateDb is null".toString());
            }
        }

        public String getPath() {
            return (String) this.f6733a.g(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1.f6737a);
        }

        public boolean isOpen() {
            i h10 = this.f6733a.h();
            if (h10 == null) {
                return false;
            }
            return h10.isOpen();
        }

        public int k1(String str, int i10, ContentValues contentValues, String str2, Object[] objArr) {
            kotlin.jvm.internal.j.g(str, "table");
            kotlin.jvm.internal.j.g(contentValues, "values");
            return ((Number) this.f6733a.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$update$1(str, i10, contentValues, str2, objArr))).intValue();
        }

        public Cursor q1(String str) {
            kotlin.jvm.internal.j.g(str, "query");
            try {
                return new a(this.f6733a.j().q1(str), this.f6733a);
            } catch (Throwable th2) {
                this.f6733a.e();
                throw th2;
            }
        }

        public void setTransactionSuccessful() {
            Unit unit;
            i h10 = this.f6733a.h();
            if (h10 != null) {
                h10.setTransactionSuccessful();
                unit = Unit.f32013a;
            } else {
                unit = null;
            }
            if (unit == null) {
                throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null".toString());
            }
        }

        public Cursor t1(l lVar, CancellationSignal cancellationSignal) {
            kotlin.jvm.internal.j.g(lVar, "query");
            try {
                return new a(this.f6733a.j().t1(lVar, cancellationSignal), this.f6733a);
            } catch (Throwable th2) {
                this.f6733a.e();
                throw th2;
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u0018\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b'\u0010(J)\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0002J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0016H\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0018H\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u001aH\u0016R\u0014\u0010\u001e\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R(\u0010&\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f0#j\n\u0012\u0006\u0012\u0004\u0018\u00010\f`$8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010%¨\u0006)"}, d2 = {"Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement;", "Lt1/m;", "T", "Lkotlin/Function1;", "block", "e", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "supportSQLiteStatement", "", "c", "", "bindIndex", "", "value", "f", "close", "H", "", "K0", "index", "B1", "f1", "", "K", "", "P0", "", "l1", "a", "Ljava/lang/String;", "sql", "Landroidx/room/c;", "b", "Landroidx/room/c;", "autoCloser", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "binds", "<init>", "(Ljava/lang/String;Landroidx/room/c;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    private static final class AutoClosingSupportSqliteStatement implements m {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f6739a;

        /* renamed from: b  reason: collision with root package name */
        private final c f6740b;

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList<Object> f6741c = new ArrayList<>();

        public AutoClosingSupportSqliteStatement(String str, c cVar) {
            kotlin.jvm.internal.j.g(str, "sql");
            kotlin.jvm.internal.j.g(cVar, "autoCloser");
            this.f6739a = str;
            this.f6740b = cVar;
        }

        /* access modifiers changed from: private */
        public final void c(m mVar) {
            Iterator<T> it = this.f6741c.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                it.next();
                int i11 = i10 + 1;
                if (i10 < 0) {
                    q.s();
                }
                Object obj = this.f6741c.get(i10);
                if (obj == null) {
                    mVar.B1(i11);
                } else if (obj instanceof Long) {
                    mVar.f1(i11, ((Number) obj).longValue());
                } else if (obj instanceof Double) {
                    mVar.K(i11, ((Number) obj).doubleValue());
                } else if (obj instanceof String) {
                    mVar.P0(i11, (String) obj);
                } else if (obj instanceof byte[]) {
                    mVar.l1(i11, (byte[]) obj);
                }
                i10 = i11;
            }
        }

        private final <T> T e(Function1<? super m, ? extends T> function1) {
            return this.f6740b.g(new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1(this, function1));
        }

        private final void f(int i10, Object obj) {
            int size;
            int i11 = i10 - 1;
            if (i11 >= this.f6741c.size() && (size = this.f6741c.size()) <= i11) {
                while (true) {
                    this.f6741c.add((Object) null);
                    if (size == i11) {
                        break;
                    }
                    size++;
                }
            }
            this.f6741c.set(i11, obj);
        }

        public void B1(int i10) {
            f(i10, (Object) null);
        }

        public int H() {
            return ((Number) e(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1.f6743a)).intValue();
        }

        public void K(int i10, double d10) {
            f(i10, Double.valueOf(d10));
        }

        public long K0() {
            return ((Number) e(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1.f6742a)).longValue();
        }

        public void P0(int i10, String str) {
            kotlin.jvm.internal.j.g(str, "value");
            f(i10, str);
        }

        public void close() throws IOException {
        }

        public void f1(int i10, long j10) {
            f(i10, Long.valueOf(j10));
        }

        public void l1(int i10, byte[] bArr) {
            kotlin.jvm.internal.j.g(bArr, "value");
            f(i10, bArr);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010G\u001a\u00020\u0001\u0012\u0006\u0010K\u001a\u00020H¢\u0006\u0004\bL\u0010MJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\u0001J\t\u0010\t\u001a\u00020\u0007H\u0001J\u0019\u0010\u000b\u001a\n \u0005*\u0004\u0018\u00010\n0\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001J\t\u0010\f\u001a\u00020\u0002H\u0001J\u0019\u0010\u000e\u001a\u00020\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\r0\rH\u0001J\u0019\u0010\u000f\u001a\u00020\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\r0\rH\u0001J\u0019\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\r0\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001J6\u0010\u0012\u001a(\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\r0\r \u0005*\u0014\u0012\u000e\b\u0001\u0012\n \u0005*\u0004\u0018\u00010\r0\r\u0018\u00010\u00110\u0011H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0002H\u0001J\u0011\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002H\u0001J\u0011\u0010\u0018\u001a\n \u0005*\u0004\u0018\u00010\u00170\u0017H\u0001J\u0011\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002H\u0001J\u0011\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0001J\u0011\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001J\t\u0010\u001e\u001a\u00020\u0002H\u0001J\u0011\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001J\u0019\u0010!\u001a\n \u0005*\u0004\u0018\u00010\r0\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001J\u0011\u0010\"\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0001J\t\u0010$\u001a\u00020#H\u0001J\t\u0010%\u001a\u00020#H\u0001J\t\u0010&\u001a\u00020#H\u0001J\t\u0010'\u001a\u00020#H\u0001J\t\u0010(\u001a\u00020#H\u0001J\t\u0010)\u001a\u00020#H\u0001J\u0011\u0010*\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001J\u0011\u0010+\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001J\t\u0010,\u001a\u00020#H\u0001J\t\u0010-\u001a\u00020#H\u0001J\t\u0010.\u001a\u00020#H\u0001J\u0011\u0010/\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001J\t\u00100\u001a\u00020#H\u0001J\u0019\u00102\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010101H\u0001J\u0019\u00104\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010303H\u0001J\t\u00105\u001a\u00020#H\u0001J!\u00106\u001a\n \u0005*\u0004\u0018\u00010\u00170\u00172\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00170\u0017H\u0001J)\u00109\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u000107072\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010808H\u0001J\u0019\u0010:\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010101H\u0001J\u0019\u0010;\u001a\u00020\u00072\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010303H\u0001J\b\u0010<\u001a\u00020\u0007H\u0016J\u001e\u0010@\u001a\u00020\u00072\u0006\u0010=\u001a\u0002072\f\u0010?\u001a\b\u0012\u0004\u0012\u0002080>H\u0017J\b\u0010A\u001a\u000208H\u0017J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u0002080>H\u0017J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u0017H\u0017R\u0014\u0010G\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006N"}, d2 = {"Landroidx/room/AutoClosingRoomOpenHelper$a;", "Landroid/database/Cursor;", "", "p0", "Landroid/database/CharArrayBuffer;", "kotlin.jvm.PlatformType", "p1", "", "copyStringToBuffer", "deactivate", "", "getBlob", "getColumnCount", "", "getColumnIndex", "getColumnIndexOrThrow", "getColumnName", "", "getColumnNames", "()[Ljava/lang/String;", "getCount", "", "getDouble", "Landroid/os/Bundle;", "getExtras", "", "getFloat", "getInt", "", "getLong", "getPosition", "", "getShort", "getString", "getType", "", "getWantsAllOnMoveCalls", "isAfterLast", "isBeforeFirst", "isClosed", "isFirst", "isLast", "isNull", "move", "moveToFirst", "moveToLast", "moveToNext", "moveToPosition", "moveToPrevious", "Landroid/database/ContentObserver;", "registerContentObserver", "Landroid/database/DataSetObserver;", "registerDataSetObserver", "requery", "respond", "Landroid/content/ContentResolver;", "Landroid/net/Uri;", "setNotificationUri", "unregisterContentObserver", "unregisterDataSetObserver", "close", "cr", "", "uris", "setNotificationUris", "getNotificationUri", "getNotificationUris", "extras", "setExtras", "a", "Landroid/database/Cursor;", "delegate", "Landroidx/room/c;", "b", "Landroidx/room/c;", "autoCloser", "<init>", "(Landroid/database/Cursor;Landroidx/room/c;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    private static final class a implements Cursor {

        /* renamed from: a  reason: collision with root package name */
        private final Cursor f6744a;

        /* renamed from: b  reason: collision with root package name */
        private final c f6745b;

        public a(Cursor cursor, c cVar) {
            kotlin.jvm.internal.j.g(cursor, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
            kotlin.jvm.internal.j.g(cVar, "autoCloser");
            this.f6744a = cursor;
            this.f6745b = cVar;
        }

        public void close() {
            this.f6744a.close();
            this.f6745b.e();
        }

        public void copyStringToBuffer(int i10, CharArrayBuffer charArrayBuffer) {
            this.f6744a.copyStringToBuffer(i10, charArrayBuffer);
        }

        public void deactivate() {
            this.f6744a.deactivate();
        }

        public byte[] getBlob(int i10) {
            return this.f6744a.getBlob(i10);
        }

        public int getColumnCount() {
            return this.f6744a.getColumnCount();
        }

        public int getColumnIndex(String str) {
            return this.f6744a.getColumnIndex(str);
        }

        public int getColumnIndexOrThrow(String str) {
            return this.f6744a.getColumnIndexOrThrow(str);
        }

        public String getColumnName(int i10) {
            return this.f6744a.getColumnName(i10);
        }

        public String[] getColumnNames() {
            return this.f6744a.getColumnNames();
        }

        public int getCount() {
            return this.f6744a.getCount();
        }

        public double getDouble(int i10) {
            return this.f6744a.getDouble(i10);
        }

        public Bundle getExtras() {
            return this.f6744a.getExtras();
        }

        public float getFloat(int i10) {
            return this.f6744a.getFloat(i10);
        }

        public int getInt(int i10) {
            return this.f6744a.getInt(i10);
        }

        public long getLong(int i10) {
            return this.f6744a.getLong(i10);
        }

        public Uri getNotificationUri() {
            return c.a(this.f6744a);
        }

        public List<Uri> getNotificationUris() {
            return h.a(this.f6744a);
        }

        public int getPosition() {
            return this.f6744a.getPosition();
        }

        public short getShort(int i10) {
            return this.f6744a.getShort(i10);
        }

        public String getString(int i10) {
            return this.f6744a.getString(i10);
        }

        public int getType(int i10) {
            return this.f6744a.getType(i10);
        }

        public boolean getWantsAllOnMoveCalls() {
            return this.f6744a.getWantsAllOnMoveCalls();
        }

        public boolean isAfterLast() {
            return this.f6744a.isAfterLast();
        }

        public boolean isBeforeFirst() {
            return this.f6744a.isBeforeFirst();
        }

        public boolean isClosed() {
            return this.f6744a.isClosed();
        }

        public boolean isFirst() {
            return this.f6744a.isFirst();
        }

        public boolean isLast() {
            return this.f6744a.isLast();
        }

        public boolean isNull(int i10) {
            return this.f6744a.isNull(i10);
        }

        public boolean move(int i10) {
            return this.f6744a.move(i10);
        }

        public boolean moveToFirst() {
            return this.f6744a.moveToFirst();
        }

        public boolean moveToLast() {
            return this.f6744a.moveToLast();
        }

        public boolean moveToNext() {
            return this.f6744a.moveToNext();
        }

        public boolean moveToPosition(int i10) {
            return this.f6744a.moveToPosition(i10);
        }

        public boolean moveToPrevious() {
            return this.f6744a.moveToPrevious();
        }

        public void registerContentObserver(ContentObserver contentObserver) {
            this.f6744a.registerContentObserver(contentObserver);
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f6744a.registerDataSetObserver(dataSetObserver);
        }

        public boolean requery() {
            return this.f6744a.requery();
        }

        public Bundle respond(Bundle bundle) {
            return this.f6744a.respond(bundle);
        }

        public void setExtras(Bundle bundle) {
            kotlin.jvm.internal.j.g(bundle, "extras");
            e.a(this.f6744a, bundle);
        }

        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.f6744a.setNotificationUri(contentResolver, uri);
        }

        public void setNotificationUris(ContentResolver contentResolver, List<? extends Uri> list) {
            kotlin.jvm.internal.j.g(contentResolver, "cr");
            kotlin.jvm.internal.j.g(list, "uris");
            h.b(this.f6744a, contentResolver, list);
        }

        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.f6744a.unregisterContentObserver(contentObserver);
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f6744a.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public AutoClosingRoomOpenHelper(j jVar, c cVar) {
        kotlin.jvm.internal.j.g(jVar, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        kotlin.jvm.internal.j.g(cVar, "autoCloser");
        this.f6730a = jVar;
        this.f6731b = cVar;
        cVar.k(a());
        this.f6732c = new AutoClosingSupportSQLiteDatabase(cVar);
    }

    public j a() {
        return this.f6730a;
    }

    public void close() {
        this.f6732c.close();
    }

    public String getDatabaseName() {
        return this.f6730a.getDatabaseName();
    }

    public i n1() {
        this.f6732c.a();
        return this.f6732c;
    }

    public void setWriteAheadLoggingEnabled(boolean z10) {
        this.f6730a.setWriteAheadLoggingEnabled(z10);
    }
}

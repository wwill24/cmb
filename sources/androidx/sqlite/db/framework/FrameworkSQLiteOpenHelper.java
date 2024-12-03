package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.appevents.UserDataStore;
import com.mparticle.identity.IdentityHttpResponse;
import gk.f;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import t1.i;
import t1.j;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0003\b\f-B7\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u001b\u0010#\u001a\u00020\u00198BX\u0002¢\u0006\f\u001a\u0004\b\u001f\u0010 *\u0004\b!\u0010\"R\u0016\u0010&\u001a\u0004\u0018\u00010\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006."}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper;", "Lt1/j;", "", "enabled", "", "setWriteAheadLoggingEnabled", "close", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "", "b", "Ljava/lang/String;", "name", "Lt1/j$a;", "c", "Lt1/j$a;", "callback", "d", "Z", "useNoBackupDirectory", "e", "allowDataLossOnRecovery", "Lgk/f;", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "f", "Lgk/f;", "lazyDelegate", "g", "writeAheadLoggingEnabled", "h", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "getDelegate$delegate", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper;)Ljava/lang/Object;", "delegate", "getDatabaseName", "()Ljava/lang/String;", "databaseName", "Lt1/i;", "n1", "()Lt1/i;", "writableDatabase", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lt1/j$a;ZZ)V", "OpenHelper", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1})
public final class FrameworkSQLiteOpenHelper implements j {

    /* renamed from: h  reason: collision with root package name */
    public static final a f7011h = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f7012a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f7013b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final j.a f7014c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final boolean f7015d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final boolean f7016e;

    /* renamed from: f  reason: collision with root package name */
    private final f<OpenHelper> f7017f = b.b(new FrameworkSQLiteOpenHelper$lazyDelegate$1(this));
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f7018g;

    @Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u0000 62\u00020\u0001:\u000378\u0018B1\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\b\u00103\u001a\u0004\u0018\u000102\u0012\u0006\u0010\"\u001a\u00020\u001d\u0012\u0006\u0010'\u001a\u00020#\u0012\u0006\u0010,\u001a\u00020\u0002¢\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0004H\u0016J \u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J \u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016R\u0017\u0010\u001c\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010'\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010,\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010)R\u0014\u00100\u001a\u00020.8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010/R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010)¨\u00069"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "", "writable", "Landroid/database/sqlite/SQLiteDatabase;", "g", "f", "Lt1/i;", "c", "sqLiteDatabase", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "e", "", "onCreate", "", "oldVersion", "newVersion", "onUpgrade", "db", "onConfigure", "onDowngrade", "onOpen", "close", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$b;", "b", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$b;", "getDbRef", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$b;", "dbRef", "Lt1/j$a;", "Lt1/j$a;", "getCallback", "()Lt1/j$a;", "callback", "d", "Z", "getAllowDataLossOnRecovery", "()Z", "allowDataLossOnRecovery", "migrated", "Lu1/a;", "Lu1/a;", "lock", "opened", "", "name", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$b;Lt1/j$a;Z)V", "h", "CallbackException", "CallbackName", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1})
    private static final class OpenHelper extends SQLiteOpenHelper {

        /* renamed from: h  reason: collision with root package name */
        public static final a f7019h = new a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        private final Context f7020a;

        /* renamed from: b  reason: collision with root package name */
        private final b f7021b;

        /* renamed from: c  reason: collision with root package name */
        private final j.a f7022c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f7023d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f7024e;

        /* renamed from: f  reason: collision with root package name */
        private final u1.a f7025f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f7026g;

        @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "callbackName", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "a", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "", "cause", "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "<init>", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;Ljava/lang/Throwable;)V", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1})
        private static final class CallbackException extends RuntimeException {
            private final CallbackName callbackName;
            private final Throwable cause;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CallbackException(CallbackName callbackName2, Throwable th2) {
                super(th2);
                kotlin.jvm.internal.j.g(callbackName2, "callbackName");
                kotlin.jvm.internal.j.g(th2, "cause");
                this.callbackName = callbackName2;
                this.cause = th2;
            }

            public final CallbackName a() {
                return this.callbackName;
            }

            public Throwable getCause() {
                return this.cause;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "", "(Ljava/lang/String;I)V", "ON_CONFIGURE", "ON_CREATE", "ON_UPGRADE", "ON_DOWNGRADE", "ON_OPEN", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public enum CallbackName {
            ON_CONFIGURE,
            ON_CREATE,
            ON_UPGRADE,
            ON_DOWNGRADE,
            ON_OPEN
        }

        @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$a;", "", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$b;", "refHolder", "Landroid/database/sqlite/SQLiteDatabase;", "sqLiteDatabase", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "a", "<init>", "()V", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final FrameworkSQLiteDatabase a(b bVar, SQLiteDatabase sQLiteDatabase) {
                kotlin.jvm.internal.j.g(bVar, "refHolder");
                kotlin.jvm.internal.j.g(sQLiteDatabase, "sqLiteDatabase");
                FrameworkSQLiteDatabase a10 = bVar.a();
                if (a10 != null && a10.c(sQLiteDatabase)) {
                    return a10;
                }
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = new FrameworkSQLiteDatabase(sQLiteDatabase);
                bVar.b(frameworkSQLiteDatabase);
                return frameworkSQLiteDatabase;
            }
        }

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class b {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f7033a;

            /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName[] r0 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_CONFIGURE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_UPGRADE     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_DOWNGRADE     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_OPEN     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    f7033a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.b.<clinit>():void");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OpenHelper(Context context, String str, b bVar, j.a aVar, boolean z10) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, aVar.f17635a, new c(aVar, bVar));
            kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
            kotlin.jvm.internal.j.g(bVar, "dbRef");
            kotlin.jvm.internal.j.g(aVar, "callback");
            this.f7020a = context;
            this.f7021b = bVar;
            this.f7022c = aVar;
            this.f7023d = z10;
            if (str == null) {
                str = UUID.randomUUID().toString();
                kotlin.jvm.internal.j.f(str, "randomUUID().toString()");
            }
            this.f7025f = new u1.a(str, context.getCacheDir(), false);
        }

        /* access modifiers changed from: private */
        public static final void b(j.a aVar, b bVar, SQLiteDatabase sQLiteDatabase) {
            kotlin.jvm.internal.j.g(aVar, "$callback");
            kotlin.jvm.internal.j.g(bVar, "$dbRef");
            a aVar2 = f7019h;
            kotlin.jvm.internal.j.f(sQLiteDatabase, "dbObj");
            aVar.c(aVar2.a(bVar, sQLiteDatabase));
        }

        private final SQLiteDatabase f(boolean z10) {
            if (z10) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                kotlin.jvm.internal.j.f(writableDatabase, "{\n                super.…eDatabase()\n            }");
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            kotlin.jvm.internal.j.f(readableDatabase, "{\n                super.…eDatabase()\n            }");
            return readableDatabase;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:12|11|13|14|15|16|17) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final android.database.sqlite.SQLiteDatabase g(boolean r5) {
            /*
                r4 = this;
                java.lang.String r0 = r4.getDatabaseName()
                boolean r1 = r4.f7026g
                if (r0 == 0) goto L_0x002c
                if (r1 != 0) goto L_0x002c
                android.content.Context r1 = r4.f7020a
                java.io.File r1 = r1.getDatabasePath(r0)
                java.io.File r1 = r1.getParentFile()
                if (r1 == 0) goto L_0x002c
                r1.mkdirs()
                boolean r2 = r1.isDirectory()
                if (r2 != 0) goto L_0x002c
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Invalid database parent file, not a directory: "
                r2.append(r3)
                r2.append(r1)
            L_0x002c:
                android.database.sqlite.SQLiteDatabase r5 = r4.f(r5)     // Catch:{ all -> 0x0031 }
                return r5
            L_0x0031:
                super.close()
                r1 = 500(0x1f4, double:2.47E-321)
                java.lang.Thread.sleep(r1)     // Catch:{ InterruptedException -> 0x0039 }
            L_0x0039:
                android.database.sqlite.SQLiteDatabase r5 = r4.f(r5)     // Catch:{ all -> 0x003e }
                return r5
            L_0x003e:
                r1 = move-exception
                super.close()
                boolean r2 = r1 instanceof androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackException
                if (r2 == 0) goto L_0x006b
                androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackException r1 = (androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackException) r1
                java.lang.Throwable r2 = r1.getCause()
                androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = r1.a()
                int[] r3 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.b.f7033a
                int r1 = r1.ordinal()
                r1 = r3[r1]
                r3 = 1
                if (r1 == r3) goto L_0x006a
                r3 = 2
                if (r1 == r3) goto L_0x006a
                r3 = 3
                if (r1 == r3) goto L_0x006a
                r3 = 4
                if (r1 == r3) goto L_0x006a
                boolean r1 = r2 instanceof android.database.sqlite.SQLiteException
                if (r1 == 0) goto L_0x0069
                goto L_0x0075
            L_0x0069:
                throw r2
            L_0x006a:
                throw r2
            L_0x006b:
                boolean r2 = r1 instanceof android.database.sqlite.SQLiteException
                if (r2 == 0) goto L_0x0086
                if (r0 == 0) goto L_0x0085
                boolean r2 = r4.f7023d
                if (r2 == 0) goto L_0x0085
            L_0x0075:
                android.content.Context r1 = r4.f7020a
                r1.deleteDatabase(r0)
                android.database.sqlite.SQLiteDatabase r5 = r4.f(r5)     // Catch:{ CallbackException -> 0x007f }
                return r5
            L_0x007f:
                r5 = move-exception
                java.lang.Throwable r5 = r5.getCause()
                throw r5
            L_0x0085:
                throw r1
            L_0x0086:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.g(boolean):android.database.sqlite.SQLiteDatabase");
        }

        public final i c(boolean z10) {
            boolean z11;
            try {
                u1.a aVar = this.f7025f;
                if (this.f7026g || getDatabaseName() == null) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                aVar.b(z11);
                this.f7024e = false;
                SQLiteDatabase g10 = g(z10);
                if (this.f7024e) {
                    close();
                    return c(z10);
                }
                FrameworkSQLiteDatabase e10 = e(g10);
                this.f7025f.d();
                return e10;
            } finally {
                this.f7025f.d();
            }
        }

        public void close() {
            try {
                u1.a.c(this.f7025f, false, 1, (Object) null);
                super.close();
                this.f7021b.b((FrameworkSQLiteDatabase) null);
                this.f7026g = false;
            } finally {
                this.f7025f.d();
            }
        }

        public final FrameworkSQLiteDatabase e(SQLiteDatabase sQLiteDatabase) {
            kotlin.jvm.internal.j.g(sQLiteDatabase, "sqLiteDatabase");
            return f7019h.a(this.f7021b, sQLiteDatabase);
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            kotlin.jvm.internal.j.g(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
            if (!this.f7024e && this.f7022c.f17635a != sQLiteDatabase.getVersion()) {
                sQLiteDatabase.setMaxSqlCacheSize(1);
            }
            try {
                this.f7022c.b(e(sQLiteDatabase));
            } catch (Throwable th2) {
                throw new CallbackException(CallbackName.ON_CONFIGURE, th2);
            }
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            kotlin.jvm.internal.j.g(sQLiteDatabase, "sqLiteDatabase");
            try {
                this.f7022c.d(e(sQLiteDatabase));
            } catch (Throwable th2) {
                throw new CallbackException(CallbackName.ON_CREATE, th2);
            }
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            kotlin.jvm.internal.j.g(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
            this.f7024e = true;
            try {
                this.f7022c.e(e(sQLiteDatabase), i10, i11);
            } catch (Throwable th2) {
                throw new CallbackException(CallbackName.ON_DOWNGRADE, th2);
            }
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            kotlin.jvm.internal.j.g(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
            if (!this.f7024e) {
                try {
                    this.f7022c.f(e(sQLiteDatabase));
                } catch (Throwable th2) {
                    throw new CallbackException(CallbackName.ON_OPEN, th2);
                }
            }
            this.f7026g = true;
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            kotlin.jvm.internal.j.g(sQLiteDatabase, "sqLiteDatabase");
            this.f7024e = true;
            try {
                this.f7022c.g(e(sQLiteDatabase), i10, i11);
            } catch (Throwable th2) {
                throw new CallbackException(CallbackName.ON_UPGRADE, th2);
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\u0007R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$b;", "", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "a", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "()Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "b", "(Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;)V", "db", "<init>", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1})
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private FrameworkSQLiteDatabase f7034a;

        public b(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.f7034a = frameworkSQLiteDatabase;
        }

        public final FrameworkSQLiteDatabase a() {
            return this.f7034a;
        }

        public final void b(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.f7034a = frameworkSQLiteDatabase;
        }
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, j.a aVar, boolean z10, boolean z11) {
        kotlin.jvm.internal.j.g(context, IdentityHttpResponse.CONTEXT);
        kotlin.jvm.internal.j.g(aVar, "callback");
        this.f7012a = context;
        this.f7013b = str;
        this.f7014c = aVar;
        this.f7015d = z10;
        this.f7016e = z11;
    }

    private final OpenHelper h() {
        return this.f7017f.getValue();
    }

    public void close() {
        if (this.f7017f.isInitialized()) {
            h().close();
        }
    }

    public String getDatabaseName() {
        return this.f7013b;
    }

    public i n1() {
        return h().c(true);
    }

    public void setWriteAheadLoggingEnabled(boolean z10) {
        if (this.f7017f.isInitialized()) {
            t1.b.d(h(), z10);
        }
        this.f7018g = z10;
    }
}

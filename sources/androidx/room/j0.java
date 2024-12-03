package androidx.room;

import com.facebook.appevents.UserDataStore;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.bytebuddy.implementation.MethodDelegation;
import t1.i;
import t1.j;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0017\u0018\u0000 \r2\u00020\u0001:\u0003\u001d\b\u0011B'\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0018¨\u0006\u001e"}, d2 = {"Landroidx/room/j0;", "Lt1/j$a;", "Lt1/i;", "db", "", "h", "j", "i", "b", "d", "", "oldVersion", "newVersion", "g", "e", "f", "Landroidx/room/e;", "c", "Landroidx/room/e;", "configuration", "Landroidx/room/j0$b;", "Landroidx/room/j0$b;", "delegate", "", "Ljava/lang/String;", "identityHash", "legacyHash", "<init>", "(Landroidx/room/e;Landroidx/room/j0$b;Ljava/lang/String;Ljava/lang/String;)V", "a", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
public class j0 extends j.a {

    /* renamed from: g  reason: collision with root package name */
    public static final a f6859g = new a((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private e f6860c;

    /* renamed from: d  reason: collision with root package name */
    private final b f6861d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6862e;

    /* renamed from: f  reason: collision with root package name */
    private final String f6863f;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\n"}, d2 = {"Landroidx/room/j0$a;", "", "Lt1/i;", "db", "", "b", "(Lt1/i;)Z", "a", "<init>", "()V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            kotlin.io.b.a(r4, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(t1.i r4) {
            /*
                r3 = this;
                java.lang.String r0 = "db"
                kotlin.jvm.internal.j.g(r4, r0)
                java.lang.String r0 = "SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"
                android.database.Cursor r4 = r4.q1(r0)
                r0 = 0
                boolean r1 = r4.moveToFirst()     // Catch:{ all -> 0x001e }
                r2 = 0
                if (r1 == 0) goto L_0x001a
                int r1 = r4.getInt(r2)     // Catch:{ all -> 0x001e }
                if (r1 != 0) goto L_0x001a
                r2 = 1
            L_0x001a:
                kotlin.io.b.a(r4, r0)
                return r2
            L_0x001e:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0020 }
            L_0x0020:
                r1 = move-exception
                kotlin.io.b.a(r4, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.j0.a.a(t1.i):boolean");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            kotlin.io.b.a(r4, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0024, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean b(t1.i r4) {
            /*
                r3 = this;
                java.lang.String r0 = "db"
                kotlin.jvm.internal.j.g(r4, r0)
                java.lang.String r0 = "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"
                android.database.Cursor r4 = r4.q1(r0)
                r0 = 0
                boolean r1 = r4.moveToFirst()     // Catch:{ all -> 0x001e }
                r2 = 0
                if (r1 == 0) goto L_0x001a
                int r1 = r4.getInt(r2)     // Catch:{ all -> 0x001e }
                if (r1 == 0) goto L_0x001a
                r2 = 1
            L_0x001a:
                kotlin.io.b.a(r4, r0)
                return r2
            L_0x001e:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x0020 }
            L_0x0020:
                r1 = move-exception
                kotlin.io.b.a(r4, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.j0.a.b(t1.i):boolean");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000f¨\u0006\u0013"}, d2 = {"Landroidx/room/j0$b;", "", "Lt1/i;", "database", "", "b", "a", "d", "c", "db", "Landroidx/room/j0$c;", "g", "f", "e", "", "I", "version", "<init>", "(I)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f6864a;

        public b(int i10) {
            this.f6864a = i10;
        }

        public abstract void a(i iVar);

        public abstract void b(i iVar);

        public abstract void c(i iVar);

        public abstract void d(i iVar);

        public abstract void e(i iVar);

        public abstract void f(i iVar);

        public abstract c g(i iVar);
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Landroidx/room/j0$c;", "", "", "a", "Z", "isValid", "", "b", "Ljava/lang/String;", "expectedFoundMsg", "<init>", "(ZLjava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 7, 1})
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f6865a;

        /* renamed from: b  reason: collision with root package name */
        public final String f6866b;

        public c(boolean z10, String str) {
            this.f6865a = z10;
            this.f6866b = str;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j0(e eVar, b bVar, String str, String str2) {
        super(bVar.f6864a);
        kotlin.jvm.internal.j.g(eVar, "configuration");
        kotlin.jvm.internal.j.g(bVar, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        kotlin.jvm.internal.j.g(str, "identityHash");
        kotlin.jvm.internal.j.g(str2, "legacyHash");
        this.f6860c = eVar;
        this.f6861d = bVar;
        this.f6862e = str;
        this.f6863f = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0058, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
        kotlin.io.b.a(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void h(t1.i r4) {
        /*
            r3 = this;
            androidx.room.j0$a r0 = f6859g
            boolean r0 = r0.b(r4)
            if (r0 == 0) goto L_0x005d
            t1.a r0 = new t1.a
            java.lang.String r1 = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"
            r0.<init>(r1)
            android.database.Cursor r4 = r4.Z0(r0)
            boolean r0 = r4.moveToFirst()     // Catch:{ all -> 0x0056 }
            r1 = 0
            if (r0 == 0) goto L_0x0020
            r0 = 0
            java.lang.String r0 = r4.getString(r0)     // Catch:{ all -> 0x0056 }
            goto L_0x0021
        L_0x0020:
            r0 = r1
        L_0x0021:
            kotlin.io.b.a(r4, r1)
            java.lang.String r4 = r3.f6862e
            boolean r4 = kotlin.jvm.internal.j.b(r4, r0)
            if (r4 != 0) goto L_0x006f
            java.lang.String r4 = r3.f6863f
            boolean r4 = kotlin.jvm.internal.j.b(r4, r0)
            if (r4 == 0) goto L_0x0035
            goto L_0x006f
        L_0x0035:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: "
            r1.append(r2)
            java.lang.String r2 = r3.f6862e
            r1.append(r2)
            java.lang.String r2 = ", found: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r4.<init>(r0)
            throw r4
        L_0x0056:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r1 = move-exception
            kotlin.io.b.a(r4, r0)
            throw r1
        L_0x005d:
            androidx.room.j0$b r0 = r3.f6861d
            androidx.room.j0$c r0 = r0.g(r4)
            boolean r1 = r0.f6865a
            if (r1 == 0) goto L_0x0070
            androidx.room.j0$b r0 = r3.f6861d
            r0.e(r4)
            r3.j(r4)
        L_0x006f:
            return
        L_0x0070:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Pre-packaged database has an invalid schema: "
            r1.append(r2)
            java.lang.String r0 = r0.f6866b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.j0.h(t1.i):void");
    }

    private final void i(i iVar) {
        iVar.D("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private final void j(i iVar) {
        i(iVar);
        iVar.D(i0.a(this.f6862e));
    }

    public void b(i iVar) {
        kotlin.jvm.internal.j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        super.b(iVar);
    }

    public void d(i iVar) {
        kotlin.jvm.internal.j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        boolean a10 = f6859g.a(iVar);
        this.f6861d.a(iVar);
        if (!a10) {
            c g10 = this.f6861d.g(iVar);
            if (!g10.f6865a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g10.f6866b);
            }
        }
        j(iVar);
        this.f6861d.c(iVar);
    }

    public void e(i iVar, int i10, int i11) {
        kotlin.jvm.internal.j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        g(iVar, i10, i11);
    }

    public void f(i iVar) {
        kotlin.jvm.internal.j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        super.f(iVar);
        h(iVar);
        this.f6861d.d(iVar);
        this.f6860c = null;
    }

    public void g(i iVar, int i10, int i11) {
        List<p1.b> d10;
        kotlin.jvm.internal.j.g(iVar, UserDataStore.DATE_OF_BIRTH);
        e eVar = this.f6860c;
        boolean z10 = false;
        if (!(eVar == null || (d10 = eVar.f6832d.d(i10, i11)) == null)) {
            this.f6861d.f(iVar);
            for (p1.b a10 : d10) {
                a10.a(iVar);
            }
            c g10 = this.f6861d.g(iVar);
            if (g10.f6865a) {
                this.f6861d.e(iVar);
                j(iVar);
                z10 = true;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + g10.f6866b);
            }
        }
        if (!z10) {
            e eVar2 = this.f6860c;
            if (eVar2 == null || eVar2.a(i10, i11)) {
                throw new IllegalStateException("A migration from " + i10 + " to " + i11 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
            }
            this.f6861d.b(iVar);
            this.f6861d.a(iVar);
        }
    }
}

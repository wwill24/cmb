package g2;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.h;
import androidx.room.k0;
import g2.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import t1.m;

public final class k implements j {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f15051a;

    /* renamed from: b  reason: collision with root package name */
    private final h<i> f15052b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f15053c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f15054d;

    class a extends h<i> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, i iVar) {
            String str = iVar.f15048a;
            if (str == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, str);
            }
            mVar.f1(2, (long) iVar.a());
            mVar.f1(3, (long) iVar.f15050c);
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM SystemIdInfo where work_spec_id=? AND generation=?";
        }
    }

    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public k(RoomDatabase roomDatabase) {
        this.f15051a = roomDatabase;
        this.f15052b = new a(roomDatabase);
        this.f15053c = new b(roomDatabase);
        this.f15054d = new c(roomDatabase);
    }

    public static List<Class<?>> h() {
        return Collections.emptyList();
    }

    public void a(m mVar) {
        j.a.b(this, mVar);
    }

    public void b(i iVar) {
        this.f15051a.d();
        this.f15051a.e();
        try {
            this.f15052b.k(iVar);
            this.f15051a.C();
        } finally {
            this.f15051a.j();
        }
    }

    public i c(m mVar) {
        return j.a.a(this, mVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: g2.i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g2.i d(java.lang.String r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?"
            r1 = 2
            androidx.room.k0 r0 = androidx.room.k0.c(r0, r1)
            r2 = 1
            if (r6 != 0) goto L_0x000e
            r0.B1(r2)
            goto L_0x0011
        L_0x000e:
            r0.P0(r2, r6)
        L_0x0011:
            long r6 = (long) r7
            r0.f1(r1, r6)
            androidx.room.RoomDatabase r6 = r5.f15051a
            r6.d()
            androidx.room.RoomDatabase r6 = r5.f15051a
            r7 = 0
            r1 = 0
            android.database.Cursor r6 = q1.b.b(r6, r0, r7, r1)
            java.lang.String r7 = "work_spec_id"
            int r7 = q1.a.e(r6, r7)     // Catch:{ all -> 0x005a }
            java.lang.String r2 = "generation"
            int r2 = q1.a.e(r6, r2)     // Catch:{ all -> 0x005a }
            java.lang.String r3 = "system_id"
            int r3 = q1.a.e(r6, r3)     // Catch:{ all -> 0x005a }
            boolean r4 = r6.moveToFirst()     // Catch:{ all -> 0x005a }
            if (r4 == 0) goto L_0x0053
            boolean r4 = r6.isNull(r7)     // Catch:{ all -> 0x005a }
            if (r4 == 0) goto L_0x0041
            goto L_0x0045
        L_0x0041:
            java.lang.String r1 = r6.getString(r7)     // Catch:{ all -> 0x005a }
        L_0x0045:
            int r7 = r6.getInt(r2)     // Catch:{ all -> 0x005a }
            int r2 = r6.getInt(r3)     // Catch:{ all -> 0x005a }
            g2.i r3 = new g2.i     // Catch:{ all -> 0x005a }
            r3.<init>(r1, r7, r2)     // Catch:{ all -> 0x005a }
            r1 = r3
        L_0x0053:
            r6.close()
            r0.g()
            return r1
        L_0x005a:
            r7 = move-exception
            r6.close()
            r0.g()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.k.d(java.lang.String, int):g2.i");
    }

    public List<String> e() {
        String str;
        k0 c10 = k0.c("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.f15051a.d();
        Cursor b10 = q1.b.b(this.f15051a, c10, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                if (b10.isNull(0)) {
                    str = null;
                } else {
                    str = b10.getString(0);
                }
                arrayList.add(str);
            }
            return arrayList;
        } finally {
            b10.close();
            c10.g();
        }
    }

    public void f(String str, int i10) {
        this.f15051a.d();
        m b10 = this.f15053c.b();
        if (str == null) {
            b10.B1(1);
        } else {
            b10.P0(1, str);
        }
        b10.f1(2, (long) i10);
        this.f15051a.e();
        try {
            b10.H();
            this.f15051a.C();
        } finally {
            this.f15051a.j();
            this.f15053c.h(b10);
        }
    }

    public void g(String str) {
        this.f15051a.d();
        m b10 = this.f15054d.b();
        if (str == null) {
            b10.B1(1);
        } else {
            b10.P0(1, str);
        }
        this.f15051a.e();
        try {
            b10.H();
            this.f15051a.C();
        } finally {
            this.f15051a.j();
            this.f15054d.h(b10);
        }
    }
}

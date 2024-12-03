package g2;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.k0;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import g2.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class w implements v {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f15106a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.room.h<u> f15107b;

    /* renamed from: c  reason: collision with root package name */
    private final androidx.room.g<u> f15108c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f15109d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedSQLiteStatement f15110e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f15111f;

    /* renamed from: g  reason: collision with root package name */
    private final SharedSQLiteStatement f15112g;

    /* renamed from: h  reason: collision with root package name */
    private final SharedSQLiteStatement f15113h;

    /* renamed from: i  reason: collision with root package name */
    private final SharedSQLiteStatement f15114i;

    /* renamed from: j  reason: collision with root package name */
    private final SharedSQLiteStatement f15115j;

    /* renamed from: k  reason: collision with root package name */
    private final SharedSQLiteStatement f15116k;

    /* renamed from: l  reason: collision with root package name */
    private final SharedSQLiteStatement f15117l;

    /* renamed from: m  reason: collision with root package name */
    private final SharedSQLiteStatement f15118m;

    /* renamed from: n  reason: collision with root package name */
    private final SharedSQLiteStatement f15119n;

    class a extends SharedSQLiteStatement {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    class d extends SharedSQLiteStatement {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE workspec SET generation=generation+1 WHERE id=?";
        }
    }

    class e extends androidx.room.h<u> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(t1.m mVar, u uVar) {
            String str = uVar.f15077a;
            if (str == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, str);
            }
            b0 b0Var = b0.f15035a;
            mVar.f1(2, (long) b0.j(uVar.f15078b));
            String str2 = uVar.f15079c;
            if (str2 == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, str2);
            }
            String str3 = uVar.f15080d;
            if (str3 == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, str3);
            }
            byte[] k10 = androidx.work.b.k(uVar.f15081e);
            if (k10 == null) {
                mVar.B1(5);
            } else {
                mVar.l1(5, k10);
            }
            byte[] k11 = androidx.work.b.k(uVar.f15082f);
            if (k11 == null) {
                mVar.B1(6);
            } else {
                mVar.l1(6, k11);
            }
            mVar.f1(7, uVar.f15083g);
            mVar.f1(8, uVar.f15084h);
            mVar.f1(9, uVar.f15085i);
            mVar.f1(10, (long) uVar.f15087k);
            mVar.f1(11, (long) b0.a(uVar.f15088l));
            mVar.f1(12, uVar.f15089m);
            mVar.f1(13, uVar.f15090n);
            mVar.f1(14, uVar.f15091o);
            mVar.f1(15, uVar.f15092p);
            mVar.f1(16, uVar.f15093q ? 1 : 0);
            mVar.f1(17, (long) b0.h(uVar.f15094r));
            mVar.f1(18, (long) uVar.g());
            mVar.f1(19, (long) uVar.f());
            b2.a aVar = uVar.f15086j;
            if (aVar != null) {
                mVar.f1(20, (long) b0.g(aVar.d()));
                mVar.f1(21, aVar.g() ? 1 : 0);
                mVar.f1(22, aVar.h() ? 1 : 0);
                mVar.f1(23, aVar.f() ? 1 : 0);
                mVar.f1(24, aVar.i() ? 1 : 0);
                mVar.f1(25, aVar.b());
                mVar.f1(26, aVar.a());
                byte[] i10 = b0.i(aVar.c());
                if (i10 == null) {
                    mVar.B1(27);
                } else {
                    mVar.l1(27, i10);
                }
            } else {
                mVar.B1(20);
                mVar.B1(21);
                mVar.B1(22);
                mVar.B1(23);
                mVar.B1(24);
                mVar.B1(25);
                mVar.B1(26);
                mVar.B1(27);
            }
        }
    }

    class f extends androidx.room.g<u> {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(t1.m mVar, u uVar) {
            String str = uVar.f15077a;
            if (str == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, str);
            }
            b0 b0Var = b0.f15035a;
            mVar.f1(2, (long) b0.j(uVar.f15078b));
            String str2 = uVar.f15079c;
            if (str2 == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, str2);
            }
            String str3 = uVar.f15080d;
            if (str3 == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, str3);
            }
            byte[] k10 = androidx.work.b.k(uVar.f15081e);
            if (k10 == null) {
                mVar.B1(5);
            } else {
                mVar.l1(5, k10);
            }
            byte[] k11 = androidx.work.b.k(uVar.f15082f);
            if (k11 == null) {
                mVar.B1(6);
            } else {
                mVar.l1(6, k11);
            }
            mVar.f1(7, uVar.f15083g);
            mVar.f1(8, uVar.f15084h);
            mVar.f1(9, uVar.f15085i);
            mVar.f1(10, (long) uVar.f15087k);
            mVar.f1(11, (long) b0.a(uVar.f15088l));
            mVar.f1(12, uVar.f15089m);
            mVar.f1(13, uVar.f15090n);
            mVar.f1(14, uVar.f15091o);
            mVar.f1(15, uVar.f15092p);
            mVar.f1(16, uVar.f15093q ? 1 : 0);
            mVar.f1(17, (long) b0.h(uVar.f15094r));
            mVar.f1(18, (long) uVar.g());
            mVar.f1(19, (long) uVar.f());
            b2.a aVar = uVar.f15086j;
            if (aVar != null) {
                mVar.f1(20, (long) b0.g(aVar.d()));
                mVar.f1(21, aVar.g() ? 1 : 0);
                mVar.f1(22, aVar.h() ? 1 : 0);
                mVar.f1(23, aVar.f() ? 1 : 0);
                mVar.f1(24, aVar.i() ? 1 : 0);
                mVar.f1(25, aVar.b());
                mVar.f1(26, aVar.a());
                byte[] i10 = b0.i(aVar.c());
                if (i10 == null) {
                    mVar.B1(27);
                } else {
                    mVar.l1(27, i10);
                }
            } else {
                mVar.B1(20);
                mVar.B1(21);
                mVar.B1(22);
                mVar.B1(23);
                mVar.B1(24);
                mVar.B1(25);
                mVar.B1(26);
                mVar.B1(27);
            }
            String str4 = uVar.f15077a;
            if (str4 == null) {
                mVar.B1(28);
            } else {
                mVar.P0(28, str4);
            }
        }
    }

    class g extends SharedSQLiteStatement {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    class h extends SharedSQLiteStatement {
        h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE workspec SET state=? WHERE id=?";
        }
    }

    class i extends SharedSQLiteStatement {
        i(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
        }
    }

    class j extends SharedSQLiteStatement {
        j(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    class k extends SharedSQLiteStatement {
        k(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
        }
    }

    class l extends SharedSQLiteStatement {
        l(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    class m extends SharedSQLiteStatement {
        m(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    public w(RoomDatabase roomDatabase) {
        this.f15106a = roomDatabase;
        this.f15107b = new e(roomDatabase);
        this.f15108c = new f(roomDatabase);
        this.f15109d = new g(roomDatabase);
        this.f15110e = new h(roomDatabase);
        this.f15111f = new i(roomDatabase);
        this.f15112g = new j(roomDatabase);
        this.f15113h = new k(roomDatabase);
        this.f15114i = new l(roomDatabase);
        this.f15115j = new m(roomDatabase);
        this.f15116k = new a(roomDatabase);
        this.f15117l = new b(roomDatabase);
        this.f15118m = new c(roomDatabase);
        this.f15119n = new d(roomDatabase);
    }

    public static List<Class<?>> v() {
        return Collections.emptyList();
    }

    public void a(String str) {
        this.f15106a.d();
        t1.m b10 = this.f15109d.b();
        if (str == null) {
            b10.B1(1);
        } else {
            b10.P0(1, str);
        }
        this.f15106a.e();
        try {
            b10.H();
            this.f15106a.C();
        } finally {
            this.f15106a.j();
            this.f15109d.h(b10);
        }
    }

    public void b(String str) {
        this.f15106a.d();
        t1.m b10 = this.f15111f.b();
        if (str == null) {
            b10.B1(1);
        } else {
            b10.P0(1, str);
        }
        this.f15106a.e();
        try {
            b10.H();
            this.f15106a.C();
        } finally {
            this.f15106a.j();
            this.f15111f.h(b10);
        }
    }

    public List<u> c(long j10) {
        k0 k0Var;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2;
        boolean z10;
        int i10;
        boolean z11;
        int i11;
        boolean z12;
        int i12;
        boolean z13;
        int i13;
        boolean z14;
        int i14;
        byte[] bArr3;
        k0 c10 = k0.c("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", 1);
        c10.f1(1, j10);
        this.f15106a.d();
        Cursor b10 = q1.b.b(this.f15106a, c10, false, (CancellationSignal) null);
        try {
            int e10 = q1.a.e(b10, "id");
            int e11 = q1.a.e(b10, "state");
            int e12 = q1.a.e(b10, "worker_class_name");
            int e13 = q1.a.e(b10, "input_merger_class_name");
            int e14 = q1.a.e(b10, "input");
            int e15 = q1.a.e(b10, "output");
            int e16 = q1.a.e(b10, "initial_delay");
            int e17 = q1.a.e(b10, "interval_duration");
            int e18 = q1.a.e(b10, "flex_duration");
            int e19 = q1.a.e(b10, "run_attempt_count");
            int e20 = q1.a.e(b10, "backoff_policy");
            int e21 = q1.a.e(b10, "backoff_delay_duration");
            int e22 = q1.a.e(b10, "last_enqueue_time");
            int e23 = q1.a.e(b10, "minimum_retention_duration");
            k0Var = c10;
            try {
                int e24 = q1.a.e(b10, "schedule_requested_at");
                int e25 = q1.a.e(b10, "run_in_foreground");
                int e26 = q1.a.e(b10, "out_of_quota_policy");
                int e27 = q1.a.e(b10, "period_count");
                int e28 = q1.a.e(b10, "generation");
                int e29 = q1.a.e(b10, "required_network_type");
                int e30 = q1.a.e(b10, "requires_charging");
                int e31 = q1.a.e(b10, "requires_device_idle");
                int e32 = q1.a.e(b10, "requires_battery_not_low");
                int e33 = q1.a.e(b10, "requires_storage_not_low");
                int e34 = q1.a.e(b10, "trigger_content_update_delay");
                int e35 = q1.a.e(b10, "trigger_max_content_delay");
                int e36 = q1.a.e(b10, "content_uri_triggers");
                int i15 = e23;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(e10)) {
                        str = null;
                    } else {
                        str = b10.getString(e10);
                    }
                    WorkInfo.State f10 = b0.f(b10.getInt(e11));
                    if (b10.isNull(e12)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(e12);
                    }
                    if (b10.isNull(e13)) {
                        str3 = null;
                    } else {
                        str3 = b10.getString(e13);
                    }
                    if (b10.isNull(e14)) {
                        bArr = null;
                    } else {
                        bArr = b10.getBlob(e14);
                    }
                    androidx.work.b g10 = androidx.work.b.g(bArr);
                    if (b10.isNull(e15)) {
                        bArr2 = null;
                    } else {
                        bArr2 = b10.getBlob(e15);
                    }
                    androidx.work.b g11 = androidx.work.b.g(bArr2);
                    long j11 = b10.getLong(e16);
                    long j12 = b10.getLong(e17);
                    long j13 = b10.getLong(e18);
                    int i16 = b10.getInt(e19);
                    BackoffPolicy c11 = b0.c(b10.getInt(e20));
                    long j14 = b10.getLong(e21);
                    long j15 = b10.getLong(e22);
                    int i17 = i15;
                    long j16 = b10.getLong(i17);
                    int i18 = e10;
                    int i19 = e24;
                    long j17 = b10.getLong(i19);
                    e24 = i19;
                    int i20 = e25;
                    if (b10.getInt(i20) != 0) {
                        e25 = i20;
                        i10 = e26;
                        z10 = true;
                    } else {
                        e25 = i20;
                        i10 = e26;
                        z10 = false;
                    }
                    OutOfQuotaPolicy e37 = b0.e(b10.getInt(i10));
                    e26 = i10;
                    int i21 = e27;
                    int i22 = b10.getInt(i21);
                    e27 = i21;
                    int i23 = e28;
                    int i24 = b10.getInt(i23);
                    e28 = i23;
                    int i25 = e29;
                    NetworkType d10 = b0.d(b10.getInt(i25));
                    e29 = i25;
                    int i26 = e30;
                    if (b10.getInt(i26) != 0) {
                        e30 = i26;
                        i11 = e31;
                        z11 = true;
                    } else {
                        e30 = i26;
                        i11 = e31;
                        z11 = false;
                    }
                    if (b10.getInt(i11) != 0) {
                        e31 = i11;
                        i12 = e32;
                        z12 = true;
                    } else {
                        e31 = i11;
                        i12 = e32;
                        z12 = false;
                    }
                    if (b10.getInt(i12) != 0) {
                        e32 = i12;
                        i13 = e33;
                        z13 = true;
                    } else {
                        e32 = i12;
                        i13 = e33;
                        z13 = false;
                    }
                    if (b10.getInt(i13) != 0) {
                        e33 = i13;
                        i14 = e34;
                        z14 = true;
                    } else {
                        e33 = i13;
                        i14 = e34;
                        z14 = false;
                    }
                    long j18 = b10.getLong(i14);
                    e34 = i14;
                    int i27 = e35;
                    long j19 = b10.getLong(i27);
                    e35 = i27;
                    int i28 = e36;
                    if (b10.isNull(i28)) {
                        bArr3 = null;
                    } else {
                        bArr3 = b10.getBlob(i28);
                    }
                    e36 = i28;
                    arrayList.add(new u(str, f10, str2, str3, g10, g11, j11, j12, j13, new b2.a(d10, z11, z12, z13, z14, j18, j19, b0.b(bArr3)), i16, c11, j14, j15, j16, j17, z10, e37, i22, i24));
                    e10 = i18;
                    i15 = i17;
                }
                b10.close();
                k0Var.g();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                b10.close();
                k0Var.g();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            k0Var = c10;
            b10.close();
            k0Var.g();
            throw th;
        }
    }

    public List<u> d() {
        k0 k0Var;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2;
        boolean z10;
        int i10;
        boolean z11;
        int i11;
        boolean z12;
        int i12;
        boolean z13;
        int i13;
        boolean z14;
        int i14;
        byte[] bArr3;
        k0 c10 = k0.c("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f15106a.d();
        Cursor b10 = q1.b.b(this.f15106a, c10, false, (CancellationSignal) null);
        try {
            int e10 = q1.a.e(b10, "id");
            int e11 = q1.a.e(b10, "state");
            int e12 = q1.a.e(b10, "worker_class_name");
            int e13 = q1.a.e(b10, "input_merger_class_name");
            int e14 = q1.a.e(b10, "input");
            int e15 = q1.a.e(b10, "output");
            int e16 = q1.a.e(b10, "initial_delay");
            int e17 = q1.a.e(b10, "interval_duration");
            int e18 = q1.a.e(b10, "flex_duration");
            int e19 = q1.a.e(b10, "run_attempt_count");
            int e20 = q1.a.e(b10, "backoff_policy");
            int e21 = q1.a.e(b10, "backoff_delay_duration");
            int e22 = q1.a.e(b10, "last_enqueue_time");
            int e23 = q1.a.e(b10, "minimum_retention_duration");
            k0Var = c10;
            try {
                int e24 = q1.a.e(b10, "schedule_requested_at");
                int e25 = q1.a.e(b10, "run_in_foreground");
                int e26 = q1.a.e(b10, "out_of_quota_policy");
                int e27 = q1.a.e(b10, "period_count");
                int e28 = q1.a.e(b10, "generation");
                int e29 = q1.a.e(b10, "required_network_type");
                int e30 = q1.a.e(b10, "requires_charging");
                int e31 = q1.a.e(b10, "requires_device_idle");
                int e32 = q1.a.e(b10, "requires_battery_not_low");
                int e33 = q1.a.e(b10, "requires_storage_not_low");
                int e34 = q1.a.e(b10, "trigger_content_update_delay");
                int e35 = q1.a.e(b10, "trigger_max_content_delay");
                int e36 = q1.a.e(b10, "content_uri_triggers");
                int i15 = e23;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(e10)) {
                        str = null;
                    } else {
                        str = b10.getString(e10);
                    }
                    WorkInfo.State f10 = b0.f(b10.getInt(e11));
                    if (b10.isNull(e12)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(e12);
                    }
                    if (b10.isNull(e13)) {
                        str3 = null;
                    } else {
                        str3 = b10.getString(e13);
                    }
                    if (b10.isNull(e14)) {
                        bArr = null;
                    } else {
                        bArr = b10.getBlob(e14);
                    }
                    androidx.work.b g10 = androidx.work.b.g(bArr);
                    if (b10.isNull(e15)) {
                        bArr2 = null;
                    } else {
                        bArr2 = b10.getBlob(e15);
                    }
                    androidx.work.b g11 = androidx.work.b.g(bArr2);
                    long j10 = b10.getLong(e16);
                    long j11 = b10.getLong(e17);
                    long j12 = b10.getLong(e18);
                    int i16 = b10.getInt(e19);
                    BackoffPolicy c11 = b0.c(b10.getInt(e20));
                    long j13 = b10.getLong(e21);
                    long j14 = b10.getLong(e22);
                    int i17 = i15;
                    long j15 = b10.getLong(i17);
                    int i18 = e10;
                    int i19 = e24;
                    long j16 = b10.getLong(i19);
                    e24 = i19;
                    int i20 = e25;
                    if (b10.getInt(i20) != 0) {
                        e25 = i20;
                        i10 = e26;
                        z10 = true;
                    } else {
                        e25 = i20;
                        i10 = e26;
                        z10 = false;
                    }
                    OutOfQuotaPolicy e37 = b0.e(b10.getInt(i10));
                    e26 = i10;
                    int i21 = e27;
                    int i22 = b10.getInt(i21);
                    e27 = i21;
                    int i23 = e28;
                    int i24 = b10.getInt(i23);
                    e28 = i23;
                    int i25 = e29;
                    NetworkType d10 = b0.d(b10.getInt(i25));
                    e29 = i25;
                    int i26 = e30;
                    if (b10.getInt(i26) != 0) {
                        e30 = i26;
                        i11 = e31;
                        z11 = true;
                    } else {
                        e30 = i26;
                        i11 = e31;
                        z11 = false;
                    }
                    if (b10.getInt(i11) != 0) {
                        e31 = i11;
                        i12 = e32;
                        z12 = true;
                    } else {
                        e31 = i11;
                        i12 = e32;
                        z12 = false;
                    }
                    if (b10.getInt(i12) != 0) {
                        e32 = i12;
                        i13 = e33;
                        z13 = true;
                    } else {
                        e32 = i12;
                        i13 = e33;
                        z13 = false;
                    }
                    if (b10.getInt(i13) != 0) {
                        e33 = i13;
                        i14 = e34;
                        z14 = true;
                    } else {
                        e33 = i13;
                        i14 = e34;
                        z14 = false;
                    }
                    long j17 = b10.getLong(i14);
                    e34 = i14;
                    int i27 = e35;
                    long j18 = b10.getLong(i27);
                    e35 = i27;
                    int i28 = e36;
                    if (b10.isNull(i28)) {
                        bArr3 = null;
                    } else {
                        bArr3 = b10.getBlob(i28);
                    }
                    e36 = i28;
                    arrayList.add(new u(str, f10, str2, str3, g10, g11, j10, j11, j12, new b2.a(d10, z11, z12, z13, z14, j17, j18, b0.b(bArr3)), i16, c11, j13, j14, j15, j16, z10, e37, i22, i24));
                    e10 = i18;
                    i15 = i17;
                }
                b10.close();
                k0Var.g();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                b10.close();
                k0Var.g();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            k0Var = c10;
            b10.close();
            k0Var.g();
            throw th;
        }
    }

    public List<String> e(String str) {
        String str2;
        k0 c10 = k0.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        this.f15106a.d();
        Cursor b10 = q1.b.b(this.f15106a, c10, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                if (b10.isNull(0)) {
                    str2 = null;
                } else {
                    str2 = b10.getString(0);
                }
                arrayList.add(str2);
            }
            return arrayList;
        } finally {
            b10.close();
            c10.g();
        }
    }

    public void f(u uVar) {
        this.f15106a.d();
        this.f15106a.e();
        try {
            this.f15107b.k(uVar);
            this.f15106a.C();
        } finally {
            this.f15106a.j();
        }
    }

    public WorkInfo.State g(String str) {
        Integer num;
        k0 c10 = k0.c("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        this.f15106a.d();
        WorkInfo.State state = null;
        Cursor b10 = q1.b.b(this.f15106a, c10, false, (CancellationSignal) null);
        try {
            if (b10.moveToFirst()) {
                if (b10.isNull(0)) {
                    num = null;
                } else {
                    num = Integer.valueOf(b10.getInt(0));
                }
                if (num != null) {
                    b0 b0Var = b0.f15035a;
                    state = b0.f(num.intValue());
                }
            }
            return state;
        } finally {
            b10.close();
            c10.g();
        }
    }

    public u h(String str) {
        k0 k0Var;
        u uVar;
        String str2;
        String str3;
        String str4;
        byte[] bArr;
        byte[] bArr2;
        boolean z10;
        int i10;
        boolean z11;
        int i11;
        boolean z12;
        int i12;
        boolean z13;
        int i13;
        boolean z14;
        int i14;
        byte[] bArr3;
        String str5 = str;
        k0 c10 = k0.c("SELECT * FROM workspec WHERE id=?", 1);
        if (str5 == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str5);
        }
        this.f15106a.d();
        Cursor b10 = q1.b.b(this.f15106a, c10, false, (CancellationSignal) null);
        try {
            int e10 = q1.a.e(b10, "id");
            int e11 = q1.a.e(b10, "state");
            int e12 = q1.a.e(b10, "worker_class_name");
            int e13 = q1.a.e(b10, "input_merger_class_name");
            int e14 = q1.a.e(b10, "input");
            int e15 = q1.a.e(b10, "output");
            int e16 = q1.a.e(b10, "initial_delay");
            int e17 = q1.a.e(b10, "interval_duration");
            int e18 = q1.a.e(b10, "flex_duration");
            int e19 = q1.a.e(b10, "run_attempt_count");
            int e20 = q1.a.e(b10, "backoff_policy");
            int e21 = q1.a.e(b10, "backoff_delay_duration");
            int e22 = q1.a.e(b10, "last_enqueue_time");
            int e23 = q1.a.e(b10, "minimum_retention_duration");
            k0Var = c10;
            try {
                int e24 = q1.a.e(b10, "schedule_requested_at");
                int e25 = q1.a.e(b10, "run_in_foreground");
                int e26 = q1.a.e(b10, "out_of_quota_policy");
                int e27 = q1.a.e(b10, "period_count");
                int e28 = q1.a.e(b10, "generation");
                int e29 = q1.a.e(b10, "required_network_type");
                int e30 = q1.a.e(b10, "requires_charging");
                int e31 = q1.a.e(b10, "requires_device_idle");
                int e32 = q1.a.e(b10, "requires_battery_not_low");
                int e33 = q1.a.e(b10, "requires_storage_not_low");
                int e34 = q1.a.e(b10, "trigger_content_update_delay");
                int e35 = q1.a.e(b10, "trigger_max_content_delay");
                int e36 = q1.a.e(b10, "content_uri_triggers");
                if (b10.moveToFirst()) {
                    if (b10.isNull(e10)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(e10);
                    }
                    WorkInfo.State f10 = b0.f(b10.getInt(e11));
                    if (b10.isNull(e12)) {
                        str3 = null;
                    } else {
                        str3 = b10.getString(e12);
                    }
                    if (b10.isNull(e13)) {
                        str4 = null;
                    } else {
                        str4 = b10.getString(e13);
                    }
                    if (b10.isNull(e14)) {
                        bArr = null;
                    } else {
                        bArr = b10.getBlob(e14);
                    }
                    androidx.work.b g10 = androidx.work.b.g(bArr);
                    if (b10.isNull(e15)) {
                        bArr2 = null;
                    } else {
                        bArr2 = b10.getBlob(e15);
                    }
                    androidx.work.b g11 = androidx.work.b.g(bArr2);
                    long j10 = b10.getLong(e16);
                    long j11 = b10.getLong(e17);
                    long j12 = b10.getLong(e18);
                    int i15 = b10.getInt(e19);
                    BackoffPolicy c11 = b0.c(b10.getInt(e20));
                    long j13 = b10.getLong(e21);
                    long j14 = b10.getLong(e22);
                    long j15 = b10.getLong(e23);
                    long j16 = b10.getLong(e24);
                    if (b10.getInt(e25) != 0) {
                        i10 = e26;
                        z10 = true;
                    } else {
                        i10 = e26;
                        z10 = false;
                    }
                    OutOfQuotaPolicy e37 = b0.e(b10.getInt(i10));
                    int i16 = b10.getInt(e27);
                    int i17 = b10.getInt(e28);
                    NetworkType d10 = b0.d(b10.getInt(e29));
                    if (b10.getInt(e30) != 0) {
                        i11 = e31;
                        z11 = true;
                    } else {
                        i11 = e31;
                        z11 = false;
                    }
                    if (b10.getInt(i11) != 0) {
                        i12 = e32;
                        z12 = true;
                    } else {
                        i12 = e32;
                        z12 = false;
                    }
                    if (b10.getInt(i12) != 0) {
                        i13 = e33;
                        z13 = true;
                    } else {
                        i13 = e33;
                        z13 = false;
                    }
                    if (b10.getInt(i13) != 0) {
                        i14 = e34;
                        z14 = true;
                    } else {
                        i14 = e34;
                        z14 = false;
                    }
                    long j17 = b10.getLong(i14);
                    long j18 = b10.getLong(e35);
                    if (b10.isNull(e36)) {
                        bArr3 = null;
                    } else {
                        bArr3 = b10.getBlob(e36);
                    }
                    uVar = new u(str2, f10, str3, str4, g10, g11, j10, j11, j12, new b2.a(d10, z11, z12, z13, z14, j17, j18, b0.b(bArr3)), i15, c11, j13, j14, j15, j16, z10, e37, i16, i17);
                } else {
                    uVar = null;
                }
                b10.close();
                k0Var.g();
                return uVar;
            } catch (Throwable th2) {
                th = th2;
                b10.close();
                k0Var.g();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            k0Var = c10;
            b10.close();
            k0Var.g();
            throw th;
        }
    }

    public void i(String str, long j10) {
        this.f15106a.d();
        t1.m b10 = this.f15113h.b();
        b10.f1(1, j10);
        if (str == null) {
            b10.B1(2);
        } else {
            b10.P0(2, str);
        }
        this.f15106a.e();
        try {
            b10.H();
            this.f15106a.C();
        } finally {
            this.f15106a.j();
            this.f15113h.h(b10);
        }
    }

    public List<androidx.work.b> j(String str) {
        byte[] bArr;
        k0 c10 = k0.c("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        this.f15106a.d();
        Cursor b10 = q1.b.b(this.f15106a, c10, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                if (b10.isNull(0)) {
                    bArr = null;
                } else {
                    bArr = b10.getBlob(0);
                }
                arrayList.add(androidx.work.b.g(bArr));
            }
            return arrayList;
        } finally {
            b10.close();
            c10.g();
        }
    }

    public List<u> k(int i10) {
        k0 k0Var;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2;
        boolean z10;
        int i11;
        boolean z11;
        int i12;
        boolean z12;
        int i13;
        boolean z13;
        int i14;
        boolean z14;
        int i15;
        byte[] bArr3;
        k0 c10 = k0.c("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", 1);
        c10.f1(1, (long) i10);
        this.f15106a.d();
        Cursor b10 = q1.b.b(this.f15106a, c10, false, (CancellationSignal) null);
        try {
            int e10 = q1.a.e(b10, "id");
            int e11 = q1.a.e(b10, "state");
            int e12 = q1.a.e(b10, "worker_class_name");
            int e13 = q1.a.e(b10, "input_merger_class_name");
            int e14 = q1.a.e(b10, "input");
            int e15 = q1.a.e(b10, "output");
            int e16 = q1.a.e(b10, "initial_delay");
            int e17 = q1.a.e(b10, "interval_duration");
            int e18 = q1.a.e(b10, "flex_duration");
            int e19 = q1.a.e(b10, "run_attempt_count");
            int e20 = q1.a.e(b10, "backoff_policy");
            int e21 = q1.a.e(b10, "backoff_delay_duration");
            int e22 = q1.a.e(b10, "last_enqueue_time");
            int e23 = q1.a.e(b10, "minimum_retention_duration");
            k0Var = c10;
            try {
                int e24 = q1.a.e(b10, "schedule_requested_at");
                int e25 = q1.a.e(b10, "run_in_foreground");
                int e26 = q1.a.e(b10, "out_of_quota_policy");
                int e27 = q1.a.e(b10, "period_count");
                int e28 = q1.a.e(b10, "generation");
                int e29 = q1.a.e(b10, "required_network_type");
                int e30 = q1.a.e(b10, "requires_charging");
                int e31 = q1.a.e(b10, "requires_device_idle");
                int e32 = q1.a.e(b10, "requires_battery_not_low");
                int e33 = q1.a.e(b10, "requires_storage_not_low");
                int e34 = q1.a.e(b10, "trigger_content_update_delay");
                int e35 = q1.a.e(b10, "trigger_max_content_delay");
                int e36 = q1.a.e(b10, "content_uri_triggers");
                int i16 = e23;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(e10)) {
                        str = null;
                    } else {
                        str = b10.getString(e10);
                    }
                    WorkInfo.State f10 = b0.f(b10.getInt(e11));
                    if (b10.isNull(e12)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(e12);
                    }
                    if (b10.isNull(e13)) {
                        str3 = null;
                    } else {
                        str3 = b10.getString(e13);
                    }
                    if (b10.isNull(e14)) {
                        bArr = null;
                    } else {
                        bArr = b10.getBlob(e14);
                    }
                    androidx.work.b g10 = androidx.work.b.g(bArr);
                    if (b10.isNull(e15)) {
                        bArr2 = null;
                    } else {
                        bArr2 = b10.getBlob(e15);
                    }
                    androidx.work.b g11 = androidx.work.b.g(bArr2);
                    long j10 = b10.getLong(e16);
                    long j11 = b10.getLong(e17);
                    long j12 = b10.getLong(e18);
                    int i17 = b10.getInt(e19);
                    BackoffPolicy c11 = b0.c(b10.getInt(e20));
                    long j13 = b10.getLong(e21);
                    long j14 = b10.getLong(e22);
                    int i18 = i16;
                    long j15 = b10.getLong(i18);
                    int i19 = e10;
                    int i20 = e24;
                    long j16 = b10.getLong(i20);
                    e24 = i20;
                    int i21 = e25;
                    if (b10.getInt(i21) != 0) {
                        e25 = i21;
                        i11 = e26;
                        z10 = true;
                    } else {
                        e25 = i21;
                        i11 = e26;
                        z10 = false;
                    }
                    OutOfQuotaPolicy e37 = b0.e(b10.getInt(i11));
                    e26 = i11;
                    int i22 = e27;
                    int i23 = b10.getInt(i22);
                    e27 = i22;
                    int i24 = e28;
                    int i25 = b10.getInt(i24);
                    e28 = i24;
                    int i26 = e29;
                    NetworkType d10 = b0.d(b10.getInt(i26));
                    e29 = i26;
                    int i27 = e30;
                    if (b10.getInt(i27) != 0) {
                        e30 = i27;
                        i12 = e31;
                        z11 = true;
                    } else {
                        e30 = i27;
                        i12 = e31;
                        z11 = false;
                    }
                    if (b10.getInt(i12) != 0) {
                        e31 = i12;
                        i13 = e32;
                        z12 = true;
                    } else {
                        e31 = i12;
                        i13 = e32;
                        z12 = false;
                    }
                    if (b10.getInt(i13) != 0) {
                        e32 = i13;
                        i14 = e33;
                        z13 = true;
                    } else {
                        e32 = i13;
                        i14 = e33;
                        z13 = false;
                    }
                    if (b10.getInt(i14) != 0) {
                        e33 = i14;
                        i15 = e34;
                        z14 = true;
                    } else {
                        e33 = i14;
                        i15 = e34;
                        z14 = false;
                    }
                    long j17 = b10.getLong(i15);
                    e34 = i15;
                    int i28 = e35;
                    long j18 = b10.getLong(i28);
                    e35 = i28;
                    int i29 = e36;
                    if (b10.isNull(i29)) {
                        bArr3 = null;
                    } else {
                        bArr3 = b10.getBlob(i29);
                    }
                    e36 = i29;
                    arrayList.add(new u(str, f10, str2, str3, g10, g11, j10, j11, j12, new b2.a(d10, z11, z12, z13, z14, j17, j18, b0.b(bArr3)), i17, c11, j13, j14, j15, j16, z10, e37, i23, i25));
                    e10 = i19;
                    i16 = i18;
                }
                b10.close();
                k0Var.g();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                b10.close();
                k0Var.g();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            k0Var = c10;
            b10.close();
            k0Var.g();
            throw th;
        }
    }

    public int l() {
        this.f15106a.d();
        t1.m b10 = this.f15117l.b();
        this.f15106a.e();
        try {
            int H = b10.H();
            this.f15106a.C();
            return H;
        } finally {
            this.f15106a.j();
            this.f15117l.h(b10);
        }
    }

    public int m(String str, long j10) {
        this.f15106a.d();
        t1.m b10 = this.f15116k.b();
        b10.f1(1, j10);
        if (str == null) {
            b10.B1(2);
        } else {
            b10.P0(2, str);
        }
        this.f15106a.e();
        try {
            int H = b10.H();
            this.f15106a.C();
            return H;
        } finally {
            this.f15106a.j();
            this.f15116k.h(b10);
        }
    }

    public List<u.b> n(String str) {
        String str2;
        k0 c10 = k0.c("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        this.f15106a.d();
        Cursor b10 = q1.b.b(this.f15106a, c10, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                if (b10.isNull(0)) {
                    str2 = null;
                } else {
                    str2 = b10.getString(0);
                }
                arrayList.add(new u.b(str2, b0.f(b10.getInt(1))));
            }
            return arrayList;
        } finally {
            b10.close();
            c10.g();
        }
    }

    public List<u> o(int i10) {
        k0 k0Var;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2;
        boolean z10;
        int i11;
        boolean z11;
        int i12;
        boolean z12;
        int i13;
        boolean z13;
        int i14;
        boolean z14;
        int i15;
        byte[] bArr3;
        k0 c10 = k0.c("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        c10.f1(1, (long) i10);
        this.f15106a.d();
        Cursor b10 = q1.b.b(this.f15106a, c10, false, (CancellationSignal) null);
        try {
            int e10 = q1.a.e(b10, "id");
            int e11 = q1.a.e(b10, "state");
            int e12 = q1.a.e(b10, "worker_class_name");
            int e13 = q1.a.e(b10, "input_merger_class_name");
            int e14 = q1.a.e(b10, "input");
            int e15 = q1.a.e(b10, "output");
            int e16 = q1.a.e(b10, "initial_delay");
            int e17 = q1.a.e(b10, "interval_duration");
            int e18 = q1.a.e(b10, "flex_duration");
            int e19 = q1.a.e(b10, "run_attempt_count");
            int e20 = q1.a.e(b10, "backoff_policy");
            int e21 = q1.a.e(b10, "backoff_delay_duration");
            int e22 = q1.a.e(b10, "last_enqueue_time");
            int e23 = q1.a.e(b10, "minimum_retention_duration");
            k0Var = c10;
            try {
                int e24 = q1.a.e(b10, "schedule_requested_at");
                int e25 = q1.a.e(b10, "run_in_foreground");
                int e26 = q1.a.e(b10, "out_of_quota_policy");
                int e27 = q1.a.e(b10, "period_count");
                int e28 = q1.a.e(b10, "generation");
                int e29 = q1.a.e(b10, "required_network_type");
                int e30 = q1.a.e(b10, "requires_charging");
                int e31 = q1.a.e(b10, "requires_device_idle");
                int e32 = q1.a.e(b10, "requires_battery_not_low");
                int e33 = q1.a.e(b10, "requires_storage_not_low");
                int e34 = q1.a.e(b10, "trigger_content_update_delay");
                int e35 = q1.a.e(b10, "trigger_max_content_delay");
                int e36 = q1.a.e(b10, "content_uri_triggers");
                int i16 = e23;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(e10)) {
                        str = null;
                    } else {
                        str = b10.getString(e10);
                    }
                    WorkInfo.State f10 = b0.f(b10.getInt(e11));
                    if (b10.isNull(e12)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(e12);
                    }
                    if (b10.isNull(e13)) {
                        str3 = null;
                    } else {
                        str3 = b10.getString(e13);
                    }
                    if (b10.isNull(e14)) {
                        bArr = null;
                    } else {
                        bArr = b10.getBlob(e14);
                    }
                    androidx.work.b g10 = androidx.work.b.g(bArr);
                    if (b10.isNull(e15)) {
                        bArr2 = null;
                    } else {
                        bArr2 = b10.getBlob(e15);
                    }
                    androidx.work.b g11 = androidx.work.b.g(bArr2);
                    long j10 = b10.getLong(e16);
                    long j11 = b10.getLong(e17);
                    long j12 = b10.getLong(e18);
                    int i17 = b10.getInt(e19);
                    BackoffPolicy c11 = b0.c(b10.getInt(e20));
                    long j13 = b10.getLong(e21);
                    long j14 = b10.getLong(e22);
                    int i18 = i16;
                    long j15 = b10.getLong(i18);
                    int i19 = e10;
                    int i20 = e24;
                    long j16 = b10.getLong(i20);
                    e24 = i20;
                    int i21 = e25;
                    if (b10.getInt(i21) != 0) {
                        e25 = i21;
                        i11 = e26;
                        z10 = true;
                    } else {
                        e25 = i21;
                        i11 = e26;
                        z10 = false;
                    }
                    OutOfQuotaPolicy e37 = b0.e(b10.getInt(i11));
                    e26 = i11;
                    int i22 = e27;
                    int i23 = b10.getInt(i22);
                    e27 = i22;
                    int i24 = e28;
                    int i25 = b10.getInt(i24);
                    e28 = i24;
                    int i26 = e29;
                    NetworkType d10 = b0.d(b10.getInt(i26));
                    e29 = i26;
                    int i27 = e30;
                    if (b10.getInt(i27) != 0) {
                        e30 = i27;
                        i12 = e31;
                        z11 = true;
                    } else {
                        e30 = i27;
                        i12 = e31;
                        z11 = false;
                    }
                    if (b10.getInt(i12) != 0) {
                        e31 = i12;
                        i13 = e32;
                        z12 = true;
                    } else {
                        e31 = i12;
                        i13 = e32;
                        z12 = false;
                    }
                    if (b10.getInt(i13) != 0) {
                        e32 = i13;
                        i14 = e33;
                        z13 = true;
                    } else {
                        e32 = i13;
                        i14 = e33;
                        z13 = false;
                    }
                    if (b10.getInt(i14) != 0) {
                        e33 = i14;
                        i15 = e34;
                        z14 = true;
                    } else {
                        e33 = i14;
                        i15 = e34;
                        z14 = false;
                    }
                    long j17 = b10.getLong(i15);
                    e34 = i15;
                    int i28 = e35;
                    long j18 = b10.getLong(i28);
                    e35 = i28;
                    int i29 = e36;
                    if (b10.isNull(i29)) {
                        bArr3 = null;
                    } else {
                        bArr3 = b10.getBlob(i29);
                    }
                    e36 = i29;
                    arrayList.add(new u(str, f10, str2, str3, g10, g11, j10, j11, j12, new b2.a(d10, z11, z12, z13, z14, j17, j18, b0.b(bArr3)), i17, c11, j13, j14, j15, j16, z10, e37, i23, i25));
                    e10 = i19;
                    i16 = i18;
                }
                b10.close();
                k0Var.g();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                b10.close();
                k0Var.g();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            k0Var = c10;
            b10.close();
            k0Var.g();
            throw th;
        }
    }

    public int p(WorkInfo.State state, String str) {
        this.f15106a.d();
        t1.m b10 = this.f15110e.b();
        b10.f1(1, (long) b0.j(state));
        if (str == null) {
            b10.B1(2);
        } else {
            b10.P0(2, str);
        }
        this.f15106a.e();
        try {
            int H = b10.H();
            this.f15106a.C();
            return H;
        } finally {
            this.f15106a.j();
            this.f15110e.h(b10);
        }
    }

    public void q(String str, androidx.work.b bVar) {
        this.f15106a.d();
        t1.m b10 = this.f15112g.b();
        byte[] k10 = androidx.work.b.k(bVar);
        if (k10 == null) {
            b10.B1(1);
        } else {
            b10.l1(1, k10);
        }
        if (str == null) {
            b10.B1(2);
        } else {
            b10.P0(2, str);
        }
        this.f15106a.e();
        try {
            b10.H();
            this.f15106a.C();
        } finally {
            this.f15106a.j();
            this.f15112g.h(b10);
        }
    }

    public List<u> r() {
        k0 k0Var;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2;
        boolean z10;
        int i10;
        boolean z11;
        int i11;
        boolean z12;
        int i12;
        boolean z13;
        int i13;
        boolean z14;
        int i14;
        byte[] bArr3;
        k0 c10 = k0.c("SELECT * FROM workspec WHERE state=1", 0);
        this.f15106a.d();
        Cursor b10 = q1.b.b(this.f15106a, c10, false, (CancellationSignal) null);
        try {
            int e10 = q1.a.e(b10, "id");
            int e11 = q1.a.e(b10, "state");
            int e12 = q1.a.e(b10, "worker_class_name");
            int e13 = q1.a.e(b10, "input_merger_class_name");
            int e14 = q1.a.e(b10, "input");
            int e15 = q1.a.e(b10, "output");
            int e16 = q1.a.e(b10, "initial_delay");
            int e17 = q1.a.e(b10, "interval_duration");
            int e18 = q1.a.e(b10, "flex_duration");
            int e19 = q1.a.e(b10, "run_attempt_count");
            int e20 = q1.a.e(b10, "backoff_policy");
            int e21 = q1.a.e(b10, "backoff_delay_duration");
            int e22 = q1.a.e(b10, "last_enqueue_time");
            int e23 = q1.a.e(b10, "minimum_retention_duration");
            k0Var = c10;
            try {
                int e24 = q1.a.e(b10, "schedule_requested_at");
                int e25 = q1.a.e(b10, "run_in_foreground");
                int e26 = q1.a.e(b10, "out_of_quota_policy");
                int e27 = q1.a.e(b10, "period_count");
                int e28 = q1.a.e(b10, "generation");
                int e29 = q1.a.e(b10, "required_network_type");
                int e30 = q1.a.e(b10, "requires_charging");
                int e31 = q1.a.e(b10, "requires_device_idle");
                int e32 = q1.a.e(b10, "requires_battery_not_low");
                int e33 = q1.a.e(b10, "requires_storage_not_low");
                int e34 = q1.a.e(b10, "trigger_content_update_delay");
                int e35 = q1.a.e(b10, "trigger_max_content_delay");
                int e36 = q1.a.e(b10, "content_uri_triggers");
                int i15 = e23;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(e10)) {
                        str = null;
                    } else {
                        str = b10.getString(e10);
                    }
                    WorkInfo.State f10 = b0.f(b10.getInt(e11));
                    if (b10.isNull(e12)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(e12);
                    }
                    if (b10.isNull(e13)) {
                        str3 = null;
                    } else {
                        str3 = b10.getString(e13);
                    }
                    if (b10.isNull(e14)) {
                        bArr = null;
                    } else {
                        bArr = b10.getBlob(e14);
                    }
                    androidx.work.b g10 = androidx.work.b.g(bArr);
                    if (b10.isNull(e15)) {
                        bArr2 = null;
                    } else {
                        bArr2 = b10.getBlob(e15);
                    }
                    androidx.work.b g11 = androidx.work.b.g(bArr2);
                    long j10 = b10.getLong(e16);
                    long j11 = b10.getLong(e17);
                    long j12 = b10.getLong(e18);
                    int i16 = b10.getInt(e19);
                    BackoffPolicy c11 = b0.c(b10.getInt(e20));
                    long j13 = b10.getLong(e21);
                    long j14 = b10.getLong(e22);
                    int i17 = i15;
                    long j15 = b10.getLong(i17);
                    int i18 = e10;
                    int i19 = e24;
                    long j16 = b10.getLong(i19);
                    e24 = i19;
                    int i20 = e25;
                    if (b10.getInt(i20) != 0) {
                        e25 = i20;
                        i10 = e26;
                        z10 = true;
                    } else {
                        e25 = i20;
                        i10 = e26;
                        z10 = false;
                    }
                    OutOfQuotaPolicy e37 = b0.e(b10.getInt(i10));
                    e26 = i10;
                    int i21 = e27;
                    int i22 = b10.getInt(i21);
                    e27 = i21;
                    int i23 = e28;
                    int i24 = b10.getInt(i23);
                    e28 = i23;
                    int i25 = e29;
                    NetworkType d10 = b0.d(b10.getInt(i25));
                    e29 = i25;
                    int i26 = e30;
                    if (b10.getInt(i26) != 0) {
                        e30 = i26;
                        i11 = e31;
                        z11 = true;
                    } else {
                        e30 = i26;
                        i11 = e31;
                        z11 = false;
                    }
                    if (b10.getInt(i11) != 0) {
                        e31 = i11;
                        i12 = e32;
                        z12 = true;
                    } else {
                        e31 = i11;
                        i12 = e32;
                        z12 = false;
                    }
                    if (b10.getInt(i12) != 0) {
                        e32 = i12;
                        i13 = e33;
                        z13 = true;
                    } else {
                        e32 = i12;
                        i13 = e33;
                        z13 = false;
                    }
                    if (b10.getInt(i13) != 0) {
                        e33 = i13;
                        i14 = e34;
                        z14 = true;
                    } else {
                        e33 = i13;
                        i14 = e34;
                        z14 = false;
                    }
                    long j17 = b10.getLong(i14);
                    e34 = i14;
                    int i27 = e35;
                    long j18 = b10.getLong(i27);
                    e35 = i27;
                    int i28 = e36;
                    if (b10.isNull(i28)) {
                        bArr3 = null;
                    } else {
                        bArr3 = b10.getBlob(i28);
                    }
                    e36 = i28;
                    arrayList.add(new u(str, f10, str2, str3, g10, g11, j10, j11, j12, new b2.a(d10, z11, z12, z13, z14, j17, j18, b0.b(bArr3)), i16, c11, j13, j14, j15, j16, z10, e37, i22, i24));
                    e10 = i18;
                    i15 = i17;
                }
                b10.close();
                k0Var.g();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                b10.close();
                k0Var.g();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            k0Var = c10;
            b10.close();
            k0Var.g();
            throw th;
        }
    }

    public boolean s() {
        boolean z10 = false;
        k0 c10 = k0.c("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.f15106a.d();
        Cursor b10 = q1.b.b(this.f15106a, c10, false, (CancellationSignal) null);
        try {
            if (b10.moveToFirst() && b10.getInt(0) != 0) {
                z10 = true;
            }
            return z10;
        } finally {
            b10.close();
            c10.g();
        }
    }

    public int t(String str) {
        this.f15106a.d();
        t1.m b10 = this.f15115j.b();
        if (str == null) {
            b10.B1(1);
        } else {
            b10.P0(1, str);
        }
        this.f15106a.e();
        try {
            int H = b10.H();
            this.f15106a.C();
            return H;
        } finally {
            this.f15106a.j();
            this.f15115j.h(b10);
        }
    }

    public int u(String str) {
        this.f15106a.d();
        t1.m b10 = this.f15114i.b();
        if (str == null) {
            b10.B1(1);
        } else {
            b10.P0(1, str);
        }
        this.f15106a.e();
        try {
            int H = b10.H();
            this.f15106a.C();
            return H;
        } finally {
            this.f15106a.j();
            this.f15114i.h(b10);
        }
    }
}

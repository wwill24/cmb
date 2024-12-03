package g2;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.h;
import java.util.Collections;
import java.util.List;
import t1.m;

public final class s implements r {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f15067a;

    /* renamed from: b  reason: collision with root package name */
    private final h<q> f15068b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f15069c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f15070d;

    class a extends h<q> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, q qVar) {
            if (qVar.b() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, qVar.b());
            }
            byte[] k10 = androidx.work.b.k(qVar.a());
            if (k10 == null) {
                mVar.B1(2);
            } else {
                mVar.l1(2, k10);
            }
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM WorkProgress";
        }
    }

    public s(RoomDatabase roomDatabase) {
        this.f15067a = roomDatabase;
        this.f15068b = new a(roomDatabase);
        this.f15069c = new b(roomDatabase);
        this.f15070d = new c(roomDatabase);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    public void a(String str) {
        this.f15067a.d();
        m b10 = this.f15069c.b();
        if (str == null) {
            b10.B1(1);
        } else {
            b10.P0(1, str);
        }
        this.f15067a.e();
        try {
            b10.H();
            this.f15067a.C();
        } finally {
            this.f15067a.j();
            this.f15069c.h(b10);
        }
    }

    public void b() {
        this.f15067a.d();
        m b10 = this.f15070d.b();
        this.f15067a.e();
        try {
            b10.H();
            this.f15067a.C();
        } finally {
            this.f15067a.j();
            this.f15070d.h(b10);
        }
    }
}

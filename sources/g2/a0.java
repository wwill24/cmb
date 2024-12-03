package g2;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.h;
import androidx.room.k0;
import g2.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import t1.m;

public final class a0 implements z {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f15030a;

    /* renamed from: b  reason: collision with root package name */
    private final h<y> f15031b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f15032c;

    class a extends h<y> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, y yVar) {
            if (yVar.a() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, yVar.a());
            }
            if (yVar.b() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, yVar.b());
            }
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM worktag WHERE work_spec_id=?";
        }
    }

    public a0(RoomDatabase roomDatabase) {
        this.f15030a = roomDatabase;
        this.f15031b = new a(roomDatabase);
        this.f15032c = new b(roomDatabase);
    }

    public static List<Class<?>> d() {
        return Collections.emptyList();
    }

    public List<String> a(String str) {
        String str2;
        k0 c10 = k0.c("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        this.f15030a.d();
        Cursor b10 = q1.b.b(this.f15030a, c10, false, (CancellationSignal) null);
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

    public void b(y yVar) {
        this.f15030a.d();
        this.f15030a.e();
        try {
            this.f15031b.k(yVar);
            this.f15030a.C();
        } finally {
            this.f15030a.j();
        }
    }

    public void c(String str, Set<String> set) {
        z.a.a(this, str, set);
    }
}

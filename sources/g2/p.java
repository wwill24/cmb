package g2;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.h;
import androidx.room.k0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import q1.b;
import t1.m;

public final class p implements o {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f15062a;

    /* renamed from: b  reason: collision with root package name */
    private final h<n> f15063b;

    class a extends h<n> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, n nVar) {
            if (nVar.a() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, nVar.a());
            }
            if (nVar.b() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, nVar.b());
            }
        }
    }

    public p(RoomDatabase roomDatabase) {
        this.f15062a = roomDatabase;
        this.f15063b = new a(roomDatabase);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    public void a(n nVar) {
        this.f15062a.d();
        this.f15062a.e();
        try {
            this.f15063b.k(nVar);
            this.f15062a.C();
        } finally {
            this.f15062a.j();
        }
    }

    public List<String> b(String str) {
        String str2;
        k0 c10 = k0.c("SELECT name FROM workname WHERE work_spec_id=?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        this.f15062a.d();
        Cursor b10 = b.b(this.f15062a, c10, false, (CancellationSignal) null);
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
}

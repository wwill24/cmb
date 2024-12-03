package g2;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.h;
import androidx.room.k0;
import java.util.Collections;
import java.util.List;
import q1.b;
import t1.m;

public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f15045a;

    /* renamed from: b  reason: collision with root package name */
    private final h<d> f15046b;

    class a extends h<d> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, d dVar) {
            if (dVar.a() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, dVar.a());
            }
            if (dVar.b() == null) {
                mVar.B1(2);
            } else {
                mVar.f1(2, dVar.b().longValue());
            }
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.f15045a = roomDatabase;
        this.f15046b = new a(roomDatabase);
    }

    public static List<Class<?>> c() {
        return Collections.emptyList();
    }

    public void a(d dVar) {
        this.f15045a.d();
        this.f15045a.e();
        try {
            this.f15046b.k(dVar);
            this.f15045a.C();
        } finally {
            this.f15045a.j();
        }
    }

    public Long b(String str) {
        k0 c10 = k0.c("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        this.f15045a.d();
        Long l10 = null;
        Cursor b10 = b.b(this.f15045a, c10, false, (CancellationSignal) null);
        try {
            if (b10.moveToFirst()) {
                if (!b10.isNull(0)) {
                    l10 = Long.valueOf(b10.getLong(0));
                }
            }
            return l10;
        } finally {
            b10.close();
            c10.g();
        }
    }
}

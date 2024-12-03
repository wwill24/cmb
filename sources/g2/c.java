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

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f15040a;

    /* renamed from: b  reason: collision with root package name */
    private final h<a> f15041b;

    class a extends h<a> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, a aVar) {
            if (aVar.b() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, aVar.b());
            }
            if (aVar.a() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, aVar.a());
            }
        }
    }

    public c(RoomDatabase roomDatabase) {
        this.f15040a = roomDatabase;
        this.f15041b = new a(roomDatabase);
    }

    public static List<Class<?>> e() {
        return Collections.emptyList();
    }

    public List<String> a(String str) {
        String str2;
        k0 c10 = k0.c("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        this.f15040a.d();
        Cursor b10 = b.b(this.f15040a, c10, false, (CancellationSignal) null);
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

    public void b(a aVar) {
        this.f15040a.d();
        this.f15040a.e();
        try {
            this.f15041b.k(aVar);
            this.f15040a.C();
        } finally {
            this.f15040a.j();
        }
    }

    public boolean c(String str) {
        boolean z10 = true;
        k0 c10 = k0.c("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        this.f15040a.d();
        boolean z11 = false;
        Cursor b10 = b.b(this.f15040a, c10, false, (CancellationSignal) null);
        try {
            if (b10.moveToFirst()) {
                if (b10.getInt(0) == 0) {
                    z10 = false;
                }
                z11 = z10;
            }
            return z11;
        } finally {
            b10.close();
            c10.g();
        }
    }

    public boolean d(String str) {
        boolean z10 = true;
        k0 c10 = k0.c("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        this.f15040a.d();
        boolean z11 = false;
        Cursor b10 = b.b(this.f15040a, c10, false, (CancellationSignal) null);
        try {
            if (b10.moveToFirst()) {
                if (b10.getInt(0) == 0) {
                    z10 = false;
                }
                z11 = z10;
            }
            return z11;
        } finally {
            b10.close();
            c10.g();
        }
    }
}

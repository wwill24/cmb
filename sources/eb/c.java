package eb;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.g;
import androidx.room.h;
import androidx.room.k0;
import androidx.room.l0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import t1.m;

public final class c extends b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f40655a;

    /* renamed from: b  reason: collision with root package name */
    private final h<d> f40656b;

    /* renamed from: c  reason: collision with root package name */
    private final h<d> f40657c;

    /* renamed from: d  reason: collision with root package name */
    private final g<d> f40658d;

    /* renamed from: e  reason: collision with root package name */
    private final g<d> f40659e;

    class a implements Callable<List<d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f40660a;

        a(k0 k0Var) {
            this.f40660a = k0Var;
        }

        /* renamed from: a */
        public List<d> call() throws Exception {
            String str;
            Cursor b10 = q1.b.b(c.this.f40655a, this.f40660a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "id");
                int e11 = q1.a.e(b10, "name");
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    int i10 = b10.getInt(e10);
                    if (b10.isNull(e11)) {
                        str = null;
                    } else {
                        str = b10.getString(e11);
                    }
                    arrayList.add(new d(i10, str));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f40660a.g();
        }
    }

    class b extends h<d> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `schools` (`id`,`name`) VALUES (nullif(?, 0),?)";
        }

        /* renamed from: n */
        public void i(m mVar, d dVar) {
            mVar.f1(1, (long) dVar.a());
            if (dVar.b() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, dVar.b());
            }
        }
    }

    /* renamed from: eb.c$c  reason: collision with other inner class name */
    class C0487c extends h<d> {
        C0487c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `schools` (`id`,`name`) VALUES (nullif(?, 0),?)";
        }

        /* renamed from: n */
        public void i(m mVar, d dVar) {
            mVar.f1(1, (long) dVar.a());
            if (dVar.b() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, dVar.b());
            }
        }
    }

    class d extends g<d> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `schools` WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, d dVar) {
            mVar.f1(1, (long) dVar.a());
        }
    }

    class e extends g<d> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `schools` SET `id` = ?,`name` = ? WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, d dVar) {
            mVar.f1(1, (long) dVar.a());
            if (dVar.b() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, dVar.b());
            }
            mVar.f1(3, (long) dVar.a());
        }
    }

    public c(RoomDatabase roomDatabase) {
        this.f40655a = roomDatabase;
        this.f40656b = new b(roomDatabase);
        this.f40657c = new C0487c(roomDatabase);
        this.f40658d = new d(roomDatabase);
        this.f40659e = new e(roomDatabase);
    }

    public static List<Class<?>> i() {
        return Collections.emptyList();
    }

    public List<Long> a(List<d> list) {
        this.f40655a.e();
        try {
            List<Long> g10 = super.a(list);
            this.f40655a.C();
            return g10;
        } finally {
            this.f40655a.j();
        }
    }

    public qj.h<List<d>> c() {
        return l0.a(this.f40655a, false, new String[]{"schools"}, new a(k0.c("SELECT * FROM schools", 0)));
    }

    public List<Long> s(List<? extends d> list) {
        this.f40655a.d();
        this.f40655a.e();
        try {
            List<Long> m10 = this.f40656b.m(list);
            this.f40655a.C();
            return m10;
        } finally {
            this.f40655a.j();
        }
    }
}

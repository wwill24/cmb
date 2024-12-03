package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.g;
import androidx.room.h;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.entities.CapabilityEntity;
import com.coffeemeetsbagel.models.entities.CapabilityType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import t1.m;

public final class q extends CapabilityRoomDao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11854a;

    /* renamed from: b  reason: collision with root package name */
    private final h<CapabilityEntity> f11855b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final g6.a f11856c = new g6.a();

    /* renamed from: d  reason: collision with root package name */
    private final h<CapabilityEntity> f11857d;

    /* renamed from: e  reason: collision with root package name */
    private final g<CapabilityEntity> f11858e;

    /* renamed from: f  reason: collision with root package name */
    private final g<CapabilityEntity> f11859f;

    class a implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11860a;

        a(k0 k0Var) {
            this.f11860a = k0Var;
        }

        /* renamed from: a */
        public Boolean call() throws Exception {
            Integer num;
            boolean z10 = false;
            Boolean bool = null;
            Cursor b10 = q1.b.b(q.this.f11854a, this.f11860a, false, (CancellationSignal) null);
            try {
                if (b10.moveToFirst()) {
                    if (b10.isNull(0)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(0));
                    }
                    if (num != null) {
                        if (num.intValue() != 0) {
                            z10 = true;
                        }
                        bool = Boolean.valueOf(z10);
                    }
                }
                return bool;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11860a.g();
        }
    }

    class b implements Callable<List<CapabilityEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11862a;

        b(k0 k0Var) {
            this.f11862a = k0Var;
        }

        /* renamed from: a */
        public List<CapabilityEntity> call() throws Exception {
            String str;
            boolean z10;
            Cursor b10 = q1.b.b(q.this.f11854a, this.f11862a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "capability");
                int e11 = q1.a.e(b10, StreamManagement.Enabled.ELEMENT);
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(e10)) {
                        str = null;
                    } else {
                        str = b10.getString(e10);
                    }
                    CapabilityType b11 = q.this.f11856c.b(str);
                    if (b10.getInt(e11) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    arrayList.add(new CapabilityEntity(b11, z10));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11862a.g();
        }
    }

    class c extends h<CapabilityEntity> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `capability` (`capability`,`enabled`) VALUES (?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, CapabilityEntity capabilityEntity) {
            String a10 = q.this.f11856c.a(capabilityEntity.getCapability());
            if (a10 == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, a10);
            }
            mVar.f1(2, capabilityEntity.getEnabled() ? 1 : 0);
        }
    }

    class d extends h<CapabilityEntity> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `capability` (`capability`,`enabled`) VALUES (?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, CapabilityEntity capabilityEntity) {
            String a10 = q.this.f11856c.a(capabilityEntity.getCapability());
            if (a10 == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, a10);
            }
            mVar.f1(2, capabilityEntity.getEnabled() ? 1 : 0);
        }
    }

    class e extends g<CapabilityEntity> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `capability` WHERE `capability` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, CapabilityEntity capabilityEntity) {
            String a10 = q.this.f11856c.a(capabilityEntity.getCapability());
            if (a10 == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, a10);
            }
        }
    }

    class f extends g<CapabilityEntity> {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `capability` SET `capability` = ?,`enabled` = ? WHERE `capability` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, CapabilityEntity capabilityEntity) {
            String a10 = q.this.f11856c.a(capabilityEntity.getCapability());
            if (a10 == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, a10);
            }
            mVar.f1(2, capabilityEntity.getEnabled() ? 1 : 0);
            String a11 = q.this.f11856c.a(capabilityEntity.getCapability());
            if (a11 == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, a11);
            }
        }
    }

    public q(RoomDatabase roomDatabase) {
        this.f11854a = roomDatabase;
        this.f11855b = new c(roomDatabase);
        this.f11857d = new d(roomDatabase);
        this.f11858e = new e(roomDatabase);
        this.f11859f = new f(roomDatabase);
    }

    public static List<Class<?>> w() {
        return Collections.emptyList();
    }

    public List<Long> a(List<CapabilityEntity> list) {
        this.f11854a.e();
        try {
            List<Long> v10 = super.a(list);
            this.f11854a.C();
            return v10;
        } finally {
            this.f11854a.j();
        }
    }

    public qj.h<Boolean> j(CapabilityType capabilityType) {
        k0 c10 = k0.c("SELECT enabled from capability WHERE capability = ?", 1);
        String a10 = this.f11856c.a(capabilityType);
        if (a10 == null) {
            c10.B1(1);
        } else {
            c10.P0(1, a10);
        }
        return l0.a(this.f11854a, false, new String[]{"capability"}, new a(c10));
    }

    public qj.h<List<CapabilityEntity>> n() {
        return l0.a(this.f11854a, false, new String[]{"capability"}, new b(k0.c("SELECT * from capability", 0)));
    }

    public List<Long> p(List<? extends CapabilityEntity> list) {
        this.f11854a.d();
        this.f11854a.e();
        try {
            List<Long> m10 = this.f11857d.m(list);
            this.f11854a.C();
            return m10;
        } finally {
            this.f11854a.j();
        }
    }
}

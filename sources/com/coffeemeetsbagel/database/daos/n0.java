package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.g;
import androidx.room.h;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.entities.ResourceEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import qj.w;
import t1.m;

public final class n0 extends ResourceRoomDao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11819a;

    /* renamed from: b  reason: collision with root package name */
    private final h<ResourceEntity> f11820b;

    /* renamed from: c  reason: collision with root package name */
    private final h<ResourceEntity> f11821c;

    /* renamed from: d  reason: collision with root package name */
    private final g<ResourceEntity> f11822d;

    /* renamed from: e  reason: collision with root package name */
    private final g<ResourceEntity> f11823e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f11824f;

    class a implements Callable<List<ResourceEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11825a;

        a(k0 k0Var) {
            this.f11825a = k0Var;
        }

        /* renamed from: a */
        public List<ResourceEntity> call() throws Exception {
            String str;
            String str2;
            String str3;
            Cursor b10 = q1.b.b(n0.this.f11819a, this.f11825a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "resource_key");
                int e11 = q1.a.e(b10, "resource_value");
                int e12 = q1.a.e(b10, "resource_list_name");
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(e10)) {
                        str = null;
                    } else {
                        str = b10.getString(e10);
                    }
                    if (b10.isNull(e11)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(e11);
                    }
                    if (b10.isNull(e12)) {
                        str3 = null;
                    } else {
                        str3 = b10.getString(e12);
                    }
                    arrayList.add(new ResourceEntity(str, str2, str3));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11825a.g();
        }
    }

    class b extends h<ResourceEntity> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `resources` (`resource_key`,`resource_value`,`resource_list_name`) VALUES (?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, ResourceEntity resourceEntity) {
            if (resourceEntity.getKey() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, resourceEntity.getKey());
            }
            if (resourceEntity.getValue() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, resourceEntity.getValue());
            }
            if (resourceEntity.getListName() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, resourceEntity.getListName());
            }
        }
    }

    class c extends h<ResourceEntity> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `resources` (`resource_key`,`resource_value`,`resource_list_name`) VALUES (?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, ResourceEntity resourceEntity) {
            if (resourceEntity.getKey() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, resourceEntity.getKey());
            }
            if (resourceEntity.getValue() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, resourceEntity.getValue());
            }
            if (resourceEntity.getListName() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, resourceEntity.getListName());
            }
        }
    }

    class d extends g<ResourceEntity> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `resources` WHERE `resource_key` = ? AND `resource_list_name` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, ResourceEntity resourceEntity) {
            if (resourceEntity.getKey() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, resourceEntity.getKey());
            }
            if (resourceEntity.getListName() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, resourceEntity.getListName());
            }
        }
    }

    class e extends g<ResourceEntity> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `resources` SET `resource_key` = ?,`resource_value` = ?,`resource_list_name` = ? WHERE `resource_key` = ? AND `resource_list_name` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, ResourceEntity resourceEntity) {
            if (resourceEntity.getKey() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, resourceEntity.getKey());
            }
            if (resourceEntity.getValue() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, resourceEntity.getValue());
            }
            if (resourceEntity.getListName() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, resourceEntity.getListName());
            }
            if (resourceEntity.getKey() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, resourceEntity.getKey());
            }
            if (resourceEntity.getListName() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, resourceEntity.getListName());
            }
        }
    }

    class f extends SharedSQLiteStatement {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM resources";
        }
    }

    public n0(RoomDatabase roomDatabase) {
        this.f11819a = roomDatabase;
        this.f11820b = new b(roomDatabase);
        this.f11821c = new c(roomDatabase);
        this.f11822d = new d(roomDatabase);
        this.f11823e = new e(roomDatabase);
        this.f11824f = new f(roomDatabase);
    }

    public static List<Class<?>> u() {
        return Collections.emptyList();
    }

    public List<Long> a(List<Resource> list) {
        this.f11819a.e();
        try {
            List<Long> t10 = super.a(list);
            this.f11819a.C();
            return t10;
        } finally {
            this.f11819a.j();
        }
    }

    public void g() {
        this.f11819a.d();
        m b10 = this.f11824f.b();
        this.f11819a.e();
        try {
            b10.H();
            this.f11819a.C();
        } finally {
            this.f11819a.j();
            this.f11824f.h(b10);
        }
    }

    public w<List<ResourceEntity>> i(String str) {
        k0 c10 = k0.c("SELECT * FROM resources WHERE resource_list_name = ?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.c(new a(c10));
    }

    public List<Long> s(List<? extends ResourceEntity> list) {
        this.f11819a.d();
        this.f11819a.e();
        try {
            List<Long> m10 = this.f11820b.m(list);
            this.f11819a.C();
            return m10;
        } finally {
            this.f11819a.j();
        }
    }
}

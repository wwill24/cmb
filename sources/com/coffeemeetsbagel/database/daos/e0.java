package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.g;
import androidx.room.h;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.entities.PriceEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import qj.w;
import t1.m;

public final class e0 extends d0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11705a;

    /* renamed from: b  reason: collision with root package name */
    private final h<PriceEntity> f11706b;

    /* renamed from: c  reason: collision with root package name */
    private final h<PriceEntity> f11707c;

    /* renamed from: d  reason: collision with root package name */
    private final g<PriceEntity> f11708d;

    /* renamed from: e  reason: collision with root package name */
    private final g<PriceEntity> f11709e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f11710f;

    class a implements Callable<List<PriceEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11711a;

        a(k0 k0Var) {
            this.f11711a = k0Var;
        }

        /* renamed from: a */
        public List<PriceEntity> call() throws Exception {
            String str;
            String str2;
            String str3;
            boolean z10;
            Cursor b10 = q1.b.b(e0.this.f11705a, this.f11711a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "name");
                int e11 = q1.a.e(b10, "beans");
                int e12 = q1.a.e(b10, "free_item_count");
                int e13 = q1.a.e(b10, "image_url");
                int e14 = q1.a.e(b10, "tint_color");
                int e15 = q1.a.e(b10, "is_unlimited");
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(e10)) {
                        str = null;
                    } else {
                        str = b10.getString(e10);
                    }
                    int i10 = b10.getInt(e11);
                    int i11 = b10.getInt(e12);
                    if (b10.isNull(e13)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(e13);
                    }
                    if (b10.isNull(e14)) {
                        str3 = null;
                    } else {
                        str3 = b10.getString(e14);
                    }
                    if (b10.getInt(e15) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    arrayList.add(new PriceEntity(str, i10, i11, str2, str3, z10));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11711a.g();
        }
    }

    class b extends h<PriceEntity> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `prices` (`name`,`beans`,`free_item_count`,`image_url`,`tint_color`,`is_unlimited`) VALUES (?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, PriceEntity priceEntity) {
            if (priceEntity.getName() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, priceEntity.getName());
            }
            mVar.f1(2, (long) priceEntity.getBeans());
            mVar.f1(3, (long) priceEntity.getFreeItemCount());
            if (priceEntity.getImageUrl() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, priceEntity.getImageUrl());
            }
            if (priceEntity.getTintColor() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, priceEntity.getTintColor());
            }
            mVar.f1(6, priceEntity.isUnlimited() ? 1 : 0);
        }
    }

    class c extends h<PriceEntity> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `prices` (`name`,`beans`,`free_item_count`,`image_url`,`tint_color`,`is_unlimited`) VALUES (?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, PriceEntity priceEntity) {
            if (priceEntity.getName() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, priceEntity.getName());
            }
            mVar.f1(2, (long) priceEntity.getBeans());
            mVar.f1(3, (long) priceEntity.getFreeItemCount());
            if (priceEntity.getImageUrl() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, priceEntity.getImageUrl());
            }
            if (priceEntity.getTintColor() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, priceEntity.getTintColor());
            }
            mVar.f1(6, priceEntity.isUnlimited() ? 1 : 0);
        }
    }

    class d extends g<PriceEntity> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `prices` WHERE `name` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, PriceEntity priceEntity) {
            if (priceEntity.getName() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, priceEntity.getName());
            }
        }
    }

    class e extends g<PriceEntity> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `prices` SET `name` = ?,`beans` = ?,`free_item_count` = ?,`image_url` = ?,`tint_color` = ?,`is_unlimited` = ? WHERE `name` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, PriceEntity priceEntity) {
            if (priceEntity.getName() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, priceEntity.getName());
            }
            mVar.f1(2, (long) priceEntity.getBeans());
            mVar.f1(3, (long) priceEntity.getFreeItemCount());
            if (priceEntity.getImageUrl() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, priceEntity.getImageUrl());
            }
            if (priceEntity.getTintColor() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, priceEntity.getTintColor());
            }
            mVar.f1(6, priceEntity.isUnlimited() ? 1 : 0);
            if (priceEntity.getName() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, priceEntity.getName());
            }
        }
    }

    class f extends SharedSQLiteStatement {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM prices";
        }
    }

    public e0(RoomDatabase roomDatabase) {
        this.f11705a = roomDatabase;
        this.f11706b = new b(roomDatabase);
        this.f11707c = new c(roomDatabase);
        this.f11708d = new d(roomDatabase);
        this.f11709e = new e(roomDatabase);
        this.f11710f = new f(roomDatabase);
    }

    public static List<Class<?>> n() {
        return Collections.emptyList();
    }

    public int c(List<PriceEntity> list) {
        this.f11705a.e();
        try {
            int j10 = super.c(list);
            this.f11705a.C();
            return j10;
        } finally {
            this.f11705a.j();
        }
    }

    public int f() {
        this.f11705a.d();
        m b10 = this.f11710f.b();
        this.f11705a.e();
        try {
            int H = b10.H();
            this.f11705a.C();
            return H;
        } finally {
            this.f11705a.j();
            this.f11710f.h(b10);
        }
    }

    public w<List<PriceEntity>> g() {
        return l0.c(new a(k0.c("SELECT * from prices", 0)));
    }

    public List<Long> s(List<? extends PriceEntity> list) {
        this.f11705a.d();
        this.f11705a.e();
        try {
            List<Long> m10 = this.f11706b.m(list);
            this.f11705a.C();
            return m10;
        } finally {
            this.f11705a.j();
        }
    }
}

package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.h;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.entities.ActiveSubscriptionEntity;
import com.coffeemeetsbagel.models.entities.SubscriptionState;
import com.google.firebase.analytics.FirebaseAnalytics;
import g6.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import t1.m;

public final class g extends ActiveSubscriptionRoomDao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11735a;

    /* renamed from: b  reason: collision with root package name */
    private final h<ActiveSubscriptionEntity> f11736b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final g6.d f11737c = new g6.d();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final o f11738d = new o();

    /* renamed from: e  reason: collision with root package name */
    private final h<ActiveSubscriptionEntity> f11739e;

    /* renamed from: f  reason: collision with root package name */
    private final androidx.room.g<ActiveSubscriptionEntity> f11740f;

    /* renamed from: g  reason: collision with root package name */
    private final androidx.room.g<ActiveSubscriptionEntity> f11741g;

    /* renamed from: h  reason: collision with root package name */
    private final SharedSQLiteStatement f11742h;

    class a implements Callable<List<ActiveSubscriptionEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11743a;

        a(k0 k0Var) {
            this.f11743a = k0Var;
        }

        /* renamed from: a */
        public List<ActiveSubscriptionEntity> call() throws Exception {
            boolean z10;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            Cursor b10 = q1.b.b(g.this.f11735a, this.f11743a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "auto_renew");
                int e11 = q1.a.e(b10, "benefits");
                int e12 = q1.a.e(b10, "expiry_date");
                int e13 = q1.a.e(b10, "sku");
                int e14 = q1.a.e(b10, FirebaseAnalytics.Param.START_DATE);
                int e15 = q1.a.e(b10, "bundle_id");
                int e16 = q1.a.e(b10, "subscription_state");
                int e17 = q1.a.e(b10, "tier");
                int e18 = q1.a.e(b10, "purchase_token");
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.getInt(e10) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (b10.isNull(e11)) {
                        str = null;
                    } else {
                        str = b10.getString(e11);
                    }
                    List<String> b11 = g.this.f11737c.b(str);
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
                        str4 = null;
                    } else {
                        str4 = b10.getString(e14);
                    }
                    if (b10.isNull(e15)) {
                        str5 = null;
                    } else {
                        str5 = b10.getString(e15);
                    }
                    SubscriptionState a10 = g.this.f11738d.a(b10.getInt(e16));
                    int i10 = b10.getInt(e17);
                    if (b10.isNull(e18)) {
                        str6 = null;
                    } else {
                        str6 = b10.getString(e18);
                    }
                    arrayList.add(new ActiveSubscriptionEntity(z10, b11, str2, str3, str4, str5, a10, i10, str6));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11743a.g();
        }
    }

    class b implements Callable<List<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11745a;

        b(k0 k0Var) {
            this.f11745a = k0Var;
        }

        /* renamed from: a */
        public List<String> call() throws Exception {
            String str;
            Cursor b10 = q1.b.b(g.this.f11735a, this.f11745a, false, (CancellationSignal) null);
            try {
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(0)) {
                        str = null;
                    } else {
                        str = b10.getString(0);
                    }
                    arrayList.add(str);
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11745a.g();
        }
    }

    class c extends h<ActiveSubscriptionEntity> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `active_subscription` (`auto_renew`,`benefits`,`expiry_date`,`sku`,`start_date`,`bundle_id`,`subscription_state`,`tier`,`purchase_token`) VALUES (?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, ActiveSubscriptionEntity activeSubscriptionEntity) {
            mVar.f1(1, activeSubscriptionEntity.getAutoRenew() ? 1 : 0);
            String a10 = g.this.f11737c.a(activeSubscriptionEntity.getBenefits());
            if (a10 == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, a10);
            }
            if (activeSubscriptionEntity.getExpiryDate() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, activeSubscriptionEntity.getExpiryDate());
            }
            if (activeSubscriptionEntity.getSku() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, activeSubscriptionEntity.getSku());
            }
            if (activeSubscriptionEntity.getStartDate() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, activeSubscriptionEntity.getStartDate());
            }
            if (activeSubscriptionEntity.getBundleId() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, activeSubscriptionEntity.getBundleId());
            }
            mVar.f1(7, (long) g.this.f11738d.b(activeSubscriptionEntity.getSubscriptionState()));
            mVar.f1(8, (long) activeSubscriptionEntity.getTier());
            if (activeSubscriptionEntity.getPurchaseToken() == null) {
                mVar.B1(9);
            } else {
                mVar.P0(9, activeSubscriptionEntity.getPurchaseToken());
            }
        }
    }

    class d extends h<ActiveSubscriptionEntity> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `active_subscription` (`auto_renew`,`benefits`,`expiry_date`,`sku`,`start_date`,`bundle_id`,`subscription_state`,`tier`,`purchase_token`) VALUES (?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, ActiveSubscriptionEntity activeSubscriptionEntity) {
            mVar.f1(1, activeSubscriptionEntity.getAutoRenew() ? 1 : 0);
            String a10 = g.this.f11737c.a(activeSubscriptionEntity.getBenefits());
            if (a10 == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, a10);
            }
            if (activeSubscriptionEntity.getExpiryDate() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, activeSubscriptionEntity.getExpiryDate());
            }
            if (activeSubscriptionEntity.getSku() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, activeSubscriptionEntity.getSku());
            }
            if (activeSubscriptionEntity.getStartDate() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, activeSubscriptionEntity.getStartDate());
            }
            if (activeSubscriptionEntity.getBundleId() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, activeSubscriptionEntity.getBundleId());
            }
            mVar.f1(7, (long) g.this.f11738d.b(activeSubscriptionEntity.getSubscriptionState()));
            mVar.f1(8, (long) activeSubscriptionEntity.getTier());
            if (activeSubscriptionEntity.getPurchaseToken() == null) {
                mVar.B1(9);
            } else {
                mVar.P0(9, activeSubscriptionEntity.getPurchaseToken());
            }
        }
    }

    class e extends androidx.room.g<ActiveSubscriptionEntity> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `active_subscription` WHERE `sku` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, ActiveSubscriptionEntity activeSubscriptionEntity) {
            if (activeSubscriptionEntity.getSku() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, activeSubscriptionEntity.getSku());
            }
        }
    }

    class f extends androidx.room.g<ActiveSubscriptionEntity> {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `active_subscription` SET `auto_renew` = ?,`benefits` = ?,`expiry_date` = ?,`sku` = ?,`start_date` = ?,`bundle_id` = ?,`subscription_state` = ?,`tier` = ?,`purchase_token` = ? WHERE `sku` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, ActiveSubscriptionEntity activeSubscriptionEntity) {
            mVar.f1(1, activeSubscriptionEntity.getAutoRenew() ? 1 : 0);
            String a10 = g.this.f11737c.a(activeSubscriptionEntity.getBenefits());
            if (a10 == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, a10);
            }
            if (activeSubscriptionEntity.getExpiryDate() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, activeSubscriptionEntity.getExpiryDate());
            }
            if (activeSubscriptionEntity.getSku() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, activeSubscriptionEntity.getSku());
            }
            if (activeSubscriptionEntity.getStartDate() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, activeSubscriptionEntity.getStartDate());
            }
            if (activeSubscriptionEntity.getBundleId() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, activeSubscriptionEntity.getBundleId());
            }
            mVar.f1(7, (long) g.this.f11738d.b(activeSubscriptionEntity.getSubscriptionState()));
            mVar.f1(8, (long) activeSubscriptionEntity.getTier());
            if (activeSubscriptionEntity.getPurchaseToken() == null) {
                mVar.B1(9);
            } else {
                mVar.P0(9, activeSubscriptionEntity.getPurchaseToken());
            }
            if (activeSubscriptionEntity.getSku() == null) {
                mVar.B1(10);
            } else {
                mVar.P0(10, activeSubscriptionEntity.getSku());
            }
        }
    }

    /* renamed from: com.coffeemeetsbagel.database.daos.g$g  reason: collision with other inner class name */
    class C0128g extends SharedSQLiteStatement {
        C0128g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM active_subscription";
        }
    }

    public g(RoomDatabase roomDatabase) {
        this.f11735a = roomDatabase;
        this.f11736b = new c(roomDatabase);
        this.f11739e = new d(roomDatabase);
        this.f11740f = new e(roomDatabase);
        this.f11741g = new f(roomDatabase);
        this.f11742h = new C0128g(roomDatabase);
    }

    public static List<Class<?>> B() {
        return Collections.emptyList();
    }

    public int j() {
        this.f11735a.d();
        m b10 = this.f11742h.b();
        this.f11735a.e();
        try {
            int H = b10.H();
            this.f11735a.C();
            return H;
        } finally {
            this.f11735a.j();
            this.f11742h.h(b10);
        }
    }

    public List<Long> s(List<? extends ActiveSubscriptionEntity> list) {
        this.f11735a.d();
        this.f11735a.e();
        try {
            List<Long> m10 = this.f11736b.m(list);
            this.f11735a.C();
            return m10;
        } finally {
            this.f11735a.j();
        }
    }

    public qj.h<List<ActiveSubscriptionEntity>> t() {
        return l0.a(this.f11735a, false, new String[]{"active_subscription"}, new a(k0.c("SELECT * FROM active_subscription", 0)));
    }

    public qj.h<List<String>> u() {
        return l0.a(this.f11735a, false, new String[]{"active_subscription"}, new b(k0.c("SELECT purchase_token FROM active_subscription", 0)));
    }

    public void w(ActiveSubscriptionEntity activeSubscriptionEntity) {
        this.f11735a.e();
        try {
            super.w(activeSubscriptionEntity);
            this.f11735a.C();
        } finally {
            this.f11735a.j();
        }
    }
}

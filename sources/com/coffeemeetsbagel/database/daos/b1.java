package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.h;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.entities.SubscriptionEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import t1.m;

public final class b1 extends a1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11646a;

    /* renamed from: b  reason: collision with root package name */
    private final h<SubscriptionEntity> f11647b;

    /* renamed from: c  reason: collision with root package name */
    private final h<SubscriptionEntity> f11648c;

    /* renamed from: d  reason: collision with root package name */
    private final androidx.room.g<SubscriptionEntity> f11649d;

    /* renamed from: e  reason: collision with root package name */
    private final androidx.room.g<SubscriptionEntity> f11650e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f11651f;

    class a implements Callable<List<SubscriptionEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11652a;

        a(k0 k0Var) {
            this.f11652a = k0Var;
        }

        /* renamed from: a */
        public List<SubscriptionEntity> call() throws Exception {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            Cursor b10 = q1.b.b(b1.this.f11646a, this.f11652a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "bundle_id");
                int e11 = q1.a.e(b10, "marketing_type");
                int e12 = q1.a.e(b10, "number_of_units");
                int e13 = q1.a.e(b10, "unit");
                int e14 = q1.a.e(b10, "savings_comparison_sku");
                int e15 = q1.a.e(b10, "sale_full_price_comparison_sku");
                int e16 = q1.a.e(b10, "sale_sku_type");
                int e17 = q1.a.e(b10, "sale_start_time");
                int e18 = q1.a.e(b10, "sale_end_time");
                int e19 = q1.a.e(b10, "sku");
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
                    int i10 = b10.getInt(e12);
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
                    if (b10.isNull(e16)) {
                        str6 = null;
                    } else {
                        str6 = b10.getString(e16);
                    }
                    long j10 = b10.getLong(e17);
                    long j11 = b10.getLong(e18);
                    if (b10.isNull(e19)) {
                        str7 = null;
                    } else {
                        str7 = b10.getString(e19);
                    }
                    arrayList.add(new SubscriptionEntity(str, str2, i10, str3, str4, str5, str6, j10, j11, str7));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11652a.g();
        }
    }

    class b implements Callable<List<SubscriptionEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11654a;

        b(k0 k0Var) {
            this.f11654a = k0Var;
        }

        /* renamed from: a */
        public List<SubscriptionEntity> call() throws Exception {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            Cursor b10 = q1.b.b(b1.this.f11646a, this.f11654a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "bundle_id");
                int e11 = q1.a.e(b10, "marketing_type");
                int e12 = q1.a.e(b10, "number_of_units");
                int e13 = q1.a.e(b10, "unit");
                int e14 = q1.a.e(b10, "savings_comparison_sku");
                int e15 = q1.a.e(b10, "sale_full_price_comparison_sku");
                int e16 = q1.a.e(b10, "sale_sku_type");
                int e17 = q1.a.e(b10, "sale_start_time");
                int e18 = q1.a.e(b10, "sale_end_time");
                int e19 = q1.a.e(b10, "sku");
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
                    int i10 = b10.getInt(e12);
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
                    if (b10.isNull(e16)) {
                        str6 = null;
                    } else {
                        str6 = b10.getString(e16);
                    }
                    long j10 = b10.getLong(e17);
                    long j11 = b10.getLong(e18);
                    if (b10.isNull(e19)) {
                        str7 = null;
                    } else {
                        str7 = b10.getString(e19);
                    }
                    arrayList.add(new SubscriptionEntity(str, str2, i10, str3, str4, str5, str6, j10, j11, str7));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11654a.g();
        }
    }

    class c extends h<SubscriptionEntity> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `subscription_variants` (`bundle_id`,`marketing_type`,`number_of_units`,`unit`,`savings_comparison_sku`,`sale_full_price_comparison_sku`,`sale_sku_type`,`sale_start_time`,`sale_end_time`,`sku`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, SubscriptionEntity subscriptionEntity) {
            if (subscriptionEntity.getBundleId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, subscriptionEntity.getBundleId());
            }
            if (subscriptionEntity.getMarketingType() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, subscriptionEntity.getMarketingType());
            }
            mVar.f1(3, (long) subscriptionEntity.getNumberOfUnits());
            if (subscriptionEntity.getUnit() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, subscriptionEntity.getUnit());
            }
            if (subscriptionEntity.getSavingsComparisonSku() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, subscriptionEntity.getSavingsComparisonSku());
            }
            if (subscriptionEntity.getSaleComparisonSku() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, subscriptionEntity.getSaleComparisonSku());
            }
            if (subscriptionEntity.getSaleSkuType() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, subscriptionEntity.getSaleSkuType());
            }
            mVar.f1(8, subscriptionEntity.getSaleStartTimeLocal());
            mVar.f1(9, subscriptionEntity.getSaleEndTimeLocal());
            if (subscriptionEntity.getSku() == null) {
                mVar.B1(10);
            } else {
                mVar.P0(10, subscriptionEntity.getSku());
            }
        }
    }

    class d extends h<SubscriptionEntity> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `subscription_variants` (`bundle_id`,`marketing_type`,`number_of_units`,`unit`,`savings_comparison_sku`,`sale_full_price_comparison_sku`,`sale_sku_type`,`sale_start_time`,`sale_end_time`,`sku`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, SubscriptionEntity subscriptionEntity) {
            if (subscriptionEntity.getBundleId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, subscriptionEntity.getBundleId());
            }
            if (subscriptionEntity.getMarketingType() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, subscriptionEntity.getMarketingType());
            }
            mVar.f1(3, (long) subscriptionEntity.getNumberOfUnits());
            if (subscriptionEntity.getUnit() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, subscriptionEntity.getUnit());
            }
            if (subscriptionEntity.getSavingsComparisonSku() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, subscriptionEntity.getSavingsComparisonSku());
            }
            if (subscriptionEntity.getSaleComparisonSku() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, subscriptionEntity.getSaleComparisonSku());
            }
            if (subscriptionEntity.getSaleSkuType() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, subscriptionEntity.getSaleSkuType());
            }
            mVar.f1(8, subscriptionEntity.getSaleStartTimeLocal());
            mVar.f1(9, subscriptionEntity.getSaleEndTimeLocal());
            if (subscriptionEntity.getSku() == null) {
                mVar.B1(10);
            } else {
                mVar.P0(10, subscriptionEntity.getSku());
            }
        }
    }

    class e extends androidx.room.g<SubscriptionEntity> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `subscription_variants` WHERE `sku` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, SubscriptionEntity subscriptionEntity) {
            if (subscriptionEntity.getSku() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, subscriptionEntity.getSku());
            }
        }
    }

    class f extends androidx.room.g<SubscriptionEntity> {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `subscription_variants` SET `bundle_id` = ?,`marketing_type` = ?,`number_of_units` = ?,`unit` = ?,`savings_comparison_sku` = ?,`sale_full_price_comparison_sku` = ?,`sale_sku_type` = ?,`sale_start_time` = ?,`sale_end_time` = ?,`sku` = ? WHERE `sku` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, SubscriptionEntity subscriptionEntity) {
            if (subscriptionEntity.getBundleId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, subscriptionEntity.getBundleId());
            }
            if (subscriptionEntity.getMarketingType() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, subscriptionEntity.getMarketingType());
            }
            mVar.f1(3, (long) subscriptionEntity.getNumberOfUnits());
            if (subscriptionEntity.getUnit() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, subscriptionEntity.getUnit());
            }
            if (subscriptionEntity.getSavingsComparisonSku() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, subscriptionEntity.getSavingsComparisonSku());
            }
            if (subscriptionEntity.getSaleComparisonSku() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, subscriptionEntity.getSaleComparisonSku());
            }
            if (subscriptionEntity.getSaleSkuType() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, subscriptionEntity.getSaleSkuType());
            }
            mVar.f1(8, subscriptionEntity.getSaleStartTimeLocal());
            mVar.f1(9, subscriptionEntity.getSaleEndTimeLocal());
            if (subscriptionEntity.getSku() == null) {
                mVar.B1(10);
            } else {
                mVar.P0(10, subscriptionEntity.getSku());
            }
            if (subscriptionEntity.getSku() == null) {
                mVar.B1(11);
            } else {
                mVar.P0(11, subscriptionEntity.getSku());
            }
        }
    }

    class g extends SharedSQLiteStatement {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM subscription_variants";
        }
    }

    public b1(RoomDatabase roomDatabase) {
        this.f11646a = roomDatabase;
        this.f11647b = new c(roomDatabase);
        this.f11648c = new d(roomDatabase);
        this.f11649d = new e(roomDatabase);
        this.f11650e = new f(roomDatabase);
        this.f11651f = new g(roomDatabase);
    }

    public static List<Class<?>> w() {
        return Collections.emptyList();
    }

    public int g() {
        this.f11646a.d();
        m b10 = this.f11651f.b();
        this.f11646a.e();
        try {
            int H = b10.H();
            this.f11646a.C();
            return H;
        } finally {
            this.f11646a.j();
            this.f11651f.h(b10);
        }
    }

    public void j(List<SubscriptionEntity> list) {
        this.f11646a.e();
        try {
            super.j(list);
            this.f11646a.C();
        } finally {
            this.f11646a.j();
        }
    }

    public qj.h<List<SubscriptionEntity>> n() {
        return l0.a(this.f11646a, false, new String[]{"subscription_variants"}, new b(k0.c("SELECT * from subscription_variants", 0)));
    }

    public List<Long> s(List<? extends SubscriptionEntity> list) {
        this.f11646a.d();
        this.f11646a.e();
        try {
            List<Long> m10 = this.f11647b.m(list);
            this.f11646a.C();
            return m10;
        } finally {
            this.f11646a.j();
        }
    }

    public qj.h<List<SubscriptionEntity>> t(String str) {
        k0 c10 = k0.c("SELECT * from subscription_variants where bundle_id = ?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.a(this.f11646a, false, new String[]{"subscription_variants"}, new a(c10));
    }
}

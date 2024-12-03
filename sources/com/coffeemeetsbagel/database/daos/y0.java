package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.entities.SubscriptionBundleEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import t1.m;

public final class y0 extends SubscriptionBundleRoomDao {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final RoomDatabase f11947b;

    /* renamed from: c  reason: collision with root package name */
    private final androidx.room.h<SubscriptionBundleEntity> f11948c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final g6.d f11949d = new g6.d();

    /* renamed from: e  reason: collision with root package name */
    private final androidx.room.h<SubscriptionBundleEntity> f11950e;

    /* renamed from: f  reason: collision with root package name */
    private final androidx.room.g<SubscriptionBundleEntity> f11951f;

    /* renamed from: g  reason: collision with root package name */
    private final androidx.room.g<SubscriptionBundleEntity> f11952g;

    /* renamed from: h  reason: collision with root package name */
    private final SharedSQLiteStatement f11953h;

    class a implements Callable<List<SubscriptionBundleEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11954a;

        a(k0 k0Var) {
            this.f11954a = k0Var;
        }

        /* renamed from: a */
        public List<SubscriptionBundleEntity> call() throws Exception {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            Cursor b10 = q1.b.b(y0.this.f11947b, this.f11954a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "id");
                int e11 = q1.a.e(b10, "name");
                int e12 = q1.a.e(b10, "tier");
                int e13 = q1.a.e(b10, "intents");
                int e14 = q1.a.e(b10, "benefit_keys");
                int e15 = q1.a.e(b10, "variant_skus");
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
                    List<String> b11 = y0.this.f11949d.b(str3);
                    if (b10.isNull(e14)) {
                        str4 = null;
                    } else {
                        str4 = b10.getString(e14);
                    }
                    List<String> b12 = y0.this.f11949d.b(str4);
                    if (b10.isNull(e15)) {
                        str5 = null;
                    } else {
                        str5 = b10.getString(e15);
                    }
                    arrayList.add(new SubscriptionBundleEntity(str, str2, i10, b11, b12, y0.this.f11949d.b(str5)));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11954a.g();
        }
    }

    class b implements Callable<List<SubscriptionBundleEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11956a;

        b(k0 k0Var) {
            this.f11956a = k0Var;
        }

        /* renamed from: a */
        public List<SubscriptionBundleEntity> call() throws Exception {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            Cursor b10 = q1.b.b(y0.this.f11947b, this.f11956a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "id");
                int e11 = q1.a.e(b10, "name");
                int e12 = q1.a.e(b10, "tier");
                int e13 = q1.a.e(b10, "intents");
                int e14 = q1.a.e(b10, "benefit_keys");
                int e15 = q1.a.e(b10, "variant_skus");
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
                    List<String> b11 = y0.this.f11949d.b(str3);
                    if (b10.isNull(e14)) {
                        str4 = null;
                    } else {
                        str4 = b10.getString(e14);
                    }
                    List<String> b12 = y0.this.f11949d.b(str4);
                    if (b10.isNull(e15)) {
                        str5 = null;
                    } else {
                        str5 = b10.getString(e15);
                    }
                    arrayList.add(new SubscriptionBundleEntity(str, str2, i10, b11, b12, y0.this.f11949d.b(str5)));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11956a.g();
        }
    }

    class c implements Callable<List<SubscriptionBundleEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11958a;

        c(k0 k0Var) {
            this.f11958a = k0Var;
        }

        /* renamed from: a */
        public List<SubscriptionBundleEntity> call() throws Exception {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            Cursor b10 = q1.b.b(y0.this.f11947b, this.f11958a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "id");
                int e11 = q1.a.e(b10, "name");
                int e12 = q1.a.e(b10, "tier");
                int e13 = q1.a.e(b10, "intents");
                int e14 = q1.a.e(b10, "benefit_keys");
                int e15 = q1.a.e(b10, "variant_skus");
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
                    List<String> b11 = y0.this.f11949d.b(str3);
                    if (b10.isNull(e14)) {
                        str4 = null;
                    } else {
                        str4 = b10.getString(e14);
                    }
                    List<String> b12 = y0.this.f11949d.b(str4);
                    if (b10.isNull(e15)) {
                        str5 = null;
                    } else {
                        str5 = b10.getString(e15);
                    }
                    arrayList.add(new SubscriptionBundleEntity(str, str2, i10, b11, b12, y0.this.f11949d.b(str5)));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11958a.g();
        }
    }

    class d implements Callable<List<SubscriptionBundleEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11960a;

        d(k0 k0Var) {
            this.f11960a = k0Var;
        }

        /* renamed from: a */
        public List<SubscriptionBundleEntity> call() throws Exception {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            Cursor b10 = q1.b.b(y0.this.f11947b, this.f11960a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "id");
                int e11 = q1.a.e(b10, "name");
                int e12 = q1.a.e(b10, "tier");
                int e13 = q1.a.e(b10, "intents");
                int e14 = q1.a.e(b10, "benefit_keys");
                int e15 = q1.a.e(b10, "variant_skus");
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
                    List<String> b11 = y0.this.f11949d.b(str3);
                    if (b10.isNull(e14)) {
                        str4 = null;
                    } else {
                        str4 = b10.getString(e14);
                    }
                    List<String> b12 = y0.this.f11949d.b(str4);
                    if (b10.isNull(e15)) {
                        str5 = null;
                    } else {
                        str5 = b10.getString(e15);
                    }
                    arrayList.add(new SubscriptionBundleEntity(str, str2, i10, b11, b12, y0.this.f11949d.b(str5)));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11960a.g();
        }
    }

    class e implements Callable<List<SubscriptionBundleEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11962a;

        e(k0 k0Var) {
            this.f11962a = k0Var;
        }

        /* renamed from: a */
        public List<SubscriptionBundleEntity> call() throws Exception {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            Cursor b10 = q1.b.b(y0.this.f11947b, this.f11962a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "id");
                int e11 = q1.a.e(b10, "name");
                int e12 = q1.a.e(b10, "tier");
                int e13 = q1.a.e(b10, "intents");
                int e14 = q1.a.e(b10, "benefit_keys");
                int e15 = q1.a.e(b10, "variant_skus");
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
                    List<String> b11 = y0.this.f11949d.b(str3);
                    if (b10.isNull(e14)) {
                        str4 = null;
                    } else {
                        str4 = b10.getString(e14);
                    }
                    List<String> b12 = y0.this.f11949d.b(str4);
                    if (b10.isNull(e15)) {
                        str5 = null;
                    } else {
                        str5 = b10.getString(e15);
                    }
                    arrayList.add(new SubscriptionBundleEntity(str, str2, i10, b11, b12, y0.this.f11949d.b(str5)));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11962a.g();
        }
    }

    class f implements Callable<List<Integer>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11964a;

        f(k0 k0Var) {
            this.f11964a = k0Var;
        }

        /* renamed from: a */
        public List<Integer> call() throws Exception {
            Integer num;
            Cursor b10 = q1.b.b(y0.this.f11947b, this.f11964a, false, (CancellationSignal) null);
            try {
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(0)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(0));
                    }
                    arrayList.add(num);
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11964a.g();
        }
    }

    class g extends androidx.room.h<SubscriptionBundleEntity> {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `subscription_bundles` (`id`,`name`,`tier`,`intents`,`benefit_keys`,`variant_skus`) VALUES (?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, SubscriptionBundleEntity subscriptionBundleEntity) {
            if (subscriptionBundleEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, subscriptionBundleEntity.getId());
            }
            if (subscriptionBundleEntity.getName() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, subscriptionBundleEntity.getName());
            }
            mVar.f1(3, (long) subscriptionBundleEntity.getTier());
            String a10 = y0.this.f11949d.a(subscriptionBundleEntity.getIntents());
            if (a10 == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, a10);
            }
            String a11 = y0.this.f11949d.a(subscriptionBundleEntity.getBenefits());
            if (a11 == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, a11);
            }
            String a12 = y0.this.f11949d.a(subscriptionBundleEntity.getVariants());
            if (a12 == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, a12);
            }
        }
    }

    class h extends androidx.room.h<SubscriptionBundleEntity> {
        h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `subscription_bundles` (`id`,`name`,`tier`,`intents`,`benefit_keys`,`variant_skus`) VALUES (?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, SubscriptionBundleEntity subscriptionBundleEntity) {
            if (subscriptionBundleEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, subscriptionBundleEntity.getId());
            }
            if (subscriptionBundleEntity.getName() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, subscriptionBundleEntity.getName());
            }
            mVar.f1(3, (long) subscriptionBundleEntity.getTier());
            String a10 = y0.this.f11949d.a(subscriptionBundleEntity.getIntents());
            if (a10 == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, a10);
            }
            String a11 = y0.this.f11949d.a(subscriptionBundleEntity.getBenefits());
            if (a11 == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, a11);
            }
            String a12 = y0.this.f11949d.a(subscriptionBundleEntity.getVariants());
            if (a12 == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, a12);
            }
        }
    }

    class i extends androidx.room.g<SubscriptionBundleEntity> {
        i(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `subscription_bundles` WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, SubscriptionBundleEntity subscriptionBundleEntity) {
            if (subscriptionBundleEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, subscriptionBundleEntity.getId());
            }
        }
    }

    class j extends androidx.room.g<SubscriptionBundleEntity> {
        j(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `subscription_bundles` SET `id` = ?,`name` = ?,`tier` = ?,`intents` = ?,`benefit_keys` = ?,`variant_skus` = ? WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, SubscriptionBundleEntity subscriptionBundleEntity) {
            if (subscriptionBundleEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, subscriptionBundleEntity.getId());
            }
            if (subscriptionBundleEntity.getName() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, subscriptionBundleEntity.getName());
            }
            mVar.f1(3, (long) subscriptionBundleEntity.getTier());
            String a10 = y0.this.f11949d.a(subscriptionBundleEntity.getIntents());
            if (a10 == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, a10);
            }
            String a11 = y0.this.f11949d.a(subscriptionBundleEntity.getBenefits());
            if (a11 == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, a11);
            }
            String a12 = y0.this.f11949d.a(subscriptionBundleEntity.getVariants());
            if (a12 == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, a12);
            }
            if (subscriptionBundleEntity.getId() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, subscriptionBundleEntity.getId());
            }
        }
    }

    class k extends SharedSQLiteStatement {
        k(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE from subscription_bundles";
        }
    }

    public y0(RoomDatabase roomDatabase) {
        this.f11947b = roomDatabase;
        this.f11948c = new g(roomDatabase);
        this.f11950e = new h(roomDatabase);
        this.f11951f = new i(roomDatabase);
        this.f11952g = new j(roomDatabase);
        this.f11953h = new k(roomDatabase);
    }

    public static List<Class<?>> P() {
        return Collections.emptyList();
    }

    public qj.h<List<SubscriptionBundleEntity>> E(int i10) {
        k0 c10 = k0.c("SELECT * from subscription_bundles WHERE tier = ? ORDER BY tier DESC LIMIT 1", 1);
        c10.f1(1, (long) i10);
        return l0.a(this.f11947b, false, new String[]{"subscription_bundles"}, new a(c10));
    }

    public qj.h<List<SubscriptionBundleEntity>> F(String str) {
        k0 c10 = k0.c("SELECT * from subscription_bundles WHERE id = ? LIMIT 1", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.a(this.f11947b, false, new String[]{"subscription_bundles"}, new d(c10));
    }

    public qj.h<List<SubscriptionBundleEntity>> G(String str) {
        k0 c10 = k0.c("SELECT * from subscription_bundles WHERE intents like ?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.a(this.f11947b, false, new String[]{"subscription_bundles"}, new e(c10));
    }

    public qj.h<List<Integer>> H() {
        return l0.a(this.f11947b, false, new String[]{"subscription_bundles"}, new f(k0.c("SELECT MIN(tier) FROM subscription_bundles", 0)));
    }

    public qj.h<List<SubscriptionBundleEntity>> I(int i10) {
        k0 c10 = k0.c("SELECT * from subscription_bundles WHERE tier < ? ORDER BY tier DESC", 1);
        c10.f1(1, (long) i10);
        return l0.a(this.f11947b, false, new String[]{"subscription_bundles"}, new b(c10));
    }

    public qj.h<List<SubscriptionBundleEntity>> J(String str, int i10) {
        k0 c10 = k0.c("SELECT * from subscription_bundles WHERE intents like lower(?) AND tier < ? ORDER BY tier DESC", 2);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        c10.f1(2, (long) i10);
        return l0.a(this.f11947b, false, new String[]{"subscription_bundles"}, new c(c10));
    }

    public void L(List<SubscriptionBundleEntity> list) {
        this.f11947b.e();
        try {
            super.L(list);
            this.f11947b.C();
        } finally {
            this.f11947b.j();
        }
    }

    public List<Long> s(List<? extends SubscriptionBundleEntity> list) {
        this.f11947b.d();
        this.f11947b.e();
        try {
            List<Long> m10 = this.f11948c.m(list);
            this.f11947b.C();
            return m10;
        } finally {
            this.f11947b.j();
        }
    }

    public int w() {
        this.f11947b.d();
        m b10 = this.f11953h.b();
        this.f11947b.e();
        try {
            int H = b10.H();
            this.f11947b.C();
            return H;
        } finally {
            this.f11947b.j();
            this.f11953h.h(b10);
        }
    }
}

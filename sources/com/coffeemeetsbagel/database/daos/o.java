package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EmptyResultSetException;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.h;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.entities.BenefitEntity;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import qj.w;
import t1.m;

public final class o extends n {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11832a;

    /* renamed from: b  reason: collision with root package name */
    private final h<BenefitEntity> f11833b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final g6.d f11834c = new g6.d();

    /* renamed from: d  reason: collision with root package name */
    private final h<BenefitEntity> f11835d;

    /* renamed from: e  reason: collision with root package name */
    private final androidx.room.g<BenefitEntity> f11836e;

    /* renamed from: f  reason: collision with root package name */
    private final androidx.room.g<BenefitEntity> f11837f;

    /* renamed from: g  reason: collision with root package name */
    private final SharedSQLiteStatement f11838g;

    class a implements Callable<List<BenefitEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11839a;

        a(k0 k0Var) {
            this.f11839a = k0Var;
        }

        /* renamed from: a */
        public List<BenefitEntity> call() throws Exception {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            Cursor b10 = q1.b.b(o.this.f11832a, this.f11839a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, SDKConstants.PARAM_KEY);
                int e11 = q1.a.e(b10, "cached_at");
                int e12 = q1.a.e(b10, "deep_link_tags");
                int e13 = q1.a.e(b10, "description");
                int e14 = q1.a.e(b10, "icon_url");
                int e15 = q1.a.e(b10, "image_url");
                int e16 = q1.a.e(b10, "title");
                int e17 = q1.a.e(b10, "small_title_display");
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(e10)) {
                        str = null;
                    } else {
                        str = b10.getString(e10);
                    }
                    long j10 = b10.getLong(e11);
                    if (b10.isNull(e12)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(e12);
                    }
                    List<String> b11 = o.this.f11834c.b(str2);
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
                    if (b10.isNull(e17)) {
                        str7 = null;
                    } else {
                        str7 = b10.getString(e17);
                    }
                    arrayList.add(new BenefitEntity(str, j10, b11, str3, str4, str5, str6, str7));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11839a.g();
        }
    }

    class b implements Callable<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11841a;

        b(k0 k0Var) {
            this.f11841a = k0Var;
        }

        /* renamed from: a */
        public Long call() throws Exception {
            Long l10 = null;
            Cursor b10 = q1.b.b(o.this.f11832a, this.f11841a, false, (CancellationSignal) null);
            try {
                if (b10.moveToFirst()) {
                    if (!b10.isNull(0)) {
                        l10 = Long.valueOf(b10.getLong(0));
                    }
                }
                if (l10 != null) {
                    return l10;
                }
                throw new EmptyResultSetException("Query returned empty result set: " + this.f11841a.a());
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11841a.g();
        }
    }

    class c extends h<BenefitEntity> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `subscription_benefits` (`key`,`cached_at`,`deep_link_tags`,`description`,`icon_url`,`image_url`,`title`,`small_title_display`) VALUES (?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, BenefitEntity benefitEntity) {
            if (benefitEntity.getKey() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, benefitEntity.getKey());
            }
            mVar.f1(2, benefitEntity.getCachedAt());
            String a10 = o.this.f11834c.a(benefitEntity.getDeepLinkTags());
            if (a10 == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, a10);
            }
            if (benefitEntity.getDescription() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, benefitEntity.getDescription());
            }
            if (benefitEntity.getIconUrl() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, benefitEntity.getIconUrl());
            }
            if (benefitEntity.getImageUrl() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, benefitEntity.getImageUrl());
            }
            if (benefitEntity.getTitle() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, benefitEntity.getTitle());
            }
            if (benefitEntity.getTitleSmallDisplay() == null) {
                mVar.B1(8);
            } else {
                mVar.P0(8, benefitEntity.getTitleSmallDisplay());
            }
        }
    }

    class d extends h<BenefitEntity> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `subscription_benefits` (`key`,`cached_at`,`deep_link_tags`,`description`,`icon_url`,`image_url`,`title`,`small_title_display`) VALUES (?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, BenefitEntity benefitEntity) {
            if (benefitEntity.getKey() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, benefitEntity.getKey());
            }
            mVar.f1(2, benefitEntity.getCachedAt());
            String a10 = o.this.f11834c.a(benefitEntity.getDeepLinkTags());
            if (a10 == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, a10);
            }
            if (benefitEntity.getDescription() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, benefitEntity.getDescription());
            }
            if (benefitEntity.getIconUrl() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, benefitEntity.getIconUrl());
            }
            if (benefitEntity.getImageUrl() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, benefitEntity.getImageUrl());
            }
            if (benefitEntity.getTitle() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, benefitEntity.getTitle());
            }
            if (benefitEntity.getTitleSmallDisplay() == null) {
                mVar.B1(8);
            } else {
                mVar.P0(8, benefitEntity.getTitleSmallDisplay());
            }
        }
    }

    class e extends androidx.room.g<BenefitEntity> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `subscription_benefits` WHERE `key` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, BenefitEntity benefitEntity) {
            if (benefitEntity.getKey() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, benefitEntity.getKey());
            }
        }
    }

    class f extends androidx.room.g<BenefitEntity> {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `subscription_benefits` SET `key` = ?,`cached_at` = ?,`deep_link_tags` = ?,`description` = ?,`icon_url` = ?,`image_url` = ?,`title` = ?,`small_title_display` = ? WHERE `key` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, BenefitEntity benefitEntity) {
            if (benefitEntity.getKey() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, benefitEntity.getKey());
            }
            mVar.f1(2, benefitEntity.getCachedAt());
            String a10 = o.this.f11834c.a(benefitEntity.getDeepLinkTags());
            if (a10 == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, a10);
            }
            if (benefitEntity.getDescription() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, benefitEntity.getDescription());
            }
            if (benefitEntity.getIconUrl() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, benefitEntity.getIconUrl());
            }
            if (benefitEntity.getImageUrl() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, benefitEntity.getImageUrl());
            }
            if (benefitEntity.getTitle() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, benefitEntity.getTitle());
            }
            if (benefitEntity.getTitleSmallDisplay() == null) {
                mVar.B1(8);
            } else {
                mVar.P0(8, benefitEntity.getTitleSmallDisplay());
            }
            if (benefitEntity.getKey() == null) {
                mVar.B1(9);
            } else {
                mVar.P0(9, benefitEntity.getKey());
            }
        }
    }

    class g extends SharedSQLiteStatement {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM subscription_benefits";
        }
    }

    public o(RoomDatabase roomDatabase) {
        this.f11832a = roomDatabase;
        this.f11833b = new c(roomDatabase);
        this.f11835d = new d(roomDatabase);
        this.f11836e = new e(roomDatabase);
        this.f11837f = new f(roomDatabase);
        this.f11838g = new g(roomDatabase);
    }

    public static List<Class<?>> y() {
        return Collections.emptyList();
    }

    public int i() {
        this.f11832a.d();
        m b10 = this.f11838g.b();
        this.f11832a.e();
        try {
            int H = b10.H();
            this.f11832a.C();
            return H;
        } finally {
            this.f11832a.j();
            this.f11838g.h(b10);
        }
    }

    public void n(List<BenefitEntity> list) {
        this.f11832a.e();
        try {
            super.n(list);
            this.f11832a.C();
        } finally {
            this.f11832a.j();
        }
    }

    public List<Long> s(List<? extends BenefitEntity> list) {
        this.f11832a.d();
        this.f11832a.e();
        try {
            List<Long> m10 = this.f11833b.m(list);
            this.f11832a.C();
            return m10;
        } finally {
            this.f11832a.j();
        }
    }

    public qj.h<List<BenefitEntity>> t() {
        return l0.a(this.f11832a, false, new String[]{"subscription_benefits"}, new a(k0.c("SELECT * from subscription_benefits", 0)));
    }

    public w<Long> u() {
        return l0.c(new b(k0.c("SELECT CASE WHEN MIN(cached_at) IS NULL THEN 0 ELSE MIN(cached_at) END  FROM subscription_benefits", 0)));
    }
}

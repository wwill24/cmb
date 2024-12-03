package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.h;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.entities.SuggestedLimitsEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import qj.w;
import t1.m;

public final class d1 extends c1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11688a;

    /* renamed from: b  reason: collision with root package name */
    private final h<SuggestedLimitsEntity> f11689b;

    /* renamed from: c  reason: collision with root package name */
    private final h<SuggestedLimitsEntity> f11690c;

    /* renamed from: d  reason: collision with root package name */
    private final androidx.room.g<SuggestedLimitsEntity> f11691d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final androidx.room.g<SuggestedLimitsEntity> f11692e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f11693f;

    class a implements Callable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SuggestedLimitsEntity f11694a;

        a(SuggestedLimitsEntity suggestedLimitsEntity) {
            this.f11694a = suggestedLimitsEntity;
        }

        /* renamed from: a */
        public Integer call() throws Exception {
            d1.this.f11688a.e();
            try {
                d1.this.f11688a.C();
                return Integer.valueOf(d1.this.f11692e.j(this.f11694a) + 0);
            } finally {
                d1.this.f11688a.j();
            }
        }
    }

    class b implements Callable<List<SuggestedLimitsEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11696a;

        b(k0 k0Var) {
            this.f11696a = k0Var;
        }

        /* renamed from: a */
        public List<SuggestedLimitsEntity> call() throws Exception {
            Integer num;
            Integer num2;
            Integer num3;
            Cursor b10 = q1.b.b(d1.this.f11688a, this.f11696a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "id");
                int e11 = q1.a.e(b10, "remaining_likes");
                int e12 = q1.a.e(b10, "remaining_views");
                int e13 = q1.a.e(b10, "num_bagels_required_for_upsell");
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    int i10 = b10.getInt(e10);
                    if (b10.isNull(e11)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(e11));
                    }
                    if (b10.isNull(e12)) {
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(b10.getInt(e12));
                    }
                    if (b10.isNull(e13)) {
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(b10.getInt(e13));
                    }
                    arrayList.add(new SuggestedLimitsEntity(i10, num, num2, num3));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11696a.g();
        }
    }

    class c extends h<SuggestedLimitsEntity> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `suggested_limits` (`id`,`remaining_likes`,`remaining_views`,`num_bagels_required_for_upsell`) VALUES (?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, SuggestedLimitsEntity suggestedLimitsEntity) {
            mVar.f1(1, (long) suggestedLimitsEntity.getId());
            if (suggestedLimitsEntity.getRemainingLikes() == null) {
                mVar.B1(2);
            } else {
                mVar.f1(2, (long) suggestedLimitsEntity.getRemainingLikes().intValue());
            }
            if (suggestedLimitsEntity.getRemainingViews() == null) {
                mVar.B1(3);
            } else {
                mVar.f1(3, (long) suggestedLimitsEntity.getRemainingViews().intValue());
            }
            if (suggestedLimitsEntity.getNumBagelsRequiredForUpsell() == null) {
                mVar.B1(4);
            } else {
                mVar.f1(4, (long) suggestedLimitsEntity.getNumBagelsRequiredForUpsell().intValue());
            }
        }
    }

    class d extends h<SuggestedLimitsEntity> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `suggested_limits` (`id`,`remaining_likes`,`remaining_views`,`num_bagels_required_for_upsell`) VALUES (?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, SuggestedLimitsEntity suggestedLimitsEntity) {
            mVar.f1(1, (long) suggestedLimitsEntity.getId());
            if (suggestedLimitsEntity.getRemainingLikes() == null) {
                mVar.B1(2);
            } else {
                mVar.f1(2, (long) suggestedLimitsEntity.getRemainingLikes().intValue());
            }
            if (suggestedLimitsEntity.getRemainingViews() == null) {
                mVar.B1(3);
            } else {
                mVar.f1(3, (long) suggestedLimitsEntity.getRemainingViews().intValue());
            }
            if (suggestedLimitsEntity.getNumBagelsRequiredForUpsell() == null) {
                mVar.B1(4);
            } else {
                mVar.f1(4, (long) suggestedLimitsEntity.getNumBagelsRequiredForUpsell().intValue());
            }
        }
    }

    class e extends androidx.room.g<SuggestedLimitsEntity> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `suggested_limits` WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, SuggestedLimitsEntity suggestedLimitsEntity) {
            mVar.f1(1, (long) suggestedLimitsEntity.getId());
        }
    }

    class f extends androidx.room.g<SuggestedLimitsEntity> {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `suggested_limits` SET `id` = ?,`remaining_likes` = ?,`remaining_views` = ?,`num_bagels_required_for_upsell` = ? WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, SuggestedLimitsEntity suggestedLimitsEntity) {
            mVar.f1(1, (long) suggestedLimitsEntity.getId());
            if (suggestedLimitsEntity.getRemainingLikes() == null) {
                mVar.B1(2);
            } else {
                mVar.f1(2, (long) suggestedLimitsEntity.getRemainingLikes().intValue());
            }
            if (suggestedLimitsEntity.getRemainingViews() == null) {
                mVar.B1(3);
            } else {
                mVar.f1(3, (long) suggestedLimitsEntity.getRemainingViews().intValue());
            }
            if (suggestedLimitsEntity.getNumBagelsRequiredForUpsell() == null) {
                mVar.B1(4);
            } else {
                mVar.f1(4, (long) suggestedLimitsEntity.getNumBagelsRequiredForUpsell().intValue());
            }
            mVar.f1(5, (long) suggestedLimitsEntity.getId());
        }
    }

    class g extends SharedSQLiteStatement {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE from suggested_limits";
        }
    }

    public d1(RoomDatabase roomDatabase) {
        this.f11688a = roomDatabase;
        this.f11689b = new c(roomDatabase);
        this.f11690c = new d(roomDatabase);
        this.f11691d = new e(roomDatabase);
        this.f11692e = new f(roomDatabase);
        this.f11693f = new g(roomDatabase);
    }

    public static List<Class<?>> u() {
        return Collections.emptyList();
    }

    public long c(SuggestedLimitsEntity suggestedLimitsEntity) {
        this.f11688a.e();
        try {
            long t10 = super.c(suggestedLimitsEntity);
            this.f11688a.C();
            return t10;
        } finally {
            this.f11688a.j();
        }
    }

    public void g() {
        this.f11688a.d();
        m b10 = this.f11693f.b();
        this.f11688a.e();
        try {
            b10.H();
            this.f11688a.C();
        } finally {
            this.f11688a.j();
            this.f11693f.h(b10);
        }
    }

    public qj.h<List<SuggestedLimitsEntity>> i() {
        return l0.a(this.f11688a, false, new String[]{"suggested_limits"}, new b(k0.c("SELECT * FROM suggested_limits LIMIT 1", 0)));
    }

    /* renamed from: v */
    public long d(SuggestedLimitsEntity suggestedLimitsEntity) {
        this.f11688a.d();
        this.f11688a.e();
        try {
            long l10 = this.f11690c.l(suggestedLimitsEntity);
            this.f11688a.C();
            return l10;
        } finally {
            this.f11688a.j();
        }
    }

    /* renamed from: w */
    public w<Integer> b(SuggestedLimitsEntity suggestedLimitsEntity) {
        return w.A(new a(suggestedLimitsEntity));
    }
}

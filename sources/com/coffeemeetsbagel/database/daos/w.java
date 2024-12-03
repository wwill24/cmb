package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.entities.MatchEntity;
import com.coffeemeetsbagel.models.enums.MatchAction;
import com.coffeemeetsbagel.models.enums.MatchType;
import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import j$.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import net.bytebuddy.description.type.TypeDescription;

public final class w extends v {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11913a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.room.h<MatchEntity> f11914b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final g6.f f11915c = new g6.f();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final g6.j f11916d = new g6.j();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final g6.g f11917e = new g6.g();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final g6.k f11918f = new g6.k();

    /* renamed from: g  reason: collision with root package name */
    private final androidx.room.h<MatchEntity> f11919g;

    /* renamed from: h  reason: collision with root package name */
    private final androidx.room.g<MatchEntity> f11920h;

    /* renamed from: i  reason: collision with root package name */
    private final androidx.room.g<MatchEntity> f11921i;

    /* renamed from: j  reason: collision with root package name */
    private final SharedSQLiteStatement f11922j;

    /* renamed from: k  reason: collision with root package name */
    private final SharedSQLiteStatement f11923k;

    /* renamed from: l  reason: collision with root package name */
    private final SharedSQLiteStatement f11924l;

    /* renamed from: m  reason: collision with root package name */
    private final SharedSQLiteStatement f11925m;

    /* renamed from: n  reason: collision with root package name */
    private final SharedSQLiteStatement f11926n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final SharedSQLiteStatement f11927o;

    /* renamed from: p  reason: collision with root package name */
    private final SharedSQLiteStatement f11928p;

    class a extends SharedSQLiteStatement {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE matches SET [is_blocked] = ? WHERE profile_id = ?";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE matches SET [woo_count] = ? WHERE id = ?";
        }
    }

    class c implements Callable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f11931a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f11932b;

        c(boolean z10, String str) {
            this.f11931a = z10;
            this.f11932b = str;
        }

        /* renamed from: a */
        public Integer call() throws Exception {
            t1.m b10 = w.this.f11927o.b();
            b10.f1(1, this.f11931a ? 1 : 0);
            String str = this.f11932b;
            if (str == null) {
                b10.B1(2);
            } else {
                b10.P0(2, str);
            }
            w.this.f11913a.e();
            try {
                Integer valueOf = Integer.valueOf(b10.H());
                w.this.f11913a.C();
                return valueOf;
            } finally {
                w.this.f11913a.j();
                w.this.f11927o.h(b10);
            }
        }
    }

    class d extends androidx.room.h<MatchEntity> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `matches` (`id`,`action`,`end_at`,`is_blocked`,`is_rising`,`like_comment`,`message`,`profile_id`,`rising_count`,`show_order`,`start_at`,`type`,`woo_count`,`woo_seen_count`,`purchase_attribution`,`match_to_me`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(t1.m mVar, MatchEntity matchEntity) {
            if (matchEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, matchEntity.getId());
            }
            mVar.f1(2, (long) w.this.f11915c.b(matchEntity.getAction()));
            String a10 = w.this.f11916d.a(matchEntity.getEndAt());
            if (a10 == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, a10);
            }
            mVar.f1(4, matchEntity.isBlocked() ? 1 : 0);
            mVar.f1(5, matchEntity.isRising() ? 1 : 0);
            if (matchEntity.getLikeComment() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, matchEntity.getLikeComment());
            }
            if (matchEntity.getMessage() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, matchEntity.getMessage());
            }
            if (matchEntity.getProfileId() == null) {
                mVar.B1(8);
            } else {
                mVar.P0(8, matchEntity.getProfileId());
            }
            mVar.f1(9, (long) matchEntity.getRisingCount());
            if (matchEntity.getShowOrder() == null) {
                mVar.B1(10);
            } else {
                mVar.f1(10, (long) matchEntity.getShowOrder().intValue());
            }
            String a11 = w.this.f11916d.a(matchEntity.getStartAt());
            if (a11 == null) {
                mVar.B1(11);
            } else {
                mVar.P0(11, a11);
            }
            String a12 = w.this.f11917e.a(matchEntity.getType());
            if (a12 == null) {
                mVar.B1(12);
            } else {
                mVar.P0(12, a12);
            }
            mVar.f1(13, (long) matchEntity.getWooCount());
            mVar.f1(14, (long) matchEntity.getWooSeenCount());
            Integer b10 = w.this.f11918f.b(matchEntity.getPurchaseAttribution());
            if (b10 == null) {
                mVar.B1(15);
            } else {
                mVar.f1(15, (long) b10.intValue());
            }
            if (matchEntity.getMatchToMe() == null) {
                mVar.B1(16);
            } else {
                mVar.P0(16, matchEntity.getMatchToMe());
            }
        }
    }

    class e implements Callable<List<MatchEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11935a;

        e(k0 k0Var) {
            this.f11935a = k0Var;
        }

        /* renamed from: a */
        public List<MatchEntity> call() throws Exception {
            String str;
            String str2;
            boolean z10;
            boolean z11;
            String str3;
            String str4;
            String str5;
            Integer num;
            String str6;
            String str7;
            Integer num2;
            String str8;
            Cursor b10 = q1.b.b(w.this.f11913a, this.f11935a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "id");
                int e11 = q1.a.e(b10, "action");
                int e12 = q1.a.e(b10, "end_at");
                int e13 = q1.a.e(b10, "is_blocked");
                int e14 = q1.a.e(b10, "is_rising");
                int e15 = q1.a.e(b10, "like_comment");
                int e16 = q1.a.e(b10, "message");
                int e17 = q1.a.e(b10, Extra.PROFILE_ID);
                int e18 = q1.a.e(b10, "rising_count");
                int e19 = q1.a.e(b10, "show_order");
                int e20 = q1.a.e(b10, "start_at");
                int e21 = q1.a.e(b10, "type");
                int e22 = q1.a.e(b10, "woo_count");
                int e23 = q1.a.e(b10, "woo_seen_count");
                int e24 = q1.a.e(b10, "purchase_attribution");
                int e25 = q1.a.e(b10, "match_to_me");
                int i10 = e22;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(e10)) {
                        str = null;
                    } else {
                        str = b10.getString(e10);
                    }
                    int i11 = e10;
                    MatchAction a10 = w.this.f11915c.a(b10.getInt(e11));
                    if (b10.isNull(e12)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(e12);
                    }
                    OffsetDateTime b11 = w.this.f11916d.b(str2);
                    if (b10.getInt(e13) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (b10.getInt(e14) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (b10.isNull(e15)) {
                        str3 = null;
                    } else {
                        str3 = b10.getString(e15);
                    }
                    if (b10.isNull(e16)) {
                        str4 = null;
                    } else {
                        str4 = b10.getString(e16);
                    }
                    if (b10.isNull(e17)) {
                        str5 = null;
                    } else {
                        str5 = b10.getString(e17);
                    }
                    int i12 = b10.getInt(e18);
                    if (b10.isNull(e19)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(e19));
                    }
                    if (b10.isNull(e20)) {
                        str6 = null;
                    } else {
                        str6 = b10.getString(e20);
                    }
                    OffsetDateTime b12 = w.this.f11916d.b(str6);
                    if (b10.isNull(e21)) {
                        str7 = null;
                    } else {
                        str7 = b10.getString(e21);
                    }
                    MatchType b13 = w.this.f11917e.b(str7);
                    int i13 = i10;
                    int i14 = b10.getInt(i13);
                    int i15 = e23;
                    int i16 = b10.getInt(i15);
                    i10 = i13;
                    int i17 = e24;
                    if (b10.isNull(i17)) {
                        e24 = i17;
                        e23 = i15;
                        num2 = null;
                    } else {
                        e24 = i17;
                        num2 = Integer.valueOf(b10.getInt(i17));
                        e23 = i15;
                    }
                    PurchaseAttribution a11 = w.this.f11918f.a(num2);
                    int i18 = e25;
                    if (b10.isNull(i18)) {
                        str8 = null;
                    } else {
                        str8 = b10.getString(i18);
                    }
                    arrayList.add(new MatchEntity(str, a10, b11, z10, z11, str4, str3, str5, i12, num, b12, b13, i14, i16, a11, str8));
                    e25 = i18;
                    e10 = i11;
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11935a.g();
        }
    }

    class f extends androidx.room.h<MatchEntity> {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `matches` (`id`,`action`,`end_at`,`is_blocked`,`is_rising`,`like_comment`,`message`,`profile_id`,`rising_count`,`show_order`,`start_at`,`type`,`woo_count`,`woo_seen_count`,`purchase_attribution`,`match_to_me`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(t1.m mVar, MatchEntity matchEntity) {
            if (matchEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, matchEntity.getId());
            }
            mVar.f1(2, (long) w.this.f11915c.b(matchEntity.getAction()));
            String a10 = w.this.f11916d.a(matchEntity.getEndAt());
            if (a10 == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, a10);
            }
            mVar.f1(4, matchEntity.isBlocked() ? 1 : 0);
            mVar.f1(5, matchEntity.isRising() ? 1 : 0);
            if (matchEntity.getLikeComment() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, matchEntity.getLikeComment());
            }
            if (matchEntity.getMessage() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, matchEntity.getMessage());
            }
            if (matchEntity.getProfileId() == null) {
                mVar.B1(8);
            } else {
                mVar.P0(8, matchEntity.getProfileId());
            }
            mVar.f1(9, (long) matchEntity.getRisingCount());
            if (matchEntity.getShowOrder() == null) {
                mVar.B1(10);
            } else {
                mVar.f1(10, (long) matchEntity.getShowOrder().intValue());
            }
            String a11 = w.this.f11916d.a(matchEntity.getStartAt());
            if (a11 == null) {
                mVar.B1(11);
            } else {
                mVar.P0(11, a11);
            }
            String a12 = w.this.f11917e.a(matchEntity.getType());
            if (a12 == null) {
                mVar.B1(12);
            } else {
                mVar.P0(12, a12);
            }
            mVar.f1(13, (long) matchEntity.getWooCount());
            mVar.f1(14, (long) matchEntity.getWooSeenCount());
            Integer b10 = w.this.f11918f.b(matchEntity.getPurchaseAttribution());
            if (b10 == null) {
                mVar.B1(15);
            } else {
                mVar.f1(15, (long) b10.intValue());
            }
            if (matchEntity.getMatchToMe() == null) {
                mVar.B1(16);
            } else {
                mVar.P0(16, matchEntity.getMatchToMe());
            }
        }
    }

    class g extends androidx.room.g<MatchEntity> {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `matches` WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(t1.m mVar, MatchEntity matchEntity) {
            if (matchEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, matchEntity.getId());
            }
        }
    }

    class h extends androidx.room.g<MatchEntity> {
        h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `matches` SET `id` = ?,`action` = ?,`end_at` = ?,`is_blocked` = ?,`is_rising` = ?,`like_comment` = ?,`message` = ?,`profile_id` = ?,`rising_count` = ?,`show_order` = ?,`start_at` = ?,`type` = ?,`woo_count` = ?,`woo_seen_count` = ?,`purchase_attribution` = ?,`match_to_me` = ? WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(t1.m mVar, MatchEntity matchEntity) {
            if (matchEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, matchEntity.getId());
            }
            mVar.f1(2, (long) w.this.f11915c.b(matchEntity.getAction()));
            String a10 = w.this.f11916d.a(matchEntity.getEndAt());
            if (a10 == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, a10);
            }
            mVar.f1(4, matchEntity.isBlocked() ? 1 : 0);
            mVar.f1(5, matchEntity.isRising() ? 1 : 0);
            if (matchEntity.getLikeComment() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, matchEntity.getLikeComment());
            }
            if (matchEntity.getMessage() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, matchEntity.getMessage());
            }
            if (matchEntity.getProfileId() == null) {
                mVar.B1(8);
            } else {
                mVar.P0(8, matchEntity.getProfileId());
            }
            mVar.f1(9, (long) matchEntity.getRisingCount());
            if (matchEntity.getShowOrder() == null) {
                mVar.B1(10);
            } else {
                mVar.f1(10, (long) matchEntity.getShowOrder().intValue());
            }
            String a11 = w.this.f11916d.a(matchEntity.getStartAt());
            if (a11 == null) {
                mVar.B1(11);
            } else {
                mVar.P0(11, a11);
            }
            String a12 = w.this.f11917e.a(matchEntity.getType());
            if (a12 == null) {
                mVar.B1(12);
            } else {
                mVar.P0(12, a12);
            }
            mVar.f1(13, (long) matchEntity.getWooCount());
            mVar.f1(14, (long) matchEntity.getWooSeenCount());
            Integer b10 = w.this.f11918f.b(matchEntity.getPurchaseAttribution());
            if (b10 == null) {
                mVar.B1(15);
            } else {
                mVar.f1(15, (long) b10.intValue());
            }
            if (matchEntity.getMatchToMe() == null) {
                mVar.B1(16);
            } else {
                mVar.P0(16, matchEntity.getMatchToMe());
            }
            if (matchEntity.getId() == null) {
                mVar.B1(17);
            } else {
                mVar.P0(17, matchEntity.getId());
            }
        }
    }

    class i extends SharedSQLiteStatement {
        i(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE from matches WHERE type = ? AND dateTime(end_at) < dateTime(?) AND NOT(is_rising)";
        }
    }

    class j extends SharedSQLiteStatement {
        j(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE matches SET [action] = ? WHERE profile_id = ?";
        }
    }

    class k extends SharedSQLiteStatement {
        k(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE matches SET [like_comment] = ? WHERE id = ?";
        }
    }

    class l extends SharedSQLiteStatement {
        l(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM matches WHERE type = ? AND dateTime(end_at) < dateTime(?)";
        }
    }

    class m extends SharedSQLiteStatement {
        m(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE matches SET [woo_seen_count] = ? WHERE id = ?";
        }
    }

    public w(RoomDatabase roomDatabase) {
        this.f11913a = roomDatabase;
        this.f11914b = new d(roomDatabase);
        this.f11919g = new f(roomDatabase);
        this.f11920h = new g(roomDatabase);
        this.f11921i = new h(roomDatabase);
        this.f11922j = new i(roomDatabase);
        this.f11923k = new j(roomDatabase);
        this.f11924l = new k(roomDatabase);
        this.f11925m = new l(roomDatabase);
        this.f11926n = new m(roomDatabase);
        this.f11927o = new a(roomDatabase);
        this.f11928p = new b(roomDatabase);
    }

    public static List<Class<?>> E() {
        return Collections.emptyList();
    }

    public int k(List<? extends MatchEntity> list) {
        this.f11913a.d();
        this.f11913a.e();
        try {
            int k10 = this.f11921i.k(list) + 0;
            this.f11913a.C();
            return k10;
        } finally {
            this.f11913a.j();
        }
    }

    public qj.h<List<MatchEntity>> n(String str) {
        k0 c10 = k0.c("SELECT * from matches WHERE id = ?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.a(this.f11913a, false, new String[]{"matches"}, new e(c10));
    }

    public int o(List<MatchEntity> list) {
        this.f11913a.e();
        try {
            int D = super.o(list);
            this.f11913a.C();
            return D;
        } finally {
            this.f11913a.j();
        }
    }

    public List<Long> s(List<? extends MatchEntity> list) {
        this.f11913a.d();
        this.f11913a.e();
        try {
            List<Long> m10 = this.f11914b.m(list);
            this.f11913a.C();
            return m10;
        } finally {
            this.f11913a.j();
        }
    }

    public int t(String str, String str2) {
        this.f11913a.d();
        t1.m b10 = this.f11925m.b();
        if (str == null) {
            b10.B1(1);
        } else {
            b10.P0(1, str);
        }
        if (str2 == null) {
            b10.B1(2);
        } else {
            b10.P0(2, str2);
        }
        this.f11913a.e();
        try {
            int H = b10.H();
            this.f11913a.C();
            return H;
        } finally {
            this.f11913a.j();
            this.f11925m.h(b10);
        }
    }

    public int u(String str, OffsetDateTime offsetDateTime, List<String> list) {
        this.f11913a.d();
        StringBuilder b10 = q1.d.b();
        b10.append("UPDATE matches SET [end_at] = ");
        b10.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
        b10.append(" WHERE type = ");
        b10.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
        b10.append(" AND id NOT IN (");
        q1.d.a(b10, list.size());
        b10.append(")");
        t1.m g10 = this.f11913a.g(b10.toString());
        String a10 = this.f11916d.a(offsetDateTime);
        if (a10 == null) {
            g10.B1(1);
        } else {
            g10.P0(1, a10);
        }
        if (str == null) {
            g10.B1(2);
        } else {
            g10.P0(2, str);
        }
        int i10 = 3;
        for (String next : list) {
            if (next == null) {
                g10.B1(i10);
            } else {
                g10.P0(i10, next);
            }
            i10++;
        }
        this.f11913a.e();
        try {
            int H = g10.H();
            this.f11913a.C();
            return H;
        } finally {
            this.f11913a.j();
        }
    }

    public int v(String str, MatchAction matchAction) {
        this.f11913a.d();
        t1.m b10 = this.f11923k.b();
        b10.f1(1, (long) this.f11915c.b(matchAction));
        if (str == null) {
            b10.B1(2);
        } else {
            b10.P0(2, str);
        }
        this.f11913a.e();
        try {
            int H = b10.H();
            this.f11913a.C();
            return H;
        } finally {
            this.f11913a.j();
            this.f11923k.h(b10);
        }
    }

    public qj.w<Integer> w(String str, boolean z10) {
        return qj.w.A(new c(z10, str));
    }
}

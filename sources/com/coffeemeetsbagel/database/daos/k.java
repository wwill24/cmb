package com.coffeemeetsbagel.database.daos;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.g;
import androidx.room.h;
import java.util.Collections;
import java.util.List;
import t1.m;

public final class k extends j {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f11786a;

    /* renamed from: b  reason: collision with root package name */
    private final h<za.b> f11787b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final g6.e f11788c = new g6.e();

    /* renamed from: d  reason: collision with root package name */
    private final h<za.b> f11789d;

    /* renamed from: e  reason: collision with root package name */
    private final g<za.b> f11790e;

    /* renamed from: f  reason: collision with root package name */
    private final g<za.b> f11791f;

    /* renamed from: g  reason: collision with root package name */
    private final SharedSQLiteStatement f11792g;

    class a extends h<za.b> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `answers` (`answer_id`,`option_id`,`profile_id`,`question_id`,`text_value`,`integer_value`,`float_value`,`max_value`,`min_value`,`location`,`is_dealbreaker`,`json_type`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, za.b bVar) {
            Integer num;
            if (bVar.b() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, bVar.b());
            }
            if (bVar.h() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, bVar.h());
            }
            if (bVar.i() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, bVar.i());
            }
            if (bVar.j() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, bVar.j());
            }
            if (bVar.k() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, bVar.k());
            }
            if (bVar.c() == null) {
                mVar.B1(6);
            } else {
                mVar.f1(6, (long) bVar.c().intValue());
            }
            if (bVar.a() == null) {
                mVar.B1(7);
            } else {
                mVar.K(7, (double) bVar.a().floatValue());
            }
            if (bVar.f() == null) {
                mVar.B1(8);
            } else {
                mVar.K(8, (double) bVar.f().floatValue());
            }
            if (bVar.g() == null) {
                mVar.B1(9);
            } else {
                mVar.K(9, (double) bVar.g().floatValue());
            }
            String a10 = k.this.f11788c.a(bVar.e());
            if (a10 == null) {
                mVar.B1(10);
            } else {
                mVar.P0(10, a10);
            }
            if (bVar.l() == null) {
                num = null;
            } else {
                num = Integer.valueOf(bVar.l().booleanValue() ? 1 : 0);
            }
            if (num == null) {
                mVar.B1(11);
            } else {
                mVar.f1(11, (long) num.intValue());
            }
            if (bVar.d() == null) {
                mVar.B1(12);
            } else {
                mVar.P0(12, bVar.d());
            }
        }
    }

    class b extends h<za.b> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `answers` (`answer_id`,`option_id`,`profile_id`,`question_id`,`text_value`,`integer_value`,`float_value`,`max_value`,`min_value`,`location`,`is_dealbreaker`,`json_type`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, za.b bVar) {
            Integer num;
            if (bVar.b() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, bVar.b());
            }
            if (bVar.h() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, bVar.h());
            }
            if (bVar.i() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, bVar.i());
            }
            if (bVar.j() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, bVar.j());
            }
            if (bVar.k() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, bVar.k());
            }
            if (bVar.c() == null) {
                mVar.B1(6);
            } else {
                mVar.f1(6, (long) bVar.c().intValue());
            }
            if (bVar.a() == null) {
                mVar.B1(7);
            } else {
                mVar.K(7, (double) bVar.a().floatValue());
            }
            if (bVar.f() == null) {
                mVar.B1(8);
            } else {
                mVar.K(8, (double) bVar.f().floatValue());
            }
            if (bVar.g() == null) {
                mVar.B1(9);
            } else {
                mVar.K(9, (double) bVar.g().floatValue());
            }
            String a10 = k.this.f11788c.a(bVar.e());
            if (a10 == null) {
                mVar.B1(10);
            } else {
                mVar.P0(10, a10);
            }
            if (bVar.l() == null) {
                num = null;
            } else {
                num = Integer.valueOf(bVar.l().booleanValue() ? 1 : 0);
            }
            if (num == null) {
                mVar.B1(11);
            } else {
                mVar.f1(11, (long) num.intValue());
            }
            if (bVar.d() == null) {
                mVar.B1(12);
            } else {
                mVar.P0(12, bVar.d());
            }
        }
    }

    class c extends g<za.b> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `answers` WHERE `option_id` = ? AND `profile_id` = ? AND `question_id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, za.b bVar) {
            if (bVar.h() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, bVar.h());
            }
            if (bVar.i() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, bVar.i());
            }
            if (bVar.j() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, bVar.j());
            }
        }
    }

    class d extends g<za.b> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `answers` SET `answer_id` = ?,`option_id` = ?,`profile_id` = ?,`question_id` = ?,`text_value` = ?,`integer_value` = ?,`float_value` = ?,`max_value` = ?,`min_value` = ?,`location` = ?,`is_dealbreaker` = ?,`json_type` = ? WHERE `option_id` = ? AND `profile_id` = ? AND `question_id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, za.b bVar) {
            Integer num;
            if (bVar.b() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, bVar.b());
            }
            if (bVar.h() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, bVar.h());
            }
            if (bVar.i() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, bVar.i());
            }
            if (bVar.j() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, bVar.j());
            }
            if (bVar.k() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, bVar.k());
            }
            if (bVar.c() == null) {
                mVar.B1(6);
            } else {
                mVar.f1(6, (long) bVar.c().intValue());
            }
            if (bVar.a() == null) {
                mVar.B1(7);
            } else {
                mVar.K(7, (double) bVar.a().floatValue());
            }
            if (bVar.f() == null) {
                mVar.B1(8);
            } else {
                mVar.K(8, (double) bVar.f().floatValue());
            }
            if (bVar.g() == null) {
                mVar.B1(9);
            } else {
                mVar.K(9, (double) bVar.g().floatValue());
            }
            String a10 = k.this.f11788c.a(bVar.e());
            if (a10 == null) {
                mVar.B1(10);
            } else {
                mVar.P0(10, a10);
            }
            if (bVar.l() == null) {
                num = null;
            } else {
                num = Integer.valueOf(bVar.l().booleanValue() ? 1 : 0);
            }
            if (num == null) {
                mVar.B1(11);
            } else {
                mVar.f1(11, (long) num.intValue());
            }
            if (bVar.d() == null) {
                mVar.B1(12);
            } else {
                mVar.P0(12, bVar.d());
            }
            if (bVar.h() == null) {
                mVar.B1(13);
            } else {
                mVar.P0(13, bVar.h());
            }
            if (bVar.i() == null) {
                mVar.B1(14);
            } else {
                mVar.P0(14, bVar.i());
            }
            if (bVar.j() == null) {
                mVar.B1(15);
            } else {
                mVar.P0(15, bVar.j());
            }
        }
    }

    class e extends SharedSQLiteStatement {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM answers WHERE profile_id = ?";
        }
    }

    public k(RoomDatabase roomDatabase) {
        this.f11786a = roomDatabase;
        this.f11787b = new a(roomDatabase);
        this.f11789d = new b(roomDatabase);
        this.f11790e = new c(roomDatabase);
        this.f11791f = new d(roomDatabase);
        this.f11792g = new e(roomDatabase);
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    public List<Long> a(List<za.b> list) {
        this.f11786a.e();
        try {
            List<Long> f10 = super.a(list);
            this.f11786a.C();
            return f10;
        } finally {
            this.f11786a.j();
        }
    }

    public List<Long> s(List<? extends za.b> list) {
        this.f11786a.d();
        this.f11786a.e();
        try {
            List<Long> m10 = this.f11787b.m(list);
            this.f11786a.C();
            return m10;
        } finally {
            this.f11786a.j();
        }
    }
}

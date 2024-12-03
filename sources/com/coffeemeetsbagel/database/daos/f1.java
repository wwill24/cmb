package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.g;
import androidx.room.h;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.entities.IcebreakersEntity;
import g6.j;
import j$.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import t1.m;

public final class f1 extends e1 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11720a;

    /* renamed from: b  reason: collision with root package name */
    private final h<ja.c> f11721b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final j f11722c = new j();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final g6.d f11723d = new g6.d();

    /* renamed from: e  reason: collision with root package name */
    private final h<ja.c> f11724e;

    /* renamed from: f  reason: collision with root package name */
    private final g<ja.c> f11725f;

    /* renamed from: g  reason: collision with root package name */
    private final g<ja.c> f11726g;

    /* renamed from: h  reason: collision with root package name */
    private final SharedSQLiteStatement f11727h;

    class a implements Callable<ja.c> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11728a;

        a(k0 k0Var) {
            this.f11728a = k0Var;
        }

        /* renamed from: a */
        public ja.c call() throws Exception {
            ja.c cVar;
            String str;
            String str2;
            String str3;
            boolean z10;
            String str4;
            String str5;
            String str6;
            boolean z11;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            int i10;
            boolean z12;
            int i11;
            boolean z13;
            int i12;
            String str12;
            int i13;
            String str13;
            int i14;
            String str14;
            int i15;
            boolean z14;
            int i16;
            Integer num;
            int i17;
            Integer num2;
            int i18;
            String str15;
            int i19;
            String str16;
            int i20;
            String str17;
            int i21;
            Integer num3;
            int i22;
            Integer num4;
            int i23;
            Integer num5;
            int i24;
            Integer num6;
            int i25;
            Integer num7;
            int i26;
            Integer num8;
            int i27;
            String str18;
            String str19;
            String str20;
            Cursor b10 = q1.b.b(f1.this.f11720a, this.f11728a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, Extra.PROFILE_ID);
                int e11 = q1.a.e(b10, "appsFlyerId");
                int e12 = q1.a.e(b10, "emailAddress");
                int e13 = q1.a.e(b10, "is_eligible_for_free_trial");
                int e14 = q1.a.e(b10, "registeredDate");
                int e15 = q1.a.e(b10, "beans");
                int e16 = q1.a.e(b10, "birthDay");
                int e17 = q1.a.e(b10, "matchRegion");
                int e18 = q1.a.e(b10, "onHold");
                int e19 = q1.a.e(b10, "deactivateReason");
                int e20 = q1.a.e(b10, "dateReactivated");
                int e21 = q1.a.e(b10, "location");
                int e22 = q1.a.e(b10, "viewedCoachMarks");
                int e23 = q1.a.e(b10, "referralCode");
                int e24 = q1.a.e(b10, "badgeCount");
                int e25 = q1.a.e(b10, "appLaunchStreak");
                int e26 = q1.a.e(b10, "hasPrioritizedLikes");
                int e27 = q1.a.e(b10, "hasActiveBoost");
                int e28 = q1.a.e(b10, "boostReportId");
                int e29 = q1.a.e(b10, "numRisingBagels");
                int e30 = q1.a.e(b10, "lastName");
                int e31 = q1.a.e(b10, "zipCode");
                int e32 = q1.a.e(b10, "usesMetric");
                int e33 = q1.a.e(b10, "ageFrom");
                int e34 = q1.a.e(b10, "ageTo");
                int e35 = q1.a.e(b10, "ethnicity");
                int e36 = q1.a.e(b10, ProfileConstants.Field.GENDER);
                int e37 = q1.a.e(b10, ProfileConstants.Field.RELIGION);
                int e38 = q1.a.e(b10, "maxDistanceMiles");
                int e39 = q1.a.e(b10, "maxDistanceKm");
                int e40 = q1.a.e(b10, "heightFeetFrom");
                int e41 = q1.a.e(b10, "heightFeetTo");
                int e42 = q1.a.e(b10, "heightInchFrom");
                int e43 = q1.a.e(b10, "heightInchTo");
                int e44 = q1.a.e(b10, "heightCmFrom");
                int e45 = q1.a.e(b10, "heightCmTo");
                int e46 = q1.a.e(b10, "first_icebreaker");
                int e47 = q1.a.e(b10, "second_icebreaker");
                int e48 = q1.a.e(b10, "third_icebreaker");
                if (b10.moveToFirst()) {
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
                    if (b10.getInt(e13) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (b10.isNull(e14)) {
                        str4 = null;
                    } else {
                        str4 = b10.getString(e14);
                    }
                    OffsetDateTime b11 = f1.this.f11722c.b(str4);
                    long j10 = b10.getLong(e15);
                    if (b10.isNull(e16)) {
                        str5 = null;
                    } else {
                        str5 = b10.getString(e16);
                    }
                    OffsetDateTime b12 = f1.this.f11722c.b(str5);
                    if (b10.isNull(e17)) {
                        str6 = null;
                    } else {
                        str6 = b10.getString(e17);
                    }
                    if (b10.getInt(e18) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (b10.isNull(e19)) {
                        str7 = null;
                    } else {
                        str7 = b10.getString(e19);
                    }
                    if (b10.isNull(e20)) {
                        str8 = null;
                    } else {
                        str8 = b10.getString(e20);
                    }
                    OffsetDateTime b13 = f1.this.f11722c.b(str8);
                    if (b10.isNull(e21)) {
                        str9 = null;
                    } else {
                        str9 = b10.getString(e21);
                    }
                    if (b10.isNull(e22)) {
                        str10 = null;
                    } else {
                        str10 = b10.getString(e22);
                    }
                    List<String> b14 = f1.this.f11723d.b(str10);
                    int i28 = e23;
                    if (b10.isNull(i28)) {
                        i10 = e24;
                        str11 = null;
                    } else {
                        str11 = b10.getString(i28);
                        i10 = e24;
                    }
                    int i29 = b10.getInt(i10);
                    int i30 = b10.getInt(e25);
                    if (b10.getInt(e26) != 0) {
                        z12 = true;
                        i11 = e27;
                    } else {
                        i11 = e27;
                        z12 = false;
                    }
                    if (b10.getInt(i11) != 0) {
                        z13 = true;
                        i12 = e28;
                    } else {
                        i12 = e28;
                        z13 = false;
                    }
                    if (b10.isNull(i12)) {
                        i13 = e29;
                        str12 = null;
                    } else {
                        str12 = b10.getString(i12);
                        i13 = e29;
                    }
                    int i31 = b10.getInt(i13);
                    int i32 = e30;
                    if (b10.isNull(i32)) {
                        i14 = e31;
                        str13 = null;
                    } else {
                        str13 = b10.getString(i32);
                        i14 = e31;
                    }
                    if (b10.isNull(i14)) {
                        i15 = e32;
                        str14 = null;
                    } else {
                        str14 = b10.getString(i14);
                        i15 = e32;
                    }
                    if (b10.getInt(i15) != 0) {
                        z14 = true;
                        i16 = e33;
                    } else {
                        i16 = e33;
                        z14 = false;
                    }
                    if (b10.isNull(i16)) {
                        i17 = e34;
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(i16));
                        i17 = e34;
                    }
                    if (b10.isNull(i17)) {
                        i18 = e35;
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(b10.getInt(i17));
                        i18 = e35;
                    }
                    if (b10.isNull(i18)) {
                        i19 = e36;
                        str15 = null;
                    } else {
                        str15 = b10.getString(i18);
                        i19 = e36;
                    }
                    if (b10.isNull(i19)) {
                        i20 = e37;
                        str16 = null;
                    } else {
                        str16 = b10.getString(i19);
                        i20 = e37;
                    }
                    if (b10.isNull(i20)) {
                        i21 = e38;
                        str17 = null;
                    } else {
                        str17 = b10.getString(i20);
                        i21 = e38;
                    }
                    int i33 = b10.getInt(i21);
                    int i34 = b10.getInt(e39);
                    int i35 = e40;
                    if (b10.isNull(i35)) {
                        i22 = e41;
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(b10.getInt(i35));
                        i22 = e41;
                    }
                    if (b10.isNull(i22)) {
                        i23 = e42;
                        num4 = null;
                    } else {
                        num4 = Integer.valueOf(b10.getInt(i22));
                        i23 = e42;
                    }
                    if (b10.isNull(i23)) {
                        i24 = e43;
                        num5 = null;
                    } else {
                        num5 = Integer.valueOf(b10.getInt(i23));
                        i24 = e43;
                    }
                    if (b10.isNull(i24)) {
                        i25 = e44;
                        num6 = null;
                    } else {
                        num6 = Integer.valueOf(b10.getInt(i24));
                        i25 = e44;
                    }
                    if (b10.isNull(i25)) {
                        i26 = e45;
                        num7 = null;
                    } else {
                        num7 = Integer.valueOf(b10.getInt(i25));
                        i26 = e45;
                    }
                    if (b10.isNull(i26)) {
                        num8 = null;
                    } else {
                        num8 = Integer.valueOf(b10.getInt(i26));
                    }
                    ja.a aVar = new ja.a(num, num2, str15, str16, str17, i33, i34, num3, num4, num5, num6, num7, num8);
                    int i36 = e46;
                    if (b10.isNull(i36)) {
                        i27 = e47;
                        str18 = null;
                    } else {
                        str18 = b10.getString(i36);
                        i27 = e47;
                    }
                    if (b10.isNull(i27)) {
                        str19 = null;
                    } else {
                        str19 = b10.getString(i27);
                    }
                    if (b10.isNull(e48)) {
                        str20 = null;
                    } else {
                        str20 = b10.getString(e48);
                    }
                    cVar = new ja.c(str, str2, str3, z10, b11, j10, b12, aVar, str6, z11, str7, b13, str9, b14, str11, new IcebreakersEntity(str18, str19, str20), i29, i30, z12, z13, str12, i31, str13, str14, z14);
                } else {
                    cVar = null;
                }
                return cVar;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11728a.g();
        }
    }

    class b extends h<ja.c> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `user` (`profile_id`,`appsFlyerId`,`emailAddress`,`is_eligible_for_free_trial`,`registeredDate`,`beans`,`birthDay`,`matchRegion`,`onHold`,`deactivateReason`,`dateReactivated`,`location`,`viewedCoachMarks`,`referralCode`,`badgeCount`,`appLaunchStreak`,`hasPrioritizedLikes`,`hasActiveBoost`,`boostReportId`,`numRisingBagels`,`lastName`,`zipCode`,`usesMetric`,`ageFrom`,`ageTo`,`ethnicity`,`gender`,`religion`,`maxDistanceMiles`,`maxDistanceKm`,`heightFeetFrom`,`heightFeetTo`,`heightInchFrom`,`heightInchTo`,`heightCmFrom`,`heightCmTo`,`first_icebreaker`,`second_icebreaker`,`third_icebreaker`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, ja.c cVar) {
            m mVar2 = mVar;
            if (cVar.s() == null) {
                mVar2.B1(1);
            } else {
                mVar2.P0(1, cVar.s());
            }
            if (cVar.b() == null) {
                mVar2.B1(2);
            } else {
                mVar2.P0(2, cVar.b());
            }
            if (cVar.i() == null) {
                mVar2.B1(3);
            } else {
                mVar2.P0(3, cVar.i());
            }
            mVar2.f1(4, cVar.y() ? 1 : 0);
            String a10 = f1.this.f11722c.a(cVar.u());
            if (a10 == null) {
                mVar2.B1(5);
            } else {
                mVar2.P0(5, a10);
            }
            mVar2.f1(6, cVar.d());
            String a11 = f1.this.f11722c.a(cVar.e());
            if (a11 == null) {
                mVar2.B1(7);
            } else {
                mVar2.P0(7, a11);
            }
            if (cVar.p() == null) {
                mVar2.B1(8);
            } else {
                mVar2.P0(8, cVar.p());
            }
            mVar2.f1(9, cVar.r() ? 1 : 0);
            if (cVar.h() == null) {
                mVar2.B1(10);
            } else {
                mVar2.P0(10, cVar.h());
            }
            String a12 = f1.this.f11722c.a(cVar.g());
            if (a12 == null) {
                mVar2.B1(11);
            } else {
                mVar2.P0(11, a12);
            }
            if (cVar.n() == null) {
                mVar2.B1(12);
            } else {
                mVar2.P0(12, cVar.n());
            }
            String a13 = f1.this.f11723d.a(cVar.w());
            if (a13 == null) {
                mVar2.B1(13);
            } else {
                mVar2.P0(13, a13);
            }
            if (cVar.t() == null) {
                mVar2.B1(14);
            } else {
                mVar2.P0(14, cVar.t());
            }
            mVar2.f1(15, (long) cVar.c());
            mVar2.f1(16, (long) cVar.a());
            mVar2.f1(17, cVar.k() ? 1 : 0);
            mVar2.f1(18, cVar.j() ? 1 : 0);
            if (cVar.f() == null) {
                mVar2.B1(19);
            } else {
                mVar2.P0(19, cVar.f());
            }
            mVar2.f1(20, (long) cVar.q());
            if (cVar.m() == null) {
                mVar2.B1(21);
            } else {
                mVar2.P0(21, cVar.m());
            }
            if (cVar.x() == null) {
                mVar2.B1(22);
            } else {
                mVar2.P0(22, cVar.x());
            }
            mVar2.f1(23, cVar.v() ? 1 : 0);
            ja.a o10 = cVar.o();
            if (o10 != null) {
                if (o10.a() == null) {
                    mVar2.B1(24);
                } else {
                    mVar2.f1(24, (long) o10.a().intValue());
                }
                if (o10.b() == null) {
                    mVar2.B1(25);
                } else {
                    mVar2.f1(25, (long) o10.b().intValue());
                }
                if (o10.c() == null) {
                    mVar2.B1(26);
                } else {
                    mVar2.P0(26, o10.c());
                }
                if (o10.d() == null) {
                    mVar2.B1(27);
                } else {
                    mVar2.P0(27, o10.d());
                }
                if (o10.m() == null) {
                    mVar2.B1(28);
                } else {
                    mVar2.P0(28, o10.m());
                }
                mVar2.f1(29, (long) o10.l());
                mVar2.f1(30, (long) o10.k());
                if (o10.g() == null) {
                    mVar2.B1(31);
                } else {
                    mVar2.f1(31, (long) o10.g().intValue());
                }
                if (o10.h() == null) {
                    mVar2.B1(32);
                } else {
                    mVar2.f1(32, (long) o10.h().intValue());
                }
                if (o10.i() == null) {
                    mVar2.B1(33);
                } else {
                    mVar2.f1(33, (long) o10.i().intValue());
                }
                if (o10.j() == null) {
                    mVar2.B1(34);
                } else {
                    mVar2.f1(34, (long) o10.j().intValue());
                }
                if (o10.e() == null) {
                    mVar2.B1(35);
                } else {
                    mVar2.f1(35, (long) o10.e().intValue());
                }
                if (o10.f() == null) {
                    mVar2.B1(36);
                } else {
                    mVar2.f1(36, (long) o10.f().intValue());
                }
            } else {
                mVar2.B1(24);
                mVar2.B1(25);
                mVar2.B1(26);
                mVar2.B1(27);
                mVar2.B1(28);
                mVar2.B1(29);
                mVar2.B1(30);
                mVar2.B1(31);
                mVar2.B1(32);
                mVar2.B1(33);
                mVar2.B1(34);
                mVar2.B1(35);
                mVar2.B1(36);
            }
            IcebreakersEntity l10 = cVar.l();
            if (l10 != null) {
                if (l10.getFirstIcebreaker() == null) {
                    mVar2.B1(37);
                } else {
                    mVar2.P0(37, l10.getFirstIcebreaker());
                }
                if (l10.getSecondIcebreaker() == null) {
                    mVar2.B1(38);
                } else {
                    mVar2.P0(38, l10.getSecondIcebreaker());
                }
                if (l10.getThirdIcebreaker() == null) {
                    mVar2.B1(39);
                } else {
                    mVar2.P0(39, l10.getThirdIcebreaker());
                }
            } else {
                mVar2.B1(37);
                mVar2.B1(38);
                mVar2.B1(39);
            }
        }
    }

    class c extends h<ja.c> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `user` (`profile_id`,`appsFlyerId`,`emailAddress`,`is_eligible_for_free_trial`,`registeredDate`,`beans`,`birthDay`,`matchRegion`,`onHold`,`deactivateReason`,`dateReactivated`,`location`,`viewedCoachMarks`,`referralCode`,`badgeCount`,`appLaunchStreak`,`hasPrioritizedLikes`,`hasActiveBoost`,`boostReportId`,`numRisingBagels`,`lastName`,`zipCode`,`usesMetric`,`ageFrom`,`ageTo`,`ethnicity`,`gender`,`religion`,`maxDistanceMiles`,`maxDistanceKm`,`heightFeetFrom`,`heightFeetTo`,`heightInchFrom`,`heightInchTo`,`heightCmFrom`,`heightCmTo`,`first_icebreaker`,`second_icebreaker`,`third_icebreaker`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, ja.c cVar) {
            m mVar2 = mVar;
            if (cVar.s() == null) {
                mVar2.B1(1);
            } else {
                mVar2.P0(1, cVar.s());
            }
            if (cVar.b() == null) {
                mVar2.B1(2);
            } else {
                mVar2.P0(2, cVar.b());
            }
            if (cVar.i() == null) {
                mVar2.B1(3);
            } else {
                mVar2.P0(3, cVar.i());
            }
            mVar2.f1(4, cVar.y() ? 1 : 0);
            String a10 = f1.this.f11722c.a(cVar.u());
            if (a10 == null) {
                mVar2.B1(5);
            } else {
                mVar2.P0(5, a10);
            }
            mVar2.f1(6, cVar.d());
            String a11 = f1.this.f11722c.a(cVar.e());
            if (a11 == null) {
                mVar2.B1(7);
            } else {
                mVar2.P0(7, a11);
            }
            if (cVar.p() == null) {
                mVar2.B1(8);
            } else {
                mVar2.P0(8, cVar.p());
            }
            mVar2.f1(9, cVar.r() ? 1 : 0);
            if (cVar.h() == null) {
                mVar2.B1(10);
            } else {
                mVar2.P0(10, cVar.h());
            }
            String a12 = f1.this.f11722c.a(cVar.g());
            if (a12 == null) {
                mVar2.B1(11);
            } else {
                mVar2.P0(11, a12);
            }
            if (cVar.n() == null) {
                mVar2.B1(12);
            } else {
                mVar2.P0(12, cVar.n());
            }
            String a13 = f1.this.f11723d.a(cVar.w());
            if (a13 == null) {
                mVar2.B1(13);
            } else {
                mVar2.P0(13, a13);
            }
            if (cVar.t() == null) {
                mVar2.B1(14);
            } else {
                mVar2.P0(14, cVar.t());
            }
            mVar2.f1(15, (long) cVar.c());
            mVar2.f1(16, (long) cVar.a());
            mVar2.f1(17, cVar.k() ? 1 : 0);
            mVar2.f1(18, cVar.j() ? 1 : 0);
            if (cVar.f() == null) {
                mVar2.B1(19);
            } else {
                mVar2.P0(19, cVar.f());
            }
            mVar2.f1(20, (long) cVar.q());
            if (cVar.m() == null) {
                mVar2.B1(21);
            } else {
                mVar2.P0(21, cVar.m());
            }
            if (cVar.x() == null) {
                mVar2.B1(22);
            } else {
                mVar2.P0(22, cVar.x());
            }
            mVar2.f1(23, cVar.v() ? 1 : 0);
            ja.a o10 = cVar.o();
            if (o10 != null) {
                if (o10.a() == null) {
                    mVar2.B1(24);
                } else {
                    mVar2.f1(24, (long) o10.a().intValue());
                }
                if (o10.b() == null) {
                    mVar2.B1(25);
                } else {
                    mVar2.f1(25, (long) o10.b().intValue());
                }
                if (o10.c() == null) {
                    mVar2.B1(26);
                } else {
                    mVar2.P0(26, o10.c());
                }
                if (o10.d() == null) {
                    mVar2.B1(27);
                } else {
                    mVar2.P0(27, o10.d());
                }
                if (o10.m() == null) {
                    mVar2.B1(28);
                } else {
                    mVar2.P0(28, o10.m());
                }
                mVar2.f1(29, (long) o10.l());
                mVar2.f1(30, (long) o10.k());
                if (o10.g() == null) {
                    mVar2.B1(31);
                } else {
                    mVar2.f1(31, (long) o10.g().intValue());
                }
                if (o10.h() == null) {
                    mVar2.B1(32);
                } else {
                    mVar2.f1(32, (long) o10.h().intValue());
                }
                if (o10.i() == null) {
                    mVar2.B1(33);
                } else {
                    mVar2.f1(33, (long) o10.i().intValue());
                }
                if (o10.j() == null) {
                    mVar2.B1(34);
                } else {
                    mVar2.f1(34, (long) o10.j().intValue());
                }
                if (o10.e() == null) {
                    mVar2.B1(35);
                } else {
                    mVar2.f1(35, (long) o10.e().intValue());
                }
                if (o10.f() == null) {
                    mVar2.B1(36);
                } else {
                    mVar2.f1(36, (long) o10.f().intValue());
                }
            } else {
                mVar2.B1(24);
                mVar2.B1(25);
                mVar2.B1(26);
                mVar2.B1(27);
                mVar2.B1(28);
                mVar2.B1(29);
                mVar2.B1(30);
                mVar2.B1(31);
                mVar2.B1(32);
                mVar2.B1(33);
                mVar2.B1(34);
                mVar2.B1(35);
                mVar2.B1(36);
            }
            IcebreakersEntity l10 = cVar.l();
            if (l10 != null) {
                if (l10.getFirstIcebreaker() == null) {
                    mVar2.B1(37);
                } else {
                    mVar2.P0(37, l10.getFirstIcebreaker());
                }
                if (l10.getSecondIcebreaker() == null) {
                    mVar2.B1(38);
                } else {
                    mVar2.P0(38, l10.getSecondIcebreaker());
                }
                if (l10.getThirdIcebreaker() == null) {
                    mVar2.B1(39);
                } else {
                    mVar2.P0(39, l10.getThirdIcebreaker());
                }
            } else {
                mVar2.B1(37);
                mVar2.B1(38);
                mVar2.B1(39);
            }
        }
    }

    class d extends g<ja.c> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `user` WHERE `profile_id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, ja.c cVar) {
            if (cVar.s() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, cVar.s());
            }
        }
    }

    class e extends g<ja.c> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `user` SET `profile_id` = ?,`appsFlyerId` = ?,`emailAddress` = ?,`is_eligible_for_free_trial` = ?,`registeredDate` = ?,`beans` = ?,`birthDay` = ?,`matchRegion` = ?,`onHold` = ?,`deactivateReason` = ?,`dateReactivated` = ?,`location` = ?,`viewedCoachMarks` = ?,`referralCode` = ?,`badgeCount` = ?,`appLaunchStreak` = ?,`hasPrioritizedLikes` = ?,`hasActiveBoost` = ?,`boostReportId` = ?,`numRisingBagels` = ?,`lastName` = ?,`zipCode` = ?,`usesMetric` = ?,`ageFrom` = ?,`ageTo` = ?,`ethnicity` = ?,`gender` = ?,`religion` = ?,`maxDistanceMiles` = ?,`maxDistanceKm` = ?,`heightFeetFrom` = ?,`heightFeetTo` = ?,`heightInchFrom` = ?,`heightInchTo` = ?,`heightCmFrom` = ?,`heightCmTo` = ?,`first_icebreaker` = ?,`second_icebreaker` = ?,`third_icebreaker` = ? WHERE `profile_id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, ja.c cVar) {
            m mVar2 = mVar;
            if (cVar.s() == null) {
                mVar2.B1(1);
            } else {
                mVar2.P0(1, cVar.s());
            }
            if (cVar.b() == null) {
                mVar2.B1(2);
            } else {
                mVar2.P0(2, cVar.b());
            }
            if (cVar.i() == null) {
                mVar2.B1(3);
            } else {
                mVar2.P0(3, cVar.i());
            }
            mVar2.f1(4, cVar.y() ? 1 : 0);
            String a10 = f1.this.f11722c.a(cVar.u());
            if (a10 == null) {
                mVar2.B1(5);
            } else {
                mVar2.P0(5, a10);
            }
            mVar2.f1(6, cVar.d());
            String a11 = f1.this.f11722c.a(cVar.e());
            if (a11 == null) {
                mVar2.B1(7);
            } else {
                mVar2.P0(7, a11);
            }
            if (cVar.p() == null) {
                mVar2.B1(8);
            } else {
                mVar2.P0(8, cVar.p());
            }
            mVar2.f1(9, cVar.r() ? 1 : 0);
            if (cVar.h() == null) {
                mVar2.B1(10);
            } else {
                mVar2.P0(10, cVar.h());
            }
            String a12 = f1.this.f11722c.a(cVar.g());
            if (a12 == null) {
                mVar2.B1(11);
            } else {
                mVar2.P0(11, a12);
            }
            if (cVar.n() == null) {
                mVar2.B1(12);
            } else {
                mVar2.P0(12, cVar.n());
            }
            String a13 = f1.this.f11723d.a(cVar.w());
            if (a13 == null) {
                mVar2.B1(13);
            } else {
                mVar2.P0(13, a13);
            }
            if (cVar.t() == null) {
                mVar2.B1(14);
            } else {
                mVar2.P0(14, cVar.t());
            }
            mVar2.f1(15, (long) cVar.c());
            mVar2.f1(16, (long) cVar.a());
            mVar2.f1(17, cVar.k() ? 1 : 0);
            mVar2.f1(18, cVar.j() ? 1 : 0);
            if (cVar.f() == null) {
                mVar2.B1(19);
            } else {
                mVar2.P0(19, cVar.f());
            }
            mVar2.f1(20, (long) cVar.q());
            if (cVar.m() == null) {
                mVar2.B1(21);
            } else {
                mVar2.P0(21, cVar.m());
            }
            if (cVar.x() == null) {
                mVar2.B1(22);
            } else {
                mVar2.P0(22, cVar.x());
            }
            mVar2.f1(23, cVar.v() ? 1 : 0);
            ja.a o10 = cVar.o();
            if (o10 != null) {
                if (o10.a() == null) {
                    mVar2.B1(24);
                } else {
                    mVar2.f1(24, (long) o10.a().intValue());
                }
                if (o10.b() == null) {
                    mVar2.B1(25);
                } else {
                    mVar2.f1(25, (long) o10.b().intValue());
                }
                if (o10.c() == null) {
                    mVar2.B1(26);
                } else {
                    mVar2.P0(26, o10.c());
                }
                if (o10.d() == null) {
                    mVar2.B1(27);
                } else {
                    mVar2.P0(27, o10.d());
                }
                if (o10.m() == null) {
                    mVar2.B1(28);
                } else {
                    mVar2.P0(28, o10.m());
                }
                mVar2.f1(29, (long) o10.l());
                mVar2.f1(30, (long) o10.k());
                if (o10.g() == null) {
                    mVar2.B1(31);
                } else {
                    mVar2.f1(31, (long) o10.g().intValue());
                }
                if (o10.h() == null) {
                    mVar2.B1(32);
                } else {
                    mVar2.f1(32, (long) o10.h().intValue());
                }
                if (o10.i() == null) {
                    mVar2.B1(33);
                } else {
                    mVar2.f1(33, (long) o10.i().intValue());
                }
                if (o10.j() == null) {
                    mVar2.B1(34);
                } else {
                    mVar2.f1(34, (long) o10.j().intValue());
                }
                if (o10.e() == null) {
                    mVar2.B1(35);
                } else {
                    mVar2.f1(35, (long) o10.e().intValue());
                }
                if (o10.f() == null) {
                    mVar2.B1(36);
                } else {
                    mVar2.f1(36, (long) o10.f().intValue());
                }
            } else {
                mVar2.B1(24);
                mVar2.B1(25);
                mVar2.B1(26);
                mVar2.B1(27);
                mVar2.B1(28);
                mVar2.B1(29);
                mVar2.B1(30);
                mVar2.B1(31);
                mVar2.B1(32);
                mVar2.B1(33);
                mVar2.B1(34);
                mVar2.B1(35);
                mVar2.B1(36);
            }
            IcebreakersEntity l10 = cVar.l();
            if (l10 != null) {
                if (l10.getFirstIcebreaker() == null) {
                    mVar2.B1(37);
                } else {
                    mVar2.P0(37, l10.getFirstIcebreaker());
                }
                if (l10.getSecondIcebreaker() == null) {
                    mVar2.B1(38);
                } else {
                    mVar2.P0(38, l10.getSecondIcebreaker());
                }
                if (l10.getThirdIcebreaker() == null) {
                    mVar2.B1(39);
                } else {
                    mVar2.P0(39, l10.getThirdIcebreaker());
                }
            } else {
                mVar2.B1(37);
                mVar2.B1(38);
                mVar2.B1(39);
            }
            if (cVar.s() == null) {
                mVar2.B1(40);
            } else {
                mVar2.P0(40, cVar.s());
            }
        }
    }

    class f extends SharedSQLiteStatement {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE user SET appsFlyerId = ? WHERE profile_id = ?";
        }
    }

    public f1(RoomDatabase roomDatabase) {
        this.f11720a = roomDatabase;
        this.f11721b = new b(roomDatabase);
        this.f11724e = new c(roomDatabase);
        this.f11725f = new d(roomDatabase);
        this.f11726g = new e(roomDatabase);
        this.f11727h = new f(roomDatabase);
    }

    public static List<Class<?>> v() {
        return Collections.emptyList();
    }

    public ja.c g() {
        k0 k0Var;
        ja.c cVar;
        String str;
        String str2;
        String str3;
        boolean z10;
        String str4;
        String str5;
        String str6;
        boolean z11;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        int i10;
        boolean z12;
        int i11;
        boolean z13;
        int i12;
        String str12;
        int i13;
        String str13;
        int i14;
        String str14;
        int i15;
        boolean z14;
        int i16;
        Integer num;
        int i17;
        Integer num2;
        int i18;
        String str15;
        int i19;
        String str16;
        int i20;
        String str17;
        int i21;
        Integer num3;
        int i22;
        Integer num4;
        int i23;
        Integer num5;
        int i24;
        Integer num6;
        int i25;
        Integer num7;
        int i26;
        Integer num8;
        int i27;
        String str18;
        String str19;
        String str20;
        k0 c10 = k0.c("SELECT * FROM user LIMIT 1", 0);
        this.f11720a.d();
        Cursor b10 = q1.b.b(this.f11720a, c10, false, (CancellationSignal) null);
        try {
            int e10 = q1.a.e(b10, Extra.PROFILE_ID);
            int e11 = q1.a.e(b10, "appsFlyerId");
            int e12 = q1.a.e(b10, "emailAddress");
            int e13 = q1.a.e(b10, "is_eligible_for_free_trial");
            int e14 = q1.a.e(b10, "registeredDate");
            int e15 = q1.a.e(b10, "beans");
            int e16 = q1.a.e(b10, "birthDay");
            int e17 = q1.a.e(b10, "matchRegion");
            int e18 = q1.a.e(b10, "onHold");
            int e19 = q1.a.e(b10, "deactivateReason");
            int e20 = q1.a.e(b10, "dateReactivated");
            int e21 = q1.a.e(b10, "location");
            int e22 = q1.a.e(b10, "viewedCoachMarks");
            k0Var = c10;
            try {
                int e23 = q1.a.e(b10, "referralCode");
                int e24 = q1.a.e(b10, "badgeCount");
                int e25 = q1.a.e(b10, "appLaunchStreak");
                int e26 = q1.a.e(b10, "hasPrioritizedLikes");
                int e27 = q1.a.e(b10, "hasActiveBoost");
                int e28 = q1.a.e(b10, "boostReportId");
                int e29 = q1.a.e(b10, "numRisingBagels");
                int e30 = q1.a.e(b10, "lastName");
                int e31 = q1.a.e(b10, "zipCode");
                int e32 = q1.a.e(b10, "usesMetric");
                int e33 = q1.a.e(b10, "ageFrom");
                int e34 = q1.a.e(b10, "ageTo");
                int e35 = q1.a.e(b10, "ethnicity");
                int e36 = q1.a.e(b10, ProfileConstants.Field.GENDER);
                int e37 = q1.a.e(b10, ProfileConstants.Field.RELIGION);
                int e38 = q1.a.e(b10, "maxDistanceMiles");
                int e39 = q1.a.e(b10, "maxDistanceKm");
                int e40 = q1.a.e(b10, "heightFeetFrom");
                int e41 = q1.a.e(b10, "heightFeetTo");
                int e42 = q1.a.e(b10, "heightInchFrom");
                int e43 = q1.a.e(b10, "heightInchTo");
                int e44 = q1.a.e(b10, "heightCmFrom");
                int e45 = q1.a.e(b10, "heightCmTo");
                int e46 = q1.a.e(b10, "first_icebreaker");
                int e47 = q1.a.e(b10, "second_icebreaker");
                int e48 = q1.a.e(b10, "third_icebreaker");
                if (b10.moveToFirst()) {
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
                    if (b10.getInt(e13) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (b10.isNull(e14)) {
                        str4 = null;
                    } else {
                        str4 = b10.getString(e14);
                    }
                    OffsetDateTime b11 = this.f11722c.b(str4);
                    long j10 = b10.getLong(e15);
                    if (b10.isNull(e16)) {
                        str5 = null;
                    } else {
                        str5 = b10.getString(e16);
                    }
                    OffsetDateTime b12 = this.f11722c.b(str5);
                    if (b10.isNull(e17)) {
                        str6 = null;
                    } else {
                        str6 = b10.getString(e17);
                    }
                    if (b10.getInt(e18) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (b10.isNull(e19)) {
                        str7 = null;
                    } else {
                        str7 = b10.getString(e19);
                    }
                    if (b10.isNull(e20)) {
                        str8 = null;
                    } else {
                        str8 = b10.getString(e20);
                    }
                    OffsetDateTime b13 = this.f11722c.b(str8);
                    if (b10.isNull(e21)) {
                        str9 = null;
                    } else {
                        str9 = b10.getString(e21);
                    }
                    if (b10.isNull(e22)) {
                        str10 = null;
                    } else {
                        str10 = b10.getString(e22);
                    }
                    List<String> b14 = this.f11723d.b(str10);
                    int i28 = e23;
                    if (b10.isNull(i28)) {
                        i10 = e24;
                        str11 = null;
                    } else {
                        str11 = b10.getString(i28);
                        i10 = e24;
                    }
                    int i29 = b10.getInt(i10);
                    int i30 = b10.getInt(e25);
                    if (b10.getInt(e26) != 0) {
                        z12 = true;
                        i11 = e27;
                    } else {
                        i11 = e27;
                        z12 = false;
                    }
                    if (b10.getInt(i11) != 0) {
                        z13 = true;
                        i12 = e28;
                    } else {
                        i12 = e28;
                        z13 = false;
                    }
                    if (b10.isNull(i12)) {
                        i13 = e29;
                        str12 = null;
                    } else {
                        str12 = b10.getString(i12);
                        i13 = e29;
                    }
                    int i31 = b10.getInt(i13);
                    int i32 = e30;
                    if (b10.isNull(i32)) {
                        i14 = e31;
                        str13 = null;
                    } else {
                        str13 = b10.getString(i32);
                        i14 = e31;
                    }
                    if (b10.isNull(i14)) {
                        i15 = e32;
                        str14 = null;
                    } else {
                        str14 = b10.getString(i14);
                        i15 = e32;
                    }
                    if (b10.getInt(i15) != 0) {
                        z14 = true;
                        i16 = e33;
                    } else {
                        i16 = e33;
                        z14 = false;
                    }
                    if (b10.isNull(i16)) {
                        i17 = e34;
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(i16));
                        i17 = e34;
                    }
                    if (b10.isNull(i17)) {
                        i18 = e35;
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(b10.getInt(i17));
                        i18 = e35;
                    }
                    if (b10.isNull(i18)) {
                        i19 = e36;
                        str15 = null;
                    } else {
                        str15 = b10.getString(i18);
                        i19 = e36;
                    }
                    if (b10.isNull(i19)) {
                        i20 = e37;
                        str16 = null;
                    } else {
                        str16 = b10.getString(i19);
                        i20 = e37;
                    }
                    if (b10.isNull(i20)) {
                        i21 = e38;
                        str17 = null;
                    } else {
                        str17 = b10.getString(i20);
                        i21 = e38;
                    }
                    int i33 = b10.getInt(i21);
                    int i34 = b10.getInt(e39);
                    int i35 = e40;
                    if (b10.isNull(i35)) {
                        i22 = e41;
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(b10.getInt(i35));
                        i22 = e41;
                    }
                    if (b10.isNull(i22)) {
                        i23 = e42;
                        num4 = null;
                    } else {
                        num4 = Integer.valueOf(b10.getInt(i22));
                        i23 = e42;
                    }
                    if (b10.isNull(i23)) {
                        i24 = e43;
                        num5 = null;
                    } else {
                        num5 = Integer.valueOf(b10.getInt(i23));
                        i24 = e43;
                    }
                    if (b10.isNull(i24)) {
                        i25 = e44;
                        num6 = null;
                    } else {
                        num6 = Integer.valueOf(b10.getInt(i24));
                        i25 = e44;
                    }
                    if (b10.isNull(i25)) {
                        i26 = e45;
                        num7 = null;
                    } else {
                        num7 = Integer.valueOf(b10.getInt(i25));
                        i26 = e45;
                    }
                    if (b10.isNull(i26)) {
                        num8 = null;
                    } else {
                        num8 = Integer.valueOf(b10.getInt(i26));
                    }
                    ja.a aVar = new ja.a(num, num2, str15, str16, str17, i33, i34, num3, num4, num5, num6, num7, num8);
                    int i36 = e46;
                    if (b10.isNull(i36)) {
                        i27 = e47;
                        str18 = null;
                    } else {
                        str18 = b10.getString(i36);
                        i27 = e47;
                    }
                    if (b10.isNull(i27)) {
                        str19 = null;
                    } else {
                        str19 = b10.getString(i27);
                    }
                    if (b10.isNull(e48)) {
                        str20 = null;
                    } else {
                        str20 = b10.getString(e48);
                    }
                    cVar = new ja.c(str, str2, str3, z10, b11, j10, b12, aVar, str6, z11, str7, b13, str9, b14, str11, new IcebreakersEntity(str18, str19, str20), i29, i30, z12, z13, str12, i31, str13, str14, z14);
                } else {
                    cVar = null;
                }
                b10.close();
                k0Var.g();
                return cVar;
            } catch (Throwable th2) {
                th = th2;
                b10.close();
                k0Var.g();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            k0Var = c10;
            b10.close();
            k0Var.g();
            throw th;
        }
    }

    public qj.h<ja.c> i() {
        return l0.a(this.f11720a, false, new String[]{"user"}, new a(k0.c("SELECT * FROM user LIMIT 1", 0)));
    }

    public int j(String str, String str2) {
        this.f11720a.d();
        m b10 = this.f11727h.b();
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
        this.f11720a.e();
        try {
            int H = b10.H();
            this.f11720a.C();
            return H;
        } finally {
            this.f11720a.j();
            this.f11727h.h(b10);
        }
    }

    /* renamed from: w */
    public long q(ja.c cVar) {
        this.f11720a.d();
        this.f11720a.e();
        try {
            long l10 = this.f11721b.l(cVar);
            this.f11720a.C();
            return l10;
        } finally {
            this.f11720a.j();
        }
    }

    /* renamed from: x */
    public int r(ja.c cVar) {
        this.f11720a.d();
        this.f11720a.e();
        try {
            int j10 = this.f11726g.j(cVar) + 0;
            this.f11720a.C();
            return j10;
        } finally {
            this.f11720a.j();
        }
    }
}

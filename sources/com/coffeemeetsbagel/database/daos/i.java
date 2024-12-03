package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.g;
import androidx.room.h;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.database.daos.h;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.entities.ActivityReportEntity;
import g6.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import t1.m;

public final class i implements h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11754a;

    /* renamed from: b  reason: collision with root package name */
    private final h<ActivityReportEntity> f11755b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final j f11756c = new j();

    /* renamed from: d  reason: collision with root package name */
    private final h<ActivityReportEntity> f11757d;

    /* renamed from: e  reason: collision with root package name */
    private final g<ActivityReportEntity> f11758e;

    /* renamed from: f  reason: collision with root package name */
    private final g<ActivityReportEntity> f11759f;

    class a implements Callable<List<ActivityReportEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11760a;

        a(k0 k0Var) {
            this.f11760a = k0Var;
        }

        /* renamed from: a */
        public List<ActivityReportEntity> call() throws Exception {
            String str;
            Integer num;
            Boolean bool;
            Float f10;
            Float f11;
            Float f12;
            String str2;
            boolean z10;
            Cursor b10 = q1.b.b(i.this.f11754a, this.f11760a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, Extra.PROFILE_ID);
                int e11 = q1.a.e(b10, "has_logged_in_recently");
                int e12 = q1.a.e(b10, "overall_chat_activity");
                int e13 = q1.a.e(b10, "chat_initiation_level");
                int e14 = q1.a.e(b10, "avg_response_time");
                int e15 = q1.a.e(b10, "expiration_date");
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(e10)) {
                        str = null;
                    } else {
                        str = b10.getString(e10);
                    }
                    if (b10.isNull(e11)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(e11));
                    }
                    if (num == null) {
                        bool = null;
                    } else {
                        if (num.intValue() != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        bool = Boolean.valueOf(z10);
                    }
                    if (b10.isNull(e12)) {
                        f10 = null;
                    } else {
                        f10 = Float.valueOf(b10.getFloat(e12));
                    }
                    if (b10.isNull(e13)) {
                        f11 = null;
                    } else {
                        f11 = Float.valueOf(b10.getFloat(e13));
                    }
                    if (b10.isNull(e14)) {
                        f12 = null;
                    } else {
                        f12 = Float.valueOf(b10.getFloat(e14));
                    }
                    if (b10.isNull(e15)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(e15);
                    }
                    arrayList.add(new ActivityReportEntity(str, bool, f10, f11, f12, i.this.f11756c.b(str2)));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11760a.g();
        }
    }

    class b extends h<ActivityReportEntity> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `activity_reports` (`profile_id`,`has_logged_in_recently`,`overall_chat_activity`,`chat_initiation_level`,`avg_response_time`,`expiration_date`) VALUES (?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, ActivityReportEntity activityReportEntity) {
            Integer num;
            if (activityReportEntity.getProfileId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, activityReportEntity.getProfileId());
            }
            if (activityReportEntity.getHasLoggedInRecently() == null) {
                num = null;
            } else {
                num = Integer.valueOf(activityReportEntity.getHasLoggedInRecently().booleanValue() ? 1 : 0);
            }
            if (num == null) {
                mVar.B1(2);
            } else {
                mVar.f1(2, (long) num.intValue());
            }
            if (activityReportEntity.getOverallChatActivity() == null) {
                mVar.B1(3);
            } else {
                mVar.K(3, (double) activityReportEntity.getOverallChatActivity().floatValue());
            }
            if (activityReportEntity.getChatInitiationLevel() == null) {
                mVar.B1(4);
            } else {
                mVar.K(4, (double) activityReportEntity.getChatInitiationLevel().floatValue());
            }
            if (activityReportEntity.getAvgResponseTime() == null) {
                mVar.B1(5);
            } else {
                mVar.K(5, (double) activityReportEntity.getAvgResponseTime().floatValue());
            }
            String a10 = i.this.f11756c.a(activityReportEntity.getExpirationDate());
            if (a10 == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, a10);
            }
        }
    }

    class c extends h<ActivityReportEntity> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `activity_reports` (`profile_id`,`has_logged_in_recently`,`overall_chat_activity`,`chat_initiation_level`,`avg_response_time`,`expiration_date`) VALUES (?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, ActivityReportEntity activityReportEntity) {
            Integer num;
            if (activityReportEntity.getProfileId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, activityReportEntity.getProfileId());
            }
            if (activityReportEntity.getHasLoggedInRecently() == null) {
                num = null;
            } else {
                num = Integer.valueOf(activityReportEntity.getHasLoggedInRecently().booleanValue() ? 1 : 0);
            }
            if (num == null) {
                mVar.B1(2);
            } else {
                mVar.f1(2, (long) num.intValue());
            }
            if (activityReportEntity.getOverallChatActivity() == null) {
                mVar.B1(3);
            } else {
                mVar.K(3, (double) activityReportEntity.getOverallChatActivity().floatValue());
            }
            if (activityReportEntity.getChatInitiationLevel() == null) {
                mVar.B1(4);
            } else {
                mVar.K(4, (double) activityReportEntity.getChatInitiationLevel().floatValue());
            }
            if (activityReportEntity.getAvgResponseTime() == null) {
                mVar.B1(5);
            } else {
                mVar.K(5, (double) activityReportEntity.getAvgResponseTime().floatValue());
            }
            String a10 = i.this.f11756c.a(activityReportEntity.getExpirationDate());
            if (a10 == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, a10);
            }
        }
    }

    class d extends g<ActivityReportEntity> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `activity_reports` WHERE `profile_id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, ActivityReportEntity activityReportEntity) {
            if (activityReportEntity.getProfileId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, activityReportEntity.getProfileId());
            }
        }
    }

    class e extends g<ActivityReportEntity> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `activity_reports` SET `profile_id` = ?,`has_logged_in_recently` = ?,`overall_chat_activity` = ?,`chat_initiation_level` = ?,`avg_response_time` = ?,`expiration_date` = ? WHERE `profile_id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, ActivityReportEntity activityReportEntity) {
            Integer num;
            if (activityReportEntity.getProfileId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, activityReportEntity.getProfileId());
            }
            if (activityReportEntity.getHasLoggedInRecently() == null) {
                num = null;
            } else {
                num = Integer.valueOf(activityReportEntity.getHasLoggedInRecently().booleanValue() ? 1 : 0);
            }
            if (num == null) {
                mVar.B1(2);
            } else {
                mVar.f1(2, (long) num.intValue());
            }
            if (activityReportEntity.getOverallChatActivity() == null) {
                mVar.B1(3);
            } else {
                mVar.K(3, (double) activityReportEntity.getOverallChatActivity().floatValue());
            }
            if (activityReportEntity.getChatInitiationLevel() == null) {
                mVar.B1(4);
            } else {
                mVar.K(4, (double) activityReportEntity.getChatInitiationLevel().floatValue());
            }
            if (activityReportEntity.getAvgResponseTime() == null) {
                mVar.B1(5);
            } else {
                mVar.K(5, (double) activityReportEntity.getAvgResponseTime().floatValue());
            }
            String a10 = i.this.f11756c.a(activityReportEntity.getExpirationDate());
            if (a10 == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, a10);
            }
            if (activityReportEntity.getProfileId() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, activityReportEntity.getProfileId());
            }
        }
    }

    public i(RoomDatabase roomDatabase) {
        this.f11754a = roomDatabase;
        this.f11755b = new b(roomDatabase);
        this.f11757d = new c(roomDatabase);
        this.f11758e = new d(roomDatabase);
        this.f11759f = new e(roomDatabase);
    }

    public static List<Class<?>> f() {
        return Collections.emptyList();
    }

    public qj.h<List<ActivityReportEntity>> h(String str) {
        k0 c10 = k0.c("SELECT * from activity_reports WHERE profile_id = ?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.a(this.f11754a, false, new String[]{"activity_reports"}, new a(c10));
    }

    public int k(List<? extends ActivityReportEntity> list) {
        this.f11754a.d();
        this.f11754a.e();
        try {
            int k10 = this.f11759f.k(list) + 0;
            this.f11754a.C();
            return k10;
        } finally {
            this.f11754a.j();
        }
    }

    public List<ActivityReportEntity> m(List<String> list) {
        String str;
        Integer num;
        Boolean bool;
        Float f10;
        Float f11;
        Float f12;
        String str2;
        boolean z10;
        StringBuilder b10 = q1.d.b();
        b10.append("SELECT * from activity_reports WHERE profile_id IN (");
        int size = list.size();
        q1.d.a(b10, size);
        b10.append(")");
        k0 c10 = k0.c(b10.toString(), size + 0);
        int i10 = 1;
        for (String next : list) {
            if (next == null) {
                c10.B1(i10);
            } else {
                c10.P0(i10, next);
            }
            i10++;
        }
        this.f11754a.d();
        Cursor b11 = q1.b.b(this.f11754a, c10, false, (CancellationSignal) null);
        try {
            int e10 = q1.a.e(b11, Extra.PROFILE_ID);
            int e11 = q1.a.e(b11, "has_logged_in_recently");
            int e12 = q1.a.e(b11, "overall_chat_activity");
            int e13 = q1.a.e(b11, "chat_initiation_level");
            int e14 = q1.a.e(b11, "avg_response_time");
            int e15 = q1.a.e(b11, "expiration_date");
            ArrayList arrayList = new ArrayList(b11.getCount());
            while (b11.moveToNext()) {
                if (b11.isNull(e10)) {
                    str = null;
                } else {
                    str = b11.getString(e10);
                }
                if (b11.isNull(e11)) {
                    num = null;
                } else {
                    num = Integer.valueOf(b11.getInt(e11));
                }
                if (num == null) {
                    bool = null;
                } else {
                    if (num.intValue() != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    bool = Boolean.valueOf(z10);
                }
                if (b11.isNull(e12)) {
                    f10 = null;
                } else {
                    f10 = Float.valueOf(b11.getFloat(e12));
                }
                if (b11.isNull(e13)) {
                    f11 = null;
                } else {
                    f11 = Float.valueOf(b11.getFloat(e13));
                }
                if (b11.isNull(e14)) {
                    f12 = null;
                } else {
                    f12 = Float.valueOf(b11.getFloat(e14));
                }
                if (b11.isNull(e15)) {
                    str2 = null;
                } else {
                    str2 = b11.getString(e15);
                }
                arrayList.add(new ActivityReportEntity(str, bool, f10, f11, f12, this.f11756c.b(str2)));
            }
            return arrayList;
        } finally {
            b11.close();
            c10.g();
        }
    }

    public int o(List<ActivityReportEntity> list) {
        this.f11754a.e();
        try {
            int a10 = h.a.a(this, list);
            this.f11754a.C();
            return a10;
        } finally {
            this.f11754a.j();
        }
    }

    public List<Long> s(List<? extends ActivityReportEntity> list) {
        this.f11754a.d();
        this.f11754a.e();
        try {
            List<Long> m10 = this.f11755b.m(list);
            this.f11754a.C();
            return m10;
        } finally {
            this.f11754a.j();
        }
    }
}

package com.coffeemeetsbagel.database.daos;

import androidx.room.RoomDatabase;
import androidx.room.g;
import androidx.room.h;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.entities.MatchContextEntity;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import t1.m;

public final class u extends MatchContextRoomDao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11899a;

    /* renamed from: b  reason: collision with root package name */
    private final h<MatchContextEntity> f11900b;

    /* renamed from: c  reason: collision with root package name */
    private final h<MatchContextEntity> f11901c;

    /* renamed from: d  reason: collision with root package name */
    private final g<MatchContextEntity> f11902d;

    /* renamed from: e  reason: collision with root package name */
    private final g<MatchContextEntity> f11903e;

    class a implements Callable<MatchContextEntity> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11904a;

        a(k0 k0Var) {
            this.f11904a = k0Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.coffeemeetsbagel.models.entities.MatchContextEntity} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r3v0 */
        /* JADX WARNING: type inference failed for: r3v3 */
        /* JADX WARNING: type inference failed for: r3v5 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.coffeemeetsbagel.models.entities.MatchContextEntity call() throws java.lang.Exception {
            /*
                r7 = this;
                com.coffeemeetsbagel.database.daos.u r0 = com.coffeemeetsbagel.database.daos.u.this
                androidx.room.RoomDatabase r0 = r0.f11899a
                androidx.room.k0 r1 = r7.f11904a
                r2 = 0
                r3 = 0
                android.database.Cursor r0 = q1.b.b(r0, r1, r2, r3)
                java.lang.String r1 = "match_id"
                int r1 = q1.a.e(r0, r1)     // Catch:{ all -> 0x0065 }
                java.lang.String r2 = "icon"
                int r2 = q1.a.e(r0, r2)     // Catch:{ all -> 0x0065 }
                java.lang.String r4 = "title"
                int r4 = q1.a.e(r0, r4)     // Catch:{ all -> 0x0065 }
                java.lang.String r5 = "body"
                int r5 = q1.a.e(r0, r5)     // Catch:{ all -> 0x0065 }
                boolean r6 = r0.moveToFirst()     // Catch:{ all -> 0x0065 }
                if (r6 == 0) goto L_0x0061
                boolean r6 = r0.isNull(r1)     // Catch:{ all -> 0x0065 }
                if (r6 == 0) goto L_0x0034
                r1 = r3
                goto L_0x0038
            L_0x0034:
                java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x0065 }
            L_0x0038:
                boolean r6 = r0.isNull(r2)     // Catch:{ all -> 0x0065 }
                if (r6 == 0) goto L_0x0040
                r2 = r3
                goto L_0x0044
            L_0x0040:
                java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0065 }
            L_0x0044:
                boolean r6 = r0.isNull(r4)     // Catch:{ all -> 0x0065 }
                if (r6 == 0) goto L_0x004c
                r4 = r3
                goto L_0x0050
            L_0x004c:
                java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x0065 }
            L_0x0050:
                boolean r6 = r0.isNull(r5)     // Catch:{ all -> 0x0065 }
                if (r6 == 0) goto L_0x0057
                goto L_0x005b
            L_0x0057:
                java.lang.String r3 = r0.getString(r5)     // Catch:{ all -> 0x0065 }
            L_0x005b:
                com.coffeemeetsbagel.models.entities.MatchContextEntity r5 = new com.coffeemeetsbagel.models.entities.MatchContextEntity     // Catch:{ all -> 0x0065 }
                r5.<init>(r1, r2, r4, r3)     // Catch:{ all -> 0x0065 }
                r3 = r5
            L_0x0061:
                r0.close()
                return r3
            L_0x0065:
                r1 = move-exception
                r0.close()
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.database.daos.u.a.call():com.coffeemeetsbagel.models.entities.MatchContextEntity");
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11904a.g();
        }
    }

    class b extends h<MatchContextEntity> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `match_context` (`match_id`,`icon`,`title`,`body`) VALUES (?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, MatchContextEntity matchContextEntity) {
            if (matchContextEntity.getMatchId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, matchContextEntity.getMatchId());
            }
            if (matchContextEntity.getIcon() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, matchContextEntity.getIcon());
            }
            if (matchContextEntity.getTitle() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, matchContextEntity.getTitle());
            }
            if (matchContextEntity.getBody() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, matchContextEntity.getBody());
            }
        }
    }

    class c extends h<MatchContextEntity> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `match_context` (`match_id`,`icon`,`title`,`body`) VALUES (?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, MatchContextEntity matchContextEntity) {
            if (matchContextEntity.getMatchId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, matchContextEntity.getMatchId());
            }
            if (matchContextEntity.getIcon() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, matchContextEntity.getIcon());
            }
            if (matchContextEntity.getTitle() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, matchContextEntity.getTitle());
            }
            if (matchContextEntity.getBody() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, matchContextEntity.getBody());
            }
        }
    }

    class d extends g<MatchContextEntity> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `match_context` WHERE `match_id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, MatchContextEntity matchContextEntity) {
            if (matchContextEntity.getMatchId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, matchContextEntity.getMatchId());
            }
        }
    }

    class e extends g<MatchContextEntity> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `match_context` SET `match_id` = ?,`icon` = ?,`title` = ?,`body` = ? WHERE `match_id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, MatchContextEntity matchContextEntity) {
            if (matchContextEntity.getMatchId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, matchContextEntity.getMatchId());
            }
            if (matchContextEntity.getIcon() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, matchContextEntity.getIcon());
            }
            if (matchContextEntity.getTitle() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, matchContextEntity.getTitle());
            }
            if (matchContextEntity.getBody() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, matchContextEntity.getBody());
            }
            if (matchContextEntity.getMatchId() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, matchContextEntity.getMatchId());
            }
        }
    }

    public u(RoomDatabase roomDatabase) {
        this.f11899a = roomDatabase;
        this.f11900b = new b(roomDatabase);
        this.f11901c = new c(roomDatabase);
        this.f11902d = new d(roomDatabase);
        this.f11903e = new e(roomDatabase);
    }

    public static List<Class<?>> t() {
        return Collections.emptyList();
    }

    public qj.h<MatchContextEntity> g(String str) {
        k0 c10 = k0.c("SELECT * from match_context WHERE match_id = ?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.a(this.f11899a, false, new String[]{"match_context"}, new a(c10));
    }

    public int k(List<? extends MatchContextEntity> list) {
        this.f11899a.d();
        this.f11899a.e();
        try {
            int k10 = this.f11903e.k(list) + 0;
            this.f11899a.C();
            return k10;
        } finally {
            this.f11899a.j();
        }
    }

    public int o(List<MatchContextEntity> list) {
        this.f11899a.e();
        try {
            int n10 = super.o(list);
            this.f11899a.C();
            return n10;
        } finally {
            this.f11899a.j();
        }
    }

    public List<Long> s(List<? extends MatchContextEntity> list) {
        this.f11899a.d();
        this.f11899a.e();
        try {
            List<Long> m10 = this.f11900b.m(list);
            this.f11899a.C();
            return m10;
        } finally {
            this.f11899a.j();
        }
    }
}

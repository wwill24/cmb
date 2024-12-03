package com.coffeemeetsbagel.likes_you;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.entities.LikesYouCardEntity;
import com.leanplum.internal.Constants;
import g6.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import qj.w;
import t1.m;

public final class e extends d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f34174a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.room.h<LikesYouCardEntity> f34175b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final g6.d f34176c = new g6.d();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final k f34177d = new k();

    /* renamed from: e  reason: collision with root package name */
    private final androidx.room.h<LikesYouCardEntity> f34178e;

    /* renamed from: f  reason: collision with root package name */
    private final androidx.room.g<LikesYouCardEntity> f34179f;

    /* renamed from: g  reason: collision with root package name */
    private final androidx.room.g<LikesYouCardEntity> f34180g;

    /* renamed from: h  reason: collision with root package name */
    private final SharedSQLiteStatement f34181h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final SharedSQLiteStatement f34182i;

    class a implements Callable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f34183a;

        a(String str) {
            this.f34183a = str;
        }

        /* renamed from: a */
        public Integer call() throws Exception {
            m b10 = e.this.f34182i.b();
            String str = this.f34183a;
            if (str == null) {
                b10.B1(1);
            } else {
                b10.P0(1, str);
            }
            e.this.f34174a.e();
            try {
                Integer valueOf = Integer.valueOf(b10.H());
                e.this.f34174a.C();
                return valueOf;
            } finally {
                e.this.f34174a.j();
                e.this.f34182i.h(b10);
            }
        }
    }

    class b implements Callable<List<LikesYouCardEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f34185a;

        b(k0 k0Var) {
            this.f34185a = k0Var;
        }

        /* renamed from: a */
        public List<LikesYouCardEntity> call() throws Exception {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            Integer num;
            Cursor b10 = q1.b.b(e.this.f34174a, this.f34185a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, Extra.PROFILE_ID);
                int e11 = q1.a.e(b10, "group_ids");
                int e12 = q1.a.e(b10, "age");
                int e13 = q1.a.e(b10, Extra.BAGEL_ID);
                int e14 = q1.a.e(b10, Constants.Keys.CITY);
                int e15 = q1.a.e(b10, "education");
                int e16 = q1.a.e(b10, ProfileConstants.Field.USER_OCCUPATION);
                int e17 = q1.a.e(b10, "pair_like_comment");
                int e18 = q1.a.e(b10, "image_url");
                int e19 = q1.a.e(b10, "purchase_attribution");
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
                    List<String> b11 = e.this.f34176c.b(str2);
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
                    if (b10.isNull(e17)) {
                        str7 = null;
                    } else {
                        str7 = b10.getString(e17);
                    }
                    if (b10.isNull(e18)) {
                        str8 = null;
                    } else {
                        str8 = b10.getString(e18);
                    }
                    if (b10.isNull(e19)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(e19));
                    }
                    arrayList.add(new LikesYouCardEntity(str, b11, i10, str3, str4, str5, str6, str7, str8, e.this.f34177d.a(num)));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f34185a.g();
        }
    }

    class c implements Callable<LikesYouCardEntity> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f34187a;

        c(k0 k0Var) {
            this.f34187a = k0Var;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.coffeemeetsbagel.models.entities.LikesYouCardEntity} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Integer} */
        /* JADX WARNING: type inference failed for: r4v0 */
        /* JADX WARNING: type inference failed for: r13v3, types: [com.coffeemeetsbagel.models.entities.LikesYouCardEntity] */
        /* JADX WARNING: type inference failed for: r4v5 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.coffeemeetsbagel.models.entities.LikesYouCardEntity call() throws java.lang.Exception {
            /*
                r24 = this;
                r1 = r24
                com.coffeemeetsbagel.likes_you.e r0 = com.coffeemeetsbagel.likes_you.e.this
                androidx.room.RoomDatabase r0 = r0.f34174a
                androidx.room.k0 r2 = r1.f34187a
                r3 = 0
                r4 = 0
                android.database.Cursor r2 = q1.b.b(r0, r2, r3, r4)
                java.lang.String r0 = "profile_id"
                int r0 = q1.a.e(r2, r0)     // Catch:{ all -> 0x00f6 }
                java.lang.String r3 = "group_ids"
                int r3 = q1.a.e(r2, r3)     // Catch:{ all -> 0x00f6 }
                java.lang.String r5 = "age"
                int r5 = q1.a.e(r2, r5)     // Catch:{ all -> 0x00f6 }
                java.lang.String r6 = "bagel_id"
                int r6 = q1.a.e(r2, r6)     // Catch:{ all -> 0x00f6 }
                java.lang.String r7 = "city"
                int r7 = q1.a.e(r2, r7)     // Catch:{ all -> 0x00f6 }
                java.lang.String r8 = "education"
                int r8 = q1.a.e(r2, r8)     // Catch:{ all -> 0x00f6 }
                java.lang.String r9 = "occupation"
                int r9 = q1.a.e(r2, r9)     // Catch:{ all -> 0x00f6 }
                java.lang.String r10 = "pair_like_comment"
                int r10 = q1.a.e(r2, r10)     // Catch:{ all -> 0x00f6 }
                java.lang.String r11 = "image_url"
                int r11 = q1.a.e(r2, r11)     // Catch:{ all -> 0x00f6 }
                java.lang.String r12 = "purchase_attribution"
                int r12 = q1.a.e(r2, r12)     // Catch:{ all -> 0x00f6 }
                boolean r13 = r2.moveToFirst()     // Catch:{ all -> 0x00f6 }
                if (r13 == 0) goto L_0x00f2
                boolean r13 = r2.isNull(r0)     // Catch:{ all -> 0x00f6 }
                if (r13 == 0) goto L_0x005a
                r14 = r4
                goto L_0x005f
            L_0x005a:
                java.lang.String r0 = r2.getString(r0)     // Catch:{ all -> 0x00f6 }
                r14 = r0
            L_0x005f:
                boolean r0 = r2.isNull(r3)     // Catch:{ all -> 0x00f6 }
                if (r0 == 0) goto L_0x0067
                r0 = r4
                goto L_0x006b
            L_0x0067:
                java.lang.String r0 = r2.getString(r3)     // Catch:{ all -> 0x00f6 }
            L_0x006b:
                com.coffeemeetsbagel.likes_you.e r3 = com.coffeemeetsbagel.likes_you.e.this     // Catch:{ all -> 0x00f6 }
                g6.d r3 = r3.f34176c     // Catch:{ all -> 0x00f6 }
                java.util.List r15 = r3.b(r0)     // Catch:{ all -> 0x00f6 }
                int r16 = r2.getInt(r5)     // Catch:{ all -> 0x00f6 }
                boolean r0 = r2.isNull(r6)     // Catch:{ all -> 0x00f6 }
                if (r0 == 0) goto L_0x0082
                r17 = r4
                goto L_0x0088
            L_0x0082:
                java.lang.String r0 = r2.getString(r6)     // Catch:{ all -> 0x00f6 }
                r17 = r0
            L_0x0088:
                boolean r0 = r2.isNull(r7)     // Catch:{ all -> 0x00f6 }
                if (r0 == 0) goto L_0x0091
                r18 = r4
                goto L_0x0097
            L_0x0091:
                java.lang.String r0 = r2.getString(r7)     // Catch:{ all -> 0x00f6 }
                r18 = r0
            L_0x0097:
                boolean r0 = r2.isNull(r8)     // Catch:{ all -> 0x00f6 }
                if (r0 == 0) goto L_0x00a0
                r19 = r4
                goto L_0x00a6
            L_0x00a0:
                java.lang.String r0 = r2.getString(r8)     // Catch:{ all -> 0x00f6 }
                r19 = r0
            L_0x00a6:
                boolean r0 = r2.isNull(r9)     // Catch:{ all -> 0x00f6 }
                if (r0 == 0) goto L_0x00af
                r20 = r4
                goto L_0x00b5
            L_0x00af:
                java.lang.String r0 = r2.getString(r9)     // Catch:{ all -> 0x00f6 }
                r20 = r0
            L_0x00b5:
                boolean r0 = r2.isNull(r10)     // Catch:{ all -> 0x00f6 }
                if (r0 == 0) goto L_0x00be
                r21 = r4
                goto L_0x00c4
            L_0x00be:
                java.lang.String r0 = r2.getString(r10)     // Catch:{ all -> 0x00f6 }
                r21 = r0
            L_0x00c4:
                boolean r0 = r2.isNull(r11)     // Catch:{ all -> 0x00f6 }
                if (r0 == 0) goto L_0x00cd
                r22 = r4
                goto L_0x00d3
            L_0x00cd:
                java.lang.String r0 = r2.getString(r11)     // Catch:{ all -> 0x00f6 }
                r22 = r0
            L_0x00d3:
                boolean r0 = r2.isNull(r12)     // Catch:{ all -> 0x00f6 }
                if (r0 == 0) goto L_0x00da
                goto L_0x00e2
            L_0x00da:
                int r0 = r2.getInt(r12)     // Catch:{ all -> 0x00f6 }
                java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00f6 }
            L_0x00e2:
                com.coffeemeetsbagel.likes_you.e r0 = com.coffeemeetsbagel.likes_you.e.this     // Catch:{ all -> 0x00f6 }
                g6.k r0 = r0.f34177d     // Catch:{ all -> 0x00f6 }
                com.coffeemeetsbagel.models.enums.PurchaseAttribution r23 = r0.a(r4)     // Catch:{ all -> 0x00f6 }
                com.coffeemeetsbagel.models.entities.LikesYouCardEntity r4 = new com.coffeemeetsbagel.models.entities.LikesYouCardEntity     // Catch:{ all -> 0x00f6 }
                r13 = r4
                r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x00f6 }
            L_0x00f2:
                r2.close()
                return r4
            L_0x00f6:
                r0 = move-exception
                r2.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.likes_you.e.c.call():com.coffeemeetsbagel.models.entities.LikesYouCardEntity");
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f34187a.g();
        }
    }

    class d extends androidx.room.h<LikesYouCardEntity> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `likes_you_card` (`profile_id`,`group_ids`,`age`,`bagel_id`,`city`,`education`,`occupation`,`pair_like_comment`,`image_url`,`purchase_attribution`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, LikesYouCardEntity likesYouCardEntity) {
            if (likesYouCardEntity.getProfileId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, likesYouCardEntity.getProfileId());
            }
            String a10 = e.this.f34176c.a(likesYouCardEntity.getGroupIds());
            if (a10 == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, a10);
            }
            mVar.f1(3, (long) likesYouCardEntity.getAge());
            if (likesYouCardEntity.getBagelId() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, likesYouCardEntity.getBagelId());
            }
            if (likesYouCardEntity.getCity() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, likesYouCardEntity.getCity());
            }
            if (likesYouCardEntity.getEducation() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, likesYouCardEntity.getEducation());
            }
            if (likesYouCardEntity.getOccupation() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, likesYouCardEntity.getOccupation());
            }
            if (likesYouCardEntity.getPairLikeComment() == null) {
                mVar.B1(8);
            } else {
                mVar.P0(8, likesYouCardEntity.getPairLikeComment());
            }
            if (likesYouCardEntity.getImageUrl() == null) {
                mVar.B1(9);
            } else {
                mVar.P0(9, likesYouCardEntity.getImageUrl());
            }
            Integer b10 = e.this.f34177d.b(likesYouCardEntity.getPurchaseAttribution());
            if (b10 == null) {
                mVar.B1(10);
            } else {
                mVar.f1(10, (long) b10.intValue());
            }
        }
    }

    /* renamed from: com.coffeemeetsbagel.likes_you.e$e  reason: collision with other inner class name */
    class C0408e extends androidx.room.h<LikesYouCardEntity> {
        C0408e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `likes_you_card` (`profile_id`,`group_ids`,`age`,`bagel_id`,`city`,`education`,`occupation`,`pair_like_comment`,`image_url`,`purchase_attribution`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, LikesYouCardEntity likesYouCardEntity) {
            if (likesYouCardEntity.getProfileId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, likesYouCardEntity.getProfileId());
            }
            String a10 = e.this.f34176c.a(likesYouCardEntity.getGroupIds());
            if (a10 == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, a10);
            }
            mVar.f1(3, (long) likesYouCardEntity.getAge());
            if (likesYouCardEntity.getBagelId() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, likesYouCardEntity.getBagelId());
            }
            if (likesYouCardEntity.getCity() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, likesYouCardEntity.getCity());
            }
            if (likesYouCardEntity.getEducation() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, likesYouCardEntity.getEducation());
            }
            if (likesYouCardEntity.getOccupation() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, likesYouCardEntity.getOccupation());
            }
            if (likesYouCardEntity.getPairLikeComment() == null) {
                mVar.B1(8);
            } else {
                mVar.P0(8, likesYouCardEntity.getPairLikeComment());
            }
            if (likesYouCardEntity.getImageUrl() == null) {
                mVar.B1(9);
            } else {
                mVar.P0(9, likesYouCardEntity.getImageUrl());
            }
            Integer b10 = e.this.f34177d.b(likesYouCardEntity.getPurchaseAttribution());
            if (b10 == null) {
                mVar.B1(10);
            } else {
                mVar.f1(10, (long) b10.intValue());
            }
        }
    }

    class f extends androidx.room.g<LikesYouCardEntity> {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `likes_you_card` WHERE `profile_id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, LikesYouCardEntity likesYouCardEntity) {
            if (likesYouCardEntity.getProfileId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, likesYouCardEntity.getProfileId());
            }
        }
    }

    class g extends androidx.room.g<LikesYouCardEntity> {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `likes_you_card` SET `profile_id` = ?,`group_ids` = ?,`age` = ?,`bagel_id` = ?,`city` = ?,`education` = ?,`occupation` = ?,`pair_like_comment` = ?,`image_url` = ?,`purchase_attribution` = ? WHERE `profile_id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, LikesYouCardEntity likesYouCardEntity) {
            if (likesYouCardEntity.getProfileId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, likesYouCardEntity.getProfileId());
            }
            String a10 = e.this.f34176c.a(likesYouCardEntity.getGroupIds());
            if (a10 == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, a10);
            }
            mVar.f1(3, (long) likesYouCardEntity.getAge());
            if (likesYouCardEntity.getBagelId() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, likesYouCardEntity.getBagelId());
            }
            if (likesYouCardEntity.getCity() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, likesYouCardEntity.getCity());
            }
            if (likesYouCardEntity.getEducation() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, likesYouCardEntity.getEducation());
            }
            if (likesYouCardEntity.getOccupation() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, likesYouCardEntity.getOccupation());
            }
            if (likesYouCardEntity.getPairLikeComment() == null) {
                mVar.B1(8);
            } else {
                mVar.P0(8, likesYouCardEntity.getPairLikeComment());
            }
            if (likesYouCardEntity.getImageUrl() == null) {
                mVar.B1(9);
            } else {
                mVar.P0(9, likesYouCardEntity.getImageUrl());
            }
            Integer b10 = e.this.f34177d.b(likesYouCardEntity.getPurchaseAttribution());
            if (b10 == null) {
                mVar.B1(10);
            } else {
                mVar.f1(10, (long) b10.intValue());
            }
            if (likesYouCardEntity.getProfileId() == null) {
                mVar.B1(11);
            } else {
                mVar.P0(11, likesYouCardEntity.getProfileId());
            }
        }
    }

    class h extends SharedSQLiteStatement {
        h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE from likes_you_card";
        }
    }

    class i extends SharedSQLiteStatement {
        i(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM likes_you_card WHERE profile_id = ?";
        }
    }

    public e(RoomDatabase roomDatabase) {
        this.f34174a = roomDatabase;
        this.f34175b = new d(roomDatabase);
        this.f34178e = new C0408e(roomDatabase);
        this.f34179f = new f(roomDatabase);
        this.f34180g = new g(roomDatabase);
        this.f34181h = new h(roomDatabase);
        this.f34182i = new i(roomDatabase);
    }

    public static List<Class<?>> z() {
        return Collections.emptyList();
    }

    public void c(List<LikesYouCardEntity> list) {
        this.f34174a.e();
        try {
            super.c(list);
            this.f34174a.C();
        } finally {
            this.f34174a.j();
        }
    }

    public void i() {
        this.f34174a.d();
        m b10 = this.f34181h.b();
        this.f34174a.e();
        try {
            b10.H();
            this.f34174a.C();
        } finally {
            this.f34174a.j();
            this.f34181h.h(b10);
        }
    }

    public w<Integer> j(String str) {
        return w.A(new a(str));
    }

    public w<List<LikesYouCardEntity>> n() {
        return l0.c(new b(k0.c("SELECT * FROM likes_you_card", 0)));
    }

    public List<Long> s(List<? extends LikesYouCardEntity> list) {
        this.f34174a.d();
        this.f34174a.e();
        try {
            List<Long> m10 = this.f34175b.m(list);
            this.f34174a.C();
            return m10;
        } finally {
            this.f34174a.j();
        }
    }

    public qj.h<LikesYouCardEntity> t(String str) {
        k0 c10 = k0.c("SELECT * FROM likes_you_card WHERE profile_id = ?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.a(this.f34174a, false, new String[]{"likes_you_card"}, new c(c10));
    }
}

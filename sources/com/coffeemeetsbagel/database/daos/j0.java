package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.entities.Height;
import com.coffeemeetsbagel.models.entities.PhotoEntity;
import com.coffeemeetsbagel.models.entities.ProfileEducationEntity;
import com.coffeemeetsbagel.models.entities.ProfileEntity;
import g6.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import t1.m;

public final class j0 extends ProfileRoomDao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11766a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.room.h<ProfileEntity> f11767b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final g6.b f11768c = new g6.b();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final g6.c f11769d = new g6.c();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final n f11770e = new n();

    /* renamed from: f  reason: collision with root package name */
    private final androidx.room.h<ProfileEntity> f11771f;

    /* renamed from: g  reason: collision with root package name */
    private final androidx.room.g<ProfileEntity> f11772g;

    /* renamed from: h  reason: collision with root package name */
    private final androidx.room.g<ProfileEntity> f11773h;

    class a implements Callable<List<ProfileEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11774a;

        a(k0 k0Var) {
            this.f11774a = k0Var;
        }

        /* JADX WARNING: Removed duplicated region for block: B:67:0x01b2 A[Catch:{ all -> 0x024c }] */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x01d0 A[Catch:{ all -> 0x024c }] */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x01f7 A[Catch:{ all -> 0x024c }] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0205 A[Catch:{ all -> 0x024c }] */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x020d A[Catch:{ all -> 0x024c }] */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x020f A[Catch:{ all -> 0x024c }] */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0219 A[Catch:{ all -> 0x024c }] */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x021d A[Catch:{ all -> 0x024c }] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.List<com.coffeemeetsbagel.models.entities.ProfileEntity> call() throws java.lang.Exception {
            /*
                r41 = this;
                r1 = r41
                com.coffeemeetsbagel.database.daos.j0 r0 = com.coffeemeetsbagel.database.daos.j0.this
                androidx.room.RoomDatabase r0 = r0.f11766a
                androidx.room.k0 r2 = r1.f11774a
                r3 = 0
                r4 = 0
                android.database.Cursor r2 = q1.b.b(r0, r2, r3, r4)
                java.lang.String r0 = "id"
                int r0 = q1.a.e(r2, r0)     // Catch:{ all -> 0x024c }
                java.lang.String r3 = "age"
                int r3 = q1.a.e(r2, r3)     // Catch:{ all -> 0x024c }
                java.lang.String r5 = "city"
                int r5 = q1.a.e(r2, r5)     // Catch:{ all -> 0x024c }
                java.lang.String r6 = "country"
                int r6 = q1.a.e(r2, r6)     // Catch:{ all -> 0x024c }
                java.lang.String r7 = "employer"
                int r7 = q1.a.e(r2, r7)     // Catch:{ all -> 0x024c }
                java.lang.String r8 = "ethnicities"
                int r8 = q1.a.e(r2, r8)     // Catch:{ all -> 0x024c }
                java.lang.String r9 = "first_name"
                int r9 = q1.a.e(r2, r9)     // Catch:{ all -> 0x024c }
                java.lang.String r10 = "gender"
                int r10 = q1.a.e(r2, r10)     // Catch:{ all -> 0x024c }
                java.lang.String r11 = "last_name"
                int r11 = q1.a.e(r2, r11)     // Catch:{ all -> 0x024c }
                java.lang.String r12 = "occupation"
                int r12 = q1.a.e(r2, r12)     // Catch:{ all -> 0x024c }
                java.lang.String r13 = "religion"
                int r13 = q1.a.e(r2, r13)     // Catch:{ all -> 0x024c }
                java.lang.String r14 = "state"
                int r14 = q1.a.e(r2, r14)     // Catch:{ all -> 0x024c }
                java.lang.String r15 = "school"
                int r15 = q1.a.e(r2, r15)     // Catch:{ all -> 0x024c }
                java.lang.String r4 = "degree_id"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x024c }
                r16 = r4
                java.lang.String r4 = "height_cm"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x024c }
                r17 = r4
                java.lang.String r4 = "height_feet"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x024c }
                r18 = r4
                java.lang.String r4 = "height_inches"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x024c }
                r19 = r4
                java.lang.String r4 = "secondary_school"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x024c }
                r20 = r4
                java.lang.String r4 = "secondary_degree_id"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x024c }
                r21 = r4
                java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x024c }
                r22 = r15
                int r15 = r2.getCount()     // Catch:{ all -> 0x024c }
                r4.<init>(r15)     // Catch:{ all -> 0x024c }
            L_0x0099:
                boolean r15 = r2.moveToNext()     // Catch:{ all -> 0x024c }
                if (r15 == 0) goto L_0x0248
                boolean r15 = r2.isNull(r0)     // Catch:{ all -> 0x024c }
                if (r15 == 0) goto L_0x00a8
                r24 = 0
                goto L_0x00ae
            L_0x00a8:
                java.lang.String r15 = r2.getString(r0)     // Catch:{ all -> 0x024c }
                r24 = r15
            L_0x00ae:
                int r25 = r2.getInt(r3)     // Catch:{ all -> 0x024c }
                boolean r15 = r2.isNull(r5)     // Catch:{ all -> 0x024c }
                if (r15 == 0) goto L_0x00bb
                r26 = 0
                goto L_0x00c1
            L_0x00bb:
                java.lang.String r15 = r2.getString(r5)     // Catch:{ all -> 0x024c }
                r26 = r15
            L_0x00c1:
                boolean r15 = r2.isNull(r6)     // Catch:{ all -> 0x024c }
                if (r15 == 0) goto L_0x00ca
                r27 = 0
                goto L_0x00d0
            L_0x00ca:
                java.lang.String r15 = r2.getString(r6)     // Catch:{ all -> 0x024c }
                r27 = r15
            L_0x00d0:
                boolean r15 = r2.isNull(r7)     // Catch:{ all -> 0x024c }
                if (r15 == 0) goto L_0x00d9
                r29 = 0
                goto L_0x00df
            L_0x00d9:
                java.lang.String r15 = r2.getString(r7)     // Catch:{ all -> 0x024c }
                r29 = r15
            L_0x00df:
                boolean r15 = r2.isNull(r8)     // Catch:{ all -> 0x024c }
                if (r15 == 0) goto L_0x00e9
                r39 = r0
                r15 = 0
                goto L_0x00ef
            L_0x00e9:
                java.lang.String r15 = r2.getString(r8)     // Catch:{ all -> 0x024c }
                r39 = r0
            L_0x00ef:
                com.coffeemeetsbagel.database.daos.j0 r0 = com.coffeemeetsbagel.database.daos.j0.this     // Catch:{ all -> 0x024c }
                g6.b r0 = r0.f11768c     // Catch:{ all -> 0x024c }
                java.util.List r30 = r0.b(r15)     // Catch:{ all -> 0x024c }
                boolean r0 = r2.isNull(r9)     // Catch:{ all -> 0x024c }
                if (r0 == 0) goto L_0x0102
                r31 = 0
                goto L_0x0108
            L_0x0102:
                java.lang.String r0 = r2.getString(r9)     // Catch:{ all -> 0x024c }
                r31 = r0
            L_0x0108:
                boolean r0 = r2.isNull(r10)     // Catch:{ all -> 0x024c }
                if (r0 == 0) goto L_0x0110
                r0 = 0
                goto L_0x0114
            L_0x0110:
                java.lang.String r0 = r2.getString(r10)     // Catch:{ all -> 0x024c }
            L_0x0114:
                com.coffeemeetsbagel.database.daos.j0 r15 = com.coffeemeetsbagel.database.daos.j0.this     // Catch:{ all -> 0x024c }
                g6.c r15 = r15.f11769d     // Catch:{ all -> 0x024c }
                com.coffeemeetsbagel.models.entities.GenderType r32 = r15.b(r0)     // Catch:{ all -> 0x024c }
                boolean r0 = r2.isNull(r11)     // Catch:{ all -> 0x024c }
                if (r0 == 0) goto L_0x0127
                r34 = 0
                goto L_0x012d
            L_0x0127:
                java.lang.String r0 = r2.getString(r11)     // Catch:{ all -> 0x024c }
                r34 = r0
            L_0x012d:
                boolean r0 = r2.isNull(r12)     // Catch:{ all -> 0x024c }
                if (r0 == 0) goto L_0x0136
                r35 = 0
                goto L_0x013c
            L_0x0136:
                java.lang.String r0 = r2.getString(r12)     // Catch:{ all -> 0x024c }
                r35 = r0
            L_0x013c:
                boolean r0 = r2.isNull(r13)     // Catch:{ all -> 0x024c }
                if (r0 == 0) goto L_0x0144
                r0 = 0
                goto L_0x0148
            L_0x0144:
                java.lang.String r0 = r2.getString(r13)     // Catch:{ all -> 0x024c }
            L_0x0148:
                com.coffeemeetsbagel.database.daos.j0 r15 = com.coffeemeetsbagel.database.daos.j0.this     // Catch:{ all -> 0x024c }
                g6.n r15 = r15.f11770e     // Catch:{ all -> 0x024c }
                com.coffeemeetsbagel.models.entities.ReligionType r36 = r15.b(r0)     // Catch:{ all -> 0x024c }
                boolean r0 = r2.isNull(r14)     // Catch:{ all -> 0x024c }
                if (r0 == 0) goto L_0x015d
                r0 = r22
                r38 = 0
                goto L_0x0165
            L_0x015d:
                java.lang.String r0 = r2.getString(r14)     // Catch:{ all -> 0x024c }
                r38 = r0
                r0 = r22
            L_0x0165:
                boolean r15 = r2.isNull(r0)     // Catch:{ all -> 0x024c }
                if (r15 == 0) goto L_0x017d
                r15 = r16
                boolean r16 = r2.isNull(r15)     // Catch:{ all -> 0x024c }
                if (r16 != 0) goto L_0x0174
                goto L_0x017f
            L_0x0174:
                r22 = r0
                r16 = r3
                r0 = r17
                r28 = 0
                goto L_0x01ac
            L_0x017d:
                r15 = r16
            L_0x017f:
                boolean r16 = r2.isNull(r0)     // Catch:{ all -> 0x024c }
                if (r16 == 0) goto L_0x0189
                r22 = r0
                r0 = 0
                goto L_0x0191
            L_0x0189:
                java.lang.String r16 = r2.getString(r0)     // Catch:{ all -> 0x024c }
                r22 = r0
                r0 = r16
            L_0x0191:
                boolean r16 = r2.isNull(r15)     // Catch:{ all -> 0x024c }
                if (r16 == 0) goto L_0x019b
                r16 = r3
                r1 = 0
                goto L_0x01a3
            L_0x019b:
                java.lang.String r16 = r2.getString(r15)     // Catch:{ all -> 0x024c }
                r1 = r16
                r16 = r3
            L_0x01a3:
                com.coffeemeetsbagel.models.entities.ProfileEducationEntity r3 = new com.coffeemeetsbagel.models.entities.ProfileEducationEntity     // Catch:{ all -> 0x024c }
                r3.<init>(r0, r1)     // Catch:{ all -> 0x024c }
                r28 = r3
                r0 = r17
            L_0x01ac:
                boolean r1 = r2.isNull(r0)     // Catch:{ all -> 0x024c }
                if (r1 == 0) goto L_0x01d0
                r1 = r18
                boolean r3 = r2.isNull(r1)     // Catch:{ all -> 0x024c }
                if (r3 == 0) goto L_0x01d2
                r3 = r19
                boolean r17 = r2.isNull(r3)     // Catch:{ all -> 0x024c }
                if (r17 != 0) goto L_0x01c3
                goto L_0x01d4
            L_0x01c3:
                r18 = r0
                r19 = r1
                r40 = r3
                r17 = r5
                r0 = r20
                r33 = 0
                goto L_0x01f1
            L_0x01d0:
                r1 = r18
            L_0x01d2:
                r3 = r19
            L_0x01d4:
                r17 = r5
                int r5 = r2.getInt(r0)     // Catch:{ all -> 0x024c }
                r18 = r0
                int r0 = r2.getInt(r1)     // Catch:{ all -> 0x024c }
                r19 = r1
                int r1 = r2.getInt(r3)     // Catch:{ all -> 0x024c }
                r40 = r3
                com.coffeemeetsbagel.models.entities.Height r3 = new com.coffeemeetsbagel.models.entities.Height     // Catch:{ all -> 0x024c }
                r3.<init>(r5, r0, r1)     // Catch:{ all -> 0x024c }
                r33 = r3
                r0 = r20
            L_0x01f1:
                boolean r1 = r2.isNull(r0)     // Catch:{ all -> 0x024c }
                if (r1 == 0) goto L_0x0205
                r1 = r21
                boolean r3 = r2.isNull(r1)     // Catch:{ all -> 0x024c }
                if (r3 != 0) goto L_0x0200
                goto L_0x0207
            L_0x0200:
                r20 = r0
                r37 = 0
                goto L_0x022a
            L_0x0205:
                r1 = r21
            L_0x0207:
                boolean r3 = r2.isNull(r0)     // Catch:{ all -> 0x024c }
                if (r3 == 0) goto L_0x020f
                r3 = 0
                goto L_0x0213
            L_0x020f:
                java.lang.String r3 = r2.getString(r0)     // Catch:{ all -> 0x024c }
            L_0x0213:
                boolean r5 = r2.isNull(r1)     // Catch:{ all -> 0x024c }
                if (r5 == 0) goto L_0x021d
                r20 = r0
                r5 = 0
                goto L_0x0223
            L_0x021d:
                java.lang.String r5 = r2.getString(r1)     // Catch:{ all -> 0x024c }
                r20 = r0
            L_0x0223:
                com.coffeemeetsbagel.models.entities.ProfileEducationEntity r0 = new com.coffeemeetsbagel.models.entities.ProfileEducationEntity     // Catch:{ all -> 0x024c }
                r0.<init>(r3, r5)     // Catch:{ all -> 0x024c }
                r37 = r0
            L_0x022a:
                com.coffeemeetsbagel.models.entities.ProfileEntity r0 = new com.coffeemeetsbagel.models.entities.ProfileEntity     // Catch:{ all -> 0x024c }
                r23 = r0
                r23.<init>(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)     // Catch:{ all -> 0x024c }
                r4.add(r0)     // Catch:{ all -> 0x024c }
                r21 = r1
                r3 = r16
                r5 = r17
                r17 = r18
                r18 = r19
                r0 = r39
                r19 = r40
                r1 = r41
                r16 = r15
                goto L_0x0099
            L_0x0248:
                r2.close()
                return r4
            L_0x024c:
                r0 = move-exception
                r2.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.database.daos.j0.a.call():java.util.List");
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11774a.g();
        }
    }

    class b implements Callable<List<ProfileEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11776a;

        b(k0 k0Var) {
            this.f11776a = k0Var;
        }

        /* JADX WARNING: Removed duplicated region for block: B:67:0x01b2 A[Catch:{ all -> 0x024c }] */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x01d0 A[Catch:{ all -> 0x024c }] */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x01f7 A[Catch:{ all -> 0x024c }] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0205 A[Catch:{ all -> 0x024c }] */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x020d A[Catch:{ all -> 0x024c }] */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x020f A[Catch:{ all -> 0x024c }] */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0219 A[Catch:{ all -> 0x024c }] */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x021d A[Catch:{ all -> 0x024c }] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.List<com.coffeemeetsbagel.models.entities.ProfileEntity> call() throws java.lang.Exception {
            /*
                r41 = this;
                r1 = r41
                com.coffeemeetsbagel.database.daos.j0 r0 = com.coffeemeetsbagel.database.daos.j0.this
                androidx.room.RoomDatabase r0 = r0.f11766a
                androidx.room.k0 r2 = r1.f11776a
                r3 = 0
                r4 = 0
                android.database.Cursor r2 = q1.b.b(r0, r2, r3, r4)
                java.lang.String r0 = "id"
                int r0 = q1.a.e(r2, r0)     // Catch:{ all -> 0x024c }
                java.lang.String r3 = "age"
                int r3 = q1.a.e(r2, r3)     // Catch:{ all -> 0x024c }
                java.lang.String r5 = "city"
                int r5 = q1.a.e(r2, r5)     // Catch:{ all -> 0x024c }
                java.lang.String r6 = "country"
                int r6 = q1.a.e(r2, r6)     // Catch:{ all -> 0x024c }
                java.lang.String r7 = "employer"
                int r7 = q1.a.e(r2, r7)     // Catch:{ all -> 0x024c }
                java.lang.String r8 = "ethnicities"
                int r8 = q1.a.e(r2, r8)     // Catch:{ all -> 0x024c }
                java.lang.String r9 = "first_name"
                int r9 = q1.a.e(r2, r9)     // Catch:{ all -> 0x024c }
                java.lang.String r10 = "gender"
                int r10 = q1.a.e(r2, r10)     // Catch:{ all -> 0x024c }
                java.lang.String r11 = "last_name"
                int r11 = q1.a.e(r2, r11)     // Catch:{ all -> 0x024c }
                java.lang.String r12 = "occupation"
                int r12 = q1.a.e(r2, r12)     // Catch:{ all -> 0x024c }
                java.lang.String r13 = "religion"
                int r13 = q1.a.e(r2, r13)     // Catch:{ all -> 0x024c }
                java.lang.String r14 = "state"
                int r14 = q1.a.e(r2, r14)     // Catch:{ all -> 0x024c }
                java.lang.String r15 = "school"
                int r15 = q1.a.e(r2, r15)     // Catch:{ all -> 0x024c }
                java.lang.String r4 = "degree_id"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x024c }
                r16 = r4
                java.lang.String r4 = "height_cm"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x024c }
                r17 = r4
                java.lang.String r4 = "height_feet"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x024c }
                r18 = r4
                java.lang.String r4 = "height_inches"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x024c }
                r19 = r4
                java.lang.String r4 = "secondary_school"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x024c }
                r20 = r4
                java.lang.String r4 = "secondary_degree_id"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x024c }
                r21 = r4
                java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x024c }
                r22 = r15
                int r15 = r2.getCount()     // Catch:{ all -> 0x024c }
                r4.<init>(r15)     // Catch:{ all -> 0x024c }
            L_0x0099:
                boolean r15 = r2.moveToNext()     // Catch:{ all -> 0x024c }
                if (r15 == 0) goto L_0x0248
                boolean r15 = r2.isNull(r0)     // Catch:{ all -> 0x024c }
                if (r15 == 0) goto L_0x00a8
                r24 = 0
                goto L_0x00ae
            L_0x00a8:
                java.lang.String r15 = r2.getString(r0)     // Catch:{ all -> 0x024c }
                r24 = r15
            L_0x00ae:
                int r25 = r2.getInt(r3)     // Catch:{ all -> 0x024c }
                boolean r15 = r2.isNull(r5)     // Catch:{ all -> 0x024c }
                if (r15 == 0) goto L_0x00bb
                r26 = 0
                goto L_0x00c1
            L_0x00bb:
                java.lang.String r15 = r2.getString(r5)     // Catch:{ all -> 0x024c }
                r26 = r15
            L_0x00c1:
                boolean r15 = r2.isNull(r6)     // Catch:{ all -> 0x024c }
                if (r15 == 0) goto L_0x00ca
                r27 = 0
                goto L_0x00d0
            L_0x00ca:
                java.lang.String r15 = r2.getString(r6)     // Catch:{ all -> 0x024c }
                r27 = r15
            L_0x00d0:
                boolean r15 = r2.isNull(r7)     // Catch:{ all -> 0x024c }
                if (r15 == 0) goto L_0x00d9
                r29 = 0
                goto L_0x00df
            L_0x00d9:
                java.lang.String r15 = r2.getString(r7)     // Catch:{ all -> 0x024c }
                r29 = r15
            L_0x00df:
                boolean r15 = r2.isNull(r8)     // Catch:{ all -> 0x024c }
                if (r15 == 0) goto L_0x00e9
                r39 = r0
                r15 = 0
                goto L_0x00ef
            L_0x00e9:
                java.lang.String r15 = r2.getString(r8)     // Catch:{ all -> 0x024c }
                r39 = r0
            L_0x00ef:
                com.coffeemeetsbagel.database.daos.j0 r0 = com.coffeemeetsbagel.database.daos.j0.this     // Catch:{ all -> 0x024c }
                g6.b r0 = r0.f11768c     // Catch:{ all -> 0x024c }
                java.util.List r30 = r0.b(r15)     // Catch:{ all -> 0x024c }
                boolean r0 = r2.isNull(r9)     // Catch:{ all -> 0x024c }
                if (r0 == 0) goto L_0x0102
                r31 = 0
                goto L_0x0108
            L_0x0102:
                java.lang.String r0 = r2.getString(r9)     // Catch:{ all -> 0x024c }
                r31 = r0
            L_0x0108:
                boolean r0 = r2.isNull(r10)     // Catch:{ all -> 0x024c }
                if (r0 == 0) goto L_0x0110
                r0 = 0
                goto L_0x0114
            L_0x0110:
                java.lang.String r0 = r2.getString(r10)     // Catch:{ all -> 0x024c }
            L_0x0114:
                com.coffeemeetsbagel.database.daos.j0 r15 = com.coffeemeetsbagel.database.daos.j0.this     // Catch:{ all -> 0x024c }
                g6.c r15 = r15.f11769d     // Catch:{ all -> 0x024c }
                com.coffeemeetsbagel.models.entities.GenderType r32 = r15.b(r0)     // Catch:{ all -> 0x024c }
                boolean r0 = r2.isNull(r11)     // Catch:{ all -> 0x024c }
                if (r0 == 0) goto L_0x0127
                r34 = 0
                goto L_0x012d
            L_0x0127:
                java.lang.String r0 = r2.getString(r11)     // Catch:{ all -> 0x024c }
                r34 = r0
            L_0x012d:
                boolean r0 = r2.isNull(r12)     // Catch:{ all -> 0x024c }
                if (r0 == 0) goto L_0x0136
                r35 = 0
                goto L_0x013c
            L_0x0136:
                java.lang.String r0 = r2.getString(r12)     // Catch:{ all -> 0x024c }
                r35 = r0
            L_0x013c:
                boolean r0 = r2.isNull(r13)     // Catch:{ all -> 0x024c }
                if (r0 == 0) goto L_0x0144
                r0 = 0
                goto L_0x0148
            L_0x0144:
                java.lang.String r0 = r2.getString(r13)     // Catch:{ all -> 0x024c }
            L_0x0148:
                com.coffeemeetsbagel.database.daos.j0 r15 = com.coffeemeetsbagel.database.daos.j0.this     // Catch:{ all -> 0x024c }
                g6.n r15 = r15.f11770e     // Catch:{ all -> 0x024c }
                com.coffeemeetsbagel.models.entities.ReligionType r36 = r15.b(r0)     // Catch:{ all -> 0x024c }
                boolean r0 = r2.isNull(r14)     // Catch:{ all -> 0x024c }
                if (r0 == 0) goto L_0x015d
                r0 = r22
                r38 = 0
                goto L_0x0165
            L_0x015d:
                java.lang.String r0 = r2.getString(r14)     // Catch:{ all -> 0x024c }
                r38 = r0
                r0 = r22
            L_0x0165:
                boolean r15 = r2.isNull(r0)     // Catch:{ all -> 0x024c }
                if (r15 == 0) goto L_0x017d
                r15 = r16
                boolean r16 = r2.isNull(r15)     // Catch:{ all -> 0x024c }
                if (r16 != 0) goto L_0x0174
                goto L_0x017f
            L_0x0174:
                r22 = r0
                r16 = r3
                r0 = r17
                r28 = 0
                goto L_0x01ac
            L_0x017d:
                r15 = r16
            L_0x017f:
                boolean r16 = r2.isNull(r0)     // Catch:{ all -> 0x024c }
                if (r16 == 0) goto L_0x0189
                r22 = r0
                r0 = 0
                goto L_0x0191
            L_0x0189:
                java.lang.String r16 = r2.getString(r0)     // Catch:{ all -> 0x024c }
                r22 = r0
                r0 = r16
            L_0x0191:
                boolean r16 = r2.isNull(r15)     // Catch:{ all -> 0x024c }
                if (r16 == 0) goto L_0x019b
                r16 = r3
                r1 = 0
                goto L_0x01a3
            L_0x019b:
                java.lang.String r16 = r2.getString(r15)     // Catch:{ all -> 0x024c }
                r1 = r16
                r16 = r3
            L_0x01a3:
                com.coffeemeetsbagel.models.entities.ProfileEducationEntity r3 = new com.coffeemeetsbagel.models.entities.ProfileEducationEntity     // Catch:{ all -> 0x024c }
                r3.<init>(r0, r1)     // Catch:{ all -> 0x024c }
                r28 = r3
                r0 = r17
            L_0x01ac:
                boolean r1 = r2.isNull(r0)     // Catch:{ all -> 0x024c }
                if (r1 == 0) goto L_0x01d0
                r1 = r18
                boolean r3 = r2.isNull(r1)     // Catch:{ all -> 0x024c }
                if (r3 == 0) goto L_0x01d2
                r3 = r19
                boolean r17 = r2.isNull(r3)     // Catch:{ all -> 0x024c }
                if (r17 != 0) goto L_0x01c3
                goto L_0x01d4
            L_0x01c3:
                r18 = r0
                r19 = r1
                r40 = r3
                r17 = r5
                r0 = r20
                r33 = 0
                goto L_0x01f1
            L_0x01d0:
                r1 = r18
            L_0x01d2:
                r3 = r19
            L_0x01d4:
                r17 = r5
                int r5 = r2.getInt(r0)     // Catch:{ all -> 0x024c }
                r18 = r0
                int r0 = r2.getInt(r1)     // Catch:{ all -> 0x024c }
                r19 = r1
                int r1 = r2.getInt(r3)     // Catch:{ all -> 0x024c }
                r40 = r3
                com.coffeemeetsbagel.models.entities.Height r3 = new com.coffeemeetsbagel.models.entities.Height     // Catch:{ all -> 0x024c }
                r3.<init>(r5, r0, r1)     // Catch:{ all -> 0x024c }
                r33 = r3
                r0 = r20
            L_0x01f1:
                boolean r1 = r2.isNull(r0)     // Catch:{ all -> 0x024c }
                if (r1 == 0) goto L_0x0205
                r1 = r21
                boolean r3 = r2.isNull(r1)     // Catch:{ all -> 0x024c }
                if (r3 != 0) goto L_0x0200
                goto L_0x0207
            L_0x0200:
                r20 = r0
                r37 = 0
                goto L_0x022a
            L_0x0205:
                r1 = r21
            L_0x0207:
                boolean r3 = r2.isNull(r0)     // Catch:{ all -> 0x024c }
                if (r3 == 0) goto L_0x020f
                r3 = 0
                goto L_0x0213
            L_0x020f:
                java.lang.String r3 = r2.getString(r0)     // Catch:{ all -> 0x024c }
            L_0x0213:
                boolean r5 = r2.isNull(r1)     // Catch:{ all -> 0x024c }
                if (r5 == 0) goto L_0x021d
                r20 = r0
                r5 = 0
                goto L_0x0223
            L_0x021d:
                java.lang.String r5 = r2.getString(r1)     // Catch:{ all -> 0x024c }
                r20 = r0
            L_0x0223:
                com.coffeemeetsbagel.models.entities.ProfileEducationEntity r0 = new com.coffeemeetsbagel.models.entities.ProfileEducationEntity     // Catch:{ all -> 0x024c }
                r0.<init>(r3, r5)     // Catch:{ all -> 0x024c }
                r37 = r0
            L_0x022a:
                com.coffeemeetsbagel.models.entities.ProfileEntity r0 = new com.coffeemeetsbagel.models.entities.ProfileEntity     // Catch:{ all -> 0x024c }
                r23 = r0
                r23.<init>(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)     // Catch:{ all -> 0x024c }
                r4.add(r0)     // Catch:{ all -> 0x024c }
                r21 = r1
                r3 = r16
                r5 = r17
                r17 = r18
                r18 = r19
                r0 = r39
                r19 = r40
                r1 = r41
                r16 = r15
                goto L_0x0099
            L_0x0248:
                r2.close()
                return r4
            L_0x024c:
                r0 = move-exception
                r2.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.database.daos.j0.b.call():java.util.List");
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11776a.g();
        }
    }

    class c implements Callable<Map<ProfileEntity, List<PhotoEntity>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11778a;

        c(k0 k0Var) {
            this.f11778a = k0Var;
        }

        /* JADX WARNING: Removed duplicated region for block: B:112:0x02bc A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:117:0x02d0 A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:118:0x02d3 A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:121:0x02df A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:122:0x02e2 A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:125:0x02f2 A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:126:0x02f5 A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:129:0x0301 A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:130:0x0306 A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x01ce A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x01ec A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0213 A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x0221 A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0229 A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x022b A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0235 A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x0239 A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x0253 A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x025c A[Catch:{ all -> 0x032a }] */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x026c A[Catch:{ all -> 0x032a }] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.Map<com.coffeemeetsbagel.models.entities.ProfileEntity, java.util.List<com.coffeemeetsbagel.models.entities.PhotoEntity>> call() throws java.lang.Exception {
            /*
                r46 = this;
                r1 = r46
                com.coffeemeetsbagel.database.daos.j0 r0 = com.coffeemeetsbagel.database.daos.j0.this
                androidx.room.RoomDatabase r0 = r0.f11766a
                androidx.room.k0 r2 = r1.f11778a
                r3 = 0
                r4 = 0
                android.database.Cursor r2 = q1.b.b(r0, r2, r3, r4)
                java.lang.String r0 = "id"
                int r0 = q1.a.e(r2, r0)     // Catch:{ all -> 0x032a }
                java.lang.String r3 = "age"
                int r3 = q1.a.e(r2, r3)     // Catch:{ all -> 0x032a }
                java.lang.String r5 = "city"
                int r5 = q1.a.e(r2, r5)     // Catch:{ all -> 0x032a }
                java.lang.String r6 = "country"
                int r6 = q1.a.e(r2, r6)     // Catch:{ all -> 0x032a }
                java.lang.String r7 = "employer"
                int r7 = q1.a.e(r2, r7)     // Catch:{ all -> 0x032a }
                java.lang.String r8 = "ethnicities"
                int r8 = q1.a.e(r2, r8)     // Catch:{ all -> 0x032a }
                java.lang.String r9 = "first_name"
                int r9 = q1.a.e(r2, r9)     // Catch:{ all -> 0x032a }
                java.lang.String r10 = "gender"
                int r10 = q1.a.e(r2, r10)     // Catch:{ all -> 0x032a }
                java.lang.String r11 = "last_name"
                int r11 = q1.a.e(r2, r11)     // Catch:{ all -> 0x032a }
                java.lang.String r12 = "occupation"
                int r12 = q1.a.e(r2, r12)     // Catch:{ all -> 0x032a }
                java.lang.String r13 = "religion"
                int r13 = q1.a.e(r2, r13)     // Catch:{ all -> 0x032a }
                java.lang.String r14 = "state"
                int r14 = q1.a.e(r2, r14)     // Catch:{ all -> 0x032a }
                java.lang.String r15 = "school"
                int r15 = q1.a.e(r2, r15)     // Catch:{ all -> 0x032a }
                java.lang.String r4 = "degree_id"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x032a }
                r16 = r4
                java.lang.String r4 = "height_cm"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x032a }
                r17 = r4
                java.lang.String r4 = "height_feet"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x032a }
                r18 = r4
                java.lang.String r4 = "height_inches"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x032a }
                r19 = r4
                java.lang.String r4 = "secondary_school"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x032a }
                r20 = r4
                java.lang.String r4 = "secondary_degree_id"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x032a }
                r21 = r4
                java.lang.String r4 = "photoId"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x032a }
                r22 = r4
                java.lang.String r4 = "caption"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x032a }
                r23 = r4
                java.lang.String r4 = "position"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x032a }
                r24 = r4
                java.lang.String r4 = "profile_id"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x032a }
                r25 = r4
                java.lang.String r4 = "url"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x032a }
                r26 = r4
                java.util.LinkedHashMap r4 = new java.util.LinkedHashMap     // Catch:{ all -> 0x032a }
                r4.<init>()     // Catch:{ all -> 0x032a }
            L_0x00bb:
                boolean r27 = r2.moveToNext()     // Catch:{ all -> 0x032a }
                if (r27 == 0) goto L_0x0326
                boolean r27 = r2.isNull(r0)     // Catch:{ all -> 0x032a }
                if (r27 == 0) goto L_0x00ca
                r29 = 0
                goto L_0x00d0
            L_0x00ca:
                java.lang.String r27 = r2.getString(r0)     // Catch:{ all -> 0x032a }
                r29 = r27
            L_0x00d0:
                int r30 = r2.getInt(r3)     // Catch:{ all -> 0x032a }
                boolean r27 = r2.isNull(r5)     // Catch:{ all -> 0x032a }
                if (r27 == 0) goto L_0x00dd
                r31 = 0
                goto L_0x00e3
            L_0x00dd:
                java.lang.String r27 = r2.getString(r5)     // Catch:{ all -> 0x032a }
                r31 = r27
            L_0x00e3:
                boolean r27 = r2.isNull(r6)     // Catch:{ all -> 0x032a }
                if (r27 == 0) goto L_0x00ec
                r32 = 0
                goto L_0x00f2
            L_0x00ec:
                java.lang.String r27 = r2.getString(r6)     // Catch:{ all -> 0x032a }
                r32 = r27
            L_0x00f2:
                boolean r27 = r2.isNull(r7)     // Catch:{ all -> 0x032a }
                if (r27 == 0) goto L_0x00fb
                r34 = 0
                goto L_0x0101
            L_0x00fb:
                java.lang.String r27 = r2.getString(r7)     // Catch:{ all -> 0x032a }
                r34 = r27
            L_0x0101:
                boolean r27 = r2.isNull(r8)     // Catch:{ all -> 0x032a }
                if (r27 == 0) goto L_0x010d
                r44 = r0
                r27 = r3
                r0 = 0
                goto L_0x0117
            L_0x010d:
                java.lang.String r27 = r2.getString(r8)     // Catch:{ all -> 0x032a }
                r44 = r0
                r0 = r27
                r27 = r3
            L_0x0117:
                com.coffeemeetsbagel.database.daos.j0 r3 = com.coffeemeetsbagel.database.daos.j0.this     // Catch:{ all -> 0x032a }
                g6.b r3 = r3.f11768c     // Catch:{ all -> 0x032a }
                java.util.List r35 = r3.b(r0)     // Catch:{ all -> 0x032a }
                boolean r0 = r2.isNull(r9)     // Catch:{ all -> 0x032a }
                if (r0 == 0) goto L_0x012a
                r36 = 0
                goto L_0x0130
            L_0x012a:
                java.lang.String r0 = r2.getString(r9)     // Catch:{ all -> 0x032a }
                r36 = r0
            L_0x0130:
                boolean r0 = r2.isNull(r10)     // Catch:{ all -> 0x032a }
                if (r0 == 0) goto L_0x0138
                r0 = 0
                goto L_0x013c
            L_0x0138:
                java.lang.String r0 = r2.getString(r10)     // Catch:{ all -> 0x032a }
            L_0x013c:
                com.coffeemeetsbagel.database.daos.j0 r3 = com.coffeemeetsbagel.database.daos.j0.this     // Catch:{ all -> 0x032a }
                g6.c r3 = r3.f11769d     // Catch:{ all -> 0x032a }
                com.coffeemeetsbagel.models.entities.GenderType r37 = r3.b(r0)     // Catch:{ all -> 0x032a }
                boolean r0 = r2.isNull(r11)     // Catch:{ all -> 0x032a }
                if (r0 == 0) goto L_0x014f
                r39 = 0
                goto L_0x0155
            L_0x014f:
                java.lang.String r0 = r2.getString(r11)     // Catch:{ all -> 0x032a }
                r39 = r0
            L_0x0155:
                boolean r0 = r2.isNull(r12)     // Catch:{ all -> 0x032a }
                if (r0 == 0) goto L_0x015e
                r40 = 0
                goto L_0x0164
            L_0x015e:
                java.lang.String r0 = r2.getString(r12)     // Catch:{ all -> 0x032a }
                r40 = r0
            L_0x0164:
                boolean r0 = r2.isNull(r13)     // Catch:{ all -> 0x032a }
                if (r0 == 0) goto L_0x016c
                r0 = 0
                goto L_0x0170
            L_0x016c:
                java.lang.String r0 = r2.getString(r13)     // Catch:{ all -> 0x032a }
            L_0x0170:
                com.coffeemeetsbagel.database.daos.j0 r3 = com.coffeemeetsbagel.database.daos.j0.this     // Catch:{ all -> 0x032a }
                g6.n r3 = r3.f11770e     // Catch:{ all -> 0x032a }
                com.coffeemeetsbagel.models.entities.ReligionType r41 = r3.b(r0)     // Catch:{ all -> 0x032a }
                boolean r0 = r2.isNull(r14)     // Catch:{ all -> 0x032a }
                if (r0 == 0) goto L_0x0183
                r43 = 0
                goto L_0x0189
            L_0x0183:
                java.lang.String r0 = r2.getString(r14)     // Catch:{ all -> 0x032a }
                r43 = r0
            L_0x0189:
                boolean r0 = r2.isNull(r15)     // Catch:{ all -> 0x032a }
                if (r0 == 0) goto L_0x019f
                r0 = r16
                boolean r3 = r2.isNull(r0)     // Catch:{ all -> 0x032a }
                if (r3 != 0) goto L_0x0198
                goto L_0x01a1
            L_0x0198:
                r45 = r0
                r0 = r17
                r33 = 0
                goto L_0x01c8
            L_0x019f:
                r0 = r16
            L_0x01a1:
                boolean r3 = r2.isNull(r15)     // Catch:{ all -> 0x032a }
                if (r3 == 0) goto L_0x01a9
                r3 = 0
                goto L_0x01ad
            L_0x01a9:
                java.lang.String r3 = r2.getString(r15)     // Catch:{ all -> 0x032a }
            L_0x01ad:
                boolean r16 = r2.isNull(r0)     // Catch:{ all -> 0x032a }
                if (r16 == 0) goto L_0x01b7
                r45 = r0
                r0 = 0
                goto L_0x01bf
            L_0x01b7:
                java.lang.String r16 = r2.getString(r0)     // Catch:{ all -> 0x032a }
                r45 = r0
                r0 = r16
            L_0x01bf:
                com.coffeemeetsbagel.models.entities.ProfileEducationEntity r1 = new com.coffeemeetsbagel.models.entities.ProfileEducationEntity     // Catch:{ all -> 0x032a }
                r1.<init>(r3, r0)     // Catch:{ all -> 0x032a }
                r33 = r1
                r0 = r17
            L_0x01c8:
                boolean r1 = r2.isNull(r0)     // Catch:{ all -> 0x032a }
                if (r1 == 0) goto L_0x01ec
                r1 = r18
                boolean r3 = r2.isNull(r1)     // Catch:{ all -> 0x032a }
                if (r3 == 0) goto L_0x01ee
                r3 = r19
                boolean r16 = r2.isNull(r3)     // Catch:{ all -> 0x032a }
                if (r16 != 0) goto L_0x01df
                goto L_0x01f0
            L_0x01df:
                r17 = r0
                r18 = r1
                r19 = r3
                r16 = r5
                r0 = r20
                r38 = 0
                goto L_0x020d
            L_0x01ec:
                r1 = r18
            L_0x01ee:
                r3 = r19
            L_0x01f0:
                r16 = r5
                int r5 = r2.getInt(r0)     // Catch:{ all -> 0x032a }
                r17 = r0
                int r0 = r2.getInt(r1)     // Catch:{ all -> 0x032a }
                r18 = r1
                int r1 = r2.getInt(r3)     // Catch:{ all -> 0x032a }
                r19 = r3
                com.coffeemeetsbagel.models.entities.Height r3 = new com.coffeemeetsbagel.models.entities.Height     // Catch:{ all -> 0x032a }
                r3.<init>(r5, r0, r1)     // Catch:{ all -> 0x032a }
                r38 = r3
                r0 = r20
            L_0x020d:
                boolean r1 = r2.isNull(r0)     // Catch:{ all -> 0x032a }
                if (r1 == 0) goto L_0x0221
                r1 = r21
                boolean r3 = r2.isNull(r1)     // Catch:{ all -> 0x032a }
                if (r3 != 0) goto L_0x021c
                goto L_0x0223
            L_0x021c:
                r20 = r0
                r42 = 0
                goto L_0x0246
            L_0x0221:
                r1 = r21
            L_0x0223:
                boolean r3 = r2.isNull(r0)     // Catch:{ all -> 0x032a }
                if (r3 == 0) goto L_0x022b
                r3 = 0
                goto L_0x022f
            L_0x022b:
                java.lang.String r3 = r2.getString(r0)     // Catch:{ all -> 0x032a }
            L_0x022f:
                boolean r5 = r2.isNull(r1)     // Catch:{ all -> 0x032a }
                if (r5 == 0) goto L_0x0239
                r20 = r0
                r5 = 0
                goto L_0x023f
            L_0x0239:
                java.lang.String r5 = r2.getString(r1)     // Catch:{ all -> 0x032a }
                r20 = r0
            L_0x023f:
                com.coffeemeetsbagel.models.entities.ProfileEducationEntity r0 = new com.coffeemeetsbagel.models.entities.ProfileEducationEntity     // Catch:{ all -> 0x032a }
                r0.<init>(r3, r5)     // Catch:{ all -> 0x032a }
                r42 = r0
            L_0x0246:
                com.coffeemeetsbagel.models.entities.ProfileEntity r0 = new com.coffeemeetsbagel.models.entities.ProfileEntity     // Catch:{ all -> 0x032a }
                r28 = r0
                r28.<init>(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43)     // Catch:{ all -> 0x032a }
                boolean r3 = r4.containsKey(r0)     // Catch:{ all -> 0x032a }
                if (r3 == 0) goto L_0x025c
                java.lang.Object r0 = r4.get(r0)     // Catch:{ all -> 0x032a }
                java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x032a }
            L_0x0259:
                r3 = r22
                goto L_0x0266
            L_0x025c:
                java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x032a }
                r3.<init>()     // Catch:{ all -> 0x032a }
                r4.put(r0, r3)     // Catch:{ all -> 0x032a }
                r0 = r3
                goto L_0x0259
            L_0x0266:
                boolean r5 = r2.isNull(r3)     // Catch:{ all -> 0x032a }
                if (r5 == 0) goto L_0x02bc
                r5 = r23
                boolean r21 = r2.isNull(r5)     // Catch:{ all -> 0x032a }
                if (r21 == 0) goto L_0x02b1
                r21 = r1
                r1 = r24
                boolean r22 = r2.isNull(r1)     // Catch:{ all -> 0x032a }
                if (r22 == 0) goto L_0x02ac
                r22 = r6
                r6 = r25
                boolean r23 = r2.isNull(r6)     // Catch:{ all -> 0x032a }
                if (r23 == 0) goto L_0x02c6
                r23 = r7
                r7 = r26
                boolean r24 = r2.isNull(r7)     // Catch:{ all -> 0x032a }
                if (r24 == 0) goto L_0x02ca
                r24 = r1
                r25 = r6
                r26 = r7
                r6 = r22
                r7 = r23
                r0 = r44
                r1 = r46
            L_0x02a0:
                r22 = r3
                r23 = r5
                r5 = r16
                r3 = r27
                r16 = r45
                goto L_0x00bb
            L_0x02ac:
                r22 = r6
                r23 = r7
                goto L_0x02b9
            L_0x02b1:
                r21 = r1
                r22 = r6
                r23 = r7
                r1 = r24
            L_0x02b9:
                r6 = r25
                goto L_0x02c8
            L_0x02bc:
                r21 = r1
                r22 = r6
                r5 = r23
                r1 = r24
                r6 = r25
            L_0x02c6:
                r23 = r7
            L_0x02c8:
                r7 = r26
            L_0x02ca:
                boolean r24 = r2.isNull(r3)     // Catch:{ all -> 0x032a }
                if (r24 == 0) goto L_0x02d3
                r29 = 0
                goto L_0x02d9
            L_0x02d3:
                java.lang.String r24 = r2.getString(r3)     // Catch:{ all -> 0x032a }
                r29 = r24
            L_0x02d9:
                boolean r24 = r2.isNull(r5)     // Catch:{ all -> 0x032a }
                if (r24 == 0) goto L_0x02e2
                r30 = 0
                goto L_0x02e8
            L_0x02e2:
                java.lang.String r24 = r2.getString(r5)     // Catch:{ all -> 0x032a }
                r30 = r24
            L_0x02e8:
                int r31 = r2.getInt(r1)     // Catch:{ all -> 0x032a }
                boolean r24 = r2.isNull(r6)     // Catch:{ all -> 0x032a }
                if (r24 == 0) goto L_0x02f5
                r32 = 0
                goto L_0x02fb
            L_0x02f5:
                java.lang.String r24 = r2.getString(r6)     // Catch:{ all -> 0x032a }
                r32 = r24
            L_0x02fb:
                boolean r24 = r2.isNull(r7)     // Catch:{ all -> 0x032a }
                if (r24 == 0) goto L_0x0306
                r24 = r1
                r33 = 0
                goto L_0x030e
            L_0x0306:
                java.lang.String r24 = r2.getString(r7)     // Catch:{ all -> 0x032a }
                r33 = r24
                r24 = r1
            L_0x030e:
                com.coffeemeetsbagel.models.entities.PhotoEntity r1 = new com.coffeemeetsbagel.models.entities.PhotoEntity     // Catch:{ all -> 0x032a }
                r28 = r1
                r28.<init>(r29, r30, r31, r32, r33)     // Catch:{ all -> 0x032a }
                r0.add(r1)     // Catch:{ all -> 0x032a }
                r1 = r46
                r25 = r6
                r26 = r7
                r6 = r22
                r7 = r23
                r0 = r44
                goto L_0x02a0
            L_0x0326:
                r2.close()
                return r4
            L_0x032a:
                r0 = move-exception
                r2.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.database.daos.j0.c.call():java.util.Map");
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11778a.g();
        }
    }

    class d implements Callable<List<PhotoEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11780a;

        d(k0 k0Var) {
            this.f11780a = k0Var;
        }

        /* renamed from: a */
        public List<PhotoEntity> call() throws Exception {
            String str;
            String str2;
            String str3;
            String str4;
            Cursor b10 = q1.b.b(j0.this.f11766a, this.f11780a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "photoId");
                int e11 = q1.a.e(b10, "caption");
                int e12 = q1.a.e(b10, "position");
                int e13 = q1.a.e(b10, Extra.PROFILE_ID);
                int e14 = q1.a.e(b10, "url");
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
                    arrayList.add(new PhotoEntity(str, str2, i10, str3, str4));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11780a.g();
        }
    }

    class e extends androidx.room.h<ProfileEntity> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `profiles` (`id`,`age`,`city`,`country`,`employer`,`ethnicities`,`first_name`,`gender`,`last_name`,`occupation`,`religion`,`state`,`school`,`degree_id`,`height_cm`,`height_feet`,`height_inches`,`secondary_school`,`secondary_degree_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, ProfileEntity profileEntity) {
            if (profileEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, profileEntity.getId());
            }
            mVar.f1(2, (long) profileEntity.getAge());
            if (profileEntity.getCity() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, profileEntity.getCity());
            }
            if (profileEntity.getCountry() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, profileEntity.getCountry());
            }
            if (profileEntity.getEmployer() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, profileEntity.getEmployer());
            }
            String a10 = j0.this.f11768c.a(profileEntity.getEthnicities());
            if (a10 == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, a10);
            }
            if (profileEntity.getFirstName() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, profileEntity.getFirstName());
            }
            String a11 = j0.this.f11769d.a(profileEntity.getGender());
            if (a11 == null) {
                mVar.B1(8);
            } else {
                mVar.P0(8, a11);
            }
            if (profileEntity.getLastName() == null) {
                mVar.B1(9);
            } else {
                mVar.P0(9, profileEntity.getLastName());
            }
            if (profileEntity.getOccupation() == null) {
                mVar.B1(10);
            } else {
                mVar.P0(10, profileEntity.getOccupation());
            }
            String a12 = j0.this.f11770e.a(profileEntity.getReligion());
            if (a12 == null) {
                mVar.B1(11);
            } else {
                mVar.P0(11, a12);
            }
            if (profileEntity.getState() == null) {
                mVar.B1(12);
            } else {
                mVar.P0(12, profileEntity.getState());
            }
            ProfileEducationEntity education = profileEntity.getEducation();
            if (education != null) {
                if (education.getSchool() == null) {
                    mVar.B1(13);
                } else {
                    mVar.P0(13, education.getSchool());
                }
                if (education.getDegreeId() == null) {
                    mVar.B1(14);
                } else {
                    mVar.P0(14, education.getDegreeId());
                }
            } else {
                mVar.B1(13);
                mVar.B1(14);
            }
            Height height = profileEntity.getHeight();
            if (height != null) {
                mVar.f1(15, (long) height.getHeightCm());
                mVar.f1(16, (long) height.getHeightFeet());
                mVar.f1(17, (long) height.getHeightInches());
            } else {
                mVar.B1(15);
                mVar.B1(16);
                mVar.B1(17);
            }
            ProfileEducationEntity secondaryEducation = profileEntity.getSecondaryEducation();
            if (secondaryEducation != null) {
                if (secondaryEducation.getSchool() == null) {
                    mVar.B1(18);
                } else {
                    mVar.P0(18, secondaryEducation.getSchool());
                }
                if (secondaryEducation.getDegreeId() == null) {
                    mVar.B1(19);
                } else {
                    mVar.P0(19, secondaryEducation.getDegreeId());
                }
            } else {
                mVar.B1(18);
                mVar.B1(19);
            }
        }
    }

    class f extends androidx.room.h<ProfileEntity> {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `profiles` (`id`,`age`,`city`,`country`,`employer`,`ethnicities`,`first_name`,`gender`,`last_name`,`occupation`,`religion`,`state`,`school`,`degree_id`,`height_cm`,`height_feet`,`height_inches`,`secondary_school`,`secondary_degree_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, ProfileEntity profileEntity) {
            if (profileEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, profileEntity.getId());
            }
            mVar.f1(2, (long) profileEntity.getAge());
            if (profileEntity.getCity() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, profileEntity.getCity());
            }
            if (profileEntity.getCountry() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, profileEntity.getCountry());
            }
            if (profileEntity.getEmployer() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, profileEntity.getEmployer());
            }
            String a10 = j0.this.f11768c.a(profileEntity.getEthnicities());
            if (a10 == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, a10);
            }
            if (profileEntity.getFirstName() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, profileEntity.getFirstName());
            }
            String a11 = j0.this.f11769d.a(profileEntity.getGender());
            if (a11 == null) {
                mVar.B1(8);
            } else {
                mVar.P0(8, a11);
            }
            if (profileEntity.getLastName() == null) {
                mVar.B1(9);
            } else {
                mVar.P0(9, profileEntity.getLastName());
            }
            if (profileEntity.getOccupation() == null) {
                mVar.B1(10);
            } else {
                mVar.P0(10, profileEntity.getOccupation());
            }
            String a12 = j0.this.f11770e.a(profileEntity.getReligion());
            if (a12 == null) {
                mVar.B1(11);
            } else {
                mVar.P0(11, a12);
            }
            if (profileEntity.getState() == null) {
                mVar.B1(12);
            } else {
                mVar.P0(12, profileEntity.getState());
            }
            ProfileEducationEntity education = profileEntity.getEducation();
            if (education != null) {
                if (education.getSchool() == null) {
                    mVar.B1(13);
                } else {
                    mVar.P0(13, education.getSchool());
                }
                if (education.getDegreeId() == null) {
                    mVar.B1(14);
                } else {
                    mVar.P0(14, education.getDegreeId());
                }
            } else {
                mVar.B1(13);
                mVar.B1(14);
            }
            Height height = profileEntity.getHeight();
            if (height != null) {
                mVar.f1(15, (long) height.getHeightCm());
                mVar.f1(16, (long) height.getHeightFeet());
                mVar.f1(17, (long) height.getHeightInches());
            } else {
                mVar.B1(15);
                mVar.B1(16);
                mVar.B1(17);
            }
            ProfileEducationEntity secondaryEducation = profileEntity.getSecondaryEducation();
            if (secondaryEducation != null) {
                if (secondaryEducation.getSchool() == null) {
                    mVar.B1(18);
                } else {
                    mVar.P0(18, secondaryEducation.getSchool());
                }
                if (secondaryEducation.getDegreeId() == null) {
                    mVar.B1(19);
                } else {
                    mVar.P0(19, secondaryEducation.getDegreeId());
                }
            } else {
                mVar.B1(18);
                mVar.B1(19);
            }
        }
    }

    class g extends androidx.room.g<ProfileEntity> {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `profiles` WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, ProfileEntity profileEntity) {
            if (profileEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, profileEntity.getId());
            }
        }
    }

    class h extends androidx.room.g<ProfileEntity> {
        h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `profiles` SET `id` = ?,`age` = ?,`city` = ?,`country` = ?,`employer` = ?,`ethnicities` = ?,`first_name` = ?,`gender` = ?,`last_name` = ?,`occupation` = ?,`religion` = ?,`state` = ?,`school` = ?,`degree_id` = ?,`height_cm` = ?,`height_feet` = ?,`height_inches` = ?,`secondary_school` = ?,`secondary_degree_id` = ? WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, ProfileEntity profileEntity) {
            if (profileEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, profileEntity.getId());
            }
            mVar.f1(2, (long) profileEntity.getAge());
            if (profileEntity.getCity() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, profileEntity.getCity());
            }
            if (profileEntity.getCountry() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, profileEntity.getCountry());
            }
            if (profileEntity.getEmployer() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, profileEntity.getEmployer());
            }
            String a10 = j0.this.f11768c.a(profileEntity.getEthnicities());
            if (a10 == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, a10);
            }
            if (profileEntity.getFirstName() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, profileEntity.getFirstName());
            }
            String a11 = j0.this.f11769d.a(profileEntity.getGender());
            if (a11 == null) {
                mVar.B1(8);
            } else {
                mVar.P0(8, a11);
            }
            if (profileEntity.getLastName() == null) {
                mVar.B1(9);
            } else {
                mVar.P0(9, profileEntity.getLastName());
            }
            if (profileEntity.getOccupation() == null) {
                mVar.B1(10);
            } else {
                mVar.P0(10, profileEntity.getOccupation());
            }
            String a12 = j0.this.f11770e.a(profileEntity.getReligion());
            if (a12 == null) {
                mVar.B1(11);
            } else {
                mVar.P0(11, a12);
            }
            if (profileEntity.getState() == null) {
                mVar.B1(12);
            } else {
                mVar.P0(12, profileEntity.getState());
            }
            ProfileEducationEntity education = profileEntity.getEducation();
            if (education != null) {
                if (education.getSchool() == null) {
                    mVar.B1(13);
                } else {
                    mVar.P0(13, education.getSchool());
                }
                if (education.getDegreeId() == null) {
                    mVar.B1(14);
                } else {
                    mVar.P0(14, education.getDegreeId());
                }
            } else {
                mVar.B1(13);
                mVar.B1(14);
            }
            Height height = profileEntity.getHeight();
            if (height != null) {
                mVar.f1(15, (long) height.getHeightCm());
                mVar.f1(16, (long) height.getHeightFeet());
                mVar.f1(17, (long) height.getHeightInches());
            } else {
                mVar.B1(15);
                mVar.B1(16);
                mVar.B1(17);
            }
            ProfileEducationEntity secondaryEducation = profileEntity.getSecondaryEducation();
            if (secondaryEducation != null) {
                if (secondaryEducation.getSchool() == null) {
                    mVar.B1(18);
                } else {
                    mVar.P0(18, secondaryEducation.getSchool());
                }
                if (secondaryEducation.getDegreeId() == null) {
                    mVar.B1(19);
                } else {
                    mVar.P0(19, secondaryEducation.getDegreeId());
                }
            } else {
                mVar.B1(18);
                mVar.B1(19);
            }
            if (profileEntity.getId() == null) {
                mVar.B1(20);
            } else {
                mVar.P0(20, profileEntity.getId());
            }
        }
    }

    public j0(RoomDatabase roomDatabase) {
        this.f11766a = roomDatabase;
        this.f11767b = new e(roomDatabase);
        this.f11771f = new f(roomDatabase);
        this.f11772g = new g(roomDatabase);
        this.f11773h = new h(roomDatabase);
    }

    public static List<Class<?>> G() {
        return Collections.emptyList();
    }

    public qj.h<Map<ProfileEntity, List<PhotoEntity>>> A(List<String> list) {
        StringBuilder b10 = q1.d.b();
        b10.append("SELECT * FROM profiles LEFT JOIN photos ON photos.profile_id = profiles.id WHERE profiles.id IN (");
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
        return l0.a(this.f11766a, false, new String[]{"profiles", "photos"}, new c(c10));
    }

    public int k(List<? extends ProfileEntity> list) {
        this.f11766a.d();
        this.f11766a.e();
        try {
            int k10 = this.f11773h.k(list) + 0;
            this.f11766a.C();
            return k10;
        } finally {
            this.f11766a.j();
        }
    }

    public int o(List<ProfileEntity> list) {
        this.f11766a.e();
        try {
            int F = super.o(list);
            this.f11766a.C();
            return F;
        } finally {
            this.f11766a.j();
        }
    }

    public List<Long> s(List<? extends ProfileEntity> list) {
        this.f11766a.d();
        this.f11766a.e();
        try {
            List<Long> m10 = this.f11767b.m(list);
            this.f11766a.C();
            return m10;
        } finally {
            this.f11766a.j();
        }
    }

    public qj.h<List<PhotoEntity>> u(String str) {
        k0 c10 = k0.c("SELECT * FROM photos WHERE profile_id = ? ORDER BY position", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.a(this.f11766a, false, new String[]{"photos"}, new d(c10));
    }

    public qj.h<List<ProfileEntity>> w(List<String> list) {
        StringBuilder b10 = q1.d.b();
        b10.append("SELECT * from profiles WHERE id IN (");
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
        return l0.a(this.f11766a, false, new String[]{"profiles"}, new a(c10));
    }

    public qj.h<List<ProfileEntity>> z(String str) {
        k0 c10 = k0.c("SELECT * from profiles WHERE id = ?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.a(this.f11766a, false, new String[]{"profiles"}, new b(c10));
    }
}

package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.h;
import androidx.room.k0;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.entities.QuestionInteractionPolicy;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import g6.l;
import g6.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import za.i;

public final class l0 extends k0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11798a;

    /* renamed from: b  reason: collision with root package name */
    private final h<za.f> f11799b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final l f11800c = new l();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final m f11801d = new m();

    /* renamed from: e  reason: collision with root package name */
    private final h<za.f> f11802e;

    /* renamed from: f  reason: collision with root package name */
    private final androidx.room.g<za.f> f11803f;

    /* renamed from: g  reason: collision with root package name */
    private final androidx.room.g<za.f> f11804g;

    /* renamed from: h  reason: collision with root package name */
    private final SharedSQLiteStatement f11805h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final g6.e f11806i = new g6.e();

    class a implements Callable<Map<i, List<za.b>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11807a;

        a(k0 k0Var) {
            this.f11807a = k0Var;
        }

        /* JADX WARNING: Removed duplicated region for block: B:102:0x0284 A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x0287 A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x0293 A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:107:0x0296 A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:110:0x02a2 A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x02a5 A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x02b5 A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:115:0x02b8 A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:118:0x02c8 A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:119:0x02cb A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:122:0x02db A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:123:0x02de A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:126:0x02ee A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:127:0x02f4 A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:130:0x030e A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:131:0x0310 A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x031a A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:134:0x031d A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:141:0x0332 A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:142:0x0335 A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x0257 A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x025a A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x0266 A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0269 A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x0275 A[Catch:{ all -> 0x0371 }] */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x0278 A[Catch:{ all -> 0x0371 }] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.util.Map<za.i, java.util.List<za.b>> call() throws java.lang.Exception {
            /*
                r49 = this;
                r1 = r49
                com.coffeemeetsbagel.database.daos.l0 r0 = com.coffeemeetsbagel.database.daos.l0.this
                androidx.room.RoomDatabase r0 = r0.f11798a
                androidx.room.k0 r2 = r1.f11807a
                r3 = 1
                r4 = 0
                android.database.Cursor r2 = q1.b.b(r0, r2, r3, r4)
                java.lang.String r0 = "id"
                int r0 = q1.a.e(r2, r0)     // Catch:{ all -> 0x0371 }
                java.lang.String r5 = "group"
                int r5 = q1.a.e(r2, r5)     // Catch:{ all -> 0x0371 }
                java.lang.String r6 = "placeholder"
                int r6 = q1.a.e(r2, r6)     // Catch:{ all -> 0x0371 }
                java.lang.String r7 = "type"
                int r7 = q1.a.e(r2, r7)     // Catch:{ all -> 0x0371 }
                java.lang.String r8 = "label"
                int r8 = q1.a.e(r2, r8)     // Catch:{ all -> 0x0371 }
                java.lang.String r9 = "text"
                int r9 = q1.a.e(r2, r9)     // Catch:{ all -> 0x0371 }
                java.lang.String r10 = "name"
                int r10 = q1.a.e(r2, r10)     // Catch:{ all -> 0x0371 }
                java.lang.String r11 = "max_options"
                int r11 = q1.a.e(r2, r11)     // Catch:{ all -> 0x0371 }
                androidx.collection.a r12 = new androidx.collection.a     // Catch:{ all -> 0x0371 }
                r12.<init>()     // Catch:{ all -> 0x0371 }
            L_0x0045:
                boolean r13 = r2.moveToNext()     // Catch:{ all -> 0x0371 }
                if (r13 == 0) goto L_0x0060
                java.lang.String r13 = r2.getString(r0)     // Catch:{ all -> 0x0371 }
                java.lang.Object r14 = r12.get(r13)     // Catch:{ all -> 0x0371 }
                java.util.ArrayList r14 = (java.util.ArrayList) r14     // Catch:{ all -> 0x0371 }
                if (r14 != 0) goto L_0x0045
                java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0371 }
                r14.<init>()     // Catch:{ all -> 0x0371 }
                r12.put(r13, r14)     // Catch:{ all -> 0x0371 }
                goto L_0x0045
            L_0x0060:
                r13 = -1
                r2.moveToPosition(r13)     // Catch:{ all -> 0x0371 }
                com.coffeemeetsbagel.database.daos.l0 r13 = com.coffeemeetsbagel.database.daos.l0.this     // Catch:{ all -> 0x0371 }
                r13.u(r12)     // Catch:{ all -> 0x0371 }
                java.lang.String r13 = "answer_id"
                int r13 = q1.a.e(r2, r13)     // Catch:{ all -> 0x0371 }
                java.lang.String r14 = "option_id"
                int r14 = q1.a.e(r2, r14)     // Catch:{ all -> 0x0371 }
                java.lang.String r15 = "profile_id"
                int r15 = q1.a.e(r2, r15)     // Catch:{ all -> 0x0371 }
                java.lang.String r3 = "question_id"
                int r3 = q1.a.e(r2, r3)     // Catch:{ all -> 0x0371 }
                java.lang.String r4 = "text_value"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x0371 }
                r16 = r4
                java.lang.String r4 = "integer_value"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x0371 }
                r17 = r4
                java.lang.String r4 = "float_value"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x0371 }
                r18 = r4
                java.lang.String r4 = "max_value"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x0371 }
                r19 = r4
                java.lang.String r4 = "min_value"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x0371 }
                r20 = r4
                java.lang.String r4 = "location"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x0371 }
                r21 = r4
                java.lang.String r4 = "is_dealbreaker"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x0371 }
                r22 = r4
                java.lang.String r4 = "json_type"
                int r4 = q1.a.e(r2, r4)     // Catch:{ all -> 0x0371 }
                r23 = r4
                java.util.LinkedHashMap r4 = new java.util.LinkedHashMap     // Catch:{ all -> 0x0371 }
                r4.<init>()     // Catch:{ all -> 0x0371 }
            L_0x00c6:
                boolean r24 = r2.moveToNext()     // Catch:{ all -> 0x0371 }
                if (r24 == 0) goto L_0x036d
                boolean r24 = r2.isNull(r0)     // Catch:{ all -> 0x0371 }
                if (r24 == 0) goto L_0x00d5
                r26 = 0
                goto L_0x00db
            L_0x00d5:
                java.lang.String r24 = r2.getString(r0)     // Catch:{ all -> 0x0371 }
                r26 = r24
            L_0x00db:
                boolean r24 = r2.isNull(r5)     // Catch:{ all -> 0x0371 }
                if (r24 == 0) goto L_0x00e7
                r24 = r3
                r34 = r5
                r5 = 0
                goto L_0x00f1
            L_0x00e7:
                java.lang.String r24 = r2.getString(r5)     // Catch:{ all -> 0x0371 }
                r34 = r5
                r5 = r24
                r24 = r3
            L_0x00f1:
                com.coffeemeetsbagel.database.daos.l0 r3 = com.coffeemeetsbagel.database.daos.l0.this     // Catch:{ all -> 0x0371 }
                g6.l r3 = r3.f11800c     // Catch:{ all -> 0x0371 }
                com.coffeemeetsbagel.models.enums.QuestionGroupType r27 = r3.b(r5)     // Catch:{ all -> 0x0371 }
                boolean r3 = r2.isNull(r6)     // Catch:{ all -> 0x0371 }
                if (r3 == 0) goto L_0x0104
                r28 = 0
                goto L_0x010a
            L_0x0104:
                java.lang.String r3 = r2.getString(r6)     // Catch:{ all -> 0x0371 }
                r28 = r3
            L_0x010a:
                boolean r3 = r2.isNull(r7)     // Catch:{ all -> 0x0371 }
                if (r3 == 0) goto L_0x0112
                r3 = 0
                goto L_0x0116
            L_0x0112:
                java.lang.String r3 = r2.getString(r7)     // Catch:{ all -> 0x0371 }
            L_0x0116:
                com.coffeemeetsbagel.database.daos.l0 r5 = com.coffeemeetsbagel.database.daos.l0.this     // Catch:{ all -> 0x0371 }
                g6.m r5 = r5.f11801d     // Catch:{ all -> 0x0371 }
                com.coffeemeetsbagel.models.enums.QuestionType r29 = r5.b(r3)     // Catch:{ all -> 0x0371 }
                boolean r3 = r2.isNull(r8)     // Catch:{ all -> 0x0371 }
                if (r3 == 0) goto L_0x0129
                r30 = 0
                goto L_0x012f
            L_0x0129:
                java.lang.String r3 = r2.getString(r8)     // Catch:{ all -> 0x0371 }
                r30 = r3
            L_0x012f:
                boolean r3 = r2.isNull(r9)     // Catch:{ all -> 0x0371 }
                if (r3 == 0) goto L_0x0138
                r31 = 0
                goto L_0x013e
            L_0x0138:
                java.lang.String r3 = r2.getString(r9)     // Catch:{ all -> 0x0371 }
                r31 = r3
            L_0x013e:
                boolean r3 = r2.isNull(r10)     // Catch:{ all -> 0x0371 }
                if (r3 == 0) goto L_0x0147
                r33 = 0
                goto L_0x014d
            L_0x0147:
                java.lang.String r3 = r2.getString(r10)     // Catch:{ all -> 0x0371 }
                r33 = r3
            L_0x014d:
                boolean r3 = r2.isNull(r11)     // Catch:{ all -> 0x0371 }
                if (r3 != 0) goto L_0x016b
                boolean r3 = r2.isNull(r11)     // Catch:{ all -> 0x0371 }
                if (r3 == 0) goto L_0x015b
                r3 = 0
                goto L_0x0163
            L_0x015b:
                int r3 = r2.getInt(r11)     // Catch:{ all -> 0x0371 }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0371 }
            L_0x0163:
                com.coffeemeetsbagel.models.entities.QuestionInteractionPolicy r5 = new com.coffeemeetsbagel.models.entities.QuestionInteractionPolicy     // Catch:{ all -> 0x0371 }
                r5.<init>(r3)     // Catch:{ all -> 0x0371 }
                r32 = r5
                goto L_0x016d
            L_0x016b:
                r32 = 0
            L_0x016d:
                za.f r3 = new za.f     // Catch:{ all -> 0x0371 }
                r25 = r3
                r25.<init>(r26, r27, r28, r29, r30, r31, r32, r33)     // Catch:{ all -> 0x0371 }
                java.lang.String r5 = r2.getString(r0)     // Catch:{ all -> 0x0371 }
                java.lang.Object r5 = r12.get(r5)     // Catch:{ all -> 0x0371 }
                java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x0371 }
                if (r5 != 0) goto L_0x0185
                java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0371 }
                r5.<init>()     // Catch:{ all -> 0x0371 }
            L_0x0185:
                r25 = r0
                za.i r0 = new za.i     // Catch:{ all -> 0x0371 }
                r0.<init>(r3, r5)     // Catch:{ all -> 0x0371 }
                boolean r3 = r4.containsKey(r0)     // Catch:{ all -> 0x0371 }
                if (r3 == 0) goto L_0x0199
                java.lang.Object r0 = r4.get(r0)     // Catch:{ all -> 0x0371 }
                java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0371 }
                goto L_0x01a2
            L_0x0199:
                java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0371 }
                r3.<init>()     // Catch:{ all -> 0x0371 }
                r4.put(r0, r3)     // Catch:{ all -> 0x0371 }
                r0 = r3
            L_0x01a2:
                boolean r3 = r2.isNull(r13)     // Catch:{ all -> 0x0371 }
                if (r3 == 0) goto L_0x0231
                boolean r3 = r2.isNull(r14)     // Catch:{ all -> 0x0371 }
                if (r3 == 0) goto L_0x0231
                boolean r3 = r2.isNull(r15)     // Catch:{ all -> 0x0371 }
                if (r3 == 0) goto L_0x0231
                r3 = r24
                boolean r5 = r2.isNull(r3)     // Catch:{ all -> 0x0371 }
                if (r5 == 0) goto L_0x022e
                r5 = r16
                boolean r16 = r2.isNull(r5)     // Catch:{ all -> 0x0371 }
                if (r16 == 0) goto L_0x0235
                r16 = r6
                r6 = r17
                boolean r17 = r2.isNull(r6)     // Catch:{ all -> 0x0371 }
                if (r17 == 0) goto L_0x0239
                r17 = r7
                r7 = r18
                boolean r18 = r2.isNull(r7)     // Catch:{ all -> 0x0371 }
                if (r18 == 0) goto L_0x023d
                r18 = r8
                r8 = r19
                boolean r19 = r2.isNull(r8)     // Catch:{ all -> 0x0371 }
                if (r19 == 0) goto L_0x0241
                r19 = r9
                r9 = r20
                boolean r20 = r2.isNull(r9)     // Catch:{ all -> 0x0371 }
                if (r20 == 0) goto L_0x0245
                r20 = r10
                r10 = r21
                boolean r21 = r2.isNull(r10)     // Catch:{ all -> 0x0371 }
                if (r21 == 0) goto L_0x0249
                r21 = r11
                r11 = r22
                boolean r22 = r2.isNull(r11)     // Catch:{ all -> 0x0371 }
                if (r22 == 0) goto L_0x024d
                r22 = r12
                r12 = r23
                boolean r23 = r2.isNull(r12)     // Catch:{ all -> 0x0371 }
                if (r23 == 0) goto L_0x0251
                r23 = r12
                r12 = r22
                r0 = r25
                r22 = r11
                r11 = r21
                r21 = r10
                r10 = r20
                r20 = r9
                r9 = r19
                r19 = r8
                r8 = r18
                r18 = r7
                r7 = r17
                r17 = r6
                r6 = r16
                r16 = r5
                r5 = r34
                goto L_0x00c6
            L_0x022e:
                r5 = r16
                goto L_0x0235
            L_0x0231:
                r5 = r16
                r3 = r24
            L_0x0235:
                r16 = r6
                r6 = r17
            L_0x0239:
                r17 = r7
                r7 = r18
            L_0x023d:
                r18 = r8
                r8 = r19
            L_0x0241:
                r19 = r9
                r9 = r20
            L_0x0245:
                r20 = r10
                r10 = r21
            L_0x0249:
                r21 = r11
                r11 = r22
            L_0x024d:
                r22 = r12
                r12 = r23
            L_0x0251:
                boolean r23 = r2.isNull(r13)     // Catch:{ all -> 0x0371 }
                if (r23 == 0) goto L_0x025a
                r36 = 0
                goto L_0x0260
            L_0x025a:
                java.lang.String r23 = r2.getString(r13)     // Catch:{ all -> 0x0371 }
                r36 = r23
            L_0x0260:
                boolean r23 = r2.isNull(r14)     // Catch:{ all -> 0x0371 }
                if (r23 == 0) goto L_0x0269
                r37 = 0
                goto L_0x026f
            L_0x0269:
                java.lang.String r23 = r2.getString(r14)     // Catch:{ all -> 0x0371 }
                r37 = r23
            L_0x026f:
                boolean r23 = r2.isNull(r15)     // Catch:{ all -> 0x0371 }
                if (r23 == 0) goto L_0x0278
                r38 = 0
                goto L_0x027e
            L_0x0278:
                java.lang.String r23 = r2.getString(r15)     // Catch:{ all -> 0x0371 }
                r38 = r23
            L_0x027e:
                boolean r23 = r2.isNull(r3)     // Catch:{ all -> 0x0371 }
                if (r23 == 0) goto L_0x0287
                r39 = 0
                goto L_0x028d
            L_0x0287:
                java.lang.String r23 = r2.getString(r3)     // Catch:{ all -> 0x0371 }
                r39 = r23
            L_0x028d:
                boolean r23 = r2.isNull(r5)     // Catch:{ all -> 0x0371 }
                if (r23 == 0) goto L_0x0296
                r40 = 0
                goto L_0x029c
            L_0x0296:
                java.lang.String r23 = r2.getString(r5)     // Catch:{ all -> 0x0371 }
                r40 = r23
            L_0x029c:
                boolean r23 = r2.isNull(r6)     // Catch:{ all -> 0x0371 }
                if (r23 == 0) goto L_0x02a5
                r41 = 0
                goto L_0x02af
            L_0x02a5:
                int r23 = r2.getInt(r6)     // Catch:{ all -> 0x0371 }
                java.lang.Integer r23 = java.lang.Integer.valueOf(r23)     // Catch:{ all -> 0x0371 }
                r41 = r23
            L_0x02af:
                boolean r23 = r2.isNull(r7)     // Catch:{ all -> 0x0371 }
                if (r23 == 0) goto L_0x02b8
                r42 = 0
                goto L_0x02c2
            L_0x02b8:
                float r23 = r2.getFloat(r7)     // Catch:{ all -> 0x0371 }
                java.lang.Float r23 = java.lang.Float.valueOf(r23)     // Catch:{ all -> 0x0371 }
                r42 = r23
            L_0x02c2:
                boolean r23 = r2.isNull(r8)     // Catch:{ all -> 0x0371 }
                if (r23 == 0) goto L_0x02cb
                r43 = 0
                goto L_0x02d5
            L_0x02cb:
                float r23 = r2.getFloat(r8)     // Catch:{ all -> 0x0371 }
                java.lang.Float r23 = java.lang.Float.valueOf(r23)     // Catch:{ all -> 0x0371 }
                r43 = r23
            L_0x02d5:
                boolean r23 = r2.isNull(r9)     // Catch:{ all -> 0x0371 }
                if (r23 == 0) goto L_0x02de
                r44 = 0
                goto L_0x02e8
            L_0x02de:
                float r23 = r2.getFloat(r9)     // Catch:{ all -> 0x0371 }
                java.lang.Float r23 = java.lang.Float.valueOf(r23)     // Catch:{ all -> 0x0371 }
                r44 = r23
            L_0x02e8:
                boolean r23 = r2.isNull(r10)     // Catch:{ all -> 0x0371 }
                if (r23 == 0) goto L_0x02f4
                r24 = r3
                r23 = r5
                r3 = 0
                goto L_0x02fe
            L_0x02f4:
                java.lang.String r23 = r2.getString(r10)     // Catch:{ all -> 0x0371 }
                r24 = r3
                r3 = r23
                r23 = r5
            L_0x02fe:
                com.coffeemeetsbagel.database.daos.l0 r5 = com.coffeemeetsbagel.database.daos.l0.this     // Catch:{ all -> 0x0371 }
                g6.e r5 = r5.f11806i     // Catch:{ all -> 0x0371 }
                com.coffeemeetsbagel.models.dto.Location r45 = r5.b(r3)     // Catch:{ all -> 0x0371 }
                boolean r3 = r2.isNull(r11)     // Catch:{ all -> 0x0371 }
                if (r3 == 0) goto L_0x0310
                r3 = 0
                goto L_0x0318
            L_0x0310:
                int r3 = r2.getInt(r11)     // Catch:{ all -> 0x0371 }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0371 }
            L_0x0318:
                if (r3 != 0) goto L_0x031d
                r46 = 0
                goto L_0x032c
            L_0x031d:
                int r3 = r3.intValue()     // Catch:{ all -> 0x0371 }
                if (r3 == 0) goto L_0x0325
                r3 = 1
                goto L_0x0326
            L_0x0325:
                r3 = 0
            L_0x0326:
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0371 }
                r46 = r3
            L_0x032c:
                boolean r3 = r2.isNull(r12)     // Catch:{ all -> 0x0371 }
                if (r3 == 0) goto L_0x0335
                r47 = 0
                goto L_0x033b
            L_0x0335:
                java.lang.String r3 = r2.getString(r12)     // Catch:{ all -> 0x0371 }
                r47 = r3
            L_0x033b:
                za.b r3 = new za.b     // Catch:{ all -> 0x0371 }
                r35 = r3
                r35.<init>(r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47)     // Catch:{ all -> 0x0371 }
                r0.add(r3)     // Catch:{ all -> 0x0371 }
                r3 = r24
                r0 = r25
                r5 = r34
                r48 = r17
                r17 = r6
                r6 = r16
                r16 = r23
                r23 = r12
                r12 = r22
                r22 = r11
                r11 = r21
                r21 = r10
                r10 = r20
                r20 = r9
                r9 = r19
                r19 = r8
                r8 = r18
                r18 = r7
                r7 = r48
                goto L_0x00c6
            L_0x036d:
                r2.close()
                return r4
            L_0x0371:
                r0 = move-exception
                r2.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.database.daos.l0.a.call():java.util.Map");
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11807a.g();
        }
    }

    class b implements Callable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11809a;

        b(k0 k0Var) {
            this.f11809a = k0Var;
        }

        /* renamed from: a */
        public Integer call() throws Exception {
            Integer num = null;
            Cursor b10 = q1.b.b(l0.this.f11798a, this.f11809a, false, (CancellationSignal) null);
            try {
                if (b10.moveToFirst()) {
                    if (!b10.isNull(0)) {
                        num = Integer.valueOf(b10.getInt(0));
                    }
                }
                return num;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11809a.g();
        }
    }

    class c extends h<za.f> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `questions` (`id`,`group`,`placeholder`,`type`,`label`,`text`,`name`,`max_options`) VALUES (?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(t1.m mVar, za.f fVar) {
            if (fVar.b() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, fVar.b());
            }
            String a10 = l0.this.f11800c.a(fVar.a());
            if (a10 == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, a10);
            }
            if (fVar.g() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, fVar.g());
            }
            String a11 = l0.this.f11801d.a(fVar.i());
            if (a11 == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, a11);
            }
            if (fVar.d() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, fVar.d());
            }
            if (fVar.h() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, fVar.h());
            }
            if (fVar.e() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, fVar.e());
            }
            QuestionInteractionPolicy c10 = fVar.c();
            if (c10 == null) {
                mVar.B1(8);
            } else if (c10.getMaxOptions() == null) {
                mVar.B1(8);
            } else {
                mVar.f1(8, (long) c10.getMaxOptions().intValue());
            }
        }
    }

    class d extends h<za.f> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `questions` (`id`,`group`,`placeholder`,`type`,`label`,`text`,`name`,`max_options`) VALUES (?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(t1.m mVar, za.f fVar) {
            if (fVar.b() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, fVar.b());
            }
            String a10 = l0.this.f11800c.a(fVar.a());
            if (a10 == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, a10);
            }
            if (fVar.g() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, fVar.g());
            }
            String a11 = l0.this.f11801d.a(fVar.i());
            if (a11 == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, a11);
            }
            if (fVar.d() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, fVar.d());
            }
            if (fVar.h() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, fVar.h());
            }
            if (fVar.e() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, fVar.e());
            }
            QuestionInteractionPolicy c10 = fVar.c();
            if (c10 == null) {
                mVar.B1(8);
            } else if (c10.getMaxOptions() == null) {
                mVar.B1(8);
            } else {
                mVar.f1(8, (long) c10.getMaxOptions().intValue());
            }
        }
    }

    class e extends androidx.room.g<za.f> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `questions` WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(t1.m mVar, za.f fVar) {
            if (fVar.b() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, fVar.b());
            }
        }
    }

    class f extends androidx.room.g<za.f> {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `questions` SET `id` = ?,`group` = ?,`placeholder` = ?,`type` = ?,`label` = ?,`text` = ?,`name` = ?,`max_options` = ? WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(t1.m mVar, za.f fVar) {
            if (fVar.b() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, fVar.b());
            }
            String a10 = l0.this.f11800c.a(fVar.a());
            if (a10 == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, a10);
            }
            if (fVar.g() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, fVar.g());
            }
            String a11 = l0.this.f11801d.a(fVar.i());
            if (a11 == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, a11);
            }
            if (fVar.d() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, fVar.d());
            }
            if (fVar.h() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, fVar.h());
            }
            if (fVar.e() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, fVar.e());
            }
            QuestionInteractionPolicy c10 = fVar.c();
            if (c10 == null) {
                mVar.B1(8);
            } else if (c10.getMaxOptions() == null) {
                mVar.B1(8);
            } else {
                mVar.f1(8, (long) c10.getMaxOptions().intValue());
            }
            if (fVar.b() == null) {
                mVar.B1(9);
            } else {
                mVar.P0(9, fVar.b());
            }
        }
    }

    class g extends SharedSQLiteStatement {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM questions WHERE `group` = ?";
        }
    }

    public l0(RoomDatabase roomDatabase) {
        this.f11798a = roomDatabase;
        this.f11799b = new c(roomDatabase);
        this.f11802e = new d(roomDatabase);
        this.f11803f = new e(roomDatabase);
        this.f11804g = new f(roomDatabase);
        this.f11805h = new g(roomDatabase);
    }

    /* access modifiers changed from: private */
    public void u(androidx.collection.a<String, ArrayList<za.c>> aVar) {
        String str;
        String str2;
        String str3;
        String str4;
        Set<String> keySet = aVar.keySet();
        if (!keySet.isEmpty()) {
            if (aVar.size() > 999) {
                androidx.collection.a aVar2 = new androidx.collection.a(999);
                int size = aVar.size();
                int i10 = 0;
                int i11 = 0;
                while (i10 < size) {
                    aVar2.put(aVar.j(i10), aVar.n(i10));
                    i10++;
                    i11++;
                    if (i11 == 999) {
                        u(aVar2);
                        aVar2 = new androidx.collection.a(999);
                        i11 = 0;
                    }
                }
                if (i11 > 0) {
                    u(aVar2);
                    return;
                }
                return;
            }
            StringBuilder b10 = q1.d.b();
            b10.append("SELECT `id`,`question_id`,`title`,`name` FROM `options` WHERE `question_id` IN (");
            int size2 = keySet.size();
            q1.d.a(b10, size2);
            b10.append(")");
            k0 c10 = k0.c(b10.toString(), size2 + 0);
            int i12 = 1;
            for (String next : keySet) {
                if (next == null) {
                    c10.B1(i12);
                } else {
                    c10.P0(i12, next);
                }
                i12++;
            }
            Cursor b11 = q1.b.b(this.f11798a, c10, false, (CancellationSignal) null);
            try {
                int d10 = q1.a.d(b11, "question_id");
                if (d10 != -1) {
                    while (b11.moveToNext()) {
                        ArrayList arrayList = aVar.get(b11.getString(d10));
                        if (arrayList != null) {
                            if (b11.isNull(0)) {
                                str = null;
                            } else {
                                str = b11.getString(0);
                            }
                            if (b11.isNull(1)) {
                                str2 = null;
                            } else {
                                str2 = b11.getString(1);
                            }
                            if (b11.isNull(2)) {
                                str3 = null;
                            } else {
                                str3 = b11.getString(2);
                            }
                            if (b11.isNull(3)) {
                                str4 = null;
                            } else {
                                str4 = b11.getString(3);
                            }
                            arrayList.add(new za.c(str, str2, str3, str4));
                        }
                    }
                    b11.close();
                }
            } finally {
                b11.close();
            }
        }
    }

    public static List<Class<?>> w() {
        return Collections.emptyList();
    }

    public qj.h<Map<i, List<za.b>>> a(String str, String str2) {
        k0 c10 = k0.c("select * from questions left join answers on questions.id = answers.question_id and answers.profile_id = ? where name = ?", 2);
        if (str2 == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str2);
        }
        if (str == null) {
            c10.B1(2);
        } else {
            c10.P0(2, str);
        }
        return androidx.room.l0.a(this.f11798a, false, new String[]{SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, ProfileConstants.Field.QUESTIONS, "answers"}, new a(c10));
    }

    public qj.h<Integer> c(String str) {
        k0 c10 = k0.c("select count(distinct question_id) from answers where profile_id = ? and is_dealbreaker = 1 ", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return androidx.room.l0.a(this.f11798a, false, new String[]{"answers"}, new b(c10));
    }

    public int k(List<? extends za.f> list) {
        this.f11798a.d();
        this.f11798a.e();
        try {
            int k10 = this.f11804g.k(list) + 0;
            this.f11798a.C();
            return k10;
        } finally {
            this.f11798a.j();
        }
    }

    public int o(List<za.f> list) {
        this.f11798a.e();
        try {
            int v10 = super.o(list);
            this.f11798a.C();
            return v10;
        } finally {
            this.f11798a.j();
        }
    }

    public List<Long> s(List<? extends za.f> list) {
        this.f11798a.d();
        this.f11798a.e();
        try {
            List<Long> m10 = this.f11799b.m(list);
            this.f11798a.C();
            return m10;
        } finally {
            this.f11798a.j();
        }
    }
}

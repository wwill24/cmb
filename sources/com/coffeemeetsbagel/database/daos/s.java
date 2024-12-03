package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.g;
import androidx.room.h;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.entities.ConnectionDetailsEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import qj.w;
import t1.m;

public final class s extends ConnectionDetailsRoomDao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11883a;

    /* renamed from: b  reason: collision with root package name */
    private final h<ConnectionDetailsEntity> f11884b;

    /* renamed from: c  reason: collision with root package name */
    private final h<ConnectionDetailsEntity> f11885c;

    /* renamed from: d  reason: collision with root package name */
    private final g<ConnectionDetailsEntity> f11886d;

    /* renamed from: e  reason: collision with root package name */
    private final g<ConnectionDetailsEntity> f11887e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f11888f;

    class a implements Callable<List<ConnectionDetailsEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11889a;

        a(k0 k0Var) {
            this.f11889a = k0Var;
        }

        /* renamed from: a */
        public List<ConnectionDetailsEntity> call() throws Exception {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            Cursor b10 = q1.b.b(s.this.f11883a, this.f11889a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "profileId");
                int e11 = q1.a.e(b10, "unreadMessageCount");
                int e12 = q1.a.e(b10, "lastMessageText");
                int e13 = q1.a.e(b10, "lastMessageDate");
                int e14 = q1.a.e(b10, "pairReadReceiptDate");
                int e15 = q1.a.e(b10, "lastSenderProfileId");
                int e16 = q1.a.e(b10, "lastMessageReadTimestamp");
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(e10)) {
                        str = null;
                    } else {
                        str = b10.getString(e10);
                    }
                    int i10 = b10.getInt(e11);
                    if (b10.isNull(e12)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(e12);
                    }
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
                    arrayList.add(new ConnectionDetailsEntity(str, i10, str2, str3, str4, str5, str6));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11889a.g();
        }
    }

    class b extends h<ConnectionDetailsEntity> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `connection_details` (`profileId`,`unreadMessageCount`,`lastMessageText`,`lastMessageDate`,`pairReadReceiptDate`,`lastSenderProfileId`,`lastMessageReadTimestamp`) VALUES (?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, ConnectionDetailsEntity connectionDetailsEntity) {
            if (connectionDetailsEntity.getProfileId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, connectionDetailsEntity.getProfileId());
            }
            mVar.f1(2, (long) connectionDetailsEntity.getUnreadMessageCount());
            if (connectionDetailsEntity.getLastMessageText() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, connectionDetailsEntity.getLastMessageText());
            }
            if (connectionDetailsEntity.getLastMessageDate() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, connectionDetailsEntity.getLastMessageDate());
            }
            if (connectionDetailsEntity.getPairReadReceiptDate() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, connectionDetailsEntity.getPairReadReceiptDate());
            }
            if (connectionDetailsEntity.getLastSenderProfileId() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, connectionDetailsEntity.getLastSenderProfileId());
            }
            if (connectionDetailsEntity.getLastMessageReadTimestamp() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, connectionDetailsEntity.getLastMessageReadTimestamp());
            }
        }
    }

    class c extends h<ConnectionDetailsEntity> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `connection_details` (`profileId`,`unreadMessageCount`,`lastMessageText`,`lastMessageDate`,`pairReadReceiptDate`,`lastSenderProfileId`,`lastMessageReadTimestamp`) VALUES (?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, ConnectionDetailsEntity connectionDetailsEntity) {
            if (connectionDetailsEntity.getProfileId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, connectionDetailsEntity.getProfileId());
            }
            mVar.f1(2, (long) connectionDetailsEntity.getUnreadMessageCount());
            if (connectionDetailsEntity.getLastMessageText() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, connectionDetailsEntity.getLastMessageText());
            }
            if (connectionDetailsEntity.getLastMessageDate() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, connectionDetailsEntity.getLastMessageDate());
            }
            if (connectionDetailsEntity.getPairReadReceiptDate() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, connectionDetailsEntity.getPairReadReceiptDate());
            }
            if (connectionDetailsEntity.getLastSenderProfileId() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, connectionDetailsEntity.getLastSenderProfileId());
            }
            if (connectionDetailsEntity.getLastMessageReadTimestamp() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, connectionDetailsEntity.getLastMessageReadTimestamp());
            }
        }
    }

    class d extends g<ConnectionDetailsEntity> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `connection_details` WHERE `profileId` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, ConnectionDetailsEntity connectionDetailsEntity) {
            if (connectionDetailsEntity.getProfileId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, connectionDetailsEntity.getProfileId());
            }
        }
    }

    class e extends g<ConnectionDetailsEntity> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `connection_details` SET `profileId` = ?,`unreadMessageCount` = ?,`lastMessageText` = ?,`lastMessageDate` = ?,`pairReadReceiptDate` = ?,`lastSenderProfileId` = ?,`lastMessageReadTimestamp` = ? WHERE `profileId` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, ConnectionDetailsEntity connectionDetailsEntity) {
            if (connectionDetailsEntity.getProfileId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, connectionDetailsEntity.getProfileId());
            }
            mVar.f1(2, (long) connectionDetailsEntity.getUnreadMessageCount());
            if (connectionDetailsEntity.getLastMessageText() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, connectionDetailsEntity.getLastMessageText());
            }
            if (connectionDetailsEntity.getLastMessageDate() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, connectionDetailsEntity.getLastMessageDate());
            }
            if (connectionDetailsEntity.getPairReadReceiptDate() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, connectionDetailsEntity.getPairReadReceiptDate());
            }
            if (connectionDetailsEntity.getLastSenderProfileId() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, connectionDetailsEntity.getLastSenderProfileId());
            }
            if (connectionDetailsEntity.getLastMessageReadTimestamp() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, connectionDetailsEntity.getLastMessageReadTimestamp());
            }
            if (connectionDetailsEntity.getProfileId() == null) {
                mVar.B1(8);
            } else {
                mVar.P0(8, connectionDetailsEntity.getProfileId());
            }
        }
    }

    class f extends SharedSQLiteStatement {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE connection_details SET unreadMessageCount = 0, lastMessageReadTimestamp = ? WHERE profileId = ?";
        }
    }

    public s(RoomDatabase roomDatabase) {
        this.f11883a = roomDatabase;
        this.f11884b = new b(roomDatabase);
        this.f11885c = new c(roomDatabase);
        this.f11886d = new d(roomDatabase);
        this.f11887e = new e(roomDatabase);
        this.f11888f = new f(roomDatabase);
    }

    public static List<Class<?>> C() {
        return Collections.emptyList();
    }

    public void A(List<ConnectionDetailsEntity> list) {
        this.f11883a.d();
        this.f11883a.e();
        try {
            this.f11885c.j(list);
            this.f11883a.C();
        } finally {
            this.f11883a.j();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.coffeemeetsbagel.models.entities.ConnectionDetailsEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.coffeemeetsbagel.models.entities.ConnectionDetailsEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.coffeemeetsbagel.models.entities.ConnectionDetailsEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: com.coffeemeetsbagel.models.entities.ConnectionDetailsEntity} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: com.coffeemeetsbagel.models.entities.ConnectionDetailsEntity} */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.coffeemeetsbagel.models.entities.ConnectionDetailsEntity v(java.lang.String r20) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            java.lang.String r2 = "SELECT * from connection_details where profileId = ?"
            r3 = 1
            androidx.room.k0 r2 = androidx.room.k0.c(r2, r3)
            if (r0 != 0) goto L_0x0011
            r2.B1(r3)
            goto L_0x0014
        L_0x0011:
            r2.P0(r3, r0)
        L_0x0014:
            androidx.room.RoomDatabase r0 = r1.f11883a
            r0.d()
            androidx.room.RoomDatabase r0 = r1.f11883a
            r3 = 0
            r4 = 0
            android.database.Cursor r3 = q1.b.b(r0, r2, r3, r4)
            java.lang.String r0 = "profileId"
            int r0 = q1.a.e(r3, r0)     // Catch:{ all -> 0x00b5 }
            java.lang.String r5 = "unreadMessageCount"
            int r5 = q1.a.e(r3, r5)     // Catch:{ all -> 0x00b5 }
            java.lang.String r6 = "lastMessageText"
            int r6 = q1.a.e(r3, r6)     // Catch:{ all -> 0x00b5 }
            java.lang.String r7 = "lastMessageDate"
            int r7 = q1.a.e(r3, r7)     // Catch:{ all -> 0x00b5 }
            java.lang.String r8 = "pairReadReceiptDate"
            int r8 = q1.a.e(r3, r8)     // Catch:{ all -> 0x00b5 }
            java.lang.String r9 = "lastSenderProfileId"
            int r9 = q1.a.e(r3, r9)     // Catch:{ all -> 0x00b5 }
            java.lang.String r10 = "lastMessageReadTimestamp"
            int r10 = q1.a.e(r3, r10)     // Catch:{ all -> 0x00b5 }
            boolean r11 = r3.moveToFirst()     // Catch:{ all -> 0x00b5 }
            if (r11 == 0) goto L_0x00ae
            boolean r11 = r3.isNull(r0)     // Catch:{ all -> 0x00b5 }
            if (r11 == 0) goto L_0x0059
            r12 = r4
            goto L_0x005e
        L_0x0059:
            java.lang.String r0 = r3.getString(r0)     // Catch:{ all -> 0x00b5 }
            r12 = r0
        L_0x005e:
            int r13 = r3.getInt(r5)     // Catch:{ all -> 0x00b5 }
            boolean r0 = r3.isNull(r6)     // Catch:{ all -> 0x00b5 }
            if (r0 == 0) goto L_0x006a
            r14 = r4
            goto L_0x006f
        L_0x006a:
            java.lang.String r0 = r3.getString(r6)     // Catch:{ all -> 0x00b5 }
            r14 = r0
        L_0x006f:
            boolean r0 = r3.isNull(r7)     // Catch:{ all -> 0x00b5 }
            if (r0 == 0) goto L_0x0077
            r15 = r4
            goto L_0x007c
        L_0x0077:
            java.lang.String r0 = r3.getString(r7)     // Catch:{ all -> 0x00b5 }
            r15 = r0
        L_0x007c:
            boolean r0 = r3.isNull(r8)     // Catch:{ all -> 0x00b5 }
            if (r0 == 0) goto L_0x0085
            r16 = r4
            goto L_0x008b
        L_0x0085:
            java.lang.String r0 = r3.getString(r8)     // Catch:{ all -> 0x00b5 }
            r16 = r0
        L_0x008b:
            boolean r0 = r3.isNull(r9)     // Catch:{ all -> 0x00b5 }
            if (r0 == 0) goto L_0x0094
            r17 = r4
            goto L_0x009a
        L_0x0094:
            java.lang.String r0 = r3.getString(r9)     // Catch:{ all -> 0x00b5 }
            r17 = r0
        L_0x009a:
            boolean r0 = r3.isNull(r10)     // Catch:{ all -> 0x00b5 }
            if (r0 == 0) goto L_0x00a3
        L_0x00a0:
            r18 = r4
            goto L_0x00a8
        L_0x00a3:
            java.lang.String r4 = r3.getString(r10)     // Catch:{ all -> 0x00b5 }
            goto L_0x00a0
        L_0x00a8:
            com.coffeemeetsbagel.models.entities.ConnectionDetailsEntity r4 = new com.coffeemeetsbagel.models.entities.ConnectionDetailsEntity     // Catch:{ all -> 0x00b5 }
            r11 = r4
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x00b5 }
        L_0x00ae:
            r3.close()
            r2.g()
            return r4
        L_0x00b5:
            r0 = move-exception
            r3.close()
            r2.g()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.database.daos.s.v(java.lang.String):com.coffeemeetsbagel.models.entities.ConnectionDetailsEntity");
    }

    public w<List<ConnectionDetailsEntity>> w(List<String> list) {
        StringBuilder b10 = q1.d.b();
        b10.append("SELECT * from connection_details where profileId IN (");
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
        return l0.c(new a(c10));
    }

    public void x(String str, String str2) {
        this.f11883a.d();
        m b10 = this.f11888f.b();
        if (str2 == null) {
            b10.B1(1);
        } else {
            b10.P0(1, str2);
        }
        if (str == null) {
            b10.B1(2);
        } else {
            b10.P0(2, str);
        }
        this.f11883a.e();
        try {
            b10.H();
            this.f11883a.C();
        } finally {
            this.f11883a.j();
            this.f11888f.h(b10);
        }
    }

    public void z(ConnectionDetailsEntity connectionDetailsEntity) {
        this.f11883a.d();
        this.f11883a.e();
        try {
            this.f11885c.k(connectionDetailsEntity);
            this.f11883a.C();
        } finally {
            this.f11883a.j();
        }
    }
}

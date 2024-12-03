package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.entities.PendingMessageEntity;
import com.coffeemeetsbagel.models.enums.MessageStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import qj.w;
import t1.m;

public final class a0 extends PendingMessageRoomDao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11619a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final androidx.room.h<PendingMessageEntity> f11620b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final g6.h f11621c = new g6.h();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final g6.i f11622d = new g6.i();

    /* renamed from: e  reason: collision with root package name */
    private final androidx.room.h<PendingMessageEntity> f11623e;

    /* renamed from: f  reason: collision with root package name */
    private final androidx.room.g<PendingMessageEntity> f11624f;

    /* renamed from: g  reason: collision with root package name */
    private final androidx.room.g<PendingMessageEntity> f11625g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final SharedSQLiteStatement f11626h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final SharedSQLiteStatement f11627i;

    /* renamed from: j  reason: collision with root package name */
    private final SharedSQLiteStatement f11628j;

    class a implements Callable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f11629a;

        a(long j10) {
            this.f11629a = j10;
        }

        /* renamed from: a */
        public Integer call() throws Exception {
            m b10 = a0.this.f11626h.b();
            b10.f1(1, this.f11629a);
            a0.this.f11619a.e();
            try {
                Integer valueOf = Integer.valueOf(b10.H());
                a0.this.f11619a.C();
                return valueOf;
            } finally {
                a0.this.f11619a.j();
                a0.this.f11626h.h(b10);
            }
        }
    }

    class b implements Callable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MessageStatus f11631a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f11632b;

        b(MessageStatus messageStatus, long j10) {
            this.f11631a = messageStatus;
            this.f11632b = j10;
        }

        /* renamed from: a */
        public Integer call() throws Exception {
            m b10 = a0.this.f11627i.b();
            String a10 = a0.this.f11621c.a(this.f11631a);
            if (a10 == null) {
                b10.B1(1);
            } else {
                b10.P0(1, a10);
            }
            b10.f1(2, this.f11632b);
            a0.this.f11619a.e();
            try {
                Integer valueOf = Integer.valueOf(b10.H());
                a0.this.f11619a.C();
                return valueOf;
            } finally {
                a0.this.f11619a.j();
                a0.this.f11627i.h(b10);
            }
        }
    }

    class c implements Callable<List<PendingMessageEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11634a;

        c(k0 k0Var) {
            this.f11634a = k0Var;
        }

        /* renamed from: a */
        public List<PendingMessageEntity> call() throws Exception {
            Long l10;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            Cursor b10 = q1.b.b(a0.this.f11619a, this.f11634a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "id");
                int e11 = q1.a.e(b10, Extra.BAGEL_ID);
                int e12 = q1.a.e(b10, "status");
                int e13 = q1.a.e(b10, "text");
                int e14 = q1.a.e(b10, "time_sent");
                int e15 = q1.a.e(b10, "type");
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(e10)) {
                        l10 = null;
                    } else {
                        l10 = Long.valueOf(b10.getLong(e10));
                    }
                    if (b10.isNull(e11)) {
                        str = null;
                    } else {
                        str = b10.getString(e11);
                    }
                    if (b10.isNull(e12)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(e12);
                    }
                    MessageStatus b11 = a0.this.f11621c.b(str2);
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
                    arrayList.add(new PendingMessageEntity(l10, str, b11, str3, str4, a0.this.f11622d.b(str5)));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11634a.g();
        }
    }

    class d extends androidx.room.h<PendingMessageEntity> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `pending_messages` (`id`,`bagel_id`,`status`,`text`,`time_sent`,`type`) VALUES (?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, PendingMessageEntity pendingMessageEntity) {
            if (pendingMessageEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.f1(1, pendingMessageEntity.getId().longValue());
            }
            if (pendingMessageEntity.getBagelId() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, pendingMessageEntity.getBagelId());
            }
            String a10 = a0.this.f11621c.a(pendingMessageEntity.getStatus());
            if (a10 == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, a10);
            }
            if (pendingMessageEntity.getText() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, pendingMessageEntity.getText());
            }
            if (pendingMessageEntity.getTimeSent() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, pendingMessageEntity.getTimeSent());
            }
            String a11 = a0.this.f11622d.a(pendingMessageEntity.getType());
            if (a11 == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, a11);
            }
        }
    }

    class e extends androidx.room.h<PendingMessageEntity> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `pending_messages` (`id`,`bagel_id`,`status`,`text`,`time_sent`,`type`) VALUES (?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, PendingMessageEntity pendingMessageEntity) {
            if (pendingMessageEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.f1(1, pendingMessageEntity.getId().longValue());
            }
            if (pendingMessageEntity.getBagelId() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, pendingMessageEntity.getBagelId());
            }
            String a10 = a0.this.f11621c.a(pendingMessageEntity.getStatus());
            if (a10 == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, a10);
            }
            if (pendingMessageEntity.getText() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, pendingMessageEntity.getText());
            }
            if (pendingMessageEntity.getTimeSent() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, pendingMessageEntity.getTimeSent());
            }
            String a11 = a0.this.f11622d.a(pendingMessageEntity.getType());
            if (a11 == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, a11);
            }
        }
    }

    class f extends androidx.room.g<PendingMessageEntity> {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `pending_messages` WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, PendingMessageEntity pendingMessageEntity) {
            if (pendingMessageEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.f1(1, pendingMessageEntity.getId().longValue());
            }
        }
    }

    class g extends androidx.room.g<PendingMessageEntity> {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `pending_messages` SET `id` = ?,`bagel_id` = ?,`status` = ?,`text` = ?,`time_sent` = ?,`type` = ? WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, PendingMessageEntity pendingMessageEntity) {
            if (pendingMessageEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.f1(1, pendingMessageEntity.getId().longValue());
            }
            if (pendingMessageEntity.getBagelId() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, pendingMessageEntity.getBagelId());
            }
            String a10 = a0.this.f11621c.a(pendingMessageEntity.getStatus());
            if (a10 == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, a10);
            }
            if (pendingMessageEntity.getText() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, pendingMessageEntity.getText());
            }
            if (pendingMessageEntity.getTimeSent() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, pendingMessageEntity.getTimeSent());
            }
            String a11 = a0.this.f11622d.a(pendingMessageEntity.getType());
            if (a11 == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, a11);
            }
            if (pendingMessageEntity.getId() == null) {
                mVar.B1(7);
            } else {
                mVar.f1(7, pendingMessageEntity.getId().longValue());
            }
        }
    }

    class h extends SharedSQLiteStatement {
        h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM pending_messages WHERE `id` = ?";
        }
    }

    class i extends SharedSQLiteStatement {
        i(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE pending_messages SET `status` = ? WHERE `id` = ?";
        }
    }

    class j extends SharedSQLiteStatement {
        j(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE pending_messages SET `time_sent` = ? WHERE `id` = ?";
        }
    }

    class k implements Callable<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PendingMessageEntity f11643a;

        k(PendingMessageEntity pendingMessageEntity) {
            this.f11643a = pendingMessageEntity;
        }

        /* renamed from: a */
        public Long call() throws Exception {
            a0.this.f11619a.e();
            try {
                long l10 = a0.this.f11620b.l(this.f11643a);
                a0.this.f11619a.C();
                return Long.valueOf(l10);
            } finally {
                a0.this.f11619a.j();
            }
        }
    }

    public a0(RoomDatabase roomDatabase) {
        this.f11619a = roomDatabase;
        this.f11620b = new d(roomDatabase);
        this.f11623e = new e(roomDatabase);
        this.f11624f = new f(roomDatabase);
        this.f11625g = new g(roomDatabase);
        this.f11626h = new h(roomDatabase);
        this.f11627i = new i(roomDatabase);
        this.f11628j = new j(roomDatabase);
    }

    public static List<Class<?>> H() {
        return Collections.emptyList();
    }

    public int A(long j10, String str) {
        this.f11619a.d();
        m b10 = this.f11628j.b();
        if (str == null) {
            b10.B1(1);
        } else {
            b10.P0(1, str);
        }
        b10.f1(2, j10);
        this.f11619a.e();
        try {
            int H = b10.H();
            this.f11619a.C();
            return H;
        } finally {
            this.f11619a.j();
            this.f11628j.h(b10);
        }
    }

    /* renamed from: I */
    public w<Long> insert(PendingMessageEntity pendingMessageEntity) {
        return w.A(new k(pendingMessageEntity));
    }

    public w<Integer> u(long j10) {
        return w.A(new a(j10));
    }

    public List<PendingMessageEntity> v(MessageStatus messageStatus, String str) {
        Long l10;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = str;
        k0 c10 = k0.c("SELECT * from pending_messages WHERE `status` = ? AND dateTime(time_sent) > dateTime(?)", 2);
        String a10 = this.f11621c.a(messageStatus);
        if (a10 == null) {
            c10.B1(1);
        } else {
            c10.P0(1, a10);
        }
        if (str7 == null) {
            c10.B1(2);
        } else {
            c10.P0(2, str7);
        }
        this.f11619a.d();
        Cursor b10 = q1.b.b(this.f11619a, c10, false, (CancellationSignal) null);
        try {
            int e10 = q1.a.e(b10, "id");
            int e11 = q1.a.e(b10, Extra.BAGEL_ID);
            int e12 = q1.a.e(b10, "status");
            int e13 = q1.a.e(b10, "text");
            int e14 = q1.a.e(b10, "time_sent");
            int e15 = q1.a.e(b10, "type");
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                if (b10.isNull(e10)) {
                    l10 = null;
                } else {
                    l10 = Long.valueOf(b10.getLong(e10));
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
                MessageStatus b11 = this.f11621c.b(str3);
                if (b10.isNull(e13)) {
                    str4 = null;
                } else {
                    str4 = b10.getString(e13);
                }
                if (b10.isNull(e14)) {
                    str5 = null;
                } else {
                    str5 = b10.getString(e14);
                }
                if (b10.isNull(e15)) {
                    str6 = null;
                } else {
                    str6 = b10.getString(e15);
                }
                arrayList.add(new PendingMessageEntity(l10, str2, b11, str4, str5, this.f11622d.b(str6)));
            }
            return arrayList;
        } finally {
            b10.close();
            c10.g();
        }
    }

    public List<PendingMessageEntity> x(MessageStatus messageStatus, String str) {
        Long l10;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = str;
        k0 c10 = k0.c("SELECT * from pending_messages WHERE `status` = ? AND `bagel_id` = ?", 2);
        String a10 = this.f11621c.a(messageStatus);
        if (a10 == null) {
            c10.B1(1);
        } else {
            c10.P0(1, a10);
        }
        if (str7 == null) {
            c10.B1(2);
        } else {
            c10.P0(2, str7);
        }
        this.f11619a.d();
        Cursor b10 = q1.b.b(this.f11619a, c10, false, (CancellationSignal) null);
        try {
            int e10 = q1.a.e(b10, "id");
            int e11 = q1.a.e(b10, Extra.BAGEL_ID);
            int e12 = q1.a.e(b10, "status");
            int e13 = q1.a.e(b10, "text");
            int e14 = q1.a.e(b10, "time_sent");
            int e15 = q1.a.e(b10, "type");
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                if (b10.isNull(e10)) {
                    l10 = null;
                } else {
                    l10 = Long.valueOf(b10.getLong(e10));
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
                MessageStatus b11 = this.f11621c.b(str3);
                if (b10.isNull(e13)) {
                    str4 = null;
                } else {
                    str4 = b10.getString(e13);
                }
                if (b10.isNull(e14)) {
                    str5 = null;
                } else {
                    str5 = b10.getString(e14);
                }
                if (b10.isNull(e15)) {
                    str6 = null;
                } else {
                    str6 = b10.getString(e15);
                }
                arrayList.add(new PendingMessageEntity(l10, str2, b11, str4, str5, this.f11622d.b(str6)));
            }
            return arrayList;
        } finally {
            b10.close();
            c10.g();
        }
    }

    public w<List<PendingMessageEntity>> y(String str) {
        k0 c10 = k0.c("SELECT * FROM pending_messages WHERE `bagel_id` = ?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.c(new c(c10));
    }

    public w<Integer> z(long j10, MessageStatus messageStatus) {
        return w.A(new b(messageStatus, j10));
    }
}

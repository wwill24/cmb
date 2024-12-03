package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.h;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.entities.ActionCardEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import qj.w;
import t1.m;

public final class d extends ActionCardRoomDao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11673a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final h<ActionCardEntity> f11674b;

    /* renamed from: c  reason: collision with root package name */
    private final h<ActionCardEntity> f11675c;

    /* renamed from: d  reason: collision with root package name */
    private final androidx.room.g<ActionCardEntity> f11676d;

    /* renamed from: e  reason: collision with root package name */
    private final androidx.room.g<ActionCardEntity> f11677e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f11678f;

    class a implements Callable<List<ActionCardEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11679a;

        a(k0 k0Var) {
            this.f11679a = k0Var;
        }

        /* renamed from: a */
        public List<ActionCardEntity> call() throws Exception {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            Cursor b10 = q1.b.b(d.this.f11673a, this.f11679a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "id");
                int e11 = q1.a.e(b10, "action");
                int e12 = q1.a.e(b10, "action_text");
                int e13 = q1.a.e(b10, "header_text");
                int e14 = q1.a.e(b10, "image_url");
                int e15 = q1.a.e(b10, "message_text");
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
                    if (b10.isNull(e12)) {
                        str3 = null;
                    } else {
                        str3 = b10.getString(e12);
                    }
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
                    arrayList.add(new ActionCardEntity(str, str2, str3, str4, str5, str6));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11679a.g();
        }
    }

    class b extends h<ActionCardEntity> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `action_card` (`id`,`action`,`action_text`,`header_text`,`image_url`,`message_text`) VALUES (?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, ActionCardEntity actionCardEntity) {
            if (actionCardEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, actionCardEntity.getId());
            }
            if (actionCardEntity.getAction() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, actionCardEntity.getAction());
            }
            if (actionCardEntity.getActionText() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, actionCardEntity.getActionText());
            }
            if (actionCardEntity.getHeaderText() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, actionCardEntity.getHeaderText());
            }
            if (actionCardEntity.getImageUrl() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, actionCardEntity.getImageUrl());
            }
            if (actionCardEntity.getMessageText() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, actionCardEntity.getMessageText());
            }
        }
    }

    class c extends h<ActionCardEntity> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `action_card` (`id`,`action`,`action_text`,`header_text`,`image_url`,`message_text`) VALUES (?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, ActionCardEntity actionCardEntity) {
            if (actionCardEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, actionCardEntity.getId());
            }
            if (actionCardEntity.getAction() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, actionCardEntity.getAction());
            }
            if (actionCardEntity.getActionText() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, actionCardEntity.getActionText());
            }
            if (actionCardEntity.getHeaderText() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, actionCardEntity.getHeaderText());
            }
            if (actionCardEntity.getImageUrl() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, actionCardEntity.getImageUrl());
            }
            if (actionCardEntity.getMessageText() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, actionCardEntity.getMessageText());
            }
        }
    }

    /* renamed from: com.coffeemeetsbagel.database.daos.d$d  reason: collision with other inner class name */
    class C0127d extends androidx.room.g<ActionCardEntity> {
        C0127d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `action_card` WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, ActionCardEntity actionCardEntity) {
            if (actionCardEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, actionCardEntity.getId());
            }
        }
    }

    class e extends androidx.room.g<ActionCardEntity> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `action_card` SET `id` = ?,`action` = ?,`action_text` = ?,`header_text` = ?,`image_url` = ?,`message_text` = ? WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, ActionCardEntity actionCardEntity) {
            if (actionCardEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, actionCardEntity.getId());
            }
            if (actionCardEntity.getAction() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, actionCardEntity.getAction());
            }
            if (actionCardEntity.getActionText() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, actionCardEntity.getActionText());
            }
            if (actionCardEntity.getHeaderText() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, actionCardEntity.getHeaderText());
            }
            if (actionCardEntity.getImageUrl() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, actionCardEntity.getImageUrl());
            }
            if (actionCardEntity.getMessageText() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, actionCardEntity.getMessageText());
            }
            if (actionCardEntity.getId() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, actionCardEntity.getId());
            }
        }
    }

    class f extends SharedSQLiteStatement {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM action_card";
        }
    }

    class g implements Callable<List<Long>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f11686a;

        g(List list) {
            this.f11686a = list;
        }

        /* renamed from: a */
        public List<Long> call() throws Exception {
            d.this.f11673a.e();
            try {
                List<Long> m10 = d.this.f11674b.m(this.f11686a);
                d.this.f11673a.C();
                return m10;
            } finally {
                d.this.f11673a.j();
            }
        }
    }

    public d(RoomDatabase roomDatabase) {
        this.f11673a = roomDatabase;
        this.f11674b = new b(roomDatabase);
        this.f11675c = new c(roomDatabase);
        this.f11676d = new C0127d(roomDatabase);
        this.f11677e = new e(roomDatabase);
        this.f11678f = new f(roomDatabase);
    }

    public static List<Class<?>> y() {
        return Collections.emptyList();
    }

    public int j() {
        this.f11673a.d();
        m b10 = this.f11678f.b();
        this.f11673a.e();
        try {
            int H = b10.H();
            this.f11673a.C();
            return H;
        } finally {
            this.f11673a.j();
            this.f11678f.h(b10);
        }
    }

    public w<List<Long>> l(List<? extends ActionCardEntity> list) {
        return w.A(new g(list));
    }

    public w<List<ActionCardEntity>> v() {
        return l0.c(new a(k0.c("SELECT * FROM action_card", 0)));
    }
}

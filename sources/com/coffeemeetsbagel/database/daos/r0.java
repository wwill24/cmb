package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.g;
import androidx.room.h;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.dto.StickerDataContract;
import com.coffeemeetsbagel.models.entities.StickerEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import qj.w;
import t1.m;

public final class r0 extends StickerRoomDao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11870a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StickerEntity> f11871b;

    /* renamed from: c  reason: collision with root package name */
    private final h<StickerEntity> f11872c;

    /* renamed from: d  reason: collision with root package name */
    private final g<StickerEntity> f11873d;

    /* renamed from: e  reason: collision with root package name */
    private final g<StickerEntity> f11874e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f11875f;

    class a implements Callable<List<StickerEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11876a;

        a(k0 k0Var) {
            this.f11876a = k0Var;
        }

        /* renamed from: a */
        public List<StickerEntity> call() throws Exception {
            String str;
            String str2;
            String str3;
            Cursor b10 = q1.b.b(r0.this.f11870a, this.f11876a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "name");
                int e11 = q1.a.e(b10, "description");
                int e12 = q1.a.e(b10, "image_url");
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
                    arrayList.add(new StickerEntity(str, str2, str3));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f11876a.g();
        }
    }

    class b extends h<StickerEntity> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `stickers` (`name`,`description`,`image_url`) VALUES (?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, StickerEntity stickerEntity) {
            if (stickerEntity.getName() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, stickerEntity.getName());
            }
            if (stickerEntity.getDescription() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, stickerEntity.getDescription());
            }
            if (stickerEntity.getImageUrl() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, stickerEntity.getImageUrl());
            }
        }
    }

    class c extends h<StickerEntity> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `stickers` (`name`,`description`,`image_url`) VALUES (?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, StickerEntity stickerEntity) {
            if (stickerEntity.getName() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, stickerEntity.getName());
            }
            if (stickerEntity.getDescription() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, stickerEntity.getDescription());
            }
            if (stickerEntity.getImageUrl() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, stickerEntity.getImageUrl());
            }
        }
    }

    class d extends g<StickerEntity> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `stickers` WHERE `image_url` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, StickerEntity stickerEntity) {
            if (stickerEntity.getImageUrl() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, stickerEntity.getImageUrl());
            }
        }
    }

    class e extends g<StickerEntity> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `stickers` SET `name` = ?,`description` = ?,`image_url` = ? WHERE `image_url` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, StickerEntity stickerEntity) {
            if (stickerEntity.getName() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, stickerEntity.getName());
            }
            if (stickerEntity.getDescription() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, stickerEntity.getDescription());
            }
            if (stickerEntity.getImageUrl() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, stickerEntity.getImageUrl());
            }
            if (stickerEntity.getImageUrl() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, stickerEntity.getImageUrl());
            }
        }
    }

    class f extends SharedSQLiteStatement {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM Stickers";
        }
    }

    public r0(RoomDatabase roomDatabase) {
        this.f11870a = roomDatabase;
        this.f11871b = new b(roomDatabase);
        this.f11872c = new c(roomDatabase);
        this.f11873d = new d(roomDatabase);
        this.f11874e = new e(roomDatabase);
        this.f11875f = new f(roomDatabase);
    }

    public static List<Class<?>> v() {
        return Collections.emptyList();
    }

    public int c(List<? extends StickerDataContract> list) {
        this.f11870a.e();
        try {
            int u10 = super.c(list);
            this.f11870a.C();
            return u10;
        } finally {
            this.f11870a.j();
        }
    }

    public int g() {
        this.f11870a.d();
        m b10 = this.f11875f.b();
        this.f11870a.e();
        try {
            int H = b10.H();
            this.f11870a.C();
            return H;
        } finally {
            this.f11870a.j();
            this.f11875f.h(b10);
        }
    }

    public w<List<StickerEntity>> j() {
        return l0.c(new a(k0.c("SELECT * FROM Stickers", 0)));
    }

    public List<Long> s(List<? extends StickerEntity> list) {
        this.f11870a.d();
        this.f11870a.e();
        try {
            List<Long> m10 = this.f11871b.m(list);
            this.f11870a.C();
            return m10;
        } finally {
            this.f11870a.j();
        }
    }
}

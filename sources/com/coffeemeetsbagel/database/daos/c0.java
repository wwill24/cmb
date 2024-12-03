package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.g;
import androidx.room.h;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.entities.PhotoEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import net.bytebuddy.description.type.TypeDescription;
import t1.m;

public final class c0 extends b0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f11662a;

    /* renamed from: b  reason: collision with root package name */
    private final h<PhotoEntity> f11663b;

    /* renamed from: c  reason: collision with root package name */
    private final h<PhotoEntity> f11664c;

    /* renamed from: d  reason: collision with root package name */
    private final g<PhotoEntity> f11665d;

    /* renamed from: e  reason: collision with root package name */
    private final g<PhotoEntity> f11666e;

    class a implements Callable<List<PhotoEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f11667a;

        a(k0 k0Var) {
            this.f11667a = k0Var;
        }

        /* renamed from: a */
        public List<PhotoEntity> call() throws Exception {
            String str;
            String str2;
            String str3;
            String str4;
            Cursor b10 = q1.b.b(c0.this.f11662a, this.f11667a, false, (CancellationSignal) null);
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
            this.f11667a.g();
        }
    }

    class b extends h<PhotoEntity> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `photos` (`photoId`,`caption`,`position`,`profile_id`,`url`) VALUES (?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, PhotoEntity photoEntity) {
            if (photoEntity.getPhotoId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, photoEntity.getPhotoId());
            }
            if (photoEntity.getCaption() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, photoEntity.getCaption());
            }
            mVar.f1(3, (long) photoEntity.getPosition());
            if (photoEntity.getProfileId() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, photoEntity.getProfileId());
            }
            if (photoEntity.getUrl() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, photoEntity.getUrl());
            }
        }
    }

    class c extends h<PhotoEntity> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `photos` (`photoId`,`caption`,`position`,`profile_id`,`url`) VALUES (?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, PhotoEntity photoEntity) {
            if (photoEntity.getPhotoId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, photoEntity.getPhotoId());
            }
            if (photoEntity.getCaption() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, photoEntity.getCaption());
            }
            mVar.f1(3, (long) photoEntity.getPosition());
            if (photoEntity.getProfileId() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, photoEntity.getProfileId());
            }
            if (photoEntity.getUrl() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, photoEntity.getUrl());
            }
        }
    }

    class d extends g<PhotoEntity> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `photos` WHERE `photoId` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, PhotoEntity photoEntity) {
            if (photoEntity.getPhotoId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, photoEntity.getPhotoId());
            }
        }
    }

    class e extends g<PhotoEntity> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `photos` SET `photoId` = ?,`caption` = ?,`position` = ?,`profile_id` = ?,`url` = ? WHERE `photoId` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, PhotoEntity photoEntity) {
            if (photoEntity.getPhotoId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, photoEntity.getPhotoId());
            }
            if (photoEntity.getCaption() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, photoEntity.getCaption());
            }
            mVar.f1(3, (long) photoEntity.getPosition());
            if (photoEntity.getProfileId() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, photoEntity.getProfileId());
            }
            if (photoEntity.getUrl() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, photoEntity.getUrl());
            }
            if (photoEntity.getPhotoId() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, photoEntity.getPhotoId());
            }
        }
    }

    public c0(RoomDatabase roomDatabase) {
        this.f11662a = roomDatabase;
        this.f11663b = new b(roomDatabase);
        this.f11664c = new c(roomDatabase);
        this.f11665d = new d(roomDatabase);
        this.f11666e = new e(roomDatabase);
    }

    public static List<Class<?>> z() {
        return Collections.emptyList();
    }

    /* renamed from: A */
    public long q(PhotoEntity photoEntity) {
        this.f11662a.d();
        this.f11662a.e();
        try {
            long l10 = this.f11663b.l(photoEntity);
            this.f11662a.C();
            return l10;
        } finally {
            this.f11662a.j();
        }
    }

    public int c(List<PhotoEntity> list) {
        this.f11662a.e();
        try {
            int v10 = super.c(list);
            this.f11662a.C();
            return v10;
        } finally {
            this.f11662a.j();
        }
    }

    public void g(PhotoEntity photoEntity, PhotoEntity photoEntity2) {
        this.f11662a.e();
        try {
            super.g(photoEntity, photoEntity2);
            this.f11662a.C();
        } finally {
            this.f11662a.j();
        }
    }

    public void j(String str, List<String> list) {
        this.f11662a.d();
        StringBuilder b10 = q1.d.b();
        b10.append("DELETE from photos WHERE profile_id = ");
        b10.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
        b10.append(" AND url NOT IN (");
        q1.d.a(b10, list.size());
        b10.append(")");
        m g10 = this.f11662a.g(b10.toString());
        if (str == null) {
            g10.B1(1);
        } else {
            g10.P0(1, str);
        }
        int i10 = 2;
        for (String next : list) {
            if (next == null) {
                g10.B1(i10);
            } else {
                g10.P0(i10, next);
            }
            i10++;
        }
        this.f11662a.e();
        try {
            g10.H();
            this.f11662a.C();
        } finally {
            this.f11662a.j();
        }
    }

    public int k(List<? extends PhotoEntity> list) {
        this.f11662a.d();
        this.f11662a.e();
        try {
            int k10 = this.f11666e.k(list) + 0;
            this.f11662a.C();
            return k10;
        } finally {
            this.f11662a.j();
        }
    }

    public qj.h<List<PhotoEntity>> n(String str) {
        k0 c10 = k0.c("SELECT * from photos WHERE profile_id = ? ORDER BY position", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.a(this.f11662a, false, new String[]{"photos"}, new a(c10));
    }

    public int o(List<PhotoEntity> list) {
        this.f11662a.e();
        try {
            int x10 = super.o(list);
            this.f11662a.C();
            return x10;
        } finally {
            this.f11662a.j();
        }
    }

    public List<Long> s(List<? extends PhotoEntity> list) {
        this.f11662a.d();
        this.f11662a.e();
        try {
            List<Long> m10 = this.f11663b.m(list);
            this.f11662a.C();
            return m10;
        } finally {
            this.f11662a.j();
        }
    }

    /* renamed from: y */
    public int e(PhotoEntity photoEntity) {
        this.f11662a.d();
        this.f11662a.e();
        try {
            int j10 = this.f11665d.j(photoEntity) + 0;
            this.f11662a.C();
            return j10;
        } finally {
            this.f11662a.j();
        }
    }
}

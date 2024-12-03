package com.coffeemeetsbagel.likes_you;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.g;
import androidx.room.h;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.entities.LikesYouPaywallCard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import qj.w;
import t1.m;

public final class p extends o {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f34246a;

    /* renamed from: b  reason: collision with root package name */
    private final h<LikesYouPaywallCard> f34247b;

    /* renamed from: c  reason: collision with root package name */
    private final h<LikesYouPaywallCard> f34248c;

    /* renamed from: d  reason: collision with root package name */
    private final g<LikesYouPaywallCard> f34249d;

    /* renamed from: e  reason: collision with root package name */
    private final g<LikesYouPaywallCard> f34250e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f34251f;

    class a implements Callable<List<LikesYouPaywallCard>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f34252a;

        a(k0 k0Var) {
            this.f34252a = k0Var;
        }

        /* renamed from: a */
        public List<LikesYouPaywallCard> call() throws Exception {
            String str;
            String str2;
            Integer num;
            Cursor b10 = q1.b.b(p.this.f34246a, this.f34252a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, Extra.PROFILE_ID);
                int e11 = q1.a.e(b10, "image_url");
                int e12 = q1.a.e(b10, "purchase_attribution");
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
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(e12));
                    }
                    arrayList.add(new LikesYouPaywallCard(str, str2, num));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f34252a.g();
        }
    }

    class b extends h<LikesYouPaywallCard> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `likes_you_paywall_card` (`profile_id`,`image_url`,`purchase_attribution`) VALUES (?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, LikesYouPaywallCard likesYouPaywallCard) {
            if (likesYouPaywallCard.getProfileId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, likesYouPaywallCard.getProfileId());
            }
            if (likesYouPaywallCard.getImageUrl() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, likesYouPaywallCard.getImageUrl());
            }
            if (likesYouPaywallCard.getPurchaseAttribution() == null) {
                mVar.B1(3);
            } else {
                mVar.f1(3, (long) likesYouPaywallCard.getPurchaseAttribution().intValue());
            }
        }
    }

    class c extends h<LikesYouPaywallCard> {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `likes_you_paywall_card` (`profile_id`,`image_url`,`purchase_attribution`) VALUES (?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, LikesYouPaywallCard likesYouPaywallCard) {
            if (likesYouPaywallCard.getProfileId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, likesYouPaywallCard.getProfileId());
            }
            if (likesYouPaywallCard.getImageUrl() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, likesYouPaywallCard.getImageUrl());
            }
            if (likesYouPaywallCard.getPurchaseAttribution() == null) {
                mVar.B1(3);
            } else {
                mVar.f1(3, (long) likesYouPaywallCard.getPurchaseAttribution().intValue());
            }
        }
    }

    class d extends g<LikesYouPaywallCard> {
        d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `likes_you_paywall_card` WHERE `profile_id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, LikesYouPaywallCard likesYouPaywallCard) {
            if (likesYouPaywallCard.getProfileId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, likesYouPaywallCard.getProfileId());
            }
        }
    }

    class e extends g<LikesYouPaywallCard> {
        e(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `likes_you_paywall_card` SET `profile_id` = ?,`image_url` = ?,`purchase_attribution` = ? WHERE `profile_id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, LikesYouPaywallCard likesYouPaywallCard) {
            if (likesYouPaywallCard.getProfileId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, likesYouPaywallCard.getProfileId());
            }
            if (likesYouPaywallCard.getImageUrl() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, likesYouPaywallCard.getImageUrl());
            }
            if (likesYouPaywallCard.getPurchaseAttribution() == null) {
                mVar.B1(3);
            } else {
                mVar.f1(3, (long) likesYouPaywallCard.getPurchaseAttribution().intValue());
            }
            if (likesYouPaywallCard.getProfileId() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, likesYouPaywallCard.getProfileId());
            }
        }
    }

    class f extends SharedSQLiteStatement {
        f(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE from likes_you_paywall_card";
        }
    }

    public p(RoomDatabase roomDatabase) {
        this.f34246a = roomDatabase;
        this.f34247b = new b(roomDatabase);
        this.f34248c = new c(roomDatabase);
        this.f34249d = new d(roomDatabase);
        this.f34250e = new e(roomDatabase);
        this.f34251f = new f(roomDatabase);
    }

    public static List<Class<?>> n() {
        return Collections.emptyList();
    }

    public void c(List<LikesYouPaywallCard> list) {
        this.f34246a.e();
        try {
            super.c(list);
            this.f34246a.C();
        } finally {
            this.f34246a.j();
        }
    }

    public void f() {
        this.f34246a.d();
        m b10 = this.f34251f.b();
        this.f34246a.e();
        try {
            b10.H();
            this.f34246a.C();
        } finally {
            this.f34246a.j();
            this.f34251f.h(b10);
        }
    }

    public w<List<LikesYouPaywallCard>> g() {
        return l0.c(new a(k0.c("SELECT * FROM likes_you_paywall_card", 0)));
    }

    public List<Long> s(List<? extends LikesYouPaywallCard> list) {
        this.f34246a.d();
        this.f34246a.e();
        try {
            List<Long> m10 = this.f34247b.m(list);
            this.f34246a.C();
            return m10;
        } finally {
            this.f34246a.j();
        }
    }
}

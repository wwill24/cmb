package com.coffeemeetsbagel.likes_you;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.h;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.likesyou.db.LikesYouGroupCardCrossRef;
import com.coffeemeetsbagel.likesyou.db.LikesYouGroupPaywallCardCrossRef;
import com.coffeemeetsbagel.likesyou.db.LikesYouGroupWithCards;
import com.coffeemeetsbagel.models.entities.LikesYouCardEntity;
import com.coffeemeetsbagel.models.entities.LikesYouGroupEntity;
import com.coffeemeetsbagel.models.entities.LikesYouPaywallCard;
import g6.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import t1.m;

public final class r extends q {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f34303a;

    /* renamed from: b  reason: collision with root package name */
    private final h<LikesYouGroupCardCrossRef> f34304b;

    /* renamed from: c  reason: collision with root package name */
    private final h<LikesYouGroupPaywallCardCrossRef> f34305c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final g6.d f34306d = new g6.d();

    /* renamed from: e  reason: collision with root package name */
    private final k f34307e = new k();

    class a extends h<LikesYouGroupCardCrossRef> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `LikesYouGroupCardCrossRef` (`id`,`profile_id`) VALUES (?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, LikesYouGroupCardCrossRef likesYouGroupCardCrossRef) {
            if (likesYouGroupCardCrossRef.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, likesYouGroupCardCrossRef.getId());
            }
            if (likesYouGroupCardCrossRef.getProfileId() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, likesYouGroupCardCrossRef.getProfileId());
            }
        }
    }

    class b extends h<LikesYouGroupPaywallCardCrossRef> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `LikesYouGroupPaywallCardCrossRef` (`id`,`profile_id`) VALUES (?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, LikesYouGroupPaywallCardCrossRef likesYouGroupPaywallCardCrossRef) {
            if (likesYouGroupPaywallCardCrossRef.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, likesYouGroupPaywallCardCrossRef.getId());
            }
            if (likesYouGroupPaywallCardCrossRef.getProfileId() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, likesYouGroupPaywallCardCrossRef.getProfileId());
            }
        }
    }

    class c implements Callable<List<LikesYouGroupWithCards>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f34310a;

        c(k0 k0Var) {
            this.f34310a = k0Var;
        }

        /* renamed from: a */
        public List<LikesYouGroupWithCards> call() throws Exception {
            Cursor b10;
            String str;
            String str2;
            int i10;
            String str3;
            Integer num;
            String str4;
            String str5;
            String str6;
            String str7;
            int i11;
            String str8;
            int i12;
            String str9;
            int i13;
            String str10;
            int i14;
            String str11;
            int i15;
            r.this.f34303a.e();
            try {
                b10 = q1.b.b(r.this.f34303a, this.f34310a, true, (CancellationSignal) null);
                int e10 = q1.a.e(b10, "id");
                int e11 = q1.a.e(b10, "name");
                int e12 = q1.a.e(b10, "count");
                int e13 = q1.a.e(b10, "group_ordinal");
                int e14 = q1.a.e(b10, "ordered_profile_ids");
                int e15 = q1.a.e(b10, "max_display_count");
                int e16 = q1.a.e(b10, "contextual_recommendation_icon");
                int e17 = q1.a.e(b10, "contextual_recommendation_text");
                int e18 = q1.a.e(b10, "contextual_recommendation_desc");
                int e19 = q1.a.e(b10, "empty_state_action");
                int e20 = q1.a.e(b10, "empty_state_cta_text");
                int e21 = q1.a.e(b10, "empty_state_description");
                int e22 = q1.a.e(b10, "empty_state_image_url");
                int e23 = q1.a.e(b10, "empty_state_title_text");
                androidx.collection.a aVar = new androidx.collection.a();
                int i16 = e22;
                androidx.collection.a aVar2 = new androidx.collection.a();
                while (b10.moveToNext()) {
                    int i17 = e21;
                    String string = b10.getString(e10);
                    if (((ArrayList) aVar.get(string)) == null) {
                        i15 = e20;
                        aVar.put(string, new ArrayList());
                    } else {
                        i15 = e20;
                    }
                    String string2 = b10.getString(e10);
                    if (((ArrayList) aVar2.get(string2)) == null) {
                        aVar2.put(string2, new ArrayList());
                    }
                    e21 = i17;
                    e20 = i15;
                }
                int i18 = e20;
                int i19 = e21;
                b10.moveToPosition(-1);
                r.this.i(aVar);
                r.this.j(aVar2);
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
                    int i20 = b10.getInt(e12);
                    int i21 = b10.getInt(e13);
                    if (b10.isNull(e14)) {
                        i10 = e11;
                        str3 = null;
                    } else {
                        str3 = b10.getString(e14);
                        i10 = e11;
                    }
                    List<String> b11 = r.this.f34306d.b(str3);
                    if (b10.isNull(e15)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(e15));
                    }
                    if (b10.isNull(e16)) {
                        str4 = null;
                    } else {
                        str4 = b10.getString(e16);
                    }
                    if (b10.isNull(e17)) {
                        str5 = null;
                    } else {
                        str5 = b10.getString(e17);
                    }
                    if (b10.isNull(e18)) {
                        str6 = null;
                    } else {
                        str6 = b10.getString(e18);
                    }
                    if (b10.isNull(e19)) {
                        i11 = i18;
                        str7 = null;
                    } else {
                        str7 = b10.getString(e19);
                        i11 = i18;
                    }
                    if (b10.isNull(i11)) {
                        i12 = i19;
                        str8 = null;
                    } else {
                        str8 = b10.getString(i11);
                        i12 = i19;
                    }
                    if (b10.isNull(i12)) {
                        i18 = i11;
                        i13 = i16;
                        str9 = null;
                    } else {
                        i18 = i11;
                        i13 = i16;
                        str9 = b10.getString(i12);
                    }
                    if (b10.isNull(i13)) {
                        i16 = i13;
                        i14 = e23;
                        str10 = null;
                    } else {
                        str10 = b10.getString(i13);
                        i16 = i13;
                        i14 = e23;
                    }
                    if (b10.isNull(i14)) {
                        e23 = i14;
                        str11 = null;
                    } else {
                        str11 = b10.getString(i14);
                        e23 = i14;
                    }
                    LikesYouGroupEntity likesYouGroupEntity = new LikesYouGroupEntity(str, str2, i20, i21, b11, num, str4, str5, str6, str7, str8, str9, str10, str11);
                    int i22 = e12;
                    ArrayList arrayList2 = (ArrayList) aVar.get(b10.getString(e10));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    androidx.collection.a aVar3 = aVar;
                    ArrayList arrayList3 = (ArrayList) aVar2.get(b10.getString(e10));
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList.add(new LikesYouGroupWithCards(likesYouGroupEntity, arrayList2, arrayList3));
                    e12 = i22;
                    aVar = aVar3;
                    e10 = e10;
                    e11 = i10;
                    i19 = i12;
                }
                r.this.f34303a.C();
                b10.close();
                r.this.f34303a.j();
                return arrayList;
            } catch (Throwable th2) {
                r.this.f34303a.j();
                throw th2;
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f34310a.g();
        }
    }

    class d implements Callable<List<LikesYouGroupWithCards>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f34312a;

        d(k0 k0Var) {
            this.f34312a = k0Var;
        }

        /* renamed from: a */
        public List<LikesYouGroupWithCards> call() throws Exception {
            Cursor b10;
            String str;
            String str2;
            int i10;
            String str3;
            Integer num;
            String str4;
            String str5;
            String str6;
            String str7;
            int i11;
            String str8;
            int i12;
            String str9;
            int i13;
            String str10;
            int i14;
            String str11;
            int i15;
            r.this.f34303a.e();
            try {
                b10 = q1.b.b(r.this.f34303a, this.f34312a, true, (CancellationSignal) null);
                int e10 = q1.a.e(b10, "id");
                int e11 = q1.a.e(b10, "name");
                int e12 = q1.a.e(b10, "count");
                int e13 = q1.a.e(b10, "group_ordinal");
                int e14 = q1.a.e(b10, "ordered_profile_ids");
                int e15 = q1.a.e(b10, "max_display_count");
                int e16 = q1.a.e(b10, "contextual_recommendation_icon");
                int e17 = q1.a.e(b10, "contextual_recommendation_text");
                int e18 = q1.a.e(b10, "contextual_recommendation_desc");
                int e19 = q1.a.e(b10, "empty_state_action");
                int e20 = q1.a.e(b10, "empty_state_cta_text");
                int e21 = q1.a.e(b10, "empty_state_description");
                int e22 = q1.a.e(b10, "empty_state_image_url");
                int e23 = q1.a.e(b10, "empty_state_title_text");
                androidx.collection.a aVar = new androidx.collection.a();
                int i16 = e22;
                androidx.collection.a aVar2 = new androidx.collection.a();
                while (b10.moveToNext()) {
                    int i17 = e21;
                    String string = b10.getString(e10);
                    if (((ArrayList) aVar.get(string)) == null) {
                        i15 = e20;
                        aVar.put(string, new ArrayList());
                    } else {
                        i15 = e20;
                    }
                    String string2 = b10.getString(e10);
                    if (((ArrayList) aVar2.get(string2)) == null) {
                        aVar2.put(string2, new ArrayList());
                    }
                    e21 = i17;
                    e20 = i15;
                }
                int i18 = e20;
                int i19 = e21;
                b10.moveToPosition(-1);
                r.this.i(aVar);
                r.this.j(aVar2);
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
                    int i20 = b10.getInt(e12);
                    int i21 = b10.getInt(e13);
                    if (b10.isNull(e14)) {
                        i10 = e11;
                        str3 = null;
                    } else {
                        str3 = b10.getString(e14);
                        i10 = e11;
                    }
                    List<String> b11 = r.this.f34306d.b(str3);
                    if (b10.isNull(e15)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(e15));
                    }
                    if (b10.isNull(e16)) {
                        str4 = null;
                    } else {
                        str4 = b10.getString(e16);
                    }
                    if (b10.isNull(e17)) {
                        str5 = null;
                    } else {
                        str5 = b10.getString(e17);
                    }
                    if (b10.isNull(e18)) {
                        str6 = null;
                    } else {
                        str6 = b10.getString(e18);
                    }
                    if (b10.isNull(e19)) {
                        i11 = i18;
                        str7 = null;
                    } else {
                        str7 = b10.getString(e19);
                        i11 = i18;
                    }
                    if (b10.isNull(i11)) {
                        i12 = i19;
                        str8 = null;
                    } else {
                        str8 = b10.getString(i11);
                        i12 = i19;
                    }
                    if (b10.isNull(i12)) {
                        i18 = i11;
                        i13 = i16;
                        str9 = null;
                    } else {
                        i18 = i11;
                        i13 = i16;
                        str9 = b10.getString(i12);
                    }
                    if (b10.isNull(i13)) {
                        i16 = i13;
                        i14 = e23;
                        str10 = null;
                    } else {
                        str10 = b10.getString(i13);
                        i16 = i13;
                        i14 = e23;
                    }
                    if (b10.isNull(i14)) {
                        e23 = i14;
                        str11 = null;
                    } else {
                        str11 = b10.getString(i14);
                        e23 = i14;
                    }
                    LikesYouGroupEntity likesYouGroupEntity = new LikesYouGroupEntity(str, str2, i20, i21, b11, num, str4, str5, str6, str7, str8, str9, str10, str11);
                    int i22 = e12;
                    ArrayList arrayList2 = (ArrayList) aVar.get(b10.getString(e10));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    androidx.collection.a aVar3 = aVar;
                    ArrayList arrayList3 = (ArrayList) aVar2.get(b10.getString(e10));
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList.add(new LikesYouGroupWithCards(likesYouGroupEntity, arrayList2, arrayList3));
                    e12 = i22;
                    aVar = aVar3;
                    e10 = e10;
                    e11 = i10;
                    i19 = i12;
                }
                r.this.f34303a.C();
                b10.close();
                r.this.f34303a.j();
                return arrayList;
            } catch (Throwable th2) {
                r.this.f34303a.j();
                throw th2;
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f34312a.g();
        }
    }

    public r(RoomDatabase roomDatabase) {
        this.f34303a = roomDatabase;
        this.f34304b = new a(roomDatabase);
        this.f34305c = new b(roomDatabase);
    }

    /* access modifiers changed from: private */
    public void i(androidx.collection.a<String, ArrayList<LikesYouCardEntity>> aVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Integer num;
        androidx.collection.a<String, ArrayList<LikesYouCardEntity>> aVar2 = aVar;
        Set<String> keySet = aVar.keySet();
        if (!keySet.isEmpty()) {
            if (aVar.size() > 999) {
                androidx.collection.a aVar3 = new androidx.collection.a(999);
                int size = aVar.size();
                int i10 = 0;
                int i11 = 0;
                while (i10 < size) {
                    aVar3.put(aVar2.j(i10), aVar2.n(i10));
                    i10++;
                    i11++;
                    if (i11 == 999) {
                        i(aVar3);
                        aVar3 = new androidx.collection.a(999);
                        i11 = 0;
                    }
                }
                if (i11 > 0) {
                    i(aVar3);
                    return;
                }
                return;
            }
            StringBuilder b10 = q1.d.b();
            b10.append("SELECT `likes_you_card`.`profile_id` AS `profile_id`,`likes_you_card`.`group_ids` AS `group_ids`,`likes_you_card`.`age` AS `age`,`likes_you_card`.`bagel_id` AS `bagel_id`,`likes_you_card`.`city` AS `city`,`likes_you_card`.`education` AS `education`,`likes_you_card`.`occupation` AS `occupation`,`likes_you_card`.`pair_like_comment` AS `pair_like_comment`,`likes_you_card`.`image_url` AS `image_url`,`likes_you_card`.`purchase_attribution` AS `purchase_attribution`,_junction.`id` FROM `LikesYouGroupCardCrossRef` AS _junction INNER JOIN `likes_you_card` ON (_junction.`profile_id` = `likes_you_card`.`profile_id`) WHERE _junction.`id` IN (");
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
            Cursor b11 = q1.b.b(this.f34303a, c10, false, (CancellationSignal) null);
            while (b11.moveToNext()) {
                try {
                    ArrayList arrayList = aVar2.get(b11.getString(10));
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
                        List<String> b12 = this.f34306d.b(str2);
                        int i13 = b11.getInt(2);
                        if (b11.isNull(3)) {
                            str3 = null;
                        } else {
                            str3 = b11.getString(3);
                        }
                        if (b11.isNull(4)) {
                            str4 = null;
                        } else {
                            str4 = b11.getString(4);
                        }
                        if (b11.isNull(5)) {
                            str5 = null;
                        } else {
                            str5 = b11.getString(5);
                        }
                        if (b11.isNull(6)) {
                            str6 = null;
                        } else {
                            str6 = b11.getString(6);
                        }
                        if (b11.isNull(7)) {
                            str7 = null;
                        } else {
                            str7 = b11.getString(7);
                        }
                        if (b11.isNull(8)) {
                            str8 = null;
                        } else {
                            str8 = b11.getString(8);
                        }
                        if (b11.isNull(9)) {
                            num = null;
                        } else {
                            num = Integer.valueOf(b11.getInt(9));
                        }
                        arrayList.add(new LikesYouCardEntity(str, b12, i13, str3, str4, str5, str6, str7, str8, this.f34307e.a(num)));
                    }
                } finally {
                    b11.close();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void j(androidx.collection.a<String, ArrayList<LikesYouPaywallCard>> aVar) {
        String str;
        String str2;
        Integer num;
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
                        j(aVar2);
                        aVar2 = new androidx.collection.a(999);
                        i11 = 0;
                    }
                }
                if (i11 > 0) {
                    j(aVar2);
                    return;
                }
                return;
            }
            StringBuilder b10 = q1.d.b();
            b10.append("SELECT `likes_you_paywall_card`.`profile_id` AS `profile_id`,`likes_you_paywall_card`.`image_url` AS `image_url`,`likes_you_paywall_card`.`purchase_attribution` AS `purchase_attribution`,_junction.`id` FROM `LikesYouGroupPaywallCardCrossRef` AS _junction INNER JOIN `likes_you_paywall_card` ON (_junction.`profile_id` = `likes_you_paywall_card`.`profile_id`) WHERE _junction.`id` IN (");
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
            Cursor b11 = q1.b.b(this.f34303a, c10, false, (CancellationSignal) null);
            while (b11.moveToNext()) {
                try {
                    ArrayList arrayList = aVar.get(b11.getString(3));
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
                            num = null;
                        } else {
                            num = Integer.valueOf(b11.getInt(2));
                        }
                        arrayList.add(new LikesYouPaywallCard(str, str2, num));
                    }
                } finally {
                    b11.close();
                }
            }
        }
    }

    public static List<Class<?>> k() {
        return Collections.emptyList();
    }

    public void a(List<LikesYouGroupCardCrossRef> list) {
        this.f34303a.d();
        this.f34303a.e();
        try {
            this.f34304b.j(list);
            this.f34303a.C();
        } finally {
            this.f34303a.j();
        }
    }

    public void b(List<LikesYouGroupPaywallCardCrossRef> list) {
        this.f34303a.d();
        this.f34303a.e();
        try {
            this.f34305c.j(list);
            this.f34303a.C();
        } finally {
            this.f34303a.j();
        }
    }

    public qj.h<List<LikesYouGroupWithCards>> c() {
        return l0.a(this.f34303a, true, new String[]{"LikesYouGroupCardCrossRef", "likes_you_card", "LikesYouGroupPaywallCardCrossRef", "likes_you_paywall_card", "likes_you_group"}, new d(k0.c("SELECT * FROM likes_you_group", 0)));
    }

    public qj.h<List<LikesYouGroupWithCards>> d(String str) {
        k0 c10 = k0.c("SELECT * FROM likes_you_group WHERE id = ?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.a(this.f34303a, true, new String[]{"LikesYouGroupCardCrossRef", "likes_you_card", "LikesYouGroupPaywallCardCrossRef", "likes_you_paywall_card", "likes_you_group"}, new c(c10));
    }
}

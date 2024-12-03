package com.coffeemeetsbagel.likes_you;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.entities.LikesYouGroupEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import qj.w;
import t1.m;

public final class k extends LikesYouGroupRoomDao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f34208a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.room.h<LikesYouGroupEntity> f34209b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final g6.d f34210c = new g6.d();

    /* renamed from: d  reason: collision with root package name */
    private final androidx.room.h<LikesYouGroupEntity> f34211d;

    /* renamed from: e  reason: collision with root package name */
    private final androidx.room.g<LikesYouGroupEntity> f34212e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final androidx.room.g<LikesYouGroupEntity> f34213f;

    /* renamed from: g  reason: collision with root package name */
    private final SharedSQLiteStatement f34214g;

    class a implements Callable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LikesYouGroupEntity f34215a;

        a(LikesYouGroupEntity likesYouGroupEntity) {
            this.f34215a = likesYouGroupEntity;
        }

        /* renamed from: a */
        public Integer call() throws Exception {
            k.this.f34208a.e();
            try {
                k.this.f34208a.C();
                return Integer.valueOf(k.this.f34213f.j(this.f34215a) + 0);
            } finally {
                k.this.f34208a.j();
            }
        }
    }

    class b implements Callable<List<LikesYouGroupEntity>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f34217a;

        b(k0 k0Var) {
            this.f34217a = k0Var;
        }

        /* renamed from: a */
        public List<LikesYouGroupEntity> call() throws Exception {
            String str;
            String str2;
            int i10;
            String str3;
            Integer num;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            int i11;
            String str10;
            int i12;
            String str11;
            Cursor b10 = q1.b.b(k.this.f34208a, this.f34217a, false, (CancellationSignal) null);
            try {
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
                int i13 = e22;
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
                    int i14 = b10.getInt(e12);
                    int i15 = b10.getInt(e13);
                    if (b10.isNull(e14)) {
                        i10 = e10;
                        str3 = null;
                    } else {
                        str3 = b10.getString(e14);
                        i10 = e10;
                    }
                    List<String> b11 = k.this.f34210c.b(str3);
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
                        str7 = null;
                    } else {
                        str7 = b10.getString(e19);
                    }
                    if (b10.isNull(e20)) {
                        str8 = null;
                    } else {
                        str8 = b10.getString(e20);
                    }
                    if (b10.isNull(e21)) {
                        i11 = i13;
                        str9 = null;
                    } else {
                        str9 = b10.getString(e21);
                        i11 = i13;
                    }
                    if (b10.isNull(i11)) {
                        i12 = e23;
                        str10 = null;
                    } else {
                        str10 = b10.getString(i11);
                        i12 = e23;
                    }
                    if (b10.isNull(i12)) {
                        i13 = i11;
                        str11 = null;
                    } else {
                        i13 = i11;
                        str11 = b10.getString(i12);
                    }
                    arrayList.add(new LikesYouGroupEntity(str, str2, i14, i15, b11, num, str4, str5, str6, str7, str8, str9, str10, str11));
                    e23 = i12;
                    e10 = i10;
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f34217a.g();
        }
    }

    class c implements Callable<LikesYouGroupEntity> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f34219a;

        c(k0 k0Var) {
            this.f34219a = k0Var;
        }

        /* renamed from: a */
        public LikesYouGroupEntity call() throws Exception {
            LikesYouGroupEntity likesYouGroupEntity;
            String str;
            String str2;
            String str3;
            Integer num;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            Cursor b10 = q1.b.b(k.this.f34208a, this.f34219a, false, (CancellationSignal) null);
            try {
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
                if (b10.moveToFirst()) {
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
                    int i11 = b10.getInt(e13);
                    if (b10.isNull(e14)) {
                        str3 = null;
                    } else {
                        str3 = b10.getString(e14);
                    }
                    List<String> b11 = k.this.f34210c.b(str3);
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
                        str7 = null;
                    } else {
                        str7 = b10.getString(e19);
                    }
                    if (b10.isNull(e20)) {
                        str8 = null;
                    } else {
                        str8 = b10.getString(e20);
                    }
                    if (b10.isNull(e21)) {
                        str9 = null;
                    } else {
                        str9 = b10.getString(e21);
                    }
                    if (b10.isNull(e22)) {
                        str10 = null;
                    } else {
                        str10 = b10.getString(e22);
                    }
                    if (b10.isNull(e23)) {
                        str11 = null;
                    } else {
                        str11 = b10.getString(e23);
                    }
                    likesYouGroupEntity = new LikesYouGroupEntity(str, str2, i10, i11, b11, num, str4, str5, str6, str7, str8, str9, str10, str11);
                } else {
                    likesYouGroupEntity = null;
                }
                return likesYouGroupEntity;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f34219a.g();
        }
    }

    class d implements Callable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f34221a;

        d(k0 k0Var) {
            this.f34221a = k0Var;
        }

        /* renamed from: a */
        public Integer call() throws Exception {
            Integer num = null;
            Cursor b10 = q1.b.b(k.this.f34208a, this.f34221a, false, (CancellationSignal) null);
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
            this.f34221a.g();
        }
    }

    class e implements Callable<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f34223a;

        e(k0 k0Var) {
            this.f34223a = k0Var;
        }

        /* renamed from: a */
        public Integer call() throws Exception {
            Integer num = null;
            Cursor b10 = q1.b.b(k.this.f34208a, this.f34223a, false, (CancellationSignal) null);
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
            this.f34223a.g();
        }
    }

    class f implements Callable<List<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f34225a;

        f(k0 k0Var) {
            this.f34225a = k0Var;
        }

        /* renamed from: a */
        public List<String> call() throws Exception {
            String str;
            Cursor b10 = q1.b.b(k.this.f34208a, this.f34225a, false, (CancellationSignal) null);
            try {
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(0)) {
                        str = null;
                    } else {
                        str = b10.getString(0);
                    }
                    arrayList.add(str);
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f34225a.g();
        }
    }

    class g extends androidx.room.h<LikesYouGroupEntity> {
        g(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `likes_you_group` (`id`,`name`,`count`,`group_ordinal`,`ordered_profile_ids`,`max_display_count`,`contextual_recommendation_icon`,`contextual_recommendation_text`,`contextual_recommendation_desc`,`empty_state_action`,`empty_state_cta_text`,`empty_state_description`,`empty_state_image_url`,`empty_state_title_text`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, LikesYouGroupEntity likesYouGroupEntity) {
            if (likesYouGroupEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, likesYouGroupEntity.getId());
            }
            if (likesYouGroupEntity.getName() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, likesYouGroupEntity.getName());
            }
            mVar.f1(3, (long) likesYouGroupEntity.getCount());
            mVar.f1(4, (long) likesYouGroupEntity.getGroupOrdinal());
            String a10 = k.this.f34210c.a(likesYouGroupEntity.getFreeProfileIds());
            if (a10 == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, a10);
            }
            if (likesYouGroupEntity.getMaxDisplayCounts() == null) {
                mVar.B1(6);
            } else {
                mVar.f1(6, (long) likesYouGroupEntity.getMaxDisplayCounts().intValue());
            }
            if (likesYouGroupEntity.getContextualRecommendationIcon() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, likesYouGroupEntity.getContextualRecommendationIcon());
            }
            if (likesYouGroupEntity.getContextualRecommendationText() == null) {
                mVar.B1(8);
            } else {
                mVar.P0(8, likesYouGroupEntity.getContextualRecommendationText());
            }
            if (likesYouGroupEntity.getContextualRecommendationDesc() == null) {
                mVar.B1(9);
            } else {
                mVar.P0(9, likesYouGroupEntity.getContextualRecommendationDesc());
            }
            if (likesYouGroupEntity.getEmptyStateAction() == null) {
                mVar.B1(10);
            } else {
                mVar.P0(10, likesYouGroupEntity.getEmptyStateAction());
            }
            if (likesYouGroupEntity.getEmptyStateCtaText() == null) {
                mVar.B1(11);
            } else {
                mVar.P0(11, likesYouGroupEntity.getEmptyStateCtaText());
            }
            if (likesYouGroupEntity.getEmptyStateDescription() == null) {
                mVar.B1(12);
            } else {
                mVar.P0(12, likesYouGroupEntity.getEmptyStateDescription());
            }
            if (likesYouGroupEntity.getEmptyStateImageUrl() == null) {
                mVar.B1(13);
            } else {
                mVar.P0(13, likesYouGroupEntity.getEmptyStateImageUrl());
            }
            if (likesYouGroupEntity.getEmptyStateTitleText() == null) {
                mVar.B1(14);
            } else {
                mVar.P0(14, likesYouGroupEntity.getEmptyStateTitleText());
            }
        }
    }

    class h extends androidx.room.h<LikesYouGroupEntity> {
        h(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `likes_you_group` (`id`,`name`,`count`,`group_ordinal`,`ordered_profile_ids`,`max_display_count`,`contextual_recommendation_icon`,`contextual_recommendation_text`,`contextual_recommendation_desc`,`empty_state_action`,`empty_state_cta_text`,`empty_state_description`,`empty_state_image_url`,`empty_state_title_text`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, LikesYouGroupEntity likesYouGroupEntity) {
            if (likesYouGroupEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, likesYouGroupEntity.getId());
            }
            if (likesYouGroupEntity.getName() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, likesYouGroupEntity.getName());
            }
            mVar.f1(3, (long) likesYouGroupEntity.getCount());
            mVar.f1(4, (long) likesYouGroupEntity.getGroupOrdinal());
            String a10 = k.this.f34210c.a(likesYouGroupEntity.getFreeProfileIds());
            if (a10 == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, a10);
            }
            if (likesYouGroupEntity.getMaxDisplayCounts() == null) {
                mVar.B1(6);
            } else {
                mVar.f1(6, (long) likesYouGroupEntity.getMaxDisplayCounts().intValue());
            }
            if (likesYouGroupEntity.getContextualRecommendationIcon() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, likesYouGroupEntity.getContextualRecommendationIcon());
            }
            if (likesYouGroupEntity.getContextualRecommendationText() == null) {
                mVar.B1(8);
            } else {
                mVar.P0(8, likesYouGroupEntity.getContextualRecommendationText());
            }
            if (likesYouGroupEntity.getContextualRecommendationDesc() == null) {
                mVar.B1(9);
            } else {
                mVar.P0(9, likesYouGroupEntity.getContextualRecommendationDesc());
            }
            if (likesYouGroupEntity.getEmptyStateAction() == null) {
                mVar.B1(10);
            } else {
                mVar.P0(10, likesYouGroupEntity.getEmptyStateAction());
            }
            if (likesYouGroupEntity.getEmptyStateCtaText() == null) {
                mVar.B1(11);
            } else {
                mVar.P0(11, likesYouGroupEntity.getEmptyStateCtaText());
            }
            if (likesYouGroupEntity.getEmptyStateDescription() == null) {
                mVar.B1(12);
            } else {
                mVar.P0(12, likesYouGroupEntity.getEmptyStateDescription());
            }
            if (likesYouGroupEntity.getEmptyStateImageUrl() == null) {
                mVar.B1(13);
            } else {
                mVar.P0(13, likesYouGroupEntity.getEmptyStateImageUrl());
            }
            if (likesYouGroupEntity.getEmptyStateTitleText() == null) {
                mVar.B1(14);
            } else {
                mVar.P0(14, likesYouGroupEntity.getEmptyStateTitleText());
            }
        }
    }

    class i extends androidx.room.g<LikesYouGroupEntity> {
        i(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `likes_you_group` WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, LikesYouGroupEntity likesYouGroupEntity) {
            if (likesYouGroupEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, likesYouGroupEntity.getId());
            }
        }
    }

    class j extends androidx.room.g<LikesYouGroupEntity> {
        j(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "UPDATE OR REPLACE `likes_you_group` SET `id` = ?,`name` = ?,`count` = ?,`group_ordinal` = ?,`ordered_profile_ids` = ?,`max_display_count` = ?,`contextual_recommendation_icon` = ?,`contextual_recommendation_text` = ?,`contextual_recommendation_desc` = ?,`empty_state_action` = ?,`empty_state_cta_text` = ?,`empty_state_description` = ?,`empty_state_image_url` = ?,`empty_state_title_text` = ? WHERE `id` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, LikesYouGroupEntity likesYouGroupEntity) {
            if (likesYouGroupEntity.getId() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, likesYouGroupEntity.getId());
            }
            if (likesYouGroupEntity.getName() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, likesYouGroupEntity.getName());
            }
            mVar.f1(3, (long) likesYouGroupEntity.getCount());
            mVar.f1(4, (long) likesYouGroupEntity.getGroupOrdinal());
            String a10 = k.this.f34210c.a(likesYouGroupEntity.getFreeProfileIds());
            if (a10 == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, a10);
            }
            if (likesYouGroupEntity.getMaxDisplayCounts() == null) {
                mVar.B1(6);
            } else {
                mVar.f1(6, (long) likesYouGroupEntity.getMaxDisplayCounts().intValue());
            }
            if (likesYouGroupEntity.getContextualRecommendationIcon() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, likesYouGroupEntity.getContextualRecommendationIcon());
            }
            if (likesYouGroupEntity.getContextualRecommendationText() == null) {
                mVar.B1(8);
            } else {
                mVar.P0(8, likesYouGroupEntity.getContextualRecommendationText());
            }
            if (likesYouGroupEntity.getContextualRecommendationDesc() == null) {
                mVar.B1(9);
            } else {
                mVar.P0(9, likesYouGroupEntity.getContextualRecommendationDesc());
            }
            if (likesYouGroupEntity.getEmptyStateAction() == null) {
                mVar.B1(10);
            } else {
                mVar.P0(10, likesYouGroupEntity.getEmptyStateAction());
            }
            if (likesYouGroupEntity.getEmptyStateCtaText() == null) {
                mVar.B1(11);
            } else {
                mVar.P0(11, likesYouGroupEntity.getEmptyStateCtaText());
            }
            if (likesYouGroupEntity.getEmptyStateDescription() == null) {
                mVar.B1(12);
            } else {
                mVar.P0(12, likesYouGroupEntity.getEmptyStateDescription());
            }
            if (likesYouGroupEntity.getEmptyStateImageUrl() == null) {
                mVar.B1(13);
            } else {
                mVar.P0(13, likesYouGroupEntity.getEmptyStateImageUrl());
            }
            if (likesYouGroupEntity.getEmptyStateTitleText() == null) {
                mVar.B1(14);
            } else {
                mVar.P0(14, likesYouGroupEntity.getEmptyStateTitleText());
            }
            if (likesYouGroupEntity.getId() == null) {
                mVar.B1(15);
            } else {
                mVar.P0(15, likesYouGroupEntity.getId());
            }
        }
    }

    /* renamed from: com.coffeemeetsbagel.likes_you.k$k  reason: collision with other inner class name */
    class C0409k extends SharedSQLiteStatement {
        C0409k(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE from likes_you_group";
        }
    }

    public k(RoomDatabase roomDatabase) {
        this.f34208a = roomDatabase;
        this.f34209b = new g(roomDatabase);
        this.f34211d = new h(roomDatabase);
        this.f34212e = new i(roomDatabase);
        this.f34213f = new j(roomDatabase);
        this.f34214g = new C0409k(roomDatabase);
    }

    public static List<Class<?>> F() {
        return Collections.emptyList();
    }

    public qj.h<Integer> A(String str) {
        k0 c10 = k0.c("SELECT max_display_count FROM likes_you_group WHERE id = ?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.a(this.f34208a, false, new String[]{"likes_you_group"}, new e(c10));
    }

    /* renamed from: G */
    public w<Integer> b(LikesYouGroupEntity likesYouGroupEntity) {
        return w.A(new a(likesYouGroupEntity));
    }

    public void c(List<LikesYouGroupEntity> list) {
        this.f34208a.e();
        try {
            super.c(list);
            this.f34208a.C();
        } finally {
            this.f34208a.j();
        }
    }

    public List<Long> s(List<? extends LikesYouGroupEntity> list) {
        this.f34208a.d();
        this.f34208a.e();
        try {
            List<Long> m10 = this.f34209b.m(list);
            this.f34208a.C();
            return m10;
        } finally {
            this.f34208a.j();
        }
    }

    public void u() {
        this.f34208a.d();
        m b10 = this.f34214g.b();
        this.f34208a.e();
        try {
            b10.H();
            this.f34208a.C();
        } finally {
            this.f34208a.j();
            this.f34214g.h(b10);
        }
    }

    public qj.h<List<LikesYouGroupEntity>> v() {
        return l0.a(this.f34208a, false, new String[]{"likes_you_group"}, new b(k0.c("SELECT *  FROM likes_you_group", 0)));
    }

    public qj.h<Integer> x(String str) {
        k0 c10 = k0.c("SELECT count FROM likes_you_group WHERE id = ?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.a(this.f34208a, false, new String[]{"likes_you_group"}, new d(c10));
    }

    public qj.h<LikesYouGroupEntity> y(String str) {
        k0 c10 = k0.c("SELECT * FROM likes_you_group WHERE id = ?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.a(this.f34208a, false, new String[]{"likes_you_group"}, new c(c10));
    }

    public w<List<String>> z(List<String> list) {
        StringBuilder b10 = q1.d.b();
        b10.append("SELECT name FROM likes_you_group WHERE id IN(");
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
        return l0.c(new f(c10));
    }
}

package com.coffeemeetsbagel.likes_you.presentation;

import com.coffeemeetsbagel.likes_you.l;
import com.coffeemeetsbagel.likes_you.q0;
import com.coffeemeetsbagel.models.entities.LikesYouCardEntity;
import com.coffeemeetsbagel.models.entities.LikesYouPaywallCard;
import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public abstract class LikesYouGridUiItem {

    /* renamed from: b  reason: collision with root package name */
    public static final a f34264b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final ViewType f34265a;

    public enum ViewType {
        UPSELL_CARD(0),
        CARD(1),
        EDIT_PREFS_CARD(2);
        
        private final int value;

        private ViewType(int i10) {
            this.value = i10;
        }

        public final int b() {
            return this.value;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a(LikesYouCardEntity likesYouCardEntity, String str, boolean z10) {
            boolean z11;
            String str2;
            String str3;
            j.g(likesYouCardEntity, "card");
            j.g(str, "instantLikeString");
            if (likesYouCardEntity.getPurchaseAttribution() == PurchaseAttribution.INSTANT_LIKE) {
                z11 = true;
            } else {
                z11 = false;
            }
            List p10 = q.p(new l((Integer) null, likesYouCardEntity.getAge() + ", " + likesYouCardEntity.getCity(), 0, 4, (DefaultConstructorMarker) null));
            String occupation = likesYouCardEntity.getOccupation();
            if (occupation != null) {
                p10.add(new l(Integer.valueOf(q0.icon_work), occupation, 0, 4, (DefaultConstructorMarker) null));
            }
            String education = likesYouCardEntity.getEducation();
            if (education != null) {
                p10.add(new l(Integer.valueOf(q0.icon_school), education, 0, 4, (DefaultConstructorMarker) null));
            }
            List x02 = CollectionsKt___CollectionsKt.x0(p10);
            if (z11) {
                List p11 = q.p(new l(Integer.valueOf(q0.ic_star), str, 0, 4, (DefaultConstructorMarker) null));
                String pairLikeComment = likesYouCardEntity.getPairLikeComment();
                if (pairLikeComment != null) {
                    p11.add(new l((Integer) null, "\"" + pairLikeComment + "\"", 2));
                }
                p11.addAll(x02);
                x02 = CollectionsKt___CollectionsKt.x0(p11);
            }
            List list = x02;
            String imageUrl = likesYouCardEntity.getImageUrl();
            if (imageUrl == null) {
                str2 = "";
            } else {
                str2 = imageUrl;
            }
            String bagelId = likesYouCardEntity.getBagelId();
            String profileId = likesYouCardEntity.getProfileId();
            Integer valueOf = Integer.valueOf(likesYouCardEntity.getAge());
            String city = likesYouCardEntity.getCity();
            if (city == null) {
                str3 = "";
            } else {
                str3 = city;
            }
            return new c(str2, bagelId, profileId, valueOf, str3, list, likesYouCardEntity.getPurchaseAttribution(), "", z10, (ViewType) null, 512, (DefaultConstructorMarker) null);
        }

        public final d b(LikesYouPaywallCard likesYouPaywallCard) {
            j.g(likesYouPaywallCard, "card");
            return new d(likesYouPaywallCard.getImageUrl(), likesYouPaywallCard.getProfileId(), PurchaseAttribution.purchaseAttributionFromInteger(likesYouPaywallCard.getPurchaseAttribution()), (ViewType) null, 8, (DefaultConstructorMarker) null);
        }
    }

    private LikesYouGridUiItem(ViewType viewType) {
        this.f34265a = viewType;
    }

    public /* synthetic */ LikesYouGridUiItem(ViewType viewType, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewType);
    }

    public ViewType a() {
        return this.f34265a;
    }

    public static final class b extends LikesYouGridUiItem {

        /* renamed from: c  reason: collision with root package name */
        private final ViewType f34270c;

        public b() {
            this((ViewType) null, 1, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(ViewType viewType, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? ViewType.EDIT_PREFS_CARD : viewType);
        }

        public ViewType a() {
            return this.f34270c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && a() == ((b) obj).a();
        }

        public int hashCode() {
            return a().hashCode();
        }

        public String toString() {
            ViewType a10 = a();
            return "EditPrefsCard(viewType=" + a10 + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ViewType viewType) {
            super(viewType, (DefaultConstructorMarker) null);
            j.g(viewType, "viewType");
            this.f34270c = viewType;
        }
    }

    public static final class d extends LikesYouGridUiItem {

        /* renamed from: c  reason: collision with root package name */
        private final String f34282c;

        /* renamed from: d  reason: collision with root package name */
        private final String f34283d;

        /* renamed from: e  reason: collision with root package name */
        private final PurchaseAttribution f34284e;

        /* renamed from: f  reason: collision with root package name */
        private final ViewType f34285f;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ d(String str, String str2, PurchaseAttribution purchaseAttribution, ViewType viewType, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i10 & 4) != 0 ? null : purchaseAttribution, (i10 & 8) != 0 ? ViewType.CARD : viewType);
        }

        public ViewType a() {
            return this.f34285f;
        }

        public final String b() {
            return this.f34282c;
        }

        public final String c() {
            return this.f34283d;
        }

        public final PurchaseAttribution d() {
            return this.f34284e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return j.b(this.f34282c, dVar.f34282c) && j.b(this.f34283d, dVar.f34283d) && this.f34284e == dVar.f34284e && a() == dVar.a();
        }

        public int hashCode() {
            int hashCode = ((this.f34282c.hashCode() * 31) + this.f34283d.hashCode()) * 31;
            PurchaseAttribution purchaseAttribution = this.f34284e;
            return ((hashCode + (purchaseAttribution == null ? 0 : purchaseAttribution.hashCode())) * 31) + a().hashCode();
        }

        public String toString() {
            String str = this.f34282c;
            String str2 = this.f34283d;
            PurchaseAttribution purchaseAttribution = this.f34284e;
            ViewType a10 = a();
            return "PaywallCard(imageUrl=" + str + ", profileId=" + str2 + ", purchaseAttribution=" + purchaseAttribution + ", viewType=" + a10 + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str, String str2, PurchaseAttribution purchaseAttribution, ViewType viewType) {
            super(viewType, (DefaultConstructorMarker) null);
            j.g(str, "imageUrl");
            j.g(str2, "profileId");
            j.g(viewType, "viewType");
            this.f34282c = str;
            this.f34283d = str2;
            this.f34284e = purchaseAttribution;
            this.f34285f = viewType;
        }
    }

    public static final class e extends LikesYouGridUiItem {

        /* renamed from: c  reason: collision with root package name */
        private final ViewType f34286c;

        /* renamed from: d  reason: collision with root package name */
        private final String f34287d;

        /* renamed from: e  reason: collision with root package name */
        private final int f34288e;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ e(ViewType viewType, String str, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? ViewType.UPSELL_CARD : viewType, str, i10);
        }

        public ViewType a() {
            return this.f34286c;
        }

        public final int b() {
            return this.f34288e;
        }

        public final String c() {
            return this.f34287d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return a() == eVar.a() && j.b(this.f34287d, eVar.f34287d) && this.f34288e == eVar.f34288e;
        }

        public int hashCode() {
            return (((a().hashCode() * 31) + this.f34287d.hashCode()) * 31) + Integer.hashCode(this.f34288e);
        }

        public String toString() {
            ViewType a10 = a();
            String str = this.f34287d;
            int i10 = this.f34288e;
            return "UpsellCard(viewType=" + a10 + ", text=" + str + ", icon=" + i10 + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ViewType viewType, String str, int i10) {
            super(viewType, (DefaultConstructorMarker) null);
            j.g(viewType, "viewType");
            j.g(str, "text");
            this.f34286c = viewType;
            this.f34287d = str;
            this.f34288e = i10;
        }
    }

    public static final class c extends LikesYouGridUiItem {

        /* renamed from: m  reason: collision with root package name */
        public static final a f34271m = new a((DefaultConstructorMarker) null);

        /* renamed from: c  reason: collision with root package name */
        private final String f34272c;

        /* renamed from: d  reason: collision with root package name */
        private final String f34273d;

        /* renamed from: e  reason: collision with root package name */
        private final String f34274e;

        /* renamed from: f  reason: collision with root package name */
        private final Integer f34275f;

        /* renamed from: g  reason: collision with root package name */
        private final String f34276g;

        /* renamed from: h  reason: collision with root package name */
        private final List<l> f34277h;

        /* renamed from: i  reason: collision with root package name */
        private final PurchaseAttribution f34278i;

        /* renamed from: j  reason: collision with root package name */
        private final String f34279j;

        /* renamed from: k  reason: collision with root package name */
        private final boolean f34280k;

        /* renamed from: l  reason: collision with root package name */
        private final ViewType f34281l;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ c(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Integer r17, java.lang.String r18, java.util.List r19, com.coffeemeetsbagel.models.enums.PurchaseAttribution r20, java.lang.String r21, boolean r22, com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem.ViewType r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
            /*
                r13 = this;
                r0 = r24
                r1 = r0 & 32
                if (r1 == 0) goto L_0x000c
                java.util.List r1 = kotlin.collections.q.j()
                r8 = r1
                goto L_0x000e
            L_0x000c:
                r8 = r19
            L_0x000e:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x0015
                r1 = 0
                r9 = r1
                goto L_0x0017
            L_0x0015:
                r9 = r20
            L_0x0017:
                r1 = r0 & 256(0x100, float:3.59E-43)
                if (r1 == 0) goto L_0x001e
                r1 = 1
                r11 = r1
                goto L_0x0020
            L_0x001e:
                r11 = r22
            L_0x0020:
                r0 = r0 & 512(0x200, float:7.175E-43)
                if (r0 == 0) goto L_0x0028
                com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem$ViewType r0 = com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem.ViewType.CARD
                r12 = r0
                goto L_0x002a
            L_0x0028:
                r12 = r23
            L_0x002a:
                r2 = r13
                r3 = r14
                r4 = r15
                r5 = r16
                r6 = r17
                r7 = r18
                r10 = r21
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem.c.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.util.List, com.coffeemeetsbagel.models.enums.PurchaseAttribution, java.lang.String, boolean, com.coffeemeetsbagel.likes_you.presentation.LikesYouGridUiItem$ViewType, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public ViewType a() {
            return this.f34281l;
        }

        public final String b() {
            return this.f34272c;
        }

        public final String c() {
            return this.f34273d;
        }

        public final String d() {
            return this.f34279j;
        }

        public final List<l> e() {
            return this.f34277h;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return j.b(this.f34272c, cVar.f34272c) && j.b(this.f34273d, cVar.f34273d) && j.b(this.f34274e, cVar.f34274e) && j.b(this.f34275f, cVar.f34275f) && j.b(this.f34276g, cVar.f34276g) && j.b(this.f34277h, cVar.f34277h) && this.f34278i == cVar.f34278i && j.b(this.f34279j, cVar.f34279j) && this.f34280k == cVar.f34280k && a() == cVar.a();
        }

        public final String f() {
            return this.f34274e;
        }

        public final PurchaseAttribution g() {
            return this.f34278i;
        }

        public final boolean h() {
            return this.f34280k;
        }

        public int hashCode() {
            int hashCode = ((((this.f34272c.hashCode() * 31) + this.f34273d.hashCode()) * 31) + this.f34274e.hashCode()) * 31;
            Integer num = this.f34275f;
            int i10 = 0;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.f34276g;
            int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.f34277h.hashCode()) * 31;
            PurchaseAttribution purchaseAttribution = this.f34278i;
            if (purchaseAttribution != null) {
                i10 = purchaseAttribution.hashCode();
            }
            int hashCode4 = (((hashCode3 + i10) * 31) + this.f34279j.hashCode()) * 31;
            boolean z10 = this.f34280k;
            if (z10) {
                z10 = true;
            }
            return ((hashCode4 + (z10 ? 1 : 0)) * 31) + a().hashCode();
        }

        public String toString() {
            String str = this.f34272c;
            String str2 = this.f34273d;
            String str3 = this.f34274e;
            Integer num = this.f34275f;
            String str4 = this.f34276g;
            List<l> list = this.f34277h;
            PurchaseAttribution purchaseAttribution = this.f34278i;
            String str5 = this.f34279j;
            boolean z10 = this.f34280k;
            ViewType a10 = a();
            return "FreeMatch(imageUrl=" + str + ", matchId=" + str2 + ", profileId=" + str3 + ", age=" + num + ", location=" + str4 + ", metaItems=" + list + ", purchaseAttribution=" + purchaseAttribution + ", matchToMe=" + str5 + ", isBlurred=" + z10 + ", viewType=" + a10 + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, String str3, Integer num, String str4, List<l> list, PurchaseAttribution purchaseAttribution, String str5, boolean z10, ViewType viewType) {
            super(viewType, (DefaultConstructorMarker) null);
            j.g(str, "imageUrl");
            j.g(str2, "matchId");
            j.g(str3, "profileId");
            j.g(list, "metaItems");
            j.g(str5, "matchToMe");
            j.g(viewType, "viewType");
            this.f34272c = str;
            this.f34273d = str2;
            this.f34274e = str3;
            this.f34275f = num;
            this.f34276g = str4;
            this.f34277h = list;
            this.f34278i = purchaseAttribution;
            this.f34279j = str5;
            this.f34280k = z10;
            this.f34281l = viewType;
        }
    }
}

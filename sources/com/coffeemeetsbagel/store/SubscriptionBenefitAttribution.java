package com.coffeemeetsbagel.store;

import com.coffeemeetsbagel.models.ModelDeeplinkData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

public enum SubscriptionBenefitAttribution {
    LIKES_YOU("limelight"),
    ACTIVITY_REPORT("activity_report"),
    DISCOVER_TAKES("discover_takes"),
    READ_RECEIPT("read_receipt"),
    PREMIUM_PREFERENCES("premium_preferences"),
    SHOP("shop"),
    BOOST(ModelDeeplinkData.VALUE_PAGE_BOOST),
    UNLIMITED_REWINDS("unlimited_rewinds"),
    SKIP_THE_LINE("skip_the_line"),
    PAID_LIKE("paid_likes"),
    SUGGESTED_LIKES("suggested_likes"),
    UNLIMITED_SUGGESTED_VIEWS("suggested_views"),
    DEFAULT("");
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f36723a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, SubscriptionBenefitAttribution> f36724b = null;
    private final String benefitDeepLinkTag;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
            if (r0.equals("suggested_rewind") == false) goto L_0x011c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
            if (r0.equals("limelight subscription card") == false) goto L_0x011c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x006e, code lost:
            if (r0.equals("just my type tab") == false) goto L_0x011c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x009f, code lost:
            if (r0.equals("likes_you_upsell") == false) goto L_0x011c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b4, code lost:
            if (r0.equals("suggested history") == false) goto L_0x011c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b9, code lost:
            return com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.f36732k;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c0, code lost:
            if (r0.equals("Limelight Grid") == false) goto L_0x011c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00c9, code lost:
            if (r0.equals("limelight tab") == false) goto L_0x011c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00de, code lost:
            if (r0.equals("limelight not subscribed") == false) goto L_0x011c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e3, code lost:
            return com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.f36725c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0130, code lost:
            if (r4.equals("limelight subscription banner") == false) goto L_0x0161;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0139, code lost:
            if (r4.equals("likes you") == false) goto L_0x0161;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x013e, code lost:
            return com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.f36725c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
            if (r0.equals("limelight not subscribed with likes") == false) goto L_0x011c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.coffeemeetsbagel.store.SubscriptionBenefitAttribution a(com.coffeemeetsbagel.store.PurchaseSource r4) {
            /*
                r3 = this;
                java.lang.String r0 = "source"
                kotlin.jvm.internal.j.g(r4, r0)
                java.lang.String r0 = r4.a()
                java.lang.String r1 = "suggested history"
                if (r0 == 0) goto L_0x011c
                int r2 = r0.hashCode()
                switch(r2) {
                    case -2038704466: goto L_0x00f0;
                    case -1770711766: goto L_0x00e4;
                    case -1490452634: goto L_0x00d8;
                    case -1271629221: goto L_0x00cc;
                    case -1237035690: goto L_0x00c3;
                    case -696717851: goto L_0x00ba;
                    case -524855145: goto L_0x00b0;
                    case -494046802: goto L_0x00a3;
                    case -446966544: goto L_0x0099;
                    case 93922211: goto L_0x008c;
                    case 343422916: goto L_0x007f;
                    case 556927845: goto L_0x0072;
                    case 874496111: goto L_0x0068;
                    case 1165704350: goto L_0x005b;
                    case 1283475838: goto L_0x004e;
                    case 1378626612: goto L_0x0044;
                    case 1452310871: goto L_0x003a;
                    case 1522244126: goto L_0x002d;
                    case 1847802076: goto L_0x0023;
                    case 1917538418: goto L_0x0016;
                    default: goto L_0x0014;
                }
            L_0x0014:
                goto L_0x011c
            L_0x0016:
                java.lang.String r2 = "premium suggested preferences"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x0020
                goto L_0x011c
            L_0x0020:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.PREMIUM_PREFERENCES
                return r4
            L_0x0023:
                java.lang.String r2 = "limelight not subscribed with likes"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x00e1
                goto L_0x011c
            L_0x002d:
                java.lang.String r2 = "boost report modal"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x0037
                goto L_0x011c
            L_0x0037:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.BOOST
                return r4
            L_0x003a:
                java.lang.String r2 = "suggested_rewind"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x00b7
                goto L_0x011c
            L_0x0044:
                java.lang.String r2 = "limelight subscription card"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x00e1
                goto L_0x011c
            L_0x004e:
                java.lang.String r2 = "suggested out of bagels"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x0058
                goto L_0x011c
            L_0x0058:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.UNLIMITED_SUGGESTED_VIEWS
                return r4
            L_0x005b:
                java.lang.String r2 = "profile take"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x0065
                goto L_0x011c
            L_0x0065:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.DISCOVER_TAKES
                return r4
            L_0x0068:
                java.lang.String r2 = "just my type tab"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x00e1
                goto L_0x011c
            L_0x0072:
                java.lang.String r2 = "activity report"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x007c
                goto L_0x011c
            L_0x007c:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.ACTIVITY_REPORT
                return r4
            L_0x007f:
                java.lang.String r2 = "skip the line"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x0089
                goto L_0x011c
            L_0x0089:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.SKIP_THE_LINE
                return r4
            L_0x008c:
                java.lang.String r2 = "boost"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x0096
                goto L_0x011c
            L_0x0096:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.BOOST
                return r4
            L_0x0099:
                java.lang.String r2 = "likes_you_upsell"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x00e1
                goto L_0x011c
            L_0x00a3:
                java.lang.String r2 = "read receipt"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x00ad
                goto L_0x011c
            L_0x00ad:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.READ_RECEIPT
                return r4
            L_0x00b0:
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L_0x00b7
                goto L_0x011c
            L_0x00b7:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.UNLIMITED_REWINDS
                return r4
            L_0x00ba:
                java.lang.String r2 = "Limelight Grid"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x00e1
                goto L_0x011c
            L_0x00c3:
                java.lang.String r2 = "limelight tab"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x00e1
                goto L_0x011c
            L_0x00cc:
                java.lang.String r2 = "flower"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x00d5
                goto L_0x011c
            L_0x00d5:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.PAID_LIKE
                return r4
            L_0x00d8:
                java.lang.String r2 = "limelight not subscribed"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x00e1
                goto L_0x011c
            L_0x00e1:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.LIKES_YOU
                return r4
            L_0x00e4:
                java.lang.String r2 = "suggested limits empty screen"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x00ed
                goto L_0x011c
            L_0x00ed:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.SUGGESTED_LIKES
                return r4
            L_0x00f0:
                java.lang.String r2 = "deep link"
                boolean r0 = r0.equals(r2)
                if (r0 != 0) goto L_0x00f9
                goto L_0x011c
            L_0x00f9:
                java.util.Map r0 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.f36724b
                java.lang.String r1 = r4.c()
                boolean r0 = r0.containsKey(r1)
                if (r0 == 0) goto L_0x0119
                java.util.Map r0 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.f36724b
                java.lang.String r4 = r4.c()
                java.lang.Object r4 = r0.get(r4)
                kotlin.jvm.internal.j.d(r4)
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = (com.coffeemeetsbagel.store.SubscriptionBenefitAttribution) r4
                goto L_0x011b
            L_0x0119:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.DEFAULT
            L_0x011b:
                return r4
            L_0x011c:
                java.lang.String r4 = r4.c()
                if (r4 == 0) goto L_0x0161
                int r0 = r4.hashCode()
                switch(r0) {
                    case -1334247376: goto L_0x0155;
                    case -667925951: goto L_0x0149;
                    case -524855145: goto L_0x013f;
                    case -147626565: goto L_0x0133;
                    case 1981511504: goto L_0x012a;
                    default: goto L_0x0129;
                }
            L_0x0129:
                goto L_0x0161
            L_0x012a:
                java.lang.String r0 = "limelight subscription banner"
                boolean r4 = r4.equals(r0)
                if (r4 != 0) goto L_0x013c
                goto L_0x0161
            L_0x0133:
                java.lang.String r0 = "likes you"
                boolean r4 = r4.equals(r0)
                if (r4 != 0) goto L_0x013c
                goto L_0x0161
            L_0x013c:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.LIKES_YOU
                return r4
            L_0x013f:
                boolean r4 = r4.equals(r1)
                if (r4 != 0) goto L_0x0146
                goto L_0x0161
            L_0x0146:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.UNLIMITED_REWINDS
                return r4
            L_0x0149:
                java.lang.String r0 = "Limelight"
                boolean r4 = r4.equals(r0)
                if (r4 != 0) goto L_0x0152
                goto L_0x0161
            L_0x0152:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.LIKES_YOU
                return r4
            L_0x0155:
                java.lang.String r0 = "Give & Take"
                boolean r4 = r4.equals(r0)
                if (r4 != 0) goto L_0x015e
                goto L_0x0161
            L_0x015e:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.DISCOVER_TAKES
                return r4
            L_0x0161:
                com.coffeemeetsbagel.store.SubscriptionBenefitAttribution r4 = com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.DEFAULT
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.store.SubscriptionBenefitAttribution.a.a(com.coffeemeetsbagel.store.PurchaseSource):com.coffeemeetsbagel.store.SubscriptionBenefitAttribution");
        }
    }

    static {
        int i10;
        f36723a = new a((DefaultConstructorMarker) null);
        SubscriptionBenefitAttribution[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (SubscriptionBenefitAttribution subscriptionBenefitAttribution : values) {
            linkedHashMap.put(subscriptionBenefitAttribution.benefitDeepLinkTag, subscriptionBenefitAttribution);
        }
        f36724b = linkedHashMap;
    }

    private SubscriptionBenefitAttribution(String str) {
        this.benefitDeepLinkTag = str;
    }

    public final String c() {
        return this.benefitDeepLinkTag;
    }
}

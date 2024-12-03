package com.mparticle.kits;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.mparticle.BaseEvent;
import com.mparticle.MParticle;
import com.mparticle.identity.MParticleIdentityClientImpl;
import com.mparticle.internal.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;
import org.json.a;
import org.json.b;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0003\u001f !B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BM\u0012&\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\t0\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0015H\u0016J#\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\b\b\u0000\u0010\u0017*\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u0001H\u0017H\u0016¢\u0006\u0002\u0010\u001aJ0\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00062\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006H\u0016J2\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u0017\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00172\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u0017\u0018\u00010\u0006H\u0016R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R1\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lcom/mparticle/kits/DataplanFilterImpl;", "Lcom/mparticle/kits/DataplanFilter;", "dataplanOptions", "Lcom/mparticle/MParticleOptions$DataplanOptions;", "(Lcom/mparticle/MParticleOptions$DataplanOptions;)V", "dataPoints", "", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "blockEvents", "", "blockEventAttributes", "blockUserAttributes", "blockUserIdentities", "(Ljava/util/Map;ZZZZ)V", "getDataPoints", "()Ljava/util/Map;", "isUserAttributeBlocked", "key", "isUserIdentityBlocked", "Lcom/mparticle/MParticle$IdentityType;", "transformEventForEvent", "T", "Lcom/mparticle/BaseEvent;", "event", "(Lcom/mparticle/BaseEvent;)Lcom/mparticle/BaseEvent;", "transformIdentities", "identities", "transformUserAttributes", "attributes", "Companion", "DataPoint", "EmptyDataplanFilter", "android-kit-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DataplanFilterImpl implements DataplanFilter {
    public static final String CUSTOM_EVENT_KEY = "custom_event";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final DataplanFilter EMPTY = new EmptyDataplanFilter();
    public static final String PRODUCT_ACTION_KEY = "product_action";
    public static final String PRODUCT_ACTION_PRODUCTS = "product_action_product";
    public static final String PRODUCT_IMPRESSION_KEY = "product_impression";
    public static final String PRODUCT_IMPRESSION_PRODUCTS = "product_impression_product";
    public static final String PROMOTION_ACTION_KEY = "promotion_action";
    public static final String SCREEN_EVENT_KEY = "screen_view";
    public static final String USER_ATTRIBUTES_KEY = "user_attributes";
    public static final String USER_IDENTITIES_KEY = "user_identities";
    /* access modifiers changed from: private */
    public static final b emptyJSONObject = new b();
    private final boolean blockEventAttributes;
    private final boolean blockEvents;
    private final boolean blockUserAttributes;
    private final boolean blockUserIdentities;
    private final Map<String, HashSet<String>> dataPoints;

    @Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b*\u0010+J,\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\f\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b0\u000b2\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0010*\u00020\u000fJ\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0004*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0007J\u001e\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b*\u00020\u0004J\n\u0010\u0016\u001a\u00020\u0007*\u00020\u0015J\n\u0010\u0016\u001a\u00020\u0007*\u00020\u0017J&\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0006j\b\u0012\u0004\u0012\u00028\u0000`\b\"\u0004\b\u0000\u0010\u0018*\b\u0012\u0004\u0012\u00028\u00000\u0019R\u0014\u0010\u001b\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b \u0010\u001cR\u0014\u0010!\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b!\u0010\u001cR\u0014\u0010\"\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0014\u0010#\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b#\u0010\u001cR\u0014\u0010$\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b$\u0010\u001cR\u0014\u0010%\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b%\u0010\u001cR\u0014\u0010&\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b&\u0010\u001cR\u0014\u0010'\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b'\u0010\u001cR\u0014\u0010(\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/mparticle/kits/DataplanFilterImpl$Companion;", "", "Lcom/mparticle/kits/DataplanFilterImpl$DataPoint;", "datapoint", "Lorg/json/b;", "jsonObject", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getAllowedKeys", "dataplan", "", "extractDataPoints", "match", "generateDatapointKey", "Lorg/json/a;", "", "toList", "constraintField", "getConstrainedPropertiesJSONObject", "getConstrainedPropertiesKeySet", "Lcom/mparticle/MParticle$IdentityType;", "getEventsApiName", "Lcom/mparticle/MParticle$EventType;", "T", "", "toHashSet", "CUSTOM_EVENT_KEY", "Ljava/lang/String;", "Lcom/mparticle/kits/DataplanFilter;", "EMPTY", "Lcom/mparticle/kits/DataplanFilter;", "PRODUCT_ACTION_KEY", "PRODUCT_ACTION_PRODUCTS", "PRODUCT_IMPRESSION_KEY", "PRODUCT_IMPRESSION_PRODUCTS", "PROMOTION_ACTION_KEY", "SCREEN_EVENT_KEY", "USER_ATTRIBUTES_KEY", "USER_IDENTITIES_KEY", "emptyJSONObject", "Lorg/json/b;", "<init>", "()V", "android-kit-base_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(2:17|18)|19|21) */
            /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|21) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
            /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    com.mparticle.MParticle$EventType[] r0 = com.mparticle.MParticle.EventType.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.mparticle.MParticle$EventType r1 = com.mparticle.MParticle.EventType.Location     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.mparticle.MParticle$EventType r1 = com.mparticle.MParticle.EventType.Media     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    com.mparticle.MParticle$EventType r1 = com.mparticle.MParticle.EventType.Navigation     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    com.mparticle.MParticle$EventType r1 = com.mparticle.MParticle.EventType.Other     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    com.mparticle.MParticle$EventType r1 = com.mparticle.MParticle.EventType.Search     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    com.mparticle.MParticle$EventType r1 = com.mparticle.MParticle.EventType.Social     // Catch:{ NoSuchFieldError -> 0x003d }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                    r2 = 6
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
                L_0x003d:
                    com.mparticle.MParticle$EventType r1 = com.mparticle.MParticle.EventType.Transaction     // Catch:{ NoSuchFieldError -> 0x0046 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                    r2 = 7
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
                L_0x0046:
                    com.mparticle.MParticle$EventType r1 = com.mparticle.MParticle.EventType.UserContent     // Catch:{ NoSuchFieldError -> 0x0050 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                    r2 = 8
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
                L_0x0050:
                    com.mparticle.MParticle$EventType r1 = com.mparticle.MParticle.EventType.UserPreference     // Catch:{ NoSuchFieldError -> 0x005a }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                    r2 = 9
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
                L_0x005a:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mparticle.kits.DataplanFilterImpl.Companion.WhenMappings.<clinit>():void");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
            if (r1.equals(com.mparticle.kits.DataplanFilterImpl.PRODUCT_IMPRESSION_KEY) == false) goto L_0x00fb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
            if (r1.equals("screen_view") == false) goto L_0x00fb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
            if (r1.equals(com.mparticle.kits.DataplanFilterImpl.PRODUCT_ACTION_KEY) == false) goto L_0x00fb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
            if (r8 == null) goto L_0x0060;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
            r8 = r8.optJSONObject(org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension.ELEMENT);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0057, code lost:
            if (r8 == null) goto L_0x0060;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
            r8 = r8.optJSONObject("data");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0060, code lost:
            r8 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0061, code lost:
            if (r8 != null) goto L_0x0064;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x006a, code lost:
            if (r7.getProductAttributeType() != null) goto L_0x007a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
            r7 = com.mparticle.kits.DataplanFilterImpl.Companion;
            r8 = r7.getConstrainedPropertiesJSONObject(r8, "custom_attributes");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0072, code lost:
            if (r8 != null) goto L_0x0075;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0074, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0079, code lost:
            return r7.getConstrainedPropertiesKeySet(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x007a, code lost:
            r7 = r7.getProductAttributeType();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0088, code lost:
            if (kotlin.jvm.internal.j.b(r7, com.mparticle.kits.DataplanFilterImpl.PRODUCT_ACTION_PRODUCTS) == false) goto L_0x00a8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x008a, code lost:
            r7 = com.mparticle.kits.DataplanFilterImpl.Companion;
            r8 = r7.getConstrainedPropertiesJSONObject(r8, com.mparticle.kits.DataplanFilterImpl.PRODUCT_ACTION_KEY);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0090, code lost:
            if (r8 == null) goto L_0x0097;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0092, code lost:
            r7 = r7.getConstrainedPropertiesJSONObject(r8, "products");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0097, code lost:
            r7 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a0, code lost:
            if (kotlin.jvm.internal.j.b(r7, com.mparticle.kits.DataplanFilterImpl.access$getEmptyJSONObject$cp()) == false) goto L_0x00e6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a7, code lost:
            return new java.util.HashSet<>();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ae, code lost:
            if (kotlin.jvm.internal.j.b(r7, com.mparticle.kits.DataplanFilterImpl.PRODUCT_IMPRESSION_PRODUCTS) == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b0, code lost:
            r7 = com.mparticle.kits.DataplanFilterImpl.Companion;
            r8 = r7.getConstrainedPropertiesJSONObject(r8, "product_impressions");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c0, code lost:
            if (kotlin.jvm.internal.j.b(r8, com.mparticle.kits.DataplanFilterImpl.access$getEmptyJSONObject$cp()) == false) goto L_0x00c8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c7, code lost:
            return new java.util.HashSet<>();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c8, code lost:
            if (r8 == null) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ca, code lost:
            r8 = r8.optJSONObject(com.google.firebase.analytics.FirebaseAnalytics.Param.ITEMS);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ce, code lost:
            if (r8 == null) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d0, code lost:
            r7 = r7.getConstrainedPropertiesJSONObject(r8, "products");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d5, code lost:
            r7 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00de, code lost:
            if (kotlin.jvm.internal.j.b(r7, com.mparticle.kits.DataplanFilterImpl.access$getEmptyJSONObject$cp()) == false) goto L_0x00e6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e5, code lost:
            return new java.util.HashSet<>();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e6, code lost:
            if (r7 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e8, code lost:
            r7 = r7.optJSONObject(com.google.firebase.analytics.FirebaseAnalytics.Param.ITEMS);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ec, code lost:
            if (r7 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00ee, code lost:
            r8 = com.mparticle.kits.DataplanFilterImpl.Companion;
            r7 = r8.getConstrainedPropertiesJSONObject(r7, "custom_attributes");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f4, code lost:
            if (r7 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00fb, code lost:
            if (r8 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
            return r8.getConstrainedPropertiesKeySet(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            return getConstrainedPropertiesKeySet(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
            if (r1.equals(com.mparticle.kits.DataplanFilterImpl.PROMOTION_ACTION_KEY) != false) goto L_0x004f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
            if (r1.equals(com.mparticle.kits.DataplanFilterImpl.CUSTOM_EVENT_KEY) == false) goto L_0x00fb;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final java.util.HashSet<java.lang.String> getAllowedKeys(com.mparticle.kits.DataplanFilterImpl.DataPoint r7, org.json.b r8) {
            /*
                r6 = this;
                java.lang.String r0 = "validator"
                org.json.b r8 = r8.optJSONObject(r0)
                r0 = 0
                if (r8 == 0) goto L_0x0010
                java.lang.String r1 = "definition"
                org.json.b r8 = r8.optJSONObject(r1)
                goto L_0x0011
            L_0x0010:
                r8 = r0
            L_0x0011:
                java.lang.String r1 = r7.getType()
                int r2 = r1.hashCode()
                java.lang.String r3 = "product_action"
                switch(r2) {
                    case -512945274: goto L_0x0047;
                    case -43018600: goto L_0x003d;
                    case 251854681: goto L_0x0033;
                    case 717572172: goto L_0x0029;
                    case 1766756690: goto L_0x0020;
                    default: goto L_0x001e;
                }
            L_0x001e:
                goto L_0x00fb
            L_0x0020:
                java.lang.String r2 = "promotion_action"
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x00fb
                goto L_0x004f
            L_0x0029:
                java.lang.String r2 = "custom_event"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x004f
                goto L_0x00fb
            L_0x0033:
                java.lang.String r2 = "product_impression"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x004f
                goto L_0x00fb
            L_0x003d:
                java.lang.String r2 = "screen_view"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x004f
                goto L_0x00fb
            L_0x0047:
                boolean r1 = r1.equals(r3)
                if (r1 != 0) goto L_0x004f
                goto L_0x00fb
            L_0x004f:
                if (r8 == 0) goto L_0x0060
                java.lang.String r1 = "properties"
                org.json.b r8 = r8.optJSONObject(r1)
                if (r8 == 0) goto L_0x0060
                java.lang.String r1 = "data"
                org.json.b r8 = r8.optJSONObject(r1)
                goto L_0x0061
            L_0x0060:
                r8 = r0
            L_0x0061:
                if (r8 != 0) goto L_0x0064
                return r0
            L_0x0064:
                java.lang.String r1 = r7.getProductAttributeType()
                java.lang.String r2 = "custom_attributes"
                if (r1 != 0) goto L_0x007a
                com.mparticle.kits.DataplanFilterImpl$Companion r7 = com.mparticle.kits.DataplanFilterImpl.Companion
                org.json.b r8 = r7.getConstrainedPropertiesJSONObject(r8, r2)
                if (r8 != 0) goto L_0x0075
                return r0
            L_0x0075:
                java.util.HashSet r7 = r7.getConstrainedPropertiesKeySet(r8)
                return r7
            L_0x007a:
                java.lang.String r7 = r7.getProductAttributeType()
                java.lang.String r1 = "product_action_product"
                boolean r1 = kotlin.jvm.internal.j.b(r7, r1)
                java.lang.String r4 = "items"
                java.lang.String r5 = "products"
                if (r1 == 0) goto L_0x00a8
                com.mparticle.kits.DataplanFilterImpl$Companion r7 = com.mparticle.kits.DataplanFilterImpl.Companion
                org.json.b r8 = r7.getConstrainedPropertiesJSONObject(r8, r3)
                if (r8 == 0) goto L_0x0097
                org.json.b r7 = r7.getConstrainedPropertiesJSONObject(r8, r5)
                goto L_0x0098
            L_0x0097:
                r7 = r0
            L_0x0098:
                org.json.b r8 = com.mparticle.kits.DataplanFilterImpl.emptyJSONObject
                boolean r8 = kotlin.jvm.internal.j.b(r7, r8)
                if (r8 == 0) goto L_0x00e6
                java.util.HashSet r7 = new java.util.HashSet
                r7.<init>()
                return r7
            L_0x00a8:
                java.lang.String r1 = "product_impression_product"
                boolean r7 = kotlin.jvm.internal.j.b(r7, r1)
                if (r7 == 0) goto L_0x00fa
                com.mparticle.kits.DataplanFilterImpl$Companion r7 = com.mparticle.kits.DataplanFilterImpl.Companion
                java.lang.String r1 = "product_impressions"
                org.json.b r8 = r7.getConstrainedPropertiesJSONObject(r8, r1)
                org.json.b r1 = com.mparticle.kits.DataplanFilterImpl.emptyJSONObject
                boolean r1 = kotlin.jvm.internal.j.b(r8, r1)
                if (r1 == 0) goto L_0x00c8
                java.util.HashSet r7 = new java.util.HashSet
                r7.<init>()
                return r7
            L_0x00c8:
                if (r8 == 0) goto L_0x00d5
                org.json.b r8 = r8.optJSONObject(r4)
                if (r8 == 0) goto L_0x00d5
                org.json.b r7 = r7.getConstrainedPropertiesJSONObject(r8, r5)
                goto L_0x00d6
            L_0x00d5:
                r7 = r0
            L_0x00d6:
                org.json.b r8 = com.mparticle.kits.DataplanFilterImpl.emptyJSONObject
                boolean r8 = kotlin.jvm.internal.j.b(r7, r8)
                if (r8 == 0) goto L_0x00e6
                java.util.HashSet r7 = new java.util.HashSet
                r7.<init>()
                return r7
            L_0x00e6:
                if (r7 == 0) goto L_0x00fa
                org.json.b r7 = r7.optJSONObject(r4)
                if (r7 == 0) goto L_0x00fa
                com.mparticle.kits.DataplanFilterImpl$Companion r8 = com.mparticle.kits.DataplanFilterImpl.Companion
                org.json.b r7 = r8.getConstrainedPropertiesJSONObject(r7, r2)
                if (r7 == 0) goto L_0x00fa
                java.util.HashSet r0 = r8.getConstrainedPropertiesKeySet(r7)
            L_0x00fa:
                return r0
            L_0x00fb:
                if (r8 == 0) goto L_0x0101
                java.util.HashSet r0 = r6.getConstrainedPropertiesKeySet(r8)
            L_0x0101:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mparticle.kits.DataplanFilterImpl.Companion.getAllowedKeys(com.mparticle.kits.DataplanFilterImpl$DataPoint, org.json.b):java.util.HashSet");
        }

        public final Map<String, HashSet<String>> extractDataPoints(b bVar) {
            a optJSONArray;
            List<Object> list;
            j.g(bVar, "dataplan");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            b optJSONObject = bVar.optJSONObject("version_document");
            if (!(optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("data_points")) == null || (list = toList(optJSONArray)) == null)) {
                ArrayList<b> arrayList = new ArrayList<>();
                for (T next : list) {
                    if (next instanceof b) {
                        arrayList.add(next);
                    }
                }
                for (b bVar2 : arrayList) {
                    b jSONObject = bVar2.getJSONObject("match");
                    Companion companion = DataplanFilterImpl.Companion;
                    j.f(jSONObject, "match");
                    DataPoint generateDatapointKey = companion.generateDatapointKey(jSONObject);
                    if (generateDatapointKey != null) {
                        linkedHashMap.put(generateDatapointKey.toString(), companion.getAllowedKeys(generateDatapointKey, bVar2));
                        List<DataPoint> productDataPoints = generateDatapointKey.getProductDataPoints();
                        if (productDataPoints != null) {
                            for (DataPoint dataPoint : productDataPoints) {
                                linkedHashMap.put(dataPoint.toString(), DataplanFilterImpl.Companion.getAllowedKeys(dataPoint, bVar2));
                            }
                        }
                    }
                }
            }
            return linkedHashMap;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b5, code lost:
            kotlin.jvm.internal.j.f(r3, "matchType");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c2, code lost:
            return new com.mparticle.kits.DataplanFilterImpl.DataPoint(r3, (java.lang.String) null, (java.lang.String) null, 6, (kotlin.jvm.internal.DefaultConstructorMarker) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00cc, code lost:
            if (r0 == null) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ce, code lost:
            r0 = r0.optString("action");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d5, code lost:
            r0 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00dc, code lost:
            if (kotlin.jvm.internal.j.b(r0, "remove_from_wish_list") == false) goto L_0x00e0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00de, code lost:
            r0 = com.mparticle.commerce.Product.REMOVE_FROM_WISHLIST;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e0, code lost:
            if (r0 == null) goto L_0x00e8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e6, code lost:
            if (kotlin.text.r.w(r0) == false) goto L_0x00e9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e8, code lost:
            r2 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e9, code lost:
            if (r2 != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00eb, code lost:
            kotlin.jvm.internal.j.f(r3, "matchType");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            return new com.mparticle.kits.DataplanFilterImpl.DataPoint(r3, r0, (java.lang.String) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.mparticle.kits.DataplanFilterImpl.DataPoint generateDatapointKey(org.json.b r9) {
            /*
                r8 = this;
                java.lang.String r0 = "match"
                kotlin.jvm.internal.j.g(r9, r0)
                java.lang.String r0 = "criteria"
                org.json.b r0 = r9.optJSONObject(r0)
                java.lang.String r1 = "type"
                java.lang.String r3 = r9.optString(r1)
                r9 = 0
                if (r3 == 0) goto L_0x00f8
                int r1 = r3.hashCode()
                r2 = 0
                r4 = 1
                java.lang.String r5 = "matchType"
                switch(r1) {
                    case -512945274: goto L_0x00c3;
                    case -282872112: goto L_0x00ac;
                    case -43018600: goto L_0x007f;
                    case 251854681: goto L_0x0075;
                    case 717572172: goto L_0x0035;
                    case 1740789323: goto L_0x002b;
                    case 1766756690: goto L_0x0021;
                    default: goto L_0x001f;
                }
            L_0x001f:
                goto L_0x00f8
            L_0x0021:
                java.lang.String r1 = "promotion_action"
                boolean r1 = r3.equals(r1)
                if (r1 != 0) goto L_0x00cc
                goto L_0x00f8
            L_0x002b:
                java.lang.String r0 = "user_attributes"
                boolean r0 = r3.equals(r0)
                if (r0 != 0) goto L_0x00b5
                goto L_0x00f8
            L_0x0035:
                java.lang.String r1 = "custom_event"
                boolean r1 = r3.equals(r1)
                if (r1 != 0) goto L_0x003f
                goto L_0x00f8
            L_0x003f:
                if (r0 == 0) goto L_0x0048
                java.lang.String r1 = "event_name"
                java.lang.String r1 = r0.optString(r1)
                goto L_0x0049
            L_0x0048:
                r1 = r9
            L_0x0049:
                if (r0 == 0) goto L_0x0052
                java.lang.String r6 = "custom_event_type"
                java.lang.String r0 = r0.optString(r6)
                goto L_0x0053
            L_0x0052:
                r0 = r9
            L_0x0053:
                if (r1 == 0) goto L_0x005e
                boolean r6 = kotlin.text.r.w(r1)
                if (r6 == 0) goto L_0x005c
                goto L_0x005e
            L_0x005c:
                r6 = r2
                goto L_0x005f
            L_0x005e:
                r6 = r4
            L_0x005f:
                if (r6 != 0) goto L_0x00f8
                if (r0 == 0) goto L_0x0069
                boolean r6 = kotlin.text.r.w(r0)
                if (r6 == 0) goto L_0x006a
            L_0x0069:
                r2 = r4
            L_0x006a:
                if (r2 != 0) goto L_0x00f8
                com.mparticle.kits.DataplanFilterImpl$DataPoint r9 = new com.mparticle.kits.DataplanFilterImpl$DataPoint
                kotlin.jvm.internal.j.f(r3, r5)
                r9.<init>(r3, r1, r0)
                return r9
            L_0x0075:
                java.lang.String r0 = "product_impression"
                boolean r0 = r3.equals(r0)
                if (r0 != 0) goto L_0x00b5
                goto L_0x00f8
            L_0x007f:
                java.lang.String r1 = "screen_view"
                boolean r1 = r3.equals(r1)
                if (r1 != 0) goto L_0x0089
                goto L_0x00f8
            L_0x0089:
                if (r0 == 0) goto L_0x0092
                java.lang.String r1 = "screen_name"
                java.lang.String r0 = r0.optString(r1)
                goto L_0x0093
            L_0x0092:
                r0 = r9
            L_0x0093:
                if (r0 == 0) goto L_0x009b
                boolean r1 = kotlin.text.r.w(r0)
                if (r1 == 0) goto L_0x009c
            L_0x009b:
                r2 = r4
            L_0x009c:
                if (r2 != 0) goto L_0x00f8
                com.mparticle.kits.DataplanFilterImpl$DataPoint r9 = new com.mparticle.kits.DataplanFilterImpl$DataPoint
                kotlin.jvm.internal.j.f(r3, r5)
                r5 = 0
                r6 = 4
                r7 = 0
                r2 = r9
                r4 = r0
                r2.<init>(r3, r4, r5, r6, r7)
                return r9
            L_0x00ac:
                java.lang.String r0 = "user_identities"
                boolean r0 = r3.equals(r0)
                if (r0 != 0) goto L_0x00b5
                goto L_0x00f8
            L_0x00b5:
                com.mparticle.kits.DataplanFilterImpl$DataPoint r9 = new com.mparticle.kits.DataplanFilterImpl$DataPoint
                kotlin.jvm.internal.j.f(r3, r5)
                r4 = 0
                r5 = 0
                r6 = 6
                r7 = 0
                r2 = r9
                r2.<init>(r3, r4, r5, r6, r7)
                return r9
            L_0x00c3:
                java.lang.String r1 = "product_action"
                boolean r1 = r3.equals(r1)
                if (r1 != 0) goto L_0x00cc
                goto L_0x00f8
            L_0x00cc:
                if (r0 == 0) goto L_0x00d5
                java.lang.String r1 = "action"
                java.lang.String r0 = r0.optString(r1)
                goto L_0x00d6
            L_0x00d5:
                r0 = r9
            L_0x00d6:
                java.lang.String r1 = "remove_from_wish_list"
                boolean r1 = kotlin.jvm.internal.j.b(r0, r1)
                if (r1 == 0) goto L_0x00e0
                java.lang.String r0 = "remove_from_wishlist"
            L_0x00e0:
                if (r0 == 0) goto L_0x00e8
                boolean r1 = kotlin.text.r.w(r0)
                if (r1 == 0) goto L_0x00e9
            L_0x00e8:
                r2 = r4
            L_0x00e9:
                if (r2 != 0) goto L_0x00f8
                com.mparticle.kits.DataplanFilterImpl$DataPoint r9 = new com.mparticle.kits.DataplanFilterImpl$DataPoint
                kotlin.jvm.internal.j.f(r3, r5)
                r5 = 0
                r6 = 4
                r7 = 0
                r2 = r9
                r4 = r0
                r2.<init>(r3, r4, r5, r6, r7)
            L_0x00f8:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mparticle.kits.DataplanFilterImpl.Companion.generateDatapointKey(org.json.b):com.mparticle.kits.DataplanFilterImpl$DataPoint");
        }

        public final b getConstrainedPropertiesJSONObject(b bVar, String str) {
            b bVar2;
            j.g(bVar, "<this>");
            j.g(str, "constraintField");
            if (j.b(bVar, DataplanFilterImpl.emptyJSONObject)) {
                return bVar;
            }
            b optJSONObject = bVar.optJSONObject(JivePropertiesExtension.ELEMENT);
            if (optJSONObject != null) {
                bVar2 = optJSONObject.optJSONObject(str);
            } else {
                bVar2 = null;
            }
            if (bVar2 != null) {
                return bVar2;
            }
            if (bVar.optBoolean("additionalProperties", true)) {
                return null;
            }
            return DataplanFilterImpl.emptyJSONObject;
        }

        public final HashSet<String> getConstrainedPropertiesKeySet(b bVar) {
            Iterator<String> keys;
            HashSet<String> hashSet;
            j.g(bVar, "<this>");
            if (j.b(bVar, DataplanFilterImpl.emptyJSONObject)) {
                return new HashSet<>();
            }
            if (bVar.optBoolean("additionalProperties", true)) {
                return null;
            }
            b optJSONObject = bVar.optJSONObject(JivePropertiesExtension.ELEMENT);
            if (optJSONObject == null || (keys = optJSONObject.keys()) == null || (hashSet = toHashSet(keys)) == null) {
                return new HashSet<>();
            }
            return hashSet;
        }

        public final String getEventsApiName(MParticle.IdentityType identityType) {
            j.g(identityType, "<this>");
            String stringValue = MParticleIdentityClientImpl.getStringValue(identityType);
            j.f(stringValue, "getStringValue(this)");
            return stringValue;
        }

        public final <T> HashSet<T> toHashSet(Iterator<? extends T> it) {
            j.g(it, "<this>");
            HashSet<T> hashSet = new HashSet<>();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
            return hashSet;
        }

        public final List<Object> toList(a aVar) {
            j.g(aVar, "<this>");
            ArrayList arrayList = new ArrayList();
            int o10 = aVar.o();
            for (int i10 = 0; i10 < o10; i10++) {
                arrayList.add(aVar.get(i10));
            }
            return arrayList;
        }

        public final String getEventsApiName(MParticle.EventType eventType) {
            j.g(eventType, "<this>");
            switch (WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()]) {
                case 1:
                    return "location";
                case 2:
                    return "media";
                case 3:
                    return "navigation";
                case 4:
                    return "other";
                case 5:
                    return FirebaseAnalytics.Event.SEARCH;
                case 6:
                    return "social";
                case 7:
                    return "transaction";
                case 8:
                    return "user_content";
                case 9:
                    return "user_preference";
                default:
                    return "unknown";
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0002\u0010\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0011J\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\"\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/mparticle/kits/DataplanFilterImpl$DataPoint;", "", "datapoint", "(Lcom/mparticle/kits/DataplanFilterImpl$DataPoint;)V", "type", "", "name", "eventType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEventType", "()Ljava/lang/String;", "getName", "<set-?>", "productAttributeType", "getProductAttributeType", "getType", "getProductDataPoints", "", "toString", "android-kit-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DataPoint {
        private final String eventType;
        private final String name;
        private String productAttributeType;
        private final String type;

        public DataPoint(String str, String str2, String str3) {
            j.g(str, "type");
            this.type = str;
            this.name = str2;
            this.eventType = str3;
        }

        public final String getEventType() {
            return this.eventType;
        }

        public final String getName() {
            return this.name;
        }

        public final String getProductAttributeType() {
            return this.productAttributeType;
        }

        public final List<DataPoint> getProductDataPoints() {
            boolean z10;
            String str = this.type;
            if (j.b(str, DataplanFilterImpl.PRODUCT_ACTION_KEY)) {
                z10 = true;
            } else {
                z10 = j.b(str, DataplanFilterImpl.PRODUCT_IMPRESSION_KEY);
            }
            if (!z10) {
                return null;
            }
            DataPoint dataPoint = new DataPoint(this);
            dataPoint.productAttributeType = DataplanFilterImpl.PRODUCT_ACTION_PRODUCTS;
            Unit unit = Unit.f32013a;
            DataPoint dataPoint2 = new DataPoint(this);
            dataPoint2.productAttributeType = DataplanFilterImpl.PRODUCT_IMPRESSION_PRODUCTS;
            return q.m(dataPoint, dataPoint2);
        }

        public final String getType() {
            return this.type;
        }

        public String toString() {
            String str;
            String str2;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.type);
            String str3 = "";
            if (this.name != null) {
                str = '.' + this.name;
            } else {
                str = str3;
            }
            sb2.append(str);
            if (this.eventType != null) {
                str2 = '.' + this.eventType;
            } else {
                str2 = str3;
            }
            sb2.append(str2);
            String str4 = this.productAttributeType;
            if (str4 != null) {
                String str5 = '.' + str4;
                if (str5 != null) {
                    str3 = str5;
                }
            }
            sb2.append(str3);
            return sb2.toString();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DataPoint(String str, String str2, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public DataPoint(DataPoint dataPoint) {
            this(dataPoint.type, dataPoint.name, dataPoint.eventType);
            j.g(dataPoint, "datapoint");
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0016J#\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u0001H\nH\u0016¢\u0006\u0002\u0010\rJ0\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000f2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000fH\u0016J2\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\n\u0018\u00010\u000f\"\u0004\b\u0000\u0010\n2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\n\u0018\u00010\u000fH\u0016¨\u0006\u0013"}, d2 = {"Lcom/mparticle/kits/DataplanFilterImpl$EmptyDataplanFilter;", "Lcom/mparticle/kits/DataplanFilter;", "()V", "isUserAttributeBlocked", "", "key", "", "isUserIdentityBlocked", "Lcom/mparticle/MParticle$IdentityType;", "transformEventForEvent", "T", "Lcom/mparticle/BaseEvent;", "event", "(Lcom/mparticle/BaseEvent;)Lcom/mparticle/BaseEvent;", "transformIdentities", "", "identities", "transformUserAttributes", "attributes", "android-kit-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class EmptyDataplanFilter implements DataplanFilter {
        public boolean isUserAttributeBlocked(String str) {
            return false;
        }

        public boolean isUserIdentityBlocked(MParticle.IdentityType identityType) {
            return false;
        }

        public <T extends BaseEvent> T transformEventForEvent(T t10) {
            return t10;
        }

        public Map<MParticle.IdentityType, String> transformIdentities(Map<MParticle.IdentityType, String> map) {
            return map;
        }

        public <T> Map<String, T> transformUserAttributes(Map<String, ? extends T> map) {
            return map;
        }
    }

    public DataplanFilterImpl(Map<String, ? extends HashSet<String>> map, boolean z10, boolean z11, boolean z12, boolean z13) {
        Map<String, ? extends HashSet<String>> map2 = map;
        boolean z14 = z10;
        boolean z15 = z11;
        boolean z16 = z12;
        boolean z17 = z13;
        j.g(map2, "dataPoints");
        this.dataPoints = map2;
        this.blockEvents = z14;
        this.blockEventAttributes = z15;
        this.blockUserAttributes = z16;
        this.blockUserIdentities = z17;
        Logger.debug("\n\nData Plan parsed for Kit Filtering: \n    blockEvents=" + z14 + "\n    blockEventAttributes=" + z15 + "\n    blockUserAttributes=" + z16 + "\n    blockUserIdentities=" + z17 + "\n        " + CollectionsKt___CollectionsKt.W(map.entrySet(), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, AnonymousClass1.INSTANCE, 30, (Object) null) + "\n        ");
    }

    public final Map<String, HashSet<String>> getDataPoints() {
        return this.dataPoints;
    }

    public boolean isUserAttributeBlocked(String str) {
        HashSet hashSet;
        if (!this.blockUserAttributes || str == null || (hashSet = this.dataPoints.get(USER_ATTRIBUTES_KEY)) == null) {
            return false;
        }
        boolean contains = hashSet.contains(str);
        if (!contains) {
            Logger.verbose("Blocking unplanned UserAttribute: " + str);
        }
        return !contains;
    }

    public boolean isUserIdentityBlocked(MParticle.IdentityType identityType) {
        HashSet hashSet;
        if (!this.blockUserIdentities || identityType == null || (hashSet = this.dataPoints.get(USER_IDENTITIES_KEY)) == null) {
            return false;
        }
        boolean contains = hashSet.contains(MParticleIdentityClientImpl.getStringValue(identityType));
        if (!contains) {
            Logger.verbose("Blocking unplanned UserIdentity: " + identityType);
        }
        return !contains;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0220, code lost:
        if (r2.hasNext() == false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0222, code lost:
        r4 = (com.mparticle.commerce.Product) r2.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0228, code lost:
        if (r4 == null) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x022a, code lost:
        r4 = r4.getCustomAttributes();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x022e, code lost:
        if (r4 == null) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0230, code lost:
        kotlin.jvm.internal.j.f(r4, "customAttributes");
        r4 = kotlin.collections.h0.w(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0237, code lost:
        if (r4 == null) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0239, code lost:
        r5 = new java.util.LinkedHashMap();
        r7 = r4.entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x024a, code lost:
        if (r7.hasNext() == false) goto L_0x026e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x024c, code lost:
        r8 = (java.util.Map.Entry) r7.next();
        r9 = (java.lang.String) r8.getKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0258, code lost:
        if (r0 == null) goto L_0x025f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x025a, code lost:
        r9 = r0.contains(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x025f, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0260, code lost:
        if (r9 == false) goto L_0x0246;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0262, code lost:
        r5.put(r8.getKey(), r8.getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x026e, code lost:
        r4.clear();
        r4.putAll(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0201, code lost:
        if (r1 != null) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0207, code lost:
        if (r1.hasNext() == false) goto L_0x0275;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0209, code lost:
        r2 = r1.next().getProducts();
        kotlin.jvm.internal.j.f(r2, "it.products");
        r2 = r2.iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends com.mparticle.BaseEvent> T transformEventForEvent(T r13) {
        /*
            r12 = this;
            r0 = 0
            if (r13 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r12.blockEvents
            if (r1 != 0) goto L_0x000e
            boolean r1 = r12.blockEventAttributes
            if (r1 == 0) goto L_0x000d
            goto L_0x000e
        L_0x000d:
            return r13
        L_0x000e:
            boolean r1 = r13 instanceof com.mparticle.MPEvent
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x004a
            r1 = r13
            com.mparticle.MPEvent r1 = (com.mparticle.MPEvent) r1
            boolean r4 = r1.isScreenEvent()
            if (r4 == 0) goto L_0x002e
            com.mparticle.kits.DataplanFilterImpl$DataPoint r4 = new com.mparticle.kits.DataplanFilterImpl$DataPoint
            java.lang.String r7 = r1.getEventName()
            r8 = 0
            r9 = 4
            r10 = 0
            java.lang.String r6 = "screen_view"
            r5 = r4
            r5.<init>(r6, r7, r8, r9, r10)
            goto L_0x00b5
        L_0x002e:
            com.mparticle.kits.DataplanFilterImpl$DataPoint r4 = new com.mparticle.kits.DataplanFilterImpl$DataPoint
            java.lang.String r5 = r1.getEventName()
            com.mparticle.kits.DataplanFilterImpl$Companion r6 = Companion
            com.mparticle.MParticle$EventType r1 = r1.getEventType()
            java.lang.String r7 = "event.eventType"
            kotlin.jvm.internal.j.f(r1, r7)
            java.lang.String r1 = r6.getEventsApiName((com.mparticle.MParticle.EventType) r1)
            java.lang.String r6 = "custom_event"
            r4.<init>(r6, r5, r1)
            goto L_0x00b5
        L_0x004a:
            boolean r1 = r13 instanceof com.mparticle.commerce.CommerceEvent
            if (r1 == 0) goto L_0x00b4
            r1 = r13
            com.mparticle.commerce.CommerceEvent r1 = (com.mparticle.commerce.CommerceEvent) r1
            java.lang.String r4 = r1.getProductAction()
            if (r4 == 0) goto L_0x0060
            boolean r4 = kotlin.text.r.w(r4)
            if (r4 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r4 = r2
            goto L_0x0061
        L_0x0060:
            r4 = r3
        L_0x0061:
            if (r4 != 0) goto L_0x0073
            com.mparticle.kits.DataplanFilterImpl$DataPoint r4 = new com.mparticle.kits.DataplanFilterImpl$DataPoint
            java.lang.String r7 = r1.getProductAction()
            r8 = 0
            r9 = 4
            r10 = 0
            java.lang.String r6 = "product_action"
            r5 = r4
            r5.<init>(r6, r7, r8, r9, r10)
            goto L_0x00b5
        L_0x0073:
            java.lang.String r4 = r1.getPromotionAction()
            if (r4 == 0) goto L_0x0082
            boolean r4 = kotlin.text.r.w(r4)
            if (r4 == 0) goto L_0x0080
            goto L_0x0082
        L_0x0080:
            r4 = r2
            goto L_0x0083
        L_0x0082:
            r4 = r3
        L_0x0083:
            if (r4 != 0) goto L_0x0095
            com.mparticle.kits.DataplanFilterImpl$DataPoint r4 = new com.mparticle.kits.DataplanFilterImpl$DataPoint
            java.lang.String r7 = r1.getPromotionAction()
            r8 = 0
            r9 = 4
            r10 = 0
            java.lang.String r6 = "promotion_action"
            r5 = r4
            r5.<init>(r6, r7, r8, r9, r10)
            goto L_0x00b5
        L_0x0095:
            java.util.List r1 = r1.getImpressions()
            if (r1 == 0) goto L_0x00a4
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00a2
            goto L_0x00a4
        L_0x00a2:
            r1 = r2
            goto L_0x00a5
        L_0x00a4:
            r1 = r3
        L_0x00a5:
            if (r1 != 0) goto L_0x00b4
            com.mparticle.kits.DataplanFilterImpl$DataPoint r1 = new com.mparticle.kits.DataplanFilterImpl$DataPoint
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            java.lang.String r5 = "product_impression"
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x00b5
        L_0x00b4:
            r4 = r0
        L_0x00b5:
            if (r4 != 0) goto L_0x00b8
            return r13
        L_0x00b8:
            boolean r1 = r12.blockEvents
            if (r1 == 0) goto L_0x00e1
            java.util.Map<java.lang.String, java.util.HashSet<java.lang.String>> r1 = r12.dataPoints
            java.lang.String r5 = r4.toString()
            boolean r1 = r1.containsKey(r5)
            if (r1 != 0) goto L_0x00e1
            java.lang.String[] r13 = new java.lang.String[r3]
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Blocking unplanned event: "
            r1.append(r3)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r13[r2] = r1
            com.mparticle.internal.Logger.verbose(r13)
            return r0
        L_0x00e1:
            java.util.Map<java.lang.String, java.util.HashSet<java.lang.String>> r1 = r12.dataPoints
            java.lang.String r5 = r4.toString()
            java.lang.Object r1 = r1.get(r5)
            java.util.HashSet r1 = (java.util.HashSet) r1
            boolean r5 = r12.blockEventAttributes
            if (r5 == 0) goto L_0x0275
            java.util.Map r5 = r13.getCustomAttributeStrings()
            if (r5 == 0) goto L_0x0148
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0104:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0148
            java.lang.Object r6 = r5.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r7 = r6.getKey()
            java.lang.String r7 = (java.lang.String) r7
            if (r1 == 0) goto L_0x0139
            boolean r8 = r1.contains(r7)
            if (r8 == 0) goto L_0x011f
            goto L_0x0139
        L_0x011f:
            java.lang.String[] r8 = new java.lang.String[r3]
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Blocking unplanned attribute: "
            r9.append(r10)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r8[r2] = r7
            com.mparticle.internal.Logger.verbose(r8)
            r7 = r2
            goto L_0x013a
        L_0x0139:
            r7 = r3
        L_0x013a:
            if (r7 == 0) goto L_0x0104
            java.lang.Object r7 = r6.getKey()
            java.lang.Object r6 = r6.getValue()
            r0.put(r7, r6)
            goto L_0x0104
        L_0x0148:
            r13.setCustomAttributes(r0)
            boolean r0 = r13 instanceof com.mparticle.commerce.CommerceEvent
            if (r0 == 0) goto L_0x0275
            java.util.Map<java.lang.String, java.util.HashSet<java.lang.String>> r0 = r12.dataPoints
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r5 = ".product_action_product"
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            java.lang.Object r0 = r0.get(r1)
            java.util.HashSet r0 = (java.util.HashSet) r0
            r1 = r13
            com.mparticle.commerce.CommerceEvent r1 = (com.mparticle.commerce.CommerceEvent) r1
            java.util.List r5 = r1.getProducts()
            java.lang.String r6 = "customAttributes"
            if (r5 == 0) goto L_0x01d2
            java.util.Iterator r5 = r5.iterator()
            if (r5 == 0) goto L_0x01d2
        L_0x0179:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x01d2
            java.lang.Object r7 = r5.next()
            com.mparticle.commerce.Product r7 = (com.mparticle.commerce.Product) r7
            if (r7 == 0) goto L_0x0179
            java.util.Map r7 = r7.getCustomAttributes()
            if (r7 == 0) goto L_0x0179
            kotlin.jvm.internal.j.f(r7, r6)
            java.util.Map r7 = kotlin.collections.h0.w(r7)
            if (r7 == 0) goto L_0x0179
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap
            r8.<init>()
            java.util.Set r9 = r7.entrySet()
            java.util.Iterator r9 = r9.iterator()
        L_0x01a3:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x01cb
            java.lang.Object r10 = r9.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r11 = r10.getKey()
            java.lang.String r11 = (java.lang.String) r11
            if (r0 == 0) goto L_0x01bc
            boolean r11 = r0.contains(r11)
            goto L_0x01bd
        L_0x01bc:
            r11 = r3
        L_0x01bd:
            if (r11 == 0) goto L_0x01a3
            java.lang.Object r11 = r10.getKey()
            java.lang.Object r10 = r10.getValue()
            r8.put(r11, r10)
            goto L_0x01a3
        L_0x01cb:
            r7.clear()
            r7.putAll(r8)
            goto L_0x0179
        L_0x01d2:
            java.util.Map<java.lang.String, java.util.HashSet<java.lang.String>> r0 = r12.dataPoints
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = ".product_impression_product"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.Object r0 = r0.get(r4)
            java.util.HashSet r0 = (java.util.HashSet) r0
            java.util.List r4 = r1.getImpressions()
            if (r4 == 0) goto L_0x01f5
            int r2 = r4.size()
        L_0x01f5:
            if (r2 <= 0) goto L_0x0275
            java.util.List r1 = r1.getImpressions()
            if (r1 == 0) goto L_0x0275
            java.util.Iterator r1 = r1.iterator()
            if (r1 == 0) goto L_0x0275
        L_0x0203:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0275
            java.lang.Object r2 = r1.next()
            com.mparticle.commerce.Impression r2 = (com.mparticle.commerce.Impression) r2
            java.util.List r2 = r2.getProducts()
            java.lang.String r4 = "it.products"
            kotlin.jvm.internal.j.f(r2, r4)
            java.util.Iterator r2 = r2.iterator()
        L_0x021c:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0203
            java.lang.Object r4 = r2.next()
            com.mparticle.commerce.Product r4 = (com.mparticle.commerce.Product) r4
            if (r4 == 0) goto L_0x021c
            java.util.Map r4 = r4.getCustomAttributes()
            if (r4 == 0) goto L_0x021c
            kotlin.jvm.internal.j.f(r4, r6)
            java.util.Map r4 = kotlin.collections.h0.w(r4)
            if (r4 == 0) goto L_0x021c
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            r5.<init>()
            java.util.Set r7 = r4.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x0246:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x026e
            java.lang.Object r8 = r7.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            java.lang.Object r9 = r8.getKey()
            java.lang.String r9 = (java.lang.String) r9
            if (r0 == 0) goto L_0x025f
            boolean r9 = r0.contains(r9)
            goto L_0x0260
        L_0x025f:
            r9 = r3
        L_0x0260:
            if (r9 == 0) goto L_0x0246
            java.lang.Object r9 = r8.getKey()
            java.lang.Object r8 = r8.getValue()
            r5.put(r9, r8)
            goto L_0x0246
        L_0x026e:
            r4.clear()
            r4.putAll(r5)
            goto L_0x021c
        L_0x0275:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.kits.DataplanFilterImpl.transformEventForEvent(com.mparticle.BaseEvent):com.mparticle.BaseEvent");
    }

    public Map<MParticle.IdentityType, String> transformIdentities(Map<MParticle.IdentityType, String> map) {
        HashSet hashSet;
        if (map == null) {
            return null;
        }
        if (!this.blockUserIdentities || (hashSet = this.dataPoints.get(USER_IDENTITIES_KEY)) == null) {
            return map;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            boolean contains = hashSet.contains(MParticleIdentityClientImpl.getStringValue((MParticle.IdentityType) next.getKey()));
            if (!contains) {
                Logger.verbose("Blocking unplanned UserIdentity: " + contains);
            }
            if (contains) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        return linkedHashMap;
    }

    public <T> Map<String, T> transformUserAttributes(Map<String, ? extends T> map) {
        HashSet hashSet;
        if (map == null) {
            return null;
        }
        if (!this.blockUserAttributes || (hashSet = this.dataPoints.get(USER_ATTRIBUTES_KEY)) == null) {
            return map;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            boolean contains = hashSet.contains((String) next.getKey());
            if (!contains) {
                Logger.verbose("Blocking unplanned UserAttribute: " + contains);
            }
            if (contains) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        return linkedHashMap;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DataplanFilterImpl(com.mparticle.MParticleOptions.DataplanOptions r10) {
        /*
            r9 = this;
            java.lang.String r0 = "dataplanOptions"
            kotlin.jvm.internal.j.g(r10, r0)
            com.mparticle.kits.DataplanFilterImpl$Companion r0 = Companion
            org.json.b r1 = r10.getDataplan()
            java.lang.String r2 = "dataplanOptions.dataplan"
            kotlin.jvm.internal.j.f(r1, r2)
            java.util.Map r4 = r0.extractDataPoints(r1)
            boolean r5 = r10.isBlockEvents()
            boolean r6 = r10.isBlockEventAttributes()
            boolean r7 = r10.isBlockUserAttributes()
            boolean r8 = r10.isBlockUserIdentities()
            r3 = r9
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.kits.DataplanFilterImpl.<init>(com.mparticle.MParticleOptions$DataplanOptions):void");
    }
}

package com.mparticle.identity;

import android.content.Context;
import com.facebook.AccessToken;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.stetho.server.http.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mparticle.BuildConfig;
import com.mparticle.MParticle;
import com.mparticle.SdkListener;
import com.mparticle.b0;
import com.mparticle.f0;
import com.mparticle.h;
import com.mparticle.identity.IdentityHttpResponse;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import com.mparticle.internal.listeners.InternalListenerManager;
import com.mparticle.l;
import com.mparticle.networking.b;
import com.mparticle.u;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;

public class a extends b implements f0 {

    /* renamed from: f  reason: collision with root package name */
    private Context f22349f;

    /* renamed from: g  reason: collision with root package name */
    private com.mparticle.internal.b f22350g;

    /* renamed from: h  reason: collision with root package name */
    private MParticle.OperatingSystem f22351h;

    /* renamed from: com.mparticle.identity.a$a  reason: collision with other inner class name */
    static /* synthetic */ class C0255a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22352a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f22353b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f22354c;

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ int[] f22355d;

        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|(2:57|58)|59|61|62|(3:63|64|66)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(57:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|61|62|(3:63|64|66)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|61|62|(3:63|64|66)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|(2:1|2)|3|5|6|7|9|10|11|12|13|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|61|62|(3:63|64|66)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(61:0|(2:1|2)|3|5|6|7|9|10|11|12|13|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|61|62|63|64|66) */
        /* JADX WARNING: Can't wrap try/catch for region: R(62:0|1|2|3|5|6|7|9|10|11|12|13|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|61|62|63|64|66) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0074 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ae */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00ba */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00c6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00d2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00de */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00ea */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00f6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0102 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x010e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x011a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0126 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0132 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x014f */
        static {
            /*
                com.mparticle.MParticle$OperatingSystem[] r0 = com.mparticle.MParticle.OperatingSystem.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22355d = r0
                r1 = 1
                com.mparticle.MParticle$OperatingSystem r2 = com.mparticle.MParticle.OperatingSystem.ANDROID     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f22355d     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mparticle.MParticle$OperatingSystem r3 = com.mparticle.MParticle.OperatingSystem.FIRE_OS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.mparticle.MParticle$Environment[] r2 = com.mparticle.MParticle.Environment.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f22354c = r2
                com.mparticle.MParticle$Environment r3 = com.mparticle.MParticle.Environment.Development     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f22354c     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.mparticle.MParticle$Environment r3 = com.mparticle.MParticle.Environment.Production     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                com.mparticle.MParticle$IdentityType[] r2 = com.mparticle.MParticle.IdentityType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f22353b = r2
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.Other     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x0053 }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.Other2     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x005e }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.Other3     // Catch:{ NoSuchFieldError -> 0x005e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x0069 }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.Other4     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x0074 }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.Other5     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r4 = 5
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x007f }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.Other6     // Catch:{ NoSuchFieldError -> 0x007f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r4 = 6
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x008a }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.Other7     // Catch:{ NoSuchFieldError -> 0x008a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x008a }
                r4 = 7
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x008a }
            L_0x008a:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x0096 }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.Other8     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r4 = 8
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x00a2 }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.Other9     // Catch:{ NoSuchFieldError -> 0x00a2 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a2 }
                r4 = 9
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00a2 }
            L_0x00a2:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x00ae }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.Other10     // Catch:{ NoSuchFieldError -> 0x00ae }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ae }
                r4 = 10
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00ae }
            L_0x00ae:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x00ba }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.CustomerId     // Catch:{ NoSuchFieldError -> 0x00ba }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ba }
                r4 = 11
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00ba }
            L_0x00ba:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x00c6 }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.Facebook     // Catch:{ NoSuchFieldError -> 0x00c6 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c6 }
                r4 = 12
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00c6 }
            L_0x00c6:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x00d2 }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.Twitter     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r4 = 13
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x00de }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.Google     // Catch:{ NoSuchFieldError -> 0x00de }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00de }
                r4 = 14
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00de }
            L_0x00de:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x00ea }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.Microsoft     // Catch:{ NoSuchFieldError -> 0x00ea }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ea }
                r4 = 15
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00ea }
            L_0x00ea:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x00f6 }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.Yahoo     // Catch:{ NoSuchFieldError -> 0x00f6 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f6 }
                r4 = 16
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x00f6 }
            L_0x00f6:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x0102 }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.Alias     // Catch:{ NoSuchFieldError -> 0x0102 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0102 }
                r4 = 17
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0102 }
            L_0x0102:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x010e }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.Email     // Catch:{ NoSuchFieldError -> 0x010e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x010e }
                r4 = 18
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x010e }
            L_0x010e:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x011a }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.FacebookCustomAudienceId     // Catch:{ NoSuchFieldError -> 0x011a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x011a }
                r4 = 19
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x011a }
            L_0x011a:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x0126 }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.MobileNumber     // Catch:{ NoSuchFieldError -> 0x0126 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0126 }
                r4 = 20
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0126 }
            L_0x0126:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x0132 }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.PhoneNumber2     // Catch:{ NoSuchFieldError -> 0x0132 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0132 }
                r4 = 21
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0132 }
            L_0x0132:
                int[] r2 = f22353b     // Catch:{ NoSuchFieldError -> 0x013e }
                com.mparticle.MParticle$IdentityType r3 = com.mparticle.MParticle.IdentityType.PhoneNumber3     // Catch:{ NoSuchFieldError -> 0x013e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x013e }
                r4 = 22
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x013e }
            L_0x013e:
                com.mparticle.internal.MPUtility$AdIdInfo$Advertiser[] r2 = com.mparticle.internal.MPUtility.AdIdInfo.Advertiser.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f22352a = r2
                com.mparticle.internal.MPUtility$AdIdInfo$Advertiser r3 = com.mparticle.internal.MPUtility.AdIdInfo.Advertiser.AMAZON     // Catch:{ NoSuchFieldError -> 0x014f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x014f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x014f }
            L_0x014f:
                int[] r1 = f22352a     // Catch:{ NoSuchFieldError -> 0x0159 }
                com.mparticle.internal.MPUtility$AdIdInfo$Advertiser r2 = com.mparticle.internal.MPUtility.AdIdInfo.Advertiser.GOOGLE     // Catch:{ NoSuchFieldError -> 0x0159 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0159 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0159 }
            L_0x0159:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mparticle.identity.a.C0255a.<clinit>():void");
        }
    }

    public a(Context context, com.mparticle.internal.b bVar, MParticle.OperatingSystem operatingSystem) {
        super(context, bVar);
        this.f22349f = context;
        this.f22350g = bVar;
        this.f22351h = operatingSystem;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.b e(com.mparticle.identity.IdentityApiRequest r14) throws org.json.JSONException {
        /*
            r13 = this;
            java.lang.Long r0 = r14.mpid
            if (r0 != 0) goto L_0x0010
            com.mparticle.internal.b r0 = r13.f22350g
            long r0 = r0.E()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r14.mpid = r0
        L_0x0010:
            org.json.b r0 = r13.f()
            org.json.a r1 = new org.json.a
            r1.<init>()
            java.util.Map r2 = r14.getUserIdentities()
            com.mparticle.internal.b r3 = r13.f22350g
            java.lang.Long r4 = r14.mpid
            long r4 = r4.longValue()
            java.util.Map r3 = r3.d((long) r4)
            java.util.HashSet r4 = new java.util.HashSet
            java.util.Set r5 = r2.keySet()
            r4.<init>(r5)
            java.util.Set r5 = r2.keySet()
            r4.addAll(r5)
            java.util.Iterator r4 = r4.iterator()
        L_0x003d:
            boolean r5 = r4.hasNext()
            java.lang.String r6 = "identity_type"
            java.lang.String r7 = "old_value"
            java.lang.String r8 = "new_value"
            if (r5 == 0) goto L_0x0089
            java.lang.Object r5 = r4.next()
            com.mparticle.MParticle$IdentityType r5 = (com.mparticle.MParticle.IdentityType) r5
            java.lang.String r9 = a((com.mparticle.MParticle.IdentityType) r5)
            boolean r10 = com.mparticle.internal.MPUtility.isEmpty((java.lang.CharSequence) r9)
            if (r10 != 0) goto L_0x003d
            org.json.b r10 = new org.json.b
            r10.<init>()
            java.lang.Object r11 = r2.get(r5)
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r5 = r3.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            if (r11 == r5) goto L_0x003d
            if (r11 == 0) goto L_0x0074
            boolean r12 = r11.equals(r5)
            if (r12 != 0) goto L_0x003d
        L_0x0074:
            if (r11 != 0) goto L_0x0078
            java.lang.Object r11 = org.json.b.NULL
        L_0x0078:
            r10.put((java.lang.String) r8, (java.lang.Object) r11)
            if (r5 != 0) goto L_0x007f
            java.lang.Object r5 = org.json.b.NULL
        L_0x007f:
            r10.put((java.lang.String) r7, (java.lang.Object) r5)
            r10.put((java.lang.String) r6, (java.lang.Object) r9)
            r1.E(r10)
            goto L_0x003d
        L_0x0089:
            java.util.Map r2 = r14.getOtherNewIdentities()
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0095:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00db
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.getValue()
            java.lang.String r3 = (java.lang.String) r3
            java.util.Map r5 = r14.getOtherOldIdentities()
            java.lang.Object r5 = r5.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            org.json.b r9 = new org.json.b
            r9.<init>()
            if (r3 == r5) goto L_0x0095
            if (r3 == 0) goto L_0x00c6
            boolean r10 = r3.equals(r5)
            if (r10 != 0) goto L_0x0095
        L_0x00c6:
            if (r3 != 0) goto L_0x00ca
            java.lang.Object r3 = org.json.b.NULL
        L_0x00ca:
            r9.put((java.lang.String) r8, (java.lang.Object) r3)
            if (r5 != 0) goto L_0x00d1
            java.lang.Object r5 = org.json.b.NULL
        L_0x00d1:
            r9.put((java.lang.String) r7, (java.lang.Object) r5)
            r9.put((java.lang.String) r6, (java.lang.Object) r4)
            r1.E(r9)
            goto L_0x0095
        L_0x00db:
            java.lang.String r14 = "identity_changes"
            r0.put((java.lang.String) r14, (java.lang.Object) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.identity.a.e(com.mparticle.identity.IdentityApiRequest):org.json.b");
    }

    private org.json.b f() throws JSONException {
        org.json.b bVar = new org.json.b();
        bVar.put("platform", (Object) g());
        bVar.put("sdk_vendor", (Object) "mparticle");
        bVar.put("sdk_version", (Object) BuildConfig.VERSION_NAME);
        org.json.b bVar2 = new org.json.b();
        bVar2.put("client_sdk", (Object) bVar);
        String w10 = this.f22350g.w();
        if (w10 != null) {
            bVar2.put(IdentityHttpResponse.CONTEXT, (Object) w10);
        }
        String a10 = a(com.mparticle.internal.b.u());
        if (!MPUtility.isEmpty((CharSequence) a10)) {
            bVar2.put("environment", (Object) a10);
        }
        bVar2.put("request_timestamp_ms", System.currentTimeMillis());
        bVar2.put(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, (Object) UUID.randomUUID().toString());
        return bVar2;
    }

    public IdentityHttpResponse a(IdentityApiRequest identityApiRequest) throws JSONException, IOException {
        org.json.b e10 = e(identityApiRequest);
        Logger.verbose("Identity modify request: \n" + e10.toString());
        org.json.a optJSONArray = e10.optJSONArray("identity_changes");
        if (optJSONArray != null && optJSONArray.o() == 0) {
            return new IdentityHttpResponse(200, identityApiRequest.mpid.longValue(), "", (ArrayList<IdentityHttpResponse.Error>) null);
        }
        u a10 = a(identityApiRequest.mpid, "modify", e10.toString());
        String b0Var = a10.h().toString();
        l listener = InternalListenerManager.getListener();
        SdkListener.Endpoint endpoint = SdkListener.Endpoint.IDENTITY_MODIFY;
        listener.onNetworkRequestStarted(endpoint, b0Var, e10, identityApiRequest);
        u a11 = a(b.C0262b.IDENTITY, a10, e10.toString(), false);
        int d10 = a11.d();
        org.json.b jsonResponse = MPUtility.getJsonResponse(a11);
        InternalListenerManager.getListener().onNetworkRequestFinished(endpoint, b0Var, jsonResponse, d10);
        return a(d10, jsonResponse);
    }

    public IdentityHttpResponse b(IdentityApiRequest identityApiRequest) throws JSONException, IOException {
        org.json.b f10 = f(identityApiRequest);
        Logger.verbose("Identity login request: " + f10.toString());
        u a10 = a(FirebaseAnalytics.Event.LOGIN, f10.toString());
        String b0Var = a10.h().toString();
        l listener = InternalListenerManager.getListener();
        SdkListener.Endpoint endpoint = SdkListener.Endpoint.IDENTITY_LOGIN;
        listener.onNetworkRequestStarted(endpoint, b0Var, f10, identityApiRequest);
        u a11 = a(b.C0262b.IDENTITY, a10, f10.toString(), false);
        int d10 = a11.d();
        org.json.b jsonResponse = MPUtility.getJsonResponse(a11);
        InternalListenerManager.getListener().onNetworkRequestFinished(endpoint, b0Var, jsonResponse, d10);
        return a(d10, jsonResponse);
    }

    public IdentityHttpResponse c(IdentityApiRequest identityApiRequest) throws JSONException, IOException {
        org.json.b f10 = f(identityApiRequest);
        Logger.verbose("Identity identify request: \n" + f10.toString());
        u a10 = a("identify", f10.toString());
        String b0Var = a10.h().toString();
        l listener = InternalListenerManager.getListener();
        SdkListener.Endpoint endpoint = SdkListener.Endpoint.IDENTITY_IDENTIFY;
        listener.onNetworkRequestStarted(endpoint, b0Var, f10, identityApiRequest);
        u a11 = a(b.C0262b.IDENTITY, a10, f10.toString(), false);
        int d10 = a11.d();
        org.json.b jsonResponse = MPUtility.getJsonResponse(a11);
        InternalListenerManager.getListener().onNetworkRequestFinished(endpoint, b0Var, jsonResponse, d10);
        return a(d10, jsonResponse);
    }

    public IdentityHttpResponse d(IdentityApiRequest identityApiRequest) throws JSONException, IOException {
        org.json.b f10 = f(identityApiRequest);
        Logger.verbose("Identity logout request: \n" + f10.toString());
        u a10 = a("logout", f10.toString());
        String b0Var = a10.h().toString();
        l listener = InternalListenerManager.getListener();
        SdkListener.Endpoint endpoint = SdkListener.Endpoint.IDENTITY_LOGOUT;
        listener.onNetworkRequestStarted(endpoint, b0Var, f10, identityApiRequest);
        u a11 = a(b.C0262b.IDENTITY, a10, f10.toString(), false);
        int d10 = a11.d();
        org.json.b jsonResponse = MPUtility.getJsonResponse(a11);
        InternalListenerManager.getListener().onNetworkRequestFinished(endpoint, b0Var, jsonResponse, d10);
        return a(d10, jsonResponse);
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return C0255a.f22355d[this.f22351h.ordinal()] != 2 ? "android" : "fire";
    }

    private String d() {
        return this.f22350g.j();
    }

    /* access modifiers changed from: package-private */
    public b0 c(String str) throws MalformedURLException {
        return a(b.C0262b.IDENTITY, str);
    }

    private IdentityHttpResponse a(int i10, org.json.b bVar) {
        try {
            Logger.verbose("Identity response code: " + i10);
            if (bVar != null) {
                Logger.verbose("Identity result: " + bVar.toString());
            }
            IdentityHttpResponse identityHttpResponse = new IdentityHttpResponse(i10, bVar);
            if (!MPUtility.isEmpty((CharSequence) identityHttpResponse.getContext())) {
                this.f22350g.a(identityHttpResponse.getContext());
            }
            return identityHttpResponse;
        } catch (JSONException e10) {
            return new IdentityHttpResponse(i10, e10.getMessage());
        }
    }

    private org.json.b f(IdentityApiRequest identityApiRequest) throws JSONException {
        org.json.b f10 = f();
        org.json.b bVar = new org.json.b();
        MPUtility.AdIdInfo adIdInfo = MPUtility.getAdIdInfo(this.f22349f);
        if (adIdInfo != null && !adIdInfo.isLimitAdTrackingEnabled) {
            int i10 = C0255a.f22352a[adIdInfo.advertiser.ordinal()];
            if (i10 == 1) {
                bVar.put("fire_aid", (Object) adIdInfo.f22362id);
            } else if (i10 == 2) {
                bVar.put("android_aaid", (Object) adIdInfo.f22362id);
            }
        }
        String K = this.f22350g.K();
        if (!MPUtility.isEmpty((CharSequence) K)) {
            bVar.put("push_token", (Object) K);
        }
        String androidID = MPUtility.getAndroidID(this.f22349f);
        if (!MPUtility.isEmpty((CharSequence) androidID)) {
            bVar.put("android_uuid", (Object) androidID);
        }
        String t10 = this.f22350g.t();
        if (!MPUtility.isEmpty((CharSequence) t10)) {
            bVar.put("device_application_stamp", (Object) t10);
        }
        if (identityApiRequest != null && !MPUtility.isEmpty((Map) identityApiRequest.getUserIdentities())) {
            for (Map.Entry next : identityApiRequest.getUserIdentities().entrySet()) {
                String a10 = a((MParticle.IdentityType) next.getKey());
                if (!MPUtility.isEmpty((CharSequence) a10)) {
                    bVar.put(a10, next.getValue());
                }
            }
        }
        f10.put("known_identities", (Object) bVar);
        Long valueOf = Long.valueOf(this.f22350g.E());
        if (!valueOf.equals(h.f22319b)) {
            f10.put("previous_mpid", (Object) valueOf);
        }
        return f10;
    }

    private u a(Long l10, String str, String str2) throws IOException {
        b0 b0Var;
        if (l10 == null) {
            b0Var = c(str);
        } else {
            b0Var = a(l10.longValue(), str);
        }
        u c10 = b0Var.c();
        c10.a(Integer.valueOf(this.f22350g.x()));
        c10.b(Integer.valueOf(this.f22350g.x()));
        c10.a("POST");
        c10.a(Boolean.TRUE);
        c10.a("Content-Encoding", "gzip");
        c10.a("x-mp-key", d());
        c10.a(HttpHeaders.CONTENT_TYPE, "application/json");
        String c11 = c();
        c10.a("Date", c11);
        try {
            c10.a("x-mp-signature", a(c10, c11, str2, e()));
        } catch (NoSuchAlgorithmException unused) {
            Logger.error("Error signing message.");
        } catch (InvalidKeyException unused2) {
            Logger.error("Error signing message.");
        }
        return c10;
    }

    private String e() {
        return this.f22350g.k();
    }

    private u a(String str, String str2) throws IOException {
        return a((Long) null, str, str2);
    }

    /* access modifiers changed from: package-private */
    public b0 a(long j10, String str) throws MalformedURLException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(j10);
        if (str.indexOf(RemoteSettings.FORWARD_SLASH_STRING) != 0) {
            sb2.append(RemoteSettings.FORWARD_SLASH_STRING);
        }
        sb2.append(str);
        return c(sb2.toString());
    }

    public static String a(MParticle.IdentityType identityType) {
        switch (C0255a.f22353b[identityType.ordinal()]) {
            case 1:
                return "other";
            case 2:
                return "other2";
            case 3:
                return "other3";
            case 4:
                return "other4";
            case 5:
                return "other5";
            case 6:
                return "other6";
            case 7:
                return "other7";
            case 8:
                return "other8";
            case 9:
                return "other9";
            case 10:
                return "other10";
            case 11:
                return "customerid";
            case 12:
                return AccessToken.DEFAULT_GRAPH_DOMAIN;
            case 13:
                return "twitter";
            case 14:
                return "google";
            case 15:
                return "microsoft";
            case 16:
                return "yahoo";
            case 17:
                return "alias";
            case 18:
                return "email";
            case 19:
                return "facebookcustomaudienceid";
            case 20:
                return "mobile_number";
            case 21:
                return "phone_number_2";
            case 22:
                return "phone_number_3";
            default:
                return "";
        }
    }

    private String a(MParticle.Environment environment) {
        int i10 = C0255a.f22354c[environment.ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? "" : "production";
        }
        return "development";
    }
}

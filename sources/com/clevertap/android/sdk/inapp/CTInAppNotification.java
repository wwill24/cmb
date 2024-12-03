package com.clevertap.android.sdk.inapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.LruCache;
import com.clevertap.android.sdk.p;
import i4.x;
import java.util.ArrayList;
import java.util.Iterator;
import org.jivesoftware.smackx.xhtmlim.packet.XHTMLExtension;
import org.json.JSONException;

public class CTInAppNotification implements Parcelable {
    public static final Parcelable.Creator<CTInAppNotification> CREATOR = new a();
    private boolean B;
    private boolean C;
    private org.json.b D;
    private String E;
    private int F;
    private ArrayList<CTInAppNotificationMedia> G;
    private String H;
    private String I;
    private char J;
    private boolean K;
    private long L;
    private String M;
    private String N;
    private int O;
    private int P;
    private String Q;
    private boolean R;
    private int S;
    private int T;

    /* renamed from: a  reason: collision with root package name */
    c f10291a;

    /* renamed from: b  reason: collision with root package name */
    private String f10292b;

    /* renamed from: c  reason: collision with root package name */
    private org.json.b f10293c;

    /* renamed from: d  reason: collision with root package name */
    private String f10294d;

    /* renamed from: e  reason: collision with root package name */
    private int f10295e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<CTInAppNotificationButton> f10296f;

    /* renamed from: g  reason: collision with root package name */
    private String f10297g;

    /* renamed from: h  reason: collision with root package name */
    private org.json.b f10298h;

    /* renamed from: j  reason: collision with root package name */
    private String f10299j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10300k;

    /* renamed from: l  reason: collision with root package name */
    private String f10301l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10302m;

    /* renamed from: n  reason: collision with root package name */
    private int f10303n;

    /* renamed from: p  reason: collision with root package name */
    private int f10304p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f10305q;

    /* renamed from: t  reason: collision with root package name */
    private String f10306t;

    /* renamed from: w  reason: collision with root package name */
    private String f10307w;

    /* renamed from: x  reason: collision with root package name */
    private CTInAppType f10308x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f10309y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f10310z;

    class a implements Parcelable.Creator<CTInAppNotification> {
        a() {
        }

        /* renamed from: a */
        public CTInAppNotification createFromParcel(Parcel parcel) {
            return new CTInAppNotification(parcel, (a) null);
        }

        /* renamed from: b */
        public CTInAppNotification[] newArray(int i10) {
            return new CTInAppNotification[i10];
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10311a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.clevertap.android.sdk.inapp.CTInAppType[] r0 = com.clevertap.android.sdk.inapp.CTInAppType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10311a = r0
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeFooter     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10311a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeHeader     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f10311a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeCover     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f10311a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeHalfInterstitial     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f10311a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeCoverImageOnly     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f10311a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeHalfInterstitialImageOnly     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f10311a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.clevertap.android.sdk.inapp.CTInAppType r1 = com.clevertap.android.sdk.inapp.CTInAppType.CTInAppTypeInterstitialImageOnly     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inapp.CTInAppNotification.b.<clinit>():void");
        }
    }

    interface c {
        void a(CTInAppNotification cTInAppNotification);
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        private static final int f10312a;

        /* renamed from: b  reason: collision with root package name */
        private static final int f10313b;

        /* renamed from: c  reason: collision with root package name */
        private static LruCache<String, byte[]> f10314c;

        class a extends LruCache<String, byte[]> {
            a(int i10) {
                super(i10);
            }

            /* access modifiers changed from: protected */
            /* renamed from: a */
            public int sizeOf(String str, byte[] bArr) {
                int a10 = d.f(bArr);
                p.o("CTInAppNotification.GifCache: have gif of size: " + a10 + "KB for key: " + str);
                return a10;
            }
        }

        static {
            int maxMemory = ((int) Runtime.getRuntime().maxMemory()) / 1024;
            f10312a = maxMemory;
            f10313b = Math.max(maxMemory / 32, 5120);
        }

        private d() {
        }

        static boolean b(String str, byte[] bArr) {
            if (f10314c == null) {
                return false;
            }
            if (e(str) != null) {
                return true;
            }
            synchronized (d.class) {
                int f10 = f(bArr);
                int d10 = d();
                p.o("CTInAppNotification.GifCache: gif size: " + f10 + "KB. Available mem: " + d10 + "KB.");
                if (f10 > d()) {
                    p.o("CTInAppNotification.GifCache: insufficient memory to add gif: " + str);
                    return false;
                }
                f10314c.put(str, bArr);
                p.o("CTInAppNotification.GifCache: added gif for key: " + str);
                return true;
            }
        }

        private static void c() {
            synchronized (d.class) {
                if (h()) {
                    p.o("CTInAppNotification.GifCache: cache is empty, removing it");
                    f10314c = null;
                }
            }
        }

        private static int d() {
            int i10;
            synchronized (d.class) {
                LruCache<String, byte[]> lruCache = f10314c;
                if (lruCache == null) {
                    i10 = 0;
                } else {
                    i10 = f10313b - lruCache.size();
                }
            }
            return i10;
        }

        static byte[] e(String str) {
            byte[] bArr;
            synchronized (d.class) {
                LruCache<String, byte[]> lruCache = f10314c;
                if (lruCache == null) {
                    bArr = null;
                } else {
                    bArr = lruCache.get(str);
                }
            }
            return bArr;
        }

        /* access modifiers changed from: private */
        public static int f(byte[] bArr) {
            return bArr.length / 1024;
        }

        static void g() {
            synchronized (d.class) {
                if (f10314c == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("CTInAppNotification.GifCache: init with max device memory: ");
                    sb2.append(f10312a);
                    sb2.append("KB and allocated cache size: ");
                    int i10 = f10313b;
                    sb2.append(i10);
                    sb2.append("KB");
                    p.o(sb2.toString());
                    try {
                        f10314c = new a(i10);
                    } catch (Throwable th2) {
                        p.r("CTInAppNotification.GifCache: unable to initialize cache: ", th2.getCause());
                    }
                }
            }
        }

        private static boolean h() {
            boolean z10;
            synchronized (d.class) {
                if (f10314c.size() <= 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            }
            return z10;
        }

        static void i(String str) {
            synchronized (d.class) {
                LruCache<String, byte[]> lruCache = f10314c;
                if (lruCache != null) {
                    lruCache.remove(str);
                    p.o("CTInAppNotification.GifCache: removed gif for key: " + str);
                    c();
                }
            }
        }
    }

    /* synthetic */ CTInAppNotification(Parcel parcel, a aVar) {
        this(parcel);
    }

    private boolean Q(Bundle bundle, String str, Class<?> cls) {
        return bundle.containsKey(str) && bundle.get(str).getClass().equals(cls);
    }

    private void V(org.json.b bVar) {
        String str;
        String str2;
        boolean z10;
        int i10;
        int i11;
        long j10;
        org.json.b bVar2;
        int i12;
        int i13;
        int i14;
        org.json.b bVar3 = bVar;
        if (!Y(e(bVar))) {
            this.f10301l = "Invalid JSON";
            return;
        }
        try {
            String str3 = "";
            if (bVar3.has("ti")) {
                str = bVar3.getString("ti");
            } else {
                str = str3;
            }
            this.f10307w = str;
            if (bVar3.has("wzrk_id")) {
                str2 = bVar3.getString("wzrk_id");
            } else {
                str2 = str3;
            }
            this.f10297g = str2;
            boolean z11 = true;
            int i15 = 0;
            if (!bVar3.has("efc") || bVar3.getInt("efc") != 1) {
                z10 = false;
            } else {
                z10 = true;
            }
            this.f10302m = z10;
            int i16 = -1;
            if (bVar3.has("tlc")) {
                i10 = bVar3.getInt("tlc");
            } else {
                i10 = -1;
            }
            this.P = i10;
            if (bVar3.has("tdc")) {
                i11 = bVar3.getInt("tdc");
            } else {
                i11 = -1;
            }
            this.O = i11;
            if (!bVar3.has("isJsEnabled") || !bVar3.getBoolean("isJsEnabled")) {
                z11 = false;
            }
            this.C = z11;
            if (bVar3.has("wzrk_ttl")) {
                j10 = bVar3.getLong("wzrk_ttl");
            } else {
                j10 = (System.currentTimeMillis() + 172800000) / 1000;
            }
            this.L = j10;
            org.json.b bVar4 = null;
            if (bVar3.has("d")) {
                bVar2 = bVar3.getJSONObject("d");
            } else {
                bVar2 = null;
            }
            if (bVar2 != null) {
                this.f10306t = bVar2.getString(XHTMLExtension.ELEMENT);
                if (bVar2.has("url")) {
                    str3 = bVar2.getString("url");
                }
                this.f10299j = str3;
                if (bVar2.has("kv")) {
                    bVar4 = bVar2.getJSONObject("kv");
                }
                this.f10298h = bVar4;
                if (bVar4 == null) {
                    this.f10298h = new org.json.b();
                }
                org.json.b jSONObject = bVar3.getJSONObject("w");
                if (jSONObject != null) {
                    this.f10300k = jSONObject.getBoolean("dk");
                    this.K = jSONObject.getBoolean("sc");
                    this.J = jSONObject.getString("pos").charAt(0);
                    if (jSONObject.has("xdp")) {
                        i12 = jSONObject.getInt("xdp");
                    } else {
                        i12 = 0;
                    }
                    this.S = i12;
                    if (jSONObject.has("xp")) {
                        i13 = jSONObject.getInt("xp");
                    } else {
                        i13 = 0;
                    }
                    this.T = i13;
                    if (jSONObject.has("ydp")) {
                        i14 = jSONObject.getInt("ydp");
                    } else {
                        i14 = 0;
                    }
                    this.f10303n = i14;
                    if (jSONObject.has("yp")) {
                        i15 = jSONObject.getInt("yp");
                    }
                    this.f10304p = i15;
                    if (jSONObject.has("mdc")) {
                        i16 = jSONObject.getInt("mdc");
                    }
                    this.F = i16;
                }
                if (this.f10306t != null) {
                    char c10 = this.J;
                    if (c10 == 't' && this.T == 100 && this.f10304p <= 30) {
                        this.f10308x = CTInAppType.CTInAppTypeHeaderHTML;
                    } else if (c10 == 'b' && this.T == 100 && this.f10304p <= 30) {
                        this.f10308x = CTInAppType.CTInAppTypeFooterHTML;
                    } else if (c10 == 'c' && this.T == 90 && this.f10304p == 85) {
                        this.f10308x = CTInAppType.CTInAppTypeInterstitialHTML;
                    } else if (c10 == 'c' && this.T == 100 && this.f10304p == 100) {
                        this.f10308x = CTInAppType.CTInAppTypeCoverHTML;
                    } else if (c10 == 'c' && this.T == 90 && this.f10304p == 50) {
                        this.f10308x = CTInAppType.CTInAppTypeHalfInterstitialHTML;
                    }
                }
            }
        } catch (JSONException unused) {
            this.f10301l = "Invalid JSON";
        }
    }

    private void X() {
        Iterator<CTInAppNotificationMedia> it = this.G.iterator();
        while (it.hasNext()) {
            CTInAppNotificationMedia next = it.next();
            if (!(next.d() == null || next.a() == null)) {
                if (!next.c().equals("image/gif")) {
                    v4.c.k(next.a(), false);
                    p.o("Deleted image - " + next.a());
                } else {
                    d.i(next.a());
                    p.o("Deleted GIF - " + next.a());
                }
            }
        }
    }

    private boolean Y(Bundle bundle) {
        Class<String> cls = String.class;
        Class<Boolean> cls2 = Boolean.class;
        Class<Integer> cls3 = Integer.class;
        try {
            Bundle bundle2 = bundle.getBundle("w");
            Bundle bundle3 = bundle.getBundle("d");
            if (bundle2 != null) {
                if (bundle3 != null) {
                    if (!Q(bundle2, "xdp", cls3) && !Q(bundle2, "xp", cls3)) {
                        return false;
                    }
                    if ((Q(bundle2, "ydp", cls3) || Q(bundle2, "yp", cls3)) && Q(bundle2, "dk", cls2) && Q(bundle2, "sc", cls2) && Q(bundle3, XHTMLExtension.ELEMENT, cls) && Q(bundle2, "pos", cls)) {
                        char charAt = bundle2.getString("pos").charAt(0);
                        if (charAt == 'b' || charAt == 'c' || charAt == 'l' || charAt == 'r' || charAt == 't') {
                            return true;
                        }
                        return false;
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            p.r("Failed to parse in-app notification!", th2);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0189 A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0190 A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0193 A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01c9 A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01cb A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0207 A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bb A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00bd A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c6 A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cb A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00dc A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ea A[SYNTHETIC, Splitter:B:58:0x00ea] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x010d A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0112 A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0115 A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x013b A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x013d A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0146 A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x014b A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0166 A[Catch:{ JSONException -> 0x0234 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x016d A[Catch:{ JSONException -> 0x0234 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.b r19) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            java.lang.String r2 = "media"
            java.lang.String r3 = "close"
            java.lang.String r4 = "message"
            java.lang.String r5 = "title"
            java.lang.String r6 = "wzrk_ttl"
            java.lang.String r7 = "hasLandscape"
            java.lang.String r8 = "hasPortrait"
            java.lang.String r9 = "bg"
            java.lang.String r10 = "tablet"
            java.lang.String r11 = "tdc"
            java.lang.String r12 = "tlc"
            java.lang.String r13 = "efc"
            java.lang.String r14 = "wzrk_id"
            java.lang.String r15 = "ti"
            boolean r16 = r0.has(r15)     // Catch:{ JSONException -> 0x0234 }
            java.lang.String r17 = ""
            if (r16 == 0) goto L_0x002d
            java.lang.String r15 = r0.getString(r15)     // Catch:{ JSONException -> 0x0234 }
            goto L_0x002f
        L_0x002d:
            r15 = r17
        L_0x002f:
            r1.f10307w = r15     // Catch:{ JSONException -> 0x0234 }
            boolean r15 = r0.has(r14)     // Catch:{ JSONException -> 0x0234 }
            if (r15 == 0) goto L_0x003c
            java.lang.String r14 = r0.getString(r14)     // Catch:{ JSONException -> 0x0234 }
            goto L_0x003e
        L_0x003c:
            r14 = r17
        L_0x003e:
            r1.f10297g = r14     // Catch:{ JSONException -> 0x0234 }
            java.lang.String r14 = "type"
            java.lang.String r14 = r0.getString(r14)     // Catch:{ JSONException -> 0x0234 }
            r1.Q = r14     // Catch:{ JSONException -> 0x0234 }
            boolean r14 = r0.has(r13)     // Catch:{ JSONException -> 0x0234 }
            r15 = 1
            if (r14 == 0) goto L_0x0057
            int r13 = r0.getInt(r13)     // Catch:{ JSONException -> 0x0234 }
            if (r13 != r15) goto L_0x0057
            r13 = r15
            goto L_0x0058
        L_0x0057:
            r13 = 0
        L_0x0058:
            r1.f10302m = r13     // Catch:{ JSONException -> 0x0234 }
            boolean r13 = r0.has(r12)     // Catch:{ JSONException -> 0x0234 }
            r14 = -1
            if (r13 == 0) goto L_0x0066
            int r12 = r0.getInt(r12)     // Catch:{ JSONException -> 0x0234 }
            goto L_0x0067
        L_0x0066:
            r12 = r14
        L_0x0067:
            r1.P = r12     // Catch:{ JSONException -> 0x0234 }
            boolean r12 = r0.has(r11)     // Catch:{ JSONException -> 0x0234 }
            if (r12 == 0) goto L_0x0073
            int r14 = r0.getInt(r11)     // Catch:{ JSONException -> 0x0234 }
        L_0x0073:
            r1.O = r14     // Catch:{ JSONException -> 0x0234 }
            java.lang.String r11 = r1.Q     // Catch:{ JSONException -> 0x0234 }
            com.clevertap.android.sdk.inapp.CTInAppType r11 = com.clevertap.android.sdk.inapp.CTInAppType.a(r11)     // Catch:{ JSONException -> 0x0234 }
            r1.f10308x = r11     // Catch:{ JSONException -> 0x0234 }
            boolean r11 = r0.has(r10)     // Catch:{ JSONException -> 0x0234 }
            if (r11 == 0) goto L_0x008b
            boolean r10 = r0.getBoolean(r10)     // Catch:{ JSONException -> 0x0234 }
            if (r10 == 0) goto L_0x008b
            r10 = r15
            goto L_0x008c
        L_0x008b:
            r10 = 0
        L_0x008c:
            r1.B = r10     // Catch:{ JSONException -> 0x0234 }
            boolean r10 = r0.has(r9)     // Catch:{ JSONException -> 0x0234 }
            if (r10 == 0) goto L_0x0099
            java.lang.String r9 = r0.getString(r9)     // Catch:{ JSONException -> 0x0234 }
            goto L_0x009b
        L_0x0099:
            java.lang.String r9 = "#FFFFFF"
        L_0x009b:
            r1.f10294d = r9     // Catch:{ JSONException -> 0x0234 }
            boolean r9 = r0.has(r8)     // Catch:{ JSONException -> 0x0234 }
            if (r9 == 0) goto L_0x00ac
            boolean r8 = r0.getBoolean(r8)     // Catch:{ JSONException -> 0x0234 }
            if (r8 == 0) goto L_0x00aa
            goto L_0x00ac
        L_0x00aa:
            r8 = 0
            goto L_0x00ad
        L_0x00ac:
            r8 = r15
        L_0x00ad:
            r1.f10310z = r8     // Catch:{ JSONException -> 0x0234 }
            boolean r8 = r0.has(r7)     // Catch:{ JSONException -> 0x0234 }
            if (r8 == 0) goto L_0x00bd
            boolean r7 = r0.getBoolean(r7)     // Catch:{ JSONException -> 0x0234 }
            if (r7 == 0) goto L_0x00bd
            r7 = r15
            goto L_0x00be
        L_0x00bd:
            r7 = 0
        L_0x00be:
            r1.f10309y = r7     // Catch:{ JSONException -> 0x0234 }
            boolean r7 = r0.has(r6)     // Catch:{ JSONException -> 0x0234 }
            if (r7 == 0) goto L_0x00cb
            long r6 = r0.getLong(r6)     // Catch:{ JSONException -> 0x0234 }
            goto L_0x00d3
        L_0x00cb:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0234 }
            r8 = 172800000(0xa4cb800, double:8.53745436E-316)
            long r6 = r6 + r8
        L_0x00d3:
            r1.L = r6     // Catch:{ JSONException -> 0x0234 }
            boolean r6 = r0.has(r5)     // Catch:{ JSONException -> 0x0234 }
            r7 = 0
            if (r6 == 0) goto L_0x00e1
            org.json.b r5 = r0.getJSONObject(r5)     // Catch:{ JSONException -> 0x0234 }
            goto L_0x00e2
        L_0x00e1:
            r5 = r7
        L_0x00e2:
            java.lang.String r6 = "#000000"
            java.lang.String r8 = "color"
            java.lang.String r9 = "text"
            if (r5 == 0) goto L_0x0107
            boolean r10 = r5.has(r9)     // Catch:{ JSONException -> 0x0234 }
            if (r10 == 0) goto L_0x00f5
            java.lang.String r10 = r5.getString(r9)     // Catch:{ JSONException -> 0x0234 }
            goto L_0x00f7
        L_0x00f5:
            r10 = r17
        L_0x00f7:
            r1.M = r10     // Catch:{ JSONException -> 0x0234 }
            boolean r10 = r5.has(r8)     // Catch:{ JSONException -> 0x0234 }
            if (r10 == 0) goto L_0x0104
            java.lang.String r5 = r5.getString(r8)     // Catch:{ JSONException -> 0x0234 }
            goto L_0x0105
        L_0x0104:
            r5 = r6
        L_0x0105:
            r1.N = r5     // Catch:{ JSONException -> 0x0234 }
        L_0x0107:
            boolean r5 = r0.has(r4)     // Catch:{ JSONException -> 0x0234 }
            if (r5 == 0) goto L_0x0112
            org.json.b r4 = r0.getJSONObject(r4)     // Catch:{ JSONException -> 0x0234 }
            goto L_0x0113
        L_0x0112:
            r4 = r7
        L_0x0113:
            if (r4 == 0) goto L_0x012f
            boolean r5 = r4.has(r9)     // Catch:{ JSONException -> 0x0234 }
            if (r5 == 0) goto L_0x011f
            java.lang.String r17 = r4.getString(r9)     // Catch:{ JSONException -> 0x0234 }
        L_0x011f:
            r5 = r17
            r1.H = r5     // Catch:{ JSONException -> 0x0234 }
            boolean r5 = r4.has(r8)     // Catch:{ JSONException -> 0x0234 }
            if (r5 == 0) goto L_0x012d
            java.lang.String r6 = r4.getString(r8)     // Catch:{ JSONException -> 0x0234 }
        L_0x012d:
            r1.I = r6     // Catch:{ JSONException -> 0x0234 }
        L_0x012f:
            boolean r4 = r0.has(r3)     // Catch:{ JSONException -> 0x0234 }
            if (r4 == 0) goto L_0x013d
            boolean r3 = r0.getBoolean(r3)     // Catch:{ JSONException -> 0x0234 }
            if (r3 == 0) goto L_0x013d
            r3 = r15
            goto L_0x013e
        L_0x013d:
            r3 = 0
        L_0x013e:
            r1.f10305q = r3     // Catch:{ JSONException -> 0x0234 }
            boolean r3 = r0.has(r2)     // Catch:{ JSONException -> 0x0234 }
            if (r3 == 0) goto L_0x014b
            org.json.b r2 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x0234 }
            goto L_0x014c
        L_0x014b:
            r2 = r7
        L_0x014c:
            if (r2 == 0) goto L_0x015e
            com.clevertap.android.sdk.inapp.CTInAppNotificationMedia r3 = new com.clevertap.android.sdk.inapp.CTInAppNotificationMedia     // Catch:{ JSONException -> 0x0234 }
            r3.<init>()     // Catch:{ JSONException -> 0x0234 }
            com.clevertap.android.sdk.inapp.CTInAppNotificationMedia r2 = r3.f(r2, r15)     // Catch:{ JSONException -> 0x0234 }
            if (r2 == 0) goto L_0x015e
            java.util.ArrayList<com.clevertap.android.sdk.inapp.CTInAppNotificationMedia> r3 = r1.G     // Catch:{ JSONException -> 0x0234 }
            r3.add(r2)     // Catch:{ JSONException -> 0x0234 }
        L_0x015e:
            java.lang.String r2 = "mediaLandscape"
            boolean r2 = r0.has(r2)     // Catch:{ JSONException -> 0x0234 }
            if (r2 == 0) goto L_0x016d
            java.lang.String r2 = "mediaLandscape"
            org.json.b r2 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x0234 }
            goto L_0x016e
        L_0x016d:
            r2 = r7
        L_0x016e:
            if (r2 == 0) goto L_0x0181
            com.clevertap.android.sdk.inapp.CTInAppNotificationMedia r3 = new com.clevertap.android.sdk.inapp.CTInAppNotificationMedia     // Catch:{ JSONException -> 0x0234 }
            r3.<init>()     // Catch:{ JSONException -> 0x0234 }
            r4 = 2
            com.clevertap.android.sdk.inapp.CTInAppNotificationMedia r2 = r3.f(r2, r4)     // Catch:{ JSONException -> 0x0234 }
            if (r2 == 0) goto L_0x0181
            java.util.ArrayList<com.clevertap.android.sdk.inapp.CTInAppNotificationMedia> r3 = r1.G     // Catch:{ JSONException -> 0x0234 }
            r3.add(r2)     // Catch:{ JSONException -> 0x0234 }
        L_0x0181:
            java.lang.String r2 = "buttons"
            boolean r2 = r0.has(r2)     // Catch:{ JSONException -> 0x0234 }
            if (r2 == 0) goto L_0x0190
            java.lang.String r2 = "buttons"
            org.json.a r0 = r0.getJSONArray(r2)     // Catch:{ JSONException -> 0x0234 }
            goto L_0x0191
        L_0x0190:
            r0 = r7
        L_0x0191:
            if (r0 == 0) goto L_0x01bc
            r2 = 0
        L_0x0194:
            int r3 = r0.o()     // Catch:{ JSONException -> 0x0234 }
            if (r2 >= r3) goto L_0x01bc
            com.clevertap.android.sdk.inapp.CTInAppNotificationButton r3 = new com.clevertap.android.sdk.inapp.CTInAppNotificationButton     // Catch:{ JSONException -> 0x0234 }
            r3.<init>()     // Catch:{ JSONException -> 0x0234 }
            org.json.b r4 = r0.j(r2)     // Catch:{ JSONException -> 0x0234 }
            com.clevertap.android.sdk.inapp.CTInAppNotificationButton r3 = r3.i(r4)     // Catch:{ JSONException -> 0x0234 }
            if (r3 == 0) goto L_0x01b9
            java.lang.String r4 = r3.getError()     // Catch:{ JSONException -> 0x0234 }
            if (r4 != 0) goto L_0x01b9
            java.util.ArrayList<com.clevertap.android.sdk.inapp.CTInAppNotificationButton> r4 = r1.f10296f     // Catch:{ JSONException -> 0x0234 }
            r4.add(r3)     // Catch:{ JSONException -> 0x0234 }
            int r3 = r1.f10295e     // Catch:{ JSONException -> 0x0234 }
            int r3 = r3 + r15
            r1.f10295e = r3     // Catch:{ JSONException -> 0x0234 }
        L_0x01b9:
            int r2 = r2 + 1
            goto L_0x0194
        L_0x01bc:
            int[] r0 = com.clevertap.android.sdk.inapp.CTInAppNotification.b.f10311a     // Catch:{ JSONException -> 0x0234 }
            com.clevertap.android.sdk.inapp.CTInAppType r2 = r1.f10308x     // Catch:{ JSONException -> 0x0234 }
            int r2 = r2.ordinal()     // Catch:{ JSONException -> 0x0234 }
            r0 = r0[r2]     // Catch:{ JSONException -> 0x0234 }
            switch(r0) {
                case 1: goto L_0x0207;
                case 2: goto L_0x0207;
                case 3: goto L_0x0207;
                case 4: goto L_0x0207;
                case 5: goto L_0x01cb;
                case 6: goto L_0x01cb;
                case 7: goto L_0x01cb;
                default: goto L_0x01c9;
            }     // Catch:{ JSONException -> 0x0234 }
        L_0x01c9:
            goto L_0x024c
        L_0x01cb:
            java.util.ArrayList<com.clevertap.android.sdk.inapp.CTInAppNotificationMedia> r0 = r1.G     // Catch:{ JSONException -> 0x0234 }
            boolean r0 = r0.isEmpty()     // Catch:{ JSONException -> 0x0234 }
            if (r0 != 0) goto L_0x0202
            java.util.ArrayList<com.clevertap.android.sdk.inapp.CTInAppNotificationMedia> r0 = r1.G     // Catch:{ JSONException -> 0x0234 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ JSONException -> 0x0234 }
        L_0x01d9:
            boolean r2 = r0.hasNext()     // Catch:{ JSONException -> 0x0234 }
            if (r2 == 0) goto L_0x024c
            java.lang.Object r2 = r0.next()     // Catch:{ JSONException -> 0x0234 }
            com.clevertap.android.sdk.inapp.CTInAppNotificationMedia r2 = (com.clevertap.android.sdk.inapp.CTInAppNotificationMedia) r2     // Catch:{ JSONException -> 0x0234 }
            boolean r3 = r2.h()     // Catch:{ JSONException -> 0x0234 }
            if (r3 != 0) goto L_0x01fd
            boolean r3 = r2.g()     // Catch:{ JSONException -> 0x0234 }
            if (r3 != 0) goto L_0x01fd
            boolean r3 = r2.j()     // Catch:{ JSONException -> 0x0234 }
            if (r3 != 0) goto L_0x01fd
            boolean r2 = r2.i()     // Catch:{ JSONException -> 0x0234 }
            if (r2 != 0) goto L_0x01d9
        L_0x01fd:
            java.lang.String r2 = "Wrong media type for template"
            r1.f10301l = r2     // Catch:{ JSONException -> 0x0234 }
            goto L_0x01d9
        L_0x0202:
            java.lang.String r0 = "No media type for template"
            r1.f10301l = r0     // Catch:{ JSONException -> 0x0234 }
            goto L_0x024c
        L_0x0207:
            java.util.ArrayList<com.clevertap.android.sdk.inapp.CTInAppNotificationMedia> r0 = r1.G     // Catch:{ JSONException -> 0x0234 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ JSONException -> 0x0234 }
        L_0x020d:
            boolean r2 = r0.hasNext()     // Catch:{ JSONException -> 0x0234 }
            if (r2 == 0) goto L_0x024c
            java.lang.Object r2 = r0.next()     // Catch:{ JSONException -> 0x0234 }
            com.clevertap.android.sdk.inapp.CTInAppNotificationMedia r2 = (com.clevertap.android.sdk.inapp.CTInAppNotificationMedia) r2     // Catch:{ JSONException -> 0x0234 }
            boolean r3 = r2.h()     // Catch:{ JSONException -> 0x0234 }
            if (r3 != 0) goto L_0x022b
            boolean r3 = r2.g()     // Catch:{ JSONException -> 0x0234 }
            if (r3 != 0) goto L_0x022b
            boolean r3 = r2.j()     // Catch:{ JSONException -> 0x0234 }
            if (r3 == 0) goto L_0x020d
        L_0x022b:
            r2.k(r7)     // Catch:{ JSONException -> 0x0234 }
            java.lang.String r2 = "Unable to download to media. Wrong media type for template"
            com.clevertap.android.sdk.p.a(r2)     // Catch:{ JSONException -> 0x0234 }
            goto L_0x020d
        L_0x0234:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid JSON"
            r2.append(r3)
            java.lang.String r0 = r0.getLocalizedMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.f10301l = r0
        L_0x024c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inapp.CTInAppNotification.a(org.json.b):void");
    }

    private static Bundle e(org.json.b bVar) {
        Bundle bundle = new Bundle();
        Iterator<String> keys = bVar.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = bVar.get(next);
                if (obj instanceof String) {
                    bundle.putString(next, (String) obj);
                } else if (obj instanceof Character) {
                    bundle.putChar(next, ((Character) obj).charValue());
                } else if (obj instanceof Integer) {
                    bundle.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Float) {
                    bundle.putFloat(next, ((Float) obj).floatValue());
                } else if (obj instanceof Double) {
                    bundle.putDouble(next, ((Double) obj).doubleValue());
                } else if (obj instanceof Long) {
                    bundle.putLong(next, ((Long) obj).longValue());
                } else if (obj instanceof Boolean) {
                    bundle.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof org.json.b) {
                    bundle.putBundle(next, e((org.json.b) obj));
                }
            } catch (JSONException unused) {
                p.o("Key had unknown object. Discarding");
            }
        }
        return bundle;
    }

    public long A() {
        return this.L;
    }

    public String B() {
        return this.M;
    }

    /* access modifiers changed from: package-private */
    public String D() {
        return this.N;
    }

    public int E() {
        return this.O;
    }

    public int F() {
        return this.P;
    }

    /* access modifiers changed from: package-private */
    public String G() {
        return this.Q;
    }

    /* access modifiers changed from: package-private */
    public int H() {
        return this.S;
    }

    /* access modifiers changed from: package-private */
    public int I() {
        return this.T;
    }

    /* access modifiers changed from: package-private */
    public CTInAppNotification K(org.json.b bVar, boolean z10) {
        String str;
        this.R = z10;
        this.D = bVar;
        try {
            if (bVar.has("type")) {
                str = bVar.getString("type");
            } else {
                str = null;
            }
            this.Q = str;
            if (str != null) {
                if (!str.equals("custom-html")) {
                    a(bVar);
                    return this;
                }
            }
            V(bVar);
        } catch (JSONException e10) {
            this.f10301l = "Invalid JSON : " + e10.getLocalizedMessage();
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean L() {
        return this.f10300k;
    }

    public boolean M() {
        return this.f10302m;
    }

    /* access modifiers changed from: package-private */
    public boolean O() {
        return this.f10305q;
    }

    /* access modifiers changed from: package-private */
    public boolean P() {
        return this.C;
    }

    public boolean R() {
        return this.f10309y;
    }

    public boolean S() {
        return this.f10310z;
    }

    /* access modifiers changed from: package-private */
    public boolean T() {
        return this.K;
    }

    /* access modifiers changed from: package-private */
    public boolean U() {
        return this.B;
    }

    /* access modifiers changed from: package-private */
    public void W() {
        Iterator<CTInAppNotificationMedia> it = this.G.iterator();
        while (it.hasNext()) {
            CTInAppNotificationMedia next = it.next();
            if (next.h()) {
                d.g();
                if (k(next) != null) {
                    this.f10291a.a(this);
                    return;
                } else if (next.d() != null) {
                    p.o("CTInAppNotification: downloading GIF :" + next.d());
                    byte[] j10 = x.j(next.d());
                    if (j10 != null) {
                        p.o("GIF Downloaded from url: " + next.d());
                        if (!d.b(next.a(), j10)) {
                            this.f10301l = "Error processing GIF";
                        }
                    }
                }
            } else if (next.i()) {
                v4.c.i();
                if (p(next) != null) {
                    this.f10291a.a(this);
                    return;
                } else if (next.d() != null) {
                    p.o("CTInAppNotification: downloading Image :" + next.d());
                    Bitmap h10 = x.h(next.d());
                    if (h10 != null) {
                        p.o("Image Downloaded from url: " + next.d());
                        if (!v4.c.b(next.a(), h10)) {
                            this.f10301l = "Error processing image";
                        }
                    } else {
                        p.a("Image Bitmap is null");
                        this.f10301l = "Error processing image as bitmap was NULL";
                    }
                }
            } else if ((next.j() || next.g()) && !this.R) {
                this.f10301l = "InApp Video/Audio is not supported";
            }
        }
        this.f10291a.a(this);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        X();
    }

    /* access modifiers changed from: package-private */
    public String d() {
        return this.f10294d;
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f10295e;
    }

    public ArrayList<CTInAppNotificationButton> g() {
        return this.f10296f;
    }

    /* access modifiers changed from: package-private */
    public String getError() {
        return this.f10301l;
    }

    public String h() {
        return this.f10297g;
    }

    /* access modifiers changed from: package-private */
    public org.json.b i() {
        return this.f10298h;
    }

    /* access modifiers changed from: package-private */
    public String j() {
        return this.f10299j;
    }

    /* access modifiers changed from: package-private */
    public byte[] k(CTInAppNotificationMedia cTInAppNotificationMedia) {
        return d.e(cTInAppNotificationMedia.a());
    }

    /* access modifiers changed from: package-private */
    public int l() {
        return this.f10303n;
    }

    /* access modifiers changed from: package-private */
    public int m() {
        return this.f10304p;
    }

    /* access modifiers changed from: package-private */
    public String n() {
        return this.f10306t;
    }

    public String o() {
        return this.f10307w;
    }

    /* access modifiers changed from: package-private */
    public Bitmap p(CTInAppNotificationMedia cTInAppNotificationMedia) {
        return v4.c.e(cTInAppNotificationMedia.a());
    }

    /* access modifiers changed from: package-private */
    public CTInAppNotificationMedia q(int i10) {
        Iterator<CTInAppNotificationMedia> it = this.G.iterator();
        while (it.hasNext()) {
            CTInAppNotificationMedia next = it.next();
            if (i10 == next.e()) {
                return next;
            }
        }
        return null;
    }

    public CTInAppType r() {
        return this.f10308x;
    }

    public org.json.b s() {
        return this.D;
    }

    public int t() {
        return this.F;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<CTInAppNotificationMedia> u() {
        return this.G;
    }

    public String w() {
        return this.H;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f10307w);
        parcel.writeString(this.f10297g);
        parcel.writeValue(this.f10308x);
        parcel.writeString(this.f10306t);
        parcel.writeByte(this.f10302m ? (byte) 1 : 0);
        parcel.writeByte(this.K ? (byte) 1 : 0);
        parcel.writeByte(this.f10300k ? (byte) 1 : 0);
        parcel.writeInt(this.F);
        parcel.writeInt(this.P);
        parcel.writeInt(this.O);
        parcel.writeValue(Character.valueOf(this.J));
        parcel.writeInt(this.f10303n);
        parcel.writeInt(this.f10304p);
        parcel.writeInt(this.S);
        parcel.writeInt(this.T);
        if (this.D == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.D.toString());
        }
        parcel.writeString(this.f10301l);
        if (this.f10298h == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.f10298h.toString());
        }
        if (this.f10293c == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeString(this.f10293c.toString());
        }
        parcel.writeString(this.Q);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
        parcel.writeString(this.f10294d);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeTypedList(this.f10296f);
        parcel.writeTypedList(this.G);
        parcel.writeByte(this.f10305q ? (byte) 1 : 0);
        parcel.writeInt(this.f10295e);
        parcel.writeByte(this.B ? (byte) 1 : 0);
        parcel.writeString(this.f10299j);
        parcel.writeByte(this.C ? (byte) 1 : 0);
        parcel.writeByte(this.f10310z ? (byte) 1 : 0);
        parcel.writeByte(this.f10309y ? (byte) 1 : 0);
        parcel.writeString(this.E);
        parcel.writeString(this.f10292b);
        parcel.writeLong(this.L);
    }

    /* access modifiers changed from: package-private */
    public String x() {
        return this.I;
    }

    /* access modifiers changed from: package-private */
    public char z() {
        return this.J;
    }

    CTInAppNotification() {
        this.f10296f = new ArrayList<>();
        this.G = new ArrayList<>();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(31:1|2|(1:4)(1:5)|6|(1:8)(1:9)|10|(1:12)(1:13)|14|(1:16)(1:17)|18|(1:20)(1:21)|22|(1:24)(1:25)|26|27|28|29|30|31|32|(1:34)(1:35)|36|(1:38)(1:39)|40|(1:42)(1:43)|44|(1:46)(1:47)|48|(1:50)(1:51)|52|54) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00fb */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0103 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0109 A[Catch:{ JSONException -> 0x0157 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x010b A[Catch:{ JSONException -> 0x0157 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x011a A[Catch:{ JSONException -> 0x0157 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x011c A[Catch:{ JSONException -> 0x0157 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x012b A[Catch:{ JSONException -> 0x0157 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x012d A[Catch:{ JSONException -> 0x0157 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0136 A[Catch:{ JSONException -> 0x0157 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0138 A[Catch:{ JSONException -> 0x0157 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0141 A[Catch:{ JSONException -> 0x0157 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0142 A[Catch:{ JSONException -> 0x0157 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private CTInAppNotification(android.os.Parcel r6) {
        /*
            r5 = this;
            r5.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5.f10296f = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5.G = r0
            java.lang.String r0 = r6.readString()     // Catch:{ JSONException -> 0x0157 }
            r5.f10307w = r0     // Catch:{ JSONException -> 0x0157 }
            java.lang.String r0 = r6.readString()     // Catch:{ JSONException -> 0x0157 }
            r5.f10297g = r0     // Catch:{ JSONException -> 0x0157 }
            java.lang.Class<com.clevertap.android.sdk.inapp.CTInAppType> r0 = com.clevertap.android.sdk.inapp.CTInAppType.class
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ JSONException -> 0x0157 }
            java.lang.Object r0 = r6.readValue(r0)     // Catch:{ JSONException -> 0x0157 }
            com.clevertap.android.sdk.inapp.CTInAppType r0 = (com.clevertap.android.sdk.inapp.CTInAppType) r0     // Catch:{ JSONException -> 0x0157 }
            r5.f10308x = r0     // Catch:{ JSONException -> 0x0157 }
            java.lang.String r0 = r6.readString()     // Catch:{ JSONException -> 0x0157 }
            r5.f10306t = r0     // Catch:{ JSONException -> 0x0157 }
            byte r0 = r6.readByte()     // Catch:{ JSONException -> 0x0157 }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x003b
            r0 = r1
            goto L_0x003c
        L_0x003b:
            r0 = r2
        L_0x003c:
            r5.f10302m = r0     // Catch:{ JSONException -> 0x0157 }
            byte r0 = r6.readByte()     // Catch:{ JSONException -> 0x0157 }
            if (r0 == 0) goto L_0x0046
            r0 = r1
            goto L_0x0047
        L_0x0046:
            r0 = r2
        L_0x0047:
            r5.K = r0     // Catch:{ JSONException -> 0x0157 }
            byte r0 = r6.readByte()     // Catch:{ JSONException -> 0x0157 }
            if (r0 == 0) goto L_0x0051
            r0 = r1
            goto L_0x0052
        L_0x0051:
            r0 = r2
        L_0x0052:
            r5.f10300k = r0     // Catch:{ JSONException -> 0x0157 }
            int r0 = r6.readInt()     // Catch:{ JSONException -> 0x0157 }
            r5.F = r0     // Catch:{ JSONException -> 0x0157 }
            int r0 = r6.readInt()     // Catch:{ JSONException -> 0x0157 }
            r5.P = r0     // Catch:{ JSONException -> 0x0157 }
            int r0 = r6.readInt()     // Catch:{ JSONException -> 0x0157 }
            r5.O = r0     // Catch:{ JSONException -> 0x0157 }
            java.lang.Class r0 = java.lang.Character.TYPE     // Catch:{ JSONException -> 0x0157 }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ JSONException -> 0x0157 }
            java.lang.Object r0 = r6.readValue(r0)     // Catch:{ JSONException -> 0x0157 }
            java.lang.Character r0 = (java.lang.Character) r0     // Catch:{ JSONException -> 0x0157 }
            char r0 = r0.charValue()     // Catch:{ JSONException -> 0x0157 }
            r5.J = r0     // Catch:{ JSONException -> 0x0157 }
            int r0 = r6.readInt()     // Catch:{ JSONException -> 0x0157 }
            r5.f10303n = r0     // Catch:{ JSONException -> 0x0157 }
            int r0 = r6.readInt()     // Catch:{ JSONException -> 0x0157 }
            r5.f10304p = r0     // Catch:{ JSONException -> 0x0157 }
            int r0 = r6.readInt()     // Catch:{ JSONException -> 0x0157 }
            r5.S = r0     // Catch:{ JSONException -> 0x0157 }
            int r0 = r6.readInt()     // Catch:{ JSONException -> 0x0157 }
            r5.T = r0     // Catch:{ JSONException -> 0x0157 }
            byte r0 = r6.readByte()     // Catch:{ JSONException -> 0x0157 }
            r3 = 0
            if (r0 != 0) goto L_0x0099
            r0 = r3
            goto L_0x00a2
        L_0x0099:
            org.json.b r0 = new org.json.b     // Catch:{ JSONException -> 0x0157 }
            java.lang.String r4 = r6.readString()     // Catch:{ JSONException -> 0x0157 }
            r0.<init>((java.lang.String) r4)     // Catch:{ JSONException -> 0x0157 }
        L_0x00a2:
            r5.D = r0     // Catch:{ JSONException -> 0x0157 }
            java.lang.String r0 = r6.readString()     // Catch:{ JSONException -> 0x0157 }
            r5.f10301l = r0     // Catch:{ JSONException -> 0x0157 }
            byte r0 = r6.readByte()     // Catch:{ JSONException -> 0x0157 }
            if (r0 != 0) goto L_0x00b2
            r0 = r3
            goto L_0x00bb
        L_0x00b2:
            org.json.b r0 = new org.json.b     // Catch:{ JSONException -> 0x0157 }
            java.lang.String r4 = r6.readString()     // Catch:{ JSONException -> 0x0157 }
            r0.<init>((java.lang.String) r4)     // Catch:{ JSONException -> 0x0157 }
        L_0x00bb:
            r5.f10298h = r0     // Catch:{ JSONException -> 0x0157 }
            byte r0 = r6.readByte()     // Catch:{ JSONException -> 0x0157 }
            if (r0 != 0) goto L_0x00c4
            goto L_0x00cd
        L_0x00c4:
            org.json.b r3 = new org.json.b     // Catch:{ JSONException -> 0x0157 }
            java.lang.String r0 = r6.readString()     // Catch:{ JSONException -> 0x0157 }
            r3.<init>((java.lang.String) r0)     // Catch:{ JSONException -> 0x0157 }
        L_0x00cd:
            r5.f10293c = r3     // Catch:{ JSONException -> 0x0157 }
            java.lang.String r0 = r6.readString()     // Catch:{ JSONException -> 0x0157 }
            r5.Q = r0     // Catch:{ JSONException -> 0x0157 }
            java.lang.String r0 = r6.readString()     // Catch:{ JSONException -> 0x0157 }
            r5.M = r0     // Catch:{ JSONException -> 0x0157 }
            java.lang.String r0 = r6.readString()     // Catch:{ JSONException -> 0x0157 }
            r5.N = r0     // Catch:{ JSONException -> 0x0157 }
            java.lang.String r0 = r6.readString()     // Catch:{ JSONException -> 0x0157 }
            r5.f10294d = r0     // Catch:{ JSONException -> 0x0157 }
            java.lang.String r0 = r6.readString()     // Catch:{ JSONException -> 0x0157 }
            r5.H = r0     // Catch:{ JSONException -> 0x0157 }
            java.lang.String r0 = r6.readString()     // Catch:{ JSONException -> 0x0157 }
            r5.I = r0     // Catch:{ JSONException -> 0x0157 }
            android.os.Parcelable$Creator<com.clevertap.android.sdk.inapp.CTInAppNotificationButton> r0 = com.clevertap.android.sdk.inapp.CTInAppNotificationButton.CREATOR     // Catch:{ all -> 0x00fb }
            java.util.ArrayList r0 = r6.createTypedArrayList(r0)     // Catch:{ all -> 0x00fb }
            r5.f10296f = r0     // Catch:{ all -> 0x00fb }
        L_0x00fb:
            android.os.Parcelable$Creator<com.clevertap.android.sdk.inapp.CTInAppNotificationMedia> r0 = com.clevertap.android.sdk.inapp.CTInAppNotificationMedia.CREATOR     // Catch:{ all -> 0x0103 }
            java.util.ArrayList r0 = r6.createTypedArrayList(r0)     // Catch:{ all -> 0x0103 }
            r5.G = r0     // Catch:{ all -> 0x0103 }
        L_0x0103:
            byte r0 = r6.readByte()     // Catch:{ JSONException -> 0x0157 }
            if (r0 == 0) goto L_0x010b
            r0 = r1
            goto L_0x010c
        L_0x010b:
            r0 = r2
        L_0x010c:
            r5.f10305q = r0     // Catch:{ JSONException -> 0x0157 }
            int r0 = r6.readInt()     // Catch:{ JSONException -> 0x0157 }
            r5.f10295e = r0     // Catch:{ JSONException -> 0x0157 }
            byte r0 = r6.readByte()     // Catch:{ JSONException -> 0x0157 }
            if (r0 == 0) goto L_0x011c
            r0 = r1
            goto L_0x011d
        L_0x011c:
            r0 = r2
        L_0x011d:
            r5.B = r0     // Catch:{ JSONException -> 0x0157 }
            java.lang.String r0 = r6.readString()     // Catch:{ JSONException -> 0x0157 }
            r5.f10299j = r0     // Catch:{ JSONException -> 0x0157 }
            byte r0 = r6.readByte()     // Catch:{ JSONException -> 0x0157 }
            if (r0 == 0) goto L_0x012d
            r0 = r1
            goto L_0x012e
        L_0x012d:
            r0 = r2
        L_0x012e:
            r5.C = r0     // Catch:{ JSONException -> 0x0157 }
            byte r0 = r6.readByte()     // Catch:{ JSONException -> 0x0157 }
            if (r0 == 0) goto L_0x0138
            r0 = r1
            goto L_0x0139
        L_0x0138:
            r0 = r2
        L_0x0139:
            r5.f10310z = r0     // Catch:{ JSONException -> 0x0157 }
            byte r0 = r6.readByte()     // Catch:{ JSONException -> 0x0157 }
            if (r0 == 0) goto L_0x0142
            goto L_0x0143
        L_0x0142:
            r1 = r2
        L_0x0143:
            r5.f10309y = r1     // Catch:{ JSONException -> 0x0157 }
            java.lang.String r0 = r6.readString()     // Catch:{ JSONException -> 0x0157 }
            r5.E = r0     // Catch:{ JSONException -> 0x0157 }
            java.lang.String r0 = r6.readString()     // Catch:{ JSONException -> 0x0157 }
            r5.f10292b = r0     // Catch:{ JSONException -> 0x0157 }
            long r0 = r6.readLong()     // Catch:{ JSONException -> 0x0157 }
            r5.L = r0     // Catch:{ JSONException -> 0x0157 }
        L_0x0157:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inapp.CTInAppNotification.<init>(android.os.Parcel):void");
    }
}

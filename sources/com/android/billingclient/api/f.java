package com.android.billingclient.api;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.billingclient.api.i;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzfl;
import com.google.android.gms.internal.play_billing.zzfm;
import com.google.android.gms.internal.play_billing.zzu;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;

class f extends e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public volatile int f8885a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8886b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f8887c;

    /* renamed from: d  reason: collision with root package name */
    private volatile o1 f8888d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Context f8889e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public volatile zze f8890f;

    /* renamed from: g  reason: collision with root package name */
    private volatile j0 f8891g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f8892h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f8893i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f8894j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f8895k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public boolean f8896l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f8897m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f8898n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public boolean f8899o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f8900p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f8901q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public boolean f8902r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public boolean f8903s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public boolean f8904t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public boolean f8905u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f8906v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f8907w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f8908x;

    /* renamed from: y  reason: collision with root package name */
    private ExecutorService f8909y;

    /* renamed from: z  reason: collision with root package name */
    private y0 f8910z;

    private f(Context context, boolean z10, boolean z11, s sVar, String str, String str2, c cVar) {
        this.f8885a = 0;
        this.f8887c = new Handler(Looper.getMainLooper());
        this.f8894j = 0;
        this.f8886b = str;
        k(context, sVar, z10, z11, cVar, str);
    }

    static /* bridge */ /* synthetic */ k0 F(f fVar, String str) {
        zzb.zzi("BillingClient", "Querying purchase history, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle zzc = zzb.zzc(fVar.f8897m, fVar.f8905u, fVar.f8906v, fVar.f8907w, fVar.f8886b);
        String str2 = null;
        while (fVar.f8895k) {
            try {
                Bundle zzh = fVar.f8890f.zzh(6, fVar.f8889e.getPackageName(), str, str2, zzc);
                i a10 = c1.a(zzh, "BillingClient", "getPurchaseHistory()");
                if (a10 != u0.f9022l) {
                    return new k0(a10, (List) null);
                }
                ArrayList<String> stringArrayList = zzh.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = zzh.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = zzh.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                int i10 = 0;
                while (i10 < stringArrayList2.size()) {
                    String str3 = stringArrayList2.get(i10);
                    String str4 = stringArrayList3.get(i10);
                    zzb.zzi("BillingClient", "Purchase record found for sku : ".concat(String.valueOf(stringArrayList.get(i10))));
                    try {
                        PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(str3, str4);
                        if (TextUtils.isEmpty(purchaseHistoryRecord.b())) {
                            zzb.zzj("BillingClient", "BUG: empty/null token!");
                        }
                        arrayList.add(purchaseHistoryRecord);
                        i10++;
                    } catch (JSONException e10) {
                        zzb.zzk("BillingClient", "Got an exception trying to decode the purchase!", e10);
                        return new k0(u0.f9020j, (List) null);
                    }
                }
                str2 = zzh.getString("INAPP_CONTINUATION_TOKEN");
                zzb.zzi("BillingClient", "Continuation token: ".concat(String.valueOf(str2)));
                if (TextUtils.isEmpty(str2)) {
                    return new k0(u0.f9022l, arrayList);
                }
            } catch (RemoteException e11) {
                zzb.zzk("BillingClient", "Got exception trying to get purchase history, try to reconnect", e11);
                return new k0(u0.f9023m, (List) null);
            }
        }
        zzb.zzj("BillingClient", "getPurchaseHistory is not supported on current device");
        return new k0(u0.f9027q, (List) null);
    }

    static /* bridge */ /* synthetic */ b1 H(f fVar, String str) {
        Bundle bundle;
        int i10;
        zzb.zzi("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle zzc = zzb.zzc(fVar.f8897m, fVar.f8905u, fVar.f8906v, fVar.f8907w, fVar.f8886b);
        String str2 = null;
        do {
            try {
                if (fVar.f8897m) {
                    zze zze = fVar.f8890f;
                    if (true != fVar.f8905u) {
                        i10 = 9;
                    } else {
                        i10 = 19;
                    }
                    bundle = zze.zzj(i10, fVar.f8889e.getPackageName(), str, str2, zzc);
                } else {
                    bundle = fVar.f8890f.zzi(3, fVar.f8889e.getPackageName(), str, str2);
                }
                i a10 = c1.a(bundle, "BillingClient", "getPurchase()");
                if (a10 != u0.f9022l) {
                    return new b1(a10, (List) null);
                }
                ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                int i11 = 0;
                while (i11 < stringArrayList2.size()) {
                    String str3 = stringArrayList2.get(i11);
                    String str4 = stringArrayList3.get(i11);
                    zzb.zzi("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i11))));
                    try {
                        Purchase purchase = new Purchase(str3, str4);
                        if (TextUtils.isEmpty(purchase.d())) {
                            zzb.zzj("BillingClient", "BUG: empty/null token!");
                        }
                        arrayList.add(purchase);
                        i11++;
                    } catch (JSONException e10) {
                        zzb.zzk("BillingClient", "Got an exception trying to decode the purchase!", e10);
                        return new b1(u0.f9020j, (List) null);
                    }
                }
                str2 = bundle.getString("INAPP_CONTINUATION_TOKEN");
                zzb.zzi("BillingClient", "Continuation token: ".concat(String.valueOf(str2)));
            } catch (Exception e11) {
                zzb.zzk("BillingClient", "Got exception trying to get purchasesm try to reconnect", e11);
                return new b1(u0.f9023m, (List) null);
            }
        } while (!TextUtils.isEmpty(str2));
        return new b1(u0.f9022l, arrayList);
    }

    private void k(Context context, s sVar, boolean z10, boolean z11, c cVar, String str) {
        boolean z12;
        this.f8889e = context.getApplicationContext();
        zzfl zzu = zzfm.zzu();
        zzu.zzj(str);
        zzu.zzi(this.f8889e.getPackageName());
        zzfm zzfm = (zzfm) zzu.zzc();
        this.f8910z = new y0();
        if (sVar == null) {
            zzb.zzj("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.f8888d = new o1(this.f8889e, sVar, cVar, this.f8910z);
        this.f8906v = z10;
        this.f8907w = z11;
        if (cVar != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        this.f8908x = z12;
    }

    /* access modifiers changed from: private */
    public final Handler s() {
        return Looper.myLooper() == null ? this.f8887c : new Handler(Looper.myLooper());
    }

    private final i t(i iVar) {
        if (Thread.interrupted()) {
            return iVar;
        }
        this.f8887c.post(new c0(this, iVar));
        return iVar;
    }

    /* access modifiers changed from: private */
    public final i u() {
        if (this.f8885a == 0 || this.f8885a == 3) {
            return u0.f9023m;
        }
        return u0.f9020j;
    }

    @SuppressLint({"PrivateApi"})
    private static String v() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get((Object) null);
        } catch (Exception unused) {
            return "5.2.0";
        }
    }

    /* access modifiers changed from: private */
    public final Future w(Callable callable, long j10, Runnable runnable, Handler handler) {
        if (this.f8909y == null) {
            this.f8909y = Executors.newFixedThreadPool(zzb.zza, new f0(this));
        }
        try {
            Future submit = this.f8909y.submit(callable);
            handler.postDelayed(new b0(submit, runnable), (long) (((double) j10) * 0.95d));
            return submit;
        } catch (Exception e10) {
            zzb.zzk("BillingClient", "Async task throws exception!", e10);
            return null;
        }
    }

    private final void x(String str, q qVar) {
        if (!d()) {
            qVar.a(u0.f9023m, (List<PurchaseHistoryRecord>) null);
            return;
        }
        if (w(new e0(this, str, qVar), 30000, new u1(qVar), s()) == null) {
            qVar.a(u(), (List<PurchaseHistoryRecord>) null);
        }
    }

    private final void y(String str, r rVar) {
        if (!d()) {
            rVar.a(u0.f9023m, zzu.zzk());
        } else if (TextUtils.isEmpty(str)) {
            zzb.zzj("BillingClient", "Please provide a valid product type.");
            rVar.a(u0.f9017g, zzu.zzk());
        } else {
            if (w(new d0(this, str, rVar), 30000, new a0(rVar), s()) == null) {
                rVar.a(u(), zzu.zzk());
            }
        }
    }

    private final boolean z() {
        return this.f8905u && this.f8907w;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Bundle C(int i10, String str, String str2, h hVar, Bundle bundle) throws Exception {
        return this.f8890f.zzg(i10, this.f8889e.getPackageName(), str, str2, (String) null, bundle);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Bundle D(String str, String str2) throws Exception {
        return this.f8890f.zzf(3, this.f8889e.getPackageName(), str, str2, (String) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object J(a aVar, b bVar) throws Exception {
        try {
            zze zze = this.f8890f;
            String packageName = this.f8889e.getPackageName();
            String a10 = aVar.a();
            String str = this.f8886b;
            Bundle bundle = new Bundle();
            bundle.putString("playBillingLibraryVersion", str);
            Bundle zzd = zze.zzd(9, packageName, a10, bundle);
            int zzb = zzb.zzb(zzd, "BillingClient");
            String zzf = zzb.zzf(zzd, "BillingClient");
            i.a c10 = i.c();
            c10.c(zzb);
            c10.b(zzf);
            bVar.a(c10.a());
            return null;
        } catch (Exception e10) {
            zzb.zzk("BillingClient", "Error acknowledge purchase!", e10);
            bVar.a(u0.f9023m);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object K(j jVar, k kVar) throws Exception {
        int i10;
        String str;
        String a10 = jVar.a();
        try {
            zzb.zzi("BillingClient", "Consuming purchase with token: " + a10);
            if (this.f8897m) {
                zze zze = this.f8890f;
                String packageName = this.f8889e.getPackageName();
                boolean z10 = this.f8897m;
                String str2 = this.f8886b;
                Bundle bundle = new Bundle();
                if (z10) {
                    bundle.putString("playBillingLibraryVersion", str2);
                }
                Bundle zze2 = zze.zze(9, packageName, a10, bundle);
                i10 = zze2.getInt("RESPONSE_CODE");
                str = zzb.zzf(zze2, "BillingClient");
            } else {
                i10 = this.f8890f.zza(3, this.f8889e.getPackageName(), a10);
                str = "";
            }
            i.a c10 = i.c();
            c10.c(i10);
            c10.b(str);
            i a11 = c10.a();
            if (i10 == 0) {
                zzb.zzi("BillingClient", "Successfully consumed purchase.");
                kVar.a(a11, a10);
                return null;
            }
            zzb.zzj("BillingClient", "Error consuming purchase with token. Response code: " + i10);
            kVar.a(a11, a10);
            return null;
        } catch (Exception e10) {
            zzb.zzk("BillingClient", "Error consuming purchase!", e10);
            kVar.a(u0.f9023m, a10);
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object L(com.android.billingclient.api.t r22, com.android.billingclient.api.p r23) throws java.lang.Exception {
        /*
            r21 = this;
            r1 = r21
            java.lang.String r2 = "BillingClient"
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r0 = r22.c()
            com.google.android.gms.internal.play_billing.zzu r10 = r22.b()
            int r11 = r10.size()
            r4 = 0
        L_0x0016:
            java.lang.String r14 = "Item is unavailable for purchase."
            if (r4 >= r11) goto L_0x0176
            int r8 = r4 + 20
            if (r8 <= r11) goto L_0x0020
            r5 = r11
            goto L_0x0021
        L_0x0020:
            r5 = r8
        L_0x0021:
            java.util.ArrayList r6 = new java.util.ArrayList
            java.util.List r4 = r10.subList(r4, r5)
            r6.<init>(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            int r5 = r6.size()
            r7 = 0
        L_0x0034:
            if (r7 >= r5) goto L_0x0046
            java.lang.Object r16 = r6.get(r7)
            com.android.billingclient.api.t$b r16 = (com.android.billingclient.api.t.b) r16
            java.lang.String r12 = r16.b()
            r4.add(r12)
            int r7 = r7 + 1
            goto L_0x0034
        L_0x0046:
            android.os.Bundle r12 = new android.os.Bundle
            r12.<init>()
            java.lang.String r5 = "ITEM_ID_LIST"
            r12.putStringArrayList(r5, r4)
            java.lang.String r4 = r1.f8886b
            java.lang.String r5 = "playBillingLibraryVersion"
            r12.putString(r5, r4)
            com.google.android.gms.internal.play_billing.zze r4 = r1.f8890f     // Catch:{ Exception -> 0x016b }
            android.content.Context r7 = r1.f8889e     // Catch:{ Exception -> 0x016b }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ Exception -> 0x016b }
            boolean r16 = r21.z()     // Catch:{ Exception -> 0x016b }
            java.lang.String r13 = r1.f8886b     // Catch:{ Exception -> 0x016b }
            android.os.Bundle r15 = new android.os.Bundle     // Catch:{ Exception -> 0x016b }
            r15.<init>()     // Catch:{ Exception -> 0x016b }
            r15.putString(r5, r13)     // Catch:{ Exception -> 0x016b }
            java.lang.String r5 = "enablePendingPurchases"
            r13 = 1
            r15.putBoolean(r5, r13)     // Catch:{ Exception -> 0x016b }
            java.lang.String r5 = "SKU_DETAILS_RESPONSE_FORMAT"
            java.lang.String r9 = "PRODUCT_DETAILS"
            r15.putString(r5, r9)     // Catch:{ Exception -> 0x016b }
            if (r16 == 0) goto L_0x0081
            java.lang.String r5 = "enablePendingPurchaseForSubscriptions"
            r15.putBoolean(r5, r13)     // Catch:{ Exception -> 0x016b }
        L_0x0081:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x016b }
            r5.<init>()     // Catch:{ Exception -> 0x016b }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x016b }
            r9.<init>()     // Catch:{ Exception -> 0x016b }
            int r13 = r6.size()     // Catch:{ Exception -> 0x016b }
            r1 = 0
            r17 = 0
        L_0x0092:
            if (r1 >= r13) goto L_0x00cd
            java.lang.Object r18 = r6.get(r1)     // Catch:{ Exception -> 0x016b }
            com.android.billingclient.api.t$b r18 = (com.android.billingclient.api.t.b) r18     // Catch:{ Exception -> 0x016b }
            r19 = r6
            r6 = 0
            r5.add(r6)     // Catch:{ Exception -> 0x00c9 }
            boolean r20 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x00c9 }
            r6 = 1
            r16 = r20 ^ 1
            r17 = r17 | r16
            java.lang.String r6 = r18.c()     // Catch:{ Exception -> 0x016b }
            r18 = r8
            java.lang.String r8 = "first_party"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x016b }
            if (r6 == 0) goto L_0x00c1
            java.lang.String r6 = "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products."
            r8 = 0
            com.google.android.gms.internal.play_billing.zzm.zzc(r8, r6)     // Catch:{ Exception -> 0x0168 }
            r9.add(r8)     // Catch:{ Exception -> 0x0168 }
            goto L_0x00c2
        L_0x00c1:
            r8 = 0
        L_0x00c2:
            int r1 = r1 + 1
            r8 = r18
            r6 = r19
            goto L_0x0092
        L_0x00c9:
            r0 = move-exception
            r12 = r6
            goto L_0x016d
        L_0x00cd:
            r18 = r8
            r8 = 0
            if (r17 == 0) goto L_0x00d7
            java.lang.String r1 = "SKU_OFFER_ID_TOKEN_LIST"
            r15.putStringArrayList(r1, r5)     // Catch:{ Exception -> 0x0168 }
        L_0x00d7:
            boolean r1 = r9.isEmpty()     // Catch:{ Exception -> 0x0168 }
            if (r1 != 0) goto L_0x00e2
            java.lang.String r1 = "SKU_SERIALIZED_DOCID_LIST"
            r15.putStringArrayList(r1, r9)     // Catch:{ Exception -> 0x0168 }
        L_0x00e2:
            r5 = 17
            r6 = r7
            r7 = r0
            r9 = r8
            r1 = r18
            r8 = r12
            r12 = r9
            r9 = r15
            android.os.Bundle r4 = r4.zzl(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0166 }
            if (r4 != 0) goto L_0x00fa
            java.lang.String r0 = "queryProductDetailsAsync got empty product details response."
            com.google.android.gms.internal.play_billing.zzb.zzj(r2, r0)
        L_0x00f7:
            r0 = 4
            goto L_0x017a
        L_0x00fa:
            java.lang.String r5 = "DETAILS_LIST"
            boolean r6 = r4.containsKey(r5)
            if (r6 != 0) goto L_0x0127
            int r0 = com.google.android.gms.internal.play_billing.zzb.zzb(r4, r2)
            java.lang.String r14 = com.google.android.gms.internal.play_billing.zzb.zzf(r4, r2)
            if (r0 == 0) goto L_0x0121
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "getSkuDetails() failed for queryProductDetailsAsync. Response code: "
            r1.append(r4)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            com.google.android.gms.internal.play_billing.zzb.zzj(r2, r1)
            goto L_0x017a
        L_0x0121:
            java.lang.String r0 = "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync."
            com.google.android.gms.internal.play_billing.zzb.zzj(r2, r0)
            goto L_0x0174
        L_0x0127:
            java.util.ArrayList r4 = r4.getStringArrayList(r5)
            if (r4 != 0) goto L_0x0133
            java.lang.String r0 = "queryProductDetailsAsync got null response list"
            com.google.android.gms.internal.play_billing.zzb.zzj(r2, r0)
            goto L_0x00f7
        L_0x0133:
            r5 = 0
        L_0x0134:
            int r6 = r4.size()
            if (r5 >= r6) goto L_0x0161
            java.lang.Object r6 = r4.get(r5)
            java.lang.String r6 = (java.lang.String) r6
            com.android.billingclient.api.o r7 = new com.android.billingclient.api.o     // Catch:{ JSONException -> 0x0158 }
            r7.<init>(r6)     // Catch:{ JSONException -> 0x0158 }
            java.lang.String r6 = r7.toString()
            java.lang.String r8 = "Got product details: "
            java.lang.String r6 = r8.concat(r6)
            com.google.android.gms.internal.play_billing.zzb.zzi(r2, r6)
            r3.add(r7)
            int r5 = r5 + 1
            goto L_0x0134
        L_0x0158:
            r0 = move-exception
            java.lang.String r1 = "Got a JSON exception trying to decode ProductDetails. \n Exception: "
            com.google.android.gms.internal.play_billing.zzb.zzk(r2, r1, r0)
            java.lang.String r14 = "Error trying to decode SkuDetails."
            goto L_0x0174
        L_0x0161:
            r4 = r1
            r1 = r21
            goto L_0x0016
        L_0x0166:
            r0 = move-exception
            goto L_0x016d
        L_0x0168:
            r0 = move-exception
            r12 = r8
            goto L_0x016d
        L_0x016b:
            r0 = move-exception
            r12 = 0
        L_0x016d:
            java.lang.String r1 = "queryProductDetailsAsync got a remote exception (try to reconnect)."
            com.google.android.gms.internal.play_billing.zzb.zzk(r2, r1, r0)
            java.lang.String r14 = "An internal error occurred."
        L_0x0174:
            r0 = 6
            goto L_0x017a
        L_0x0176:
            r12 = 0
            java.lang.String r14 = ""
            r0 = 0
        L_0x017a:
            com.android.billingclient.api.i$a r1 = com.android.billingclient.api.i.c()
            r1.c(r0)
            r1.b(r14)
            com.android.billingclient.api.i r0 = r1.a()
            r1 = r23
            r1.a(r0, r3)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.f.L(com.android.billingclient.api.t, com.android.billingclient.api.p):java.lang.Object");
    }

    public final void a(a aVar, b bVar) {
        if (!d()) {
            bVar.a(u0.f9023m);
        } else if (TextUtils.isEmpty(aVar.a())) {
            zzb.zzj("BillingClient", "Please provide a valid purchase token.");
            bVar.a(u0.f9019i);
        } else if (!this.f8897m) {
            bVar.a(u0.f9012b);
        } else {
            if (w(new v1(this, aVar, bVar), 30000, new x(bVar), s()) == null) {
                bVar.a(u());
            }
        }
    }

    public final void b(j jVar, k kVar) {
        if (!d()) {
            kVar.a(u0.f9023m, jVar.a());
            return;
        }
        if (w(new s1(this, jVar, kVar), 30000, new t1(kVar, jVar), s()) == null) {
            kVar.a(u(), jVar.a());
        }
    }

    public final int c() {
        return this.f8885a;
    }

    public final boolean d() {
        return (this.f8885a != 2 || this.f8890f == null || this.f8891g == null) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:185:0x047f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0481, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x049d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x049e, code lost:
        com.google.android.gms.internal.play_billing.zzb.zzk(r9, "Exception while launching billing flow. Try to reconnect", r0);
        r1 = com.android.billingclient.api.u0.f9023m;
        com.android.billingclient.api.s0.a(5, 2, r1);
        r8.t(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x04ad, code lost:
        return r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x03a9  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x03b4  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x03bc  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03f7  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x03fb  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0454 A[Catch:{ CancellationException | TimeoutException -> 0x04ae, Exception -> 0x049d }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0483 A[Catch:{ CancellationException | TimeoutException -> 0x04ae, Exception -> 0x049d }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x049d A[ExcHandler: Exception (r0v5 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:175:0x0442] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.android.billingclient.api.i e(android.app.Activity r33, com.android.billingclient.api.h r34) {
        /*
            r32 = this;
            r8 = r32
            r0 = r33
            java.lang.String r1 = "proxyPackageVersion"
            java.lang.String r9 = "BUY_INTENT"
            boolean r2 = r32.d()
            r10 = 2
            if (r2 != 0) goto L_0x0018
            com.android.billingclient.api.i r0 = com.android.billingclient.api.u0.f9023m
            com.android.billingclient.api.s0.a(r10, r10, r0)
            r8.t(r0)
            return r0
        L_0x0018:
            java.util.ArrayList r2 = r34.g()
            java.util.List r3 = r34.h()
            r4 = 0
            java.lang.Object r5 = com.google.android.gms.internal.play_billing.zzz.zza(r2, r4)
            com.android.billingclient.api.SkuDetails r5 = (com.android.billingclient.api.SkuDetails) r5
            java.lang.Object r6 = com.google.android.gms.internal.play_billing.zzz.zza(r3, r4)
            com.android.billingclient.api.h$b r6 = (com.android.billingclient.api.h.b) r6
            if (r5 == 0) goto L_0x0038
            java.lang.String r7 = r5.a()
            java.lang.String r11 = r5.b()
            goto L_0x0048
        L_0x0038:
            com.android.billingclient.api.o r7 = r6.b()
            java.lang.String r7 = r7.b()
            com.android.billingclient.api.o r11 = r6.b()
            java.lang.String r11 = r11.c()
        L_0x0048:
            java.lang.String r12 = "subs"
            boolean r12 = r11.equals(r12)
            r13 = 9
            java.lang.String r14 = "BillingClient"
            if (r12 == 0) goto L_0x0067
            boolean r12 = r8.f8892h
            if (r12 == 0) goto L_0x0059
            goto L_0x0067
        L_0x0059:
            java.lang.String r0 = "Current client doesn't support subscriptions."
            com.google.android.gms.internal.play_billing.zzb.zzj(r14, r0)
            com.android.billingclient.api.i r0 = com.android.billingclient.api.u0.f9025o
            com.android.billingclient.api.s0.a(r13, r10, r0)
            r8.t(r0)
            return r0
        L_0x0067:
            boolean r12 = r34.q()
            if (r12 == 0) goto L_0x0082
            boolean r12 = r8.f8895k
            if (r12 == 0) goto L_0x0072
            goto L_0x0082
        L_0x0072:
            java.lang.String r0 = "Current client doesn't support extra params for buy intent."
            com.google.android.gms.internal.play_billing.zzb.zzj(r14, r0)
            r0 = 18
            com.android.billingclient.api.i r1 = com.android.billingclient.api.u0.f9018h
            com.android.billingclient.api.s0.a(r0, r10, r1)
            r8.t(r1)
            return r1
        L_0x0082:
            int r12 = r2.size()
            r15 = 1
            if (r12 <= r15) goto L_0x009e
            boolean r12 = r8.f8902r
            if (r12 == 0) goto L_0x008e
            goto L_0x009e
        L_0x008e:
            java.lang.String r0 = "Current client doesn't support multi-item purchases."
            com.google.android.gms.internal.play_billing.zzb.zzj(r14, r0)
            r0 = 19
            com.android.billingclient.api.i r1 = com.android.billingclient.api.u0.f9030t
            com.android.billingclient.api.s0.a(r0, r10, r1)
            r8.t(r1)
            return r1
        L_0x009e:
            boolean r12 = r3.isEmpty()
            if (r12 != 0) goto L_0x00b9
            boolean r12 = r8.f8903s
            if (r12 == 0) goto L_0x00a9
            goto L_0x00b9
        L_0x00a9:
            java.lang.String r0 = "Current client doesn't support purchases with ProductDetails."
            com.google.android.gms.internal.play_billing.zzb.zzj(r14, r0)
            r0 = 20
            com.android.billingclient.api.i r1 = com.android.billingclient.api.u0.f9032v
            com.android.billingclient.api.s0.a(r0, r10, r1)
            r8.t(r1)
            return r1
        L_0x00b9:
            boolean r12 = r8.f8895k
            if (r12 == 0) goto L_0x0429
            boolean r12 = r8.f8897m
            boolean r13 = r8.f8905u
            boolean r10 = r8.f8906v
            boolean r4 = r8.f8907w
            boolean r15 = r8.f8908x
            r17 = r9
            java.lang.String r9 = r8.f8886b
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            r18 = r11
            java.lang.String r11 = "playBillingLibraryVersion"
            r0.putString(r11, r9)
            int r9 = r34.b()
            if (r9 == 0) goto L_0x00e6
            int r9 = r34.b()
            java.lang.String r11 = "prorationMode"
            r0.putInt(r11, r9)
        L_0x00e6:
            java.lang.String r9 = r34.c()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x00f9
            java.lang.String r9 = r34.c()
            java.lang.String r11 = "accountId"
            r0.putString(r11, r9)
        L_0x00f9:
            java.lang.String r9 = r34.d()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x010c
            java.lang.String r9 = r34.d()
            java.lang.String r11 = "obfuscatedProfileId"
            r0.putString(r11, r9)
        L_0x010c:
            boolean r9 = r34.p()
            if (r9 == 0) goto L_0x0118
            java.lang.String r9 = "isOfferPersonalizedByDeveloper"
            r11 = 1
            r0.putBoolean(r9, r11)
        L_0x0118:
            r9 = 0
            boolean r11 = android.text.TextUtils.isEmpty(r9)
            if (r11 != 0) goto L_0x0131
            java.util.ArrayList r11 = new java.util.ArrayList
            java.lang.String[] r19 = new java.lang.String[]{r9}
            java.util.List r9 = java.util.Arrays.asList(r19)
            r11.<init>(r9)
            java.lang.String r9 = "skusToReplace"
            r0.putStringArrayList(r9, r11)
        L_0x0131:
            java.lang.String r9 = r34.e()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0144
            java.lang.String r9 = r34.e()
            java.lang.String r11 = "oldSkuPurchaseToken"
            r0.putString(r11, r9)
        L_0x0144:
            r9 = 0
            boolean r11 = android.text.TextUtils.isEmpty(r9)
            if (r11 != 0) goto L_0x0150
            java.lang.String r11 = "oldSkuPurchaseId"
            r0.putString(r11, r9)
        L_0x0150:
            java.lang.String r11 = r34.f()
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x0164
            java.lang.String r11 = r34.f()
            java.lang.String r9 = "originalExternalTransactionId"
            r0.putString(r9, r11)
            r9 = 0
        L_0x0164:
            boolean r11 = android.text.TextUtils.isEmpty(r9)
            if (r11 != 0) goto L_0x016f
            java.lang.String r11 = "paymentsPurchaseParams"
            r0.putString(r11, r9)
        L_0x016f:
            if (r12 == 0) goto L_0x017a
            if (r10 == 0) goto L_0x017a
            java.lang.String r9 = "enablePendingPurchases"
            r10 = 1
            r0.putBoolean(r9, r10)
            goto L_0x017b
        L_0x017a:
            r10 = 1
        L_0x017b:
            if (r13 == 0) goto L_0x0184
            if (r4 == 0) goto L_0x0184
            java.lang.String r4 = "enablePendingPurchaseForSubscriptions"
            r0.putBoolean(r4, r10)
        L_0x0184:
            if (r15 == 0) goto L_0x018b
            java.lang.String r4 = "enableAlternativeBilling"
            r0.putBoolean(r4, r10)
        L_0x018b:
            boolean r4 = r2.isEmpty()
            java.lang.String r9 = "additionalSkuTypes"
            java.lang.String r10 = "additionalSkus"
            java.lang.String r11 = "SKU_SERIALIZED_DOCID_LIST"
            java.lang.String r12 = "skuDetailsTokens"
            java.lang.String r13 = "SKU_OFFER_ID_TOKEN_LIST"
            if (r4 != 0) goto L_0x02a1
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            r20 = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r21 = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r22 = r14
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Iterator r23 = r2.iterator()
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
        L_0x01c6:
            boolean r28 = r23.hasNext()
            if (r28 == 0) goto L_0x0233
            java.lang.Object r28 = r23.next()
            com.android.billingclient.api.SkuDetails r28 = (com.android.billingclient.api.SkuDetails) r28
            java.lang.String r29 = r28.h()
            boolean r29 = r29.isEmpty()
            if (r29 != 0) goto L_0x01e6
            r29 = r6
            java.lang.String r6 = r28.h()
            r4.add(r6)
            goto L_0x01e8
        L_0x01e6:
            r29 = r6
        L_0x01e8:
            java.lang.String r6 = r28.e()
            r30 = r5
            java.lang.String r5 = r28.d()
            int r31 = r28.c()
            java.lang.String r8 = r28.g()
            r15.add(r6)
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            r16 = 1
            r6 = r6 ^ 1
            r24 = r24 | r6
            r7.add(r5)
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            r5 = r5 ^ 1
            r25 = r25 | r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r31)
            r1.add(r5)
            if (r31 == 0) goto L_0x021e
            r5 = r16
            goto L_0x021f
        L_0x021e:
            r5 = 0
        L_0x021f:
            r26 = r26 | r5
            boolean r5 = android.text.TextUtils.isEmpty(r8)
            r5 = r5 ^ 1
            r27 = r27 | r5
            r14.add(r8)
            r8 = r32
            r6 = r29
            r5 = r30
            goto L_0x01c6
        L_0x0233:
            r30 = r5
            r29 = r6
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x0240
            r0.putStringArrayList(r12, r4)
        L_0x0240:
            if (r24 == 0) goto L_0x0245
            r0.putStringArrayList(r13, r15)
        L_0x0245:
            if (r25 == 0) goto L_0x024c
            java.lang.String r4 = "SKU_OFFER_ID_LIST"
            r0.putStringArrayList(r4, r7)
        L_0x024c:
            if (r26 == 0) goto L_0x0253
            java.lang.String r4 = "SKU_OFFER_TYPE_LIST"
            r0.putIntegerArrayList(r4, r1)
        L_0x0253:
            if (r27 == 0) goto L_0x0258
            r0.putStringArrayList(r11, r14)
        L_0x0258:
            int r1 = r2.size()
            r4 = 1
            if (r1 <= r4) goto L_0x0354
            java.util.ArrayList r1 = new java.util.ArrayList
            int r5 = r2.size()
            int r5 = r5 + -1
            r1.<init>(r5)
            java.util.ArrayList r5 = new java.util.ArrayList
            int r6 = r2.size()
            int r6 = r6 + -1
            r5.<init>(r6)
            r11 = r4
        L_0x0276:
            int r6 = r2.size()
            if (r11 >= r6) goto L_0x0299
            java.lang.Object r6 = r2.get(r11)
            com.android.billingclient.api.SkuDetails r6 = (com.android.billingclient.api.SkuDetails) r6
            java.lang.String r6 = r6.a()
            r1.add(r6)
            java.lang.Object r6 = r2.get(r11)
            com.android.billingclient.api.SkuDetails r6 = (com.android.billingclient.api.SkuDetails) r6
            java.lang.String r6 = r6.b()
            r5.add(r6)
            int r11 = r11 + 1
            goto L_0x0276
        L_0x0299:
            r0.putStringArrayList(r10, r1)
            r0.putStringArrayList(r9, r5)
            goto L_0x0354
        L_0x02a1:
            r21 = r1
            r30 = r5
            r29 = r6
            r20 = r7
            r22 = r14
            r4 = 1
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r3.size()
            int r2 = r2 + -1
            r1.<init>(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r5 = r3.size()
            int r5 = r5 + -1
            r2.<init>(r5)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r8 = 0
        L_0x02d2:
            int r14 = r3.size()
            if (r8 >= r14) goto L_0x0333
            java.lang.Object r14 = r3.get(r8)
            com.android.billingclient.api.h$b r14 = (com.android.billingclient.api.h.b) r14
            com.android.billingclient.api.o r15 = r14.b()
            java.lang.String r16 = r15.f()
            boolean r16 = r16.isEmpty()
            if (r16 != 0) goto L_0x02f3
            java.lang.String r4 = r15.f()
            r5.add(r4)
        L_0x02f3:
            java.lang.String r4 = r14.c()
            r6.add(r4)
            java.lang.String r4 = r15.g()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x030b
            java.lang.String r4 = r15.g()
            r7.add(r4)
        L_0x030b:
            if (r8 <= 0) goto L_0x032f
            java.lang.Object r4 = r3.get(r8)
            com.android.billingclient.api.h$b r4 = (com.android.billingclient.api.h.b) r4
            com.android.billingclient.api.o r4 = r4.b()
            java.lang.String r4 = r4.b()
            r1.add(r4)
            java.lang.Object r4 = r3.get(r8)
            com.android.billingclient.api.h$b r4 = (com.android.billingclient.api.h.b) r4
            com.android.billingclient.api.o r4 = r4.b()
            java.lang.String r4 = r4.c()
            r2.add(r4)
        L_0x032f:
            int r8 = r8 + 1
            r4 = 1
            goto L_0x02d2
        L_0x0333:
            r0.putStringArrayList(r13, r6)
            boolean r4 = r5.isEmpty()
            if (r4 != 0) goto L_0x033f
            r0.putStringArrayList(r12, r5)
        L_0x033f:
            boolean r4 = r7.isEmpty()
            if (r4 != 0) goto L_0x0348
            r0.putStringArrayList(r11, r7)
        L_0x0348:
            boolean r4 = r1.isEmpty()
            if (r4 != 0) goto L_0x0354
            r0.putStringArrayList(r10, r1)
            r0.putStringArrayList(r9, r2)
        L_0x0354:
            boolean r1 = r0.containsKey(r13)
            r8 = r32
            if (r1 == 0) goto L_0x036d
            boolean r1 = r8.f8900p
            if (r1 == 0) goto L_0x0361
            goto L_0x036d
        L_0x0361:
            r0 = 21
            com.android.billingclient.api.i r1 = com.android.billingclient.api.u0.f9031u
            r2 = 2
            com.android.billingclient.api.s0.a(r0, r2, r1)
            r8.t(r1)
            return r1
        L_0x036d:
            java.lang.String r1 = "skuPackageName"
            if (r30 == 0) goto L_0x0385
            java.lang.String r2 = r30.f()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0385
            java.lang.String r2 = r30.f()
            r0.putString(r1, r2)
        L_0x0382:
            r1 = 0
            r15 = 1
            goto L_0x03a3
        L_0x0385:
            if (r29 == 0) goto L_0x03a1
            com.android.billingclient.api.o r2 = r29.b()
            java.lang.String r2 = r2.e()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x03a1
            com.android.billingclient.api.o r2 = r29.b()
            java.lang.String r2 = r2.e()
            r0.putString(r1, r2)
            goto L_0x0382
        L_0x03a1:
            r1 = 0
            r15 = 0
        L_0x03a3:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x03ae
            java.lang.String r2 = "accountName"
            r0.putString(r2, r1)
        L_0x03ae:
            android.content.Intent r1 = r33.getIntent()
            if (r1 != 0) goto L_0x03bc
            java.lang.String r1 = "Activity's intent is null."
            r9 = r22
            com.google.android.gms.internal.play_billing.zzb.zzj(r9, r1)
            goto L_0x03ed
        L_0x03bc:
            r9 = r22
            java.lang.String r2 = "PROXY_PACKAGE"
            java.lang.String r4 = r1.getStringExtra(r2)
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x03ed
            java.lang.String r1 = r1.getStringExtra(r2)
            java.lang.String r2 = "proxyPackage"
            r0.putString(r2, r1)
            android.content.Context r2 = r8.f8889e     // Catch:{ NameNotFoundException -> 0x03e6 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ NameNotFoundException -> 0x03e6 }
            r4 = 0
            android.content.pm.PackageInfo r1 = r2.getPackageInfo(r1, r4)     // Catch:{ NameNotFoundException -> 0x03e6 }
            java.lang.String r1 = r1.versionName     // Catch:{ NameNotFoundException -> 0x03e6 }
            r2 = r21
            r0.putString(r2, r1)     // Catch:{ NameNotFoundException -> 0x03e8 }
            goto L_0x03ed
        L_0x03e6:
            r2 = r21
        L_0x03e8:
            java.lang.String r1 = "package not found"
            r0.putString(r2, r1)
        L_0x03ed:
            boolean r1 = r8.f8903s
            if (r1 == 0) goto L_0x03fb
            boolean r1 = r3.isEmpty()
            if (r1 != 0) goto L_0x03fb
            r1 = 17
        L_0x03f9:
            r3 = r1
            goto L_0x040d
        L_0x03fb:
            boolean r1 = r8.f8901q
            if (r1 == 0) goto L_0x0404
            if (r15 == 0) goto L_0x0404
            r1 = 15
            goto L_0x03f9
        L_0x0404:
            boolean r1 = r8.f8897m
            if (r1 == 0) goto L_0x040b
            r3 = 9
            goto L_0x040d
        L_0x040b:
            r1 = 6
            goto L_0x03f9
        L_0x040d:
            com.android.billingclient.api.y r10 = new com.android.billingclient.api.y
            r1 = r10
            r2 = r32
            r4 = r20
            r5 = r18
            r6 = r34
            r7 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r3 = 5000(0x1388, double:2.4703E-320)
            r5 = 0
            android.os.Handler r6 = r8.f8887c
            r1 = r32
            r2 = r10
            java.util.concurrent.Future r0 = r1.w(r2, r3, r5, r6)
            goto L_0x0440
        L_0x0429:
            r20 = r7
            r17 = r9
            r18 = r11
            r9 = r14
            com.android.billingclient.api.z r2 = new com.android.billingclient.api.z
            r2.<init>(r8, r7, r11)
            r3 = 5000(0x1388, double:2.4703E-320)
            r5 = 0
            android.os.Handler r6 = r8.f8887c
            r1 = r32
            java.util.concurrent.Future r0 = r1.w(r2, r3, r5, r6)
        L_0x0440:
            r1 = 5000(0x1388, double:2.4703E-320)
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            java.lang.Object r0 = r0.get(r1, r3)     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            int r1 = com.google.android.gms.internal.play_billing.zzb.zzb(r0, r9)     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            java.lang.String r2 = com.google.android.gms.internal.play_billing.zzb.zzf(r0, r9)     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            if (r1 == 0) goto L_0x0483
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            r0.<init>()     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            java.lang.String r3 = "Unable to buy item, Error response code: "
            r0.append(r3)     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            r0.append(r1)     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            java.lang.String r0 = r0.toString()     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            com.google.android.gms.internal.play_billing.zzb.zzj(r9, r0)     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            com.android.billingclient.api.i$a r0 = com.android.billingclient.api.i.c()     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            r0.c(r1)     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            r0.b(r2)     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            com.android.billingclient.api.i r0 = r0.a()     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            r1 = 3
            r2 = 2
            com.android.billingclient.api.s0.a(r1, r2, r0)     // Catch:{ TimeoutException -> 0x0481, CancellationException -> 0x047f, Exception -> 0x049d }
            r8.t(r0)     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            return r0
        L_0x047f:
            r0 = move-exception
            goto L_0x04b2
        L_0x0481:
            r0 = move-exception
            goto L_0x04b2
        L_0x0483:
            android.content.Intent r1 = new android.content.Intent     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            java.lang.Class<com.android.billingclient.api.ProxyBillingActivity> r2 = com.android.billingclient.api.ProxyBillingActivity.class
            r3 = r33
            r1.<init>(r3, r2)     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            r2 = r17
            android.os.Parcelable r0 = r0.getParcelable(r2)     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            android.app.PendingIntent r0 = (android.app.PendingIntent) r0     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            r1.putExtra(r2, r0)     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            r3.startActivity(r1)     // Catch:{ TimeoutException -> 0x04b0, CancellationException -> 0x04ae, Exception -> 0x049d }
            com.android.billingclient.api.i r0 = com.android.billingclient.api.u0.f9022l
            return r0
        L_0x049d:
            r0 = move-exception
            java.lang.String r1 = "Exception while launching billing flow. Try to reconnect"
            com.google.android.gms.internal.play_billing.zzb.zzk(r9, r1, r0)
            r0 = 5
            com.android.billingclient.api.i r1 = com.android.billingclient.api.u0.f9023m
            r2 = 2
            com.android.billingclient.api.s0.a(r0, r2, r1)
            r8.t(r1)
            return r1
        L_0x04ae:
            r0 = move-exception
            goto L_0x04b1
        L_0x04b0:
            r0 = move-exception
        L_0x04b1:
            r2 = 2
        L_0x04b2:
            java.lang.String r1 = "Time out while launching billing flow. Try to reconnect"
            com.google.android.gms.internal.play_billing.zzb.zzk(r9, r1, r0)
            r0 = 4
            com.android.billingclient.api.i r1 = com.android.billingclient.api.u0.f9024n
            com.android.billingclient.api.s0.a(r0, r2, r1)
            r8.t(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.f.e(android.app.Activity, com.android.billingclient.api.h):com.android.billingclient.api.i");
    }

    public void g(t tVar, p pVar) {
        if (!d()) {
            pVar.a(u0.f9023m, new ArrayList());
        } else if (!this.f8903s) {
            zzb.zzj("BillingClient", "Querying product details is not supported.");
            pVar.a(u0.f9032v, new ArrayList());
        } else {
            if (w(new q1(this, tVar, pVar), 30000, new r1(pVar), s()) == null) {
                pVar.a(u(), new ArrayList());
            }
        }
    }

    public void h(u uVar, q qVar) {
        x(uVar.b(), qVar);
    }

    public void i(v vVar, r rVar) {
        y(vVar.b(), rVar);
    }

    public final void j(g gVar) {
        ServiceInfo serviceInfo;
        if (d()) {
            zzb.zzi("BillingClient", "Service connection is valid. No need to re-initialize.");
            gVar.a(u0.f9022l);
        } else if (this.f8885a == 1) {
            zzb.zzj("BillingClient", "Client is already in the process of connecting to billing service.");
            gVar.a(u0.f9014d);
        } else if (this.f8885a == 3) {
            zzb.zzj("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            gVar.a(u0.f9023m);
        } else {
            this.f8885a = 1;
            this.f8888d.d();
            zzb.zzi("BillingClient", "Starting in-app billing setup.");
            this.f8891g = new j0(this, gVar, (i0) null);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            List<ResolveInfo> queryIntentServices = this.f8889e.getPackageManager().queryIntentServices(intent, 0);
            if (!(queryIntentServices == null || queryIntentServices.isEmpty() || (serviceInfo = queryIntentServices.get(0).serviceInfo) == null)) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    zzb.zzj("BillingClient", "The device doesn't have valid Play Store.");
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.f8886b);
                    if (this.f8889e.bindService(intent2, this.f8891g, 1)) {
                        zzb.zzi("BillingClient", "Service was bonded successfully.");
                        return;
                    }
                    zzb.zzj("BillingClient", "Connection to Billing service is blocked.");
                }
            }
            this.f8885a = 0;
            zzb.zzi("BillingClient", "Billing service unavailable on device.");
            gVar.a(u0.f9013c);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void r(i iVar) {
        if (this.f8888d.c() != null) {
            this.f8888d.c().a(iVar, (List<Purchase>) null);
            return;
        }
        this.f8888d.b();
        zzb.zzj("BillingClient", "No valid listener is set in BroadcastManager");
    }

    f(String str, boolean z10, Context context, x0 x0Var) {
        this.f8885a = 0;
        this.f8887c = new Handler(Looper.getMainLooper());
        this.f8894j = 0;
        this.f8886b = v();
        this.f8889e = context.getApplicationContext();
        zzfl zzu = zzfm.zzu();
        zzu.zzj(v());
        zzu.zzi(this.f8889e.getPackageName());
        zzfm zzfm = (zzfm) zzu.zzc();
        this.f8910z = new y0();
        zzb.zzj("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.f8888d = new o1(this.f8889e, (x0) null, this.f8910z);
        this.f8906v = z10;
    }

    f(String str, boolean z10, boolean z11, Context context, s sVar, c cVar) {
        this(context, z10, false, sVar, v(), (String) null, cVar);
    }
}

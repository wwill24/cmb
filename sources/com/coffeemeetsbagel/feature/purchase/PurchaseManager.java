package com.coffeemeetsbagel.feature.purchase;

import a7.a;
import android.os.Bundle;
import android.text.TextUtils;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.coffeemeetsbagel.components.AuthenticationScopeProvider;
import com.coffeemeetsbagel.feature.profile.ProfileContract$Manager;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import com.coffeemeetsbagel.feature.purchase.requests.DiscoverLikesPurchaseRequest;
import com.coffeemeetsbagel.feature.purchase.requests.DiscoverSearchTakePurchaseRequest;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.store.PriceRepository;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.alc.models.PurchaseRequest;
import com.coffeemeetsbagel.store.j0;
import com.coffeemeetsbagel.store.k0;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.d;
import com.google.gson.e;
import com.google.gson.j;
import com.uber.autodispose.m;
import com.uber.autodispose.t;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.mam.element.MamElements;
import qj.q;

public class PurchaseManager implements k0 {
    public static final String TAG = "PurchaseManager";
    private final a analyticsManager;
    private final AuthenticationScopeProvider authenticationScopeProvider;
    private final PriceRepository priceRepository;
    private final ProfileContract$Manager profileManager;
    private final PurchaseApi purchaseApi;

    public PurchaseManager(PriceRepository priceRepository2, ProfileManager profileManager2, a aVar, PurchaseApi purchaseApi2, AuthenticationScopeProvider authenticationScopeProvider2) {
        this.priceRepository = priceRepository2;
        this.profileManager = profileManager2;
        this.analyticsManager = aVar;
        this.purchaseApi = purchaseApi2;
        this.authenticationScopeProvider = authenticationScopeProvider2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$buyCmbItem$0(Map map, String str, long j10, k0.b bVar, Class cls, j jVar) throws Exception {
        map.put(MamElements.MamResultExtension.ELEMENT, "succeeded");
        this.analyticsManager.j("Purchased Item", map);
        sendPurchaseCMBItemEventToAppsFlyer(str, j10);
        d b10 = new e().c(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).b();
        this.profileManager.e(new Bundle(), (v8.a) null);
        refreshPricesFromApi((k0.a) null);
        bVar.b(b10.g(jVar.d(), cls));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$buyCmbItem$1(k0.b bVar, Map map, Throwable th2) throws Exception {
        bVar.a(th2);
        map.put(MamElements.MamResultExtension.ELEMENT, StreamManagement.Failed.ELEMENT);
        this.analyticsManager.j("Purchased Item", map);
        refreshPricesFromApi((k0.a) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$buyCmbItem$2(Map map, String str, long j10, boolean z10, k0.b bVar, Class cls, j jVar) throws Exception {
        map.put(MamElements.MamResultExtension.ELEMENT, "succeeded");
        this.analyticsManager.j("Purchased Item", map);
        sendPurchaseCMBItemEventToAppsFlyer(str, j10);
        this.profileManager.f();
        this.profileManager.e(new Bundle(), (v8.a) null);
        if (z10) {
            refreshPricesFromApi((k0.a) null);
        }
        bVar.b(new d().g(jVar.d(), cls));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$buyCmbItem$3(k0.b bVar, Map map, Throwable th2) throws Exception {
        bVar.a(th2);
        map.put(MamElements.MamResultExtension.ELEMENT, StreamManagement.Failed.ELEMENT);
        this.analyticsManager.j("Purchased Item", map);
        refreshPricesFromApi((k0.a) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$refreshPricesFromApi$4(k0.a aVar) throws Exception {
        if (aVar != null) {
            aVar.onSuccess();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$refreshPricesFromApi$5(k0.a aVar, Throwable th2) throws Exception {
        fa.a.g(TAG, "failed to refresh prices", th2);
        if (aVar != null) {
            aVar.onFailure();
        }
    }

    private void sendPurchaseCMBItemEventToAppsFlyer(String str, long j10) {
        HashMap hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.CONTENT_ID, str);
        hashMap.put(AFInAppEventParameterName.PRICE, String.valueOf(j10));
        this.analyticsManager.trackEvent(AFInAppEventType.SPENT_CREDIT, hashMap);
    }

    public <T> void buyCmbItem(PurchaseType purchaseType, long j10, int i10, k0.b<T, Throwable> bVar, Class cls, String str, String str2) {
        String str3 = str2;
        String d10 = purchaseType.d();
        HashMap hashMap = new HashMap();
        hashMap.put("item", purchaseType.a());
        hashMap.put("beans", String.valueOf(j10));
        hashMap.put(FirebaseAnalytics.Param.QUANTITY, String.valueOf(i10));
        long j11 = j10;
        PurchaseRequest purchaseRequest = new PurchaseRequest(d10, j10, i10);
        if (!TextUtils.isEmpty(str)) {
            purchaseRequest.setBagelId(str);
        } else if (!TextUtils.isEmpty(str2)) {
            if (d10.equals(PurchaseType.DISCOVER_SEARCH_RESULT.d())) {
                purchaseRequest.setDiscoverSearchResultId(str3);
            } else {
                purchaseRequest.setGiveTenId(str3);
            }
        }
        ((t) this.purchaseApi.purchase(purchaseRequest).K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this.authenticationScopeProvider))).b(new e(this, hashMap, d10, j10, bVar, cls), new f(this, bVar, hashMap));
    }

    public void clear() {
        this.priceRepository.f();
    }

    public Price getPrice(PurchaseType purchaseType) {
        return this.priceRepository.g(purchaseType);
    }

    public q<Map<String, Price>> priceCache() {
        return this.priceRepository.l();
    }

    public void refreshPricesFromApi(k0.a aVar) {
        ((m) this.priceRepository.n().j(com.uber.autodispose.a.a(this.authenticationScopeProvider))).f(new c(aVar), new d(aVar));
    }

    public <T, E extends Throwable> void buyCmbItem(j0<T> j0Var, k0.b<T, E> bVar, boolean z10) {
        long expectedPrice = j0Var.getExpectedPrice();
        int itemCount = j0Var.getItemCount();
        String cmbName = j0Var.getCmbName();
        Class listenerType = j0Var.getListenerType();
        HashMap hashMap = new HashMap();
        hashMap.put("item", j0Var.getAnalyticsItemName());
        hashMap.put("beans", String.valueOf(expectedPrice));
        hashMap.put(FirebaseAnalytics.Param.QUANTITY, String.valueOf(itemCount));
        PurchaseRequest purchaseRequest = new PurchaseRequest(cmbName, expectedPrice, itemCount);
        if (j0Var instanceof DiscoverSearchTakePurchaseRequest) {
            purchaseRequest.setDiscoverSearchResultId(((DiscoverSearchTakePurchaseRequest) j0Var).getGiveTakeId());
        } else if (j0Var instanceof DiscoverLikesPurchaseRequest) {
            purchaseRequest.setGiveTenId(((DiscoverLikesPurchaseRequest) j0Var).getGiveTakeId());
        }
        ((t) this.purchaseApi.purchase(purchaseRequest).K(dk.a.c()).E(sj.a.a()).g(com.uber.autodispose.a.a(this.authenticationScopeProvider))).b(new a(this, hashMap, cmbName, expectedPrice, z10, bVar, listenerType), new b(this, bVar, hashMap));
    }
}

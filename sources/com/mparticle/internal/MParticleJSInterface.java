package com.mparticle.internal;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.mparticle.BaseEvent;
import com.mparticle.MPEvent;
import com.mparticle.MParticle;
import com.mparticle.commerce.CommerceEvent;
import com.mparticle.commerce.Impression;
import com.mparticle.commerce.Product;
import com.mparticle.commerce.Promotion;
import com.mparticle.commerce.TransactionAttributes;
import com.mparticle.identity.IdentityApi;
import com.mparticle.identity.IdentityApiRequest;
import com.mparticle.identity.MParticleUser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.bytebuddy.utility.JavaConstant;
import org.json.JSONException;

public class MParticleJSInterface {
    private static final String AFFILIATION = "Affiliation";
    private static final String ATTRIBUTES = "Attributes";
    private static final String BRAND = "Brand";
    private static final String CATEGORY = "Category";
    private static final String CHECKOUT_OPTIONS = "CheckoutOptions";
    private static final String CHECKOUT_STEP = "CheckoutStep";
    private static final String COUPON_CODE = "CouponCode";
    private static final String CURRENCY_CODE = "CurrencyCode";
    private static final String EVENT_NAME = "EventName";
    protected static final String IDENTITY = "Identity";
    public static final String INTERFACE_BASE_NAME = "mParticleAndroid";
    protected static final String JS_KEY_EVENT_ATTRIBUTES = "EventAttributes";
    protected static final String JS_KEY_EVENT_CATEGORY = "EventCategory";
    protected static final String JS_KEY_EVENT_DATATYPE = "EventDataType";
    protected static final String JS_KEY_EVENT_FLAGS = "CustomFlags";
    protected static final String JS_KEY_EVENT_NAME = "EventName";
    protected static final String JS_KEY_OPTOUT = "OptOut";
    protected static final int JS_MSG_TYPE_COMMERCE = 16;
    protected static final int JS_MSG_TYPE_CR = 5;
    protected static final int JS_MSG_TYPE_OO = 6;
    protected static final int JS_MSG_TYPE_PE = 4;
    protected static final int JS_MSG_TYPE_PV = 3;
    protected static final int JS_MSG_TYPE_SE = 2;
    protected static final int JS_MSG_TYPE_SS = 1;
    private static final String NAME = "Name";
    private static final String POSITION = "Position";
    private static final String PRICE = "Price";
    private static final String PRODUCT_ACTION = "ProductAction";
    private static final String PRODUCT_ACTION_TYPE = "ProductActionType";
    private static final String PRODUCT_IMPRESSIONS = "ProductImpressions";
    private static final String PRODUCT_IMPRESSION_NAME = "ProductImpressionList";
    private static final String PRODUCT_LIST = "ProductList";
    private static final String PROMOTION_ACTION = "PromotionAction";
    private static final String PROMOTION_ACTION_TYPE = "PromotionActionType";
    private static final String PROMOTION_CREATIVE = "Creative";
    private static final String PROMOTION_ID = "Id";
    private static final String PROMOTION_LIST = "PromotionList";
    private static final String PROMOTION_NAME = "Name";
    private static final String PROMOTION_POSITION = "Position";
    private static final String QUANTITY = "Quantity";
    private static final String SHIPPING_AMOUNT = "ShippingAmount";
    private static final String SKU = "Sku";
    private static final String TAX_AMOUNT = "TaxAmount";
    private static final String TOTAL_AMOUNT = "TotalAmount";
    private static final String TRANSACTION_ID = "TransactionId";
    protected static final String TYPE = "Type";
    protected static final String USER_IDENTITIES = "UserIdentities";
    protected static final String USER_IDENTITY = "UserIdentity";
    private static final String VARIANT = "Variant";
    private static final String errorMsg = "Error processing JSON data from Webview: %s";

    class a implements Product.EqualityComparator {
        a() {
        }

        public boolean equals(Product product, Product product2) {
            if (product.getSku() != null) {
                return product.getSku().equals(product2.getSku());
            }
            if (product2.getSku() == null) {
                return true;
            }
            return false;
        }
    }

    class b extends IdentityApi.k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22364a;

        b(String str) {
            this.f22364a = str;
        }

        public void a(MParticleUser mParticleUser) {
            mParticleUser.setUserTag(this.f22364a);
        }
    }

    class c extends IdentityApi.k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22366a;

        c(String str) {
            this.f22366a = str;
        }

        public void a(MParticleUser mParticleUser) {
            mParticleUser.removeUserAttribute(this.f22366a);
        }
    }

    class d extends IdentityApi.k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22368a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f22369b;

        d(String str, Object obj) {
            this.f22368a = str;
            this.f22369b = obj;
        }

        public void a(MParticleUser mParticleUser) {
            mParticleUser.setUserAttribute(this.f22368a, String.valueOf(this.f22369b));
        }
    }

    class e extends IdentityApi.k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22371a;

        e(String str) {
            this.f22371a = str;
        }

        public void a(MParticleUser mParticleUser) {
            mParticleUser.removeUserAttribute(this.f22371a);
        }
    }

    class f extends IdentityApi.k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f22373a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f22374b;

        f(String str, List list) {
            this.f22373a = str;
            this.f22374b = list;
        }

        public void a(MParticleUser mParticleUser) {
            mParticleUser.setUserAttributeList(this.f22373a, this.f22374b);
        }
    }

    class g extends IdentityApi.k {
        g() {
        }

        public void a(MParticleUser mParticleUser) {
            for (String removeUserAttribute : mParticleUser.getUserAttributes().keySet()) {
                mParticleUser.removeUserAttribute(removeUserAttribute);
            }
        }
    }

    public MParticleJSInterface() {
        Product.setEqualityComparator(new a());
    }

    protected static Map<String, List<String>> convertToListMap(org.json.b bVar) {
        if (bVar == null) {
            return null;
        }
        Iterator<String> keys = bVar.keys();
        HashMap hashMap = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                org.json.a optJSONArray = bVar.optJSONArray(next);
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i10 = 0; i10 < optJSONArray.o(); i10++) {
                        try {
                            arrayList.add(optJSONArray.n(i10));
                        } catch (JSONException unused) {
                            Logger.warning("Could not parse custom flag array value.");
                        }
                    }
                    hashMap.put(next, arrayList);
                } else {
                    hashMap.put(next, Collections.singletonList(bVar.getString(next)));
                }
            } catch (Exception e10) {
                Logger.warning(e10, "Could not parse custom flag value.");
            }
        }
        return hashMap;
    }

    protected static Map<String, String> convertToMap(org.json.b bVar) {
        if (bVar == null) {
            return null;
        }
        Iterator<String> keys = bVar.keys();
        HashMap hashMap = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                hashMap.put(next, bVar.getString(next));
            } catch (JSONException e10) {
                Logger.warning(e10, "Could not parse attribute value.");
            }
        }
        return hashMap;
    }

    static String getBridgeName(String str) {
        StringBuilder sb2 = new StringBuilder(INTERFACE_BASE_NAME);
        sb2.append(JavaConstant.Dynamic.DEFAULT_NAME);
        if (!MPUtility.isEmpty((CharSequence) str)) {
            sb2.append(str);
        } else {
            sb2.append(MParticle.getInstance().Internal().b().U());
        }
        sb2.append("_v2");
        return sb2.toString();
    }

    private MParticle.IdentityType getIdentityType(org.json.b bVar) {
        String str;
        String str2;
        MParticle.IdentityType identityType = null;
        try {
            str = null;
            identityType = MParticle.IdentityType.parseInt(bVar.getInt(TYPE));
        } catch (JSONException e10) {
            str = e10.getMessage();
        }
        if (identityType != null) {
            return identityType;
        }
        try {
            return MParticle.IdentityType.valueOf(bVar.getString(TYPE));
        } catch (JSONException e11) {
            String[] strArr = new String[1];
            Object[] objArr = new Object[1];
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e11.getMessage());
            if (!MPUtility.isEmpty((CharSequence) str)) {
                str2 = "\n" + str;
            } else {
                str2 = "";
            }
            sb2.append(str2);
            objArr[0] = sb2.toString();
            strArr[0] = String.format(errorMsg, objArr);
            Logger.warning(strArr);
            return identityType;
        }
    }

    private TransactionAttributes getTransactionAttributes(org.json.b bVar) {
        if (bVar == null || (!bVar.has(TRANSACTION_ID) && !bVar.has("Affiliation") && !bVar.has(COUPON_CODE) && !bVar.has(TOTAL_AMOUNT) && !bVar.has(TAX_AMOUNT) && !bVar.has(SHIPPING_AMOUNT))) {
            return null;
        }
        TransactionAttributes transactionAttributes = new TransactionAttributes();
        transactionAttributes.setId(bVar.optString(TRANSACTION_ID, transactionAttributes.getId())).setAffiliation(bVar.optString("Affiliation", transactionAttributes.getAffiliation())).setCouponCode(bVar.optString(COUPON_CODE, transactionAttributes.getCouponCode())).setRevenue(Double.valueOf(bVar.optDouble(TOTAL_AMOUNT))).setTax(Double.valueOf(bVar.optDouble(TAX_AMOUNT))).setShipping(Double.valueOf(bVar.optDouble(SHIPPING_AMOUNT)));
        return transactionAttributes;
    }

    public static void registerWebView(WebView webView, String str) {
        if (webView != null) {
            webView.addJavascriptInterface(new MParticleJSInterface(), getBridgeName(str));
        }
    }

    private Impression toImpression(org.json.b bVar) {
        org.json.a optJSONArray;
        if (bVar == null || !bVar.has(PRODUCT_IMPRESSION_NAME) || (optJSONArray = bVar.optJSONArray(PRODUCT_LIST)) == null) {
            return null;
        }
        Impression impression = null;
        for (int i10 = 0; i10 < optJSONArray.o(); i10++) {
            Product product = toProduct(optJSONArray.s(i10));
            String optString = bVar.optString(PRODUCT_IMPRESSION_NAME, (String) null);
            if (product != null) {
                if (impression != null) {
                    impression.addProduct(product);
                } else if (!MPUtility.isEmpty((CharSequence) optString)) {
                    impression = new Impression(optString, product);
                }
            }
        }
        return impression;
    }

    private Promotion toPromotion(org.json.b bVar) {
        if (bVar == null) {
            return null;
        }
        return new Promotion().setName(bVar.optString("Name", (String) null)).setCreative(bVar.optString("Creative", (String) null)).setId(bVar.optString("Id", (String) null)).setPosition(bVar.optString("Position", (String) null));
    }

    @JavascriptInterface
    public void addToCart(String str) {
        try {
            Product product = toProduct(new org.json.b(str));
            if (product != null) {
                MParticle.getInstance().logEvent(new CommerceEvent.Builder("add_to_cart", product).build());
                return;
            }
            Logger.warning(String.format(errorMsg, new Object[]{"unable to convert String to Product: " + str}));
        } catch (JSONException e10) {
            Logger.warning(String.format(errorMsg, new Object[]{e10.getMessage()}));
        }
    }

    @JavascriptInterface
    public void clearCart() {
        Logger.warning("Unable to clear cart - method not supported");
    }

    /* access modifiers changed from: package-private */
    public MParticle.EventType convertEventType(int i10) {
        switch (i10) {
            case 0:
                return MParticle.EventType.Unknown;
            case 1:
                return MParticle.EventType.Navigation;
            case 2:
                return MParticle.EventType.Location;
            case 3:
                return MParticle.EventType.Search;
            case 4:
                return MParticle.EventType.Transaction;
            case 5:
                return MParticle.EventType.UserContent;
            case 6:
                return MParticle.EventType.UserPreference;
            case 7:
                return MParticle.EventType.Social;
            case 9:
                return MParticle.EventType.Media;
            default:
                return MParticle.EventType.Other;
        }
    }

    @JavascriptInterface
    public String getAllUserAttributes() {
        Map<String, Object> userAttributes = MParticle.getInstance().Identity().getCurrentUser().getUserAttributes();
        org.json.a aVar = new org.json.a();
        for (Map.Entry next : userAttributes.entrySet()) {
            try {
                org.json.b bVar = new org.json.b();
                bVar.put(SDKConstants.PARAM_KEY, next.getKey());
                bVar.put("value", (Object) next.getValue().toString());
                aVar.E(bVar);
            } catch (JSONException e10) {
                Logger.warning(e10.getMessage());
            }
        }
        return aVar.toString();
    }

    @JavascriptInterface
    public String getCurrentMpId() {
        MParticleUser currentUser = MParticle.getInstance().Identity().getCurrentUser();
        if (currentUser != null) {
            return String.valueOf(currentUser.getId());
        }
        return String.valueOf(0);
    }

    /* access modifiers changed from: protected */
    public IdentityApiRequest getIdentityApiRequest(org.json.b bVar) {
        org.json.a optJSONArray = bVar.optJSONArray(USER_IDENTITIES);
        HashMap hashMap = new HashMap();
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.o(); i10++) {
                try {
                    org.json.b j10 = optJSONArray.j(i10);
                    hashMap.put(getIdentityType(j10), j10.getString("Identity"));
                } catch (JSONException e10) {
                    Logger.warning(String.format(errorMsg, new Object[]{e10.getMessage()}));
                }
            }
        }
        IdentityApiRequest.Builder userIdentities = IdentityApiRequest.withEmptyUser().userIdentities(hashMap);
        if (bVar.has(TYPE) && bVar.has("Identity")) {
            MParticle.IdentityType identityType = getIdentityType(bVar);
            String optString = bVar.optString("Identity");
            if (identityType != null && !MPUtility.isEmpty((CharSequence) optString)) {
                userIdentities.userIdentity(identityType, optString);
            }
        }
        return userIdentities.build();
    }

    /* access modifiers changed from: package-private */
    public String getProductAction(String str) {
        if (str == null) {
            return null;
        }
        try {
            switch (Integer.parseInt(str)) {
                case 0:
                    return "unknown";
                case 1:
                    return "add_to_cart";
                case 2:
                    return "remove_from_cart";
                case 3:
                    return Product.CHECKOUT;
                case 4:
                    return Product.CHECKOUT_OPTION;
                case 5:
                    return "click";
                case 6:
                    return Product.DETAIL;
                case 7:
                    return "purchase";
                case 8:
                    return "refund";
                case 9:
                    return "add_to_wishlist";
                case 10:
                    return Product.REMOVE_FROM_WISHLIST;
            }
        } catch (Exception unused) {
            Logger.warning("unable to match ProductAction for value " + str);
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public String getPromotionAction(String str) {
        if (str == null) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt == 0) {
                return "unknown";
            }
            if (parseInt == 1) {
                return "view";
            }
            if (parseInt != 2) {
                return str;
            }
            return "click";
        } catch (Exception unused) {
            Logger.warning("unable to match ProductAction for value " + str);
        }
    }

    @JavascriptInterface
    public String getUserAttributesLists() {
        HashMap hashMap = new HashMap();
        MParticleUser currentUser = MParticle.getInstance().Identity().getCurrentUser();
        if (currentUser == null) {
            return new org.json.b().toString();
        }
        for (Map.Entry next : currentUser.getUserAttributes().entrySet()) {
            if (next.getValue() instanceof List) {
                hashMap.put((String) next.getKey(), (List) next.getValue());
            }
        }
        org.json.a aVar = new org.json.a();
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                org.json.b bVar = new org.json.b();
                bVar.put(SDKConstants.PARAM_KEY, entry.getKey());
                org.json.a aVar2 = new org.json.a();
                for (Object E : (List) entry.getValue()) {
                    aVar2.E(E);
                }
                bVar.put("value", (Object) aVar2.toString());
                aVar.E(bVar);
            } catch (JSONException e10) {
                Logger.warning(e10.getMessage());
            }
        }
        return aVar.toString();
    }

    @JavascriptInterface
    public void logEvent(String str) {
        try {
            org.json.b bVar = new org.json.b(str);
            String string = bVar.getString("EventName");
            MParticle.EventType convertEventType = convertEventType(bVar.getInt(JS_KEY_EVENT_CATEGORY));
            Map<String, String> convertToMap = convertToMap(bVar.optJSONObject(JS_KEY_EVENT_ATTRIBUTES));
            Map<String, List<String>> convertToListMap = convertToListMap(bVar.optJSONObject(JS_KEY_EVENT_FLAGS));
            int i10 = bVar.getInt(JS_KEY_EVENT_DATATYPE);
            if (i10 == 16) {
                CommerceEvent commerceEvent = toCommerceEvent(bVar);
                if (commerceEvent == null) {
                    Logger.warning("CommerceEvent empty, or unparseable");
                } else {
                    logEvent((BaseEvent) commerceEvent);
                }
            } else if (i10 == 3) {
                logScreen(new MPEvent.Builder(string, convertEventType).customAttributes(convertToMap).customFlags(convertToListMap).build());
            } else if (i10 == 4) {
                logEvent((BaseEvent) new MPEvent.Builder(string, convertEventType).customAttributes(convertToMap).customFlags(convertToListMap).build());
            } else if (i10 == 5) {
                MParticle.getInstance().logError(string, convertToMap);
            } else if (i10 == 6) {
                MParticle.getInstance().setOptOut(Boolean.valueOf(bVar.optBoolean(JS_KEY_OPTOUT)));
            }
        } catch (JSONException e10) {
            Logger.warning(String.format(errorMsg, new Object[]{e10.getMessage()}));
        }
    }

    /* access modifiers changed from: protected */
    public void logScreen(MPEvent mPEvent) {
        MParticle.getInstance().logScreen(mPEvent);
    }

    @JavascriptInterface
    public void login() {
        MParticle.getInstance().Identity().login();
    }

    @JavascriptInterface
    public void logout() {
        MParticle.getInstance().Identity().logout();
    }

    @JavascriptInterface
    public void modify(String str) {
        IdentityApiRequest identityApiRequest;
        try {
            identityApiRequest = getIdentityApiRequest(new org.json.b(str));
        } catch (JSONException e10) {
            Logger.warning(String.format(errorMsg, new Object[]{e10.getMessage()}));
            identityApiRequest = null;
        }
        MParticle.getInstance().Identity().modify(identityApiRequest);
    }

    @JavascriptInterface
    public void removeAllUserAttributes() {
        if (MParticle.getInstance().Identity().getCurrentUser() != null) {
            MParticleUser currentUser = MParticle.getInstance().Identity().getCurrentUser();
            for (String removeUserAttribute : currentUser.getUserAttributes().keySet()) {
                currentUser.removeUserAttribute(removeUserAttribute);
            }
            return;
        }
        MParticle.getInstance().Identity().addIdentityStateListener(new g());
    }

    @JavascriptInterface
    public void removeFromCart(String str) {
        try {
            Product product = toProduct(new org.json.b(str));
            if (product != null) {
                MParticle.getInstance().logEvent(new CommerceEvent.Builder("remove_from_cart", product).build());
                return;
            }
            Logger.warning(String.format(errorMsg, new Object[]{"unable to convert String to Product: " + str}));
        } catch (JSONException e10) {
            Logger.warning(String.format(errorMsg, new Object[]{e10.getMessage()}));
        }
    }

    @JavascriptInterface
    public void removeUserAttribute(String str) {
        try {
            String string = new org.json.b(str).getString(SDKConstants.PARAM_KEY);
            if (MParticle.getInstance().Identity().getCurrentUser() != null) {
                MParticle.getInstance().Identity().getCurrentUser().removeUserAttribute(string);
            } else {
                MParticle.getInstance().Identity().addIdentityStateListener(new e(string));
            }
        } catch (JSONException e10) {
            Logger.warning(String.format(errorMsg, new Object[]{e10.getMessage()}));
        }
    }

    @JavascriptInterface
    public void removeUserIdentity(String str) {
    }

    @JavascriptInterface
    public void removeUserTag(String str) {
        try {
            String string = new org.json.b(str).getString(SDKConstants.PARAM_KEY);
            if (MParticle.getInstance().Identity().getCurrentUser() != null) {
                MParticle.getInstance().Identity().getCurrentUser().removeUserAttribute(string);
            } else {
                MParticle.getInstance().Identity().addIdentityStateListener(new c(string));
            }
        } catch (JSONException e10) {
            Logger.warning(String.format(errorMsg, new Object[]{e10.getMessage()}));
        }
    }

    @JavascriptInterface
    public void setSessionAttribute(String str) {
        try {
            org.json.b bVar = new org.json.b(str);
            MParticle.getInstance().setSessionAttribute(bVar.getString(SDKConstants.PARAM_KEY), bVar.getString("value"));
        } catch (JSONException e10) {
            Logger.warning(String.format(errorMsg, new Object[]{e10.getMessage()}));
        }
    }

    @JavascriptInterface
    public void setUserAttribute(String str) {
        try {
            org.json.b bVar = new org.json.b(str);
            String string = bVar.getString(SDKConstants.PARAM_KEY);
            Object obj = bVar.get("value");
            if (MParticle.getInstance().Identity().getCurrentUser() != null) {
                MParticle.getInstance().Identity().getCurrentUser().setUserAttribute(string, String.valueOf(obj));
            } else {
                MParticle.getInstance().Identity().addIdentityStateListener(new d(string, obj));
            }
        } catch (JSONException e10) {
            Logger.warning(String.format(errorMsg, new Object[]{e10.getMessage()}));
        }
    }

    @JavascriptInterface
    public void setUserAttributeList(String str) {
        try {
            org.json.b bVar = new org.json.b(str);
            String string = bVar.getString(SDKConstants.PARAM_KEY);
            org.json.a jSONArray = bVar.getJSONArray("value");
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < jSONArray.o(); i10++) {
                arrayList.add(String.valueOf(jSONArray.get(i10)));
            }
            if (MParticle.getInstance().Identity().getCurrentUser() != null) {
                MParticle.getInstance().Identity().getCurrentUser().setUserAttributeList(string, arrayList);
            } else {
                MParticle.getInstance().Identity().addIdentityStateListener(new f(string, arrayList));
            }
        } catch (JSONException e10) {
            Logger.warning(String.format(errorMsg, new Object[]{e10.getMessage()}));
        }
    }

    @JavascriptInterface
    public void setUserIdentity(String str) {
    }

    @JavascriptInterface
    public void setUserTag(String str) {
        try {
            String string = new org.json.b(str).getString(SDKConstants.PARAM_KEY);
            if (MParticle.getInstance().Identity().getCurrentUser() != null) {
                MParticle.getInstance().Identity().getCurrentUser().setUserTag(string);
            } else {
                MParticle.getInstance().Identity().addIdentityStateListener(new b(string));
            }
        } catch (JSONException e10) {
            Logger.warning(String.format(errorMsg, new Object[]{e10.getMessage()}));
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ac A[LOOP:2: B:37:0x00ac->B:44:0x00c7, LOOP_START, PHI: r1 r6 
      PHI: (r1v3 int) = (r1v0 int), (r1v4 int) binds: [B:36:0x00aa, B:44:0x00c7] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r6v3 com.mparticle.commerce.CommerceEvent$Builder) = (r6v1 com.mparticle.commerce.CommerceEvent$Builder), (r6v4 com.mparticle.commerce.CommerceEvent$Builder) binds: [B:36:0x00aa, B:44:0x00c7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.mparticle.commerce.CommerceEvent toCommerceEvent(org.json.b r9) {
        /*
            r8 = this;
            java.lang.String r0 = "ProductAction"
            org.json.b r0 = r9.optJSONObject(r0)
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x0063
            java.lang.String r3 = "ProductActionType"
            java.lang.String r3 = r0.optString(r3, r2)
            java.lang.String r3 = r8.getProductAction(r3)
            java.lang.String r4 = "ProductList"
            org.json.a r4 = r0.optJSONArray(r4)
            if (r3 == 0) goto L_0x0063
            if (r4 == 0) goto L_0x0063
            r5 = r1
            r6 = r2
        L_0x0020:
            int r7 = r4.o()
            if (r5 >= r7) goto L_0x003c
            org.json.b r7 = r4.s(r5)
            com.mparticle.commerce.Product r7 = r8.toProduct(r7)
            if (r6 != 0) goto L_0x0036
            com.mparticle.commerce.CommerceEvent$Builder r6 = new com.mparticle.commerce.CommerceEvent$Builder
            r6.<init>((java.lang.String) r3, (com.mparticle.commerce.Product) r7)
            goto L_0x0039
        L_0x0036:
            r6.addProduct(r7)
        L_0x0039:
            int r5 = r5 + 1
            goto L_0x0020
        L_0x003c:
            if (r6 != 0) goto L_0x0043
            com.mparticle.commerce.CommerceEvent$Builder r6 = new com.mparticle.commerce.CommerceEvent$Builder
            r6.<init>((java.lang.String) r3, (com.mparticle.commerce.Product) r2)
        L_0x0043:
            com.mparticle.commerce.TransactionAttributes r3 = r8.getTransactionAttributes(r0)
            if (r3 == 0) goto L_0x004c
            r6.transactionAttributes(r3)
        L_0x004c:
            java.lang.String r3 = "CheckoutStep"
            int r3 = r0.optInt(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r6.checkoutStep(r3)
            java.lang.String r3 = "CheckoutOptions"
            java.lang.String r0 = r0.optString(r3)
            r6.checkoutOptions(r0)
            goto L_0x0064
        L_0x0063:
            r6 = r2
        L_0x0064:
            java.lang.String r0 = "PromotionAction"
            org.json.b r0 = r9.optJSONObject(r0)
            if (r0 == 0) goto L_0x00a4
            java.lang.String r3 = "PromotionActionType"
            java.lang.String r3 = r0.optString(r3)
            java.lang.String r3 = r8.getPromotionAction(r3)
            java.lang.String r4 = "PromotionList"
            org.json.a r0 = r0.optJSONArray(r4)
            if (r3 == 0) goto L_0x00a4
            if (r0 == 0) goto L_0x00a4
            r4 = r1
        L_0x0081:
            int r5 = r0.o()
            if (r4 >= r5) goto L_0x009d
            org.json.b r5 = r0.s(r4)
            com.mparticle.commerce.Promotion r5 = r8.toPromotion(r5)
            if (r6 != 0) goto L_0x0097
            com.mparticle.commerce.CommerceEvent$Builder r6 = new com.mparticle.commerce.CommerceEvent$Builder
            r6.<init>((java.lang.String) r3, (com.mparticle.commerce.Promotion) r5)
            goto L_0x009a
        L_0x0097:
            r6.addPromotion(r5)
        L_0x009a:
            int r4 = r4 + 1
            goto L_0x0081
        L_0x009d:
            if (r6 != 0) goto L_0x00a4
            com.mparticle.commerce.CommerceEvent$Builder r6 = new com.mparticle.commerce.CommerceEvent$Builder
            r6.<init>((java.lang.String) r3, (com.mparticle.commerce.Promotion) r2)
        L_0x00a4:
            java.lang.String r0 = "ProductImpressions"
            org.json.a r0 = r9.optJSONArray(r0)
            if (r0 == 0) goto L_0x00ca
        L_0x00ac:
            int r3 = r0.o()
            if (r1 >= r3) goto L_0x00ca
            org.json.b r3 = r0.s(r1)
            com.mparticle.commerce.Impression r3 = r8.toImpression(r3)
            if (r3 == 0) goto L_0x00c7
            if (r6 != 0) goto L_0x00c4
            com.mparticle.commerce.CommerceEvent$Builder r6 = new com.mparticle.commerce.CommerceEvent$Builder
            r6.<init>((com.mparticle.commerce.Impression) r3)
            goto L_0x00c7
        L_0x00c4:
            r6.addImpression(r3)
        L_0x00c7:
            int r1 = r1 + 1
            goto L_0x00ac
        L_0x00ca:
            if (r6 != 0) goto L_0x00cd
            return r2
        L_0x00cd:
            java.lang.String r0 = "EventAttributes"
            org.json.b r0 = r9.optJSONObject(r0)
            java.util.Map r0 = convertToMap(r0)
            if (r0 == 0) goto L_0x00dc
            r6.customAttributes(r0)
        L_0x00dc:
            java.lang.String r0 = "CustomFlags"
            org.json.b r0 = r9.optJSONObject(r0)
            java.util.Map r0 = convertToListMap(r0)
            if (r0 == 0) goto L_0x00eb
            r6.customFlags(r0)
        L_0x00eb:
            java.lang.String r0 = "CurrencyCode"
            java.lang.String r0 = r9.optString(r0, r2)
            if (r0 == 0) goto L_0x00fe
            java.lang.String r1 = "null"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x00fe
            r6.currency(r0)
        L_0x00fe:
            java.lang.String r0 = "EventName"
            java.lang.String r9 = r9.optString(r0, r2)
            r6.internalEventName(r9)
            com.mparticle.commerce.CommerceEvent r9 = r6.build()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.internal.MParticleJSInterface.toCommerceEvent(org.json.b):com.mparticle.commerce.CommerceEvent");
    }

    /* access modifiers changed from: package-private */
    public Product toProduct(org.json.b bVar) {
        if (bVar == null) {
            return null;
        }
        try {
            Product.Builder builder = new Product.Builder(bVar.getString("Name"), bVar.optString(SKU, (String) null), bVar.optDouble(PRICE, 0.0d));
            builder.category(bVar.optString("Category", (String) null));
            builder.couponCode(bVar.optString(COUPON_CODE, (String) null));
            if (bVar.has("Position")) {
                builder.position(Integer.valueOf(bVar.optInt("Position", 0)));
            }
            if (bVar.has("Quantity")) {
                builder.quantity(bVar.optDouble("Quantity", 1.0d));
            }
            builder.brand(bVar.optString("Brand", (String) null));
            builder.variant(bVar.optString("Variant", (String) null));
            Map<String, String> convertToMap = convertToMap(bVar.optJSONObject(ATTRIBUTES));
            if (convertToMap != null) {
                builder.customAttributes(convertToMap);
            }
            return builder.build();
        } catch (JSONException unused) {
            return null;
        }
    }

    @JavascriptInterface
    public void login(String str) {
        IdentityApiRequest identityApiRequest;
        try {
            identityApiRequest = getIdentityApiRequest(new org.json.b(str));
        } catch (JSONException e10) {
            Logger.warning(String.format(errorMsg, new Object[]{e10.getMessage()}));
            identityApiRequest = null;
        }
        MParticle.getInstance().Identity().login(identityApiRequest);
    }

    @JavascriptInterface
    public void logout(String str) {
        IdentityApiRequest identityApiRequest;
        try {
            identityApiRequest = getIdentityApiRequest(new org.json.b(str));
        } catch (JSONException e10) {
            Logger.warning(String.format(errorMsg, new Object[]{e10.getMessage()}));
            identityApiRequest = null;
        }
        MParticle.getInstance().Identity().logout(identityApiRequest);
    }

    /* access modifiers changed from: protected */
    public void logEvent(BaseEvent baseEvent) {
        MParticle.getInstance().logEvent(baseEvent);
    }
}

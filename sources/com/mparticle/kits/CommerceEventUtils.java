package com.mparticle.kits;

import androidx.annotation.NonNull;
import com.mparticle.MPEvent;
import com.mparticle.MParticle;
import com.mparticle.commerce.CommerceEvent;
import com.mparticle.commerce.Impression;
import com.mparticle.commerce.Product;
import com.mparticle.commerce.Promotion;
import com.mparticle.commerce.TransactionAttributes;
import com.mparticle.internal.MPUtility;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class CommerceEventUtils {
    private static final String IMPRESSION_NAME = "eCommerce - Impression - Item";
    private static final String ITEM_NAME = "eCommerce - %s - Item";
    static final String PLUSONE_NAME = "eCommerce - %s - Total";

    public interface Constants {
        public static final String ATT_ACTION_CHECKOUT_OPTIONS = "Checkout Options";
        public static final String ATT_ACTION_CHECKOUT_STEP = "Checkout Step";
        public static final String ATT_ACTION_CURRENCY_CODE = "Currency Code";
        public static final String ATT_ACTION_PRODUCT_ACTION_LIST = "Product Action List";
        public static final String ATT_ACTION_PRODUCT_LIST_SOURCE = "Product List Source";
        public static final String ATT_AFFILIATION = "Affiliation";
        public static final String ATT_PRODUCT_BRAND = "Brand";
        public static final String ATT_PRODUCT_CATEGORY = "Category";
        public static final String ATT_PRODUCT_COUPON_CODE = "Coupon Code";
        public static final String ATT_PRODUCT_ID = "Id";
        public static final String ATT_PRODUCT_NAME = "Name";
        public static final String ATT_PRODUCT_POSITION = "Position";
        public static final String ATT_PRODUCT_PRICE = "Item Price";
        public static final String ATT_PRODUCT_QUANTITY = "Quantity";
        public static final String ATT_PRODUCT_TOTAL_AMOUNT = "Total Product Amount";
        public static final String ATT_PRODUCT_VARIANT = "Variant";
        public static final String ATT_PROMOTION_CREATIVE = "Creative";
        public static final String ATT_PROMOTION_ID = "Id";
        public static final String ATT_PROMOTION_NAME = "Name";
        public static final String ATT_PROMOTION_POSITION = "Position";
        public static final String ATT_SCREEN_NAME = "Screen Name";
        public static final String ATT_SHIPPING = "Shipping Amount";
        public static final String ATT_TAX = "Tax Amount";
        public static final String ATT_TOTAL = "Total Amount";
        public static final String ATT_TRANSACTION_COUPON_CODE = "Coupon Code";
        public static final String ATT_TRANSACTION_ID = "Transaction Id";
        public static final String DEFAULT_CURRENCY_CODE = "USD";
        public static final int EVENT_TYPE_ADD_TO_CART = 10;
        public static final int EVENT_TYPE_ADD_TO_WISHLIST = 20;
        public static final int EVENT_TYPE_CHECKOUT = 12;
        public static final int EVENT_TYPE_CHECKOUT_OPTION = 13;
        public static final int EVENT_TYPE_CLICK = 14;
        public static final int EVENT_TYPE_IMPRESSION = 22;
        public static final int EVENT_TYPE_PROMOTION_CLICK = 19;
        public static final int EVENT_TYPE_PROMOTION_VIEW = 18;
        public static final int EVENT_TYPE_PURCHASE = 16;
        public static final int EVENT_TYPE_REFUND = 17;
        public static final int EVENT_TYPE_REMOVE_FROM_CART = 11;
        public static final int EVENT_TYPE_REMOVE_FROM_WISHLIST = 21;
        public static final String EVENT_TYPE_STRING_ADD_TO_CART = "ProductAddToCart";
        public static final String EVENT_TYPE_STRING_ADD_TO_WISHLIST = "ProductAddToWishlist";
        public static final String EVENT_TYPE_STRING_CHECKOUT = "ProductCheckout";
        public static final String EVENT_TYPE_STRING_CHECKOUT_OPTION = "ProductCheckoutOption";
        public static final String EVENT_TYPE_STRING_CLICK = "ProductClick";
        public static final String EVENT_TYPE_STRING_IMPRESSION = "ProductImpression";
        public static final String EVENT_TYPE_STRING_PROMOTION_CLICK = "PromotionClick";
        public static final String EVENT_TYPE_STRING_PROMOTION_VIEW = "PromotionView";
        public static final String EVENT_TYPE_STRING_PURCHASE = "ProductPurchase";
        public static final String EVENT_TYPE_STRING_REFUND = "ProductRefund";
        public static final String EVENT_TYPE_STRING_REMOVE_FROM_CART = "ProductRemoveFromCart";
        public static final String EVENT_TYPE_STRING_REMOVE_FROM_WISHLIST = "ProductRemoveFromWishlist";
        public static final String EVENT_TYPE_STRING_UNKNOWN = "Unknown";
        public static final String EVENT_TYPE_STRING_VIEW_DETAIL = "ProductViewDetail";
        public static final int EVENT_TYPE_VIEW_DETAIL = 15;
        public static final String RESERVED_KEY_LTV = "$Amount";
    }

    public interface OnAttributeExtracted {
        void onAttributeExtracted(String str, double d10);

        void onAttributeExtracted(String str, int i10);

        void onAttributeExtracted(String str, String str2);

        void onAttributeExtracted(Map<String, String> map);
    }

    private static class StringAttributeExtractor implements OnAttributeExtracted {
        Map<String, String> attributes;

        StringAttributeExtractor(@NonNull Map<String, String> map) {
            this.attributes = map;
        }

        public void onAttributeExtracted(String str, String str2) {
            this.attributes.put(str, str2);
        }

        public void onAttributeExtracted(String str, double d10) {
            this.attributes.put(str, Double.toString(d10));
        }

        public void onAttributeExtracted(String str, int i10) {
            this.attributes.put(str, Integer.toString(i10));
        }

        public void onAttributeExtracted(Map<String, String> map) {
            this.attributes.putAll(map);
        }
    }

    private CommerceEventUtils() {
    }

    public static List<MPEvent> expand(CommerceEvent commerceEvent) {
        LinkedList linkedList = new LinkedList();
        if (commerceEvent == null) {
            return linkedList;
        }
        linkedList.addAll(expandProductAction(commerceEvent));
        linkedList.addAll(expandPromotionAction(commerceEvent));
        linkedList.addAll(expandProductImpression(commerceEvent));
        return linkedList;
    }

    public static List<MPEvent> expandProductAction(CommerceEvent commerceEvent) {
        LinkedList linkedList = new LinkedList();
        String productAction = commerceEvent.getProductAction();
        if (productAction == null) {
            return linkedList;
        }
        if (productAction.equalsIgnoreCase("purchase") || productAction.equalsIgnoreCase("refund")) {
            MPEvent.Builder builder = new MPEvent.Builder(String.format(PLUSONE_NAME, new Object[]{commerceEvent.getProductAction()}), MParticle.EventType.Transaction);
            HashMap hashMap = new HashMap();
            if (commerceEvent.getCustomAttributeStrings() != null) {
                hashMap.putAll(commerceEvent.getCustomAttributeStrings());
            }
            extractActionAttributes(commerceEvent, (Map<String, String>) hashMap);
            linkedList.add(builder.customAttributes(hashMap).shouldUploadEvent(commerceEvent.isShouldUploadEvent()).build());
        }
        List<Product> products = commerceEvent.getProducts();
        if (products != null) {
            for (int i10 = 0; i10 < products.size(); i10++) {
                MPEvent.Builder builder2 = new MPEvent.Builder(String.format(ITEM_NAME, new Object[]{productAction}), MParticle.EventType.Transaction);
                HashMap hashMap2 = new HashMap();
                StringAttributeExtractor stringAttributeExtractor = new StringAttributeExtractor(hashMap2);
                extractProductFields(products.get(i10), (OnAttributeExtracted) stringAttributeExtractor);
                extractProductAttributes(products.get(i10), (OnAttributeExtracted) stringAttributeExtractor);
                extractTransactionId(commerceEvent, stringAttributeExtractor);
                linkedList.add(builder2.customAttributes(hashMap2).shouldUploadEvent(commerceEvent.isShouldUploadEvent()).build());
            }
        }
        return linkedList;
    }

    public static List<MPEvent> expandProductImpression(CommerceEvent commerceEvent) {
        List<Impression> impressions = commerceEvent.getImpressions();
        LinkedList linkedList = new LinkedList();
        if (impressions == null) {
            return linkedList;
        }
        for (int i10 = 0; i10 < impressions.size(); i10++) {
            List<Product> products = impressions.get(i10).getProducts();
            if (products != null) {
                for (int i11 = 0; i11 < products.size(); i11++) {
                    MPEvent.Builder builder = new MPEvent.Builder(IMPRESSION_NAME, MParticle.EventType.Transaction);
                    HashMap hashMap = new HashMap();
                    if (commerceEvent.getCustomAttributeStrings() != null) {
                        hashMap.putAll(commerceEvent.getCustomAttributeStrings());
                    }
                    extractProductAttributes(products.get(i10), (Map<String, String>) hashMap);
                    extractProductFields(products.get(i10), (Map<String, String>) hashMap);
                    extractImpressionAttributes(impressions.get(i10), hashMap);
                    linkedList.add(builder.customAttributes(hashMap).shouldUploadEvent(commerceEvent.isShouldUploadEvent()).build());
                }
            }
        }
        return linkedList;
    }

    public static List<MPEvent> expandPromotionAction(CommerceEvent commerceEvent) {
        List<Promotion> promotions;
        LinkedList linkedList = new LinkedList();
        String promotionAction = commerceEvent.getPromotionAction();
        if (!(promotionAction == null || (promotions = commerceEvent.getPromotions()) == null)) {
            for (int i10 = 0; i10 < promotions.size(); i10++) {
                MPEvent.Builder builder = new MPEvent.Builder(String.format(ITEM_NAME, new Object[]{promotionAction}), MParticle.EventType.Transaction);
                HashMap hashMap = new HashMap();
                if (commerceEvent.getCustomAttributeStrings() != null) {
                    hashMap.putAll(commerceEvent.getCustomAttributeStrings());
                }
                extractPromotionAttributes(promotions.get(i10), (Map<String, String>) hashMap);
                linkedList.add(builder.customAttributes(hashMap).shouldUploadEvent(commerceEvent.isShouldUploadEvent()).build());
            }
        }
        return linkedList;
    }

    public static void extractActionAttributes(CommerceEvent commerceEvent, Map<String, String> map) {
        extractActionAttributes(commerceEvent, (OnAttributeExtracted) new StringAttributeExtractor(map));
    }

    private static void extractImpressionAttributes(Impression impression, Map<String, String> map) {
        if (impression != null && !MPUtility.isEmpty((CharSequence) impression.getListName())) {
            map.put("Product Impression List", impression.getListName());
        }
    }

    public static void extractProductAttributes(Product product, Map<String, String> map) {
        extractProductAttributes(product, (OnAttributeExtracted) new StringAttributeExtractor(map));
    }

    public static void extractProductFields(Product product, Map<String, String> map) {
        extractProductFields(product, (OnAttributeExtracted) new StringAttributeExtractor(map));
    }

    public static void extractPromotionAttributes(Promotion promotion, Map<String, String> map) {
        extractPromotionAttributes(promotion, (OnAttributeExtracted) new StringAttributeExtractor(map));
    }

    public static Map<String, String> extractTransactionAttributes(CommerceEvent commerceEvent, Map<String, String> map) {
        if (!(commerceEvent == null || commerceEvent.getTransactionAttributes() == null)) {
            extractTransactionAttributes(commerceEvent, (OnAttributeExtracted) new StringAttributeExtractor(map));
        }
        return map;
    }

    private static void extractTransactionId(CommerceEvent commerceEvent, OnAttributeExtracted onAttributeExtracted) {
        if (commerceEvent != null && commerceEvent.getTransactionAttributes() != null && !MPUtility.isEmpty((CharSequence) commerceEvent.getTransactionAttributes().getId())) {
            onAttributeExtracted.onAttributeExtracted(Constants.ATT_TRANSACTION_ID, commerceEvent.getTransactionAttributes().getId());
        }
    }

    public static int getEventType(CommerceEvent commerceEvent) {
        if (!MPUtility.isEmpty((CharSequence) commerceEvent.getProductAction())) {
            String productAction = commerceEvent.getProductAction();
            if (productAction.equalsIgnoreCase("add_to_cart")) {
                return 10;
            }
            if (productAction.equalsIgnoreCase("remove_from_cart")) {
                return 11;
            }
            if (productAction.equalsIgnoreCase(Product.CHECKOUT)) {
                return 12;
            }
            if (productAction.equalsIgnoreCase(Product.CHECKOUT_OPTION)) {
                return 13;
            }
            if (productAction.equalsIgnoreCase("click")) {
                return 14;
            }
            if (productAction.equalsIgnoreCase(Product.DETAIL)) {
                return 15;
            }
            if (productAction.equalsIgnoreCase("purchase")) {
                return 16;
            }
            if (productAction.equalsIgnoreCase("refund")) {
                return 17;
            }
            if (productAction.equalsIgnoreCase("add_to_wishlist")) {
                return 20;
            }
            if (productAction.equalsIgnoreCase(Product.REMOVE_FROM_WISHLIST)) {
                return 21;
            }
        }
        if (MPUtility.isEmpty((CharSequence) commerceEvent.getPromotionAction())) {
            return 22;
        }
        String promotionAction = commerceEvent.getPromotionAction();
        if (promotionAction.equalsIgnoreCase("view")) {
            return 18;
        }
        if (promotionAction.equalsIgnoreCase("click")) {
            return 19;
        }
        return 22;
    }

    public static String getEventTypeString(CommerceEvent commerceEvent) {
        switch (getEventType(commerceEvent)) {
            case 10:
                return Constants.EVENT_TYPE_STRING_ADD_TO_CART;
            case 11:
                return Constants.EVENT_TYPE_STRING_REMOVE_FROM_CART;
            case 12:
                return Constants.EVENT_TYPE_STRING_CHECKOUT;
            case 13:
                return Constants.EVENT_TYPE_STRING_CHECKOUT_OPTION;
            case 14:
                return Constants.EVENT_TYPE_STRING_CLICK;
            case 15:
                return Constants.EVENT_TYPE_STRING_VIEW_DETAIL;
            case 16:
                return Constants.EVENT_TYPE_STRING_PURCHASE;
            case 17:
                return Constants.EVENT_TYPE_STRING_REFUND;
            case 18:
                return Constants.EVENT_TYPE_STRING_PROMOTION_VIEW;
            case 19:
                return Constants.EVENT_TYPE_STRING_PROMOTION_CLICK;
            case 20:
                return Constants.EVENT_TYPE_STRING_ADD_TO_WISHLIST;
            case 21:
                return Constants.EVENT_TYPE_STRING_REMOVE_FROM_WISHLIST;
            case 22:
                return Constants.EVENT_TYPE_STRING_IMPRESSION;
            default:
                return "Unknown";
        }
    }

    public static void extractActionAttributes(CommerceEvent commerceEvent, OnAttributeExtracted onAttributeExtracted) {
        extractTransactionAttributes(commerceEvent, onAttributeExtracted);
        extractTransactionId(commerceEvent, onAttributeExtracted);
        String currency = commerceEvent.getCurrency();
        if (MPUtility.isEmpty((CharSequence) currency)) {
            currency = Constants.DEFAULT_CURRENCY_CODE;
        }
        onAttributeExtracted.onAttributeExtracted(Constants.ATT_ACTION_CURRENCY_CODE, currency);
        String checkoutOptions = commerceEvent.getCheckoutOptions();
        if (!MPUtility.isEmpty((CharSequence) checkoutOptions)) {
            onAttributeExtracted.onAttributeExtracted(Constants.ATT_ACTION_CHECKOUT_OPTIONS, checkoutOptions);
        }
        if (commerceEvent.getCheckoutStep() != null) {
            onAttributeExtracted.onAttributeExtracted(Constants.ATT_ACTION_CHECKOUT_STEP, commerceEvent.getCheckoutStep().intValue());
        }
        if (!MPUtility.isEmpty((CharSequence) commerceEvent.getProductListSource())) {
            onAttributeExtracted.onAttributeExtracted(Constants.ATT_ACTION_PRODUCT_LIST_SOURCE, commerceEvent.getProductListSource());
        }
        if (!MPUtility.isEmpty((CharSequence) commerceEvent.getProductListName())) {
            onAttributeExtracted.onAttributeExtracted(Constants.ATT_ACTION_PRODUCT_ACTION_LIST, commerceEvent.getProductListName());
        }
    }

    public static void extractProductAttributes(Product product, OnAttributeExtracted onAttributeExtracted) {
        if (product != null && product.getCustomAttributes() != null) {
            onAttributeExtracted.onAttributeExtracted(product.getCustomAttributes());
        }
    }

    public static void extractProductFields(Product product, OnAttributeExtracted onAttributeExtracted) {
        if (product != null) {
            if (!MPUtility.isEmpty((CharSequence) product.getCouponCode())) {
                onAttributeExtracted.onAttributeExtracted("Coupon Code", product.getCouponCode());
            }
            if (!MPUtility.isEmpty((CharSequence) product.getBrand())) {
                onAttributeExtracted.onAttributeExtracted(Constants.ATT_PRODUCT_BRAND, product.getBrand());
            }
            if (!MPUtility.isEmpty((CharSequence) product.getCategory())) {
                onAttributeExtracted.onAttributeExtracted(Constants.ATT_PRODUCT_CATEGORY, product.getCategory());
            }
            if (!MPUtility.isEmpty((CharSequence) product.getName())) {
                onAttributeExtracted.onAttributeExtracted("Name", product.getName());
            }
            if (!MPUtility.isEmpty((CharSequence) product.getSku())) {
                onAttributeExtracted.onAttributeExtracted("Id", product.getSku());
            }
            if (!MPUtility.isEmpty((CharSequence) product.getVariant())) {
                onAttributeExtracted.onAttributeExtracted(Constants.ATT_PRODUCT_VARIANT, product.getVariant());
            }
            if (product.getPosition() != null) {
                onAttributeExtracted.onAttributeExtracted("Position", product.getPosition().intValue());
            }
            onAttributeExtracted.onAttributeExtracted(Constants.ATT_PRODUCT_PRICE, product.getUnitPrice());
            onAttributeExtracted.onAttributeExtracted(Constants.ATT_PRODUCT_QUANTITY, product.getQuantity());
            onAttributeExtracted.onAttributeExtracted(Constants.ATT_PRODUCT_TOTAL_AMOUNT, product.getTotalAmount());
        }
    }

    public static void extractPromotionAttributes(Promotion promotion, OnAttributeExtracted onAttributeExtracted) {
        if (promotion != null) {
            if (!MPUtility.isEmpty((CharSequence) promotion.getId())) {
                onAttributeExtracted.onAttributeExtracted("Id", promotion.getId());
            }
            if (!MPUtility.isEmpty((CharSequence) promotion.getPosition())) {
                onAttributeExtracted.onAttributeExtracted("Position", promotion.getPosition());
            }
            if (!MPUtility.isEmpty((CharSequence) promotion.getName())) {
                onAttributeExtracted.onAttributeExtracted("Name", promotion.getName());
            }
            if (!MPUtility.isEmpty((CharSequence) promotion.getCreative())) {
                onAttributeExtracted.onAttributeExtracted(Constants.ATT_PROMOTION_CREATIVE, promotion.getCreative());
            }
        }
    }

    public static void extractTransactionAttributes(CommerceEvent commerceEvent, OnAttributeExtracted onAttributeExtracted) {
        TransactionAttributes transactionAttributes = commerceEvent.getTransactionAttributes();
        extractTransactionId(commerceEvent, onAttributeExtracted);
        if (!MPUtility.isEmpty((CharSequence) transactionAttributes.getAffiliation())) {
            onAttributeExtracted.onAttributeExtracted(Constants.ATT_AFFILIATION, transactionAttributes.getAffiliation());
        }
        if (!MPUtility.isEmpty((CharSequence) transactionAttributes.getCouponCode())) {
            onAttributeExtracted.onAttributeExtracted("Coupon Code", transactionAttributes.getCouponCode());
        }
        if (transactionAttributes.getRevenue() != null) {
            onAttributeExtracted.onAttributeExtracted(Constants.ATT_TOTAL, transactionAttributes.getRevenue().doubleValue());
        }
        if (transactionAttributes.getShipping() != null) {
            onAttributeExtracted.onAttributeExtracted(Constants.ATT_SHIPPING, transactionAttributes.getShipping().doubleValue());
        }
        if (transactionAttributes.getTax() != null) {
            onAttributeExtracted.onAttributeExtracted(Constants.ATT_TAX, transactionAttributes.getTax().doubleValue());
        }
    }
}

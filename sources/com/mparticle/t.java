package com.mparticle;

import android.location.Location;
import com.mparticle.commerce.CommerceEvent;
import com.mparticle.commerce.Impression;
import com.mparticle.commerce.Product;
import com.mparticle.commerce.Promotion;
import com.mparticle.commerce.TransactionAttributes;
import com.mparticle.internal.InternalSession;
import com.mparticle.internal.MPUtility;
import com.mparticle.kits.ReportingMessage;
import org.json.JSONException;
import org.json.b;

public class t extends c {

    public static class a extends d {
        public a(CommerceEvent commerceEvent) {
            super(ReportingMessage.MessageType.COMMERCE_EVENT);
            a(this, commerceEvent);
        }

        public c a(InternalSession internalSession, Location location, long j10) throws JSONException {
            return new t(this, internalSession, location, j10);
        }

        private static void a(b bVar, CommerceEvent commerceEvent) {
            try {
                if (commerceEvent.getScreen() != null) {
                    bVar.put("sn", (Object) commerceEvent.getScreen());
                }
                if (commerceEvent.getNonInteraction() != null) {
                    bVar.put("ni", commerceEvent.getNonInteraction().booleanValue());
                }
                if (commerceEvent.getCurrency() != null) {
                    bVar.put("cu", (Object) commerceEvent.getCurrency());
                }
                if (commerceEvent.getCustomAttributeStrings() != null) {
                    bVar.put("attrs", (Object) MPUtility.mapToJson(commerceEvent.getCustomAttributeStrings()));
                }
                if (commerceEvent.getProductAction() != null) {
                    b bVar2 = new b();
                    bVar.put("pd", (Object) bVar2);
                    bVar2.put("an", (Object) commerceEvent.getProductAction());
                    if (commerceEvent.getCheckoutStep() != null) {
                        bVar2.put("cs", (Object) commerceEvent.getCheckoutStep());
                    }
                    if (commerceEvent.getCheckoutOptions() != null) {
                        bVar2.put("co", (Object) commerceEvent.getCheckoutOptions());
                    }
                    if (commerceEvent.getProductListName() != null) {
                        bVar2.put("pal", (Object) commerceEvent.getProductListName());
                    }
                    if (commerceEvent.getProductListSource() != null) {
                        bVar2.put("pls", (Object) commerceEvent.getProductListSource());
                    }
                    if (commerceEvent.getTransactionAttributes() != null) {
                        TransactionAttributes transactionAttributes = commerceEvent.getTransactionAttributes();
                        if (transactionAttributes.getId() != null) {
                            bVar2.put("ti", (Object) transactionAttributes.getId());
                        }
                        if (transactionAttributes.getAffiliation() != null) {
                            bVar2.put("ta", (Object) transactionAttributes.getAffiliation());
                        }
                        if (transactionAttributes.getRevenue() != null) {
                            bVar2.put("tr", (Object) transactionAttributes.getRevenue());
                        }
                        if (transactionAttributes.getTax() != null) {
                            bVar2.put("tt", (Object) transactionAttributes.getTax());
                        }
                        if (transactionAttributes.getShipping() != null) {
                            bVar2.put("ts", (Object) transactionAttributes.getShipping());
                        }
                        if (transactionAttributes.getCouponCode() != null) {
                            bVar2.put("tcc", (Object) transactionAttributes.getCouponCode());
                        }
                    }
                    if (commerceEvent.getProducts() != null && commerceEvent.getProducts().size() > 0) {
                        org.json.a aVar = new org.json.a();
                        for (int i10 = 0; i10 < commerceEvent.getProducts().size(); i10++) {
                            aVar.E(new b(commerceEvent.getProducts().get(i10).toString()));
                        }
                        bVar2.put("pl", (Object) aVar);
                    }
                }
                if (commerceEvent.getPromotionAction() != null) {
                    b bVar3 = new b();
                    bVar.put(ReportingMessage.MessageType.PUSH_RECEIVED, (Object) bVar3);
                    bVar3.put("an", (Object) commerceEvent.getPromotionAction());
                    if (commerceEvent.getPromotions() != null && commerceEvent.getPromotions().size() > 0) {
                        org.json.a aVar2 = new org.json.a();
                        for (int i11 = 0; i11 < commerceEvent.getPromotions().size(); i11++) {
                            aVar2.E(a(commerceEvent.getPromotions().get(i11)));
                        }
                        bVar3.put("pl", (Object) aVar2);
                    }
                }
                if (commerceEvent.getImpressions() != null && commerceEvent.getImpressions().size() > 0) {
                    org.json.a aVar3 = new org.json.a();
                    for (Impression next : commerceEvent.getImpressions()) {
                        b bVar4 = new b();
                        if (next.getListName() != null) {
                            bVar4.put("pil", (Object) next.getListName());
                        }
                        if (next.getProducts() != null && next.getProducts().size() > 0) {
                            org.json.a aVar4 = new org.json.a();
                            bVar4.put("pl", (Object) aVar4);
                            for (Product product : next.getProducts()) {
                                aVar4.E(new b(product.toString()));
                            }
                        }
                        if (bVar4.length() > 0) {
                            aVar3.E(bVar4);
                        }
                    }
                    if (aVar3.o() > 0) {
                        bVar.put("pi", (Object) aVar3);
                    }
                }
            } catch (Exception unused) {
            }
        }

        private static b a(Promotion promotion) {
            b bVar = new b();
            try {
                if (!MPUtility.isEmpty((CharSequence) promotion.getId())) {
                    bVar.put("id", (Object) promotion.getId());
                }
                if (!MPUtility.isEmpty((CharSequence) promotion.getName())) {
                    bVar.put("nm", (Object) promotion.getName());
                }
                if (!MPUtility.isEmpty((CharSequence) promotion.getCreative())) {
                    bVar.put("cr", (Object) promotion.getCreative());
                }
                if (!MPUtility.isEmpty((CharSequence) promotion.getPosition())) {
                    bVar.put("ps", (Object) promotion.getPosition());
                }
            } catch (JSONException unused) {
            }
            return bVar;
        }
    }

    protected t(a aVar, InternalSession internalSession, Location location, long j10) throws JSONException {
        super(aVar, internalSession, location, j10);
    }
}

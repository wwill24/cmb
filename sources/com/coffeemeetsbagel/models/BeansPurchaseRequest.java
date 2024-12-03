package com.coffeemeetsbagel.models;

import java.util.Objects;
import lg.c;

public class BeansPurchaseRequest {
    @c("purchase_receipt")
    private final String receipt;
    @c("purchase_signature")
    private final String signature;

    public BeansPurchaseRequest(String str, String str2) {
        this.receipt = str;
        this.signature = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BeansPurchaseRequest beansPurchaseRequest = (BeansPurchaseRequest) obj;
        if (!Objects.equals(this.receipt, beansPurchaseRequest.receipt) || !Objects.equals(this.signature, beansPurchaseRequest.signature)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.receipt, this.signature});
    }
}

package com.coffeemeetsbagel.models.responses;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ResponseActionCards extends ResponseGeneric {
    private final ResponseActionCardsV1 data;

    public ResponseActionCards(ResponseActionCardsV1 responseActionCardsV1) {
        this.data = responseActionCardsV1;
    }

    public static /* synthetic */ ResponseActionCards copy$default(ResponseActionCards responseActionCards, ResponseActionCardsV1 responseActionCardsV1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            responseActionCardsV1 = responseActionCards.data;
        }
        return responseActionCards.copy(responseActionCardsV1);
    }

    public final ResponseActionCardsV1 component1() {
        return this.data;
    }

    public final ResponseActionCards copy(ResponseActionCardsV1 responseActionCardsV1) {
        return new ResponseActionCards(responseActionCardsV1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ResponseActionCards) && j.b(this.data, ((ResponseActionCards) obj).data);
    }

    public final ResponseActionCardsV1 getData() {
        return this.data;
    }

    public int hashCode() {
        ResponseActionCardsV1 responseActionCardsV1 = this.data;
        if (responseActionCardsV1 == null) {
            return 0;
        }
        return responseActionCardsV1.hashCode();
    }

    public String toString() {
        return "ResponseActionCards(data=" + this.data + PropertyUtils.MAPPED_DELIM2;
    }
}

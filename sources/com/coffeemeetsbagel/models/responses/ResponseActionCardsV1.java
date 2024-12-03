package com.coffeemeetsbagel.models.responses;

import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ResponseActionCardsV1 implements Serializable {

    /* renamed from: v1  reason: collision with root package name */
    private final List<ResponseActionCard> f34731v1;

    public ResponseActionCardsV1(List<ResponseActionCard> list) {
        this.f34731v1 = list;
    }

    public static /* synthetic */ ResponseActionCardsV1 copy$default(ResponseActionCardsV1 responseActionCardsV1, List<ResponseActionCard> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = responseActionCardsV1.f34731v1;
        }
        return responseActionCardsV1.copy(list);
    }

    public final List<ResponseActionCard> component1() {
        return this.f34731v1;
    }

    public final ResponseActionCardsV1 copy(List<ResponseActionCard> list) {
        return new ResponseActionCardsV1(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ResponseActionCardsV1) && j.b(this.f34731v1, ((ResponseActionCardsV1) obj).f34731v1);
    }

    public final List<ResponseActionCard> getV1() {
        return this.f34731v1;
    }

    public int hashCode() {
        List<ResponseActionCard> list = this.f34731v1;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "ResponseActionCardsV1(v1=" + this.f34731v1 + PropertyUtils.MAPPED_DELIM2;
    }
}

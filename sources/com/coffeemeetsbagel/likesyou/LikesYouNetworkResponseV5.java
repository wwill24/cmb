package com.coffeemeetsbagel.likesyou;

import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class LikesYouNetworkResponseV5 extends ResponseGeneric {
    private final LikesYouDataNetworkResponseV5 data;

    public LikesYouNetworkResponseV5(LikesYouDataNetworkResponseV5 likesYouDataNetworkResponseV5) {
        j.g(likesYouDataNetworkResponseV5, "data");
        this.data = likesYouDataNetworkResponseV5;
    }

    public static /* synthetic */ LikesYouNetworkResponseV5 copy$default(LikesYouNetworkResponseV5 likesYouNetworkResponseV5, LikesYouDataNetworkResponseV5 likesYouDataNetworkResponseV5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            likesYouDataNetworkResponseV5 = likesYouNetworkResponseV5.data;
        }
        return likesYouNetworkResponseV5.copy(likesYouDataNetworkResponseV5);
    }

    public final LikesYouDataNetworkResponseV5 component1() {
        return this.data;
    }

    public final LikesYouNetworkResponseV5 copy(LikesYouDataNetworkResponseV5 likesYouDataNetworkResponseV5) {
        j.g(likesYouDataNetworkResponseV5, "data");
        return new LikesYouNetworkResponseV5(likesYouDataNetworkResponseV5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LikesYouNetworkResponseV5) && j.b(this.data, ((LikesYouNetworkResponseV5) obj).data);
    }

    public final LikesYouDataNetworkResponseV5 getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "LikesYouNetworkResponseV5(data=" + this.data + PropertyUtils.MAPPED_DELIM2;
    }
}

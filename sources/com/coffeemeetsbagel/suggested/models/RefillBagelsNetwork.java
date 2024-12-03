package com.coffeemeetsbagel.suggested.models;

import com.coffeemeetsbagel.models.Bagel;
import java.util.List;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class RefillBagelsNetwork {
    private final List<Bagel> bagels;
    @c("out_of_bagels")
    private final boolean outOfBagels;

    public RefillBagelsNetwork(List<? extends Bagel> list, boolean z10) {
        this.bagels = list;
        this.outOfBagels = z10;
    }

    public static /* synthetic */ RefillBagelsNetwork copy$default(RefillBagelsNetwork refillBagelsNetwork, List<Bagel> list, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = refillBagelsNetwork.bagels;
        }
        if ((i10 & 2) != 0) {
            z10 = refillBagelsNetwork.outOfBagels;
        }
        return refillBagelsNetwork.copy(list, z10);
    }

    public final List<Bagel> component1() {
        return this.bagels;
    }

    public final boolean component2() {
        return this.outOfBagels;
    }

    public final RefillBagelsNetwork copy(List<? extends Bagel> list, boolean z10) {
        return new RefillBagelsNetwork(list, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RefillBagelsNetwork)) {
            return false;
        }
        RefillBagelsNetwork refillBagelsNetwork = (RefillBagelsNetwork) obj;
        return j.b(this.bagels, refillBagelsNetwork.bagels) && this.outOfBagels == refillBagelsNetwork.outOfBagels;
    }

    public final List<Bagel> getBagels() {
        return this.bagels;
    }

    public final boolean getOutOfBagels() {
        return this.outOfBagels;
    }

    public int hashCode() {
        List<Bagel> list = this.bagels;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        boolean z10 = this.outOfBagels;
        if (z10) {
            z10 = true;
        }
        return hashCode + (z10 ? 1 : 0);
    }

    public String toString() {
        return "RefillBagelsNetwork(bagels=" + this.bagels + ", outOfBagels=" + this.outOfBagels + PropertyUtils.MAPPED_DELIM2;
    }
}

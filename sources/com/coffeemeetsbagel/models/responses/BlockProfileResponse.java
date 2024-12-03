package com.coffeemeetsbagel.models.responses;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.mam.element.MamElements;

public final class BlockProfileResponse extends ResponseGeneric {
    private final String result;

    public BlockProfileResponse(String str) {
        j.g(str, MamElements.MamResultExtension.ELEMENT);
        this.result = str;
    }

    public static /* synthetic */ BlockProfileResponse copy$default(BlockProfileResponse blockProfileResponse, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = blockProfileResponse.result;
        }
        return blockProfileResponse.copy(str);
    }

    public final String component1() {
        return this.result;
    }

    public final BlockProfileResponse copy(String str) {
        j.g(str, MamElements.MamResultExtension.ELEMENT);
        return new BlockProfileResponse(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BlockProfileResponse) && j.b(this.result, ((BlockProfileResponse) obj).result);
    }

    public final String getResult() {
        return this.result;
    }

    public int hashCode() {
        return this.result.hashCode();
    }

    public String toString() {
        return "BlockProfileResponse(result=" + this.result + PropertyUtils.MAPPED_DELIM2;
    }
}

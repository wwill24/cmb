package com.coffeemeetsbagel.models.body;

import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class BlockProfileRequest {
    @c("block_reason")
    private final String blockReason;
    @c("block_type")
    private final String blockType;

    public BlockProfileRequest(String str, String str2) {
        this.blockType = str;
        this.blockReason = str2;
    }

    private final String component1() {
        return this.blockType;
    }

    private final String component2() {
        return this.blockReason;
    }

    public static /* synthetic */ BlockProfileRequest copy$default(BlockProfileRequest blockProfileRequest, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = blockProfileRequest.blockType;
        }
        if ((i10 & 2) != 0) {
            str2 = blockProfileRequest.blockReason;
        }
        return blockProfileRequest.copy(str, str2);
    }

    public final BlockProfileRequest copy(String str, String str2) {
        return new BlockProfileRequest(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockProfileRequest)) {
            return false;
        }
        BlockProfileRequest blockProfileRequest = (BlockProfileRequest) obj;
        return j.b(this.blockType, blockProfileRequest.blockType) && j.b(this.blockReason, blockProfileRequest.blockReason);
    }

    public int hashCode() {
        String str = this.blockType;
        int i10 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.blockReason;
        if (str2 != null) {
            i10 = str2.hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        return "BlockProfileRequest(blockType=" + this.blockType + ", blockReason=" + this.blockReason + PropertyUtils.MAPPED_DELIM2;
    }
}

package com.coffeemeetsbagel.models;

import com.coffeemeetsbagel.models.enums.Reason;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class DeactivateReason {
    private boolean checked;
    private final String description;
    private final Reason reasonId;

    public DeactivateReason(Reason reason, boolean z10, String str) {
        j.g(reason, "reasonId");
        j.g(str, "description");
        this.reasonId = reason;
        this.checked = z10;
        this.description = str;
    }

    public static /* synthetic */ DeactivateReason copy$default(DeactivateReason deactivateReason, Reason reason, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            reason = deactivateReason.reasonId;
        }
        if ((i10 & 2) != 0) {
            z10 = deactivateReason.checked;
        }
        if ((i10 & 4) != 0) {
            str = deactivateReason.description;
        }
        return deactivateReason.copy(reason, z10, str);
    }

    public final Reason component1() {
        return this.reasonId;
    }

    public final boolean component2() {
        return this.checked;
    }

    public final String component3() {
        return this.description;
    }

    public final DeactivateReason copy(Reason reason, boolean z10, String str) {
        j.g(reason, "reasonId");
        j.g(str, "description");
        return new DeactivateReason(reason, z10, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeactivateReason)) {
            return false;
        }
        DeactivateReason deactivateReason = (DeactivateReason) obj;
        return this.reasonId == deactivateReason.reasonId && this.checked == deactivateReason.checked && j.b(this.description, deactivateReason.description);
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Reason getReasonId() {
        return this.reasonId;
    }

    public int hashCode() {
        int hashCode = this.reasonId.hashCode() * 31;
        boolean z10 = this.checked;
        if (z10) {
            z10 = true;
        }
        return ((hashCode + (z10 ? 1 : 0)) * 31) + this.description.hashCode();
    }

    public final void setChecked(boolean z10) {
        this.checked = z10;
    }

    public String toString() {
        return "DeactivateReason(reasonId=" + this.reasonId + ", checked=" + this.checked + ", description=" + this.description + PropertyUtils.MAPPED_DELIM2;
    }
}

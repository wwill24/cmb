package net.bytebuddy.jar.asm;

import org.apache.commons.beanutils.PropertyUtils;

public final class Handle {
    private final String descriptor;
    private final boolean isInterface;
    private final String name;
    private final String owner;
    private final int tag;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public Handle(int i10, String str, String str2, String str3) {
        this(i10, str, str2, str3, i10 == 9);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Handle)) {
            return false;
        }
        Handle handle = (Handle) obj;
        if (this.tag != handle.tag || this.isInterface != handle.isInterface || !this.owner.equals(handle.owner) || !this.name.equals(handle.name) || !this.descriptor.equals(handle.descriptor)) {
            return false;
        }
        return true;
    }

    public String getDesc() {
        return this.descriptor;
    }

    public String getName() {
        return this.name;
    }

    public String getOwner() {
        return this.owner;
    }

    public int getTag() {
        return this.tag;
    }

    public int hashCode() {
        int i10;
        int i11 = this.tag;
        if (this.isInterface) {
            i10 = 64;
        } else {
            i10 = 0;
        }
        return i11 + i10 + (this.owner.hashCode() * this.name.hashCode() * this.descriptor.hashCode());
    }

    public boolean isInterface() {
        return this.isInterface;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.owner);
        sb2.append('.');
        sb2.append(this.name);
        sb2.append(this.descriptor);
        sb2.append(" (");
        sb2.append(this.tag);
        sb2.append(this.isInterface ? " itf" : "");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        return sb2.toString();
    }

    public Handle(int i10, String str, String str2, String str3, boolean z10) {
        this.tag = i10;
        this.owner = str;
        this.name = str2;
        this.descriptor = str3;
        this.isInterface = z10;
    }
}

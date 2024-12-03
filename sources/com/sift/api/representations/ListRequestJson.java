package com.sift.api.representations;

import java.util.ArrayList;
import java.util.List;
import lg.a;
import lg.c;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.beanutils.PropertyUtils;

public class ListRequestJson {
    @a
    @c("data")
    public List<Object> data = new ArrayList();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListRequestJson)) {
            return false;
        }
        List<Object> list = this.data;
        List<Object> list2 = ((ListRequestJson) obj).data;
        if (list == list2) {
            return true;
        }
        if (list == null || !list.equals(list2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        List<Object> list = this.data;
        return 31 + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ListRequestJson.class.getName());
        sb2.append('@');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append('[');
        sb2.append("data");
        sb2.append(SignatureVisitor.INSTANCEOF);
        Object obj = this.data;
        if (obj == null) {
            obj = "<null>";
        }
        sb2.append(obj);
        sb2.append(',');
        if (sb2.charAt(sb2.length() - 1) == ',') {
            sb2.setCharAt(sb2.length() - 1, PropertyUtils.INDEXED_DELIM2);
        } else {
            sb2.append(PropertyUtils.INDEXED_DELIM2);
        }
        return sb2.toString();
    }

    public ListRequestJson withData(List<Object> list) {
        this.data = list;
        return this;
    }
}

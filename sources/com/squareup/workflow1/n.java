package com.squareup.workflow1;

import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\r\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/squareup/workflow1/n;", "OutputT", "", "", "toString", "other", "", "equals", "", "hashCode", "a", "Ljava/lang/Object;", "()Ljava/lang/Object;", "value", "<init>", "(Ljava/lang/Object;)V", "wf1-workflow-core"}, k = 1, mv = {1, 6, 0})
public final class n<OutputT> {

    /* renamed from: a  reason: collision with root package name */
    private final OutputT f23147a;

    public n(OutputT outputt) {
        this.f23147a = outputt;
    }

    public final OutputT a() {
        return this.f23147a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        return j.b(this.f23147a, ((n) obj).f23147a);
    }

    public int hashCode() {
        OutputT outputt = this.f23147a;
        if (outputt == null) {
            return 0;
        }
        return outputt.hashCode();
    }

    public String toString() {
        return "WorkflowOutput(" + this.f23147a + PropertyUtils.MAPPED_DELIM2;
    }
}

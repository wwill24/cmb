package com.mparticle;

import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/mparticle/w0;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/mparticle/v0;", "a", "Lcom/mparticle/v0;", "()Lcom/mparticle/v0;", "sdk", "b", "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", "version", "<init>", "(Lcom/mparticle/v0;Ljava/lang/String;)V", "android-core_release"}, k = 1, mv = {1, 7, 1})
public final class w0 {

    /* renamed from: a  reason: collision with root package name */
    private final v0 f22646a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22647b;

    public w0(v0 v0Var, String str) {
        j.g(v0Var, "sdk");
        this.f22646a = v0Var;
        this.f22647b = str;
    }

    public final v0 a() {
        return this.f22646a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w0)) {
            return false;
        }
        w0 w0Var = (w0) obj;
        return this.f22646a == w0Var.f22646a && j.b(this.f22647b, w0Var.f22647b);
    }

    public int hashCode() {
        int hashCode = this.f22646a.hashCode() * 31;
        String str = this.f22647b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "WrapperSdkVersion(sdk=" + this.f22646a + ", version=" + this.f22647b + PropertyUtils.MAPPED_DELIM2;
    }
}

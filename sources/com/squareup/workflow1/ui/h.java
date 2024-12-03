package com.squareup.workflow1.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u000f\u001a\u00028\u0000\u0012\u0006\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u000f\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\u00020\u00048\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/squareup/workflow1/ui/h;", "", "W", "Lcom/squareup/workflow1/ui/d;", "", "toString", "", "hashCode", "other", "", "equals", "b", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "wrapped", "c", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "d", "compatibilityKey", "<init>", "(Ljava/lang/Object;Ljava/lang/String;)V", "wf1-core-common"}, k = 1, mv = {1, 6, 0})
public final class h<W> implements d {

    /* renamed from: b  reason: collision with root package name */
    private final W f23240b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23241c;

    /* renamed from: d  reason: collision with root package name */
    private final String f23242d;

    public h(W w10, String str) {
        j.g(w10, "wrapped");
        j.g(str, "name");
        this.f23240b = w10;
        this.f23241c = str;
        if (!r.w(str)) {
            this.f23242d = d.f23236a.a(w10, str);
            return;
        }
        throw new IllegalArgumentException("name must not be blank.".toString());
    }

    public final W a() {
        return this.f23240b;
    }

    public String c() {
        return this.f23242d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return j.b(this.f23240b, hVar.f23240b) && j.b(this.f23241c, hVar.f23241c);
    }

    public int hashCode() {
        return (this.f23240b.hashCode() * 31) + this.f23241c.hashCode();
    }

    public String toString() {
        return super.toString() + ": " + c();
    }
}

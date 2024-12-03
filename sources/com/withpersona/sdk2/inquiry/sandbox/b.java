package com.withpersona.sdk2.inquiry.sandbox;

import com.withpersona.sdk2.inquiry.sandbox.SandboxFlags;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class b<R> {

    /* renamed from: a  reason: collision with root package name */
    private final R f27162a;

    /* renamed from: b  reason: collision with root package name */
    private final Function0<Unit> f27163b;

    /* renamed from: c  reason: collision with root package name */
    private final Function0<SandboxFlags.ForcedStatus> f27164c;

    public b(R r10, Function0<Unit> function0, Function0<? extends SandboxFlags.ForcedStatus> function02) {
        j.g(r10, "mainScreen");
        j.g(function0, "onFabClick");
        j.g(function02, "getCurrentForcedStatus");
        this.f27162a = r10;
        this.f27163b = function0;
        this.f27164c = function02;
    }

    public final Function0<SandboxFlags.ForcedStatus> a() {
        return this.f27164c;
    }

    public final R b() {
        return this.f27162a;
    }

    public final Function0<Unit> c() {
        return this.f27163b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return j.b(this.f27162a, bVar.f27162a) && j.b(this.f27163b, bVar.f27163b) && j.b(this.f27164c, bVar.f27164c);
    }

    public int hashCode() {
        return (((this.f27162a.hashCode() * 31) + this.f27163b.hashCode()) * 31) + this.f27164c.hashCode();
    }

    public String toString() {
        return "SandboxScreen(mainScreen=" + this.f27162a + ", onFabClick=" + this.f27163b + ", getCurrentForcedStatus=" + this.f27164c + PropertyUtils.MAPPED_DELIM2;
    }
}

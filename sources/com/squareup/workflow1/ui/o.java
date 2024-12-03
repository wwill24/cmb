package com.squareup.workflow1.ui;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import wk.c;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B%\b\u0002\u0012\u001a\u0010\u000b\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\b¢\u0006\u0004\b\f\u0010\rB%\b\u0016\u0012\u001a\u0010\u000b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u000e\"\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\f\u0010\u000fJ*\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\"\b\b\u0000\u0010\u0003*\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004H\u0016R(\u0010\u000b\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/squareup/workflow1/ui/o;", "Lcom/squareup/workflow1/ui/s;", "", "RenderingT", "Lwk/c;", "renderingType", "Lcom/squareup/workflow1/ui/r;", "a", "", "b", "Ljava/util/Map;", "bindings", "<init>", "(Ljava/util/Map;)V", "", "([Lcom/squareup/workflow1/ui/r;)V", "wf1-core-android"}, k = 1, mv = {1, 6, 0})
public final class o implements s {

    /* renamed from: b  reason: collision with root package name */
    private final Map<c<?>, r<?>> f23290b;

    private o(Map<c<?>, ? extends r<?>> map) {
        this.f23290b = map;
    }

    public <RenderingT> r<RenderingT> a(c<? extends RenderingT> cVar) {
        j.g(cVar, "renderingType");
        r<?> rVar = this.f23290b.get(cVar);
        if (rVar instanceof r) {
            return rVar;
        }
        return null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public o(com.squareup.workflow1.ui.r<?>... r7) {
        /*
            r6 = this;
            java.lang.String r0 = "bindings"
            kotlin.jvm.internal.j.g(r7, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r7.length
            r0.<init>(r1)
            int r1 = r7.length
            r2 = 0
            r3 = r2
        L_0x000e:
            if (r3 >= r1) goto L_0x0020
            r4 = r7[r3]
            int r3 = r3 + 1
            wk.c r5 = r4.getType()
            kotlin.Pair r4 = gk.h.a(r5, r4)
            r0.add(r4)
            goto L_0x000e
        L_0x0020:
            java.util.Map r0 = kotlin.collections.h0.s(r0)
            java.util.Set r1 = r0.keySet()
            int r1 = r1.size()
            int r3 = r7.length
            if (r1 != r3) goto L_0x0031
            r1 = 1
            goto L_0x0032
        L_0x0031:
            r1 = r2
        L_0x0032:
            if (r1 != 0) goto L_0x0064
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r3 = r7.length
            r1.<init>(r3)
            int r3 = r7.length
        L_0x0040:
            if (r2 >= r3) goto L_0x004e
            r4 = r7[r2]
            int r2 = r2 + 1
            wk.c r4 = r4.getType()
            r1.add(r4)
            goto L_0x0040
        L_0x004e:
            r0.append(r1)
            java.lang.String r7 = " must not have duplicate entries."
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r0.<init>(r7)
            throw r0
        L_0x0064:
            r6.<init>((java.util.Map<wk.c<?>, ? extends com.squareup.workflow1.ui.r<?>>) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.workflow1.ui.o.<init>(com.squareup.workflow1.ui.r[]):void");
    }
}

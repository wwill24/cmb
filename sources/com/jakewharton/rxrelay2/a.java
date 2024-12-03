package com.jakewharton.rxrelay2;

import vj.l;

class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f22159a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f22160b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f22161c;

    /* renamed from: d  reason: collision with root package name */
    private int f22162d;

    /* renamed from: com.jakewharton.rxrelay2.a$a  reason: collision with other inner class name */
    public interface C0252a<T> extends l<T> {
        boolean test(T t10);
    }

    a(int i10) {
        this.f22159a = i10;
        Object[] objArr = new Object[(i10 + 1)];
        this.f22160b = objArr;
        this.f22161c = objArr;
    }

    /* access modifiers changed from: package-private */
    public void a(c<? super T> cVar) {
        int i10 = this.f22159a;
        for (Object[] objArr = this.f22160b; objArr != null; objArr = objArr[i10]) {
            for (int i11 = 0; i11 < i10; i11++) {
                Object[] objArr2 = objArr[i11];
                if (objArr2 == null) {
                    break;
                }
                cVar.accept(objArr2);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object[]} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(T r4) {
        /*
            r3 = this;
            int r0 = r3.f22159a
            int r1 = r3.f22162d
            if (r1 != r0) goto L_0x0011
            int r1 = r0 + 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object[] r2 = r3.f22161c
            r2[r0] = r1
            r3.f22161c = r1
            r1 = 0
        L_0x0011:
            java.lang.Object[] r0 = r3.f22161c
            r0[r1] = r4
            int r1 = r1 + 1
            r3.f22162d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.rxrelay2.a.b(java.lang.Object):void");
    }

    /* access modifiers changed from: package-private */
    public void c(C0252a<? super T> aVar) {
        int i10 = this.f22159a;
        for (Object[] objArr = this.f22160b; objArr != null; objArr = objArr[i10]) {
            for (int i11 = 0; i11 < i10; i11++) {
                Object[] objArr2 = objArr[i11];
                if (objArr2 == null || aVar.test(objArr2)) {
                    break;
                }
            }
        }
    }
}

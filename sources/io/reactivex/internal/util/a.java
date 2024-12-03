package io.reactivex.internal.util;

import qj.u;
import rn.b;
import vj.l;

public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final int f30716a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f30717b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f30718c;

    /* renamed from: d  reason: collision with root package name */
    int f30719d;

    /* renamed from: io.reactivex.internal.util.a$a  reason: collision with other inner class name */
    public interface C0358a<T> extends l<T> {
        boolean test(T t10);
    }

    public a(int i10) {
        this.f30716a = i10;
        Object[] objArr = new Object[(i10 + 1)];
        this.f30717b = objArr;
        this.f30718c = objArr;
    }

    public <U> boolean a(u<? super U> uVar) {
        Object[] objArr = this.f30717b;
        int i10 = this.f30716a;
        while (true) {
            int i11 = 0;
            if (objArr == null) {
                return false;
            }
            while (i11 < i10) {
                Object[] objArr2 = objArr[i11];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (NotificationLite.b(objArr2, uVar)) {
                    return true;
                } else {
                    i11++;
                }
            }
            objArr = objArr[i10];
        }
    }

    public <U> boolean b(b<? super U> bVar) {
        Object[] objArr = this.f30717b;
        int i10 = this.f30716a;
        while (true) {
            int i11 = 0;
            if (objArr == null) {
                return false;
            }
            while (i11 < i10) {
                Object[] objArr2 = objArr[i11];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (NotificationLite.c(objArr2, bVar)) {
                    return true;
                } else {
                    i11++;
                }
            }
            objArr = objArr[i10];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(T r4) {
        /*
            r3 = this;
            int r0 = r3.f30716a
            int r1 = r3.f30719d
            if (r1 != r0) goto L_0x0011
            int r1 = r0 + 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object[] r2 = r3.f30718c
            r2[r0] = r1
            r3.f30718c = r1
            r1 = 0
        L_0x0011:
            java.lang.Object[] r0 = r3.f30718c
            r0[r1] = r4
            int r1 = r1 + 1
            r3.f30719d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.a.c(java.lang.Object):void");
    }

    public void d(C0358a<? super T> aVar) {
        int i10 = this.f30716a;
        for (Object[] objArr = this.f30717b; objArr != null; objArr = objArr[i10]) {
            int i11 = 0;
            while (i11 < i10) {
                Object[] objArr2 = objArr[i11];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (!aVar.test(objArr2)) {
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public void e(T t10) {
        this.f30717b[0] = t10;
    }
}

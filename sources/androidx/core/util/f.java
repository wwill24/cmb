package androidx.core.util;

import androidx.annotation.NonNull;

public class f<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f4737a;

    /* renamed from: b  reason: collision with root package name */
    private int f4738b;

    public f(int i10) {
        if (i10 > 0) {
            this.f4737a = new Object[i10];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private boolean b(@NonNull T t10) {
        for (int i10 = 0; i10 < this.f4738b; i10++) {
            if (this.f4737a[i10] == t10) {
                return true;
            }
        }
        return false;
    }

    public boolean a(@NonNull T t10) {
        if (!b(t10)) {
            int i10 = this.f4738b;
            Object[] objArr = this.f4737a;
            if (i10 >= objArr.length) {
                return false;
            }
            objArr[i10] = t10;
            this.f4738b = i10 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }

    public T acquire() {
        int i10 = this.f4738b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        T[] tArr = this.f4737a;
        T t10 = tArr[i11];
        tArr[i11] = null;
        this.f4738b = i10 - 1;
        return t10;
    }
}

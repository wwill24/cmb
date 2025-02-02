package androidx.constraintlayout.core;

class f<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f3709a;

    /* renamed from: b  reason: collision with root package name */
    private int f3710b;

    f(int i10) {
        if (i10 > 0) {
            this.f3709a = new Object[i10];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public boolean a(T t10) {
        int i10 = this.f3710b;
        Object[] objArr = this.f3709a;
        if (i10 >= objArr.length) {
            return false;
        }
        objArr[i10] = t10;
        this.f3710b = i10 + 1;
        return true;
    }

    public T acquire() {
        int i10 = this.f3710b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        T[] tArr = this.f3709a;
        T t10 = tArr[i11];
        tArr[i11] = null;
        this.f3710b = i10 - 1;
        return t10;
    }

    public void b(T[] tArr, int i10) {
        if (i10 > tArr.length) {
            i10 = tArr.length;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            T t10 = tArr[i11];
            int i12 = this.f3710b;
            Object[] objArr = this.f3709a;
            if (i12 < objArr.length) {
                objArr[i12] = t10;
                this.f3710b = i12 + 1;
            }
        }
    }
}

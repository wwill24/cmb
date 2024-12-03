package com.coffeemeetsbagel.likes_you;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.j;

public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private int f34165a;

    /* renamed from: b  reason: collision with root package name */
    private int f34166b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34167c;

    /* renamed from: d  reason: collision with root package name */
    private List<T> f34168d;

    public a(T[] tArr, int i10) {
        j.g(tArr, "list");
        int length = tArr.length;
        this.f34167c = length;
        ArrayList arrayList = new ArrayList(length);
        for (int i11 = 0; i11 < length; i11++) {
            arrayList.add((Object) null);
        }
        this.f34168d = arrayList;
        this.f34165a = -1;
        this.f34166b = -1;
        ArrayList arrayList2 = new ArrayList(tArr.length);
        for (T a10 : tArr) {
            a(a10);
            arrayList2.add(Unit.f32013a);
        }
        this.f34165a = i10;
        int i12 = this.f34167c;
        this.f34166b = ((i10 + i12) - 1) % i12;
    }

    private final boolean c() {
        int i10 = this.f34165a;
        if ((i10 == 0 && this.f34166b == this.f34167c - 1) || i10 == this.f34166b + 1) {
            return true;
        }
        return false;
    }

    public final void a(T t10) {
        if (!c()) {
            if (this.f34165a == -1) {
                this.f34165a = 0;
            }
            int i10 = (this.f34166b + 1) % this.f34167c;
            this.f34166b = i10;
            this.f34168d.set(i10, t10);
        }
    }

    public final boolean b() {
        return this.f34165a == -1;
    }

    public final T d() {
        if (b()) {
            return null;
        }
        T t10 = this.f34168d.get(this.f34165a);
        int i10 = this.f34165a;
        if (i10 == this.f34166b) {
            this.f34165a = -1;
            this.f34166b = -1;
            return t10;
        }
        this.f34165a = (i10 + 1) % this.f34167c;
        return t10;
    }
}

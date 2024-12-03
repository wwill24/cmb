package vk;

import java.util.NoSuchElementException;
import kotlin.collections.b0;

public final class d extends b0 {

    /* renamed from: a  reason: collision with root package name */
    private final int f33924a;

    /* renamed from: b  reason: collision with root package name */
    private final int f33925b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f33926c;

    /* renamed from: d  reason: collision with root package name */
    private int f33927d;

    public d(int i10, int i11, int i12) {
        this.f33924a = i12;
        this.f33925b = i11;
        boolean z10 = true;
        if (i12 <= 0 ? i10 < i11 : i10 > i11) {
            z10 = false;
        }
        this.f33926c = z10;
        this.f33927d = !z10 ? i11 : i10;
    }

    public boolean hasNext() {
        return this.f33926c;
    }

    public int nextInt() {
        int i10 = this.f33927d;
        if (i10 != this.f33925b) {
            this.f33927d = this.f33924a + i10;
        } else if (this.f33926c) {
            this.f33926c = false;
        } else {
            throw new NoSuchElementException();
        }
        return i10;
    }
}

package vk;

import java.util.NoSuchElementException;
import kotlin.collections.n;
import kotlin.jvm.internal.j;

public final class b extends n {

    /* renamed from: a  reason: collision with root package name */
    private final int f33918a;

    /* renamed from: b  reason: collision with root package name */
    private final int f33919b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f33920c;

    /* renamed from: d  reason: collision with root package name */
    private int f33921d;

    public b(char c10, char c11, int i10) {
        this.f33918a = i10;
        this.f33919b = c11;
        boolean z10 = true;
        if (i10 <= 0 ? j.i(c10, c11) < 0 : j.i(c10, c11) > 0) {
            z10 = false;
        }
        this.f33920c = z10;
        this.f33921d = !z10 ? c11 : c10;
    }

    public char a() {
        int i10 = this.f33921d;
        if (i10 != this.f33919b) {
            this.f33921d = this.f33918a + i10;
        } else if (this.f33920c) {
            this.f33920c = false;
        } else {
            throw new NoSuchElementException();
        }
        return (char) i10;
    }

    public boolean hasNext() {
        return this.f33920c;
    }
}

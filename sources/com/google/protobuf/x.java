package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

class x extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<ByteBuffer> f21963a;

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f21964b;

    /* renamed from: c  reason: collision with root package name */
    private int f21965c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f21966d;

    /* renamed from: e  reason: collision with root package name */
    private int f21967e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f21968f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f21969g;

    /* renamed from: h  reason: collision with root package name */
    private int f21970h;

    /* renamed from: j  reason: collision with root package name */
    private long f21971j;

    x(Iterable<ByteBuffer> iterable) {
        this.f21963a = iterable.iterator();
        for (ByteBuffer next : iterable) {
            this.f21965c++;
        }
        this.f21966d = -1;
        if (!a()) {
            this.f21964b = w.f21956e;
            this.f21966d = 0;
            this.f21967e = 0;
            this.f21971j = 0;
        }
    }

    private boolean a() {
        this.f21966d++;
        if (!this.f21963a.hasNext()) {
            return false;
        }
        ByteBuffer next = this.f21963a.next();
        this.f21964b = next;
        this.f21967e = next.position();
        if (this.f21964b.hasArray()) {
            this.f21968f = true;
            this.f21969g = this.f21964b.array();
            this.f21970h = this.f21964b.arrayOffset();
        } else {
            this.f21968f = false;
            this.f21971j = j1.k(this.f21964b);
            this.f21969g = null;
        }
        return true;
    }

    private void b(int i10) {
        int i11 = this.f21967e + i10;
        this.f21967e = i11;
        if (i11 == this.f21964b.limit()) {
            a();
        }
    }

    public int read() throws IOException {
        if (this.f21966d == this.f21965c) {
            return -1;
        }
        if (this.f21968f) {
            byte b10 = this.f21969g[this.f21967e + this.f21970h] & 255;
            b(1);
            return b10;
        }
        byte w10 = j1.w(((long) this.f21967e) + this.f21971j) & 255;
        b(1);
        return w10;
    }

    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (this.f21966d == this.f21965c) {
            return -1;
        }
        int limit = this.f21964b.limit();
        int i12 = this.f21967e;
        int i13 = limit - i12;
        if (i11 > i13) {
            i11 = i13;
        }
        if (this.f21968f) {
            System.arraycopy(this.f21969g, i12 + this.f21970h, bArr, i10, i11);
            b(i11);
        } else {
            int position = this.f21964b.position();
            ByteBuffer byteBuffer = (ByteBuffer) this.f21964b.position(this.f21967e);
            this.f21964b.get(bArr, i10, i11);
            ByteBuffer byteBuffer2 = (ByteBuffer) this.f21964b.position(position);
            b(i11);
        }
        return i11;
    }
}

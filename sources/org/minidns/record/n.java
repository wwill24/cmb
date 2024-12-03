package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import zm.b;

public class n extends h {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f41685c;

    /* renamed from: d  reason: collision with root package name */
    private transient String f41686d;

    n(byte[] bArr) {
        this.f41685c = bArr;
    }

    public static n j(DataInputStream dataInputStream, int i10) throws IOException {
        byte[] bArr = new byte[i10];
        dataInputStream.readFully(bArr);
        return new n(bArr);
    }

    public void c(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.f41685c);
    }

    public String i() {
        if (this.f41686d == null) {
            this.f41686d = b.a(this.f41685c);
        }
        return this.f41686d;
    }

    public String toString() {
        return i();
    }
}

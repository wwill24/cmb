package org.minidns.record;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import org.minidns.record.Record;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f41661a;

    /* renamed from: b  reason: collision with root package name */
    private transient Integer f41662b;

    private void d() {
        if (this.f41661a == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                c(new DataOutputStream(byteArrayOutputStream));
                this.f41661a = byteArrayOutputStream.toByteArray();
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public abstract Record.TYPE a();

    public final int b() {
        d();
        return this.f41661a.length;
    }

    /* access modifiers changed from: protected */
    public abstract void c(DataOutputStream dataOutputStream) throws IOException;

    public final byte[] e() {
        d();
        return (byte[]) this.f41661a.clone();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        h hVar = (h) obj;
        hVar.d();
        d();
        return Arrays.equals(this.f41661a, hVar.f41661a);
    }

    public final void h(DataOutputStream dataOutputStream) throws IOException {
        d();
        dataOutputStream.write(this.f41661a);
    }

    public final int hashCode() {
        if (this.f41662b == null) {
            d();
            this.f41662b = Integer.valueOf(Arrays.hashCode(this.f41661a));
        }
        return this.f41662b.intValue();
    }
}

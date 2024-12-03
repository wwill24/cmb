package ym;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.minidns.record.b;
import org.minidns.record.h;

public abstract class a<IA extends InetAddress> extends h {

    /* renamed from: c  reason: collision with root package name */
    protected final byte[] f42184c;

    /* renamed from: d  reason: collision with root package name */
    private transient IA f42185d;

    protected a(byte[] bArr) {
        this.f42184c = bArr;
    }

    public static a<? extends InetAddress> i(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return new org.minidns.record.a((Inet4Address) inetAddress);
        }
        return new b((Inet6Address) inetAddress);
    }

    public final void c(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.f42184c);
    }

    public final IA j() {
        if (this.f42185d == null) {
            try {
                this.f42185d = InetAddress.getByAddress(this.f42184c);
            } catch (UnknownHostException e10) {
                throw new IllegalStateException(e10);
            }
        }
        return this.f42185d;
    }

    public final byte[] k() {
        return (byte[]) this.f42184c.clone();
    }

    protected a(IA ia2) {
        this(ia2.getAddress());
        this.f42185d = ia2;
    }
}

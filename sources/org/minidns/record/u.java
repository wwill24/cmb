package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.minidns.record.Record;

public final class u extends h {

    /* renamed from: c  reason: collision with root package name */
    private final Record.TYPE f41714c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f41715d;

    private u(DataInputStream dataInputStream, int i10, Record.TYPE type) throws IOException {
        this.f41714c = type;
        byte[] bArr = new byte[i10];
        this.f41715d = bArr;
        dataInputStream.readFully(bArr);
    }

    public static u i(DataInputStream dataInputStream, int i10, Record.TYPE type) throws IOException {
        return new u(dataInputStream, i10, type);
    }

    public void c(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.f41715d);
    }
}

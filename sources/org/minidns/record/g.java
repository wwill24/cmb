package org.minidns.record;

import java.io.DataInputStream;
import java.io.IOException;
import org.minidns.record.Record;
import org.minidns.record.i;

public class g extends i {
    public g(int i10, byte b10, byte b11, byte[] bArr) {
        super(i10, b10, b11, bArr);
    }

    public static g k(DataInputStream dataInputStream, int i10) throws IOException {
        i.b j10 = i.j(dataInputStream, i10);
        return new g(j10.f41669a, j10.f41670b, j10.f41671c, j10.f41672d);
    }

    public Record.TYPE a() {
        return Record.TYPE.DS;
    }
}

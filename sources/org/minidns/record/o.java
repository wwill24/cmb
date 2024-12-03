package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.minidns.edns.a;

public class o extends h {

    /* renamed from: c  reason: collision with root package name */
    public final List<a> f41687c;

    public o() {
        this(Collections.emptyList());
    }

    public static o i(DataInputStream dataInputStream, int i10) throws IOException {
        List list;
        if (i10 == 0) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList = new ArrayList(4);
            while (i10 > 0) {
                int readUnsignedShort = dataInputStream.readUnsignedShort();
                int readUnsignedShort2 = dataInputStream.readUnsignedShort();
                byte[] bArr = new byte[readUnsignedShort2];
                dataInputStream.read(bArr);
                arrayList.add(a.d(readUnsignedShort, bArr));
                i10 -= readUnsignedShort2 + 4;
            }
            list = arrayList;
        }
        return new o(list);
    }

    /* access modifiers changed from: protected */
    public void c(DataOutputStream dataOutputStream) throws IOException {
        for (a f10 : this.f41687c) {
            f10.f(dataOutputStream);
        }
    }

    public o(List<a> list) {
        this.f41687c = Collections.unmodifiableList(list);
    }
}

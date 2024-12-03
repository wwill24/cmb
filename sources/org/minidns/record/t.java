package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class t extends h {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f41711c;

    /* renamed from: d  reason: collision with root package name */
    private transient String f41712d;

    /* renamed from: e  reason: collision with root package name */
    private transient List<String> f41713e;

    public t(byte[] bArr) {
        this.f41711c = bArr;
    }

    public static t l(DataInputStream dataInputStream, int i10) throws IOException {
        byte[] bArr = new byte[i10];
        dataInputStream.readFully(bArr);
        return new t(bArr);
    }

    public void c(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.write(this.f41711c);
    }

    public List<String> i() {
        if (this.f41713e == null) {
            List<byte[]> j10 = j();
            ArrayList arrayList = new ArrayList(j10.size());
            for (byte[] str : j10) {
                try {
                    arrayList.add(new String(str, "UTF-8"));
                } catch (UnsupportedEncodingException e10) {
                    throw new AssertionError(e10);
                }
            }
            this.f41713e = Collections.unmodifiableList(arrayList);
        }
        return this.f41713e;
    }

    public List<byte[]> j() {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f41711c;
            if (i10 >= bArr.length) {
                return arrayList;
            }
            int i11 = i10 + 1;
            int i12 = (bArr[i10] & 255) + i11;
            arrayList.add(Arrays.copyOfRange(bArr, i11, i12));
            i10 = i12;
        }
    }

    public String k() {
        if (this.f41712d == null) {
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = i().iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                if (it.hasNext()) {
                    sb2.append(" / ");
                }
            }
            this.f41712d = sb2.toString();
        }
        return this.f41712d;
    }

    public String toString() {
        return "\"" + k() + "\"";
    }
}

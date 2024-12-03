package net.bytebuddy.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class StreamDrainer {
    public static final StreamDrainer DEFAULT = new StreamDrainer();
    public static final int DEFAULT_BUFFER_SIZE = 1024;
    private static final int END_OF_STREAM = -1;
    private static final int FROM_BEGINNING = 0;
    private final int bufferSize;

    public StreamDrainer() {
        this(1024);
    }

    public byte[] drain(InputStream inputStream) throws IOException {
        int read;
        ArrayList<byte[]> arrayList = new ArrayList<>();
        byte[] bArr = new byte[this.bufferSize];
        int i10 = 0;
        do {
            read = inputStream.read(bArr, i10, this.bufferSize - i10);
            i10 += Math.max(read, 0);
            if (i10 == this.bufferSize) {
                arrayList.add(bArr);
                bArr = new byte[this.bufferSize];
                i10 = 0;
            }
        } while (read != -1);
        byte[] bArr2 = new byte[((arrayList.size() * this.bufferSize) + i10)];
        int i11 = 0;
        for (byte[] arraycopy : arrayList) {
            int i12 = this.bufferSize;
            System.arraycopy(arraycopy, 0, bArr2, i11 * i12, i12);
            i11++;
        }
        System.arraycopy(bArr, 0, bArr2, i11 * this.bufferSize, i10);
        return bArr2;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.bufferSize == ((StreamDrainer) obj).bufferSize;
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.bufferSize;
    }

    public StreamDrainer(int i10) {
        this.bufferSize = i10;
    }
}

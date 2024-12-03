package org.bouncycastle.asn1;

import com.google.android.gms.common.api.a;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import net.bytebuddy.jar.asm.Opcodes;

class StreamUtil {
    private static final long MAX_MEMORY = Runtime.getRuntime().maxMemory();

    StreamUtil() {
    }

    static int calculateBodyLength(int i10) {
        int i11 = 1;
        if (i10 > 127) {
            int i12 = 1;
            while (true) {
                i10 >>>= 8;
                if (i10 == 0) {
                    break;
                }
                i12++;
            }
            for (int i13 = (i12 - 1) * 8; i13 >= 0; i13 -= 8) {
                i11++;
            }
        }
        return i11;
    }

    static int calculateTagLength(int i10) throws IOException {
        if (i10 < 31) {
            return 1;
        }
        if (i10 < 128) {
            return 2;
        }
        byte[] bArr = new byte[5];
        int i11 = 4;
        do {
            i10 >>= 7;
            i11--;
            bArr[i11] = (byte) ((i10 & Opcodes.LAND) | 128);
        } while (i10 > 127);
        return 1 + (5 - i11);
    }

    static int findLimit(InputStream inputStream) {
        if (inputStream instanceof LimitedInputStream) {
            return ((LimitedInputStream) inputStream).getLimit();
        }
        if (inputStream instanceof ASN1InputStream) {
            return ((ASN1InputStream) inputStream).getLimit();
        }
        if (inputStream instanceof ByteArrayInputStream) {
            return ((ByteArrayInputStream) inputStream).available();
        }
        if (inputStream instanceof FileInputStream) {
            try {
                FileChannel channel = ((FileInputStream) inputStream).getChannel();
                long size = channel != null ? channel.size() : 2147483647L;
                if (size < 2147483647L) {
                    return (int) size;
                }
            } catch (IOException unused) {
            }
        }
        long j10 = MAX_MEMORY;
        return j10 > 2147483647L ? a.e.API_PRIORITY_OTHER : (int) j10;
    }
}

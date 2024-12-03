package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.DataInputStream;
import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.util.SHA1;
import org.jxmpp.jid.Jid;

public class Socks5Utils {
    public static String createDigest(String str, Jid jid, Jid jid2) {
        return SHA1.hex(str + jid + jid2);
    }

    public static byte[] receiveSocks5Message(DataInputStream dataInputStream) throws IOException, SmackException.SmackMessageException {
        byte[] bArr = new byte[5];
        dataInputStream.readFully(bArr, 0, 5);
        if (bArr[3] == 3) {
            byte b10 = bArr[4];
            byte[] bArr2 = new byte[(b10 + 7)];
            System.arraycopy(bArr, 0, bArr2, 0, 5);
            dataInputStream.readFully(bArr2, 5, b10 + 2);
            return bArr2;
        }
        throw new SmackException.SmackMessageException("Unsupported SOCKS5 address type: " + bArr[3] + " (expected: 0x03)");
    }
}

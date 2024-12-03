package org.bouncycastle.util.encoders;

public class UrlBase64Encoder extends Base64Encoder {
    public UrlBase64Encoder() {
        byte[] bArr = this.encodingTable;
        bArr[bArr.length - 2] = Framer.STDIN_FRAME_PREFIX;
        bArr[bArr.length - 1] = Framer.STDIN_REQUEST_FRAME_PREFIX;
        this.padding = 46;
        initialiseDecodingTable();
    }
}

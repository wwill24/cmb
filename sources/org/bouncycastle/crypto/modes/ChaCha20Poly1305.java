package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.engines.ChaCha7539Engine;
import org.bouncycastle.crypto.macs.Poly1305;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class ChaCha20Poly1305 implements AEADCipher {
    private static final long AAD_LIMIT = -1;
    private static final int BUF_SIZE = 64;
    private static final long DATA_LIMIT = 274877906880L;
    private static final int KEY_SIZE = 32;
    private static final int MAC_SIZE = 16;
    private static final int NONCE_SIZE = 12;
    private static final byte[] ZEROES = new byte[15];
    private long aadCount;
    private final byte[] buf;
    private int bufPos;
    private final ChaCha7539Engine chacha20;
    private long dataCount;
    private byte[] initialAAD;
    private final byte[] key;
    private final byte[] mac;
    private final byte[] nonce;
    private final Mac poly1305;
    private int state;

    private static final class State {
        static final int DEC_AAD = 6;
        static final int DEC_DATA = 7;
        static final int DEC_FINAL = 8;
        static final int DEC_INIT = 5;
        static final int ENC_AAD = 2;
        static final int ENC_DATA = 3;
        static final int ENC_FINAL = 4;
        static final int ENC_INIT = 1;
        static final int UNINITIALIZED = 0;

        private State() {
        }
    }

    public ChaCha20Poly1305() {
        this(new Poly1305());
    }

    public ChaCha20Poly1305(Mac mac2) {
        this.key = new byte[32];
        this.nonce = new byte[12];
        this.buf = new byte[80];
        this.mac = new byte[16];
        this.state = 0;
        if (mac2 == null) {
            throw new NullPointerException("'poly1305' cannot be null");
        } else if (16 == mac2.getMacSize()) {
            this.chacha20 = new ChaCha7539Engine();
            this.poly1305 = mac2;
        } else {
            throw new IllegalArgumentException("'poly1305' must be a 128-bit MAC");
        }
    }

    private void checkAAD() {
        int i10 = this.state;
        int i11 = 2;
        if (i10 != 1) {
            if (i10 == 2) {
                return;
            }
            if (i10 != 4) {
                i11 = 6;
                if (i10 != 5) {
                    if (i10 != 6) {
                        throw new IllegalStateException();
                    }
                    return;
                }
            } else {
                throw new IllegalStateException("ChaCha20Poly1305 cannot be reused for encryption");
            }
        }
        this.state = i11;
    }

    private void checkData() {
        int i10;
        switch (this.state) {
            case 1:
            case 2:
                i10 = 3;
                break;
            case 3:
            case 7:
                return;
            case 4:
                throw new IllegalStateException("ChaCha20Poly1305 cannot be reused for encryption");
            case 5:
            case 6:
                i10 = 7;
                break;
            default:
                throw new IllegalStateException();
        }
        finishAAD(i10);
    }

    private void finishAAD(int i10) {
        padMAC(this.aadCount);
        this.state = i10;
    }

    private void finishData(int i10) {
        padMAC(this.dataCount);
        byte[] bArr = new byte[16];
        Pack.longToLittleEndian(this.aadCount, bArr, 0);
        Pack.longToLittleEndian(this.dataCount, bArr, 8);
        this.poly1305.update(bArr, 0, 16);
        this.poly1305.doFinal(this.mac, 0);
        this.state = i10;
    }

    private long incrementCount(long j10, int i10, long j11) {
        long j12 = (long) i10;
        if (j10 - Long.MIN_VALUE <= (j11 - j12) - Long.MIN_VALUE) {
            return j10 + j12;
        }
        throw new IllegalStateException("Limit exceeded");
    }

    private void initMAC() {
        byte[] bArr = new byte[64];
        try {
            this.chacha20.processBytes(bArr, 0, 64, bArr, 0);
            this.poly1305.init(new KeyParameter(bArr, 0, 32));
        } finally {
            Arrays.clear(bArr);
        }
    }

    private void padMAC(long j10) {
        int i10 = ((int) j10) & 15;
        if (i10 != 0) {
            this.poly1305.update(ZEROES, 0, 16 - i10);
        }
    }

    private void processData(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        if (i12 <= bArr2.length - i11) {
            this.chacha20.processBytes(bArr, i10, i11, bArr2, i12);
            this.dataCount = incrementCount(this.dataCount, i11, DATA_LIMIT);
            return;
        }
        throw new OutputLengthException("Output buffer too short");
    }

    private void reset(boolean z10, boolean z11) {
        Arrays.clear(this.buf);
        if (z10) {
            Arrays.clear(this.mac);
        }
        this.aadCount = 0;
        this.dataCount = 0;
        this.bufPos = 0;
        switch (this.state) {
            case 1:
            case 5:
                break;
            case 2:
            case 3:
            case 4:
                this.state = 4;
                return;
            case 6:
            case 7:
            case 8:
                this.state = 5;
                break;
            default:
                throw new IllegalStateException();
        }
        if (z11) {
            this.chacha20.reset();
        }
        initMAC();
        byte[] bArr = this.initialAAD;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }

    public int doFinal(byte[] bArr, int i10) throws IllegalStateException, InvalidCipherTextException {
        int i11;
        if (bArr == null) {
            throw new NullPointerException("'out' cannot be null");
        } else if (i10 >= 0) {
            checkData();
            Arrays.clear(this.mac);
            int i12 = this.state;
            if (i12 == 3) {
                int i13 = this.bufPos;
                i11 = i13 + 16;
                if (i10 <= bArr.length - i11) {
                    if (i13 > 0) {
                        processData(this.buf, 0, i13, bArr, i10);
                        this.poly1305.update(bArr, i10, this.bufPos);
                    }
                    finishData(4);
                    System.arraycopy(this.mac, 0, bArr, i10 + this.bufPos, 16);
                } else {
                    throw new OutputLengthException("Output buffer too short");
                }
            } else if (i12 == 7) {
                int i14 = this.bufPos;
                if (i14 >= 16) {
                    i11 = i14 - 16;
                    if (i10 <= bArr.length - i11) {
                        if (i11 > 0) {
                            this.poly1305.update(this.buf, 0, i11);
                            processData(this.buf, 0, i11, bArr, i10);
                        }
                        finishData(8);
                        if (!Arrays.constantTimeAreEqual(16, this.mac, 0, this.buf, i11)) {
                            throw new InvalidCipherTextException("mac check in ChaCha20Poly1305 failed");
                        }
                    } else {
                        throw new OutputLengthException("Output buffer too short");
                    }
                } else {
                    throw new InvalidCipherTextException("data too short");
                }
            } else {
                throw new IllegalStateException();
            }
            reset(false, true);
            return i11;
        } else {
            throw new IllegalArgumentException("'outOff' cannot be negative");
        }
    }

    public String getAlgorithmName() {
        return "ChaCha20Poly1305";
    }

    public byte[] getMac() {
        return Arrays.clone(this.mac);
    }

    public int getOutputSize(int i10) {
        int max = Math.max(0, i10) + this.bufPos;
        int i11 = this.state;
        if (i11 == 1 || i11 == 2 || i11 == 3) {
            return max + 16;
        }
        if (i11 == 5 || i11 == 6 || i11 == 7) {
            return Math.max(0, max - 16);
        }
        throw new IllegalStateException();
    }

    public int getUpdateOutputSize(int i10) {
        int max = Math.max(0, i10) + this.bufPos;
        int i11 = this.state;
        if (!(i11 == 1 || i11 == 2 || i11 == 3)) {
            if (i11 == 5 || i11 == 6 || i11 == 7) {
                max = Math.max(0, max - 16);
            } else {
                throw new IllegalStateException();
            }
        }
        return max - (max % 64);
    }

    /* JADX WARNING: type inference failed for: r8v9, types: [org.bouncycastle.crypto.CipherParameters] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(boolean r7, org.bouncycastle.crypto.CipherParameters r8) throws java.lang.IllegalArgumentException {
        /*
            r6 = this;
            boolean r0 = r8 instanceof org.bouncycastle.crypto.params.AEADParameters
            if (r0 == 0) goto L_0x0039
            org.bouncycastle.crypto.params.AEADParameters r8 = (org.bouncycastle.crypto.params.AEADParameters) r8
            int r0 = r8.getMacSize()
            r1 = 128(0x80, float:1.794E-43)
            if (r1 != r0) goto L_0x0022
            org.bouncycastle.crypto.params.KeyParameter r0 = r8.getKey()
            byte[] r1 = r8.getNonce()
            org.bouncycastle.crypto.params.ParametersWithIV r2 = new org.bouncycastle.crypto.params.ParametersWithIV
            r2.<init>(r0, r1)
            byte[] r8 = r8.getAssociatedText()
            r6.initialAAD = r8
            goto L_0x004e
        L_0x0022:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "Invalid value for MAC size: "
            r8.append(r1)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0039:
            boolean r0 = r8 instanceof org.bouncycastle.crypto.params.ParametersWithIV
            if (r0 == 0) goto L_0x00c4
            r2 = r8
            org.bouncycastle.crypto.params.ParametersWithIV r2 = (org.bouncycastle.crypto.params.ParametersWithIV) r2
            org.bouncycastle.crypto.CipherParameters r8 = r2.getParameters()
            r0 = r8
            org.bouncycastle.crypto.params.KeyParameter r0 = (org.bouncycastle.crypto.params.KeyParameter) r0
            byte[] r1 = r2.getIV()
            r8 = 0
            r6.initialAAD = r8
        L_0x004e:
            r8 = 32
            if (r0 != 0) goto L_0x005f
            int r3 = r6.state
            if (r3 == 0) goto L_0x0057
            goto L_0x0066
        L_0x0057:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Key must be specified in initial init"
            r7.<init>(r8)
            throw r7
        L_0x005f:
            byte[] r3 = r0.getKey()
            int r3 = r3.length
            if (r8 != r3) goto L_0x00bc
        L_0x0066:
            if (r1 == 0) goto L_0x00b4
            int r3 = r1.length
            r4 = 12
            if (r4 != r3) goto L_0x00b4
            int r3 = r6.state
            if (r3 == 0) goto L_0x0092
            if (r7 == 0) goto L_0x0092
            byte[] r3 = r6.nonce
            boolean r3 = org.bouncycastle.util.Arrays.areEqual((byte[]) r3, (byte[]) r1)
            if (r3 == 0) goto L_0x0092
            if (r0 == 0) goto L_0x008a
            byte[] r3 = r6.key
            byte[] r5 = r0.getKey()
            boolean r3 = org.bouncycastle.util.Arrays.areEqual((byte[]) r3, (byte[]) r5)
            if (r3 != 0) goto L_0x008a
            goto L_0x0092
        L_0x008a:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "cannot reuse nonce for ChaCha20Poly1305 encryption"
            r7.<init>(r8)
            throw r7
        L_0x0092:
            r3 = 0
            if (r0 == 0) goto L_0x009e
            byte[] r0 = r0.getKey()
            byte[] r5 = r6.key
            java.lang.System.arraycopy(r0, r3, r5, r3, r8)
        L_0x009e:
            byte[] r8 = r6.nonce
            java.lang.System.arraycopy(r1, r3, r8, r3, r4)
            org.bouncycastle.crypto.engines.ChaCha7539Engine r8 = r6.chacha20
            r0 = 1
            r8.init(r0, r2)
            if (r7 == 0) goto L_0x00ad
            r7 = r0
            goto L_0x00ae
        L_0x00ad:
            r7 = 5
        L_0x00ae:
            r6.state = r7
            r6.reset(r0, r3)
            return
        L_0x00b4:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Nonce must be 96 bits"
            r7.<init>(r8)
            throw r7
        L_0x00bc:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Key must be 256 bits"
            r7.<init>(r8)
            throw r7
        L_0x00c4:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "invalid parameters passed to ChaCha20Poly1305"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.modes.ChaCha20Poly1305.init(boolean, org.bouncycastle.crypto.CipherParameters):void");
    }

    public void processAADByte(byte b10) {
        checkAAD();
        this.aadCount = incrementCount(this.aadCount, 1, -1);
        this.poly1305.update(b10);
    }

    public void processAADBytes(byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            throw new NullPointerException("'in' cannot be null");
        } else if (i10 < 0) {
            throw new IllegalArgumentException("'inOff' cannot be negative");
        } else if (i11 < 0) {
            throw new IllegalArgumentException("'len' cannot be negative");
        } else if (i10 <= bArr.length - i11) {
            checkAAD();
            if (i11 > 0) {
                this.aadCount = incrementCount(this.aadCount, i11, -1);
                this.poly1305.update(bArr, i10, i11);
            }
        } else {
            throw new DataLengthException("Input buffer too short");
        }
    }

    public int processByte(byte b10, byte[] bArr, int i10) throws DataLengthException {
        checkData();
        int i11 = this.state;
        if (i11 == 3) {
            byte[] bArr2 = this.buf;
            int i12 = this.bufPos;
            bArr2[i12] = b10;
            int i13 = i12 + 1;
            this.bufPos = i13;
            if (i13 != 64) {
                return 0;
            }
            processData(bArr2, 0, 64, bArr, i10);
            this.poly1305.update(bArr, i10, 64);
            this.bufPos = 0;
            return 64;
        } else if (i11 == 7) {
            byte[] bArr3 = this.buf;
            int i14 = this.bufPos;
            bArr3[i14] = b10;
            int i15 = i14 + 1;
            this.bufPos = i15;
            if (i15 != bArr3.length) {
                return 0;
            }
            this.poly1305.update(bArr3, 0, 64);
            processData(this.buf, 0, 64, bArr, i10);
            byte[] bArr4 = this.buf;
            System.arraycopy(bArr4, 64, bArr4, 0, 16);
            this.bufPos = 16;
            return 64;
        } else {
            throw new IllegalStateException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0095 A[LOOP:2: B:27:0x0093->B:28:0x0095, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int processBytes(byte[] r17, int r18, int r19, byte[] r20, int r21) throws org.bouncycastle.crypto.DataLengthException {
        /*
            r16 = this;
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            if (r7 == 0) goto L_0x00da
            if (r8 < 0) goto L_0x00d2
            if (r9 < 0) goto L_0x00ca
            int r0 = r7.length
            int r0 = r0 - r9
            if (r8 > r0) goto L_0x00c2
            if (r11 < 0) goto L_0x00ba
            r16.checkData()
            int r0 = r6.state
            r1 = 3
            r12 = 0
            r13 = 64
            if (r0 == r1) goto L_0x0062
            r1 = 7
            if (r0 != r1) goto L_0x005c
            r14 = r12
            r15 = r14
        L_0x0028:
            if (r14 >= r9) goto L_0x00b9
            byte[] r0 = r6.buf
            int r1 = r6.bufPos
            int r2 = r8 + r14
            byte r2 = r7[r2]
            r0[r1] = r2
            int r1 = r1 + 1
            r6.bufPos = r1
            int r2 = r0.length
            if (r1 != r2) goto L_0x0059
            org.bouncycastle.crypto.Mac r1 = r6.poly1305
            r1.update(r0, r12, r13)
            byte[] r1 = r6.buf
            r2 = 0
            r3 = 64
            int r5 = r11 + r15
            r0 = r16
            r4 = r20
            r0.processData(r1, r2, r3, r4, r5)
            byte[] r0 = r6.buf
            r1 = 16
            java.lang.System.arraycopy(r0, r13, r0, r12, r1)
            r6.bufPos = r1
            int r15 = r15 + 64
        L_0x0059:
            int r14 = r14 + 1
            goto L_0x0028
        L_0x005c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x0062:
            int r0 = r6.bufPos
            if (r0 == 0) goto L_0x0092
        L_0x0066:
            if (r9 <= 0) goto L_0x0092
            int r9 = r9 + -1
            byte[] r1 = r6.buf
            int r0 = r6.bufPos
            int r14 = r8 + 1
            byte r2 = r7[r8]
            r1[r0] = r2
            int r0 = r0 + 1
            r6.bufPos = r0
            if (r0 != r13) goto L_0x0090
            r2 = 0
            r3 = 64
            r0 = r16
            r4 = r20
            r5 = r21
            r0.processData(r1, r2, r3, r4, r5)
            org.bouncycastle.crypto.Mac r0 = r6.poly1305
            r0.update(r10, r11, r13)
            r6.bufPos = r12
            r15 = r13
            r8 = r14
            goto L_0x0093
        L_0x0090:
            r8 = r14
            goto L_0x0066
        L_0x0092:
            r15 = r12
        L_0x0093:
            if (r9 < r13) goto L_0x00b0
            r3 = 64
            int r14 = r11 + r15
            r0 = r16
            r1 = r17
            r2 = r8
            r4 = r20
            r5 = r14
            r0.processData(r1, r2, r3, r4, r5)
            org.bouncycastle.crypto.Mac r0 = r6.poly1305
            r0.update(r10, r14, r13)
            int r8 = r8 + 64
            int r9 = r9 + -64
            int r15 = r15 + 64
            goto L_0x0093
        L_0x00b0:
            if (r9 <= 0) goto L_0x00b9
            byte[] r0 = r6.buf
            java.lang.System.arraycopy(r7, r8, r0, r12, r9)
            r6.bufPos = r9
        L_0x00b9:
            return r15
        L_0x00ba:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "'outOff' cannot be negative"
            r0.<init>(r1)
            throw r0
        L_0x00c2:
            org.bouncycastle.crypto.DataLengthException r0 = new org.bouncycastle.crypto.DataLengthException
            java.lang.String r1 = "Input buffer too short"
            r0.<init>(r1)
            throw r0
        L_0x00ca:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "'len' cannot be negative"
            r0.<init>(r1)
            throw r0
        L_0x00d2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "'inOff' cannot be negative"
            r0.<init>(r1)
            throw r0
        L_0x00da:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "'in' cannot be null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.modes.ChaCha20Poly1305.processBytes(byte[], int, int, byte[], int):int");
    }

    public void reset() {
        reset(true, true);
    }
}

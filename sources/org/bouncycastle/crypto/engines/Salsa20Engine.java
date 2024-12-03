package org.bouncycastle.crypto.engines;

import com.google.firebase.sessions.settings.RemoteSettings;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.MaxBytesExceededException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.SkippingStreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.Strings;
import org.jivesoftware.smack.datatypes.UInt32;

public class Salsa20Engine implements SkippingStreamCipher {
    public static final int DEFAULT_ROUNDS = 20;
    private static final int STATE_SIZE = 16;
    private static final int[] TAU_SIGMA = Pack.littleEndianToInt(Strings.toByteArray("expand 16-byte kexpand 32-byte k"), 0, 8);
    protected static final byte[] sigma = Strings.toByteArray("expand 32-byte k");
    protected static final byte[] tau = Strings.toByteArray("expand 16-byte k");
    private int cW0;
    private int cW1;
    private int cW2;
    protected int[] engineState;
    private int index;
    private boolean initialised;
    private byte[] keyStream;
    protected int rounds;

    /* renamed from: x  reason: collision with root package name */
    protected int[] f41435x;

    public Salsa20Engine() {
        this(20);
    }

    public Salsa20Engine(int i10) {
        this.index = 0;
        this.engineState = new int[16];
        this.f41435x = new int[16];
        this.keyStream = new byte[64];
        this.initialised = false;
        if (i10 <= 0 || (i10 & 1) != 0) {
            throw new IllegalArgumentException("'rounds' must be a positive, even number");
        }
        this.rounds = i10;
    }

    private boolean limitExceeded() {
        int i10 = this.cW0 + 1;
        this.cW0 = i10;
        if (i10 == 0) {
            int i11 = this.cW1 + 1;
            this.cW1 = i11;
            if (i11 == 0) {
                int i12 = this.cW2 + 1;
                this.cW2 = i12;
                return (i12 & 32) != 0;
            }
        }
        return false;
    }

    private boolean limitExceeded(int i10) {
        int i11 = this.cW0 + i10;
        this.cW0 = i11;
        if (i11 >= i10 || i11 < 0) {
            return false;
        }
        int i12 = this.cW1 + 1;
        this.cW1 = i12;
        if (i12 != 0) {
            return false;
        }
        int i13 = this.cW2 + 1;
        this.cW2 = i13;
        return (i13 & 32) != 0;
    }

    private void resetLimitCounter() {
        this.cW0 = 0;
        this.cW1 = 0;
        this.cW2 = 0;
    }

    public static void salsaCore(int i10, int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        if (iArr3.length != 16) {
            throw new IllegalArgumentException();
        } else if (iArr4.length != 16) {
            throw new IllegalArgumentException();
        } else if (i10 % 2 == 0) {
            boolean z10 = false;
            int i11 = iArr3[0];
            int i12 = iArr3[1];
            int i13 = iArr3[2];
            int i14 = iArr3[3];
            int i15 = iArr3[4];
            int i16 = iArr3[5];
            int i17 = iArr3[6];
            int i18 = 7;
            int i19 = iArr3[7];
            int i20 = iArr3[8];
            int i21 = 9;
            int i22 = iArr3[9];
            int i23 = iArr3[10];
            int i24 = iArr3[11];
            int i25 = iArr3[12];
            int i26 = 13;
            int i27 = iArr3[13];
            int i28 = iArr3[14];
            int i29 = iArr3[15];
            int i30 = i28;
            int i31 = i27;
            int i32 = i25;
            int i33 = i24;
            int i34 = i23;
            int i35 = i22;
            int i36 = i20;
            int i37 = i19;
            int i38 = i17;
            int i39 = i16;
            int i40 = i15;
            int i41 = i14;
            int i42 = i13;
            int i43 = i12;
            int i44 = i11;
            int i45 = i10;
            while (i45 > 0) {
                int rotateLeft = Integers.rotateLeft(i44 + i32, i18) ^ i40;
                int rotateLeft2 = i36 ^ Integers.rotateLeft(rotateLeft + i44, i21);
                int rotateLeft3 = i32 ^ Integers.rotateLeft(rotateLeft2 + rotateLeft, i26);
                int rotateLeft4 = Integers.rotateLeft(rotateLeft3 + rotateLeft2, 18) ^ i44;
                int rotateLeft5 = i35 ^ Integers.rotateLeft(i39 + i43, i18);
                int rotateLeft6 = i31 ^ Integers.rotateLeft(rotateLeft5 + i39, i21);
                int rotateLeft7 = i43 ^ Integers.rotateLeft(rotateLeft6 + rotateLeft5, i26);
                int rotateLeft8 = Integers.rotateLeft(rotateLeft7 + rotateLeft6, 18) ^ i39;
                int rotateLeft9 = i30 ^ Integers.rotateLeft(i34 + i38, 7);
                int rotateLeft10 = i42 ^ Integers.rotateLeft(rotateLeft9 + i34, 9);
                int rotateLeft11 = i38 ^ Integers.rotateLeft(rotateLeft10 + rotateLeft9, 13);
                int rotateLeft12 = i34 ^ Integers.rotateLeft(rotateLeft11 + rotateLeft10, 18);
                int rotateLeft13 = i41 ^ Integers.rotateLeft(i29 + i33, 7);
                int rotateLeft14 = i37 ^ Integers.rotateLeft(rotateLeft13 + i29, 9);
                int i46 = i45;
                int rotateLeft15 = i33 ^ Integers.rotateLeft(rotateLeft14 + rotateLeft13, 13);
                int i47 = rotateLeft6;
                int rotateLeft16 = i29 ^ Integers.rotateLeft(rotateLeft15 + rotateLeft14, 18);
                int i48 = rotateLeft3;
                i43 = rotateLeft7 ^ Integers.rotateLeft(rotateLeft4 + rotateLeft13, 7);
                i42 = rotateLeft10 ^ Integers.rotateLeft(i43 + rotateLeft4, 9);
                int rotateLeft17 = rotateLeft13 ^ Integers.rotateLeft(i42 + i43, 13);
                int rotateLeft18 = rotateLeft4 ^ Integers.rotateLeft(rotateLeft17 + i42, 18);
                i38 = rotateLeft11 ^ Integers.rotateLeft(rotateLeft8 + rotateLeft, 7);
                i37 = rotateLeft14 ^ Integers.rotateLeft(i38 + rotateLeft8, 9);
                int rotateLeft19 = Integers.rotateLeft(i37 + i38, 13) ^ rotateLeft;
                i39 = rotateLeft8 ^ Integers.rotateLeft(rotateLeft19 + i37, 18);
                i33 = rotateLeft15 ^ Integers.rotateLeft(rotateLeft12 + rotateLeft5, 7);
                int rotateLeft20 = Integers.rotateLeft(i33 + rotateLeft12, 9) ^ rotateLeft2;
                i35 = rotateLeft5 ^ Integers.rotateLeft(rotateLeft20 + i33, 13);
                i34 = rotateLeft12 ^ Integers.rotateLeft(i35 + rotateLeft20, 18);
                i32 = i48 ^ Integers.rotateLeft(rotateLeft16 + rotateLeft9, 7);
                i31 = i47 ^ Integers.rotateLeft(i32 + rotateLeft16, 9);
                i30 = rotateLeft9 ^ Integers.rotateLeft(i31 + i32, 13);
                i29 = rotateLeft16 ^ Integers.rotateLeft(i30 + i31, 18);
                i41 = rotateLeft17;
                i36 = rotateLeft20;
                i44 = rotateLeft18;
                i40 = rotateLeft19;
                z10 = false;
                i26 = 13;
                i21 = 9;
                i18 = 7;
                int[] iArr5 = iArr;
                i45 = i46 - 2;
                int[] iArr6 = iArr2;
            }
            char c10 = z10;
            iArr2[c10] = i44 + iArr[c10];
            iArr2[1] = i43 + iArr[1];
            iArr2[2] = i42 + iArr[2];
            iArr2[3] = i41 + iArr[3];
            iArr2[4] = i40 + iArr[4];
            iArr2[5] = i39 + iArr[5];
            iArr2[6] = i38 + iArr[6];
            iArr2[7] = i37 + iArr[7];
            iArr2[8] = i36 + iArr[8];
            iArr2[9] = i35 + iArr[9];
            iArr2[10] = i34 + iArr[10];
            iArr2[11] = i33 + iArr[11];
            iArr2[12] = i32 + iArr[12];
            iArr2[13] = i31 + iArr[13];
            iArr2[14] = i30 + iArr[14];
            iArr2[15] = i29 + iArr[15];
        } else {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
    }

    /* access modifiers changed from: protected */
    public void advanceCounter() {
        int[] iArr = this.engineState;
        int i10 = iArr[8] + 1;
        iArr[8] = i10;
        if (i10 == 0) {
            iArr[9] = iArr[9] + 1;
        }
    }

    /* access modifiers changed from: protected */
    public void advanceCounter(long j10) {
        int i10 = (int) (j10 >>> 32);
        int i11 = (int) j10;
        if (i10 > 0) {
            int[] iArr = this.engineState;
            iArr[9] = iArr[9] + i10;
        }
        int[] iArr2 = this.engineState;
        int i12 = iArr2[8];
        int i13 = i11 + i12;
        iArr2[8] = i13;
        if (i12 != 0 && i13 < i12) {
            iArr2[9] = iArr2[9] + 1;
        }
    }

    /* access modifiers changed from: protected */
    public void generateKeyStream(byte[] bArr) {
        salsaCore(this.rounds, this.engineState, this.f41435x);
        Pack.intToLittleEndian(this.f41435x, bArr, 0);
    }

    public String getAlgorithmName() {
        if (this.rounds == 20) {
            return "Salsa20";
        }
        return "Salsa20" + RemoteSettings.FORWARD_SLASH_STRING + this.rounds;
    }

    /* access modifiers changed from: protected */
    public long getCounter() {
        int[] iArr = this.engineState;
        return (((long) iArr[9]) << 32) | (((long) iArr[8]) & UInt32.MAX_VALUE_LONG);
    }

    /* access modifiers changed from: protected */
    public int getNonceSize() {
        return 8;
    }

    public long getPosition() {
        return (getCounter() * 64) + ((long) this.index);
    }

    public void init(boolean z10, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            if (iv == null || iv.length != getNonceSize()) {
                throw new IllegalArgumentException(getAlgorithmName() + " requires exactly " + getNonceSize() + " bytes of IV");
            }
            CipherParameters parameters = parametersWithIV.getParameters();
            if (parameters == null) {
                if (this.initialised) {
                    setKey((byte[]) null, iv);
                } else {
                    throw new IllegalStateException(getAlgorithmName() + " KeyParameter can not be null for first initialisation");
                }
            } else if (parameters instanceof KeyParameter) {
                setKey(((KeyParameter) parameters).getKey(), iv);
            } else {
                throw new IllegalArgumentException(getAlgorithmName() + " Init parameters must contain a KeyParameter (or null for re-init)");
            }
            reset();
            this.initialised = true;
            return;
        }
        throw new IllegalArgumentException(getAlgorithmName() + " Init parameters must include an IV");
    }

    /* access modifiers changed from: protected */
    public void packTauOrSigma(int i10, int[] iArr, int i11) {
        int i12 = (i10 - 16) / 4;
        int[] iArr2 = TAU_SIGMA;
        iArr[i11] = iArr2[i12];
        iArr[i11 + 1] = iArr2[i12 + 1];
        iArr[i11 + 2] = iArr2[i12 + 2];
        iArr[i11 + 3] = iArr2[i12 + 3];
    }

    public int processBytes(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        if (!this.initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i10 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + i11 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (!limitExceeded(i11)) {
            for (int i13 = 0; i13 < i11; i13++) {
                byte[] bArr3 = this.keyStream;
                int i14 = this.index;
                bArr2[i13 + i12] = (byte) (bArr3[i14] ^ bArr[i13 + i10]);
                int i15 = (i14 + 1) & 63;
                this.index = i15;
                if (i15 == 0) {
                    advanceCounter();
                    generateKeyStream(this.keyStream);
                }
            }
            return i11;
        } else {
            throw new MaxBytesExceededException("2^70 byte limit per IV would be exceeded; Change IV");
        }
    }

    public void reset() {
        this.index = 0;
        resetLimitCounter();
        resetCounter();
        generateKeyStream(this.keyStream);
    }

    /* access modifiers changed from: protected */
    public void resetCounter() {
        int[] iArr = this.engineState;
        iArr[9] = 0;
        iArr[8] = 0;
    }

    /* access modifiers changed from: protected */
    public void retreatCounter() {
        int[] iArr = this.engineState;
        int i10 = iArr[8];
        if (i10 == 0 && iArr[9] == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        int i11 = i10 - 1;
        iArr[8] = i11;
        if (i11 == -1) {
            iArr[9] = iArr[9] - 1;
        }
    }

    /* access modifiers changed from: protected */
    public void retreatCounter(long j10) {
        int i10 = (int) (j10 >>> 32);
        int i11 = (int) j10;
        if (i10 != 0) {
            int[] iArr = this.engineState;
            int i12 = iArr[9];
            if ((((long) i12) & UInt32.MAX_VALUE_LONG) >= (((long) i10) & UInt32.MAX_VALUE_LONG)) {
                iArr[9] = i12 - i10;
            } else {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
        }
        int[] iArr2 = this.engineState;
        int i13 = iArr2[8];
        if ((((long) i13) & UInt32.MAX_VALUE_LONG) >= (UInt32.MAX_VALUE_LONG & ((long) i11))) {
            iArr2[8] = i13 - i11;
            return;
        }
        int i14 = iArr2[9];
        if (i14 != 0) {
            iArr2[9] = i14 - 1;
            iArr2[8] = i13 - i11;
            return;
        }
        throw new IllegalStateException("attempt to reduce counter past zero.");
    }

    public byte returnByte(byte b10) {
        if (!limitExceeded()) {
            byte[] bArr = this.keyStream;
            int i10 = this.index;
            byte b11 = (byte) (b10 ^ bArr[i10]);
            int i11 = (i10 + 1) & 63;
            this.index = i11;
            if (i11 == 0) {
                advanceCounter();
                generateKeyStream(this.keyStream);
            }
            return b11;
        }
        throw new MaxBytesExceededException("2^70 byte limit per IV; Change IV");
    }

    public long seekTo(long j10) {
        reset();
        return skip(j10);
    }

    /* access modifiers changed from: protected */
    public void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length == 16 || bArr.length == 32) {
                int length = (bArr.length - 16) / 4;
                int[] iArr = this.engineState;
                int[] iArr2 = TAU_SIGMA;
                iArr[0] = iArr2[length];
                iArr[5] = iArr2[length + 1];
                iArr[10] = iArr2[length + 2];
                iArr[15] = iArr2[length + 3];
                Pack.littleEndianToInt(bArr, 0, iArr, 1, 4);
                Pack.littleEndianToInt(bArr, bArr.length - 16, this.engineState, 11, 4);
            } else {
                throw new IllegalArgumentException(getAlgorithmName() + " requires 128 bit or 256 bit key");
            }
        }
        Pack.littleEndianToInt(bArr2, 0, this.engineState, 6, 2);
    }

    public long skip(long j10) {
        long j11;
        if (j10 >= 0) {
            if (j10 >= 64) {
                long j12 = j10 / 64;
                advanceCounter(j12);
                j11 = j10 - (j12 * 64);
            } else {
                j11 = j10;
            }
            int i10 = this.index;
            int i11 = (((int) j11) + i10) & 63;
            this.index = i11;
            if (i11 < i10) {
                advanceCounter();
            }
        } else {
            long j13 = -j10;
            if (j13 >= 64) {
                long j14 = j13 / 64;
                retreatCounter(j14);
                j13 -= j14 * 64;
            }
            for (long j15 = 0; j15 < j13; j15++) {
                if (this.index == 0) {
                    retreatCounter();
                }
                this.index = (this.index - 1) & 63;
            }
        }
        generateKeyStream(this.keyStream);
        return j10;
    }
}

package org.bouncycastle.crypto.digests;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.engines.ThreefishEngine;
import org.bouncycastle.crypto.params.SkeinParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Memoable;
import org.jivesoftware.smack.datatypes.UInt32;

public class SkeinEngine implements Memoable {
    private static final Hashtable INITIAL_STATES = new Hashtable();
    private static final int PARAM_TYPE_CONFIG = 4;
    private static final int PARAM_TYPE_KEY = 0;
    private static final int PARAM_TYPE_MESSAGE = 48;
    private static final int PARAM_TYPE_OUTPUT = 63;
    public static final int SKEIN_1024 = 1024;
    public static final int SKEIN_256 = 256;
    public static final int SKEIN_512 = 512;
    long[] chain;
    private long[] initialState;
    private byte[] key;
    private final int outputSizeBytes;
    private Parameter[] postMessageParameters;
    private Parameter[] preMessageParameters;
    private final byte[] singleByte;
    final ThreefishEngine threefish;
    private final UBI ubi;

    private static class Configuration {
        private byte[] bytes;

        public Configuration(long j10) {
            byte[] bArr = new byte[32];
            this.bytes = bArr;
            bArr[0] = 83;
            bArr[1] = 72;
            bArr[2] = 65;
            bArr[3] = 51;
            bArr[4] = 1;
            bArr[5] = 0;
            ThreefishEngine.wordToBytes(j10, bArr, 8);
        }

        public byte[] getBytes() {
            return this.bytes;
        }
    }

    public static class Parameter {
        private int type;
        private byte[] value;

        public Parameter(int i10, byte[] bArr) {
            this.type = i10;
            this.value = bArr;
        }

        public int getType() {
            return this.type;
        }

        public byte[] getValue() {
            return this.value;
        }
    }

    private class UBI {
        private byte[] currentBlock;
        private int currentOffset;
        private long[] message;
        private final UbiTweak tweak = new UbiTweak();

        public UBI(int i10) {
            byte[] bArr = new byte[i10];
            this.currentBlock = bArr;
            this.message = new long[(bArr.length / 8)];
        }

        private void processBlock(long[] jArr) {
            long[] jArr2;
            SkeinEngine skeinEngine = SkeinEngine.this;
            skeinEngine.threefish.init(true, skeinEngine.chain, this.tweak.getWords());
            int i10 = 0;
            while (true) {
                jArr2 = this.message;
                if (i10 >= jArr2.length) {
                    break;
                }
                jArr2[i10] = ThreefishEngine.bytesToWord(this.currentBlock, i10 * 8);
                i10++;
            }
            SkeinEngine.this.threefish.processBlock(jArr2, jArr);
            for (int i11 = 0; i11 < jArr.length; i11++) {
                jArr[i11] = jArr[i11] ^ this.message[i11];
            }
        }

        public void doFinal(long[] jArr) {
            int i10 = this.currentOffset;
            while (true) {
                byte[] bArr = this.currentBlock;
                if (i10 < bArr.length) {
                    bArr[i10] = 0;
                    i10++;
                } else {
                    this.tweak.setFinal(true);
                    processBlock(jArr);
                    return;
                }
            }
        }

        public void reset(int i10) {
            this.tweak.reset();
            this.tweak.setType(i10);
            this.currentOffset = 0;
        }

        public void reset(UBI ubi) {
            this.currentBlock = Arrays.clone(ubi.currentBlock, this.currentBlock);
            this.currentOffset = ubi.currentOffset;
            this.message = Arrays.clone(ubi.message, this.message);
            this.tweak.reset(ubi.tweak);
        }

        public void update(byte[] bArr, int i10, int i11, long[] jArr) {
            int i12 = 0;
            while (i11 > i12) {
                if (this.currentOffset == this.currentBlock.length) {
                    processBlock(jArr);
                    this.tweak.setFirst(false);
                    this.currentOffset = 0;
                }
                int min = Math.min(i11 - i12, this.currentBlock.length - this.currentOffset);
                System.arraycopy(bArr, i10 + i12, this.currentBlock, this.currentOffset, min);
                i12 += min;
                this.currentOffset += min;
                this.tweak.advancePosition(min);
            }
        }
    }

    private static class UbiTweak {
        private static final long LOW_RANGE = 9223372034707292160L;
        private static final long T1_FINAL = Long.MIN_VALUE;
        private static final long T1_FIRST = 4611686018427387904L;
        private boolean extendedPosition;
        private long[] tweak = new long[2];

        public UbiTweak() {
            reset();
        }

        public void advancePosition(int i10) {
            if (this.extendedPosition) {
                long[] jArr = this.tweak;
                long[] jArr2 = {jArr[0] & UInt32.MAX_VALUE_LONG, (jArr[0] >>> 32) & UInt32.MAX_VALUE_LONG, jArr[1] & UInt32.MAX_VALUE_LONG};
                long j10 = (long) i10;
                for (int i11 = 0; i11 < 3; i11++) {
                    long j11 = j10 + jArr2[i11];
                    jArr2[i11] = j11;
                    j10 = j11 >>> 32;
                }
                long[] jArr3 = this.tweak;
                jArr3[0] = ((jArr2[1] & UInt32.MAX_VALUE_LONG) << 32) | (jArr2[0] & UInt32.MAX_VALUE_LONG);
                jArr3[1] = (jArr2[2] & UInt32.MAX_VALUE_LONG) | (jArr3[1] & -4294967296L);
                return;
            }
            long[] jArr4 = this.tweak;
            long j12 = jArr4[0] + ((long) i10);
            jArr4[0] = j12;
            if (j12 > LOW_RANGE) {
                this.extendedPosition = true;
            }
        }

        public int getType() {
            return (int) ((this.tweak[1] >>> 56) & 63);
        }

        public long[] getWords() {
            return this.tweak;
        }

        public boolean isFinal() {
            return (this.tweak[1] & T1_FINAL) != 0;
        }

        public boolean isFirst() {
            return (this.tweak[1] & T1_FIRST) != 0;
        }

        public void reset() {
            long[] jArr = this.tweak;
            jArr[0] = 0;
            jArr[1] = 0;
            this.extendedPosition = false;
            setFirst(true);
        }

        public void reset(UbiTweak ubiTweak) {
            this.tweak = Arrays.clone(ubiTweak.tweak, this.tweak);
            this.extendedPosition = ubiTweak.extendedPosition;
        }

        public void setFinal(boolean z10) {
            if (z10) {
                long[] jArr = this.tweak;
                jArr[1] = jArr[1] | T1_FINAL;
                return;
            }
            long[] jArr2 = this.tweak;
            jArr2[1] = jArr2[1] & Long.MAX_VALUE;
        }

        public void setFirst(boolean z10) {
            if (z10) {
                long[] jArr = this.tweak;
                jArr[1] = jArr[1] | T1_FIRST;
                return;
            }
            long[] jArr2 = this.tweak;
            jArr2[1] = jArr2[1] & -4611686018427387905L;
        }

        public void setType(int i10) {
            long[] jArr = this.tweak;
            jArr[1] = (jArr[1] & -274877906944L) | ((((long) i10) & 63) << 56);
        }

        public String toString() {
            return getType() + " first: " + isFirst() + ", final: " + isFinal();
        }
    }

    static {
        initialState(256, 128, new long[]{-2228972824489528736L, -8629553674646093540L, 1155188648486244218L, -3677226592081559102L});
        initialState(256, 160, new long[]{1450197650740764312L, 3081844928540042640L, -3136097061834271170L, 3301952811952417661L});
        initialState(256, 224, new long[]{-4176654842910610933L, -8688192972455077604L, -7364642305011795836L, 4056579644589979102L});
        initialState(256, 256, new long[]{-243853671043386295L, 3443677322885453875L, -5531612722399640561L, 7662005193972177513L});
        initialState(512, 128, new long[]{-6288014694233956526L, 2204638249859346602L, 3502419045458743507L, -4829063503441264548L, 983504137758028059L, 1880512238245786339L, -6715892782214108542L, 7602827311880509485L});
        initialState(512, 160, new long[]{2934123928682216849L, -4399710721982728305L, 1684584802963255058L, 5744138295201861711L, 2444857010922934358L, -2807833639722848072L, -5121587834665610502L, 118355523173251694L});
        initialState(512, 224, new long[]{-3688341020067007964L, -3772225436291745297L, -8300862168937575580L, 4146387520469897396L, 1106145742801415120L, 7455425944880474941L, -7351063101234211863L, -7048981346965512457L});
        initialState(512, 384, new long[]{-6631894876634615969L, -5692838220127733084L, -7099962856338682626L, -2911352911530754598L, 2000907093792408677L, 9140007292425499655L, 6093301768906360022L, 2769176472213098488L});
        initialState(512, 512, new long[]{5261240102383538638L, 978932832955457283L, -8083517948103779378L, -7339365279355032399L, 6752626034097301424L, -1531723821829733388L, -7417126464950782685L, -5901786942805128141L});
    }

    public SkeinEngine(int i10, int i11) {
        this.singleByte = new byte[1];
        if (i11 % 8 == 0) {
            this.outputSizeBytes = i11 / 8;
            ThreefishEngine threefishEngine = new ThreefishEngine(i10);
            this.threefish = threefishEngine;
            this.ubi = new UBI(threefishEngine.getBlockSize());
            return;
        }
        throw new IllegalArgumentException("Output size must be a multiple of 8 bits. :" + i11);
    }

    public SkeinEngine(SkeinEngine skeinEngine) {
        this(skeinEngine.getBlockSize() * 8, skeinEngine.getOutputSize() * 8);
        copyIn(skeinEngine);
    }

    private void checkInitialised() {
        if (this.ubi == null) {
            throw new IllegalArgumentException("Skein engine is not initialised.");
        }
    }

    private static Parameter[] clone(Parameter[] parameterArr, Parameter[] parameterArr2) {
        if (parameterArr == null) {
            return null;
        }
        if (parameterArr2 == null || parameterArr2.length != parameterArr.length) {
            parameterArr2 = new Parameter[parameterArr.length];
        }
        System.arraycopy(parameterArr, 0, parameterArr2, 0, parameterArr2.length);
        return parameterArr2;
    }

    private void copyIn(SkeinEngine skeinEngine) {
        this.ubi.reset(skeinEngine.ubi);
        this.chain = Arrays.clone(skeinEngine.chain, this.chain);
        this.initialState = Arrays.clone(skeinEngine.initialState, this.initialState);
        this.key = Arrays.clone(skeinEngine.key, this.key);
        this.preMessageParameters = clone(skeinEngine.preMessageParameters, this.preMessageParameters);
        this.postMessageParameters = clone(skeinEngine.postMessageParameters, this.postMessageParameters);
    }

    private void createInitialState() {
        long[] jArr = (long[]) INITIAL_STATES.get(variantIdentifier(getBlockSize(), getOutputSize()));
        int i10 = 0;
        if (this.key != null || jArr == null) {
            this.chain = new long[(getBlockSize() / 8)];
            byte[] bArr = this.key;
            if (bArr != null) {
                ubiComplete(0, bArr);
            }
            ubiComplete(4, new Configuration((long) (this.outputSizeBytes * 8)).getBytes());
        } else {
            this.chain = Arrays.clone(jArr);
        }
        if (this.preMessageParameters != null) {
            while (true) {
                Parameter[] parameterArr = this.preMessageParameters;
                if (i10 >= parameterArr.length) {
                    break;
                }
                Parameter parameter = parameterArr[i10];
                ubiComplete(parameter.getType(), parameter.getValue());
                i10++;
            }
        }
        this.initialState = Arrays.clone(this.chain);
    }

    private void initParams(Hashtable hashtable) {
        Enumeration keys = hashtable.keys();
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        while (keys.hasMoreElements()) {
            Integer num = (Integer) keys.nextElement();
            byte[] bArr = (byte[]) hashtable.get(num);
            if (num.intValue() == 0) {
                this.key = bArr;
            } else if (num.intValue() < 48) {
                vector.addElement(new Parameter(num.intValue(), bArr));
            } else {
                vector2.addElement(new Parameter(num.intValue(), bArr));
            }
        }
        Parameter[] parameterArr = new Parameter[vector.size()];
        this.preMessageParameters = parameterArr;
        vector.copyInto(parameterArr);
        sort(this.preMessageParameters);
        Parameter[] parameterArr2 = new Parameter[vector2.size()];
        this.postMessageParameters = parameterArr2;
        vector2.copyInto(parameterArr2);
        sort(this.postMessageParameters);
    }

    private static void initialState(int i10, int i11, long[] jArr) {
        INITIAL_STATES.put(variantIdentifier(i10 / 8, i11 / 8), jArr);
    }

    private void output(long j10, byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[8];
        ThreefishEngine.wordToBytes(j10, bArr2, 0);
        long[] jArr = new long[this.chain.length];
        ubiInit(63);
        this.ubi.update(bArr2, 0, 8, jArr);
        this.ubi.doFinal(jArr);
        int i12 = ((i11 + 8) - 1) / 8;
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i13 * 8;
            int min = Math.min(8, i11 - i14);
            if (min == 8) {
                ThreefishEngine.wordToBytes(jArr[i13], bArr, i14 + i10);
            } else {
                ThreefishEngine.wordToBytes(jArr[i13], bArr2, 0);
                System.arraycopy(bArr2, 0, bArr, i14 + i10, min);
            }
        }
    }

    private static void sort(Parameter[] parameterArr) {
        if (parameterArr != null) {
            for (int i10 = 1; i10 < parameterArr.length; i10++) {
                Parameter parameter = parameterArr[i10];
                int i11 = i10;
                while (i11 > 0) {
                    int i12 = i11 - 1;
                    if (parameter.getType() >= parameterArr[i12].getType()) {
                        break;
                    }
                    parameterArr[i11] = parameterArr[i12];
                    i11 = i12;
                }
                parameterArr[i11] = parameter;
            }
        }
    }

    private void ubiComplete(int i10, byte[] bArr) {
        ubiInit(i10);
        this.ubi.update(bArr, 0, bArr.length, this.chain);
        ubiFinal();
    }

    private void ubiFinal() {
        this.ubi.doFinal(this.chain);
    }

    private void ubiInit(int i10) {
        this.ubi.reset(i10);
    }

    private static Integer variantIdentifier(int i10, int i11) {
        return Integers.valueOf(i10 | (i11 << 16));
    }

    public Memoable copy() {
        return new SkeinEngine(this);
    }

    public int doFinal(byte[] bArr, int i10) {
        checkInitialised();
        if (bArr.length >= this.outputSizeBytes + i10) {
            ubiFinal();
            if (this.postMessageParameters != null) {
                int i11 = 0;
                while (true) {
                    Parameter[] parameterArr = this.postMessageParameters;
                    if (i11 >= parameterArr.length) {
                        break;
                    }
                    Parameter parameter = parameterArr[i11];
                    ubiComplete(parameter.getType(), parameter.getValue());
                    i11++;
                }
            }
            int blockSize = getBlockSize();
            int i12 = ((this.outputSizeBytes + blockSize) - 1) / blockSize;
            for (int i13 = 0; i13 < i12; i13++) {
                int i14 = i13 * blockSize;
                output((long) i13, bArr, i10 + i14, Math.min(blockSize, this.outputSizeBytes - i14));
            }
            reset();
            return this.outputSizeBytes;
        }
        throw new OutputLengthException("Output buffer is too short to hold output");
    }

    public int getBlockSize() {
        return this.threefish.getBlockSize();
    }

    public int getOutputSize() {
        return this.outputSizeBytes;
    }

    public void init(SkeinParameters skeinParameters) {
        this.chain = null;
        this.key = null;
        this.preMessageParameters = null;
        this.postMessageParameters = null;
        if (skeinParameters != null) {
            if (skeinParameters.getKey().length >= 16) {
                initParams(skeinParameters.getParameters());
            } else {
                throw new IllegalArgumentException("Skein key must be at least 128 bits.");
            }
        }
        createInitialState();
        ubiInit(48);
    }

    public void reset() {
        long[] jArr = this.initialState;
        long[] jArr2 = this.chain;
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        ubiInit(48);
    }

    public void reset(Memoable memoable) {
        SkeinEngine skeinEngine = (SkeinEngine) memoable;
        if (getBlockSize() == skeinEngine.getBlockSize() && this.outputSizeBytes == skeinEngine.outputSizeBytes) {
            copyIn(skeinEngine);
            return;
        }
        throw new IllegalArgumentException("Incompatible parameters in provided SkeinEngine.");
    }

    public void update(byte b10) {
        byte[] bArr = this.singleByte;
        bArr[0] = b10;
        update(bArr, 0, 1);
    }

    public void update(byte[] bArr, int i10, int i11) {
        checkInitialised();
        this.ubi.update(bArr, i10, i11, this.chain);
    }
}

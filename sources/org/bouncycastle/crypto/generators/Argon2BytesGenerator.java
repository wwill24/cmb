package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.Blake2bDigest;
import org.bouncycastle.crypto.params.Argon2Parameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Longs;
import org.bouncycastle.util.Pack;

public class Argon2BytesGenerator {
    private static final int ARGON2_ADDRESSES_IN_BLOCK = 128;
    private static final int ARGON2_BLOCK_SIZE = 1024;
    private static final int ARGON2_PREHASH_DIGEST_LENGTH = 64;
    private static final int ARGON2_PREHASH_SEED_LENGTH = 72;
    private static final int ARGON2_QWORDS_IN_BLOCK = 128;
    private static final int ARGON2_SYNC_POINTS = 4;
    private static final long M32L = 4294967295L;
    private static final int MAX_PARALLELISM = 16777216;
    private static final int MIN_ITERATIONS = 1;
    private static final int MIN_OUTLEN = 4;
    private static final int MIN_PARALLELISM = 1;
    private static final byte[] ZERO_BYTES = new byte[4];
    private int laneLength;
    private Block[] memory;
    private Argon2Parameters parameters;
    private int segmentLength;

    private static class Block {
        private static final int SIZE = 128;
        /* access modifiers changed from: private */

        /* renamed from: v  reason: collision with root package name */
        public final long[] f41441v;

        private Block() {
            this.f41441v = new long[128];
        }

        /* access modifiers changed from: private */
        public void copyBlock(Block block) {
            System.arraycopy(block.f41441v, 0, this.f41441v, 0, 128);
        }

        /* access modifiers changed from: private */
        public void xor(Block block, Block block2) {
            long[] jArr = this.f41441v;
            long[] jArr2 = block.f41441v;
            long[] jArr3 = block2.f41441v;
            for (int i10 = 0; i10 < 128; i10++) {
                jArr[i10] = jArr2[i10] ^ jArr3[i10];
            }
        }

        /* access modifiers changed from: private */
        public void xorWith(Block block) {
            long[] jArr = this.f41441v;
            long[] jArr2 = block.f41441v;
            for (int i10 = 0; i10 < 128; i10++) {
                jArr[i10] = jArr[i10] ^ jArr2[i10];
            }
        }

        /* access modifiers changed from: private */
        public void xorWith(Block block, Block block2) {
            long[] jArr = this.f41441v;
            long[] jArr2 = block.f41441v;
            long[] jArr3 = block2.f41441v;
            for (int i10 = 0; i10 < 128; i10++) {
                jArr[i10] = jArr[i10] ^ (jArr2[i10] ^ jArr3[i10]);
            }
        }

        public Block clear() {
            Arrays.fill(this.f41441v, 0);
            return this;
        }

        /* access modifiers changed from: package-private */
        public void fromBytes(byte[] bArr) {
            if (bArr.length >= 1024) {
                Pack.littleEndianToLong(bArr, 0, this.f41441v);
                return;
            }
            throw new IllegalArgumentException("input shorter than blocksize");
        }

        /* access modifiers changed from: package-private */
        public void toBytes(byte[] bArr) {
            if (bArr.length >= 1024) {
                Pack.longToLittleEndian(this.f41441v, bArr, 0);
                return;
            }
            throw new IllegalArgumentException("output shorter than blocksize");
        }
    }

    private static class FillBlock {
        Block R;
        Block Z;
        Block addressBlock;
        Block inputBlock;

        private FillBlock() {
            this.R = new Block();
            this.Z = new Block();
            this.addressBlock = new Block();
            this.inputBlock = new Block();
        }

        private void applyBlake() {
            for (int i10 = 0; i10 < 8; i10++) {
                int i11 = i10 * 16;
                Argon2BytesGenerator.roundFunction(this.Z, i11, i11 + 1, i11 + 2, i11 + 3, i11 + 4, i11 + 5, i11 + 6, i11 + 7, i11 + 8, i11 + 9, i11 + 10, i11 + 11, i11 + 12, i11 + 13, i11 + 14, i11 + 15);
            }
            for (int i12 = 0; i12 < 8; i12++) {
                int i13 = i12 * 2;
                Argon2BytesGenerator.roundFunction(this.Z, i13, i13 + 1, i13 + 16, i13 + 17, i13 + 32, i13 + 33, i13 + 48, i13 + 49, i13 + 64, i13 + 65, i13 + 80, i13 + 81, i13 + 96, i13 + 97, i13 + 112, i13 + 113);
            }
        }

        /* access modifiers changed from: private */
        public void fillBlock(Block block, Block block2) {
            this.Z.copyBlock(block);
            applyBlake();
            block2.xor(block, this.Z);
        }

        /* access modifiers changed from: private */
        public void fillBlock(Block block, Block block2, Block block3) {
            this.R.xor(block, block2);
            this.Z.copyBlock(this.R);
            applyBlake();
            block3.xor(this.R, this.Z);
        }

        /* access modifiers changed from: private */
        public void fillBlockWithXor(Block block, Block block2, Block block3) {
            this.R.xor(block, block2);
            this.Z.copyBlock(this.R);
            applyBlake();
            block3.xorWith(this.R, this.Z);
        }
    }

    private static class Position {
        int lane;
        int pass;
        int slice;

        Position() {
        }
    }

    private static void F(long[] jArr, int i10, int i11, int i12, int i13) {
        quarterRound(jArr, i10, i11, i13, 32);
        quarterRound(jArr, i12, i13, i11, 24);
        quarterRound(jArr, i10, i11, i13, 16);
        quarterRound(jArr, i12, i13, i11, 63);
    }

    private static void addByteString(byte[] bArr, Digest digest, byte[] bArr2) {
        if (bArr2 == null) {
            digest.update(ZERO_BYTES, 0, 4);
            return;
        }
        Pack.intToLittleEndian(bArr2.length, bArr, 0);
        digest.update(bArr, 0, 4);
        digest.update(bArr2, 0, bArr2.length);
    }

    private void digest(byte[] bArr, byte[] bArr2, int i10, int i11) {
        Block block = this.memory[this.laneLength - 1];
        for (int i12 = 1; i12 < this.parameters.getLanes(); i12++) {
            int i13 = this.laneLength;
            block.xorWith(this.memory[(i12 * i13) + (i13 - 1)]);
        }
        block.toBytes(bArr);
        hash(bArr, bArr2, i10, i11);
    }

    private void doInit(Argon2Parameters argon2Parameters) {
        int memory2 = argon2Parameters.getMemory();
        if (memory2 < argon2Parameters.getLanes() * 8) {
            memory2 = argon2Parameters.getLanes() * 8;
        }
        int lanes = memory2 / (argon2Parameters.getLanes() * 4);
        this.segmentLength = lanes;
        this.laneLength = lanes * 4;
        initMemory(lanes * argon2Parameters.getLanes() * 4);
    }

    private void fillFirstBlocks(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[72];
        System.arraycopy(bArr2, 0, bArr3, 0, 64);
        bArr3[64] = 1;
        for (int i10 = 0; i10 < this.parameters.getLanes(); i10++) {
            Pack.intToLittleEndian(i10, bArr2, 68);
            Pack.intToLittleEndian(i10, bArr3, 68);
            hash(bArr2, bArr, 0, 1024);
            this.memory[(this.laneLength * i10) + 0].fromBytes(bArr);
            hash(bArr3, bArr, 0, 1024);
            this.memory[(this.laneLength * i10) + 1].fromBytes(bArr);
        }
    }

    private void fillMemoryBlocks() {
        FillBlock fillBlock = new FillBlock();
        Position position = new Position();
        for (int i10 = 0; i10 < this.parameters.getIterations(); i10++) {
            position.pass = i10;
            for (int i11 = 0; i11 < 4; i11++) {
                position.slice = i11;
                for (int i12 = 0; i12 < this.parameters.getLanes(); i12++) {
                    position.lane = i12;
                    fillSegment(fillBlock, position);
                }
            }
        }
    }

    private void fillSegment(FillBlock fillBlock, Position position) {
        Block block;
        Block block2;
        FillBlock fillBlock2 = fillBlock;
        Position position2 = position;
        boolean isDataIndependentAddressing = isDataIndependentAddressing(position2);
        int startingIndex = getStartingIndex(position);
        int i10 = (position2.lane * this.laneLength) + (position2.slice * this.segmentLength) + startingIndex;
        int prevOffset = getPrevOffset(i10);
        if (isDataIndependentAddressing) {
            Block clear = fillBlock2.addressBlock.clear();
            Block clear2 = fillBlock2.inputBlock.clear();
            initAddressBlocks(fillBlock2, position2, clear2, clear);
            block2 = clear;
            block = clear2;
        } else {
            block2 = null;
            block = null;
        }
        boolean isWithXor = isWithXor(position2);
        int i11 = startingIndex;
        int i12 = i10;
        int i13 = prevOffset;
        while (i11 < this.segmentLength) {
            long pseudoRandom = getPseudoRandom(fillBlock, i11, block2, block, i13, isDataIndependentAddressing);
            int refLane = getRefLane(position2, pseudoRandom);
            int refColumn = getRefColumn(position, i11, pseudoRandom, refLane == position2.lane);
            Block[] blockArr = this.memory;
            Block block3 = blockArr[i13];
            Block block4 = blockArr[(this.laneLength * refLane) + refColumn];
            Block block5 = blockArr[i12];
            if (isWithXor) {
                fillBlock2.fillBlockWithXor(block3, block4, block5);
            } else {
                fillBlock2.fillBlock(block3, block4, block5);
            }
            i11++;
            i13 = i12;
            i12++;
        }
    }

    private int getPrevOffset(int i10) {
        int i11 = this.laneLength;
        return i10 % i11 == 0 ? (i10 + i11) - 1 : i10 - 1;
    }

    private long getPseudoRandom(FillBlock fillBlock, int i10, Block block, Block block2, int i11, boolean z10) {
        if (!z10) {
            return this.memory[i11].f41441v[0];
        }
        int i12 = i10 % 128;
        if (i12 == 0) {
            nextAddresses(fillBlock, block2, block);
        }
        return block.f41441v[i12];
    }

    private int getRefColumn(Position position, int i10, long j10, boolean z10) {
        int i11;
        int i12;
        int i13 = position.pass;
        int i14 = -1;
        int i15 = 0;
        int i16 = position.slice;
        if (i13 != 0) {
            int i17 = this.segmentLength;
            int i18 = this.laneLength;
            int i19 = ((i16 + 1) * i17) % i18;
            int i20 = i18 - i17;
            if (z10) {
                i12 = (i20 + i10) - 1;
            } else {
                if (i10 != 0) {
                    i14 = 0;
                }
                i12 = i20 + i14;
            }
            i15 = i19;
            i11 = i12;
        } else if (z10) {
            i11 = ((i16 * this.segmentLength) + i10) - 1;
        } else {
            int i21 = i16 * this.segmentLength;
            if (i10 != 0) {
                i14 = 0;
            }
            i11 = i21 + i14;
        }
        long j11 = j10 & 4294967295L;
        return ((int) (((long) i15) + (((long) (i11 - 1)) - ((((long) i11) * ((j11 * j11) >>> 32)) >>> 32)))) % this.laneLength;
    }

    private int getRefLane(Position position, long j10) {
        int lanes = (int) ((j10 >>> 32) % ((long) this.parameters.getLanes()));
        return (position.pass == 0 && position.slice == 0) ? position.lane : lanes;
    }

    private static int getStartingIndex(Position position) {
        return (position.pass == 0 && position.slice == 0) ? 2 : 0;
    }

    private void hash(byte[] bArr, byte[] bArr2, int i10, int i11) {
        byte[] bArr3 = new byte[4];
        Pack.intToLittleEndian(i11, bArr3, 0);
        if (i11 <= 64) {
            Blake2bDigest blake2bDigest = new Blake2bDigest(i11 * 8);
            blake2bDigest.update(bArr3, 0, 4);
            blake2bDigest.update(bArr, 0, bArr.length);
            blake2bDigest.doFinal(bArr2, i10);
            return;
        }
        Blake2bDigest blake2bDigest2 = new Blake2bDigest(512);
        byte[] bArr4 = new byte[64];
        blake2bDigest2.update(bArr3, 0, 4);
        blake2bDigest2.update(bArr, 0, bArr.length);
        blake2bDigest2.doFinal(bArr4, 0);
        System.arraycopy(bArr4, 0, bArr2, i10, 32);
        int i12 = i10 + 32;
        int i13 = 2;
        int i14 = ((i11 + 31) / 32) - 2;
        while (i13 <= i14) {
            blake2bDigest2.update(bArr4, 0, 64);
            blake2bDigest2.doFinal(bArr4, 0);
            System.arraycopy(bArr4, 0, bArr2, i12, 32);
            i13++;
            i12 += 32;
        }
        Blake2bDigest blake2bDigest3 = new Blake2bDigest((i11 - (i14 * 32)) * 8);
        blake2bDigest3.update(bArr4, 0, 64);
        blake2bDigest3.doFinal(bArr2, i12);
    }

    private void initAddressBlocks(FillBlock fillBlock, Position position, Block block, Block block2) {
        block.f41441v[0] = intToLong(position.pass);
        block.f41441v[1] = intToLong(position.lane);
        block.f41441v[2] = intToLong(position.slice);
        block.f41441v[3] = intToLong(this.memory.length);
        block.f41441v[4] = intToLong(this.parameters.getIterations());
        block.f41441v[5] = intToLong(this.parameters.getType());
        if (position.pass == 0 && position.slice == 0) {
            nextAddresses(fillBlock, block, block2);
        }
    }

    private void initMemory(int i10) {
        this.memory = new Block[i10];
        int i11 = 0;
        while (true) {
            Block[] blockArr = this.memory;
            if (i11 < blockArr.length) {
                blockArr[i11] = new Block();
                i11++;
            } else {
                return;
            }
        }
    }

    private void initialize(byte[] bArr, byte[] bArr2, int i10) {
        Blake2bDigest blake2bDigest = new Blake2bDigest(512);
        Pack.intToLittleEndian(new int[]{this.parameters.getLanes(), i10, this.parameters.getMemory(), this.parameters.getIterations(), this.parameters.getVersion(), this.parameters.getType()}, bArr, 0);
        blake2bDigest.update(bArr, 0, 24);
        addByteString(bArr, blake2bDigest, bArr2);
        addByteString(bArr, blake2bDigest, this.parameters.getSalt());
        addByteString(bArr, blake2bDigest, this.parameters.getSecret());
        addByteString(bArr, blake2bDigest, this.parameters.getAdditional());
        byte[] bArr3 = new byte[72];
        blake2bDigest.doFinal(bArr3, 0);
        fillFirstBlocks(bArr, bArr3);
    }

    private long intToLong(int i10) {
        return ((long) i10) & 4294967295L;
    }

    private boolean isDataIndependentAddressing(Position position) {
        if (this.parameters.getType() != 1) {
            return this.parameters.getType() == 2 && position.pass == 0 && position.slice < 2;
        }
        return true;
    }

    private boolean isWithXor(Position position) {
        return (position.pass == 0 || this.parameters.getVersion() == 16) ? false : true;
    }

    private void nextAddresses(FillBlock fillBlock, Block block, Block block2) {
        long[] access$400 = block.f41441v;
        access$400[6] = access$400[6] + 1;
        fillBlock.fillBlock(block, block2);
        fillBlock.fillBlock(block2, block2);
    }

    private static void quarterRound(long[] jArr, int i10, int i11, int i12, int i13) {
        long j10 = jArr[i10];
        long j11 = jArr[i11];
        long j12 = j10 + j11 + ((j10 & 4294967295L) * 2 * (4294967295L & j11));
        long rotateRight = Longs.rotateRight(jArr[i12] ^ j12, i13);
        jArr[i10] = j12;
        jArr[i12] = rotateRight;
    }

    private void reset() {
        if (this.memory != null) {
            int i10 = 0;
            while (true) {
                Block[] blockArr = this.memory;
                if (i10 < blockArr.length) {
                    Block block = blockArr[i10];
                    if (block != null) {
                        block.clear();
                    }
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void roundFunction(Block block, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25) {
        int i26 = i10;
        int i27 = i11;
        int i28 = i12;
        int i29 = i13;
        int i30 = i15;
        int i31 = i16;
        int i32 = i17;
        int i33 = i18;
        int i34 = i19;
        int i35 = i20;
        int i36 = i21;
        int i37 = i22;
        int i38 = i23;
        int i39 = i24;
        int i40 = i25;
        long[] access$400 = block.f41441v;
        F(access$400, i26, i14, i33, i37);
        F(access$400, i27, i30, i34, i38);
        F(access$400, i28, i31, i35, i39);
        long[] jArr = access$400;
        int i41 = i13;
        F(jArr, i41, i32, i36, i40);
        F(jArr, i26, i30, i35, i40);
        F(jArr, i27, i31, i36, i37);
        F(jArr, i28, i32, i33, i38);
        F(jArr, i41, i14, i34, i39);
    }

    public int generateBytes(byte[] bArr, byte[] bArr2) {
        return generateBytes(bArr, bArr2, 0, bArr2.length);
    }

    public int generateBytes(byte[] bArr, byte[] bArr2, int i10, int i11) {
        if (i11 >= 4) {
            byte[] bArr3 = new byte[1024];
            initialize(bArr3, bArr, i11);
            fillMemoryBlocks();
            digest(bArr3, bArr2, i10, i11);
            reset();
            return i11;
        }
        throw new IllegalStateException("output length less than 4");
    }

    public int generateBytes(char[] cArr, byte[] bArr) {
        return generateBytes(this.parameters.getCharToByteConverter().convert(cArr), bArr);
    }

    public int generateBytes(char[] cArr, byte[] bArr, int i10, int i11) {
        return generateBytes(this.parameters.getCharToByteConverter().convert(cArr), bArr, i10, i11);
    }

    public void init(Argon2Parameters argon2Parameters) {
        this.parameters = argon2Parameters;
        if (argon2Parameters.getLanes() < 1) {
            throw new IllegalStateException("lanes must be greater than 1");
        } else if (argon2Parameters.getLanes() > MAX_PARALLELISM) {
            throw new IllegalStateException("lanes must be less than 16777216");
        } else if (argon2Parameters.getMemory() < argon2Parameters.getLanes() * 2) {
            throw new IllegalStateException("memory is less than: " + (argon2Parameters.getLanes() * 2) + " expected " + (argon2Parameters.getLanes() * 2));
        } else if (argon2Parameters.getIterations() >= 1) {
            doInit(argon2Parameters);
        } else {
            throw new IllegalStateException("iterations is less than: 1");
        }
    }
}

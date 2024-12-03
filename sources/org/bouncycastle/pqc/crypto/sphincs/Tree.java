package org.bouncycastle.pqc.crypto.sphincs;

class Tree {

    static class leafaddr {
        int level;
        long subleaf;
        long subtree;

        public leafaddr() {
        }

        public leafaddr(leafaddr leafaddr) {
            this.level = leafaddr.level;
            this.subtree = leafaddr.subtree;
            this.subleaf = leafaddr.subleaf;
        }
    }

    Tree() {
    }

    static void gen_leaf_wots(HashFunctions hashFunctions, byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, leafaddr leafaddr2) {
        byte[] bArr4 = new byte[32];
        byte[] bArr5 = new byte[2144];
        Wots wots = new Wots();
        HashFunctions hashFunctions2 = hashFunctions;
        Seed.get_seed(hashFunctions, bArr4, 0, bArr3, leafaddr2);
        wots.wots_pkgen(hashFunctions, bArr5, 0, bArr4, 0, bArr2, i11);
        l_tree(hashFunctions, bArr, i10, bArr5, 0, bArr2, i11);
    }

    static void l_tree(HashFunctions hashFunctions, byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12) {
        int i13;
        byte[] bArr4 = bArr2;
        int i14 = i11;
        int i15 = 67;
        for (int i16 = 0; i16 < 7; i16++) {
            int i17 = 0;
            while (true) {
                i13 = i15 >>> 1;
                if (i17 >= i13) {
                    break;
                }
                hashFunctions.hash_2n_n_mask(bArr2, i14 + (i17 * 32), bArr2, i14 + (i17 * 2 * 32), bArr3, i12 + (i16 * 2 * 32));
                i17++;
            }
            if ((i15 & 1) != 0) {
                System.arraycopy(bArr4, i14 + ((i15 - 1) * 32), bArr4, (i13 * 32) + i14, 32);
                i13++;
            }
            i15 = i13;
        }
        byte[] bArr5 = bArr;
        System.arraycopy(bArr4, i14, bArr, i10, 32);
    }

    static void treehash(HashFunctions hashFunctions, byte[] bArr, int i10, int i11, byte[] bArr2, leafaddr leafaddr2, byte[] bArr3, int i12) {
        leafaddr leafaddr3 = new leafaddr(leafaddr2);
        int i13 = i11 + 1;
        byte[] bArr4 = new byte[(i13 * 32)];
        int[] iArr = new int[i13];
        int i14 = 1;
        int i15 = (int) (leafaddr3.subleaf + ((long) (1 << i11)));
        int i16 = 0;
        while (true) {
            int i17 = 32;
            if (leafaddr3.subleaf >= ((long) i15)) {
                break;
            }
            gen_leaf_wots(hashFunctions, bArr4, i16 * 32, bArr3, i12, bArr2, leafaddr3);
            iArr[i16] = 0;
            int i18 = i16 + i14;
            while (i18 > i14) {
                int i19 = iArr[i18 - 1];
                int i20 = i18 - 2;
                if (i19 != iArr[i20]) {
                    break;
                }
                int i21 = i20 * 32;
                int i22 = i15;
                int i23 = i21;
                int i24 = i14;
                int[] iArr2 = iArr;
                hashFunctions.hash_2n_n_mask(bArr4, i21, bArr4, i23, bArr3, i12 + ((i19 + 7) * 2 * i17));
                iArr2[i20] = iArr2[i20] + i24;
                i18--;
                i14 = i24;
                i17 = i17;
                i15 = i22;
                iArr = iArr2;
            }
            leafaddr3.subleaf++;
            i16 = i18;
            i14 = i14;
            i15 = i15;
            iArr = iArr;
        }
        for (int i25 = 0; i25 < 32; i25++) {
            bArr[i10 + i25] = bArr4[i25];
        }
    }
}

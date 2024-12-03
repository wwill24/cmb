package org.bouncycastle.pqc.crypto.gmss;

import org.bouncycastle.util.Arrays;

public class GMSSParameters {
    private int[] K;
    private int[] heightOfTrees;
    private int numOfLayers;
    private int[] winternitzParameter;

    public GMSSParameters(int i10) throws IllegalArgumentException {
        if (i10 <= 10) {
            init(1, new int[]{10}, new int[]{3}, new int[]{2});
        } else if (i10 <= 20) {
            init(2, new int[]{10, 10}, new int[]{5, 4}, new int[]{2, 2});
        } else {
            init(4, new int[]{10, 10, 10, 10}, new int[]{9, 9, 9, 3}, new int[]{2, 2, 2, 2});
        }
    }

    public GMSSParameters(int i10, int[] iArr, int[] iArr2, int[] iArr3) throws IllegalArgumentException {
        init(i10, iArr, iArr2, iArr3);
    }

    private void init(int i10, int[] iArr, int[] iArr2, int[] iArr3) throws IllegalArgumentException {
        boolean z10;
        String str;
        this.numOfLayers = i10;
        if (i10 == iArr2.length && i10 == iArr.length && i10 == iArr3.length) {
            z10 = true;
            str = "";
        } else {
            str = "Unexpected parameterset format";
            z10 = false;
        }
        for (int i11 = 0; i11 < this.numOfLayers; i11++) {
            int i12 = iArr3[i11];
            if (i12 < 2 || (iArr[i11] - i12) % 2 != 0) {
                str = "Wrong parameter K (K >= 2 and H-K even required)!";
                z10 = false;
            }
            if (iArr[i11] < 4 || iArr2[i11] < 2) {
                str = "Wrong parameter H or w (H > 3 and w > 1 required)!";
                z10 = false;
            }
        }
        if (z10) {
            this.heightOfTrees = Arrays.clone(iArr);
            this.winternitzParameter = Arrays.clone(iArr2);
            this.K = Arrays.clone(iArr3);
            return;
        }
        throw new IllegalArgumentException(str);
    }

    public int[] getHeightOfTrees() {
        return Arrays.clone(this.heightOfTrees);
    }

    public int[] getK() {
        return Arrays.clone(this.K);
    }

    public int getNumOfLayers() {
        return this.numOfLayers;
    }

    public int[] getWinternitzParameter() {
        return Arrays.clone(this.winternitzParameter);
    }
}

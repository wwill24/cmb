package org.bouncycastle.crypto.util;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.crypto.AlphabetMapper;

public class BasicAlphabetMapper implements AlphabetMapper {
    private Map<Integer, Character> charMap;
    private Map<Character, Integer> indexMap;

    public BasicAlphabetMapper(String str) {
        this(str.toCharArray());
    }

    public BasicAlphabetMapper(char[] cArr) {
        this.indexMap = new HashMap();
        this.charMap = new HashMap();
        int i10 = 0;
        while (i10 != cArr.length) {
            if (!this.indexMap.containsKey(Character.valueOf(cArr[i10]))) {
                this.indexMap.put(Character.valueOf(cArr[i10]), Integer.valueOf(i10));
                this.charMap.put(Integer.valueOf(i10), Character.valueOf(cArr[i10]));
                i10++;
            } else {
                throw new IllegalArgumentException("duplicate key detected in alphabet: " + cArr[i10]);
            }
        }
    }

    public char[] convertToChars(byte[] bArr) {
        char[] cArr;
        int i10 = 0;
        if (this.charMap.size() <= 256) {
            cArr = new char[bArr.length];
            while (i10 != bArr.length) {
                cArr[i10] = this.charMap.get(Integer.valueOf(bArr[i10] & 255)).charValue();
                i10++;
            }
        } else if ((bArr.length & 1) == 0) {
            cArr = new char[(bArr.length / 2)];
            while (i10 != bArr.length) {
                cArr[i10 / 2] = this.charMap.get(Integer.valueOf(((bArr[i10] << 8) & 65280) | (bArr[i10 + 1] & 255))).charValue();
                i10 += 2;
            }
        } else {
            throw new IllegalArgumentException("two byte radix and input string odd length");
        }
        return cArr;
    }

    public byte[] convertToIndexes(char[] cArr) {
        byte[] bArr;
        int i10 = 0;
        if (this.indexMap.size() <= 256) {
            bArr = new byte[cArr.length];
            while (i10 != cArr.length) {
                bArr[i10] = this.indexMap.get(Character.valueOf(cArr[i10])).byteValue();
                i10++;
            }
        } else {
            bArr = new byte[(cArr.length * 2)];
            while (i10 != cArr.length) {
                int intValue = this.indexMap.get(Character.valueOf(cArr[i10])).intValue();
                int i11 = i10 * 2;
                bArr[i11] = (byte) ((intValue >> 8) & 255);
                bArr[i11 + 1] = (byte) (intValue & 255);
                i10++;
            }
        }
        return bArr;
    }

    public int getRadix() {
        return this.indexMap.size();
    }
}

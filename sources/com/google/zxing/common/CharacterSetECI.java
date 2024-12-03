package com.google.zxing.common;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.jar.asm.Opcodes;
import org.bouncycastle.i18n.LocalizedMessage;
import org.jivesoftware.smack.util.StringUtils;

public enum CharacterSetECI {
    Cp437((String) new int[]{0, 2}, (int) new String[0]),
    ISO8859_1((String) new int[]{1, 3}, (int) new String[]{LocalizedMessage.DEFAULT_ENCODING}),
    ISO8859_2((String) 4, (int) new String[]{"ISO-8859-2"}),
    ISO8859_3((String) 5, (int) new String[]{"ISO-8859-3"}),
    ISO8859_4((String) 6, (int) new String[]{"ISO-8859-4"}),
    ISO8859_5((String) 7, (int) new String[]{"ISO-8859-5"}),
    ISO8859_7((String) 9, (int) new String[]{"ISO-8859-7"}),
    ISO8859_9((String) 11, (int) new String[]{"ISO-8859-9"}),
    ISO8859_13((String) 15, (int) new String[]{"ISO-8859-13"}),
    ISO8859_15((String) 17, (int) new String[]{"ISO-8859-15"}),
    ISO8859_16((String) 18, (int) new String[]{"ISO-8859-16"}),
    SJIS((String) 20, (int) new String[]{"Shift_JIS"}),
    Cp1250((String) 21, (int) new String[]{"windows-1250"}),
    Cp1251((String) 22, (int) new String[]{"windows-1251"}),
    Cp1252((String) 23, (int) new String[]{"windows-1252"}),
    Cp1256((String) 24, (int) new String[]{"windows-1256"}),
    UnicodeBigUnmarked((String) 25, (int) new String[]{"UTF-16BE", "UnicodeBig"}),
    UTF8((String) 26, (int) new String[]{"UTF-8"}),
    ASCII((String) new int[]{27, Opcodes.TABLESWITCH}, (int) new String[]{StringUtils.USASCII}),
    Big5(28),
    GB18030((String) 29, (int) new String[]{"GB2312", "EUC_CN", "GBK"}),
    EUC_KR((String) 30, (int) new String[]{"EUC-KR"});
    
    private static final Map<Integer, CharacterSetECI> D = null;
    private static final Map<String, CharacterSetECI> E = null;
    private final String[] otherEncodingNames;
    private final int[] values;

    static {
        D = new HashMap();
        E = new HashMap();
        for (CharacterSetECI characterSetECI : values()) {
            for (int valueOf : characterSetECI.values) {
                D.put(Integer.valueOf(valueOf), characterSetECI);
            }
            E.put(characterSetECI.name(), characterSetECI);
            for (String put : characterSetECI.otherEncodingNames) {
                E.put(put, characterSetECI);
            }
        }
    }

    private CharacterSetECI(int i10) {
        this(r3, r4, new int[]{i10}, new String[0]);
    }

    public static CharacterSetECI a(Charset charset) {
        return E.get(charset.name());
    }

    public static CharacterSetECI b(String str) {
        return E.get(str);
    }

    public int c() {
        return this.values[0];
    }

    private CharacterSetECI(int i10, String... strArr) {
        this.values = new int[]{i10};
        this.otherEncodingNames = strArr;
    }

    private CharacterSetECI(int[] iArr, String... strArr) {
        this.values = iArr;
        this.otherEncodingNames = strArr;
    }
}

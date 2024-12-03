package org.jivesoftware.smack.util;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public class StringUtils {
    public static final String AMP_ENCODE = "&amp;";
    public static final String APOS_ENCODE = "&apos;";
    public static final String GT_ENCODE = "&gt;";
    public static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
    public static final String LT_ENCODE = "&lt;";
    public static final String MD5 = "MD5";
    public static final String PORTABLE_NEWLINE_REGEX = "\\r?\\n";
    public static final String QUOTE_ENCODE = "&quot;";
    private static final int RANDOM_STRING_CHUNK_SIZE = 4;
    public static final String SHA1 = "SHA-1";
    private static final char[] UNAMBIGUOUS_NUMBERS_AND_LETTERS = UNAMBIGUOUS_NUMBERS_AND_LETTERS_STRING.toCharArray();
    public static final String UNAMBIGUOUS_NUMBERS_AND_LETTERS_STRING = "123456789ABCDEFGHIJKLMNPQRSTUVWXYZ";
    @Deprecated
    public static final String USASCII = "US-ASCII";
    @Deprecated
    public static final String UTF8 = "UTF-8";
    private static final Pattern XML_WHITESPACE = Pattern.compile("[\t\n\r ]");

    /* renamed from: org.jivesoftware.smack.util.StringUtils$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$util$StringUtils$XmlEscapeMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.jivesoftware.smack.util.StringUtils$XmlEscapeMode[] r0 = org.jivesoftware.smack.util.StringUtils.XmlEscapeMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jivesoftware$smack$util$StringUtils$XmlEscapeMode = r0
                org.jivesoftware.smack.util.StringUtils$XmlEscapeMode r1 = org.jivesoftware.smack.util.StringUtils.XmlEscapeMode.safe     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$util$StringUtils$XmlEscapeMode     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jivesoftware.smack.util.StringUtils$XmlEscapeMode r1 = org.jivesoftware.smack.util.StringUtils.XmlEscapeMode.forAttribute     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$util$StringUtils$XmlEscapeMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jivesoftware.smack.util.StringUtils$XmlEscapeMode r1 = org.jivesoftware.smack.util.StringUtils.XmlEscapeMode.forAttributeApos     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$jivesoftware$smack$util$StringUtils$XmlEscapeMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jivesoftware.smack.util.StringUtils$XmlEscapeMode r1 = org.jivesoftware.smack.util.StringUtils.XmlEscapeMode.forText     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.util.StringUtils.AnonymousClass1.<clinit>():void");
        }
    }

    private enum XmlEscapeMode {
        safe,
        forAttribute,
        forAttributeApos,
        forText
    }

    public static Appendable appendHeading(Appendable appendable, String str) throws IOException {
        return appendHeading(appendable, str, SignatureVisitor.SUPER);
    }

    public static void appendTo(Collection<? extends Object> collection, StringBuilder sb2) {
        appendTo(collection, ", ", sb2);
    }

    public static String collectionToString(Collection<? extends Object> collection) {
        return toStringBuilder(collection, " ").toString();
    }

    public static String deleteXmlWhitespace(String str) {
        return XML_WHITESPACE.matcher(str).replaceAll("");
    }

    public static String encodeHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10] & 255;
            int i11 = i10 * 2;
            char[] cArr2 = HEX_CHARS;
            cArr[i11] = cArr2[b10 >>> 4];
            cArr[i11 + 1] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }

    public static CharSequence escapeForXml(CharSequence charSequence) {
        return escapeForXml(charSequence, XmlEscapeMode.safe);
    }

    public static CharSequence escapeForXmlAttribute(CharSequence charSequence) {
        return escapeForXml(charSequence, XmlEscapeMode.forAttribute);
    }

    public static CharSequence escapeForXmlAttributeApos(CharSequence charSequence) {
        return escapeForXml(charSequence, XmlEscapeMode.forAttributeApos);
    }

    public static CharSequence escapeForXmlText(CharSequence charSequence) {
        return escapeForXml(charSequence, XmlEscapeMode.forText);
    }

    @Deprecated
    public static synchronized String hash(String str) {
        String hex;
        synchronized (StringUtils.class) {
            hex = SHA1.hex(str);
        }
        return hex;
    }

    public static String insecureRandomString(int i10) {
        return randomString(i10, RandomUtil.RANDOM.get());
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isNullOrEmpty(charSequence);
    }

    public static boolean isNullOrEmpty(CharSequence charSequence) {
        return charSequence == null || isEmpty(charSequence);
    }

    public static boolean isNullOrNotEmpty(CharSequence charSequence) {
        if (charSequence == null) {
            return true;
        }
        return !charSequence.toString().isEmpty();
    }

    public static String maybeToString(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return charSequence.toString();
    }

    public static int nullSafeCharSequenceComparator(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence == null) ^ (charSequence2 == null)) {
            return charSequence == null ? -1 : 1;
        }
        if (charSequence == null && charSequence2 == null) {
            return 0;
        }
        return charSequence.toString().compareTo(charSequence2.toString());
    }

    public static boolean nullSafeCharSequenceEquals(CharSequence charSequence, CharSequence charSequence2) {
        return nullSafeCharSequenceComparator(charSequence, charSequence2) == 0;
    }

    private static String randomString(Random random, char[] cArr, int i10) {
        CharBuffer allocate = CharBuffer.allocate(((i10 - 1) / 4) + i10);
        try {
            randomString(allocate, random, cArr, i10);
            return allocate.flip().toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public static <CS extends CharSequence> CS requireNotNullNorEmpty(CS cs, String str) {
        if (!isNullOrEmpty((CharSequence) cs)) {
            return cs;
        }
        throw new IllegalArgumentException(str);
    }

    @Deprecated
    public static <CS extends CharSequence> CS requireNotNullOrEmpty(CS cs, String str) {
        return requireNotNullNorEmpty(cs, str);
    }

    public static <CS extends CharSequence> CS requireNullOrNotEmpty(CS cs, String str) {
        if (cs == null) {
            return null;
        }
        if (!isEmpty(cs)) {
            return cs;
        }
        throw new IllegalArgumentException(str);
    }

    public static String returnIfNotEmptyTrimmed(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() > 0) {
            return trim;
        }
        return null;
    }

    public static String secureOfflineAttackSafeRandomString() {
        return randomString(RandomUtil.SECURE_RANDOM.get(), UNAMBIGUOUS_NUMBERS_AND_LETTERS, 24);
    }

    public static String secureOnlineAttackSafeRandomString() {
        return randomString(RandomUtil.SECURE_RANDOM.get(), UNAMBIGUOUS_NUMBERS_AND_LETTERS, 10);
    }

    public static String secureUniqueRandomString() {
        return randomString(RandomUtil.SECURE_RANDOM.get(), UNAMBIGUOUS_NUMBERS_AND_LETTERS, 13);
    }

    public static List<String> splitLinesPortable(String str) {
        return Arrays.asList(str.split(PORTABLE_NEWLINE_REGEX));
    }

    public static StringBuilder toStringBuilder(Collection<? extends Object> collection, String str) {
        StringBuilder sb2 = new StringBuilder(collection.size() * 20);
        appendTo(collection, str, sb2);
        return sb2;
    }

    public static List<String> toStrings(Collection<? extends CharSequence> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (CharSequence charSequence : collection) {
            arrayList.add(charSequence.toString());
        }
        return arrayList;
    }

    public static byte[] toUtf8Bytes(String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }

    public static Appendable appendHeading(Appendable appendable, String str, char c10) throws IOException {
        appendable.append(str).append(10);
        for (int i10 = 0; i10 < str.length(); i10++) {
            appendable.append(c10);
        }
        return appendable.append(10);
    }

    public static <O> void appendTo(Collection<O> collection, StringBuilder sb2, Consumer<O> consumer) {
        appendTo(collection, ", ", sb2, consumer);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        if (r6 != '<') goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        if (r6 != '<') goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r6 != '\'') goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        if (r6 != '\'') goto L_0x0065;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.CharSequence escapeForXml(java.lang.CharSequence r16, org.jivesoftware.smack.util.StringUtils.XmlEscapeMode r17) {
        /*
            r0 = r16
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r2 = r16.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            double r4 = (double) r2
            r6 = 4608533498688228557(0x3ff4cccccccccccd, double:1.3)
            double r4 = r4 * r6
            int r4 = (int) r4
            r3.<init>(r4)
            r4 = 0
            r5 = r4
        L_0x0019:
            if (r4 >= r2) goto L_0x0081
            char r6 = r0.charAt(r4)
            int[] r7 = org.jivesoftware.smack.util.StringUtils.AnonymousClass1.$SwitchMap$org$jivesoftware$smack$util$StringUtils$XmlEscapeMode
            int r8 = r17.ordinal()
            r7 = r7[r8]
            java.lang.String r8 = "&quot;"
            r9 = 34
            java.lang.String r10 = "&apos;"
            r11 = 39
            r12 = 1
            java.lang.String r13 = "&lt;"
            java.lang.String r14 = "&amp;"
            r15 = 38
            r1 = 60
            if (r7 == r12) goto L_0x0059
            r12 = 2
            if (r7 == r12) goto L_0x0050
            r8 = 3
            if (r7 == r8) goto L_0x0049
            r8 = 4
            if (r7 == r8) goto L_0x0044
            goto L_0x0065
        L_0x0044:
            if (r6 == r15) goto L_0x0069
            if (r6 == r1) goto L_0x006e
            goto L_0x0065
        L_0x0049:
            if (r6 == r15) goto L_0x0069
            if (r6 == r11) goto L_0x0067
            if (r6 == r1) goto L_0x006e
            goto L_0x0065
        L_0x0050:
            if (r6 == r9) goto L_0x006f
            if (r6 == r1) goto L_0x006e
            if (r6 == r15) goto L_0x0069
            if (r6 == r11) goto L_0x0067
            goto L_0x0065
        L_0x0059:
            if (r6 == r9) goto L_0x006f
            if (r6 == r1) goto L_0x006e
            r1 = 62
            if (r6 == r1) goto L_0x006b
            if (r6 == r15) goto L_0x0069
            if (r6 == r11) goto L_0x0067
        L_0x0065:
            r8 = 0
            goto L_0x006f
        L_0x0067:
            r8 = r10
            goto L_0x006f
        L_0x0069:
            r8 = r14
            goto L_0x006f
        L_0x006b:
            java.lang.String r8 = "&gt;"
            goto L_0x006f
        L_0x006e:
            r8 = r13
        L_0x006f:
            if (r8 == 0) goto L_0x007d
            if (r4 <= r5) goto L_0x0076
            r3.append(r0, r5, r4)
        L_0x0076:
            r3.append(r8)
            int r5 = r4 + 1
            r4 = r5
            goto L_0x007f
        L_0x007d:
            int r4 = r4 + 1
        L_0x007f:
            r1 = 0
            goto L_0x0019
        L_0x0081:
            if (r5 != 0) goto L_0x0084
            return r0
        L_0x0084:
            if (r4 <= r5) goto L_0x0089
            r3.append(r0, r5, r4)
        L_0x0089:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.util.StringUtils.escapeForXml(java.lang.CharSequence, org.jivesoftware.smack.util.StringUtils$XmlEscapeMode):java.lang.CharSequence");
    }

    public static boolean isNotEmpty(CharSequence... charSequenceArr) {
        for (CharSequence isNullOrEmpty : charSequenceArr) {
            if (isNullOrEmpty(isNullOrEmpty)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNullOrEmpty(CharSequence... charSequenceArr) {
        for (CharSequence isNotEmpty : charSequenceArr) {
            if (isNotEmpty(isNotEmpty)) {
                return false;
            }
        }
        return true;
    }

    public static void appendTo(Collection<? extends Object> collection, String str, StringBuilder sb2) {
        appendTo(collection, str, sb2, new o(sb2));
    }

    public static <O> void appendTo(Collection<O> collection, String str, StringBuilder sb2, Consumer<O> consumer) {
        Iterator<O> it = collection.iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
            if (it.hasNext()) {
                sb2.append(str);
            }
        }
    }

    private static void randomString(Appendable appendable, Random random, char[] cArr, int i10) throws IOException {
        for (int i11 = 1; i11 <= i10; i11++) {
            appendable.append(cArr[random.nextInt(cArr.length)]);
            if (i11 % 4 == 0 && i11 < i10) {
                appendable.append(SignatureVisitor.SUPER);
            }
        }
    }

    public static String randomString(int i10) {
        return randomString(i10, RandomUtil.SECURE_RANDOM.get());
    }

    public static String randomString(int i10, Random random) {
        if (i10 == 0) {
            return "";
        }
        char[] cArr = new char[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            char[] cArr2 = UNAMBIGUOUS_NUMBERS_AND_LETTERS;
            cArr[i11] = cArr2[random.nextInt(cArr2.length)];
        }
        return new String(cArr);
    }
}

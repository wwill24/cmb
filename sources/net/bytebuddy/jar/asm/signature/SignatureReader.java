package net.bytebuddy.jar.asm.signature;

public class SignatureReader {
    private final String signatureValue;

    public SignatureReader(String str) {
        this.signatureValue = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int parseType(java.lang.String r8, int r9, net.bytebuddy.jar.asm.signature.SignatureVisitor r10) {
        /*
            int r0 = r9 + 1
            char r9 = r8.charAt(r9)
            r1 = 70
            if (r9 == r1) goto L_0x00c0
            r1 = 76
            r2 = 59
            r3 = 1
            if (r9 == r1) goto L_0x004c
            r1 = 86
            if (r9 == r1) goto L_0x00c0
            r1 = 73
            if (r9 == r1) goto L_0x00c0
            r1 = 74
            if (r9 == r1) goto L_0x00c0
            r1 = 83
            if (r9 == r1) goto L_0x00c0
            r1 = 84
            if (r9 == r1) goto L_0x003f
            r1 = 90
            if (r9 == r1) goto L_0x00c0
            r1 = 91
            if (r9 == r1) goto L_0x0036
            switch(r9) {
                case 66: goto L_0x00c0;
                case 67: goto L_0x00c0;
                case 68: goto L_0x00c0;
                default: goto L_0x0030;
            }
        L_0x0030:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>()
            throw r8
        L_0x0036:
            net.bytebuddy.jar.asm.signature.SignatureVisitor r9 = r10.visitArrayType()
            int r8 = parseType(r8, r0, r9)
            return r8
        L_0x003f:
            int r9 = r8.indexOf(r2, r0)
            java.lang.String r8 = r8.substring(r0, r9)
            r10.visitTypeVariable(r8)
            int r9 = r9 + r3
            return r9
        L_0x004c:
            r9 = 0
            r4 = r9
            r5 = r4
        L_0x004f:
            r1 = r0
        L_0x0050:
            int r6 = r0 + 1
            char r0 = r8.charAt(r0)
            r7 = 46
            if (r0 == r7) goto L_0x00a5
            if (r0 != r2) goto L_0x005d
            goto L_0x00a5
        L_0x005d:
            r7 = 60
            if (r0 != r7) goto L_0x00a3
            int r0 = r6 + -1
            java.lang.String r0 = r8.substring(r1, r0)
            if (r5 == 0) goto L_0x006d
            r10.visitInnerClassType(r0)
            goto L_0x0070
        L_0x006d:
            r10.visitClassType(r0)
        L_0x0070:
            r0 = r6
        L_0x0071:
            char r4 = r8.charAt(r0)
            r6 = 62
            if (r4 == r6) goto L_0x00a1
            r6 = 42
            if (r4 == r6) goto L_0x009b
            r6 = 43
            if (r4 == r6) goto L_0x0090
            r6 = 45
            if (r4 == r6) goto L_0x0090
            r4 = 61
            net.bytebuddy.jar.asm.signature.SignatureVisitor r4 = r10.visitTypeArgument(r4)
            int r0 = parseType(r8, r0, r4)
            goto L_0x0071
        L_0x0090:
            int r0 = r0 + 1
            net.bytebuddy.jar.asm.signature.SignatureVisitor r4 = r10.visitTypeArgument(r4)
            int r0 = parseType(r8, r0, r4)
            goto L_0x0071
        L_0x009b:
            int r0 = r0 + 1
            r10.visitTypeArgument()
            goto L_0x0071
        L_0x00a1:
            r4 = r3
            goto L_0x0050
        L_0x00a3:
            r0 = r6
            goto L_0x0050
        L_0x00a5:
            if (r4 != 0) goto L_0x00b6
            int r4 = r6 + -1
            java.lang.String r1 = r8.substring(r1, r4)
            if (r5 == 0) goto L_0x00b3
            r10.visitInnerClassType(r1)
            goto L_0x00b6
        L_0x00b3:
            r10.visitClassType(r1)
        L_0x00b6:
            if (r0 != r2) goto L_0x00bc
            r10.visitEnd()
            return r6
        L_0x00bc:
            r4 = r9
            r5 = r3
            r0 = r6
            goto L_0x004f
        L_0x00c0:
            r10.visitBaseType(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.signature.SignatureReader.parseType(java.lang.String, int, net.bytebuddy.jar.asm.signature.SignatureVisitor):int");
    }

    public void accept(SignatureVisitor signatureVisitor) {
        char charAt;
        String str = this.signatureValue;
        int length = str.length();
        int i10 = 0;
        if (str.charAt(0) == '<') {
            i10 = 2;
            do {
                int indexOf = str.indexOf(58, i10);
                signatureVisitor.visitFormalTypeParameter(str.substring(i10 - 1, indexOf));
                int i11 = indexOf + 1;
                char charAt2 = str.charAt(i11);
                if (charAt2 == 'L' || charAt2 == '[' || charAt2 == 'T') {
                    i11 = parseType(str, i11, signatureVisitor.visitClassBound());
                }
                while (true) {
                    i10 = i11 + 1;
                    charAt = str.charAt(i11);
                    if (charAt != ':') {
                        break;
                    }
                    i11 = parseType(str, i10, signatureVisitor.visitInterfaceBound());
                }
            } while (charAt != '>');
        }
        if (str.charAt(i10) == '(') {
            int i12 = i10 + 1;
            while (str.charAt(i12) != ')') {
                i12 = parseType(str, i12, signatureVisitor.visitParameterType());
            }
            int parseType = parseType(str, i12 + 1, signatureVisitor.visitReturnType());
            while (parseType < length) {
                parseType = parseType(str, parseType + 1, signatureVisitor.visitExceptionType());
            }
            return;
        }
        int parseType2 = parseType(str, i10, signatureVisitor.visitSuperclass());
        while (parseType2 < length) {
            parseType2 = parseType(str, parseType2, signatureVisitor.visitInterface());
        }
    }

    public void acceptType(SignatureVisitor signatureVisitor) {
        parseType(this.signatureValue, 0, signatureVisitor);
    }
}

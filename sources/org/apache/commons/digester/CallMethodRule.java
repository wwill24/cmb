package org.apache.commons.digester;

import org.apache.commons.logging.Log;
import org.xml.sax.Attributes;

public class CallMethodRule extends Rule {
    static /* synthetic */ Class class$java$lang$String;
    protected String bodyText;
    protected String methodName;
    private String[] paramClassNames;
    protected int paramCount;
    protected Class[] paramTypes;
    protected int targetOffset;
    protected boolean useExactMatch;

    public CallMethodRule(Digester digester, String str, int i10) {
        this(str, i10);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError(e10.getMessage());
        }
    }

    public void begin(Attributes attributes) throws Exception {
        int i10 = this.paramCount;
        if (i10 > 0) {
            Object[] objArr = new Object[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                objArr[i11] = null;
            }
            this.digester.pushParams(objArr);
        }
    }

    public void body(String str) throws Exception {
        if (this.paramCount == 0) {
            this.bodyText = str.trim();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0097, code lost:
        if (r7.isAssignableFrom(r10.paramTypes[r6]) == false) goto L_0x009f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void end() throws java.lang.Exception {
        /*
            r10 = this;
            int r0 = r10.paramCount
            java.lang.String r1 = "java.lang.String"
            java.lang.String r2 = ")"
            r3 = 1
            r4 = 0
            if (r0 <= 0) goto L_0x004c
            org.apache.commons.digester.Digester r0 = r10.digester
            java.lang.Object r0 = r0.popParams()
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            org.apache.commons.digester.Digester r5 = r10.digester
            org.apache.commons.logging.Log r5 = r5.log
            boolean r5 = r5.isTraceEnabled()
            if (r5 == 0) goto L_0x0043
            int r5 = r0.length
            r6 = r4
        L_0x001e:
            if (r6 >= r5) goto L_0x0043
            org.apache.commons.digester.Digester r7 = r10.digester
            org.apache.commons.logging.Log r7 = r7.log
            java.lang.StringBuffer r8 = new java.lang.StringBuffer
            r8.<init>()
            java.lang.String r9 = "[CallMethodRule]("
            r8.append(r9)
            r8.append(r6)
            r8.append(r2)
            r9 = r0[r6]
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.trace(r8)
            int r6 = r6 + 1
            goto L_0x001e
        L_0x0043:
            int r5 = r10.paramCount
            if (r5 != r3) goto L_0x0072
            r3 = r0[r4]
            if (r3 != 0) goto L_0x0072
            return
        L_0x004c:
            java.lang.Class[] r0 = r10.paramTypes
            if (r0 == 0) goto L_0x0071
            int r5 = r0.length
            if (r5 == 0) goto L_0x0071
            java.lang.String r5 = r10.bodyText
            if (r5 != 0) goto L_0x0058
            return
        L_0x0058:
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r6[r4] = r5
            int r0 = r0.length
            if (r0 != 0) goto L_0x006f
            java.lang.Class[] r0 = new java.lang.Class[r3]
            r10.paramTypes = r0
            java.lang.Class r3 = class$java$lang$String
            if (r3 != 0) goto L_0x006d
            java.lang.Class r3 = class$(r1)
            class$java$lang$String = r3
        L_0x006d:
            r0[r4] = r3
        L_0x006f:
            r0 = r6
            goto L_0x0072
        L_0x0071:
            r0 = 0
        L_0x0072:
            java.lang.Class[] r3 = r10.paramTypes
            int r3 = r3.length
            java.lang.Object[] r5 = new java.lang.Object[r3]
            r6 = r4
        L_0x0078:
            java.lang.Class[] r7 = r10.paramTypes
            int r7 = r7.length
            if (r6 >= r7) goto L_0x00b0
            r7 = r0[r6]
            if (r7 == 0) goto L_0x009f
            boolean r7 = r7 instanceof java.lang.String
            if (r7 == 0) goto L_0x009a
            java.lang.Class r7 = class$java$lang$String
            if (r7 != 0) goto L_0x008f
            java.lang.Class r7 = class$(r1)
            class$java$lang$String = r7
        L_0x008f:
            java.lang.Class[] r8 = r10.paramTypes
            r8 = r8[r6]
            boolean r7 = r7.isAssignableFrom(r8)
            if (r7 != 0) goto L_0x009a
            goto L_0x009f
        L_0x009a:
            r7 = r0[r6]
            r5[r6] = r7
            goto L_0x00ad
        L_0x009f:
            r7 = r0[r6]
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Class[] r8 = r10.paramTypes
            r8 = r8[r6]
            java.lang.Object r7 = org.apache.commons.beanutils.ConvertUtils.convert((java.lang.String) r7, (java.lang.Class<?>) r8)
            r5[r6] = r7
        L_0x00ad:
            int r6 = r6 + 1
            goto L_0x0078
        L_0x00b0:
            int r0 = r10.targetOffset
            if (r0 < 0) goto L_0x00bb
            org.apache.commons.digester.Digester r1 = r10.digester
            java.lang.Object r0 = r1.peek((int) r0)
            goto L_0x00c8
        L_0x00bb:
            org.apache.commons.digester.Digester r0 = r10.digester
            int r1 = r0.getCount()
            int r6 = r10.targetOffset
            int r1 = r1 + r6
            java.lang.Object r0 = r0.peek((int) r1)
        L_0x00c8:
            java.lang.String r1 = "[CallMethodRule]{"
            if (r0 == 0) goto L_0x015b
            org.apache.commons.digester.Digester r6 = r10.digester
            org.apache.commons.logging.Log r6 = r6.log
            boolean r6 = r6.isDebugEnabled()
            if (r6 == 0) goto L_0x0142
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            r6.<init>(r1)
            org.apache.commons.digester.Digester r1 = r10.digester
            java.lang.String r1 = r1.match
            r6.append(r1)
            java.lang.String r1 = "} Call "
            r6.append(r1)
            java.lang.Class r1 = r0.getClass()
            java.lang.String r1 = r1.getName()
            r6.append(r1)
            java.lang.String r1 = "."
            r6.append(r1)
            java.lang.String r1 = r10.methodName
            r6.append(r1)
            java.lang.String r1 = "("
            r6.append(r1)
        L_0x0101:
            if (r4 >= r3) goto L_0x0134
            if (r4 <= 0) goto L_0x010a
            java.lang.String r1 = ","
            r6.append(r1)
        L_0x010a:
            r1 = r5[r4]
            java.lang.String r7 = "null"
            if (r1 != 0) goto L_0x0114
            r6.append(r7)
            goto L_0x011b
        L_0x0114:
            java.lang.String r1 = r1.toString()
            r6.append(r1)
        L_0x011b:
            java.lang.String r1 = "/"
            r6.append(r1)
            java.lang.Class[] r1 = r10.paramTypes
            r1 = r1[r4]
            if (r1 != 0) goto L_0x012a
            r6.append(r7)
            goto L_0x0131
        L_0x012a:
            java.lang.String r1 = r1.getName()
            r6.append(r1)
        L_0x0131:
            int r4 = r4 + 1
            goto L_0x0101
        L_0x0134:
            r6.append(r2)
            org.apache.commons.digester.Digester r1 = r10.digester
            org.apache.commons.logging.Log r1 = r1.log
            java.lang.String r2 = r6.toString()
            r1.debug(r2)
        L_0x0142:
            boolean r1 = r10.useExactMatch
            if (r1 == 0) goto L_0x014f
            java.lang.String r1 = r10.methodName
            java.lang.Class[] r2 = r10.paramTypes
            java.lang.Object r0 = org.apache.commons.beanutils.MethodUtils.invokeExactMethod(r0, r1, r5, r2)
            goto L_0x0157
        L_0x014f:
            java.lang.String r1 = r10.methodName
            java.lang.Class[] r2 = r10.paramTypes
            java.lang.Object r0 = org.apache.commons.beanutils.MethodUtils.invokeMethod(r0, r1, r5, r2)
        L_0x0157:
            r10.processMethodCallResult(r0)
            return
        L_0x015b:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r0.append(r1)
            org.apache.commons.digester.Digester r1 = r10.digester
            java.lang.String r1 = r1.match
            r0.append(r1)
            java.lang.String r1 = "} Call target is null ("
            r0.append(r1)
            java.lang.String r1 = "targetOffset="
            r0.append(r1)
            int r1 = r10.targetOffset
            r0.append(r1)
            java.lang.String r1 = ",stackdepth="
            r0.append(r1)
            org.apache.commons.digester.Digester r1 = r10.digester
            int r1 = r1.getCount()
            r0.append(r1)
            r0.append(r2)
            org.xml.sax.SAXException r1 = new org.xml.sax.SAXException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.digester.CallMethodRule.end():void");
    }

    public void finish() throws Exception {
        this.bodyText = null;
    }

    public boolean getUseExactMatch() {
        return this.useExactMatch;
    }

    /* access modifiers changed from: protected */
    public void processMethodCallResult(Object obj) {
    }

    public void setDigester(Digester digester) {
        super.setDigester(digester);
        String[] strArr = this.paramClassNames;
        if (strArr != null) {
            this.paramTypes = new Class[strArr.length];
            for (int i10 = 0; i10 < this.paramClassNames.length; i10++) {
                try {
                    this.paramTypes[i10] = digester.getClassLoader().loadClass(this.paramClassNames[i10]);
                } catch (ClassNotFoundException e10) {
                    Log logger = digester.getLogger();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("(CallMethodRule) Cannot load class ");
                    stringBuffer.append(this.paramClassNames[i10]);
                    logger.error(stringBuffer.toString(), e10);
                    this.paramTypes[i10] = null;
                }
            }
        }
    }

    public void setUseExactMatch(boolean z10) {
        this.useExactMatch = z10;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("CallMethodRule[");
        stringBuffer.append("methodName=");
        stringBuffer.append(this.methodName);
        stringBuffer.append(", paramCount=");
        stringBuffer.append(this.paramCount);
        stringBuffer.append(", paramTypes={");
        if (this.paramTypes != null) {
            for (int i10 = 0; i10 < this.paramTypes.length; i10++) {
                if (i10 > 0) {
                    stringBuffer.append(", ");
                }
                stringBuffer.append(this.paramTypes[i10].getName());
            }
        }
        stringBuffer.append("}");
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public CallMethodRule(Digester digester, String str, int i10, String[] strArr) {
        this(str, i10, strArr);
    }

    public CallMethodRule(Digester digester, String str, int i10, Class[] clsArr) {
        this(str, i10, clsArr);
    }

    public CallMethodRule(String str, int i10) {
        this(0, str, i10);
    }

    public CallMethodRule(int i10, String str, int i11) {
        this.bodyText = null;
        this.paramTypes = null;
        this.paramClassNames = null;
        int i12 = 0;
        this.useExactMatch = false;
        this.targetOffset = i10;
        this.methodName = str;
        this.paramCount = i11;
        if (i11 == 0) {
            Class[] clsArr = new Class[1];
            Class cls = class$java$lang$String;
            if (cls == null) {
                cls = class$("java.lang.String");
                class$java$lang$String = cls;
            }
            clsArr[0] = cls;
            this.paramTypes = clsArr;
            return;
        }
        this.paramTypes = new Class[i11];
        while (true) {
            Class[] clsArr2 = this.paramTypes;
            if (i12 < clsArr2.length) {
                Class cls2 = class$java$lang$String;
                if (cls2 == null) {
                    cls2 = class$("java.lang.String");
                    class$java$lang$String = cls2;
                }
                clsArr2[i12] = cls2;
                i12++;
            } else {
                return;
            }
        }
    }

    public CallMethodRule(String str) {
        this(0, str, 0, (Class[]) null);
    }

    public CallMethodRule(int i10, String str) {
        this(i10, str, 0, (Class[]) null);
    }

    public CallMethodRule(String str, int i10, String[] strArr) {
        this(0, str, i10, strArr);
    }

    public CallMethodRule(int i10, String str, int i11, String[] strArr) {
        this.bodyText = null;
        this.paramTypes = null;
        this.paramClassNames = null;
        int i12 = 0;
        this.useExactMatch = false;
        this.targetOffset = i10;
        this.methodName = str;
        this.paramCount = i11;
        if (strArr == null) {
            this.paramTypes = new Class[i11];
            while (true) {
                Class[] clsArr = this.paramTypes;
                if (i12 < clsArr.length) {
                    Class cls = class$java$lang$String;
                    if (cls == null) {
                        cls = class$("java.lang.String");
                        class$java$lang$String = cls;
                    }
                    clsArr[i12] = cls;
                    i12++;
                } else {
                    return;
                }
            }
        } else {
            this.paramClassNames = new String[strArr.length];
            while (true) {
                String[] strArr2 = this.paramClassNames;
                if (i12 < strArr2.length) {
                    strArr2[i12] = strArr[i12];
                    i12++;
                } else {
                    return;
                }
            }
        }
    }

    public CallMethodRule(String str, int i10, Class[] clsArr) {
        this(0, str, i10, clsArr);
    }

    public CallMethodRule(int i10, String str, int i11, Class[] clsArr) {
        this.bodyText = null;
        this.paramTypes = null;
        this.paramClassNames = null;
        int i12 = 0;
        this.useExactMatch = false;
        this.targetOffset = i10;
        this.methodName = str;
        this.paramCount = i11;
        if (clsArr == null) {
            this.paramTypes = new Class[i11];
            while (true) {
                Class[] clsArr2 = this.paramTypes;
                if (i12 < clsArr2.length) {
                    Class cls = class$java$lang$String;
                    if (cls == null) {
                        cls = class$("java.lang.String");
                        class$java$lang$String = cls;
                    }
                    clsArr2[i12] = cls;
                    i12++;
                } else {
                    return;
                }
            }
        } else {
            this.paramTypes = new Class[clsArr.length];
            while (true) {
                Class[] clsArr3 = this.paramTypes;
                if (i12 < clsArr3.length) {
                    clsArr3[i12] = clsArr[i12];
                    i12++;
                } else {
                    return;
                }
            }
        }
    }
}

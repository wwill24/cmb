package org.apache.commons.digester;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtendedBaseRules extends RulesBase {
    private int counter = 0;
    /* access modifiers changed from: private */
    public Map order = new HashMap();

    private boolean basicMatch(String str, String str2) {
        return str2.equals(str.substring(2)) || str2.endsWith(str.substring(1));
    }

    private List findExactAncesterMatch(String str) {
        int length = str.length();
        while (true) {
            int i10 = length - 1;
            if (length <= 0) {
                return null;
            }
            length = str.lastIndexOf(47, i10);
            if (length > 0) {
                HashMap hashMap = this.cache;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str.substring(0, length));
                stringBuffer.append("/*");
                List list = (List) hashMap.get(stringBuffer.toString());
                if (list != null) {
                    return list;
                }
            }
        }
    }

    private boolean parentMatch(String str, String str2, String str3) {
        return str3.endsWith(str.substring(1, str.length() - 2));
    }

    public void add(String str, Rule rule) {
        super.add(str, rule);
        int i10 = this.counter + 1;
        this.counter = i10;
        this.order.put(rule, new Integer(i10));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: java.util.List} */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0080, code lost:
        if (r10 != null) goto L_0x005d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List match(java.lang.String r22, java.lang.String r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = 47
            int r4 = r2.lastIndexOf(r3)
            r5 = -1
            r6 = 1
            r7 = 0
            if (r4 != r5) goto L_0x0015
            java.lang.String r4 = ""
            r8 = r7
            goto L_0x001a
        L_0x0015:
            java.lang.String r4 = r2.substring(r7, r4)
            r8 = r6
        L_0x001a:
            java.util.ArrayList r9 = new java.util.ArrayList
            int r10 = r0.counter
            r9.<init>(r10)
            java.util.HashMap r10 = r0.cache
            java.lang.String r11 = "!*"
            java.lang.Object r10 = r10.get(r11)
            java.util.List r10 = (java.util.List) r10
            if (r10 == 0) goto L_0x0030
            r9.addAll(r10)
        L_0x0030:
            java.util.HashMap r10 = r0.cache
            java.lang.StringBuffer r11 = new java.lang.StringBuffer
            r11.<init>()
            java.lang.String r12 = "!"
            r11.append(r12)
            r11.append(r4)
            java.lang.String r13 = "/?"
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            java.lang.Object r10 = r10.get(r11)
            java.util.List r10 = (java.util.List) r10
            if (r10 == 0) goto L_0x0053
            r9.addAll(r10)
        L_0x0053:
            java.util.HashMap r10 = r0.cache
            java.lang.Object r10 = r10.get(r2)
            java.util.List r10 = (java.util.List) r10
            if (r10 == 0) goto L_0x005f
        L_0x005d:
            r8 = r6
            goto L_0x0084
        L_0x005f:
            if (r8 == 0) goto L_0x0083
            java.util.HashMap r8 = r0.cache
            java.lang.StringBuffer r10 = new java.lang.StringBuffer
            r10.<init>()
            r10.append(r4)
            r10.append(r13)
            java.lang.String r10 = r10.toString()
            java.lang.Object r8 = r8.get(r10)
            r10 = r8
            java.util.List r10 = (java.util.List) r10
            if (r10 == 0) goto L_0x007c
            goto L_0x005d
        L_0x007c:
            java.util.List r10 = r0.findExactAncesterMatch(r2)
            if (r10 == 0) goto L_0x0083
            goto L_0x005d
        L_0x0083:
            r8 = r7
        L_0x0084:
            java.util.HashMap r11 = r0.cache
            java.util.Set r11 = r11.keySet()
            java.util.Iterator r11 = r11.iterator()
            r14 = r7
        L_0x008f:
            boolean r15 = r11.hasNext()
            if (r15 == 0) goto L_0x019c
            java.lang.Object r15 = r11.next()
            java.lang.String r15 = (java.lang.String) r15
            boolean r16 = r15.startsWith(r12)
            if (r16 == 0) goto L_0x00a9
            int r3 = r15.length()
            java.lang.String r15 = r15.substring(r6, r3)
        L_0x00a9:
            java.lang.String r3 = "*/"
            boolean r3 = r15.startsWith(r3)
            java.lang.String r6 = "/*"
            boolean r6 = r15.endsWith(r6)
            if (r3 != 0) goto L_0x00c2
            if (r16 == 0) goto L_0x00bc
            if (r6 == 0) goto L_0x00bc
            goto L_0x00c2
        L_0x00bc:
            r20 = r4
            r5 = 47
            goto L_0x0194
        L_0x00c2:
            boolean r18 = r15.endsWith(r13)
            if (r18 == 0) goto L_0x00d5
            boolean r19 = r0.parentMatch(r15, r2, r4)
            r20 = r4
            r4 = r7
            r17 = r19
            r5 = 47
            goto L_0x0151
        L_0x00d5:
            if (r6 == 0) goto L_0x0146
            r7 = 2
            if (r3 == 0) goto L_0x010f
            int r20 = r15.length()
            int r5 = r20 + -2
            java.lang.String r5 = r15.substring(r7, r5)
            boolean r7 = r2.endsWith(r5)
            if (r7 == 0) goto L_0x00ed
            r5 = 1
            r7 = -1
            goto L_0x0108
        L_0x00ed:
            java.lang.StringBuffer r7 = new java.lang.StringBuffer
            r7.<init>()
            r7.append(r5)
            java.lang.String r5 = "/"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            int r5 = r2.indexOf(r5)
            r7 = -1
            if (r5 <= r7) goto L_0x0107
            r5 = 1
            goto L_0x0108
        L_0x0107:
            r5 = 0
        L_0x0108:
            r20 = r4
            r7 = r5
            r4 = 0
            r5 = 47
            goto L_0x014f
        L_0x010f:
            int r20 = r15.length()
            int r7 = r20 + -2
            r5 = 0
            java.lang.String r7 = r15.substring(r5, r7)
            boolean r19 = r2.startsWith(r7)
            if (r19 == 0) goto L_0x013e
            int r5 = r23.length()
            r20 = r4
            int r4 = r7.length()
            if (r5 != r4) goto L_0x0130
            r4 = 1
            r5 = 47
            goto L_0x0143
        L_0x0130:
            int r4 = r7.length()
            char r4 = r2.charAt(r4)
            r5 = 47
            if (r4 != r5) goto L_0x0142
            r4 = 1
            goto L_0x0143
        L_0x013e:
            r20 = r4
            r5 = 47
        L_0x0142:
            r4 = 0
        L_0x0143:
            r7 = r4
            r4 = 0
            goto L_0x014f
        L_0x0146:
            r20 = r4
            r5 = 47
            boolean r4 = r0.basicMatch(r15, r2)
            r7 = 0
        L_0x014f:
            r17 = 0
        L_0x0151:
            if (r17 != 0) goto L_0x0157
            if (r4 != 0) goto L_0x0157
            if (r7 == 0) goto L_0x0194
        L_0x0157:
            if (r16 == 0) goto L_0x0176
            java.util.HashMap r3 = r0.cache
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>()
            r4.append(r12)
            r4.append(r15)
            java.lang.String r4 = r4.toString()
            java.lang.Object r3 = r3.get(r4)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x0194
            r9.addAll(r3)
            goto L_0x0194
        L_0x0176:
            if (r8 != 0) goto L_0x0194
            int r4 = r15.length()
            if (r3 == 0) goto L_0x0180
            int r4 = r4 + -1
        L_0x0180:
            if (r6 == 0) goto L_0x0185
        L_0x0182:
            int r4 = r4 + -1
            goto L_0x0188
        L_0x0185:
            if (r18 == 0) goto L_0x0188
            goto L_0x0182
        L_0x0188:
            if (r4 <= r14) goto L_0x0194
            java.util.HashMap r3 = r0.cache
            java.lang.Object r3 = r3.get(r15)
            java.util.List r3 = (java.util.List) r3
            r10 = r3
            r14 = r4
        L_0x0194:
            r3 = r5
            r4 = r20
            r5 = -1
            r6 = 1
            r7 = 0
            goto L_0x008f
        L_0x019c:
            if (r10 != 0) goto L_0x01a9
            java.util.HashMap r2 = r0.cache
            java.lang.String r3 = "*"
            java.lang.Object r2 = r2.get(r3)
            r10 = r2
            java.util.List r10 = (java.util.List) r10
        L_0x01a9:
            if (r10 == 0) goto L_0x01ae
            r9.addAll(r10)
        L_0x01ae:
            if (r1 == 0) goto L_0x01d0
            java.util.Iterator r2 = r9.iterator()
        L_0x01b4:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x01d0
            java.lang.Object r3 = r2.next()
            org.apache.commons.digester.Rule r3 = (org.apache.commons.digester.Rule) r3
            java.lang.String r3 = r3.getNamespaceURI()
            if (r3 == 0) goto L_0x01b4
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x01b4
            r2.remove()
            goto L_0x01b4
        L_0x01d0:
            org.apache.commons.digester.ExtendedBaseRules$1 r1 = new org.apache.commons.digester.ExtendedBaseRules$1
            r1.<init>()
            java.util.Collections.sort(r9, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.digester.ExtendedBaseRules.match(java.lang.String, java.lang.String):java.util.List");
    }
}

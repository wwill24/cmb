package b3;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mparticle.kits.ReportingMessage;

class l0 {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7793a = JsonReader.a.a("nm", "c", "w", ReportingMessage.MessageType.OPT_OUT, "lc", "lj", "ml", "hd", "d");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f7794b = JsonReader.a.a("n", ReportingMessage.MessageType.SCREEN_VIEW);

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.ShapeStroke a(com.airbnb.lottie.parser.moshi.JsonReader r18, com.airbnb.lottie.h r19) throws java.io.IOException {
        /*
            r0 = r18
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r1 = 0
            r4 = 0
            r11 = r1
            r10 = r4
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r12 = 0
        L_0x0012:
            boolean r13 = r18.g()
            if (r13 == 0) goto L_0x00fe
            com.airbnb.lottie.parser.moshi.JsonReader$a r13 = f7793a
            int r13 = r0.y(r13)
            r14 = 1
            switch(r13) {
                case 0: goto L_0x00f6;
                case 1: goto L_0x00ee;
                case 2: goto L_0x00e6;
                case 3: goto L_0x00de;
                case 4: goto L_0x00cf;
                case 5: goto L_0x00c0;
                case 6: goto L_0x00b7;
                case 7: goto L_0x00af;
                case 8: goto L_0x0028;
                default: goto L_0x0022;
            }
        L_0x0022:
            r2 = r19
            r18.E()
            goto L_0x0012
        L_0x0028:
            r18.b()
        L_0x002b:
            boolean r13 = r18.g()
            if (r13 == 0) goto L_0x0099
            r18.c()
            r13 = 0
            r15 = 0
        L_0x0036:
            boolean r16 = r18.g()
            if (r16 == 0) goto L_0x0057
            com.airbnb.lottie.parser.moshi.JsonReader$a r2 = f7794b
            int r2 = r0.y(r2)
            if (r2 == 0) goto L_0x0052
            if (r2 == r14) goto L_0x004d
            r18.C()
            r18.E()
            goto L_0x0036
        L_0x004d:
            x2.b r15 = b3.d.e(r18, r19)
            goto L_0x0036
        L_0x0052:
            java.lang.String r13 = r18.n()
            goto L_0x0036
        L_0x0057:
            r18.f()
            r13.hashCode()
            int r17 = r13.hashCode()
            switch(r17) {
                case 100: goto L_0x007c;
                case 103: goto L_0x0071;
                case 111: goto L_0x0066;
                default: goto L_0x0064;
            }
        L_0x0064:
            r2 = -1
            goto L_0x0086
        L_0x0066:
            java.lang.String r2 = "o"
            boolean r2 = r13.equals(r2)
            if (r2 != 0) goto L_0x006f
            goto L_0x0064
        L_0x006f:
            r2 = 2
            goto L_0x0086
        L_0x0071:
            java.lang.String r2 = "g"
            boolean r2 = r13.equals(r2)
            if (r2 != 0) goto L_0x007a
            goto L_0x0064
        L_0x007a:
            r2 = r14
            goto L_0x0086
        L_0x007c:
            java.lang.String r2 = "d"
            boolean r2 = r13.equals(r2)
            if (r2 != 0) goto L_0x0085
            goto L_0x0064
        L_0x0085:
            r2 = r1
        L_0x0086:
            switch(r2) {
                case 0: goto L_0x0090;
                case 1: goto L_0x0090;
                case 2: goto L_0x008c;
                default: goto L_0x0089;
            }
        L_0x0089:
            r2 = r19
            goto L_0x002b
        L_0x008c:
            r2 = r19
            r5 = r15
            goto L_0x002b
        L_0x0090:
            r2 = r19
            r2.u(r14)
            r3.add(r15)
            goto L_0x002b
        L_0x0099:
            r2 = r19
            r18.e()
            int r13 = r3.size()
            if (r13 != r14) goto L_0x0012
            java.lang.Object r13 = r3.get(r1)
            x2.b r13 = (x2.b) r13
            r3.add(r13)
            goto L_0x0012
        L_0x00af:
            r2 = r19
            boolean r11 = r18.h()
            goto L_0x0012
        L_0x00b7:
            r2 = r19
            double r13 = r18.k()
            float r10 = (float) r13
            goto L_0x0012
        L_0x00c0:
            r2 = r19
            com.airbnb.lottie.model.content.ShapeStroke$LineJoinType[] r9 = com.airbnb.lottie.model.content.ShapeStroke.LineJoinType.values()
            int r13 = r18.l()
            int r13 = r13 - r14
            r9 = r9[r13]
            goto L_0x0012
        L_0x00cf:
            r2 = r19
            com.airbnb.lottie.model.content.ShapeStroke$LineCapType[] r8 = com.airbnb.lottie.model.content.ShapeStroke.LineCapType.values()
            int r13 = r18.l()
            int r13 = r13 - r14
            r8 = r8[r13]
            goto L_0x0012
        L_0x00de:
            r2 = r19
            x2.d r12 = b3.d.h(r18, r19)
            goto L_0x0012
        L_0x00e6:
            r2 = r19
            x2.b r7 = b3.d.e(r18, r19)
            goto L_0x0012
        L_0x00ee:
            r2 = r19
            x2.a r6 = b3.d.c(r18, r19)
            goto L_0x0012
        L_0x00f6:
            r2 = r19
            java.lang.String r4 = r18.n()
            goto L_0x0012
        L_0x00fe:
            if (r12 != 0) goto L_0x0115
            x2.d r0 = new x2.d
            d3.a r1 = new d3.a
            r2 = 100
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.<init>(r2)
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r0.<init>(r1)
            r12 = r0
        L_0x0115:
            com.airbnb.lottie.model.content.ShapeStroke r13 = new com.airbnb.lottie.model.content.ShapeStroke
            r0 = r13
            r1 = r4
            r2 = r5
            r4 = r6
            r5 = r12
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.l0.a(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.h):com.airbnb.lottie.model.content.ShapeStroke");
    }
}

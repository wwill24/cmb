package b3;

import com.airbnb.lottie.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mparticle.kits.ReportingMessage;
import java.io.IOException;
import x2.a;
import x2.b;

public class k {

    /* renamed from: f  reason: collision with root package name */
    private static final JsonReader.a f7784f = JsonReader.a.a("ef");

    /* renamed from: g  reason: collision with root package name */
    private static final JsonReader.a f7785g = JsonReader.a.a("nm", ReportingMessage.MessageType.SCREEN_VIEW);

    /* renamed from: a  reason: collision with root package name */
    private a f7786a;

    /* renamed from: b  reason: collision with root package name */
    private b f7787b;

    /* renamed from: c  reason: collision with root package name */
    private b f7788c;

    /* renamed from: d  reason: collision with root package name */
    private b f7789d;

    /* renamed from: e  reason: collision with root package name */
    private b f7790e;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        if (r0.equals("Opacity") == false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.airbnb.lottie.parser.moshi.JsonReader r6, com.airbnb.lottie.h r7) throws java.io.IOException {
        /*
            r5 = this;
            r6.c()
            java.lang.String r0 = ""
        L_0x0005:
            boolean r1 = r6.g()
            if (r1 == 0) goto L_0x0090
            com.airbnb.lottie.parser.moshi.JsonReader$a r1 = f7785g
            int r1 = r6.y(r1)
            if (r1 == 0) goto L_0x008a
            r2 = 1
            if (r1 == r2) goto L_0x001d
            r6.C()
            r6.E()
            goto L_0x0005
        L_0x001d:
            r0.hashCode()
            r1 = -1
            int r3 = r0.hashCode()
            r4 = 0
            switch(r3) {
                case 353103893: goto L_0x0055;
                case 397447147: goto L_0x004c;
                case 1041377119: goto L_0x0041;
                case 1379387491: goto L_0x0036;
                case 1383710113: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            r2 = r1
            goto L_0x005f
        L_0x002b:
            java.lang.String r2 = "Softness"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            r2 = 4
            goto L_0x005f
        L_0x0036:
            java.lang.String r2 = "Shadow Color"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x003f
            goto L_0x0029
        L_0x003f:
            r2 = 3
            goto L_0x005f
        L_0x0041:
            java.lang.String r2 = "Direction"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x004a
            goto L_0x0029
        L_0x004a:
            r2 = 2
            goto L_0x005f
        L_0x004c:
            java.lang.String r3 = "Opacity"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L_0x005f
            goto L_0x0029
        L_0x0055:
            java.lang.String r2 = "Distance"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x005e
            goto L_0x0029
        L_0x005e:
            r2 = r4
        L_0x005f:
            switch(r2) {
                case 0: goto L_0x0082;
                case 1: goto L_0x007b;
                case 2: goto L_0x0074;
                case 3: goto L_0x006d;
                case 4: goto L_0x0066;
                default: goto L_0x0062;
            }
        L_0x0062:
            r6.E()
            goto L_0x0005
        L_0x0066:
            x2.b r1 = b3.d.e(r6, r7)
            r5.f7790e = r1
            goto L_0x0005
        L_0x006d:
            x2.a r1 = b3.d.c(r6, r7)
            r5.f7786a = r1
            goto L_0x0005
        L_0x0074:
            x2.b r1 = b3.d.f(r6, r7, r4)
            r5.f7788c = r1
            goto L_0x0005
        L_0x007b:
            x2.b r1 = b3.d.f(r6, r7, r4)
            r5.f7787b = r1
            goto L_0x0005
        L_0x0082:
            x2.b r1 = b3.d.e(r6, r7)
            r5.f7789d = r1
            goto L_0x0005
        L_0x008a:
            java.lang.String r0 = r6.n()
            goto L_0x0005
        L_0x0090:
            r6.f()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.k.a(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.h):void");
    }

    /* access modifiers changed from: package-private */
    public j b(JsonReader jsonReader, h hVar) throws IOException {
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        while (jsonReader.g()) {
            if (jsonReader.y(f7784f) != 0) {
                jsonReader.C();
                jsonReader.E();
            } else {
                jsonReader.b();
                while (jsonReader.g()) {
                    a(jsonReader, hVar);
                }
                jsonReader.e();
            }
        }
        a aVar = this.f7786a;
        if (aVar == null || (bVar = this.f7787b) == null || (bVar2 = this.f7788c) == null || (bVar3 = this.f7789d) == null || (bVar4 = this.f7790e) == null) {
            return null;
        }
        return new j(aVar, bVar, bVar2, bVar3, bVar4);
    }
}

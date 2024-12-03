package com.withpersona.sdk2.camera.analyzers;

import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class TextExtractionAnalyzer implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final a f14237c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final d f14238a = b();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Integer> f14239b = new HashMap<>();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final d b() {
        try {
            Object newInstance = Class.forName("com.withpersona.sdk2.inquiry.extraction.impl.TextEntityExtractorImpl").newInstance();
            j.e(newInstance, "null cannot be cast to non-null type com.withpersona.sdk2.camera.analyzers.TextEntityExtractor");
            return (d) newInstance;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00af A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00dd A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(com.withpersona.sdk2.camera.s r8, android.graphics.Rect r9, kotlin.coroutines.c<? super kotlin.Result<? extends com.withpersona.sdk2.camera.analyzers.a>> r10) {
        /*
            r7 = this;
            boolean r9 = r10 instanceof com.withpersona.sdk2.camera.analyzers.TextExtractionAnalyzer$analyze$1
            if (r9 == 0) goto L_0x0013
            r9 = r10
            com.withpersona.sdk2.camera.analyzers.TextExtractionAnalyzer$analyze$1 r9 = (com.withpersona.sdk2.camera.analyzers.TextExtractionAnalyzer$analyze$1) r9
            int r0 = r9.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L_0x0013
            int r0 = r0 - r1
            r9.label = r0
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.camera.analyzers.TextExtractionAnalyzer$analyze$1 r9 = new com.withpersona.sdk2.camera.analyzers.TextExtractionAnalyzer$analyze$1
            r9.<init>(r7, r10)
        L_0x0018:
            java.lang.Object r10 = r9.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r9.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r3) goto L_0x002e
            java.lang.Object r8 = r9.L$0
            com.withpersona.sdk2.camera.analyzers.TextExtractionAnalyzer r8 = (com.withpersona.sdk2.camera.analyzers.TextExtractionAnalyzer) r8
            gk.g.b(r10)
            goto L_0x004d
        L_0x002e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0036:
            gk.g.b(r10)
            com.withpersona.sdk2.camera.analyzers.d r10 = r7.f14238a
            if (r10 == 0) goto L_0x0050
            zg.a r8 = r8.c()
            r9.L$0 = r7
            r9.label = r3
            java.lang.Object r10 = r10.b(r8, r9)
            if (r10 != r0) goto L_0x004c
            return r0
        L_0x004c:
            r8 = r7
        L_0x004d:
            kotlin.Result r10 = (kotlin.Result) r10
            goto L_0x0052
        L_0x0050:
            r8 = r7
            r10 = r2
        L_0x0052:
            if (r10 == 0) goto L_0x0062
            java.lang.Object r9 = r10.j()
            boolean r0 = kotlin.Result.g(r9)
            if (r0 == 0) goto L_0x005f
            r9 = r2
        L_0x005f:
            com.withpersona.sdk2.camera.analyzers.a r9 = (com.withpersona.sdk2.camera.analyzers.a) r9
            goto L_0x0063
        L_0x0062:
            r9 = r2
        L_0x0063:
            boolean r0 = r9 instanceof com.withpersona.sdk2.camera.analyzers.a.f
            if (r0 == 0) goto L_0x007a
            com.withpersona.sdk2.camera.analyzers.a$f r9 = (com.withpersona.sdk2.camera.analyzers.a.f) r9
            com.withpersona.sdk2.camera.ExtractedTexts r1 = r9.a()
            java.util.Date r2 = r1.a()
            com.withpersona.sdk2.camera.ExtractedTexts r9 = r9.a()
            java.util.Date r9 = r9.c()
            goto L_0x007b
        L_0x007a:
            r9 = r2
        L_0x007b:
            r1 = 0
            if (r2 == 0) goto L_0x00ad
            if (r9 == 0) goto L_0x00ad
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r2.toString()
            r4.append(r5)
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            java.util.HashMap<java.lang.String, java.lang.Integer> r5 = r8.f14239b
            java.lang.Object r6 = r5.get(r4)
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 != 0) goto L_0x00a1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.a.b(r1)
        L_0x00a1:
            int r6 = r6.intValue()
            int r6 = r6 + r3
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.a.b(r6)
            r5.put(r4, r6)
        L_0x00ad:
            if (r2 == 0) goto L_0x00b3
            if (r9 == 0) goto L_0x00b3
            r4 = r3
            goto L_0x00b4
        L_0x00b3:
            r4 = r1
        L_0x00b4:
            java.util.HashMap<java.lang.String, java.lang.Integer> r5 = r8.f14239b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            java.lang.Object r5 = r5.get(r6)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 != 0) goto L_0x00d2
            r5 = -1
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.a.b(r5)
        L_0x00d2:
            int r5 = r5.intValue()
            r6 = 3
            if (r5 < r6) goto L_0x00da
            goto L_0x00db
        L_0x00da:
            r3 = r1
        L_0x00db:
            if (r4 == 0) goto L_0x00fd
            if (r3 == 0) goto L_0x00fd
            com.withpersona.sdk2.camera.analyzers.d r8 = r8.f14238a
            if (r8 == 0) goto L_0x00e6
            r8.close()
        L_0x00e6:
            kotlin.Result$a r8 = kotlin.Result.f32010a
            com.withpersona.sdk2.camera.analyzers.a$f r8 = new com.withpersona.sdk2.camera.analyzers.a$f
            com.withpersona.sdk2.camera.ExtractedTexts r10 = new com.withpersona.sdk2.camera.ExtractedTexts
            kotlin.jvm.internal.j.d(r2)
            kotlin.jvm.internal.j.d(r9)
            r10.<init>(r2, r9)
            r8.<init>(r10)
            java.lang.Object r8 = kotlin.Result.b(r8)
            goto L_0x0117
        L_0x00fd:
            if (r0 == 0) goto L_0x0108
            kotlin.Result$a r8 = kotlin.Result.f32010a
            com.withpersona.sdk2.camera.analyzers.a$b r8 = com.withpersona.sdk2.camera.analyzers.a.b.f14241a
            java.lang.Object r8 = kotlin.Result.b(r8)
            goto L_0x0117
        L_0x0108:
            if (r10 == 0) goto L_0x010f
            java.lang.Object r8 = r10.j()
            goto L_0x0117
        L_0x010f:
            kotlin.Result$a r8 = kotlin.Result.f32010a
            com.withpersona.sdk2.camera.analyzers.a$b r8 = com.withpersona.sdk2.camera.analyzers.a.b.f14241a
            java.lang.Object r8 = kotlin.Result.b(r8)
        L_0x0117:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.analyzers.TextExtractionAnalyzer.a(com.withpersona.sdk2.camera.s, android.graphics.Rect, kotlin.coroutines.c):java.lang.Object");
    }
}

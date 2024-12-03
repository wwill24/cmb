package com.withpersona.sdk2.inquiry.selfie.network;

import com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker$run$1", f = "SubmitVerificationWorker.kt", l = {140, 161, 163}, m = "invokeSuspend")
final class SubmitVerificationWorker$run$1 extends SuspendLambda implements Function2<c<? super SubmitVerificationWorker.b>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SubmitVerificationWorker this$0;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f27430a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.withpersona.sdk2.inquiry.selfie.Selfie$Direction[] r0 = com.withpersona.sdk2.inquiry.selfie.Selfie.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.selfie.Selfie$Direction r1 = com.withpersona.sdk2.inquiry.selfie.Selfie.Direction.CENTER     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.withpersona.sdk2.inquiry.selfie.Selfie$Direction r1 = com.withpersona.sdk2.inquiry.selfie.Selfie.Direction.LEFT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.withpersona.sdk2.inquiry.selfie.Selfie$Direction r1 = com.withpersona.sdk2.inquiry.selfie.Selfie.Direction.RIGHT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f27430a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker$run$1.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubmitVerificationWorker$run$1(SubmitVerificationWorker submitVerificationWorker, kotlin.coroutines.c<? super SubmitVerificationWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = submitVerificationWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        SubmitVerificationWorker$run$1 submitVerificationWorker$run$1 = new SubmitVerificationWorker$run$1(this.this$0, cVar);
        submitVerificationWorker$run$1.L$0 = obj;
        return submitVerificationWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super SubmitVerificationWorker.b> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((SubmitVerificationWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x02fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r6) goto L_0x0031
            if (r2 == r5) goto L_0x0024
            if (r2 != r4) goto L_0x001c
            java.lang.Object r1 = r0.L$0
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r1 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r1
            gk.g.b(r19)
            goto L_0x0317
        L_0x001c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0024:
            java.lang.Object r2 = r0.L$1
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r2 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r2
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.c r5 = (kotlinx.coroutines.flow.c) r5
            gk.g.b(r19)
            goto L_0x02f8
        L_0x0031:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.c r2 = (kotlinx.coroutines.flow.c) r2
            gk.g.b(r19)
            r3 = r19
        L_0x003a:
            r5 = r2
            goto L_0x02aa
        L_0x003d:
            gk.g.b(r19)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.c r2 = (kotlinx.coroutines.flow.c) r2
            com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker r7 = r0.this$0
            ui.a r8 = r7.f27421j
            com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker r9 = r0.this$0
            java.util.List r9 = r9.f27416e
            r7.n(r8, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker r8 = r0.this$0
            java.util.List r8 = r8.f27416e
            com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker r9 = r0.this$0
            java.util.Iterator r8 = r8.iterator()
        L_0x0064:
            boolean r10 = r8.hasNext()
            java.lang.String r13 = "data[attributes][fields]["
            if (r10 == 0) goto L_0x021e
            java.lang.Object r10 = r8.next()
            com.withpersona.sdk2.inquiry.selfie.Selfie r10 = (com.withpersona.sdk2.inquiry.selfie.Selfie) r10
            java.io.File r14 = new java.io.File
            java.lang.String r15 = r10.a()
            r14.<init>(r15)
            boolean r15 = r10 instanceof com.withpersona.sdk2.inquiry.selfie.Selfie.SelfieImage
            java.lang.String r3 = "][files][][type]"
            java.lang.String r12 = "][files][][capture-method]"
            java.lang.String r11 = "][files][][name]"
            java.lang.String r4 = "][files][][frames][]"
            if (r15 == 0) goto L_0x0175
            wi.a r15 = r9.f27423l
            r15.a(r14)
            okhttp3.z$a r15 = okhttp3.z.f33274a
            okhttp3.v$a r5 = okhttp3.v.f33190e
            java.lang.String r6 = "image/*"
            okhttp3.v r5 = r5.b(r6)
            okhttp3.z r5 = r15.a(r14, r5)
            r6 = r10
            com.withpersona.sdk2.inquiry.selfie.Selfie$SelfieImage r6 = (com.withpersona.sdk2.inquiry.selfie.Selfie.SelfieImage) r6
            com.withpersona.sdk2.inquiry.selfie.Selfie$Direction r6 = r6.d()
            int[] r15 = com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker$run$1.a.f27430a
            int r6 = r6.ordinal()
            r6 = r15[r6]
            r15 = 1
            if (r6 == r15) goto L_0x00c0
            r15 = 2
            if (r6 == r15) goto L_0x00bd
            r15 = 3
            if (r6 != r15) goto L_0x00b7
            java.lang.String r6 = "right_photo"
            goto L_0x00c2
        L_0x00b7:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x00bd:
            java.lang.String r6 = "left_photo"
            goto L_0x00c2
        L_0x00c0:
            java.lang.String r6 = "center_photo"
        L_0x00c2:
            okhttp3.w$c$a r15 = okhttp3.w.c.f33214c
            r16 = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r13)
            r17 = r8
            java.lang.String r8 = r9.f27420i
            r6.append(r8)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            java.lang.String r6 = r14.getName()
            okhttp3.w$c r4 = r15.c(r4, r6, r5)
            r5 = 4
            okhttp3.w$c[] r5 = new okhttp3.w.c[r5]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r13)
            java.lang.String r8 = r9.f27420i
            r6.append(r8)
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            com.withpersona.sdk2.inquiry.selfie.v r8 = r9.f27415d
            com.withpersona.sdk2.inquiry.selfie.v$a r11 = com.withpersona.sdk2.inquiry.selfie.v.a.f27435a
            boolean r11 = kotlin.jvm.internal.j.b(r8, r11)
            if (r11 == 0) goto L_0x010e
            java.lang.String r8 = "photo"
            goto L_0x0118
        L_0x010e:
            com.withpersona.sdk2.inquiry.selfie.v$b r11 = com.withpersona.sdk2.inquiry.selfie.v.b.f27436a
            boolean r8 = kotlin.jvm.internal.j.b(r8, r11)
            if (r8 == 0) goto L_0x016f
            r8 = r16
        L_0x0118:
            okhttp3.w$c r6 = r15.b(r6, r8)
            r8 = 0
            r5[r8] = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r13)
            java.lang.String r8 = r9.f27420i
            r6.append(r8)
            r6.append(r12)
            java.lang.String r6 = r6.toString()
            com.withpersona.sdk2.inquiry.selfie.Selfie$CaptureMethod r8 = r10.c()
            java.lang.String r8 = r8.b()
            okhttp3.w$c r6 = r15.b(r6, r8)
            r8 = 1
            r5[r8] = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r13)
            java.lang.String r8 = r9.f27420i
            r6.append(r8)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            java.lang.String r6 = "image"
            okhttp3.w$c r3 = r15.b(r3, r6)
            r6 = 2
            r5[r6] = r3
            r3 = 3
            r5[r3] = r4
            java.util.List r3 = kotlin.collections.q.m(r5)
            r7.addAll(r3)
            goto L_0x0217
        L_0x016f:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x0175:
            r17 = r8
            boolean r5 = r10 instanceof com.withpersona.sdk2.inquiry.selfie.Selfie.SelfieVideo
            if (r5 == 0) goto L_0x0217
            okhttp3.z$a r5 = okhttp3.z.f33274a
            okhttp3.v$a r6 = okhttp3.v.f33190e
            java.lang.String r8 = "video/*"
            okhttp3.v r6 = r6.b(r8)
            okhttp3.z r5 = r5.a(r14, r6)
            okhttp3.w$c$a r6 = okhttp3.w.c.f33214c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r13)
            java.lang.String r15 = r9.f27420i
            r8.append(r15)
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            java.lang.String r8 = r14.getName()
            okhttp3.w$c r4 = r6.c(r4, r8, r5)
            r5 = 4
            okhttp3.w$c[] r5 = new okhttp3.w.c[r5]
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r13)
            java.lang.String r14 = r9.f27420i
            r8.append(r14)
            r8.append(r11)
            java.lang.String r8 = r8.toString()
            java.lang.String r11 = "video"
            okhttp3.w$c r8 = r6.b(r8, r11)
            r14 = 0
            r5[r14] = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r13)
            java.lang.String r14 = r9.f27420i
            r8.append(r14)
            r8.append(r12)
            java.lang.String r8 = r8.toString()
            com.withpersona.sdk2.inquiry.selfie.Selfie$CaptureMethod r10 = r10.c()
            java.lang.String r10 = r10.b()
            okhttp3.w$c r8 = r6.b(r8, r10)
            r10 = 1
            r5[r10] = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r13)
            java.lang.String r10 = r9.f27420i
            r8.append(r10)
            r8.append(r3)
            java.lang.String r3 = r8.toString()
            okhttp3.w$c r3 = r6.b(r3, r11)
            r6 = 2
            r5[r6] = r3
            r3 = 3
            r5[r3] = r4
            java.util.List r3 = kotlin.collections.q.m(r5)
            r7.addAll(r3)
        L_0x0217:
            r8 = r17
            r4 = 3
            r5 = 2
            r6 = 1
            goto L_0x0064
        L_0x021e:
            com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker r3 = r0.this$0
            r4 = 5
            okhttp3.w$c[] r4 = new okhttp3.w.c[r4]
            okhttp3.w$c$a r5 = okhttp3.w.c.f33214c
            java.lang.String r6 = r3.f27414c
            java.lang.String r8 = "data[id]"
            okhttp3.w$c r6 = r5.b(r8, r6)
            r8 = 0
            r4[r8] = r6
            java.lang.String r6 = "data[type]"
            java.lang.String r8 = "inquiry"
            okhttp3.w$c r6 = r5.b(r6, r8)
            r8 = 1
            r4[r8] = r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r13)
            java.lang.String r8 = r3.f27420i
            r6.append(r8)
            java.lang.String r8 = "][type]"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            com.withpersona.sdk2.inquiry.selfie.v r8 = r3.f27415d
            com.withpersona.sdk2.inquiry.selfie.v$a r9 = com.withpersona.sdk2.inquiry.selfie.v.a.f27435a
            boolean r9 = kotlin.jvm.internal.j.b(r8, r9)
            if (r9 == 0) goto L_0x0264
            java.lang.String r8 = "only_center"
            goto L_0x026e
        L_0x0264:
            com.withpersona.sdk2.inquiry.selfie.v$b r9 = com.withpersona.sdk2.inquiry.selfie.v.b.f27436a
            boolean r8 = kotlin.jvm.internal.j.b(r8, r9)
            if (r8 == 0) goto L_0x031a
            java.lang.String r8 = "profile_and_center"
        L_0x026e:
            okhttp3.w$c r6 = r5.b(r6, r8)
            r8 = 2
            r4[r8] = r6
            java.lang.String r6 = r3.f27419h
            java.lang.String r8 = "meta[from_component]"
            okhttp3.w$c r6 = r5.b(r8, r6)
            r8 = 3
            r4[r8] = r6
            java.lang.String r3 = r3.f27418g
            java.lang.String r6 = "meta[from_step]"
            okhttp3.w$c r3 = r5.b(r6, r3)
            r5 = 4
            r4[r5] = r3
            java.util.List r3 = kotlin.collections.q.m(r4)
            r7.addAll(r3)
            com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker$run$1$2 r3 = new com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker$run$1$2
            com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker r4 = r0.this$0
            r5 = 0
            r3.<init>(r4, r7, r5)
            r0.L$0 = r2
            r4 = 1
            r0.label = r4
            java.lang.Object r3 = com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.enqueueVerificationRequestWithRetry(r3, r0)
            if (r3 != r1) goto L_0x003a
            return r1
        L_0x02aa:
            r2 = r3
            com.withpersona.sdk2.inquiry.network.NetworkCallResult r2 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult) r2
            com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker r3 = r0.this$0
            boolean r4 = r2 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success
            if (r4 == 0) goto L_0x02f8
            r4 = r2
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Success r4 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult.Success) r4
            r4.getResponse()
            ui.a r4 = r3.f27421j
            boolean r4 = r4.a()
            if (r4 != 0) goto L_0x02e8
            java.util.List r3 = r3.f27416e
            java.util.Iterator r3 = r3.iterator()
        L_0x02cb:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x02e8
            java.lang.Object r4 = r3.next()
            com.withpersona.sdk2.inquiry.selfie.Selfie r4 = (com.withpersona.sdk2.inquiry.selfie.Selfie) r4
            boolean r6 = r4 instanceof com.withpersona.sdk2.inquiry.selfie.Selfie.SelfieImage
            if (r6 == 0) goto L_0x02cb
            java.io.File r6 = new java.io.File
            java.lang.String r4 = r4.a()
            r6.<init>(r4)
            r6.delete()
            goto L_0x02cb
        L_0x02e8:
            com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker$b$b r3 = com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker.b.C0330b.f27429a
            r0.L$0 = r5
            r0.L$1 = r2
            r4 = 2
            r0.label = r4
            java.lang.Object r3 = r5.c(r3, r0)
            if (r3 != r1) goto L_0x02f8
            return r1
        L_0x02f8:
            boolean r3 = r2 instanceof com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure
            if (r3 == 0) goto L_0x0317
            r3 = r2
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Failure r3 = (com.withpersona.sdk2.inquiry.network.NetworkCallResult.Failure) r3
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r3 = r3.getNetworkErrorInfo()
            com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker$b$a r4 = new com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker$b$a
            r4.<init>(r3)
            r0.L$0 = r2
            r2 = 0
            r0.L$1 = r2
            r2 = 3
            r0.label = r2
            java.lang.Object r2 = r5.c(r4, r0)
            if (r2 != r1) goto L_0x0317
            return r1
        L_0x0317:
            kotlin.Unit r1 = kotlin.Unit.f32013a
            return r1
        L_0x031a:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.selfie.network.SubmitVerificationWorker$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

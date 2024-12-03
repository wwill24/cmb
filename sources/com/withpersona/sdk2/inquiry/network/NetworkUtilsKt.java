package com.withpersona.sdk2.inquiry.network;

import com.withpersona.sdk2.inquiry.network.ErrorResponse;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import com.withpersona.sdk2.inquiry.network.NetworkCallResult;
import java.net.SocketTimeoutException;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import retrofit2.r;

public final class NetworkUtilsKt {
    private static final int NUM_RETRIES = 3;

    public static final <T> Object enqueueRetriableRequestWithRetry(Function1<? super c<? super r<T>>, ? extends Object> function1, c<? super NetworkCallResult<T>> cVar) {
        return enqueueWithRetryWhen(function1, NetworkUtilsKt$enqueueRetriableRequestWithRetry$2.INSTANCE, cVar);
    }

    public static final <T> Object enqueueVerificationRequestWithRetry(Function1<? super c<? super r<T>>, ? extends Object> function1, c<? super NetworkCallResult<T>> cVar) {
        return enqueueWithRetryWhen(function1, NetworkUtilsKt$enqueueVerificationRequestWithRetry$2.INSTANCE, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object enqueueWithRetryWhen(kotlin.jvm.functions.Function1<? super kotlin.coroutines.c<? super retrofit2.r<T>>, ? extends java.lang.Object> r6, kotlin.jvm.functions.Function1<? super com.withpersona.sdk2.inquiry.network.InternalErrorInfo.NetworkErrorInfo, java.lang.Boolean> r7, kotlin.coroutines.c<? super com.withpersona.sdk2.inquiry.network.NetworkCallResult<T>> r8) {
        /*
            boolean r0 = r8 instanceof com.withpersona.sdk2.inquiry.network.NetworkUtilsKt$enqueueWithRetryWhen$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.withpersona.sdk2.inquiry.network.NetworkUtilsKt$enqueueWithRetryWhen$1 r0 = (com.withpersona.sdk2.inquiry.network.NetworkUtilsKt$enqueueWithRetryWhen$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.inquiry.network.NetworkUtilsKt$enqueueWithRetryWhen$1 r0 = new com.withpersona.sdk2.inquiry.network.NetworkUtilsKt$enqueueWithRetryWhen$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r2 = r0.L$0
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            gk.g.b(r8)
            r5 = r0
            r0 = r7
            r7 = r2
            r2 = r1
            r1 = r5
            goto L_0x0061
        L_0x0038:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0040:
            gk.g.b(r8)
            r8 = 0
            r2 = 0
            r5 = r7
            r7 = r6
            r6 = r2
            r2 = r1
            r1 = r0
        L_0x004a:
            r0 = r8
            r8 = r5
            r4 = 3
            if (r6 >= r4) goto L_0x0088
            r1.L$0 = r7
            r1.L$1 = r8
            r1.I$0 = r6
            r1.label = r3
            java.lang.Object r0 = r7.invoke(r1)
            if (r0 != r2) goto L_0x005e
            return r2
        L_0x005e:
            r5 = r0
            r0 = r8
            r8 = r5
        L_0x0061:
            retrofit2.r r8 = (retrofit2.r) r8
            boolean r4 = r8.g()
            if (r4 == 0) goto L_0x0073
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Success r6 = new com.withpersona.sdk2.inquiry.network.NetworkCallResult$Success
            java.lang.Object r7 = r8.a()
            r6.<init>(r7)
            return r6
        L_0x0073:
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r8 = toErrorInfo(r8)
            java.lang.Object r4 = r0.invoke(r8)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x0085
            r0 = r8
            goto L_0x0088
        L_0x0085:
            int r6 = r6 + r3
            r5 = r0
            goto L_0x004a
        L_0x0088:
            com.withpersona.sdk2.inquiry.network.NetworkCallResult$Failure r6 = new com.withpersona.sdk2.inquiry.network.NetworkCallResult$Failure
            if (r0 == 0) goto L_0x0090
            r6.<init>(r0)
            return r6
        L_0x0090:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Required value was null."
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.enqueueWithRetryWhen(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.c):java.lang.Object");
    }

    public static final <T> NetworkCallResult<T> onFailure(NetworkCallResult<T> networkCallResult, Function1<? super InternalErrorInfo.NetworkErrorInfo, Unit> function1) {
        j.g(networkCallResult, "<this>");
        j.g(function1, "action");
        if (networkCallResult instanceof NetworkCallResult.Failure) {
            function1.invoke(((NetworkCallResult.Failure) networkCallResult).getNetworkErrorInfo());
        }
        return networkCallResult;
    }

    public static final <T> NetworkCallResult<T> onSuccess(NetworkCallResult<T> networkCallResult, Function1<? super T, Unit> function1) {
        j.g(networkCallResult, "<this>");
        j.g(function1, "action");
        if (networkCallResult instanceof NetworkCallResult.Success) {
            function1.invoke(((NetworkCallResult.Success) networkCallResult).getResponse());
        }
        return networkCallResult;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0190, code lost:
        if (r5 == false) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x01c7, code lost:
        if (r4 != false) goto L_0x0032;
     */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0136  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.withpersona.sdk2.inquiry.network.InternalErrorInfo.NetworkErrorInfo toErrorInfo(retrofit2.r<?> r8) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.j.g(r8, r0)
            java.lang.String r0 = r8.h()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0016
            boolean r0 = kotlin.text.r.w(r0)
            if (r0 == 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r0 = r2
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            r3 = 0
            if (r0 != 0) goto L_0x001f
            java.lang.String r0 = r8.h()
            goto L_0x0020
        L_0x001f:
            r0 = r3
        L_0x0020:
            int r4 = r8.b()
            r5 = 401(0x191, float:5.62E-43)
            if (r4 != r5) goto L_0x002a
        L_0x0028:
            r5 = r1
            goto L_0x0030
        L_0x002a:
            r5 = 404(0x194, float:5.66E-43)
            if (r4 != r5) goto L_0x002f
            goto L_0x0028
        L_0x002f:
            r5 = r2
        L_0x0030:
            if (r5 == 0) goto L_0x0035
        L_0x0032:
            r1 = r2
            goto L_0x01cb
        L_0x0035:
            com.withpersona.sdk2.inquiry.network.HttpStatusCode r5 = com.withpersona.sdk2.inquiry.network.HttpStatusCode.INSTANCE
            kotlin.ranges.IntRange r6 = r5.getCLIENT_ERRORS()
            int r7 = r6.b()
            int r6 = r6.d()
            if (r4 > r6) goto L_0x0049
            if (r7 > r4) goto L_0x0049
            r6 = r1
            goto L_0x004a
        L_0x0049:
            r6 = r2
        L_0x004a:
            if (r6 == 0) goto L_0x01b4
            okhttp3.b0 r4 = r8.e()     // Catch:{ Exception -> 0x0080 }
            if (r4 == 0) goto L_0x008b
            okio.BufferedSource r4 = r4.source()     // Catch:{ Exception -> 0x0080 }
            if (r4 == 0) goto L_0x008b
            com.squareup.moshi.s$b r5 = new com.squareup.moshi.s$b     // Catch:{ Exception -> 0x0080 }
            r5.<init>()     // Catch:{ Exception -> 0x0080 }
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Companion r6 = com.withpersona.sdk2.inquiry.network.ErrorResponse.Companion     // Catch:{ Exception -> 0x0080 }
            com.squareup.moshi.h$e r6 = r6.getAdapter()     // Catch:{ Exception -> 0x0080 }
            com.squareup.moshi.s$b r5 = r5.a(r6)     // Catch:{ Exception -> 0x0080 }
            com.squareup.moshi.s r5 = r5.d()     // Catch:{ Exception -> 0x0080 }
            java.lang.Class<com.withpersona.sdk2.inquiry.network.ErrorResponse> r6 = com.withpersona.sdk2.inquiry.network.ErrorResponse.class
            com.squareup.moshi.h r5 = r5.c(r6)     // Catch:{ Exception -> 0x0080 }
            okio.Buffer r4 = r4.d()     // Catch:{ Exception -> 0x0080 }
            okio.Buffer r4 = r4.clone()     // Catch:{ Exception -> 0x0080 }
            java.lang.Object r4 = r5.fromJson((okio.BufferedSource) r4)     // Catch:{ Exception -> 0x0080 }
            com.withpersona.sdk2.inquiry.network.ErrorResponse r4 = (com.withpersona.sdk2.inquiry.network.ErrorResponse) r4     // Catch:{ Exception -> 0x0080 }
            goto L_0x008c
        L_0x0080:
            r4 = move-exception
            boolean r5 = r4 instanceof com.squareup.moshi.JsonDataException
            if (r5 == 0) goto L_0x0087
            r5 = r1
            goto L_0x0089
        L_0x0087:
            boolean r5 = r4 instanceof java.io.IOException
        L_0x0089:
            if (r5 == 0) goto L_0x01b3
        L_0x008b:
            r4 = r3
        L_0x008c:
            if (r4 == 0) goto L_0x00aa
            java.util.List r5 = r4.getErrors()
            if (r5 == 0) goto L_0x00aa
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.P(r5)
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Error r5 = (com.withpersona.sdk2.inquiry.network.ErrorResponse.Error) r5
            if (r5 == 0) goto L_0x00aa
            java.lang.String r6 = r5.getDescription()
            if (r6 != 0) goto L_0x00a6
            java.lang.String r6 = r5.getTitle()
        L_0x00a6:
            if (r6 != 0) goto L_0x00a9
            goto L_0x00aa
        L_0x00a9:
            r0 = r6
        L_0x00aa:
            if (r4 == 0) goto L_0x00d4
            java.util.List r5 = r4.getErrors()
            if (r5 == 0) goto L_0x00cf
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L_0x00b9
            goto L_0x00cf
        L_0x00b9:
            java.util.Iterator r5 = r5.iterator()
        L_0x00bd:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00cf
            java.lang.Object r6 = r5.next()
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Error r6 = (com.withpersona.sdk2.inquiry.network.ErrorResponse.Error) r6
            boolean r6 = r6 instanceof com.withpersona.sdk2.inquiry.network.ErrorResponse.Error.InactiveTemplateError
            if (r6 == 0) goto L_0x00bd
            r5 = r1
            goto L_0x00d0
        L_0x00cf:
            r5 = r2
        L_0x00d0:
            if (r5 != r1) goto L_0x00d4
            r5 = r1
            goto L_0x00d5
        L_0x00d4:
            r5 = r2
        L_0x00d5:
            if (r5 == 0) goto L_0x00da
        L_0x00d7:
            r1 = r2
            goto L_0x0194
        L_0x00da:
            if (r4 == 0) goto L_0x0104
            java.util.List r5 = r4.getErrors()
            if (r5 == 0) goto L_0x00ff
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L_0x00e9
            goto L_0x00ff
        L_0x00e9:
            java.util.Iterator r5 = r5.iterator()
        L_0x00ed:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00ff
            java.lang.Object r6 = r5.next()
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Error r6 = (com.withpersona.sdk2.inquiry.network.ErrorResponse.Error) r6
            boolean r6 = r6 instanceof com.withpersona.sdk2.inquiry.network.ErrorResponse.Error.InvalidConfigError
            if (r6 == 0) goto L_0x00ed
            r5 = r1
            goto L_0x0100
        L_0x00ff:
            r5 = r2
        L_0x0100:
            if (r5 != r1) goto L_0x0104
            r5 = r1
            goto L_0x0105
        L_0x0104:
            r5 = r2
        L_0x0105:
            if (r5 == 0) goto L_0x0108
            goto L_0x00d7
        L_0x0108:
            if (r4 == 0) goto L_0x0132
            java.util.List r5 = r4.getErrors()
            if (r5 == 0) goto L_0x012d
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L_0x0117
            goto L_0x012d
        L_0x0117:
            java.util.Iterator r5 = r5.iterator()
        L_0x011b:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x012d
            java.lang.Object r6 = r5.next()
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Error r6 = (com.withpersona.sdk2.inquiry.network.ErrorResponse.Error) r6
            boolean r6 = r6 instanceof com.withpersona.sdk2.inquiry.network.ErrorResponse.Error.UnauthenticatedError
            if (r6 == 0) goto L_0x011b
            r5 = r1
            goto L_0x012e
        L_0x012d:
            r5 = r2
        L_0x012e:
            if (r5 != r1) goto L_0x0132
            r5 = r1
            goto L_0x0133
        L_0x0132:
            r5 = r2
        L_0x0133:
            if (r5 == 0) goto L_0x0136
            goto L_0x00d7
        L_0x0136:
            if (r4 == 0) goto L_0x0160
            java.util.List r5 = r4.getErrors()
            if (r5 == 0) goto L_0x015b
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L_0x0145
            goto L_0x015b
        L_0x0145:
            java.util.Iterator r5 = r5.iterator()
        L_0x0149:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x015b
            java.lang.Object r6 = r5.next()
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Error r6 = (com.withpersona.sdk2.inquiry.network.ErrorResponse.Error) r6
            boolean r6 = r6 instanceof com.withpersona.sdk2.inquiry.network.ErrorResponse.Error.InconsistentTransitionError
            if (r6 == 0) goto L_0x0149
            r5 = r1
            goto L_0x015c
        L_0x015b:
            r5 = r2
        L_0x015c:
            if (r5 != r1) goto L_0x0160
            r5 = r1
            goto L_0x0161
        L_0x0160:
            r5 = r2
        L_0x0161:
            if (r5 == 0) goto L_0x0165
            goto L_0x00d7
        L_0x0165:
            if (r4 == 0) goto L_0x018f
            java.util.List r5 = r4.getErrors()
            if (r5 == 0) goto L_0x018a
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L_0x0174
            goto L_0x018a
        L_0x0174:
            java.util.Iterator r5 = r5.iterator()
        L_0x0178:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x018a
            java.lang.Object r6 = r5.next()
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Error r6 = (com.withpersona.sdk2.inquiry.network.ErrorResponse.Error) r6
            boolean r6 = r6 instanceof com.withpersona.sdk2.inquiry.network.ErrorResponse.Error.FieldNotFoundError
            if (r6 == 0) goto L_0x0178
            r5 = r1
            goto L_0x018b
        L_0x018a:
            r5 = r2
        L_0x018b:
            if (r5 != r1) goto L_0x018f
            r5 = r1
            goto L_0x0190
        L_0x018f:
            r5 = r2
        L_0x0190:
            if (r5 == 0) goto L_0x0194
            goto L_0x00d7
        L_0x0194:
            if (r4 == 0) goto L_0x01a3
            java.util.List r2 = r4.getErrors()
            if (r2 == 0) goto L_0x01a3
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.P(r2)
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Error r2 = (com.withpersona.sdk2.inquiry.network.ErrorResponse.Error) r2
            r3 = r2
        L_0x01a3:
            boolean r2 = r3 instanceof com.withpersona.sdk2.inquiry.network.ErrorResponse.Error.UnknownError
            if (r2 == 0) goto L_0x01cb
            r2 = r3
            com.withpersona.sdk2.inquiry.network.ErrorResponse$Error$UnknownError r2 = (com.withpersona.sdk2.inquiry.network.ErrorResponse.Error.UnknownError) r2
            okhttp3.b0 r4 = r8.e()
            r2.setErrorBody(r4)
            goto L_0x01cb
        L_0x01b3:
            throw r4
        L_0x01b4:
            kotlin.ranges.IntRange r5 = r5.getSERVER_ERRORS()
            int r6 = r5.b()
            int r5 = r5.d()
            if (r4 > r5) goto L_0x01c6
            if (r6 > r4) goto L_0x01c6
            r4 = r1
            goto L_0x01c7
        L_0x01c6:
            r4 = r2
        L_0x01c7:
            if (r4 == 0) goto L_0x01cb
            goto L_0x0032
        L_0x01cb:
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r2 = new com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo
            int r8 = r8.b()
            r2.<init>(r8, r0, r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.toErrorInfo(retrofit2.r):com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo");
    }

    public static final InternalErrorInfo.NetworkErrorInfo toSocketTimeoutErrorInfo(SocketTimeoutException socketTimeoutException) {
        j.g(socketTimeoutException, "<this>");
        return new InternalErrorInfo.NetworkErrorInfo(0, socketTimeoutException.getLocalizedMessage(), true, (ErrorResponse.Error) null, 8, (DefaultConstructorMarker) null);
    }
}

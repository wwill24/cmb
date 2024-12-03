package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.qualityvalidation.Excuse;
import com.facebook.internal.qualityvalidation.ExcusesForDesignViolations;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 G2\u00020\u0001:\u0003HGIB\u0001\b\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001b\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\b\u0010<\u001a\u0004\u0018\u00010.\u0012\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010@B#\b\u0017\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\u000e\u00100\u001a\n\u0018\u00010Aj\u0004\u0018\u0001`B¢\u0006\u0004\b?\u0010CB%\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b?\u0010DB\u0011\b\u0012\u0012\u0006\u0010E\u001a\u00020\u0004¢\u0006\u0004\b?\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010 \u001a\u0004\u0018\u00010\u001b8\u0006¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001fR\u0019\u0010#\u001a\u0004\u0018\u00010\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010(\u001a\u0004\u0018\u00010'8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010,\u001a\u0004\u0018\u00010\u00028F¢\u0006\f\n\u0004\b,\u0010\u0014\u001a\u0004\b-\u0010\u0016R(\u00100\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010.8\u0006@BX\u000e¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0017\u00105\u001a\u0002048\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0019\u00109\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b9\u0010\u0014\u001a\u0004\b:\u0010\u0016¨\u0006J"}, d2 = {"Lcom/facebook/FacebookRequestError;", "Landroid/os/Parcelable;", "", "toString", "Landroid/os/Parcel;", "out", "", "flags", "", "writeToParcel", "describeContents", "requestStatusCode", "I", "getRequestStatusCode", "()I", "errorCode", "getErrorCode", "subErrorCode", "getSubErrorCode", "errorType", "Ljava/lang/String;", "getErrorType", "()Ljava/lang/String;", "errorUserTitle", "getErrorUserTitle", "errorUserMessage", "getErrorUserMessage", "Lorg/json/b;", "requestResultBody", "Lorg/json/b;", "getRequestResultBody", "()Lorg/json/b;", "requestResult", "getRequestResult", "", "batchRequestResult", "Ljava/lang/Object;", "getBatchRequestResult", "()Ljava/lang/Object;", "Ljava/net/HttpURLConnection;", "connection", "Ljava/net/HttpURLConnection;", "getConnection", "()Ljava/net/HttpURLConnection;", "errorMessage", "getErrorMessage", "Lcom/facebook/FacebookException;", "<set-?>", "exception", "Lcom/facebook/FacebookException;", "getException", "()Lcom/facebook/FacebookException;", "Lcom/facebook/FacebookRequestError$Category;", "category", "Lcom/facebook/FacebookRequestError$Category;", "getCategory", "()Lcom/facebook/FacebookRequestError$Category;", "errorRecoveryMessage", "getErrorRecoveryMessage", "errorMessageField", "exceptionField", "", "errorIsTransient", "<init>", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/b;Lorg/json/b;Ljava/lang/Object;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookException;Z)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/net/HttpURLConnection;Ljava/lang/Exception;)V", "(ILjava/lang/String;Ljava/lang/String;)V", "parcel", "(Landroid/os/Parcel;)V", "Companion", "Category", "Range", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
@ExcusesForDesignViolations({@Excuse(reason = "Legacy migration", type = "KOTLIN_JVM_FIELD")})
public final class FacebookRequestError implements Parcelable {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    public static final Parcelable.Creator<FacebookRequestError> CREATOR = new FacebookRequestError$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String ERROR_CODE_FIELD_KEY = "code";
    private static final String ERROR_CODE_KEY = "error_code";
    private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
    private static final String ERROR_KEY = "error";
    private static final String ERROR_MESSAGE_FIELD_KEY = "message";
    private static final String ERROR_MSG_KEY = "error_msg";
    private static final String ERROR_REASON_KEY = "error_reason";
    private static final String ERROR_SUB_CODE_KEY = "error_subcode";
    private static final String ERROR_TYPE_FIELD_KEY = "type";
    private static final String ERROR_USER_MSG_KEY = "error_user_msg";
    private static final String ERROR_USER_TITLE_KEY = "error_user_title";
    /* access modifiers changed from: private */
    public static final Range HTTP_RANGE_SUCCESS = new Range(200, 299);
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    private final Object batchRequestResult;
    private final Category category;
    private final HttpURLConnection connection;
    private final int errorCode;
    private final String errorMessage;
    private final String errorRecoveryMessage;
    private final String errorType;
    private final String errorUserMessage;
    private final String errorUserTitle;
    private FacebookException exception;
    private final b requestResult;
    private final b requestResultBody;
    private final int requestStatusCode;
    private final int subErrorCode;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/FacebookRequestError$Category;", "", "(Ljava/lang/String;I)V", "LOGIN_RECOVERABLE", "OTHER", "TRANSIENT", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    @Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b(\u0010)J&\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007R\u001a\u0010\n\u001a\u00020\t8\u0000X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00168\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0014\u0010\u001d\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0014\u0010\u001e\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u0014\u0010\u001f\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014R\u0014\u0010 \u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b \u0010\u0014R\u0014\u0010!\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b!\u0010\u0014R\u0014\u0010\"\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b\"\u0010\u0014R\u0014\u0010#\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b#\u0010\u0014R\u0014\u0010%\u001a\u00020$8\u0006XT¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020$8\u0006XT¢\u0006\u0006\n\u0004\b'\u0010&¨\u0006*"}, d2 = {"Lcom/facebook/FacebookRequestError$Companion;", "", "Lorg/json/b;", "singleResult", "batchResult", "Ljava/net/HttpURLConnection;", "connection", "Lcom/facebook/FacebookRequestError;", "checkResponseAndCreateError", "Lcom/facebook/FacebookRequestError$Range;", "HTTP_RANGE_SUCCESS", "Lcom/facebook/FacebookRequestError$Range;", "getHTTP_RANGE_SUCCESS$facebook_core_release", "()Lcom/facebook/FacebookRequestError$Range;", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "getErrorClassification", "()Lcom/facebook/internal/FacebookRequestErrorClassification;", "errorClassification", "", "BODY_KEY", "Ljava/lang/String;", "CODE_KEY", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "ERROR_CODE_FIELD_KEY", "ERROR_CODE_KEY", "ERROR_IS_TRANSIENT_KEY", "ERROR_KEY", "ERROR_MESSAGE_FIELD_KEY", "ERROR_MSG_KEY", "ERROR_REASON_KEY", "ERROR_SUB_CODE_KEY", "ERROR_TYPE_FIELD_KEY", "ERROR_USER_MSG_KEY", "ERROR_USER_TITLE_KEY", "", "INVALID_ERROR_CODE", "I", "INVALID_HTTP_STATUS_CODE", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:50:0x00cf A[Catch:{ JSONException -> 0x012d }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.facebook.FacebookRequestError checkResponseAndCreateError(org.json.b r20, java.lang.Object r21, java.net.HttpURLConnection r22) {
            /*
                r19 = this;
                r9 = r20
                java.lang.String r0 = "error_code"
                java.lang.String r1 = "error"
                java.lang.String r2 = "FACEBOOK_NON_JSON_RESULT"
                java.lang.String r3 = "body"
                java.lang.String r4 = "code"
                java.lang.String r5 = "singleResult"
                kotlin.jvm.internal.j.g(r9, r5)
                r15 = 0
                boolean r5 = r9.has(r4)     // Catch:{ JSONException -> 0x012d }
                if (r5 == 0) goto L_0x012d
                int r5 = r9.getInt(r4)     // Catch:{ JSONException -> 0x012d }
                java.lang.Object r6 = com.facebook.internal.Utility.getStringPropertyAsJSON(r9, r3, r2)     // Catch:{ JSONException -> 0x012d }
                if (r6 == 0) goto L_0x00f0
                boolean r7 = r6 instanceof org.json.b     // Catch:{ JSONException -> 0x012d }
                if (r7 == 0) goto L_0x00f0
                r7 = r6
                org.json.b r7 = (org.json.b) r7     // Catch:{ JSONException -> 0x012d }
                boolean r7 = r7.has(r1)     // Catch:{ JSONException -> 0x012d }
                r8 = 1
                java.lang.String r10 = "error_subcode"
                r11 = 0
                r12 = -1
                if (r7 == 0) goto L_0x0083
                r0 = r6
                org.json.b r0 = (org.json.b) r0     // Catch:{ JSONException -> 0x012d }
                java.lang.Object r0 = com.facebook.internal.Utility.getStringPropertyAsJSON(r0, r1, r15)     // Catch:{ JSONException -> 0x012d }
                org.json.b r0 = (org.json.b) r0     // Catch:{ JSONException -> 0x012d }
                if (r0 != 0) goto L_0x0041
                r1 = r15
                goto L_0x0047
            L_0x0041:
                java.lang.String r1 = "type"
                java.lang.String r1 = r0.optString(r1, r15)     // Catch:{ JSONException -> 0x012d }
            L_0x0047:
                if (r0 != 0) goto L_0x004b
                r7 = r15
                goto L_0x0051
            L_0x004b:
                java.lang.String r7 = "message"
                java.lang.String r7 = r0.optString(r7, r15)     // Catch:{ JSONException -> 0x012d }
            L_0x0051:
                if (r0 != 0) goto L_0x0055
                r4 = r12
                goto L_0x0059
            L_0x0055:
                int r4 = r0.optInt(r4, r12)     // Catch:{ JSONException -> 0x012d }
            L_0x0059:
                if (r0 != 0) goto L_0x005c
                goto L_0x0060
            L_0x005c:
                int r12 = r0.optInt(r10, r12)     // Catch:{ JSONException -> 0x012d }
            L_0x0060:
                if (r0 != 0) goto L_0x0064
                r10 = r15
                goto L_0x006a
            L_0x0064:
                java.lang.String r10 = "error_user_msg"
                java.lang.String r10 = r0.optString(r10, r15)     // Catch:{ JSONException -> 0x012d }
            L_0x006a:
                if (r0 != 0) goto L_0x006e
                r13 = r15
                goto L_0x0074
            L_0x006e:
                java.lang.String r13 = "error_user_title"
                java.lang.String r13 = r0.optString(r13, r15)     // Catch:{ JSONException -> 0x012d }
            L_0x0074:
                if (r0 != 0) goto L_0x0077
                goto L_0x007d
            L_0x0077:
                java.lang.String r14 = "is_transient"
                boolean r11 = r0.optBoolean(r14, r11)     // Catch:{ JSONException -> 0x012d }
            L_0x007d:
                r14 = r11
                r11 = r8
                r8 = r7
                r7 = r12
                r12 = r4
                goto L_0x00cc
            L_0x0083:
                r1 = r6
                org.json.b r1 = (org.json.b) r1     // Catch:{ JSONException -> 0x012d }
                boolean r1 = r1.has(r0)     // Catch:{ JSONException -> 0x012d }
                java.lang.String r4 = "error_msg"
                java.lang.String r7 = "error_reason"
                if (r1 != 0) goto L_0x00aa
                r1 = r6
                org.json.b r1 = (org.json.b) r1     // Catch:{ JSONException -> 0x012d }
                boolean r1 = r1.has(r4)     // Catch:{ JSONException -> 0x012d }
                if (r1 != 0) goto L_0x00aa
                r1 = r6
                org.json.b r1 = (org.json.b) r1     // Catch:{ JSONException -> 0x012d }
                boolean r1 = r1.has(r7)     // Catch:{ JSONException -> 0x012d }
                if (r1 == 0) goto L_0x00a3
                goto L_0x00aa
            L_0x00a3:
                r14 = r11
                r7 = r12
                r4 = r15
                r8 = r4
                r10 = r8
                r13 = r10
                goto L_0x00cd
            L_0x00aa:
                r1 = r6
                org.json.b r1 = (org.json.b) r1     // Catch:{ JSONException -> 0x012d }
                java.lang.String r1 = r1.optString(r7, r15)     // Catch:{ JSONException -> 0x012d }
                r7 = r6
                org.json.b r7 = (org.json.b) r7     // Catch:{ JSONException -> 0x012d }
                java.lang.String r4 = r7.optString(r4, r15)     // Catch:{ JSONException -> 0x012d }
                r7 = r6
                org.json.b r7 = (org.json.b) r7     // Catch:{ JSONException -> 0x012d }
                int r0 = r7.optInt(r0, r12)     // Catch:{ JSONException -> 0x012d }
                r7 = r6
                org.json.b r7 = (org.json.b) r7     // Catch:{ JSONException -> 0x012d }
                int r7 = r7.optInt(r10, r12)     // Catch:{ JSONException -> 0x012d }
                r12 = r0
                r14 = r11
                r10 = r15
                r13 = r10
                r11 = r8
                r8 = r4
            L_0x00cc:
                r4 = r1
            L_0x00cd:
                if (r11 == 0) goto L_0x00f0
                com.facebook.FacebookRequestError r16 = new com.facebook.FacebookRequestError     // Catch:{ JSONException -> 0x012d }
                r11 = r6
                org.json.b r11 = (org.json.b) r11     // Catch:{ JSONException -> 0x012d }
                r17 = 0
                r18 = 0
                r0 = r16
                r1 = r5
                r2 = r12
                r3 = r7
                r5 = r8
                r6 = r13
                r7 = r10
                r8 = r11
                r9 = r20
                r10 = r21
                r11 = r22
                r12 = r17
                r13 = r14
                r14 = r18
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x012d }
                return r16
            L_0x00f0:
                com.facebook.FacebookRequestError$Range r0 = r19.getHTTP_RANGE_SUCCESS$facebook_core_release()     // Catch:{ JSONException -> 0x012d }
                boolean r0 = r0.contains(r5)     // Catch:{ JSONException -> 0x012d }
                if (r0 != 0) goto L_0x012d
                com.facebook.FacebookRequestError r16 = new com.facebook.FacebookRequestError     // Catch:{ JSONException -> 0x012d }
                r4 = -1
                r6 = -1
                r7 = 0
                r8 = 0
                r10 = 0
                r11 = 0
                boolean r0 = r9.has(r3)     // Catch:{ JSONException -> 0x012d }
                if (r0 == 0) goto L_0x0110
                java.lang.Object r0 = com.facebook.internal.Utility.getStringPropertyAsJSON(r9, r3, r2)     // Catch:{ JSONException -> 0x012d }
                org.json.b r0 = (org.json.b) r0     // Catch:{ JSONException -> 0x012d }
                r12 = r0
                goto L_0x0111
            L_0x0110:
                r12 = r15
            L_0x0111:
                r13 = 0
                r14 = 0
                r17 = 0
                r0 = r16
                r1 = r5
                r2 = r4
                r3 = r6
                r4 = r7
                r5 = r8
                r6 = r10
                r7 = r11
                r8 = r12
                r9 = r20
                r10 = r21
                r11 = r22
                r12 = r13
                r13 = r14
                r14 = r17
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ JSONException -> 0x012d }
                return r16
            L_0x012d:
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookRequestError.Companion.checkResponseAndCreateError(org.json.b, java.lang.Object, java.net.HttpURLConnection):com.facebook.FacebookRequestError");
        }

        public final synchronized FacebookRequestErrorClassification getErrorClassification() {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null) {
                return FacebookRequestErrorClassification.Companion.getDefaultErrorClassification();
            }
            return appSettingsWithoutQuery.getErrorClassification();
        }

        public final Range getHTTP_RANGE_SUCCESS$facebook_core_release() {
            return FacebookRequestError.HTTP_RANGE_SUCCESS;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/FacebookRequestError$Range;", "", "start", "", "end", "(II)V", "contains", "", "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Range {
        private final int end;
        private final int start;

        public Range(int i10, int i11) {
            this.start = i10;
            this.end = i11;
        }

        public final boolean contains(int i10) {
            return i10 <= this.end && this.start <= i10;
        }
    }

    private FacebookRequestError(int i10, int i11, int i12, String str, String str2, String str3, String str4, b bVar, b bVar2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException, boolean z10) {
        boolean z11;
        Category category2;
        this.requestStatusCode = i10;
        this.errorCode = i11;
        this.subErrorCode = i12;
        this.errorType = str;
        this.errorUserTitle = str3;
        this.errorUserMessage = str4;
        this.requestResultBody = bVar;
        this.requestResult = bVar2;
        this.batchRequestResult = obj;
        this.connection = httpURLConnection;
        this.errorMessage = str2;
        if (facebookException != null) {
            this.exception = facebookException;
            z11 = true;
        } else {
            this.exception = new FacebookServiceException(this, getErrorMessage());
            z11 = false;
        }
        if (z11) {
            category2 = Category.OTHER;
        } else {
            category2 = Companion.getErrorClassification().classify(i11, i12, z10);
        }
        this.category = category2;
        this.errorRecoveryMessage = Companion.getErrorClassification().getRecoveryMessage(category2);
    }

    public /* synthetic */ FacebookRequestError(int i10, int i11, int i12, String str, String str2, String str3, String str4, b bVar, b bVar2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException, boolean z10, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, i11, i12, str, str2, str3, str4, bVar, bVar2, obj, httpURLConnection, facebookException, z10);
    }

    public /* synthetic */ FacebookRequestError(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    public static final FacebookRequestError checkResponseAndCreateError(b bVar, Object obj, HttpURLConnection httpURLConnection) {
        return Companion.checkResponseAndCreateError(bVar, obj, httpURLConnection);
    }

    public static final synchronized FacebookRequestErrorClassification getErrorClassification() {
        FacebookRequestErrorClassification errorClassification;
        synchronized (FacebookRequestError.class) {
            errorClassification = Companion.getErrorClassification();
        }
        return errorClassification;
    }

    public int describeContents() {
        return 0;
    }

    public final Object getBatchRequestResult() {
        return this.batchRequestResult;
    }

    public final Category getCategory() {
        return this.category;
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        String str = this.errorMessage;
        if (str != null) {
            return str;
        }
        FacebookException facebookException = this.exception;
        if (facebookException == null) {
            return null;
        }
        return facebookException.getLocalizedMessage();
    }

    public final String getErrorRecoveryMessage() {
        return this.errorRecoveryMessage;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final String getErrorUserMessage() {
        return this.errorUserMessage;
    }

    public final String getErrorUserTitle() {
        return this.errorUserTitle;
    }

    public final FacebookException getException() {
        return this.exception;
    }

    public final b getRequestResult() {
        return this.requestResult;
    }

    public final b getRequestResultBody() {
        return this.requestResultBody;
    }

    public final int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public final int getSubErrorCode() {
        return this.subErrorCode;
    }

    public String toString() {
        String str = "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", subErrorCode: " + this.subErrorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + "}";
        j.f(str, "StringBuilder(\"{HttpStatus: \")\n        .append(requestStatusCode)\n        .append(\", errorCode: \")\n        .append(errorCode)\n        .append(\", subErrorCode: \")\n        .append(subErrorCode)\n        .append(\", errorType: \")\n        .append(errorType)\n        .append(\", errorMessage: \")\n        .append(errorMessage)\n        .append(\"}\")\n        .toString()");
        return str;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeInt(this.requestStatusCode);
        parcel.writeInt(this.errorCode);
        parcel.writeInt(this.subErrorCode);
        parcel.writeString(this.errorType);
        parcel.writeString(getErrorMessage());
        parcel.writeString(this.errorUserTitle);
        parcel.writeString(this.errorUserMessage);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FacebookRequestError(java.net.HttpURLConnection r17, java.lang.Exception r18) {
        /*
            r16 = this;
            r0 = r18
            boolean r1 = r0 instanceof com.facebook.FacebookException
            if (r1 == 0) goto L_0x000a
            com.facebook.FacebookException r0 = (com.facebook.FacebookException) r0
            r14 = r0
            goto L_0x0010
        L_0x000a:
            com.facebook.FacebookException r1 = new com.facebook.FacebookException
            r1.<init>((java.lang.Throwable) r0)
            r14 = r1
        L_0x0010:
            r15 = 0
            r3 = -1
            r4 = -1
            r5 = -1
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r2 = r16
            r13 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookRequestError.<init>(java.net.HttpURLConnection, java.lang.Exception):void");
    }

    public FacebookRequestError(int i10, String str, String str2) {
        this(-1, i10, -1, str, str2, (String) null, (String) null, (b) null, (b) null, (Object) null, (HttpURLConnection) null, (FacebookException) null, false);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (b) null, (b) null, (Object) null, (HttpURLConnection) null, (FacebookException) null, false);
    }
}

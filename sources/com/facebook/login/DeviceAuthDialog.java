package com.facebook.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.c;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.common.R;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import com.mparticle.kits.AppsFlyerKit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 T2\u00020\u0001:\u0003TUVB\u0007¢\u0006\u0004\bR\u0010SJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J<\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0002J)\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J4\u0010\u0016\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0002J&\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010 \u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u001bH\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0016J\u0016\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010*H\u0016J\b\u0010,\u001a\u00020\bH\u0016J\u0010\u0010/\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020-H\u0014J\u0010\u00101\u001a\u0002002\u0006\u0010.\u001a\u00020-H\u0015J\u0010\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u000202H\u0014J\b\u00105\u001a\u00020\u0004H\u0014J\b\u00106\u001a\u00020-H\u0014R\u0016\u00107\u001a\u00020\u001d8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X.¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u0002098\u0002@\u0002X.¢\u0006\u0006\n\u0004\b<\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u001c\u0010G\u001a\b\u0012\u0002\b\u0003\u0018\u00010F8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010IR\u0016\u0010J\u001a\u00020-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010L\u001a\u00020-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010KR\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010MR\u0014\u0010Q\u001a\u00020N8BX\u0004¢\u0006\u0006\u001a\u0004\bO\u0010P¨\u0006W"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog;", "Landroidx/fragment/app/c;", "Lcom/facebook/login/DeviceAuthDialog$RequestState;", "currentRequestState", "", "setCurrentRequestState", "poll", "schedulePoll", "", "userId", "Lcom/facebook/login/DeviceAuthDialog$PermissionsLists;", "permissions", "accessToken", "name", "Ljava/util/Date;", "expirationTime", "dataAccessExpirationTime", "presentConfirmation", "", "expiresIn", "onSuccess", "(Ljava/lang/String;JLjava/lang/Long;)V", "completeLogin", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "Landroid/app/Dialog;", "onCreateDialog", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "outState", "onSaveInstanceState", "onDestroyView", "Lcom/facebook/login/LoginClient$Request;", "request", "startLogin", "", "additionalDeviceInfo", "getApplicationAccessToken", "", "isSmartLogin", "initializeContentView", "", "getLayoutResId", "Lcom/facebook/FacebookException;", "ex", "onError", "onCancel", "onBackButtonPressed", "progressBar", "Landroid/view/View;", "Landroid/widget/TextView;", "confirmationCode", "Landroid/widget/TextView;", "instructions", "Lcom/facebook/login/DeviceAuthMethodHandler;", "deviceAuthMethodHandler", "Lcom/facebook/login/DeviceAuthMethodHandler;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "completed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lcom/facebook/GraphRequestAsyncTask;", "currentGraphRequestPoll", "Lcom/facebook/GraphRequestAsyncTask;", "Ljava/util/concurrent/ScheduledFuture;", "scheduledPoll", "Ljava/util/concurrent/ScheduledFuture;", "Lcom/facebook/login/DeviceAuthDialog$RequestState;", "isBeingDestroyed", "Z", "isRetry", "Lcom/facebook/login/LoginClient$Request;", "Lcom/facebook/GraphRequest;", "getPollRequest", "()Lcom/facebook/GraphRequest;", "pollRequest", "<init>", "()V", "Companion", "PermissionsLists", "RequestState", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public class DeviceAuthDialog extends c {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String DEVICE_LOGIN_ENDPOINT = "device/login";
    /* access modifiers changed from: private */
    public static final String DEVICE_LOGIN_STATUS_ENDPOINT = "device/login_status";
    private static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED = 1349173;
    /* access modifiers changed from: private */
    public static final int LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING = 1349174;
    private static final int LOGIN_ERROR_SUBCODE_CODE_EXPIRED = 1349152;
    private static final int LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING = 1349172;
    private static final String REQUEST_STATE_KEY = "request_state";
    private final AtomicBoolean completed = new AtomicBoolean();
    private TextView confirmationCode;
    private volatile GraphRequestAsyncTask currentGraphRequestPoll;
    private volatile RequestState currentRequestState;
    private DeviceAuthMethodHandler deviceAuthMethodHandler;
    private TextView instructions;
    private boolean isBeingDestroyed;
    private boolean isRetry;
    private View progressBar;
    private LoginClient.Request request;
    private volatile ScheduledFuture<?> scheduledPoll;

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R \u0010\u0007\u001a\u00020\u00068\u0000XD¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR \u0010\r\u001a\u00020\u00068\u0000XD¢\u0006\u0012\n\u0004\b\r\u0010\b\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR \u0010\u0011\u001a\u00020\u00108\u0000XD¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0015\u0010\f\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u0019\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog$Companion;", "", "Lorg/json/b;", "result", "Lcom/facebook/login/DeviceAuthDialog$PermissionsLists;", "handlePermissionResponse", "", "DEVICE_LOGIN_ENDPOINT", "Ljava/lang/String;", "getDEVICE_LOGIN_ENDPOINT$facebook_common_release", "()Ljava/lang/String;", "getDEVICE_LOGIN_ENDPOINT$facebook_common_release$annotations", "()V", "DEVICE_LOGIN_STATUS_ENDPOINT", "getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release", "getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release$annotations", "", "LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING", "I", "getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release", "()I", "getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release$annotations", "LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED", "LOGIN_ERROR_SUBCODE_CODE_EXPIRED", "LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING", "REQUEST_STATE_KEY", "<init>", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDEVICE_LOGIN_ENDPOINT$facebook_common_release$annotations() {
        }

        public static /* synthetic */ void getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release$annotations() {
        }

        public static /* synthetic */ void getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release$annotations() {
        }

        /* access modifiers changed from: private */
        public final PermissionsLists handlePermissionResponse(b bVar) throws JSONException {
            boolean z10;
            String optString;
            a jSONArray = bVar.getJSONObject("permissions").getJSONArray("data");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int o10 = jSONArray.o();
            if (o10 > 0) {
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    b s10 = jSONArray.s(i10);
                    String optString2 = s10.optString("permission");
                    j.f(optString2, "permission");
                    if (optString2.length() == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z10 && !j.b(optString2, "installed") && (optString = s10.optString("status")) != null) {
                        int hashCode = optString.hashCode();
                        if (hashCode != -1309235419) {
                            if (hashCode != 280295099) {
                                if (hashCode == 568196142 && optString.equals("declined")) {
                                    arrayList2.add(optString2);
                                }
                            } else if (optString.equals("granted")) {
                                arrayList.add(optString2);
                            }
                        } else if (optString.equals("expired")) {
                            arrayList3.add(optString2);
                        }
                    }
                    if (i11 >= o10) {
                        break;
                    }
                    i10 = i11;
                }
            }
            return new PermissionsLists(arrayList, arrayList2, arrayList3);
        }

        public final String getDEVICE_LOGIN_ENDPOINT$facebook_common_release() {
            return DeviceAuthDialog.DEVICE_LOGIN_ENDPOINT;
        }

        public final String getDEVICE_LOGIN_STATUS_ENDPOINT$facebook_common_release() {
            return DeviceAuthDialog.DEVICE_LOGIN_STATUS_ENDPOINT;
        }

        public final int getLOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING$facebook_common_release() {
            return DeviceAuthDialog.LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0007R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog$PermissionsLists;", "", "grantedPermissions", "", "", "declinedPermissions", "expiredPermissions", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDeclinedPermissions", "()Ljava/util/List;", "setDeclinedPermissions", "(Ljava/util/List;)V", "getExpiredPermissions", "setExpiredPermissions", "getGrantedPermissions", "setGrantedPermissions", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class PermissionsLists {
        private List<String> declinedPermissions;
        private List<String> expiredPermissions;
        private List<String> grantedPermissions;

        public PermissionsLists(List<String> list, List<String> list2, List<String> list3) {
            j.g(list, "grantedPermissions");
            j.g(list2, SDKConstants.PARAM_DECLINED_PERMISSIONS);
            j.g(list3, SDKConstants.PARAM_EXPIRED_PERMISSIONS);
            this.grantedPermissions = list;
            this.declinedPermissions = list2;
            this.expiredPermissions = list3;
        }

        public final List<String> getDeclinedPermissions() {
            return this.declinedPermissions;
        }

        public final List<String> getExpiredPermissions() {
            return this.expiredPermissions;
        }

        public final List<String> getGrantedPermissions() {
            return this.grantedPermissions;
        }

        public final void setDeclinedPermissions(List<String> list) {
            j.g(list, "<set-?>");
            this.declinedPermissions = list;
        }

        public final void setExpiredPermissions(List<String> list) {
            j.g(list, "<set-?>");
            this.expiredPermissions = list;
        }

        public final void setGrantedPermissions(List<String> list) {
            j.g(list, "<set-?>");
            this.grantedPermissions = list;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007\b\u0010¢\u0006\u0002\u0010\u0002B\u000f\b\u0014\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0018H\u0016R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog$RequestState;", "Landroid/os/Parcelable;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "<set-?>", "", "authorizationUri", "getAuthorizationUri", "()Ljava/lang/String;", "interval", "", "getInterval", "()J", "setInterval", "(J)V", "lastPoll", "requestCode", "getRequestCode", "setRequestCode", "(Ljava/lang/String;)V", "userCode", "describeContents", "", "getUserCode", "setLastPoll", "", "setUserCode", "withinLastRefreshWindow", "", "writeToParcel", "dest", "flags", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class RequestState implements Parcelable {
        public static final Parcelable.Creator<RequestState> CREATOR = new DeviceAuthDialog$RequestState$Companion$CREATOR$1();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private String authorizationUri;
        private long interval;
        private long lastPoll;
        private String requestCode;
        private String userCode;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog$RequestState$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/DeviceAuthDialog$RequestState;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public RequestState() {
        }

        protected RequestState(Parcel parcel) {
            j.g(parcel, "parcel");
            this.authorizationUri = parcel.readString();
            this.userCode = parcel.readString();
            this.requestCode = parcel.readString();
            this.interval = parcel.readLong();
            this.lastPoll = parcel.readLong();
        }

        public int describeContents() {
            return 0;
        }

        public final String getAuthorizationUri() {
            return this.authorizationUri;
        }

        public final long getInterval() {
            return this.interval;
        }

        public final String getRequestCode() {
            return this.requestCode;
        }

        public final String getUserCode() {
            return this.userCode;
        }

        public final void setInterval(long j10) {
            this.interval = j10;
        }

        public final void setLastPoll(long j10) {
            this.lastPoll = j10;
        }

        public final void setRequestCode(String str) {
            this.requestCode = str;
        }

        public final void setUserCode(String str) {
            this.userCode = str;
            o oVar = o.f32141a;
            String format2 = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", Arrays.copyOf(new Object[]{str}, 1));
            j.f(format2, "java.lang.String.format(locale, format, *args)");
            this.authorizationUri = format2;
        }

        public final boolean withinLastRefreshWindow() {
            if (this.lastPoll != 0 && (new Date().getTime() - this.lastPoll) - (this.interval * 1000) < 0) {
                return true;
            }
            return false;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "dest");
            parcel.writeString(this.authorizationUri);
            parcel.writeString(this.userCode);
            parcel.writeString(this.requestCode);
            parcel.writeLong(this.interval);
            parcel.writeLong(this.lastPoll);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _get_pollRequest_$lambda-5  reason: not valid java name */
    public static final void m152_get_pollRequest_$lambda5(DeviceAuthDialog deviceAuthDialog, GraphResponse graphResponse) {
        FacebookException facebookException;
        j.g(deviceAuthDialog, "this$0");
        j.g(graphResponse, "response");
        if (!deviceAuthDialog.completed.get()) {
            FacebookRequestError error = graphResponse.getError();
            if (error != null) {
                int subErrorCode = error.getSubErrorCode();
                boolean z10 = true;
                if (!(subErrorCode == LOGIN_ERROR_SUBCODE_AUTHORIZATION_PENDING || subErrorCode == LOGIN_ERROR_SUBCODE_EXCESSIVE_POLLING)) {
                    z10 = false;
                }
                if (z10) {
                    deviceAuthDialog.schedulePoll();
                } else if (subErrorCode == LOGIN_ERROR_SUBCODE_CODE_EXPIRED) {
                    RequestState requestState = deviceAuthDialog.currentRequestState;
                    if (requestState != null) {
                        DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                        DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
                    }
                    LoginClient.Request request2 = deviceAuthDialog.request;
                    if (request2 != null) {
                        deviceAuthDialog.startLogin(request2);
                    } else {
                        deviceAuthDialog.onCancel();
                    }
                } else if (subErrorCode == LOGIN_ERROR_SUBCODE_AUTHORIZATION_DECLINED) {
                    deviceAuthDialog.onCancel();
                } else {
                    FacebookRequestError error2 = graphResponse.getError();
                    if (error2 == null) {
                        facebookException = null;
                    } else {
                        facebookException = error2.getException();
                    }
                    if (facebookException == null) {
                        facebookException = new FacebookException();
                    }
                    deviceAuthDialog.onError(facebookException);
                }
            } else {
                try {
                    b jSONObject = graphResponse.getJSONObject();
                    if (jSONObject == null) {
                        jSONObject = new b();
                    }
                    String string = jSONObject.getString("access_token");
                    j.f(string, "resultObject.getString(\"access_token\")");
                    deviceAuthDialog.onSuccess(string, jSONObject.getLong(AccessToken.EXPIRES_IN_KEY), Long.valueOf(jSONObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
                } catch (JSONException e10) {
                    deviceAuthDialog.onError(new FacebookException((Throwable) e10));
                }
            }
        }
    }

    private final void completeLogin(String str, PermissionsLists permissionsLists, String str2, Date date, Date date2) {
        DeviceAuthMethodHandler deviceAuthMethodHandler2 = this.deviceAuthMethodHandler;
        if (deviceAuthMethodHandler2 != null) {
            deviceAuthMethodHandler2.onSuccess(str2, FacebookSdk.getApplicationId(), str, permissionsLists.getGrantedPermissions(), permissionsLists.getDeclinedPermissions(), permissionsLists.getExpiredPermissions(), AccessTokenSource.DEVICE_AUTH, date, (Date) null, date2);
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private final GraphRequest getPollRequest() {
        String str;
        Bundle bundle = new Bundle();
        RequestState requestState = this.currentRequestState;
        if (requestState == null) {
            str = null;
        } else {
            str = requestState.getRequestCode();
        }
        bundle.putString("code", str);
        bundle.putString("access_token", getApplicationAccessToken());
        return GraphRequest.Companion.newPostRequestWithBundle((AccessToken) null, DEVICE_LOGIN_STATUS_ENDPOINT, bundle, new f(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initializeContentView$lambda-2  reason: not valid java name */
    public static final void m153initializeContentView$lambda2(DeviceAuthDialog deviceAuthDialog, View view) {
        j.g(deviceAuthDialog, "this$0");
        deviceAuthDialog.onCancel();
    }

    private final void onSuccess(String str, long j10, Long l10) {
        Date date;
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,permissions,name");
        Date date2 = null;
        if (j10 != 0) {
            date = new Date(new Date().getTime() + (j10 * 1000));
        } else {
            date = null;
        }
        if ((l10 == null || l10.longValue() != 0) && l10 != null) {
            date2 = new Date(l10.longValue() * 1000);
        }
        GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(new AccessToken(str, FacebookSdk.getApplicationId(), "0", (Collection) null, (Collection) null, (Collection) null, (AccessTokenSource) null, date, (Date) null, date2, (String) null, 1024, (DefaultConstructorMarker) null), "me", new b(this, str, date, date2));
        newGraphPathRequest.setHttpMethod(HttpMethod.GET);
        newGraphPathRequest.setParameters(bundle);
        newGraphPathRequest.executeAsync();
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-10  reason: not valid java name */
    public static final void m154onSuccess$lambda10(DeviceAuthDialog deviceAuthDialog, String str, Date date, Date date2, GraphResponse graphResponse) {
        EnumSet<SmartLoginOption> smartLoginOptions;
        j.g(deviceAuthDialog, "this$0");
        j.g(str, "$accessToken");
        j.g(graphResponse, "response");
        if (!deviceAuthDialog.completed.get()) {
            FacebookRequestError error = graphResponse.getError();
            if (error != null) {
                FacebookException exception = error.getException();
                if (exception == null) {
                    exception = new FacebookException();
                }
                deviceAuthDialog.onError(exception);
                return;
            }
            try {
                b jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    jSONObject = new b();
                }
                String string = jSONObject.getString("id");
                j.f(string, "jsonObject.getString(\"id\")");
                PermissionsLists access$handlePermissionResponse = Companion.handlePermissionResponse(jSONObject);
                String string2 = jSONObject.getString("name");
                j.f(string2, "jsonObject.getString(\"name\")");
                RequestState requestState = deviceAuthDialog.currentRequestState;
                if (requestState != null) {
                    DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                    DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
                }
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
                Boolean bool = null;
                if (!(appSettingsWithoutQuery == null || (smartLoginOptions = appSettingsWithoutQuery.getSmartLoginOptions()) == null)) {
                    bool = Boolean.valueOf(smartLoginOptions.contains(SmartLoginOption.RequireConfirm));
                }
                if (!j.b(bool, Boolean.TRUE) || deviceAuthDialog.isRetry) {
                    deviceAuthDialog.completeLogin(string, access$handlePermissionResponse, str, date, date2);
                    return;
                }
                deviceAuthDialog.isRetry = true;
                deviceAuthDialog.presentConfirmation(string, access$handlePermissionResponse, str, string2, date, date2);
            } catch (JSONException e10) {
                deviceAuthDialog.onError(new FacebookException((Throwable) e10));
            }
        }
    }

    private final void poll() {
        RequestState requestState = this.currentRequestState;
        if (requestState != null) {
            requestState.setLastPoll(new Date().getTime());
        }
        this.currentGraphRequestPoll = getPollRequest().executeAsync();
    }

    private final void presentConfirmation(String str, PermissionsLists permissionsLists, String str2, String str3, Date date, Date date2) {
        String string = getResources().getString(R.string.com_facebook_smart_login_confirmation_title);
        j.f(string, "resources.getString(R.string.com_facebook_smart_login_confirmation_title)");
        String string2 = getResources().getString(R.string.com_facebook_smart_login_confirmation_continue_as);
        j.f(string2, "resources.getString(R.string.com_facebook_smart_login_confirmation_continue_as)");
        String string3 = getResources().getString(R.string.com_facebook_smart_login_confirmation_cancel);
        j.f(string3, "resources.getString(R.string.com_facebook_smart_login_confirmation_cancel)");
        o oVar = o.f32141a;
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{str3}, 1));
        j.f(format2, "java.lang.String.format(format, *args)");
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(string).setCancelable(true).setNegativeButton(format2, new c(this, str, permissionsLists, str2, date, date2)).setPositiveButton(string3, new d(this));
        builder.create().show();
    }

    /* access modifiers changed from: private */
    /* renamed from: presentConfirmation$lambda-6  reason: not valid java name */
    public static final void m155presentConfirmation$lambda6(DeviceAuthDialog deviceAuthDialog, String str, PermissionsLists permissionsLists, String str2, Date date, Date date2, DialogInterface dialogInterface, int i10) {
        j.g(deviceAuthDialog, "this$0");
        j.g(str, "$userId");
        j.g(permissionsLists, "$permissions");
        j.g(str2, "$accessToken");
        deviceAuthDialog.completeLogin(str, permissionsLists, str2, date, date2);
    }

    /* access modifiers changed from: private */
    /* renamed from: presentConfirmation$lambda-8  reason: not valid java name */
    public static final void m156presentConfirmation$lambda8(DeviceAuthDialog deviceAuthDialog, DialogInterface dialogInterface, int i10) {
        j.g(deviceAuthDialog, "this$0");
        View initializeContentView = deviceAuthDialog.initializeContentView(false);
        Dialog dialog = deviceAuthDialog.getDialog();
        if (dialog != null) {
            dialog.setContentView(initializeContentView);
        }
        LoginClient.Request request2 = deviceAuthDialog.request;
        if (request2 != null) {
            deviceAuthDialog.startLogin(request2);
        }
    }

    private final void schedulePoll() {
        Long l10;
        RequestState requestState = this.currentRequestState;
        if (requestState == null) {
            l10 = null;
        } else {
            l10 = Long.valueOf(requestState.getInterval());
        }
        if (l10 != null) {
            this.scheduledPoll = DeviceAuthMethodHandler.Companion.getBackgroundExecutor().schedule(new e(this), l10.longValue(), TimeUnit.SECONDS);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: schedulePoll$lambda-3  reason: not valid java name */
    public static final void m157schedulePoll$lambda3(DeviceAuthDialog deviceAuthDialog) {
        j.g(deviceAuthDialog, "this$0");
        deviceAuthDialog.poll();
    }

    private final void setCurrentRequestState(RequestState requestState) {
        this.currentRequestState = requestState;
        TextView textView = this.confirmationCode;
        if (textView != null) {
            textView.setText(requestState.getUserCode());
            DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), DeviceRequestsHelper.generateQRCode(requestState.getAuthorizationUri()));
            TextView textView2 = this.instructions;
            if (textView2 != null) {
                textView2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, bitmapDrawable, (Drawable) null, (Drawable) null);
                TextView textView3 = this.confirmationCode;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                    View view = this.progressBar;
                    if (view != null) {
                        view.setVisibility(8);
                        if (!this.isRetry && DeviceRequestsHelper.startAdvertisementService(requestState.getUserCode())) {
                            new InternalAppEventsLogger(getContext()).logEventImplicitly(AnalyticsEvents.EVENT_SMART_LOGIN_SERVICE);
                        }
                        if (requestState.withinLastRefreshWindow()) {
                            schedulePoll();
                        } else {
                            poll();
                        }
                    } else {
                        j.y("progressBar");
                        throw null;
                    }
                } else {
                    j.y("confirmationCode");
                    throw null;
                }
            } else {
                j.y("instructions");
                throw null;
            }
        } else {
            j.y("confirmationCode");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startLogin$lambda-1  reason: not valid java name */
    public static final void m158startLogin$lambda1(DeviceAuthDialog deviceAuthDialog, GraphResponse graphResponse) {
        FacebookException facebookException;
        j.g(deviceAuthDialog, "this$0");
        j.g(graphResponse, "response");
        if (!deviceAuthDialog.isBeingDestroyed) {
            if (graphResponse.getError() != null) {
                FacebookRequestError error = graphResponse.getError();
                if (error == null) {
                    facebookException = null;
                } else {
                    facebookException = error.getException();
                }
                if (facebookException == null) {
                    facebookException = new FacebookException();
                }
                deviceAuthDialog.onError(facebookException);
                return;
            }
            b jSONObject = graphResponse.getJSONObject();
            if (jSONObject == null) {
                jSONObject = new b();
            }
            RequestState requestState = new RequestState();
            try {
                requestState.setUserCode(jSONObject.getString("user_code"));
                requestState.setRequestCode(jSONObject.getString("code"));
                requestState.setInterval(jSONObject.getLong("interval"));
                deviceAuthDialog.setCurrentRequestState(requestState);
            } catch (JSONException e10) {
                deviceAuthDialog.onError(new FacebookException((Throwable) e10));
            }
        }
    }

    public Map<String, String> additionalDeviceInfo() {
        return null;
    }

    public String getApplicationAccessToken() {
        return Validate.hasAppID() + '|' + Validate.hasClientToken();
    }

    /* access modifiers changed from: protected */
    public int getLayoutResId(boolean z10) {
        if (z10) {
            return R.layout.com_facebook_smart_device_dialog_fragment;
        }
        return R.layout.com_facebook_device_auth_dialog_fragment;
    }

    /* access modifiers changed from: protected */
    public View initializeContentView(boolean z10) {
        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();
        j.f(layoutInflater, "requireActivity().layoutInflater");
        View inflate = layoutInflater.inflate(getLayoutResId(z10), (ViewGroup) null);
        j.f(inflate, "inflater.inflate(getLayoutResId(isSmartLogin), null)");
        View findViewById = inflate.findViewById(R.id.progress_bar);
        j.f(findViewById, "view.findViewById(R.id.progress_bar)");
        this.progressBar = findViewById;
        View findViewById2 = inflate.findViewById(R.id.confirmation_code);
        if (findViewById2 != null) {
            this.confirmationCode = (TextView) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.cancel_button);
            if (findViewById3 != null) {
                ((Button) findViewById3).setOnClickListener(new h(this));
                View findViewById4 = inflate.findViewById(R.id.com_facebook_device_auth_instructions);
                if (findViewById4 != null) {
                    TextView textView = (TextView) findViewById4;
                    this.instructions = textView;
                    textView.setText(Html.fromHtml(getString(R.string.com_facebook_device_auth_instructions)));
                    return inflate;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    /* access modifiers changed from: protected */
    public boolean onBackButtonPressed() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCancel() {
        if (this.completed.compareAndSet(false, true)) {
            RequestState requestState = this.currentRequestState;
            if (requestState != null) {
                DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler2 = this.deviceAuthMethodHandler;
            if (deviceAuthMethodHandler2 != null) {
                deviceAuthMethodHandler2.onCancel();
            }
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        boolean z10;
        DeviceAuthDialog$onCreateDialog$dialog$1 deviceAuthDialog$onCreateDialog$dialog$1 = new DeviceAuthDialog$onCreateDialog$dialog$1(this, requireActivity(), R.style.com_facebook_auth_dialog);
        if (!DeviceRequestsHelper.isAvailable() || this.isRetry) {
            z10 = false;
        } else {
            z10 = true;
        }
        deviceAuthDialog$onCreateDialog$dialog$1.setContentView(initializeContentView(z10));
        return deviceAuthDialog$onCreateDialog$dialog$1;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        LoginClient loginClient;
        j.g(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        LoginFragment loginFragment = (LoginFragment) ((FacebookActivity) requireActivity()).getCurrentFragment();
        LoginMethodHandler loginMethodHandler = null;
        if (!(loginFragment == null || (loginClient = loginFragment.getLoginClient()) == null)) {
            loginMethodHandler = loginClient.getCurrentHandler();
        }
        this.deviceAuthMethodHandler = (DeviceAuthMethodHandler) loginMethodHandler;
        if (!(bundle == null || (requestState = (RequestState) bundle.getParcelable(REQUEST_STATE_KEY)) == null)) {
            setCurrentRequestState(requestState);
        }
        return onCreateView;
    }

    public void onDestroyView() {
        this.isBeingDestroyed = true;
        this.completed.set(true);
        super.onDestroyView();
        GraphRequestAsyncTask graphRequestAsyncTask = this.currentGraphRequestPoll;
        if (graphRequestAsyncTask != null) {
            graphRequestAsyncTask.cancel(true);
        }
        ScheduledFuture<?> scheduledFuture = this.scheduledPoll;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        j.g(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        if (!this.isBeingDestroyed) {
            onCancel();
        }
    }

    /* access modifiers changed from: protected */
    public void onError(FacebookException facebookException) {
        j.g(facebookException, "ex");
        if (this.completed.compareAndSet(false, true)) {
            RequestState requestState = this.currentRequestState;
            if (requestState != null) {
                DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                DeviceRequestsHelper.cleanUpAdvertisementService(requestState.getUserCode());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler2 = this.deviceAuthMethodHandler;
            if (deviceAuthMethodHandler2 != null) {
                deviceAuthMethodHandler2.onError(facebookException);
            }
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        j.g(bundle, "outState");
        super.onSaveInstanceState(bundle);
        if (this.currentRequestState != null) {
            bundle.putParcelable(REQUEST_STATE_KEY, this.currentRequestState);
        }
    }

    public void startLogin(LoginClient.Request request2) {
        Map map;
        j.g(request2, "request");
        this.request = request2;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(AppsFlyerKit.COMMA, request2.getPermissions()));
        Utility utility = Utility.INSTANCE;
        Utility.putNonEmptyString(bundle, ServerProtocol.DIALOG_PARAM_REDIRECT_URI, request2.getDeviceRedirectUriString());
        Utility.putNonEmptyString(bundle, DeviceRequestsHelper.DEVICE_TARGET_USER_ID, request2.getDeviceAuthTargetUserId());
        bundle.putString("access_token", getApplicationAccessToken());
        DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
        Map<String, String> additionalDeviceInfo = additionalDeviceInfo();
        if (additionalDeviceInfo == null) {
            map = null;
        } else {
            map = h0.w(additionalDeviceInfo);
        }
        bundle.putString(DeviceRequestsHelper.DEVICE_INFO_PARAM, DeviceRequestsHelper.getDeviceInfo(map));
        GraphRequest.Companion.newPostRequestWithBundle((AccessToken) null, DEVICE_LOGIN_ENDPOINT, bundle, new g(this)).executeAsync();
    }
}

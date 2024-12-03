package com.facebook.login.widget;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.activity.result.c;
import androidx.activity.result.d;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.LoginTargetApp;
import com.facebook.login.R;
import com.facebook.login.widget.ToolTipPopup;
import com.mparticle.identity.IdentityHttpResponse;
import com.mparticle.kits.ReportingMessage;
import e.a;
import gk.f;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;

@Metadata(bv = {}, d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0016\u0018\u0000 ¶\u00012\u00020\u0001:\b¶\u0001·\u0001¸\u0001¹\u0001B?\b\u0004\u0012\u0006\u0010.\u001a\u00020-\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\u0006\u00101\u001a\u00020\u000b\u0012\u0006\u00102\u001a\u00020\u000b\u0012\u0007\u0010®\u0001\u001a\u00020\u0006\u0012\u0007\u0010¯\u0001\u001a\u00020\u0006¢\u0006\u0006\b°\u0001\u0010±\u0001B\u0013\b\u0016\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0006\b°\u0001\u0010²\u0001B\u001d\b\u0016\u0012\u0006\u0010.\u001a\u00020-\u0012\b\u00100\u001a\u0004\u0018\u00010/¢\u0006\u0006\b°\u0001\u0010³\u0001B&\b\u0016\u0012\u0006\u0010.\u001a\u00020-\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\u0007\u0010´\u0001\u001a\u00020\u000b¢\u0006\u0006\b°\u0001\u0010µ\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0003J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J\b\u0010\t\u001a\u00020\u0004H\u0003J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0003J\u0016\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0007J'\u0010\u000f\u001a\u00020\u00042\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0010\"\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0011J%\u0010\u0012\u001a\u00020\u00042\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0010\"\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0012\u0010\u0011J\u0016\u0010\u0013\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0007J'\u0010\u0013\u001a\u00020\u00042\u0016\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0010\"\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u0013\u0010\u0011J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u001c\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0015J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0015J0\u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000bH\u0015J\b\u0010(\u001a\u00020\u0004H\u0015J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000bH\u0015J*\u00103\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000bH\u0015J*\u00104\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000bH\u0005J\u0018\u00107\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000bH\u0015J\u0010\u00108\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000bH\u0005J\b\u00109\u001a\u00020\u0004H\u0005J\b\u0010:\u001a\u00020\u0004H\u0005J\b\u0010;\u001a\u00020\u0004H\u0005J\b\u0010<\u001a\u00020\u0004H\u0005R\u0016\u0010=\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R.\u0010@\u001a\u0004\u0018\u00010\u00062\b\u0010?\u001a\u0004\u0018\u00010\u00068\u0006@FX\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER.\u0010F\u001a\u0004\u0018\u00010\u00062\b\u0010?\u001a\u0004\u0018\u00010\u00068\u0006@FX\u000e¢\u0006\u0012\n\u0004\bF\u0010A\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER\u001a\u0010J\u001a\u00020I8\u0004X\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0016\u0010N\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010>R\"\u0010P\u001a\u00020O8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010^\u001a\u00020]8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0018\u0010e\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010h\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bh\u0010iR(\u0010l\u001a\b\u0012\u0004\u0012\u00020k0j8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u0018\u0010s\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010u\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0017\u0010w\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\bw\u0010A\u001a\u0004\bx\u0010CR(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010y\u001a\u0004\u0018\u00010\u00168\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0017\u0010z\u001a\u0004\b{\u0010|R%\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060~\u0018\u00010}8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0010\u0001R+\u0010\u0001\u001a\u00030\u00012\u0007\u0010?\u001a\u00030\u00018F@FX\u000e¢\u0006\u0010\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R+\u0010\u0001\u001a\u00030\u00012\u0007\u0010?\u001a\u00030\u00018F@FX\u000e¢\u0006\u0010\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R+\u0010\u0001\u001a\u00030\u00012\u0007\u0010?\u001a\u00030\u00018F@FX\u000e¢\u0006\u0010\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R'\u0010\u0001\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u00068F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER+\u0010\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010?\u001a\u0004\u0018\u00010\u00068F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0001\u0010C\"\u0005\b\u0001\u0010ER)\u0010\u0001\u001a\u00020!2\u0006\u0010?\u001a\u00020!8F@FX\u000e¢\u0006\u0010\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0014\u0010\u0001\u001a\u00020!8F¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0017\u0010¢\u0001\u001a\u00020\u000b8EX\u0004¢\u0006\b\u001a\u0006\b \u0001\u0010¡\u0001R3\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00060\r8F@FX\u000e¢\u0006\u000f\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0005\b\u0012\u0010¥\u0001R\u001c\u0010©\u0001\u001a\u00070¦\u0001R\u00020\u00008TX\u0004¢\u0006\b\u001a\u0006\b§\u0001\u0010¨\u0001R\u0017\u0010«\u0001\u001a\u00020\u000b8TX\u0004¢\u0006\b\u001a\u0006\bª\u0001\u0010¡\u0001R\u0017\u0010­\u0001\u001a\u00020\u000b8UX\u0004¢\u0006\b\u001a\u0006\b¬\u0001\u0010¡\u0001¨\u0006º\u0001"}, d2 = {"Lcom/facebook/login/widget/LoginButton;", "Lcom/facebook/FacebookButtonBase;", "Lcom/facebook/internal/FetchedAppSettings;", "settings", "", "showToolTipPerSettings", "", "toolTipString", "displayToolTip", "checkToolTipSettings", "text", "", "measureButtonWidth", "", "permissions", "setReadPermissions", "", "([Ljava/lang/String;)V", "setPermissions", "setPublishPermissions", "clearPermissions", "dismissToolTip", "Lcom/facebook/CallbackManager;", "callbackManager", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "callback", "registerCallback", "unregisterCallback", "onAttachedToWindow", "Landroid/graphics/Canvas;", "canvas", "onDraw", "", "changed", "left", "top", "right", "bottom", "onLayout", "onDetachedFromWindow", "Landroid/view/View;", "changedView", "visibility", "onVisibilityChanged", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "configureButton", "parseLoginButtonAttributes", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "getLoginButtonWidth", "setButtonText", "setButtonIcon", "setButtonRadius", "setButtonTransparency", "confirmLogout", "Z", "value", "loginText", "Ljava/lang/String;", "getLoginText", "()Ljava/lang/String;", "setLoginText", "(Ljava/lang/String;)V", "logoutText", "getLogoutText", "setLogoutText", "Lcom/facebook/login/widget/LoginButton$LoginButtonProperties;", "properties", "Lcom/facebook/login/widget/LoginButton$LoginButtonProperties;", "getProperties", "()Lcom/facebook/login/widget/LoginButton$LoginButtonProperties;", "toolTipChecked", "Lcom/facebook/login/widget/ToolTipPopup$Style;", "toolTipStyle", "Lcom/facebook/login/widget/ToolTipPopup$Style;", "getToolTipStyle", "()Lcom/facebook/login/widget/ToolTipPopup$Style;", "setToolTipStyle", "(Lcom/facebook/login/widget/ToolTipPopup$Style;)V", "Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "toolTipMode", "Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "getToolTipMode", "()Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "setToolTipMode", "(Lcom/facebook/login/widget/LoginButton$ToolTipMode;)V", "", "toolTipDisplayTime", "J", "getToolTipDisplayTime", "()J", "setToolTipDisplayTime", "(J)V", "Lcom/facebook/login/widget/ToolTipPopup;", "toolTipPopup", "Lcom/facebook/login/widget/ToolTipPopup;", "Lcom/facebook/AccessTokenTracker;", "accessTokenTracker", "Lcom/facebook/AccessTokenTracker;", "Lgk/f;", "Lcom/facebook/login/LoginManager;", "loginManagerLazy", "Lgk/f;", "getLoginManagerLazy", "()Lgk/f;", "setLoginManagerLazy", "(Lgk/f;)V", "", "customButtonRadius", "Ljava/lang/Float;", "customButtonTransparency", "I", "loggerID", "getLoggerID", "<set-?>", "Lcom/facebook/CallbackManager;", "getCallbackManager", "()Lcom/facebook/CallbackManager;", "Landroidx/activity/result/c;", "", "androidXLoginCaller", "Landroidx/activity/result/c;", "Lcom/facebook/login/DefaultAudience;", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "setDefaultAudience", "(Lcom/facebook/login/DefaultAudience;)V", "defaultAudience", "Lcom/facebook/login/LoginBehavior;", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "setLoginBehavior", "(Lcom/facebook/login/LoginBehavior;)V", "loginBehavior", "Lcom/facebook/login/LoginTargetApp;", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "setLoginTargetApp", "(Lcom/facebook/login/LoginTargetApp;)V", "loginTargetApp", "getAuthType", "setAuthType", "authType", "getMessengerPageId", "setMessengerPageId", "messengerPageId", "getResetMessengerState", "()Z", "setResetMessengerState", "(Z)V", "resetMessengerState", "getShouldSkipAccountDeduplication", "shouldSkipAccountDeduplication", "getLoginButtonContinueLabel", "()I", "loginButtonContinueLabel", "getPermissions", "()Ljava/util/List;", "(Ljava/util/List;)V", "Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "getNewLoginClickListener", "()Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "newLoginClickListener", "getDefaultStyleResource", "defaultStyleResource", "getDefaultRequestCode", "defaultRequestCode", "analyticsButtonCreatedEventName", "analyticsButtonTappedEventName", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILjava/lang/String;Ljava/lang/String;)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "LoginButtonProperties", "LoginClickListener", "ToolTipMode", "facebook-login_release"}, k = 1, mv = {1, 5, 1})
public class LoginButton extends FacebookButtonBase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_BUTTON_TRANSPARENCY = 255;
    private static final int MIN_BUTTON_TRANSPARENCY = 0;
    private static final String TAG = LoginButton.class.getName();
    private AccessTokenTracker accessTokenTracker;
    /* access modifiers changed from: private */
    public c<Collection<String>> androidXLoginCaller;
    private CallbackManager callbackManager;
    /* access modifiers changed from: private */
    public boolean confirmLogout;
    private Float customButtonRadius;
    private int customButtonTransparency;
    private final String loggerID;
    private f<? extends LoginManager> loginManagerLazy;
    private String loginText;
    private String logoutText;
    private final LoginButtonProperties properties;
    private boolean toolTipChecked;
    private long toolTipDisplayTime;
    private ToolTipMode toolTipMode;
    private ToolTipPopup toolTipPopup;
    private ToolTipPopup.Style toolTipStyle;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/login/widget/LoginButton$Companion;", "", "()V", "MAX_BUTTON_TRANSPARENCY", "", "MIN_BUTTON_TRANSPARENCY", "TAG", "", "kotlin.jvm.PlatformType", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010.\u001a\u00020/R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u00020%2\u0006\u0010*\u001a\u00020%@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)¨\u00060"}, d2 = {"Lcom/facebook/login/widget/LoginButton$LoginButtonProperties;", "", "()V", "authType", "", "getAuthType", "()Ljava/lang/String;", "setAuthType", "(Ljava/lang/String;)V", "defaultAudience", "Lcom/facebook/login/DefaultAudience;", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "setDefaultAudience", "(Lcom/facebook/login/DefaultAudience;)V", "loginBehavior", "Lcom/facebook/login/LoginBehavior;", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "setLoginBehavior", "(Lcom/facebook/login/LoginBehavior;)V", "loginTargetApp", "Lcom/facebook/login/LoginTargetApp;", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "setLoginTargetApp", "(Lcom/facebook/login/LoginTargetApp;)V", "messengerPageId", "getMessengerPageId", "setMessengerPageId", "permissions", "", "getPermissions", "()Ljava/util/List;", "setPermissions", "(Ljava/util/List;)V", "resetMessengerState", "", "getResetMessengerState", "()Z", "setResetMessengerState", "(Z)V", "<set-?>", "shouldSkipAccountDeduplication", "getShouldSkipAccountDeduplication", "setShouldSkipAccountDeduplication", "clearPermissions", "", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class LoginButtonProperties {
        private String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
        private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
        private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
        private LoginTargetApp loginTargetApp = LoginTargetApp.FACEBOOK;
        private String messengerPageId;
        private List<String> permissions = q.j();
        private boolean resetMessengerState;
        private boolean shouldSkipAccountDeduplication;

        public final void clearPermissions() {
            this.permissions = q.j();
        }

        public final String getAuthType() {
            return this.authType;
        }

        public final DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        public final LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        public final LoginTargetApp getLoginTargetApp() {
            return this.loginTargetApp;
        }

        public final String getMessengerPageId() {
            return this.messengerPageId;
        }

        public final List<String> getPermissions() {
            return this.permissions;
        }

        public final boolean getResetMessengerState() {
            return this.resetMessengerState;
        }

        public final boolean getShouldSkipAccountDeduplication() {
            return this.shouldSkipAccountDeduplication;
        }

        public final void setAuthType(String str) {
            j.g(str, "<set-?>");
            this.authType = str;
        }

        public final void setDefaultAudience(DefaultAudience defaultAudience2) {
            j.g(defaultAudience2, "<set-?>");
            this.defaultAudience = defaultAudience2;
        }

        public final void setLoginBehavior(LoginBehavior loginBehavior2) {
            j.g(loginBehavior2, "<set-?>");
            this.loginBehavior = loginBehavior2;
        }

        public final void setLoginTargetApp(LoginTargetApp loginTargetApp2) {
            j.g(loginTargetApp2, "<set-?>");
            this.loginTargetApp = loginTargetApp2;
        }

        public final void setMessengerPageId(String str) {
            this.messengerPageId = str;
        }

        public final void setPermissions(List<String> list) {
            j.g(list, "<set-?>");
            this.permissions = list;
        }

        public final void setResetMessengerState(boolean z10) {
            this.resetMessengerState = z10;
        }

        /* access modifiers changed from: protected */
        public final void setShouldSkipAccountDeduplication(boolean z10) {
            this.shouldSkipAccountDeduplication = z10;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0004J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0004R\u0014\u0010\u0003\u001a\u00020\u00048DX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078DX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/facebook/login/widget/LoginButton$LoginClickListener;", "Landroid/view/View$OnClickListener;", "(Lcom/facebook/login/widget/LoginButton;)V", "isFamilyLogin", "", "()Z", "loginTargetApp", "Lcom/facebook/login/LoginTargetApp;", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "getLoginManager", "Lcom/facebook/login/LoginManager;", "onClick", "", "v", "Landroid/view/View;", "performLogin", "performLogout", "context", "Landroid/content/Context;", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    protected class LoginClickListener implements View.OnClickListener {
        final /* synthetic */ LoginButton this$0;

        public LoginClickListener(LoginButton loginButton) {
            j.g(loginButton, "this$0");
            this.this$0 = loginButton;
        }

        /* access modifiers changed from: private */
        /* renamed from: performLogout$lambda-2  reason: not valid java name */
        public static final void m172performLogout$lambda2(LoginManager loginManager, DialogInterface dialogInterface, int i10) {
            if (!CrashShieldHandler.isObjectCrashing(LoginClickListener.class)) {
                try {
                    j.g(loginManager, "$loginManager");
                    loginManager.logOut();
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, LoginClickListener.class);
                }
            }
        }

        /* access modifiers changed from: protected */
        public LoginManager getLoginManager() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                LoginManager instance = LoginManager.Companion.getInstance();
                instance.setDefaultAudience(this.this$0.getDefaultAudience());
                instance.setLoginBehavior(this.this$0.getLoginBehavior());
                instance.setLoginTargetApp(getLoginTargetApp());
                instance.setAuthType(this.this$0.getAuthType());
                instance.setFamilyLogin(isFamilyLogin());
                instance.setShouldSkipAccountDeduplication(this.this$0.getShouldSkipAccountDeduplication());
                instance.setMessengerPageId(this.this$0.getMessengerPageId());
                instance.setResetMessengerState(this.this$0.getResetMessengerState());
                return instance;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public final LoginTargetApp getLoginTargetApp() {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                return LoginTargetApp.FACEBOOK;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public final boolean isFamilyLogin() {
            CrashShieldHandler.isObjectCrashing(this);
            return false;
        }

        public void onClick(View view) {
            int i10;
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    j.g(view, ReportingMessage.MessageType.SCREEN_VIEW);
                    this.this$0.callExternalOnClickListener(view);
                    AccessToken.Companion companion = AccessToken.Companion;
                    AccessToken currentAccessToken = companion.getCurrentAccessToken();
                    boolean isCurrentAccessTokenActive = companion.isCurrentAccessTokenActive();
                    if (isCurrentAccessTokenActive) {
                        Context context = this.this$0.getContext();
                        j.f(context, IdentityHttpResponse.CONTEXT);
                        performLogout(context);
                    } else {
                        performLogin();
                    }
                    InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(this.this$0.getContext());
                    Bundle bundle = new Bundle();
                    int i11 = 0;
                    if (currentAccessToken != null) {
                        i10 = 0;
                    } else {
                        i10 = 1;
                    }
                    bundle.putInt("logging_in", i10);
                    if (isCurrentAccessTokenActive) {
                        i11 = 1;
                    }
                    bundle.putInt("access_token_expired", i11);
                    internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_LOGIN_VIEW_USAGE, bundle);
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void performLogin() {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    LoginManager loginManager = getLoginManager();
                    c access$getAndroidXLoginCaller$p = this.this$0.androidXLoginCaller;
                    if (access$getAndroidXLoginCaller$p != null) {
                        LoginManager.FacebookLoginActivityResultContract facebookLoginActivityResultContract = (LoginManager.FacebookLoginActivityResultContract) access$getAndroidXLoginCaller$p.a();
                        CallbackManager callbackManager = this.this$0.getCallbackManager();
                        if (callbackManager == null) {
                            callbackManager = new CallbackManagerImpl();
                        }
                        facebookLoginActivityResultContract.setCallbackManager(callbackManager);
                        access$getAndroidXLoginCaller$p.b(this.this$0.getProperties().getPermissions());
                    } else if (this.this$0.getFragment() != null) {
                        Fragment fragment = this.this$0.getFragment();
                        if (fragment != null) {
                            LoginButton loginButton = this.this$0;
                            loginManager.logIn(fragment, (Collection<String>) loginButton.getProperties().getPermissions(), loginButton.getLoggerID());
                        }
                    } else if (this.this$0.getNativeFragment() != null) {
                        android.app.Fragment nativeFragment = this.this$0.getNativeFragment();
                        if (nativeFragment != null) {
                            LoginButton loginButton2 = this.this$0;
                            loginManager.logIn(nativeFragment, (Collection<String>) loginButton2.getProperties().getPermissions(), loginButton2.getLoggerID());
                        }
                    } else {
                        loginManager.logIn(this.this$0.getActivity(), (Collection<String>) this.this$0.getProperties().getPermissions(), this.this$0.getLoggerID());
                    }
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void performLogout(Context context) {
            String str;
            String str2;
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    j.g(context, IdentityHttpResponse.CONTEXT);
                    LoginManager loginManager = getLoginManager();
                    if (this.this$0.confirmLogout) {
                        String string = this.this$0.getResources().getString(R.string.com_facebook_loginview_log_out_action);
                        j.f(string, "resources.getString(R.string.com_facebook_loginview_log_out_action)");
                        String string2 = this.this$0.getResources().getString(R.string.com_facebook_loginview_cancel_action);
                        j.f(string2, "resources.getString(R.string.com_facebook_loginview_cancel_action)");
                        Profile currentProfile = Profile.Companion.getCurrentProfile();
                        if (currentProfile == null) {
                            str = null;
                        } else {
                            str = currentProfile.getName();
                        }
                        if (str != null) {
                            o oVar = o.f32141a;
                            String string3 = this.this$0.getResources().getString(R.string.com_facebook_loginview_logged_in_as);
                            j.f(string3, "resources.getString(R.string.com_facebook_loginview_logged_in_as)");
                            str2 = String.format(string3, Arrays.copyOf(new Object[]{currentProfile.getName()}, 1));
                            j.f(str2, "java.lang.String.format(format, *args)");
                        } else {
                            str2 = this.this$0.getResources().getString(R.string.com_facebook_loginview_logged_in_using_facebook);
                            j.f(str2, "{\n          resources.getString(R.string.com_facebook_loginview_logged_in_using_facebook)\n        }");
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage(str2).setCancelable(true).setPositiveButton(string, new f(loginManager)).setNegativeButton(string2, (DialogInterface.OnClickListener) null);
                        builder.create().show();
                        return;
                    }
                    loginManager.logOut();
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "", "stringValue", "", "intValue", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getIntValue", "()I", "toString", "AUTOMATIC", "DISPLAY_ALWAYS", "NEVER_DISPLAY", "Companion", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum ToolTipMode {
        AUTOMATIC(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, 0),
        DISPLAY_ALWAYS("display_always", 1),
        NEVER_DISPLAY("never_display", 2);
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public static final ToolTipMode DEFAULT = null;
        private final int intValue;
        private final String stringValue;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/facebook/login/widget/LoginButton$ToolTipMode$Companion;", "", "()V", "DEFAULT", "Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "getDEFAULT", "()Lcom/facebook/login/widget/LoginButton$ToolTipMode;", "fromInt", "enumValue", "", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ToolTipMode fromInt(int i10) {
                for (ToolTipMode toolTipMode : ToolTipMode.values()) {
                    if (toolTipMode.getIntValue() == i10) {
                        return toolTipMode;
                    }
                }
                return null;
            }

            public final ToolTipMode getDEFAULT() {
                return ToolTipMode.DEFAULT;
            }
        }

        static {
            ToolTipMode toolTipMode;
            Companion = new Companion((DefaultConstructorMarker) null);
            DEFAULT = toolTipMode;
        }

        private ToolTipMode(String str, int i10) {
            this.stringValue = str;
            this.intValue = i10;
        }

        public final int getIntValue() {
            return this.intValue;
        }

        public String toString() {
            return this.stringValue;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToolTipMode.values().length];
            iArr[ToolTipMode.AUTOMATIC.ordinal()] = 1;
            iArr[ToolTipMode.DISPLAY_ALWAYS.ordinal()] = 2;
            iArr[ToolTipMode.NEVER_DISPLAY.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected LoginButton(Context context, AttributeSet attributeSet, int i10, int i11, String str, String str2) {
        super(context, attributeSet, i10, i11, str, str2);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(str, "analyticsButtonCreatedEventName");
        j.g(str2, "analyticsButtonTappedEventName");
        this.properties = new LoginButtonProperties();
        this.toolTipStyle = ToolTipPopup.Style.BLUE;
        this.toolTipMode = ToolTipMode.Companion.getDEFAULT();
        this.toolTipDisplayTime = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
        this.loginManagerLazy = b.b(LoginButton$loginManagerLazy$1.INSTANCE);
        this.customButtonTransparency = 255;
        String uuid = UUID.randomUUID().toString();
        j.f(uuid, "randomUUID().toString()");
        this.loggerID = uuid;
    }

    private final void checkToolTipSettings() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                int i10 = WhenMappings.$EnumSwitchMapping$0[this.toolTipMode.ordinal()];
                if (i10 == 1) {
                    Utility utility = Utility.INSTANCE;
                    FacebookSdk.getExecutor().execute(new e(Utility.getMetadataApplicationId(getContext()), this));
                } else if (i10 == 2) {
                    String string = getResources().getString(R.string.com_facebook_tooltip_default);
                    j.f(string, "resources.getString(R.string.com_facebook_tooltip_default)");
                    displayToolTip(string);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: checkToolTipSettings$lambda-3  reason: not valid java name */
    public static final void m169checkToolTipSettings$lambda3(String str, LoginButton loginButton) {
        j.g(str, "$appId");
        j.g(loginButton, "this$0");
        loginButton.getActivity().runOnUiThread(new c(loginButton, FetchedAppSettingsManager.queryAppSettings(str, false)));
    }

    /* access modifiers changed from: private */
    /* renamed from: checkToolTipSettings$lambda-3$lambda-2  reason: not valid java name */
    public static final void m170checkToolTipSettings$lambda3$lambda2(LoginButton loginButton, FetchedAppSettings fetchedAppSettings) {
        j.g(loginButton, "this$0");
        loginButton.showToolTipPerSettings(fetchedAppSettings);
    }

    private final void displayToolTip(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                ToolTipPopup toolTipPopup2 = new ToolTipPopup(str, this);
                toolTipPopup2.setStyle(this.toolTipStyle);
                toolTipPopup2.setNuxDisplayTime(this.toolTipDisplayTime);
                toolTipPopup2.show();
                this.toolTipPopup = toolTipPopup2;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    private final int measureButtonWidth(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return getCompoundPaddingLeft() + getCompoundDrawablePadding() + measureTextWidth(str) + getCompoundPaddingRight();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachedToWindow$lambda-0  reason: not valid java name */
    public static final void m171onAttachedToWindow$lambda0(CallbackManager.ActivityResultParameters activityResultParameters) {
    }

    private final void showToolTipPerSettings(FetchedAppSettings fetchedAppSettings) {
        if (!CrashShieldHandler.isObjectCrashing(this) && fetchedAppSettings != null) {
            try {
                if (fetchedAppSettings.getNuxEnabled() && getVisibility() == 0) {
                    displayToolTip(fetchedAppSettings.getNuxContent());
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void clearPermissions() {
        this.properties.clearPermissions();
    }

    /* access modifiers changed from: protected */
    public void configureButton(Context context, AttributeSet attributeSet, int i10, int i11) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(context, IdentityHttpResponse.CONTEXT);
                super.configureButton(context, attributeSet, i10, i11);
                setInternalOnClickListener(getNewLoginClickListener());
                parseLoginButtonAttributes(context, attributeSet, i10, i11);
                if (isInEditMode()) {
                    setBackgroundColor(getResources().getColor(com.facebook.common.R.color.com_facebook_blue));
                    setLoginText("Continue with Facebook");
                } else {
                    this.accessTokenTracker = new LoginButton$configureButton$1(this);
                }
                setButtonText();
                setButtonRadius();
                setButtonTransparency();
                setButtonIcon();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void dismissToolTip() {
        ToolTipPopup toolTipPopup2 = this.toolTipPopup;
        if (toolTipPopup2 != null) {
            toolTipPopup2.dismiss();
        }
        this.toolTipPopup = null;
    }

    public final String getAuthType() {
        return this.properties.getAuthType();
    }

    public final CallbackManager getCallbackManager() {
        return this.callbackManager;
    }

    public final DefaultAudience getDefaultAudience() {
        return this.properties.getDefaultAudience();
    }

    /* access modifiers changed from: protected */
    public int getDefaultRequestCode() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public int getDefaultStyleResource() {
        return R.style.com_facebook_loginview_default_style;
    }

    public final String getLoggerID() {
        return this.loggerID;
    }

    public final LoginBehavior getLoginBehavior() {
        return this.properties.getLoginBehavior();
    }

    /* access modifiers changed from: protected */
    public final int getLoginButtonContinueLabel() {
        return R.string.com_facebook_loginview_log_in_button_continue;
    }

    /* access modifiers changed from: protected */
    public final int getLoginButtonWidth(int i10) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            Resources resources = getResources();
            String str = this.loginText;
            if (str == null) {
                str = resources.getString(R.string.com_facebook_loginview_log_in_button_continue);
                int measureButtonWidth = measureButtonWidth(str);
                if (View.resolveSize(measureButtonWidth, i10) < measureButtonWidth) {
                    str = resources.getString(R.string.com_facebook_loginview_log_in_button);
                }
            }
            return measureButtonWidth(str);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public final f<LoginManager> getLoginManagerLazy() {
        return this.loginManagerLazy;
    }

    public final LoginTargetApp getLoginTargetApp() {
        return this.properties.getLoginTargetApp();
    }

    public final String getLoginText() {
        return this.loginText;
    }

    public final String getLogoutText() {
        return this.logoutText;
    }

    public final String getMessengerPageId() {
        return this.properties.getMessengerPageId();
    }

    /* access modifiers changed from: protected */
    public LoginClickListener getNewLoginClickListener() {
        return new LoginClickListener(this);
    }

    public final List<String> getPermissions() {
        return this.properties.getPermissions();
    }

    /* access modifiers changed from: protected */
    public final LoginButtonProperties getProperties() {
        return this.properties;
    }

    public final boolean getResetMessengerState() {
        return this.properties.getResetMessengerState();
    }

    public final boolean getShouldSkipAccountDeduplication() {
        return this.properties.getShouldSkipAccountDeduplication();
    }

    public final long getToolTipDisplayTime() {
        return this.toolTipDisplayTime;
    }

    public final ToolTipMode getToolTipMode() {
        return this.toolTipMode;
    }

    public final ToolTipPopup.Style getToolTipStyle() {
        return this.toolTipStyle;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onAttachedToWindow();
                if (getContext() instanceof d) {
                    Context context = getContext();
                    if (context != null) {
                        this.androidXLoginCaller = ((d) context).getActivityResultRegistry().j("facebook-login", ((LoginManager) this.loginManagerLazy.getValue()).createLogInActivityResultContract(this.callbackManager, this.loggerID), new d());
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.activity.result.ActivityResultRegistryOwner");
                    }
                }
                AccessTokenTracker accessTokenTracker2 = this.accessTokenTracker;
                if (accessTokenTracker2 != null) {
                    if (accessTokenTracker2.isTracking()) {
                        accessTokenTracker2.startTracking();
                        setButtonText();
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onDetachedFromWindow();
                c<Collection<String>> cVar = this.androidXLoginCaller;
                if (cVar != null) {
                    cVar.d();
                }
                AccessTokenTracker accessTokenTracker2 = this.accessTokenTracker;
                if (accessTokenTracker2 != null) {
                    accessTokenTracker2.stopTracking();
                }
                dismissToolTip();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(canvas, "canvas");
                super.onDraw(canvas);
                if (!this.toolTipChecked && !isInEditMode()) {
                    this.toolTipChecked = true;
                    checkToolTipSettings();
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                super.onLayout(z10, i10, i11, i12, i13);
                setButtonText();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
                int compoundPaddingTop = getCompoundPaddingTop() + ((int) Math.ceil((double) (Math.abs(fontMetrics.top) + Math.abs(fontMetrics.bottom)))) + getCompoundPaddingBottom();
                Resources resources = getResources();
                int loginButtonWidth = getLoginButtonWidth(i10);
                String str = this.logoutText;
                if (str == null) {
                    str = resources.getString(R.string.com_facebook_loginview_log_out_button);
                    j.f(str, "resources.getString(R.string.com_facebook_loginview_log_out_button)");
                }
                setMeasuredDimension(View.resolveSize(Math.max(loginButtonWidth, measureButtonWidth(str)), i10), compoundPaddingTop);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i10) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(view, "changedView");
                super.onVisibilityChanged(view, i10);
                if (i10 != 0) {
                    dismissToolTip();
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void parseLoginButtonAttributes(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(context, IdentityHttpResponse.CONTEXT);
                ToolTipMode.Companion companion = ToolTipMode.Companion;
                this.toolTipMode = companion.getDEFAULT();
                obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.com_facebook_login_view, i10, i11);
                j.f(obtainStyledAttributes, "context\n            .theme\n            .obtainStyledAttributes(\n                attrs, R.styleable.com_facebook_login_view, defStyleAttr, defStyleRes)");
                this.confirmLogout = obtainStyledAttributes.getBoolean(R.styleable.com_facebook_login_view_com_facebook_confirm_logout, true);
                setLoginText(obtainStyledAttributes.getString(R.styleable.com_facebook_login_view_com_facebook_login_text));
                setLogoutText(obtainStyledAttributes.getString(R.styleable.com_facebook_login_view_com_facebook_logout_text));
                ToolTipMode fromInt = companion.fromInt(obtainStyledAttributes.getInt(R.styleable.com_facebook_login_view_com_facebook_tooltip_mode, companion.getDEFAULT().getIntValue()));
                if (fromInt == null) {
                    fromInt = companion.getDEFAULT();
                }
                this.toolTipMode = fromInt;
                int i12 = R.styleable.com_facebook_login_view_com_facebook_login_button_radius;
                if (obtainStyledAttributes.hasValue(i12)) {
                    this.customButtonRadius = Float.valueOf(obtainStyledAttributes.getDimension(i12, 0.0f));
                }
                int integer = obtainStyledAttributes.getInteger(R.styleable.com_facebook_login_view_com_facebook_login_button_transparency, 255);
                this.customButtonTransparency = integer;
                int max = Math.max(0, integer);
                this.customButtonTransparency = max;
                this.customButtonTransparency = Math.min(255, max);
                obtainStyledAttributes.recycle();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void registerCallback(CallbackManager callbackManager2, FacebookCallback<LoginResult> facebookCallback) {
        j.g(callbackManager2, "callbackManager");
        j.g(facebookCallback, "callback");
        ((LoginManager) this.loginManagerLazy.getValue()).registerCallback(callbackManager2, facebookCallback);
        if (this.callbackManager == null) {
            this.callbackManager = callbackManager2;
        }
    }

    public final void setAuthType(String str) {
        j.g(str, "value");
        this.properties.setAuthType(str);
    }

    /* access modifiers changed from: protected */
    public final void setButtonIcon() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                setCompoundDrawablesWithIntrinsicBounds(a.b(getContext(), com.facebook.common.R.drawable.com_facebook_button_icon), (Drawable) null, (Drawable) null, (Drawable) null);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(29)
    public final void setButtonRadius() {
        GradientDrawable gradientDrawable;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Float f10 = this.customButtonRadius;
                if (f10 != null) {
                    float floatValue = f10.floatValue();
                    Drawable background = getBackground();
                    if (Build.VERSION.SDK_INT >= 29 && (background instanceof StateListDrawable)) {
                        int i10 = 0;
                        int a10 = ((StateListDrawable) background).getStateCount();
                        if (a10 > 0) {
                            while (true) {
                                int i11 = i10 + 1;
                                Drawable a11 = ((StateListDrawable) background).getStateDrawable(i10);
                                if (a11 instanceof GradientDrawable) {
                                    gradientDrawable = (GradientDrawable) a11;
                                } else {
                                    gradientDrawable = null;
                                }
                                if (gradientDrawable != null) {
                                    gradientDrawable.setCornerRadius(floatValue);
                                }
                                if (i11 >= a10) {
                                    break;
                                }
                                i10 = i11;
                            }
                        }
                    }
                    if (background instanceof GradientDrawable) {
                        ((GradientDrawable) background).setCornerRadius(floatValue);
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void setButtonText() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Resources resources = getResources();
                if (isInEditMode() || !AccessToken.Companion.isCurrentAccessTokenActive()) {
                    String str = this.loginText;
                    if (str != null) {
                        setText(str);
                        return;
                    }
                    String string = resources.getString(getLoginButtonContinueLabel());
                    j.f(string, "resources.getString(loginButtonContinueLabel)");
                    int width = getWidth();
                    if (width != 0 && measureButtonWidth(string) > width) {
                        string = resources.getString(R.string.com_facebook_loginview_log_in_button);
                        j.f(string, "resources.getString(R.string.com_facebook_loginview_log_in_button)");
                    }
                    setText(string);
                    return;
                }
                String str2 = this.logoutText;
                if (str2 == null) {
                    str2 = resources.getString(R.string.com_facebook_loginview_log_out_button);
                }
                setText(str2);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void setButtonTransparency() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                getBackground().setAlpha(this.customButtonTransparency);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public final void setDefaultAudience(DefaultAudience defaultAudience) {
        j.g(defaultAudience, "value");
        this.properties.setDefaultAudience(defaultAudience);
    }

    public final void setLoginBehavior(LoginBehavior loginBehavior) {
        j.g(loginBehavior, "value");
        this.properties.setLoginBehavior(loginBehavior);
    }

    /* access modifiers changed from: protected */
    public final void setLoginManagerLazy(f<? extends LoginManager> fVar) {
        j.g(fVar, "<set-?>");
        this.loginManagerLazy = fVar;
    }

    public final void setLoginTargetApp(LoginTargetApp loginTargetApp) {
        j.g(loginTargetApp, "value");
        this.properties.setLoginTargetApp(loginTargetApp);
    }

    public final void setLoginText(String str) {
        this.loginText = str;
        setButtonText();
    }

    public final void setLogoutText(String str) {
        this.logoutText = str;
        setButtonText();
    }

    public final void setMessengerPageId(String str) {
        this.properties.setMessengerPageId(str);
    }

    public final void setPermissions(String... strArr) {
        j.g(strArr, "permissions");
        this.properties.setPermissions(q.o(Arrays.copyOf(strArr, strArr.length)));
    }

    public final void setPublishPermissions(List<String> list) {
        j.g(list, "permissions");
        this.properties.setPermissions(list);
    }

    public final void setReadPermissions(List<String> list) {
        j.g(list, "permissions");
        this.properties.setPermissions(list);
    }

    public final void setResetMessengerState(boolean z10) {
        this.properties.setResetMessengerState(z10);
    }

    public final void setToolTipDisplayTime(long j10) {
        this.toolTipDisplayTime = j10;
    }

    public final void setToolTipMode(ToolTipMode toolTipMode2) {
        j.g(toolTipMode2, "<set-?>");
        this.toolTipMode = toolTipMode2;
    }

    public final void setToolTipStyle(ToolTipPopup.Style style) {
        j.g(style, "<set-?>");
        this.toolTipStyle = style;
    }

    public final void unregisterCallback(CallbackManager callbackManager2) {
        j.g(callbackManager2, "callbackManager");
        ((LoginManager) this.loginManagerLazy.getValue()).unregisterCallback(callbackManager2);
    }

    public final void setPermissions(List<String> list) {
        j.g(list, "value");
        this.properties.setPermissions(list);
    }

    public final void setPublishPermissions(String... strArr) {
        j.g(strArr, "permissions");
        this.properties.setPermissions(q.o(Arrays.copyOf(strArr, strArr.length)));
    }

    public final void setReadPermissions(String... strArr) {
        j.g(strArr, "permissions");
        this.properties.setPermissions(q.o(Arrays.copyOf(strArr, strArr.length)));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LoginButton(Context context) {
        this(context, (AttributeSet) null, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LoginButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LoginButton(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, AnalyticsEvents.EVENT_LOGIN_BUTTON_CREATE, AnalyticsEvents.EVENT_LOGIN_BUTTON_DID_TAP);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }
}

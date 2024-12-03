package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import androidx.activity.result.c;
import androidx.activity.result.d;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import c.a;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0016\u0018\u0000 ~2\u00020\u0001:\n\u0001~\u0001\u0001\u0001B\u0007¢\u0006\u0004\b|\u0010}J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J \u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0018\u001a\u00020\u00062\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0018\u0010\u0019\u001a\u00020\u00062\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u001c\u0010!\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\bH\u0002JL\u0010*\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010#\u001a\u00020\"2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010$2\b\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010)\u001a\u00020(2\b\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010+\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u0010\u0010.\u001a\u00020(2\u0006\u0010-\u001a\u00020,H\u0002JH\u00109\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010/2\b\u00102\u001a\u0004\u0018\u0001012\b\u00103\u001a\u0004\u0018\u00010\b2\b\u0010'\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020(2\u000e\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106H\u0002J \u0010>\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<H\u0002J\u0010\u0010@\u001a\u00020\u00062\u0006\u0010?\u001a\u00020(H\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A2\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020D2\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0004J \u0010E\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u000e\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106J\u0010\u0010F\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J,\u0010J\u001a\u00020(2\u0006\u0010H\u001a\u00020G2\b\u0010I\u001a\u0004\u0018\u00010,2\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106H\u0017J\u000e\u0010M\u001a\u00020\u00002\u0006\u0010L\u001a\u00020KJ\u000e\u0010P\u001a\u00020\u00002\u0006\u0010O\u001a\u00020NJ\u000e\u0010S\u001a\u00020\u00002\u0006\u0010R\u001a\u00020QJ\u000e\u0010U\u001a\u00020\u00002\u0006\u0010T\u001a\u00020\u000bJ\u0010\u0010W\u001a\u00020\u00002\b\u0010V\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010X\u001a\u00020(J\u000e\u0010[\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020(J\u000e\u0010]\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020(J\b\u0010^\u001a\u00020\u0006H\u0016J\u0016\u0010_\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020:J\u001e\u0010_\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020<2\u0006\u0010;\u001a\u00020:J\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007J$\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001c\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020D2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ$\u0010\r\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0016\u0010`\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010B\u001a\u00020AJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020CJ\u001e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007J$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001c\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020D2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001e\u0010\u0012\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ(\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020C2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010a\u001a\u0004\u0018\u00010\u000bJ\u001e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020D2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ(\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020D2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010a\u001a\u0004\u0018\u00010\u000bJ\u001e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ(\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010a\u001a\u0004\u0018\u00010\u000bJ\u001e\u0010\u0017\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A2\u0006\u0010\u000f\u001a\u00020\u000eJ(\u0010\u0017\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010a\u001a\u0004\u0018\u00010\u000bJ.\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010a\u001a\u0004\u0018\u00010\u000bJ$\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ$\u0010c\u001a\u00060bR\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010d\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0018\u0010e\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0014J\b\u0010f\u001a\u00020\bH\u0014J\u0010\u0010g\u001a\u00020,2\u0006\u0010\u001c\u001a\u00020\bH\u0014R$\u0010L\u001a\u00020K2\u0006\u0010h\u001a\u00020K8\u0006@BX\u000e¢\u0006\f\n\u0004\bL\u0010i\u001a\u0004\bj\u0010kR$\u0010R\u001a\u00020Q2\u0006\u0010h\u001a\u00020Q8\u0006@BX\u000e¢\u0006\f\n\u0004\bR\u0010l\u001a\u0004\bm\u0010nR\u0014\u0010p\u001a\u00020o8\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010qR$\u0010T\u001a\u00020\u000b2\u0006\u0010h\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\bT\u0010r\u001a\u0004\bs\u0010tR\u0018\u0010V\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010rR\u0016\u0010X\u001a\u00020(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010uR$\u0010v\u001a\u00020N2\u0006\u0010h\u001a\u00020N8\u0006@BX\u000e¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR$\u0010Z\u001a\u00020(2\u0006\u0010h\u001a\u00020(8\u0006@BX\u000e¢\u0006\f\n\u0004\bZ\u0010u\u001a\u0004\bZ\u0010zR$\u0010\\\u001a\u00020(2\u0006\u0010h\u001a\u00020(8\u0006@BX\u000e¢\u0006\f\n\u0004\b\\\u0010u\u001a\u0004\b{\u0010zR\u0014\u0010?\u001a\u00020(8BX\u0004¢\u0006\u0006\u001a\u0004\b?\u0010z¨\u0006\u0001"}, d2 = {"Lcom/facebook/login/LoginManager;", "", "Lcom/facebook/internal/FragmentWrapper;", "fragment", "Lcom/facebook/GraphResponse;", "response", "", "resolveError", "Lcom/facebook/login/LoginClient$Request;", "createLoginRequestFromResponse", "", "", "permissions", "logInWithReadPermissions", "Lcom/facebook/login/LoginConfiguration;", "loginConfig", "loginWithConfiguration", "reauthorizeDataAccess", "logInWithPublishPermissions", "Landroidx/activity/result/d;", "activityResultRegistryOwner", "Lcom/facebook/CallbackManager;", "callbackManager", "logIn", "validateReadPermissions", "validatePublishPermissions", "Lcom/facebook/login/StartActivityDelegate;", "startActivityDelegate", "request", "startLogin", "Landroid/content/Context;", "context", "loginRequest", "logStartLogin", "Lcom/facebook/login/LoginClient$Result$Code;", "result", "", "resultExtras", "Ljava/lang/Exception;", "exception", "", "wasLoginActivityTried", "logCompleteLogin", "tryFacebookActivity", "Landroid/content/Intent;", "intent", "resolveIntent", "Lcom/facebook/AccessToken;", "newToken", "Lcom/facebook/AuthenticationToken;", "newIdToken", "origRequest", "Lcom/facebook/FacebookException;", "isCanceled", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "callback", "finishLogin", "Lcom/facebook/LoginStatusCallback;", "responseCallback", "", "toastDurationMs", "retrieveLoginStatusImpl", "isExpressLoginAllowed", "setExpressLoginStatus", "Landroid/app/Activity;", "activity", "Landroidx/fragment/app/Fragment;", "Landroid/app/Fragment;", "registerCallback", "unregisterCallback", "", "resultCode", "data", "onActivityResult", "Lcom/facebook/login/LoginBehavior;", "loginBehavior", "setLoginBehavior", "Lcom/facebook/login/LoginTargetApp;", "targetApp", "setLoginTargetApp", "Lcom/facebook/login/DefaultAudience;", "defaultAudience", "setDefaultAudience", "authType", "setAuthType", "messengerPageId", "setMessengerPageId", "resetMessengerState", "setResetMessengerState", "isFamilyLogin", "setFamilyLogin", "shouldSkipAccountDeduplication", "setShouldSkipAccountDeduplication", "logOut", "retrieveLoginStatus", "logInWithConfiguration", "loggerID", "Lcom/facebook/login/LoginManager$FacebookLoginActivityResultContract;", "createLogInActivityResultContract", "createLoginRequestWithConfig", "createLoginRequest", "createReauthorizeRequest", "getFacebookActivityIntent", "<set-?>", "Lcom/facebook/login/LoginBehavior;", "getLoginBehavior", "()Lcom/facebook/login/LoginBehavior;", "Lcom/facebook/login/DefaultAudience;", "getDefaultAudience", "()Lcom/facebook/login/DefaultAudience;", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", "Ljava/lang/String;", "getAuthType", "()Ljava/lang/String;", "Z", "loginTargetApp", "Lcom/facebook/login/LoginTargetApp;", "getLoginTargetApp", "()Lcom/facebook/login/LoginTargetApp;", "()Z", "getShouldSkipAccountDeduplication", "<init>", "()V", "Companion", "ActivityStartActivityDelegate", "AndroidxActivityResultRegistryOwnerStartActivityDelegate", "FacebookLoginActivityResultContract", "FragmentStartActivityDelegate", "LoginLoggerHolder", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public class LoginManager {
    public static final Companion Companion;
    private static final String EXPRESS_LOGIN_ALLOWED = "express_login_allowed";
    private static final String MANAGE_PERMISSION_PREFIX = "manage";
    /* access modifiers changed from: private */
    public static final Set<String> OTHER_PUBLISH_PERMISSIONS;
    private static final String PREFERENCE_LOGIN_MANAGER = "com.facebook.loginManager";
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";
    private static final String TAG;
    /* access modifiers changed from: private */
    public static volatile LoginManager instance;
    private String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
    private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
    private boolean isFamilyLogin;
    private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
    private LoginTargetApp loginTargetApp = LoginTargetApp.FACEBOOK;
    private String messengerPageId;
    private boolean resetMessengerState;
    private final SharedPreferences sharedPreferences;
    private boolean shouldSkipAccountDeduplication;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/facebook/login/LoginManager$ActivityStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityContext", "getActivityContext", "()Landroid/app/Activity;", "startActivityForResult", "", "intent", "Landroid/content/Intent;", "requestCode", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class ActivityStartActivityDelegate implements StartActivityDelegate {
        private final Activity activityContext;

        public ActivityStartActivityDelegate(Activity activity) {
            j.g(activity, "activity");
            this.activityContext = activity;
        }

        public Activity getActivityContext() {
            return this.activityContext;
        }

        public void startActivityForResult(Intent intent, int i10) {
            j.g(intent, SDKConstants.PARAM_INTENT);
            getActivityContext().startActivityForResult(intent, i10);
        }
    }

    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/facebook/login/LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "Landroid/content/Intent;", "intent", "", "requestCode", "", "startActivityForResult", "Landroidx/activity/result/d;", "activityResultRegistryOwner", "Landroidx/activity/result/d;", "Lcom/facebook/CallbackManager;", "callbackManager", "Lcom/facebook/CallbackManager;", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "activityContext", "<init>", "(Landroidx/activity/result/d;Lcom/facebook/CallbackManager;)V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    private static final class AndroidxActivityResultRegistryOwnerStartActivityDelegate implements StartActivityDelegate {
        private final d activityResultRegistryOwner;
        private final CallbackManager callbackManager;

        public AndroidxActivityResultRegistryOwnerStartActivityDelegate(d dVar, CallbackManager callbackManager2) {
            j.g(dVar, "activityResultRegistryOwner");
            j.g(callbackManager2, "callbackManager");
            this.activityResultRegistryOwner = dVar;
            this.callbackManager = callbackManager2;
        }

        /* access modifiers changed from: private */
        /* renamed from: startActivityForResult$lambda-0  reason: not valid java name */
        public static final void m166startActivityForResult$lambda0(AndroidxActivityResultRegistryOwnerStartActivityDelegate androidxActivityResultRegistryOwnerStartActivityDelegate, LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder, Pair pair) {
            j.g(androidxActivityResultRegistryOwnerStartActivityDelegate, "this$0");
            j.g(loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder, "$launcherHolder");
            CallbackManager callbackManager2 = androidxActivityResultRegistryOwnerStartActivityDelegate.callbackManager;
            int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            Object obj = pair.first;
            j.f(obj, "result.first");
            callbackManager2.onActivityResult(requestCode, ((Number) obj).intValue(), (Intent) pair.second);
            c<Intent> launcher = loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.getLauncher();
            if (launcher != null) {
                launcher.d();
            }
            loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.setLauncher((c<Intent>) null);
        }

        public Activity getActivityContext() {
            d dVar = this.activityResultRegistryOwner;
            if (dVar instanceof Activity) {
                return (Activity) dVar;
            }
            return null;
        }

        public void startActivityForResult(Intent intent, int i10) {
            j.g(intent, SDKConstants.PARAM_INTENT);
            LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder = new LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder();
            loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.setLauncher(this.activityResultRegistryOwner.getActivityResultRegistry().j("facebook-login", new LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$1(), new p(this, loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder)));
            c<Intent> launcher = loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.getLauncher();
            if (launcher != null) {
                launcher.b(intent);
            }
        }
    }

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J \u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\b\u0010\u001c\u001a\u00020\fH\u0017J2\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006)"}, d2 = {"Lcom/facebook/login/LoginManager$Companion;", "", "()V", "EXPRESS_LOGIN_ALLOWED", "", "MANAGE_PERMISSION_PREFIX", "OTHER_PUBLISH_PERMISSIONS", "", "PREFERENCE_LOGIN_MANAGER", "PUBLISH_PERMISSION_PREFIX", "TAG", "instance", "Lcom/facebook/login/LoginManager;", "otherPublishPermissions", "getOtherPublishPermissions", "()Ljava/util/Set;", "computeLoginResult", "Lcom/facebook/login/LoginResult;", "request", "Lcom/facebook/login/LoginClient$Request;", "newToken", "Lcom/facebook/AccessToken;", "newIdToken", "Lcom/facebook/AuthenticationToken;", "getExtraDataFromIntent", "", "intent", "Landroid/content/Intent;", "getInstance", "handleLoginStatusError", "", "errorType", "errorDescription", "loggerRef", "logger", "Lcom/facebook/login/LoginLogger;", "responseCallback", "Lcom/facebook/LoginStatusCallback;", "isPublishPermission", "", "permission", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Set<String> getOtherPublishPermissions() {
            return n0.i("ads_management", "create_event", "rsvp_event");
        }

        /* access modifiers changed from: private */
        public final void handleLoginStatusError(String str, String str2, String str3, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback) {
            FacebookException facebookException = new FacebookException(str + ": " + str2);
            loginLogger.logLoginStatusError(str3, facebookException);
            loginStatusCallback.onError(facebookException);
        }

        public final LoginResult computeLoginResult(LoginClient.Request request, AccessToken accessToken, AuthenticationToken authenticationToken) {
            j.g(request, "request");
            j.g(accessToken, "newToken");
            Set<String> permissions = request.getPermissions();
            Set A0 = CollectionsKt___CollectionsKt.A0(CollectionsKt___CollectionsKt.K(accessToken.getPermissions()));
            if (request.isRerequest()) {
                A0.retainAll(permissions);
            }
            Set A02 = CollectionsKt___CollectionsKt.A0(CollectionsKt___CollectionsKt.K(permissions));
            A02.removeAll(A0);
            return new LoginResult(accessToken, authenticationToken, A0, A02);
        }

        public final Map<String, String> getExtraDataFromIntent(Intent intent) {
            if (intent == null) {
                return null;
            }
            intent.setExtrasClassLoader(LoginClient.Result.class.getClassLoader());
            LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra(LoginFragment.RESULT_KEY);
            if (result == null) {
                return null;
            }
            return result.extraData;
        }

        public LoginManager getInstance() {
            if (LoginManager.instance == null) {
                synchronized (this) {
                    LoginManager.instance = new LoginManager();
                    Unit unit = Unit.f32013a;
                }
            }
            LoginManager access$getInstance$cp = LoginManager.instance;
            if (access$getInstance$cp != null) {
                return access$getInstance$cp;
            }
            j.y("instance");
            throw null;
        }

        public final boolean isPublishPermission(String str) {
            if (str == null) {
                return false;
            }
            if (r.J(str, LoginManager.PUBLISH_PERMISSION_PREFIX, false, 2, (Object) null) || r.J(str, LoginManager.MANAGE_PERMISSION_PREFIX, false, 2, (Object) null) || LoginManager.OTHER_PUBLISH_PERMISSIONS.contains(str)) {
                return true;
            }
            return false;
        }
    }

    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u001f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/facebook/login/LoginManager$FacebookLoginActivityResultContract;", "Lc/a;", "", "", "Lcom/facebook/CallbackManager$ActivityResultParameters;", "Landroid/content/Context;", "context", "permissions", "Landroid/content/Intent;", "createIntent", "", "resultCode", "intent", "parseResult", "Lcom/facebook/CallbackManager;", "callbackManager", "Lcom/facebook/CallbackManager;", "getCallbackManager", "()Lcom/facebook/CallbackManager;", "setCallbackManager", "(Lcom/facebook/CallbackManager;)V", "loggerID", "Ljava/lang/String;", "getLoggerID", "()Ljava/lang/String;", "setLoggerID", "(Ljava/lang/String;)V", "<init>", "(Lcom/facebook/login/LoginManager;Lcom/facebook/CallbackManager;Ljava/lang/String;)V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public final class FacebookLoginActivityResultContract extends a<Collection<? extends String>, CallbackManager.ActivityResultParameters> {
        private CallbackManager callbackManager;
        private String loggerID;

        public FacebookLoginActivityResultContract(LoginManager loginManager, CallbackManager callbackManager2, String str) {
            j.g(loginManager, "this$0");
            LoginManager.this = loginManager;
            this.callbackManager = callbackManager2;
            this.loggerID = str;
        }

        public final CallbackManager getCallbackManager() {
            return this.callbackManager;
        }

        public final String getLoggerID() {
            return this.loggerID;
        }

        public final void setCallbackManager(CallbackManager callbackManager2) {
            this.callbackManager = callbackManager2;
        }

        public final void setLoggerID(String str) {
            this.loggerID = str;
        }

        public Intent createIntent(Context context, Collection<String> collection) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            j.g(collection, "permissions");
            LoginClient.Request createLoginRequestWithConfig = LoginManager.this.createLoginRequestWithConfig(new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
            String str = this.loggerID;
            if (str != null) {
                createLoginRequestWithConfig.setAuthId(str);
            }
            LoginManager.this.logStartLogin(context, createLoginRequestWithConfig);
            Intent facebookActivityIntent = LoginManager.this.getFacebookActivityIntent(createLoginRequestWithConfig);
            if (LoginManager.this.resolveIntent(facebookActivityIntent)) {
                return facebookActivityIntent;
            }
            FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            LoginManager.this.logCompleteLogin(context, LoginClient.Result.Code.ERROR, (Map<String, String>) null, facebookException, false, createLoginRequestWithConfig);
            throw facebookException;
        }

        public CallbackManager.ActivityResultParameters parseResult(int i10, Intent intent) {
            LoginManager.onActivityResult$default(LoginManager.this, i10, intent, (FacebookCallback) null, 4, (Object) null);
            int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            CallbackManager callbackManager2 = this.callbackManager;
            if (callbackManager2 != null) {
                callbackManager2.onActivityResult(requestCode, i10, intent);
            }
            return new CallbackManager.ActivityResultParameters(requestCode, i10, intent);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FacebookLoginActivityResultContract(CallbackManager callbackManager2, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(LoginManager.this, (i10 & 1) != 0 ? null : callbackManager2, (i10 & 2) != 0 ? null : str);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/login/LoginManager$FragmentStartActivityDelegate;", "Lcom/facebook/login/StartActivityDelegate;", "fragment", "Lcom/facebook/internal/FragmentWrapper;", "(Lcom/facebook/internal/FragmentWrapper;)V", "activityContext", "Landroid/app/Activity;", "getActivityContext", "()Landroid/app/Activity;", "startActivityForResult", "", "intent", "Landroid/content/Intent;", "requestCode", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class FragmentStartActivityDelegate implements StartActivityDelegate {
        private final Activity activityContext;
        private final FragmentWrapper fragment;

        public FragmentStartActivityDelegate(FragmentWrapper fragmentWrapper) {
            j.g(fragmentWrapper, "fragment");
            this.fragment = fragmentWrapper;
            this.activityContext = fragmentWrapper.getActivity();
        }

        public Activity getActivityContext() {
            return this.activityContext;
        }

        public void startActivityForResult(Intent intent, int i10) {
            j.g(intent, SDKConstants.PARAM_INTENT);
            this.fragment.startActivityForResult(intent, i10);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/login/LoginManager$LoginLoggerHolder;", "", "()V", "logger", "Lcom/facebook/login/LoginLogger;", "getLogger", "context", "Landroid/content/Context;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class LoginLoggerHolder {
        public static final LoginLoggerHolder INSTANCE = new LoginLoggerHolder();
        private static LoginLogger logger;

        private LoginLoggerHolder() {
        }

        public final synchronized LoginLogger getLogger(Context context) {
            if (context == null) {
                context = FacebookSdk.getApplicationContext();
            }
            if (context == null) {
                return null;
            }
            if (logger == null) {
                logger = new LoginLogger(context, FacebookSdk.getApplicationId());
            }
            return logger;
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        OTHER_PUBLISH_PERMISSIONS = companion.getOtherPublishPermissions();
        String cls = LoginManager.class.toString();
        j.f(cls, "LoginManager::class.java.toString()");
        TAG = cls;
    }

    public LoginManager() {
        Validate.sdkInitialized();
        SharedPreferences sharedPreferences2 = FacebookSdk.getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, 0);
        j.f(sharedPreferences2, "getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences2;
        if (FacebookSdk.hasCustomTabsPrefetching && CustomTabUtils.getChromePackage() != null) {
            androidx.browser.customtabs.c.a(FacebookSdk.getApplicationContext(), "com.android.chrome", new CustomTabPrefetchHelper());
            androidx.browser.customtabs.c.b(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationContext().getPackageName());
        }
    }

    public static final LoginResult computeLoginResult(LoginClient.Request request, AccessToken accessToken, AuthenticationToken authenticationToken) {
        return Companion.computeLoginResult(request, accessToken, authenticationToken);
    }

    public static /* synthetic */ FacebookLoginActivityResultContract createLogInActivityResultContract$default(LoginManager loginManager, CallbackManager callbackManager, String str, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                callbackManager = null;
            }
            if ((i10 & 2) != 0) {
                str = null;
            }
            return loginManager.createLogInActivityResultContract(callbackManager, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLogInActivityResultContract");
    }

    private final LoginClient.Request createLoginRequestFromResponse(GraphResponse graphResponse) {
        Set<String> permissions;
        AccessToken accessToken = graphResponse.getRequest().getAccessToken();
        List list = null;
        if (!(accessToken == null || (permissions = accessToken.getPermissions()) == null)) {
            list = CollectionsKt___CollectionsKt.K(permissions);
        }
        return createLoginRequest(list);
    }

    private final void finishLogin(AccessToken accessToken, AuthenticationToken authenticationToken, LoginClient.Request request, FacebookException facebookException, boolean z10, FacebookCallback<LoginResult> facebookCallback) {
        LoginResult loginResult;
        if (accessToken != null) {
            AccessToken.Companion.setCurrentAccessToken(accessToken);
            Profile.Companion.fetchProfileForCurrentAccessToken();
        }
        if (authenticationToken != null) {
            AuthenticationToken.Companion.setCurrentAuthenticationToken(authenticationToken);
        }
        if (facebookCallback != null) {
            if (accessToken == null || request == null) {
                loginResult = null;
            } else {
                loginResult = Companion.computeLoginResult(request, accessToken, authenticationToken);
            }
            if (z10 || (loginResult != null && loginResult.getRecentlyGrantedPermissions().isEmpty())) {
                facebookCallback.onCancel();
            } else if (facebookException != null) {
                facebookCallback.onError(facebookException);
            } else if (accessToken != null && loginResult != null) {
                setExpressLoginStatus(true);
                facebookCallback.onSuccess(loginResult);
            }
        }
    }

    public static final Map<String, String> getExtraDataFromIntent(Intent intent) {
        return Companion.getExtraDataFromIntent(intent);
    }

    public static LoginManager getInstance() {
        return Companion.getInstance();
    }

    private final boolean isExpressLoginAllowed() {
        return this.sharedPreferences.getBoolean(EXPRESS_LOGIN_ALLOWED, true);
    }

    public static final boolean isPublishPermission(String str) {
        return Companion.isPublishPermission(str);
    }

    /* access modifiers changed from: private */
    public final void logCompleteLogin(Context context, LoginClient.Result.Code code, Map<String, String> map, Exception exc, boolean z10, LoginClient.Request request) {
        String str;
        String str2;
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger != null) {
            if (request == null) {
                LoginLogger.logUnexpectedError$default(logger, LoginLogger.EVENT_NAME_LOGIN_COMPLETE, "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", (String) null, 4, (Object) null);
                return;
            }
            HashMap hashMap = new HashMap();
            if (z10) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            } else {
                str = "0";
            }
            hashMap.put(LoginLogger.EVENT_EXTRAS_TRY_LOGIN_ACTIVITY, str);
            String authId = request.getAuthId();
            if (request.isFamilyLogin()) {
                str2 = LoginLogger.EVENT_NAME_FOA_LOGIN_COMPLETE;
            } else {
                str2 = LoginLogger.EVENT_NAME_LOGIN_COMPLETE;
            }
            logger.logCompleteLogin(authId, hashMap, code, map, exc, str2);
        }
    }

    /* access modifiers changed from: private */
    public final void logStartLogin(Context context, LoginClient.Request request) {
        String str;
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger != null && request != null) {
            if (request.isFamilyLogin()) {
                str = LoginLogger.EVENT_NAME_FOA_LOGIN_START;
            } else {
                str = LoginLogger.EVENT_NAME_LOGIN_START;
            }
            logger.logStartLogin(request, str);
        }
    }

    private final void loginWithConfiguration(FragmentWrapper fragmentWrapper, LoginConfiguration loginConfiguration) {
        logIn(fragmentWrapper, loginConfiguration);
    }

    public static /* synthetic */ boolean onActivityResult$default(LoginManager loginManager, int i10, Intent intent, FacebookCallback facebookCallback, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 4) != 0) {
                facebookCallback = null;
            }
            return loginManager.onActivityResult(i10, intent, facebookCallback);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onActivityResult");
    }

    /* access modifiers changed from: private */
    /* renamed from: registerCallback$lambda-0  reason: not valid java name */
    public static final boolean m163registerCallback$lambda0(LoginManager loginManager, FacebookCallback facebookCallback, int i10, Intent intent) {
        j.g(loginManager, "this$0");
        return loginManager.onActivityResult(i10, intent, facebookCallback);
    }

    /* access modifiers changed from: private */
    public final boolean resolveIntent(Intent intent) {
        return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    private final void retrieveLoginStatusImpl(Context context, LoginStatusCallback loginStatusCallback, long j10) {
        Context context2;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        j.f(uuid, "randomUUID().toString()");
        if (context == null) {
            context2 = FacebookSdk.getApplicationContext();
        } else {
            context2 = context;
        }
        LoginLogger loginLogger = new LoginLogger(context2, applicationId);
        if (!isExpressLoginAllowed()) {
            loginLogger.logLoginStatusFailure(uuid);
            loginStatusCallback.onFailure();
            return;
        }
        LoginStatusClient newInstance$facebook_common_release = LoginStatusClient.Companion.newInstance$facebook_common_release(context, applicationId, uuid, FacebookSdk.getGraphApiVersion(), j10, (String) null);
        newInstance$facebook_common_release.setCompletedListener(new n(uuid, loginLogger, loginStatusCallback, applicationId));
        loginLogger.logLoginStatusStart(uuid);
        if (!newInstance$facebook_common_release.start()) {
            loginLogger.logLoginStatusFailure(uuid);
            loginStatusCallback.onFailure();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: retrieveLoginStatusImpl$lambda-2  reason: not valid java name */
    public static final void m164retrieveLoginStatusImpl$lambda2(String str, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback, String str2, Bundle bundle) {
        boolean z10;
        boolean z11;
        boolean z12;
        String str3 = str;
        LoginLogger loginLogger2 = loginLogger;
        LoginStatusCallback loginStatusCallback2 = loginStatusCallback;
        Bundle bundle2 = bundle;
        j.g(str3, "$loggerRef");
        j.g(loginLogger2, "$logger");
        j.g(loginStatusCallback2, "$responseCallback");
        j.g(str2, "$applicationId");
        if (bundle2 != null) {
            String string = bundle2.getString(NativeProtocol.STATUS_ERROR_TYPE);
            String string2 = bundle2.getString(NativeProtocol.STATUS_ERROR_DESCRIPTION);
            if (string != null) {
                Companion.handleLoginStatusError(string, string2, str, loginLogger, loginStatusCallback);
                return;
            }
            String string3 = bundle2.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
            Utility utility = Utility.INSTANCE;
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle2, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0));
            ArrayList<String> stringArrayList = bundle2.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            String string4 = bundle2.getString(NativeProtocol.RESULT_ARGS_SIGNED_REQUEST);
            String string5 = bundle2.getString("graph_domain");
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle2, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0));
            String str4 = null;
            boolean z13 = false;
            if (string4 == null || string4.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                str4 = LoginMethodHandler.Companion.getUserIDFromSignedRequest(string4);
            }
            String str5 = str4;
            if (string3 == null || string3.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                if (stringArrayList == null || stringArrayList.isEmpty()) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12) {
                    if (str5 == null || str5.length() == 0) {
                        z13 = true;
                    }
                    if (!z13) {
                        AccessToken accessToken = new AccessToken(string3, str2, str5, stringArrayList, (Collection<String>) null, (Collection<String>) null, (AccessTokenSource) null, bundleLongAsDate, (Date) null, bundleLongAsDate2, string5);
                        AccessToken.Companion.setCurrentAccessToken(accessToken);
                        Profile.Companion.fetchProfileForCurrentAccessToken();
                        loginLogger2.logLoginStatusSuccess(str3);
                        loginStatusCallback2.onCompleted(accessToken);
                        return;
                    }
                }
            }
            loginLogger2.logLoginStatusFailure(str3);
            loginStatusCallback.onFailure();
            return;
        }
        loginLogger2.logLoginStatusFailure(str3);
        loginStatusCallback.onFailure();
    }

    private final void setExpressLoginStatus(boolean z10) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putBoolean(EXPRESS_LOGIN_ALLOWED, z10);
        edit.apply();
    }

    private final void startLogin(StartActivityDelegate startActivityDelegate, LoginClient.Request request) throws FacebookException {
        logStartLogin(startActivityDelegate.getActivityContext(), request);
        CallbackManagerImpl.Companion.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new o(this));
        if (!tryFacebookActivity(startActivityDelegate, request)) {
            FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            logCompleteLogin(startActivityDelegate.getActivityContext(), LoginClient.Result.Code.ERROR, (Map<String, String>) null, facebookException, false, request);
            throw facebookException;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startLogin$lambda-1  reason: not valid java name */
    public static final boolean m165startLogin$lambda1(LoginManager loginManager, int i10, Intent intent) {
        j.g(loginManager, "this$0");
        return onActivityResult$default(loginManager, i10, intent, (FacebookCallback) null, 4, (Object) null);
    }

    private final boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate, LoginClient.Request request) {
        Intent facebookActivityIntent = getFacebookActivityIntent(request);
        if (!resolveIntent(facebookActivityIntent)) {
            return false;
        }
        try {
            startActivityDelegate.startActivityForResult(facebookActivityIntent, LoginClient.Companion.getLoginRequestCode());
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private final void validatePublishPermissions(Collection<String> collection) {
        if (collection != null) {
            for (String next : collection) {
                if (!Companion.isPublishPermission(next)) {
                    throw new FacebookException("Cannot pass a read permission (" + next + ") to a request for publish authorization");
                }
            }
        }
    }

    private final void validateReadPermissions(Collection<String> collection) {
        if (collection != null) {
            for (String next : collection) {
                if (Companion.isPublishPermission(next)) {
                    throw new FacebookException("Cannot pass a publish or manage permission (" + next + ") to a request for read authorization");
                }
            }
        }
    }

    public final FacebookLoginActivityResultContract createLogInActivityResultContract() {
        return createLogInActivityResultContract$default(this, (CallbackManager) null, (String) null, 3, (Object) null);
    }

    public final FacebookLoginActivityResultContract createLogInActivityResultContract(CallbackManager callbackManager) {
        return createLogInActivityResultContract$default(this, callbackManager, (String) null, 2, (Object) null);
    }

    public final FacebookLoginActivityResultContract createLogInActivityResultContract(CallbackManager callbackManager, String str) {
        return new FacebookLoginActivityResultContract(this, callbackManager, str);
    }

    /* access modifiers changed from: protected */
    public LoginClient.Request createLoginRequest(Collection<String> collection) {
        Set set;
        LoginBehavior loginBehavior2 = this.loginBehavior;
        if (collection == null) {
            set = null;
        } else {
            set = CollectionsKt___CollectionsKt.B0(collection);
        }
        DefaultAudience defaultAudience2 = this.defaultAudience;
        String str = this.authType;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        j.f(uuid, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior2, set, defaultAudience2, str, applicationId, uuid, this.loginTargetApp, (String) null, (String) null, (String) null, (CodeChallengeMethod) null, 1920, (DefaultConstructorMarker) null);
        request.setRerequest(AccessToken.Companion.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    /* access modifiers changed from: protected */
    public LoginClient.Request createLoginRequestWithConfig(LoginConfiguration loginConfiguration) {
        String str;
        j.g(loginConfiguration, "loginConfig");
        CodeChallengeMethod codeChallengeMethod = CodeChallengeMethod.S256;
        try {
            PKCEUtil pKCEUtil = PKCEUtil.INSTANCE;
            str = PKCEUtil.generateCodeChallenge(loginConfiguration.getCodeVerifier(), codeChallengeMethod);
        } catch (FacebookException unused) {
            codeChallengeMethod = CodeChallengeMethod.PLAIN;
            str = loginConfiguration.getCodeVerifier();
        }
        LoginBehavior loginBehavior2 = this.loginBehavior;
        Set B0 = CollectionsKt___CollectionsKt.B0(loginConfiguration.getPermissions());
        DefaultAudience defaultAudience2 = this.defaultAudience;
        String str2 = this.authType;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        j.f(uuid, "randomUUID().toString()");
        LoginTargetApp loginTargetApp2 = this.loginTargetApp;
        String nonce = loginConfiguration.getNonce();
        String codeVerifier = loginConfiguration.getCodeVerifier();
        LoginClient.Request request = new LoginClient.Request(loginBehavior2, B0, defaultAudience2, str2, applicationId, uuid, loginTargetApp2, nonce, codeVerifier, str, codeChallengeMethod);
        request.setRerequest(AccessToken.Companion.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    /* access modifiers changed from: protected */
    public LoginClient.Request createReauthorizeRequest() {
        LoginBehavior loginBehavior2 = LoginBehavior.DIALOG_ONLY;
        HashSet hashSet = new HashSet();
        DefaultAudience defaultAudience2 = this.defaultAudience;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        j.f(uuid, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior2, hashSet, defaultAudience2, "reauthorize", applicationId, uuid, this.loginTargetApp, (String) null, (String) null, (String) null, (CodeChallengeMethod) null, 1920, (DefaultConstructorMarker) null);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    public final String getAuthType() {
        return this.authType;
    }

    public final DefaultAudience getDefaultAudience() {
        return this.defaultAudience;
    }

    /* access modifiers changed from: protected */
    public Intent getFacebookActivityIntent(LoginClient.Request request) {
        j.g(request, "request");
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(request.getLoginBehavior().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        intent.putExtra(LoginFragment.REQUEST_KEY, bundle);
        return intent;
    }

    public final LoginBehavior getLoginBehavior() {
        return this.loginBehavior;
    }

    public final LoginTargetApp getLoginTargetApp() {
        return this.loginTargetApp;
    }

    public final boolean getShouldSkipAccountDeduplication() {
        return this.shouldSkipAccountDeduplication;
    }

    public final boolean isFamilyLogin() {
        return this.isFamilyLogin;
    }

    public final void logIn(Fragment fragment, Collection<String> collection) {
        j.g(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection);
    }

    public final void logInWithConfiguration(Fragment fragment, LoginConfiguration loginConfiguration) {
        j.g(fragment, "fragment");
        j.g(loginConfiguration, "loginConfig");
        loginWithConfiguration(new FragmentWrapper(fragment), loginConfiguration);
    }

    public final void logInWithPublishPermissions(Fragment fragment, Collection<String> collection) {
        j.g(fragment, "fragment");
        j.g(collection, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), collection);
    }

    public final void logInWithReadPermissions(Fragment fragment, Collection<String> collection) {
        j.g(fragment, "fragment");
        j.g(collection, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), collection);
    }

    public void logOut() {
        AccessToken.Companion.setCurrentAccessToken((AccessToken) null);
        AuthenticationToken.Companion.setCurrentAuthenticationToken((AuthenticationToken) null);
        Profile.Companion.setCurrentProfile((Profile) null);
        setExpressLoginStatus(false);
    }

    public final boolean onActivityResult(int i10, Intent intent) {
        return onActivityResult$default(this, i10, intent, (FacebookCallback) null, 4, (Object) null);
    }

    public boolean onActivityResult(int i10, Intent intent, FacebookCallback<LoginResult> facebookCallback) {
        boolean z10;
        Map<String, String> map;
        LoginClient.Result.Code code;
        LoginClient.Request request;
        AuthenticationToken authenticationToken;
        AccessToken accessToken;
        AuthenticationToken authenticationToken2;
        int i11 = i10;
        Intent intent2 = intent;
        LoginClient.Result.Code code2 = LoginClient.Result.Code.ERROR;
        FacebookException facebookException = null;
        boolean z11 = false;
        if (intent2 != null) {
            intent2.setExtrasClassLoader(LoginClient.Result.class.getClassLoader());
            LoginClient.Result result = (LoginClient.Result) intent2.getParcelableExtra(LoginFragment.RESULT_KEY);
            if (result != null) {
                request = result.request;
                LoginClient.Result.Code code3 = result.code;
                if (i11 != -1) {
                    if (i11 == 0) {
                        z11 = true;
                    }
                    accessToken = null;
                    authenticationToken2 = null;
                } else if (code3 == LoginClient.Result.Code.SUCCESS) {
                    accessToken = result.token;
                    authenticationToken2 = result.authenticationToken;
                } else {
                    authenticationToken2 = null;
                    facebookException = new FacebookAuthorizationException(result.errorMessage);
                    accessToken = null;
                }
                map = result.loggingExtras;
                z10 = z11;
                authenticationToken = authenticationToken2;
                code = code3;
                if (facebookException == null && accessToken == null && !z10) {
                    facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
                }
                FacebookException facebookException2 = facebookException;
                LoginClient.Request request2 = request;
                logCompleteLogin((Context) null, code, map, facebookException2, true, request2);
                finishLogin(accessToken, authenticationToken, request2, facebookException2, z10, facebookCallback);
                return true;
            }
        } else if (i11 == 0) {
            code = LoginClient.Result.Code.CANCEL;
            z10 = true;
            accessToken = null;
            authenticationToken = null;
            request = null;
            map = null;
            facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
            FacebookException facebookException22 = facebookException;
            LoginClient.Request request22 = request;
            logCompleteLogin((Context) null, code, map, facebookException22, true, request22);
            finishLogin(accessToken, authenticationToken, request22, facebookException22, z10, facebookCallback);
            return true;
        }
        code = code2;
        accessToken = null;
        authenticationToken = null;
        request = null;
        map = null;
        z10 = false;
        facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        FacebookException facebookException222 = facebookException;
        LoginClient.Request request222 = request;
        logCompleteLogin((Context) null, code, map, facebookException222, true, request222);
        finishLogin(accessToken, authenticationToken, request222, facebookException222, z10, facebookCallback);
        return true;
    }

    public final void reauthorizeDataAccess(Activity activity) {
        j.g(activity, "activity");
        startLogin(new ActivityStartActivityDelegate(activity), createReauthorizeRequest());
    }

    public final void registerCallback(CallbackManager callbackManager, FacebookCallback<LoginResult> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new m(this, facebookCallback));
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public final void resolveError(Activity activity, GraphResponse graphResponse) {
        j.g(activity, "activity");
        j.g(graphResponse, "response");
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestFromResponse(graphResponse));
    }

    public final void retrieveLoginStatus(Context context, LoginStatusCallback loginStatusCallback) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(loginStatusCallback, "responseCallback");
        retrieveLoginStatus(context, 5000, loginStatusCallback);
    }

    public final LoginManager setAuthType(String str) {
        j.g(str, "authType");
        this.authType = str;
        return this;
    }

    public final LoginManager setDefaultAudience(DefaultAudience defaultAudience2) {
        j.g(defaultAudience2, "defaultAudience");
        this.defaultAudience = defaultAudience2;
        return this;
    }

    public final LoginManager setFamilyLogin(boolean z10) {
        this.isFamilyLogin = z10;
        return this;
    }

    public final LoginManager setLoginBehavior(LoginBehavior loginBehavior2) {
        j.g(loginBehavior2, "loginBehavior");
        this.loginBehavior = loginBehavior2;
        return this;
    }

    public final LoginManager setLoginTargetApp(LoginTargetApp loginTargetApp2) {
        j.g(loginTargetApp2, "targetApp");
        this.loginTargetApp = loginTargetApp2;
        return this;
    }

    public final LoginManager setMessengerPageId(String str) {
        this.messengerPageId = str;
        return this;
    }

    public final LoginManager setResetMessengerState(boolean z10) {
        this.resetMessengerState = z10;
        return this;
    }

    public final LoginManager setShouldSkipAccountDeduplication(boolean z10) {
        this.shouldSkipAccountDeduplication = z10;
        return this;
    }

    public final void unregisterCallback(CallbackManager callbackManager) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).unregisterCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode());
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public final void logIn(Fragment fragment, Collection<String> collection, String str) {
        j.g(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection, str);
    }

    public final void logInWithPublishPermissions(Fragment fragment, CallbackManager callbackManager, Collection<String> collection) {
        j.g(fragment, "fragment");
        j.g(callbackManager, "callbackManager");
        j.g(collection, "permissions");
        h activity = fragment.getActivity();
        if (activity != null) {
            logInWithPublishPermissions((d) activity, callbackManager, collection);
            return;
        }
        throw new FacebookException(j.p("Cannot obtain activity context on the fragment ", fragment));
    }

    public final void logInWithReadPermissions(Fragment fragment, CallbackManager callbackManager, Collection<String> collection) {
        j.g(fragment, "fragment");
        j.g(callbackManager, "callbackManager");
        j.g(collection, "permissions");
        h activity = fragment.getActivity();
        if (activity != null) {
            logInWithReadPermissions((d) activity, callbackManager, collection);
            return;
        }
        throw new FacebookException(j.p("Cannot obtain activity context on the fragment ", fragment));
    }

    public final void loginWithConfiguration(Activity activity, LoginConfiguration loginConfiguration) {
        j.g(activity, "activity");
        j.g(loginConfiguration, "loginConfig");
        logIn(activity, loginConfiguration);
    }

    public final void resolveError(Fragment fragment, GraphResponse graphResponse) {
        j.g(fragment, "fragment");
        j.g(graphResponse, "response");
        resolveError(new FragmentWrapper(fragment), graphResponse);
    }

    public final void retrieveLoginStatus(Context context, long j10, LoginStatusCallback loginStatusCallback) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(loginStatusCallback, "responseCallback");
        retrieveLoginStatusImpl(context, loginStatusCallback, j10);
    }

    public final void logIn(android.app.Fragment fragment, Collection<String> collection) {
        j.g(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection);
    }

    public final void reauthorizeDataAccess(Fragment fragment) {
        j.g(fragment, "fragment");
        reauthorizeDataAccess(new FragmentWrapper(fragment));
    }

    public final void resolveError(Fragment fragment, CallbackManager callbackManager, GraphResponse graphResponse) {
        j.g(fragment, "fragment");
        j.g(callbackManager, "callbackManager");
        j.g(graphResponse, "response");
        h activity = fragment.getActivity();
        if (activity != null) {
            resolveError((d) activity, callbackManager, graphResponse);
            return;
        }
        throw new FacebookException(j.p("Cannot obtain activity context on the fragment ", fragment));
    }

    private final void reauthorizeDataAccess(FragmentWrapper fragmentWrapper) {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createReauthorizeRequest());
    }

    public final void logIn(android.app.Fragment fragment, Collection<String> collection, String str) {
        j.g(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection, str);
    }

    public final void logIn(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        j.g(fragmentWrapper, "fragment");
        logIn(fragmentWrapper, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logInWithPublishPermissions(android.app.Fragment fragment, Collection<String> collection) {
        j.g(fragment, "fragment");
        j.g(collection, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), collection);
    }

    public final void logInWithReadPermissions(android.app.Fragment fragment, Collection<String> collection) {
        j.g(fragment, "fragment");
        j.g(collection, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), collection);
    }

    private final void logInWithPublishPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        validatePublishPermissions(collection);
        loginWithConfiguration(fragmentWrapper, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    private final void logInWithReadPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        validateReadPermissions(collection);
        logIn(fragmentWrapper, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void resolveError(android.app.Fragment fragment, GraphResponse graphResponse) {
        j.g(fragment, "fragment");
        j.g(graphResponse, "response");
        resolveError(new FragmentWrapper(fragment), graphResponse);
    }

    private final void resolveError(FragmentWrapper fragmentWrapper, GraphResponse graphResponse) {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestFromResponse(graphResponse));
    }

    public final void logIn(FragmentWrapper fragmentWrapper, Collection<String> collection, String str) {
        j.g(fragmentWrapper, "fragment");
        LoginClient.Request createLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
        if (str != null) {
            createLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestWithConfig);
    }

    public final void resolveError(d dVar, CallbackManager callbackManager, GraphResponse graphResponse) {
        j.g(dVar, "activityResultRegistryOwner");
        j.g(callbackManager, "callbackManager");
        j.g(graphResponse, "response");
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(dVar, callbackManager), createLoginRequestFromResponse(graphResponse));
    }

    public final void logInWithPublishPermissions(Activity activity, Collection<String> collection) {
        j.g(activity, "activity");
        validatePublishPermissions(collection);
        loginWithConfiguration(activity, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logInWithReadPermissions(Activity activity, Collection<String> collection) {
        j.g(activity, "activity");
        validateReadPermissions(collection);
        logIn(activity, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logIn(Activity activity, Collection<String> collection) {
        j.g(activity, "activity");
        logIn(activity, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logInWithPublishPermissions(d dVar, CallbackManager callbackManager, Collection<String> collection) {
        j.g(dVar, "activityResultRegistryOwner");
        j.g(callbackManager, "callbackManager");
        j.g(collection, "permissions");
        validatePublishPermissions(collection);
        logIn(dVar, callbackManager, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logInWithReadPermissions(d dVar, CallbackManager callbackManager, Collection<String> collection) {
        j.g(dVar, "activityResultRegistryOwner");
        j.g(callbackManager, "callbackManager");
        j.g(collection, "permissions");
        validateReadPermissions(collection);
        logIn(dVar, callbackManager, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }

    public final void logIn(FragmentWrapper fragmentWrapper, LoginConfiguration loginConfiguration) {
        j.g(fragmentWrapper, "fragment");
        j.g(loginConfiguration, "loginConfig");
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestWithConfig(loginConfiguration));
    }

    public final void logIn(Activity activity, LoginConfiguration loginConfiguration) {
        j.g(activity, "activity");
        j.g(loginConfiguration, "loginConfig");
        boolean z10 = activity instanceof d;
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestWithConfig(loginConfiguration));
    }

    public final void logIn(Activity activity, Collection<String> collection, String str) {
        j.g(activity, "activity");
        LoginClient.Request createLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
        if (str != null) {
            createLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestWithConfig);
    }

    private final void logIn(d dVar, CallbackManager callbackManager, LoginConfiguration loginConfiguration) {
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(dVar, callbackManager), createLoginRequestWithConfig(loginConfiguration));
    }

    public final void logIn(d dVar, CallbackManager callbackManager, Collection<String> collection, String str) {
        j.g(dVar, "activityResultRegistryOwner");
        j.g(callbackManager, "callbackManager");
        j.g(collection, "permissions");
        LoginClient.Request createLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
        if (str != null) {
            createLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(dVar, callbackManager), createLoginRequestWithConfig);
    }

    public final void logIn(d dVar, CallbackManager callbackManager, Collection<String> collection) {
        j.g(dVar, "activityResultRegistryOwner");
        j.g(callbackManager, "callbackManager");
        j.g(collection, "permissions");
        logIn(dVar, callbackManager, new LoginConfiguration(collection, (String) null, 2, (DefaultConstructorMarker) null));
    }
}

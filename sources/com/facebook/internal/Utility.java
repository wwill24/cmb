package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mparticle.identity.IdentityHttpResponse;
import com.mparticle.kits.AppsFlyerKit;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import kotlin.text.Regex;
import kotlin.text.d;
import org.json.JSONException;
import org.json.a;
import org.json.b;
import org.json.h;

@Metadata(bv = {}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002Ò\u0001B\u000b\b\u0002¢\u0006\u0006\bÑ\u0001\u0010Ì\u0001J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u001e\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\rH\u0002J&\u0010\u001a\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0007J$\u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0007J,\u0010#\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010!H\u0007J$\u0010%\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0019H\u0007J$\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0007J\u0012\u0010*\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010(H\u0007J\u0012\u0010-\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010+H\u0007J\u0012\u00100\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010.H\u0007J\u001c\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001032\u0006\u00102\u001a\u000201H\u0007J\u001c\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006032\u0006\u00102\u001a\u000201H\u0007J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\u00060!2\u0006\u00107\u001a\u000206H\u0007J&\u0010:\u001a\u0004\u0018\u00010\u00012\u0006\u00102\u001a\u0002012\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u00109\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010=\u001a\u00020\u00062\b\u0010<\u001a\u0004\u0018\u00010;H\u0007J\u001a\u0010A\u001a\u00020@2\b\u0010<\u001a\u0004\u0018\u00010;2\u0006\u0010?\u001a\u00020>H\u0007J\u001c\u0010C\u001a\u00020\u00042\b\u0010B\u001a\u0004\u0018\u00010\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010E\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020.2\u0006\u0010D\u001a\u00020\u0006H\u0002J\u0010\u0010F\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020.H\u0007J\"\u0010K\u001a\u00020\u001f2\b\u0010G\u001a\u0004\u0018\u00010\u00062\u000e\u0010J\u001a\n\u0018\u00010Hj\u0004\u0018\u0001`IH\u0007J\u001c\u0010K\u001a\u00020\u001f2\b\u0010G\u001a\u0004\u0018\u00010\u00062\b\u0010L\u001a\u0004\u0018\u00010\u0006H\u0007J&\u0010K\u001a\u00020\u001f2\b\u0010G\u001a\u0004\u0018\u00010\u00062\b\u0010L\u001a\u0004\u0018\u00010\u00062\b\u0010N\u001a\u0004\u0018\u00010MH\u0007J)\u0010P\u001a\u00020\u0004\"\u0004\b\u0000\u0010O2\b\u0010B\u001a\u0004\u0018\u00018\u00002\b\u0010\u001d\u001a\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\bP\u0010QJ\u001c\u0010T\u001a\u00020\u00062\b\u0010R\u001a\u0004\u0018\u0001012\b\u0010S\u001a\u0004\u0018\u00010\u0006H\u0007J\u001e\u0010V\u001a\u0004\u0018\u0001012\b\u0010R\u001a\u0004\u0018\u0001012\b\u0010U\u001a\u0004\u0018\u00010\u0006H\u0007J\u001e\u0010W\u001a\u0004\u0018\u0001062\b\u0010R\u001a\u0004\u0018\u0001012\b\u0010U\u001a\u0004\u0018\u00010\u0006H\u0007J\u0016\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00060!2\u0006\u00107\u001a\u000206H\u0007J\u0016\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00060Y2\u0006\u00107\u001a\u000206H\u0007J \u0010\\\u001a\u00020\u00062\u0016\u0010[\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000603H\u0007J\u001c\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006032\u0006\u0010]\u001a\u00020\u0006H\u0007J4\u0010d\u001a\u00020\u001f2\u0006\u0010_\u001a\u0002012\b\u0010a\u001a\u0004\u0018\u00010`2\b\u0010b\u001a\u0004\u0018\u00010\u00062\u0006\u0010c\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0007J\n\u0010e\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010g\u001a\u00020\u001f2\u0006\u0010_\u001a\u0002012\u0006\u0010f\u001a\u00020.H\u0007JE\u0010n\u001a\u0004\u0018\u00010m2\n\u0010i\u001a\u0006\u0012\u0002\b\u00030h2\u0006\u0010j\u001a\u00020\u00062\u001e\u0010l\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010h0k\"\b\u0012\u0002\b\u0003\u0018\u00010hH\u0007¢\u0006\u0004\bn\u0010oJA\u0010n\u001a\u0004\u0018\u00010m2\u0006\u0010p\u001a\u00020\u00062\u0006\u0010j\u001a\u00020\u00062\u001e\u0010l\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010h0k\"\b\u0012\u0002\b\u0003\u0018\u00010hH\u0007¢\u0006\u0004\bn\u0010qJ;\u0010u\u001a\u0004\u0018\u00010\u00012\b\u0010r\u001a\u0004\u0018\u00010\u00012\u0006\u0010s\u001a\u00020m2\u0016\u0010t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010k\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\bu\u0010vJ\u0012\u0010w\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010.H\u0007J\u0014\u0010x\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0019H\u0007J\u0012\u0010y\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0019H\u0007J\u0012\u0010z\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0019H\u0007J\u0012\u0010{\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0019H\u0007J\u0010\u0010~\u001a\u00020}2\u0006\u0010|\u001a\u00020\u0019H\u0007J(\u0010\u0001\u001a\u0004\u0018\u000102\b\u0010&\u001a\u0004\u0018\u00010\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0001\u001a\u00020H\u0007J-\u0010\u0001\u001a\u00020\u001f2\b\u0010\u0001\u001a\u00030\u00012\u0018\u0010[\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u000103H\u0007J%\u0010\u0001\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001032\b\u0010\u0001\u001a\u00030\u0001H\u0007J)\u0010\u0001\u001a\u00020\u001f2\b\u0010\u0001\u001a\u00030\u00012\u0014\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u000103H\u0007J!\u0010\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001032\b\u0010\u0001\u001a\u00030\u0001H\u0007J\u0015\u0010\u0001\u001a\u00020\u00042\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\u0014\u0010\u0001\u001a\u00020\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\u0006H\u0007J\u001c\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020\u00062\b\u0010\u0001\u001a\u00030\u0001H\u0007J\u0014\u0010\u0001\u001a\u0004\u0018\u0001012\u0007\u0010\u0001\u001a\u00020\u0006H\u0007J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0006H\u0002J\u0014\u0010\u0001\u001a\u00020\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\u000b\u0010\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\t\u0010\u0001\u001a\u00020@H\u0002J\u0011\u0010\u0001\u001a\u00020\u001f2\u0006\u0010f\u001a\u00020.H\u0002J\t\u0010\u0001\u001a\u00020\u001fH\u0002J\u0011\u0010\u0001\u001a\u00020\u001f2\u0006\u0010f\u001a\u00020.H\u0002J\t\u0010\u0001\u001a\u00020\u0004H\u0002J\t\u0010\u0001\u001a\u00020\u001fH\u0002J\t\u0010\u0001\u001a\u00020\u001fH\u0002J\u0012\u0010\u0001\u001a\u00020}2\u0007\u0010\u000e\u001a\u00030\u0001H\u0002J+\u0010 \u0001\u001a\u00020\u001f2\u0006\u0010_\u001a\u0002012\u0006\u0010a\u001a\u00020`2\b\u0010b\u001a\u0004\u0018\u00010\u00062\u0006\u0010/\u001a\u00020.H\u0002J!\u0010¡\u0001\u001a\u00020\u001f2\u0006\u0010_\u001a\u0002012\u0006\u0010a\u001a\u00020`2\u0006\u0010/\u001a\u00020.H\u0002J\u0011\u0010¢\u0001\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0002J\u0012\u0010¤\u0001\u001a\u00020\u00062\u0007\u0010£\u0001\u001a\u00020@H\u0007J\u0011\u0010¥\u0001\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0007J\u0011\u0010¦\u0001\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0007J\u0011\u0010§\u0001\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0007J\u0015\u0010ª\u0001\u001a\u00020\u001f2\n\u0010©\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0007J\u0011\u0010«\u0001\u001a\u00020\u00062\u0006\u0010/\u001a\u00020.H\u0007R\u0017\u0010¬\u0001\u001a\u00020\u00068\u0006XT¢\u0006\b\n\u0006\b¬\u0001\u0010­\u0001R\u0017\u0010®\u0001\u001a\u00020\u00068\u0002XT¢\u0006\b\n\u0006\b®\u0001\u0010­\u0001R\u0017\u0010¯\u0001\u001a\u00020\u00068\u0002XT¢\u0006\b\n\u0006\b¯\u0001\u0010­\u0001R\u0017\u0010°\u0001\u001a\u00020\u00068\u0002XT¢\u0006\b\n\u0006\b°\u0001\u0010­\u0001R\u0017\u0010±\u0001\u001a\u00020\u00068\u0002XT¢\u0006\b\n\u0006\b±\u0001\u0010­\u0001R\u0017\u0010²\u0001\u001a\u00020\u00068\u0002XT¢\u0006\b\n\u0006\b²\u0001\u0010­\u0001R\u0017\u0010³\u0001\u001a\u00020\u00068\u0002XT¢\u0006\b\n\u0006\b³\u0001\u0010­\u0001R\u0017\u0010´\u0001\u001a\u00020@8\u0006XT¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u0017\u0010¶\u0001\u001a\u00020@8\u0002XT¢\u0006\b\n\u0006\b¶\u0001\u0010µ\u0001R\u0017\u0010·\u0001\u001a\u00020\u00068\u0002XT¢\u0006\b\n\u0006\b·\u0001\u0010­\u0001R\u0019\u0010¸\u0001\u001a\u00020@8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010µ\u0001R\u0019\u0010¹\u0001\u001a\u00020}8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u0019\u0010»\u0001\u001a\u00020}8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b»\u0001\u0010º\u0001R\u0019\u0010¼\u0001\u001a\u00020}8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010º\u0001R\u0019\u0010½\u0001\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b½\u0001\u0010­\u0001R\u0019\u0010¾\u0001\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010­\u0001R\u0019\u0010¿\u0001\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010­\u0001R\u0017\u0010À\u0001\u001a\u00020\u00068\u0002XT¢\u0006\b\n\u0006\bÀ\u0001\u0010­\u0001R\u0017\u0010Á\u0001\u001a\u00020\u00068\u0002XT¢\u0006\b\n\u0006\bÁ\u0001\u0010­\u0001R\u0017\u0010Â\u0001\u001a\u00020\u00068\u0002XT¢\u0006\b\n\u0006\bÂ\u0001\u0010­\u0001R\u0017\u0010Æ\u0001\u001a\u0005\u0018\u00010Ã\u00018G¢\u0006\b\u001a\u0006\bÄ\u0001\u0010Å\u0001R\u0015\u0010È\u0001\u001a\u00030Ã\u00018G¢\u0006\b\u001a\u0006\bÇ\u0001\u0010Å\u0001R\u001f\u0010É\u0001\u001a\u00020\u00048FX\u0004¢\u0006\u0010\u0012\u0006\bË\u0001\u0010Ì\u0001\u001a\u0006\bÉ\u0001\u0010Ê\u0001R\u0016\u0010Ï\u0001\u001a\u0004\u0018\u0001018G¢\u0006\b\u001a\u0006\bÍ\u0001\u0010Î\u0001R\u0014\u0010Ð\u0001\u001a\u00020\u00048G¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Ê\u0001¨\u0006Ó\u0001"}, d2 = {"Lcom/facebook/internal/Utility;", "", "", "c", "", "isNullOrEmpty", "", "s", "valueIfNullOrEmpty", "coerceValueIfNullOrEmpty", "key", "md5hash", "sha1hash", "", "bytes", "sha256hash", "algorithm", "hashWithAlgorithm", "Ljava/security/MessageDigest;", "hash", "hashBytes", "authority", "path", "Landroid/os/Bundle;", "parameters", "Landroid/net/Uri;", "buildUri", "queryString", "parseUrlQueryString", "b", "value", "", "putNonEmptyString", "", "list", "putCommaSeparatedStringList", "uri", "putUri", "bundle", "putJSONValueInBundle", "Ljava/io/Closeable;", "closeable", "closeQuietly", "Ljava/net/URLConnection;", "connection", "disconnectQuietly", "Landroid/content/Context;", "context", "getMetadataApplicationId", "Lorg/json/b;", "jsonObject", "", "convertJSONObjectToHashMap", "convertJSONObjectToStringMap", "Lorg/json/a;", "jsonArray", "convertJSONArrayToList", "nonJSONPropertyKey", "getStringPropertyAsJSON", "Ljava/io/InputStream;", "inputStream", "readStreamToString", "Ljava/io/OutputStream;", "outputStream", "", "copyAndCloseInputStream", "a", "stringsEqualOrEmpty", "domain", "clearCookiesForDomain", "clearFacebookCookies", "tag", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "logd", "msg", "", "t", "T", "areObjectsEqual", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "response", "propertyName", "safeGetStringFromResponse", "propertyKey", "tryGetJSONObjectFromResponse", "tryGetJSONArrayFromResponse", "jsonArrayToStringList", "", "jsonArrayToSet", "map", "mapToJsonStr", "str", "jsonStrToMap", "params", "Lcom/facebook/internal/AttributionIdentifiers;", "attributionIdentifiers", "anonymousAppDeviceGUID", "limitEventUsage", "setAppEventAttributionParameters", "getAppVersion", "appContext", "setAppEventExtendedDeviceInfoParameters", "Ljava/lang/Class;", "clazz", "methodName", "", "parameterTypes", "Ljava/lang/reflect/Method;", "getMethodQuietly", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "className", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "receiver", "method", "args", "invokeMethodQuietly", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "getActivityName", "getUriString", "isWebUri", "isContentUri", "isFileUri", "contentUri", "", "getContentSize", "Ljava/util/Date;", "dateBase", "getBundleLongAsDate", "Landroid/os/Parcel;", "parcel", "writeStringMapToParcel", "readStringMapFromParcel", "writeNonnullStringMapToParcel", "readNonnullStringMapFromParcel", "Lcom/facebook/AccessToken;", "token", "isCurrentAccessToken", "tokenGraphDomain", "getGraphDomainFromTokenDomain", "accessToken", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "callback", "getGraphMeRequestWithCacheAsync", "awaitGetGraphMeRequestWithCache", "Lcom/facebook/GraphRequest;", "getGraphMeRequestWithCache", "graphDomain", "getProfileFieldsForGraphDomain", "getCurrentTokenDomainWithDefault", "refreshBestGuessNumberOfCPUCores", "refreshPeriodicExtendedDeviceInfo", "refreshTimezone", "refreshCarrierName", "externalStorageExists", "refreshAvailableExternalStorage", "refreshTotalExternalStorage", "", "convertBytesToGB", "appendAnonIdUnderCompliance", "appendAttributionIdUnderCompliance", "isGooglePlayServicesAvailable", "length", "generateRandomString", "mustFixWindowParamsForAutofill", "isAutofillAvailable", "isChromeOS", "Ljava/lang/Runnable;", "runnable", "runOnNonUiThread", "getAppName", "LOG_TAG", "Ljava/lang/String;", "HASH_ALGORITHM_MD5", "HASH_ALGORITHM_SHA1", "HASH_ALGORITHM_SHA256", "URL_SCHEME", "EXTRA_APP_EVENTS_INFO_FORMAT_VERSION", "UTF8", "DEFAULT_STREAM_BUFFER_SIZE", "I", "REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS", "NO_CARRIER", "numCPUCores", "timestampOfLastCheck", "J", "totalExternalStorageGB", "availableExternalStorageGB", "deviceTimezoneAbbreviation", "deviceTimeZoneName", "carrierName", "ARC_DEVICE_PATTERN", "FACEBOOK_PROFILE_FIELDS", "INSTAGRAM_PROFILE_FIELDS", "Ljava/util/Locale;", "getResourceLocale", "()Ljava/util/Locale;", "resourceLocale", "getCurrentLocale", "currentLocale", "isAutoAppLinkSetup", "()Z", "isAutoAppLinkSetup$annotations", "()V", "getDataProcessingOptions", "()Lorg/json/b;", "dataProcessingOptions", "isDataProcessingRestricted", "<init>", "GraphMeRequestWithCacheCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class Utility {
    private static final String ARC_DEVICE_PATTERN = ".+_cheets|cheets_.+";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
    private static final String FACEBOOK_PROFILE_FIELDS = "id,name,first_name,middle_name,last_name";
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    private static final String HASH_ALGORITHM_SHA256 = "SHA-256";
    private static final String INSTAGRAM_PROFILE_FIELDS = "id,name,profile_picture";
    public static final Utility INSTANCE = new Utility();
    public static final String LOG_TAG = "FacebookSDK";
    private static final String NO_CARRIER = "NoCarrier";
    private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
    private static final String URL_SCHEME = "https";
    private static final String UTF8 = "UTF-8";
    private static long availableExternalStorageGB = -1;
    private static String carrierName = NO_CARRIER;
    private static String deviceTimeZoneName = "";
    private static String deviceTimezoneAbbreviation = "";
    private static int numCPUCores;
    private static long timestampOfLastCheck = -1;
    private static long totalExternalStorageGB = -1;

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\t"}, d2 = {"Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "", "Lorg/json/b;", "userInfo", "", "onSuccess", "Lcom/facebook/FacebookException;", "error", "onFailure", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface GraphMeRequestWithCacheCallback {
        void onFailure(FacebookException facebookException);

        void onSuccess(b bVar);
    }

    private Utility() {
    }

    private final void appendAnonIdUnderCompliance(b bVar, AttributionIdentifiers attributionIdentifiers, String str, Context context) {
        if (Build.VERSION.SDK_INT < 31 || !isGooglePlayServicesAvailable(context)) {
            bVar.put("anon_id", (Object) str);
        } else if (!attributionIdentifiers.isTrackingLimited()) {
            bVar.put("anon_id", (Object) str);
        }
    }

    private final void appendAttributionIdUnderCompliance(b bVar, AttributionIdentifiers attributionIdentifiers, Context context) {
        if (Build.VERSION.SDK_INT < 31 || !isGooglePlayServicesAvailable(context)) {
            bVar.put("attribution", (Object) attributionIdentifiers.getAttributionId());
        } else if (!attributionIdentifiers.isTrackingLimited()) {
            bVar.put("attribution", (Object) attributionIdentifiers.getAttributionId());
        }
    }

    public static final <T> boolean areObjectsEqual(T t10, T t11) {
        return t10 == null ? t11 == null : j.b(t10, t11);
    }

    public static final b awaitGetGraphMeRequestWithCache(String str) {
        j.g(str, SDKConstants.PARAM_ACCESS_TOKEN);
        b profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            return profileInformation;
        }
        GraphResponse executeAndWait = INSTANCE.getGraphMeRequestWithCache(str).executeAndWait();
        if (executeAndWait.getError() != null) {
            return null;
        }
        return executeAndWait.getJsonObject();
    }

    public static final Uri buildUri(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                if (obj instanceof String) {
                    builder.appendQueryParameter(next, (String) obj);
                }
            }
        }
        Uri build = builder.build();
        j.f(build, "builder.build()");
        return build;
    }

    private final void clearCookiesForDomain(Context context, String str) {
        int i10;
        boolean z10;
        CookieSyncManager.createInstance(context).sync();
        CookieManager instance = CookieManager.getInstance();
        String cookie = instance.getCookie(str);
        if (cookie != null) {
            Object[] array2 = StringsKt__StringsKt.C0(cookie, new String[]{";"}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array2 != null) {
                String[] strArr = (String[]) array2;
                int length = strArr.length;
                int i11 = 0;
                while (i11 < length) {
                    String str2 = strArr[i11];
                    i11++;
                    Object[] array3 = StringsKt__StringsKt.C0(str2, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                    if (array3 != null) {
                        String[] strArr2 = (String[]) array3;
                        if (strArr2.length > 0) {
                            String str3 = strArr2[0];
                            int length2 = str3.length() - 1;
                            int i12 = 0;
                            boolean z11 = false;
                            while (i12 <= length2) {
                                if (!z11) {
                                    i10 = i12;
                                } else {
                                    i10 = length2;
                                }
                                if (j.i(str3.charAt(i10), 32) <= 0) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                if (!z11) {
                                    if (!z10) {
                                        z11 = true;
                                    } else {
                                        i12++;
                                    }
                                } else if (!z10) {
                                    break;
                                } else {
                                    length2--;
                                }
                            }
                            instance.setCookie(str, j.p(str3.subSequence(i12, length2 + 1).toString(), "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;"));
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                instance.removeExpiredCookie();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public static final void clearFacebookCookies(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        try {
            Utility utility = INSTANCE;
            utility.clearCookiesForDomain(context, "facebook.com");
            utility.clearCookiesForDomain(context, ".facebook.com");
            utility.clearCookiesForDomain(context, "https://facebook.com");
            utility.clearCookiesForDomain(context, "https://.facebook.com");
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final String coerceValueIfNullOrEmpty(String str, String str2) {
        return isNullOrEmpty(str) ? str2 : str;
    }

    private final long convertBytesToGB(double d10) {
        return Math.round(d10 / 1.073741824E9d);
    }

    public static final List<String> convertJSONArrayToList(a aVar) {
        j.g(aVar, "jsonArray");
        try {
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            int o10 = aVar.o();
            if (o10 <= 0) {
                return arrayList;
            }
            while (true) {
                int i11 = i10 + 1;
                String n10 = aVar.n(i10);
                j.f(n10, "jsonArray.getString(i)");
                arrayList.add(n10);
                if (i11 >= o10) {
                    return arrayList;
                }
                i10 = i11;
            }
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    public static final Map<String, Object> convertJSONObjectToHashMap(b bVar) {
        j.g(bVar, "jsonObject");
        HashMap hashMap = new HashMap();
        a names = bVar.names();
        if (names == null) {
            return hashMap;
        }
        int i10 = 0;
        int o10 = names.o();
        if (o10 > 0) {
            while (true) {
                int i11 = i10 + 1;
                try {
                    String n10 = names.n(i10);
                    j.f(n10, "keys.getString(i)");
                    Object obj = bVar.get(n10);
                    if (obj instanceof b) {
                        obj = convertJSONObjectToHashMap((b) obj);
                    }
                    j.f(obj, "value");
                    hashMap.put(n10, obj);
                } catch (JSONException unused) {
                }
                if (i11 >= o10) {
                    break;
                }
                i10 = i11;
            }
        }
        return hashMap;
    }

    public static final Map<String, String> convertJSONObjectToStringMap(b bVar) {
        j.g(bVar, "jsonObject");
        HashMap hashMap = new HashMap();
        Iterator<String> keys = bVar.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = bVar.optString(next);
            if (optString != null) {
                j.f(next, SDKConstants.PARAM_KEY);
                hashMap.put(next, optString);
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int copyAndCloseInputStream(java.io.InputStream r6, java.io.OutputStream r7) throws java.io.IOException {
        /*
            java.lang.String r0 = "outputStream"
            kotlin.jvm.internal.j.g(r7, r0)
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ all -> 0x002a }
            r1.<init>(r6)     // Catch:{ all -> 0x002a }
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0027 }
            r2 = 0
            r3 = r2
        L_0x0011:
            int r4 = r1.read(r0)     // Catch:{ all -> 0x0027 }
            r5 = -1
            if (r4 == r5) goto L_0x001d
            r7.write(r0, r2, r4)     // Catch:{ all -> 0x0027 }
            int r3 = r3 + r4
            goto L_0x0011
        L_0x001d:
            r1.close()
            if (r6 != 0) goto L_0x0023
            goto L_0x0026
        L_0x0023:
            r6.close()
        L_0x0026:
            return r3
        L_0x0027:
            r7 = move-exception
            r0 = r1
            goto L_0x002b
        L_0x002a:
            r7 = move-exception
        L_0x002b:
            if (r0 != 0) goto L_0x002e
            goto L_0x0031
        L_0x002e:
            r0.close()
        L_0x0031:
            if (r6 != 0) goto L_0x0034
            goto L_0x0037
        L_0x0034:
            r6.close()
        L_0x0037:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.Utility.copyAndCloseInputStream(java.io.InputStream, java.io.OutputStream):int");
    }

    public static final void disconnectQuietly(URLConnection uRLConnection) {
        if (uRLConnection != null && (uRLConnection instanceof HttpURLConnection)) {
            ((HttpURLConnection) uRLConnection).disconnect();
        }
    }

    private final boolean externalStorageExists() {
        return j.b("mounted", Environment.getExternalStorageState());
    }

    public static final String generateRandomString(int i10) {
        String bigInteger = new BigInteger(i10 * 5, new Random()).toString(32);
        j.f(bigInteger, "BigInteger(length * 5, r).toString(32)");
        return bigInteger;
    }

    public static final String getActivityName(Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        String simpleName = context.getClass().getSimpleName();
        j.f(simpleName, "{\n      context.javaClass.simpleName\n    }");
        return simpleName;
    }

    public static final String getAppName(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        try {
            String applicationName = FacebookSdk.getApplicationName();
            if (applicationName != null) {
                return applicationName;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i10 = applicationInfo.labelRes;
            if (i10 == 0) {
                return applicationInfo.nonLocalizedLabel.toString();
            }
            String string = context.getString(i10);
            j.f(string, "context.getString(stringId)");
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static final String getAppVersion() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static final Date getBundleLongAsDate(Bundle bundle, String str, Date date) {
        long j10;
        j.g(date, "dateBase");
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            j10 = ((Number) obj).longValue();
        } else {
            if (obj instanceof String) {
                try {
                    j10 = Long.parseLong((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        if (j10 == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date(date.getTime() + (j10 * 1000));
    }

    public static final long getContentSize(Uri uri) {
        j.g(uri, "contentUri");
        Cursor cursor = null;
        try {
            Cursor query = FacebookSdk.getApplicationContext().getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
            if (query == null) {
                return 0;
            }
            int columnIndex = query.getColumnIndex("_size");
            query.moveToFirst();
            long j10 = query.getLong(columnIndex);
            query.close();
            return j10;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public static final Locale getCurrentLocale() {
        Locale resourceLocale = getResourceLocale();
        if (resourceLocale != null) {
            return resourceLocale;
        }
        Locale locale = Locale.getDefault();
        j.f(locale, "getDefault()");
        return locale;
    }

    private final String getCurrentTokenDomainWithDefault() {
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.getGraphDomain() == null) {
            return AccessToken.DEFAULT_GRAPH_DOMAIN;
        }
        return currentAccessToken.getGraphDomain();
    }

    public static final b getDataProcessingOptions() {
        Class<Utility> cls = Utility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            String string = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.DATA_PROCESSING_OPTIONS_PREFERENCES, 0).getString(FacebookSdk.DATA_PROCESSION_OPTIONS, (String) null);
            if (string != null) {
                try {
                    return new b(string);
                } catch (JSONException unused) {
                }
            }
            return null;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final String getGraphDomainFromTokenDomain(String str) {
        String facebookDomain = FacebookSdk.getFacebookDomain();
        if (str == null) {
            return facebookDomain;
        }
        if (j.b(str, FacebookSdk.GAMING)) {
            return r.D(facebookDomain, "facebook.com", "fb.gg", false, 4, (Object) null);
        }
        if (j.b(str, FacebookSdk.INSTAGRAM)) {
            return r.D(facebookDomain, "facebook.com", FacebookSdk.INSTAGRAM_COM, false, 4, (Object) null);
        }
        return facebookDomain;
    }

    private final GraphRequest getGraphMeRequestWithCache(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", getProfileFieldsForGraphDomain(getCurrentTokenDomainWithDefault()));
        bundle.putString("access_token", str);
        GraphRequest newMeRequest = GraphRequest.Companion.newMeRequest((AccessToken) null, (GraphRequest.GraphJSONObjectCallback) null);
        newMeRequest.setParameters(bundle);
        newMeRequest.setHttpMethod(HttpMethod.GET);
        return newMeRequest;
    }

    public static final void getGraphMeRequestWithCacheAsync(String str, GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback) {
        j.g(str, SDKConstants.PARAM_ACCESS_TOKEN);
        j.g(graphMeRequestWithCacheCallback, "callback");
        b profileInformation = ProfileInformationCache.getProfileInformation(str);
        if (profileInformation != null) {
            graphMeRequestWithCacheCallback.onSuccess(profileInformation);
            return;
        }
        q qVar = new q(graphMeRequestWithCacheCallback, str);
        GraphRequest graphMeRequestWithCache = INSTANCE.getGraphMeRequestWithCache(str);
        graphMeRequestWithCache.setCallback(qVar);
        graphMeRequestWithCache.executeAsync();
    }

    /* access modifiers changed from: private */
    /* renamed from: getGraphMeRequestWithCacheAsync$lambda-3  reason: not valid java name */
    public static final void m127getGraphMeRequestWithCacheAsync$lambda3(GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback, String str, GraphResponse graphResponse) {
        j.g(graphMeRequestWithCacheCallback, "$callback");
        j.g(str, "$accessToken");
        j.g(graphResponse, "response");
        if (graphResponse.getError() != null) {
            graphMeRequestWithCacheCallback.onFailure(graphResponse.getError().getException());
            return;
        }
        ProfileInformationCache profileInformationCache = ProfileInformationCache.INSTANCE;
        b jsonObject = graphResponse.getJsonObject();
        if (jsonObject != null) {
            ProfileInformationCache.putProfileInformation(str, jsonObject);
            graphMeRequestWithCacheCallback.onSuccess(graphResponse.getJsonObject());
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final String getMetadataApplicationId(Context context) {
        Validate.notNull(context, IdentityHttpResponse.CONTEXT);
        return FacebookSdk.getApplicationId();
    }

    public static final Method getMethodQuietly(Class<?> cls, String str, Class<?>... clsArr) {
        j.g(cls, "clazz");
        j.g(str, "methodName");
        j.g(clsArr, "parameterTypes");
        try {
            return cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final String getProfileFieldsForGraphDomain(String str) {
        return j.b(str, FacebookSdk.INSTAGRAM) ? INSTAGRAM_PROFILE_FIELDS : FACEBOOK_PROFILE_FIELDS;
    }

    public static final Locale getResourceLocale() {
        try {
            return FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Object getStringPropertyAsJSON(b bVar, String str, String str2) throws JSONException {
        j.g(bVar, "jsonObject");
        Object opt = bVar.opt(str);
        if (opt != null && (opt instanceof String)) {
            opt = new h((String) opt).j();
        }
        if (opt == null || (opt instanceof b) || (opt instanceof a)) {
            return opt;
        }
        if (str2 != null) {
            b bVar2 = new b();
            bVar2.putOpt(str2, opt);
            return bVar2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    public static final String getUriString(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    private final String hashBytes(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb2 = new StringBuilder();
        j.f(digest, "digest");
        int length = digest.length;
        int i10 = 0;
        while (i10 < length) {
            byte b10 = digest[i10];
            i10++;
            sb2.append(Integer.toHexString((b10 >> 4) & 15));
            sb2.append(Integer.toHexString((b10 >> 0) & 15));
        }
        String sb3 = sb2.toString();
        j.f(sb3, "builder.toString()");
        return sb3;
    }

    private final String hashWithAlgorithm(String str, String str2) {
        Charset charset = d.f32216b;
        if (str2 != null) {
            byte[] bytes = str2.getBytes(charset);
            j.f(bytes, "(this as java.lang.String).getBytes(charset)");
            return hashWithAlgorithm(str, bytes);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static final Object invokeMethodQuietly(Object obj, Method method, Object... objArr) {
        j.g(method, FirebaseAnalytics.Param.METHOD);
        j.g(objArr, "args");
        try {
            return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static final boolean isAutoAppLinkSetup() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            o oVar = o.f32141a;
            String format2 = String.format("fb%s://applinks", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
            j.f(format2, "java.lang.String.format(format, *args)");
            intent.setData(Uri.parse(format2));
            Context applicationContext = FacebookSdk.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            String packageName = applicationContext.getPackageName();
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            j.f(queryIntentActivities, "packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)");
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                if (j.b(packageName, resolveInfo.activityInfo.packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static /* synthetic */ void isAutoAppLinkSetup$annotations() {
    }

    public static final boolean isAutofillAvailable(Context context) {
        AutofillManager autofillManager;
        j.g(context, IdentityHttpResponse.CONTEXT);
        if (Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class)) != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled()) {
            return true;
        }
        return false;
    }

    public static final boolean isChromeOS(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String str = Build.DEVICE;
        if (str != null) {
            j.f(str, "DEVICE");
            if (new Regex(ARC_DEVICE_PATTERN).e(str)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isContentUri(Uri uri) {
        return uri != null && r.t("content", uri.getScheme(), true);
    }

    public static final boolean isCurrentAccessToken(AccessToken accessToken) {
        return accessToken != null && j.b(accessToken, AccessToken.Companion.getCurrentAccessToken());
    }

    public static final boolean isDataProcessingRestricted() {
        Class<Utility> cls = Utility.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            b dataProcessingOptions = getDataProcessingOptions();
            if (dataProcessingOptions == null) {
                return false;
            }
            try {
                a jSONArray = dataProcessingOptions.getJSONArray(FacebookSdk.DATA_PROCESSION_OPTIONS);
                int o10 = jSONArray.o();
                if (o10 > 0) {
                    int i10 = 0;
                    while (true) {
                        int i11 = i10 + 1;
                        String n10 = jSONArray.n(i10);
                        j.f(n10, "options.getString(i)");
                        String lowerCase = n10.toLowerCase();
                        j.f(lowerCase, "(this as java.lang.String).toLowerCase()");
                        if (j.b(lowerCase, "ldu")) {
                            return true;
                        }
                        if (i11 >= o10) {
                            break;
                        }
                        i10 = i11;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return false;
        }
    }

    public static final boolean isFileUri(Uri uri) {
        return uri != null && r.t("file", uri.getScheme(), true);
    }

    private final boolean isGooglePlayServicesAvailable(Context context) {
        Method methodQuietly = getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
        if (methodQuietly == null) {
            return false;
        }
        Object invokeMethodQuietly = invokeMethodQuietly((Object) null, methodQuietly, context);
        if (!(invokeMethodQuietly instanceof Integer) || !j.b(invokeMethodQuietly, 0)) {
            return false;
        }
        return true;
    }

    public static final boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static final boolean isWebUri(Uri uri) {
        if (uri == null || (!r.t("http", uri.getScheme(), true) && !r.t("https", uri.getScheme(), true) && !r.t("fbstaging", uri.getScheme(), true))) {
            return false;
        }
        return true;
    }

    public static final Set<String> jsonArrayToSet(a aVar) throws JSONException {
        j.g(aVar, "jsonArray");
        HashSet hashSet = new HashSet();
        int o10 = aVar.o();
        if (o10 > 0) {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                String n10 = aVar.n(i10);
                j.f(n10, "jsonArray.getString(i)");
                hashSet.add(n10);
                if (i11 >= o10) {
                    break;
                }
                i10 = i11;
            }
        }
        return hashSet;
    }

    public static final List<String> jsonArrayToStringList(a aVar) throws JSONException {
        j.g(aVar, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int o10 = aVar.o();
        if (o10 > 0) {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                arrayList.add(aVar.n(i10));
                if (i11 >= o10) {
                    break;
                }
                i10 = i11;
            }
        }
        return arrayList;
    }

    public static final Map<String, String> jsonStrToMap(String str) {
        boolean z10;
        j.g(str, "str");
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return new HashMap();
        }
        try {
            HashMap hashMap = new HashMap();
            b bVar = new b(str);
            Iterator<String> keys = bVar.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                j.f(next, SDKConstants.PARAM_KEY);
                String string = bVar.getString(next);
                j.f(string, "jsonObject.getString(key)");
                hashMap.put(next, string);
            }
            return hashMap;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public static final void logd(String str, Exception exc) {
        if (FacebookSdk.isDebugEnabled() && str != null && exc != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(exc.getClass().getSimpleName());
            sb2.append(": ");
            sb2.append(exc.getMessage());
        }
    }

    public static final String mapToJsonStr(Map<String, String> map) {
        j.g(map, "map");
        String str = "";
        if (!map.isEmpty()) {
            try {
                b bVar = new b();
                for (Map.Entry next : map.entrySet()) {
                    bVar.put((String) next.getKey(), (Object) (String) next.getValue());
                }
                str = bVar.toString();
            } catch (JSONException unused) {
            }
            j.f(str, "{\n      try {\n        val jsonObject = JSONObject()\n        for ((key, value) in map) {\n          jsonObject.put(key, value)\n        }\n        jsonObject.toString()\n      } catch (_e: JSONException) {\n        \"\"\n      }\n    }");
        }
        return str;
    }

    public static final String md5hash(String str) {
        j.g(str, SDKConstants.PARAM_KEY);
        return INSTANCE.hashWithAlgorithm("MD5", str);
    }

    public static final boolean mustFixWindowParamsForAutofill(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        return isAutofillAvailable(context);
    }

    public static final Bundle parseUrlQueryString(String str) {
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(str)) {
            if (str != null) {
                Object[] array2 = StringsKt__StringsKt.C0(str, new String[]{"&"}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array2 != null) {
                    String[] strArr = (String[]) array2;
                    int length = strArr.length;
                    int i10 = 0;
                    while (i10 < length) {
                        String str2 = strArr[i10];
                        i10++;
                        Object[] array3 = StringsKt__StringsKt.C0(str2, new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                        if (array3 != null) {
                            String[] strArr2 = (String[]) array3;
                            try {
                                if (strArr2.length == 2) {
                                    bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), URLDecoder.decode(strArr2[1], "UTF-8"));
                                } else if (strArr2.length == 1) {
                                    bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), "");
                                }
                            } catch (UnsupportedEncodingException e10) {
                                logd(LOG_TAG, (Exception) e10);
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        return bundle;
    }

    public static final void putCommaSeparatedStringList(Bundle bundle, String str, List<String> list) {
        j.g(bundle, NetworkProfile.BISEXUAL);
        if (list != null) {
            bundle.putString(str, TextUtils.join(AppsFlyerKit.COMMA, list));
        }
    }

    public static final boolean putJSONValueInBundle(Bundle bundle, String str, Object obj) {
        j.g(bundle, "bundle");
        if (obj == null) {
            bundle.remove(str);
            return true;
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
            return true;
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Number) obj).doubleValue());
            return true;
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
            return true;
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Number) obj).intValue());
            return true;
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
            return true;
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Number) obj).longValue());
            return true;
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
            return true;
        } else if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        } else if (obj instanceof a) {
            bundle.putString(str, ((a) obj).toString());
            return true;
        } else if (!(obj instanceof b)) {
            return false;
        } else {
            bundle.putString(str, ((b) obj).toString());
            return true;
        }
    }

    public static final void putNonEmptyString(Bundle bundle, String str, String str2) {
        j.g(bundle, NetworkProfile.BISEXUAL);
        if (!isNullOrEmpty(str2)) {
            bundle.putString(str, str2);
        }
    }

    public static final void putUri(Bundle bundle, String str, Uri uri) {
        j.g(bundle, NetworkProfile.BISEXUAL);
        if (uri != null) {
            putNonEmptyString(bundle, str, uri.toString());
        }
    }

    public static final Map<String, String> readNonnullStringMapFromParcel(Parcel parcel) {
        j.g(parcel, "parcel");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        int i10 = 0;
        if (readInt > 0) {
            do {
                i10++;
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (!(readString == null || readString2 == null)) {
                    hashMap.put(readString, readString2);
                    continue;
                }
            } while (i10 < readInt);
        }
        return hashMap;
    }

    public static final String readStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader;
        BufferedInputStream bufferedInputStream;
        Throwable th2;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder sb2 = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read != -1) {
                            sb2.append(cArr, 0, read);
                        } else {
                            String sb3 = sb2.toString();
                            j.f(sb3, "{\n      bufferedInputStream = BufferedInputStream(inputStream)\n      reader = InputStreamReader(bufferedInputStream)\n      val stringBuilder = StringBuilder()\n      val bufferSize = 1024 * 2\n      val buffer = CharArray(bufferSize)\n      var n = 0\n      while (reader.read(buffer).also { n = it } != -1) {\n        stringBuilder.append(buffer, 0, n)\n      }\n      stringBuilder.toString()\n    }");
                            closeQuietly(bufferedInputStream);
                            closeQuietly(inputStreamReader);
                            return sb3;
                        }
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    closeQuietly(bufferedInputStream);
                    closeQuietly(inputStreamReader);
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                inputStreamReader = null;
                closeQuietly(bufferedInputStream);
                closeQuietly(inputStreamReader);
                throw th2;
            }
        } catch (Throwable th5) {
            bufferedInputStream = null;
            th2 = th5;
            inputStreamReader = null;
            closeQuietly(bufferedInputStream);
            closeQuietly(inputStreamReader);
            throw th2;
        }
    }

    public static final Map<String, String> readStringMapFromParcel(Parcel parcel) {
        j.g(parcel, "parcel");
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        int i10 = 0;
        if (readInt > 0) {
            do {
                i10++;
                hashMap.put(parcel.readString(), parcel.readString());
            } while (i10 < readInt);
        }
        return hashMap;
    }

    private final void refreshAvailableExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                availableExternalStorageGB = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
            availableExternalStorageGB = convertBytesToGB((double) availableExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private final int refreshBestGuessNumberOfCPUCores() {
        int i10 = numCPUCores;
        if (i10 > 0) {
            return i10;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new r());
            if (listFiles != null) {
                numCPUCores = listFiles.length;
            }
        } catch (Exception unused) {
        }
        if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return numCPUCores;
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshBestGuessNumberOfCPUCores$lambda-4  reason: not valid java name */
    public static final boolean m128refreshBestGuessNumberOfCPUCores$lambda4(File file, String str) {
        return Pattern.matches("cpu[0-9]+", str);
    }

    private final void refreshCarrierName(Context context) {
        if (j.b(carrierName, NO_CARRIER)) {
            try {
                Object systemService = context.getSystemService("phone");
                if (systemService != null) {
                    String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
                    j.f(networkOperatorName, "telephonyManager.networkOperatorName");
                    carrierName = networkOperatorName;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
            } catch (Exception unused) {
            }
        }
    }

    private final void refreshPeriodicExtendedDeviceInfo(Context context) {
        if (timestampOfLastCheck == -1 || System.currentTimeMillis() - timestampOfLastCheck >= 1800000) {
            timestampOfLastCheck = System.currentTimeMillis();
            refreshTimezone();
            refreshCarrierName(context);
            refreshTotalExternalStorage();
            refreshAvailableExternalStorage();
        }
    }

    private final void refreshTimezone() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            j.f(displayName, "tz.getDisplayName(tz.inDaylightTime(Date()), TimeZone.SHORT)");
            deviceTimezoneAbbreviation = displayName;
            String id2 = timeZone.getID();
            j.f(id2, "tz.id");
            deviceTimeZoneName = id2;
        } catch (AssertionError | Exception unused) {
        }
    }

    private final void refreshTotalExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                totalExternalStorageGB = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            }
            totalExternalStorageGB = convertBytesToGB((double) totalExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    public static final void runOnNonUiThread(Runnable runnable) {
        try {
            FacebookSdk.getExecutor().execute(runnable);
        } catch (Exception unused) {
        }
    }

    public static final String safeGetStringFromResponse(b bVar, String str) {
        if (bVar == null) {
            return "";
        }
        String optString = bVar.optString(str, "");
        j.f(optString, "response.optString(propertyName, \"\")");
        return optString;
    }

    public static final void setAppEventAttributionParameters(b bVar, AttributionIdentifiers attributionIdentifiers, String str, boolean z10, Context context) throws JSONException {
        j.g(bVar, "params");
        j.g(context, IdentityHttpResponse.CONTEXT);
        FeatureManager featureManager = FeatureManager.INSTANCE;
        FeatureManager.Feature feature = FeatureManager.Feature.ServiceUpdateCompliance;
        if (!FeatureManager.isEnabled(feature)) {
            bVar.put("anon_id", (Object) str);
        }
        boolean z11 = true;
        bVar.put("application_tracking_enabled", !z10);
        bVar.put("advertiser_id_collection_enabled", FacebookSdk.getAdvertiserIDCollectionEnabled());
        if (attributionIdentifiers != null) {
            if (FeatureManager.isEnabled(feature)) {
                INSTANCE.appendAnonIdUnderCompliance(bVar, attributionIdentifiers, str, context);
            }
            if (attributionIdentifiers.getAttributionId() != null) {
                if (FeatureManager.isEnabled(feature)) {
                    INSTANCE.appendAttributionIdUnderCompliance(bVar, attributionIdentifiers, context);
                } else {
                    bVar.put("attribution", (Object) attributionIdentifiers.getAttributionId());
                }
            }
            if (attributionIdentifiers.getAndroidAdvertiserId() != null) {
                bVar.put("advertiser_id", (Object) attributionIdentifiers.getAndroidAdvertiserId());
                bVar.put("advertiser_tracking_enabled", !attributionIdentifiers.isTrackingLimited());
            }
            if (!attributionIdentifiers.isTrackingLimited()) {
                String allHashedUserData = UserDataStore.getAllHashedUserData();
                if (allHashedUserData.length() != 0) {
                    z11 = false;
                }
                if (!z11) {
                    bVar.put("ud", (Object) allHashedUserData);
                }
            }
            if (attributionIdentifiers.getAndroidInstallerPackage() != null) {
                bVar.put("installer_package", (Object) attributionIdentifiers.getAndroidInstallerPackage());
            }
        }
    }

    public static final void setAppEventExtendedDeviceInfoParameters(b bVar, Context context) throws JSONException {
        String str;
        Locale locale;
        int i10;
        DisplayManager displayManager;
        j.g(bVar, "params");
        j.g(context, "appContext");
        a aVar = new a();
        aVar.E(EXTRA_APP_EVENTS_INFO_FORMAT_VERSION);
        INSTANCE.refreshPeriodicExtendedDeviceInfo(context);
        String packageName = context.getPackageName();
        int i11 = 0;
        int i12 = -1;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            if (packageInfo != null) {
                i12 = packageInfo.versionCode;
                str = packageInfo.versionName;
                aVar.E(packageName);
                aVar.A(i12);
                aVar.E(str);
                aVar.E(Build.VERSION.RELEASE);
                aVar.E(Build.MODEL);
                try {
                    locale = context.getResources().getConfiguration().locale;
                } catch (Exception unused) {
                    locale = Locale.getDefault();
                }
                aVar.E(locale.getLanguage() + '_' + locale.getCountry());
                aVar.E(deviceTimezoneAbbreviation);
                aVar.E(carrierName);
                double d10 = 0.0d;
                try {
                    Object systemService = context.getSystemService("display");
                    Display display = null;
                    if (systemService instanceof DisplayManager) {
                        displayManager = (DisplayManager) systemService;
                    } else {
                        displayManager = null;
                    }
                    if (displayManager != null) {
                        display = displayManager.getDisplay(0);
                    }
                    if (display != null) {
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        display.getMetrics(displayMetrics);
                        int i13 = displayMetrics.widthPixels;
                        try {
                            i11 = displayMetrics.heightPixels;
                            d10 = (double) displayMetrics.density;
                        } catch (Exception unused2) {
                        }
                        i10 = i11;
                        i11 = i13;
                        aVar.A(i11);
                        aVar.A(i10);
                        aVar.E(new DecimalFormat("#.##").format(d10));
                        aVar.A(INSTANCE.refreshBestGuessNumberOfCPUCores());
                        aVar.D(totalExternalStorageGB);
                        aVar.D(availableExternalStorageGB);
                        aVar.E(deviceTimeZoneName);
                        bVar.put(Constants.EXTINFO, (Object) aVar.toString());
                    }
                } catch (Exception unused3) {
                }
                i10 = 0;
                aVar.A(i11);
                aVar.A(i10);
                aVar.E(new DecimalFormat("#.##").format(d10));
                aVar.A(INSTANCE.refreshBestGuessNumberOfCPUCores());
                aVar.D(totalExternalStorageGB);
                aVar.D(availableExternalStorageGB);
                aVar.E(deviceTimeZoneName);
                bVar.put(Constants.EXTINFO, (Object) aVar.toString());
            }
        } catch (PackageManager.NameNotFoundException unused4) {
            str = "";
        }
    }

    public static final String sha1hash(String str) {
        j.g(str, SDKConstants.PARAM_KEY);
        return INSTANCE.hashWithAlgorithm("SHA-1", str);
    }

    public static final String sha256hash(String str) {
        if (str == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm("SHA-256", str);
    }

    public static final boolean stringsEqualOrEmpty(String str, String str2) {
        boolean z10;
        boolean z11;
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (str2 == null || str2.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 && z11) {
            return true;
        }
        if (z10 || z11) {
            return false;
        }
        return j.b(str, str2);
    }

    public static final a tryGetJSONArrayFromResponse(b bVar, String str) {
        if (bVar == null) {
            return null;
        }
        return bVar.optJSONArray(str);
    }

    public static final b tryGetJSONObjectFromResponse(b bVar, String str) {
        if (bVar == null) {
            return null;
        }
        return bVar.optJSONObject(str);
    }

    public static final void writeNonnullStringMapToParcel(Parcel parcel, Map<String, String> map) {
        j.g(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    public static final void writeStringMapToParcel(Parcel parcel, Map<String, String> map) {
        j.g(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    public static final Method getMethodQuietly(String str, String str2, Class<?>... clsArr) {
        j.g(str, "className");
        j.g(str2, "methodName");
        j.g(clsArr, "parameterTypes");
        try {
            Class<?> cls = Class.forName(str);
            j.f(cls, "clazz");
            return getMethodQuietly(cls, str2, (Class<?>[]) (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private final String hashWithAlgorithm(String str, byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            j.f(instance, "hash");
            return hashBytes(instance, bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static final boolean isNullOrEmpty(String str) {
        if (str != null) {
            if (!(str.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    public static final String sha1hash(byte[] bArr) {
        j.g(bArr, "bytes");
        return INSTANCE.hashWithAlgorithm("SHA-1", bArr);
    }

    public static final String sha256hash(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm("SHA-256", bArr);
    }

    public static final void logd(String str, String str2) {
        FacebookSdk.isDebugEnabled();
    }

    public static final void logd(String str, String str2, Throwable th2) {
        if (FacebookSdk.isDebugEnabled()) {
            isNullOrEmpty(str);
        }
    }
}

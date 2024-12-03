package com.facebook;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.util.FacebookParse;
import com.facebook.GraphRequestBatch;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.mparticle.identity.IdentityHttpResponse;
import com.mparticle.kits.AppsFlyerKit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import kotlin.text.d;
import org.apache.commons.cli.HelpFormatter;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.json.JSONException;
import org.json.a;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 g2\u00020\u0001:\thigjklmnoBQ\b\u0017\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010<\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010S\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bc\u0010dB\u001b\b\u0010\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\\\u001a\u00020e¢\u0006\u0004\bc\u0010fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J$\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001b\u001a\u00020\u0004H\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010#\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b0\u0010$\u001a\u0004\b1\u0010&\"\u0004\b2\u0010(R$\u00103\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b3\u0010$\u001a\u0004\b4\u0010&\"\u0004\b5\u0010(R\"\u00106\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010C\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010I\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bI\u0010$\u001a\u0004\bJ\u0010&\"\u0004\bK\u0010(R.\u0010M\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010L8\u0006@FX\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR.\u0010U\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010S8\u0006@FX\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u00107R\u0018\u0010\\\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010$R\u0016\u0010^\u001a\u0004\u0018\u00010\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b]\u0010&R\u0011\u0010`\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b_\u0010&R\u0011\u0010b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\ba\u0010&¨\u0006p"}, d2 = {"Lcom/facebook/GraphRequest;", "", "", "addCommonParameters", "", "getAccessTokenToUseForRequest", "getClientTokenForRequest", "baseUrl", "", "isBatch", "appendParametersToBaseUrl", "getUrlWithGraphPath", "shouldForceClientTokenForRequest", "isValidGraphRequestForDomain", "isApplicationRequest", "Lorg/json/a;", "batch", "", "Lcom/facebook/GraphRequest$Attachment;", "attachments", "serializeToBatch", "forceOverride", "setForceApplicationRequest", "Lcom/facebook/GraphResponse;", "executeAndWait", "Lcom/facebook/GraphRequestAsyncTask;", "executeAsync", "toString", "Lcom/facebook/AccessToken;", "accessToken", "Lcom/facebook/AccessToken;", "getAccessToken", "()Lcom/facebook/AccessToken;", "setAccessToken", "(Lcom/facebook/AccessToken;)V", "graphPath", "Ljava/lang/String;", "getGraphPath", "()Ljava/lang/String;", "setGraphPath", "(Ljava/lang/String;)V", "Lorg/json/b;", "graphObject", "Lorg/json/b;", "getGraphObject", "()Lorg/json/b;", "setGraphObject", "(Lorg/json/b;)V", "batchEntryName", "getBatchEntryName", "setBatchEntryName", "batchEntryDependsOn", "getBatchEntryDependsOn", "setBatchEntryDependsOn", "batchEntryOmitResultOnSuccess", "Z", "getBatchEntryOmitResultOnSuccess", "()Z", "setBatchEntryOmitResultOnSuccess", "(Z)V", "Landroid/os/Bundle;", "parameters", "Landroid/os/Bundle;", "getParameters", "()Landroid/os/Bundle;", "setParameters", "(Landroid/os/Bundle;)V", "tag", "Ljava/lang/Object;", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "version", "getVersion", "setVersion", "Lcom/facebook/GraphRequest$Callback;", "callback", "Lcom/facebook/GraphRequest$Callback;", "getCallback", "()Lcom/facebook/GraphRequest$Callback;", "setCallback", "(Lcom/facebook/GraphRequest$Callback;)V", "Lcom/facebook/HttpMethod;", "value", "httpMethod", "Lcom/facebook/HttpMethod;", "getHttpMethod", "()Lcom/facebook/HttpMethod;", "setHttpMethod", "(Lcom/facebook/HttpMethod;)V", "forceApplicationRequest", "overriddenURL", "getGraphPathWithVersion", "graphPathWithVersion", "getRelativeUrlForBatchedRequest", "relativeUrlForBatchedRequest", "getUrlForSingleRequest", "urlForSingleRequest", "<init>", "(Lcom/facebook/AccessToken;Ljava/lang/String;Landroid/os/Bundle;Lcom/facebook/HttpMethod;Lcom/facebook/GraphRequest$Callback;Ljava/lang/String;)V", "Ljava/net/URL;", "(Lcom/facebook/AccessToken;Ljava/net/URL;)V", "Companion", "Attachment", "Callback", "GraphJSONArrayCallback", "GraphJSONObjectCallback", "KeyValueSerializer", "OnProgressCallback", "ParcelableResourceWithMimeType", "Serializer", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class GraphRequest {
    private static final String ACCEPT_LANGUAGE_HEADER = "Accept-Language";
    public static final String ACCESS_TOKEN_PARAM = "access_token";
    private static final String ATTACHED_FILES_PARAM = "attached_files";
    private static final String ATTACHMENT_FILENAME_PREFIX = "file";
    private static final String BATCH_APP_ID_PARAM = "batch_app_id";
    private static final String BATCH_BODY_PARAM = "body";
    private static final String BATCH_ENTRY_DEPENDS_ON_PARAM = "depends_on";
    private static final String BATCH_ENTRY_NAME_PARAM = "name";
    private static final String BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM = "omit_response_on_success";
    private static final String BATCH_METHOD_PARAM = "method";
    private static final String BATCH_PARAM = "batch";
    private static final String BATCH_RELATIVE_URL_PARAM = "relative_url";
    private static final String CAPTION_PARAM = "caption";
    private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEBUG_KEY = "__debug__";
    private static final String DEBUG_MESSAGES_KEY = "messages";
    private static final String DEBUG_MESSAGE_KEY = "message";
    private static final String DEBUG_MESSAGE_LINK_KEY = "link";
    private static final String DEBUG_MESSAGE_TYPE_KEY = "type";
    private static final String DEBUG_PARAM = "debug";
    private static final String DEBUG_SEVERITY_INFO = "info";
    private static final String DEBUG_SEVERITY_WARNING = "warning";
    public static final String FIELDS_PARAM = "fields";
    private static final String FORMAT_JSON = "json";
    private static final String FORMAT_PARAM = "format";
    private static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final int MAXIMUM_BATCH_SIZE = 50;
    private static final String ME = "me";
    /* access modifiers changed from: private */
    public static final String MIME_BOUNDARY;
    private static final String MY_FRIENDS = "me/friends";
    private static final String MY_PHOTOS = "me/photos";
    private static final String PICTURE_PARAM = "picture";
    private static final String SDK_ANDROID = "android";
    private static final String SDK_PARAM = "sdk";
    private static final String SEARCH = "search";
    public static final String TAG = GraphRequest.class.getSimpleName();
    private static final String USER_AGENT_BASE = "FBAndroidSDK";
    private static final String USER_AGENT_HEADER = "User-Agent";
    private static final String VIDEOS_SUFFIX = "/videos";
    /* access modifiers changed from: private */
    public static String defaultBatchApplicationId;
    /* access modifiers changed from: private */
    public static volatile String userAgent;
    /* access modifiers changed from: private */
    public static final Pattern versionPattern = Pattern.compile("^/?v\\d+\\.\\d+/(.*)");
    private AccessToken accessToken;
    private String batchEntryDependsOn;
    private String batchEntryName;
    private boolean batchEntryOmitResultOnSuccess;
    private Callback callback;
    private boolean forceApplicationRequest;
    private b graphObject;
    private String graphPath;
    private HttpMethod httpMethod;
    private String overriddenURL;
    private Bundle parameters;
    private Object tag;
    private String version;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/facebook/GraphRequest$Attachment;", "", "request", "Lcom/facebook/GraphRequest;", "value", "(Lcom/facebook/GraphRequest;Ljava/lang/Object;)V", "getRequest", "()Lcom/facebook/GraphRequest;", "getValue", "()Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Attachment {
        private final GraphRequest request;
        private final Object value;

        public Attachment(GraphRequest graphRequest, Object obj) {
            j.g(graphRequest, "request");
            this.request = graphRequest;
            this.value = obj;
        }

        public final GraphRequest getRequest() {
            return this.request;
        }

        public final Object getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/GraphRequest$Callback;", "", "onCompleted", "", "response", "Lcom/facebook/GraphResponse;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Callback {
        void onCompleted(GraphResponse graphResponse);
    }

    @Metadata(bv = {}, d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u000b\b\u0002¢\u0006\u0006\b¨\u0001\u0010 \u0001J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J:\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0002H\u0002J \u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J(\u0010#\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u000bH\u0002J \u0010)\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020&2\u0006\u0010(\u001a\u00020'H\u0002J$\u0010-\u001a\u00020\u000f2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020+0*2\u0006\u0010\u001e\u001a\u00020&H\u0002J2\u00100\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020&2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020'0.2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020+0/H\u0002J\u0010\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u00020\tH\u0002J\u0012\u00103\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u00104\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u00105\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0002J\n\u00106\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u00108\u001a\u00020\u000f2\b\u00107\u001a\u0004\u0018\u00010\u0002H\u0007J&\u0010>\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010;\u001a\u0004\u0018\u00010\u00022\b\u0010=\u001a\u0004\u0018\u00010<H\u0007J\u001c\u0010@\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010=\u001a\u0004\u0018\u00010?H\u0007J0\u0010A\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010=\u001a\u0004\u0018\u00010<H\u0007J0\u0010C\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010B\u001a\u0004\u0018\u00010$2\b\u0010=\u001a\u0004\u0018\u00010<H\u0007J\u001c\u0010E\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010=\u001a\u0004\u0018\u00010DH\u0007J&\u0010F\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010=\u001a\u0004\u0018\u00010<H\u0007J@\u0010L\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010H\u001a\u0004\u0018\u00010G2\u0006\u0010I\u001a\u00020\u00142\u0006\u0010J\u001a\u00020\u00142\b\u0010K\u001a\u0004\u0018\u00010\u00022\b\u0010=\u001a\u0004\u0018\u00010DH\u0007JB\u0010Q\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010N\u001a\u00020M2\b\u0010O\u001a\u0004\u0018\u00010\u00022\b\u0010P\u001a\u0004\u0018\u00010$2\b\u0010=\u001a\u0004\u0018\u00010<H\u0007JB\u0010Q\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010S\u001a\u00020R2\b\u0010O\u001a\u0004\u0018\u00010\u00022\b\u0010P\u001a\u0004\u0018\u00010$2\b\u0010=\u001a\u0004\u0018\u00010<H\u0007JB\u0010Q\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010U\u001a\u00020T2\b\u0010O\u001a\u0004\u0018\u00010\u00022\b\u0010P\u001a\u0004\u0018\u00010$2\b\u0010=\u001a\u0004\u0018\u00010<H\u0007J.\u0010X\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010W\u001a\u00020V2\b\u00107\u001a\u0004\u0018\u00010\u00022\b\u0010=\u001a\u0004\u0018\u00010<H\u0007J$\u0010X\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010W\u001a\u00020V2\b\u0010=\u001a\u0004\u0018\u00010<H\u0007J#\u0010Z\u001a\u00020\u00072\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0Y\"\u00020'H\u0007¢\u0006\u0004\bZ\u0010[J\u0016\u0010Z\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020'0.H\u0007J\u0010\u0010Z\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010]\u001a\u00020\\2\u0006\u0010(\u001a\u00020'H\u0007J)\u0010_\u001a\b\u0012\u0004\u0012\u00020\\0^2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0Y\"\u00020'H\u0007¢\u0006\u0004\b_\u0010`J\u001c\u0010_\u001a\b\u0012\u0004\u0012\u00020\\0^2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020'0.H\u0007J\u0016\u0010_\u001a\b\u0012\u0004\u0012\u00020\\0^2\u0006\u0010\n\u001a\u00020\tH\u0007J#\u0010b\u001a\u00020a2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0Y\"\u00020'H\u0007¢\u0006\u0004\bb\u0010cJ\u0016\u0010b\u001a\u00020a2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020'0.H\u0007J\u0010\u0010b\u001a\u00020a2\u0006\u0010\n\u001a\u00020\tH\u0007J$\u0010d\u001a\b\u0012\u0004\u0012\u00020\\0^2\u0006\u0010\r\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020'0.H\u0007J\u001e\u0010d\u001a\b\u0012\u0004\u0012\u00020\\0^2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J\u0018\u0010e\u001a\u00020a2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J\"\u0010e\u001a\u00020a2\b\u0010g\u001a\u0004\u0018\u00010f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J%\u0010k\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\\0^H\u0001¢\u0006\u0004\bi\u0010jJ\u0017\u0010n\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\bl\u0010mJ\u001f\u0010q\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0001¢\u0006\u0004\bo\u0010pR\u0014\u0010t\u001a\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\br\u0010sR\u001e\u0010u\u001a\u0004\u0018\u00010\u00028B@\u0002X\u000e¢\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010sR\u0014\u0010x\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\bx\u0010vR\u0014\u0010y\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\by\u0010vR\u0014\u0010z\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\bz\u0010vR\u0014\u0010{\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b{\u0010vR\u0014\u0010|\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b|\u0010vR\u0014\u0010}\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b}\u0010vR\u0014\u0010~\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b~\u0010vR\u0014\u0010\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0006XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0017\u0010\u0001\u001a\u00020\u00148\u0006XT¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR\u0016\u0010\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b\u0001\u0010vR'\u0010\u0001\u001a\u000b \u0001*\u0004\u0018\u00010\u00020\u00028\u0000X\u0004¢\u0006\u000f\n\u0005\b\u0001\u0010v\u0012\u0006\b\u0001\u0010 \u0001R\u0016\u0010¡\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b¡\u0001\u0010vR\u0016\u0010¢\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b¢\u0001\u0010vR\u0016\u0010£\u0001\u001a\u00020\u00028\u0002XT¢\u0006\u0007\n\u0005\b£\u0001\u0010vR\u001a\u0010¤\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b¤\u0001\u0010vR\"\u0010¦\u0001\u001a\r \u0001*\u0005\u0018\u00010¥\u00010¥\u00018\u0002X\u0004¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001¨\u0006©\u0001"}, d2 = {"Lcom/facebook/GraphRequest$Companion;", "", "", "graphPath", "getDefaultPhotoPathIfNull", "Ljava/net/URL;", "url", "Ljava/net/HttpURLConnection;", "createConnection", "Lcom/facebook/GraphRequestBatch;", "requests", "", "hasOnProgressCallbacks", "connection", "shouldUseGzip", "", "setConnectionContentType", "isGzipCompressible", "Lcom/facebook/internal/Logger;", "logger", "", "numRequests", "Ljava/io/OutputStream;", "outputStream", "processRequest", "path", "isMeRequest", "Lorg/json/b;", "graphObject", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "serializer", "processGraphObject", "key", "value", "passByValue", "processGraphObjectProperty", "Landroid/os/Bundle;", "bundle", "Lcom/facebook/GraphRequest$Serializer;", "Lcom/facebook/GraphRequest;", "request", "serializeParameters", "", "Lcom/facebook/GraphRequest$Attachment;", "attachments", "serializeAttachments", "", "", "serializeRequestsAsJSON", "batch", "getBatchAppId", "isSupportedAttachmentType", "isSupportedParameterType", "parameterToString", "getDefaultBatchApplicationId", "applicationId", "setDefaultBatchApplicationId", "Lcom/facebook/AccessToken;", "accessToken", "id", "Lcom/facebook/GraphRequest$Callback;", "callback", "newDeleteObjectRequest", "Lcom/facebook/GraphRequest$GraphJSONObjectCallback;", "newMeRequest", "newPostRequest", "parameters", "newPostRequestWithBundle", "Lcom/facebook/GraphRequest$GraphJSONArrayCallback;", "newMyFriendsRequest", "newGraphPathRequest", "Landroid/location/Location;", "location", "radiusInMeters", "resultsLimit", "searchText", "newPlacesSearchRequest", "Landroid/graphics/Bitmap;", "image", "caption", "params", "newUploadPhotoRequest", "Ljava/io/File;", "file", "Landroid/net/Uri;", "photoUri", "Landroid/content/Context;", "context", "newCustomAudienceThirdPartyIdRequest", "", "toHttpConnection", "([Lcom/facebook/GraphRequest;)Ljava/net/HttpURLConnection;", "Lcom/facebook/GraphResponse;", "executeAndWait", "", "executeBatchAndWait", "([Lcom/facebook/GraphRequest;)Ljava/util/List;", "Lcom/facebook/GraphRequestAsyncTask;", "executeBatchAsync", "([Lcom/facebook/GraphRequest;)Lcom/facebook/GraphRequestAsyncTask;", "executeConnectionAndWait", "executeConnectionAsync", "Landroid/os/Handler;", "callbackHandler", "responses", "runCallbacks$facebook_core_release", "(Lcom/facebook/GraphRequestBatch;Ljava/util/List;)V", "runCallbacks", "validateFieldsParamForGetRequests$facebook_core_release", "(Lcom/facebook/GraphRequestBatch;)V", "validateFieldsParamForGetRequests", "serializeToUrlConnection$facebook_core_release", "(Lcom/facebook/GraphRequestBatch;Ljava/net/HttpURLConnection;)V", "serializeToUrlConnection", "getMimeContentType", "()Ljava/lang/String;", "mimeContentType", "userAgent", "Ljava/lang/String;", "getUserAgent", "ACCEPT_LANGUAGE_HEADER", "ACCESS_TOKEN_PARAM", "ATTACHED_FILES_PARAM", "ATTACHMENT_FILENAME_PREFIX", "BATCH_APP_ID_PARAM", "BATCH_BODY_PARAM", "BATCH_ENTRY_DEPENDS_ON_PARAM", "BATCH_ENTRY_NAME_PARAM", "BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM", "BATCH_METHOD_PARAM", "BATCH_PARAM", "BATCH_RELATIVE_URL_PARAM", "CAPTION_PARAM", "CONTENT_ENCODING_HEADER", "CONTENT_TYPE_HEADER", "DEBUG_KEY", "DEBUG_MESSAGES_KEY", "DEBUG_MESSAGE_KEY", "DEBUG_MESSAGE_LINK_KEY", "DEBUG_MESSAGE_TYPE_KEY", "DEBUG_PARAM", "DEBUG_SEVERITY_INFO", "DEBUG_SEVERITY_WARNING", "FIELDS_PARAM", "FORMAT_JSON", "FORMAT_PARAM", "ISO_8601_FORMAT_STRING", "MAXIMUM_BATCH_SIZE", "I", "ME", "MIME_BOUNDARY", "MY_FRIENDS", "MY_PHOTOS", "PICTURE_PARAM", "SDK_ANDROID", "SDK_PARAM", "SEARCH", "kotlin.jvm.PlatformType", "TAG", "getTAG$facebook_core_release$annotations", "()V", "USER_AGENT_BASE", "USER_AGENT_HEADER", "VIDEOS_SUFFIX", "defaultBatchApplicationId", "Ljava/util/regex/Pattern;", "versionPattern", "Ljava/util/regex/Pattern;", "<init>", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final HttpURLConnection createConnection(URL url) throws IOException {
            URLConnection openConnection = url.openConnection();
            if (openConnection != null) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setRequestProperty(GraphRequest.USER_AGENT_HEADER, getUserAgent());
                httpURLConnection.setRequestProperty(GraphRequest.ACCEPT_LANGUAGE_HEADER, Locale.getDefault().toString());
                httpURLConnection.setChunkedStreamingMode(0);
                return httpURLConnection;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        }

        private final String getBatchAppId(GraphRequestBatch graphRequestBatch) {
            String batchApplicationId = graphRequestBatch.getBatchApplicationId();
            boolean z10 = true;
            if (batchApplicationId != null && (!graphRequestBatch.isEmpty())) {
                return batchApplicationId;
            }
            Iterator it = graphRequestBatch.iterator();
            while (it.hasNext()) {
                AccessToken accessToken = ((GraphRequest) it.next()).getAccessToken();
                if (accessToken != null) {
                    return accessToken.getApplicationId();
                }
            }
            String access$getDefaultBatchApplicationId$cp = GraphRequest.defaultBatchApplicationId;
            if (access$getDefaultBatchApplicationId$cp != null) {
                if (access$getDefaultBatchApplicationId$cp.length() <= 0) {
                    z10 = false;
                }
                if (z10) {
                    return access$getDefaultBatchApplicationId$cp;
                }
            }
            return FacebookSdk.getApplicationId();
        }

        private final String getDefaultPhotoPathIfNull(String str) {
            return str == null ? GraphRequest.MY_PHOTOS : str;
        }

        private final String getMimeContentType() {
            o oVar = o.f32141a;
            String format2 = String.format("multipart/form-data; boundary=%s", Arrays.copyOf(new Object[]{GraphRequest.MIME_BOUNDARY}, 1));
            j.f(format2, "java.lang.String.format(format, *args)");
            return format2;
        }

        public static /* synthetic */ void getTAG$facebook_core_release$annotations() {
        }

        private final String getUserAgent() {
            if (GraphRequest.userAgent == null) {
                o oVar = o.f32141a;
                String format2 = String.format("%s.%s", Arrays.copyOf(new Object[]{GraphRequest.USER_AGENT_BASE, FacebookSdkVersion.BUILD}, 2));
                j.f(format2, "java.lang.String.format(format, *args)");
                GraphRequest.userAgent = format2;
                String customUserAgent = InternalSettings.getCustomUserAgent();
                if (!Utility.isNullOrEmpty(customUserAgent)) {
                    String format3 = String.format(Locale.ROOT, "%s/%s", Arrays.copyOf(new Object[]{GraphRequest.userAgent, customUserAgent}, 2));
                    j.f(format3, "java.lang.String.format(locale, format, *args)");
                    GraphRequest.userAgent = format3;
                }
            }
            return GraphRequest.userAgent;
        }

        private final boolean hasOnProgressCallbacks(GraphRequestBatch graphRequestBatch) {
            for (GraphRequestBatch.Callback callback : graphRequestBatch.getCallbacks()) {
                if (callback instanceof GraphRequestBatch.OnProgressCallback) {
                    return true;
                }
            }
            Iterator it = graphRequestBatch.iterator();
            while (it.hasNext()) {
                if (((GraphRequest) it.next()).getCallback() instanceof OnProgressCallback) {
                    return true;
                }
            }
            return false;
        }

        private final boolean isGzipCompressible(GraphRequestBatch graphRequestBatch) {
            Iterator it = graphRequestBatch.iterator();
            while (it.hasNext()) {
                GraphRequest graphRequest = (GraphRequest) it.next();
                Iterator<String> it2 = graphRequest.getParameters().keySet().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (isSupportedAttachmentType(graphRequest.getParameters().get(it2.next()))) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        private final boolean isMeRequest(String str) {
            Matcher matcher = GraphRequest.versionPattern.matcher(str);
            if (matcher.matches()) {
                str = matcher.group(1);
                j.f(str, "matcher.group(1)");
            }
            if (r.J(str, "me/", false, 2, (Object) null) || r.J(str, "/me/", false, 2, (Object) null)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final boolean isSupportedAttachmentType(Object obj) {
            if ((obj instanceof Bitmap) || (obj instanceof byte[]) || (obj instanceof Uri) || (obj instanceof ParcelFileDescriptor) || (obj instanceof ParcelableResourceWithMimeType)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final boolean isSupportedParameterType(Object obj) {
            return (obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Number) || (obj instanceof Date);
        }

        /* access modifiers changed from: private */
        /* renamed from: newMeRequest$lambda-0  reason: not valid java name */
        public static final void m28newMeRequest$lambda0(GraphJSONObjectCallback graphJSONObjectCallback, GraphResponse graphResponse) {
            j.g(graphResponse, "response");
            if (graphJSONObjectCallback != null) {
                graphJSONObjectCallback.onCompleted(graphResponse.getJSONObject(), graphResponse);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: newPlacesSearchRequest$lambda-1  reason: not valid java name */
        public static final void m29newPlacesSearchRequest$lambda1(GraphJSONArrayCallback graphJSONArrayCallback, GraphResponse graphResponse) {
            a aVar;
            j.g(graphResponse, "response");
            if (graphJSONArrayCallback != null) {
                b jSONObject = graphResponse.getJSONObject();
                if (jSONObject == null) {
                    aVar = null;
                } else {
                    aVar = jSONObject.optJSONArray("data");
                }
                graphJSONArrayCallback.onCompleted(aVar, graphResponse);
            }
        }

        /* access modifiers changed from: private */
        public final String parameterToString(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if ((obj instanceof Boolean) || (obj instanceof Number)) {
                return obj.toString();
            }
            if (obj instanceof Date) {
                String format2 = new SimpleDateFormat(GraphRequest.ISO_8601_FORMAT_STRING, Locale.US).format((Date) obj);
                j.f(format2, "iso8601DateFormat.format(value)");
                return format2;
            }
            throw new IllegalArgumentException("Unsupported parameter type.");
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x002e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void processGraphObject(org.json.b r10, java.lang.String r11, com.facebook.GraphRequest.KeyValueSerializer r12) {
            /*
                r9 = this;
                boolean r0 = r9.isMeRequest(r11)
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x0023
                r5 = 0
                r6 = 0
                r7 = 6
                r8 = 0
                java.lang.String r4 = ":"
                r3 = r11
                int r0 = kotlin.text.StringsKt__StringsKt.b0(r3, r4, r5, r6, r7, r8)
                java.lang.String r4 = "?"
                int r11 = kotlin.text.StringsKt__StringsKt.b0(r3, r4, r5, r6, r7, r8)
                r3 = 3
                if (r0 <= r3) goto L_0x0023
                r3 = -1
                if (r11 == r3) goto L_0x0021
                if (r0 >= r11) goto L_0x0023
            L_0x0021:
                r11 = r1
                goto L_0x0024
            L_0x0023:
                r11 = r2
            L_0x0024:
                java.util.Iterator r0 = r10.keys()
            L_0x0028:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L_0x0053
                java.lang.Object r3 = r0.next()
                java.lang.String r3 = (java.lang.String) r3
                java.lang.Object r4 = r10.opt(r3)
                if (r11 == 0) goto L_0x0044
                java.lang.String r5 = "image"
                boolean r5 = kotlin.text.r.t(r3, r5, r1)
                if (r5 == 0) goto L_0x0044
                r5 = r1
                goto L_0x0045
            L_0x0044:
                r5 = r2
            L_0x0045:
                java.lang.String r6 = "key"
                kotlin.jvm.internal.j.f(r3, r6)
                java.lang.String r6 = "value"
                kotlin.jvm.internal.j.f(r4, r6)
                r9.processGraphObjectProperty(r3, r4, r12, r5)
                goto L_0x0028
            L_0x0053:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.Companion.processGraphObject(org.json.b, java.lang.String, com.facebook.GraphRequest$KeyValueSerializer):void");
        }

        private final void processGraphObjectProperty(String str, Object obj, KeyValueSerializer keyValueSerializer, boolean z10) {
            Class<?> cls = obj.getClass();
            if (b.class.isAssignableFrom(cls)) {
                b bVar = (b) obj;
                if (z10) {
                    Iterator<String> keys = bVar.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        o oVar = o.f32141a;
                        String format2 = String.format("%s[%s]", Arrays.copyOf(new Object[]{str, next}, 2));
                        j.f(format2, "java.lang.String.format(format, *args)");
                        Object opt = bVar.opt(next);
                        j.f(opt, "jsonObject.opt(propertyName)");
                        processGraphObjectProperty(format2, opt, keyValueSerializer, z10);
                    }
                } else if (bVar.has("id")) {
                    String optString = bVar.optString("id");
                    j.f(optString, "jsonObject.optString(\"id\")");
                    processGraphObjectProperty(str, optString, keyValueSerializer, z10);
                } else if (bVar.has("url")) {
                    String optString2 = bVar.optString("url");
                    j.f(optString2, "jsonObject.optString(\"url\")");
                    processGraphObjectProperty(str, optString2, keyValueSerializer, z10);
                } else if (bVar.has(NativeProtocol.OPEN_GRAPH_CREATE_OBJECT_KEY)) {
                    String bVar2 = bVar.toString();
                    j.f(bVar2, "jsonObject.toString()");
                    processGraphObjectProperty(str, bVar2, keyValueSerializer, z10);
                }
            } else if (a.class.isAssignableFrom(cls)) {
                a aVar = (a) obj;
                int o10 = aVar.o();
                if (o10 > 0) {
                    int i10 = 0;
                    while (true) {
                        int i11 = i10 + 1;
                        o oVar2 = o.f32141a;
                        String format3 = String.format(Locale.ROOT, "%s[%d]", Arrays.copyOf(new Object[]{str, Integer.valueOf(i10)}, 2));
                        j.f(format3, "java.lang.String.format(locale, format, *args)");
                        Object p10 = aVar.p(i10);
                        j.f(p10, "jsonArray.opt(i)");
                        processGraphObjectProperty(format3, p10, keyValueSerializer, z10);
                        if (i11 < o10) {
                            i10 = i11;
                        } else {
                            return;
                        }
                    }
                }
            } else if (String.class.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls)) {
                keyValueSerializer.writeString(str, obj.toString());
            } else if (Date.class.isAssignableFrom(cls)) {
                String format4 = new SimpleDateFormat(GraphRequest.ISO_8601_FORMAT_STRING, Locale.US).format((Date) obj);
                j.f(format4, "iso8601DateFormat.format(date)");
                keyValueSerializer.writeString(str, format4);
            } else {
                Utility utility = Utility.INSTANCE;
                Utility.logd(GraphRequest.TAG, "The type of property " + str + " in the graph object is unknown. It won't be sent in the request.");
            }
        }

        private final void processRequest(GraphRequestBatch graphRequestBatch, Logger logger, int i10, URL url, OutputStream outputStream, boolean z10) {
            Serializer serializer = new Serializer(outputStream, logger, z10);
            boolean z11 = false;
            if (i10 == 1) {
                GraphRequest graphRequest = graphRequestBatch.get(0);
                HashMap hashMap = new HashMap();
                for (String next : graphRequest.getParameters().keySet()) {
                    Object obj = graphRequest.getParameters().get(next);
                    if (isSupportedAttachmentType(obj)) {
                        j.f(next, SDKConstants.PARAM_KEY);
                        hashMap.put(next, new Attachment(graphRequest, obj));
                    }
                }
                if (logger != null) {
                    logger.append("  Parameters:\n");
                }
                serializeParameters(graphRequest.getParameters(), serializer, graphRequest);
                if (logger != null) {
                    logger.append("  Attachments:\n");
                }
                serializeAttachments(hashMap, serializer);
                b graphObject = graphRequest.getGraphObject();
                if (graphObject != null) {
                    String path = url.getPath();
                    j.f(path, "url.path");
                    processGraphObject(graphObject, path, serializer);
                    return;
                }
                return;
            }
            String batchAppId = getBatchAppId(graphRequestBatch);
            if (batchAppId.length() == 0) {
                z11 = true;
            }
            if (!z11) {
                serializer.writeString(GraphRequest.BATCH_APP_ID_PARAM, batchAppId);
                HashMap hashMap2 = new HashMap();
                serializeRequestsAsJSON(serializer, graphRequestBatch, hashMap2);
                if (logger != null) {
                    logger.append("  Attachments:\n");
                }
                serializeAttachments(hashMap2, serializer);
                return;
            }
            throw new FacebookException("App ID was not specified at the request or Settings.");
        }

        /* access modifiers changed from: private */
        /* renamed from: runCallbacks$lambda-2  reason: not valid java name */
        public static final void m30runCallbacks$lambda2(ArrayList arrayList, GraphRequestBatch graphRequestBatch) {
            j.g(arrayList, "$callbacks");
            j.g(graphRequestBatch, "$requests");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                Object obj = pair.second;
                j.f(obj, "pair.second");
                ((Callback) pair.first).onCompleted((GraphResponse) obj);
            }
            for (GraphRequestBatch.Callback onBatchCompleted : graphRequestBatch.getCallbacks()) {
                onBatchCompleted.onBatchCompleted(graphRequestBatch);
            }
        }

        private final void serializeAttachments(Map<String, Attachment> map, Serializer serializer) {
            for (Map.Entry next : map.entrySet()) {
                if (GraphRequest.Companion.isSupportedAttachmentType(((Attachment) next.getValue()).getValue())) {
                    serializer.writeObject((String) next.getKey(), ((Attachment) next.getValue()).getValue(), ((Attachment) next.getValue()).getRequest());
                }
            }
        }

        private final void serializeParameters(Bundle bundle, Serializer serializer, GraphRequest graphRequest) {
            for (String next : bundle.keySet()) {
                Object obj = bundle.get(next);
                if (isSupportedParameterType(obj)) {
                    j.f(next, SDKConstants.PARAM_KEY);
                    serializer.writeObject(next, obj, graphRequest);
                }
            }
        }

        private final void serializeRequestsAsJSON(Serializer serializer, Collection<GraphRequest> collection, Map<String, Attachment> map) {
            a aVar = new a();
            for (GraphRequest access$serializeToBatch : collection) {
                access$serializeToBatch.serializeToBatch(aVar, map);
            }
            serializer.writeRequestsAsJson(GraphRequest.BATCH_PARAM, aVar, collection);
        }

        private final void setConnectionContentType(HttpURLConnection httpURLConnection, boolean z10) {
            if (z10) {
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty(GraphRequest.CONTENT_ENCODING_HEADER, "gzip");
                return;
            }
            httpURLConnection.setRequestProperty("Content-Type", getMimeContentType());
        }

        public final GraphResponse executeAndWait(GraphRequest graphRequest) {
            j.g(graphRequest, "request");
            List<GraphResponse> executeBatchAndWait = executeBatchAndWait(graphRequest);
            if (executeBatchAndWait.size() == 1) {
                return executeBatchAndWait.get(0);
            }
            throw new FacebookException("invalid state: expected a single response");
        }

        public final List<GraphResponse> executeBatchAndWait(GraphRequest... graphRequestArr) {
            j.g(graphRequestArr, "requests");
            return executeBatchAndWait((Collection<GraphRequest>) l.p0(graphRequestArr));
        }

        public final GraphRequestAsyncTask executeBatchAsync(GraphRequest... graphRequestArr) {
            j.g(graphRequestArr, "requests");
            return executeBatchAsync((Collection<GraphRequest>) l.p0(graphRequestArr));
        }

        public final List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, Collection<GraphRequest> collection) {
            j.g(httpURLConnection, ModelDeeplinkData.VALUE_PAGE_CONNECTION);
            j.g(collection, "requests");
            return executeConnectionAndWait(httpURLConnection, new GraphRequestBatch(collection));
        }

        public final GraphRequestAsyncTask executeConnectionAsync(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
            j.g(httpURLConnection, ModelDeeplinkData.VALUE_PAGE_CONNECTION);
            j.g(graphRequestBatch, "requests");
            return executeConnectionAsync((Handler) null, httpURLConnection, graphRequestBatch);
        }

        public final String getDefaultBatchApplicationId() {
            return GraphRequest.defaultBatchApplicationId;
        }

        public final GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken, Context context, String str, Callback callback) {
            String str2;
            j.g(context, IdentityHttpResponse.CONTEXT);
            if (str == null && accessToken != null) {
                str = accessToken.getApplicationId();
            }
            if (str == null) {
                str = Utility.getMetadataApplicationId(context);
            }
            if (str != null) {
                String p10 = j.p(str, "/custom_audience_third_party_id");
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(context);
                Bundle bundle = new Bundle();
                if (accessToken == null) {
                    if (attributionIdentifiers != null) {
                        if (attributionIdentifiers.getAttributionId() != null) {
                            str2 = attributionIdentifiers.getAttributionId();
                        } else {
                            str2 = attributionIdentifiers.getAndroidAdvertiserId();
                        }
                        if (str2 != null) {
                            bundle.putString("udid", str2);
                        }
                    } else {
                        throw new FacebookException("There is no access token and attribution identifiers could not be retrieved");
                    }
                }
                if (FacebookSdk.getLimitEventAndDataUsage(context) || (attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited())) {
                    bundle.putString("limit_event_usage", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                }
                return new GraphRequest(accessToken, p10, bundle, HttpMethod.GET, callback, (String) null, 32, (DefaultConstructorMarker) null);
            }
            throw new FacebookException("Facebook App ID cannot be determined");
        }

        public final GraphRequest newDeleteObjectRequest(AccessToken accessToken, String str, Callback callback) {
            return new GraphRequest(accessToken, str, (Bundle) null, HttpMethod.DELETE, callback, (String) null, 32, (DefaultConstructorMarker) null);
        }

        public final GraphRequest newGraphPathRequest(AccessToken accessToken, String str, Callback callback) {
            return new GraphRequest(accessToken, str, (Bundle) null, (HttpMethod) null, callback, (String) null, 32, (DefaultConstructorMarker) null);
        }

        public final GraphRequest newMeRequest(AccessToken accessToken, GraphJSONObjectCallback graphJSONObjectCallback) {
            return new GraphRequest(accessToken, "me", (Bundle) null, (HttpMethod) null, new s(graphJSONObjectCallback), (String) null, 32, (DefaultConstructorMarker) null);
        }

        public final GraphRequest newMyFriendsRequest(AccessToken accessToken, GraphJSONArrayCallback graphJSONArrayCallback) {
            return new GraphRequest(accessToken, GraphRequest.MY_FRIENDS, (Bundle) null, (HttpMethod) null, new GraphRequest$Companion$newMyFriendsRequest$wrapper$1(graphJSONArrayCallback), (String) null, 32, (DefaultConstructorMarker) null);
        }

        public final GraphRequest newPlacesSearchRequest(AccessToken accessToken, Location location, int i10, int i11, String str, GraphJSONArrayCallback graphJSONArrayCallback) {
            if (location != null || !Utility.isNullOrEmpty(str)) {
                Bundle bundle = new Bundle(5);
                bundle.putString("type", "place");
                bundle.putInt(FacebookParse.FB_PARAM_FIELD_LIMIT, i11);
                if (location != null) {
                    o oVar = o.f32141a;
                    String format2 = String.format(Locale.US, "%f,%f", Arrays.copyOf(new Object[]{Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())}, 2));
                    j.f(format2, "java.lang.String.format(locale, format, *args)");
                    bundle.putString("center", format2);
                    bundle.putInt("distance", i10);
                }
                if (!Utility.isNullOrEmpty(str)) {
                    bundle.putString(XHTMLText.Q, str);
                }
                return new GraphRequest(accessToken, "search", bundle, HttpMethod.GET, new t(graphJSONArrayCallback), (String) null, 32, (DefaultConstructorMarker) null);
            }
            throw new FacebookException("Either location or searchText must be specified.");
        }

        public final GraphRequest newPostRequest(AccessToken accessToken, String str, b bVar, Callback callback) {
            GraphRequest graphRequest = new GraphRequest(accessToken, str, (Bundle) null, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
            graphRequest.setGraphObject(bVar);
            return graphRequest;
        }

        public final GraphRequest newPostRequestWithBundle(AccessToken accessToken, String str, Bundle bundle, Callback callback) {
            return new GraphRequest(accessToken, str, bundle, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
        }

        public final GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, Bitmap bitmap, String str2, Bundle bundle, Callback callback) {
            Bitmap bitmap2 = bitmap;
            String str3 = str2;
            Bundle bundle2 = bundle;
            j.g(bitmap2, "image");
            Bundle bundle3 = new Bundle();
            if (bundle2 != null) {
                bundle3.putAll(bundle2);
            }
            bundle3.putParcelable("picture", bitmap2);
            if (str3 != null) {
                if (str2.length() > 0) {
                    bundle3.putString("caption", str3);
                }
            }
            String str4 = str;
            return new GraphRequest(accessToken, getDefaultPhotoPathIfNull(str), bundle3, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
        }

        public final void runCallbacks$facebook_core_release(GraphRequestBatch graphRequestBatch, List<GraphResponse> list) {
            Boolean bool;
            j.g(graphRequestBatch, "requests");
            j.g(list, "responses");
            int size = graphRequestBatch.size();
            ArrayList arrayList = new ArrayList();
            if (size > 0) {
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    GraphRequest graphRequest = graphRequestBatch.get(i10);
                    if (graphRequest.getCallback() != null) {
                        arrayList.add(new Pair(graphRequest.getCallback(), list.get(i10)));
                    }
                    if (i11 >= size) {
                        break;
                    }
                    i10 = i11;
                }
            }
            if (arrayList.size() > 0) {
                q qVar = new q(arrayList, graphRequestBatch);
                Handler callbackHandler = graphRequestBatch.getCallbackHandler();
                if (callbackHandler == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(callbackHandler.post(qVar));
                }
                if (bool == null) {
                    qVar.run();
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x00f2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void serializeToUrlConnection$facebook_core_release(com.facebook.GraphRequestBatch r14, java.net.HttpURLConnection r15) throws java.io.IOException, org.json.JSONException {
            /*
                r13 = this;
                java.lang.String r0 = "requests"
                kotlin.jvm.internal.j.g(r14, r0)
                java.lang.String r0 = "connection"
                kotlin.jvm.internal.j.g(r15, r0)
                com.facebook.internal.Logger r0 = new com.facebook.internal.Logger
                com.facebook.LoggingBehavior r1 = com.facebook.LoggingBehavior.REQUESTS
                java.lang.String r2 = "Request"
                r0.<init>(r1, r2)
                int r10 = r14.size()
                boolean r11 = r13.isGzipCompressible(r14)
                r1 = 0
                r2 = 0
                r3 = 1
                if (r10 != r3) goto L_0x0029
                com.facebook.GraphRequest r4 = r14.get((int) r1)
                com.facebook.HttpMethod r4 = r4.getHttpMethod()
                goto L_0x002a
            L_0x0029:
                r4 = r2
            L_0x002a:
                if (r4 != 0) goto L_0x002e
                com.facebook.HttpMethod r4 = com.facebook.HttpMethod.POST
            L_0x002e:
                java.lang.String r5 = r4.name()
                r15.setRequestMethod(r5)
                r13.setConnectionContentType(r15, r11)
                java.net.URL r12 = r15.getURL()
                java.lang.String r5 = "Request:\n"
                r0.append((java.lang.String) r5)
                java.lang.String r5 = r14.getId()
                java.lang.String r6 = "Id"
                r0.appendKeyValue(r6, r5)
                java.lang.String r5 = "url"
                kotlin.jvm.internal.j.f(r12, r5)
                java.lang.String r5 = "URL"
                r0.appendKeyValue(r5, r12)
                java.lang.String r5 = r15.getRequestMethod()
                java.lang.String r6 = "connection.requestMethod"
                kotlin.jvm.internal.j.f(r5, r6)
                java.lang.String r6 = "Method"
                r0.appendKeyValue(r6, r5)
                java.lang.String r5 = "User-Agent"
                java.lang.String r6 = r15.getRequestProperty(r5)
                java.lang.String r7 = "connection.getRequestProperty(\"User-Agent\")"
                kotlin.jvm.internal.j.f(r6, r7)
                r0.appendKeyValue(r5, r6)
                java.lang.String r5 = "Content-Type"
                java.lang.String r6 = r15.getRequestProperty(r5)
                java.lang.String r7 = "connection.getRequestProperty(\"Content-Type\")"
                kotlin.jvm.internal.j.f(r6, r7)
                r0.appendKeyValue(r5, r6)
                int r5 = r14.getTimeout()
                r15.setConnectTimeout(r5)
                int r5 = r14.getTimeout()
                r15.setReadTimeout(r5)
                com.facebook.HttpMethod r5 = com.facebook.HttpMethod.POST
                if (r4 != r5) goto L_0x0091
                r1 = r3
            L_0x0091:
                if (r1 != 0) goto L_0x0097
                r0.log()
                return
            L_0x0097:
                r15.setDoOutput(r3)
                java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00ee }
                java.io.OutputStream r15 = r15.getOutputStream()     // Catch:{ all -> 0x00ee }
                r1.<init>(r15)     // Catch:{ all -> 0x00ee }
                if (r11 == 0) goto L_0x00ae
                java.util.zip.GZIPOutputStream r15 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x00ab }
                r15.<init>(r1)     // Catch:{ all -> 0x00ab }
                goto L_0x00af
            L_0x00ab:
                r14 = move-exception
                r2 = r1
                goto L_0x00ef
            L_0x00ae:
                r15 = r1
            L_0x00af:
                boolean r1 = r13.hasOnProgressCallbacks(r14)     // Catch:{ all -> 0x00eb }
                if (r1 == 0) goto L_0x00da
                com.facebook.ProgressNoopOutputStream r1 = new com.facebook.ProgressNoopOutputStream     // Catch:{ all -> 0x00eb }
                android.os.Handler r2 = r14.getCallbackHandler()     // Catch:{ all -> 0x00eb }
                r1.<init>(r2)     // Catch:{ all -> 0x00eb }
                r5 = 0
                r3 = r13
                r4 = r14
                r6 = r10
                r7 = r12
                r8 = r1
                r9 = r11
                r3.processRequest(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00eb }
                int r2 = r1.getMaxProgress()     // Catch:{ all -> 0x00eb }
                java.util.Map r5 = r1.getProgressMap()     // Catch:{ all -> 0x00eb }
                com.facebook.ProgressOutputStream r1 = new com.facebook.ProgressOutputStream     // Catch:{ all -> 0x00eb }
                long r6 = (long) r2     // Catch:{ all -> 0x00eb }
                r2 = r1
                r3 = r15
                r4 = r14
                r2.<init>(r3, r4, r5, r6)     // Catch:{ all -> 0x00eb }
                r15 = r1
            L_0x00da:
                r1 = r13
                r2 = r14
                r3 = r0
                r4 = r10
                r5 = r12
                r6 = r15
                r7 = r11
                r1.processRequest(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00eb }
                r15.close()
                r0.log()
                return
            L_0x00eb:
                r14 = move-exception
                r2 = r15
                goto L_0x00ef
            L_0x00ee:
                r14 = move-exception
            L_0x00ef:
                if (r2 != 0) goto L_0x00f2
                goto L_0x00f5
            L_0x00f2:
                r2.close()
            L_0x00f5:
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.Companion.serializeToUrlConnection$facebook_core_release(com.facebook.GraphRequestBatch, java.net.HttpURLConnection):void");
        }

        public final void setDefaultBatchApplicationId(String str) {
            GraphRequest.defaultBatchApplicationId = str;
        }

        public final HttpURLConnection toHttpConnection(GraphRequest... graphRequestArr) {
            j.g(graphRequestArr, "requests");
            return toHttpConnection((Collection<GraphRequest>) l.p0(graphRequestArr));
        }

        public final void validateFieldsParamForGetRequests$facebook_core_release(GraphRequestBatch graphRequestBatch) {
            j.g(graphRequestBatch, "requests");
            Iterator it = graphRequestBatch.iterator();
            while (it.hasNext()) {
                GraphRequest graphRequest = (GraphRequest) it.next();
                if (HttpMethod.GET == graphRequest.getHttpMethod()) {
                    Utility utility = Utility.INSTANCE;
                    if (Utility.isNullOrEmpty(graphRequest.getParameters().getString("fields"))) {
                        Logger.Companion companion = Logger.Companion;
                        LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("GET requests for /");
                        String graphPath = graphRequest.getGraphPath();
                        if (graphPath == null) {
                            graphPath = "";
                        }
                        sb2.append(graphPath);
                        sb2.append(" should contain an explicit \"fields\" parameter.");
                        companion.log(loggingBehavior, 5, "Request", sb2.toString());
                    }
                }
            }
        }

        public final List<GraphResponse> executeBatchAndWait(Collection<GraphRequest> collection) {
            j.g(collection, "requests");
            return executeBatchAndWait(new GraphRequestBatch(collection));
        }

        public final GraphRequestAsyncTask executeBatchAsync(Collection<GraphRequest> collection) {
            j.g(collection, "requests");
            return executeBatchAsync(new GraphRequestBatch(collection));
        }

        public final List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
            j.g(httpURLConnection, ModelDeeplinkData.VALUE_PAGE_CONNECTION);
            j.g(graphRequestBatch, "requests");
            List<GraphResponse> fromHttpConnection$facebook_core_release = GraphResponse.Companion.fromHttpConnection$facebook_core_release(httpURLConnection, graphRequestBatch);
            Utility.disconnectQuietly(httpURLConnection);
            int size = graphRequestBatch.size();
            if (size == fromHttpConnection$facebook_core_release.size()) {
                runCallbacks$facebook_core_release(graphRequestBatch, fromHttpConnection$facebook_core_release);
                AccessTokenManager.Companion.getInstance().extendAccessTokenIfNeeded();
                return fromHttpConnection$facebook_core_release;
            }
            o oVar = o.f32141a;
            String format2 = String.format(Locale.US, "Received %d responses while expecting %d", Arrays.copyOf(new Object[]{Integer.valueOf(fromHttpConnection$facebook_core_release.size()), Integer.valueOf(size)}, 2));
            j.f(format2, "java.lang.String.format(locale, format, *args)");
            throw new FacebookException(format2);
        }

        public final GraphRequestAsyncTask executeConnectionAsync(Handler handler, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
            j.g(httpURLConnection, ModelDeeplinkData.VALUE_PAGE_CONNECTION);
            j.g(graphRequestBatch, "requests");
            GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(httpURLConnection, graphRequestBatch);
            graphRequestBatch.setCallbackHandler(handler);
            graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
            return graphRequestAsyncTask;
        }

        public final HttpURLConnection toHttpConnection(Collection<GraphRequest> collection) {
            j.g(collection, "requests");
            Validate.notEmpty(collection, "requests");
            return toHttpConnection(new GraphRequestBatch(collection));
        }

        public final List<GraphResponse> executeBatchAndWait(GraphRequestBatch graphRequestBatch) {
            Exception exc;
            HttpURLConnection httpURLConnection;
            List<GraphResponse> list;
            j.g(graphRequestBatch, "requests");
            Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
            HttpURLConnection httpURLConnection2 = null;
            try {
                httpURLConnection = toHttpConnection(graphRequestBatch);
                exc = null;
            } catch (Exception e10) {
                exc = e10;
                httpURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                Utility.disconnectQuietly(httpURLConnection2);
                throw th;
            }
            if (httpURLConnection != null) {
                try {
                    list = executeConnectionAndWait(httpURLConnection, graphRequestBatch);
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection2 = httpURLConnection;
                    Utility.disconnectQuietly(httpURLConnection2);
                    throw th;
                }
            } else {
                List<GraphResponse> constructErrorResponses = GraphResponse.Companion.constructErrorResponses(graphRequestBatch.getRequests(), (HttpURLConnection) null, new FacebookException((Throwable) exc));
                runCallbacks$facebook_core_release(graphRequestBatch, constructErrorResponses);
                list = constructErrorResponses;
            }
            Utility.disconnectQuietly(httpURLConnection);
            return list;
        }

        public final GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch graphRequestBatch) {
            j.g(graphRequestBatch, "requests");
            Validate.notEmptyAndContainsNoNulls(graphRequestBatch, "requests");
            GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequestAsyncTask(graphRequestBatch);
            graphRequestAsyncTask.executeOnExecutor(FacebookSdk.getExecutor(), new Void[0]);
            return graphRequestAsyncTask;
        }

        public final HttpURLConnection toHttpConnection(GraphRequestBatch graphRequestBatch) {
            URL url;
            j.g(graphRequestBatch, "requests");
            validateFieldsParamForGetRequests$facebook_core_release(graphRequestBatch);
            try {
                if (graphRequestBatch.size() == 1) {
                    url = new URL(graphRequestBatch.get(0).getUrlForSingleRequest());
                } else {
                    url = new URL(ServerProtocol.getGraphUrlBase());
                }
                HttpURLConnection httpURLConnection = null;
                try {
                    httpURLConnection = createConnection(url);
                    serializeToUrlConnection$facebook_core_release(graphRequestBatch, httpURLConnection);
                    return httpURLConnection;
                } catch (IOException e10) {
                    Utility.disconnectQuietly(httpURLConnection);
                    throw new FacebookException("could not construct request body", (Throwable) e10);
                } catch (JSONException e11) {
                    Utility.disconnectQuietly(httpURLConnection);
                    throw new FacebookException("could not construct request body", (Throwable) e11);
                }
            } catch (MalformedURLException e12) {
                throw new FacebookException("could not construct URL for request", (Throwable) e12);
            }
        }

        public final GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, File file, String str2, Bundle bundle, Callback callback) throws FileNotFoundException {
            j.g(file, "file");
            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            bundle2.putParcelable("picture", open);
            if (str2 != null) {
                if (str2.length() > 0) {
                    bundle2.putString("caption", str2);
                }
            }
            return new GraphRequest(accessToken, getDefaultPhotoPathIfNull(str), bundle2, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
        }

        public final GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken, Context context, Callback callback) {
            j.g(context, IdentityHttpResponse.CONTEXT);
            return newCustomAudienceThirdPartyIdRequest(accessToken, context, (String) null, callback);
        }

        public final GraphRequest newUploadPhotoRequest(AccessToken accessToken, String str, Uri uri, String str2, Bundle bundle, Callback callback) throws FileNotFoundException, FacebookException {
            Uri uri2 = uri;
            String str3 = str2;
            Bundle bundle2 = bundle;
            j.g(uri, "photoUri");
            if (Utility.isFileUri(uri)) {
                return newUploadPhotoRequest(accessToken, str, new File(uri.getPath()), str2, bundle, callback);
            } else if (Utility.isContentUri(uri)) {
                Bundle bundle3 = new Bundle();
                if (bundle2 != null) {
                    bundle3.putAll(bundle2);
                }
                bundle3.putParcelable("picture", uri);
                if (str3 != null) {
                    if (str2.length() > 0) {
                        bundle3.putString("caption", str3);
                    }
                }
                String str4 = str;
                return new GraphRequest(accessToken, getDefaultPhotoPathIfNull(str), bundle3, HttpMethod.POST, callback, (String) null, 32, (DefaultConstructorMarker) null);
            } else {
                throw new FacebookException("The photo Uri must be either a file:// or content:// Uri");
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¨\u0006\b"}, d2 = {"Lcom/facebook/GraphRequest$GraphJSONArrayCallback;", "", "Lorg/json/a;", "objects", "Lcom/facebook/GraphResponse;", "response", "", "onCompleted", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface GraphJSONArrayCallback {
        void onCompleted(a aVar, GraphResponse graphResponse);
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¨\u0006\b"}, d2 = {"Lcom/facebook/GraphRequest$GraphJSONObjectCallback;", "", "Lorg/json/b;", "obj", "Lcom/facebook/GraphResponse;", "response", "", "onCompleted", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface GraphJSONObjectCallback {
        void onCompleted(b bVar, GraphResponse graphResponse);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bâ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/facebook/GraphRequest$KeyValueSerializer;", "", "writeString", "", "key", "", "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private interface KeyValueSerializer {
        void writeString(String str, String str2);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/facebook/GraphRequest$OnProgressCallback;", "Lcom/facebook/GraphRequest$Callback;", "onProgress", "", "current", "", "max", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface OnProgressCallback extends Callback {
        void onProgress(long j10, long j11);
    }

    @Metadata(bv = {}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010)\u001a\u00020(\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\u0006\u00101\u001a\u00020.¢\u0006\u0004\b7\u00108J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J$\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\fJ\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002J \u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u001d\u001a\u00020\bJ$\u0010!\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u0002J-\u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00022\u0016\u0010$\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040#\"\u0004\u0018\u00010\u0004¢\u0006\u0004\b%\u0010&J-\u0010'\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00022\u0016\u0010$\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040#\"\u0004\u0018\u00010\u0004¢\u0006\u0004\b'\u0010&R\u0014\u0010)\u001a\u00020(8\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u0004\u0018\u00010+8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020.8\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00100R\u0018\u00106\u001a\u000602j\u0002`38BX\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/facebook/GraphRequest$Serializer;", "Lcom/facebook/GraphRequest$KeyValueSerializer;", "", "key", "", "value", "Lcom/facebook/GraphRequest;", "request", "", "writeObject", "Lorg/json/a;", "requestJsonArray", "", "requests", "writeRequestsAsJson", "writeString", "Landroid/graphics/Bitmap;", "bitmap", "writeBitmap", "", "bytes", "writeBytes", "Landroid/net/Uri;", "contentUri", "mimeType", "writeContentUri", "Landroid/os/ParcelFileDescriptor;", "descriptor", "writeFile", "writeRecordBoundary", "name", "filename", "contentType", "writeContentDisposition", "format", "", "args", "write", "(Ljava/lang/String;[Ljava/lang/Object;)V", "writeLine", "Ljava/io/OutputStream;", "outputStream", "Ljava/io/OutputStream;", "Lcom/facebook/internal/Logger;", "logger", "Lcom/facebook/internal/Logger;", "", "firstWrite", "Z", "useUrlEncode", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "getInvalidTypeError", "()Ljava/lang/RuntimeException;", "invalidTypeError", "<init>", "(Ljava/io/OutputStream;Lcom/facebook/internal/Logger;Z)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class Serializer implements KeyValueSerializer {
        private boolean firstWrite = true;
        private final Logger logger;
        private final OutputStream outputStream;
        private final boolean useUrlEncode;

        public Serializer(OutputStream outputStream2, Logger logger2, boolean z10) {
            j.g(outputStream2, "outputStream");
            this.outputStream = outputStream2;
            this.logger = logger2;
            this.useUrlEncode = z10;
        }

        private final RuntimeException getInvalidTypeError() {
            return new IllegalArgumentException("value is not a supported type.");
        }

        public final void write(String str, Object... objArr) {
            j.g(str, GraphRequest.FORMAT_PARAM);
            j.g(objArr, "args");
            if (!this.useUrlEncode) {
                if (this.firstWrite) {
                    OutputStream outputStream2 = this.outputStream;
                    Charset charset = d.f32216b;
                    byte[] bytes = HelpFormatter.DEFAULT_LONG_OPT_PREFIX.getBytes(charset);
                    j.f(bytes, "(this as java.lang.String).getBytes(charset)");
                    outputStream2.write(bytes);
                    OutputStream outputStream3 = this.outputStream;
                    String access$getMIME_BOUNDARY$cp = GraphRequest.MIME_BOUNDARY;
                    if (access$getMIME_BOUNDARY$cp != null) {
                        byte[] bytes2 = access$getMIME_BOUNDARY$cp.getBytes(charset);
                        j.f(bytes2, "(this as java.lang.String).getBytes(charset)");
                        outputStream3.write(bytes2);
                        OutputStream outputStream4 = this.outputStream;
                        byte[] bytes3 = "\r\n".getBytes(charset);
                        j.f(bytes3, "(this as java.lang.String).getBytes(charset)");
                        outputStream4.write(bytes3);
                        this.firstWrite = false;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                }
                OutputStream outputStream5 = this.outputStream;
                o oVar = o.f32141a;
                Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                String format2 = String.format(str, Arrays.copyOf(copyOf, copyOf.length));
                j.f(format2, "java.lang.String.format(format, *args)");
                Charset charset2 = d.f32216b;
                if (format2 != null) {
                    byte[] bytes4 = format2.getBytes(charset2);
                    j.f(bytes4, "(this as java.lang.String).getBytes(charset)");
                    outputStream5.write(bytes4);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            OutputStream outputStream6 = this.outputStream;
            o oVar2 = o.f32141a;
            Locale locale = Locale.US;
            Object[] copyOf2 = Arrays.copyOf(objArr, objArr.length);
            String format3 = String.format(locale, str, Arrays.copyOf(copyOf2, copyOf2.length));
            j.f(format3, "java.lang.String.format(locale, format, *args)");
            String encode = URLEncoder.encode(format3, "UTF-8");
            j.f(encode, "encode(String.format(Locale.US, format, *args), \"UTF-8\")");
            byte[] bytes5 = encode.getBytes(d.f32216b);
            j.f(bytes5, "(this as java.lang.String).getBytes(charset)");
            outputStream6.write(bytes5);
        }

        public final void writeBitmap(String str, Bitmap bitmap) {
            j.g(str, SDKConstants.PARAM_KEY);
            j.g(bitmap, "bitmap");
            writeContentDisposition(str, str, "image/png");
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.outputStream);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                logger2.appendKeyValue(j.p("    ", str), "<Image>");
            }
        }

        public final void writeBytes(String str, byte[] bArr) {
            j.g(str, SDKConstants.PARAM_KEY);
            j.g(bArr, "bytes");
            writeContentDisposition(str, str, "content/unknown");
            this.outputStream.write(bArr);
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                String p10 = j.p("    ", str);
                o oVar = o.f32141a;
                String format2 = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(bArr.length)}, 1));
                j.f(format2, "java.lang.String.format(locale, format, *args)");
                logger2.appendKeyValue(p10, format2);
            }
        }

        public final void writeContentDisposition(String str, String str2, String str3) {
            if (!this.useUrlEncode) {
                write("Content-Disposition: form-data; name=\"%s\"", str);
                if (str2 != null) {
                    write("; filename=\"%s\"", str2);
                }
                writeLine("", new Object[0]);
                if (str3 != null) {
                    writeLine("%s: %s", "Content-Type", str3);
                }
                writeLine("", new Object[0]);
                return;
            }
            OutputStream outputStream2 = this.outputStream;
            o oVar = o.f32141a;
            String format2 = String.format("%s=", Arrays.copyOf(new Object[]{str}, 1));
            j.f(format2, "java.lang.String.format(format, *args)");
            Charset charset = d.f32216b;
            if (format2 != null) {
                byte[] bytes = format2.getBytes(charset);
                j.f(bytes, "(this as java.lang.String).getBytes(charset)");
                outputStream2.write(bytes);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }

        public final void writeContentUri(String str, Uri uri, String str2) {
            int i10;
            j.g(str, SDKConstants.PARAM_KEY);
            j.g(uri, "contentUri");
            if (str2 == null) {
                str2 = "content/unknown";
            }
            writeContentDisposition(str, str, str2);
            if (this.outputStream instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) this.outputStream).addProgress(Utility.getContentSize(uri));
                i10 = 0;
            } else {
                InputStream openInputStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri);
                Utility utility = Utility.INSTANCE;
                i10 = Utility.copyAndCloseInputStream(openInputStream, this.outputStream) + 0;
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                String p10 = j.p("    ", str);
                o oVar = o.f32141a;
                String format2 = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1));
                j.f(format2, "java.lang.String.format(locale, format, *args)");
                logger2.appendKeyValue(p10, format2);
            }
        }

        public final void writeFile(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) {
            int i10;
            j.g(str, SDKConstants.PARAM_KEY);
            j.g(parcelFileDescriptor, "descriptor");
            if (str2 == null) {
                str2 = "content/unknown";
            }
            writeContentDisposition(str, str, str2);
            OutputStream outputStream2 = this.outputStream;
            if (outputStream2 instanceof ProgressNoopOutputStream) {
                ((ProgressNoopOutputStream) outputStream2).addProgress(parcelFileDescriptor.getStatSize());
                i10 = 0;
            } else {
                ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
                Utility utility = Utility.INSTANCE;
                i10 = Utility.copyAndCloseInputStream(autoCloseInputStream, this.outputStream) + 0;
            }
            writeLine("", new Object[0]);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                String p10 = j.p("    ", str);
                o oVar = o.f32141a;
                String format2 = String.format(Locale.ROOT, "<Data: %d>", Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1));
                j.f(format2, "java.lang.String.format(locale, format, *args)");
                logger2.appendKeyValue(p10, format2);
            }
        }

        public final void writeLine(String str, Object... objArr) {
            j.g(str, GraphRequest.FORMAT_PARAM);
            j.g(objArr, "args");
            write(str, Arrays.copyOf(objArr, objArr.length));
            if (!this.useUrlEncode) {
                write("\r\n", new Object[0]);
            }
        }

        public final void writeObject(String str, Object obj, GraphRequest graphRequest) {
            j.g(str, SDKConstants.PARAM_KEY);
            OutputStream outputStream2 = this.outputStream;
            if (outputStream2 instanceof RequestOutputStream) {
                ((RequestOutputStream) outputStream2).setCurrentRequest(graphRequest);
            }
            Companion companion = GraphRequest.Companion;
            if (companion.isSupportedParameterType(obj)) {
                writeString(str, companion.parameterToString(obj));
            } else if (obj instanceof Bitmap) {
                writeBitmap(str, (Bitmap) obj);
            } else if (obj instanceof byte[]) {
                writeBytes(str, (byte[]) obj);
            } else if (obj instanceof Uri) {
                writeContentUri(str, (Uri) obj, (String) null);
            } else if (obj instanceof ParcelFileDescriptor) {
                writeFile(str, (ParcelFileDescriptor) obj, (String) null);
            } else if (obj instanceof ParcelableResourceWithMimeType) {
                ParcelableResourceWithMimeType parcelableResourceWithMimeType = (ParcelableResourceWithMimeType) obj;
                Parcelable resource = parcelableResourceWithMimeType.getResource();
                String mimeType = parcelableResourceWithMimeType.getMimeType();
                if (resource instanceof ParcelFileDescriptor) {
                    writeFile(str, (ParcelFileDescriptor) resource, mimeType);
                } else if (resource instanceof Uri) {
                    writeContentUri(str, (Uri) resource, mimeType);
                } else {
                    throw getInvalidTypeError();
                }
            } else {
                throw getInvalidTypeError();
            }
        }

        public final void writeRecordBoundary() {
            if (!this.useUrlEncode) {
                writeLine("--%s", GraphRequest.MIME_BOUNDARY);
                return;
            }
            OutputStream outputStream2 = this.outputStream;
            byte[] bytes = "&".getBytes(d.f32216b);
            j.f(bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream2.write(bytes);
        }

        public final void writeRequestsAsJson(String str, a aVar, Collection<GraphRequest> collection) {
            j.g(str, SDKConstants.PARAM_KEY);
            j.g(aVar, "requestJsonArray");
            j.g(collection, "requests");
            OutputStream outputStream2 = this.outputStream;
            if (!(outputStream2 instanceof RequestOutputStream)) {
                String aVar2 = aVar.toString();
                j.f(aVar2, "requestJsonArray.toString()");
                writeString(str, aVar2);
                return;
            }
            RequestOutputStream requestOutputStream = (RequestOutputStream) outputStream2;
            writeContentDisposition(str, (String) null, (String) null);
            write("[", new Object[0]);
            int i10 = 0;
            for (GraphRequest currentRequest : collection) {
                int i11 = i10 + 1;
                b j10 = aVar.j(i10);
                requestOutputStream.setCurrentRequest(currentRequest);
                if (i10 > 0) {
                    write(",%s", j10.toString());
                } else {
                    write("%s", j10.toString());
                }
                i10 = i11;
            }
            write("]", new Object[0]);
            Logger logger2 = this.logger;
            if (logger2 != null) {
                String p10 = j.p("    ", str);
                String aVar3 = aVar.toString();
                j.f(aVar3, "requestJsonArray.toString()");
                logger2.appendKeyValue(p10, aVar3);
            }
        }

        public void writeString(String str, String str2) {
            j.g(str, SDKConstants.PARAM_KEY);
            j.g(str2, "value");
            writeContentDisposition(str, (String) null, (String) null);
            writeLine("%s", str2);
            writeRecordBoundary();
            Logger logger2 = this.logger;
            if (logger2 != null) {
                logger2.appendKeyValue(j.p("    ", str), str2);
            }
        }
    }

    static {
        char[] charArray = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        j.f(charArray, "(this as java.lang.String).toCharArray()");
        StringBuilder sb2 = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        int nextInt = secureRandom.nextInt(11) + 30;
        if (nextInt > 0) {
            int i10 = 0;
            do {
                i10++;
                sb2.append(charArray[secureRandom.nextInt(charArray.length)]);
            } while (i10 < nextInt);
        }
        String sb3 = sb2.toString();
        j.f(sb3, "buffer.toString()");
        MIME_BOUNDARY = sb3;
    }

    public GraphRequest() {
        this((AccessToken) null, (String) null, (Bundle) null, (HttpMethod) null, (Callback) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public GraphRequest(AccessToken accessToken2) {
        this(accessToken2, (String) null, (Bundle) null, (HttpMethod) null, (Callback) null, (String) null, 62, (DefaultConstructorMarker) null);
    }

    public GraphRequest(AccessToken accessToken2, String str) {
        this(accessToken2, str, (Bundle) null, (HttpMethod) null, (Callback) null, (String) null, 60, (DefaultConstructorMarker) null);
    }

    public GraphRequest(AccessToken accessToken2, String str, Bundle bundle) {
        this(accessToken2, str, bundle, (HttpMethod) null, (Callback) null, (String) null, 56, (DefaultConstructorMarker) null);
    }

    public GraphRequest(AccessToken accessToken2, String str, Bundle bundle, HttpMethod httpMethod2) {
        this(accessToken2, str, bundle, httpMethod2, (Callback) null, (String) null, 48, (DefaultConstructorMarker) null);
    }

    public GraphRequest(AccessToken accessToken2, String str, Bundle bundle, HttpMethod httpMethod2, Callback callback2) {
        this(accessToken2, str, bundle, httpMethod2, callback2, (String) null, 32, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GraphRequest(com.facebook.AccessToken r6, java.lang.String r7, android.os.Bundle r8, com.facebook.HttpMethod r9, com.facebook.GraphRequest.Callback r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.GraphRequest.<init>(com.facebook.AccessToken, java.lang.String, android.os.Bundle, com.facebook.HttpMethod, com.facebook.GraphRequest$Callback, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: _set_callback_$lambda-0  reason: not valid java name */
    public static final void m27_set_callback_$lambda0(Callback callback2, GraphResponse graphResponse) {
        b bVar;
        a aVar;
        String str;
        String str2;
        String str3;
        j.g(graphResponse, "response");
        b jSONObject = graphResponse.getJSONObject();
        if (jSONObject == null) {
            bVar = null;
        } else {
            bVar = jSONObject.optJSONObject(DEBUG_KEY);
        }
        if (bVar == null) {
            aVar = null;
        } else {
            aVar = bVar.optJSONArray("messages");
        }
        if (aVar != null) {
            int i10 = 0;
            int o10 = aVar.o();
            if (o10 > 0) {
                while (true) {
                    int i11 = i10 + 1;
                    b s10 = aVar.s(i10);
                    if (s10 == null) {
                        str = null;
                    } else {
                        str = s10.optString("message");
                    }
                    if (s10 == null) {
                        str2 = null;
                    } else {
                        str2 = s10.optString("type");
                    }
                    if (s10 == null) {
                        str3 = null;
                    } else {
                        str3 = s10.optString("link");
                    }
                    if (!(str == null || str2 == null)) {
                        LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_INFO;
                        if (j.b(str2, DEBUG_SEVERITY_WARNING)) {
                            loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
                        }
                        if (!Utility.isNullOrEmpty(str3)) {
                            str = str + " Link: " + str3;
                        }
                        Logger.Companion companion = Logger.Companion;
                        String str4 = TAG;
                        j.f(str4, "TAG");
                        companion.log(loggingBehavior, str4, str);
                    }
                    if (i11 >= o10) {
                        break;
                    }
                    i10 = i11;
                }
            }
        }
        if (callback2 != null) {
            callback2.onCompleted(graphResponse);
        }
    }

    private final void addCommonParameters() {
        Bundle bundle = this.parameters;
        if (shouldForceClientTokenForRequest()) {
            bundle.putString("access_token", getClientTokenForRequest());
        } else {
            String accessTokenToUseForRequest = getAccessTokenToUseForRequest();
            if (accessTokenToUseForRequest != null) {
                bundle.putString("access_token", accessTokenToUseForRequest);
            }
        }
        if (!bundle.containsKey("access_token")) {
            Utility utility = Utility.INSTANCE;
            Utility.isNullOrEmpty(FacebookSdk.getClientToken());
        }
        bundle.putString("sdk", "android");
        bundle.putString(FORMAT_PARAM, "json");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            bundle.putString(DEBUG_PARAM, "info");
        } else if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            bundle.putString(DEBUG_PARAM, DEBUG_SEVERITY_WARNING);
        }
    }

    private final String appendParametersToBaseUrl(String str, boolean z10) {
        if (!z10 && this.httpMethod == HttpMethod.POST) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (String next : this.parameters.keySet()) {
            Object obj = this.parameters.get(next);
            if (obj == null) {
                obj = "";
            }
            Companion companion = Companion;
            if (companion.isSupportedParameterType(obj)) {
                buildUpon.appendQueryParameter(next, companion.parameterToString(obj).toString());
            } else if (this.httpMethod != HttpMethod.GET) {
                o oVar = o.f32141a;
                String format2 = String.format(Locale.US, "Unsupported parameter type for GET request: %s", Arrays.copyOf(new Object[]{obj.getClass().getSimpleName()}, 1));
                j.f(format2, "java.lang.String.format(locale, format, *args)");
                throw new IllegalArgumentException(format2);
            }
        }
        String builder = buildUpon.toString();
        j.f(builder, "uriBuilder.toString()");
        return builder;
    }

    public static final GraphResponse executeAndWait(GraphRequest graphRequest) {
        return Companion.executeAndWait(graphRequest);
    }

    public static final List<GraphResponse> executeBatchAndWait(GraphRequestBatch graphRequestBatch) {
        return Companion.executeBatchAndWait(graphRequestBatch);
    }

    public static final List<GraphResponse> executeBatchAndWait(Collection<GraphRequest> collection) {
        return Companion.executeBatchAndWait(collection);
    }

    public static final List<GraphResponse> executeBatchAndWait(GraphRequest... graphRequestArr) {
        return Companion.executeBatchAndWait(graphRequestArr);
    }

    public static final GraphRequestAsyncTask executeBatchAsync(GraphRequestBatch graphRequestBatch) {
        return Companion.executeBatchAsync(graphRequestBatch);
    }

    public static final GraphRequestAsyncTask executeBatchAsync(Collection<GraphRequest> collection) {
        return Companion.executeBatchAsync(collection);
    }

    public static final GraphRequestAsyncTask executeBatchAsync(GraphRequest... graphRequestArr) {
        return Companion.executeBatchAsync(graphRequestArr);
    }

    public static final List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        return Companion.executeConnectionAndWait(httpURLConnection, graphRequestBatch);
    }

    public static final List<GraphResponse> executeConnectionAndWait(HttpURLConnection httpURLConnection, Collection<GraphRequest> collection) {
        return Companion.executeConnectionAndWait(httpURLConnection, collection);
    }

    public static final GraphRequestAsyncTask executeConnectionAsync(Handler handler, HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        return Companion.executeConnectionAsync(handler, httpURLConnection, graphRequestBatch);
    }

    public static final GraphRequestAsyncTask executeConnectionAsync(HttpURLConnection httpURLConnection, GraphRequestBatch graphRequestBatch) {
        return Companion.executeConnectionAsync(httpURLConnection, graphRequestBatch);
    }

    private final String getAccessTokenToUseForRequest() {
        AccessToken accessToken2 = this.accessToken;
        if (accessToken2 != null) {
            if (!this.parameters.containsKey("access_token")) {
                String token = accessToken2.getToken();
                Logger.Companion.registerAccessToken(token);
                return token;
            }
        } else if (!this.parameters.containsKey("access_token")) {
            return getClientTokenForRequest();
        }
        return this.parameters.getString("access_token");
    }

    private final String getClientTokenForRequest() {
        boolean z10;
        String applicationId = FacebookSdk.getApplicationId();
        String clientToken = FacebookSdk.getClientToken();
        boolean z11 = true;
        if (applicationId.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (clientToken.length() <= 0) {
                z11 = false;
            }
            if (z11) {
                return applicationId + '|' + clientToken;
            }
        }
        Utility utility = Utility.INSTANCE;
        Utility.logd(TAG, "Warning: Request without access token missing application ID or client token.");
        return null;
    }

    public static final String getDefaultBatchApplicationId() {
        return Companion.getDefaultBatchApplicationId();
    }

    private final String getGraphPathWithVersion() {
        if (versionPattern.matcher(this.graphPath).matches()) {
            return this.graphPath;
        }
        o oVar = o.f32141a;
        String format2 = String.format("%s/%s", Arrays.copyOf(new Object[]{this.version, this.graphPath}, 2));
        j.f(format2, "java.lang.String.format(format, *args)");
        return format2;
    }

    private final String getUrlWithGraphPath(String str) {
        if (!isValidGraphRequestForDomain()) {
            str = ServerProtocol.getFacebookGraphUrlBase();
        }
        o oVar = o.f32141a;
        String format2 = String.format("%s/%s", Arrays.copyOf(new Object[]{str, getGraphPathWithVersion()}, 2));
        j.f(format2, "java.lang.String.format(format, *args)");
        return format2;
    }

    private final boolean isApplicationRequest() {
        if (this.graphPath == null) {
            return false;
        }
        String str = "^/?" + FacebookSdk.getApplicationId() + "/?.*";
        if (this.forceApplicationRequest || Pattern.matches(str, this.graphPath) || Pattern.matches("^/?app/?.*", this.graphPath)) {
            return true;
        }
        return false;
    }

    private final boolean isValidGraphRequestForDomain() {
        if (!j.b(FacebookSdk.getGraphDomain(), FacebookSdk.INSTAGRAM_COM)) {
            return true;
        }
        return !isApplicationRequest();
    }

    public static final GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken2, Context context, Callback callback2) {
        return Companion.newCustomAudienceThirdPartyIdRequest(accessToken2, context, callback2);
    }

    public static final GraphRequest newCustomAudienceThirdPartyIdRequest(AccessToken accessToken2, Context context, String str, Callback callback2) {
        return Companion.newCustomAudienceThirdPartyIdRequest(accessToken2, context, str, callback2);
    }

    public static final GraphRequest newDeleteObjectRequest(AccessToken accessToken2, String str, Callback callback2) {
        return Companion.newDeleteObjectRequest(accessToken2, str, callback2);
    }

    public static final GraphRequest newGraphPathRequest(AccessToken accessToken2, String str, Callback callback2) {
        return Companion.newGraphPathRequest(accessToken2, str, callback2);
    }

    public static final GraphRequest newMeRequest(AccessToken accessToken2, GraphJSONObjectCallback graphJSONObjectCallback) {
        return Companion.newMeRequest(accessToken2, graphJSONObjectCallback);
    }

    public static final GraphRequest newMyFriendsRequest(AccessToken accessToken2, GraphJSONArrayCallback graphJSONArrayCallback) {
        return Companion.newMyFriendsRequest(accessToken2, graphJSONArrayCallback);
    }

    public static final GraphRequest newPlacesSearchRequest(AccessToken accessToken2, Location location, int i10, int i11, String str, GraphJSONArrayCallback graphJSONArrayCallback) {
        return Companion.newPlacesSearchRequest(accessToken2, location, i10, i11, str, graphJSONArrayCallback);
    }

    public static final GraphRequest newPostRequest(AccessToken accessToken2, String str, b bVar, Callback callback2) {
        return Companion.newPostRequest(accessToken2, str, bVar, callback2);
    }

    public static final GraphRequest newPostRequestWithBundle(AccessToken accessToken2, String str, Bundle bundle, Callback callback2) {
        return Companion.newPostRequestWithBundle(accessToken2, str, bundle, callback2);
    }

    public static final GraphRequest newUploadPhotoRequest(AccessToken accessToken2, String str, Bitmap bitmap, String str2, Bundle bundle, Callback callback2) {
        return Companion.newUploadPhotoRequest(accessToken2, str, bitmap, str2, bundle, callback2);
    }

    public static final GraphRequest newUploadPhotoRequest(AccessToken accessToken2, String str, Uri uri, String str2, Bundle bundle, Callback callback2) throws FileNotFoundException, FacebookException {
        return Companion.newUploadPhotoRequest(accessToken2, str, uri, str2, bundle, callback2);
    }

    public static final GraphRequest newUploadPhotoRequest(AccessToken accessToken2, String str, File file, String str2, Bundle bundle, Callback callback2) throws FileNotFoundException {
        return Companion.newUploadPhotoRequest(accessToken2, str, file, str2, bundle, callback2);
    }

    public static final void runCallbacks$facebook_core_release(GraphRequestBatch graphRequestBatch, List<GraphResponse> list) {
        Companion.runCallbacks$facebook_core_release(graphRequestBatch, list);
    }

    /* access modifiers changed from: private */
    public final void serializeToBatch(a aVar, Map<String, Attachment> map) throws JSONException, IOException {
        b bVar = new b();
        String str = this.batchEntryName;
        if (str != null) {
            bVar.put("name", (Object) str);
            bVar.put(BATCH_ENTRY_OMIT_RESPONSE_ON_SUCCESS_PARAM, this.batchEntryOmitResultOnSuccess);
        }
        String str2 = this.batchEntryDependsOn;
        if (str2 != null) {
            bVar.put(BATCH_ENTRY_DEPENDS_ON_PARAM, (Object) str2);
        }
        String relativeUrlForBatchedRequest = getRelativeUrlForBatchedRequest();
        bVar.put(BATCH_RELATIVE_URL_PARAM, (Object) relativeUrlForBatchedRequest);
        bVar.put("method", (Object) this.httpMethod);
        AccessToken accessToken2 = this.accessToken;
        if (accessToken2 != null) {
            Logger.Companion.registerAccessToken(accessToken2.getToken());
        }
        ArrayList arrayList = new ArrayList();
        for (String str3 : this.parameters.keySet()) {
            Object obj = this.parameters.get(str3);
            if (Companion.isSupportedAttachmentType(obj)) {
                o oVar = o.f32141a;
                String format2 = String.format(Locale.ROOT, "%s%d", Arrays.copyOf(new Object[]{"file", Integer.valueOf(map.size())}, 2));
                j.f(format2, "java.lang.String.format(locale, format, *args)");
                arrayList.add(format2);
                map.put(format2, new Attachment(this, obj));
            }
        }
        if (!arrayList.isEmpty()) {
            bVar.put(ATTACHED_FILES_PARAM, (Object) TextUtils.join(AppsFlyerKit.COMMA, arrayList));
        }
        b bVar2 = this.graphObject;
        if (bVar2 != null) {
            ArrayList arrayList2 = new ArrayList();
            Companion.processGraphObject(bVar2, relativeUrlForBatchedRequest, new GraphRequest$serializeToBatch$1(arrayList2));
            bVar.put("body", (Object) TextUtils.join("&", arrayList2));
        }
        aVar.E(bVar);
    }

    public static final void serializeToUrlConnection$facebook_core_release(GraphRequestBatch graphRequestBatch, HttpURLConnection httpURLConnection) throws IOException, JSONException {
        Companion.serializeToUrlConnection$facebook_core_release(graphRequestBatch, httpURLConnection);
    }

    public static final void setDefaultBatchApplicationId(String str) {
        Companion.setDefaultBatchApplicationId(str);
    }

    private final boolean shouldForceClientTokenForRequest() {
        boolean z10;
        boolean z11;
        String accessTokenToUseForRequest = getAccessTokenToUseForRequest();
        if (accessTokenToUseForRequest == null) {
            z10 = false;
        } else {
            z10 = StringsKt__StringsKt.O(accessTokenToUseForRequest, "|", false, 2, (Object) null);
        }
        if (accessTokenToUseForRequest == null || !r.J(accessTokenToUseForRequest, "IG", false, 2, (Object) null) || z10) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11 && isApplicationRequest()) {
            return true;
        }
        if (isValidGraphRequestForDomain() || z10) {
            return false;
        }
        return true;
    }

    public static final HttpURLConnection toHttpConnection(GraphRequestBatch graphRequestBatch) {
        return Companion.toHttpConnection(graphRequestBatch);
    }

    public static final HttpURLConnection toHttpConnection(Collection<GraphRequest> collection) {
        return Companion.toHttpConnection(collection);
    }

    public static final HttpURLConnection toHttpConnection(GraphRequest... graphRequestArr) {
        return Companion.toHttpConnection(graphRequestArr);
    }

    public static final void validateFieldsParamForGetRequests$facebook_core_release(GraphRequestBatch graphRequestBatch) {
        Companion.validateFieldsParamForGetRequests$facebook_core_release(graphRequestBatch);
    }

    public final GraphResponse executeAndWait() {
        return Companion.executeAndWait(this);
    }

    public final GraphRequestAsyncTask executeAsync() {
        return Companion.executeBatchAsync(this);
    }

    public final AccessToken getAccessToken() {
        return this.accessToken;
    }

    public final String getBatchEntryDependsOn() {
        return this.batchEntryDependsOn;
    }

    public final String getBatchEntryName() {
        return this.batchEntryName;
    }

    public final boolean getBatchEntryOmitResultOnSuccess() {
        return this.batchEntryOmitResultOnSuccess;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final b getGraphObject() {
        return this.graphObject;
    }

    public final String getGraphPath() {
        return this.graphPath;
    }

    public final HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public final Bundle getParameters() {
        return this.parameters;
    }

    public final String getRelativeUrlForBatchedRequest() {
        if (this.overriddenURL == null) {
            String urlWithGraphPath = getUrlWithGraphPath(ServerProtocol.getGraphUrlBase());
            addCommonParameters();
            Uri parse = Uri.parse(appendParametersToBaseUrl(urlWithGraphPath, true));
            o oVar = o.f32141a;
            String format2 = String.format("%s?%s", Arrays.copyOf(new Object[]{parse.getPath(), parse.getQuery()}, 2));
            j.f(format2, "java.lang.String.format(format, *args)");
            return format2;
        }
        throw new FacebookException("Can't override URL for a batch request");
    }

    public final Object getTag() {
        return this.tag;
    }

    public final String getUrlForSingleRequest() {
        String str;
        String str2 = this.overriddenURL;
        if (str2 != null) {
            return String.valueOf(str2);
        }
        String str3 = this.graphPath;
        if (this.httpMethod != HttpMethod.POST || str3 == null || !r.s(str3, VIDEOS_SUFFIX, false, 2, (Object) null)) {
            ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
            str = ServerProtocol.getGraphUrlBaseForSubdomain(FacebookSdk.getGraphDomain());
        } else {
            str = ServerProtocol.getGraphVideoUrlBase();
        }
        String urlWithGraphPath = getUrlWithGraphPath(str);
        addCommonParameters();
        return appendParametersToBaseUrl(urlWithGraphPath, false);
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setAccessToken(AccessToken accessToken2) {
        this.accessToken = accessToken2;
    }

    public final void setBatchEntryDependsOn(String str) {
        this.batchEntryDependsOn = str;
    }

    public final void setBatchEntryName(String str) {
        this.batchEntryName = str;
    }

    public final void setBatchEntryOmitResultOnSuccess(boolean z10) {
        this.batchEntryOmitResultOnSuccess = z10;
    }

    public final void setCallback(Callback callback2) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_INFO) || FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            this.callback = new p(callback2);
        } else {
            this.callback = callback2;
        }
    }

    public final void setForceApplicationRequest(boolean z10) {
        this.forceApplicationRequest = z10;
    }

    public final void setGraphObject(b bVar) {
        this.graphObject = bVar;
    }

    public final void setGraphPath(String str) {
        this.graphPath = str;
    }

    public final void setHttpMethod(HttpMethod httpMethod2) {
        if (this.overriddenURL == null || httpMethod2 == HttpMethod.GET) {
            if (httpMethod2 == null) {
                httpMethod2 = HttpMethod.GET;
            }
            this.httpMethod = httpMethod2;
            return;
        }
        throw new FacebookException("Can't change HTTP method on request with overridden URL.");
    }

    public final void setParameters(Bundle bundle) {
        j.g(bundle, "<set-?>");
        this.parameters = bundle;
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{Request: ");
        sb2.append(" accessToken: ");
        Object obj = this.accessToken;
        if (obj == null) {
            obj = "null";
        }
        sb2.append(obj);
        sb2.append(", graphPath: ");
        sb2.append(this.graphPath);
        sb2.append(", graphObject: ");
        sb2.append(this.graphObject);
        sb2.append(", httpMethod: ");
        sb2.append(this.httpMethod);
        sb2.append(", parameters: ");
        sb2.append(this.parameters);
        sb2.append("}");
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder()\n        .append(\"{Request: \")\n        .append(\" accessToken: \")\n        .append(if (accessToken == null) \"null\" else accessToken)\n        .append(\", graphPath: \")\n        .append(graphPath)\n        .append(\", graphObject: \")\n        .append(graphObject)\n        .append(\", httpMethod: \")\n        .append(httpMethod)\n        .append(\", parameters: \")\n        .append(parameters)\n        .append(\"}\")\n        .toString()");
        return sb3;
    }

    public GraphRequest(AccessToken accessToken2, String str, Bundle bundle, HttpMethod httpMethod2, Callback callback2, String str2) {
        this.batchEntryOmitResultOnSuccess = true;
        this.accessToken = accessToken2;
        this.graphPath = str;
        this.version = str2;
        setCallback(callback2);
        setHttpMethod(httpMethod2);
        if (bundle != null) {
            this.parameters = new Bundle(bundle);
        } else {
            this.parameters = new Bundle();
        }
        if (this.version == null) {
            this.version = FacebookSdk.getGraphApiVersion();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u0015*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0002:\u0001\u0015B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0012\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType;", "RESOURCE", "Landroid/os/Parcelable;", "resource", "mimeType", "", "(Landroid/os/Parcelable;Ljava/lang/String;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getMimeType", "()Ljava/lang/String;", "getResource", "()Landroid/os/Parcelable;", "Landroid/os/Parcelable;", "describeContents", "", "writeToParcel", "", "out", "flags", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ParcelableResourceWithMimeType<RESOURCE extends Parcelable> implements Parcelable {
        public static final Parcelable.Creator<ParcelableResourceWithMimeType<?>> CREATOR = new GraphRequest$ParcelableResourceWithMimeType$Companion$CREATOR$1();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String mimeType;
        private final RESOURCE resource;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/GraphRequest$ParcelableResourceWithMimeType;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ ParcelableResourceWithMimeType(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        public ParcelableResourceWithMimeType(RESOURCE resource2, String str) {
            this.mimeType = str;
            this.resource = resource2;
        }

        public int describeContents() {
            return 1;
        }

        public final String getMimeType() {
            return this.mimeType;
        }

        public final RESOURCE getResource() {
            return this.resource;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            j.g(parcel, "out");
            parcel.writeString(this.mimeType);
            parcel.writeParcelable(this.resource, i10);
        }

        private ParcelableResourceWithMimeType(Parcel parcel) {
            this.mimeType = parcel.readString();
            this.resource = parcel.readParcelable(FacebookSdk.getApplicationContext().getClassLoader());
        }
    }

    public GraphRequest(AccessToken accessToken2, URL url) {
        j.g(url, "overriddenURL");
        this.batchEntryOmitResultOnSuccess = true;
        this.accessToken = accessToken2;
        this.overriddenURL = url.toString();
        setHttpMethod(HttpMethod.GET);
        this.parameters = new Bundle();
    }
}

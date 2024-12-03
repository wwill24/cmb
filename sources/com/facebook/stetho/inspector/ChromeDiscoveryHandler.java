package com.facebook.stetho.inspector;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.facebook.stetho.common.ProcessUtil;
import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.http.ExactPathMatcher;
import com.facebook.stetho.server.http.HandlerRegistry;
import com.facebook.stetho.server.http.HttpHandler;
import com.facebook.stetho.server.http.HttpStatus;
import com.facebook.stetho.server.http.LightHttpBody;
import com.facebook.stetho.server.http.LightHttpRequest;
import com.facebook.stetho.server.http.LightHttpResponse;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class ChromeDiscoveryHandler implements HttpHandler {
    private static final String PAGE_ID = "1";
    private static final String PATH_ACTIVATE = "/json/activate/1";
    private static final String PATH_PAGE_LIST = "/json";
    private static final String PATH_VERSION = "/json/version";
    private static final String PROTOCOL_VERSION = "1.1";
    private static final String USER_AGENT = "Stetho";
    private static final String WEBKIT_REV = "@188492";
    private static final String WEBKIT_VERSION = "537.36 (@188492)";
    private final Context mContext;
    private final String mInspectorPath;
    private LightHttpBody mPageListResponse;
    private LightHttpBody mVersionResponse;

    public ChromeDiscoveryHandler(Context context, String str) {
        this.mContext = context;
        this.mInspectorPath = str;
    }

    private CharSequence getAppLabel() {
        return this.mContext.getPackageManager().getApplicationLabel(this.mContext.getApplicationInfo());
    }

    private String getAppLabelAndVersion() {
        StringBuilder sb2 = new StringBuilder();
        PackageManager packageManager = this.mContext.getPackageManager();
        sb2.append(getAppLabel());
        sb2.append('/');
        try {
            sb2.append(packageManager.getPackageInfo(this.mContext.getPackageName(), 0).versionName);
            return sb2.toString();
        } catch (PackageManager.NameNotFoundException e10) {
            throw new RuntimeException(e10);
        }
    }

    private void handleActivate(LightHttpResponse lightHttpResponse) {
        setSuccessfulResponse(lightHttpResponse, LightHttpBody.create("Target activation ignored\n", "text/plain"));
    }

    private void handlePageList(LightHttpResponse lightHttpResponse) throws JSONException {
        if (this.mPageListResponse == null) {
            a aVar = new a();
            b bVar = new b();
            bVar.put("type", (Object) "app");
            bVar.put("title", (Object) makeTitle());
            bVar.put("id", (Object) "1");
            bVar.put("description", (Object) "");
            bVar.put("webSocketDebuggerUrl", (Object) "ws://" + this.mInspectorPath);
            bVar.put("devtoolsFrontendUrl", (Object) new Uri.Builder().scheme("http").authority("chrome-devtools-frontend.appspot.com").appendEncodedPath("serve_rev").appendEncodedPath(WEBKIT_REV).appendEncodedPath("devtools.html").appendQueryParameter("ws", this.mInspectorPath).build().toString());
            aVar.E(bVar);
            this.mPageListResponse = LightHttpBody.create(aVar.toString(), "application/json");
        }
        setSuccessfulResponse(lightHttpResponse, this.mPageListResponse);
    }

    private void handleVersion(LightHttpResponse lightHttpResponse) throws JSONException {
        if (this.mVersionResponse == null) {
            b bVar = new b();
            bVar.put("WebKit-Version", (Object) WEBKIT_VERSION);
            bVar.put("User-Agent", (Object) USER_AGENT);
            bVar.put("Protocol-Version", (Object) PROTOCOL_VERSION);
            bVar.put("Browser", (Object) getAppLabelAndVersion());
            bVar.put("Android-Package", (Object) this.mContext.getPackageName());
            this.mVersionResponse = LightHttpBody.create(bVar.toString(), "application/json");
        }
        setSuccessfulResponse(lightHttpResponse, this.mVersionResponse);
    }

    private String makeTitle() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getAppLabel());
        sb2.append(" (powered by Stetho)");
        String processName = ProcessUtil.getProcessName();
        int indexOf = processName.indexOf(58);
        if (indexOf >= 0) {
            sb2.append(processName.substring(indexOf));
        }
        return sb2.toString();
    }

    private static void setSuccessfulResponse(LightHttpResponse lightHttpResponse, LightHttpBody lightHttpBody) {
        lightHttpResponse.code = 200;
        lightHttpResponse.reasonPhrase = MessageTemplateConstants.Values.OK_TEXT;
        lightHttpResponse.body = lightHttpBody;
    }

    public boolean handleRequest(SocketLike socketLike, LightHttpRequest lightHttpRequest, LightHttpResponse lightHttpResponse) {
        String path = lightHttpRequest.uri.getPath();
        try {
            if (PATH_VERSION.equals(path)) {
                handleVersion(lightHttpResponse);
                return true;
            } else if (PATH_PAGE_LIST.equals(path)) {
                handlePageList(lightHttpResponse);
                return true;
            } else if (PATH_ACTIVATE.equals(path)) {
                handleActivate(lightHttpResponse);
                return true;
            } else {
                lightHttpResponse.code = HttpStatus.HTTP_NOT_IMPLEMENTED;
                lightHttpResponse.reasonPhrase = "Not implemented";
                lightHttpResponse.body = LightHttpBody.create("No support for " + path + "\n", "text/plain");
                return true;
            }
        } catch (JSONException e10) {
            lightHttpResponse.code = 500;
            lightHttpResponse.reasonPhrase = "Internal server error";
            lightHttpResponse.body = LightHttpBody.create(e10.toString() + "\n", "text/plain");
            return true;
        }
    }

    public void register(HandlerRegistry handlerRegistry) {
        handlerRegistry.register(new ExactPathMatcher(PATH_PAGE_LIST), this);
        handlerRegistry.register(new ExactPathMatcher(PATH_VERSION), this);
        handlerRegistry.register(new ExactPathMatcher(PATH_ACTIVATE), this);
    }
}

package com.facebook.applinks;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.bolts.AppLink;
import com.facebook.bolts.AppLinkResolver;
import com.facebook.bolts.Continuation;
import com.facebook.bolts.Task;
import com.facebook.bolts.TaskCompletionSource;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class FacebookAppLinkResolver implements AppLinkResolver {
    private static final String APP_LINK_ANDROID_TARGET_KEY = "android";
    private static final String APP_LINK_KEY = "app_links";
    private static final String APP_LINK_TARGET_APP_NAME_KEY = "app_name";
    private static final String APP_LINK_TARGET_CLASS_KEY = "class";
    private static final String APP_LINK_TARGET_PACKAGE_KEY = "package";
    private static final String APP_LINK_TARGET_SHOULD_FALLBACK_KEY = "should_fallback";
    private static final String APP_LINK_TARGET_URL_KEY = "url";
    private static final String APP_LINK_WEB_TARGET_KEY = "web";
    private final HashMap<Uri, AppLink> cachedAppLinks = new HashMap<>();

    static /* synthetic */ AppLink.Target access$000(b bVar) {
        Class<FacebookAppLinkResolver> cls = FacebookAppLinkResolver.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return getAndroidTargetFromJson(bVar);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    static /* synthetic */ Uri access$100(Uri uri, b bVar) {
        Class<FacebookAppLinkResolver> cls = FacebookAppLinkResolver.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return getWebFallbackUriFromJson(uri, bVar);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    static /* synthetic */ HashMap access$200(FacebookAppLinkResolver facebookAppLinkResolver) {
        Class<FacebookAppLinkResolver> cls = FacebookAppLinkResolver.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return facebookAppLinkResolver.cachedAppLinks;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    private static AppLink.Target getAndroidTargetFromJson(b bVar) {
        Uri uri;
        Class<FacebookAppLinkResolver> cls = FacebookAppLinkResolver.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            String tryGetStringFromJson = tryGetStringFromJson(bVar, APP_LINK_TARGET_PACKAGE_KEY, (String) null);
            if (tryGetStringFromJson == null) {
                return null;
            }
            String tryGetStringFromJson2 = tryGetStringFromJson(bVar, APP_LINK_TARGET_CLASS_KEY, (String) null);
            String tryGetStringFromJson3 = tryGetStringFromJson(bVar, "app_name", (String) null);
            String tryGetStringFromJson4 = tryGetStringFromJson(bVar, "url", (String) null);
            if (tryGetStringFromJson4 != null) {
                uri = Uri.parse(tryGetStringFromJson4);
            } else {
                uri = null;
            }
            return new AppLink.Target(tryGetStringFromJson, tryGetStringFromJson2, uri, tryGetStringFromJson3);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    private static Uri getWebFallbackUriFromJson(Uri uri, b bVar) {
        Class<FacebookAppLinkResolver> cls = FacebookAppLinkResolver.class;
        Uri uri2 = null;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            b jSONObject = bVar.getJSONObject("web");
            if (!tryGetBooleanFromJson(jSONObject, APP_LINK_TARGET_SHOULD_FALLBACK_KEY, true)) {
                return null;
            }
            String tryGetStringFromJson = tryGetStringFromJson(jSONObject, "url", (String) null);
            if (tryGetStringFromJson != null) {
                uri2 = Uri.parse(tryGetStringFromJson);
            }
            if (uri2 != null) {
                return uri2;
            }
            return uri;
        } catch (JSONException unused) {
            return uri;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    private static boolean tryGetBooleanFromJson(b bVar, String str, boolean z10) {
        Class<FacebookAppLinkResolver> cls = FacebookAppLinkResolver.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return bVar.getBoolean(str);
        } catch (JSONException unused) {
            return z10;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return false;
        }
    }

    private static String tryGetStringFromJson(b bVar, String str, String str2) {
        Class<FacebookAppLinkResolver> cls = FacebookAppLinkResolver.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return bVar.getString(str);
        } catch (JSONException unused) {
            return str2;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public Task<AppLink> getAppLinkFromUrlInBackground(final Uri uri) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(uri);
            return getAppLinkFromUrlsInBackground(arrayList).onSuccess(new Continuation<Map<Uri, AppLink>, AppLink>() {
                public AppLink then(Task<Map<Uri, AppLink>> task) throws Exception {
                    return (AppLink) task.getResult().get(uri);
                }
            });
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public Task<Map<Uri, AppLink>> getAppLinkFromUrlsInBackground(List<Uri> list) {
        AppLink appLink;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            final HashMap hashMap = new HashMap();
            final HashSet hashSet = new HashSet();
            StringBuilder sb2 = new StringBuilder();
            for (Uri next : list) {
                synchronized (this.cachedAppLinks) {
                    appLink = this.cachedAppLinks.get(next);
                }
                if (appLink != null) {
                    hashMap.put(next, appLink);
                } else {
                    if (!hashSet.isEmpty()) {
                        sb2.append(',');
                    }
                    sb2.append(next.toString());
                    hashSet.add(next);
                }
            }
            if (hashSet.isEmpty()) {
                return Task.forResult(hashMap);
            }
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            Bundle bundle = new Bundle();
            bundle.putString("ids", sb2.toString());
            bundle.putString("fields", String.format("%s.fields(%s,%s)", new Object[]{APP_LINK_KEY, "android", "web"}));
            new GraphRequest(AccessToken.getCurrentAccessToken(), "", bundle, (HttpMethod) null, new GraphRequest.Callback() {
                public void onCompleted(GraphResponse graphResponse) {
                    if (!CrashShieldHandler.isObjectCrashing(this)) {
                        try {
                            FacebookRequestError error = graphResponse.getError();
                            if (error != null) {
                                taskCompletionSource.setError(error.getException());
                                return;
                            }
                            b jSONObject = graphResponse.getJSONObject();
                            if (jSONObject == null) {
                                taskCompletionSource.setResult(hashMap);
                                return;
                            }
                            Iterator it = hashSet.iterator();
                            while (it.hasNext()) {
                                Uri uri = (Uri) it.next();
                                if (jSONObject.has(uri.toString())) {
                                    try {
                                        b jSONObject2 = jSONObject.getJSONObject(uri.toString()).getJSONObject(FacebookAppLinkResolver.APP_LINK_KEY);
                                        a jSONArray = jSONObject2.getJSONArray("android");
                                        int o10 = jSONArray.o();
                                        ArrayList arrayList = new ArrayList(o10);
                                        for (int i10 = 0; i10 < o10; i10++) {
                                            AppLink.Target access$000 = FacebookAppLinkResolver.access$000(jSONArray.j(i10));
                                            if (access$000 != null) {
                                                arrayList.add(access$000);
                                            }
                                        }
                                        AppLink appLink = new AppLink(uri, arrayList, FacebookAppLinkResolver.access$100(uri, jSONObject2));
                                        hashMap.put(uri, appLink);
                                        synchronized (FacebookAppLinkResolver.access$200(FacebookAppLinkResolver.this)) {
                                            FacebookAppLinkResolver.access$200(FacebookAppLinkResolver.this).put(uri, appLink);
                                        }
                                    } catch (JSONException unused) {
                                    }
                                }
                            }
                            taskCompletionSource.setResult(hashMap);
                        } catch (Throwable th2) {
                            CrashShieldHandler.handleThrowable(th2, this);
                        }
                    }
                }
            }).executeAsync();
            return taskCompletionSource.getTask();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }
}

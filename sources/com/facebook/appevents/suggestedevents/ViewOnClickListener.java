package com.facebook.appevents.suggestedevents;

import android.os.Bundle;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.mparticle.kits.AppsFlyerKit;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.o;
import org.json.JSONException;
import org.json.b;
import vc.c;
import vc.d;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B!\b\u0002\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/facebook/appevents/suggestedevents/ViewOnClickListener;", "Landroid/view/View$OnClickListener;", "", "process", "", "pathID", "buttonText", "Lorg/json/b;", "viewData", "predictAndProcess", "Landroid/view/View;", "view", "onClick", "baseListener", "Landroid/view/View$OnClickListener;", "Ljava/lang/ref/WeakReference;", "rootViewWeakReference", "Ljava/lang/ref/WeakReference;", "hostViewWeakReference", "activityName", "Ljava/lang/String;", "hostView", "rootView", "<init>", "(Landroid/view/View;Landroid/view/View;Ljava/lang/String;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class ViewOnClickListener implements View.OnClickListener {
    private static final String API_ENDPOINT = "%s/suggested_events";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String OTHER_EVENT = "other";
    private static final Set<Integer> viewsAttachedListener = new HashSet();
    private final String activityName;
    private final View.OnClickListener baseListener;
    private final WeakReference<View> hostViewWeakReference;
    private final WeakReference<View> rootViewWeakReference;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u000fJ \u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J \u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/facebook/appevents/suggestedevents/ViewOnClickListener$Companion;", "", "()V", "API_ENDPOINT", "", "OTHER_EVENT", "viewsAttachedListener", "", "", "attachListener", "", "hostView", "Landroid/view/View;", "rootView", "activityName", "attachListener$facebook_core_release", "processPredictedResult", "predictedEvent", "buttonText", "dense", "", "queryHistoryAndProcess", "", "pathID", "sendPredictedResult", "eventToPost", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final void processPredictedResult(String str, String str2, float[] fArr) {
            if (SuggestedEventsManager.isProductionEvents$facebook_core_release(str)) {
                new InternalAppEventsLogger(FacebookSdk.getApplicationContext()).logEventFromSE(str, str2);
            } else if (SuggestedEventsManager.isEligibleEvents$facebook_core_release(str)) {
                sendPredictedResult(str, str2, fArr);
            }
        }

        /* access modifiers changed from: private */
        public final boolean queryHistoryAndProcess(String str, String str2) {
            String queryEvent = PredictionHistoryManager.queryEvent(str);
            if (queryEvent == null) {
                return false;
            }
            if (j.b(queryEvent, "other")) {
                return true;
            }
            Utility utility = Utility.INSTANCE;
            Utility.runOnNonUiThread(new d(queryEvent, str2));
            return true;
        }

        /* access modifiers changed from: private */
        /* renamed from: queryHistoryAndProcess$lambda-0  reason: not valid java name */
        public static final void m86queryHistoryAndProcess$lambda0(String str, String str2) {
            j.g(str, "$queriedEvent");
            j.g(str2, "$buttonText");
            ViewOnClickListener.Companion.processPredictedResult(str, str2, new float[0]);
        }

        private final void sendPredictedResult(String str, String str2, float[] fArr) {
            Bundle bundle = new Bundle();
            try {
                bundle.putString("event_name", str);
                b bVar = new b();
                StringBuilder sb2 = new StringBuilder();
                int length = fArr.length;
                int i10 = 0;
                while (i10 < length) {
                    float f10 = fArr[i10];
                    i10++;
                    sb2.append(f10);
                    sb2.append(AppsFlyerKit.COMMA);
                }
                bVar.put("dense", (Object) sb2.toString());
                bVar.put("button_text", (Object) str2);
                bundle.putString("metadata", bVar.toString());
                GraphRequest.Companion companion = GraphRequest.Companion;
                o oVar = o.f32141a;
                String format2 = String.format(Locale.US, ViewOnClickListener.API_ENDPOINT, Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                j.f(format2, "java.lang.String.format(locale, format, *args)");
                GraphRequest newPostRequest = companion.newPostRequest((AccessToken) null, format2, (b) null, (GraphRequest.Callback) null);
                newPostRequest.setParameters(bundle);
                newPostRequest.executeAndWait();
            } catch (JSONException unused) {
            }
        }

        public final void attachListener$facebook_core_release(View view, View view2, String str) {
            j.g(view, "hostView");
            j.g(view2, "rootView");
            j.g(str, "activityName");
            int hashCode = view.hashCode();
            if (!ViewOnClickListener.access$getViewsAttachedListener$cp().contains(Integer.valueOf(hashCode))) {
                ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                ViewHierarchy.setOnClickListener(view, new ViewOnClickListener(view, view2, str, (DefaultConstructorMarker) null));
                ViewOnClickListener.access$getViewsAttachedListener$cp().add(Integer.valueOf(hashCode));
            }
        }
    }

    private ViewOnClickListener(View view, View view2, String str) {
        this.baseListener = ViewHierarchy.getExistingOnClickListener(view);
        this.rootViewWeakReference = new WeakReference<>(view2);
        this.hostViewWeakReference = new WeakReference<>(view);
        if (str != null) {
            String lowerCase = str.toLowerCase();
            j.f(lowerCase, "(this as java.lang.String).toLowerCase()");
            this.activityName = r.D(lowerCase, "activity", "", false, 4, (Object) null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public /* synthetic */ ViewOnClickListener(View view, View view2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, view2, str);
    }

    public static final /* synthetic */ Set access$getViewsAttachedListener$cp() {
        if (CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            return null;
        }
        try {
            return viewsAttachedListener;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, ViewOnClickListener.class);
            return null;
        }
    }

    public static final void attachListener$facebook_core_release(View view, View view2, String str) {
        if (!CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            try {
                Companion.attachListener$facebook_core_release(view, view2, str);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, ViewOnClickListener.class);
            }
        }
    }

    private final void predictAndProcess(String str, String str2, b bVar) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Utility utility = Utility.INSTANCE;
                Utility.runOnNonUiThread(new c(bVar, str2, this, str));
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: predictAndProcess$lambda-0  reason: not valid java name */
    public static final void m85predictAndProcess$lambda0(b bVar, String str, ViewOnClickListener viewOnClickListener, String str2) {
        if (!CrashShieldHandler.isObjectCrashing(ViewOnClickListener.class)) {
            try {
                j.g(bVar, "$viewData");
                j.g(str, "$buttonText");
                j.g(viewOnClickListener, "this$0");
                j.g(str2, "$pathID");
                try {
                    Utility utility = Utility.INSTANCE;
                    String appName = Utility.getAppName(FacebookSdk.getApplicationContext());
                    if (appName != null) {
                        String lowerCase = appName.toLowerCase();
                        j.f(lowerCase, "(this as java.lang.String).toLowerCase()");
                        float[] denseFeatures = FeatureExtractor.getDenseFeatures(bVar, lowerCase);
                        String textFeature = FeatureExtractor.getTextFeature(str, viewOnClickListener.activityName, lowerCase);
                        if (denseFeatures != null) {
                            ModelManager modelManager = ModelManager.INSTANCE;
                            String[] predict = ModelManager.predict(ModelManager.Task.MTML_APP_EVENT_PREDICTION, new float[][]{denseFeatures}, new String[]{textFeature});
                            if (predict != null) {
                                String str3 = predict[0];
                                PredictionHistoryManager.addPrediction(str2, str3);
                                if (!j.b(str3, "other")) {
                                    Companion.processPredictedResult(str3, str, denseFeatures);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                } catch (Exception unused) {
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, ViewOnClickListener.class);
            }
        }
    }

    private final void process() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                View view = this.rootViewWeakReference.get();
                View view2 = this.hostViewWeakReference.get();
                if (view != null && view2 != null) {
                    try {
                        String textOfViewRecursively = SuggestedEventViewHierarchy.getTextOfViewRecursively(view2);
                        String pathID = PredictionHistoryManager.getPathID(view2, textOfViewRecursively);
                        if (pathID != null && !Companion.queryHistoryAndProcess(pathID, textOfViewRecursively)) {
                            b bVar = new b();
                            bVar.put("view", (Object) SuggestedEventViewHierarchy.getDictionaryOfView(view, view2));
                            bVar.put(ViewHierarchyConstants.SCREEN_NAME_KEY, (Object) this.activityName);
                            predictAndProcess(pathID, textOfViewRecursively, bVar);
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public void onClick(View view) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                j.g(view, "view");
                View.OnClickListener onClickListener = this.baseListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                process();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }
}

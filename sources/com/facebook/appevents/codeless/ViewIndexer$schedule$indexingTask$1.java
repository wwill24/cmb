package com.facebook.appevents.codeless;

import java.util.TimerTask;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/facebook/appevents/codeless/ViewIndexer$schedule$indexingTask$1", "Ljava/util/TimerTask;", "run", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewIndexer$schedule$indexingTask$1 extends TimerTask {
    final /* synthetic */ ViewIndexer this$0;

    ViewIndexer$schedule$indexingTask$1(ViewIndexer viewIndexer) {
        this.this$0 = viewIndexer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0073 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r7 = this;
            com.facebook.appevents.codeless.ViewIndexer r0 = r7.this$0     // Catch:{ Exception -> 0x0086 }
            java.lang.ref.WeakReference r0 = com.facebook.appevents.codeless.ViewIndexer.access$getActivityReference$p(r0)     // Catch:{ Exception -> 0x0086 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0086 }
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ Exception -> 0x0086 }
            android.view.View r1 = com.facebook.appevents.internal.AppEventUtility.getRootView(r0)     // Catch:{ Exception -> 0x0086 }
            if (r0 == 0) goto L_0x0085
            if (r1 != 0) goto L_0x0015
            goto L_0x0085
        L_0x0015:
            java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ Exception -> 0x0086 }
            boolean r2 = com.facebook.appevents.codeless.CodelessManager.getIsAppIndexingEnabled$facebook_core_release()     // Catch:{ Exception -> 0x0086 }
            if (r2 != 0) goto L_0x0024
            return
        L_0x0024:
            boolean r2 = com.facebook.internal.InternalSettings.isUnityApp()     // Catch:{ Exception -> 0x0086 }
            if (r2 == 0) goto L_0x002e
            com.facebook.appevents.codeless.internal.UnityReflection.captureViewHierarchy()     // Catch:{ Exception -> 0x0086 }
            return
        L_0x002e:
            java.util.concurrent.FutureTask r2 = new java.util.concurrent.FutureTask     // Catch:{ Exception -> 0x0086 }
            com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker r3 = new com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker     // Catch:{ Exception -> 0x0086 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0086 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0086 }
            com.facebook.appevents.codeless.ViewIndexer r3 = r7.this$0     // Catch:{ Exception -> 0x0086 }
            android.os.Handler r3 = com.facebook.appevents.codeless.ViewIndexer.access$getUiThreadHandler$p(r3)     // Catch:{ Exception -> 0x0086 }
            r3.post(r2)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r3 = ""
            r4 = 1
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x004f }
            java.lang.Object r2 = r2.get(r4, r6)     // Catch:{ Exception -> 0x004f }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x004f }
            r3 = r2
            goto L_0x0052
        L_0x004f:
            com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp()     // Catch:{ Exception -> 0x0086 }
        L_0x0052:
            org.json.b r2 = new org.json.b     // Catch:{ Exception -> 0x0086 }
            r2.<init>()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r4 = "screenname"
            r2.put((java.lang.String) r4, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x0073 }
            java.lang.String r0 = "screenshot"
            r2.put((java.lang.String) r0, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x0073 }
            org.json.a r0 = new org.json.a     // Catch:{ JSONException -> 0x0073 }
            r0.<init>()     // Catch:{ JSONException -> 0x0073 }
            org.json.b r1 = com.facebook.appevents.codeless.internal.ViewHierarchy.getDictionaryOfView(r1)     // Catch:{ JSONException -> 0x0073 }
            r0.E(r1)     // Catch:{ JSONException -> 0x0073 }
            java.lang.String r1 = "view"
            r2.put((java.lang.String) r1, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x0073 }
            goto L_0x0076
        L_0x0073:
            com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp()     // Catch:{ Exception -> 0x0086 }
        L_0x0076:
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r1 = "viewTree.toString()"
            kotlin.jvm.internal.j.f(r0, r1)     // Catch:{ Exception -> 0x0086 }
            com.facebook.appevents.codeless.ViewIndexer r1 = r7.this$0     // Catch:{ Exception -> 0x0086 }
            com.facebook.appevents.codeless.ViewIndexer.access$sendToServer(r1, r0)     // Catch:{ Exception -> 0x0086 }
            goto L_0x0089
        L_0x0085:
            return
        L_0x0086:
            com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp()
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.ViewIndexer$schedule$indexingTask$1.run():void");
    }
}

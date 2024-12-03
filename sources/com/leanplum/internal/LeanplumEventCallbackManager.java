package com.leanplum.internal;

import androidx.annotation.NonNull;
import com.leanplum.internal.Request;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class LeanplumEventCallbackManager {
    private final ConcurrentHashMap<String, LeanplumEventCallbacks> callbacks = new ConcurrentHashMap<>();

    private static class LeanplumEventCallbacks {
        /* access modifiers changed from: private */
        public Request.ErrorCallback errorCallback;
        /* access modifiers changed from: private */
        public Request.ResponseCallback responseCallback;

        LeanplumEventCallbacks(Request.ResponseCallback responseCallback2, Request.ErrorCallback errorCallback2) {
            this.responseCallback = responseCallback2;
            this.errorCallback = errorCallback2;
        }
    }

    LeanplumEventCallbackManager() {
    }

    /* access modifiers changed from: package-private */
    public void addCallbacks(Request request, Request.ResponseCallback responseCallback, Request.ErrorCallback errorCallback) {
        if (request != null) {
            if (responseCallback != null || errorCallback != null) {
                this.callbacks.put(request.getRequestId(), new LeanplumEventCallbacks(responseCallback, errorCallback));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void invokeAllCallbacksWithError(@NonNull final Exception exc) {
        if (this.callbacks.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry next : this.callbacks.entrySet()) {
                String str = (String) next.getKey();
                final LeanplumEventCallbacks leanplumEventCallbacks = (LeanplumEventCallbacks) next.getValue();
                if (leanplumEventCallbacks != null) {
                    OperationQueue.sharedInstance().addParallelOperation(new Runnable() {
                        public void run() {
                            if (leanplumEventCallbacks.errorCallback != null) {
                                leanplumEventCallbacks.errorCallback.error(exc);
                            }
                        }
                    });
                    arrayList.add(str);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.callbacks.remove((String) it.next());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        r4 = com.leanplum.internal.RequestUtil.getResponseForId(r8, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void invokeCallbacks(org.json.b r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.leanplum.internal.LeanplumEventCallbackManager$LeanplumEventCallbacks> r0 = r7.callbacks
            int r0 = r0.size()
            if (r0 != 0) goto L_0x000c
            return
        L_0x000c:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.leanplum.internal.LeanplumEventCallbackManager$LeanplumEventCallbacks> r1 = r7.callbacks
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x001b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0068
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            com.leanplum.internal.LeanplumEventCallbackManager$LeanplumEventCallbacks r2 = (com.leanplum.internal.LeanplumEventCallbackManager.LeanplumEventCallbacks) r2
            if (r3 == 0) goto L_0x001b
            if (r2 == 0) goto L_0x001b
            org.json.b r4 = com.leanplum.internal.RequestUtil.getResponseForId(r8, r3)
            if (r4 == 0) goto L_0x001b
            boolean r5 = com.leanplum.internal.RequestUtil.isResponseSuccess(r4)
            if (r5 == 0) goto L_0x0050
            com.leanplum.internal.OperationQueue r5 = com.leanplum.internal.OperationQueue.sharedInstance()
            com.leanplum.internal.LeanplumEventCallbackManager$1 r6 = new com.leanplum.internal.LeanplumEventCallbackManager$1
            r6.<init>(r2, r4)
            r5.addParallelOperation(r6)
            goto L_0x0064
        L_0x0050:
            java.lang.String r4 = com.leanplum.internal.RequestUtil.getResponseError(r4)
            java.lang.String r4 = com.leanplum.internal.RequestUtil.getReadableErrorMessage(r4)
            com.leanplum.internal.OperationQueue r5 = com.leanplum.internal.OperationQueue.sharedInstance()
            com.leanplum.internal.LeanplumEventCallbackManager$2 r6 = new com.leanplum.internal.LeanplumEventCallbackManager$2
            r6.<init>(r2, r4)
            r5.addParallelOperation(r6)
        L_0x0064:
            r0.add(r3)
            goto L_0x001b
        L_0x0068:
            java.util.Iterator r8 = r0.iterator()
        L_0x006c:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x007e
            java.lang.Object r0 = r8.next()
            java.lang.String r0 = (java.lang.String) r0
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.leanplum.internal.LeanplumEventCallbackManager$LeanplumEventCallbacks> r1 = r7.callbacks
            r1.remove(r0)
            goto L_0x006c
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.LeanplumEventCallbackManager.invokeCallbacks(org.json.b):void");
    }
}

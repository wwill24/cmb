package com.facebook.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.WorkQueue;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004-./0B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J \u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J(\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0014\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\"H\u0007J2\u0010#\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000f2\u000e\u0010$\u001a\n\u0018\u00010%j\u0004\u0018\u0001`&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u0012H\u0002J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010+\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0018\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/facebook/internal/ImageDownloader;", "", "()V", "CACHE_READ_QUEUE_MAX_CONCURRENT", "", "DOWNLOAD_QUEUE_MAX_CONCURRENT", "cacheReadQueue", "Lcom/facebook/internal/WorkQueue;", "downloadQueue", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "pendingRequests", "", "Lcom/facebook/internal/ImageDownloader$RequestKey;", "Lcom/facebook/internal/ImageDownloader$DownloaderContext;", "cancelRequest", "", "request", "Lcom/facebook/internal/ImageRequest;", "clearCache", "", "download", "key", "downloadAsync", "enqueueCacheRead", "allowCachedRedirects", "enqueueDownload", "enqueueRequest", "workQueue", "workItem", "Ljava/lang/Runnable;", "getPendingRequests", "", "issueResponse", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "bitmap", "Landroid/graphics/Bitmap;", "isCachedRedirect", "prioritizeRequest", "readFromCache", "removePendingRequest", "CacheReadWorkItem", "DownloadImageWorkItem", "DownloaderContext", "RequestKey", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ImageDownloader {
    private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
    public static final ImageDownloader INSTANCE = new ImageDownloader();
    private static final WorkQueue cacheReadQueue = new WorkQueue(2, (Executor) null, 2, (DefaultConstructorMarker) null);
    private static final WorkQueue downloadQueue = new WorkQueue(8, (Executor) null, 2, (DefaultConstructorMarker) null);
    private static Handler handler;
    private static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/internal/ImageDownloader$CacheReadWorkItem;", "Ljava/lang/Runnable;", "key", "Lcom/facebook/internal/ImageDownloader$RequestKey;", "allowCachedRedirects", "", "(Lcom/facebook/internal/ImageDownloader$RequestKey;Z)V", "run", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class CacheReadWorkItem implements Runnable {
        private final boolean allowCachedRedirects;
        private final RequestKey key;

        public CacheReadWorkItem(RequestKey requestKey, boolean z10) {
            j.g(requestKey, SDKConstants.PARAM_KEY);
            this.key = requestKey;
            this.allowCachedRedirects = z10;
        }

        public void run() {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    ImageDownloader.INSTANCE.readFromCache(this.key, this.allowCachedRedirects);
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/ImageDownloader$DownloadImageWorkItem;", "Ljava/lang/Runnable;", "key", "Lcom/facebook/internal/ImageDownloader$RequestKey;", "(Lcom/facebook/internal/ImageDownloader$RequestKey;)V", "run", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class DownloadImageWorkItem implements Runnable {
        private final RequestKey key;

        public DownloadImageWorkItem(RequestKey requestKey) {
            j.g(requestKey, SDKConstants.PARAM_KEY);
            this.key = requestKey;
        }

        public void run() {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    ImageDownloader.INSTANCE.download(this.key);
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/facebook/internal/ImageDownloader$DownloaderContext;", "", "request", "Lcom/facebook/internal/ImageRequest;", "(Lcom/facebook/internal/ImageRequest;)V", "isCancelled", "", "()Z", "setCancelled", "(Z)V", "getRequest", "()Lcom/facebook/internal/ImageRequest;", "setRequest", "workItem", "Lcom/facebook/internal/WorkQueue$WorkItem;", "getWorkItem", "()Lcom/facebook/internal/WorkQueue$WorkItem;", "setWorkItem", "(Lcom/facebook/internal/WorkQueue$WorkItem;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DownloaderContext {
        private boolean isCancelled;
        private ImageRequest request;
        private WorkQueue.WorkItem workItem;

        public DownloaderContext(ImageRequest imageRequest) {
            j.g(imageRequest, "request");
            this.request = imageRequest;
        }

        public final ImageRequest getRequest() {
            return this.request;
        }

        public final WorkQueue.WorkItem getWorkItem() {
            return this.workItem;
        }

        public final boolean isCancelled() {
            return this.isCancelled;
        }

        public final void setCancelled(boolean z10) {
            this.isCancelled = z10;
        }

        public final void setRequest(ImageRequest imageRequest) {
            j.g(imageRequest, "<set-?>");
            this.request = imageRequest;
        }

        public final void setWorkItem(WorkQueue.WorkItem workItem2) {
            this.workItem = workItem2;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0004\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/facebook/internal/ImageDownloader$RequestKey;", "", "uri", "Landroid/net/Uri;", "tag", "(Landroid/net/Uri;Ljava/lang/Object;)V", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "equals", "", "o", "hashCode", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class RequestKey {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        private Object tag;
        private Uri uri;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/ImageDownloader$RequestKey$Companion;", "", "()V", "HASH_MULTIPLIER", "", "HASH_SEED", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public RequestKey(Uri uri2, Object obj) {
            j.g(uri2, "uri");
            j.g(obj, "tag");
            this.uri = uri2;
            this.tag = obj;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof RequestKey)) {
                return false;
            }
            RequestKey requestKey = (RequestKey) obj;
            if (requestKey.uri == this.uri && requestKey.tag == this.tag) {
                return true;
            }
            return false;
        }

        public final Object getTag() {
            return this.tag;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return ((1073 + this.uri.hashCode()) * 37) + this.tag.hashCode();
        }

        public final void setTag(Object obj) {
            j.g(obj, "<set-?>");
            this.tag = obj;
        }

        public final void setUri(Uri uri2) {
            j.g(uri2, "<set-?>");
            this.uri = uri2;
        }
    }

    private ImageDownloader() {
    }

    public static final boolean cancelRequest(ImageRequest imageRequest) {
        boolean z10;
        j.g(imageRequest, "request");
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            DownloaderContext downloaderContext = map.get(requestKey);
            z10 = true;
            if (downloaderContext != null) {
                WorkQueue.WorkItem workItem = downloaderContext.getWorkItem();
                if (workItem == null || !workItem.cancel()) {
                    downloaderContext.setCancelled(true);
                } else {
                    map.remove(requestKey);
                }
            } else {
                z10 = false;
            }
            Unit unit = Unit.f32013a;
        }
        return z10;
    }

    public static final void clearCache() {
        ImageResponseCache.clearCache();
        UrlRedirectCache.clearCache();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.io.IOException} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a2, code lost:
        r5 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a3, code lost:
        r4 = null;
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b8, code lost:
        r11 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b8 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0018] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void download(com.facebook.internal.ImageDownloader.RequestKey r11) {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            r2 = 1
            java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00ce, all -> 0x00c5 }
            android.net.Uri r4 = r11.getUri()     // Catch:{ IOException -> 0x00ce, all -> 0x00c5 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00ce, all -> 0x00c5 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00ce, all -> 0x00c5 }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x00ce, all -> 0x00c5 }
            if (r3 == 0) goto L_0x00bd
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x00ce, all -> 0x00c5 }
            r3.setInstanceFollowRedirects(r1)     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            int r4 = r3.getResponseCode()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 == r5) goto L_0x00a6
            r5 = 301(0x12d, float:4.22E-43)
            if (r4 == r5) goto L_0x0064
            r5 = 302(0x12e, float:4.23E-43)
            if (r4 == r5) goto L_0x0064
            java.io.InputStream r4 = r3.getErrorStream()     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0061, all -> 0x005d }
            r5.<init>()     // Catch:{ IOException -> 0x0061, all -> 0x005d }
            if (r4 == 0) goto L_0x004d
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0061, all -> 0x005d }
            r6.<init>(r4)     // Catch:{ IOException -> 0x0061, all -> 0x005d }
            r7 = 128(0x80, float:1.794E-43)
            char[] r8 = new char[r7]     // Catch:{ IOException -> 0x0061, all -> 0x005d }
        L_0x003f:
            int r9 = r6.read(r8, r1, r7)     // Catch:{ IOException -> 0x0061, all -> 0x005d }
            if (r9 <= 0) goto L_0x0049
            r5.append(r8, r1, r9)     // Catch:{ IOException -> 0x0061, all -> 0x005d }
            goto L_0x003f
        L_0x0049:
            com.facebook.internal.Utility.closeQuietly(r6)     // Catch:{ IOException -> 0x0061, all -> 0x005d }
            goto L_0x0052
        L_0x004d:
            java.lang.String r6 = "Unexpected error while downloading an image."
            r5.append(r6)     // Catch:{ IOException -> 0x0061, all -> 0x005d }
        L_0x0052:
            com.facebook.FacebookException r6 = new com.facebook.FacebookException     // Catch:{ IOException -> 0x0061, all -> 0x005d }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0061, all -> 0x005d }
            r6.<init>((java.lang.String) r5)     // Catch:{ IOException -> 0x0061, all -> 0x005d }
            r5 = r0
            goto L_0x00af
        L_0x005d:
            r11 = move-exception
            r0 = r4
            goto L_0x00c7
        L_0x0061:
            r5 = move-exception
            goto L_0x00d1
        L_0x0064:
            java.lang.String r2 = "location"
            java.lang.String r2 = r3.getHeaderField(r2)     // Catch:{ IOException -> 0x00a2, all -> 0x00b8 }
            boolean r4 = com.facebook.internal.Utility.isNullOrEmpty((java.lang.String) r2)     // Catch:{ IOException -> 0x00a2, all -> 0x00b8 }
            if (r4 != 0) goto L_0x009e
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ IOException -> 0x00a2, all -> 0x00b8 }
            com.facebook.internal.UrlRedirectCache r4 = com.facebook.internal.UrlRedirectCache.INSTANCE     // Catch:{ IOException -> 0x00a2, all -> 0x00b8 }
            android.net.Uri r4 = r11.getUri()     // Catch:{ IOException -> 0x00a2, all -> 0x00b8 }
            com.facebook.internal.UrlRedirectCache.cacheUriRedirect(r4, r2)     // Catch:{ IOException -> 0x00a2, all -> 0x00b8 }
            com.facebook.internal.ImageDownloader$DownloaderContext r4 = r10.removePendingRequest(r11)     // Catch:{ IOException -> 0x00a2, all -> 0x00b8 }
            if (r4 == 0) goto L_0x009e
            boolean r5 = r4.isCancelled()     // Catch:{ IOException -> 0x00a2, all -> 0x00b8 }
            if (r5 != 0) goto L_0x009e
            com.facebook.internal.ImageRequest r4 = r4.getRequest()     // Catch:{ IOException -> 0x00a2, all -> 0x00b8 }
            com.facebook.internal.ImageDownloader$RequestKey r5 = new com.facebook.internal.ImageDownloader$RequestKey     // Catch:{ IOException -> 0x00a2, all -> 0x00b8 }
            java.lang.String r6 = "redirectUri"
            kotlin.jvm.internal.j.f(r2, r6)     // Catch:{ IOException -> 0x00a2, all -> 0x00b8 }
            java.lang.Object r6 = r11.getTag()     // Catch:{ IOException -> 0x00a2, all -> 0x00b8 }
            r5.<init>(r2, r6)     // Catch:{ IOException -> 0x00a2, all -> 0x00b8 }
            r10.enqueueCacheRead(r4, r5, r1)     // Catch:{ IOException -> 0x00a2, all -> 0x00b8 }
        L_0x009e:
            r5 = r0
            r6 = r5
            r2 = r1
            goto L_0x00b0
        L_0x00a2:
            r5 = move-exception
            r4 = r0
            r2 = r1
            goto L_0x00d1
        L_0x00a6:
            java.io.InputStream r4 = com.facebook.internal.ImageResponseCache.interceptAndCacheImageStream(r3)     // Catch:{ IOException -> 0x00ba, all -> 0x00b8 }
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r4)     // Catch:{ IOException -> 0x0061, all -> 0x005d }
            r6 = r0
        L_0x00af:
            r0 = r4
        L_0x00b0:
            com.facebook.internal.Utility.closeQuietly(r0)
            com.facebook.internal.Utility.disconnectQuietly(r3)
            r0 = r5
            goto L_0x00d8
        L_0x00b8:
            r11 = move-exception
            goto L_0x00c7
        L_0x00ba:
            r5 = move-exception
            r4 = r0
            goto L_0x00d1
        L_0x00bd:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch:{ IOException -> 0x00ce, all -> 0x00c5 }
            java.lang.String r4 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r3.<init>(r4)     // Catch:{ IOException -> 0x00ce, all -> 0x00c5 }
            throw r3     // Catch:{ IOException -> 0x00ce, all -> 0x00c5 }
        L_0x00c5:
            r11 = move-exception
            r3 = r0
        L_0x00c7:
            com.facebook.internal.Utility.closeQuietly(r0)
            com.facebook.internal.Utility.disconnectQuietly(r3)
            throw r11
        L_0x00ce:
            r5 = move-exception
            r3 = r0
            r4 = r3
        L_0x00d1:
            com.facebook.internal.Utility.closeQuietly(r4)
            com.facebook.internal.Utility.disconnectQuietly(r3)
            r6 = r5
        L_0x00d8:
            if (r2 == 0) goto L_0x00dd
            r10.issueResponse(r11, r6, r0, r1)
        L_0x00dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.download(com.facebook.internal.ImageDownloader$RequestKey):void");
    }

    public static final void downloadAsync(ImageRequest imageRequest) {
        if (imageRequest != null) {
            RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
            Map<RequestKey, DownloaderContext> map = pendingRequests;
            synchronized (map) {
                DownloaderContext downloaderContext = map.get(requestKey);
                if (downloaderContext != null) {
                    downloaderContext.setRequest(imageRequest);
                    downloaderContext.setCancelled(false);
                    WorkQueue.WorkItem workItem = downloaderContext.getWorkItem();
                    if (workItem != null) {
                        workItem.moveToFront();
                        Unit unit = Unit.f32013a;
                    }
                } else {
                    INSTANCE.enqueueCacheRead(imageRequest, requestKey, imageRequest.isCachedRedirectAllowed());
                    Unit unit2 = Unit.f32013a;
                }
            }
        }
    }

    private final void enqueueCacheRead(ImageRequest imageRequest, RequestKey requestKey, boolean z10) {
        enqueueRequest(imageRequest, requestKey, cacheReadQueue, new CacheReadWorkItem(requestKey, z10));
    }

    private final void enqueueDownload(ImageRequest imageRequest, RequestKey requestKey) {
        enqueueRequest(imageRequest, requestKey, downloadQueue, new DownloadImageWorkItem(requestKey));
    }

    private final void enqueueRequest(ImageRequest imageRequest, RequestKey requestKey, WorkQueue workQueue, Runnable runnable) {
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            DownloaderContext downloaderContext = new DownloaderContext(imageRequest);
            map.put(requestKey, downloaderContext);
            downloaderContext.setWorkItem(WorkQueue.addActiveWorkItem$default(workQueue, runnable, false, 2, (Object) null));
            Unit unit = Unit.f32013a;
        }
    }

    private final synchronized Handler getHandler() {
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        return handler;
    }

    private final void issueResponse(RequestKey requestKey, Exception exc, Bitmap bitmap, boolean z10) {
        ImageRequest.Callback callback;
        Handler handler2;
        DownloaderContext removePendingRequest = removePendingRequest(requestKey);
        if (removePendingRequest != null && !removePendingRequest.isCancelled()) {
            ImageRequest request = removePendingRequest.getRequest();
            if (request == null) {
                callback = null;
            } else {
                callback = request.getCallback();
            }
            ImageRequest.Callback callback2 = callback;
            if (callback2 != null && (handler2 = getHandler()) != null) {
                handler2.post(new n(request, exc, z10, bitmap, callback2));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: issueResponse$lambda-4  reason: not valid java name */
    public static final void m124issueResponse$lambda4(ImageRequest imageRequest, Exception exc, boolean z10, Bitmap bitmap, ImageRequest.Callback callback) {
        j.g(imageRequest, "$request");
        callback.onCompleted(new ImageResponse(imageRequest, exc, z10, bitmap));
    }

    public static final void prioritizeRequest(ImageRequest imageRequest) {
        j.g(imageRequest, "request");
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            DownloaderContext downloaderContext = map.get(requestKey);
            if (downloaderContext != null) {
                WorkQueue.WorkItem workItem = downloaderContext.getWorkItem();
                if (workItem != null) {
                    workItem.moveToFront();
                }
            }
            Unit unit = Unit.f32013a;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void readFromCache(com.facebook.internal.ImageDownloader.RequestKey r4, boolean r5) {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            if (r5 == 0) goto L_0x0018
            com.facebook.internal.UrlRedirectCache r5 = com.facebook.internal.UrlRedirectCache.INSTANCE
            android.net.Uri r5 = r4.getUri()
            android.net.Uri r5 = com.facebook.internal.UrlRedirectCache.getRedirectedUri(r5)
            if (r5 == 0) goto L_0x0018
            java.io.InputStream r5 = com.facebook.internal.ImageResponseCache.getCachedImageStream(r5)
            if (r5 == 0) goto L_0x0019
            r0 = 1
            goto L_0x0019
        L_0x0018:
            r5 = r1
        L_0x0019:
            if (r0 != 0) goto L_0x0025
            com.facebook.internal.ImageResponseCache r5 = com.facebook.internal.ImageResponseCache.INSTANCE
            android.net.Uri r5 = r4.getUri()
            java.io.InputStream r5 = com.facebook.internal.ImageResponseCache.getCachedImageStream(r5)
        L_0x0025:
            if (r5 == 0) goto L_0x0032
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r5)
            com.facebook.internal.Utility.closeQuietly(r5)
            r3.issueResponse(r4, r1, r2, r0)
            goto L_0x004a
        L_0x0032:
            com.facebook.internal.ImageDownloader$DownloaderContext r5 = r3.removePendingRequest(r4)
            if (r5 != 0) goto L_0x0039
            goto L_0x003d
        L_0x0039:
            com.facebook.internal.ImageRequest r1 = r5.getRequest()
        L_0x003d:
            if (r5 == 0) goto L_0x004a
            boolean r5 = r5.isCancelled()
            if (r5 != 0) goto L_0x004a
            if (r1 == 0) goto L_0x004a
            r3.enqueueDownload(r1, r4)
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.readFromCache(com.facebook.internal.ImageDownloader$RequestKey, boolean):void");
    }

    private final DownloaderContext removePendingRequest(RequestKey requestKey) {
        DownloaderContext remove;
        Map<RequestKey, DownloaderContext> map = pendingRequests;
        synchronized (map) {
            remove = map.remove(requestKey);
        }
        return remove;
    }

    public final Map<RequestKey, DownloaderContext> getPendingRequests() {
        return pendingRequests;
    }
}

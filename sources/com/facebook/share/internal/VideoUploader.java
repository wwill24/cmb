package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.WorkQueue;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.b;

public class VideoUploader {
    private static final String ERROR_BAD_SERVER_RESPONSE = "Unexpected error in server response";
    private static final String ERROR_UPLOAD = "Video upload failed";
    private static final int MAX_RETRIES_PER_PHASE = 2;
    private static final String PARAM_DESCRIPTION = "description";
    private static final String PARAM_END_OFFSET = "end_offset";
    private static final String PARAM_FILE_SIZE = "file_size";
    private static final String PARAM_REF = "ref";
    private static final String PARAM_SESSION_ID = "upload_session_id";
    private static final String PARAM_START_OFFSET = "start_offset";
    private static final String PARAM_TITLE = "title";
    private static final String PARAM_UPLOAD_PHASE = "upload_phase";
    private static final String PARAM_VALUE_UPLOAD_FINISH_PHASE = "finish";
    private static final String PARAM_VALUE_UPLOAD_START_PHASE = "start";
    private static final String PARAM_VALUE_UPLOAD_TRANSFER_PHASE = "transfer";
    private static final String PARAM_VIDEO_FILE_CHUNK = "video_file_chunk";
    private static final String PARAM_VIDEO_ID = "video_id";
    private static final int RETRY_DELAY_BACK_OFF_FACTOR = 3;
    private static final int RETRY_DELAY_UNIT_MS = 5000;
    private static final String TAG = "VideoUploader";
    private static final int UPLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static AccessTokenTracker accessTokenTracker;
    private static Handler handler;
    private static boolean initialized;
    private static Set<UploadContext> pendingUploads = new HashSet();
    private static WorkQueue uploadQueue = new WorkQueue(8);

    private static class FinishUploadWorkItem extends UploadWorkItemBase {
        static final Set<Integer> transientErrorCodes = new HashSet<Integer>() {
            {
                add(1363011);
            }
        };

        public FinishUploadWorkItem(UploadContext uploadContext, int i10) {
            super(uploadContext, i10);
        }

        /* access modifiers changed from: protected */
        public void enqueueRetry(int i10) {
            VideoUploader.enqueueUploadFinish(this.uploadContext, i10);
        }

        public Bundle getParameters() {
            Bundle bundle = new Bundle();
            Bundle bundle2 = this.uploadContext.params;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            bundle.putString(VideoUploader.PARAM_UPLOAD_PHASE, VideoUploader.PARAM_VALUE_UPLOAD_FINISH_PHASE);
            bundle.putString(VideoUploader.PARAM_SESSION_ID, this.uploadContext.sessionId);
            Utility.putNonEmptyString(bundle, "title", this.uploadContext.title);
            Utility.putNonEmptyString(bundle, "description", this.uploadContext.description);
            Utility.putNonEmptyString(bundle, VideoUploader.PARAM_REF, this.uploadContext.ref);
            return bundle;
        }

        /* access modifiers changed from: protected */
        public Set<Integer> getTransientErrorCodes() {
            return transientErrorCodes;
        }

        /* access modifiers changed from: protected */
        public void handleError(FacebookException facebookException) {
            VideoUploader.logError(facebookException, "Video '%s' failed to finish uploading", this.uploadContext.videoId);
            endUploadWithFailure(facebookException);
        }

        /* access modifiers changed from: protected */
        public void handleSuccess(b bVar) throws JSONException {
            if (bVar.getBoolean("success")) {
                issueResponseOnMainThread((FacebookException) null, this.uploadContext.videoId);
            } else {
                handleError(new FacebookException(VideoUploader.ERROR_BAD_SERVER_RESPONSE));
            }
        }
    }

    private static class StartUploadWorkItem extends UploadWorkItemBase {
        static final Set<Integer> transientErrorCodes = new HashSet<Integer>() {
            {
                add(6000);
            }
        };

        public StartUploadWorkItem(UploadContext uploadContext, int i10) {
            super(uploadContext, i10);
        }

        /* access modifiers changed from: protected */
        public void enqueueRetry(int i10) {
            VideoUploader.enqueueUploadStart(this.uploadContext, i10);
        }

        public Bundle getParameters() {
            Bundle bundle = new Bundle();
            bundle.putString(VideoUploader.PARAM_UPLOAD_PHASE, "start");
            bundle.putLong(VideoUploader.PARAM_FILE_SIZE, this.uploadContext.videoSize);
            return bundle;
        }

        /* access modifiers changed from: protected */
        public Set<Integer> getTransientErrorCodes() {
            return transientErrorCodes;
        }

        /* access modifiers changed from: protected */
        public void handleError(FacebookException facebookException) {
            VideoUploader.logError(facebookException, "Error starting video upload", new Object[0]);
            endUploadWithFailure(facebookException);
        }

        /* access modifiers changed from: protected */
        public void handleSuccess(b bVar) throws JSONException {
            this.uploadContext.sessionId = bVar.getString(VideoUploader.PARAM_SESSION_ID);
            this.uploadContext.videoId = bVar.getString(VideoUploader.PARAM_VIDEO_ID);
            String string = bVar.getString(VideoUploader.PARAM_START_OFFSET);
            String string2 = bVar.getString(VideoUploader.PARAM_END_OFFSET);
            if (this.uploadContext.progressCallback != null) {
                long parseLong = Long.parseLong(string);
                UploadContext uploadContext = this.uploadContext;
                uploadContext.progressCallback.onProgress(parseLong, uploadContext.videoSize);
            }
            VideoUploader.enqueueUploadChunk(this.uploadContext, string, string2, 0);
        }
    }

    private static class TransferChunkWorkItem extends UploadWorkItemBase {
        static final Set<Integer> transientErrorCodes = new HashSet<Integer>() {
            {
                add(1363019);
                add(1363021);
                add(1363030);
                add(1363033);
                add(1363041);
            }
        };
        private String chunkEnd;
        private String chunkStart;

        public TransferChunkWorkItem(UploadContext uploadContext, String str, String str2, int i10) {
            super(uploadContext, i10);
            this.chunkStart = str;
            this.chunkEnd = str2;
        }

        /* access modifiers changed from: protected */
        public void enqueueRetry(int i10) {
            VideoUploader.enqueueUploadChunk(this.uploadContext, this.chunkStart, this.chunkEnd, i10);
        }

        public Bundle getParameters() throws IOException {
            Bundle bundle = new Bundle();
            bundle.putString(VideoUploader.PARAM_UPLOAD_PHASE, VideoUploader.PARAM_VALUE_UPLOAD_TRANSFER_PHASE);
            bundle.putString(VideoUploader.PARAM_SESSION_ID, this.uploadContext.sessionId);
            bundle.putString(VideoUploader.PARAM_START_OFFSET, this.chunkStart);
            byte[] access$600 = VideoUploader.getChunk(this.uploadContext, this.chunkStart, this.chunkEnd);
            if (access$600 != null) {
                bundle.putByteArray(VideoUploader.PARAM_VIDEO_FILE_CHUNK, access$600);
                return bundle;
            }
            throw new FacebookException("Error reading video");
        }

        /* access modifiers changed from: protected */
        public Set<Integer> getTransientErrorCodes() {
            return transientErrorCodes;
        }

        /* access modifiers changed from: protected */
        public void handleError(FacebookException facebookException) {
            VideoUploader.logError(facebookException, "Error uploading video '%s'", this.uploadContext.videoId);
            endUploadWithFailure(facebookException);
        }

        /* access modifiers changed from: protected */
        public void handleSuccess(b bVar) throws JSONException {
            String string = bVar.getString(VideoUploader.PARAM_START_OFFSET);
            String string2 = bVar.getString(VideoUploader.PARAM_END_OFFSET);
            if (this.uploadContext.progressCallback != null) {
                long parseLong = Long.parseLong(string);
                UploadContext uploadContext = this.uploadContext;
                uploadContext.progressCallback.onProgress(parseLong, uploadContext.videoSize);
            }
            if (Utility.areObjectsEqual(string, string2)) {
                VideoUploader.enqueueUploadFinish(this.uploadContext, 0);
            } else {
                VideoUploader.enqueueUploadChunk(this.uploadContext, string, string2, 0);
            }
        }
    }

    private static class UploadContext {
        public final AccessToken accessToken;
        public final FacebookCallback<Sharer.Result> callback;
        public String chunkStart;
        public final String description;
        public final String graphNode;
        public boolean isCanceled;
        public Bundle params;
        public final GraphRequest.OnProgressCallback progressCallback;
        public final String ref;
        public String sessionId;
        public final String title;
        public String videoId;
        public long videoSize;
        public InputStream videoStream;
        public final Uri videoUri;
        public WorkQueue.WorkItem workItem;

        /* access modifiers changed from: private */
        public void initialize() throws FileNotFoundException {
            try {
                if (Utility.isFileUri(this.videoUri)) {
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(new File(this.videoUri.getPath()), 268435456);
                    this.videoSize = open.getStatSize();
                    this.videoStream = new ParcelFileDescriptor.AutoCloseInputStream(open);
                } else if (Utility.isContentUri(this.videoUri)) {
                    this.videoSize = Utility.getContentSize(this.videoUri);
                    this.videoStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(this.videoUri);
                } else {
                    throw new FacebookException("Uri must be a content:// or file:// uri");
                }
            } catch (FileNotFoundException e10) {
                Utility.closeQuietly(this.videoStream);
                throw e10;
            }
        }

        private UploadContext(ShareVideoContent shareVideoContent, String str, FacebookCallback<Sharer.Result> facebookCallback, GraphRequest.OnProgressCallback onProgressCallback) {
            this.chunkStart = "0";
            this.accessToken = AccessToken.getCurrentAccessToken();
            this.videoUri = shareVideoContent.getVideo().getLocalUrl();
            this.title = shareVideoContent.getContentTitle();
            this.description = shareVideoContent.getContentDescription();
            this.ref = shareVideoContent.getRef();
            this.graphNode = str;
            this.callback = facebookCallback;
            this.progressCallback = onProgressCallback;
            this.params = shareVideoContent.getVideo().getParameters();
            if (!Utility.isNullOrEmpty((Collection<?>) shareVideoContent.getPeopleIds())) {
                this.params.putString("tags", TextUtils.join(", ", shareVideoContent.getPeopleIds()));
            }
            if (!Utility.isNullOrEmpty(shareVideoContent.getPlaceId())) {
                this.params.putString("place", shareVideoContent.getPlaceId());
            }
            if (!Utility.isNullOrEmpty(shareVideoContent.getRef())) {
                this.params.putString(VideoUploader.PARAM_REF, shareVideoContent.getRef());
            }
        }
    }

    private static abstract class UploadWorkItemBase implements Runnable {
        protected int completedRetries;
        protected GraphResponse response;
        protected UploadContext uploadContext;

        protected UploadWorkItemBase(UploadContext uploadContext2, int i10) {
            this.uploadContext = uploadContext2;
            this.completedRetries = i10;
        }

        private boolean attemptRetry(int i10) {
            if (this.completedRetries >= 2 || !getTransientErrorCodes().contains(Integer.valueOf(i10))) {
                return false;
            }
            VideoUploader.getHandler().postDelayed(new Runnable() {
                public void run() {
                    if (!CrashShieldHandler.isObjectCrashing(this)) {
                        try {
                            UploadWorkItemBase uploadWorkItemBase = UploadWorkItemBase.this;
                            uploadWorkItemBase.enqueueRetry(uploadWorkItemBase.completedRetries + 1);
                        } catch (Throwable th2) {
                            CrashShieldHandler.handleThrowable(th2, this);
                        }
                    }
                }
            }, (long) (((int) Math.pow(3.0d, (double) this.completedRetries)) * 5000));
            return true;
        }

        /* access modifiers changed from: protected */
        public void endUploadWithFailure(FacebookException facebookException) {
            issueResponseOnMainThread(facebookException, (String) null);
        }

        /* access modifiers changed from: protected */
        public abstract void enqueueRetry(int i10);

        /* access modifiers changed from: protected */
        public void executeGraphRequestSynchronously(Bundle bundle) {
            UploadContext uploadContext2 = this.uploadContext;
            Bundle bundle2 = bundle;
            GraphResponse executeAndWait = new GraphRequest(uploadContext2.accessToken, String.format(Locale.ROOT, "%s/videos", new Object[]{uploadContext2.graphNode}), bundle2, HttpMethod.POST, (GraphRequest.Callback) null).executeAndWait();
            this.response = executeAndWait;
            if (executeAndWait != null) {
                FacebookRequestError error = executeAndWait.getError();
                b jSONObject = this.response.getJSONObject();
                if (error != null) {
                    if (!attemptRetry(error.getSubErrorCode())) {
                        handleError(new FacebookGraphResponseException(this.response, VideoUploader.ERROR_UPLOAD));
                    }
                } else if (jSONObject != null) {
                    try {
                        handleSuccess(jSONObject);
                    } catch (JSONException e10) {
                        endUploadWithFailure(new FacebookException(VideoUploader.ERROR_BAD_SERVER_RESPONSE, (Throwable) e10));
                    }
                } else {
                    handleError(new FacebookException(VideoUploader.ERROR_BAD_SERVER_RESPONSE));
                }
            } else {
                handleError(new FacebookException(VideoUploader.ERROR_BAD_SERVER_RESPONSE));
            }
        }

        /* access modifiers changed from: protected */
        public abstract Bundle getParameters() throws Exception;

        /* access modifiers changed from: protected */
        public abstract Set<Integer> getTransientErrorCodes();

        /* access modifiers changed from: protected */
        public abstract void handleError(FacebookException facebookException);

        /* access modifiers changed from: protected */
        public abstract void handleSuccess(b bVar) throws JSONException;

        /* access modifiers changed from: protected */
        public void issueResponseOnMainThread(final FacebookException facebookException, final String str) {
            VideoUploader.getHandler().post(new Runnable() {
                public void run() {
                    if (!CrashShieldHandler.isObjectCrashing(this)) {
                        try {
                            UploadWorkItemBase uploadWorkItemBase = UploadWorkItemBase.this;
                            VideoUploader.issueResponse(uploadWorkItemBase.uploadContext, facebookException, uploadWorkItemBase.response, str);
                        } catch (Throwable th2) {
                            CrashShieldHandler.handleThrowable(th2, this);
                        }
                    }
                }
            });
        }

        public void run() {
            if (!CrashShieldHandler.isObjectCrashing(this)) {
                try {
                    if (!this.uploadContext.isCanceled) {
                        executeGraphRequestSynchronously(getParameters());
                    } else {
                        endUploadWithFailure((FacebookException) null);
                    }
                } catch (FacebookException e10) {
                    endUploadWithFailure(e10);
                } catch (Exception e11) {
                    endUploadWithFailure(new FacebookException(VideoUploader.ERROR_UPLOAD, (Throwable) e11));
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, this);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static synchronized void cancelAllRequests() {
        synchronized (VideoUploader.class) {
            for (UploadContext uploadContext : pendingUploads) {
                uploadContext.isCanceled = true;
            }
        }
    }

    private static synchronized void enqueueRequest(UploadContext uploadContext, Runnable runnable) {
        synchronized (VideoUploader.class) {
            uploadContext.workItem = uploadQueue.addActiveWorkItem(runnable);
        }
    }

    /* access modifiers changed from: private */
    public static void enqueueUploadChunk(UploadContext uploadContext, String str, String str2, int i10) {
        enqueueRequest(uploadContext, new TransferChunkWorkItem(uploadContext, str, str2, i10));
    }

    /* access modifiers changed from: private */
    public static void enqueueUploadFinish(UploadContext uploadContext, int i10) {
        enqueueRequest(uploadContext, new FinishUploadWorkItem(uploadContext, i10));
    }

    /* access modifiers changed from: private */
    public static void enqueueUploadStart(UploadContext uploadContext, int i10) {
        enqueueRequest(uploadContext, new StartUploadWorkItem(uploadContext, i10));
    }

    /* access modifiers changed from: private */
    public static byte[] getChunk(UploadContext uploadContext, String str, String str2) throws IOException {
        int read;
        if (!Utility.areObjectsEqual(str, uploadContext.chunkStart)) {
            logError((Exception) null, "Error reading video chunk. Expected chunk '%s'. Requested chunk '%s'.", uploadContext.chunkStart, str);
            return null;
        }
        int parseLong = (int) (Long.parseLong(str2) - Long.parseLong(str));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[Math.min(8192, parseLong)];
        do {
            read = uploadContext.videoStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
                parseLong -= read;
                if (parseLong == 0) {
                }
            }
            uploadContext.chunkStart = str2;
            return byteArrayOutputStream.toByteArray();
        } while (parseLong >= 0);
        logError((Exception) null, "Error reading video chunk. Expected buffer length - '%d'. Actual - '%d'.", Integer.valueOf(parseLong + read), Integer.valueOf(read));
        return null;
    }

    /* access modifiers changed from: private */
    public static synchronized Handler getHandler() {
        Handler handler2;
        synchronized (VideoUploader.class) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler2 = handler;
        }
        return handler2;
    }

    /* access modifiers changed from: private */
    public static void issueResponse(UploadContext uploadContext, FacebookException facebookException, GraphResponse graphResponse, String str) {
        removePendingUpload(uploadContext);
        Utility.closeQuietly(uploadContext.videoStream);
        FacebookCallback<Sharer.Result> facebookCallback = uploadContext.callback;
        if (facebookCallback != null) {
            if (facebookException != null) {
                ShareInternalUtility.invokeOnErrorCallback(facebookCallback, facebookException);
            } else if (uploadContext.isCanceled) {
                ShareInternalUtility.invokeOnCancelCallback(facebookCallback);
            } else {
                ShareInternalUtility.invokeOnSuccessCallback(facebookCallback, str);
            }
        }
        if (uploadContext.progressCallback != null) {
            if (graphResponse != null) {
                try {
                    if (graphResponse.getJSONObject() != null) {
                        graphResponse.getJSONObject().put(PARAM_VIDEO_ID, (Object) str);
                    }
                } catch (JSONException unused) {
                }
            }
            uploadContext.progressCallback.onCompleted(graphResponse);
        }
    }

    /* access modifiers changed from: private */
    public static void logError(Exception exc, String str, Object... objArr) {
        String.format(Locale.ROOT, str, objArr);
    }

    private static void registerAccessTokenTracker() {
        accessTokenTracker = new AccessTokenTracker() {
            /* access modifiers changed from: protected */
            public void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                if (accessToken != null) {
                    if (accessToken2 == null || !Utility.areObjectsEqual(accessToken2.getUserId(), accessToken.getUserId())) {
                        VideoUploader.cancelAllRequests();
                    }
                }
            }
        };
    }

    private static synchronized void removePendingUpload(UploadContext uploadContext) {
        synchronized (VideoUploader.class) {
            pendingUploads.remove(uploadContext);
        }
    }

    public static synchronized void uploadAsync(ShareVideoContent shareVideoContent, String str, FacebookCallback<Sharer.Result> facebookCallback) throws FileNotFoundException {
        synchronized (VideoUploader.class) {
            uploadAsync(shareVideoContent, str, facebookCallback, (GraphRequest.OnProgressCallback) null);
        }
    }

    public static synchronized void uploadAsyncWithProgressCallback(ShareVideoContent shareVideoContent, GraphRequest.OnProgressCallback onProgressCallback) throws FileNotFoundException {
        synchronized (VideoUploader.class) {
            uploadAsync(shareVideoContent, "me", (FacebookCallback<Sharer.Result>) null, onProgressCallback);
        }
    }

    private static synchronized void uploadAsync(ShareVideoContent shareVideoContent, String str, FacebookCallback<Sharer.Result> facebookCallback, GraphRequest.OnProgressCallback onProgressCallback) throws FileNotFoundException {
        synchronized (VideoUploader.class) {
            if (!initialized) {
                registerAccessTokenTracker();
                initialized = true;
            }
            Validate.notNull(shareVideoContent, "videoContent");
            Validate.notNull(str, "graphNode");
            ShareVideo video = shareVideoContent.getVideo();
            Validate.notNull(video, "videoContent.video");
            Validate.notNull(video.getLocalUrl(), "videoContent.video.localUrl");
            UploadContext uploadContext = new UploadContext(shareVideoContent, str, facebookCallback, onProgressCallback);
            uploadContext.initialize();
            pendingUploads.add(uploadContext);
            enqueueUploadStart(uploadContext, 0);
        }
    }

    public static synchronized void uploadAsyncWithProgressCallback(ShareVideoContent shareVideoContent, String str, GraphRequest.OnProgressCallback onProgressCallback) throws FileNotFoundException {
        synchronized (VideoUploader.class) {
            uploadAsync(shareVideoContent, str, (FacebookCallback<Sharer.Result>) null, onProgressCallback);
        }
    }
}

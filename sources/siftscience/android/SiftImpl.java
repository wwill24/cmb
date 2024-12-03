package siftscience.android;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.google.gson.JsonSyntaxException;
import com.sift.api.representations.MobileEventJson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import siftscience.android.Queue;
import siftscience.android.Sift;
import siftscience.android.Uploader;

class SiftImpl {
    /* access modifiers changed from: private */
    public static final Queue.Config APP_STATE_QUEUE_CONFIG;
    static final String APP_STATE_QUEUE_IDENTIFIER = "siftscience.android.app";
    private static final String ARCHIVE_NAME = "siftscience";
    /* access modifiers changed from: private */
    public static final Queue.Config DEVICE_PROPERTIES_QUEUE_CONFIG;
    static final String DEVICE_PROPERTIES_QUEUE_IDENTIFIER = "siftscience.android.device";
    /* access modifiers changed from: private */
    public static final String TAG = "siftscience.android.SiftImpl";
    /* access modifiers changed from: private */
    public final SharedPreferences archives;
    /* access modifiers changed from: private */
    public Sift.Config config;
    private final Uploader.ConfigProvider configProvider;
    /* access modifiers changed from: private */
    public final Map<String, Queue> queues;
    private final TaskManager taskManager;
    /* access modifiers changed from: private */
    public final Queue.UploadRequester uploadRequester;
    private final Uploader uploader;
    /* access modifiers changed from: private */
    public String userId;
    /* access modifiers changed from: private */
    public final Queue.UserIdProvider userIdProvider;

    private class AppendTask implements Runnable {
        private MobileEventJson event;
        private String queueIdentifier;

        AppendTask(String str, MobileEventJson mobileEventJson) {
            this.queueIdentifier = str;
            this.event = mobileEventJson;
        }

        public void run() {
            Queue queue = SiftImpl.this.getQueue(this.queueIdentifier);
            if (queue != null) {
                queue.append(this.event);
            }
        }
    }

    private enum ArchiveKey {
        CONFIG("config"),
        USER_ID("user_id"),
        QUEUE("queue");
        
        public final String key;

        private ArchiveKey(String str) {
            this.key = str;
        }

        static String getKeyForQueueIdentifier(String str) {
            return String.format("%s/%s", new Object[]{QUEUE.key, str});
        }

        static String getQueueIdentifier(String str) {
            int indexOf;
            if (str.startsWith(QUEUE.key) && (indexOf = str.indexOf(47)) != -1) {
                return str.substring(indexOf + 1);
            }
            return null;
        }
    }

    private class ArchiveTask implements Runnable {
        private ArchiveTask() {
        }

        public void run() {
            SharedPreferences.Editor edit = SiftImpl.this.archives.edit();
            edit.clear();
            try {
                edit.putString(ArchiveKey.CONFIG.key, SiftImpl.this.archiveConfig());
                String unused = SiftImpl.TAG;
                String.format("Archived Sift.Config: %s", new Object[]{SiftImpl.this.archiveConfig()});
                edit.putString(ArchiveKey.USER_ID.key, SiftImpl.this.getUserId());
                String unused2 = SiftImpl.TAG;
                String.format("Archived User ID: %s", new Object[]{SiftImpl.this.getUserId()});
                for (Map.Entry entry : SiftImpl.this.queues.entrySet()) {
                    String keyForQueueIdentifier = ArchiveKey.getKeyForQueueIdentifier((String) entry.getKey());
                    String unused3 = SiftImpl.TAG;
                    String.format("Archived %s Queue", new Object[]{keyForQueueIdentifier});
                    edit.putString(keyForQueueIdentifier, ((Queue) entry.getValue()).archive());
                }
            } finally {
                edit.apply();
            }
        }
    }

    private class ForceUploadTask implements Runnable {
        private String queueIdentifier;

        ForceUploadTask(String str) {
            this.queueIdentifier = str;
        }

        public void run() {
            Queue queue = SiftImpl.this.getQueue(this.queueIdentifier);
            if (queue != null) {
                queue.forceUpload();
            }
        }
    }

    private class SetConfigTask implements Runnable {
        private Sift.Config config;

        SetConfigTask(Sift.Config config2) {
            this.config = config2;
        }

        public void run() {
            synchronized (this) {
                Sift.Config unused = SiftImpl.this.config = this.config;
            }
        }
    }

    private class SetUserIdTask implements Runnable {
        private String userId;

        SetUserIdTask(String str) {
            this.userId = str;
        }

        public void run() {
            synchronized (this) {
                String unused = SiftImpl.this.userId = this.userId;
            }
        }
    }

    private class UnarchiveTask implements Runnable {
        private final boolean hasUnboundUserId;

        public UnarchiveTask(boolean z10) {
            this.hasUnboundUserId = z10;
        }

        public void run() {
            if (SiftImpl.this.config == null) {
                String string = SiftImpl.this.archives.getString(ArchiveKey.CONFIG.key, (String) null);
                SiftImpl siftImpl = SiftImpl.this;
                Sift.Config unused = siftImpl.config = siftImpl.unarchiveConfig(string);
                String unused2 = SiftImpl.TAG;
                String.format("Unarchived Sift.Config: %s", new Object[]{string});
            }
            if (!this.hasUnboundUserId) {
                SiftImpl siftImpl2 = SiftImpl.this;
                String unused3 = siftImpl2.userId = siftImpl2.archives.getString(ArchiveKey.USER_ID.key, (String) null);
                String unused4 = SiftImpl.TAG;
                String.format("Unarchived User ID: %s", new Object[]{SiftImpl.this.userId});
            }
            for (Map.Entry next : SiftImpl.this.archives.getAll().entrySet()) {
                String queueIdentifier = ArchiveKey.getQueueIdentifier((String) next.getKey());
                String str = (String) next.getValue();
                if (queueIdentifier != null) {
                    if (queueIdentifier.equals(SiftImpl.DEVICE_PROPERTIES_QUEUE_IDENTIFIER)) {
                        Queue queue = new Queue(str, SiftImpl.this.userIdProvider, SiftImpl.this.uploadRequester, SiftImpl.DEVICE_PROPERTIES_QUEUE_CONFIG);
                        String unused5 = SiftImpl.TAG;
                        SiftImpl.this.queues.put(queueIdentifier, queue);
                    }
                    if (queueIdentifier.equals(SiftImpl.APP_STATE_QUEUE_IDENTIFIER)) {
                        Queue queue2 = new Queue(str, SiftImpl.this.userIdProvider, SiftImpl.this.uploadRequester, SiftImpl.APP_STATE_QUEUE_CONFIG);
                        String unused6 = SiftImpl.TAG;
                        SiftImpl.this.queues.put(queueIdentifier, queue2);
                    }
                }
            }
            if (!SiftImpl.this.queues.containsKey(SiftImpl.DEVICE_PROPERTIES_QUEUE_IDENTIFIER)) {
                SiftImpl.this.createQueue(SiftImpl.DEVICE_PROPERTIES_QUEUE_IDENTIFIER, SiftImpl.DEVICE_PROPERTIES_QUEUE_CONFIG);
            }
            if (!SiftImpl.this.queues.containsKey(SiftImpl.APP_STATE_QUEUE_IDENTIFIER)) {
                SiftImpl.this.createQueue(SiftImpl.APP_STATE_QUEUE_IDENTIFIER, SiftImpl.APP_STATE_QUEUE_CONFIG);
            }
        }
    }

    static {
        Queue.Config.Builder withUploadWhenMoreThan = new Queue.Config.Builder().withAcceptSameEventAfter(TimeUnit.HOURS.toMillis(1)).withUploadWhenMoreThan(0);
        TimeUnit timeUnit = TimeUnit.MINUTES;
        DEVICE_PROPERTIES_QUEUE_CONFIG = withUploadWhenMoreThan.withUploadWhenOlderThan(timeUnit.toMillis(1)).build();
        APP_STATE_QUEUE_CONFIG = new Queue.Config.Builder().withUploadWhenMoreThan(8).withUploadWhenOlderThan(timeUnit.toMillis(1)).build();
    }

    SiftImpl(Context context, Sift.Config config2, String str, boolean z10) {
        this(context, config2, str, z10, new TaskManager());
    }

    /* access modifiers changed from: package-private */
    public void appendAppStateEvent(MobileEventJson mobileEventJson) {
        this.taskManager.submit(new AppendTask(APP_STATE_QUEUE_IDENTIFIER, mobileEventJson));
    }

    /* access modifiers changed from: package-private */
    public void appendDevicePropertiesEvent(MobileEventJson mobileEventJson) {
        this.taskManager.submit(new AppendTask(DEVICE_PROPERTIES_QUEUE_IDENTIFIER, mobileEventJson));
    }

    /* access modifiers changed from: package-private */
    public String archiveConfig() {
        return Sift.GSON.u(this.config);
    }

    /* access modifiers changed from: package-private */
    public Queue createQueue(@NonNull String str, Queue.Config config2) {
        if (getQueue(str) == null) {
            Queue queue = new Queue((String) null, this.userIdProvider, this.uploadRequester, config2);
            this.queues.put(str, queue);
            String.format("Created new %s queue", new Object[]{str});
            return queue;
        }
        throw new IllegalStateException(String.format("Queue exists: %s", new Object[]{str}));
    }

    /* access modifiers changed from: package-private */
    public void forceUploadAppStateEvent() {
        this.taskManager.submit(new ForceUploadTask(APP_STATE_QUEUE_IDENTIFIER));
    }

    /* access modifiers changed from: package-private */
    public void forceUploadDevicePropertiesEvent() {
        this.taskManager.submit(new ForceUploadTask(DEVICE_PROPERTIES_QUEUE_IDENTIFIER));
    }

    /* access modifiers changed from: package-private */
    public synchronized Sift.Config getConfig() {
        Sift.Config config2 = this.config;
        if (config2 != null) {
            return config2;
        }
        return unarchiveConfig(this.archives.getString(ArchiveKey.CONFIG.key, (String) null));
    }

    /* access modifiers changed from: package-private */
    public Queue getQueue(@NonNull String str) {
        return this.queues.get(str);
    }

    /* access modifiers changed from: package-private */
    public synchronized String getUserId() {
        return this.userId;
    }

    /* access modifiers changed from: package-private */
    public void save() {
        this.taskManager.submit(new ArchiveTask());
    }

    /* access modifiers changed from: package-private */
    public void setConfig(Sift.Config config2) {
        this.taskManager.submit(new SetConfigTask(config2));
    }

    /* access modifiers changed from: package-private */
    public void setUserId(String str) {
        this.taskManager.submit(new SetUserIdTask(str));
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        this.taskManager.shutdown();
    }

    /* access modifiers changed from: package-private */
    public Sift.Config unarchiveConfig(String str) {
        if (str == null) {
            Sift.Config config2 = this.config;
            if (config2 == null) {
                return new Sift.Config();
            }
            return config2;
        }
        try {
            return (Sift.Config) Sift.GSON.k(str, Sift.Config.class);
        } catch (JsonSyntaxException unused) {
            Sift.Config config3 = this.config;
            if (config3 == null) {
                return new Sift.Config();
            }
            return config3;
        }
    }

    /* access modifiers changed from: package-private */
    public void unsetUserId() {
        this.taskManager.submit(new SetUserIdTask((String) null));
    }

    /* access modifiers changed from: package-private */
    public void upload(List<MobileEventJson> list) {
        this.uploader.upload(list);
    }

    SiftImpl(Context context, Sift.Config config2, String str, boolean z10, TaskManager taskManager2) {
        this.userIdProvider = new Queue.UserIdProvider() {
            public String getUserId() {
                return SiftImpl.this.getUserId();
            }
        };
        this.uploadRequester = new Queue.UploadRequester() {
            public void requestUpload(List<MobileEventJson> list) {
                SiftImpl.this.upload(list);
            }
        };
        AnonymousClass3 r02 = new Uploader.ConfigProvider() {
            public Sift.Config getConfig() {
                return SiftImpl.this.getConfig();
            }
        };
        this.configProvider = r02;
        this.archives = context.getSharedPreferences(ARCHIVE_NAME, 0);
        this.taskManager = taskManager2;
        this.config = config2;
        if (z10) {
            this.userId = str;
            String.format("Using unbound User ID: %s", new Object[]{str});
        }
        this.queues = new HashMap();
        this.uploader = new Uploader(taskManager2, r02);
        taskManager2.submit(new UnarchiveTask(z10));
    }
}

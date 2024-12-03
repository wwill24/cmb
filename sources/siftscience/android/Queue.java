package siftscience.android;

import androidx.annotation.NonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.sift.api.representations.MobileEventJson;
import java.util.ArrayList;
import java.util.List;
import lg.c;

public class Queue {
    private static final String TAG = "siftscience.android.Queue";
    private final Config config;
    private final State state;
    private final UploadRequester uploadRequester;
    private final UserIdProvider userIdProvider;

    public static class Config {
        /* access modifiers changed from: private */
        @c(alternate = {"acceptSameEventAfter"}, value = "accept_same_event_after")
        public final long acceptSameEventAfter;
        /* access modifiers changed from: private */
        @c(alternate = {"uploadWhenMoreThan"}, value = "upload_when_more_than")
        public final int uploadWhenMoreThan;
        /* access modifiers changed from: private */
        @c(alternate = {"uploadWhenOlderThan"}, value = "upload_when_older_than")
        public final long uploadWhenOlderThan;

        public static class Builder {
            private long acceptSameEventAfter = 0;
            private int uploadWhenMoreThan = 0;
            private long uploadWhenOlderThan = 0;

            public Config build() {
                return new Config(this.acceptSameEventAfter, this.uploadWhenMoreThan, this.uploadWhenOlderThan);
            }

            /* access modifiers changed from: package-private */
            public Builder withAcceptSameEventAfter(long j10) {
                this.acceptSameEventAfter = j10;
                return this;
            }

            /* access modifiers changed from: package-private */
            public Builder withUploadWhenMoreThan(int i10) {
                this.uploadWhenMoreThan = i10;
                return this;
            }

            /* access modifiers changed from: package-private */
            public Builder withUploadWhenOlderThan(long j10) {
                this.uploadWhenOlderThan = j10;
                return this;
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            if (this.acceptSameEventAfter == config.acceptSameEventAfter && this.uploadWhenMoreThan == config.uploadWhenMoreThan && this.uploadWhenOlderThan == config.uploadWhenOlderThan) {
                return true;
            }
            return false;
        }

        private Config(long j10, int i10, long j11) {
            this.acceptSameEventAfter = j10;
            this.uploadWhenMoreThan = i10;
            this.uploadWhenOlderThan = j11;
        }
    }

    private static class State {
        @c("config")
        Config config;
        @c(alternate = {"lastEvent"}, value = "last_event")
        MobileEventJson lastEvent = null;
        @c(alternate = {"lastUploadTimestamp"}, value = "last_upload_timestamp")
        long lastUploadTimestamp = 0;
        @c("queue")
        List<MobileEventJson> queue = new ArrayList();

        State() {
        }
    }

    interface UploadRequester {
        void requestUpload(List<MobileEventJson> list);
    }

    interface UserIdProvider {
        String getUserId();
    }

    Queue(String str, UserIdProvider userIdProvider2, UploadRequester uploadRequester2, Config config2) {
        this.state = unarchive(str);
        this.config = config2;
        this.userIdProvider = userIdProvider2;
        this.uploadRequester = uploadRequester2;
    }

    /* access modifiers changed from: package-private */
    public void append(@NonNull MobileEventJson mobileEventJson) {
        MobileEventJson mobileEventJson2;
        long now = Time.now();
        if (mobileEventJson.userId == null) {
            mobileEventJson.userId = this.userIdProvider.getUserId();
        }
        if (this.config.acceptSameEventAfter <= 0 || (mobileEventJson2 = this.state.lastEvent) == null || now >= mobileEventJson2.time.longValue() + this.config.acceptSameEventAfter || !Utils.eventsAreBasicallyEqual(this.state.lastEvent, mobileEventJson)) {
            String.format("Append event: %s", new Object[]{mobileEventJson.toString()});
            this.state.queue.add(mobileEventJson);
            this.state.lastEvent = mobileEventJson;
            if (isReadyForUpload(now)) {
                this.state.lastUploadTimestamp = now;
                this.uploadRequester.requestUpload(flush());
                return;
            }
            return;
        }
        String.format("Drop duplicate event: %s", new Object[]{mobileEventJson.toString()});
    }

    /* access modifiers changed from: package-private */
    public String archive() throws JsonParseException {
        return Sift.GSON.u(this.state);
    }

    /* access modifiers changed from: package-private */
    public List<MobileEventJson> flush() {
        State state2 = this.state;
        List<MobileEventJson> list = state2.queue;
        state2.queue = new ArrayList();
        return list;
    }

    /* access modifiers changed from: package-private */
    public void forceUpload() {
        if (!this.state.queue.isEmpty()) {
            this.state.lastUploadTimestamp = Time.now();
            this.uploadRequester.requestUpload(flush());
        }
    }

    /* access modifiers changed from: package-private */
    public Config getConfig() {
        return this.config;
    }

    /* access modifiers changed from: package-private */
    public boolean isReadyForUpload(long j10) {
        if (this.state.queue.size() > this.config.uploadWhenMoreThan || (!this.state.queue.isEmpty() && j10 > this.state.lastUploadTimestamp + this.config.uploadWhenOlderThan)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public State unarchive(String str) {
        if (str == null) {
            return new State();
        }
        try {
            return (State) Sift.GSON.k(str, State.class);
        } catch (JsonSyntaxException unused) {
            return new State();
        }
    }
}

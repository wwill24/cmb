package com.facebook.messenger;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/facebook/messenger/ShareToMessengerParams;", "", "builder", "Lcom/facebook/messenger/ShareToMessengerParamsBuilder;", "(Lcom/facebook/messenger/ShareToMessengerParamsBuilder;)V", "externalUri", "Landroid/net/Uri;", "getExternalUri", "()Landroid/net/Uri;", "metaData", "", "getMetaData", "()Ljava/lang/String;", "mimeType", "getMimeType", "uri", "getUri", "Companion", "facebook-messenger_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ShareToMessengerParams {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Set<String> VALID_EXTERNAL_URI_SCHEMES;
    /* access modifiers changed from: private */
    public static final Set<String> VALID_MIME_TYPES;
    /* access modifiers changed from: private */
    public static final Set<String> VALID_URI_SCHEMES;
    private final Uri externalUri;
    private final String metaData;
    private final String mimeType;
    private final Uri uri;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0007R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/facebook/messenger/ShareToMessengerParams$Companion;", "", "()V", "VALID_EXTERNAL_URI_SCHEMES", "", "", "getVALID_EXTERNAL_URI_SCHEMES", "()Ljava/util/Set;", "VALID_MIME_TYPES", "getVALID_MIME_TYPES", "VALID_URI_SCHEMES", "getVALID_URI_SCHEMES", "newBuilder", "Lcom/facebook/messenger/ShareToMessengerParamsBuilder;", "uri", "Landroid/net/Uri;", "mimeType", "facebook-messenger_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<String> getVALID_EXTERNAL_URI_SCHEMES() {
            return ShareToMessengerParams.VALID_EXTERNAL_URI_SCHEMES;
        }

        public final Set<String> getVALID_MIME_TYPES() {
            return ShareToMessengerParams.VALID_MIME_TYPES;
        }

        public final Set<String> getVALID_URI_SCHEMES() {
            return ShareToMessengerParams.VALID_URI_SCHEMES;
        }

        public final ShareToMessengerParamsBuilder newBuilder(Uri uri, String str) {
            j.g(uri, "uri");
            j.g(str, "mimeType");
            return new ShareToMessengerParamsBuilder(uri, str);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("image/*");
        hashSet.add("image/jpeg");
        hashSet.add("image/png");
        hashSet.add("image/gif");
        hashSet.add("image/webp");
        hashSet.add("video/*");
        hashSet.add("video/mp4");
        hashSet.add("audio/*");
        hashSet.add("audio/mpeg");
        VALID_MIME_TYPES = CollectionsKt___CollectionsKt.B0(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add("content");
        hashSet2.add("android.resource");
        hashSet2.add("file");
        VALID_URI_SCHEMES = CollectionsKt___CollectionsKt.B0(hashSet2);
        HashSet hashSet3 = new HashSet();
        hashSet3.add("http");
        hashSet3.add("https");
        VALID_EXTERNAL_URI_SCHEMES = CollectionsKt___CollectionsKt.B0(hashSet3);
    }

    public ShareToMessengerParams(ShareToMessengerParamsBuilder shareToMessengerParamsBuilder) {
        j.g(shareToMessengerParamsBuilder, "builder");
        Uri uri2 = shareToMessengerParamsBuilder.getUri();
        if (uri2 != null) {
            this.uri = uri2;
            String mimeType2 = shareToMessengerParamsBuilder.getMimeType();
            if (mimeType2 != null) {
                this.mimeType = mimeType2;
                this.metaData = shareToMessengerParamsBuilder.getMetaData();
                Uri externalUri2 = shareToMessengerParamsBuilder.getExternalUri();
                this.externalUri = externalUri2;
                if (!CollectionsKt___CollectionsKt.E(VALID_URI_SCHEMES, uri2.getScheme())) {
                    throw new IllegalArgumentException(j.p("Unsupported URI scheme: ", getUri().getScheme()).toString());
                } else if (!VALID_MIME_TYPES.contains(mimeType2)) {
                    throw new IllegalArgumentException(j.p("Unsupported mime-type: ", getMimeType()).toString());
                } else if (externalUri2 != null && !CollectionsKt___CollectionsKt.E(VALID_EXTERNAL_URI_SCHEMES, externalUri2.getScheme())) {
                    throw new IllegalArgumentException(j.p("Unsupported external uri scheme: ", getExternalUri().getScheme()).toString());
                }
            } else {
                throw new IllegalStateException("Must provide mimeType".toString());
            }
        } else {
            throw new IllegalStateException("Must provide non-null uri".toString());
        }
    }

    public static final ShareToMessengerParamsBuilder newBuilder(Uri uri2, String str) {
        return Companion.newBuilder(uri2, str);
    }

    public final Uri getExternalUri() {
        return this.externalUri;
    }

    public final String getMetaData() {
        return this.metaData;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final Uri getUri() {
        return this.uri;
    }
}

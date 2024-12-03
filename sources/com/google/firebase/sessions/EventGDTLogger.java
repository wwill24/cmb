package com.google.firebase.sessions;

import cd.b;
import cd.c;
import cd.f;
import com.google.firebase.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.text.d;
import org.jivesoftware.smackx.json.packet.JsonPacketExtension;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/google/firebase/sessions/EventGDTLogger;", "Lcom/google/firebase/sessions/EventGDTLoggerInterface;", "Lcom/google/firebase/sessions/SessionEvent;", "value", "", "encode", "sessionEvent", "", "log", "Lcom/google/firebase/inject/Provider;", "Lcd/f;", "transportFactoryProvider", "Lcom/google/firebase/inject/Provider;", "<init>", "(Lcom/google/firebase/inject/Provider;)V", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
public final class EventGDTLogger implements EventGDTLoggerInterface {
    private static final String AQS_LOG_SOURCE = "FIREBASE_APPQUALITY_SESSION";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "EventGDTLogger";
    private final Provider<f> transportFactoryProvider;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/EventGDTLogger$Companion;", "", "()V", "AQS_LOG_SOURCE", "", "TAG", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public EventGDTLogger(Provider<f> provider) {
        j.g(provider, "transportFactoryProvider");
        this.transportFactoryProvider = provider;
    }

    /* access modifiers changed from: private */
    public final byte[] encode(SessionEvent sessionEvent) {
        String encode = SessionEvents.INSTANCE.getSESSION_EVENT_ENCODER$com_google_firebase_firebase_sessions().encode(sessionEvent);
        j.f(encode, "SessionEvents.SESSION_EVENT_ENCODER.encode(value)");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Session Event: ");
        sb2.append(encode);
        byte[] bytes = encode.getBytes(d.f32216b);
        j.f(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public void log(SessionEvent sessionEvent) {
        j.g(sessionEvent, "sessionEvent");
        this.transportFactoryProvider.get().a(AQS_LOG_SOURCE, SessionEvent.class, b.b(JsonPacketExtension.ELEMENT), new a(this)).b(c.d(sessionEvent));
    }
}

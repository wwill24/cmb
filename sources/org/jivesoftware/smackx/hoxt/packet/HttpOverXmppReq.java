package org.jivesoftware.smackx.hoxt.packet;

import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;
import org.jivesoftware.smackx.jingle.element.Jingle;

public final class HttpOverXmppReq extends AbstractHttpOverXmpp {
    public static final String ELEMENT = "req";
    private final boolean ibb;
    private final boolean jingle;
    private final int maxChunkSize;
    private final HttpMethod method;
    private final String resource;
    private final boolean sipub;

    public static final class Builder extends AbstractHttpOverXmpp.Builder<Builder, HttpOverXmppReq> {
        /* access modifiers changed from: private */
        public boolean ibb;
        /* access modifiers changed from: private */
        public boolean jingle;
        /* access modifiers changed from: private */
        public int maxChunkSize;
        /* access modifiers changed from: private */
        public HttpMethod method;
        /* access modifiers changed from: private */
        public String resource;
        /* access modifiers changed from: private */
        public boolean sipub;

        /* access modifiers changed from: protected */
        public Builder getThis() {
            return this;
        }

        public Builder setIbb(boolean z10) {
            this.ibb = z10;
            return this;
        }

        public Builder setJingle(boolean z10) {
            this.jingle = z10;
            return this;
        }

        public Builder setMaxChunkSize(int i10) {
            if (i10 < 256 || i10 > 65536) {
                throw new IllegalArgumentException("maxChunkSize must be within [256, 65536]");
            }
            this.maxChunkSize = i10;
            return this;
        }

        public Builder setMethod(HttpMethod httpMethod) {
            this.method = httpMethod;
            return this;
        }

        public Builder setResource(String str) {
            this.resource = str;
            return this;
        }

        public Builder setSipub(boolean z10) {
            this.sipub = z10;
            return this;
        }

        private Builder() {
            this.maxChunkSize = -1;
            this.sipub = true;
            this.ibb = true;
            this.jingle = true;
        }

        public HttpOverXmppReq build() {
            if (this.method == null) {
                throw new IllegalArgumentException("Method cannot be null");
            } else if (this.resource != null) {
                return new HttpOverXmppReq(this);
            } else {
                throw new IllegalArgumentException("Resource cannot be null");
            }
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQHoxtChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute(FirebaseAnalytics.Param.METHOD, (Enum<?>) this.method);
        iQChildElementXmlStringBuilder.attribute("resource", this.resource);
        iQChildElementXmlStringBuilder.attribute(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, getVersion());
        iQChildElementXmlStringBuilder.optIntAttribute("maxChunkSize", this.maxChunkSize);
        iQChildElementXmlStringBuilder.optBooleanAttributeDefaultTrue("sipub", this.sipub);
        iQChildElementXmlStringBuilder.optBooleanAttributeDefaultTrue(AbstractHttpOverXmpp.Ibb.ELEMENT, this.ibb);
        iQChildElementXmlStringBuilder.optBooleanAttributeDefaultTrue(Jingle.ELEMENT, this.jingle);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        return iQChildElementXmlStringBuilder;
    }

    public int getMaxChunkSize() {
        return this.maxChunkSize;
    }

    public HttpMethod getMethod() {
        return this.method;
    }

    public String getResource() {
        return this.resource;
    }

    public boolean isIbb() {
        return this.ibb;
    }

    public boolean isJingle() {
        return this.jingle;
    }

    public boolean isSipub() {
        return this.sipub;
    }

    private HttpOverXmppReq(Builder builder) {
        super("req", builder);
        this.method = builder.method;
        this.resource = builder.resource;
        this.maxChunkSize = builder.maxChunkSize;
        this.ibb = builder.ibb;
        this.jingle = builder.jingle;
        this.sipub = builder.sipub;
        setType(IQ.Type.set);
    }
}

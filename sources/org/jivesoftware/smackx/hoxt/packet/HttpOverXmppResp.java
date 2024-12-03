package org.jivesoftware.smackx.hoxt.packet;

import com.facebook.internal.ServerProtocol;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.hoxt.packet.AbstractHttpOverXmpp;

public final class HttpOverXmppResp extends AbstractHttpOverXmpp {
    public static final String ELEMENT = "resp";
    private final int statusCode;
    private final String statusMessage;

    public static final class Builder extends AbstractHttpOverXmpp.Builder<Builder, HttpOverXmppResp> {
        /* access modifiers changed from: private */
        public int statusCode;
        /* access modifiers changed from: private */
        public String statusMessage;

        /* access modifiers changed from: protected */
        public Builder getThis() {
            return this;
        }

        public Builder setStatusCode(int i10) {
            this.statusCode = i10;
            return this;
        }

        public Builder setStatusMessage(String str) {
            this.statusMessage = str;
            return this;
        }

        private Builder() {
            this.statusCode = 200;
            this.statusMessage = null;
        }

        public HttpOverXmppResp build() {
            return new HttpOverXmppResp(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    /* access modifiers changed from: protected */
    public IQ.IQChildElementXmlStringBuilder getIQHoxtChildElementBuilder(IQ.IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, getVersion());
        iQChildElementXmlStringBuilder.attribute("statusCode", this.statusCode);
        iQChildElementXmlStringBuilder.optAttribute("statusMessage", this.statusMessage);
        iQChildElementXmlStringBuilder.rightAngleBracket();
        return iQChildElementXmlStringBuilder;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    private HttpOverXmppResp(Builder builder) {
        super(ELEMENT, builder);
        this.statusCode = ((Integer) Objects.requireNonNull(Integer.valueOf(builder.statusCode), "statusCode must not be null")).intValue();
        this.statusMessage = builder.statusMessage;
    }
}

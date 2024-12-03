package org.jivesoftware.smack.tcp;

import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.initializer.UrlInitializer;
import org.jivesoftware.smack.sm.StreamManagementModuleDescriptor;

public class TCPInitializer extends UrlInitializer {
    static {
        SmackConfiguration.addModule(StreamManagementModuleDescriptor.class);
        SmackConfiguration.addModule(XmppTcpTransportModuleDescriptor.class);
    }

    /* access modifiers changed from: protected */
    public String getProvidersUri() {
        return "classpath:org.jivesoftware.smack.tcp/smacktcp.providers";
    }
}

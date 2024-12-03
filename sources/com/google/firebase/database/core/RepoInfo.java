package com.google.firebase.database.core;

import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.emulators.EmulatedServiceSettings;
import java.net.URI;

public final class RepoInfo {
    private static final String LAST_SESSION_ID_PARAM = "ls";
    private static final String VERSION_PARAM = "v";
    public String host;
    public String internalHost;
    public String namespace;
    public boolean secure;

    public void applyEmulatorSettings(@Nullable EmulatedServiceSettings emulatedServiceSettings) {
        if (emulatedServiceSettings != null) {
            String str = emulatedServiceSettings.getHost() + CertificateUtil.DELIMITER + emulatedServiceSettings.getPort();
            this.host = str;
            this.internalHost = str;
            this.secure = false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RepoInfo.class != obj.getClass()) {
            return false;
        }
        RepoInfo repoInfo = (RepoInfo) obj;
        if (this.secure == repoInfo.secure && this.host.equals(repoInfo.host)) {
            return this.namespace.equals(repoInfo.namespace);
        }
        return false;
    }

    public URI getConnectionURL(String str) {
        String str2;
        if (this.secure) {
            str2 = "wss";
        } else {
            str2 = "ws";
        }
        String str3 = str2 + "://" + this.internalHost + "/.ws?ns=" + this.namespace + "&" + "v" + "=" + "5";
        if (str != null) {
            str3 = str3 + "&ls=" + str;
        }
        return URI.create(str3);
    }

    public int hashCode() {
        return (((this.host.hashCode() * 31) + (this.secure ? 1 : 0)) * 31) + this.namespace.hashCode();
    }

    public boolean isCacheableHost() {
        return this.internalHost.startsWith("s-");
    }

    public boolean isCustomHost() {
        return !this.host.contains(".firebaseio.com") && !this.host.contains(".firebaseio-demo.com");
    }

    public boolean isDemoHost() {
        return this.host.contains(".firebaseio-demo.com");
    }

    public boolean isSecure() {
        return this.secure;
    }

    public String toDebugString() {
        return "(host=" + this.host + ", secure=" + this.secure + ", ns=" + this.namespace + " internal=" + this.internalHost + ")";
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("http");
        sb2.append(this.secure ? "s" : "");
        sb2.append("://");
        sb2.append(this.host);
        return sb2.toString();
    }
}

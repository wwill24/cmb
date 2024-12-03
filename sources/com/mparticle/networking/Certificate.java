package com.mparticle.networking;

import androidx.annotation.NonNull;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import org.json.JSONException;
import org.json.b;

public final class Certificate {
    private String alias;
    private String certificate;

    private Certificate(String str, String str2) {
        this.alias = str;
        this.certificate = str2;
    }

    public static Certificate with(@NonNull String str, @NonNull String str2) {
        if (!MPUtility.isEmpty((CharSequence) str) && !MPUtility.isEmpty((CharSequence) str2)) {
            return new Certificate(str, str2);
        }
        Logger.warning(String.format("Alias and Certificate values must both be non-empty strings. Unable to build certificate with Alias = %s and Certificate = %s.", new Object[]{str, str2}));
        return null;
    }

    static Certificate withCertificate(b bVar) {
        try {
            return new Certificate(bVar.getString("alias"), bVar.getString("certificate"));
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @NonNull
    public String getAlias() {
        return this.alias;
    }

    @NonNull
    public String getCertificate() {
        return this.certificate;
    }

    /* access modifiers changed from: package-private */
    public b toJson() {
        b bVar = new b();
        try {
            return new b().put("alias", (Object) getAlias()).put("certificate", (Object) getCertificate());
        } catch (JSONException e10) {
            Logger.error(e10, new String[0]);
            return bVar;
        }
    }

    @NonNull
    public String toString() {
        return toJson().toString();
    }
}

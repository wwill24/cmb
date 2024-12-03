package com.mparticle.identity;

import android.content.Context;
import androidx.annotation.NonNull;
import com.mparticle.MParticle;
import com.mparticle.UserAttributeListenerType;
import com.mparticle.consent.ConsentState;
import java.util.Map;

public class c implements MParticleUser {

    /* renamed from: a  reason: collision with root package name */
    private long f22360a;

    /* renamed from: b  reason: collision with root package name */
    b f22361b;

    private c(Context context, long j10, b bVar) {
        this.f22360a = j10;
        this.f22361b = bVar;
    }

    static MParticleUser a(Context context, long j10, b bVar) {
        return new c(context, j10, bVar);
    }

    public ConsentState getConsentState() {
        return this.f22361b.a(getId());
    }

    public long getFirstSeenTime() {
        return this.f22361b.a(Long.valueOf(getId()));
    }

    public long getId() {
        return this.f22360a;
    }

    public long getLastSeenTime() {
        return this.f22361b.b(Long.valueOf(getId()));
    }

    public Map<String, Object> getUserAttributes() {
        return this.f22361b.b(getId());
    }

    public Map<MParticle.IdentityType, String> getUserIdentities() {
        return this.f22361b.c(getId());
    }

    public boolean incrementUserAttribute(String str, Number number) {
        return this.f22361b.a(str, number, getId());
    }

    public boolean isLoggedIn() {
        return this.f22361b.c(Long.valueOf(getId()));
    }

    public boolean removeUserAttribute(String str) {
        return this.f22361b.a(str, getId());
    }

    public void setConsentState(ConsentState consentState) {
        this.f22361b.a(consentState, getId());
    }

    public boolean setUserAttribute(String str, Object obj) {
        return this.f22361b.a(str, obj, getId());
    }

    public boolean setUserAttributeList(String str, Object obj) {
        return this.f22361b.b(str, obj, getId());
    }

    public boolean setUserAttributes(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        boolean z10 = true;
        for (Map.Entry next : map.entrySet()) {
            if (!setUserAttribute((String) next.getKey(), next.getValue())) {
                z10 = false;
            }
        }
        return z10;
    }

    public boolean setUserTag(@NonNull String str) {
        return setUserAttribute(str, (Object) null);
    }

    public Map<String, Object> getUserAttributes(UserAttributeListenerType userAttributeListenerType) {
        return this.f22361b.a(userAttributeListenerType, getId());
    }
}

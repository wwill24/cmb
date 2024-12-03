package com.mparticle.identity;

import androidx.annotation.NonNull;
import com.mparticle.MParticle;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import java.util.HashMap;
import java.util.Map;

public final class IdentityApiRequest {
    Long mpid;
    private Map<String, String> otherNewIdentities;
    private Map<String, String> otherOldIdentities;
    private UserAliasHandler userAliasHandler;
    private Map<MParticle.IdentityType, String> userIdentities;

    @NonNull
    public static Builder withEmptyUser() {
        return new Builder();
    }

    @NonNull
    public static Builder withUser(MParticleUser mParticleUser) {
        return new Builder(mParticleUser);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Map<String, String> getOtherNewIdentities() {
        return this.otherNewIdentities;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Map<String, String> getOtherOldIdentities() {
        return this.otherOldIdentities;
    }

    public UserAliasHandler getUserAliasHandler() {
        return this.userAliasHandler;
    }

    @NonNull
    public Map<MParticle.IdentityType, String> getUserIdentities() {
        return this.userIdentities;
    }

    private IdentityApiRequest(Builder builder) {
        this.userAliasHandler = null;
        this.userIdentities = new HashMap();
        this.otherOldIdentities = new HashMap();
        this.otherNewIdentities = new HashMap();
        if (builder.userIdentities != null) {
            this.userIdentities = builder.userIdentities;
        }
        if (builder.userAliasHandler != null) {
            this.userAliasHandler = builder.userAliasHandler;
        }
        if (builder.otherOldIdentities.size() == builder.otherNewIdentities.size()) {
            this.otherNewIdentities = builder.otherNewIdentities;
            this.otherOldIdentities = builder.otherOldIdentities;
        }
        if (builder.mpid != null) {
            this.mpid = builder.mpid;
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public Long mpid;
        /* access modifiers changed from: private */
        public Map<String, String> otherNewIdentities = new HashMap();
        /* access modifiers changed from: private */
        public Map<String, String> otherOldIdentities = new HashMap();
        /* access modifiers changed from: private */
        public UserAliasHandler userAliasHandler;
        /* access modifiers changed from: private */
        public Map<MParticle.IdentityType, String> userIdentities = new HashMap();

        protected Builder(MParticleUser mParticleUser) {
            if (mParticleUser != null) {
                this.userIdentities = mParticleUser.getUserIdentities();
                this.mpid = Long.valueOf(mParticleUser.getId());
            }
        }

        @NonNull
        public IdentityApiRequest build() {
            return new IdentityApiRequest(this);
        }

        @NonNull
        public Builder customerId(String str) {
            return userIdentity(MParticle.IdentityType.CustomerId, str);
        }

        @NonNull
        public Builder email(String str) {
            return userIdentity(MParticle.IdentityType.Email, str);
        }

        /* access modifiers changed from: protected */
        @NonNull
        public Builder googleAdId(String str, String str2) {
            this.otherOldIdentities.put("android_aaid", str2);
            this.otherNewIdentities.put("android_aaid", str);
            return this;
        }

        /* access modifiers changed from: protected */
        @NonNull
        public Builder pushToken(String str, String str2) {
            if (MPUtility.isEmpty((CharSequence) str2)) {
                str2 = null;
            }
            if (MPUtility.isEmpty((CharSequence) str)) {
                str = null;
            }
            this.otherOldIdentities.put("push_token", str2);
            this.otherNewIdentities.put("push_token", str);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder userAliasHandler(UserAliasHandler userAliasHandler2) {
            this.userAliasHandler = userAliasHandler2;
            return this;
        }

        @NonNull
        public Builder userIdentities(@NonNull Map<MParticle.IdentityType, String> map) {
            for (Map.Entry next : map.entrySet()) {
                userIdentity((MParticle.IdentityType) next.getKey(), (String) next.getValue());
            }
            return this;
        }

        @NonNull
        public Builder userIdentity(@NonNull MParticle.IdentityType identityType, String str) {
            if (this.userIdentities.containsKey(identityType)) {
                Logger.warning("IdentityApiRequest already contains field with IdentityType of:" + identityType + ". It will be overwritten");
            }
            this.userIdentities.put(identityType, str);
            return this;
        }

        protected Builder() {
        }
    }
}

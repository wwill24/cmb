package com.mparticle.identity;

import androidx.annotation.NonNull;
import com.facebook.internal.security.CertificateUtil;
import com.mparticle.MParticle;
import com.mparticle.internal.Logger;
import java.util.concurrent.TimeUnit;

public class AliasRequest {
    private Long destinationMpid;
    private Long endTime;
    private Long sourceMpid;
    private Long startTime;

    public static class Builder {
        /* access modifiers changed from: private */
        public long destinationMpid;
        /* access modifiers changed from: private */
        public long endTime;
        private boolean implicitStartTime = false;
        /* access modifiers changed from: private */
        public long sourceMpid;
        /* access modifiers changed from: private */
        public long startTime;

        /* access modifiers changed from: private */
        public Builder implicitStartTime(boolean z10) {
            this.implicitStartTime = z10;
            return this;
        }

        public AliasRequest build() {
            if (this.implicitStartTime) {
                int i10 = 90;
                try {
                    MParticle instance = MParticle.getInstance();
                    if (instance != null) {
                        i10 = instance.Internal().b().i();
                    }
                } catch (Exception e10) {
                    Logger.error(e10.getMessage());
                }
                long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis((long) i10);
                if (this.startTime < currentTimeMillis) {
                    this.startTime = currentTimeMillis;
                    if (currentTimeMillis > this.endTime) {
                        Logger.warning("Source User has not been seen in the last %s days. Alias Request will likely fail");
                    }
                }
            }
            return new AliasRequest(this);
        }

        public Builder destinationMpid(long j10) {
            this.destinationMpid = j10;
            return this;
        }

        public Builder endTime(long j10) {
            this.endTime = j10;
            return this;
        }

        public Builder sourceMpid(long j10) {
            this.sourceMpid = j10;
            return this;
        }

        public Builder startTime(long j10) {
            this.startTime = j10;
            this.implicitStartTime = false;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AliasRequest)) {
            return false;
        }
        AliasRequest aliasRequest = (AliasRequest) obj;
        if (aliasRequest.getEndTime() == getEndTime() && aliasRequest.getStartTime() == getStartTime() && aliasRequest.getSourceMpid() == getSourceMpid() && aliasRequest.getDestinationMpid() == getDestinationMpid()) {
            return true;
        }
        return false;
    }

    public long getDestinationMpid() {
        return this.destinationMpid.longValue();
    }

    public long getEndTime() {
        return this.endTime.longValue();
    }

    public long getSourceMpid() {
        return this.sourceMpid.longValue();
    }

    public long getStartTime() {
        return this.startTime.longValue();
    }

    public int hashCode() {
        return (getEndTime() + CertificateUtil.DELIMITER + getStartTime() + CertificateUtil.DELIMITER + getSourceMpid() + CertificateUtil.DELIMITER + getDestinationMpid()).hashCode();
    }

    private AliasRequest(Builder builder) {
        this.sourceMpid = Long.valueOf(builder.sourceMpid);
        this.destinationMpid = Long.valueOf(builder.destinationMpid);
        this.startTime = Long.valueOf(builder.startTime);
        this.endTime = Long.valueOf(builder.endTime);
    }

    public static Builder builder(@NonNull MParticleUser mParticleUser, @NonNull MParticleUser mParticleUser2) {
        return new Builder().destinationMpid(mParticleUser2.getId()).sourceMpid(mParticleUser.getId()).startTime(mParticleUser.getFirstSeenTime()).endTime(mParticleUser.getLastSeenTime()).implicitStartTime(true);
    }
}

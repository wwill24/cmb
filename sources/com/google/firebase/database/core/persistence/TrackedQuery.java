package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.view.QuerySpec;

public final class TrackedQuery {
    public final boolean active;
    public final boolean complete;

    /* renamed from: id  reason: collision with root package name */
    public final long f21077id;
    public final long lastUse;
    public final QuerySpec querySpec;

    public TrackedQuery(long j10, QuerySpec querySpec2, long j11, boolean z10, boolean z11) {
        this.f21077id = j10;
        if (!querySpec2.loadsAllData() || querySpec2.isDefault()) {
            this.querySpec = querySpec2;
            this.lastUse = j11;
            this.complete = z10;
            this.active = z11;
            return;
        }
        throw new IllegalArgumentException("Can't create TrackedQuery for a non-default query that loads all data");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != TrackedQuery.class) {
            return false;
        }
        TrackedQuery trackedQuery = (TrackedQuery) obj;
        if (this.f21077id == trackedQuery.f21077id && this.querySpec.equals(trackedQuery.querySpec) && this.lastUse == trackedQuery.lastUse && this.complete == trackedQuery.complete && this.active == trackedQuery.active) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Long.valueOf(this.f21077id).hashCode() * 31) + this.querySpec.hashCode()) * 31) + Long.valueOf(this.lastUse).hashCode()) * 31) + Boolean.valueOf(this.complete).hashCode()) * 31) + Boolean.valueOf(this.active).hashCode();
    }

    public TrackedQuery setActiveState(boolean z10) {
        return new TrackedQuery(this.f21077id, this.querySpec, this.lastUse, this.complete, z10);
    }

    public TrackedQuery setComplete() {
        return new TrackedQuery(this.f21077id, this.querySpec, this.lastUse, true, this.active);
    }

    public String toString() {
        return "TrackedQuery{id=" + this.f21077id + ", querySpec=" + this.querySpec + ", lastUse=" + this.lastUse + ", complete=" + this.complete + ", active=" + this.active + "}";
    }

    public TrackedQuery updateLastUse(long j10) {
        return new TrackedQuery(this.f21077id, this.querySpec, j10, this.complete, this.active);
    }
}

package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/google/firebase/sessions/DataCollectionStatus;", "", "performance", "Lcom/google/firebase/sessions/DataCollectionState;", "crashlytics", "sessionSamplingRate", "", "(Lcom/google/firebase/sessions/DataCollectionState;Lcom/google/firebase/sessions/DataCollectionState;D)V", "getCrashlytics", "()Lcom/google/firebase/sessions/DataCollectionState;", "getPerformance", "getSessionSamplingRate", "()D", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DataCollectionStatus {
    private final DataCollectionState crashlytics;
    private final DataCollectionState performance;
    private final double sessionSamplingRate;

    public DataCollectionStatus() {
        this((DataCollectionState) null, (DataCollectionState) null, 0.0d, 7, (DefaultConstructorMarker) null);
    }

    public DataCollectionStatus(DataCollectionState dataCollectionState, DataCollectionState dataCollectionState2, double d10) {
        j.g(dataCollectionState, "performance");
        j.g(dataCollectionState2, "crashlytics");
        this.performance = dataCollectionState;
        this.crashlytics = dataCollectionState2;
        this.sessionSamplingRate = d10;
    }

    public static /* synthetic */ DataCollectionStatus copy$default(DataCollectionStatus dataCollectionStatus, DataCollectionState dataCollectionState, DataCollectionState dataCollectionState2, double d10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dataCollectionState = dataCollectionStatus.performance;
        }
        if ((i10 & 2) != 0) {
            dataCollectionState2 = dataCollectionStatus.crashlytics;
        }
        if ((i10 & 4) != 0) {
            d10 = dataCollectionStatus.sessionSamplingRate;
        }
        return dataCollectionStatus.copy(dataCollectionState, dataCollectionState2, d10);
    }

    public final DataCollectionState component1() {
        return this.performance;
    }

    public final DataCollectionState component2() {
        return this.crashlytics;
    }

    public final double component3() {
        return this.sessionSamplingRate;
    }

    public final DataCollectionStatus copy(DataCollectionState dataCollectionState, DataCollectionState dataCollectionState2, double d10) {
        j.g(dataCollectionState, "performance");
        j.g(dataCollectionState2, "crashlytics");
        return new DataCollectionStatus(dataCollectionState, dataCollectionState2, d10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataCollectionStatus)) {
            return false;
        }
        DataCollectionStatus dataCollectionStatus = (DataCollectionStatus) obj;
        return this.performance == dataCollectionStatus.performance && this.crashlytics == dataCollectionStatus.crashlytics && j.b(Double.valueOf(this.sessionSamplingRate), Double.valueOf(dataCollectionStatus.sessionSamplingRate));
    }

    public final DataCollectionState getCrashlytics() {
        return this.crashlytics;
    }

    public final DataCollectionState getPerformance() {
        return this.performance;
    }

    public final double getSessionSamplingRate() {
        return this.sessionSamplingRate;
    }

    public int hashCode() {
        return (((this.performance.hashCode() * 31) + this.crashlytics.hashCode()) * 31) + Double.hashCode(this.sessionSamplingRate);
    }

    public String toString() {
        return "DataCollectionStatus(performance=" + this.performance + ", crashlytics=" + this.crashlytics + ", sessionSamplingRate=" + this.sessionSamplingRate + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataCollectionStatus(DataCollectionState dataCollectionState, DataCollectionState dataCollectionState2, double d10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? DataCollectionState.COLLECTION_SDK_NOT_INSTALLED : dataCollectionState, (i10 & 2) != 0 ? DataCollectionState.COLLECTION_SDK_NOT_INSTALLED : dataCollectionState2, (i10 & 4) != 0 ? 1.0d : d10);
    }
}

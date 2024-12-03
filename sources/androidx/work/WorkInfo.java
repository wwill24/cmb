package androidx.work;

import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public final class WorkInfo {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private UUID f7336a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private State f7337b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private b f7338c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f7339d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private b f7340e;

    /* renamed from: f  reason: collision with root package name */
    private int f7341f;

    /* renamed from: g  reason: collision with root package name */
    private final int f7342g;

    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean b() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    public WorkInfo(@NonNull UUID uuid, @NonNull State state, @NonNull b bVar, @NonNull List<String> list, @NonNull b bVar2, int i10, int i11) {
        this.f7336a = uuid;
        this.f7337b = state;
        this.f7338c = bVar;
        this.f7339d = new HashSet(list);
        this.f7340e = bVar2;
        this.f7341f = i10;
        this.f7342g = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WorkInfo.class != obj.getClass()) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.f7341f == workInfo.f7341f && this.f7342g == workInfo.f7342g && this.f7336a.equals(workInfo.f7336a) && this.f7337b == workInfo.f7337b && this.f7338c.equals(workInfo.f7338c) && this.f7339d.equals(workInfo.f7339d)) {
            return this.f7340e.equals(workInfo.f7340e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f7336a.hashCode() * 31) + this.f7337b.hashCode()) * 31) + this.f7338c.hashCode()) * 31) + this.f7339d.hashCode()) * 31) + this.f7340e.hashCode()) * 31) + this.f7341f) * 31) + this.f7342g;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.f7336a + '\'' + ", mState=" + this.f7337b + ", mOutputData=" + this.f7338c + ", mTags=" + this.f7339d + ", mProgress=" + this.f7340e + '}';
    }
}

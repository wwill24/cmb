package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import qj.h;
import yj.a;

public final class FlowableRange extends h<Integer> {

    /* renamed from: b  reason: collision with root package name */
    final int f30194b;

    /* renamed from: c  reason: collision with root package name */
    final int f30195c;

    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final int end;
        int index;

        BaseRangeSubscription(int i10, int i11) {
            this.index = i10;
            this.end = i11;
        }

        /* access modifiers changed from: package-private */
        public abstract void a();

        public final int b(int i10) {
            return i10 & 1;
        }

        /* renamed from: c */
        public final Integer poll() {
            int i10 = this.index;
            if (i10 == this.end) {
                return null;
            }
            this.index = i10 + 1;
            return Integer.valueOf(i10);
        }

        public final void cancel() {
            this.cancelled = true;
        }

        public final void clear() {
            this.index = this.end;
        }

        /* access modifiers changed from: package-private */
        public abstract void d(long j10);

        public final boolean isEmpty() {
            return this.index == this.end;
        }

        public final void r(long j10) {
            if (SubscriptionHelper.j(j10) && b.a(this, j10) == 0) {
                if (j10 == Long.MAX_VALUE) {
                    a();
                } else {
                    d(j10);
                }
            }
        }
    }

    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final a<? super Integer> downstream;

        RangeConditionalSubscription(a<? super Integer> aVar, int i10, int i11) {
            super(i10, i11);
            this.downstream = aVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i10 = this.end;
            a<? super Integer> aVar = this.downstream;
            int i11 = this.index;
            while (i11 != i10) {
                if (!this.cancelled) {
                    aVar.f(Integer.valueOf(i11));
                    i11++;
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                aVar.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(long j10) {
            int i10 = this.end;
            int i11 = this.index;
            a<? super Integer> aVar = this.downstream;
            do {
                long j11 = 0;
                while (true) {
                    if (j11 == j10 || i11 == i10) {
                        if (i11 != i10) {
                            j10 = get();
                            if (j11 == j10) {
                                this.index = i11;
                                j10 = addAndGet(-j11);
                            }
                        } else if (!this.cancelled) {
                            aVar.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.cancelled) {
                        if (aVar.f(Integer.valueOf(i11))) {
                            j11++;
                        }
                        i11++;
                    } else {
                        return;
                    }
                }
            } while (j10 != 0);
        }
    }

    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final rn.b<? super Integer> downstream;

        RangeSubscription(rn.b<? super Integer> bVar, int i10, int i11) {
            super(i10, i11);
            this.downstream = bVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i10 = this.end;
            rn.b<? super Integer> bVar = this.downstream;
            int i11 = this.index;
            while (i11 != i10) {
                if (!this.cancelled) {
                    bVar.d(Integer.valueOf(i11));
                    i11++;
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                bVar.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(long j10) {
            int i10 = this.end;
            int i11 = this.index;
            rn.b<? super Integer> bVar = this.downstream;
            do {
                long j11 = 0;
                while (true) {
                    if (j11 == j10 || i11 == i10) {
                        if (i11 != i10) {
                            j10 = get();
                            if (j11 == j10) {
                                this.index = i11;
                                j10 = addAndGet(-j11);
                            }
                        } else if (!this.cancelled) {
                            bVar.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.cancelled) {
                        bVar.d(Integer.valueOf(i11));
                        j11++;
                        i11++;
                    } else {
                        return;
                    }
                }
            } while (j10 != 0);
        }
    }

    public FlowableRange(int i10, int i11) {
        this.f30194b = i10;
        this.f30195c = i10 + i11;
    }

    public void n0(rn.b<? super Integer> bVar) {
        if (bVar instanceof a) {
            bVar.e(new RangeConditionalSubscription((a) bVar, this.f30194b, this.f30195c));
        } else {
            bVar.e(new RangeSubscription(bVar, this.f30194b, this.f30195c));
        }
    }
}

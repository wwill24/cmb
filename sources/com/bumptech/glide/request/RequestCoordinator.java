package com.bumptech.glide.request;

import b4.a;

public interface RequestCoordinator {

    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);
        
        private final boolean isComplete;

        private RequestState(boolean z10) {
            this.isComplete = z10;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.isComplete;
        }
    }

    boolean a();

    boolean b(a aVar);

    boolean c(a aVar);

    void d(a aVar);

    void g(a aVar);

    RequestCoordinator getRoot();

    boolean i(a aVar);
}

package ed;

import java.util.concurrent.Executor;

class n implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f40749a;

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f40750a;

        a(Runnable runnable) {
            this.f40750a = runnable;
        }

        public void run() {
            try {
                this.f40750a.run();
            } catch (Exception e10) {
                id.a.d("Executor", "Background execution failure.", e10);
            }
        }
    }

    n(Executor executor) {
        this.f40749a = executor;
    }

    public void execute(Runnable runnable) {
        this.f40749a.execute(new a(runnable));
    }
}

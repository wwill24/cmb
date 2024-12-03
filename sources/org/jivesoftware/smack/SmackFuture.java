package org.jivesoftware.smack;

import java.io.IOException;
import java.lang.Exception;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.CallbackRecipient;
import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smack.util.ExceptionCallback;
import org.jivesoftware.smack.util.SuccessCallback;

public abstract class SmackFuture<V, E extends Exception> implements Future<V>, CallbackRecipient<V, E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    /* access modifiers changed from: private */
    public static final Logger LOGGER = Logger.getLogger(SmackFuture.class.getName());
    private boolean callbacksInvoked;
    private boolean cancelled;
    private Consumer<SmackFuture<V, E>> completionCallback;
    protected E exception;
    /* access modifiers changed from: private */
    public ExceptionCallback<E> exceptionCallback;
    protected V result;
    /* access modifiers changed from: private */
    public SuccessCallback<V> successCallback;

    public static abstract class InternalProcessStanzaSmackFuture<V, E extends Exception> extends InternalSmackFuture<V, E> implements StanzaListener, ExceptionCallback<E> {
        /* access modifiers changed from: protected */
        public abstract void handleStanza(Stanza stanza);

        /* access modifiers changed from: protected */
        public abstract boolean isNonFatalException(E e10);

        public final synchronized void processStanza(Stanza stanza) {
            handleStanza(stanza);
        }

        public final synchronized void processException(E e10) {
            if (!isNonFatalException(e10)) {
                this.exception = e10;
                notifyAll();
                maybeInvokeCallbacks();
            }
        }
    }

    public static class InternalSmackFuture<V, E extends Exception> extends SmackFuture<V, E> {
        public final synchronized void setException(E e10) {
            this.exception = e10;
            notifyAll();
            maybeInvokeCallbacks();
        }

        public final synchronized void setResult(V v10) {
            this.result = v10;
            notifyAll();
            maybeInvokeCallbacks();
        }
    }

    public static abstract class SimpleInternalProcessStanzaSmackFuture<V, E extends Exception> extends InternalProcessStanzaSmackFuture<V, E> {
        /* access modifiers changed from: protected */
        public boolean isNonFatalException(E e10) {
            return false;
        }
    }

    public static class SocketFuture extends InternalSmackFuture<Socket, IOException> {
        /* access modifiers changed from: private */
        public final Socket socket;
        /* access modifiers changed from: private */
        public boolean wasInterrupted;
        /* access modifiers changed from: private */
        public final Object wasInterruptedLock = new Object();

        public SocketFuture(SocketFactory socketFactory) throws IOException {
            this.socket = socketFactory.createSocket();
        }

        /* access modifiers changed from: private */
        public void closeSocket() {
            try {
                this.socket.close();
            } catch (IOException e10) {
                SmackFuture.LOGGER.log(Level.WARNING, "Could not close socket", e10);
            }
        }

        public void connectAsync(final SocketAddress socketAddress, final int i10) {
            AbstractXMPPConnection.asyncGo(new Runnable() {
                public void run() {
                    try {
                        SocketFuture.this.socket.connect(socketAddress, i10);
                        synchronized (SocketFuture.this.wasInterruptedLock) {
                            if (SocketFuture.this.wasInterrupted) {
                                SocketFuture.this.closeSocket();
                                return;
                            }
                            SocketFuture socketFuture = SocketFuture.this;
                            socketFuture.setResult(socketFuture.socket);
                        }
                    } catch (IOException e10) {
                        SocketFuture.this.setException(e10);
                    }
                }
            });
        }

        /* access modifiers changed from: protected */
        public void futureWait(long j10) throws InterruptedException {
            try {
                SmackFuture.super.futureWait(j10);
            } catch (InterruptedException e10) {
                synchronized (this.wasInterruptedLock) {
                    this.wasInterrupted = true;
                    if (!this.socket.isClosed()) {
                        closeSocket();
                    }
                    throw e10;
                }
            }
        }
    }

    static {
        Class<SmackFuture> cls = SmackFuture.class;
    }

    public static boolean await(Collection<? extends SmackFuture<?, ?>> collection, long j10, TimeUnit timeUnit) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(collection.size());
        for (SmackFuture onCompletion : collection) {
            onCompletion.onCompletion(new n(countDownLatch));
        }
        return countDownLatch.await(j10, timeUnit);
    }

    public static <V, E extends Exception> SmackFuture<V, E> from(V v10) {
        InternalSmackFuture internalSmackFuture = new InternalSmackFuture();
        internalSmackFuture.setResult(v10);
        return internalSmackFuture;
    }

    private V getOrThrowExecutionException() throws ExecutionException {
        V v10 = this.result;
        if (v10 != null) {
            return v10;
        }
        if (this.exception == null) {
            throw new CancellationException();
        }
        throw new ExecutionException(this.exception);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0013, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean cancel(boolean r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isDone()     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x000a
            r2 = 0
            monitor-exit(r1)
            return r2
        L_0x000a:
            r0 = 1
            r1.cancelled = r0     // Catch:{ all -> 0x0014 }
            if (r2 == 0) goto L_0x0012
            r1.notifyAll()     // Catch:{ all -> 0x0014 }
        L_0x0012:
            monitor-exit(r1)
            return r0
        L_0x0014:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.SmackFuture.cancel(boolean):boolean");
    }

    /* access modifiers changed from: protected */
    public final void futureWait() throws InterruptedException {
        futureWait(0);
    }

    public final synchronized V get() throws InterruptedException, ExecutionException {
        while (this.result == null && this.exception == null && !this.cancelled) {
            futureWait();
        }
        return getOrThrowExecutionException();
    }

    public V getIfAvailable() {
        return this.result;
    }

    public final synchronized V getOrThrow() throws Exception, InterruptedException {
        V v10;
        while (true) {
            v10 = this.result;
            if (v10 == null && this.exception == null && !this.cancelled) {
                futureWait();
            } else {
                E e10 = this.exception;
            }
        }
        E e102 = this.exception;
        if (e102 != null) {
            throw e102;
        } else if (this.cancelled) {
            throw new CancellationException();
        }
        return v10;
    }

    public final synchronized boolean isCancelled() {
        return this.cancelled;
    }

    public final synchronized boolean isDone() {
        return this.result != null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0042, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0044, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void maybeInvokeCallbacks() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.cancelled     // Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0043
            boolean r0 = r2.callbacksInvoked     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x000a
            goto L_0x0043
        L_0x000a:
            V r0 = r2.result     // Catch:{ all -> 0x0045 }
            r1 = 1
            if (r0 != 0) goto L_0x0013
            E r0 = r2.exception     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x001c
        L_0x0013:
            org.jivesoftware.smack.util.Consumer<org.jivesoftware.smack.SmackFuture<V, E>> r0 = r2.completionCallback     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x001c
            r2.callbacksInvoked = r1     // Catch:{ all -> 0x0045 }
            r0.accept(r2)     // Catch:{ all -> 0x0045 }
        L_0x001c:
            V r0 = r2.result     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x002f
            org.jivesoftware.smack.util.SuccessCallback<V> r0 = r2.successCallback     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x002f
            r2.callbacksInvoked = r1     // Catch:{ all -> 0x0045 }
            org.jivesoftware.smack.SmackFuture$1 r0 = new org.jivesoftware.smack.SmackFuture$1     // Catch:{ all -> 0x0045 }
            r0.<init>()     // Catch:{ all -> 0x0045 }
            org.jivesoftware.smack.AbstractXMPPConnection.asyncGo(r0)     // Catch:{ all -> 0x0045 }
            goto L_0x0041
        L_0x002f:
            E r0 = r2.exception     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x0041
            org.jivesoftware.smack.util.ExceptionCallback<E> r0 = r2.exceptionCallback     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x0041
            r2.callbacksInvoked = r1     // Catch:{ all -> 0x0045 }
            org.jivesoftware.smack.SmackFuture$2 r0 = new org.jivesoftware.smack.SmackFuture$2     // Catch:{ all -> 0x0045 }
            r0.<init>()     // Catch:{ all -> 0x0045 }
            org.jivesoftware.smack.AbstractXMPPConnection.asyncGo(r0)     // Catch:{ all -> 0x0045 }
        L_0x0041:
            monitor-exit(r2)
            return
        L_0x0043:
            monitor-exit(r2)
            return
        L_0x0045:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.SmackFuture.maybeInvokeCallbacks():void");
    }

    public void onCompletion(Consumer<SmackFuture<V, E>> consumer) {
        this.completionCallback = consumer;
        maybeInvokeCallbacks();
    }

    public CallbackRecipient<V, E> onError(ExceptionCallback<E> exceptionCallback2) {
        this.exceptionCallback = exceptionCallback2;
        maybeInvokeCallbacks();
        return this;
    }

    public CallbackRecipient<V, E> onSuccess(SuccessCallback<V> successCallback2) {
        this.successCallback = successCallback2;
        maybeInvokeCallbacks();
        return this;
    }

    /* access modifiers changed from: protected */
    public void futureWait(long j10) throws InterruptedException {
        wait(j10);
    }

    public final synchronized V get(long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        V v10;
        long currentTimeMillis = System.currentTimeMillis() + timeUnit.toMillis(j10);
        while (true) {
            v10 = this.result;
            if (v10 != null && this.exception != null) {
                long currentTimeMillis2 = currentTimeMillis - System.currentTimeMillis();
                if (currentTimeMillis2 > 0) {
                    futureWait(currentTimeMillis2);
                }
            }
        }
        if (this.cancelled) {
            throw new CancellationException();
        } else if (v10 == null || this.exception == null) {
            throw new TimeoutException();
        }
        return getOrThrowExecutionException();
    }
}

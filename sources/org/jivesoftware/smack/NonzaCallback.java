package org.jivesoftware.smack;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.util.XmppElementUtil;

public class NonzaCallback {
    protected final AbstractXMPPConnection connection;
    protected final Map<QName, ClassAndConsumer<? extends Nonza>> filterAndListeners;

    public static final class Builder {
        /* access modifiers changed from: private */
        public final AbstractXMPPConnection connection;
        /* access modifiers changed from: private */
        public Map<QName, ClassAndConsumer<? extends Nonza>> filterAndListeners = new HashMap();

        Builder(AbstractXMPPConnection abstractXMPPConnection) {
            this.connection = abstractXMPPConnection;
        }

        public NonzaCallback install() {
            return new NonzaCallback(this);
        }

        public <N extends Nonza> Builder listenFor(Class<N> cls, NonzaListener<N> nonzaListener) {
            this.filterAndListeners.put(XmppElementUtil.getQNameFor(cls), new ClassAndConsumer(cls, nonzaListener));
            return this;
        }
    }

    private static final class ClassAndConsumer<N extends Nonza> {
        private final Class<N> clazz;
        private final NonzaListener<N> consumer;

        /* access modifiers changed from: private */
        public void accept(Object obj) throws IOException {
            this.consumer.accept((Nonza) this.clazz.cast(obj));
        }

        private ClassAndConsumer(Class<N> cls, NonzaListener<N> nonzaListener) {
            this.clazz = cls;
            this.consumer = nonzaListener;
        }
    }

    public interface NonzaListener<N extends Nonza> {
        void accept(N n10) throws IOException;
    }

    private static final class NonzaResponseCallback<SN extends Nonza, FN extends Nonza> extends NonzaCallback {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        /* access modifiers changed from: private */
        public FN failedNonza;
        /* access modifiers changed from: private */
        public SN successNonza;

        private boolean hasReceivedSuccessOrFailedNonza() {
            return (this.successNonza == null && this.failedNonza == null) ? false : true;
        }

        /* access modifiers changed from: private */
        public void notifyResponse() {
            synchronized (this) {
                notifyAll();
            }
        }

        /* access modifiers changed from: private */
        public SN waitForResponse() throws SmackException.NoResponseException, InterruptedException, XMPPException.FailedNonzaException {
            long currentTimeMillis = System.currentTimeMillis() + this.connection.getReplyTimeout();
            synchronized (this) {
                while (true) {
                    if (hasReceivedSuccessOrFailedNonza()) {
                        break;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 >= currentTimeMillis) {
                        break;
                    }
                    wait(currentTimeMillis - currentTimeMillis2);
                }
                while (true) {
                }
            }
            if (!hasReceivedSuccessOrFailedNonza()) {
                throw SmackException.NoResponseException.newWith((XMPPConnection) this.connection, "Nonza Listener");
            } else if (this.failedNonza == null) {
                return this.successNonza;
            } else {
                throw new XMPPException.FailedNonzaException(this.failedNonza);
            }
        }

        private NonzaResponseCallback(Class<SN> cls, Class<FN> cls2, Builder builder) {
            super(builder);
            QName qNameFor = XmppElementUtil.getQNameFor(cls);
            QName qNameFor2 = XmppElementUtil.getQNameFor(cls2);
            ClassAndConsumer classAndConsumer = new ClassAndConsumer(cls, new NonzaListener<SN>() {
                public void accept(SN sn2) {
                    Nonza unused = NonzaResponseCallback.this.successNonza = sn2;
                    NonzaResponseCallback.this.notifyResponse();
                }
            });
            ClassAndConsumer classAndConsumer2 = new ClassAndConsumer(cls2, new NonzaListener<FN>() {
                public void accept(FN fn2) {
                    Nonza unused = NonzaResponseCallback.this.failedNonza = fn2;
                    NonzaResponseCallback.this.notifyResponse();
                }
            });
            this.filterAndListeners.put(qNameFor, classAndConsumer);
            this.filterAndListeners.put(qNameFor2, classAndConsumer2);
            install();
        }
    }

    static <SN extends Nonza, FN extends Nonza> SN sendAndWaitForResponse(Builder builder, Nonza nonza, Class<SN> cls, Class<FN> cls2) throws SmackException.NoResponseException, SmackException.NotConnectedException, InterruptedException, XMPPException.FailedNonzaException {
        NonzaResponseCallback nonzaResponseCallback = new NonzaResponseCallback(cls, cls2, builder);
        try {
            nonzaResponseCallback.connection.sendNonza(nonza);
            return nonzaResponseCallback.waitForResponse();
        } finally {
            nonzaResponseCallback.cancel();
        }
    }

    public void cancel() {
        for (Map.Entry<QName, ClassAndConsumer<? extends Nonza>> key : this.filterAndListeners.entrySet()) {
            QName qName = (QName) key.getKey();
            synchronized (this.connection.nonzaCallbacksMap) {
                this.connection.nonzaCallbacksMap.removeOne(qName, this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void install() {
        if (!this.filterAndListeners.isEmpty()) {
            for (QName next : this.filterAndListeners.keySet()) {
                synchronized (this.connection.nonzaCallbacksMap) {
                    this.connection.nonzaCallbacksMap.put(next, this);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onNonzaReceived(Nonza nonza) throws IOException {
        this.filterAndListeners.get(nonza.getQName()).accept(nonza);
    }

    private NonzaCallback(Builder builder) {
        this.connection = builder.connection;
        this.filterAndListeners = builder.filterAndListeners;
        install();
    }
}

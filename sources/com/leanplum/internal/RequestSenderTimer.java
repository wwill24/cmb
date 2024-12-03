package com.leanplum.internal;

import androidx.annotation.NonNull;
import com.leanplum.EventsUploadInterval;
import com.leanplum.internal.Request;

public class RequestSenderTimer {
    private static final RequestSenderTimer INSTANCE = new RequestSenderTimer();
    private EventsUploadInterval timerInterval = EventsUploadInterval.AT_MOST_15_MINUTES;
    /* access modifiers changed from: private */
    public Runnable timerOperation;

    public static RequestSenderTimer get() {
        return INSTANCE;
    }

    /* access modifiers changed from: private */
    public void sendAllRequestsWithHeartbeat() {
        RequestSender.getInstance().send(RequestBuilder.withHeartbeatAction().andType(Request.RequestType.IMMEDIATE).create());
    }

    /* access modifiers changed from: protected */
    public Runnable createTimerOperation() {
        return new Runnable() {
            public void run() {
                RequestSenderTimer.this.sendAllRequestsWithHeartbeat();
                OperationQueue.sharedInstance().addOperationAfterDelay(RequestSenderTimer.this.timerOperation, RequestSenderTimer.this.getIntervalMillis());
            }
        };
    }

    /* access modifiers changed from: protected */
    public long getIntervalMillis() {
        return (long) (this.timerInterval.getMinutes() * 60 * 1000);
    }

    public void setTimerInterval(@NonNull EventsUploadInterval eventsUploadInterval) {
        this.timerInterval = eventsUploadInterval;
    }

    public synchronized void start() {
        if (this.timerOperation == null) {
            this.timerOperation = createTimerOperation();
            OperationQueue.sharedInstance().addOperationAfterDelay(this.timerOperation, getIntervalMillis());
        }
    }

    public synchronized void stop() {
        if (this.timerOperation != null) {
            OperationQueue.sharedInstance().removeOperation(this.timerOperation);
            this.timerOperation = null;
        }
    }
}

package com.leanplum.callbacks;

public abstract class RegisterDeviceCallback implements Runnable {
    private EmailCallback callback;

    public static abstract class EmailCallback implements Runnable {
        private String email;

        public abstract void onResponse(String str);

        public void run() {
            onResponse(this.email);
        }

        public void setResponseHandler(String str) {
            this.email = str;
        }
    }

    public abstract void onResponse(EmailCallback emailCallback);

    public void run() {
        onResponse(this.callback);
    }

    public void setResponseHandler(EmailCallback emailCallback) {
        this.callback = emailCallback;
    }
}

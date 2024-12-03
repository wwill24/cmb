package com.google.firebase.crashlytics.internal.common;

public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    

    /* renamed from: id  reason: collision with root package name */
    private final int f21012id;

    private DeliveryMechanism(int i10) {
        this.f21012id = i10;
    }

    public static DeliveryMechanism determineFrom(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }

    public int getId() {
        return this.f21012id;
    }

    public String toString() {
        return Integer.toString(this.f21012id);
    }
}

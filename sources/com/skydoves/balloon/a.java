package com.skydoves.balloon;

import kotlin.jvm.internal.j;

public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Balloon f22789a;

    public a(Balloon balloon) {
        j.g(balloon, "balloon");
        this.f22789a = balloon;
    }

    public void run() {
        this.f22789a.I();
    }
}

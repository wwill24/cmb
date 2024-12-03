package com.mparticle;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;

public class n extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    a f22607a;

    public n(Context context) {
        super(context);
        this.f22607a = new a((Application) context.getApplicationContext());
    }

    public Context getApplicationContext() {
        return this.f22607a;
    }
}

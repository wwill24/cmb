package com.android.billingclient.api;

import com.android.billingclient.api.i;

final class u0 {
    static final i A;

    /* renamed from: a  reason: collision with root package name */
    static final i f9011a;

    /* renamed from: b  reason: collision with root package name */
    static final i f9012b;

    /* renamed from: c  reason: collision with root package name */
    static final i f9013c;

    /* renamed from: d  reason: collision with root package name */
    static final i f9014d;

    /* renamed from: e  reason: collision with root package name */
    static final i f9015e;

    /* renamed from: f  reason: collision with root package name */
    static final i f9016f;

    /* renamed from: g  reason: collision with root package name */
    static final i f9017g;

    /* renamed from: h  reason: collision with root package name */
    static final i f9018h;

    /* renamed from: i  reason: collision with root package name */
    static final i f9019i;

    /* renamed from: j  reason: collision with root package name */
    static final i f9020j;

    /* renamed from: k  reason: collision with root package name */
    static final i f9021k;

    /* renamed from: l  reason: collision with root package name */
    static final i f9022l;

    /* renamed from: m  reason: collision with root package name */
    static final i f9023m;

    /* renamed from: n  reason: collision with root package name */
    static final i f9024n;

    /* renamed from: o  reason: collision with root package name */
    static final i f9025o;

    /* renamed from: p  reason: collision with root package name */
    static final i f9026p;

    /* renamed from: q  reason: collision with root package name */
    static final i f9027q;

    /* renamed from: r  reason: collision with root package name */
    static final i f9028r;

    /* renamed from: s  reason: collision with root package name */
    static final i f9029s;

    /* renamed from: t  reason: collision with root package name */
    static final i f9030t;

    /* renamed from: u  reason: collision with root package name */
    static final i f9031u;

    /* renamed from: v  reason: collision with root package name */
    static final i f9032v;

    /* renamed from: w  reason: collision with root package name */
    static final i f9033w;

    /* renamed from: x  reason: collision with root package name */
    static final i f9034x;

    /* renamed from: y  reason: collision with root package name */
    static final i f9035y;

    /* renamed from: z  reason: collision with root package name */
    static final i f9036z;

    static {
        i.a c10 = i.c();
        c10.c(3);
        c10.b("Google Play In-app Billing API version is less than 3");
        f9011a = c10.a();
        i.a c11 = i.c();
        c11.c(3);
        c11.b("Google Play In-app Billing API version is less than 9");
        f9012b = c11.a();
        i.a c12 = i.c();
        c12.c(3);
        c12.b("Billing service unavailable on device.");
        f9013c = c12.a();
        i.a c13 = i.c();
        c13.c(5);
        c13.b("Client is already in the process of connecting to billing service.");
        f9014d = c13.a();
        i.a c14 = i.c();
        c14.c(5);
        c14.b("The list of SKUs can't be empty.");
        f9015e = c14.a();
        i.a c15 = i.c();
        c15.c(5);
        c15.b("SKU type can't be empty.");
        f9016f = c15.a();
        i.a c16 = i.c();
        c16.c(5);
        c16.b("Product type can't be empty.");
        f9017g = c16.a();
        i.a c17 = i.c();
        c17.c(-2);
        c17.b("Client does not support extra params.");
        f9018h = c17.a();
        i.a c18 = i.c();
        c18.c(5);
        c18.b("Invalid purchase token.");
        f9019i = c18.a();
        i.a c19 = i.c();
        c19.c(6);
        c19.b("An internal error occurred.");
        f9020j = c19.a();
        i.a c20 = i.c();
        c20.c(5);
        c20.b("SKU can't be null.");
        f9021k = c20.a();
        i.a c21 = i.c();
        c21.c(0);
        f9022l = c21.a();
        i.a c22 = i.c();
        c22.c(-1);
        c22.b("Service connection is disconnected.");
        f9023m = c22.a();
        i.a c23 = i.c();
        c23.c(-3);
        c23.b("Timeout communicating with service.");
        f9024n = c23.a();
        i.a c24 = i.c();
        c24.c(-2);
        c24.b("Client does not support subscriptions.");
        f9025o = c24.a();
        i.a c25 = i.c();
        c25.c(-2);
        c25.b("Client does not support subscriptions update.");
        f9026p = c25.a();
        i.a c26 = i.c();
        c26.c(-2);
        c26.b("Client does not support get purchase history.");
        f9027q = c26.a();
        i.a c27 = i.c();
        c27.c(-2);
        c27.b("Client does not support price change confirmation.");
        f9028r = c27.a();
        i.a c28 = i.c();
        c28.c(-2);
        c28.b("Play Store version installed does not support cross selling products.");
        f9029s = c28.a();
        i.a c29 = i.c();
        c29.c(-2);
        c29.b("Client does not support multi-item purchases.");
        f9030t = c29.a();
        i.a c30 = i.c();
        c30.c(-2);
        c30.b("Client does not support offer_id_token.");
        f9031u = c30.a();
        i.a c31 = i.c();
        c31.c(-2);
        c31.b("Client does not support ProductDetails.");
        f9032v = c31.a();
        i.a c32 = i.c();
        c32.c(-2);
        c32.b("Client does not support in-app messages.");
        f9033w = c32.a();
        i.a c33 = i.c();
        c33.c(-2);
        c33.b("Client does not support alternative billing.");
        f9034x = c33.a();
        i.a c34 = i.c();
        c34.c(5);
        c34.b("Unknown feature");
        f9035y = c34.a();
        i.a c35 = i.c();
        c35.c(-2);
        c35.b("Play Store version installed does not support get billing config.");
        f9036z = c35.a();
        i.a c36 = i.c();
        c36.c(-2);
        c36.b("Query product details with serialized docid is not supported.");
        A = c36.a();
    }
}

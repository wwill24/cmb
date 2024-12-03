package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.NetworkPhoto;
import vj.a;

public final /* synthetic */ class d0 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PhotoRepository f12484a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NetworkPhoto f12485b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NetworkPhoto f12486c;

    public /* synthetic */ d0(PhotoRepository photoRepository, NetworkPhoto networkPhoto, NetworkPhoto networkPhoto2) {
        this.f12484a = photoRepository;
        this.f12485b = networkPhoto;
        this.f12486c = networkPhoto2;
    }

    public final void run() {
        PhotoRepository.k(this.f12484a, this.f12485b, this.f12486c);
    }
}

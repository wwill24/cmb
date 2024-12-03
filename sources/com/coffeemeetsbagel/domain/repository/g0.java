package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.entities.PhotoEntity;
import vj.a;

public final /* synthetic */ class g0 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PhotoRepository f12505a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PhotoEntity f12506b;

    public /* synthetic */ g0(PhotoRepository photoRepository, PhotoEntity photoEntity) {
        this.f12505a = photoRepository;
        this.f12506b = photoEntity;
    }

    public final void run() {
        PhotoRepository.i(this.f12505a, this.f12506b);
    }
}

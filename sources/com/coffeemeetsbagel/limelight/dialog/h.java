package com.coffeemeetsbagel.limelight.dialog;

import com.coffeemeetsbagel.cmbbottomnav.state.NavStateManager;
import com.coffeemeetsbagel.domain.repository.LikesYouMatchRepository;
import hb.c;
import s9.a;

public final class h {
    public static void a(LimelightDialogInteractor limelightDialogInteractor, a aVar) {
        limelightDialogInteractor.f34372p = aVar;
    }

    public static void b(LimelightDialogInteractor limelightDialogInteractor, LikesYouMatchRepository likesYouMatchRepository) {
        limelightDialogInteractor.f34369l = likesYouMatchRepository;
    }

    public static void c(LimelightDialogInteractor limelightDialogInteractor, NavStateManager navStateManager) {
        limelightDialogInteractor.f34371n = navStateManager;
    }

    public static void d(LimelightDialogInteractor limelightDialogInteractor, c cVar) {
        limelightDialogInteractor.f34370m = cVar;
    }
}

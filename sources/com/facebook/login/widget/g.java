package com.facebook.login.widget;

import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;

public final /* synthetic */ class g implements ImageRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfilePictureView f37919a;

    public /* synthetic */ g(ProfilePictureView profilePictureView) {
        this.f37919a = profilePictureView;
    }

    public final void onCompleted(ImageResponse imageResponse) {
        ProfilePictureView.m173sendImageRequest$lambda2(this.f37919a, imageResponse);
    }
}

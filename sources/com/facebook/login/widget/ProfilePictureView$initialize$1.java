package com.facebook.login.widget;

import com.facebook.Profile;
import com.facebook.ProfileTracker;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¨\u0006\u0007"}, d2 = {"com/facebook/login/widget/ProfilePictureView$initialize$1", "Lcom/facebook/ProfileTracker;", "onCurrentProfileChanged", "", "oldProfile", "Lcom/facebook/Profile;", "currentProfile", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProfilePictureView$initialize$1 extends ProfileTracker {
    final /* synthetic */ ProfilePictureView this$0;

    ProfilePictureView$initialize$1(ProfilePictureView profilePictureView) {
        this.this$0 = profilePictureView;
    }

    /* access modifiers changed from: protected */
    public void onCurrentProfileChanged(Profile profile, Profile profile2) {
        String str;
        ProfilePictureView profilePictureView = this.this$0;
        if (profile2 == null) {
            str = null;
        } else {
            str = profile2.getId();
        }
        profilePictureView.setProfileId(str);
        this.this$0.refreshImage(true);
    }
}

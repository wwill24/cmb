package com.facebook;

import android.content.Intent;
import com.facebook.internal.Utility;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import n1.a;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\b\u0000\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00028F@FX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0007\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/facebook/ProfileManager;", "", "Lcom/facebook/Profile;", "currentProfile", "", "writeToCache", "", "setCurrentProfile", "oldProfile", "sendCurrentProfileChangedBroadcast", "loadCurrentProfile", "Ln1/a;", "localBroadcastManager", "Ln1/a;", "Lcom/facebook/ProfileCache;", "profileCache", "Lcom/facebook/ProfileCache;", "currentProfileField", "Lcom/facebook/Profile;", "value", "getCurrentProfile", "()Lcom/facebook/Profile;", "(Lcom/facebook/Profile;)V", "<init>", "(Ln1/a;Lcom/facebook/ProfileCache;)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class ProfileManager {
    public static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";
    public static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
    /* access modifiers changed from: private */
    public static volatile ProfileManager instance;
    private Profile currentProfileField;
    private final a localBroadcastManager;
    private final ProfileCache profileCache;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/ProfileManager$Companion;", "", "()V", "ACTION_CURRENT_PROFILE_CHANGED", "", "EXTRA_NEW_PROFILE", "EXTRA_OLD_PROFILE", "instance", "Lcom/facebook/ProfileManager;", "getInstance", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized ProfileManager getInstance() {
            ProfileManager access$getInstance$cp;
            if (ProfileManager.instance == null) {
                a b10 = a.b(FacebookSdk.getApplicationContext());
                j.f(b10, "getInstance(applicationContext)");
                ProfileManager.instance = new ProfileManager(b10, new ProfileCache());
            }
            access$getInstance$cp = ProfileManager.instance;
            if (access$getInstance$cp == null) {
                j.y("instance");
                throw null;
            }
            return access$getInstance$cp;
        }
    }

    public ProfileManager(a aVar, ProfileCache profileCache2) {
        j.g(aVar, "localBroadcastManager");
        j.g(profileCache2, "profileCache");
        this.localBroadcastManager = aVar;
        this.profileCache = profileCache2;
    }

    public static final synchronized ProfileManager getInstance() {
        ProfileManager instance2;
        synchronized (ProfileManager.class) {
            instance2 = Companion.getInstance();
        }
        return instance2;
    }

    private final void sendCurrentProfileChangedBroadcast(Profile profile, Profile profile2) {
        Intent intent = new Intent(ACTION_CURRENT_PROFILE_CHANGED);
        intent.putExtra(EXTRA_OLD_PROFILE, profile);
        intent.putExtra(EXTRA_NEW_PROFILE, profile2);
        this.localBroadcastManager.d(intent);
    }

    public final Profile getCurrentProfile() {
        return this.currentProfileField;
    }

    public final boolean loadCurrentProfile() {
        Profile load = this.profileCache.load();
        if (load == null) {
            return false;
        }
        setCurrentProfile(load, false);
        return true;
    }

    public final void setCurrentProfile(Profile profile) {
        setCurrentProfile(profile, true);
    }

    private final void setCurrentProfile(Profile profile, boolean z10) {
        Profile profile2 = this.currentProfileField;
        this.currentProfileField = profile;
        if (z10) {
            if (profile != null) {
                this.profileCache.save(profile);
            } else {
                this.profileCache.clear();
            }
        }
        if (!Utility.areObjectsEqual(profile2, profile)) {
            sendCurrentProfileChangedBroadcast(profile2, profile);
        }
    }
}

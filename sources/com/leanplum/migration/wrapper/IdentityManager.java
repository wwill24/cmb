package com.leanplum.migration.wrapper;

import com.leanplum.internal.Constants;
import com.leanplum.internal.Log;
import com.leanplum.migration.MigrationConstants;
import com.leanplum.utils.StringPreference;
import com.leanplum.utils.StringPreferenceNullable;
import gk.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.j;
import tk.d;
import wk.l;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010!\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\"\u0012\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\b0\"¢\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\bJ\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\bR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R+\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR/\u0010 \u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b8B@BX\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019¨\u0006'"}, d2 = {"Lcom/leanplum/migration/wrapper/IdentityManager;", "", "", "loginAnonymously", "loginIdentified", "", "isAnonymous", "isFirstTimeStart", "", "cleverTapId", "", "profile", "userId", "setUserId", "isDeviceIdHashed", "getOriginalDeviceId", "Lcom/leanplum/migration/wrapper/LPIdentity;", "identity", "Lcom/leanplum/migration/wrapper/LPIdentity;", "<set-?>", "state$delegate", "Ltk/d;", "getState", "()Ljava/lang/String;", "setState", "(Ljava/lang/String;)V", "state", "startState", "Ljava/lang/String;", "anonymousMergeUserId$delegate", "getAnonymousMergeUserId", "setAnonymousMergeUserId", "anonymousMergeUserId", "deviceId", "Ltk/d;", "stateDelegate", "mergeUserDelegate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ltk/d;Ltk/d;)V", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class IdentityManager {
    static final /* synthetic */ l[] $$delegatedProperties;
    private final d anonymousMergeUserId$delegate;
    private final LPIdentity identity;
    private final String startState;
    private final d state$delegate;

    static {
        Class<IdentityManager> cls = IdentityManager.class;
        $$delegatedProperties = new l[]{kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(cls, "state", "getState()Ljava/lang/String;", 0)), kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(cls, "anonymousMergeUserId", "getAnonymousMergeUserId()Ljava/lang/String;", 0))};
    }

    public IdentityManager(String str, String str2, d<Object, String> dVar, d<Object, String> dVar2) {
        j.g(str, Constants.Params.DEVICE_ID);
        j.g(str2, Constants.Params.USER_ID);
        j.g(dVar, "stateDelegate");
        j.g(dVar2, "mergeUserDelegate");
        this.identity = new LPIdentity(str, str2);
        this.state$delegate = dVar;
        this.anonymousMergeUserId$delegate = dVar2;
        this.startState = getState();
        if (isAnonymous()) {
            loginAnonymously();
        } else {
            loginIdentified();
        }
    }

    private final String getAnonymousMergeUserId() {
        return (String) this.anonymousMergeUserId$delegate.getValue(this, $$delegatedProperties[1]);
    }

    private final String getState() {
        return (String) this.state$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private final void loginAnonymously() {
        setState("anonymous");
    }

    private final void loginIdentified() {
        if (j.b(getState(), "undefined")) {
            setState("identified");
        } else if (j.b(getState(), "anonymous")) {
            setAnonymousMergeUserId(this.identity.userId());
            Log.d("Wrapper: anonymous data will be merged to " + getAnonymousMergeUserId(), new Object[0]);
            setState("identified");
        }
    }

    private final void setAnonymousMergeUserId(String str) {
        this.anonymousMergeUserId$delegate.setValue(this, $$delegatedProperties[1], str);
    }

    private final void setState(String str) {
        this.state$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final String cleverTapId() {
        if (this.identity.isAnonymous()) {
            return this.identity.deviceId();
        }
        if (j.b(this.identity.userId(), getAnonymousMergeUserId())) {
            return this.identity.deviceId();
        }
        return this.identity.deviceId() + '_' + this.identity.userId();
    }

    public final String getOriginalDeviceId() {
        return this.identity.originalDeviceId();
    }

    public final boolean isAnonymous() {
        return this.identity.isAnonymous();
    }

    public final boolean isDeviceIdHashed() {
        return !j.b(this.identity.originalDeviceId(), this.identity.deviceId());
    }

    public final boolean isFirstTimeStart() {
        return j.b(this.startState, "undefined");
    }

    public final Map<String, String> profile() {
        return g0.f(h.a(MigrationConstants.IDENTITY, this.identity.originalUserId()));
    }

    public final boolean setUserId(String str) {
        j.g(str, Constants.Params.USER_ID);
        if (!this.identity.setUserId(str)) {
            return false;
        }
        if (!j.b(getState(), "anonymous")) {
            return true;
        }
        setAnonymousMergeUserId(this.identity.userId());
        Log.d("Wrapper: anonymous data will be merged to " + getAnonymousMergeUserId(), new Object[0]);
        setState("identified");
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IdentityManager(String str, String str2, d dVar, d dVar2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i10 & 4) != 0 ? new StringPreference("ct_login_state", "undefined") : dVar, (i10 & 8) != 0 ? new StringPreferenceNullable("ct_anon_merge_userid", (String) null, 2, (DefaultConstructorMarker) null) : dVar2);
    }
}

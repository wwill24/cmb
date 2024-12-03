package com.leanplum.migration.wrapper;

import com.leanplum.internal.Constants;
import com.leanplum.utils.HashUtil;
import i4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0003J\u0006\u0010\u000b\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/leanplum/migration/wrapper/LPIdentity;", "", "deviceId", "", "userId", "(Ljava/lang/String;Ljava/lang/String;)V", "deviceIdHash", "userIdHash", "isAnonymous", "", "originalDeviceId", "originalUserId", "setUserId", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class LPIdentity {
    private final String deviceId;
    private String deviceIdHash;
    private String userId;
    private String userIdHash;

    public LPIdentity(String str, String str2) {
        j.g(str, Constants.Params.DEVICE_ID);
        j.g(str2, Constants.Params.USER_ID);
        this.deviceId = str;
        this.userId = str2;
        if (str.length() > 50 || !x.y(str)) {
            this.deviceIdHash = HashUtil.INSTANCE.sha256_200(str);
        }
        this.userIdHash = HashUtil.INSTANCE.sha256_40(this.userId);
    }

    public final String deviceId() {
        String str = this.deviceIdHash;
        return str != null ? str : this.deviceId;
    }

    public final boolean isAnonymous() {
        return j.b(this.userId, this.deviceId);
    }

    public final String originalDeviceId() {
        return this.deviceId;
    }

    public final String originalUserId() {
        return this.userId;
    }

    public final boolean setUserId(String str) {
        j.g(str, Constants.Params.USER_ID);
        if (j.b(this.userId, str)) {
            return false;
        }
        this.userId = str;
        this.userIdHash = HashUtil.INSTANCE.sha256_40(str);
        return true;
    }

    public final String userId() {
        return this.userIdHash;
    }
}

package com.coffeemeetsbagel.models;

import androidx.annotation.Keep;

@Keep
public interface ResultCode {
    public static final int ALREADY_LOGGED_IN = 69;
    public static final int BAGEL_BLOCKED = 50;
    public static final int GENERIC_ERROR = 70;
    public static final int HAS_UNIT_CHANGED = 51;
    public static final int IMAGE_TOO_LARGE = 53;
    public static final int LOGOUT = 47;
    public static final int NO_FILTER_SEARCH_RESULTS = 52;
    public static final int PHONE_LOGIN_BANNED = 71;
    public static final int PHONE_LOGIN_FAILED = 65;
    public static final int PHONE_LOGIN_MAINTENANCE_MODE = 66;
    public static final int PHONE_LOGIN_SUCCEEDED = 61;
    public static final int PROFILE_BLOCKED = 67;
    public static final int SEND_FLOWERS = 68;
    public static final int TAKE_ACTION = 64;
    public static final int VERIFICATION_ERROR = 72;
    public static final int VERIFICATION_SUCCESS = 73;
}

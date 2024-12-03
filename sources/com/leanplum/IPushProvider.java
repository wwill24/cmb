package com.leanplum;

interface IPushProvider {
    String getRegistrationId();

    PushProviderType getType();

    void setRegistrationId(String str);

    void unregister();

    void updateRegistrationId();
}

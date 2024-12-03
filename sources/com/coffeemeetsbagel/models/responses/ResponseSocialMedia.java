package com.coffeemeetsbagel.models.responses;

import com.coffeemeetsbagel.models.enums.RewardType;

public class ResponseSocialMedia extends ResponseGeneric {
    private int earnedBeans;
    private int invitesSent;
    private RewardType mRewardType;
    private int newInviteCount;

    public ResponseSocialMedia(String str, int i10) {
        super(str, i10);
    }

    public int getBeansEarned() {
        return this.earnedBeans;
    }

    public int getInviteCount() {
        return this.newInviteCount;
    }

    public int getInvitesSent() {
        return this.invitesSent;
    }

    public RewardType getRewardType() {
        return this.mRewardType;
    }

    public void setBeanRewardTypeType(RewardType rewardType) {
        this.mRewardType = rewardType;
    }

    public void setInvitesSent(int i10) {
        this.invitesSent = i10;
    }
}

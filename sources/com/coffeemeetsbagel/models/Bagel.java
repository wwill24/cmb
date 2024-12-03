package com.coffeemeetsbagel.models;

import androidx.annotation.NonNull;
import com.coffeemeetsbagel.models.dto.MatchContract;
import com.coffeemeetsbagel.models.enums.MatchAction;
import com.coffeemeetsbagel.models.enums.MatchToMe;
import com.coffeemeetsbagel.models.enums.MatchType;
import com.coffeemeetsbagel.models.enums.PurchaseAttribution;
import com.coffeemeetsbagel.models.util.DateUtils;
import fa.a;
import j$.time.OffsetDateTime;
import java.io.Serializable;
import java.util.Date;
import kotlin.jvm.internal.j;
import lg.c;

public class Bagel implements Serializable, Model, Comparable<Bagel> {
    public static final int ACTION_CHECKED = 3;
    public static final int ACTION_LIKED = 1;
    public static final int ACTION_NOT_CHECKED = 0;
    public static final int ACTION_PASSED = 2;
    public static final int BAGEL_TYPE_BONUS = 7;
    public static final int BAGEL_TYPE_CHAT_INITIATION = 10;
    public static final int BAGEL_TYPE_GIVEN = 4;
    public static final int BAGEL_TYPE_LIGHTWEIGHT = 5;
    public static final int BAGEL_TYPE_REGULAR = 0;
    public static final int BAGEL_TYPE_REMATCH = 1;
    public static final int BAGEL_TYPE_TAKEN = 6;
    public static final int BAGEL_TYPE_VIDEO_TAKE = 11;
    /* access modifiers changed from: private */
    public int action;
    private int bagelType;
    private boolean chatRemoved;
    private String coupleId;
    private String createdAt;
    private String decouplingDate;
    /* access modifiers changed from: private */
    public String endDate;
    private String givenByFirstName;
    @c("reveal_purchased")
    private boolean hasRevealPurchased;
    /* access modifiers changed from: private */

    /* renamed from: id  reason: collision with root package name */
    public String f34705id;
    /* access modifiers changed from: private */
    @c("block")
    public boolean isBlocked;
    @c("pair_block")
    private boolean isPairBlocked;
    private boolean isRematched;
    private String lastUpdated;
    /* access modifiers changed from: private */
    @c("like_comment")
    public String likeComment;
    @c("like_photo_url")
    private String likePhotoUrl;
    @c("like_profile_part")
    private String likeProfilePart;
    private ConnectionDetails mConnectionDetails = new ConnectionDetails();
    @c("match_context")
    private MatchContext matchContext;
    /* access modifiers changed from: private */
    @c("match_to_me")
    public String matchToMe;
    private int meetupFollowUpAnswer;
    private int meetupPromptAnswer;
    private int numMutualFriends;
    /* access modifiers changed from: private */
    public int pairAction;
    private int pairBagelType;
    private boolean pairChatRemoved;
    /* access modifiers changed from: private */
    @c("pair_like_comment")
    public String pairLikeComment;
    @c("pair_like_photo_url")
    private String pairLikePhotoUrl;
    @c("pair_like_profile_part")
    private String pairLikeProfilePart;
    /* access modifiers changed from: private */
    public int pairTotalWoos;
    private NetworkProfile profile;
    /* access modifiers changed from: private */
    public String profileId;
    /* access modifiers changed from: private */
    @c("purchase_attribution")
    public Integer purchaseAttribution;
    /* access modifiers changed from: private */
    public int risingBagelCount;
    private String rosterGroup;
    /* access modifiers changed from: private */
    public Integer showOrder;
    /* access modifiers changed from: private */
    public String startDate;
    private int totalWoos;
    /* access modifiers changed from: private */
    public int totalWoosSeen;

    public enum STAMP {
        LIKED,
        PASSED,
        CONNECTED
    }

    @NonNull
    public static Bagel fromMatch(@NonNull MatchContract matchContract) {
        j.h(matchContract, "match");
        Bagel bagel = new Bagel();
        bagel.setId(matchContract.getId());
        bagel.setShowOrder(matchContract.getShowOrder());
        bagel.setAction(matchContract.getAction().getId());
        bagel.setLikeComment(matchContract.getLikeComment());
        bagel.setEndDate(DateUtils.getFormattedUtcDateTimeFromOffsetDateTime(matchContract.getEndAt()));
        bagel.setIsBlocked(matchContract.isBlocked());
        bagel.setPairLikeComment(matchContract.getMessage());
        bagel.setProfileId(matchContract.getProfileId());
        bagel.setRisingBagelCount(matchContract.getRisingCount());
        bagel.setStartDate(DateUtils.getFormattedUtcDateTimeFromOffsetDateTime(matchContract.getStartAt()));
        bagel.setTotalWoos(matchContract.getWooCount());
        bagel.setTotalWoosSeen(matchContract.getWooSeenCount());
        if (matchContract.getPurchaseAttribution() != null) {
            bagel.setPurchaseAttributionValue(Integer.valueOf(matchContract.getPurchaseAttribution().getPurchaseAttributionInteger()));
        }
        return bagel;
    }

    private int idComparisonOrDefault(Bagel bagel, Bagel bagel2) {
        try {
            if (Long.valueOf(bagel.getId()).longValue() - Long.valueOf(bagel2.getId()).longValue() > 0) {
                return 1;
            }
            return -1;
        } catch (NumberFormatException e10) {
            a.i(e10);
            return 1;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof Bagel) && this.f34705id.equals(((Bagel) obj).getId());
    }

    public int getAction() {
        return this.action;
    }

    public int getBagelType() {
        return this.bagelType;
    }

    public ConnectionDetails getConnectionDetails() {
        return this.mConnectionDetails;
    }

    public String getCoupleId() {
        return this.coupleId;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getDecouplingDate() {
        return this.decouplingDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public String getGivenByFirstName() {
        return this.givenByFirstName;
    }

    public String getId() {
        return this.f34705id;
    }

    public String getLastUpdated() {
        return this.lastUpdated;
    }

    public String getLikeComment() {
        return this.likeComment;
    }

    public MatchContext getMatchContext() {
        return this.matchContext;
    }

    public String getMatchToMe() {
        return this.matchToMe;
    }

    public int getMeetupFollowUpAnswer() {
        return this.meetupFollowUpAnswer;
    }

    public int getMeetupPromptAnswer() {
        return this.meetupPromptAnswer;
    }

    public int getNumMutualFriends() {
        return this.numMutualFriends;
    }

    public int getPairAction() {
        return this.pairAction;
    }

    public int getPairBagelType() {
        return this.pairBagelType;
    }

    public String getPairLikeComment() {
        return this.pairLikeComment;
    }

    public int getPairTotalWoos() {
        return this.pairTotalWoos;
    }

    public NetworkProfile getProfile() {
        return this.profile;
    }

    public String getProfileId() {
        return this.profileId;
    }

    public Integer getPurchaseAttributionValue() {
        return this.purchaseAttribution;
    }

    public int getRisingBagelCount() {
        return this.risingBagelCount;
    }

    public String getRosterGroup() {
        return this.rosterGroup;
    }

    public Integer getShowOrder() {
        return this.showOrder;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public int getTotalWoos() {
        return this.totalWoos;
    }

    public int getTotalWoosSeen() {
        return this.totalWoosSeen;
    }

    public boolean hasRevealPurchased() {
        return this.hasRevealPurchased;
    }

    public boolean isActedUpon() {
        int i10 = this.action;
        return i10 == 1 || i10 == 2;
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public boolean isChatRemoved() {
        return this.chatRemoved;
    }

    public boolean isChecked() {
        return this.action == 3;
    }

    public boolean isConnected() {
        return this.action == 1 && this.pairAction == 1 && this.coupleId != null && !this.isBlocked;
    }

    public boolean isExpired() {
        long currentTimestamp = DateUtils.getCurrentTimestamp();
        Date date = DateUtils.getDate(this.endDate);
        if (date == null || date.getTime() < currentTimestamp) {
            return true;
        }
        return false;
    }

    public boolean isPairBlocked() {
        return this.isPairBlocked;
    }

    public boolean isPairChatRemoved() {
        return this.pairChatRemoved;
    }

    public boolean isPastDecouplingDate() {
        Date date = DateUtils.getDate(getDecouplingDate());
        if (date == null || DateUtils.getCurrentTimestamp() > date.getTime()) {
            return true;
        }
        return false;
    }

    public boolean isRematched() {
        return this.isRematched;
    }

    public void setAction(int i10) {
        this.action = i10;
    }

    public void setBagelType(int i10) {
        this.bagelType = i10;
    }

    public void setChatRemoved(boolean z10) {
        this.chatRemoved = z10;
    }

    public void setConnectionDetails(ConnectionDetails connectionDetails) {
        this.mConnectionDetails = connectionDetails;
    }

    public void setCoupleId(String str) {
        this.coupleId = str;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public void setDecouplingDate(String str) {
        this.decouplingDate = str;
    }

    public void setEndDate(String str) {
        this.endDate = str;
    }

    public void setGivenByFirstName(String str) {
        this.givenByFirstName = str;
    }

    public void setHasRevealPurchased(boolean z10) {
        this.hasRevealPurchased = z10;
    }

    public void setId(String str) {
        this.f34705id = str;
    }

    public void setIsBlocked(boolean z10) {
        this.isBlocked = z10;
    }

    public void setIsPairBlocked(boolean z10) {
        this.isPairBlocked = z10;
    }

    public void setIsRematched(boolean z10) {
        this.isRematched = z10;
    }

    public void setLastUpdated(String str) {
        this.lastUpdated = str;
    }

    public void setLikeComment(String str) {
        this.likeComment = str;
    }

    public void setMatchContext(MatchContext matchContext2) {
        this.matchContext = matchContext2;
    }

    public void setMatchToMe(String str) {
        this.matchToMe = str;
    }

    public void setMeetupFollowUpAnswer(int i10) {
        this.meetupFollowUpAnswer = i10;
    }

    public void setMeetupPromptAnswer(int i10) {
        this.meetupPromptAnswer = i10;
    }

    public void setNumMutualFriends(int i10) {
        this.numMutualFriends = i10;
    }

    public void setPairAction(int i10) {
        this.pairAction = i10;
    }

    public void setPairBagelType(int i10) {
        this.pairBagelType = i10;
    }

    public void setPairChatRemoved(boolean z10) {
        this.pairChatRemoved = z10;
    }

    public void setPairLikeComment(String str) {
        this.pairLikeComment = str;
    }

    public void setPairTotalWoos(int i10) {
        this.pairTotalWoos = i10;
    }

    public void setProfile(NetworkProfile networkProfile) {
        this.profile = networkProfile;
    }

    public void setProfileId(String str) {
        this.profileId = str;
    }

    public void setPurchaseAttributionValue(Integer num) {
        this.purchaseAttribution = num;
    }

    public void setRisingBagelCount(int i10) {
        this.risingBagelCount = i10;
    }

    public void setRosterGroup(String str) {
        this.rosterGroup = str;
    }

    public void setShowOrder(Integer num) {
        this.showOrder = num;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }

    public void setTotalWoos(int i10) {
        this.totalWoos = i10;
    }

    public void setTotalWoosSeen(int i10) {
        this.totalWoosSeen = i10;
    }

    public MatchContract toMatch(final MatchType matchType) {
        return new MatchContract() {
            @NonNull
            public MatchAction getAction() {
                return MatchAction.Companion.fromId(Bagel.this.action);
            }

            @NonNull
            public OffsetDateTime getEndAt() {
                return DateUtils.getOffsetDateTimeForFormattedUtcDateTime(Bagel.this.endDate);
            }

            @NonNull
            public String getId() {
                return Bagel.this.f34705id;
            }

            public String getLikeComment() {
                return Bagel.this.likeComment;
            }

            @NonNull
            public String getMatchToMe() {
                return Bagel.this.matchToMe == null ? MatchToMe.OTHER.getValue() : Bagel.this.matchToMe;
            }

            public String getMessage() {
                return Bagel.this.pairLikeComment;
            }

            @NonNull
            public String getProfileId() {
                return Bagel.this.profileId;
            }

            public PurchaseAttribution getPurchaseAttribution() {
                if (Bagel.this.purchaseAttribution != null) {
                    return PurchaseAttribution.purchaseAttributionFromInteger(Bagel.this.purchaseAttribution);
                }
                return null;
            }

            public int getRisingCount() {
                return Bagel.this.risingBagelCount;
            }

            public Integer getShowOrder() {
                return Bagel.this.showOrder;
            }

            @NonNull
            public OffsetDateTime getStartAt() {
                return DateUtils.getOffsetDateTimeForFormattedUtcDateTime(Bagel.this.startDate);
            }

            @NonNull
            public MatchType getType() {
                return matchType;
            }

            public int getWooCount() {
                return Bagel.this.pairTotalWoos;
            }

            public int getWooSeenCount() {
                return Bagel.this.totalWoosSeen;
            }

            public boolean isBlocked() {
                return Bagel.this.isBlocked;
            }

            public boolean isRising() {
                return Bagel.this.pairAction == 1;
            }
        };
    }

    public String toString() {
        if (this.profile == null) {
            return "Unknown / not filled in";
        }
        return "" + this.profileId + " : " + this.profile.getUserFirstName() + " DC Date : " + this.decouplingDate + " CP ID : " + this.coupleId;
    }

    public int compareTo(@NonNull Bagel bagel) {
        if (this.f34705id.equals(bagel.f34705id)) {
            return 0;
        }
        int i10 = -DateUtils.getCalendarFromStringDate(this.startDate).compareTo(DateUtils.getCalendarFromStringDate(bagel.startDate));
        return i10 == 0 ? idComparisonOrDefault(this, bagel) : i10;
    }
}

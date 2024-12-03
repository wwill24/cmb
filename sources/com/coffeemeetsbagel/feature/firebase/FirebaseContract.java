package com.coffeemeetsbagel.feature.firebase;

import java.util.Map;

public interface FirebaseContract {

    public interface Analytics {

        public interface ItemName {
            public static final Companion Companion = Companion.$$INSTANCE;
            public static final String INSTANT_LIKE_FAILURE = "instant like failure";
            public static final String INSTANT_LIKE_SUCCESS = "instant like success";
            public static final String WOO_FAILURE = "woo failure";
            public static final String WOO_SUCCESS = "woo success";

            public static final class Companion {
                static final /* synthetic */ Companion $$INSTANCE = new Companion();
                public static final String INSTANT_LIKE_FAILURE = "instant like failure";
                public static final String INSTANT_LIKE_SUCCESS = "instant like success";
                public static final String WOO_FAILURE = "woo failure";
                public static final String WOO_SUCCESS = "woo success";

                private Companion() {
                }
            }
        }

        public interface UserPropertyKey {
            public static final Companion Companion = Companion.$$INSTANCE;
            public static final String FEEDBACK_FIRST_QUESTION = "feedback_first_question";
            public static final String FEEDBACK_LEAVE_FEEDBACK = "feedback_leave_feedback";
            public static final String FEEDBACK_RATE_APP = "feedback_rate_app";

            public static final class Companion {
                static final /* synthetic */ Companion $$INSTANCE = new Companion();
                public static final String FEEDBACK_FIRST_QUESTION = "feedback_first_question";
                public static final String FEEDBACK_LEAVE_FEEDBACK = "feedback_leave_feedback";
                public static final String FEEDBACK_RATE_APP = "feedback_rate_app";

                private Companion() {
                }
            }
        }

        public interface UserPropertyValue {
            public static final Companion Companion = Companion.$$INSTANCE;
            public static final String NO = "no";
            public static final String YES = "yes";

            public static final class Companion {
                static final /* synthetic */ Companion $$INSTANCE = new Companion();
                public static final String NO = "no";
                public static final String YES = "yes";

                private Companion() {
                }
            }
        }

        void logSpendingVirtualCurrency(long j10, String str, long j11);

        void setUserId(String str);

        void setUserProperty(String str, String str2);

        void trackEvent(String str, Map<String, String> map);
    }
}

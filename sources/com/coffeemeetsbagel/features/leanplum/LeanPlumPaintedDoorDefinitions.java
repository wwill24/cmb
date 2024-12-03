package com.coffeemeetsbagel.features.leanplum;

import com.leanplum.annotations.Variable;

public class LeanPlumPaintedDoorDefinitions {
    @Variable(group = "Android.PaintedDoor.ChatList.NavBar.Trailing", name = "AccessibilityLabel")
    public static String chatNavBarTrailingAccessiblityLabel = "";
    @Variable(group = "Android.PaintedDoor.ChatList.NavBar.Trailing", name = "TriggeredEventName")
    public static String chatNavBarTrailingEvent = "";
    @Variable(group = "Android.PaintedDoor.ChatList.NavBar.Trailing", name = "IconHeight")
    public static int chatNavBarTrailingHeight = 40;
    @Variable(group = "Android.PaintedDoor.ChatList.NavBar.Trailing", name = "IconURL")
    public static String chatNavBarTrailingUrl = "";
    @Variable(group = "Android.PaintedDoor.ChatList.NavBar.Trailing", name = "ViewedEventName")
    public static String chatNavBarTrailingViewedEvent = "";
    @Variable(group = "Android.PaintedDoor.ChatList.NavBar.Trailing", name = "IconWidth")
    public static int chatNavBarTrailingWidth = 40;
    @Variable(group = "Android.PaintedDoor.Discover.NavBar.Trailing", name = "AccessibilityLabel")
    public static String discoverNavBarTrailingAccessiblityLabel = "";
    @Variable(group = "Android.PaintedDoor.Discover.NavBar.Trailing", name = "TriggeredEventName")
    public static String discoverNavBarTrailingEvent = "";
    @Variable(group = "Android.PaintedDoor.Discover.NavBar.Trailing", name = "IconHeight")
    public static int discoverNavBarTrailingHeight = 40;
    @Variable(group = "Android.PaintedDoor.Discover.NavBar.Trailing", name = "IconURL")
    public static String discoverNavBarTrailingUrl = "";
    @Variable(group = "Android.PaintedDoor.Discover.NavBar.Trailing", name = "IconWidth")
    public static int discoverNavBarTrailingWidth = 40;
    @Variable(group = "Android.PaintedDoor.Discover.NavBar.Trailing", name = "ViewedEventName")
    public static String discoverYouNavBarTrailingViewedEvent = "";
    @Variable(group = "Android.PaintedDoor.LikesYou.NavBar.Trailing", name = "AccessibilityLabel")
    public static String likesYouNavBarTrailingAccessiblityLabel = "";
    @Variable(group = "Android.PaintedDoor.LikesYou.NavBar.Trailing", name = "TriggeredEventName")
    public static String likesYouNavBarTrailingEvent = "";
    @Variable(group = "Android.PaintedDoor.LikesYou.NavBar.Trailing", name = "IconHeight")
    public static int likesYouNavBarTrailingHeight = 40;
    @Variable(group = "Android.PaintedDoor.LikesYou.NavBar.Trailing", name = "IconURL")
    public static String likesYouNavBarTrailingUrl = "";
    @Variable(group = "Android.PaintedDoor.LikesYou.NavBar.Trailing", name = "ViewedEventName")
    public static String likesYouNavBarTrailingViewedEvent = "";
    @Variable(group = "Android.PaintedDoor.LikesYou.NavBar.Trailing", name = "IconWidth")
    public static int likesYouNavBarTrailingWidth = 40;
    @Variable(group = "Android.PaintedDoor.ProfileMe.Banner.Trailing", name = "AccessibilityLabel")
    public static String profileNavBarTrailingAccessiblityLabel = "";
    @Variable(group = "Android.PaintedDoor.ProfileMe.Banner.Trailing", name = "TriggeredEventName")
    public static String profileNavBarTrailingEvent = "";
    @Variable(group = "Android.PaintedDoor.ProfileMe.Banner.Trailing", name = "IconHeight")
    public static int profileNavBarTrailingHeight = 40;
    @Variable(group = "Android.PaintedDoor.ProfileMe.Banner.Trailing", name = "IconURL")
    public static String profileNavBarTrailingUrl = "";
    @Variable(group = "Android.PaintedDoor.ProfileMe.Banner.Trailing", name = "IconWidth")
    public static int profileNavBarTrailingWidth = 40;
    @Variable(group = "Android.PaintedDoor.ProfileMe.NavBar.Trailing", name = "ViewedEventName")
    public static String profileYouNavBarTrailingViewedEvent = "";
    @Variable(group = "Android.PaintedDoor.Suggested.NavBar.Trailing", name = "AccessibilityLabel")
    public static String suggestedNavBarTrailingAccessiblityLabel = "";
    @Variable(group = "Android.PaintedDoor.Suggested.NavBar.Trailing", name = "TriggeredEventName")
    public static String suggestedNavBarTrailingEvent = "";
    @Variable(group = "Android.PaintedDoor.Suggested.NavBar.Trailing", name = "IconHeight")
    public static int suggestedNavBarTrailingHeight = 40;
    @Variable(group = "Android.PaintedDoor.Suggested.NavBar.Trailing", name = "IconURL")
    public static String suggestedNavBarTrailingUrl = "";
    @Variable(group = "Android.PaintedDoor.Suggested.NavBar.Trailing", name = "ViewedEventName")
    public static String suggestedNavBarTrailingViewedEvent = "";
    @Variable(group = "Android.PaintedDoor.Suggested.NavBar.Trailing", name = "IconWidth")
    public static int suggestedNavBarTrailingWidth = 40;

    public enum DoorVariable {
        ICON_WIDTH,
        ICON_HEIGHT,
        ACCESSIBILITY_LABEL,
        TRIGGER_EVENT,
        ICON_URL,
        VIEWED_EVENT
    }

    public enum PaintedDoor {
        CHAT_LIST,
        DISCOVER,
        SUGGESTED,
        LIKES_YOU,
        PROFILE_ME,
        UNDEFINED;

        private String d(String str) {
            return str == null ? "" : str;
        }

        public int a(DoorVariable doorVariable) {
            int i10 = a.f13509a[doorVariable.ordinal()];
            if (i10 != 5) {
                if (i10 != 6) {
                    throw new IllegalArgumentException(doorVariable.name() + " is not an int type");
                } else if (this == CHAT_LIST) {
                    return LeanPlumPaintedDoorDefinitions.chatNavBarTrailingHeight;
                } else {
                    if (this == DISCOVER) {
                        return LeanPlumPaintedDoorDefinitions.discoverNavBarTrailingHeight;
                    }
                    if (this == LIKES_YOU) {
                        return LeanPlumPaintedDoorDefinitions.likesYouNavBarTrailingHeight;
                    }
                    if (this == PROFILE_ME) {
                        return LeanPlumPaintedDoorDefinitions.profileNavBarTrailingHeight;
                    }
                    if (this == SUGGESTED) {
                        return LeanPlumPaintedDoorDefinitions.suggestedNavBarTrailingHeight;
                    }
                    throw new IllegalArgumentException("Undefined door: " + name());
                }
            } else if (this == CHAT_LIST) {
                return LeanPlumPaintedDoorDefinitions.chatNavBarTrailingWidth;
            } else {
                if (this == DISCOVER) {
                    return LeanPlumPaintedDoorDefinitions.discoverNavBarTrailingWidth;
                }
                if (this == LIKES_YOU) {
                    return LeanPlumPaintedDoorDefinitions.likesYouNavBarTrailingWidth;
                }
                if (this == PROFILE_ME) {
                    return LeanPlumPaintedDoorDefinitions.profileNavBarTrailingWidth;
                }
                if (this == SUGGESTED) {
                    return LeanPlumPaintedDoorDefinitions.suggestedNavBarTrailingWidth;
                }
                throw new IllegalArgumentException("Undefined door: " + name());
            }
        }

        public String b(DoorVariable doorVariable) {
            int i10 = a.f13509a[doorVariable.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            throw new IllegalArgumentException(doorVariable.name() + " is not a String type");
                        } else if (this == CHAT_LIST) {
                            return d(LeanPlumPaintedDoorDefinitions.chatNavBarTrailingViewedEvent);
                        } else {
                            if (this == DISCOVER) {
                                return d(LeanPlumPaintedDoorDefinitions.discoverYouNavBarTrailingViewedEvent);
                            }
                            if (this == LIKES_YOU) {
                                return d(LeanPlumPaintedDoorDefinitions.likesYouNavBarTrailingViewedEvent);
                            }
                            if (this == PROFILE_ME) {
                                return d(LeanPlumPaintedDoorDefinitions.profileYouNavBarTrailingViewedEvent);
                            }
                            if (this == SUGGESTED) {
                                return d(LeanPlumPaintedDoorDefinitions.suggestedNavBarTrailingViewedEvent);
                            }
                            throw new IllegalArgumentException("Undefined door: " + name());
                        }
                    } else if (this == CHAT_LIST) {
                        return d(LeanPlumPaintedDoorDefinitions.chatNavBarTrailingUrl);
                    } else {
                        if (this == DISCOVER) {
                            return d(LeanPlumPaintedDoorDefinitions.discoverNavBarTrailingUrl);
                        }
                        if (this == LIKES_YOU) {
                            return d(LeanPlumPaintedDoorDefinitions.likesYouNavBarTrailingUrl);
                        }
                        if (this == PROFILE_ME) {
                            return d(LeanPlumPaintedDoorDefinitions.profileNavBarTrailingUrl);
                        }
                        if (this == SUGGESTED) {
                            return d(LeanPlumPaintedDoorDefinitions.suggestedNavBarTrailingUrl);
                        }
                        throw new IllegalArgumentException("Undefined door: " + name());
                    }
                } else if (this == CHAT_LIST) {
                    return d(LeanPlumPaintedDoorDefinitions.chatNavBarTrailingEvent);
                } else {
                    if (this == DISCOVER) {
                        return d(LeanPlumPaintedDoorDefinitions.discoverNavBarTrailingEvent);
                    }
                    if (this == LIKES_YOU) {
                        return d(LeanPlumPaintedDoorDefinitions.likesYouNavBarTrailingEvent);
                    }
                    if (this == PROFILE_ME) {
                        return d(LeanPlumPaintedDoorDefinitions.profileNavBarTrailingEvent);
                    }
                    if (this == SUGGESTED) {
                        return d(LeanPlumPaintedDoorDefinitions.suggestedNavBarTrailingEvent);
                    }
                    throw new IllegalArgumentException("Undefined door: " + name());
                }
            } else if (this == CHAT_LIST) {
                return d(LeanPlumPaintedDoorDefinitions.chatNavBarTrailingAccessiblityLabel);
            } else {
                if (this == DISCOVER) {
                    return d(LeanPlumPaintedDoorDefinitions.discoverNavBarTrailingAccessiblityLabel);
                }
                if (this == LIKES_YOU) {
                    return d(LeanPlumPaintedDoorDefinitions.likesYouNavBarTrailingAccessiblityLabel);
                }
                if (this == PROFILE_ME) {
                    return d(LeanPlumPaintedDoorDefinitions.profileNavBarTrailingAccessiblityLabel);
                }
                if (this == SUGGESTED) {
                    return d(LeanPlumPaintedDoorDefinitions.suggestedNavBarTrailingAccessiblityLabel);
                }
                throw new IllegalArgumentException("Undefined door: " + name());
            }
        }

        public boolean c() {
            if (a(DoorVariable.ICON_WIDTH) <= 0 || a(DoorVariable.ICON_HEIGHT) <= 0 || b(DoorVariable.TRIGGER_EVENT).length() <= 0 || b(DoorVariable.ICON_URL).length() <= 0) {
                return false;
            }
            return true;
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13509a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions$DoorVariable[] r0 = com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions.DoorVariable.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f13509a = r0
                com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions$DoorVariable r1 = com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions.DoorVariable.ACCESSIBILITY_LABEL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f13509a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions$DoorVariable r1 = com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions.DoorVariable.TRIGGER_EVENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f13509a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions$DoorVariable r1 = com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions.DoorVariable.ICON_URL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f13509a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions$DoorVariable r1 = com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions.DoorVariable.VIEWED_EVENT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f13509a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions$DoorVariable r1 = com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions.DoorVariable.ICON_WIDTH     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f13509a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions$DoorVariable r1 = com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions.DoorVariable.ICON_HEIGHT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.features.leanplum.LeanPlumPaintedDoorDefinitions.a.<clinit>():void");
        }
    }
}

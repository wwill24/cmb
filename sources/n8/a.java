package n8;

import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.SavedMessage;
import com.coffeemeetsbagel.models.enums.MessageType;
import com.coffeemeetsbagel.models.util.DateUtils;
import java.util.Date;

public class a {
    private boolean a(ConnectionDetails connectionDetails, SavedMessage savedMessage) {
        if (savedMessage.getTimestampDate() == null) {
            return false;
        }
        Date lastMessageDateDate = connectionDetails.getLastMessageDateDate();
        if (lastMessageDateDate == null || savedMessage.getTimestampDate().after(lastMessageDateDate)) {
            return true;
        }
        return false;
    }

    private void c(ConnectionDetails connectionDetails, SavedMessage savedMessage) {
        if (savedMessage.hasContent() && a(connectionDetails, savedMessage)) {
            connectionDetails.setLastMessageDate(DateUtils.getFormattedDate(savedMessage.getTimestampDate(), DateUtils.DATE_WITH_TIME_PATTERN));
            connectionDetails.setLastMessageText(savedMessage.getMessage());
            connectionDetails.setLastSenderProfileId(savedMessage.getProfileId());
        }
    }

    private void d(ConnectionDetails connectionDetails, SavedMessage savedMessage) {
        if (savedMessage.isDisplayedMessage() && savedMessage.getTimestampDate() != null && savedMessage.isToMe()) {
            if (connectionDetails.getPairReadReceiptDateDate() == null || savedMessage.getTimestampDate().after(connectionDetails.getPairReadReceiptDateDate())) {
                connectionDetails.setPairReadReceiptDate(DateUtils.getFormattedDate(savedMessage.getTimestampDate(), DateUtils.DATE_WITH_TIME_PATTERN_MS));
            }
        }
    }

    private void e(ConnectionDetails connectionDetails, SavedMessage savedMessage) {
        if (savedMessage.isDisplayedMessage() && !savedMessage.isToMe()) {
            connectionDetails.resetUnreadMessageCount();
        } else if (savedMessage.getCategory() != null && !MessageType.NONE.name().equals(savedMessage.getCategory()) && savedMessage.isToMe() && !savedMessage.isDisplayedMessage()) {
            connectionDetails.incrementUnreadMessageCount();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(ConnectionDetails connectionDetails, SavedMessage savedMessage) {
        connectionDetails.setProfileId(savedMessage.getProfileId());
        if (a(connectionDetails, savedMessage)) {
            c(connectionDetails, savedMessage);
            e(connectionDetails, savedMessage);
        }
        d(connectionDetails, savedMessage);
    }
}

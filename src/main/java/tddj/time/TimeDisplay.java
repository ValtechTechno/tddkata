package tddj.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeDisplay {

    TimeService timeService = new TimeService();

    public String getCurrentTimeInFunnyWay() {
        Calendar now = timeService.getCalendar();
        StringBuilder time = new StringBuilder();
        time.append("C'est l'heure");

        if ((now.get(Calendar.HOUR_OF_DAY) == 12)
                && (now.get(Calendar.MINUTE) == 0)) {
            time.append(" du déjeuner");
        } else {
            SimpleDateFormat fr = new SimpleDateFormat("h:mm a");
            time.append(" ");
            time.append(fr.format(now.getTime()));
        }
        return time.toString();
    }

}

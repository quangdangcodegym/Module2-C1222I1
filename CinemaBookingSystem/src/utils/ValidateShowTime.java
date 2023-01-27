package utils;

import model.ERoom;
import model.ShowTime;
import repository.ShowTimeRepository;
import service.ShowTimeService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ValidateShowTime {
    private ShowTimeService showTimeService;

    public ValidateShowTime() {
        showTimeService = new ShowTimeService();
    }

    public boolean checkDateOfShowTime(String date) {
        if (DateUtils.validateDateFormat(date) == false) {
            return false;
        }
        Date newShowTime = DateUtils.parseDate(date);
        Date today = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DATE, 15);  // number of days to add

        Date afterHalfMonth = c.getTime();

        if (newShowTime.after(today) && newShowTime.before(afterHalfMonth)) {
            return true;
        }
        return false;
    }


    /**
     *
     * @param time : 2023-01-09 15:29
     * @param showTime: (2023-01-05 10:00, 2023-01-05 11:30)
     * @return
     */
    public boolean isInHour(Date time, ShowTime showTime) {
        Date startTime = DateUtils.minusTime(showTime.getStartTime(), 15);
        Date endTime = DateUtils.plusTime(showTime.getEndTime(), 15);
        if (time.after(startTime) && time.before(endTime) || (time.equals(startTime) || (time.equals(endTime)))) {
            return true;
        }
        return false;
    }

    public boolean checkNewValidateShowTime(String start, ShowTime newShowTime) {
        Date end = newShowTime.getEndTime();
        ERoom room = newShowTime.getIdRoom();
        long idRoom = room.getId();
        List<ShowTime> allShowTimes = showTimeService.getAllShowTimes();
        boolean exists = true;
        if (!checkDateOfShowTime(start)) {
            exists = true;
        }
        if (checkDateOfShowTime(start)) {
            // 2023-01-09 15:29 bettween
            // (2023-01-05 10:00, 2023-01-05 11:30)
            // (2023-01-05 14:00, 2023-01-05 15:00)

            Date newStartTime = DateUtils.parseDate(start);
            for (int i = 0; i < allShowTimes.size(); i++) {
                // đã tồn tại : true; chưa: false
                if (isInHour(newStartTime, allShowTimes.get(i)) == false && isInHour(end, allShowTimes.get(i)) == false) {
                    exists = false;
                } else {
                    if (idRoom == allShowTimes.get(i).getIdRoom().getId()) {
                        exists = true;
                    } else {
                        exists = false;
                    }
                }
            }
        }
        return exists;
    }

    public boolean checkEditShowTime(String start, ShowTime newShowTime) {
        List<ShowTime> showTimes = showTimeService.getAllShowTimes();
        for(int i = 0; i < showTimes.size();i++){
            if(showTimes.get(i).getId() == newShowTime.getId()){
                showTimes.remove(showTimes.get(i));
            }
        }
        Date end = newShowTime.getEndTime();
        ERoom room = newShowTime.getIdRoom();
        long idRoom = room.getId();
        boolean exists = true;
        if (!checkDateOfShowTime(start)) {
            exists = true;
        }
        if (checkDateOfShowTime(start)) {
            Date newStartTime = DateUtils.parseDate(start);
            for (int i = 0; i < showTimes.size(); i++) {
                // đã tồn tại : true; chưa: false
                if (isInHour(newStartTime, showTimes.get(i)) == false && isInHour(end, showTimes.get(i)) == false) {
                    exists = false;
                } else {
                    if (idRoom == showTimes.get(i).getIdRoom().getId()) {
                        exists = true;
                    } else {
                        exists = false;
                    }
                }
            }
        }
        return exists;
    }

}

package callback2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangHongbin on 2017/2/17.
 */
public class EventNotifier {

    private List<CallMe> callMes = new ArrayList<CallMe>();

    public void regist(CallMe callMe){
        callMes.add(callMe);
    }

    public void doWork(){
        for (CallMe callMe:callMes){
            callMe.interestingEvent("sample event");
        }
    }
}

package com.di.anno_list_injection;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SampleBean {

    @Resource
    private List<String> fruitsList;

    public void showFruits() {
        for (String fruit : fruitsList) {
            System.out.println("fruit: " + fruit);
        }
    }

    //@Resource(name = "prefsList")
    @Value("#{prefsList}")
    private List<String> prefs;

    public void showPrefs() {
        for (String pref : prefs) {
            System.out.println("pref: " + pref);
        }
    }

    @Resource
    private Map<String, String> timetable;

    public void showTimetable() {
        for (Map.Entry<String, String> subject : timetable.entrySet()) {
            System.out.println(String.format("timetable: %s, %s",
                    subject.getKey(), subject.getValue()));
        }
    }
    
    @Resource(name = "fruitMap")
    private Map<String, String> fruitMap;

    public void showFruitMap() {
        for (Map.Entry<String, String> subject : fruitMap.entrySet()) {
            System.out.println(String.format("fruitMap: %s, %s",
                    subject.getKey(), subject.getValue()));
        }
    }
}
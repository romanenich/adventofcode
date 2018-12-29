package com.romanenich.adventofcode2018.day4;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution4 {

    private final static String FILE_PATH = "com.romanenich/adventofcode2018/day4/input4.txt";

    public static void main(String[] args) {
        DataLoader4 dataLoader4 = new DataLoader4(FILE_PATH);
        List<Data4> datas = dataLoader4.loadData();
        Collections.sort(datas);
        Collection<GuardInfo> guardInfos = getGuardInfos(datas);

        final GuardInfo guardInfo1 = Collections.max(guardInfos);
        System.out.println("1. id * min = " + guardInfo1.getGuardId() * guardInfo1.getMinute().getMinute());

        final GuardInfo guardInfo2 = Collections.max(guardInfos, new Comparator<GuardInfo>() {
            @Override
            public int compare(GuardInfo o1, GuardInfo o2) {
                return o1.getMaxSleepCount().compareTo(o2.getMaxSleepCount());
            }
        });
        System.out.println("2. id * min = " + guardInfo2.getGuardId() * guardInfo2.getMinute().getMinute());
    }

    private static Collection<GuardInfo> getGuardInfos(List<Data4> datas) {
        GuardInfo curGuardInfo = null;
        Map<Integer, GuardInfo> guardInfos = new TreeMap<>();
        LocalDateTime startSleepTime = null;
        for (Data4 data : datas) {
            if (curGuardInfo == null && data.getType() != Data4.TYPE.SHIFT_BEGINS) {
                continue;
            }

            if (data.getType() == Data4.TYPE.SHIFT_BEGINS) {
                curGuardInfo = guardInfos.get(data.getGuardId());
                if (curGuardInfo == null) {
                    curGuardInfo = new GuardInfo(data.getGuardId());
                    guardInfos.put(data.getGuardId(), curGuardInfo);
                    continue;
                }
            }

            if (data.getType() == Data4.TYPE.WAKES_UP) {
                LocalDateTime wakesTime = data.getDateTime();
                curGuardInfo.add(startSleepTime, wakesTime);
                continue;
            }

            if (data.getType() == Data4.TYPE.FALLS_ASLEEP) {
                startSleepTime = data.getDateTime();
            }
        }
        return guardInfos.values();
    }
}

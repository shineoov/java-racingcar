package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RacingRecordManager {

    public static List<String> getRacingWinner(List<List<RacingRecord>> racingRecords) {
        List<RacingRecord> finalRacingHistory = getFinalRacingRecord(racingRecords);

        int maxPosition = getRacingMaxPosition(finalRacingHistory);

        return finalRacingHistory.stream()
                .filter(u -> u.getPosition() == maxPosition)
                .map(u -> u.getCar().getName())
                .collect(Collectors.toList());
    }

    private static List<RacingRecord> getFinalRacingRecord(List<List<RacingRecord>> racingRecords) {
        return racingRecords.get(racingRecords.size() - 1);
    }

    private static int getRacingMaxPosition(List<RacingRecord> finalRacingHistory) {
        return finalRacingHistory.stream()
                .max(Comparator.comparing(RacingRecord::getPosition))
                .orElseThrow(NoSuchElementException::new)
                .getPosition();
    }
}

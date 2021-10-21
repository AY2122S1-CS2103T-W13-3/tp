package seedu.address.model.util;

import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.GameBook;
import seedu.address.model.ReadOnlyGameBook;
import seedu.address.model.gameentry.DatePlayed;
import seedu.address.model.gameentry.GameEntry;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static GameEntry[] getSampleGameEntries() {
        Date date1 = new Date(121, 9, 12, 11, 40);
        Date date2 = new Date(121, 9, 12, 12, 40);
        return new GameEntry[] {
            new GameEntry("Poker", 10.96, 0.23, new DatePlayed(date1, true), 10,
                    "Home", getTagSet("drunk")),
            new GameEntry("Roulette", 31.01, 1.12, new DatePlayed(date1, false),
                        10, "Marina Bay Sands", getTagSet("drunk")),
            new GameEntry("Poker", 110., 23.64, new DatePlayed(date2, true), 12,
                        "School", getTagSet()),
            new GameEntry("Blackjack", 10.2, 12.94, new DatePlayed(date2, true), 10,
                        "john's home", getTagSet("hungry", "angry", "friends")),
            new GameEntry("Baccarat", 21.12, 0.26, new DatePlayed(60000000),
                        12, "resorts world Sentosa", getTagSet("smoking", "late-night")),
        };
    }

    public static ReadOnlyGameBook getSampleGameBook() {
        GameBook sampleGb = new GameBook();
        for (GameEntry sampleGameEntry : getSampleGameEntries()) {
            sampleGb.addGameEntry(sampleGameEntry);
        }
        return sampleGb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}

package testVagrant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PlaylistTest {
    private RecentlyPlayedSongsStore store;
    @BeforeEach
    public  void set() {
        int initialCapacity = 3;
        store = new RecentlyPlayedSongsStore(initialCapacity);
    }
    @Test
    public void testRecentSongs() {
        // User 1
        store.addRecentlyPlayedSong("User1", "S1");
        store.addRecentlyPlayedSong("User1", "S2");
        store.addRecentlyPlayedSong("User1", "S3");
        // Getting recently played songs for "User1"
        List<String> user1RecentlyPlayed = store.getRecentlyPlayedSongs("User1");
        List<String> expectedUser1RecentlyPlayed = Arrays.asList("S3", "S2", "S1");

        Assertions.assertEquals(expectedUser1RecentlyPlayed, user1RecentlyPlayed,
                "Recently played songs for User1 do not match the expected result.");
        System.out.println("User1's Recently Played Songs: " + user1RecentlyPlayed);
        // User 1 - Plays song S4
        store.addRecentlyPlayedSong("User1", "S4");
        System.out.println("User1's Recently Played Songs after playing song S4: " + store.getRecentlyPlayedSongs("User1"));

        // User 1 - Plays song S2 again
        store.addRecentlyPlayedSong("User1", "S2");
        System.out.println("User1's Recently Played Songs after playing song S2 again: " + store.getRecentlyPlayedSongs("User1"));

        // User 1 - Plays song S1 again
        store.addRecentlyPlayedSong("User1", "S1");
        System.out.println("User1's Recently Played Songs after playing song S1 again: " + store.getRecentlyPlayedSongs("User1"));


        // Getting recently played songs for "User1" after adding more songs
        user1RecentlyPlayed = store.getRecentlyPlayedSongs("User1");
        expectedUser1RecentlyPlayed = Arrays.asList("S1", "S2", "S4");
        Assertions.assertEquals(expectedUser1RecentlyPlayed, user1RecentlyPlayed,

                "Recently played songs for User1 after adding more songs do not match the expected result.");
    }
}

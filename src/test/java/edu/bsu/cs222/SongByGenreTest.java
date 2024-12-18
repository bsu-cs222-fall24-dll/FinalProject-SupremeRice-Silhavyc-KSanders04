package edu.bsu.cs222;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("ALL")
class SongByGenreTest {

    @Test
    void testGetSongByGenreWithPreviews() throws Exception {
        SongByGenre songByGenre = new SongByGenre();

        String genre = "pop";
        String[][] songs = songByGenre.getSongByGenreWithPreviews(genre);

        assertTrue(songs.length > 0, "The songs array should contain at least one song");
        assertTrue(songs[0].length == 2, "Each song entry should contain two elements (song name and preview URL)");
    }
}

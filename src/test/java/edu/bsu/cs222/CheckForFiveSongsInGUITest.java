package edu.bsu.cs222;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CheckForFiveSongsInGUITest {
    private GUIMenu guiMenu;
    private MusicController musicController;

    @BeforeEach
    public void setUp() {
        guiMenu = new GUIMenu();
        musicController = new MusicController(guiMenu, new ArtistByGenre(), new SongByGenre());
    }

    @Test
    public void testGetResultsSong() {
        guiMenu.genreComboBox.setSelectedItem("jazz");
        musicController.getResults("song");
        String outputText = guiMenu.outputPane.getText();
        assertNotNull(outputText, "Output pane should display songs.");

        String[] lines = outputText.split("\n");

        long songsCount = 0;
        if (lines.length >= 5) {
            for (String line : lines) {
                String trimmedLine = line.trim();
                if (!trimmedLine.isEmpty() && !trimmedLine.contains("Songs:")) {
                    songsCount += 1;
                }
            }
        }

        assertEquals(5, songsCount, "Output should contain 5 songs.");
    }
}

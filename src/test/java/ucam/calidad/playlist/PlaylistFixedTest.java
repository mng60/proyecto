package ucam.calidad.playlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ucam.calidad.playlist.Playlist;
import ucam.calidad.playlist.Song;

public class PlaylistFixedTest {

    private Playlist playlist;
    private Song s1;

    @BeforeEach
    public void setUp() {
        playlist = new Playlist("Favoritas");
        s1 = new Song("1", "Song A", "Artist A", 180);
        playlist.addSong(s1);
    }

    @Test
    public void testAssertEquals_CorrectDuration() {
        assertEquals(180, playlist.getTotalDuration(), "La duración total debe coincidir");
    }

    @Test
    public void testAssertTrue_AddDuplicateReturnsFalseSoWeCheckFalse() {
        boolean addedAgain = playlist.addSong(s1);
        assertFalse(addedAgain, "Añadir un duplicado debe devolver false");
    }

    @Test
    public void testAssertNotNull_FoundIsNotNull() {
        Song found = playlist.findSongByTitle("Song A");
        assertNotNull(found, "La canción debería existir");
    }

    @Test
    public void testAssertSame_FoundIsSameInstance() {
        Song found = playlist.findSongByTitle("Song A");
        assertSame(s1, found, "Debe ser la misma instancia guardada");
    }
}

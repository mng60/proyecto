package ucam.calidad.playlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlaylistFailureTest {

    private Playlist playlist;
    private Song s1;
    private Song s3;

    @BeforeEach
    public void setUp() {
        playlist = new Playlist("Favoritas");
        s1 = new Song("1", "Song A", "Artist A", 180);
        s3 = new Song("2", "Song B", "Artist B", 200);
        playlist.addSong(s1);
    }

    // Fallo 1: assertEquals con valor incorrecto
    @Test
    public void failAssertEquals_WrongDuration() {
        assertEquals(999, playlist.getTotalDuration(), "Duración incorrecta a propósito");
    }

    // Fallo 2: assertTrue cuando la condición es falsa
    @Test
    public void failAssertTrue_AddDuplicateShouldBeTrue() {
        boolean addedAgain = playlist.addSong(s1); // duplicado -> false
        assertTrue(addedAgain, "Debería fallar porque es duplicado");
    }

    // Fallo 3: assertNull cuando no es null
    @Test
    public void failAssertNull_FoundIsNotNull() {
        Song found = playlist.findSongByTitle("Song A");
        assertNull(found, "Debería fallar porque sí existe");
    }

    // Fallo 4: assertSame con objetos distintos
    @Test
    public void failAssertSame_DifferentInstances() {
        Song copy = new Song("1", "Song A", "Artist A", 180);
        assertSame(s1, copy, "Debe fallar porque no es la misma instancia");
    }
}

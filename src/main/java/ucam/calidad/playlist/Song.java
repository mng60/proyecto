package ucam.calidad.playlist;

import java.util.Objects;

public class Song 
{
	private String id;
    private String title;
    private String artist;
    private int durationSeconds; // duración en segundos

    public Song(String id, String title, String artist, int durationSeconds) 
    {
        if (id == null || id.isEmpty()) 
        {
            throw new IllegalArgumentException("El id de la canción no puede ser nulo ni vacío");
        }
        if (durationSeconds <= 0) 
        {
            throw new IllegalArgumentException("La duración debe ser positiva");
        }
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.durationSeconds = durationSeconds;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    @Override
    public boolean equals(Object o) 
    {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        // Consideramos que dos canciones son iguales si tienen el mismo id
        return Objects.equals(id, song.id);
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(id);
    }

    @Override
    public String toString() 
    {
        return "Song{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", durationSeconds=" + durationSeconds +
                '}';
    }
}

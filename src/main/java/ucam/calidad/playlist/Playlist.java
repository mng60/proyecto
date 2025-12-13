package ucam.calidad.playlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Playlist 
{
	private String name;
    private List<Song> songs;

    public Playlist(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la playlist no puede ser nulo ni vacío");
        }
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        return new ArrayList<>(songs);
    }

    public int getSongCount() {
        return songs.size();
    }

    public boolean isEmpty() {
        return songs.isEmpty();
    }

    /**
     * Añade una canción a la playlist.
     * Devuelve true si se ha añadido, false si ya existía (no se permiten duplicados por id).
     */
    public boolean addSong(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("La canción no puede ser null");
        }
        if (songs.contains(song)) {
            return false;
        }
        return songs.add(song);
    }

    /**
     * Elimina una canción por id.
     * Devuelve true si se eliminó, false si no se encontró.
     */
    public boolean removeSongById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("El id no puede ser nulo ni vacío");
        }
        Iterator<Song> it = songs.iterator();
        while (it.hasNext()) {
            Song s = it.next();
            if (id.equals(s.getId())) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Busca la primera canción cuyo título coincida (ignorando mayúsculas/minúsculas).
     * Devuelve null si no se encuentra.
     */
    public Song findSongByTitle(String title) {
        if (title == null) {
            return null;
        }
        for (Song s : songs) {
            if (title.equalsIgnoreCase(s.getTitle())) {
                return s;
            }
        }
        return null;
    }

    /**
     * Devuelve la duración total de la playlist en segundos.
     */
    public int getTotalDuration() {
        int total = 0;
        for (Song s : songs) {
            total += s.getDurationSeconds();
        }
        return total;
    }

    /**
     * Elimina todas las canciones de la playlist.
     */
    public void clear() {
        songs.clear();
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "name='" + name + '\'' +
                ", songs=" + songs.size() +
                '}';
    }
}

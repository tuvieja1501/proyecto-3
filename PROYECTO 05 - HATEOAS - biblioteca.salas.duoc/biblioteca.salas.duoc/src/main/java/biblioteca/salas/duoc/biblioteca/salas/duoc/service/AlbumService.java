package biblioteca.salas.duoc.biblioteca.salas.duoc.service;

import biblioteca.salas.duoc.biblioteca.salas.duoc.model.Album;
import biblioteca.salas.duoc.biblioteca.salas.duoc.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    
    @Autowired
    private AlbumRepository albumRepository;
    
    public List<Album> findAll() {
        return albumRepository.findAll();
    }
    
    public Optional<Album> findById(Long id) {
        return albumRepository.findById(id);
    }
    
    public Album save(Album album) {
        return albumRepository.save(album);
    }
    
    public Album update(Long id, Album albumActualizado) {
        return albumRepository.findById(id)
                .map(album -> {
                    album.setTitulo(albumActualizado.getTitulo());
                    album.setDescripcion(albumActualizado.getDescripcion());
                    album.setFechaLanzamiento(albumActualizado.getFechaLanzamiento());
                    album.setPortadaUrl(albumActualizado.getPortadaUrl());
                    album.setGenero(albumActualizado.getGenero());
                    album.setNumeroCanciones(albumActualizado.getNumeroCanciones());
                    album.setDuracionTotal(albumActualizado.getDuracionTotal());
                    return albumRepository.save(album);
                })
                .orElseThrow(() -> new RuntimeException("Album no encontrado con id: " + id));
    }
    
    public void deleteById(Long id) {
        albumRepository.deleteById(id);
    }
    
    public List<Album> findByArtistaId(Long artistaId) {
        return albumRepository.findByArtistaId(artistaId);
    }
    
    public List<Album> searchByTitle(String titulo) {
        return albumRepository.findByTituloContainingIgnoreCase(titulo);
    }
    
    public List<Album> findRecentAlbums() {
        return albumRepository.findRecentAlbums();
    }
    
    public List<Album> findByDateRange(Date fechaInicio, Date fechaFin) {
        return albumRepository.findByFechaLanzamientoBetween(fechaInicio, fechaFin);
    }
}
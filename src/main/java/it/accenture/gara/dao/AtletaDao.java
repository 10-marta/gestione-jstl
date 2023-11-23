package it.accenture.gara.dao;

import it.accenture.gara.model.Atleta;

import java.util.List;

public interface AtletaDao {
    public Atleta findById(String id);
    public List<Atleta> findAll();
    public Atleta save(Atleta atleta);
    public void delete(String id);
    public Atleta update (String id,Atleta atleta);
}

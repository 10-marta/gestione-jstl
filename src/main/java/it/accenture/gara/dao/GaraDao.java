package it.accenture.gara.dao;

import it.accenture.gara.model.Gara;

import java.util.List;

public interface GaraDao {
    public List<Gara> findAll();
    public Gara findById(String id);
    public Gara save(Gara gara);
    public Gara update(String id,Gara gara);
    public void delete(String id);


}

package it.accenture.gara.dao.fake;

import it.accenture.gara.dao.AtletaDao;
import it.accenture.gara.model.Atleta;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AtletaDaoFake implements AtletaDao {
    private static final Logger logger =Logger.getLogger(AtletaDaoFake.class.getName());

    private List<Atleta> atleti=new ArrayList<>();

    public  AtletaDaoFake(){
        atleti.add(new Atleta("CS098A","Andrea","Lovicu","M3","Demurtas A.S.D"));
        atleti.add(new Atleta("CS987B","Micheal","Giua","M2","School Bike Sardigna"));
        atleti.add(new Atleta("CS457N","Salvatore","D'Urso","M7","Alghero Bike"));
    }

    @Override
    public Atleta findById(String id) {
        for(int i=0;i<atleti.size();i++){
            if(atleti.get(i).getId().equals(id)){
                return atleti.get(i);
            }
        }
        throw  new RuntimeException("L'altleta non è presente");
    }

    @Override
    public List<Atleta> findAll() {
        return atleti;
    }

    @Override
    public Atleta save(Atleta atleta) {
        atleti.add(atleta);
        return atleta;
    }

    @Override
    public void delete(String id) {
        for(int i=0; i<atleti.size();i++){
            if(atleti.get(i).getId().equals(id)){
                atleti.remove(i);
            }
        }
    }


    @Override
    public Atleta update(String id, Atleta atleta) {
            Atleta newAtleta = findById(id);
            return newAtleta.update(atleta);
    }
}

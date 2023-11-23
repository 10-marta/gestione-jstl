package it.accenture.gara.dao.fake;

import it.accenture.gara.dao.GaraDao;
import it.accenture.gara.model.Atleta;
import it.accenture.gara.model.Gara;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GaraDaoFake implements GaraDao {

    private static final Logger logger = Logger.getLogger(GaraDao.class.getName());
    private List<Gara> gare = new ArrayList<>();

    public GaraDaoFake() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        gare.add(new Gara("162734", "Trofeo MTB Cagliari", "Cagliari", LocalDate.parse("05/11/2023", formatoData), LocalDate.parse("05/11/2023", formatoData)));
        gare.add(new Gara("152932", "Gran fondo Isola di Sant'Antioco", "Sant'Antioco", LocalDate.parse("18/10/2023", formatoData), LocalDate.parse("18/10/2023", formatoData)));
        gare.add(new Gara("166744", "1° Trofeo sa matta de ottigu", "Sarroch", LocalDate.parse("29/10/2023", formatoData), LocalDate.parse("29/10/2023", formatoData)));
        gare.add(new Gara("164901","1°Ciclocross parco dei bambini","Pabillonis",LocalDate.parse("19/11/2023",formatoData), LocalDate.parse("19/11/2023",formatoData)));
    }

    @Override
    public Gara findById(String id) {
        for (int i = 0; i < gare.size(); i++) {
            if (gare.get(i).getId_gara().equals(id)) {
                return gare.get(i);
            }
        }
        throw new RuntimeException("La gara non è presente");
    }

    @Override
    public List<Gara> findAll() {
        return gare;
    }

    @Override
    public Gara save(Gara gara) {
        gare.add(gara);
        return gara;
    }

    @Override
    public void delete(String id) {
        for (int i = 0; i < gare.size(); i++) {
            if (gare.get(i).getId_gara().equals(id)) {
                gare.remove(i);
            }
        }
    }

    @Override
    public Gara update(String id, Gara gara) {
        Gara newGara = findById(id);
        return newGara.update(gara);
    }
}

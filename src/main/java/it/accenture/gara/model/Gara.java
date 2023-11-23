package it.accenture.gara.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Gara {
    private String id_gara;
    private String denominazione;
    private String luogo;
    private LocalDate datagara;
    private LocalDate datasvoltasi;

    public Gara(String id_gara, String denominazione, String luogo, LocalDate datagara, LocalDate datasvoltasi) {
       super();
        this.id_gara = id_gara;
        this.denominazione = denominazione;
        this.luogo = luogo;
        this.datagara = datagara;
        this.datasvoltasi = datasvoltasi;
    }

    public String getId_gara() {
        return id_gara;
    }

    public void setId_gara(String id_gara) {
        this.id_gara = id_gara;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public LocalDate getDatagara() {
        return datagara;
    }

    public void setDatagara(LocalDate datagara) {
        DateTimeFormatter formatta=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.datagara = LocalDate.parse(datagara.format(formatta));
    }

    public LocalDate getDatasvoltasi() {

        return datasvoltasi;
    }

    public void setDatasvoltasi(LocalDate datasvoltasi) {
        DateTimeFormatter formatta=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.datasvoltasi=LocalDate.parse(datasvoltasi.format(formatta));
    }

    @Override
    public String toString() {
        return "Gara{" +
                "id_gara='" + id_gara + '\'' +
                ", denominazione='" + denominazione + '\'' +
                ", luogo='" + luogo + '\'' +
                ", datagara=" + datagara +
                ", datasvoltasi=" + datasvoltasi +
                '}';
    }

    public Gara update(Gara item){
        this.id_gara=item.getId_gara();
        this.denominazione=item.getDenominazione();
        this.luogo=item.getLuogo();
        this.datagara=item.getDatagara();
        this.datasvoltasi=item.getDatasvoltasi();
        return this;
    }
}

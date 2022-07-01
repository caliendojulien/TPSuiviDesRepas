package fr.afpa.suividesrepas.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
public class Repas {
    private int id;
    private Date date_repas;
    private Time heure_repas;
    private ArrayList<Aliment> aliments;

    public Repas(int id, Date date_repas, Time heure_repas) {
        this.id = id;
        this.date_repas = date_repas;
        this.heure_repas = heure_repas;
    }
}

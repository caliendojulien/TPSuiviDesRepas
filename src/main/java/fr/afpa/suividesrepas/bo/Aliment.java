package fr.afpa.suividesrepas.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Aliment {
    private int id;
    private String nom;
    private int id_repas;
}

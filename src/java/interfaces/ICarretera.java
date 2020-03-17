/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.Carretera;
import modelo.Detalle;
import modelo.Empresa;

/**
 *
 * @author Alex
 */
public interface ICarretera {
    public List<Carretera> getCarreteras();
    public Carretera getCarreteraByID(int id);
    
}

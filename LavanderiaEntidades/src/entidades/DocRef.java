/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author EDWARD-PC
 */
public class DocRef {
    private int id;
    private Ingresos ingreso;
    private TipoDoc tipoDoc;
    private String serie;
    private int numero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ingresos getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingresos ingreso) {
        this.ingreso = ingreso;
    }

    public TipoDoc getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoDoc tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public DocRef() {
    }

    public DocRef(int id, Ingresos ingreso, TipoDoc tipoDoc, String serie, int numero) {
        this.id = id;
        this.ingreso = ingreso;
        this.tipoDoc = tipoDoc;
        this.serie = serie;
        this.numero = numero;
    }
    
    
}

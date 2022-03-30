/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author EDWARD-PC
 */
public class NumeracionDocumento {
    private int NumeracionDocumentoId;
    private TipoDoc tipodoc;
    private String serie;
    private int ultimoNumero;
    private String estado;

    public NumeracionDocumento() {
    }

    public NumeracionDocumento(int NumeracionDocumentoId, TipoDoc tipodoc, String serie, int ultimoNumero, String estado) {
        this.NumeracionDocumentoId = NumeracionDocumentoId;
        this.tipodoc = tipodoc;
        this.serie = serie;
        this.ultimoNumero = ultimoNumero;
        this.estado = estado;
    }

    
    
    public int getNumeracionDocumentoId() {
        return NumeracionDocumentoId;
    }

    public void setNumeracionDocumentoId(int NumeracionDocumentoId) {
        this.NumeracionDocumentoId = NumeracionDocumentoId;
    }

    public TipoDoc getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(TipoDoc tipodoc) {
        this.tipodoc = tipodoc;
    }

    
    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getUltimoNumero() {
        return ultimoNumero;
    }

    public void setUltimoNumero(int ultimoNumero) {
        this.ultimoNumero = ultimoNumero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}

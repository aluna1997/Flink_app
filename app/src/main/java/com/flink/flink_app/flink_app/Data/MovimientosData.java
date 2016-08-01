package com.flink.flink_app.flink_app.Data;

/**
 * Created by felipe on 1/08/16.
 */
public class MovimientosData {
    private String establecimiento;
    private Integer valor;
    private String dia;


    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public MovimientosData(String establecimiento, Integer valor, String dia) {
        this.establecimiento = establecimiento;
        this.valor = valor;
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "MovimientosData{" +
                "establecimiento='" + establecimiento + '\'' +
                ", valor=" + valor +
                ", dia='" + dia + '\'' +
                '}';
    }


}

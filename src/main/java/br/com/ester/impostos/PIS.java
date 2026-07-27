/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ester.impostos;

/**
 * Representa o PIS, calculado com base na diferença entre
 * o valor total de débito e o valor total de crédito da empresa.
 *
 * @author Ester Teixeira
 */
public class PIS implements Imposto {

    private double valorDebito;
    private double valorCredito;

    /*
     * A alíquota do PIS é fixa em 1,65%.
     * Em cálculos, 1,65% corresponde ao valor decimal 0,0165.
     */
    private static final double ALIQUOTA = 0.0165;

    /**
     * Inicializa os valores de débito e crédito utilizados
     * no cálculo do imposto.
     */
    public PIS(double valorDebito, double valorCredito) {
        this.valorDebito = valorDebito;
        this.valorCredito = valorCredito;
    }

    public double getValorDebito() {
        return valorDebito;
    }

    public void setValorDebito(double valorDebito) {
        this.valorDebito = valorDebito;
    }

    public double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }

    /**
     * Calcula o PIS aplicando a alíquota de 1,65% sobre
     * a diferença entre o débito e o crédito.
     */
    @Override
    public double calcularImposto() {
        double baseCalculo = valorDebito - valorCredito;
        return baseCalculo * ALIQUOTA;
    }

    /**
     * Retorna a descrição usada para identificar o imposto.
     */
    @Override
    public String getDescricao() {
        return "PIS";
    }
}

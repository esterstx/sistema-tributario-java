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
public class IPI implements Imposto {

    private double aliquota;
    private double valorProduto;
    private double valorFrete;
    private double valorSeguro;
    private double outrasDespesas;

    /**
     * Inicializa os valores necessários para o cálculo do IPI.
     */
    public IPI(
            double aliquota,
            double valorProduto,
            double valorFrete,
            double valorSeguro,
            double outrasDespesas) {

        this.aliquota = aliquota;
        this.valorProduto = valorProduto;
        this.valorFrete = valorFrete;
        this.valorSeguro = valorSeguro;
        this.outrasDespesas = outrasDespesas;
    }

    public double getAliquota() {
        return aliquota;
    }

    public void setAliquota(double aliquota) {
        this.aliquota = aliquota;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public double getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public double getOutrasDespesas() {
        return outrasDespesas;
    }

    public void setOutrasDespesas(double outrasDespesas) {
        this.outrasDespesas = outrasDespesas;
    }

    /**
     * Soma os valores que formam a base de cálculo do IPI.
     */
    public double calcularBaseCalculo() {
        return valorProduto
                + valorFrete
                + valorSeguro
                + outrasDespesas;
    }

    /**
     * Calcula o IPI aplicando a alíquota informada
     * sobre a base de cálculo.
     */
    @Override
    public double calcularImposto() {
        double baseCalculo = calcularBaseCalculo();
        return baseCalculo * aliquota / 100;
    }

    /**
     * Retorna o nome do imposto para identificação na listagem.
     */
    @Override
    public String getDescricao() {
        return "IPI";
    }
}
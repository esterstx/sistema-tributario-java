/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ester.impostos;

import java.util.ArrayList;

/**
 * Representa os pagamentos de impostos de uma empresa.
 *
 * A classe mantém uma única lista capaz de armazenar diferentes
 * tipos de impostos que implementem a interface Imposto.
 *
 * @author Ester Teixeira
 */
public class Pagamentos {

    private String nomeEmpresa;
    private ArrayList<Imposto> impostos;

    /**
     * Inicializa o nome da empresa e cria a lista de impostos.
     */
    public Pagamentos(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
        this.impostos = new ArrayList<>();
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public ArrayList<Imposto> getImpostos() {
        return impostos;
    }

    public void setImpostos(ArrayList<Imposto> impostos) {
        this.impostos = impostos;
    }

    /**
     * Adiciona um imposto à lista de pagamentos da empresa.
     *
     * Como o parâmetro é do tipo Imposto, o método pode receber
     * objetos PIS, IPI e outros impostos criados futuramente.
     */
    public void adicionarImposto(Imposto imposto) {
        impostos.add(imposto);
    }

    /**
     * Mostra a descrição e o valor calculado de todos os impostos.
     */
    public void mostrarImpostos() {

        System.out.println();
        System.out.println("===== IMPOSTOS DA EMPRESA =====");
        System.out.println("Empresa: " + nomeEmpresa);

        if (impostos.isEmpty()) {
            System.out.println("Nenhum imposto foi cadastrado.");
            return;
        }

        for (Imposto imposto : impostos) {

            System.out.println("--------------------------------");

            System.out.println(
                    "Imposto: " + imposto.getDescricao()
            );

            System.out.printf(
                    "Valor calculado: R$ %.2f%n",
                    imposto.calcularImposto()
            );
        }

        System.out.println("--------------------------------");
    }
}
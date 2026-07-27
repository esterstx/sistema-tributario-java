/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ester.impostos;

/**
 * Define os comportamentos obrigatórios para todos os impostos
 * cadastrados no sistema.
 *
 * Como cada imposto possui dados e fórmulas diferentes, a interface
 * estabelece somente as operações que todos precisam oferecer.
 *
 * @author Ester Teixeira
 */
public interface Imposto {
    /**
     * Calcula o valor do imposto conforme a regra específica
     * de cada classe.
     *
     * @return valor calculado do imposto
     */
   double calcularImposto();
    /**
     * Retorna o nome utilizado para identificar o imposto.
     *
     * @return descrição do imposto
     */
    String getDescricao();
}

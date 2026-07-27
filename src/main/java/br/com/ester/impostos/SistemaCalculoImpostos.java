/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.ester.impostos;

import java.util.Scanner;

/**
 * Classe principal responsável pelo cadastro da empresa
 * e dos impostos que deverão ser pagos.
 *
 * @author Ester Teixeira
 */
public class SistemaCalculoImpostos {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("===== SISTEMA DE CALCULO DE IMPOSTOS =====");

        System.out.print("Nome da empresa: ");
        String nomeEmpresa = entrada.nextLine();

        /*
         * O objeto Pagamentos mantém o nome da empresa e uma única
         * lista capaz de armazenar diferentes tipos de impostos.
         */
        Pagamentos pagamentos = new Pagamentos(nomeEmpresa);

        /*
         * A repetição não possui uma quantidade fixa de cadastros.
         * Ela será encerrada somente quando o usuário digitar "pare".
         */
        while (true) {

            System.out.println();
            System.out.println("Tipos disponíveis:");
            System.out.println("PIS");
            System.out.println("IPI");
            System.out.println("Digite \"pare\" para finalizar.");
            System.out.print("Informe o tipo de imposto: ");

            String tipoImposto = entrada.nextLine().trim();

            if (tipoImposto.equalsIgnoreCase("pare")) {
                break;
            }

            switch (tipoImposto.toUpperCase()) {

                case "PIS":

                    System.out.println();
                    System.out.println("===== CADASTRO DO PIS =====");

                    double valorDebito = lerValorPositivo(
                            entrada,
                            "Valor total de debito: R$ "
                    );

                    double valorCredito = lerValorPositivo(
                            entrada,
                            "Valor total de credito: R$ "
                    );

                    PIS pis = new PIS(
                            valorDebito,
                            valorCredito
                    );

                    pagamentos.adicionarImposto(pis);

                    System.out.println(
                            "PIS cadastrado com sucesso."
                    );

                    break;

                case "IPI":

                    System.out.println();
                    System.out.println("===== CADASTRO DO IPI =====");

                    double aliquota = lerValorPositivo(
                            entrada,
                            "Aliquota do IPI (%): "
                    );

                    double valorProduto = lerValorPositivo(
                            entrada,
                            "Valor do produto: R$ "
                    );

                    double valorFrete = lerValorPositivo(
                            entrada,
                            "Valor do frete: R$ "
                    );

                    double valorSeguro = lerValorPositivo(
                            entrada,
                            "Valor do seguro: R$ "
                    );

                    double outrasDespesas = lerValorPositivo(
                            entrada,
                            "Outras despesas: R$ "
                    );

                    IPI ipi = new IPI(
                            aliquota,
                            valorProduto,
                            valorFrete,
                            valorSeguro,
                            outrasDespesas
                    );

                    pagamentos.adicionarImposto(ipi);

                    System.out.println(
                            "IPI cadastrado com sucesso."
                    );

                    break;

                default:

                    System.out.println(
                            "Tipo invalido. Digite PIS, IPI ou pare."
                    );
            }
        }

        /*
         * Independentemente do tipo real de cada objeto, a classe
         * Pagamentos mostra a descrição e calcula todos os impostos.
         */
        pagamentos.mostrarImpostos();

        entrada.close();
    }

    /**
     * Lê um número e impede que o programa seja encerrado caso
     * o usuário deixe o campo vazio ou digite um valor inválido.
     */
    private static double lerValorPositivo(
            Scanner entrada,
            String mensagem) {

        while (true) {

            System.out.print(mensagem);

            String valorDigitado = entrada
                    .nextLine()
                    .trim()
                    .replace(",", ".");

            if (valorDigitado.isEmpty()) {
                System.out.println(
                        "O campo não pode ficar vazio."
                );
                continue;
            }

            try {

                double valor = Double.parseDouble(valorDigitado);

                if (valor < 0) {
                    System.out.println(
                            "O valor não pode ser negativo."
                    );
                    continue;
                }

                return valor;

            } catch (NumberFormatException erro) {

                System.out.println(
                        "Digite somente um valor numerico."
                );
            }
        }
    }
}
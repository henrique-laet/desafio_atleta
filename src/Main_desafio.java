import java.util.Locale;
import java.util.Scanner;

public class Main_desafio {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int x, quantidadeAtletasF = 0,  quantidadeAtletasM = 0;
        double altura, peso, alturaMedia, porcentagemHomem = 0, somaAltura = 0, quantidadeAtleta = 0,
        somaPeso = 0,  pesoMedio, atletaMaisAlto = 0;
        String nome, nomeAtletaMaisAlto = "";

        System.out.print("Qual a quantidade de atletas? ");
        x = sc.nextInt();

        for (int i = 1; i <= x; i++) {
            System.out.println("Digite os dados do atleta numero " + i);

            System.out.print("Nome: ");
            nome = sc.next();

            System.out.print("Digite o sexo: ");
            char sexo = sc.next().charAt(0);
            do {
                if (sexo != 'F' && sexo != 'M') {
                    System.out.print("Valor invalido! Favor digitar F ou M: ");
                    sexo = sc.next().charAt(0);
                }
            }while (sexo != 'F' && sexo != 'M');


            System.out.print("Altura:");
            do {
                altura = sc.nextDouble();
                if (altura <= 0) {
                    System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                }
            } while (altura <=0);


            if (altura > atletaMaisAlto) {
                atletaMaisAlto = altura;
                nomeAtletaMaisAlto = nome;
            }

            System.out.print("Peso:");
            do {
                peso = sc.nextDouble();
                if (peso <= 0) {
                    System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                } else {
                    quantidadeAtleta++;
                    somaPeso += peso;

                }
            } while (peso <=0);


            if (sexo == 'F') {
                quantidadeAtletasF++;
                somaAltura += altura;

            } else if (sexo == 'M') {
                quantidadeAtletasM++;
            }

        }

        pesoMedio  = somaPeso / quantidadeAtleta;
        porcentagemHomem = ((double) quantidadeAtletasM / x) * 100;
        alturaMedia = somaAltura / quantidadeAtletasF;

        System.out.println();
        System.out.println("RELATÓRIO:");

        System.out.printf("Peso médio dos atletas:  %.2f%n", pesoMedio);
        System.out.println("Atleta mais alto: " + nomeAtletaMaisAlto);
        System.out.printf("Porcentagem de homens: %.1f %%%n", porcentagemHomem);

        if (quantidadeAtletasF <=0) {
            System.out.println("Não há mulheres cadastradas");
        } else {
            System.out.printf("Altura média das mulheres:  %.2f%n", alturaMedia);
        }

        sc.close();
    }
}

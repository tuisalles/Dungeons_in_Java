
package Dunegons_In_Java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, java.nio.charset.StandardCharsets.UTF_8);
        String nomeDigitado;
        int resposta = 0;

        
        //menu
        do {
        System.out.println("******************************");
        System.out.println("       DUNGEONS IN JAVA       ");
        System.out.println("******************************");
        System.out.println("1 - Novo Jogo.");
        System.out.println("2 - Sair.");
        
        System.out.print("Escolha uma opção: ");
        resposta = scanner.nextInt();
        scanner.nextLine();
        
            //escolhas
            switch (resposta) {
                case 1:                      
                    System.out.println("Bem-vindo, herói! ");
                    System.out.print("Insira o seu nome: ");
                    nomeDigitado = scanner.nextLine();                   
                    Heroi heroi = new Heroi(nomeDigitado);   //criando um Heroi em objeto Heroi e colocando o nome digitado como nome desse Heroi.
                                                       
                    System.out.println("\nIniciando a sua jornada...\n");
                      
                    while (heroi.estaVivo()) {
                    
                        String dungeonAtual = Dungeons.dungeon();    // puxando o metodo de sorteio de dungeons e estabelendo a nova variavel do sorteio no main.                    
                        System.out.println(heroi.getNome() + ", você chegou na " + dungeonAtual);

                        Inimigo inimigo = Gerador_Inimigos.sortearInimigo();     // criando um inimigo novo a partir do sorteio, e colocando esse inimigo sorteado como um novo objeto inimigo.
                        System.out.println("De repente, um monstro apareceu!\n");
                        System.out.println("Nome: " + inimigo.getNome() + ".");
                        System.out.println("HP: " + inimigo.getHp() + ".\n");

                        while (heroi.estaVivo() && inimigo.estaVivo()) {
                            System.out.println("⚔️ SEU TURNO:");
                            System.out.println(heroi.getNome() + " HP: " + heroi.getHp() + " | " + inimigo.getNome() + " HP: " + inimigo.getHp());
                            System.out.println("Escolha o seu ataque: ");
                            System.out.println("1 - Ataque leve   (Mais fácil de acertar, menos dano)");
                            System.out.println("2 - Ataque pesado (Mais difícil de acertar, mais dano)");
                            System.out.print("O que você faz? ");
                            int tipoAtaque = scanner.nextInt();
                            scanner.nextLine();

                            int ataqueHeroi = 0;

                            switch (tipoAtaque) {
                                case 1 -> ataqueHeroi = heroi.ataqueLeve();
                                case 2 -> ataqueHeroi = heroi.ataquePesado();
                                default -> System.out.println("Você se atrapalhou e perdeu a chance!");
                            }

                            if (ataqueHeroi > 0) {
                                System.out.println("Você acertou! Causou " + ataqueHeroi + " de dano no " + inimigo.getNome() + "!");
                                inimigo.receberDano(ataqueHeroi);
                            } else {
                                System.out.println("Que pena, você errou o golpe!");
                            }

                            if (!inimigo.estaVivo()) {
                                break;
                            }

                            System.out.println("\n👾 TURNO DO INIMIGO:");
                            System.out.println("O " + inimigo.getNome() + " te acatou.");

                            int ataqueInimigo = inimigo.ataqueInimigo();

                            if (ataqueInimigo > 0) {
                                System.out.println(inimigo.getNome() + " te acertou, e te causou " + ataqueInimigo + " de dano!\n");
                                heroi.receberDano(ataqueInimigo);
                            } else {
                                System.out.println("Você conseguiu se esquivar!\n");
                            }

                        }    
                        if (heroi.estaVivo()) {
                            System.out.println("\nParabéns! Você derrou um " + inimigo.getNome());
                            System.out.println("Prossiga para a próxima dungeon!\n");
                        } else {
                            System.out.println("Você foi derrotado por um " + inimigo.getNome() + "!");
                            System.out.println("GAME OVER!\n");
                        }
                    }  
                break;    
                   
               case 2:
                    System.out.println("Obrigado por jogar!");
                break;

                default:
                    System.out.println("Erro 101: Opção inválida.");
                break;
            }
               
        } while (resposta != 2);
        scanner.close();   
             
    }
    
}


package Dunegons_In_Java;

import java.util.Random;

public class Inimigo {
    
    private String nome;
    private int hp;
    private int ataque;
    
    private static final Random random = new Random();   
    
        public Inimigo(String nome, int hp, int ataque) {
            this.nome = nome;
            this.hp = hp;
            this.ataque = ataque;
        }
        
        public int ataqueInimigo() {
        int acerto = random.nextInt(100);
            if (acerto < 60) {
                return this.ataque;
            } else {
                return 0;
            }
        }
                       
        public void receberDano(int quantidade) {
            this.hp -= quantidade;
            if (this.hp < 0) {
                this.hp = 0;
            }
        }
        
        public boolean estaVivo() {
            return this.hp > 0;
        }
        
        public String getNome() { return nome; }
        public int getHp() { return hp; }
        public int getAtaque() { return ataque; }
    
}
















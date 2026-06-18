
package Dunegons_In_Java;

import java.util.Random;

public class Heroi {
    
    private String nome;
    private int hp;
    private static final Random random = new Random();
    
        public Heroi(String nome) {
            this.nome = nome;
            this.hp = 100;
        }
               
        public int ataqueLeve() {
        int acerto = random.nextInt(100);
            if (acerto < 90) {
                return 40;
            } else {
                return 0;
            }
        }
        
        public int ataquePesado() {
        int acerto = random.nextInt(100);
            if (acerto < 60) {
                return 80;
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

}





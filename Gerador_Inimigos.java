
package Dunegons_In_Java;

import java.util.Random;

public class Gerador_Inimigos {
    
    private static final Random random = new Random();
    
    public static Inimigo sortearInimigo() {
            
        int escolha= random.nextInt(5);
            
        switch (escolha) {
            case 0 -> {return new Inimigo("Espectro das Correntes", 100, 20);}
            case 1 -> {return new Inimigo("Guardião de Pedra", 100, 25);}
            case 2 -> {return new Inimigo("Rastejante da Névoa", 100, 5);}
            case 3 -> {return new Inimigo("Vulto das Lâminas", 100, 15);}
            default -> {return new Inimigo("Sentinela Espectral", 100, 40);}      // pra não ficar sem return, usar um deles como default.
            }
    } 
}

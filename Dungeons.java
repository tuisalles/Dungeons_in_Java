
package Dunegons_In_Java;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

public class Dungeons {
    
    private static final String[] TEXTO_DUNGEON = {"""
                            Sala das Sombras 
                            As tochas tremeluzem, revelando paredes cobertas por musgo e um silêncio opressor;
                            no centro, um altar de pedra quebrado guarda marcas de antigos rituais, enquanto 
                            ratos correm entre ossos espalhados pelo chão.                     
                            """,  
                            """
                            Câmara do Eco Perdido  
                            Cada passo reverbera como se algo invisível o acompanhasse; pilares altos sustentam o teto,
                            e entre eles há urnas rachadas e pedaços de tapeçarias antigas, onde figuras desbotadas 
                            parecem ganhar vida sob a luz fraca.                            
                            """,
                            """
                            Galeria das Correntes  
                            Correntes enferrujadas pendem do teto, rangendo ao menor movimento; algumas ainda prendem 
                            esqueletos em posição de súplica, e o chão de pedra está marcado por arranhões profundos, 
                            como se garras tivessem tentado escapar.
                            """,
                            """
                            Cripta da Névoa Antiga  
                            Uma névoa densa cobre o chão, escondendo armadilhas e segredos; sarcófagos de pedra
                            se alinham nas paredes, e símbolos gravados brilham fracamente, emitindo um calor estranho
                            que contrasta com o frio da sala.
                            """,
                            """
                            Sala do Guardião Esquecido  
                            Estátuas rachadas observam em silêncio, como se esperassem despertar; entre elas, há escudos
                            enferrujados e lanças quebradas, e o som distante de água pingando ecoa, sugerindo uma
                            passagem oculta atrás das paredes.
                            """
                            };
    
    private static final Queue<Integer> historicoIndices = new LinkedList<>();
    private static final Random random = new Random();
    private static final int ESPACO_MEMORIA = 2;
    
     
    public static String dungeon() {
        
        int indiceDungeon;
        
        do {
            indiceDungeon = random.nextInt(TEXTO_DUNGEON.length);
        } while (historicoIndices.contains(indiceDungeon));
                
        historicoIndices.add(indiceDungeon);

        if (historicoIndices.size() > ESPACO_MEMORIA) {
            historicoIndices.poll();
        }
                      
        return TEXTO_DUNGEON[indiceDungeon];
           
    }
}
















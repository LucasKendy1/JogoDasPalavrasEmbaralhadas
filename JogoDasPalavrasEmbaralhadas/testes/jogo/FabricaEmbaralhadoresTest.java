package jogo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class FabricaEmbaralhadoresTest {
    private BancoDePalavras bancoDePalavras;
    private FabricaEmbaralhadores fabricaEmbaralhadores;

    @Before
    public void setUp() throws FileNotFoundException {
       
        bancoDePalavras = new BancoDePalavras(); 
        fabricaEmbaralhadores = new FabricaEmbaralhadores(bancoDePalavras);
        bancoDePalavras.sorteaPalavra();
    }

    @Test
    public void testSorteaEmbaralhador() {
        boolean result = fabricaEmbaralhadores.sorteaEmbaralhador();
        assertNotNull(result);
    }

    @Test
    public void testEmbaralhaPalavra() {
        String palavraEmbaralhada = fabricaEmbaralhadores.embaralhaPalavra();
        assertNotNull(palavraEmbaralhada);
        
    }

  

    @Test
    public void testEmbaralhador1() {
        String palavraEmbaralhada = fabricaEmbaralhadores.embaralhador1();
        assertNotNull(palavraEmbaralhada);
        
    }

    @Test
    public void testEmbaralhador2() {
        String palavraEmbaralhada = fabricaEmbaralhadores.embaralhador2();
        assertNotNull(palavraEmbaralhada);
       
    }
}

import static org.junit.jupiter.api.Assertions.*;

class AnuncioTest {

    @org.junit.jupiter.api.Test
    public void calculaViews() {
        Anuncio anuncio = new Anuncio();
        anuncio.setVerba(1);
        anuncio.calculaViews();
        assertEquals(30,anuncio.getViews());
    }
}
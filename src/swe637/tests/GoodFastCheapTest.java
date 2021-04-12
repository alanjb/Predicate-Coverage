import org.junit.Before;
import org.junit.Test;
import swe637.GoodFastCheap;

import static org.junit.Assert.*;

/*
* f ^ c: {FTT, FTF, FFT}
* g ^ c: {TFT, TFF, F*T}
* g ^ f: {TTF, TF*, FT*}
*
* TR: {TTF, TFF, TFT, FFT, FTF, FTT}
* */

public class GoodFastCheapTest {
    GoodFastCheap gfc;

    @Before
    public void setUp(){
        gfc = new GoodFastCheap();
    }

    @Test
    public void test_Good_Fast__TTF(){
        gfc.makeGood();
        gfc.makeFast();

        assertTrue(gfc.isSatisfactory());
    }

    @Test
    public void test_Good_Cheap__TFF(){
        gfc.makeGood();

        assertFalse(gfc.isSatisfactoryRefactored());
    }

    @Test
    public void test_Fast_Cheap__FTF() throws Exception{
        gfc.makeFast(); //FTF

        assertFalse(gfc.isSatisfactoryRefactored());
    }

    @Test
    public void test_Good_Cheap__TFT() throws Exception {
        gfc.makeGood();
        gfc.makeCheap();

        assertTrue(gfc.isSatisfactory());
    }

    @Test
    public void test_Good_Cheap__FFT() throws Exception {
        gfc.makeCheap();

        assertFalse(gfc.isSatisfactory());
    }

    @Test
    public void test_Fast_Cheap__FTT(){
        gfc.makeFast();  // FTF
        gfc.makeCheap(); // FTT

        assertTrue(gfc.isSatisfactoryRefactored());
    }
}
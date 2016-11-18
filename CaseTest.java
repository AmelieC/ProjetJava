/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author christophe
 */
public class CaseTest {
    
    static Case caseDeTest;
    
    @BeforeClass
    public static void setUpClass() {
        caseDeTest = new Case(13,14);
    }
    
    @AfterClass
    public static void tearDownClass() {
        caseDeTest = null;
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
   
   
    @Test
    public void testGetCoordonneeX(){
        assertEquals(9, caseDeTest.getCoordonneeX());
    }
    @Test
    public void testGetCoordonneeY(){
        assertEquals(10, caseDeTest.getCoordonneeY());
    }
    @Test
    public void testEstUtilisée(){
        assertEquals(false, caseDeTest.estUtilisee());
    }
    @Test
    public void testEstDetruite(){
        assertEquals(false, caseDeTest.estDetruite());
    }
     @Test
    public void testSetCoordonneeX(){
        caseDeTest.setCoordonneeX(9);
        assertEquals(9, caseDeTest.getCoordonneeX());
    }
    @Test
    public void testSetCoordonneeY(){
        caseDeTest.setCoordonneeY(10);
        assertEquals(10, caseDeTest.getCoordonneeY());
    }
    @Test
    public void testSetEstUtilisée(){
        caseDeTest.setEstUtilisee(true);
        assertEquals(true, caseDeTest.estUtilisee());
    }
    @Test
    public void testSetEstDetruite(){
        caseDeTest.setEstDetruite(true);
        assertEquals(true, caseDeTest.estDetruite());
    }
    
}

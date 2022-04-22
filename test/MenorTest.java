/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import controladores.MenorJpaController;
import entidades.Menor;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Yorch
 */
public class MenorTest {
    
    public MenorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
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

    @Test
    public void hello() {
        Menor menor = new Menor();
        menor.setApellido("Favore");
        menor.setDni("300000");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
        MenorJpaController mjc = new MenorJpaController(emf);
        mjc.create(menor);
    }
}

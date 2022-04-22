/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import controladores.ExpedienteJpaController;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import entidades.Menor;
import java.util.List;
import java.util.ArrayList;
import entidades.Expediente;
import facades.MenorFacade;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yorch
 */
public class ExpedienteTest {
    
    public ExpedienteTest() {
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
         List<Menor> listaMenores = new ArrayList();
         Menor menor = new Menor();
         MenorFacade menorFacade = new MenorFacade();
         listaMenores = menorFacade.getTodos();
         Expediente expediente = new Expediente();
         expediente.setMenor(listaMenores);
         expediente.setAnio("2010");
         expediente.setNumero(224);
         expediente.setArchivado(true);
                 EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
        ExpedienteJpaController ejc = new ExpedienteJpaController(emf);
        ejc.create(expediente);
         
     }
}

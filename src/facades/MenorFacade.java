/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import controladores.MenorJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Menor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Yorch
 */
public class MenorFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("menoresJPAPU");
    EntityManager em = emf.createEntityManager();
    MenorJpaController menorJpaController = new MenorJpaController(emf);
    
    public void altaMenor(Menor menor) {
        menorJpaController.create(menor);
    }
    
    public boolean modificarMenor(Menor menor) {
        try {
            menorJpaController.edit(menor);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MenorFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(MenorFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean eliminarMenor(Long id) {
        try {
            menorJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MenorFacade.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public Menor buscar(Long id) {
        return menorJpaController.findMenor(id);
    }
    
    public Menor buscarPorApellidoNombre(String apeNomMenor) {  //devuelve como resultado un solo menor
        String[] apeNom = apeNomMenor.split(", ");
        Query quMenor = em.createQuery("SELECT p FROM Persona p WHERE p.apellido ='" + apeNom[0] + "' AND p.nombre ='" + apeNom[1] + "'");
        return (Menor)quMenor.getSingleResult();
    }
    
    public List<Menor> buscarXApellidoNombre(String apeNomMenor) { //resultado posible: varios menores
        String[] apeNom = {};
        if (apeNomMenor.contains(", ")) {
            apeNom = apeNomMenor.split(", ");
        } else if (apeNomMenor.contains(",")) {
            apeNom = apeNomMenor.split(",");
        }
        Query quMenor = em.createQuery("SELECT p FROM Persona p WHERE p.apellido ='" + apeNom[0] + "' AND p.nombre ='" + apeNom[1] + "'");
        return quMenor.getResultList();
    }
    
    public Menor getMenor(int numero, String año){
        Query quMenor = em.createQuery("SELECT p FROM Persona p WHERE p.expediente.numero =" + numero + " AND p.Expediente.año ='" + año + "'");
        return (Menor)quMenor.getSingleResult();
    }
    
    public List<Menor> getMenoresPorExpediente(String expediente) {
        String[] expte = expediente.split("/");
        if (expte[1].startsWith("9")) { //expte[1] son los dos últimos dígitos del año "----"
            expte[1] = "19" + expte[1]; //si comienza con 9 --> "--9-" => 199?
        } else { // si comienza con otro número 0 o 1
            expte[1] = "20" + expte[1]; // => 200?  o  => 201?
        }
        Query quMenores = em.createQuery("SELECT m FROM Menor m WHERE m.expediente.numero ='" + Integer.parseInt(expte[0]) + "' AND m.expediente.año ='" + expte[1] + "'");
        return quMenores.getResultList();
    }
    
    public List<Menor> getTodos(){
        Query quMenores = em.createQuery("SELECT m FROM Menor m");
        return quMenores.getResultList();
    }
    
    public int[] calcularPorcentajes() {
        int[] resultados = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};//null;
        int cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0, cont5 = 0, cont6 = 0, cont7 = 0, cont8 = 0, cont9 = 0, cont10 = 0, cantMenores = 0;
        boolean vueltaA = true, vueltaT = true, separado = false, asisteEscuela = true, tieneTrabajo = false, flagPadre = false, flagMadre = false, flagTio = false, flagTia = false, flagAbuelo = false, flagAbuela = false;
        Query quMenores = em.createQuery("SELECT m FROM Menor m");
        List<Menor> menores = quMenores.getResultList();
        List<String> grupoConv = null;
        for (Menor menor : menores) { //recorro todos los menores dados de alta
            try {
                grupoConv = menor.getGrupoConvivencia().getGrupoConvivencia(); //obtengo la lista de grupo de convivencia
                for (String grupo : grupoConv) { //recorro sus grupos de convivencia
                    if (grupo.equals("No tiene padre ni padrastro.")) { //y cuento cada posibilidad de grupo de convivencia
                        cont1++;
                        flagPadre = true; //marco que no tiene padre
                    }
                    if (grupo.equals("No tiene madre ni madrastra.")) {
                        cont2++;
                        if (flagPadre) {
                            flagMadre = true;  //si no tiene padre ni madre, quizas convive con abuel@
                        }
                    }
                    if (grupo.startsWith("Instituto de Menores ")) {
                        cont6++;
                    }
                    if (grupo.equals("Tio: Si")) {
                        cont7++;
                        flagTio = true;
                        vueltaT = false; //me indica que si vive con al menos el tio, no tengo en cuenta a la tia
                    } else { //al no vivir con el tio pregunto si vive con tia
                        if (grupo.equals("Tia: Si")) {
                            if (vueltaT) {
                                cont7++; //si esta condición es falsa, no sumo xq vive con tio
                            }
                            flagTia = true;
                        }
                    }
                    if (grupo.equals("Abuelo: Si")) {
                        if (flagPadre && flagMadre && flagTio && flagTia) {
                            cont8++;
                        }
                        flagAbuelo = false;
                        vueltaA = false;
                    }
                    if (grupo.equals("Abuela: Si")) {
                        if (vueltaA) {
                            if (flagPadre && flagMadre && flagTio && flagTia) {
                                cont8++;
                            }
                        }
                    }
                    if (grupo.equals("Padrastro")) {
                        separado = true; //vive con madre y padrastro
                    }
                    if (grupo.equals("Madrastra")) {
                        separado = true; //convive con padre y madrastra
                    }
                }
                if (menor.getEscolaridad().equals("No")) {
                    cont3++;
                    asisteEscuela = false;
                }
                if (menor.getTrabajo().equals("Si")) {
                    cont4++;
                    tieneTrabajo = true;
                }
                if (menor.getConsumoEstupefacientes().toString() != null) {
                    cont5++;
                    if (asisteEscuela) {
                        cont10++;
                    }
                }
            } catch (java.lang.NullPointerException ex) {
//                return resultados;
            }
            if (asisteEscuela && tieneTrabajo) {
                cont9++;
            }
            if (separado) {
                cont10++; //el menor convive con uno de los padres y su pareja
            }
            cantMenores++;
            vueltaT = true; vueltaA = true; separado = false; asisteEscuela = true; tieneTrabajo = false; flagPadre = false; flagMadre = false; flagTio = false; flagTia = false;
        }
        try {
            resultados[0] = (cont1 * 100) / cantMenores;
            resultados[1] = (cont2 * 100) / cantMenores;
            resultados[2] = (cont3 * 100) / cantMenores;
            resultados[3] = (cont4 * 100) / cantMenores;
            resultados[4] = (cont5 * 100) / cantMenores;
            resultados[5] = (cont6 * 100) / cantMenores;
            resultados[6] = (cont7 * 100) / cantMenores;
            resultados[7] = (cont8 * 100) / cantMenores;
            resultados[8] = (cont9 * 100) / cantMenores;
            resultados[9] = (cont10 * 100) / cantMenores;
        } catch (java.lang.ArithmeticException ex) {
            return resultados; //con valores = 0 en cada posición
        }
        return resultados;
    }
}

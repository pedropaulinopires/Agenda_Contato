package dao;

import bean.Contato;
import java.util.ArrayList;
import javax.persistence.EntityManager;

public class ContatoDAO {
    /**
     * 
     * metodo para adicionar Contato
     * 
     * @param c
     **/
    public static void adicionarContato(Contato c){
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro de inserir Contato no banco ==>> "+e.getMessage());
        } finally {
            em.close();
        }
    }
    
    /**
     * 
     * metodo para remover Contato
     * 
     * @param c
    **/
    public static void removerContato(Contato c){
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.getTransaction().begin();
            em.remove(em.getReference(Contato.class, c.getId()));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro de remover Contato ==>> " +e.getMessage());
        } finally {
            em.close();
        }
    }
    /**
     * 
     * metodo para atualizar Contato
     * 
     *
     * @param c */
    public static void atualizarContato(Contato c){
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro de atualizar Contato ==>> "+e.getMessage());
        } finally {
            em.close();
        }
    }
    
    /**
     * 
     * metodo para busca de Contato por id
     * 
     * @param id
     * @return 
    **/
    public static Contato buscarContatoId(long id){
        Contato c = null;
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.find(Contato.class, id);
        } catch (Exception e) {
            System.out.println("Erro de buscar Contato por id ==>> "+e.getMessage());
        } finally {
            em.close();
        }
        return c;
    }
    
    /**
     * 
     * metodo para listar todos os Contato
     * 
     *
     * @return lista de Contato  */
    public static ArrayList<Contato> listarTodosContato(){
        ArrayList<Contato> l = new ArrayList<>();
        EntityManager em = ConnectionFactory.getConnection();
        try {
            l = (ArrayList<Contato>) em.createQuery("from Contato c").getResultList();
        } catch (Exception e) {
            System.out.println("Erro de listagem de todos os Contato ==>> "+e.getMessage());
        } finally {
            em.close();
        }
        return l;
    }
    /**
     * 
     * metodo para buscar todos os contatos pelo id do login
     * 
     * @param id
     * @return 
     **/
    public static ArrayList<Contato> buscarContatosPorIdLogin(long id){
        ArrayList<Contato> c = new ArrayList<>();
        EntityManager em = ConnectionFactory.getConnection();
        try {
            c = (ArrayList<Contato>) em.createQuery("select c from Contato as c where c.login.id = :id ")
                    .setParameter("id", id).getResultList();
        } catch (Exception e) {
            System.out.println("Erro de buscar contato por id do login ==>> "+e.getMessage());
        } finally {
            em.close();
        }
        return c;
    }
    /***
     * 
     * metodo pra limpar lista de Contato por id de login
     * 
     * @param id
     */
    public static void limparContatosPorIdLogin(long id){
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.getTransaction().begin();
            em.createQuery("delete from Contato where login_id = :id").setParameter("id", id).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro de limpar Contatos por id login ==>> "+e.getMessage());
        } finally {
            em.close();
        }
    }
     
    
}

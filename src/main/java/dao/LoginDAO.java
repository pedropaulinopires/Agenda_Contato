/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Login;
import java.util.ArrayList;
import javax.persistence.EntityManager;

/**
 *
 * @author Usuario
 */
public class LoginDAO {
    /**
     * 
     * metodo para adicionar login
     * 
     * @param l
     **/
    public static void adicionarLogin(Login l){
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro de inserir Login no banco ==>> "+e.getMessage());
        } finally {
            em.close();
        }
    }
    
    /**
     * 
     * metodo para remover login
     * 
     * @param l
    **/
    public static void removerLogin(Login l){
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.getTransaction().begin();
            em.remove(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro de remover login ==>> "+e.getMessage());
        } finally {
            em.close();
        }
    }
    /**
     * 
     * metodo para atualizar login
     * 
     *
     * @param l */
    public static void atualizarLogin(Login l){
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.getTransaction().begin();
            em.merge(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro de atualizar login ==>> "+e.getMessage());
        } finally {
            em.close();
        }
    }
    
    /**
     * 
     * metodo para busca de login por id
     * 
     * @param id
     * @return 
    **/
    public static Login buscarLoginId(long id){
        Login l = null;
        EntityManager em = ConnectionFactory.getConnection();
        try {
            em.find(Login.class, id);
        } catch (Exception e) {
            System.out.println("Erro de buscar login por id ==>> "+e.getMessage());
        } finally {
            em.close();
        }
        return l;
    }
    
    /**
     * 
     * metodo para listar todos os login
     * 
     *
     * @return lista de login  */
    public static ArrayList<Login> listarTodosLogin(){
        ArrayList<Login> l = new ArrayList<>();
        EntityManager em = ConnectionFactory.getConnection();
        try {
            l = (ArrayList<Login>) em.createQuery("from Login l").getResultList();
        } catch (Exception e) {
            System.out.println("Erro de listagem de todos os login ==>> "+e.getMessage());
        } finally {
            em.close();
        }
        return l;
    }
    
    /**
     * 
     * metodo para buscar login por email
     * 
     * @param email
     * @return 
     **/
    public static Login buscarLoginEmail(String email){
        Login l = new Login();
        EntityManager em = ConnectionFactory.getConnection();
        try {
            l =(Login) em.createQuery("select l from Login l where email = :email").setParameter("email", email).getSingleResult();
        } catch (Exception e) {
            System.out.println("Erro de buscar login por email ==>> "+e.getMessage());
            return null;
        } finally {
            em.close();
        }
        return l; 
    }
    
}

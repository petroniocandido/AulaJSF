/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tadsMeuPrimeiroJSF.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author petronio
 */
@Stateless
public class PessoaDAO extends DAOGenerico<Pessoa> {

    public PessoaDAO() {
        super(Pessoa.class);
    }
   
    
    @Override
    public List<Pessoa> Buscar(Pessoa obj) {
        String consulta = "select l from Pessoa l";
        if(obj != null){
            consulta = consulta + " where l.nome like '%" + obj.getNome() + "%'";
        }
        Query q = manager.createQuery(consulta);
        return q.getResultList();
    }
    
}

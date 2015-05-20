/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.MeuPrimeiroJSF.controllers;

import br.edu.ifnmg.tadsMeuPrimeiroJSF.model.Pessoa;
import br.edu.ifnmg.tadsMeuPrimeiroJSF.model.PessoaDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author petronio
 */
@Named(value = "pessoaController")
@SessionScoped
public class PessoaController implements Serializable{

    /**
     * Creates a new instance of PessoaController
     */
    
    @EJB
    PessoaDAO dao;
    
    private Pessoa entidade, filtro;
    
    private List<Pessoa> listagem;
    
    public PessoaController() {
        entidade = new Pessoa();
        filtro = new Pessoa();
    }
    
    public void filtrar(){
        listagem = dao.Buscar(filtro);
    }
    
    public String novo(){
        entidade = new Pessoa();
        return "editarPessoa.xhtml";
    }

    public Pessoa getEntidade() {
        return entidade;
    }

    public void setEntidade(Pessoa entidade) {
        this.entidade = entidade;
    }

    public Pessoa getFiltro() {
        return filtro;
    }

    public void setFiltro(Pessoa filtro) {
        this.filtro = filtro;
    }
    
    

    public List<Pessoa> getListagem() {
        if(listagem == null){
            listagem = dao.Buscar(null);
        }
        return listagem;
    }
    
    
    
    public void exibirMensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(msg));
    }
    
    public void salvar(){
        if(dao.Salvar(entidade)){
            exibirMensagem("Salvo com sucesso!");
            entidade = new Pessoa();
        } else {
            exibirMensagem("Falha!");
        }
        
    }
    
}

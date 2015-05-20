/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifnmg.tads.MeuPrimeiroJSF.controllers;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;



/**
 *
 * @author petronio
 */
@Named("testeController")
@SessionScoped
public class Teste implements Serializable {

    private int operandoA, operandoB, soma;
    
    private String valor;
    
    public void somar(){
        soma = operandoA + operandoB;
    }
    
    public Teste() {
        valor = "teste";
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getOperandoA() {
        return operandoA;
    }

    public void setOperandoA(int operandoA) {
        this.operandoA = operandoA;
    }

    public int getOperandoB() {
        return operandoB;
    }

    public void setOperandoB(int operandoB) {
        this.operandoB = operandoB;
    }

    public int getSoma() {
        return soma;
    }

    public void setSoma(int soma) {
        this.soma = soma;
    }
    
    
    
}

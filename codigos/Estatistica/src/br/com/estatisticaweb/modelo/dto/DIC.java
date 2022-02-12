/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estatisticaweb.modelo.dto;

/**
 *
 * @author aluno
 */
public class DIC {
    private Integer glTratamento;
    
    private Integer glResiduo;
    
    private Double SomaQuadradosTratamento;
    
    private String Tratamentos;

    
    public Integer getGlTratamento() {
        return glTratamento;
    }

    public void setGlTratamento(Integer glTratamento) {
        this.glTratamento = glTratamento;
    }

    public Integer getGlResiduo() {
        return glResiduo;
    }

    public void setGlResiduo(Integer glResiduo) {
        this.glResiduo = glResiduo;
    }
    
    public Double getSomaQuadradosTratamento(){
        return SomaQuadradosTratamento;
    }
    
    public void setSomaQuadradosTratamento(Double SomaQuadradosTratamento){
        this.SomaQuadradosTratamento = SomaQuadradosTratamento;
    }
    
}

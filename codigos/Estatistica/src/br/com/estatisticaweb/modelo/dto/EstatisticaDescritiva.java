package br.com.estatisticaweb.modelo.dto;

/**
 *
 * @author aluno
 */
public class EstatisticaDescritiva {
    private Double media;
    
    private Double moda;
    
    private Double mediana;
    
    private Double desvioPadrao;
    
    private Double variancia;    
    
    private Double curtose;
    
    private Double amplitude;
    
    private Double maior;
    
    private Double menor;
    

    public EstatisticaDescritiva() {
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Double getModa() {
        return moda;
    }

    public void setModa(Double moda) {
        this.moda = moda;
    }

    public Double getDesvioPadrao() {
        return desvioPadrao;
    }

    public void setDesvioPadrao(Double desvioPadrao) {
        this.desvioPadrao = desvioPadrao;
    }
    
    public Double getVariancia() {
        return variancia;
    }

    public void setVariancia(Double variancia) {
        this.variancia = variancia;
    }
    
    public Double getMediana() {
        return mediana;
    }

    public void setMediana(Double mediana) {
        this.mediana = mediana;
    }
    
    public Double getCurtose() {
        return curtose;
    }

    public void setCurtose(Double curtose) {
        this.curtose = curtose; 
    }
    
    public Double getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(Double amplitude) {
        this.amplitude = amplitude;
    }
    
    public Double getMaior() {
        return maior;
    }

    public void setMaior(Double maior) {
        this.maior = maior;
    }
    
    public Double getMenor() {
        return menor;
    }

    public void setMenor(Double menor) {
        this.menor = menor;
    }
}


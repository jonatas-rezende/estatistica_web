<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="./css/aleatorizacao.css" />
    
            <section class="box-learning">
                <div class="left">
                    <div class="box">
                        <font color="#0C61B3"><h3>Aleatorização</h3></font>
                        <table style="width:100%" >
                            <tr>
                              <td>K</td>
                              <td>P</td> 
                              <td>P</td>
                              <td>K</td>
                              <td>P</td> 
                              <td>K</td>
                            </tr>
                            <tr>
                              <td>K</td>
                              <td>K</td> 
                              <td>P</td>
                              <td>K</td>
                              <td>P</td> 
                              <td>P</td>
                            </tr>
                            <tr>
                              <td>P</td>
                              <td>K</td> 
                              <td>P</td>
                              <td>K</td>
                              <td>P</td> 
                              <td>P</td>
                            </tr>
                            <tr>
                              <td>P</td>
                              <td>K</td> 
                              <td>P</td>
                              <td>K</td>
                              <td>K</td> 
                              <td>P</td>
                            </tr>
                            <tr>
                              <td>P</td>
                              <td>K</td> 
                              <td>P</td>
                              <td>K</td>
                              <td>P</td> 
                              <td>K</td>
                            </tr>
                          </table>
                        
                        
                    </div>
                    
                </div>
                <div class="right">
                    <label for="data">Insira os resultados separados por ponto e vírgula</label>
                    <input type="text" name="data" id="data" value="20; 58; 85; 74; 14" placeholder="Ex: 20; 58; 85; 74; 14"><br><br>
                    <a href="#"><button class="btn">EXECUTAR</button></a>
                    RESULTADO
                    
                    <table style="width:100%">
                         
                        <tr>
                          <th>SS</th>
                          <th>Sf</th>
                          <th>df</th>
                        </tr>
                        <tr>
                          <td>Model</td>
                          <td>1248.65</td>
                          <td>7</td>
                          <td>5485.34</td>
                        </tr>
                        <tr>
                          <td>Residual</td>
                          <td>48.2544</td>
                          <td>874</td>
                          <td>5755</td>
                        </tr>
                        <tr>
                          <td>Total</td>
                          <td>574.578</td>
                          <td>847</td>
                          <td>1.577.44</td>
                        </tr>
                      </table>
                    
                    
                <form class="footer" action="">
                    <input type="text" name="data" id="data" placeholder="Digite o nome do projeto">
                    <button>Salvar Resultados</button>
                    <hr>
                    <span>Conte-nos como foi sua experiência com nosso sistema!</span>

                </form>
  
                </div>
            </section>
#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <math.h>

#define FALSE 0
#define TRUE 1

void aleatorizar();

int main(){
	char tratamentos[] = {'P', 'K', 'N'};
	int r = 10;
	int t = sizeof(tratamentos) / sizeof(char);
	int n = r * t;
	
	int v[n];
	int qtde[t];
	
	for (int i = 0; i < n; i++) v[i] = 0;
	for (int i = 0; i < t; i++) qtde[i] = 0;
	
	srand(time(NULL));
	
	for (int i = 0; i < n; i++){
		int permitido = FALSE;
		do {
			//Sorteia um número inteiro k entre 0 e t
			float kReal = (float) (rand()) / RAND_MAX;
			int k = round(kReal * (t - 1));
		
			if (qtde[k] < r){
				//Atribui v[i] o valor k
				v[i] = k;
				qtde[k]++;
				permitido = TRUE;
			}
		} while (!permitido);
	}
	
	int linhas, colunas;
	int encontrou = FALSE;
	int menorDiferenca = 100000;
	for (int i = 3; i < n; i++){
		for (int j = 3; j < n; j++){
			int produto = i * j;
			
			if (produto == n){
				encontrou = TRUE;
				int diferenca = abs(i - j);
				
				if (diferenca < menorDiferenca){
					linhas = i;
					colunas = j;
					menorDiferenca = diferenca;
				}
			}
		}
	}
	
	if (!encontrou){	
		linhas = sqrt(n);
		colunas = round( (float) (n) / linhas);
	}
	
	int menor = fmin(linhas, colunas);
	int maior = fmax(linhas, colunas);
	
	colunas = menor;
	linhas = maior;
	
	//Essa é a única parte que deve ir para o JSP
	int i = 0;
	for (int linha = 0; linha < linhas; linha++){
		for (int coluna = 0; coluna < colunas; coluna++){
			int k = v[i];
		
			printf(" %c ", tratamentos[k]);
			i++;
			
			if (i > n - 1) break;
		}
		printf("\n");
		if (i > n - 1) break;
	}
	printf("\n");

	return 0;
}

void aleatorizar(){
	
}

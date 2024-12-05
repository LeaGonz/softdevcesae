//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        Pretende-se uma aplicação que permita classificar cada um dos N alunos de uma disciplina com a seguinte estrutura de
avaliação:
Trabalho 1 – 20% da nota
Trabalho 2 - 20% da nota
Exame – 60 % da nota
Para cada aluno obter o seu nome e as notas de cada um dos elementos de avaliação (validadas entre 0 e 20), calculando
de seguida a nota final. A classificação deve ser indicada mediante a seguinte tabela:

Nota Comentário
De 0 a 4,9 Muito fraco
De 5 a 9,9 Fraco
De 10 a 12,9 Suficiente
De 13 a 16,9 Bom
De 17 a 20 Muito bom

Deve ser também indicada o valor da melhor e pior nota final bem como a percentagem de notas positivas em cada um
dos itens de avaliação (trabalho 1, trabalho 2 e exame) e as suas respetivas médias. Indicar ainda o total de alunos com
classificação “Muito Bom”.
A saída do programa (“output”) deve ser apresentada da seguinte forma:
Nome do aluno Classificação
João Bom
Luis Muito Bom
Manuel Fraco
… ….
*********************************************
MELHOR NOTA FINAL: 18 valores
PIOR NOTA FINAL: 2 valores
PERCENTAGENS DE NOTAS POSITIVAS:
Trabalho 1: 63%
Trabalho 2: 45%
Exame: 54%
PRÁTICA LABORATORIAL 02
PCE | Exercícios
PL02
_______________________________________________________________________________________________________________
Bruno Santos Página 2
Final: 51%
MÉDIAS DAS NOTAS:
Trabalho 1: 13,4 valores
Trabalho 2: 10,7 valores
Exame: 12,6 valores
6 alunos com classificação MUITO BOM
A aplicação deve conter um menu que permita:
1. Inserir, editar e eliminar alunos e notas (no formato numérico);
2. Imprimir os dados da turma (output acima – deve ser recalculado sempre que haja nova alteração);
3. Ler e gravar os dados em ficheiro
         */

        System.out.println("*** CESAE - Controlo de Notas ***");
        System.out.println("Menu Alunos:");
        System.out.println("1- Inserir     |     2- Editar     |     3- Eliminar");
        System.out.println("");
    }
}
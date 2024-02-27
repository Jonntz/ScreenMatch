package br.com.screenMatch.calc;

public class Recomends {

    public void filter(Classify classify){
        if(classify.getClassify() >= 4){
            System.out.println("Está entre os preferidos");
        } else if(classify.getClassify() >= 2){
            System.out.println("Muito bem avaliado");
        } else {
            System.out.println("Adicione na sua lista");
        }
    }
}

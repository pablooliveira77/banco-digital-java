package steps;

import io.cucumber.java.pt.*;

public class ExemploStepsCucumber {

    @Dado("que o sistema está inicializado")
    public void sistema_inicializado() {
        System.out.println("Sistema inicializado com sucesso.");
    }

    @Quando("eu realizo uma ação qualquer")
    public void realizo_acao_qualquer() {
        System.out.println("Ação realizada.");
    }

    @Então("o resultado esperado deve ser exibido")
    public void resultado_esperado() {
        System.out.println("Resultado validado com sucesso.");
    }
}


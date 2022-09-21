import java.util.Scanner;

public class Conta {
    public double numConta;
    protected String tipoConta;
    private String donoConta;
    private double saldoConta;
    private boolean statusConta;

    public Conta(){
        this.setSaldoConta(0);
        this.setStatusConta(false);
    }

    public void opcoes(){
        Scanner leitor = new Scanner(System.in);
        System.out.println("Seja bem-vindo ao banco CCN - Companhia Certificadora Nacional!!");
        System.out.println("Qual opção você de  seja? Escolha de acordo com o número ao lado");
        System.out.println("1 - Abrir conta");
        System.out.println("2 - Fechar conta");
        System.out.println("3 - Depositar ");
        System.out.println("4 - Sacar ");
        System.out.println("5 - Pagar mensalidade");

        int opc = leitor.nextInt();

        switch (opc){
            case 1:
                abrirConta();
                break;
            case 2:
                fecharConta();
                break;
            case 3:
                depositar();
                break;
            case 4:
                sacar();
                break;
            case 5:
                pagarMensalidade();
                break;
        }

    }

    public void mostrarConta(){
        System.out.println("-----------------");
        System.out.println("Número da conta:"+this.getNumConta());
        System.out.println("Tipo da conta:"+this.getTipoConta());
        System.out.println("Dono da conta:"+this.getDonoConta());
        System.out.println("Saldo da conta:"+this.getSaldoConta());
        if (isStatusConta()) {
            System.out.println("Status da conta: Ativo");
        }else{
            System.out.println("Status da conta: Inativa");
        }
    }

    public void voltarOuSair(){
        System.out.println("---------------------");
        Scanner leitor = new Scanner(System.in);
        System.out.println("Deseja voltar para a lista de opções? Digite S para Sim ou N para Não");
        String confirmacao = leitor.nextLine();
        if ("S".equals(confirmacao)) {
            opcoes();
        }else{
            System.out.println("Tchau! Volte sempre!");
            return;
        }
    }
    private void abrirConta() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("---------------------");
        System.out.println("1 - Abrir conta");
        System.out.println("Qual o seu nome completo?");
        String donoConta = leitor.nextLine();
        System.out.println("Qual o tipo de conta? Digite CC para Conta Corrente ou CP para Conta Poupança");
        String tipoConta = leitor.nextLine();
        System.out.println("Deseja confirmar a criação da conta? Digite S para Sim ou N para Não");
        String confirmacao = leitor.nextLine();

        if ("S".equals(confirmacao)) {
            this.setNumConta(Math.random());
            this.setDonoConta(donoConta);
            this.setTipoConta(tipoConta);
            if ("CC".equals(tipoConta)) {
                this.setSaldoConta(50);
            }else{
                this.setSaldoConta(120);
            }
            this.setStatusConta(true);
            System.out.println("Conta criada com sucesso!");
            System.out.println("Você ganhou um saldo inicial de acordo com o tipo de seu conta, veja abaixo:");
            mostrarConta();
        }else{
            System.out.println("Criação cancelada.");
        }

        voltarOuSair();
    }
    private void fecharConta() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Você deseja mesmo fechar a conta? Digite S para Sim ou  N para Não");
        String confirmacao = leitor.nextLine();
        if ("S".equals(confirmacao)){
            if (this.getSaldoConta() >= 0) {
                System.out.println("Não é possível fechar a sua conta pois existe um saldo presente, por favor, saque o valor abaixo para poder fechar a conta.");
            }else {
                this.setStatusConta(false);
                System.out.println("Conta fechada com sucesso!");
            }
        }
        voltarOuSair();
    }

    private void depositar() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Qual o valor que você deseja depositar?");
        double deposito = leitor.nextDouble();
        this.setSaldoConta(this.getSaldoConta()+deposito);
        System.out.println("Deposito feito com sucesso!");
        mostrarConta();
        voltarOuSair();

    }

    private void sacar() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Qual o valor do saque?");
        double saque = leitor.nextDouble();
        if (saque > this.getSaldoConta()) {
            System.out.println("O valor do saque é maior que o saldo na conta!");
        }else{
            this.setSaldoConta(this.getSaldoConta() - saque);
        }

        mostrarConta();
        voltarOuSair();
    }

    private void pagarMensalidade() {
        double valorMensalidade = 0;
        if ("CC".equals(this.getTipoConta())){
            valorMensalidade = 12;
        }else if ("CP".equals(this.getTipoConta())){
            valorMensalidade = 20;
        }
        this.setSaldoConta(this.getSaldoConta()-valorMensalidade);
        System.out.println("Mensalidade paga com sucesso!");
        mostrarConta();
        voltarOuSair();
    }

    public double getNumConta() {
        return numConta;
    }

    public void setNumConta(double numConta) {
        this.numConta = numConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getDonoConta() {
        return donoConta;
    }

    public void setDonoConta(String donoConta) {
        this.donoConta = donoConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public boolean isStatusConta() {
        return statusConta;
    }

    public void setStatusConta(boolean statusConta) {
        this.statusConta = statusConta;
    }
}

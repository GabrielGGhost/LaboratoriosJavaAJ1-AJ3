package lab12_asbtract_2;
/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 *  
 */
public class Conta implements Tributavel{

    protected double saldo;
    private String numero;
    private Cliente titular;
    private Agencia agencia;
    private double acumuladorIFN;    
    private static double taxaIFN = 0.038;    

    public Conta(double saldoInicial, String num, Cliente tit, Agencia ag) {
       	this.setSaldo(saldoInicial);
        this.setNumero(num);
        this.setTitular(tit);
        this.setAgencia(ag);
    }

    public Conta(String num, Cliente tit, Agencia ag) {
        this(0, num, tit, ag);
    }

    public void saque(double valor) {
        System.out.println("Realizando saque de R$ " + valor + " da conta " + numero);
        if (valor > 0) {
            if (this.getSaldo() >= valor) {
                this.setSaldo(this.getSaldo() - valor);
                acumularIFN(valor);
            } else
                System.out.println("Saldo insuficiente");
        } else {
            System.out.println("O valor de saque deve ser positivo");
        }
    }

    public void deposito(double valor) {
        System.out.println("Realizando deposito de R$" + valor + " da conta " + this.getNumero());
        if (valor >= 0) {
            this.setSaldo(this.getSaldo() + valor);
        } else
            System.out.println("O valor do deposito deve ser positivo");
    }

    public void imprimeDados() {
        System.out.println("======================================");
        agencia.imprimeDados();
        System.out.println("Numero da conta: " + this.getNumero());
        titular.imprimeDados();
        System.out.println("Saldo  : R$" + this.getSaldo());
        System.out.println("========================================");
    }

    public double getSaldo() {
        return this.saldo;
    }

    public Agencia getAgencia() {
        return this.agencia;
    }

    public String getNumero() {
        return this.numero;
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public static double getTaxaIFN() {
        return Conta.taxaIFN;
    }

    public double getAcumuladorIFN() {
		return this.acumuladorIFN;
	}

	public void setAcumuladorIFN(double acumuladorIFN) {
		this.acumuladorIFN = acumuladorIFN;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public static void setTaxaIFN(double taxaIFN) {
        Conta.taxaIFN = taxaIFN;
    }
    
    protected void acumularIFN(double valorSaque) {
        this.setAcumuladorIFN(this.getAcumuladorIFN() + Conta.taxaIFN * valorSaque);
    }

    public double getIFNAcumulado() {
        return this.acumuladorIFN;
    }

	@Override
	public String getDescricaoTributavel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNomeImposto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calcularImpostos() {
		// TODO Auto-generated method stub
		return 0;
	}    
}

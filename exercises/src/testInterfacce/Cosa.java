package testInterfacce;

public class Cosa implements Comparable<Cosa>{
	private int num;
	private String nome;

	public Cosa(int num, String nome) {
		super();
		this.num = num;
		this.nome = nome;
	}

	public int getNum() {
		return num;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Cosa [num=" + num + ", nome=" + nome + "]";
	}

	@Override
	public int compareTo(Cosa other) {
		int resut = this.num - other.num;
		if (resut != 0) {
			return resut;
		}
		return this.nome.compareTo(other.nome);
		
	}
	
}

import java.io.*;
import java.util.NoSuchElementException;

public class CalcRPN {
	// variaveis da instancia :
	// uma pilha para os c´alculos
	Pilha<Double> aPilha;
	
	CalcRPN () {
		aPilha = new Pilha<Double>();
	}
	
	void mais() {
		try {
			double soma = aPilha.desempilha() + aPilha.desempilha();
			aPilha.empilha(soma);
		} catch (NoSuchElementException e){
			throw new Error("A lista e invalida; erro: " + e.getMessage());
		}	
	}
	
	void menos() {
		try {
			double sub1 = aPilha.desempilha();
			double sub2 = aPilha.desempilha();
			
			aPilha.empilha(sub2 - sub1);
			
		} catch (NoSuchElementException e){
			throw new Error("A lista e invalida; erro: " + e.getMessage());
		}	
	}

	void vezes() {
		try {
			double mult = aPilha.desempilha() * aPilha.desempilha();
			aPilha.empilha(mult);
		} catch (NoSuchElementException e){
			throw new Error("A lista e invalida; erro: " + e.getMessage());
		}
	}

	void dividido() {
		try {
			double sub1 = aPilha.desempilha();
			double sub2 = aPilha.desempilha();
			
			aPilha.empilha(sub2/sub1);
			
		} catch (NoSuchElementException e){
			throw new Error("A lista e invalida; erro: " + e.getMessage());
		}
	}
	// retorna o conteudo do topo da pilha
	Double resultado() {
		return aPilha.topo();
	}
	// interpretador de comandos
	void exec(String cmd) {
	throw new Error("a ser completado");
	}
	
	static void test() {
		CalcRPN calc = new CalcRPN() ;
		System.out.print("3 2 + = ");
		calc.aPilha.empilha(3.0);
		calc.aPilha.empilha(2.0);
		calc.mais();
		System.out.println(calc.resultado());
		calc = new CalcRPN();
		System.out.print("3 2 - = ");
		calc.aPilha.empilha(3.0);
		calc.aPilha.empilha(2.0);
		calc.menos();
		System.out.println(calc.resultado());
		calc = new CalcRPN();
		System.out.print("3 2 * = ");
		calc.aPilha.empilha(3.0);
		calc.aPilha.empilha(2.0);
		calc.vezes();
		System.out.println(calc.resultado());
		calc = new CalcRPN();
		System.out.print("3 2 / = ");
		calc.aPilha.empilha(3.0);
		calc.aPilha.empilha(2.0);
		calc.dividido();
		System.out.println(calc.resultado());
		calc = new CalcRPN();
		System.out.print("1 2 + 3 4 - / 10 3 - * = ");
		calc.aPilha.empilha(1.0);
		calc.aPilha.empilha(2.0);
		calc.mais();
		calc.aPilha.empilha(3.0);
		calc.aPilha.empilha(4.0);
		calc.menos();
		calc.dividido();
		calc.aPilha.empilha(10.0);
		calc.aPilha.empilha(3.0);
		calc.menos();
		calc.vezes();
		System.out.println(calc.resultado());
		}
	
	public static void main(String[] args) {
		test();
	}

	}
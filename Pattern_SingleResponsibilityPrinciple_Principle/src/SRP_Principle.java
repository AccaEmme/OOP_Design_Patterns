/*
https://www.youtube.com/watch?v=pjIIlBsjALc

Un buon sistema software inizia da codice pulito, analogamente se i mattoni usati per la costruzione di un edificio sono scadenti, l'architettura dell'edificio non pu� fare molto per migliorare la qualit� dell'edificio.
Tuttavia � possibile fare "casini" anche con mattoni ben fatti se l'architettura non � un granch� ed � proprio qui che intervengono i principi SOLID.

I principi SOLID indicano come disporre le nostre funzioni e strutture nelle classi e come quest'ultime sono interconnesse tra loro.
Con l'obiettivo di creare strutture software:
 - tolleranti alle modifiche
 - facili da comprendere
 - fungano da basi di componenti riutilizzabili

I 5 principi SOLID sono:
 - Single Responsibility Principle
 - Open-Close Principle
 - Liskov Substitution Principle
 - Interface Segregation Principle
 - Dependency Inversion Principle

parlando di "Single Responsibility Principle" si dice spesso che il modulo debba fare una sola cosa soltanto, ma questa convinzione � errata
un modulo dovrebbe essere responsabile di uno e un solo attore
 - attore: si intendono utenti o committenti che possono volere cambiamenti del sistema
 - modulo: � solo un insieme coeso di funzioni e strutture, la coesione quando � ben fatta implica il principio SRP
 
 Anzich� mettere tutto nella stessa classe, applichiamo il Single Responsibility Principle
 PayCalculator non conoscer� HourReporter.
 Bisogna per� instanziare 3 nuove classi, che ci sta.
 
ma si potrebbe usare il "pattern Facade": istanzia le 3 classi fornendo all'esterno un unico oggetto, in questo modo l'istanziazione e la gestione sono centralizzate nella classe Facade e le altre classi rimarranno indipendenti.
*/

class PayCalculator{
	public String calcolatePay() {
		return "5";
	}
}

class HourReporter{
	public String reportHours(){
		return "4";
	}
}

class EmployeeSaver{
	private String employee;
	
	public void EmployeeSaver(String nome) {
		this.employee = nome;
	}
}

class EmployeeData{
	
}

package com.classe.Player;

public class Player {
	private long Id;
	private String Name;
	private int Exp;
	private int Offensive;
	private int Def;
	private int Skill;
	private int Vitality;
	private int Age;
	
	public Player(long id, String name,int exp,int offensive,int def,int skill,int vitality, int age, long team){
		this.Id = id;
		this.Name = name;
		this.Offensive = offensive;
		this.Exp = exp;
		this.Def = def;
		this.Skill = skill;
		this.Vitality = vitality;
		this.Age = age;		
	}
	
	public Player(){
		setRandomNom();
		this.Offensive = 20;
		this.Exp = 20;
		this.Def = 20;
		this.Skill = 20;
		this.Vitality = 20;
		this.Age = 20;
	}
	
	public Player(long _Team) {
		this();
	}
	
	public long getId() {
		return Id;
	}
	
	public void setId(long id) {
		Id = id;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	public void setRandomNom() {
		String randomNom = "";
		NameGenerator nameGenerator = new NameGenerator();
		randomNom = nameGenerator.getName();
		this.Name =  randomNom;
	}
	
	
	public int getVitality() {
		return Vitality;
	}
	
	public void setVitality(int vitality) {
		this.Vitality = vitality;
	}
	
	public int getSkill() {
		return Skill;
	}
	
	public void setSkill(int skill) {
		this.Skill = skill;
	}
	
	public int getDef() {
		return Def;
	}
	
	public void setDef(int def) {
		this.Def = def;
	}
	
	public int getOffensive() {
		return Offensive;
	}
	
	public void setOffensive(int offensive) {
		this.Offensive = offensive;
	}

	public int getExp() {
		return Exp;
	}

	public void setExp(int exp) {
		Exp = exp;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		this.Age = age;
	}	
}

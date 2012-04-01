package com.classe.Player;

public class Player {
	private int Id;
	private String Name;
	private int Exp;
	private int Offensive;
	private int Def;
	private int Skill;
	private int Vitality;
	private int Age;
	private String Team;
	
	public Player(int id, String name,int exp,int offensive,int def,int skill,int vitality, int age, String team){
		this.Id = id;
		this.Name = name;
		this.Offensive = offensive;
		this.Exp = exp;
		this.Def = def;
		this.Skill = skill;
		this.Vitality = vitality;
		this.Age = age;
		this.Team = team;
		
	}
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public void setNAme(String name) {
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

	public String getTeam() {
		return Team;
	}

	public void setTeam(String team) {
		Team = team;
	}
	
}

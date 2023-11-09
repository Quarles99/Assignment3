package com.example.poketracker;

public class PokeData {
    private int nationalNumber;
    private String name;
    private String species;
    private Float height;
    private Float weight;
    private int hp;
    private int attack;
    private int defense;

    public PokeData(int nationalNumber, String name, String species, Float height, Float weight, int hp, int attack, int defense) {
        this.nationalNumber = nationalNumber;
        this.name = name;
        this.species = species;
        this.height = height;
        this.weight = weight;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        name = name;
    }

    public int getNumber() {
        return nationalNumber;
    }

    public void setNumber(int number){
        nationalNumber = number;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}

package ru.sbertech.javaschoolrnd.d1zab;


class DomesticCat extends Cat {
    private String activities;

    public DomesticCat(String name, int age, String activities) {
        super(name, age);
        this.activities = activities;
    }

    public String getProfession() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

}
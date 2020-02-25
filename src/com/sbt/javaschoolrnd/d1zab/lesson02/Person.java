package com.sbt.javaschoolrnd.d1zab.lesson02;


// final - Constant variables cannot be used in a program
// for subsequent assignment and comparison.
// Therefore, we use fields without final.

public class Person {
    private boolean man;
    private String name;
    private Person spouse;


    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean checksGender (Person myPerson){
        if (this.man != myPerson.man){
            // genders are not equal
            System.out.println("Genders of " + this.name + " and " + myPerson.name +
                    " are not equal. Try to Marry them!");
            return true;
        }
        else {
            System.out.println("Sorry, the gender of " + this.name + " and " + myPerson.name + " is the same.");
            System.out.println("Sorry, can't marry. We are in Russia.\n");
            return false;
        }
    }


    public boolean marry(Person myPerson){
        if (this.spouse == myPerson){
            System.out.println("Already Married!");
        }

        // We check the gender of current candidates and
        // whether they are husband and wife.
        else if (this.checksGender(myPerson) == true & this.spouse != myPerson){

            // Next is checking current spouses
            if (this.spouse == null & myPerson.spouse == null) {
                this.spouse = myPerson;
                myPerson.spouse = this;
                System.out.println(this.name + " and " + myPerson.name + " are married now!\n");
                System.out.println(this.name + " and " + myPerson.name + "'s statuses has been changed!\n");
                // this and person's status has been changed
                return true;
            }

            else if (this.spouse == null & myPerson.spouse != null) {
                // myPerson is married - Divorce him/her!

                myPerson.divorce (myPerson.spouse);

                this.spouse = myPerson;
                myPerson.spouse = this;

                System.out.println(this.name + " and " + myPerson.name + " are married now!\n");
                System.out.println(this.name + "'s statuses has been changed!\n");

                // this status has been changed
                return true;
            }

            else if (this.spouse != null & myPerson.spouse == null) {
                // thisPerson is married - Divorce him/her!

                this.divorce (this.spouse);

                this.spouse = myPerson;
                myPerson.spouse = this;

                System.out.println(this.name + " and " + myPerson.name + " are married now!\n");
                System.out.println(myPerson.name + "'s statuses has been changed!\n");

                // person's status has been changed
                return true;
            }

            else {
                // Both are married - Divorce them ALL!!!
                myPerson.divorce (myPerson.spouse);
                this.divorce (this.spouse);

                this.spouse = myPerson;
                myPerson.spouse = this;
                System.out.println(this.name + " and " + myPerson.name + " are married now!\n");


                return false;
            }
        }


        return false;
    }

    public void divorce(Person myPerson){

            this.spouse = null;
            myPerson.spouse = null;

            System.out.println(this.name + " and " + myPerson.name + " are divorced now...");
    }



    public String seeStats(){
        if (this.spouse == null){
            return "Name = " + this.name + "\t\t Gender = " + this.man +
                    "\t\t Spouse = not married";
        }
        else
        return "Name = " + this.name + "\t\t Gender = " + this.man +
                "\t\t Spouse = " + this.spouse.name;
    }
}
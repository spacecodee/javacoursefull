package com.spacecodee.javabasic;

public class SentenciasControl {
    /*
     * if() => si();
     * else() => casoContrario();
     * switch() => ifElse();
     * operador ternario | ternary operator
     * */

    static int agePerson1 = 16;
    static int agePerson2 = 17;
    static int agePerson3 = 25;
    static int agePerson4 = 18;
    static int numberOlderThan = 18;
    static String olderThan = "mayor a " + numberOlderThan;

    public static void validatePeopleOlderThan18() {
        if (SentenciasControl.agePerson1 > SentenciasControl.numberOlderThan) {
            System.out.println(SentenciasControl.olderThan + " - " + SentenciasControl.agePerson1);
        }
        else if (SentenciasControl.agePerson2 > SentenciasControl.numberOlderThan) {
            System.out.println(SentenciasControl.olderThan + " - " + SentenciasControl.agePerson2);
        }
        else if (SentenciasControl.agePerson3 > SentenciasControl.numberOlderThan) {
            System.out.println(SentenciasControl.olderThan + " - " + SentenciasControl.agePerson3);
        }
        else if (SentenciasControl.agePerson4 > SentenciasControl.numberOlderThan) {
            System.out.println(SentenciasControl.olderThan + " - " + SentenciasControl.agePerson4);
        }
        else {
            System.out.println("Menor");
        }
    }

    public static void validatePeopleOlderThan18WhitSwitch() {
        switch (SentenciasControl.agePerson3) {
            case 16 : System.out.println(SentenciasControl.olderThan + " - | " + SentenciasControl.agePerson1);break;
            case 17 : System.out.println(SentenciasControl.olderThan + " - | - " + SentenciasControl.agePerson2);break;
            case 25 : System.out.println(SentenciasControl.olderThan + " - | - | " + SentenciasControl.agePerson3);break;
            case 19 : System.out.println(SentenciasControl.olderThan + " - | - | " + SentenciasControl.agePerson4);break;
            default : System.out.println(SentenciasControl.olderThan + " - " + SentenciasControl.agePerson1);break;
        }
    }

    public static void ternaryOperator() {
        var validateOlder = SentenciasControl.agePerson3 > 18 ? true : "Es mayor a 18";
        System.out.println("validateOlder = " + validateOlder);
    }

    public static void main(String[] args) {
        //SentenciasControl.validatePeopleOlderThan18();
        //SentenciasControl.validatePeopleOlderThan18WhitSwitch();
        SentenciasControl.ternaryOperator();
    }
}

import java.util.Hashtable;

public class Rotor {
    char[] setup;
    char[] reverse;
    int notch;

    public Rotor(char[] letters, char[] reverse, int turn)  //constructor

    {
        this.setup=letters;
        this.reverse=reverse;
        this.notch=turn;
    }

    public Rotor[] chooseRotors(Rotor rotor1, Rotor rotor2, Rotor rotor3)  //setting an array of the rotors user chooses to use
    {
        Rotor[] chosenRotors = new Rotor[3];
        chosenRotors[0]=rotor1;
        chosenRotors[1]=rotor2;
        chosenRotors[2]=rotor3;
        return chosenRotors;
    }
}

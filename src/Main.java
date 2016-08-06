import java.util.Hashtable;

public class Main {
    //Initialization, rotor settings and hashtable for plugboard (one isn't wired here but can be inputted easily)
    static char[] first = {'B','D','F','H','J','L','C','P','R','T','X','V','Z','N','Y','E','I','W','G','A','K','M','U','S','Q','O'};
    static char[] second = {'A','J','D','K','S','I','R','U','X','B','L','H','W','T','M','C','Q','G','Z','N','P','Y','F','V','O','E'};
    static char[] third = {'E','K','M','F','L','G','D','Q','V','Z','N','T','O','W','Y','H','X','U','S','P','A','I','B','R','C','J'};
    static char[] refl = {'Y','R','U','H','Q','S','L','D','P','X','N','G','O','K','M','I','E','B','F','Z','C','W','V','J','A','T'};
    static char[] alph = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    static Hashtable<Character, Character> hash = new Hashtable<>(); //set plugboard values
    static Rotor[] setup = new Rotor[3];

    public static void main(String[] args) {

        //initializing main and setting up rotors, plugboard, and reflector
        Main enigma = new Main();
        Rotor rotor1 = new Rotor(first, alph, 5);
        Rotor rotor2 = new Rotor(second, alph, 1);
        Rotor rotor3 = new Rotor(third, alph, 1);

        setup = rotor1.chooseRotors(rotor1, rotor2, rotor3);
        Plugboard p = new Plugboard(hash);
        Reflector r = new Reflector(refl);

        //creates an alphabet hashtable I use for the encryption
        enigma.setAlphabet();

        //test commands: encrypt takes text, rotor array, plugboard and reflector. decrypt takes same plus rotor settings
        System.out.println(enigma.encrypt("hola",setup, p, r));
        System.out.println(enigma.decrypt("shas", setup, 5, 1, 1, p ,r));

    }


    public String encrypt(String a,Rotor[] r, Plugboard p, Reflector rfl)
    {
        //initialization

        char[] text=a.toUpperCase().toCharArray();
        int counter=0;
        int count;
        String result="";

        //moves rotor forward
        for(int i=0;i<a.length();i++) {


            if(r[0].notch%26==0)
            {
                if(r[1].notch%26==0)
                {
                    r[2].notch++;
                }
                r[1].notch++;
            }
            r[0].notch++;

            //checks the plugboard for any wiring for current character
            char temp = text[counter];
            if (p.ht.contains(temp)) {
                temp = p.ht.get(temp);
            }

            //Rotor commands: Gets the alphabetical order of current character, reduces it by the notch, and finds that number character
            //in the rotor's char array
            temp = r[0].setup[Math.floorMod((ht.get(temp) - Math.floorMod(r[0].notch-2,26)), 25)];
            System.out.print(temp+", ");

            //rotor 2
            temp = r[1].setup[Math.floorMod((ht.get(temp) - Math.floorMod(r[1].notch-1,26)), 25)];
            System.out.print(temp+", ");

            //rotor 3
            temp = r[2].setup[Math.floorMod((ht.get(temp) - Math.floorMod(r[2].notch-1,26)), 25)];
            System.out.print(temp+", ");

            //Reflector: same as rotors but without notch
            temp = rfl.setup[ht.get(temp)];
            System.out.print(temp+", ");

            //While loop sees what number in the rotor array the current char is, then gets the character of that order in the alphabet
            //(Reverse rotor 3)
            count=0;
            while(r[2].setup[count]!=temp){
                count++;
            }
            temp = r[2].reverse[(count+ ((r[2].notch-1) % 26)) % 25] ;
            System.out.print(temp+", ");

            //Reverse rotor 2
            count=0;
            while(r[1].setup[count]!=temp){
                count++;
            }
            temp = r[1].reverse[(count+ ((r[1].notch-1) % 26)) % 25] ;
            System.out.print(temp);

            //Reverse rotor 1
            count=0;
            while(r[0].setup[count]!=temp){
                count++;
            }
            temp = r[0].reverse[(count+ ((r[0].notch-2) % 26) )% 25] ;
            System.out.println(": "+temp);

            //Last step: plugboard once more
            if (p.ht.contains(temp)) {
                temp = p.ht.get(temp);
            }
            result+=temp;
            counter++;
        }

        return result;
    }

    //Decrypt sets the rotor notches at specified settings then runs encrypt
    public String decrypt(String a, Rotor[] r, int x, int y, int z, Plugboard p, Reflector rfl)
    {
        r[0].notch=x;
        r[1].notch=y;
        r[2].notch=z;

        return encrypt(a, r, p, rfl);
    }

    //alphabet hashtable used for encrypting
    Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
    //Gives each letter in the alphabet its numerical order to use in encryption above
    public void setAlphabet(){
        ht.put('A',0);
        ht.put('B',1);
        ht.put('C',2);
        ht.put('D',3);
        ht.put('E',4);
        ht.put('F',5);
        ht.put('G',6);
        ht.put('H',7);
        ht.put('I',8);
        ht.put('J',9);
        ht.put('K',10);
        ht.put('L',11);
        ht.put('M',12);
        ht.put('N',13);
        ht.put('O',14);
        ht.put('P',15);
        ht.put('Q',16);
        ht.put('R',17);
        ht.put('S',18);
        ht.put('T',19);
        ht.put('U',20);
        ht.put('V',21);
        ht.put('W',22);
        ht.put('X',23);
        ht.put('Y',24);
        ht.put('Z',25);
    }
    }







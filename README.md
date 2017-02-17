# Enigma-Java
Virtual Java version of enigma machine (WWII Nazi encryption device)

Enigma was a Nazi encryption device used in WWII that was deemed impossible to crack due to its rotor functionality,
making two consecutive identical letters encrypt differently (ie encrypting AA could give BH). 

Setup Input:
Rotors: The rotors Rotor1, Rotor2 and Rotor3 must be initialized with choice of rotor, alph hashmap, and number depicting
        initial rotor placement (1-25). 
        The rotor array setup[] must then be set up with these choices using the function chooseRotors (which should be
        called through rotor1 as it exists in the Rotor class.     
Reflector: For choice of reflector values simply edit the refl char[] array. 
Plugboard: For plugboard settings, hashmap is initialized, simply use p.put(letter1, letter2) where letters 1 and 2 are the
           characters you wish to link.
           
Input:
Encryption: Call function encrypt() with parameters String a=message to decrypt, Rotor[]=setup[] array, p and r = 
            user-chosen plugboard and reflector (set as p and r). 
Decryption: Call function decrypt() with exact same parameters as given to encrypt when encrypted (must be the same to decrypt)
            as well as ints x, y and z which are the rotor notch settings for rotors 1, 2 and 3, respectively. 
  

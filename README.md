Credit card forgery has been on the rise lately. Luckily, there are many ways to determine if a credit card is a fake. Given a list of credit card numbers and their associated issuing networks, for each credit card determine if it is valid or not by validating its issuer identification number (IIN), length, and check sum by applying the Luhn algorithm.

Use this for reference. While the article states that Maestro IINs can start with 6, since IINs are unique, Maestro IINs can't coincide with the IINs of the other issuers given in the Input description below.

Example

For

listOfNumbers = [["Visa","400007-9927-39-8715"], 
                 ["Visa","5000 0000 1234 5678"], 
                 ["Visa","40002847193819287"]]
the output should be
validate(listOfNumbers) = [true, false, false].

The first card number is "400007-9927-39-8715" and it is issued by "Visa". This card has a valid IIN, a valid length, and a valid checksum, in spite of the hyphen placement. This card is valid.

The second card number is "5000 0000 1234 5673" and is also issued by "Visa". This card does not have a valid IIN for Visa, so this card is not valid.

The third card number is "40002847193819289" and it is also issued by "Visa". This card number is too long to be a valid Visa number, so this card is not valid.

Therefore, the final answer is [true, false, false].

For

listOfNumbers = [["Totally Legit Bank","1234-5678-9010-1110"], 
                 ["Discover Card","622126-103952-1904"]]
the output should be
validate(listOfNumbers) = [false, false].

The first card number is "1234-5678-9010-1110" and it is issued by "Totally Legit Bank". Totally Legit Bank is not a valid bank name, therefore this card is not valid.

The second card number is "6221-2610-3952-1904" and is issued by "Discover Card". This card's checksum should be 9 instead of 4, so this card is not valid.

Therefore, the final output should be [false, false].

Input/Output

[time limit] 3000ms (java)
[input] array.array.string listOfNumbers

A 2D array, where each array represents a card in the format [<card_issuer>, <card_number>].

The following issuing networks are considered to be valid: Visa, MasterCard, Maestro, JCB, Discover Card, American Express, Laser, and InterPayment.

Payment card numbers are composed only of numbers, spaces, and/or hyphens.

Constraints:
1 ≤ listOfNumbers.length ≤ 100,
listOfNumbers[i].length = 2,
1 ≤ listOfNumbers[i][j].length ≤ 25.

[output] array.boolean

A list of booleans, where the ith element of the list is true if the ith card is valid and false otherwise.

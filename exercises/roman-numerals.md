# Roman numerals

Any natural number between 0 and 3999 can be represented in *roman numerals* using the following rules:

1. Only symbols *M*, *D*, *C*, *X*, *V*, *I* can be used. Their values are shown below:

    |   M  |  D  |  C  | L  |  X | V | I |
    |------|-----|-----|----|----|---|---|
    | 1000 | 500 | 100 | 50 | 10 | 5 | 1 |

2. Symbols M, C, X, I can be repeated consecutively up to three times.
3. Symbols D, L and V can not be repeated.
4. When a symbol of lower value of appears to the right of a symbol of equal or higher value, all symbol values are added.
5. When a symbols of lower value appears to the left of a symbols of higher value, the lower value is subtracted from the higher value. Only symbols C, X, V can be subtracted. Each symbol can be subtracted only once. The subtracted symbol must be one fifth or one tenth of the larger.

*Examples:*

-    1 = I
-    4 = IV
-    8 = VIII
-    9 = IX
-   14 = XIV
-   16 = XVI
-   19 = XIX
-   99 = XCIX
-  105 = CV
- 1001 = MI
- 2289 = MMCCLXXXIX

Implement the following methods in the `RomanNumeralUtils` class:

```java
class RomanNumeralUtils {

    public static boolean isValidRomanNumeral(String value) { ... }

    public static int parseRomanNumeral(String numeral) { ... }

    public static String toRomanNumeral(int number) { ... }

}
```

Use [jqwik](https://jqwik.net/) to create property based tests verifying these three methods. Create the tests before implementing the methods. Document any bugs you found with the help of these tests during the process.

**NOTE:** 
- Do not use any existing implementation, write your own code. 
- Use the provided project template as a starting point.
- In the project you can launch the tests with `mvn test`.

## Answer
## Basic structure 
#### Class `RomanNumeralUtils`

- `isValidRomanNumeral`: checks for valid combinations of Roman numeral characters.
- `parseRomanNumeral`: converts a Roman numeral string to its corresponding integer value.
- `toRomanNumeral`: converts an integer to its Roman numeral representation.

#### Test class `RomanNumeralUtilsTest`

- isValidTrueForValidNumerals: Tests if the isValidRomanNumeral method returns true for valid Roman numerals.
- isValidFalseForInvalidNumerals: Tests if the isValidRomanNumeral method returns false for invalid Roman numerals.
- parseInverseOfRomanNumeral: Tests if parsing a Roman numeral and converting it back results in the same numeral.

## Step-by-step implementation

#### 1. Property-based tests with jqwik
For each method, the properties that the method must satisfy should be defined and various test cases based on these properties should be implemented in `RomanNumeralTest`.

#### 2. Methods implementation
Methods in `RomanNumeralUtils` should be implemented based on the rules provided for Roman numerals.

## Results 
Upon thorough testing using property-based testing with `jqwik`, all the tests for the `RomanNumeralUtils` class have passed successfully.

![roman](images/roman.jpg)